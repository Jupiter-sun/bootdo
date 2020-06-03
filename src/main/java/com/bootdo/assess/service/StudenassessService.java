package com.bootdo.assess.service;

import com.bootdo.assess.domain.StudenassessDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-06-02 00:19:38
 */
public interface StudenassessService {
	
	StudenassessDO get(Integer id);
	
	List<StudenassessDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(StudenassessDO studenassess);
	
	int update(StudenassessDO studenassess);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
