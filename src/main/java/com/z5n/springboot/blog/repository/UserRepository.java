package com.z5n.springboot.blog.repository;

import com.z5n.springboot.blog.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * User Repository 接口 继承CrudRepository来实现CRUD功能
 * @author zmx
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
