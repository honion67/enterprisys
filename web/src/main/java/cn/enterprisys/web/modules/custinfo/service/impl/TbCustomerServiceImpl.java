package cn.enterprisys.web.modules.custinfo.service.impl;

import cn.enterprisys.web.modules.custinfo.entity.TbCustomer;
import cn.enterprisys.web.modules.custinfo.mapper.TbCustomerMapper;
import cn.enterprisys.web.modules.custinfo.service.ITbCustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class TbCustomerServiceImpl extends ServiceImpl<TbCustomerMapper, TbCustomer> implements ITbCustomerService {

}
