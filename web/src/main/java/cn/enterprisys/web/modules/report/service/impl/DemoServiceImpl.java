package cn.enterprisys.web.modules.report.service.impl;

import cn.enterprisys.web.modules.report.entity.Demo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.enterprisys.web.modules.report.mapper.DemoMapper;
import cn.enterprisys.web.modules.report.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DemoServiceImpl extends ServiceImpl<DemoMapper, Demo> implements DemoService {

    @Autowired
    private DemoMapper demoMapper;


}
