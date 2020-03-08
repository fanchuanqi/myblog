package com.example.demo.Service.Impl;


import com.example.demo.Enum.ArticleStatus;
import com.example.demo.Mapper.ArticleMapper;
import com.example.demo.Mapper.CommentMapper;
import com.example.demo.Pojo.Article;
import com.example.demo.Pojo.Comment;
import com.example.demo.Service.CommentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
public class CommentServiceImpl implements CommentService {
    @Autowired(required = false)
    private CommentMapper commentMapper;

    @Autowired(required = false)
    private ArticleMapper articleMapper;

    @Override
    public void insertComment(Comment comment) {
            commentMapper.insert(comment);
    }

    @Override
    public List<Comment> listCommentByArticleId(Integer articleId) {
        return commentMapper.listCommentByArticleId(articleId);
    }

    @Override
    public Comment getCommentById(Integer id) {
        return commentMapper.getCommentById(id);
    }

    @Override
    public PageInfo<Comment> listCommentByPage(Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<Comment> commentList  = commentMapper.listComment();
            for (int i = 0; i < commentList.size(); i++) {
                Article article = articleMapper.getArticleByStatusAndId(ArticleStatus.PUBLISH.getValue(), commentList.get(i).getCommentArticleId());
                commentList.get(i).setArticle(article);
            }
        return new PageInfo<>(commentList);
    }

    @Override
    public List<Comment> listComment() {
        return commentMapper.listComment();
    }

    @Override
    public void deleteComment(Integer id) {
            commentMapper.deleteById(id);
    }

    @Override
    public void updateComment(Comment comment) {
            commentMapper.update(comment);
    }

    @Override
    public Integer countComment() {
        return commentMapper.countComment();
    }

    @Override
    public List<Comment> listRecentComment(Integer limit) {
        List<Comment> commentList = commentMapper.listRecentComment(limit);

            for (int i = 0; i < commentList.size(); i++) {
                Article article = articleMapper.getArticleByStatusAndId(ArticleStatus.PUBLISH.getValue(), commentList.get(i).getCommentArticleId());
                commentList.get(i).setArticle(article);
            }

        return commentList;
    }

    @Override
    public List<Comment> listChildComment(Integer id) {
        return commentMapper.listChildComment(id);
    }
}
