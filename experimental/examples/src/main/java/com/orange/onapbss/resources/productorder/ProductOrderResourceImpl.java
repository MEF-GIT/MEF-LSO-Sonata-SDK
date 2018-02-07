package com.orange.onapbss.resources.productorder;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.orange.onapbss.converter.JsonEntityConverter;
import com.orange.onapbss.converter.serviceorder.ServiceOrderRequestGenerator;
import com.orange.onapbss.datamodel.productordering.ProductOrderEntity;
import com.orange.onapbss.datamodel.productordering.StateTypeEntity;
import com.orange.onapbss.datamodel.productordering.ZErrorEntity;
import com.orange.onapbss.serviceorder.ServiceOrderProcessor;
import com.orange.onapbss.serviceproductmapping.ServiceOrderProductOrderService;
import com.orange.soa.commons.json.Jackson;
import com.orange.soa.commons.json.JsonRepresentation;
import com.orange.soa.commons.resource.ResourceBase;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Path("productOrder")
@Component("productOrderResource")
@RestController
public class ProductOrderResourceImpl extends ResourceBase<ProductOrderEntity> implements ProductOrderResource {

    @Autowired
    private ProductOrderService productOrderService;


    @Autowired
    private ProductOrderValidationService productOrderValidationService;

    @Override
    protected ProductOrderService getService() {
        return this.productOrderService;
    }

    @Autowired
    private ServiceOrderRequestGenerator serviceOrderRequestGenerator;

    @Autowired
    private JsonEntityConverter jsonEntityConverter;

    @Autowired
    private ServiceOrderProductOrderService serviceOrderProductOrderService;

    @Autowired
    private ServiceOrderProcessor serviceOrderProcessor;

    private static final Logger LOGGER = LoggerFactory
            .getLogger(ProductOrderResourceImpl.class);


    @GET
    @Path("{productOrderId}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response get(final @Context UriInfo uriInfo,
                        final @PathParam("productOrderId") String productOrderId) {

        ProductOrderEntity productOrder = productOrderService.get(productOrderId);

        JsonNode productOrderJson = callServiceOrderAndManageProductOrder(productOrder);

        return Response.status(200).entity(productOrderJson).build();
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response create(final @Context UriInfo uriInfo,
                           final @RequestBody JsonNode resource) {

        ProductOrderEntity productOrder = jsonEntityConverter.convertJsonToProductOrderEntity(resource);

        ZErrorEntity zErrorEntity = productOrderValidationService.checkProductOrderBusinessRules(resource);
        if (CollectionUtils.isNotEmpty(zErrorEntity.getDetails())) {
            return Response.status(422).entity(zErrorEntity).build();
        }
        productOrder.setOrderDate(new Date());

        ProductOrderEntity productOrderSaved = productOrderService.create(productOrder);
        // on a besoin du productorder en base en non celui de la requête pour récupérer notamment l id généré automatiquement
        productOrderSaved = postServiceOrder(productOrderSaved);


        Set<String> fieldNames = Sets.newHashSet("id");
        final ObjectNode node = Jackson.createNode(productOrderSaved, new JsonRepresentation(fieldNames));
        return Response.status(201).entity(node).build();
    }


    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response find(final @Context UriInfo info) {

        List<JsonNode> response = Lists.newArrayList();

        Response entitiesFound = super.find(info);
        LinkedHashSet<ProductOrderEntity> productOrderEntities =(LinkedHashSet) entitiesFound.getEntity();
        if (CollectionUtils.isEmpty(productOrderEntities)) {
            return Response.noContent().build();
        }
        for (ProductOrderEntity productOrderEntity : productOrderEntities) {
            JsonNode productOrderJson = callServiceOrderAndManageProductOrder(productOrderEntity);
            response.add(productOrderJson);
        }
        return Response.status(200).entity(response).build();
    }

    private JsonNode callServiceOrderAndManageProductOrder(ProductOrderEntity productOrder) {

        // call to legato deactivated
        return jsonEntityConverter.convertProductOrderEntityToJson(productOrder);

    }





    private ProductOrderEntity postServiceOrder(ProductOrderEntity productOrder) {
        // call to legato deactivated
       productOrderService.updateProductOrderStatus(productOrder, StateTypeEntity.ACKNOWLEDGED,StateTypeEntity.ACKNOWLEDGED);
       productOrderService.update(productOrder);
       return productOrder;
    }

    public byte[] getByteArray(String data) {

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(byteArrayOutputStream);

        try {
            out.write(data.getBytes());
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return byteArrayOutputStream.toByteArray();

    }



}
