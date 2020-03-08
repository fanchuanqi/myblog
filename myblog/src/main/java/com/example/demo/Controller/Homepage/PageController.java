package com.example.demo.Controller.Homepage;

import com.example.demo.Pojo.Article;
import com.example.demo.Pojo.Category;
import com.example.demo.Pojo.Page;
import com.example.demo.Pojo.Tag;
import com.example.demo.Service.ArticleService;
import com.example.demo.Service.CategoryService;
import com.example.demo.Service.PageService;
import com.example.demo.Service.TagService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author niwang
 * @Date 3/7
 */
@RestController
public class PageController {
    @Autowired
    private PageService pageService;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private CategoryService categoryService;


    @Autowired
    private TagService tagService;

    /**
     * 页面详情页面
     *
     * @param key
     * @return
     */
    @RequestMapping(value = "/page")
    public Page pageDetail(String key) {

        return pageService.getPageByKey(1, key);
    }

    @RequestMapping(value = "/")
    public List<Article> getArticle(){
        //获得热评文章
        return articleService.listArticleByCommentCount(8);
    }




    /**
     * 文章归档页面显示
     *
     * @return
     */
    @RequestMapping(value = "/articleFile")
    public List<Article> articleFile() {
        List<Article> articleList = articleService.listAllNotWithContent();
        return articleList;
    }

    /**
     * 站点地图显示
     *
     * @return
     */
    @RequestMapping(value = "/map")
    public String siteMap() {
        HashMap<String,Object> map = new HashMap<>();

        //文章显示
        List<Article> articleList = articleService.listAllNotWithContent();
        map.put("articleList",articleList);
        //分类显示
        List<Category> categoryList = categoryService.listCategory();
        map.put("categoryList",categoryList);
        //标签显示
        List<Tag> tagList = tagService.listTag();
        map.put("tagList",tagList);

        //侧边栏显示
        //获得热评文章
        List<Article> mostCommentArticleList = articleService.listArticleByCommentCount(10);
        map.put("mostCommentArticleList",mostCommentArticleList);

        return new JSONObject(map).toString();
    }

}
