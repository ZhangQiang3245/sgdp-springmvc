package com.sgdp.sys.user.controller;

import com.sgdp.sys.user.model.User;
import com.sgdp.sys.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

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

    @RequestMapping(value = "/login", method= RequestMethod.GET)
    public String login(Model model){
        model.addAttribute("mess", "sdfsdf");
        return  "login/index";
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public String createUser(@RequestParam String username,@RequestParam String password,@RequestParam String usercode,@RequestParam String orgid) {
        User user = new User();
        user.setUserid(UUID.randomUUID().toString());
        user.setUsername(username);
        user.setUsercode(usercode);
        user.setPassword(password);
        user.setOrgid(orgid);
        userService.insert(user);
        return "redirect:/static/success.html";
    }
}
