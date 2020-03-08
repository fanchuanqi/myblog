package com.example.demo.Service.Impl;


import com.example.demo.Mapper.PageMapper;
import com.example.demo.Pojo.Page;
import com.example.demo.Service.PageService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PageServiceImpl implements PageService {
    @Autowired(required = false)
    private PageMapper pageMapper;

    @Override
    public Page getPageByKey(Integer status, String key) {
        return pageMapper.getPageByKey(status, key);
    }

    @Override
    public Page getPageById(Integer id) {
        return pageMapper.getPageById(id);
    }

    @Override
    public List<Page> listPage(Integer status) {
        return pageMapper.listPage(status);
    }


    @Override
    public void insertPage(Page page) {
        pageMapper.insert(page);
    }

    @Override
    public void deletePage(Integer id) {
        pageMapper.deleteById(id);
    }

    @Override
    public void updatePage(Page page) {
        pageMapper.update(page);
    }
}
