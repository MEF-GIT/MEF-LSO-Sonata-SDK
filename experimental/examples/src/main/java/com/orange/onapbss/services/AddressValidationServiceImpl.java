package com.orange.onapbss.services;

import com.orange.onapbss.datamodel.addressValidation.AddressValidation;
import com.orange.onapbss.datamodel.addressValidation.AddressValidationRepository;
import com.orange.onapbss.datamodel.addressValidation.GeographicAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressValidationServiceImpl implements AddressValidationService {

    @Autowired
    private AddressValidationRepository addressRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<AddressValidation> listAll() {
        List<AddressValidation> addresses = new ArrayList<>();
        addressRepository.findAll().forEach(addresses::add);
        return addresses;
    }

    @Override
    public AddressValidation add(AddressValidation address) {
        AddressValidation response = addressRepository.save(address);
        return response;
    }

    @Override
    public AddressValidation validate(AddressValidation address) {
        AddressValidation response = null;

        Query query = new Query();
        query.addCriteria(Criteria.where("validAddress.city").is(address.getValidAddress().getCity()));
        query.addCriteria(Criteria.where("validAddress.streetNr").is(address.getValidAddress().getStreetNr()));
        query.addCriteria(Criteria.where("validAddress.streetName").is(address.getValidAddress().getStreetName()));
        query.addCriteria(Criteria.where("validAddress.streetType").is(address.getValidAddress().getStreetType()));
        query.addCriteria(Criteria.where("validAddress.postcode").is(address.getValidAddress().getPostcode()));
        query.addCriteria(Criteria.where("validAddress.country").is(address.getValidAddress().getCountry()));
        List<AddressValidation> result = mongoTemplate.find(query, AddressValidation.class);

        if (result != null && result.size()>0) {
            response = result.get(0);
            response.setValidationResult("success");
            return response;
        } else {
            return createKOResponse();
        }
    }

    @Override
    public void reset() {
        addressRepository.deleteAll();
        addressRepository.save(initMockAddress());
    }

    private AddressValidation initMockAddress() {
        AddressValidation addressValidation = new AddressValidation();
        GeographicAddress address = new GeographicAddress();
        address.setId("1");
        address.setStreetNr("2");
        address.setStreetName("Pierre Marzin");
        address.setStreetType("avenue");
        address.setPostcode("22300");
        address.setCity("Lannion");
        address.setCountry("France");
        addressValidation.setValidAddress(address);
        return addressValidation;
    }



    private AddressValidation createKOResponse() {
        AddressValidation addressValidation = new AddressValidation();
        addressValidation.setId("1");
        addressValidation.setValidationResult("fail");
        return addressValidation;
    }


}
