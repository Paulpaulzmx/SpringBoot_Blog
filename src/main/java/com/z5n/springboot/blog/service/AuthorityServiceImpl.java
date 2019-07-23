package com.z5n.springboot.blog.service;

import com.z5n.springboot.blog.domain.Authority;
import com.z5n.springboot.blog.repository.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Authority 服务接口
 */
public class AuthorityServiceImpl implements AuthorityService{

    @Autowired
    private AuthorityRepository authorityRepository;

    @Override
    public Authority getAuthorityById(Long id) {
        return authorityRepository.findOne(id);
    }
}
