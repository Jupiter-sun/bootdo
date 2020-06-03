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

import com.bootdo.assess.domain.AssessConfigDO;
import com.bootdo.assess.service.AssessConfigService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 考核占比表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-06-02 00:19:38
 */
 
@Controller
@RequestMapping("/assess/assessConfig")
public class AssessConfigController {
	@Autowired
	private AssessConfigService assessConfigService;
	
	@GetMapping()
	@RequiresPermissions("assess:assessConfig:assessConfig")
	String AssessConfig(){
	    return "assess/assessConfig/assessConfig";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("assess:assessConfig:assessConfig")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<AssessConfigDO> assessConfigList = assessConfigService.list(query);
		int total = assessConfigService.count(query);
		PageUtils pageUtils = new PageUtils(assessConfigList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("assess:assessConfig:add")
	String add(){
	    return "assess/assessConfig/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("assess:assessConfig:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		AssessConfigDO assessConfig = assessConfigService.get(id);
		model.addAttribute("assessConfig", assessConfig);
	    return "assess/assessConfig/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("assess:assessConfig:add")
	public R save( AssessConfigDO assessConfig){
		if(assessConfigService.save(assessConfig)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("assess:assessConfig:edit")
	public R update( AssessConfigDO assessConfig){
		assessConfigService.update(assessConfig);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("assess:assessConfig:remove")
	public R remove( Integer id){
		if(assessConfigService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("assess:assessConfig:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		assessConfigService.batchRemove(ids);
		return R.ok();
	}
	
}
