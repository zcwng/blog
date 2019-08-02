package com.itshidu.web.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itshidu.web.entity.Forum;

public interface ForumDao extends JpaRepository<Forum,Long> {
	
	List<Forum> findByStatus(boolean status);
	
}
