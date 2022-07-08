package test;

import org.junit.Test;
import pojo.Notice;
import service.NoticeService;
import service.impl.NoticeServiceImpl;
import utils.JdbcUtils;

import java.util.Date;
import java.util.List;

public class NoticeServiceTest {
    NoticeService noticeService = new NoticeServiceImpl();

    @Test
    public void testFindAllNotice() {
        List<Notice> allNotice = noticeService.findAllNotice();
        allNotice.forEach(System.out::println);
    }

    @Test
    public void testAddNotice() {
        //获取Date类型的当前系统时间
        Date date = new Date();

        Notice notice = new Notice(null,"新增测试1","测试添加",date);
        int i = noticeService.addNotice(notice);
        System.out.println(i);
        JdbcUtils.commitAndClose();
    }

    @Test
    public void testDeleteNotice() {
        int i = noticeService.deleteNotice(4);
        System.out.println(i);
        JdbcUtils.commitAndClose();
    }

    @Test
    public void testUpdateNotice() {
        Notice notice = new Notice(1,"新增测试2","测试添加",new Date());
        int i = noticeService.updateNotice(notice);
        System.out.println(i);
        JdbcUtils.commitAndClose();
    }

    @Test
    public void testFindNewNotice(){
        List<Notice> list = noticeService.findNewNotice();
        list.forEach(System.out::println);
    }
}
