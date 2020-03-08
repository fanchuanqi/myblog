package com.example.demo.Controller.Admin;


import com.example.demo.Enum.ArticleStatus;
import com.example.demo.Pojo.Article;
import com.example.demo.Pojo.Comment;
import com.example.demo.Service.ArticleService;
import com.example.demo.Service.CommentService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
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
public class BackCommentController {
    @Autowired
    private CommentService commentService;

    @Autowired
    private ArticleService articleService;

    public BackCommentController() {
    }

    /**
     * 评论页面
     *
     * @param pageIndex 页码
     * @param pageSize  页大小
     * @return modelAndView
     */
    @RequestMapping(value = "/page")
    public PageInfo<Comment> commentListView(Integer pageIndex, Integer pageSize) {
        PageInfo<Comment> commentPageInfo = commentService.listCommentByPage(pageIndex, pageSize);
        return commentPageInfo;
    }


    /**
     * 添加评论
     *
     * @param comment
     */
    @RequestMapping(value = "/insert", method = {RequestMethod.POST})
    public void insertComment(Comment comment) {
        //添加评论
        comment.setCommentCreateTime(new Date());
        commentService.insertComment(comment);
        //更新文章的评论数
        Article article = articleService.getArticleByStatusAndId(null, comment.getCommentArticleId());
        articleService.updateCommentCount(article.getArticleId());
    }

    /**
     * 删除评论
     *
     * @param id 批量ID
     */
    @RequestMapping(value = "/delete")
    public void deleteComment(Integer id) {
        Comment comment = commentService.getCommentById(id);
        //删除评论
        commentService.deleteComment(id);
        //删除其子评论
        List<Comment> childCommentList = commentService.listChildComment(id);
        for (int i = 0; i < childCommentList.size(); i++) {
            commentService.deleteComment(childCommentList.get(i).getCommentId());
        }
        //更新文章的评论数
        Article article = articleService.getArticleByStatusAndId(null, comment.getCommentArticleId());
        articleService.updateCommentCount(article.getArticleId());
    }



    /**
     * 编辑评论提交
     *
     * @param comment
     * @return
     */
    @RequestMapping(value = "/editSubmit", method = RequestMethod.POST)
    public void editCommentSubmit(Comment comment) {
        commentService.updateComment(comment);
    }



    /**
     * 回复评论提交
     *
     * @param comment
     * @return
     */
    @RequestMapping(value = "/replySubmit", method = RequestMethod.POST)
    public void replyCommentSubmit(Comment comment) {
        //文章评论数+1
        Article article = articleService.getArticleByStatusAndId(ArticleStatus.PUBLISH.getValue(), comment.getCommentArticleId());
        article.setArticleCommentCount(article.getArticleCommentCount() + 1);
        articleService.updateArticle(article);
        //添加评论
        comment.setCommentCreateTime(new Date());
        commentService.insertComment(comment);
    }
}
