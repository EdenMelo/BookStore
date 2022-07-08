package dao;

import pojo.Notice;

import java.util.List;

public interface NoticeDao {
    /**查询所有公告信息*/
    List<Notice> queryAllNotice();

    /**添加公告信息*/
    int addNotice(Notice notice);

    /**删除公告信息*/
    int deleteNotice(int noticeId);

    /**更新公告信息*/
    int updateNotice(Notice notice);

    /**查询最新的五条公告信息*/
    List<Notice> queryNewNotice();

    /**根据公告id查看公告详情*/
    Notice queryNoticeById(int noticeId);

}
