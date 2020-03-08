package com.example.demo.Service.Impl;

import com.example.demo.Mapper.ArticleCategoryRefMapper;
import com.example.demo.Mapper.CategoryMapper;
import com.example.demo.Pojo.Category;
import com.example.demo.Service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

@Slf4j
public class CategoryServiceImpl implements CategoryService {

    @Autowired(required = false)
    private CategoryMapper categoryMapper;

    @Autowired(required = false)
    private ArticleCategoryRefMapper articleCategoryRefMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteCategory(Integer id) {
            categoryMapper.deleteCategory(id);
            articleCategoryRefMapper.deleteByCategoryId(id);
    }

    @Override
    public Category getCategoryById(Integer id) {
        return categoryMapper.getCategoryById(id);
    }

    @Override
    public void updateCategory(Category category) {
            categoryMapper.update(category);
    }

    @Override
    public Category insertCategory(Category category) {
            categoryMapper.insert(category);
        return category;
    }


    @Override
    public Integer countCategory() {
        return categoryMapper.countCategory();
    }


    @Override
    public List<Category> listCategory() {
        return categoryMapper.listCategory();
    }

    @Override
    public List<Category> listCategoryWithCount() {
        List<Category> categoryList = null;
            categoryList = categoryMapper.listCategory();
            for (int i = 0; i < categoryList.size(); i++) {
                Integer count = articleCategoryRefMapper.countArticleByCategoryId(categoryList.get(i).getCategoryId());
                categoryList.get(i).setArticleCount(count);
            }
        return categoryList;
    }

    @Override
    public Category getCategoryByName(String name) {

        return categoryMapper.getCategoryByName(name);
    }
}
