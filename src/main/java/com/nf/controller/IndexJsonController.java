package com.nf.controller;

import com.nf.model.User;
import com.nf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.UUID;

/**
 * Created by devil on 14-6-6.
 */
@Controller
public class IndexJsonController {
    @Autowired
    private UserService userService;

    @RequestMapping("/indexjson")
    public String register() {
        return "indexjson";
    }

    @RequestMapping(value = "/ajaxsave", method = RequestMethod.POST)
    @ResponseBody
    public User addUser(@RequestBody User user) {
        ModelAndView mav = null;
        user.setId(UUID.randomUUID().toString());
        user.setRegtime(new Date());
        try {
            userService.addUser(user);
            //request.setAttribute("user", user);
            return user;
        } catch (Exception e) {

            return user;
        }
    }
}
