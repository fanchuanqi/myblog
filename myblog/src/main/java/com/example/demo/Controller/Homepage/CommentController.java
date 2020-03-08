package com.example.demo.Controller.Homepage;


import com.example.demo.Enum.ArticleStatus;
import com.example.demo.Enum.Role;
import com.example.demo.Pojo.Article;
import com.example.demo.Pojo.Comment;
import com.example.demo.Service.ArticleService;
import com.example.demo.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author niwang
 * @Date 3/7
 */
@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;

    @Autowired
    private ArticleService articleService;

    /**
     * 添加评论
     *
     * @param comment
     */
    @RequestMapping(value = "/comment", method = {RequestMethod.POST})
    public void insertComment(Comment comment) {
        //添加评论
        comment.setCommentCreateTime(new Date());
        comment.setCommentIp(comment.getCommentAuthorUrl());

        comment.setCommentRole(Role.VISITOR.getValue());

        commentService.insertComment(comment);
        //更新文章的评论数
        Article article = articleService.getArticleByStatusAndId(ArticleStatus.PUBLISH.getValue(), comment.getCommentArticleId());
        articleService.updateCommentCount(article.getArticleId());
    }
}
