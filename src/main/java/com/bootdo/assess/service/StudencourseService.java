package com.bootdo.assess.service;

import com.bootdo.assess.domain.StudencourseDO;

import java.util.List;
import java.util.Map;

/**
 * 学生选课表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-06-02 00:19:38
 */
public interface StudencourseService {
	
	StudencourseDO get(Integer id);
	
	List<StudencourseDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(StudencourseDO studencourse);
	
	int update(StudencourseDO studencourse);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
