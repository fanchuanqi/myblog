package com.example.demo.Controller.Admin;

import com.example.demo.DTO.RespBean;
import com.example.demo.Pojo.Article;
import com.example.demo.Pojo.Category;
import com.example.demo.Pojo.Tag;
import com.example.demo.Service.ArticleService;
import com.example.demo.Service.CategoryService;
import com.example.demo.Service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * @author niwang
 * @Date 3/7
 */
@RestController("/back")
public class BackArticleController {
    @Autowired
    private ArticleService articleService;




    /**
     * 后台添加文章提交操作
     *
     * @param   article
     * @return RespBean
     */
    @RequestMapping(value = "/article/insertSubmit", method = RequestMethod.POST)
    public RespBean insertArticleSubmit(Article article) {
        articleService.insertArticle(article);
        return RespBean.ok("添加成功");
    }


    /**
     * 删除文章
     *
     * @param id 文章ID
     */
    @RequestMapping(value = "/article/delete")
    public void deleteArticle(Integer id) {
        articleService.deleteArticle(id);
    }


    /**
     * 编辑文章页面显示
     *
     * @param article
     * @return
     */
    @RequestMapping(value = "/article/edit")
    public void editArticleView(Article article) {
        articleService.updateArticle(article);
    }


    /**
     * 编辑文章提交
     *
     * @param article
     * @return
     */
    @RequestMapping(value = "/article/editSubmit", method = RequestMethod.POST)
    public RespBean editArticleSubmit(Article article) {
        articleService.insertArticle(article);
        return RespBean.ok("文章提交成功");
    }
}
