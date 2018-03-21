package com.sgdp.sys.user.controller;

import com.sgdp.sys.user.model.User;
import com.sgdp.sys.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author ZhangQiang
 * @date 2018/3/19
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public Map createUser(@RequestParam String username, @RequestParam String password, @RequestParam String usercode, @RequestParam String orgid) {
        User user = new User();
        user.setUserid(UUID.randomUUID().toString());
        user.setUsername(username);
        user.setUsercode(usercode);
        user.setPassword(password);
        user.setOrgid(orgid);
        int n = userService.insert(user);
        Map map = new HashMap();
        if (n < 1) {
            map.put("code", -1);
        } else {
            map.put("code", 1);
        }
        return map;
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    @ResponseBody
    public Map deleteUserByPrimaryKey(@RequestParam String userid) {
        int n = userService.deleteByPrimaryKey(userid);
        Map map = new HashMap();
        if (n < 1) {
            map.put("code", -1);
        } else {
            map.put("code", 1);
        }
        return map;
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ResponseBody
    public Map updateUserByPrimaryKey(User user) {
        int n = userService.updateByPrimaryKey(user);
        Map map = new HashMap();
        if (n < 1) {
            map.put("code", -1);
        } else {
            map.put("code", 1);
        }
        return map;
    }


}
