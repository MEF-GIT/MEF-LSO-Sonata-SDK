package model.ServiceabilityModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.json.JSONException;
import org.json.JSONObject;

public class Address {
    private GeoCode geoCode;
    public Address(GeoCode geoCode) {
        this.geoCode = geoCode;
    }

    public Address() {

    }

    @JsonProperty("GeoCode")
    public GeoCode getGeoCode() {
        return geoCode;
    }

    public void setGeoCode(GeoCode geoCode) {
        this.geoCode = geoCode;
    }
    public void jsonToAddress(String data) throws JSONException {
        JSONObject jsonObject=new JSONObject(data);
        String latitude=jsonObject.getJSONObject("EthernetServiceabilityRequestItem")
                .getJSONObject("address").getJSONObject("GeoCode").getString("latitude");
        String longitude=jsonObject.getJSONObject("EthernetServiceabilityRequestItem")
                .getJSONObject("address").getJSONObject("GeoCode").getString("longitude");
        GeoCode geoCode=new GeoCode(latitude,longitude);
        this.setGeoCode(geoCode);
    }
}
