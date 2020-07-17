package com.cqupt.controller;

import com.cqupt.domain.UsersInfo;
import com.cqupt.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UsersController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/findAll.do")
    public ModelAndView findALl() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<UsersInfo> usersInfoList = userService.findAll();
        mv.addObject("userList",usersInfoList);
        mv.setViewName("user-list");
        return mv;
    }

    @RequestMapping("/save.do")
    public String save(UsersInfo usersInfo) throws Exception{
        ModelAndView mv = new ModelAndView();
        userService.save(usersInfo);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(String id) throws Exception {
        ModelAndView mv = new ModelAndView();
        UsersInfo usersInfo = userService.findById(id);
        mv.addObject("user",usersInfo);
        mv.setViewName("user-show");
        return mv;
    }

    // 在用户list页面 通过添加角色按钮给当前用户添加角色
    @RequestMapping("findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(String id) throws Exception{
        ModelAndView mv = new ModelAndView();
        UsersInfo usersInfo = userService.findById(id);
        //

        return mv;
    }

}