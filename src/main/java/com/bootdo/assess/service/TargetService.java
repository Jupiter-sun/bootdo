package com.bootdo.assess.service;

import com.bootdo.assess.domain.TargetDO;

import java.util.List;
import java.util.Map;

/**
 * 指标项表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-06-02 00:19:38
 */
public interface TargetService {
	
	TargetDO get(Integer id);
	
	List<TargetDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TargetDO target);
	
	int update(TargetDO target);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
