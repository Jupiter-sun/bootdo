package com.bootdo.assess.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.assess.dao.TargetDao;
import com.bootdo.assess.domain.TargetDO;
import com.bootdo.assess.service.TargetService;



@Service
public class TargetServiceImpl implements TargetService {
	@Autowired
	private TargetDao targetDao;
	
	@Override
	public TargetDO get(Integer id){
		return targetDao.get(id);
	}
	
	@Override
	public List<TargetDO> list(Map<String, Object> map){
		return targetDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return targetDao.count(map);
	}
	
	@Override
	public int save(TargetDO target){
		return targetDao.save(target);
	}
	
	@Override
	public int update(TargetDO target){
		return targetDao.update(target);
	}
	
	@Override
	public int remove(Integer id){
		return targetDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return targetDao.batchRemove(ids);
	}
	
}
