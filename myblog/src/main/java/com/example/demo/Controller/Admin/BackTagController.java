package com.example.demo.Controller.Admin;


import com.example.demo.Pojo.Tag;
import com.example.demo.Service.ArticleService;
import com.example.demo.Service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author niwang
 * @Date 3/7
 */
@RestController("/back")
public class BackTagController {
    @Autowired
    private ArticleService articleService;

    @Autowired
    private TagService tagService;

    /**
     * 后台标签列表显示
     * @return
     */
    @RequestMapping(value = "/tag")
    public List<Tag> index()  {
        List<Tag> tagList = tagService.listTagWithCount();
        return tagList;
    }


    /**
     * 后台添加分类页面显示
     *
     * @param tag
     * @return
     */
    @RequestMapping(value = "/tag/insertSubmit",method = RequestMethod.POST)
    public void insertTagSubmit(Tag tag)  {
        tagService.insertTag(tag);
    }

    /**
     * 删除标签
     *
     * @param id 标签ID
     * @return
     */
    @RequestMapping(value = "/tag/delete")
    public void deleteTag(Integer id)  {
        Integer count = articleService.countArticleByTagId(id);
        if (count == 0) {
            tagService.deleteTag(id);
        }
    }

    /**
     * 编辑标签页面显示
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/tag/edit")
    public Tag editTagView(Integer id)  {
        Tag tag =  tagService.getTagById(id);
        return tag;
    }


    /**
     * 编辑标签提交
     *
     * @param tag
     * @return
     */
    @RequestMapping(value = "/tag/editSubmit",method = RequestMethod.POST)
    public void editTagSubmit(Tag tag)  {
        tagService.updateTag(tag);
    }
}
