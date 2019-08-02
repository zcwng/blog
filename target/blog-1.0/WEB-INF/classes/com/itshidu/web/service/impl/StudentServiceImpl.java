package com.itshidu.web.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.itshidu.web.dao.StudentDao;
import com.itshidu.web.entity.Student;
import com.itshidu.web.service.StudentService;
import com.itshidu.web.vo.Result;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired StudentDao studentDao;
	
	@Override
	public Result list(int page, int rows) {

		Pageable arg0 = PageRequest.of(page-1, rows);//DataJPA分页页码从0开始
		Page<Student> data = studentDao.findAll(arg0);
		
		Result er = Result.of(200);
		er.put("total", data.getTotalElements());
		er.put("rows", data.getContent());
		
		return er;
	}

	@Override
	public void delete(long id) {
		studentDao.deleteById(id);
	}

	@Override
	public void update(Student stu) {
		Student target = studentDao.getOne(stu.getId());
		BeanUtils.copyProperties(stu, target, "createTime","updateTime");
		target.setUpdateTime(new Date());
		studentDao.save(target);
	}

	@Override
	public void save(Student stu) {
		stu.setCreateTime(new Date());
		stu.setUpdateTime(new Date());
		studentDao.save(stu);
	}

}
