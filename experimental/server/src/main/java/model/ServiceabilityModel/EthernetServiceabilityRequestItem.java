package model.ServiceabilityModel;

import org.json.JSONException;
import org.json.JSONObject;

public class EthernetServiceabilityRequestItem {
    private String bandwidth;
    private String maxPortSpeed;
   // private Address address;
    private Enums.AccessMedium accessMedium;
    private Enums.ClassOfService classOfService;
    private Enums.ProductCategory productCategory;
    private Enums.ProductType productType;
    private int pricingTerm;
    private String desiredActivationDate;
    private Enums.InterfaceType interfaceType;
    private boolean newEnniRequired;
    private String buyerEnniId;
    private ServiceSite serviceSite;
    private int price;
    //wow
    public EthernetServiceabilityRequestItem(){
    }
    public EthernetServiceabilityRequestItem(String bandwidth, String maxPortSpeed, Address address, Enums.AccessMedium accessMedium
            , Enums.ClassOfService classOfService, Enums.ProductCategory productCategory
            , Enums.ProductType productType, int pricingTerm, String date, Enums.InterfaceType interfaceType, boolean newEnniRequired, String buyerEnniId, ServiceSite serviceSite, int price){
        this.bandwidth = bandwidth;
        this.maxPortSpeed = maxPortSpeed;
        //this.address = address;
        this.accessMedium = accessMedium;
        this.classOfService = classOfService;
        this.productCategory = productCategory;
        this.productType = productType;
        this.pricingTerm = pricingTerm;
        this.desiredActivationDate = date;
        this.interfaceType = interfaceType;
        this.newEnniRequired = newEnniRequired;
        this.buyerEnniId = buyerEnniId;
        this.serviceSite = serviceSite;
        this.price = price;
    }
    public String getBandwidth() {
        return bandwidth;
    }

    public void setBandwidth(String bandwidth) {
        this.bandwidth = bandwidth;
    }

    public String getMaxPortSpeed() {
        return maxPortSpeed;
    }

    public void setMaxPortSpeed(String maxPortSpeed) {
        this.maxPortSpeed = maxPortSpeed;
    }

//    public Address getAddress() {
//        return address;
//    }
//
//    public void setAddress(Address address) {
//        this.address = address;
//    }

    public Enums.AccessMedium getAccessMedium() {
        return accessMedium;
    }

    public void setAccessMedium(Enums.AccessMedium accessMedium) {
        this.accessMedium = accessMedium;
    }

    public Enums.ClassOfService getClassOfService() {
        return classOfService;
    }

    public void setClassOfService(Enums.ClassOfService classOfService) {
        this.classOfService = classOfService;
    }

    public Enums.ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(Enums.ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public Enums.ProductType getProductType() {
        return productType;
    }

    public void setProductType(Enums.ProductType productType) {
        this.productType = productType;
    }

    public int getPricingTerm() {
        return pricingTerm;
    }

    public void setPricingTerm(int pricingTerm) {
        this.pricingTerm = pricingTerm;
    }

    public String getDesiredActivationDate() {
        return desiredActivationDate;
    }

    public void setDesiredActivationDate(String desiredActivationDate) {
        this.desiredActivationDate = desiredActivationDate;
    }
    private Address jsonToAddress(String data) throws JSONException {
        JSONObject jsonObject=new JSONObject(data);
        String latitude=jsonObject.getJSONObject("ServiceabilityRequest")
                .getJSONObject("servicesite").getJSONObject("address").getJSONObject("GeoCode").getString("latitude");
        String longitude=jsonObject.getJSONObject("ServiceabilityRequest")
                .getJSONObject("servicesite").getJSONObject("address").getJSONObject("GeoCode").getString("longitude");
        return new Address(new GeoCode(latitude,longitude));
    }
    public void jsonToESRI(String data) throws JSONException {
        JSONObject jsonObject=new JSONObject(data);
        //EthernetServiceabilityRequestItem eSRI=new EthernetServiceabilityRequestItem();
        this.setServiceSite(new ServiceSite(jsonToAddress(data)));
       // this.setAddress(jsonToAddress(data));
        this.setBandwidth(jsonObject.getJSONObject("ServiceabilityRequest").getJSONObject("EthernetServiceabilityRequestItem").getString("bandwidth"));
        this.setMaxPortSpeed(jsonObject.getJSONObject("ServiceabilityRequest").getJSONObject("EthernetServiceabilityRequestItem").getString("maxPortSpeed"));
        this.setAccessMedium(Enums.AccessMedium.valueOf
                ((jsonObject.getJSONObject("ServiceabilityRequest").getJSONObject("EthernetServiceabilityRequestItem").getString("accessMedium"))));
        this.setClassOfService(Enums.ClassOfService.valueOf
                ((jsonObject.getJSONObject("ServiceabilityRequest").getJSONObject("EthernetServiceabilityRequestItem").getString("classOfService"))));
        this.setProductCategory(Enums.ProductCategory.valueOf
                ((jsonObject.getJSONObject("ServiceabilityRequest").getJSONObject("EthernetServiceabilityRequestItem").getString("productCategory"))));
        this.setProductType(Enums.ProductType.valueOf
                ((jsonObject.getJSONObject("ServiceabilityRequest").getJSONObject("EthernetServiceabilityRequestItem").getString("productType"))));
        this.setPricingTerm(jsonObject.getJSONObject("ServiceabilityRequest").getJSONObject("EthernetServiceabilityRequestItem").getInt("pricingTerm"));
        this.setDesiredActivationDate(jsonObject.getJSONObject("ServiceabilityRequest").getJSONObject("EthernetServiceabilityRequestItem").getString("desiredActivationDate"));
        this.setInterfaceType(Enums.InterfaceType.valueOf
                ((jsonObject.getJSONObject("ServiceabilityRequest").getJSONObject("EthernetServiceabilityRequestItem").getString("interfaceType"))));
        this.setNewEnniRequired(jsonObject.getJSONObject("ServiceabilityRequest").getJSONObject("EthernetServiceabilityRequestItem").getBoolean("newEnniRequired"));
    }

    public Enums.InterfaceType getInterfaceType() {
        return interfaceType;
    }

    public void setInterfaceType(Enums.InterfaceType interfaceType) {
        this.interfaceType = interfaceType;
    }

    public boolean isNewEnniRequired() {
        return newEnniRequired;
    }

    public void setNewEnniRequired(boolean newEnniRequired) {
        this.newEnniRequired = newEnniRequired;
    }

    public String getBuyerEnniId() {
        return buyerEnniId;
    }

    public void setBuyerEnniId(String buyerEnniId) {
        this.buyerEnniId = buyerEnniId;
    }

    public ServiceSite getServiceSite() {
        return serviceSite;
    }

    public void setServiceSite(ServiceSite serviceSite) {
        this.serviceSite = serviceSite;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
