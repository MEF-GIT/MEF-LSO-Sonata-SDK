package com.orange.onapbss.resources.status;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.orange.onapbss.resources.status.model.ApplicationStatus;
import com.orange.onapbss.resources.status.model.StatusType;
import com.orange.soa.commons.json.Jackson;
import com.orange.soa.commons.json.JsonRepresentation;

@Path("status")
@Component("statusResource")
public class StatusResourceImpl {

	@Autowired
	private StatusService statusService;

	private JsonRepresentation fullView;

	public StatusResourceImpl() {
		fullView = new JsonRepresentation().add("name").add("status").add("version").add("components.name")
				.add("components.status");
	}

	@GET
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response status(final @Context UriInfo uriInfo) {

		// TODO Maybe change how to get application name and version
		final String[] splitPath = uriInfo.getBaseUri().getPath().split("/");

		final String applicationName = splitPath[1];
		final String applicationVersion = splitPath[2];

		final ApplicationStatus applicationStatus = this.statusService.get(applicationName, applicationVersion);

		final boolean isServiceFullyFunctional = StatusType.OK.equals(applicationStatus.getStatus()) ? applicationStatus
				.getComponents().stream().allMatch(componentStatus -> StatusType.OK.equals(componentStatus.getStatus()))
				: false;

		final ObjectNode json = Jackson.createNode(applicationStatus, this.fullView);

		return isServiceFullyFunctional ? Response.ok(json).build()
				: Response.status(Status.SERVICE_UNAVAILABLE).entity(json).build();
	}

}
