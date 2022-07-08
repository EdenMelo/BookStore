package test;

import dao.NoticeDao;
import dao.impl.NoticeDaoImpl;
import org.junit.Test;
import pojo.Notice;
import utils.JdbcUtils;

import java.util.Date;
import java.util.List;

public class NoticeDaoTest {
    NoticeDao noticeDao = new NoticeDaoImpl();

    @Test
    public void testQueryAllNotice() {
        List<Notice> list = noticeDao.queryAllNotice();
        list.forEach(System.out::println);
    }

    @Test
    public void testAddNotice() {
        //获取Date类型的当前系统时间
        Date date = new Date();

        Notice notice = new Notice(null,"新增测试1","测试添加",date);
        int i = noticeDao.addNotice(notice);
        System.out.println(i);
        JdbcUtils.commitAndClose();
    }

    @Test
    public void testDeleteNotice() {
        int i = noticeDao.deleteNotice(3);
        System.out.println(i);
        JdbcUtils.commitAndClose();
    }

    @Test
    public void testUpdateNotice() {
        Notice notice = new Notice(1,"新增测试1","测试添加",new Date());
        int i = noticeDao.updateNotice(notice);
        System.out.println(i);
        JdbcUtils.commitAndClose();
    }

    @Test
    public void testQueryNewNotice(){
        List<Notice> list = noticeDao.queryNewNotice();
        list.forEach(System.out::println);
    }

    @Test
    public void queryNoticeById(){
        Notice notice = noticeDao.queryNoticeById(13);
        System.out.println(notice);
    }


}
