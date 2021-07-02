package com.sure.oa.base;

public class Result {

    public static Result success(){
        return new Result(true, null, null);
    }

    public static Result success(String message){
        return new Result(true, message, null);
    }

    public static Result success(String message, Object data){
        return new Result(true, message, data);
    }

    public static Result fail(){
        return new Result(false, null, null);
    }

    public static Result fail(String message){
        return new Result(false, message, null);
    }

    public static Result fail(String message, Object data){
        return new Result(false, message, data);
    }

    private boolean success;
    private String message;
    private Object data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    private Result(boolean success, String message, Object data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }
}
