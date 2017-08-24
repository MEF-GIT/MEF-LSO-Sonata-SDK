package model.ServiceabilityModel;

public class ServiceabilityResponse {
    static int counter=1;
    static String globalResponseID="ServiceabilityResponse_No.";
    private boolean mpoeOnly;
    private String expirationDate;
    private ServiceabilityRequest serviceabilityRequest;
    private ServiceSite serviceSite;
    private String ServiceabilityResponseId;
    private String buyedId;
    private String sellerId;
    private Enums.ServiceabilityResponseStatus serviceabilityResponseStatus;
    private int installationInterval;
    private EthernetProductSpec ethernetProductSpec;
    private ServiceabilityConfidence serviceabilityConfidence;
    private int ItemId;

    public ServiceabilityResponse(ServiceabilityRequest serviceabilityRequest, ServiceSite serviceSite){
        this.ServiceabilityResponseId=globalResponseID+counter;
        counter++;
        this.serviceabilityRequest=serviceabilityRequest;
        this.serviceSite=serviceSite;
        this.serviceabilityResponseStatus= Enums.ServiceabilityResponseStatus.SUBMITTED;
    }
    public ServiceabilityResponse(boolean mpoeOnly, String expirationDate, ServiceabilityRequest serviceabilityRequest, ServiceSite serviceSite, String serviceabilityResponseId, String buyedId, String sellerId,
                                  Enums.ServiceabilityResponseStatus serviceabilityResponseStatus, int installationInterval, EthernetProductSpec ethernetProductSpec) {
        this.mpoeOnly = mpoeOnly;
        this.expirationDate = expirationDate;
        this.serviceabilityRequest = serviceabilityRequest;
        this.serviceSite = serviceSite;
        ServiceabilityResponseId = serviceabilityResponseId;
        this.buyedId = buyedId;
        this.sellerId = sellerId;
        this.serviceabilityResponseStatus = serviceabilityResponseStatus;
        this.installationInterval = installationInterval;
        this.ethernetProductSpec = ethernetProductSpec;
    }

    public boolean isMpoeOnly() {
        return mpoeOnly;
    }

    public void setMpoeOnly(boolean mpoeOnly) {
        this.mpoeOnly = mpoeOnly;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public ServiceabilityRequest getServiceabilityRequest() {
        return serviceabilityRequest;
    }

    public void setServiceabilityRequest(ServiceabilityRequest serviceabilityRequest) {
        this.serviceabilityRequest = serviceabilityRequest;
    }

    public ServiceSite getServiceSite() {
        return serviceSite;
    }

    public void setServiceSite(ServiceSite serviceSite) {
        this.serviceSite = serviceSite;
    }

    public String getServiceabilityResponseId() {
        return ServiceabilityResponseId;
    }

    public void setServiceabilityResponseId(String serviceabilityResponseId) {
        ServiceabilityResponseId = serviceabilityResponseId;
    }

    public String getBuyedId() {
        return buyedId;
    }

    public void setBuyedId(String buyedId) {
        this.buyedId = buyedId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public Enums.ServiceabilityResponseStatus getServiceabilityResponseStatus() {
        return serviceabilityResponseStatus;
    }

    public void setServiceabilityResponseStatus(Enums.ServiceabilityResponseStatus serviceabilityResponseStatus) {
        this.serviceabilityResponseStatus = serviceabilityResponseStatus;
    }

    public int getInstallationInterval() {
        return installationInterval;
    }

    public void setInstallationInterval(int installationInterval) {
        this.installationInterval = installationInterval;
    }

    public EthernetProductSpec getEthernetProductSpec() {
        return ethernetProductSpec;
    }

    public void setEthernetProductSpec(EthernetProductSpec ethernetProductSpec) {
        this.ethernetProductSpec = ethernetProductSpec;
    }

    public ServiceabilityConfidence getServiceabilityConfidence() {
        return serviceabilityConfidence;
    }

    public void setServiceabilityConfidence(ServiceabilityConfidence serviceabilityConfidence) {
        this.serviceabilityConfidence = serviceabilityConfidence;
    }

    public int getItemId() {
        return ItemId;
    }

    public void setItemId(int itemId) {
        ItemId = itemId;
    }
}