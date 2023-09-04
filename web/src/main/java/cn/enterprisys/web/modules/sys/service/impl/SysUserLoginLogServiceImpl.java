package cn.enterprisys.web.modules.sys.service.impl;

import cn.enterprisys.web.modules.sys.mapper.SysUserLoginLogMapper;
import cn.enterprisys.web.modules.sys.service.SysUserLoginLogService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.enterprisys.web.modules.sys.entity.SysUserLoginLog;
import cn.enterprisys.web.modules.sys.form.SysLoginLogForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SysUserLoginLogServiceImpl extends ServiceImpl<SysUserLoginLogMapper, SysUserLoginLog> implements SysUserLoginLogService {
    @Autowired
    private SysUserLoginLogMapper sysUserLoginLogMapper;

    /**
     * 查询列表
     *
     * @param sysLoginLogForm
     * @param page
     * @return
     */
    @Override
    public List<SysUserLoginLog> queryLoginLogList(SysLoginLogForm sysLoginLogForm, IPage page) {
        return sysUserLoginLogMapper.queryLoginLogList(sysLoginLogForm,page);
    }
}
