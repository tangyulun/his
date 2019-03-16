package com.ssh.controller.drugstorage;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ssh.pojos.DrugPurchase;
import com.ssh.service.drugstorage.PurchaseService;
import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;
import com.ssh.vo.behospitalized.OutpaitentRegistVo;
import com.ssh.vo.drugstorage.BuydingdanVo;
import com.ssh.vo.drugstorage.DrugPurchaseVo;

@Controller
public class PurchaseController {
	@Autowired
	private PurchaseService PService;
	
	
	
	@GetMapping("to_purchase")
	@ResponseBody
	public String PNumber(){
		return CommentOrder.commOrder(PService.PNumber(), "CG");
	}
	
	/**
	 * 新增采购。。。。。。
	 * @param id
	 * @param drugId
	 * @param drugName
	 * @param num
	 * @param dw
	 * @param drugPfprice
	 * @param zprice
	 * @param ph
	 * @param bz
	 */
	@PostMapping("/to_insert_caigou_wa")
	@ResponseBody
	public void insertCaigou(String drugId,String drugName,BigDecimal num,
			String dw,BigDecimal drugPfprice,BigDecimal zprice,String ph,String bz){
				PService.insertCaigou(drugId, drugName, num, dw, drugPfprice, zprice, ph, bz);
	}
	
	/**
	 * 查询
	 * @return
	 */
	@GetMapping("/select_caigouxd_all")
	@ResponseBody
	public List<BuydingdanVo> selectCaiGouXDAll(){
		return PService.selectAll();
	}
	
	/**
	 * 清除
	 */
	@GetMapping("/clear_caigouxq")
	@ResponseBody
	public void clear(){
		PService.clear();
	}
	
	/**
	 * 添加挂单
	 * @param dp
	 * @param empId
	 * @param supplierId
	 * @return
	 */
	@PostMapping("/to_insert_guadan")
	@ResponseBody
	public Errors insertgd(DrugPurchase dp,Long empId,String supplierId , String state){
		return PService.insertguadan(dp, empId, supplierId , state);
	}
	
	/**
	 * 查询总金额
	 * @return
	 */
	@GetMapping("/select_z_money")
	@ResponseBody
	public double selectZMoney(){
		return PService.selectZMoney();
	}
	
	/**
	 * 删除采购记录
	 * @param xq
	 * @return
	 */
	@GetMapping("/delete_xq_pur")
	@ResponseBody
	public Errors deletexq(String xq){
		return PService.deletexd(CommentOrder.dealString(xq));
	}
	
	/**
	 * 修改挂单信息
	 * @param bd
	 * @param id
	 */
	@PostMapping("/update_caigou_xq")
	@ResponseBody
	public void updatecaigou(BuydingdanVo bd , int id){
		 PService.updatecaigou(bd, id);
	}
	
	/**
	 * 分页查询挂单信息
	 * @param page
	 * @param rows
	 * @return
	 */
	@GetMapping("/to_find_caigou_dingdan_fenye")
	@ResponseBody
	public Map selectguadan(int page,int rows){
		List<DrugPurchaseVo> list=PService.selectCaigoudan(page, rows);
		Map map=new HashMap<>();
		map.put("total", PService.count());
		map.put("rows", list);
		return map;
	}
	
	/**
	 * 根据订单号模糊查询
	 * @param page
	 * @param rows
	 * @param drugPurchaseId
	 * @return
	 */
	@GetMapping("/to_mohu_find_dingdan")
	@ResponseBody
	public Map<String , Object> mohufindDindan(int page,int rows,String drugPurchaseId){
		List<DrugPurchaseVo> list=PService.mohufindDingdan(page, rows, drugPurchaseId);
		Map<String,Object> map=new HashMap<>();
		map.put("total", PService.mohuCount(drugPurchaseId));
		map.put("rows", list);
		return map;
	}
	
	/**
	 * 高级查询从开始日期到截止日期来查询
	 * @param page
	 * @param rows
	 * @param startTime
	 * @param endTime
	 * @param drugPurchaseId
	 * @return
	 */
	@GetMapping("/to_select_startToend_gaoji")
	@ResponseBody
	public Map<String,Object> findStartDatetoEndDate(int page,int rows,Date startTime , Date endTime , String drugPurchaseId){
		Map<String , Object> map = new HashMap<>();
		List<DrugPurchaseVo> list=PService.findStartDatetoEndDate(page, rows, startTime, endTime, drugPurchaseId);
		map.put("total", PService.queryStartEndcount());
		map.put("rows", list);
		return map;
	}
	
	/**
	 * 查询详表显示在table中
	 * @param drugPurchaseId
	 * @return
	 */
	@GetMapping("/to_find_xiangbiao_xq")
	@ResponseBody
	public List<BuydingdanVo> findDingdanxq(String drugPurchaseId){
		return PService.selectdingdanxq(drugPurchaseId);
	}
	
	/**
	 * 根据供应商id查询采购历史
	 * @param supplierId
	 * @return
	 */
	@GetMapping("/to_find_drugPurchase_BySupplierId")
	@ResponseBody
	public List<DrugPurchaseVo> selectSupplier(String supplierId){
		return PService.selectSupplier(supplierId);
	}
}
