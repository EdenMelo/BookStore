package pojo;

public class Collections {
    private String productId;

    private String userId;

    @Override
    public String toString() {
        return "Collections{" +
                "productId='" + productId + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }

    public Collections() {
    }

    public Collections(String productId, String userId) {
        this.productId = productId;
        this.userId = userId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
