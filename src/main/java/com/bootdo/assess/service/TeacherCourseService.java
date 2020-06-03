package com.bootdo.assess.service;

import com.bootdo.assess.domain.CourseDO;
import com.bootdo.assess.domain.TeacherCourseDO;
import com.bootdo.common.domain.Tree;

import java.util.List;
import java.util.Map;

/**
 * 老师选课表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-06-02 00:19:38
 */
public interface TeacherCourseService {
	
	TeacherCourseDO get(Integer id);
	
	List<TeacherCourseDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TeacherCourseDO teacherCourse);
	
	int update(TeacherCourseDO teacherCourse);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);

}
