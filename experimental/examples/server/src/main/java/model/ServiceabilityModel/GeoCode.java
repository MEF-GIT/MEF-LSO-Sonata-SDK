package model.ServiceabilityModel;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Rami9 on 06/06/2017.
 */
public class GeoCode {
    private String latitude;
    private String  longitude;

    public GeoCode(String latitude,String longitude){
        this.latitude=latitude;
        this.longitude=longitude;
    }
    @JsonProperty("latitude")
    public String  getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
    @JsonProperty("longitude")
    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
