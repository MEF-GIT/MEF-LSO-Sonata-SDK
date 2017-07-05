package model.ServiceabilityModel;

import java.util.List;

public class ServiceabilityRequest {
    static int counter=1;
    static String globalRequestID="ServiceabilityRequest_No.";
    private String desiredResponseDate;
    private Enums.ServiceabilityRequestStatus serviceRequestStatus;
    private String serviceabilityRequestId;
    private String buyedId;
    private String sellerId;
    private String projectId;
    private ServiceSite serviceSite;
    private EthernetServiceabilityRequestItem ethernetServiceabilityRequestItem;
    private ServiceabilityResponse serviceabilityResponse;
    private int itemId;
    //private List<EthernetServiceabilityRequestItem> serviceabilityRequestItem;
    //private List<ServiceabilityResponse> serviceabilityResponses;

    public ServiceabilityRequest(ServiceSite serviceSite,EthernetServiceabilityRequestItem esri){
        this.serviceabilityRequestId=globalRequestID+counter;
        counter++;
        this.serviceabilityRequestId=serviceabilityRequestId;
        this.serviceSite=serviceSite;
        this.ethernetServiceabilityRequestItem=esri;
        this.serviceRequestStatus= Enums.ServiceabilityRequestStatus.SUBMITTED;

    }
    public ServiceabilityRequest(String desiredResponseDate, Enums.ServiceabilityRequestStatus serviceRequestStatus, String serviceabilityRequestId, String buyedId, String sellerId, String projectId,
                                 ServiceSite serviceSite, List<EthernetServiceabilityRequestItem> serviceabilityRequestItem, List<ServiceabilityResponse> serviceabilityResponses, EthernetServiceabilityRequestItem ethernetServiceabilityRequestItem, ServiceabilityResponse serviceabilityResponse) {
        this.desiredResponseDate = desiredResponseDate;
        this.serviceRequestStatus = serviceRequestStatus;
        this.serviceabilityRequestId = serviceabilityRequestId;
        this.buyedId = buyedId;
        this.sellerId = sellerId;
        this.projectId = projectId;
        this.serviceSite = serviceSite;
//        this.serviceabilityRequestItem = serviceabilityRequestItem;
//        this.serviceabilityResponses = serviceabilityResponses;
        this.ethernetServiceabilityRequestItem = ethernetServiceabilityRequestItem;
        this.serviceabilityResponse = serviceabilityResponse;
    }

    public String getDesiredResponseDate() {
        return desiredResponseDate;
    }

    public void setDesiredResponseDate(String desiredResponseDate) {
        this.desiredResponseDate = desiredResponseDate;
    }

    public Enums.ServiceabilityRequestStatus getServiceRequestStatus() {
        return serviceRequestStatus;
    }

    public void setServiceRequestStatus(Enums.ServiceabilityRequestStatus serviceRequestStatus) {
        this.serviceRequestStatus = serviceRequestStatus;
    }

    public String getServiceabilityRequestId() {
        return serviceabilityRequestId;
    }

    public void setServiceabilityRequestId(String serviceabilityRequestId) {
        this.serviceabilityRequestId = serviceabilityRequestId;
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

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public ServiceSite getServiceSite() {
        return serviceSite;
    }

    public void setServiceSite(ServiceSite serviceSite) {
        this.serviceSite = serviceSite;
    }

    public EthernetServiceabilityRequestItem getEthernetServiceabilityRequestItem() {
        return ethernetServiceabilityRequestItem;
    }

    public void setEthernetServiceabilityRequestItem(EthernetServiceabilityRequestItem ethernetServiceabilityRequestItem) {
        this.ethernetServiceabilityRequestItem = ethernetServiceabilityRequestItem;
    }

    public ServiceabilityResponse getServiceabilityResponse() {
        return serviceabilityResponse;
    }

    public void setServiceabilityResponse(ServiceabilityResponse serviceabilityResponse) {
        this.serviceabilityResponse = serviceabilityResponse;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

//    public List<EthernetServiceabilityRequestItem> getServiceabilityRequestItem() {
//        return serviceabilityRequestItem;
//    }
//
//    public void setServiceabilityRequestItem(List<EthernetServiceabilityRequestItem> serviceabilityRequestItem) {
//        this.serviceabilityRequestItem = serviceabilityRequestItem;
//    }
//
//    public List<ServiceabilityResponse> getServiceabilityResponses() {
//        return serviceabilityResponses;
//    }
//
//    public void setServiceabilityResponses(List<ServiceabilityResponse> serviceabilityResponses) {
//        this.serviceabilityResponses = serviceabilityResponses;
//    }
}
