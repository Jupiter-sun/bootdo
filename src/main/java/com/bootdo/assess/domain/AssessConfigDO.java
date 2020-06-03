package com.bootdo.assess.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 考核占比表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-06-02 00:19:38
 */
public class AssessConfigDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//ID
	private Integer id;
	//考核项名称
	private String assessName;
	//课程id
	private String courseId;
	//考核项占比
	private Double propotion;
	//技能点
	private String tId;

	/**
	 * 设置：ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：ID
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：考核项名称
	 */
	public void setAssessName(String assessName) {
		this.assessName = assessName;
	}
	/**
	 * 获取：考核项名称
	 */
	public String getAssessName() {
		return assessName;
	}
	/**
	 * 设置：课程id
	 */
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	/**
	 * 获取：课程id
	 */
	public String getCourseId() {
		return courseId;
	}
	/**
	 * 设置：考核项占比
	 */
	public void setPropotion(Double propotion) {
		this.propotion = propotion;
	}
	/**
	 * 获取：考核项占比
	 */
	public Double getPropotion() {
		return propotion;
	}
	/**
	 * 设置：技能点
	 */
	public void setTId(String tId) {
		this.tId = tId;
	}
	/**
	 * 获取：技能点
	 */
	public String getTId() {
		return tId;
	}
}
