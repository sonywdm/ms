package com.renhang.userapi.domain;

import java.io.Serializable;

/**
 * @author heng.jia
 * @date 2018/7/3 下午11:43
 */
public class User implements Serializable{


    private static final long serialVersionUID = 6441540867934564356L;
    /**
     * ID
     */
    private Long id;

    /**
     * 用户名称
     */
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
