package com.ssh.controller.drugstorage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssh.pojos.Supplier;
import com.ssh.pojos.SupplierType;
import com.ssh.service.drugstorage.SupplierService;
import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;
import com.ssh.vo.drugstorage.ParentTypeVo;
import com.ssh.vo.drugstorage.SupplierTypeVo;
import com.ssh.vo.drugstorage.SupplierVo;

@Controller
public class SupplierController {
	
	@Autowired
	private SupplierService sService;
	
	@GetMapping("/to_supplier")
	public String findsth(Model model){
		List<SupplierVo> list=sService.findAll();
		for (SupplierVo s : list) {
			System.err.println(s.getSupplierName());
		}
		model.addAttribute("list", list);
		return "drugstorage/aa";
	}
	
	/**
	 * 添加供应商分类
	 * @param SName
	 */
	@PostMapping("/to_add_supplierType")
	@ResponseBody
	public Errors insertSupType(String SName){
		return sService.insertSupplierType(SName);
	}
	
	/**
	 * 自动生成id编号
	 * @return
	 */
	@GetMapping("/to_find_supplierId")
	@ResponseBody
	public String findId(){
		return sService.findId();
	}
	
	/**
	 * 分页查询所有供应商
	 * @param model
	 * @return
	 */
	@GetMapping("/to_findAll_supplier")
	@ResponseBody
	public Map selectAllSupplier(int page,int rows){
		List<SupplierVo> listVo=sService.selectAllSupplier(page,rows);
		Map map=new HashMap<>();
		map.put("total", sService.count());
		map.put("rows", listVo);
		return map;
	}
	
	/**
	 * 查询所有供应商
	 * @param model
	 * @return
	 */
	@GetMapping("/to_allSupplier")
	@ResponseBody
	public List<SupplierVo> selectAll(){
		return sService.selectAll();
	}
	
	/**
	 * 根据id删除供应商
	 * @param supplierId
	 * @return
	 */
	@GetMapping("/to_delete_supplier")
	@ResponseBody
	public Errors deteleSupplier(String supplierId){
		return  sService.deleteOneSupplier(supplierId);
	}
	
	/**
	 * 查询树状图中的数据
	 * @return
	 */
	@GetMapping("/to_find_supplierType")
	@ResponseBody
	public List<ParentTypeVo> findAllSupplierType(){
		return sService.findSupplierType();
	}
	
	/**
	 * 查询所有供应商分类
	 * @return
	 */
	@PostMapping("/to_select_supplierType")
	@ResponseBody
	public List<SupplierTypeVo> selectSupplierType(){
		return sService.findAllSupplierType();
	}
	
	/**
	 * 查询是否有相同的分类名称
	 * @param supplierTypeName
	 * @return
	 */
	@PostMapping("/to_find_supplierTypeName")
	@ResponseBody
	public Errors findSupplierTypeName(String SName){
		return sService.findSupplierTypeName(SName);
	}
	
	/**
	 * 根据分类id修改分类名称
	 * @param supplierId
	 * @param stype
	 * @return
	 */
	@PostMapping("/to_update_supplierTypeName")
	@ResponseBody
	public Errors updateSupplierTYpe(Long supplierTypeId,String supplierTypeName){
		return sService.updateSupplierType(supplierTypeId, supplierTypeName);
	}
	
	/**
	 * 根据供应商id修改供应商信息
	 * @param supplierId
	 * @param sup
	 * @return
	 */
	@GetMapping("/to_update_supplier")
	@ResponseBody
	public Errors updateSupplier(String supplierId,Supplier sup,Long TypeId){
		return sService.updateSupplier(supplierId, sup,TypeId);
	}
	
	/**
	 * 根据供应商分类分页查询供应商信息
	 * @param page
	 * @param rows
	 * @param typeId
	 * @return
	 */
	@GetMapping("/to_fenye_findSupplier")
	@ResponseBody
	public Map<String,Object> querySupplierType(int page,int rows,long typeId){
		List<SupplierVo> list=sService.querySupplierTypeId(page, rows, typeId);
		Map<String,Object> map=new HashMap<>();
		map.put("total", sService.querySupplierTypeCount(typeId));
		map.put("rows", list);
		return map;
	}
	
	/**
	 * 模糊查询供应商信息
	 * @param supplierName
	 * @return
	 */
	@GetMapping("/to_findMohu_Supplier")
	@ResponseBody
	public Map<String , Object> findMohuSupplier(String supplierName,int page,int rows){
		List<SupplierVo> list=sService.mohufindSupplier(page, rows, supplierName);
		Map<String,Object> map=new HashMap<>();
		map.put("total", sService.mohuoSuplierCount(supplierName));
		map.put("rows", list);
		return map;
	}
	
	/**
	 * 新增供应商
	 * @param StypeId
	 * @param supplier
	 * @return
	 */
	@RequestMapping("/to_insert_supplier")
	@ResponseBody
	public Errors insertSupplier(Long TypeId,Supplier supplier){
		return sService.insertSupplier(TypeId, supplier);
	}
	
	/**
	 * 根据供应商id修改供应商信息
	 * @param supplierId
	 * @param sup
	 * @return
	 */
	@RequestMapping("/to_update_SupplierAll")
	@ResponseBody
	public Errors upadteSupplier(String supplierId,Supplier sup,Long TypeId){
		return sService.updateSupplier(supplierId, sup,TypeId);
	}
}
