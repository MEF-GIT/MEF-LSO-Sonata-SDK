package com.orange.onapbss.resources.productorder;

import com.fasterxml.jackson.databind.JsonNode;
import com.orange.onapbss.converter.JsonEntityConverter;
import com.orange.onapbss.datamodel.productordering.OrderItemEntity;
import com.orange.onapbss.datamodel.productordering.ProductOrderEntity;
import com.orange.onapbss.datamodel.productordering.StateTypeEntity;
import com.orange.soa.commons.dao.Dao;
import com.orange.soa.commons.service.ServiceBase;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManagerFactory;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service("productOrderService")
@EnableScheduling
public class ProductOrderServiceImpl extends ServiceBase<ProductOrderEntity> implements ProductOrderService {

    private static final org.slf4j.Logger LOGGER = LoggerFactory
            .getLogger(ProductOrderServiceImpl.class);

    @Autowired
    private Dao<ProductOrderEntity> productOrderDao;

    @Override
    public String getId(ProductOrderEntity resource) {
        return resource.getId();
    }

    @Override
    protected Dao<ProductOrderEntity> getDao() {
        return this.productOrderDao;
    }

    @Override
    public void setId(ProductOrderEntity resource) {
        resource.setId(UUID.randomUUID().toString());
    }

    @Autowired
    private JsonEntityConverter jsonEntityConverter;

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    public ProductOrderEntity manageProductOrderStatus(ProductOrderEntity productOrder, JSONObject serviceOrder) {
        JSONArray orderItems = (JSONArray) serviceOrder.get("orderItem");
        boolean existOrderItemFailed = false;
        boolean existOrderItemCompleted = false;
        int orderItemCompleted = 0;
        for (Object o : orderItems) {
            JSONObject orderItem = (JSONObject) o;

            JSONObject serviceSpecification = (JSONObject)orderItem.get("serviceSpecification");
            String serviceOrderItemId = (String)serviceSpecification.get("id");
            if(orderItem.get("state")!=null){
                StateTypeEntity orderItemState = StateTypeEntity.fromValue(orderItem.get("state").toString());

                OrderItemEntity orderItemById = getOrderItemById(productOrder, serviceOrderItemId);

                if(orderItemById!=null)
                {
                    orderItemById.setStateValue(orderItemState);

                    if (orderItemState == StateTypeEntity.FAILED) {
                        existOrderItemFailed = true;
                    } else if (orderItemState == StateTypeEntity.COMPLETED) {
                        existOrderItemCompleted = true;
                        orderItemCompleted++;
                    }
                }

            }

        }
        updateProductOrderStatus(productOrder, orderItems, existOrderItemFailed, existOrderItemCompleted, orderItemCompleted);

        this.update(productOrder);
        return productOrder;
    }

    private void updateProductOrderStatus(ProductOrderEntity productOrder, JSONArray orderItems, boolean existOrderItemFailed, boolean existOrderItemCompleted, int orderItemCompleted) {
        if (existOrderItemFailed) {
            productOrder.setStateValue(StateTypeEntity.FAILED);
        } else if (existOrderItemCompleted && orderItemCompleted < orderItems.size()) {
            productOrder.setStateValue(StateTypeEntity.PARTIAL);
        } else if (orderItemCompleted == orderItems.size()) {
            productOrder.setStateValue(StateTypeEntity.COMPLETED);
            productOrder.setCompletionDate(new Date());
        }
    }

    @Override
    public void updateProductOrderStatus(ProductOrderEntity productOrder, StateTypeEntity productOrderState,StateTypeEntity productOrderItemState) {
        productOrder.setStateValue(productOrderState);
        for (OrderItemEntity orderItemEntity : productOrder.getOrderItem()) {
            orderItemEntity.setStateValue(productOrderItemState);
        }
    }


    @Scheduled(fixedDelay = 180000)
    public void scheduleUpdateProductOrderManually() {
        SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
        Session session = sessionFactory.openSession();

        List<ProductOrderEntity> productOrderEntityNotCompleted = getProductOrderEntityNotCompleted(session);
        LOGGER.info("number of update product order"+productOrderEntityNotCompleted.size());

        for (ProductOrderEntity notCompletedProductOrder : productOrderEntityNotCompleted) {
            LOGGER.info("update product order"+notCompletedProductOrder.getId());
            updateProductOrderStatus(notCompletedProductOrder, StateTypeEntity.COMPLETED,StateTypeEntity.COMPLETED);
            notCompletedProductOrder.setCompletionDate(new Date());
            update(notCompletedProductOrder);
        }
        session.close();

    }

    private List<ProductOrderEntity> getProductOrderEntityNotCompleted(Session session) {

        org.hibernate.Query query = session.createQuery("from ProductOrderEntity where (state is null or state != 'completed') ");
        List<ProductOrderEntity> notCompletedProductOrders = query.list();
        return notCompletedProductOrders;
    }


    private OrderItemEntity getOrderItemById(ProductOrderEntity productOrderEntity, String serviceOrderItemId) {
        for (OrderItemEntity orderItemEntity : productOrderEntity.getOrderItem()) {
            String product = orderItemEntity.getProduct();
            JsonNode productNode = jsonEntityConverter.convertStringToJson(product);
            String productOrderItemId = productNode.get("productSpecification").get("id").textValue();
            if (isProductOrderIdMatchingWithServiceOrderId(productOrderItemId,serviceOrderItemId)) {
                return orderItemEntity;
            }
        }
        return null;
    }

    private boolean isProductOrderIdMatchingWithServiceOrderId(String productOrderItemId,String serviceOrderItemId){
        if(productOrderItemId.startsWith("UNISpec"))
        {
            return "UNI_ServiceSpec".equalsIgnoreCase(serviceOrderItemId);
        }
        if(productOrderItemId.startsWith("eLine"))
        {
            return "eLine_ServiceSpec".equalsIgnoreCase(serviceOrderItemId);
        }
        if(productOrderItemId.startsWith("UNICE"))
        {
            return "UNICEEndPoint_ServiceSpec".equalsIgnoreCase(serviceOrderItemId);
        }
        if(productOrderItemId.startsWith("ENNICE"))
        {
            return "ENNICEEndPoint_ServiceSpec".equalsIgnoreCase(serviceOrderItemId);
        }
        return false;
    }

}
