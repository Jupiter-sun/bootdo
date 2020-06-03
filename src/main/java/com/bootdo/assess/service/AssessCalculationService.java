package com.bootdo.assess.service;

import com.bootdo.assess.domain.dto.AccessTargetDTO;

import java.util.List;
import java.util.Map;

/**
 * @Program : bootdo
 * @ClassName : AssessCalculationService
 * @Description :
 * @Author : 许妍
 * @Date : 2020-06-02 00:24
 */
public interface AssessCalculationService {

    List<AccessTargetDTO> queryTargetReach(String userId);

    Float queryCourseReach(String courseId);
}
