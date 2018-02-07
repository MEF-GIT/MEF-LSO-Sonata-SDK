package com.orange.onapbss.resources.productorder;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Lists;
import com.orange.onapbss.datamodel.productordering.ActionTypeEntity;
import com.orange.onapbss.datamodel.productordering.ZErrorDetailEntity;
import com.orange.onapbss.datamodel.productordering.ZErrorEntity;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductOrderValidationService {


    private final List<String> allowedPartyRoleProductOrder = Lists.newArrayList("buyer", "seller", "Billing Contact", "Order Contact",
            "Implementation Contact", "Technical Contact");

    private final List<String> allowedPartyRoleProductOrderItem = Lists.newArrayList("UNI Site Contact",
            "UNI Alt Site Contact", "ENNI Site Contact", "ENNI Alt Site Contact");


    public ZErrorEntity checkProductOrderBusinessRules(JsonNode productOrderJson) {


        ZErrorEntity error = new ZErrorEntity();
        error.setCode(422);
        List<ZErrorDetailEntity> detailErrors = Lists.newArrayList();
        JsonNode ordersJson = productOrderJson.path("orderItem");

        if (ordersJson == null || !ordersJson.isArray()) {
            ZErrorDetailEntity detailError = new ZErrorDetailEntity();
            detailError.setCode(100);
            detailError.setDescription("Missing order item (minimum 1) At least one order item must be provided");
            detailError.setMessage("Missing order item (minimum 1) At least one order item must be provided");
            detailErrors.add(detailError);
        }
        if (ordersJson.size() != 4) {
            ZErrorDetailEntity detailError = new ZErrorDetailEntity();
            detailError.setMessage("4 orderItems msut be defined in productorder");
            detailErrors.add(detailError);
        }
        int nbBuyerRelatedParted = 0;
        for (JsonNode relatedPartyEntity : productOrderJson.path("relatedParty")) {
            String entityRole = relatedPartyEntity.path("role").textValue();
            if ("Buyer".equalsIgnoreCase(entityRole)) {
                nbBuyerRelatedParted++;
            }
            if (isPartyRoleAllowed(allowedPartyRoleProductOrder, entityRole)) {
                ZErrorDetailEntity detailError = new ZErrorDetailEntity();
                detailError.setCode(102);
                detailError.setDescription("A relatedParty is at the wrong level The party role provided is not managed - MEF allows to have \"Buyer\", \"Seller\", \"Billing Contact\", \"Order Contact\"," +
                        "\"Implementation Contact\", \"Technical Contact\" roles at product order level");
                detailError.setMessage("A relatedParty is at the wrong level The party role provided is not managed - MEF allows to have \"Buyer\", \"Seller\", \"Billing Contact\", \"Order Contact\"," +
                        "\"Implementation Contact\", \"Technical Contact\" roles at product order level");
                detailErrors.add(detailError);
            }

        }
        if (nbBuyerRelatedParted == 0) {
            ZErrorDetailEntity detailError = new ZErrorDetailEntity();
            detailError.setCode(101);
            detailError.setDescription("Missing Buyer at order level");
            detailError.setMessage("Missing Buyer at order level");
            detailErrors.add(detailError);
        }
        if (nbBuyerRelatedParted > 1) {
            ZErrorDetailEntity detailError = new ZErrorDetailEntity();
            detailError.setCode(101);
            detailError.setDescription("One and only one related party with a \"Buyer\" role should be provided at the product order level.");
            detailError.setMessage("One and only one related party with a \"Buyer\" role should be provided at the product order level.");
            detailErrors.add(detailError);
        }
        List<String> idRefProductItems = Lists.newArrayList("UNISpec",
                "eLineSpec", "UNICEEndPointSpec", "ENNICEEndPointSpec");

        for (JsonNode orderItemJson : productOrderJson.path("orderItem")) {
            for (JsonNode relatedPartyEntity : orderItemJson.path("product").path("relatedParty")) {
                String partyRole = relatedPartyEntity.path("role").textValue();
                if (isPartyRoleAllowed(allowedPartyRoleProductOrderItem, partyRole)) {
                    ZErrorDetailEntity detailError = new ZErrorDetailEntity();
                    detailError.setCode(102);
                    detailError.setDescription("A relatedParty is at the wrong level The party role provided is not managed - MEF allows to have  \"UNI Site Contact\"," +
                            "\"UNI Alt Site Contact\", \"ENNI Site Contact\", \"ENNI Alt Site Contact\" at product order item level");
                    detailError.setMessage("A relatedParty is at the wrong level The party role provided is not managed - MEF allows to have  \"UNI Site Contact\"," +
                            "\"UNI Alt Site Contact\", \"ENNI Site Contact\", \"ENNI Alt Site Contact\" at product order item level");
                    detailErrors.add(detailError);
                }
            }
            if (!orderItemJson.get("action").textValue().equalsIgnoreCase(ActionTypeEntity.ADD.value())) {
                ZErrorDetailEntity detailError = new ZErrorDetailEntity();
                detailError.setMessage("orderItem " + orderItemJson.get("id").textValue() + " is not in 'add' action");
                detailErrors.add(detailError);
            }
            String idRefProductItem = orderItemJson.get("product").get("productSpecification").get("id").textValue();
            String refProductItemFound = null;
            for (String refProductItem : idRefProductItems) {
                if(refProductItem.startsWith(idRefProductItem))
                {
                    refProductItemFound=refProductItem;
                }
            }
            idRefProductItems.remove(refProductItemFound);
        }
        if (CollectionUtils.isNotEmpty(idRefProductItems)) {
            ZErrorDetailEntity detailError = new ZErrorDetailEntity();
            detailError.setMessage("productorder must contain an UNISpec, eLineSpec, UNICEEndPointspec, ENNICEEndPointSpec item. A least one is missing");
            detailErrors.add(detailError);
        }

        error.setDetails(detailErrors);
        return error;
    }

    private boolean isPartyRoleAllowed(List<String> allowedPartyRoles, String partyRole) {
        for (String allowedPartyRole : allowedPartyRoles) {
            if (!allowedPartyRole.equalsIgnoreCase(partyRole)) {
                return false;
            }
        }
        return true;
    }

}
