package cn.enterprisys.web.modules.sys.service.impl;

import cn.enterprisys.web.modules.sys.mapper.SysDictMapper;
import cn.enterprisys.web.modules.sys.service.SysDictService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.enterprisys.web.modules.sys.entity.SysDict;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
@Log4j2
public class SysDictServiceImpl extends ServiceImpl<SysDictMapper, SysDict> implements SysDictService {

    @Autowired
    private SysDictMapper sysDictMapper;


    @Override
    public List<Map> queryList(Collection<String> diceCodes) {
        return sysDictMapper.queryList(diceCodes);
    }

    @Override
    public List<SysDict> queryDictCode(String dictName, String[] diceCodes) {
        return sysDictMapper.queryDictCode(dictName, diceCodes);
    }


}
