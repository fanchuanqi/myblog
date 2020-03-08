package com.example.demo.Controller.Homepage;

import com.example.demo.Enum.ArticleStatus;
import com.example.demo.Pojo.Article;
import com.example.demo.Pojo.Category;
import com.example.demo.Pojo.Tag;
import com.example.demo.Service.ArticleService;
import com.example.demo.Service.CategoryService;
import com.example.demo.Service.TagService;
import com.github.pagehelper.PageInfo;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author niwang
 * @Date 3/7
 */
@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private TagService tagService;

    /**
     * 根据分类查询文章
     *
     * @param cateId 分类ID
     * @return 模板
     */
    @RequestMapping("/category")
    public String getArticleListByCategory(Integer cateId,Integer pageIndex,Integer pageSize) {

        Map<String,Object> map = new HashMap<String, Object>();

        //该分类信息
        Category category = categoryService.getCategoryById(cateId);
        map.put("category",category);

        //文章列表
        HashMap<String, Object> criteria = new HashMap<>(2);
        criteria.put("categoryId", cateId);
        criteria.put("status", ArticleStatus.PUBLISH.getValue());
        PageInfo<Article> articlePageInfo = articleService.pageArticle(pageIndex, pageSize, criteria);
        map.put("articlePageInfo",articlePageInfo);

        //侧边栏
        //标签列表显示
        List<Tag> allTagList = tagService.listTag();
        map.put("allTagList",allTagList);

        //获得随机文章
        List<Article> randomArticleList = articleService.listRandomArticle(8);
        map.put("randomArticleList",randomArticleList);

        //获得热评文章
        List<Article> mostCommentArticleList = articleService.listArticleByCommentCount(8);
        map.put("mostCommentArticleList",mostCommentArticleList);

        return new JSONObject(map).toString();
    }
}
