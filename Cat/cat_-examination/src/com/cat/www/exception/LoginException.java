package com.cat.www.exception;

public class LoginException extends RuntimeException{
    private String errorMessage;
    private int errorCode;

    public LoginException(int errorCode,String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage=errorMessage;
    }

    public LoginException() {

    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

}
