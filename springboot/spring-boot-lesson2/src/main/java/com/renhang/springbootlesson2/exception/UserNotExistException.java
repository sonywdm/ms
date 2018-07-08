package com.renhang.springbootlesson2.exception;

/**
 * @author heng.jia
 * @date 2018/6/29 上午10:08
 */
public class UserNotExistException extends RuntimeException {

    private String id;

    public UserNotExistException(String id) {
        super("user not exist");
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
