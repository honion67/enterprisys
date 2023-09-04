package cn.enterprisys.web.modules.appdemo.controller;

import cn.enterprisys.web.commons.entity.LayuiPage;
import cn.enterprisys.web.commons.utils.LayuiTools;
import cn.enterprisys.web.commons.utils.SystemCheckUtils;
import cn.enterprisys.web.modules.BaseController;
import cn.enterprisys.web.modules.log.LogModules;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;


import cn.enterprisys.web.modules.appdemo.entity.AppDemo;
import cn.enterprisys.web.modules.appdemo.service.IAppDemoService;




import link.ahsj.core.annotations.AddGroup;
import link.ahsj.core.annotations.SameUrlData;
import link.ahsj.core.annotations.SysLog;
import link.ahsj.core.annotations.UpdateGroup;
import link.ahsj.core.entitys.ApiModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("appdemo")
public class AppDemoController extends BaseController {

    @Autowired
    private IAppDemoService entityService;

    private static final String LogModule = "AppDemo";

    @GetMapping("/list.html")
    public String list() {
        return "app/appdemo/list";
    }

    @RequestMapping("/add.html")
    @PreAuthorize("hasAuthority('app:appdemo:add')")
    public ModelAndView toAdd(ModelAndView mv) {
        mv.setViewName("app/appdemo/add");
        return mv;
    }

    @GetMapping("/{id}.html")
    @PreAuthorize("hasAuthority('app:appdemo:update')")
    public ModelAndView toUpdate(@PathVariable("id") String id, ModelAndView mv) {
        mv.setViewName("app/appdemo/update");
        mv.addObject("obj", entityService.getById(id));
        mv.addObject("id", id);
        return mv;
    }

    @RequestMapping("list")
    @PreAuthorize("hasAuthority('app:appdemo:list')")
    public ResponseEntity page(LayuiPage layuiPage) {
        SystemCheckUtils.getInstance().checkMaxPage(layuiPage);
        IPage page = new Page<>(layuiPage.getPage(), layuiPage.getLimit());
        return ResponseEntity.ok(LayuiTools.toLayuiTableModel(entityService.page(page)));
    }

    @SameUrlData
    @PostMapping("save")
    @SysLog(value = LogModules.SAVE, module =LogModule)
    @PreAuthorize("hasAuthority('app:appdemo:add')")
    public ResponseEntity<ApiModel> save(@Validated({AddGroup.class}) @RequestBody AppDemo entity) {
        entityService.save(entity);
        return ResponseEntity.ok(ApiModel.ok());
    }

    @SameUrlData
    @SysLog(value = LogModules.UPDATE, module = LogModule)
    @PutMapping("update")
    @PreAuthorize("hasAuthority('app:appdemo:update')")
    public ResponseEntity<ApiModel> update(@Validated({UpdateGroup.class}) @RequestBody AppDemo entity) {
        entityService.updateById(entity);
        return ResponseEntity.ok(ApiModel.ok());
    }

    @SysLog(value = LogModules.DELETE, module = LogModule)
    @DeleteMapping("delete/{id}")
    @PreAuthorize("hasAuthority('app:appdemo:delete')")
    public ResponseEntity<ApiModel> delete(@PathVariable("id") String id) {
        entityService.removeById(id);
        return ResponseEntity.ok(ApiModel.ok());
    }

}
