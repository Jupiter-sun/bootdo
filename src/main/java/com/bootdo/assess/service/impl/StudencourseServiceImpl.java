package com.bootdo.assess.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.assess.dao.StudencourseDao;
import com.bootdo.assess.domain.StudencourseDO;
import com.bootdo.assess.service.StudencourseService;



@Service
public class StudencourseServiceImpl implements StudencourseService {
	@Autowired
	private StudencourseDao studencourseDao;
	
	@Override
	public StudencourseDO get(Integer id){
		return studencourseDao.get(id);
	}
	
	@Override
	public List<StudencourseDO> list(Map<String, Object> map){
		return studencourseDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return studencourseDao.count(map);
	}
	
	@Override
	public int save(StudencourseDO studencourse){
		return studencourseDao.save(studencourse);
	}
	
	@Override
	public int update(StudencourseDO studencourse){
		return studencourseDao.update(studencourse);
	}
	
	@Override
	public int remove(Integer id){
		return studencourseDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return studencourseDao.batchRemove(ids);
	}
	
}
