package com.orange.onapbss.converter;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.orange.onapbss.datamodel.productofferingq.ProductOfferingQualificationEntity;
import com.orange.onapbss.datamodel.productordering.OrderItemEntity;
import com.orange.onapbss.datamodel.productordering.ProductOrderEntity;
import com.orange.onapbss.exception.Technical;
import com.orange.onapbss.exception.TechnicalException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Service
public class JsonEntityConverter {

    private static final ObjectMapper mapper = new ObjectMapper();

    private static final Logger LOGGER = LoggerFactory
            .getLogger(JsonEntityConverter.class);


    public JsonEntityConverter() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        mapper.setDateFormat(df);
    }

    public void addProductJsonToOrderItemEntity(ProductOrderEntity productOrder, JsonNode orderItemJson) {
        JsonNode productJson = orderItemJson.path("product");
        for (OrderItemEntity orderItemEntity : productOrder.getOrderItem()) {
            if (orderItemEntity.getId().equals(orderItemJson.path("id").textValue())) {
                orderItemEntity.setProduct(productJson.toString());
            }
        }
    }


    public ProductOfferingQualificationEntity convertJsonToProductOfferingQualificationEntity(JsonNode resource) {

        try {
            ObjectMapper mapper = new ObjectMapper();
            ProductOfferingQualificationEntity productOfferingQualificationEntity = mapper.treeToValue(resource, ProductOfferingQualificationEntity.class);
            return productOfferingQualificationEntity;
        } catch (JsonProcessingException e) {
            LOGGER.warn("Unable to convert productOfferingQualificationEntity to entity " + resource, e);
            throw new TechnicalException(Technical.GENERIC,
                    "Unable to convert productOfferingQualificationEntity to entity " + resource);
        }
    }


    public ProductOrderEntity convertJsonToProductOrderEntity(JsonNode resource) {

        try {
            ProductOrderEntity productOrder = mapper.treeToValue(resource, ProductOrderEntity.class);

            JsonNode ordersJson = resource.path("orderItem");
            if (ordersJson != null && ordersJson.isArray()) {
                for (JsonNode orderItemJson : ordersJson) {
                    addProductJsonToOrderItemEntity(productOrder, orderItemJson);
                }
            }
            return productOrder;
        } catch (JsonProcessingException e) {
            LOGGER.warn("Unable to convert productorderJson to entity " + resource, e);
            throw new TechnicalException(Technical.GENERIC,
                    "Unable to convert productorderJson to entity " + resource);
        }
    }

    public JsonNode convertStringToJson(String o) {
        JsonNode jsonNode = null;
        try {
            jsonNode = mapper.readTree(o);
        } catch (IOException e) {
            LOGGER.warn("Unable to convert "+o+" to json ");

        }
        return jsonNode;
    }


    public JsonNode convertProductOrderEntityToJson(ProductOrderEntity productOrder) {
        JsonNode productOrderJson = mapper.valueToTree(productOrder);
        JsonNode ordersJson = productOrderJson.path("orderItem");

        for (OrderItemEntity orderItemEntity : productOrder.getOrderItem()) {
            if (ordersJson != null && ordersJson.isArray()) {
                addProductToJson(ordersJson, orderItemEntity);
            }
        }
        return ((ObjectNode) productOrderJson).set("orderItem", ordersJson);
    }


    private void addProductToJson(JsonNode ordersJson, OrderItemEntity orderItemEntity) {
        for (JsonNode orderItemNode : ordersJson) {
            if (orderItemEntity.getId().equals(orderItemNode.path("id").textValue())) {
                try {
                    JsonNode productNode = mapper.readTree(orderItemEntity.getProduct());
                    ObjectNode node = (ObjectNode) orderItemNode;
                    node.set("product", productNode);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
