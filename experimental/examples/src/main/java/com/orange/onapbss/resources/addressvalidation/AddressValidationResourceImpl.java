package com.orange.onapbss.resources.addressvalidation;

import com.orange.onapbss.datamodel.addressValidation.AddressValidation;
import com.orange.onapbss.services.AddressValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;

@Path("addressValidation")
@Component("addressValidationResource")
public class AddressValidationResourceImpl {

    @Autowired
    AddressValidationService addressValidationService;

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response create(final @RequestBody AddressValidation resource) {
        AddressValidation response = addressValidationService.validate(resource);
        response.setValidationDate(new Date());
        response.setStatus("done");
        response.setProvideaAlternative(false);
        return Response.ok(response).status(201).build();
    }
}