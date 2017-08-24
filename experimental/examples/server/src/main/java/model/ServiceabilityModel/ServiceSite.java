package model.ServiceabilityModel;


public class ServiceSite {
    private String siteId;
    private String siteCompanyName;
    private String siteCustomerName;
    private String additionalSiteInformation;
    private String siteDescription;
    private Enums.SiteAddressType siteAddressType;
    private Address address;
    private String siteName;
    private Contact contact;
    private Link link;

    public ServiceSite(Address address){
        this.address=address;
    }
    public ServiceSite(String siteId, String siteCompanyName, String siteCustomerName, String additionalSiteInformation,
                       String siteDescription, Enums.SiteAddressType siteAddressType, Address address, String siteName, Contact contact, Link link) {
        this.siteId = siteId;
        this.siteCompanyName = siteCompanyName;
        this.siteCustomerName = siteCustomerName;
        this.additionalSiteInformation = additionalSiteInformation;
        this.siteDescription = siteDescription;
        this.siteAddressType = siteAddressType;
        this.address = address;
        this.siteName = siteName;
        this.contact = contact;
        this.link = link;
    }
    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getSiteCompanyName() {
        return siteCompanyName;
    }

    public void setSiteCompanyName(String siteCompanyName) {
        this.siteCompanyName = siteCompanyName;
    }

    public String getSiteCustomerName() {
        return siteCustomerName;
    }

    public void setSiteCustomerName(String siteCustomerName) {
        this.siteCustomerName = siteCustomerName;
    }

    public String getAdditionalSiteInformation() {
        return additionalSiteInformation;
    }

    public void setAdditionalSiteInformation(String additionalSiteInformation) {
        this.additionalSiteInformation = additionalSiteInformation;
    }

    public String getSiteDescription() {
        return siteDescription;
    }

    public void setSiteDescription(String siteDescription) {
        this.siteDescription = siteDescription;
    }

    public Enums.SiteAddressType getSiteAddressType() {
        return siteAddressType;
    }

    public void setSiteAddressType(Enums.SiteAddressType siteAddressType) {
        this.siteAddressType = siteAddressType;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }


}
