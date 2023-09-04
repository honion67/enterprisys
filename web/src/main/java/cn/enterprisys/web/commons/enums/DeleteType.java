package cn.enterprisys.web.commons.enums;

import com.fasterxml.jackson.annotation.JsonValue;


public enum DeleteType {


    /**
     * 常规状态
     */
    NORMAL(0),

    /**
     * 禁用状态
     */
    DISABLE(1);


    @JsonValue
    private final int value;

    DeleteType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
