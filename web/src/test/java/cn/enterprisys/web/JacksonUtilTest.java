package cn.enterprisys.web;

import cn.enterprisys.WebApplication;
import cn.enterprisys.web.commons.utils.JacksonUtil;
import cn.enterprisys.web.modules.report.entity.Demo;
import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebApplication.class)
public class JacksonUtilTest {
    @Autowired
    private JacksonUtil jacksonUtil;

    private String listStr;
    private String demoStr;

    @Before
    public void objToJsonStr() {
        Demo demo = new Demo();
        demo.setId("123");
        demo.setName("张三");
        demo.setCreateTime(LocalDateTime.now());
        demoStr = jacksonUtil.objToJsonStr(demo);
        System.out.println(demoStr);
        Demo demo2 = new Demo();
        demo2.setId("456");
        demo2.setName("李四");
        demo2.setCreateTime(LocalDateTime.now().plusDays(1));
        ArrayList<Demo> demos = new ArrayList<>();
        demos.add(demo);
        demos.add(demo2);
        listStr = jacksonUtil.objToJsonStr(demos);
    }

    @Test
    public void jsonStrToBean() {
        Demo demo = jacksonUtil.jsonStrToBean(demoStr, Demo.class);
        System.out.println(demo);
    }

    @Test
    public void jsonStrToCollection() {
        List<Demo> demos = jacksonUtil.jsonStrToCollection(listStr, List.class, Demo.class);
        System.out.println(demos);
    }

    @Test
    public void jsonStrToObj() {
        List<Demo> demos = jacksonUtil.jsonStrToObj(listStr, new TypeReference<List<Demo>>() {
        });
        System.out.println(demos);
        Demo demo = jacksonUtil.jsonStrToObj(demoStr, new TypeReference<Demo>() {
        });
        System.out.println(demo);
    }
}