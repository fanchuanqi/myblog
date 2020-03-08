package com.example.demo.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Announcement implements Serializable {
    private  static final long serialVersionUID = -5462258703523903527L;

    private String id;
    private Integer announcementId;

    private String announcementTitle;
    private String announcementContent;

    private Date announcementCreateTime;

    private Date announcementUpdateTime;

    private Integer announcementStatus;

    private Integer announcementOrder;

}
