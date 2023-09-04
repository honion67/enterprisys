package cn.enterprisys.web.modules.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cn.enterprisys.web.modules.sys.entity.SysDict;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;
import java.util.Map;


public interface SysDictMapper extends BaseMapper<SysDict> {

    /**
     * 根据字典编码查询列表
     *
     * @param diceCodes
     * @return
     */
    List<Map> queryList(@Param("diceCodes") Collection<String> diceCodes);

    /**
     * 根据条件查询字典编码
     *
     * @param dictName
     * @param diceCodes
     * @return
     */
    List<SysDict> queryDictCode(@Param("dictName") String dictName, @Param("diceCodes") String[] diceCodes);
}
