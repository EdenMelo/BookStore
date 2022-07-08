package pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    // 订单编号
    private String id;


    // 订单总价
    private double money;


    // 送货地址
    private String receiverAddress;


    // 收货人姓名
    private String receiverName;


    // 收货人电话
    private String receiverPhone;


    // 订单状态
    private int paystate;


    // 下单时间
    private Date ordertime;


    //订单所属用户id
    private String userId;


    // 订单所属用户
    private User user;


    //订单项
    private List<OrderItem> orderItems = new ArrayList<>();

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }


    public Order(String id, double money, String receiverAddress, String receiverName, String receiverPhone, int paystate, Date ordertime, String userId, User user) {
        this.id = id;
        this.money = money;
        this.receiverAddress = receiverAddress;
        this.receiverName = receiverName;
        this.receiverPhone = receiverPhone;
        this.paystate = paystate;
        this.ordertime = ordertime;
        this.userId = userId;
        this.user = user;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", money=" + money +
                ", receiverAddress='" + receiverAddress + '\'' +
                ", receiverName='" + receiverName + '\'' +
                ", receiverPhone='" + receiverPhone + '\'' +
                ", paystate=" + paystate +
                ", ordertime=" + ordertime +
                ", userId='" + userId + '\'' +
                ", user=" + user +
                ", orderItems=" + orderItems +
                '}';
    }

    public Order(String id, double money, String receiverAddress, String receiverName, String receiverPhone, int paystate, Date ordertime, String userId, User user, List<OrderItem> orderItems) {
        this.id = id;
        this.money = money;
        this.receiverAddress = receiverAddress;
        this.receiverName = receiverName;
        this.receiverPhone = receiverPhone;
        this.paystate = paystate;
        this.ordertime = ordertime;
        this.userId = userId;
        this.user = user;
        this.orderItems = orderItems;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Order() {
    }

    public Order(String id, double money, String receiverAddress, String receiverName, String receiverPhone, int paystate, Date ordertime, User user) {
        this.id = id;
        this.money = money;
        this.receiverAddress = receiverAddress;
        this.receiverName = receiverName;
        this.receiverPhone = receiverPhone;
        this.paystate = paystate;
        this.ordertime = ordertime;
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public int getPaystate() {
        return paystate;
    }

    public void setPaystate(int paystate) {
        this.paystate = paystate;
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
