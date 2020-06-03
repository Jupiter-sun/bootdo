package com.bootdo.assess.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 老师选课表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-06-02 00:19:38
 */
public class TeacherCourseDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//
	private Integer courseId;
	//
	private Integer teacherId;
	//
	private Integer credit;
	//教学班达成度
	private String achieve;

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
	 * 设置：
	 */
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	/**
	 * 获取：
	 */
	public Integer getCourseId() {
		return courseId;
	}
	/**
	 * 设置：
	 */
	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}
	/**
	 * 获取：
	 */
	public Integer getTeacherId() {
		return teacherId;
	}
	/**
	 * 设置：
	 */
	public void setCredit(Integer credit) {
		this.credit = credit;
	}
	/**
	 * 获取：
	 */
	public Integer getCredit() {
		return credit;
	}
	/**
	 * 设置：教学班达成度
	 */
	public void setAchieve(String achieve) {
		this.achieve = achieve;
	}
	/**
	 * 获取：教学班达成度
	 */
	public String getAchieve() {
		return achieve;
	}
}
