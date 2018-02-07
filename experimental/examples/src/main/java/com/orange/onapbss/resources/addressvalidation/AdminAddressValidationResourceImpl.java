package com.orange.onapbss.resources.addressvalidation;

import com.orange.onapbss.datamodel.addressValidation.AddressValidation;
import com.orange.onapbss.services.AddressValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("admin/addressValidation")
@Component("adminAddressValidationResource")
public class AdminAddressValidationResourceImpl {

    @Autowired
    AddressValidationService addressValidationService;

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response createNewAddress(final @RequestBody AddressValidation addressValidation) {
        return Response.ok(addressValidationService.add(addressValidation))
                .status(201)
                .build();
    }

    @POST
    @Path("/reset")
    public Response resetAddresses() {
        addressValidationService.reset();
        return Response.ok().status(204).build();
    }

    @GET
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response listAllAddresses() {
        return Response.ok(addressValidationService.listAll()).status(200).build();
    }



}