package cn.enterprisys.web.modules.appdemo.service.impl;

import cn.enterprisys.web.modules.appdemo.entity.AppDemo;
import cn.enterprisys.web.modules.appdemo.mapper.AppDemoMapper;
import cn.enterprisys.web.modules.appdemo.service.IAppDemoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class AppDemoServiceImpl extends ServiceImpl<AppDemoMapper, AppDemo> implements IAppDemoService {

}
