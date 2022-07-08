package service.impl;

import dao.NoticeDao;
import dao.impl.NoticeDaoImpl;
import pojo.Notice;
import service.NoticeService;
import utils.JdbcUtils;

import java.util.List;

public class NoticeServiceImpl implements NoticeService {

    NoticeDao noticeDao = new NoticeDaoImpl();

    @Override
    public List<Notice> findAllNotice() {
        List<Notice> list = noticeDao.queryAllNotice();
        JdbcUtils.commitAndClose();
        return list;
    }

    @Override
    public int addNotice(Notice notice) {
        int i = noticeDao.addNotice(notice);
        if (i == 1) {
            JdbcUtils.commitAndClose();
        } else {
            JdbcUtils.rollbackAndClose();
        }
        return i;
    }

    @Override
    public int deleteNotice(int noticeId) {
        int i = noticeDao.deleteNotice(noticeId);
        if (i == 1) {
            JdbcUtils.commitAndClose();
        } else {
            JdbcUtils.rollbackAndClose();
        }
        return i;
    }

    @Override
    public int updateNotice(Notice notice) {
        int i = noticeDao.updateNotice(notice);
        if(i==1){
            JdbcUtils.commitAndClose();
        }else{
            JdbcUtils.rollbackAndClose();
        }
        return i;
    }

    @Override
    public List<Notice> findNewNotice() {
        List<Notice> list = noticeDao.queryNewNotice();
        JdbcUtils.commitAndClose();
        return list;
    }

    @Override
    public Notice findNoticeById(int noticeId) {
        Notice notice = noticeDao.queryNoticeById(noticeId);
        return notice;
    }
}
