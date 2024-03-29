package com.tobeto.bootcampProject.core.utilities.results;

public class Result {

    private boolean success;
    private String message;

    public Result(boolean success){
        this.success = success;
    }

    public Result(boolean success, String message) {
        this(success); //yukarı Result constructor'ına gidiyor.
        this.message = message;

    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
