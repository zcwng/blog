package com.itshidu.web.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.itshidu.web.entity.User;

public interface UserDao extends JpaRepository<User,Long> {
	
	User findByUsername(String username);
	User findByEmail(String email);
	User findByQqOpenid(String qqOpenid);
	Page<User> findByUsernameLike(String username,Pageable pageable);
	
}
