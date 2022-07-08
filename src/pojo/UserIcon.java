package pojo;

public class UserIcon {
    private String userId;

    private String userIconUrl;

    public UserIcon() {
    }

    public UserIcon(String userId, String userIconUrl) {
        this.userId = userId;
        this.userIconUrl = userIconUrl;
    }

    @Override
    public String toString() {
        return "UserIcon{" +
                "userId='" + userId + '\'' +
                ", userIconUrl='" + userIconUrl + '\'' +
                '}';
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserIconUrl() {
        return userIconUrl;
    }

    public void setUserIconUrl(String userIconUrl) {
        this.userIconUrl = userIconUrl;
    }
}
