package com.example.demo.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author
 * @Date 3/6
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article implements Serializable {
    private  static final long serialVersionUID = 4357777377821069625L;

    //Id
    private String id;
    private Integer articleId;
    private Integer articleUserId;

    //文章关联用户
    private User user;

    //文章
    private String articleTitle;
    private Integer articleIsComment;
    private Integer articleOrder;
    private String articleContent;
    private String articleSummary;

    private Integer articleStatus;

    //文章浏览数 评论数 喜爱数
    private Integer articleViewCount;
    private Integer articleCommentCount;
    private Integer articleLikeCount;

    private Date articleCreateTime;
    private Date articleUpdateTime;

    private List<Tag> tagList;
    private List<Category> categoryList;

}
