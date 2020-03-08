package com.example.demo.Controller.Homepage;


import com.example.demo.DTO.RespBean;
import com.example.demo.Enum.ArticleStatus;
import com.example.demo.Pojo.*;
import com.example.demo.Service.*;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author niwang
 * @Date 3/7
 */
@RestController
public class AnnouncementController {
    @Autowired
    private AnnouncementService announcementService;

    @Autowired
    private ArticleService articleService;

    /**
     * 公告详情页显示
     *
     * @param announcementId
     * @return Announcement
     */
    @RequestMapping(value = "/notice")
    public Announcement NoticeDetailView(Integer announcementId) {
        //公告内容和信息显示
       return announcementService.getAnnouncementById(announcementId);
    }
}
