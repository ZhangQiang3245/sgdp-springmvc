package com.sgdp.sys.user.controller;

import com.sgdp.sys.user.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ZQ on 2018/3/21.
 */
@Controller
public class LoginController {

    @RequestMapping("/")
    public String gotoLogin() {
        return "redirect:static/main/login.html";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(User user) {
        if ("admin".equals(user.getUsercode()) && "admin".equals(user.getPassword())) {
            return "redirect:static/main/index.html";
        }else{
            return "redirect:/";
        }
    }

}
