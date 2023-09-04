package cn.enterprisys.web.modules.monitor.controller;


import cn.enterprisys.web.modules.sys.service.UserOperationLogService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cn.enterprisys.web.modules.sys.entity.SysUserOperationLog;
import cn.enterprisys.web.modules.sys.form.SysOperationLogForm;
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
 * 用户操作日志表 前端控制器
 */
@Controller
@RequestMapping("log")
public class    SysUserOperationLogController  {
    @Autowired
    private UserOperationLogService sysUserOperationLogService;

    @GetMapping("/list.html")
    @PreAuthorize("hasAuthority('log:operationLogList')")
    public ModelAndView toList(ModelAndView mv) {
        List<SysUserOperationLog> list = sysUserOperationLogService.queryType();
        mv.setViewName("sys/userOperationLog/logList");
        mv.addObject("list", list);
        return mv;
    }
    @SysLog(value = "日志列表", module = "登录日志管理")
    @RequestMapping("operationLogList")
    @PreAuthorize("hasAuthority('log:operationLogList')")
    public ResponseEntity page(LayuiPage layuiPage, SysOperationLogForm sysOperationLogForm) {
        SystemCheckUtils.getInstance().checkMaxPage(layuiPage);
        IPage page = new Page<>(layuiPage.getPage(), layuiPage.getLimit());
        List<SysUserOperationLog> queryList = sysUserOperationLogService.queryOperationList(sysOperationLogForm, page);
        page.setRecords(queryList);
        return ResponseEntity.ok(LayuiTools.toLayuiTableModel(page));
    }
}
