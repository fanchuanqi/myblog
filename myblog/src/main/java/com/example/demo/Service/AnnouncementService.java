package com.example.demo.Service;

import com.example.demo.Pojo.Announcement;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author niwang
 * @Date 3/6
 */
@Service
public interface AnnouncementService {
    /**
     * 获得公告列表
     *
     * @param status 状态
     * @return 列表
     */
    List<Announcement> listAnnouncement(Integer status);

    /**
     * 添加公告
     *
     * @param announcement 公告
     */
    void insertAnnouncement(Announcement announcement);

    /**
     * 删除公告
     *
     * @param id
     */
    void deleteAnnouncement(Integer id);

    /**
     * 更新公告
     *
     * @param announcement
     */
    void updateAnnouncement(Announcement announcement);

    /**
     * 根据id查询公告
     *
     * @param id ID
     * @return 公告
     */
    Announcement getAnnouncementById(Integer id);
}
