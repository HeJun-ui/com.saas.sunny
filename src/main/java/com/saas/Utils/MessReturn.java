package com.saas.Utils;

public class MessReturn {
    private final static int successcode =200;
    private final static int failedcode =409;

    private final static boolean teuesuccess =true;
    private final static boolean falsesuccess =false;



    public int getCode() {
        return code;
    }

    public Object getMessage() {
        return message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    private boolean status;
    private int code;
    private Object message;


    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public MessReturn() {
    }

    public MessReturn(boolean status,int code,Object message) {
        this.status=status;
        this.code=code;
        this.message=message;
    }
    public  MessReturn requsuccess(Object message)
    {
        return new MessReturn(teuesuccess,successcode,message);
    }
    public  MessReturn requfailed(Object message)

    {
        return new MessReturn(falsesuccess,failedcode,message);
    }
}
