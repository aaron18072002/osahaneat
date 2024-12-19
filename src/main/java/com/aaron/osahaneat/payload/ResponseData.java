package com.aaron.osahaneat.payload;

/**
 * {
 *     status: 200,
 *     desc: "",
 *     data: {}
 * }
 */
public class ResponseData {

    private int status;
    private String desc;
    private Object data;

    public ResponseData() {

    }

    public ResponseData(int status, String desc, Object data) {
        this.status = status;
        this.desc = desc;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
