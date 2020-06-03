package com.bootdo.assess.domain.dto;

/**
 * @Program : bootdo
 * @ClassName : AccessDetail
 * @Description :
 * @Author : 许妍
 * @Date : 2020-06-02 01:17
 */
public class AccessDetail {
    //课程名
    private String courseName;

    //学分
    private Integer credit;

    //考核名称
    private String AccessName;

    //占比
    private Double propotion;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public String getAccessName() {
        return AccessName;
    }

    public void setAccessName(String accessName) {
        AccessName = accessName;
    }

    public Double getPropotion() {
        return propotion;
    }

    public void setPropotion(Double propotion) {
        this.propotion = propotion;
    }
}
