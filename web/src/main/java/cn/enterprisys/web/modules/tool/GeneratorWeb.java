package cn.enterprisys.web.modules.tool;

import com.baomidou.mybatisplus.annotation.DbType;
import cn.enterprisys.web.modules.log.LogModules;
import cn.enterprisys.web.commons.utils.JacksonUtil;
import cn.enterprisys.web.modules.BaseController;
import link.ahsj.core.annotations.AddGroup;
import link.ahsj.core.annotations.SameUrlData;
import link.ahsj.core.annotations.SysLog;
import link.ahsj.core.entitys.ApiModel;
import link.ahsj.generator.utils.GeneratorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("gen")
public class GeneratorWeb extends BaseController {

    @Autowired
    private JacksonUtil jacksonUtil;

    @GetMapping("list.html")
    public String list() {
        return "tool/gen/list";
    }

    @SameUrlData
    @PostMapping("save")
    @SysLog(value = LogModules.SAVE, module = "代码生成")
//    @PreAuthorize("hasAuthority('gen:code:add')")
    public ResponseEntity<ApiModel> save(@Validated({AddGroup.class}) @RequestBody GeneratorForm form) {
        GeneratorUtils.generator(
                form.getCodeType(),
                form.getPackageName(),
                form.getModuleName(),
                "mysql".equals(form.getDbType()) ? DbType.MYSQL : DbType.ORACLE,
                form.getOutputDir(),
                // 页面上的父上下文
                // 自己的上下文
                form.getBaseMenuId(),
                form.getMenuName(),
                StringUtils.isNotBlank(form.getTableId()) ? form.getTableId() : null,
                form.getBaseContext(),
                form.getContext(),
                form.getAuthor(),
                form.getIp(),
                form.getProt(),
                form.getDatabase(),
                form.getUsername(),
                form.getPassword(),
                StringUtils.isNotBlank(form.getTablePrefixs()) ? form.getTablePrefixs().split(",") : null,
                StringUtils.isNotBlank(form.getTableNames()) ? form.getTableNames().split(",") : null, false
        );
        System.out.println(jacksonUtil.objToJsonStr(form));

        return ResponseEntity.ok(ApiModel.ok());
    }
}
