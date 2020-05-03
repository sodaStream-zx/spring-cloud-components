package com.configs.conmonsentity;

/**
 * @author Twilight
 * @desc
 * @createTime 2020-05-03-11:54
 */
public class ResultData<T> {
    private T data;
    private Integer code;
    private String msg;

    public ResultData(T data) {
        this.data = data;
        this.code = 1;
        this.msg = "请求成功";
    }

    public ResultData() {
    }

    public ResultData(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
    }

    public ResultData(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
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
