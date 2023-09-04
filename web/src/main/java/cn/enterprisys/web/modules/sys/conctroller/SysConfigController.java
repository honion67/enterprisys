package cn.enterprisys.web.modules.sys.conctroller;


import cn.enterprisys.web.modules.sys.service.SysConfigService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cn.enterprisys.web.modules.log.LogModules;
import cn.enterprisys.web.modules.sys.entity.SysConfig;
import cn.enterprisys.web.commons.entity.LayuiPage;
import cn.enterprisys.web.commons.utils.LayuiTools;
import cn.enterprisys.web.commons.utils.SystemCheckUtils;
import link.ahsj.core.annotations.AddGroup;
import link.ahsj.core.annotations.SysLog;
import link.ahsj.core.annotations.UpdateGroup;
import link.ahsj.core.entitys.ApiModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/config")
public class SysConfigController {


    @Autowired
    private SysConfigService sysConfigService;

    @GetMapping("/list.html")
    public String list() {
        return "sys/config/configList";
    }

    @RequestMapping("configList")
    @SysLog(value = LogModules.LIST, module = LogModules.SYSTEM)
    @PreAuthorize("hasAuthority('config:configList')")
    public ResponseEntity page(LayuiPage layuiPage, SysConfig sysConfig) {
        SystemCheckUtils.getInstance().checkMaxPage(layuiPage);
        IPage page = new Page<>(layuiPage.getPage(), layuiPage.getLimit());
        page.setRecords(sysConfigService.list(Wrappers.<SysConfig>lambdaQuery().like(StringUtils.isNotEmpty(sysConfig.getInfo()), SysConfig::getInfo, sysConfig.getInfo())));
        return ResponseEntity.ok(LayuiTools.toLayuiTableModel(page));
    }

    @RequestMapping("/add.html")
    @PreAuthorize("hasAuthority('config:add')")
    public ModelAndView toAdd(ModelAndView mv) {
        mv.setViewName("sys/config/configAdd");
        return mv;
    }


    @PostMapping("save")
    @SysLog(value = LogModules.SAVE, module = LogModules.SYSTEM)
    @PreAuthorize("hasAuthority('config:add')")
    public ResponseEntity<ApiModel> save(@Validated({AddGroup.class}) @RequestBody SysConfig sysConfig) {
        sysConfigService.save(sysConfig);
        return ResponseEntity.ok(ApiModel.ok());
    }

    @GetMapping("/{id}.html")
    @PreAuthorize("hasAuthority('config:update')")
    public ModelAndView toUpdate(@PathVariable("id") String id, ModelAndView mv) {
        SysConfig sysConfig = sysConfigService.getById(id);
        mv.setViewName("sys/config/configUpdate");
        mv.addObject("obj", sysConfig);
        return mv;
    }

    @SysLog(value = LogModules.UPDATE, module = LogModules.SYSTEM)
    @PutMapping("update")
    @PreAuthorize("hasAuthority('config:update')")
    public ResponseEntity<ApiModel> update(@Validated({UpdateGroup.class}) @RequestBody SysConfig sysConfig) {
        sysConfigService.updateById(sysConfig);
        return ResponseEntity.ok(ApiModel.ok());
    }

    @SysLog(value = LogModules.DELETE, module = LogModules.SYSTEM)
    @DeleteMapping("delete/{id}")
    @PreAuthorize("hasAuthority('config:delete')")
    public ResponseEntity<ApiModel> delete(@PathVariable("id") String id) {
        sysConfigService.deleteById(id);
        return ResponseEntity.ok(ApiModel.ok());
    }

    @SysLog(value = LogModules.RECOVER, module = LogModules.SYSTEM)
    @DeleteMapping("recovery/{id}")
    @PreAuthorize("hasAuthority('config:recovery')")
    public ResponseEntity<ApiModel> recover(@PathVariable("id") String id) {
        sysConfigService.recoverById(id);
        return ResponseEntity.ok(ApiModel.ok());
    }
}
