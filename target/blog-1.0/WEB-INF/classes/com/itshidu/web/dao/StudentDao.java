package com.itshidu.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itshidu.web.entity.Student;

public interface StudentDao extends JpaRepository<Student,Long> {
	
}
