package cn.enterprisys.web.modules.sys.service;

import cn.enterprisys.web.modules.sys.entity.SysDict;
import cn.enterprisys.web.modules.sys.entity.SysDictVerifyEntity;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DictService  {


    /**
     * 导入数据字典
     *
     * @param list
     * @return
     */
    List<String> importDict(List<SysDictVerifyEntity> list);

    /**
     * 根据字典编码查询列表
     *
     * @param diceCodes
     * @return
     */
    List<SysDict> queryDictList(Collection<String> diceCodes,String dictName);


    /**
     * 根据字典编码查询列表
     *
     * @param diceCodes
     * @return
     */
    List<Map> queryList(Collection<String> diceCodes);

    /**
     * 根据条件查询字典编码
     *
     * @param dictName
     * @param diceCodes
     * @return
     */
    List<SysDict> queryDictCode(String dictName, String[] diceCodes);
}
