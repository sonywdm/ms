package com.renhang.springbootlesson3.repository;

import com.renhang.springbootlesson3.domain.JpaUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author heng.jia
 * @date 2018/6/30 下午3:30
 */
public interface JpaUserRepository extends JpaRepository<JpaUser, Integer>{

    JpaUser findById(Integer id);

}
