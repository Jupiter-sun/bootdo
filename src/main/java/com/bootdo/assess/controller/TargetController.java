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

import com.bootdo.assess.domain.TargetDO;
import com.bootdo.assess.service.TargetService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 指标项表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-06-02 00:19:38
 */
 
@Controller
@RequestMapping("/assess/target")
public class TargetController {
	@Autowired
	private TargetService targetService;
	
	@GetMapping()
	@RequiresPermissions("assess:target:target")
	String Target(){
	    return "assess/target/target";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("assess:target:target")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<TargetDO> targetList = targetService.list(query);
		int total = targetService.count(query);
		PageUtils pageUtils = new PageUtils(targetList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("assess:target:add")
	String add(){
	    return "assess/target/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("assess:target:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		TargetDO target = targetService.get(id);
		model.addAttribute("target", target);
	    return "assess/target/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("assess:target:add")
	public R save( TargetDO target){
		if(targetService.save(target)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("assess:target:edit")
	public R update( TargetDO target){
		targetService.update(target);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("assess:target:remove")
	public R remove( Integer id){
		if(targetService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("assess:target:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		targetService.batchRemove(ids);
		return R.ok();
	}
	
}
