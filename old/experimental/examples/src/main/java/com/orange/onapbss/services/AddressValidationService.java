package com.orange.onapbss.services;

import com.orange.onapbss.datamodel.addressValidation.AddressValidation;

import java.util.List;

public interface AddressValidationService {

    List<AddressValidation> listAll();

    AddressValidation add(AddressValidation address);

    AddressValidation validate(AddressValidation address);

    void reset();
}
