package com.z5n.springboot.blog.repository;

import com.z5n.springboot.blog.domain.User;

import java.util.List;

/**
 * User Repository 接口
 * @author zmx
 */
public interface UserRepository {
    /**
     * 创建或修改用户
     * @param user 被修改或创建的用户
     * @return 返回修改好的结果
     */
    User saveOrUpdateUser(User user);

    /**
     * 根据用户id删除用户
     * @param id 传入的id
     */
    void deleteUser(long id);

    /**
     * 根据id查询用户
     * @param id 传入的id
     * @return 返回用户实例
     */
    User getUserById(long id);

    /**
     * 获取用户列表
     * @return 用户列表
     */
    List<User> listUsers();
}
