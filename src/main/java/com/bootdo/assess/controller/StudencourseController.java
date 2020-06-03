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

import com.bootdo.assess.domain.StudencourseDO;
import com.bootdo.assess.service.StudencourseService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 学生选课表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-06-02 00:19:38
 */
 
@Controller
@RequestMapping("/assess/studencourse")
public class StudencourseController {
	@Autowired
	private StudencourseService studencourseService;
	
	@GetMapping()
	@RequiresPermissions("assess:studencourse:studencourse")
	String Studencourse(){
	    return "assess/studencourse/studencourse";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("assess:studencourse:studencourse")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<StudencourseDO> studencourseList = studencourseService.list(query);
		int total = studencourseService.count(query);
		PageUtils pageUtils = new PageUtils(studencourseList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("assess:studencourse:add")
	String add(){
	    return "assess/studencourse/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("assess:studencourse:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		StudencourseDO studencourse = studencourseService.get(id);
		model.addAttribute("studencourse", studencourse);
	    return "assess/studencourse/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("assess:studencourse:add")
	public R save( StudencourseDO studencourse){
		if(studencourseService.save(studencourse)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("assess:studencourse:edit")
	public R update( StudencourseDO studencourse){
		studencourseService.update(studencourse);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("assess:studencourse:remove")
	public R remove( Integer id){
		if(studencourseService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("assess:studencourse:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		studencourseService.batchRemove(ids);
		return R.ok();
	}


	//选课
	@GetMapping("/treeView")
	public String treeView(Model model,String courseIds){
		model.addAttribute("courseIds", courseIds);
		return "assess/selectCourseTree";
	}
	
}
