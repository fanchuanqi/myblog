package com.example.demo.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author
 * @Date 3/6
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment implements Serializable {
    private static final long serialVersionUID = -9140327714552950891L;

    private String id;
    private Integer commentId;
    private String commentPid;
    private String commentPname;

    private Integer commentArticleId;
    private String commentAuthorName;
    private String commentAuthorEmail;

    private String commentAuthorUrl;
    private String commentAuthorAvatar;
    private String commentContent;
    private String commentAgent;
    private String commentIp;
    private Date commentCreateTime;

    /**
     * 角色(管理员1，访客0)
     */
    private Integer commentRole;

    /**
     * 非数据库字段
     */
    private Article article;
}
