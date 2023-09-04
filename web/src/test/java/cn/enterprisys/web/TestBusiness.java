package cn.enterprisys.web;

import cn.enterprisys.web.modules.sys.service.SysDeptService;
import cn.enterprisys.web.modules.sys.entity.SysDept;
import link.ahsj.core.components.tree.BusinessBuildUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestBusiness {

    @Autowired
    private SysDeptService sysDeptService;

    /**
     * 初始化机构层级
     */
    @Test
    public void initDeptBusiness() {
        SysDept sysDept = sysDeptService.getOne(sysDeptService.lambdaQuery()
                .eq(SysDept::getParentDeptId,"0000")
                .getWrapper());
        List<SysDept> list = sysDeptService.list();
        BusinessBuildUtils.rearrangement(sysDept, list);
        sysDeptService.updateBatchById(list);
    }

}
