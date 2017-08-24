package model.ServiceabilityModel;

/**
 * Created by Rami9 on 12/06/2017.
 */
public class EthernetProductSpec extends ProductSpec {
    private String bandwidth;
    private Enums.AccessMedium accessMedium;
    private Enums.ClassOfService classOfService;
    private Enums.ProductCategory productCategory;
    private Enums.ProductType productType;
    private String orgClassOfServiceName;
    private Enums.AccessTechnology accessTechnology;
    private int mtuSize;
    private boolean colorForwarding;
    private ServiceSite enniLocation;
    private String productSpecId;
    private String productName;
    private String productCode;

    public EthernetProductSpec(String productSpecId, String productName, String productCode, Enums.ProductType productType,
                               Enums.ProductCategory productCategory, String bandwidth, Enums.AccessMedium accessMedium, Enums.ClassOfService classOfService, Enums.ProductCategory productCategory1, Enums.ProductType productType1, String orgClassOfServiceName, Enums.AccessTechnology accessTechnology, int mtuSize, boolean colorForwarding,
                               ServiceSite enniLocation, String productSpecId1, String productName1, String productCode1) {
        super(productSpecId, productName, productCode, productType, productCategory);
        this.bandwidth = bandwidth;
        this.accessMedium = accessMedium;
        this.classOfService = classOfService;
        this.productCategory = productCategory1;
        this.productType = productType1;
        this.orgClassOfServiceName = orgClassOfServiceName;
        this.accessTechnology = accessTechnology;
        this.mtuSize = mtuSize;
        this.colorForwarding = colorForwarding;
        this.enniLocation = enniLocation;
        this.productSpecId = productSpecId1;
        this.productName = productName1;
        this.productCode = productCode1;
    }

    public String getBandwidth() {
        return bandwidth;
    }

    public void setBandwidth(String bandwidth) {
        this.bandwidth = bandwidth;
    }

    public Enums.AccessMedium getAccessMedium() {
        return accessMedium;
    }

    public void setAccessMedium(Enums.AccessMedium accessMedium) {
        this.accessMedium = accessMedium;
    }

    public Enums.ClassOfService getClassOfService() {
        return classOfService;
    }

    public void setClassOfService(Enums.ClassOfService classOfService) {
        this.classOfService = classOfService;
    }

    @Override
    public Enums.ProductCategory getProductCategory() {
        return productCategory;
    }

    @Override
    public void setProductCategory(Enums.ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    @Override
    public Enums.ProductType getProductType() {
        return productType;
    }

    @Override
    public void setProductType(Enums.ProductType productType) {
        this.productType = productType;
    }

    public String getOrgClassOfServiceName() {
        return orgClassOfServiceName;
    }

    public void setOrgClassOfServiceName(String orgClassOfServiceName) {
        this.orgClassOfServiceName = orgClassOfServiceName;
    }

    public Enums.AccessTechnology getAccessTechnology() {
        return accessTechnology;
    }

    public void setAccessTechnology(Enums.AccessTechnology accessTechnology) {
        this.accessTechnology = accessTechnology;
    }

    public int getMtuSize() {
        return mtuSize;
    }

    public void setMtuSize(int mtuSize) {
        this.mtuSize = mtuSize;
    }

    public boolean isColorForwarding() {
        return colorForwarding;
    }

    public void setColorForwarding(boolean colorForwarding) {
        this.colorForwarding = colorForwarding;
    }

    public ServiceSite getEnniLocation() {
        return enniLocation;
    }

    public void setEnniLocation(ServiceSite enniLocation) {
        this.enniLocation = enniLocation;
    }

    @Override
    public String getProductSpecId() {
        return productSpecId;
    }

    @Override
    public void setProductSpecId(String productSpecId) {
        this.productSpecId = productSpecId;
    }

    @Override
    public String getProductName() {
        return productName;
    }

    @Override
    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String getProductCode() {
        return productCode;
    }

    @Override
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
}
