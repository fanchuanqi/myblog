package com.example.demo.Mapper;


import com.example.demo.Pojo.Announcement;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ni.wang
 * @Date 3/6
 */
public interface AnnouncementMapper {
    /**
     * 根据ID删除
     *
     * @param announcementId 公告ID
     * @return 影响行数
     */
    int deleteById(Integer announcementId);

    /**
     * 添加
     *
     * @param announcement 公告
     * @return 影响行数
     */
    int insert(Announcement announcement);

    /**
     * 根据ID查询
     *
     * @param announcementId 公告ID
     * @return 公告
     */
    Announcement getannouncementById(Integer announcementId);

    /**
     * 获得公告列表
     *
     * @param announcement 公告
     * @return 影响行数
     */
    int update(Announcement announcement);

    /**
     * 获得公告列表
     *
     * @param announcement 公告
     * @return 影响行数
     */
    int updateByPrimaryKey(Announcement announcement);

    /**
     * 获得公告总数
     *
     * @param status 状态
     * @return 影响行数
     */
    Integer countAnnouncement(@Param(value = "status") Integer status);

    /**
     * 获得公告列表
     *
     * @param status 状态
     * @return 公告列表
     */
    List<Announcement> listannouncement(@Param(value = "status") Integer status);
}
