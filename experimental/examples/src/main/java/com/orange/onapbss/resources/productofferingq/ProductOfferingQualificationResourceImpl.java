package com.orange.onapbss.resources.productofferingq;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.orange.onapbss.converter.JsonEntityConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Path("productOfferingQualification")
@Component("productOfferingQualificationResource")
public class ProductOfferingQualificationResourceImpl  {

	@Inject
	JsonEntityConverter jsonEntityConverter;



	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response create(final @Context UriInfo uriInfo,
						   final @RequestBody JsonNode resource) {

		//check if request is ok
		jsonEntityConverter.convertJsonToProductOfferingQualificationEntity(resource);


		LocalDate today = LocalDate.now();
		//add 1 week to the current date
		LocalDate next2Week = today.plus(1, ChronoUnit.WEEKS);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String oneWeekLaterString = next2Week.format(formatter);
		String todayString = today.format(formatter);
		((ObjectNode)resource).put("state", "COMPLETED");
		((ObjectNode)resource).put("id", UUID.randomUUID().toString());
		((ObjectNode)resource).put("expirationDate", oneWeekLaterString);
		JsonNode productOfferingQualificationItems = resource.get("productOfferingQualificationItem");
		for (JsonNode productOfferingQualificationItem : productOfferingQualificationItems) {
			((ObjectNode)productOfferingQualificationItem).put("state", "COMPLETED");
			((ObjectNode)productOfferingQualificationItem).put("serviceabilityConfidence", "GREEN");
			if(productOfferingQualificationItem.get("estimatedResponseDate")==null) {
				((ObjectNode) productOfferingQualificationItem).put("estimatedResponseDate", todayString);
			}
			if(productOfferingQualificationItem.get("installationInterval")==null)
			{
				ObjectNode installationInterval = JsonNodeFactory.instance.objectNode();
				installationInterval.put("amount",30);
				installationInterval.put("timeUnit","SECS");
				((ObjectNode) productOfferingQualificationItem).set("installationInterval",installationInterval);
			}

		}


		return Response.ok(resource).status(201).build();
	}




}
