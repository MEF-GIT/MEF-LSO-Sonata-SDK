package model.OrderModel;

import model.ServiceabilityModel.*;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.*;
@SuppressWarnings("Duplicates")
public class ProductOrder {
    private static int counter=1;
    private static String globalProductID="ProductOrder_No.";
    private String buyerId;
    private String sellerId;
    private OrderItem orderItem;
    private int orderItemId;
    private String productOrderId;
    private Enums.OrderType orderType;
    private String serviceabilityResponseId;
    private int expeditePriority;
    private String orderDate;
    private Enums.OrderActivity orderActivity;
    private String requestedCompletionDate;
    private String dateComplete;
    private String projectId;
    private Enums.PricingMethod pricingMethod;
    private int pricingTerm;
    private String notes;
    private Enums.OrderStatus orderStatus;
    private BillingInfo billingInfo;
    private int billingInfoId;
    //private DesiredOrderResponse desiredOrderResponse;

    public ProductOrder(String buyerId, String sellerId, OrderItem orderItem, int orderItemId, String productOrderId, Enums.OrderType orderType, String serviceabilityResponseId, int expeditePriority, String orderDate, Enums.OrderActivity orderActivity, String resquestedCompletionDate, String dateComplete, String projectId, Enums.PricingMethod pricingMethod
            , int pricingTerm, String notes, Enums.OrderStatus orderStatus, BillingInfo billingInfo) {
        this.orderItemId = orderItemId;
        this.productOrderId=globalProductID+counter;
        counter++;
        this.buyerId = buyerId;
        this.sellerId = sellerId;
        this.orderItem = orderItem;
        this.productOrderId = productOrderId;
        this.orderType = orderType;
        this.serviceabilityResponseId = serviceabilityResponseId;
        this.expeditePriority = expeditePriority;
        this.orderDate = orderDate;
        this.orderActivity = orderActivity;
        this.requestedCompletionDate = resquestedCompletionDate;
        this.dateComplete = dateComplete;
        this.projectId = projectId;
        this.pricingMethod = pricingMethod;
        this.pricingTerm = pricingTerm;
        this.notes = notes;
        this.orderStatus = orderStatus;
        this.billingInfo = billingInfo;
    }
    public ProductOrder(){
        this.productOrderId=globalProductID+counter;
        counter++;
    }


    public void jsonToProductOrder(String data) throws JSONException, SQLException, ClassNotFoundException {
        JSONObject jsonObject=new JSONObject(data);
        String latitude=jsonObject.getString("latitude");
        String longitude=jsonObject.getString("longitude");
        GeoCode geoCode=new GeoCode(latitude,longitude);
        Address billingAddress=new Address(geoCode);
        Contact contact =new Contact(jsonObject.getString("email"),jsonObject.getString("telephone"),null,jsonObject.getString("contactName"));
        BillingInfo billingInfo=new BillingInfo(contact,billingAddress);
        this.billingInfo=billingInfo;
        this.serviceabilityResponseId=jsonObject.getString("responseId");
        this.pricingMethod = Enums.PricingMethod.valueOf(jsonObject.getString("pricingMethod"));
        this.orderActivity= Enums.OrderActivity.INSTALL;
        this.orderStatus= Enums.OrderStatus.ACKNOWLEDGED;
        Connection connection=connectToDB();
        Statement stresult = connection.createStatement();
        ResultSet location = stresult.executeQuery(
                "SELECT ItemId FROM serviceability.serviceabilityresponse" +
                        " WHERE serviceabilityResponseId='"+serviceabilityResponseId+"'");
        location.next();
        int itemId=location.getInt("ItemId");
        Statement stresult1 = connection.createStatement();
        ResultSet location1 = stresult1.executeQuery(
                "SELECT * FROM serviceability.ethernetserviceabilityrequestitems" +
                        " WHERE ItemId='"+itemId+"'");
        location1.next();
        Address address = new Address(new GeoCode(location1.getString("latitude"),
                location1.getString("longitude")));
        ServiceSite serviceSite = new ServiceSite(address);
        EthernetServiceabilityRequestItem esri = new EthernetServiceabilityRequestItem();
        esri.setBandwidth(location1.getString("bandwidth"));
        esri.setMaxPortSpeed(location1.getString("maxPortSpeed"));
        esri.setServiceSite(new ServiceSite(address));
        esri.setAccessMedium(model.ServiceabilityModel.Enums.AccessMedium.valueOf(location1.getString("accessMedium")));
        esri.setClassOfService(model.ServiceabilityModel.Enums.ClassOfService.valueOf(location1.getString("classOfService")));
        esri.setProductCategory(model.ServiceabilityModel.Enums.ProductCategory.valueOf(location1.getString("productCategory")));
        esri.setProductType(model.ServiceabilityModel.Enums.ProductType.valueOf(location1.getString("productType")));
        esri.setPricingTerm(location1.getInt("pricingTerm"));
        esri.setDesiredActivationDate(location1.getString("date"));
        esri.setInterfaceType(model.ServiceabilityModel.Enums.InterfaceType.valueOf(location1.getString("interfaceType")));
        Product product=new Product(serviceSite,itemId,null,esri);
        OrderItem orderItem=new OrderItem(Enums.OrderItemAction.ADD,product);
        this.orderType= Enums.OrderType.valueOf(esri.getProductType().toString());
        this.orderItem=orderItem;
    }
    private Connection connectToDB() throws SQLException, ClassNotFoundException {
        String host="jdbc:mysql://localhost:3306/serviceability";
        String user="rami";
        String pass="wissamrami";
        Class.forName("com.mysql.jdbc.Driver");
        return
                DriverManager.getConnection(host
                        ,user,pass);
    }
    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public BillingInfo getBillingInfo() {
        return billingInfo;
    }

    public void setBillingInfo(BillingInfo billingInfo) {
        this.billingInfo = billingInfo;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public OrderItem getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(OrderItem orderItem) {
        this.orderItem = orderItem;
    }

    public String getProductOrderId() {
        return productOrderId;
    }

    public void setProductOrderId(String productOrderId) {
        this.productOrderId = productOrderId;
    }

    public Enums.OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(Enums.OrderType orderType) {
        this.orderType = orderType;
    }

    public String getServiceabilityResponseId() {
        return serviceabilityResponseId;
    }

    public void setServiceabilityResponseId(String serviceabilityResponseId) {
        this.serviceabilityResponseId = serviceabilityResponseId;
    }

    public int getExpeditePriority() {
        return expeditePriority;
    }

    public void setExpeditePriority(int expeditePriority) {
        this.expeditePriority = expeditePriority;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public Enums.OrderActivity getOrderActivity() {
        return orderActivity;
    }

    public void setOrderActivity(Enums.OrderActivity orderActivity) {
        this.orderActivity = orderActivity;
    }

    public String getResquestedCompletionDate() {
        return requestedCompletionDate;
    }

    public void setResquestedCompletionDate(String requestedCompletionDate) {
        this.requestedCompletionDate = requestedCompletionDate;
    }

    public String getDateComplete() {
        return dateComplete;
    }

    public void setDateComplete(String dateComplete) {
        this.dateComplete = dateComplete;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public Enums.PricingMethod getPricingMethod() {
        return pricingMethod;
    }

    public void setPricingMethod(Enums.PricingMethod pricingMethod) {
        this.pricingMethod = pricingMethod;
    }

    public int getPricingTerm() {
        return pricingTerm;
    }

    public void setPricingTerm(int pricingTerm) {
        this.pricingTerm = pricingTerm;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Enums.OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Enums.OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(int orderItemId) {
        this.orderItemId = orderItemId;
    }

    public int getBillingInfoId() {
        return billingInfoId;
    }

    public void setBillingInfoId(int billingInfoId) {
        this.billingInfoId = billingInfoId;
    }
}
