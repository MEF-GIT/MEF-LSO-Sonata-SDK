package model.OrderModel;

import model.ServiceabilityModel.EthernetServiceabilityRequestItem;
import model.ServiceabilityModel.ProductSpec;
import model.ServiceabilityModel.ServiceSite;

public class Product {
    private ServiceSite serviceSite;
    private int productId;
    private ProductSpec productSpec;
    private EthernetServiceabilityRequestItem ethernetServiceabilityRequestItem;

    public Product(ServiceSite serviceSite, int productId, ProductSpec productSpec, EthernetServiceabilityRequestItem ethernetServiceabilityRequestItem) {
        this.setServiceSite(serviceSite);
        this.setProductId(productId);
        this.setProductSpec(productSpec);
        this.setEthernetServiceabilityRequestItem(ethernetServiceabilityRequestItem);
    }

    public ServiceSite getServiceSite() {
        return serviceSite;
    }

    public void setServiceSite(ServiceSite serviceSite) {
        this.serviceSite = serviceSite;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public ProductSpec getProductSpec() {
        return productSpec;
    }

    public void setProductSpec(ProductSpec productSpec) {
        this.productSpec = productSpec;
    }

    public EthernetServiceabilityRequestItem getEthernetServiceabilityRequestItem() {
        return ethernetServiceabilityRequestItem;
    }

    public void setEthernetServiceabilityRequestItem(EthernetServiceabilityRequestItem ethernetServiceabilityRequestItem) {
        this.ethernetServiceabilityRequestItem = ethernetServiceabilityRequestItem;
    }
}
