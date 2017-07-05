package model.OrderModel;


import model.ServiceabilityModel.EthernetServiceabilityRequestItem;

public class OrderItem {
    //private Enums.OrderItemStatus orderStatus;
    private Enums.OrderItemAction orderItemAction;
    private Product product;


    public OrderItem(Enums.OrderItemAction orderItemAction, Product product) {
        this.orderItemAction = orderItemAction;
        this.product=product;
    }

    public Enums.OrderItemAction getOrderItemAction() {
        return orderItemAction;
    }

    public void setOrderItemAction(Enums.OrderItemAction orderItemAction) {
        this.orderItemAction = orderItemAction;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}