package com.saas.Utils;

public class MessReturn {
    private final static int successcode =200;
    private final static int failedcode =409;

    private final static boolean teuesuccess =true;
    private final static boolean falsesuccess =false;
    private boolean success;

    public boolean isSuccess() {
        return success;
    }

    public int getCode() {
        return code;
    }

    public Object getMessage() {
        return message;
    }

    private int code;
    private Object message;

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public MessReturn() {
    }

    public MessReturn(boolean success, int code,Object message) {
        this.success = success;
        this.code = code;
        this.message=message;
    }
    public  MessReturn requsuccess(Object message)
    {
        return new MessReturn(true,successcode,message);
    }
}
