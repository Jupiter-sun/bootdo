package com.bootdo.assess.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 学生选课表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-06-02 00:19:38
 */
public class StudencourseDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//
	private Integer courseNo;
	//老师id
	private Integer teacherId;
	//学生id
	private Integer studentId;
	//课程名称
	private String courseName;
	//学分
	private Float credit;

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
	public void setCourseNo(Integer courseNo) {
		this.courseNo = courseNo;
	}
	/**
	 * 获取：
	 */
	public Integer getCourseNo() {
		return courseNo;
	}
	/**
	 * 设置：老师id
	 */
	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}
	/**
	 * 获取：老师id
	 */
	public Integer getTeacherId() {
		return teacherId;
	}
	/**
	 * 设置：学生id
	 */
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	/**
	 * 获取：学生id
	 */
	public Integer getStudentId() {
		return studentId;
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
	public void setCredit(Float credit) {
		this.credit = credit;
	}
	/**
	 * 获取：学分
	 */
	public Float getCredit() {
		return credit;
	}
}
