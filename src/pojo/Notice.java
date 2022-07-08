package pojo;
import java.util.Date;

public class Notice {

    private Integer noticeId;

    private String noticeTitle;

    private String noticeDetails;

    private Date noticeTime;

    @Override
    public String toString() {
        return "Notice{" +
                "noticeId=" + noticeId +
                ", noticeTitle='" + noticeTitle + '\'' +
                ", noticeDetails='" + noticeDetails + '\'' +
                ", noticeTime=" + noticeTime +
                '}';
    }

    public Notice() {
    }

    public Notice(Integer noticeId, String noticeTitle, String noticeDetails, Date noticeTime) {
        this.noticeId = noticeId;
        this.noticeTitle = noticeTitle;
        this.noticeDetails = noticeDetails;
        this.noticeTime = noticeTime;
    }

    public Integer getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Integer noticeId) {
        this.noticeId = noticeId;
    }

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }

    public String getNoticeDetails() {
        return noticeDetails;
    }

    public void setNoticeDetails(String noticeDetails) {
        this.noticeDetails = noticeDetails;
    }

    public Date getNoticeTime() {
        return noticeTime;
    }

    public void setNoticeTime(Date noticeTime) {
        this.noticeTime = noticeTime;
    }
}
