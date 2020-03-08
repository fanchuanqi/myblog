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
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = -2320299020412878696L;

    //用户信息
    private String id;
    private Integer userId;
    private String userName;
    private String userPass;
    private String userNickname;
    private String userEmail;
    private String userUrl;
    private String userAvatar;

    private String userLastLoginIp;

    private String FavoriteArticle;

    private Date userRegisterTime;
    private Date userLastLoginTime;

    private Integer userStatus;

    /**
     * 文章数量（不是数据库字段）
     */
    private Integer articleCount;
}
