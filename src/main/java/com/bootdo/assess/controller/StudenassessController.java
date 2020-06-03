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

import com.bootdo.assess.domain.StudenassessDO;
import com.bootdo.assess.service.StudenassessService;
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
@RequestMapping("/assess/studenassess")
public class StudenassessController {
	@Autowired
	private StudenassessService studenassessService;
	
	@GetMapping()
	@RequiresPermissions("assess:studenassess:studenassess")
	String Studenassess(){
	    return "assess/studenassess/studenassess";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("assess:studenassess:studenassess")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<StudenassessDO> studenassessList = studenassessService.list(query);
		int total = studenassessService.count(query);
		PageUtils pageUtils = new PageUtils(studenassessList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("assess:studenassess:add")
	String add(){
	    return "assess/studenassess/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("assess:studenassess:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		StudenassessDO studenassess = studenassessService.get(id);
		model.addAttribute("studenassess", studenassess);
	    return "assess/studenassess/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("assess:studenassess:add")
	public R save( StudenassessDO studenassess){
		if(studenassessService.save(studenassess)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("assess:studenassess:edit")
	public R update( StudenassessDO studenassess){
		studenassessService.update(studenassess);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("assess:studenassess:remove")
	public R remove( Integer id){
		if(studenassessService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("assess:studenassess:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		studenassessService.batchRemove(ids);
		return R.ok();
	}
	
}
