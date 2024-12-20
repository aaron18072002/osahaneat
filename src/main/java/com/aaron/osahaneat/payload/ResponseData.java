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
    private boolean isSuccess = true;
    private String desc;
    private Object data;

    public ResponseData() {

    }

    public ResponseData(int status, String desc, Object data) {
        this.status = status;
        this.desc = desc;
        this.data = data;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
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

    @Override
    public String toString() {
        return "ResponseData{" +
                "status=" + status +
                ", isSuccess=" + isSuccess +
                ", desc='" + desc + '\'' +
                ", data=" + data +
                '}';
    }
}
