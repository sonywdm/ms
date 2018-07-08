package com.renhang.springbootlesson3.mapper;

import com.renhang.springbootlesson3.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author heng.jia
 * @date 2018/6/30 下午3:49
 */
@Mapper
public interface MyBatisUserMapper {

//    @Select("select id, name, age from user where id = #{id}")
//    User findUserById(@Param("id") Integer id);

    User findUserById(Integer id);

}
