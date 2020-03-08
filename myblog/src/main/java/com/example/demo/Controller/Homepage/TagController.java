package com.example.demo.Controller.Homepage;

import com.example.demo.Enum.ArticleStatus;
import com.example.demo.Pojo.Article;
import com.example.demo.Pojo.Tag;
import com.example.demo.Service.ArticleService;
import com.example.demo.Service.TagService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * @author niwang
 * @Date 3/7
 */
@RestController
public class TagController {

    @Autowired
    private TagService tagService;

    @Autowired
    private ArticleService articleService;


    /**
     * 根据标签查询文章
     *
     * @param tagId 标签ID
     * @return 模板
     */
    @RequestMapping("/tag")
    public PageInfo<Article> getArticleListByTag(Integer tagId,Integer pageIndex,Integer pageSize) {
        //该标签信息
        Tag tag = tagService.getTagById(tagId);


        //文章列表
        HashMap<String, Object> criteria = new HashMap<>(2);
        criteria.put("tagId", tagId);
        criteria.put("status", ArticleStatus.PUBLISH.getValue());
        PageInfo<Article> articlePageInfo = articleService.pageArticle(pageIndex, pageSize, criteria);

        return articlePageInfo;
    }
}
