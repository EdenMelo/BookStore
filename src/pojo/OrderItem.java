package pojo;

public class OrderItem {
    //订单
    private Order order;


    //产品
    private Product p;


    //产品id
    private String productId;


    //单个商品的购买数量
    private int buynum;


    @Override
    public String toString() {
        return "OrderItem{" +
                "order=" + order +
                ", p=" + p +
                ", productId=" + productId +
                ", buynum=" + buynum +
                '}';
    }

    public OrderItem() {
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public OrderItem(Order order, Product p, int buynum) {
        this.order = order;
        this.p = p;
        this.buynum = buynum;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getP() {
        return p;
    }

    public void setP(Product p) {
        this.p = p;
    }

    public int getBuynum() {
        return buynum;
    }

    public void setBuynum(int buynum) {
        this.buynum = buynum;
    }
}
