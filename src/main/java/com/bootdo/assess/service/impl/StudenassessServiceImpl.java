package com.bootdo.assess.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.assess.dao.StudenassessDao;
import com.bootdo.assess.domain.StudenassessDO;
import com.bootdo.assess.service.StudenassessService;



@Service
public class StudenassessServiceImpl implements StudenassessService {
	@Autowired
	private StudenassessDao studenassessDao;
	
	@Override
	public StudenassessDO get(Integer id){
		return studenassessDao.get(id);
	}
	
	@Override
	public List<StudenassessDO> list(Map<String, Object> map){
		return studenassessDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return studenassessDao.count(map);
	}
	
	@Override
	public int save(StudenassessDO studenassess){
		return studenassessDao.save(studenassess);
	}
	
	@Override
	public int update(StudenassessDO studenassess){
		return studenassessDao.update(studenassess);
	}
	
	@Override
	public int remove(Integer id){
		return studenassessDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return studenassessDao.batchRemove(ids);
	}
	
}
