package com.bootdo.assess.controller;

import java.util.List;
import java.util.Map;

import com.bootdo.assess.domain.CourseDO;
import com.bootdo.assess.service.CourseService;
import com.bootdo.common.domain.Tree;
import com.bootdo.system.domain.DeptDO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.assess.domain.TeacherCourseDO;
import com.bootdo.assess.service.TeacherCourseService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 老师选课表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-06-02 00:19:38
 */
 
@Controller
@RequestMapping("/assess/teacherCourse")
public class TeacherCourseController {
	@Autowired
	private TeacherCourseService teacherCourseService;
	
	@GetMapping()
	@RequiresPermissions("assess:teacherCourse:teacherCourse")
	String TeacherCourse(){
	    return "assess/teacherCourse/teacherCourse";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("assess:teacherCourse:teacherCourse")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<TeacherCourseDO> teacherCourseList = teacherCourseService.list(query);
		int total = teacherCourseService.count(query);
		PageUtils pageUtils = new PageUtils(teacherCourseList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("assess:teacherCourse:add")
	String add(){
	    return "assess/teacherCourse/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("assess:teacherCourse:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		TeacherCourseDO teacherCourse = teacherCourseService.get(id);
		model.addAttribute("teacherCourse", teacherCourse);
	    return "assess/teacherCourse/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("assess:teacherCourse:add")
	public R save( TeacherCourseDO teacherCourse){
		if(teacherCourseService.save(teacherCourse)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("assess:teacherCourse:edit")
	public R update( TeacherCourseDO teacherCourse){
		teacherCourseService.update(teacherCourse);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("assess:teacherCourse:remove")
	public R remove( Integer id){
		if(teacherCourseService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("assess:teacherCourse:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		teacherCourseService.batchRemove(ids);
		return R.ok();
	}
	
}
