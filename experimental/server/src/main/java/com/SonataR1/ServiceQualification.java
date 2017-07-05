package com.SonataR1;
import model.ServiceabilityModel.*;
import org.json.JSONException;
import org.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.*;
import java.text.ParseException;

@SuppressWarnings("Duplicates")
@Path("/api/address")
public class ServiceQualification {
    private String responseId;

    @Path("/validate")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response createDataInJSON(String data) throws JSONException, SQLException, ClassNotFoundException {
        JSONObject jsonObject=new JSONObject(data);
        String latitude=jsonObject.getJSONObject("address").getJSONObject("GeoCode").getString("latitude");
        String longitude=jsonObject.getJSONObject("address").getJSONObject("GeoCode").getString("longitude");
        Address address=new Address(new GeoCode(latitude,longitude));
        if(validateAddress(address)){
            String result = " Valid Address\n"+data+"\n";
            return Response.status(201).entity(result).build();
        }
        else{
            String result = " Not Valid Address:\n"+data;
            return Response.status(404).entity(result).build();
        }
    }
    @Path("/ServiceQualification")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response ServiceQualification(String data) throws JSONException, SQLException, ClassNotFoundException, ParseException {
        int statusCode;
        String result;
        EthernetServiceabilityRequestItem esri=jsonToESRI(data);
        ServiceabilityRequest serviceabilityRequest=
                new ServiceabilityRequest(esri.getServiceSite(),esri);
        ServiceabilityResponse serviceabilityResponse=new ServiceabilityResponse(serviceabilityRequest,serviceabilityRequest.getServiceSite());
        serviceabilityRequest.setServiceabilityResponse(serviceabilityResponse);
        if(!validateServiceability(serviceabilityRequest)){
            serviceabilityResponse.setServiceabilityConfidence(new ServiceabilityConfidence(Enums.ConfidenceColor.RED,null,null));
             statusCode=400;
             result = "We cannot deliver the service you requested:\n";
        }
        else{
            serviceabilityResponse.setServiceabilityConfidence(new ServiceabilityConfidence(Enums.ConfidenceColor.GREEN,null,null));
            statusCode=201;
            result = "The Service you requested is accepted.\n "+data;
        }
        serviceabilityResponse.setServiceabilityResponseStatus(Enums.ServiceabilityResponseStatus.COMPLETED);
        serviceabilityRequest.setServiceRequestStatus(Enums.ServiceabilityRequestStatus.COMPLETED);
        addServiceabilityRequestToDB(serviceabilityRequest);
        addServiceabilityResponseToDB(serviceabilityResponse);
        return Response.status(statusCode).entity(result).header("price",serviceabilityRequest.getEthernetServiceabilityRequestItem().getPrice()).header("responseId",serviceabilityResponse.getServiceabilityResponseId()).build();

    }
    private Address jsonToAddress(String data) throws JSONException {
        Address address=new Address();
        address.jsonToAddress(data);
        return address;
    }
    private EthernetServiceabilityRequestItem jsonToESRI(String data) throws JSONException, ParseException {
        EthernetServiceabilityRequestItem eSRI=new EthernetServiceabilityRequestItem();
        eSRI.jsonToESRI(data);
        return eSRI;
    }
    private boolean validateServiceability(ServiceabilityRequest serviceabilityRequest) throws ClassNotFoundException, SQLException {
        boolean isvalid;
        Connection connection=connectToDB();
        Statement stresult = connection.createStatement();
        ResultSet location = stresult.executeQuery(
                "SELECT ItemId,price FROM serviceability.ethernetserviceabilityrequestitems" +
                        " WHERE latitude='"+serviceabilityRequest.getEthernetServiceabilityRequestItem().getServiceSite().getAddress().getGeoCode().getLatitude()+"'"
                        + "AND longitude='"+serviceabilityRequest.getEthernetServiceabilityRequestItem().getServiceSite().getAddress().getGeoCode().getLongitude()+"'"
                        +"AND bandwidth='"+serviceabilityRequest.getEthernetServiceabilityRequestItem().getBandwidth()+"'"
                        +"AND maxPortSpeed='"+serviceabilityRequest.getEthernetServiceabilityRequestItem().getMaxPortSpeed()+"'"
                        +"AND accessMedium='"+serviceabilityRequest.getEthernetServiceabilityRequestItem().getAccessMedium()+"'"
                        +"AND classOfService='"+serviceabilityRequest.getEthernetServiceabilityRequestItem().getClassOfService()+"'"
                        +"AND productCategory='"+serviceabilityRequest.getEthernetServiceabilityRequestItem().getProductCategory()+"'"
                        +"AND productType='"+serviceabilityRequest.getEthernetServiceabilityRequestItem().getProductType()+"'"
                        +"AND pricingTerm='"+serviceabilityRequest.getEthernetServiceabilityRequestItem().getPricingTerm()+"'"
                        +"AND date='"+serviceabilityRequest.getEthernetServiceabilityRequestItem().getDesiredActivationDate()+"'"
        );
        isvalid=(location.next());
        if(isvalid){
            int ItemId=location.getInt("ItemId");
            serviceabilityRequest.setItemId(ItemId);
            int price=location.getInt("price");
            serviceabilityRequest.getEthernetServiceabilityRequestItem().setPrice(price);
            serviceabilityRequest.getServiceabilityResponse().setItemId(ItemId);
        }
        location.close();
        return isvalid;
    }
    private boolean validateAddress(Address address) throws SQLException, ClassNotFoundException {
        boolean isvalid;
        Connection connection=connectToDB();
        Statement stresult = connection.createStatement();
        ResultSet location = stresult.executeQuery(
                "SELECT * FROM GeoCodes WHERE latitude='"+address.getGeoCode().getLatitude()+"'"
                        + "AND longitude='"+address.getGeoCode().getLongitude()+"'"
        );
        isvalid=(location.next());
        location.close();
        return isvalid;
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
    private void addServiceabilityRequestToDB(ServiceabilityRequest serviceabilityRequest) throws SQLException, ClassNotFoundException {
        Connection connection=connectToDB();
        Statement stresult = connection.createStatement();
      stresult.executeUpdate(
               "INSERT into serviceability.serviceabilityrequest" +
                       "( serviceabilityRequestStatus, serviceabilityRequestId, latitude, longitude, serviceabilityResponseId, ItemId)" +
                       "VALUES ('"+serviceabilityRequest.getServiceRequestStatus()+"','"+serviceabilityRequest.getServiceabilityRequestId()+"','"
                       +serviceabilityRequest.getServiceSite().getAddress().getGeoCode().getLatitude()+"','"+
                       serviceabilityRequest.getServiceSite().getAddress().getGeoCode().getLongitude()+"','"+
                       serviceabilityRequest.getServiceabilityResponse().getServiceabilityResponseId()+"','"+
                       serviceabilityRequest.getItemId()+"') "
        );
    }
    private void addServiceabilityResponseToDB(ServiceabilityResponse serviceabilityResponse)
            throws SQLException, ClassNotFoundException {
        Connection connection=connectToDB();
        Statement stresult = connection.createStatement();
         stresult.executeUpdate(
                "INSERT into serviceability.serviceabilityresponse" +
                        "(serviceabilityResponseStatus, serviceabilityResponseId, latitude, longitude, serviceabilityRequestId,Color, ItemId)" +
                        "VALUES ('"+serviceabilityResponse.getServiceabilityResponseStatus()+"','"+serviceabilityResponse.getServiceabilityResponseId()+"','"
                        +serviceabilityResponse.getServiceSite().getAddress().getGeoCode().getLatitude()+"','"+
                        serviceabilityResponse.getServiceSite().getAddress().getGeoCode().getLongitude()+"','"+
                        serviceabilityResponse.getServiceabilityRequest().getServiceabilityRequestId()+"','"+
                        serviceabilityResponse.getServiceabilityConfidence().getColor()+"','"+
                        serviceabilityResponse.getItemId()+"') "
        );

    }
}