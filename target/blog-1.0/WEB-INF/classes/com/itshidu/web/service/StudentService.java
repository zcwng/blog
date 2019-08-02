package com.itshidu.web.service;

import org.springframework.data.domain.Page;

import com.itshidu.web.entity.Student;
import com.itshidu.web.vo.Result;

public interface StudentService {

	Result list(int page, int rows);

	void delete(long id);

	void update(Student stu);

	void save(Student stu);
	
}
