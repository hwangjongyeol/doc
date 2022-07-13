package com.skt.tidhub.config.exception;


public class BizExceptionProperties extends Exception {

    private static final long serialVersionUID = 4011553437434927169L;

    /**
     * Exception 정의
     */
    protected Exception exception;

    protected String code;
    protected String msg;
    protected String[] msgArgs;

    public BizExceptionProperties() {
        super();
        this.exception = null;
    }

    public BizExceptionProperties(String code) {
        super();
        this.code = code;
        this.exception = null;
    }

    public BizExceptionProperties(String code, String msg) {
        super(msg);
        this.exception = null;
        this.code = code;
        this.msg = msg;
    }

    public BizExceptionProperties(String code, String[] msgArgs) {
        super();
        this.exception = null;
        this.code = code;
        this.msgArgs = msgArgs;
    }

    public BizExceptionProperties(Exception e) {
        super();
        this.exception = e;
    }

    public BizExceptionProperties(String msg, Exception e) {
        super(msg);
        this.exception = e;
        this.msg = msg;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String[] getMsgArgs() {
        return msgArgs;
    }

    public void setMsgArgs(String[] msgArgs) {
        this.msgArgs = msgArgs;
    }
}

