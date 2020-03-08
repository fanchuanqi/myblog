package com.example.demo.Service.Impl;

import com.example.demo.Mapper.AnnouncementMapper;
import com.example.demo.Pojo.Announcement;
import com.example.demo.Service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class AnnouncementServiceImpl implements AnnouncementService {
    @Autowired
    private AnnouncementMapper announcementMapper;


    @Override
    public List<Announcement> listAnnouncement(Integer status) {
        return announcementMapper.listannouncement(status);
    }

    @Override
    public void insertAnnouncement(Announcement announcement) {
        announcementMapper.insert(announcement);
    }

    @Override
    public void deleteAnnouncement(Integer id) {
        announcementMapper.deleteById(id);
    }

    @Override
    public void updateAnnouncement(Announcement announcement) {
        announcementMapper.update(announcement);
    }

    @Override
    public Announcement getAnnouncementById(Integer id) {
        return announcementMapper.getannouncementById(id);
    }
}
