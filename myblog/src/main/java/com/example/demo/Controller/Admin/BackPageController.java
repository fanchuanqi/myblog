package com.example.demo.Controller.Admin;


import com.example.demo.Enum.PageStatus;
import com.example.demo.Pojo.Page;
import com.example.demo.Service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author niwang
 * @Date 3/7
 */
@RestController("/back")
public class BackPageController {
    @Autowired
    private PageService pageService;

    /**
     * 后台页面列表显示
     *
     * @return
     */
    @RequestMapping(value = "/page")
    public void index() {
        List<Page> pageList = pageService.listPage(null);
    }


    /**
     * 后台添加页面提交操作
     *
     * @param page
     * @return
     */
    @RequestMapping(value = "/page/insertSubmit", method = RequestMethod.POST)
    public void insertPageSubmit(Page page) {

        //判断别名是否存在
        Page checkPage = pageService.getPageByKey(null, page.getPageKey());
        if (checkPage == null) {
            page.setPageCreateTime(new Date());
            page.setPageUpdateTime(new Date());
            page.setPageStatus(PageStatus.NORMAL.getValue());
            pageService.insertPage(page);
        }
    }

    /**
     * 删除页面
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/page/delete")
    public void deletePage(Integer id) {
        //调用service批量删除
        pageService.deletePage(id);
    }


    /**
     * 获取页面信息
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/page/edit")
    public Page getPage(Integer id) {
        return  pageService.getPageById(id);
    }


    /**
     * 编辑页面提交
     *
     * @param page
     * @return
     */
    @RequestMapping(value = "/page/editSubmit", method = RequestMethod.POST)
    public void editPageSubmit(Page page) {
        Page checkPage = pageService.getPageByKey(null, page.getPageKey());
        //判断别名是否存在且不是这篇文章
        if (Objects.equals(checkPage.getPageId(), page.getPageId())) {
            page.setPageUpdateTime(new Date());
            pageService.updatePage(page);
        }
    }
}
