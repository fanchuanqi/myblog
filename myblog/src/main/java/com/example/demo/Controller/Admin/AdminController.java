package com.example.demo.Controller.Admin;

import com.example.demo.DTO.UserRequest;
import com.example.demo.Pojo.Article;
import com.example.demo.Pojo.User;
import com.example.demo.Service.ArticleService;
import com.example.demo.Service.UserService;
import com.example.demo.Util.JWTUtil;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author niwang
 * @Date 3/7
 */
@RestController("/back")
public class AdminController {
    @Autowired
    private UserService userService;

    @Autowired
    private ArticleService articleService;


    /**
     * 后台首页
     *
     * @return
     */
    @RequestMapping("/admin")
    public List<Article> index(){

        //文章列表
        List<Article> articleList = articleService.listRecentArticle(10);
        return articleList;

    }


    /**
     * 登录验证
     *
     * @param userRequest
     * @return
     */
    @RequestMapping(value = "/loginVerify",method = RequestMethod.POST)
    @ResponseBody
    public String loginVerify(UserRequest userRequest)  {
        Map<String, Object> map = new HashMap<String, Object>();
        User user = userService.getUserByNameOrEmail(userRequest.getUserName());

        if(user==null) {
            map.put("code",0);
            map.put("msg","用户名无效！");
        } else if(!user.getUserPass().equals(userRequest.getPassWord())) {
            map.put("code",0);
            map.put("msg","密码错误！");
        } else {
            //登录成功
            map.put("code",1);
            map.put("msg","");

            //添加token
            String token = JWTUtil.sign(userRequest.getUserName(),userRequest.getPassWord());
            map.put("access_token",token);

            user.setUserLastLoginTime(new Date());
            user.setUserLastLoginIp(userRequest.getIpAddr());
            userService.updateUser(user);
        }


        String result = new JSONObject(map).toString();
        return result;
    }


}
