package com.bootdo.assess.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.assess.dao.AssessConfigDao;
import com.bootdo.assess.domain.AssessConfigDO;
import com.bootdo.assess.service.AssessConfigService;



@Service
public class AssessConfigServiceImpl implements AssessConfigService {
	@Autowired
	private AssessConfigDao assessConfigDao;
	
	@Override
	public AssessConfigDO get(Integer id){
		return assessConfigDao.get(id);
	}
	
	@Override
	public List<AssessConfigDO> list(Map<String, Object> map){
		return assessConfigDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return assessConfigDao.count(map);
	}
	
	@Override
	public int save(AssessConfigDO assessConfig){
		return assessConfigDao.save(assessConfig);
	}
	
	@Override
	public int update(AssessConfigDO assessConfig){
		return assessConfigDao.update(assessConfig);
	}
	
	@Override
	public int remove(Integer id){
		return assessConfigDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return assessConfigDao.batchRemove(ids);
	}
	
}
