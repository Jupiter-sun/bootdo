package com.bootdo.assess.service.impl;

import com.bootdo.assess.domain.CourseDO;
import com.bootdo.common.domain.Tree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.assess.dao.TeacherCourseDao;
import com.bootdo.assess.domain.TeacherCourseDO;
import com.bootdo.assess.service.TeacherCourseService;



@Service
public class TeacherCourseServiceImpl implements TeacherCourseService {
	@Autowired
	private TeacherCourseDao teacherCourseDao;
	
	@Override
	public TeacherCourseDO get(Integer id){
		return teacherCourseDao.get(id);
	}
	
	@Override
	public List<TeacherCourseDO> list(Map<String, Object> map){
		return teacherCourseDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return teacherCourseDao.count(map);
	}
	
	@Override
	public int save(TeacherCourseDO teacherCourse){
		return teacherCourseDao.save(teacherCourse);
	}
	
	@Override
	public int update(TeacherCourseDO teacherCourse){
		return teacherCourseDao.update(teacherCourse);
	}
	
	@Override
	public int remove(Integer id){
		return teacherCourseDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return teacherCourseDao.batchRemove(ids);
	}

}
