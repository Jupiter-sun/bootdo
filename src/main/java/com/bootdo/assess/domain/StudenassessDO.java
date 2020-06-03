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
public class StudenassessDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//学生id
	private Integer studentId;
	//指标项占比id
	private Integer scoreProId;
	//分数
	private Float score;

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
	 * 设置：指标项占比id
	 */
	public void setScoreProId(Integer scoreProId) {
		this.scoreProId = scoreProId;
	}
	/**
	 * 获取：指标项占比id
	 */
	public Integer getScoreProId() {
		return scoreProId;
	}
	/**
	 * 设置：分数
	 */
	public void setScore(Float score) {
		this.score = score;
	}
	/**
	 * 获取：分数
	 */
	public Float getScore() {
		return score;
	}
}
