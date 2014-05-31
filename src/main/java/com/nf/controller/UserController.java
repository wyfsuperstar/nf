package com.nf.controller;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nf.model.User;
import com.nf.service.UserService;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/reg")
    public String register() {
        return "index";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ModelAndView addUser(User user) {
        ModelAndView mav = null;
        user.setId(UUID.randomUUID().toString());
        user.setRegtime(new Date());
        try {
            userService.addUser(user);
            //request.setAttribute("user", user);
            mav = new ModelAndView();
            mav.setViewName("success");
            mav.addObject("user", user);
            mav.addObject("msg", "注册成功了，可以去登陆了");
            return mav;
        } catch (Exception e) {
            mav = new ModelAndView();
            mav.setViewName("error");
            mav.addObject("user", null);
            mav.addObject("msg", "注册失败");
            return mav;
        }
    }

}