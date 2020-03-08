package com.example.demo.Controller.Admin;


import com.example.demo.DTO.RespBean;
import com.example.demo.DTO.UserRequest;
import com.example.demo.Pojo.User;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author niwang
 * @Date 3/7
 */
@RestController("/back")
public class BackUserController {

    @Autowired
    UserService userService;

    @RequestMapping("user/insert")
    public RespBean insertUser(User user){
        userService.insertUser(user);
        return RespBean.ok("添加成功");
    }

    @RequestMapping("user/delete")
    public RespBean deleteUserById(Integer id){
        return RespBean.ok("删除成功");
    }

    @RequestMapping("user/delete")
    public RespBean updateUserById(User user){
        return RespBean.ok("删除成功");
    }

    @RequestMapping("user/searchByName")
    public User findUserByName(String username){
        return userService.getUserByName(username);
    }

    @RequestMapping("user/searchById")
    public User findUserByName(Integer id){
        return userService.getUserById(id);
    }


}
