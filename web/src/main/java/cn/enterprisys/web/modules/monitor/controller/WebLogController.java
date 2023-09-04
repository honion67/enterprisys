package cn.enterprisys.web.modules.monitor.controller;


import cn.enterprisys.web.modules.sys.service.SysUserLoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 用户登录日志表 前端控制器
 */
@RequestMapping("/logweb")
@Controller
public class WebLogController {
    @Autowired
    private SysUserLoginLogService sysUserLoginLogService;

    @GetMapping("/list.html")
    @PreAuthorize("hasAuthority('logweb:list')")
    public ModelAndView toList(ModelAndView mv) {
        mv.setViewName("sys/logWeb/logWeb");
        return mv;
    }

}
