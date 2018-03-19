package com.sgdp.sys.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ZhangQiang
 * @date 2018/3/19
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/login")
    public String login(Model model){
        ModelAndView mv = new ModelAndView();
        model.addAttribute("mess", "hello world!");
        HashMap map = new HashMap();
        map.put("aa","bbsadasd");
        model.addAttribute("user",  map  );
        return  "/login/index";
    }
}
