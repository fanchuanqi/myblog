package com.example.demo.Controller.Homepage;


import com.example.demo.Enum.ArticleStatus;
import com.example.demo.Pojo.Article;
import com.example.demo.Pojo.Comment;
import com.example.demo.Pojo.Tag;
import com.example.demo.Pojo.User;
import com.example.demo.Service.*;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author niwang
 * @Date 3/7
 */
@RestController
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    @Autowired
    private TagService tagService;

    @Autowired
    private CategoryService categoryService;

    /**
     * 文章详情页显示
     *
     * @param articleId 文章ID
     * @return String
     */
    @RequestMapping(value = "/article/detail")
    public String getArticleDetailPage(Integer articleId) {

        Map<String,Object> map = new HashMap<String, Object>();

        //文章信息，分类，标签，作者，评论
        Article article = articleService.getArticleByStatusAndId(ArticleStatus.PUBLISH.getValue(), articleId);

        if (article == null) {
            return "文章为空";
        }

        //用户信息
        User user = userService.getUserById(article.getArticleUserId());
        map.put("user",user);


        //评论列表
        List<Comment> commentList = commentService.listCommentByArticleId(articleId);
        map.put("commentList",commentList);

        //相关文章
        List<Integer> categoryIds = articleService.listCategoryIdByArticleId(articleId);
        List<Article> similarArticleList = articleService.listArticleByCategoryIds(categoryIds, 5);
        map.put("similarArticleList",similarArticleList);

        //猜你喜欢
        List<Article> mostViewArticleList = articleService.listArticleByViewCount(5);
        map.put("mostViewArticleList",mostViewArticleList);

        //获取下一篇文章
        Article afterArticle = articleService.getAfterArticle(articleId);
        map.put("afterArticle",afterArticle);

        //获取上一篇文章
        Article preArticle = articleService.getPreArticle(articleId);
        map.put("preArticle",preArticle);

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

    /**
     * 点赞增加
     *
     * @param id 文章ID
     * @return 点赞量数量
     */
    @RequestMapping(value = "/article/like", method = {RequestMethod.POST})
    @ResponseBody
    public Integer increaseLikeCount(Integer id) {
        Article article = articleService.getArticleByStatusAndId(ArticleStatus.PUBLISH.getValue(), id);
        Integer articleCount = article.getArticleLikeCount() + 1;
        article.setArticleLikeCount(articleCount);
        articleService.updateArticle(article);

        return articleCount;
    }

    /**
     * 文章访问量数增加
     *
     * @param id 文章ID
     * @return 访问量数量
     */
    @RequestMapping(value = "/article/view", method = {RequestMethod.POST})
    @ResponseBody
    public Integer increaseViewCount(@PathVariable("id") Integer id) {
        Article article = articleService.getArticleByStatusAndId(ArticleStatus.PUBLISH.getValue(), id);
        Integer articleCount = article.getArticleViewCount() + 1;
        article.setArticleViewCount(articleCount);
        articleService.updateArticle(article);

        return articleCount;
    }

    @RequestMapping(value = "/article/most")
    public List<Article> getArticle(){
        //获得热评文章
        return articleService.listArticleByCommentCount(8);
    }
}
