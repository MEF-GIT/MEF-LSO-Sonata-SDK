package model.ServiceabilityModel;

/**
 * Created by Rami9 on 12/06/2017.
 */
public class ServiceabilityConfidence {
    private Enums.ConfidenceColor color;
    private String estimatedResponseDate;
    private String reason;

    public ServiceabilityConfidence(){

    }
    public ServiceabilityConfidence(Enums.ConfidenceColor color, String estimatedResponseDate, String reason) {
        this.color = color;
        this.estimatedResponseDate = estimatedResponseDate;
        this.reason = reason;
    }

    public Enums.ConfidenceColor getColor() {
        return color;
    }
    public ServiceabilityConfidence setRedColor(){
        this.setColor(Enums.ConfidenceColor.RED);
        return this;
    }
    public ServiceabilityConfidence setGreenColor(){
        this.setColor(Enums.ConfidenceColor.GREEN);
        return this;
    }
    public void setColor(Enums.ConfidenceColor color) {
        this.color = color;
    }

    public String getEstimatedResponseDate() {
        return estimatedResponseDate;
    }

    public void setEstimatedResponseDate(String estimatedResponseDate) {
        this.estimatedResponseDate = estimatedResponseDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
