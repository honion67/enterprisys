package cn.enterprisys.web.modules.echarts;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/map")
public class MapController {


    @GetMapping("/list.html")
    public String list() {
        return "echarts/map";
    }
}
