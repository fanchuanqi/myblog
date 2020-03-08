package com.example.demo.Controller.Admin;

import com.example.demo.DTO.RespBean;
import com.example.demo.Pojo.Category;
import com.example.demo.Service.ArticleService;
import com.example.demo.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author niwang
 * @Date 3/7
 */
@RestController("/back")
public class BackCategoryController {
    @Autowired
    private ArticleService articleService;


    @Autowired
    private CategoryService categoryService;

    /**
     * 后台分类列表显示
     *
     * @return
     */
    @RequestMapping(value = "/category")
    public List<Category> categoryList()  {
        List<Category> categoryList = categoryService.listCategoryWithCount();
        return categoryList;
    }


    /**
     * 后台添加分类提交
     *
     * @param category
     * @return
     */
    @RequestMapping(value = "/category/insertSubmit",method = RequestMethod.POST)
    public String insertCategorySubmit(Category category)  {
        categoryService.insertCategory(category);
        return "redirect:/admin/category";
    }

    /**
     * 删除分类
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/category/delete")
    public RespBean deleteCategory(Integer id)  {
        //禁止删除有文章的分类
        int count = articleService.countArticleByCategoryId(id);

        if (count == 0) {
            categoryService.deleteCategory(id);
            return RespBean.ok("删除分类成功");
        }else {
            return RespBean.error("分类存在文章");
        }
    }

    /**
     * 编辑分类页面显示
     *
     * @param category
     * @return
     */
    @RequestMapping(value = "/category/edit")
    public RespBean editCategoryView(Category category)  {
        categoryService.updateCategory(category);
        return RespBean.ok("添加成功");
    }


}
