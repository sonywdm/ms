package com.renhang.springbootlesson2.dto;

import com.renhang.springbootlesson2.validator.MyConstraint;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author heng.jia
 * @date 2018/6/28 下午8:53
 */
public class UserQueryCondition {

//    @NotBlank(message = "用户名不能为空")
    @MyConstraint(message = "这是一个测试")
    @ApiModelProperty("用户名不能为空")
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
