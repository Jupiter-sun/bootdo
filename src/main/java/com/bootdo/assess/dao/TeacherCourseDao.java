package com.bootdo.assess.dao;

import com.bootdo.assess.domain.TeacherCourseDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 老师选课表
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-06-02 00:19:38
 */
@Mapper
public interface TeacherCourseDao {

	TeacherCourseDO get(Integer id);
	
	List<TeacherCourseDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TeacherCourseDO teacherCourse);
	
	int update(TeacherCourseDO teacherCourse);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
