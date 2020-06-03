package com.bootdo.assess.service.impl;

import com.bootdo.assess.dao.*;
import com.bootdo.assess.domain.*;
import com.bootdo.assess.domain.dto.AccessDetail;
import com.bootdo.assess.domain.dto.AccessTargetDTO;
import com.bootdo.assess.service.AssessCalculationService;
import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Program : bootdo
 * @ClassName : AssessCalculationServiceImpl
 * @Description :
 * @Author : 许妍
 * @Date : 2020-06-02 00:24
 */
@Service
public class AssessCalculationServiceImpl implements AssessCalculationService {


    @Autowired
    private CourseDao courseDao;

    @Autowired
    private AssessConfigDao assessConfigDao;

    @Autowired
    private StudencourseDao studencourseDao;

    @Autowired
    private StudenassessDao studenassessDao;

    @Autowired
    private TargetDao targetDao;

    /*
     
     */
    /***
     * @method queryTargetReach 
     * @param userId
     * @description 指标点A 一共被数学课（学分5分）大作业（占数学课20%），数学课考试（占数学课30%），语文课（学分3分）考试（占语文课35%）关联。
     *              数学课的大作业考了75分，数学课考试考了82分，语文课考试考了62分。
     *              最后的指标点A的达成度应该是。 （5*20%）/（5*20%+5*30%+3*35%）*75/100   +（5*30%）/（5*20%+5*30%+3*35%）*82/100 +  （3*35%）/（5*20%+5*30%+3*35%）*62/100
     * @author 许妍
     * @date 2020/6/2 1:36 上午 
     * @return {@link java.util.List<com.bootdo.assess.domain.dto.AccessTargetDTO>}  
     * @throws 
     */
    @Override
    public List<AccessTargetDTO> queryTargetReach(String userId) {

        List<AccessTargetDTO> accessTargetDTOS = new ArrayList<>();
        //查出我的课程
        List<StudencourseDO> studencourseDOS = studencourseDao.list(new ImmutableMap.Builder<String,Object>().put("studentId",userId).build());
        //定义指标A全部考核点占比的和
        double sum = 0;
        //学分*占比
        for (StudencourseDO studencourseDO:studencourseDOS){
            //查出课程的学分
            int credit = courseDao.get(studencourseDO.getCourseNo()).getCredit();

            //查出考核点占比
            List<AssessConfigDO> assessConfigDOS = assessConfigDao.list(new ImmutableMap.Builder<String,Object>().put("courseNo",studencourseDO.getCourseNo()).build());
            for (AssessConfigDO assessConfigDO:assessConfigDOS){
                double s = credit * assessConfigDO.getPropotion();
                sum = sum+s;
            }
        }
        double AllSum = 0;
        //计算A指标关联的各个考核点/全部考核点占比的和
        for (int i = 0; i < studencourseDOS.size(); i++) {
            CourseDO courseDO = courseDao.get(studencourseDOS.get(i).getCourseNo());
            Integer credit = courseDO.getCredit();
            String courseName = courseDO.getCourseName();
            List<AccessDetail> details = new ArrayList<>();
            
            List<AssessConfigDO> assessConfigDOS = assessConfigDao.list(new ImmutableMap.Builder<String,Object>().put("courseNo",studencourseDOS.get(i).getCourseNo()).build());
            for (AssessConfigDO assessConfigDO:assessConfigDOS){
                AccessTargetDTO accessTargetDTO = new AccessTargetDTO();
                double proPotion = assessConfigDO.getPropotion();
                Integer courseScoreProId = assessConfigDO.getId();
                String tid = assessConfigDO.getTId();
                TargetDO targetDO = targetDao.get(Integer.parseInt(tid));
                //根据学生id以及考核点id查询学生考核点成绩
                List<StudenassessDO> studentScoreDOS = studenassessDao.list(new ImmutableMap.Builder<String,Object>().put("studentId",userId)
                        .put("scoreProId",courseScoreProId).build());
                if(!studentScoreDOS.isEmpty()){
                    float score = studentScoreDOS.get(0).getScore();
                    double s = credit * proPotion;
                    double ss = s/sum * score/100;
                    AllSum = AllSum + ss;
                }

                AccessDetail detail = new AccessDetail();
                detail.setCredit(credit);
                detail.setCourseName(courseName);
                detail.setAccessName(assessConfigDO.getAssessName());
                detail.setPropotion(proPotion);
                details.add(detail);

                accessTargetDTO.setTargetName(targetDO.getTargetName());
                accessTargetDTO.setTargetCompProportion(AllSum);
                accessTargetDTO.setAccessDetail(details);
                accessTargetDTOS.add(accessTargetDTO);
            }
            
        }


        //查出
        return accessTargetDTOS;
    }

    /***
     * @method queryCourseReach 
     * @param courseId
     * @description 课程达成度
     * @author 许妍
     * @date 2020/6/2 1:37 上午 
     * @return {@link java.util.Map<java.lang.String,java.lang.Object>}  
     * @throws 
     */
    @Override
    public Float queryCourseReach(String courseId) {
        //查询某个课程的所有学生成绩表
        List<StudenassessDO> studenassessDOList = studenassessDao.list(new ImmutableMap.Builder<String,Object>().put("courseId",courseId).build());
        float scoreSum = 0;
        for (StudenassessDO studenassessDO:studenassessDOList){
            float score = studenassessDO.getScore();
            scoreSum+=score;
        }
        List<StudencourseDO> studencourseDOList = studencourseDao.list(new ImmutableMap.Builder<String,Object>().put("courseId",courseId).build());

        return scoreSum/studencourseDOList.size();
    }
}
