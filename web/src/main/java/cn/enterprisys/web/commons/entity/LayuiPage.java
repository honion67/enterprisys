package cn.enterprisys.web.commons.entity;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;

//分页
@Getter
@Log4j2
public class LayuiPage {

    private Integer page = 1;
    private Integer limit = 10;

    public void setPage(Integer page) {
        this.page = page;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
