package com.saas.Utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;

public class ResponseUtil {
    private final static int successcode =200;
    private final static int failedcode =409;

    private final static boolean teuesuccess =true;
    private final static boolean falsesuccess =false;

    private boolean status;
    private int code;
    private Object message;

    public void setStatus(boolean status) {
        this.status = status;
    }
    public int getCode() {
        return code;
    }

    public Object getMessage() {
        return message;
    }

    public boolean isStatus() {
        return status;
    }
    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public ResponseUtil() {
    }

    public ResponseUtil(boolean status, int code, Object message) {
        this.status=status;
        this.code=code;
        this.message=message;
    }
    public ResponseUtil requsuccess(Object message)
    {
        return new ResponseUtil(teuesuccess,successcode,message);
    }

    public ResponseUtil requfailed(Object message)

    {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = servletRequestAttributes.getResponse();
        response.setStatus(409);
        return new ResponseUtil(falsesuccess,failedcode,message);
    }
}
