package com.bootdo.assess.domain.dto;

import java.util.List;

/**
 * @Program : bootdo
 * @ClassName : AccessTargetDTO
 * @Description :
 * @Author : 许妍
 * @Date : 2020-06-02 01:03
 */
public class AccessTargetDTO {
    /*
     指标点A 一共被数学课（学分5分）大作业（占数学课20%），数学课考试（占数学课30%），语文课（学分3分）考试（占语文课35%）关联。
     数学课的大作业考了75分，数学课考试考了82分，语文课考试考了62分。
     最后的指标点A的达成度应该是。 （5*20%）/（5*20%+5*30%+3*35%）*75/100   +（5*30%）/（5*20%+5*30%+3*35%）*82/100 +  （3*35%）/（5*20%+5*30%+3*35%）*62/100
     */
    //指标名称
    private String targetName;

    //指标完成占比
    private Double targetCompProportion;

    //考核详情
    private List<AccessDetail> AccessDetail ;


    public String getTargetName() {
        return targetName;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName;
    }

    public Double getTargetCompProportion() {
        return targetCompProportion;
    }

    public void setTargetCompProportion(Double targetCompProportion) {
        this.targetCompProportion = targetCompProportion;
    }

    public List<com.bootdo.assess.domain.dto.AccessDetail> getAccessDetail() {
        return AccessDetail;
    }

    public void setAccessDetail(List<com.bootdo.assess.domain.dto.AccessDetail> accessDetail) {
        AccessDetail = accessDetail;
    }
}
