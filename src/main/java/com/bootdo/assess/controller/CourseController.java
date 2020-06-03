package com.bootdo.assess.controller;

import java.util.List;
import java.util.Map;

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

import com.bootdo.assess.domain.CourseDO;
import com.bootdo.assess.service.CourseService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-06-02 00:19:38
 */
 
@Controller
@RequestMapping("/assess/course")
public class CourseController {
	@Autowired
	private CourseService courseService;
	
	@GetMapping()
	@RequiresPermissions("assess:course:course")
	String Course(){
	    return "assess/course/course";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("assess:course:course")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<CourseDO> courseList = courseService.list(query);
		int total = courseService.count(query);
		PageUtils pageUtils = new PageUtils(courseList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("assess:course:add")
	String add(){
	    return "assess/course/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("assess:course:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		CourseDO course = courseService.get(id);
		model.addAttribute("course", course);
	    return "assess/course/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("assess:course:add")
	public R save( CourseDO course){
		if(courseService.save(course)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("assess:course:edit")
	public R update( CourseDO course){
		courseService.update(course);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("assess:course:remove")
	public R remove( Integer id){
		if(courseService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("assess:course:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		courseService.batchRemove(ids);
		return R.ok();
	}
	
}
