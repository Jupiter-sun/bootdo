package com.bootdo.assess.dao;

import com.bootdo.assess.domain.AssessConfigDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 考核占比表
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-06-02 00:19:38
 */
@Mapper
public interface AssessConfigDao {

	AssessConfigDO get(Integer id);
	
	List<AssessConfigDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(AssessConfigDO assessConfig);
	
	int update(AssessConfigDO assessConfig);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
