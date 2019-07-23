package com.z5n.springboot.blog.service;

import com.z5n.springboot.blog.domain.Authority;

/**
 * Authority 服务接口
 */
public interface AuthorityService {
    Authority getAuthorityById(Long id);
}
