package com.ssh.controller.dean;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssh.pojos.DrugPurchase;
import com.ssh.service.dean.DrugCaigouJiluService;
import com.ssh.vo.drugstorage.DrugPurchaseDetaliVo;
import com.ssh.vo.drugstorage.DrugPurchaseVo;

@Controller
public class DrugCaigouJiluController {

	@Autowired
	private DrugCaigouJiluService dService;
	
	/**
	 * 查询所有采购记录
	 * @param page
	 * @param rows
	 * @return
	 */
	@GetMapping("/select_caigouJilu_all")
	@ResponseBody
	public List<DrugPurchaseVo> selectAll(int page , int rows){
		return dService.selectAll(page, rows);
	}
	
	/**
	 * 根据采购订单号查询详情
	 * @param drugPurchaseId
	 * @return
	 */
	@GetMapping("/to_select_xq_by_drugPurchaseId")
	@ResponseBody
	public List<DrugPurchaseDetaliVo> selectByPurchaseId(String drugPurchaseId){
		return dService.selectByPurchaseId(drugPurchaseId);
	}
	
	/**
	 * 根据采购订单号或供应商查询
	 * @param drugPurchaseId
	 * @param supplierName
	 * @param page
	 * @param rows
	 * @return
	 */
	@GetMapping("/to_select_By_IdAndSup")
	@ResponseBody
	public List<DrugPurchaseVo> selectByIdAndSup(String drugPurchaseId , String supplierName , int page ,int rows){
		return dService.selectByIdAndSup(drugPurchaseId, supplierName, page, rows);
	}
	
	/**
	 * 高级查询
	 * @param page
	 * @param rows
	 * @param startTime
	 * @param endTime
	 * @param drugPurchaseId
	 * @param supplierName
	 * @param state
	 * @return
	 */
	@GetMapping("/to_gaoji_find_by_time_id_zt")
	@ResponseBody
	public Map<String , Object> findgaoji(int page , int rows,Date startTime ,Date endTime,String drugPurchaseId,String drugPurchaseZt){
		System.out.println(startTime+"99099");
		System.out.println(endTime+"8888");
		System.out.println(drugPurchaseId+"777");
		System.out.println(drugPurchaseZt+"6666");
		 Map<String , Object> map = new HashMap<>();
		 List<DrugPurchaseVo> list = dService.findgaoji(page, rows, startTime, endTime, drugPurchaseId, drugPurchaseZt);
		 map.put("total", dService.queryMohufindCount());
		 map.put("rows", list);
		 return map;
	}
}
