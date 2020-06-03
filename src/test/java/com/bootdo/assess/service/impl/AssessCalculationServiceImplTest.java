package com.bootdo.assess.service.impl;

import com.bootdo.assess.domain.dto.AccessTargetDTO;
import com.bootdo.assess.service.AssessCalculationService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AssessCalculationServiceImplTest {

    @Autowired
    private AssessCalculationService assessCalculationService;


    /**
     * @method queryStuReach
     * @param
     * @description 学生达成度
     * @author 许妍
     * @date 2020/6/2 1:34 上午
     * @return
     * @throws
     */
    @Test
    public void queryStuReach() {
        List<AccessTargetDTO> map = assessCalculationService.queryTargetReach("124");
        double sum = 0;
        for (AccessTargetDTO accessTargetDTO : map) {
            sum+=accessTargetDTO.getTargetCompProportion();
        }
        double a = sum/map.size();
        Assert.assertNotNull(a);
    }

    /**
     * @method queryTargetReach
     * @param
     * @description 指标达成度
     * @author 许妍
     * @date 2020/6/2 1:34 上午
     * @return
     * @throws
     */
    @Test
    public void queryTargetReach(){
        List<AccessTargetDTO> map = assessCalculationService.queryTargetReach("124");
        System.out.println("===========");
        Assert.assertNotNull(map);
    }

    /**
     * @method queryCourseReach
     * @param
     * @description 课程达成度
     * @author 许妍
     * @date 2020/6/2 1:34 上午
     * @return
     * @throws
     */
    @Test
    public void queryCourseReach() {
        Float result = assessCalculationService.queryCourseReach("5");
        System.out.println("=============");
        Assert.assertNotNull(result);
    }
}