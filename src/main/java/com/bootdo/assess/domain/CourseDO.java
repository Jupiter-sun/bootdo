package com.bootdo.assess.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-06-02 00:19:38
 */
public class CourseDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//课程名称
	private String courseName;
	//学分
	private Integer credit;
	//课程代码
	private Integer courseNo;
	//是否启用
	private Integer enable;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：课程名称
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	/**
	 * 获取：课程名称
	 */
	public String getCourseName() {
		return courseName;
	}
	/**
	 * 设置：学分
	 */
	public void setCredit(Integer credit) {
		this.credit = credit;
	}
	/**
	 * 获取：学分
	 */
	public Integer getCredit() {
		return credit;
	}
	/**
	 * 设置：课程代码
	 */
	public void setCourseNo(Integer courseNo) {
		this.courseNo = courseNo;
	}
	/**
	 * 获取：课程代码
	 */
	public Integer getCourseNo() {
		return courseNo;
	}
	/**
	 * 设置：是否启用
	 */
	public void setEnable(Integer enable) {
		this.enable = enable;
	}
	/**
	 * 获取：是否启用
	 */
	public Integer getEnable() {
		return enable;
	}
}
