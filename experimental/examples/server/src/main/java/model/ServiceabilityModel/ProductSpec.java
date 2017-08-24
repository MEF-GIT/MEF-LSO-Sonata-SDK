package model.ServiceabilityModel;

/**
 * Created by Rami9 on 12/06/2017.
 */
public class ProductSpec {
    private String productSpecId;
    private String productName;
    private String productCode;
    private Enums.ProductType productType;
    private Enums.ProductCategory productCategory;

    public ProductSpec(String productSpecId, String productName,
                       String productCode, Enums.ProductType productType, Enums.ProductCategory productCategory) {
        this.productSpecId = productSpecId;
        this.productName = productName;
        this.productCode = productCode;
        this.productType = productType;
        this.productCategory = productCategory;
    }

    public String getProductSpecId() {
        return productSpecId;
    }

    public void setProductSpecId(String productSpecId) {
        this.productSpecId = productSpecId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public Enums.ProductType getProductType() {
        return productType;
    }

    public void setProductType(Enums.ProductType productType) {
        this.productType = productType;
    }

    public Enums.ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(Enums.ProductCategory productCategory) {
        this.productCategory = productCategory;
    }
}
