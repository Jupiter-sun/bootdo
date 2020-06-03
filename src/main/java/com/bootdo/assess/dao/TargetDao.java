package com.bootdo.assess.dao;

import com.bootdo.assess.domain.TargetDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 指标项表
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-06-02 00:19:38
 */
@Mapper
public interface TargetDao {

	TargetDO get(Integer id);
	
	List<TargetDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TargetDO target);
	
	int update(TargetDO target);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
