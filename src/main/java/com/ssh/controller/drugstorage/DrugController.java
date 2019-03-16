package com.ssh.controller.drugstorage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssh.pojos.Drug;
import com.ssh.service.drugstorage.DrugService;
import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;
import com.ssh.vo.drugstorage.DrugTypeVo;
import com.ssh.vo.drugstorage.DrugVo;
import com.ssh.vo.drugstorage.ParentTypeDrugVo;

@Controller
public class DrugController {

	@Autowired
	private DrugService dService;
	
	/**
	 * 添加药品分类
	 * @param SName
	 * @return
	 */
	@PostMapping("/to_insert_drugType")
	@ResponseBody
	public Errors insertDrugType(String drugTypeName){
		return dService.insertDrugType(drugTypeName);
	}
	
	/**
	 * 自动生成药品id
	 * @return
	 */
	@GetMapping("/to_find_drugId")
	@ResponseBody
	public String findDrugId(){
		return dService.findDrugId();
	}
	
	/**
	 * 查询药品分类用树状图显示
	 * @return
	 */
	@GetMapping("/to_select_drugType_tree")
	@ResponseBody
	public List<ParentTypeDrugVo> selectAllDrugType(){
		return dService.selectAllDrugType();
	}
	
	/**
	 * 查询所有药品分类
	 * @return
	 */
	@PostMapping("/to_select_drugType")
	@ResponseBody
	public List<DrugTypeVo> selectDrugTypeName(){
		return dService.selectDrugTypeName();
	}
	
	/**
	 * 查询是否有相同的药品分类名称
	 * @param drugTypeName
	 * @return
	 */
	@PostMapping("/to_select_drugType_Name")
	@ResponseBody
	public Errors selectName(String drugTypeName){
		return dService.selectName(drugTypeName);
	}
	
	/**
	 * 分页查询药品信息
	 * @param page
	 * @param rows
	 * @return
	 */
	@GetMapping("/to_select_drug_fenye")
	@ResponseBody
	public Map findAllDrug(int page,int rows){
		List<DrugVo> list=dService.findAllDrug(page, rows);
		Map map=new HashMap<>();
		map.put("total", dService.count());
		map.put("rows", list);
		return map;
	}
	
	
	/**
	 * 新增药品
	 * @param DTypeId
	 * @param SupId
	 * @param drug
	 * @return
	 */
	@PostMapping("/to_insert_drug")
	@ResponseBody
	public Errors insertDrug(Long DTypeId,Long Unita,int sx,int xx,Drug drug,int yaokuKucunTop,int yaokuKucunBottom){
		return dService.insertDrug(DTypeId, Unita, drug, sx, xx, yaokuKucunTop, yaokuKucunBottom);
	}
	
	/**
	 * 修改药品
	 * @param drugId
	 * @param drug
	 * @param supplierId
	 * @param DTypeId
	 * @param Unita
	 * @param sx
	 * @param xx
	 * @return
	 */
	@PostMapping("/to_update_drugall")
	@ResponseBody
	public Errors upadteDrug(Drug drug,Long DTypeId,Long Unita,int sx,int xx,int yaokuKucunTop,int yaokuKucunBottom){
		return dService.upadteDrug(drug, DTypeId, Unita, sx, xx, yaokuKucunTop, yaokuKucunBottom);
	}
	
	/**
	 * 根据药品分类查询药品信息
	 * @param page
	 * @param rows
	 * @param DTypeId
	 * @return
	 */
	@GetMapping("/to_select_drug_byTypeId")
	@ResponseBody
	public Map findDrugByTypeId(int page,int rows,Long DTypeId){
		List<DrugVo> dv= dService.findDrugByTypeId(page, rows, DTypeId);
		Map<String,Object> map=new HashMap<>();
		map.put("total", dService.findDrugByTypeIdCount(DTypeId));
		map.put("rows", dv);
		return map;
	}
	
	/**
	 * 模糊查询药品信息
	 * @param drugName
	 * @param page
	 * @param rows
	 * @return
	 */
	@GetMapping("/to_mohufind_drug_byName")
	@ResponseBody
	public Map<String,Object> mohufindDrugByName(String drugName,int page,int rows){
		List<DrugVo> dv=dService.mohufindDrugByName(page, rows, drugName);
		Map<String,Object> map=new HashMap<>();
		map.put("total", dService.mohufindDrugByNameCount(drugName));
		map.put("rows", dv);
		return map;
	}
	
	/**
	 * 分页查询药品信息
	 * @param page
	 * @param rows
	 * @return
	 */
	@GetMapping("/to_find_drug_byfenye")
	@ResponseBody
	public List<DrugVo> findDrugByfenye(int page,int rows){
		return dService.findDrugByfenye(page, rows);
	}
	
	/**
	 * 根据药品分类id修改药品分类名
	 * @param drugTypeId
	 * @param drugTypeName
	 * @return
	 */
	@GetMapping("/to_update_drugType_byID")
	@ResponseBody
	public Errors updateDrugById(Long drugTypeId,String drugTypeName){
		return dService.updateDrugById(drugTypeId, drugTypeName);
	}
	
	/**
	 * 查询库存大于0的库存
	 * @param page
	 * @param rows
	 * @return
	 */
	@GetMapping("/to_selectDrug_ByKucun")
	@ResponseBody
	public Map selectDrugByKucun(int page , int rows){
		List<DrugVo> list=dService.selectDrugByKucun(page, rows);
		Map map=new HashMap<>();
		map.put("total", dService.count());
		map.put("rows", list);
		return map;
	}
}
