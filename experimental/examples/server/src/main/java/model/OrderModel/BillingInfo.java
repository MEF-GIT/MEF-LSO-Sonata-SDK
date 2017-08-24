package model.OrderModel;


import model.ServiceabilityModel.Address;
import model.ServiceabilityModel.Contact;

public class BillingInfo {
    private Contact contact;
    private Address address;

    public BillingInfo(Contact contact, Address address) {
        this.contact = contact;
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
