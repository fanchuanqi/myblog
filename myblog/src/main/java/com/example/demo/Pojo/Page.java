package com.example.demo.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author
 * @Date 3/6
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Page {

    private String id;
    private Integer pageId;
    private String pageKey;
    private String pageTitle;
    private String pageContent;

    private Date pageCreateTime;
    private Date pageUpdateTime;

    private Integer pageViewCount;
    private Integer pageCommentCount;
    private Integer pageStatus;
}
