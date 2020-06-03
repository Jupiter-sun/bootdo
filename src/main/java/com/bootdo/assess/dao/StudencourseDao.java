package com.bootdo.assess.dao;

import com.bootdo.assess.domain.StudencourseDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 学生选课表
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-06-02 00:19:38
 */
@Mapper
public interface StudencourseDao {

	StudencourseDO get(Integer id);
	
	List<StudencourseDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(StudencourseDO studencourse);
	
	int update(StudencourseDO studencourse);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
