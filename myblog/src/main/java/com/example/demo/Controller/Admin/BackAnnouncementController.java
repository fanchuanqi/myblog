package com.example.demo.Controller.Admin;

import com.example.demo.Pojo.Announcement;
import com.example.demo.Service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @author niwang
 * @Date 3/7
 */
@RestController("/back")
public class BackAnnouncementController {
    @Autowired
    private AnnouncementService announcementService;

    /**
     * 后台公告列表显示
     *
     * @return
     */
    @RequestMapping(value = "/announcement")
    public List<Announcement> index(Model model) {
        return announcementService.listAnnouncement(null);
    }

    /**
     * 添加公告
     *
     * @return
     */
    @RequestMapping(value = "/announcement/insert")
    public void insertAnnouncement(Announcement announcement) {
        announcementService.insertAnnouncement(announcement);
    }

    /**
     * 删除公告
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/announcement/delete}")
    public void deleteAnnouncement(Integer id) {
        announcementService.deleteAnnouncement(id);
    }

    /**
     * 根据Id获取公告内容
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/announcement/edit")
    public Announcement editAnnouncementView(Integer id) {
        Announcement announcement = announcementService.getAnnouncementById(id);
        return announcement;
    }


    /**
     * 编辑公告页面显示
     *
     * @param announcement
     * @return
     */
    @RequestMapping(value = "/announcement/editSubmit", method = RequestMethod.POST)
    public void editAnnouncementSubmit(Announcement announcement) {
        announcement.setAnnouncementUpdateTime(new Date());
        announcementService.updateAnnouncement(announcement);
    }
}
