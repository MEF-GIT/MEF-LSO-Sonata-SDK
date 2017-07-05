package model.OrderModel;

public class Enums {
    public enum OrderType{
        UNI,ACCESS_EPL,ACCESS_EVPL
    }
    public enum OrderActivity{
        INSTALL,CHANGE,DISCONNECT
    }
    public enum PricingMethod{
        TARIFF,CONTRACT,INDIVIDUAL_CASE_BASIS,OTHER
    }
    public enum OrderStatus{
        PENDING,IN_PROGRESS,HELD, ACKNOWLEDGED,REJECTED,CANCELLED,COMPLETED,FAILED
    }
    public enum OrderItemAction{
        ADD,CHANGE,DELETE
    }
}
