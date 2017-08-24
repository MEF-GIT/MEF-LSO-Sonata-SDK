package model.ServiceabilityModel;

/**
 * Created by Rami9 on 12/06/2017.
 */
public class Contact {
    private String emailAddress;
    private String telephoneNumber;
    private String telephoneExtension;
    private String contactName;

    public Contact(String emailAddress, String telephoneNumber, String telephoneExtension, String contactName) {
        this.emailAddress = emailAddress;
        this.telephoneNumber = telephoneNumber;
        this.telephoneExtension = telephoneExtension;
        this.contactName = contactName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getTelephoneExtension() {
        return telephoneExtension;
    }

    public void setTelephoneExtension(String telephoneExtension) {
        this.telephoneExtension = telephoneExtension;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }
}
