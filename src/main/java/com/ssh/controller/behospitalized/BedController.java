package com.ssh.controller.behospitalized;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssh.pojos.Bed;
import com.ssh.pojos.Financial;
import com.ssh.service.behospitalized.BedService;
import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;
import com.ssh.vo.behospitalized.BedVo;
import com.ssh.vo.behospitalized.HouseTypeVo;

@Controller
public class BedController {
	@Autowired
	private BedService bedservice;
	/**
	 * 获取病房号
	 * @return
	 */
	@GetMapping("/get_bed_number")
	@ResponseBody
	public String getNumber(){
		return bedservice.getNumber();
	}
	/**
	 * 添加病房
	 * @param bed
	 * @return
	 */
	@PostMapping("/add_bed")
	@ResponseBody
	public Errors addNewBed(Bed bed,Long bedTypeId,Long houseTypeId,Long empId) {
		return bedservice.addBed(bed,bedTypeId,houseTypeId,empId);
	}
	/**
	 * 查询所有病房
	 * @param page
	 * @param rows
	 * @return
	 */
	@GetMapping("/select_all_bed")
	@ResponseBody
	public Map<String , Object> selectAllBed(int page , int rows){
		Map<String , Object> map = new HashMap<>();
		List<BedVo> list = bedservice.selectAllBed(page, rows);
		map.put("total", bedservice.count());
		map.put("rows", list);
		return map;
 	}
	/**
	 * 根据ul来查询病房
	 * @param page
	 * @param rows
	 * @param bedTypeId
	 * @return
	 */
	@GetMapping("/query_bed_type")
	@ResponseBody
	public Map<String , Object> queryBedType(int page , int rows,Long bedTypeId){
		List<BedVo> list = bedservice.selectBedTypeId(page, rows, bedTypeId);
		Map<String , Object> map = new HashMap<>();
		map.put("total", bedservice.queryBTCount(bedTypeId));
		map.put("rows", list);
		return map;
 	}
	
	/**
	 * 获取病床分类
	 * @return
	 */
	@PostMapping("/get_house_type")
	@ResponseBody
	public List<HouseTypeVo> getBedType(){
		return bedservice.getHouseType();
	}
	/**
	 * 根据bedName来查询
	 * @param page
	 * @param rows
	 * @param bedName
	 * @return
	 */
	@GetMapping("/select_bedName_where")
	@ResponseBody
	public Map<String , Object> selectBedNameWhere(int page , int rows , String bedName){
		Map<String , Object> map = new HashMap<>();
		List<BedVo> list = bedservice.selectBedNameWhere(page, rows, bedName);
		map.put("total", bedservice.selectBedNameWhereCount(bedName));
		map.put("rows", list);
		return map;
	}
	
	/**
	 * 修改病房
	 * @param bed
	 * @param bedTypeId
	 * @param houseTypeId
	 * @param empId
	 * @return
	 */
	@PostMapping("/update_bed")
	@ResponseBody
	public Errors updateBed(Bed bed,String bedId,Long bedTypeId,Long houseTypeId,Long empId){
		return bedservice.updateBed(bed, bedId, bedTypeId, houseTypeId, empId);
	}
	/**
	 * 修改病房分类名称
	 * @param bedTypeId
	 * @param bedTypeName
	 * @return
	 */
	@GetMapping("/update_bedTypeName")
	@ResponseBody
	public Errors updataBedTypeName(Long bedTypeId,String bedTypeName){
		return bedservice.updataBedTypeName(bedTypeId, bedTypeName);
	}
	
}
