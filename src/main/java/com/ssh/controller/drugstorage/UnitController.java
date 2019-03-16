package com.ssh.controller.drugstorage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssh.pojos.Unit;
import com.ssh.service.drugstorage.UnitService;
import com.ssh.utils.Errors;
import com.ssh.vo.drugstorage.ParentTypeUnitVo;
import com.ssh.vo.drugstorage.UnitVo;

@Controller
public class UnitController {

	@Autowired
	private UnitService uService;
	
	/**
	 * 新增药品单位
	 * @param unitsName
	 * @return
	 */
	@PostMapping("/to_insert_unitName")
	@ResponseBody
	public Errors insertUnit(String unitsName){
		return uService.insertUnit(unitsName);
	}
	
	/**
	 * 查询是否有相同的药品单位名称
	 * @param unitsName
	 * @return
	 */
	@PostMapping("/to_find_unitName")
	@ResponseBody
	public Errors selectName(String unitsName){
		return uService.selectName(unitsName);
	}
	
	/**
	 * 按树状图查询所有药品单位
	 * @return
	 */
	@GetMapping("/to_select_allunit")
	@ResponseBody
	public List<ParentTypeUnitVo> selectAllUnit(){
		return uService.selectAllUnit();
	}
	
	/**
	 * 查询所有药品单位
	 * @return
	 */
	@PostMapping("/to_select_allunitName")
	@ResponseBody
	public List<UnitVo> selectAllUnitName(){
		return uService.selectAllUnitName();
	}
	
	/**
	 * 修改单位名称
	 * @param unitId
	 * @param unitName
	 * @return
	 */
	@PostMapping("/to_update_unitName")
	@ResponseBody
	public Errors updateUnit(Long unitId,String unitsName){
		return uService.updateUnitName(unitId, unitsName);
	}
}
