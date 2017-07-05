package model.ServiceabilityModel;


public class Enums {

    public enum AccessMedium{
        FIBER,COAX,TWISTED_PAIR
    }
    public enum ClassOfService{
        HIGH,MEDIUM,LOW
    }
    public enum ProductCategory{
        ETHERNET
    }
    public enum ProductType{
        UNI,ACCESS_EPL,ACCESS_EVPL
    }
    public enum InterfaceType{
        ELECTRICAL,OPTICAL
    }
    public enum SiteAddressType{
        FORMATTED,FIELDED,REFERENCED,GEOCRAPHIC
    }
    public enum ServiceabilityRequestStatus{
        SUBMITTED,COMPLETED,FAILED,CANCELLED
    }
    public enum ServiceabilityResponseStatus{
        SUBMITTED,COMPLETED,UNDER_REVIEW,REJECTED,DRAFT,ACCEPTED
    }
    public enum ConfidenceColor{
        GREEN,YELLOW,RED
    }
    public enum AccessTechnology{
        BONDED_COPPER,DIRECT_FIBER,DOCSIS_3_0,DOCSIS_3_1,DSL,PACKET_MICROWAVE,PON,SONET_SDH,TDM,WDM
    }
}
