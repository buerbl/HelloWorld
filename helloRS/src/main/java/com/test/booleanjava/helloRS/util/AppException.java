package com.test.booleanjava.helloRS.util;

/**
 * 错误封装
 *
 * @author moyuhui
 *
 */
@SuppressWarnings("serial")
public class AppException extends Exception {

    private int errorCode;

    public AppException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public AppException(int errorCode, String message, Throwable e) {
        super(message + ";" + e.getMessage(), e);
        this.errorCode = errorCode;
    }
    public int getErrorCode() {
        return errorCode;
    }

}

