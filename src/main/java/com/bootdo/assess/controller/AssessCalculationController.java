package com.bootdo.assess.controller;

import com.bootdo.assess.domain.dto.AccessTargetDTO;
import com.bootdo.assess.service.AssessCalculationService;
import com.bootdo.common.config.SecuityConfig;
import com.bootdo.common.controller.BaseController;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Program : bootdo
 * @ClassName : AssessCalculationController
 * @Description :
 * @Author : 许妍
 * @Date : 2020-06-02 10:15
 */
@Controller
@RequestMapping("/assess/calculation")
public class AssessCalculationController extends BaseController {

    @Autowired
    private AssessCalculationService assessCalculationService;

    @GetMapping("assesscalculation")
    public String assesscalculation(){
        return "/assess/assesscalculation";
    }

    /**
     * @method queryTargetReach 
     * @param 
     * @description 指标达成度
     * @author 许妍
     * @date 2020/6/2 10:21 上午 
     * @return {@link java.util.List<com.bootdo.assess.domain.dto.AccessTargetDTO>}  
     * @throws 
     */
    @ResponseBody
    @PostMapping("queryTargetReach")
    public List<AccessTargetDTO> queryTargetReach(){
        return assessCalculationService.queryTargetReach("124");
    }

    /**
     * @method queryStuReach 
     * @param 
     * @description 学生达成度
     * @author 许妍
     * @date 2020/6/2 10:21 上午 
     * @return {@link java.lang.Double}  
     * @throws 
     */
    @GetMapping("queryStuReach")
    public String queryStuReach(HttpServletRequest request){
        List<AccessTargetDTO> list = assessCalculationService.queryTargetReach("124");
        double sum = 0;
        for (AccessTargetDTO accessTargetDTO : list) {
            sum+=accessTargetDTO.getTargetCompProportion();
        }
        request.setAttribute("user",getUser().getName());
        request.setAttribute("result",sum/list.size());
        return "/assess/assessstu";
    }

    /**
     * @method queryCourseReach 
     * @param 
     * @description 课程达成度
     * @author 许妍
     * @date 2020/6/2 10:21 上午 
     * @return {@link java.lang.Float}  
     * @throws 
     */
    @GetMapping("queryCourseReach")
    public String queryCourseReach(HttpServletRequest request){
        Float result = assessCalculationService.queryCourseReach("5");
        request.setAttribute("result",result);
        return "/assess/assesscourse";
    }
}
