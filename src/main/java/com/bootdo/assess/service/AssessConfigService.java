package com.bootdo.assess.service;

import com.bootdo.assess.domain.AssessConfigDO;

import java.util.List;
import java.util.Map;

/**
 * 考核占比表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-06-02 00:19:38
 */
public interface AssessConfigService {
	
	AssessConfigDO get(Integer id);
	
	List<AssessConfigDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(AssessConfigDO assessConfig);
	
	int update(AssessConfigDO assessConfig);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
