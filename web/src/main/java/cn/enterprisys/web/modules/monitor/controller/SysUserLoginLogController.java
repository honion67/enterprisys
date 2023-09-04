package cn.enterprisys.web.modules.monitor.controller;


import cn.enterprisys.web.modules.sys.service.SysUserLoginLogService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cn.enterprisys.web.modules.sys.entity.SysUserLoginLog;
import cn.enterprisys.web.modules.sys.form.SysLoginLogForm;
import cn.enterprisys.web.commons.entity.LayuiPage;
import cn.enterprisys.web.commons.utils.LayuiTools;
import cn.enterprisys.web.commons.utils.SystemCheckUtils;
import link.ahsj.core.annotations.SysLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 用户登录日志表 前端控制器
 */
@RequestMapping("/loginLog")
@Controller
public class SysUserLoginLogController {
    @Autowired
    private SysUserLoginLogService sysUserLoginLogService;

    @GetMapping("/list.html")
    @PreAuthorize("hasAuthority('loginLog:loginLogList')")
    public ModelAndView toList(ModelAndView mv) {
        mv.setViewName("sys/userLoginLog/logList");
        return mv;
    }

    @SysLog(value = "登录日志列表", module = "登录日志管理")
    @RequestMapping("loginLogList")
    @PreAuthorize("hasAuthority('loginLog:loginLogList')")
    public ResponseEntity page(LayuiPage layuiPage, SysLoginLogForm sysLoginLogForm) {
        SystemCheckUtils.getInstance().checkMaxPage(layuiPage);
        IPage page = new Page<>(layuiPage.getPage(), layuiPage.getLimit());
        List<SysUserLoginLog> list = sysUserLoginLogService.queryLoginLogList(sysLoginLogForm, page);
        page.setRecords(list);
        return ResponseEntity.ok(LayuiTools.toLayuiTableModel(page));
    }
}
