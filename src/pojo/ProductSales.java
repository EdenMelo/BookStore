package pojo;

public class ProductSales {

    private String productId;

    private String productName;

    private Integer productSale;

    private String latestSaleDate;

    @Override
    public String toString() {
        return "ProductSales{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", productSale=" + productSale +
                ", latestSaleDate='" + latestSaleDate + '\'' +
                '}';
    }

    public ProductSales() {
    }

    public ProductSales(String productId, String productName, Integer productSale, String latestSaleDate) {
        this.productId = productId;
        this.productName = productName;
        this.productSale = productSale;
        this.latestSaleDate = latestSaleDate;
    }

    public String getLatestSaleDate() {
        return latestSaleDate;
    }

    public void setLatestSaleDate(String latestSaleDate) {
        this.latestSaleDate = latestSaleDate;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductSale() {
        return productSale;
    }

    public void setProductSale(Integer productSale) {
        this.productSale = productSale;
    }


}
