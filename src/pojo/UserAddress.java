package pojo;

public class UserAddress {
    Integer userId;
    String address;

    @Override
    public String toString() {
        return "UserAddress{" +
                "userId=" + userId +
                ", address='" + address + '\'' +
                '}';
    }

    public UserAddress() {
    }

    public UserAddress(Integer userId, String address) {
        this.userId = userId;
        this.address = address;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
