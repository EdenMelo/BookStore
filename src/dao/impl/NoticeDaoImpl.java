package dao.impl;

import dao.NoticeDao;
import pojo.Notice;

import java.util.List;

public class NoticeDaoImpl extends BaseDao implements NoticeDao {
    @Override
    public List<Notice> queryAllNotice() {
        String sql = "select n_id noticeId, title noticeTitle, " +
                "details noticeDetails, n_time noticeTime" +
                " from notice";
        return queryForList(Notice.class,sql);
    }

    @Override
    public int addNotice(Notice notice) {
        String sql = "insert into notice values(?,?,?,?)";
        return update(sql,null,notice.getNoticeTitle(),notice.getNoticeDetails(),notice.getNoticeTime());
    }

    @Override
    public int deleteNotice(int noticeId) {
        String sql = "delete from notice where n_id = ?";
        return update(sql,noticeId);
    }

    @Override
    public int updateNotice(Notice notice) {
        String sql = "update notice set title = ?, details = ?, n_time = ? where n_id = ?";
        return update(sql,notice.getNoticeTitle(),notice.getNoticeDetails(),notice.getNoticeTime(),notice.getNoticeId());
    }

    @Override
    public List<Notice> queryNewNotice() {
        String sql = "select n_id noticeId, title noticeTitle, " +
                "details noticeDetails, n_time noticeTime" +
                " from notice order by n_time desc limit 5";
        return queryForList(Notice.class,sql);
    }

    @Override
    public Notice queryNoticeById(int noticeId) {
        String sql = "select n_id noticeId, title noticeTitle, " +
                "details noticeDetails, n_time noticeTime" +
                " from notice where n_id = ?";
        return queryForOne(Notice.class,sql,noticeId);
    }
}
