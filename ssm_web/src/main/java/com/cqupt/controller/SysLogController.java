package com.cqupt.controller;


import com.cqupt.domain.SysLog;
import com.cqupt.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/sysLog")
public class SysLogController {

    @Autowired
    private ISysLogService sysLogService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<SysLog> sysLogsList = sysLogService.findAll();
        mv.addObject("sysLogs",sysLogsList);
        mv.setViewName("syslog-list");
        return mv;
    }
}
