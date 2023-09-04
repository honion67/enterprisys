package cn.enterprisys.web.commons.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;
import cn.enterprisys.web.commons.entity.CodeMsg;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Data
public class LayuiTools {

    private Integer code;
    private String msg;
    private Long count;
    private List data;

    public static Map<String, Object> toLayuiTableModel(IPage page) {
        Map<String, Object> layuiModel = new HashMap<>(4);
        layuiModel.put("code", 0);
        layuiModel.put("msg", CodeMsg.DEFAULT_MSG);
        layuiModel.put("count", page.getTotal());
        layuiModel.put("data", page.getRecords());
        return layuiModel;
    }

    public static Map<String, Object> toLayuiTreeTableModel(List list) {
        Map<String, Object> teeTableModel = new HashMap<>(4);
        teeTableModel.put("code", 0);
        teeTableModel.put("msg", "ok");
        teeTableModel.put("data", list);
        return teeTableModel;
    }
}
