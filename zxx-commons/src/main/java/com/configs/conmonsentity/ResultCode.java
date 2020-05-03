package com.configs.conmonsentity;

/**
 * @author Twilight
 * @desc
 * @createTime 2020-05-03-12:00
 */
public enum ResultCode {
    BAD_QUREST(10000, "请求失败");
    private Integer code;
    private String msg;

    ResultCode() {
    }

    ResultCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
