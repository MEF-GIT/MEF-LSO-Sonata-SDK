package com.SonataR1;

import com.sun.org.apache.regexp.internal.RE;
import model.OrderModel.BillingInfo;
import model.OrderModel.Product;
import model.OrderModel.ProductOrder;
import model.ServiceabilityModel.ServiceabilityResponse;
import org.json.JSONException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.*;

@SuppressWarnings("Duplicates")
@Path("/api/OrderManagement")
public class ProductOrdering {

    @Path("/productOrder")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response CreateNewOrder(String data) throws SQLException, JSONException, ClassNotFoundException {
        ProductOrder productOrder=jsonToProductOrder(data);
        int billingInfoId=addBillingInfo(productOrder.getBillingInfo());
        productOrder.setBillingInfoId(billingInfoId);
        addProductOrderToDB(productOrder);
       return Response.status(201).entity("").header("orderId",productOrder.getProductOrderId()).build();
    }

    private ProductOrder jsonToProductOrder(String data) throws JSONException, SQLException, ClassNotFoundException {
        ProductOrder productOrder=new ProductOrder();
        productOrder.jsonToProductOrder(data);
        return productOrder;
    }

    private void addProductOrderToDB(ProductOrder productOrder)
            throws SQLException, ClassNotFoundException {
        Connection connection=connectToDB();
        Statement stresult = connection.createStatement();
        stresult.executeUpdate(
                "INSERT into serviceability.productorder" +
                        "(productOrderId, orderItemId, billingInfoId, serviceabilityResponseId, orderDate, orderActivity, orderStatus, requestedCompletionDate, pricingMethod)" +
                        "VALUES ('"+productOrder.getProductOrderId()+"','"+productOrder.getOrderItem().getProduct().getProductId()+"','"
                        +productOrder.getBillingInfoId()+"','"+
                        productOrder.getServiceabilityResponseId()+"','"+
                        productOrder.getOrderDate()+"','"+
                        productOrder.getOrderActivity()+"','"+
                        productOrder.getOrderStatus()+"','"+
                        productOrder.getResquestedCompletionDate()+"','"+
                        productOrder.getPricingMethod()+"') "
        );

    }
    private int addBillingInfo(BillingInfo billingInfo) throws SQLException, ClassNotFoundException {
        Connection connection=connectToDB();
        Statement stresult = connection.createStatement();
        stresult.executeUpdate(
                "INSERT into serviceability.billinginfo" +
                        "(latitude, longitude, email, telephone, contactName)" +
                        "VALUES ('"+billingInfo.getAddress().getGeoCode().getLatitude()+"','"+billingInfo.getAddress().getGeoCode().getLongitude()+"','"
                        +billingInfo.getContact().getEmailAddress()+"','"+
                        billingInfo.getContact().getTelephoneNumber()+"','"+
                        billingInfo.getContact().getContactName()+"') "
        );
        Statement id=connection.createStatement();
        ResultSet resultSet=id.executeQuery(
                "SELECT MAX(billingInfoId) AS MAXID FROM serviceability.billinginfo"
        );
        resultSet.next();
        return resultSet.getInt("MAXID");
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

}
