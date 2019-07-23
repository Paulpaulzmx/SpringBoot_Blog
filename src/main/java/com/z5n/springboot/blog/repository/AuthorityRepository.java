package com.z5n.springboot.blog.repository;

import com.z5n.springboot.blog.domain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Authority 仓库
 */
public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}
