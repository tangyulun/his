package com.ssh.controller.operation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssh.pojos.Shoushu;
import com.ssh.pojos.ShoushuMess;
import com.ssh.service.operation.SugeryService;
import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;
import com.ssh.vo.operation.SelectFinanVo;
import com.ssh.vo.operation.ShouShuTypeVo;
import com.ssh.vo.operation.ShouShuVo;
import com.ssh.vo.operation.ShoushuChuanzhiVo;
import com.ssh.vo.operation.SurgeryTypeVo;

@Controller
public class SugeryController {
	@Autowired
	private SugeryService syservice;
	
	/**
	 * 添加手术分类
	 * @param shoushuTypeName
	 * @return
	 */
	@PostMapping("add_shoushu_type")
	@ResponseBody
	public Errors selectAddss(String shoushuTypeName){
			return syservice.selectAddss(shoushuTypeName);
	}
	
	/**
	 * 手术树形文件夹
	 * @return
	 */
	@GetMapping("/select_shoushu_type")
	@ResponseBody
	public List<SurgeryTypeVo> selectshoushutype(){
		return syservice.selectshoushutype();
	}
	
	/**
	 * 验证手术分类是否存在
	 * @param shoushuTypeName
	 * @return
	 */
	@PostMapping("/sugery_ssfl_name")
	@ResponseBody
	public Errors sugeryKeshiclassName(String shoushuTypeName){
		return syservice.sugeryflclassName(shoushuTypeName);
	}
	
	/**
	 * 添加手术项目编号
	 * @return
	 */
	@GetMapping("/tj_sugeryxm")
	@ResponseBody
	public String TjSugeryxm(){
		return syservice.selectSugeryTjbh();
	}
	
	/**
	 * 查询手术项目分类
	 * @return
	 */
		@GetMapping("/select_sugery_fenlei")
		@ResponseBody
		public List<ShouShuTypeVo> SelectSugeryFenlei(){
			return syservice.SelectSugeryIdFl();
		}
		/**
		 * 右边的表格
		 * @param page
		 * @param rows
		 * @return
		 */
		@GetMapping("/select_sugery_right")
		@ResponseBody
		public Map<String,Object> selectSugeryRight(int page ,int rows){
			Map<String,Object> map	=	new HashMap<>();
			List<ShouShuVo> list =	syservice.selectShoushuRight(page, rows);
			map.put("total", syservice.count());
			map.put("rows", list);
			return map;
		}
		/**
		 * 查询表格
		 * @param page
		 * @param rows
		 * @param jianyanName
		 * @return
		 */
		@GetMapping("select_shoushuname_where")
		@ResponseBody
		public Map<String , Object> selectShoushunameWhere(int page ,int rows,String shoushuName){
			Map<String , Object> map = new HashMap<>();
			List<ShouShuVo> list = syservice.selectShoushuNameWhere(page, rows, shoushuName);
			map.put("total", syservice.selectShoushusNameCount(shoushuName));
			map.put("rows", list);
			return map;
		}
		/**
		 * 添加手术项目
		 * @param jianyan
		 * @return 
		 */
		@PostMapping("/add_shoushu_tj")
		@ResponseBody
		public  Errors addShoushuTj(Shoushu shoushu,Long empId,Long dclassId,Long shoushuTypeId){
			System.err.println(empId +"\n"+dclassId+"\n"+shoushuTypeId);
			return syservice.addShoushuxm(shoushu,empId,dclassId,shoushuTypeId);
		}
		/**
		 * 编辑手术项目
		 * @param shoushu
		 * @param shoushuId
		 * @param shoushuTypeId
		 * @return
		 */
		@GetMapping("update_shoushu")
		@ResponseBody
		public Errors updateSugery(Shoushu shoushu,String shoushuId,Long shoushuTypeId){
			return syservice.updateSugery(shoushu, shoushuId, shoushuTypeId);
		}
		
		/**
		 * 点击ul，刷新右边数据表格的方法
		 * @param page
		 * @param rows
		 * @param jianyantypeid
		 * @return
		 */
		@GetMapping("/qh_shoushu")
		@ResponseBody
		public Map<String,Object> qhShoushu(int page,int rows,Long shoushuTypeId){
			List<ShouShuVo> list=syservice.findShoushuTypeId(page, rows, shoushuTypeId);
			Map<String,Object> map=new HashMap<>();
			map.put("total", syservice.findShoushuTypeCount(shoushuTypeId));
			map.put("rows", list);
			return map;
		}
		/**
		 * 手术室挂单处理
		 * @param shoushuMess
		 * @param empId
		 * @param hospitalRegistrationId
		 * @return
		 */
		@PostMapping("/insert_guadan")
		@ResponseBody
		public Errors addShoushuGd(String state,ShoushuMess shoushuMess,Long empId,String hospitalRegistrationId,String shoushuId){
			return syservice.addShoushuGd(state, shoushuMess, empId, hospitalRegistrationId,shoushuId);
		}
		
		/**
		 * 根据日期模糊查询编号方法
		 * @return
		 */
		@GetMapping("/shoushu_bh")
		@ResponseBody
		public String addShoushuGd(){
			return CommentOrder.commOrder(syservice.addShoushuGd(),"SS");
		}
		/**
		 * 查询表
		 * @param page
		 * @param rows
		 * @return
		 */
		@GetMapping("/select_fianialHistory")
		@ResponseBody
		public Map<String , Object> selectfinan(int page , int rows){
			Map<String,Object> map	=	new HashMap<>();
			List<SelectFinanVo> list =	syservice.selectfinan(page, rows);
			map.put("total",syservice.countb());
			map.put("rows", list);
			return map;
		}
		
		/**
		 * 修改手术分类
		 * @param shoushuTypeId
		 * @param shoushuTypeName
		 * @return
		 */
		@GetMapping("/update_shoushu_ul")
		@ResponseBody
		public Errors updateShoushuUl(Long shoushuTypeId, String shoushuTypeName){
			return syservice.updateShoushuUl(shoushuTypeId, shoushuTypeName);
		}
		
		/**
		 * 手术主页面点击住院号传值到下面手术治疗表格中
		 * @param hospitalRegistrationId
		 * @return
		 */
		@GetMapping("/select_Shoushu_Zhuyuan")
		@ResponseBody
		public 	List<ShoushuChuanzhiVo> SelectChuanZhi(String hospitalRegistrationId){
			return syservice.SelectChuanZhi(hospitalRegistrationId);
		}
		//修改
		@GetMapping("/update_select_shoushu")
		@ResponseBody
		public void updateSelectShoushu(int id,String jieguo){
			 syservice.UpdateShouShuBianji(id, jieguo);
		}
		//查
		@GetMapping("/select_shoushu_bianji")
		@ResponseBody
		public List<ShoushuChuanzhiVo> selectShoushuBianji(){
			return syservice.selectShoushuBianji();
		}
		
		@GetMapping("/select_panduan_zhuyuan")
		@ResponseBody
		public Errors SelectShoushuPanduan(String hospitalRegistrationId){
			return syservice.SelectShoushuPanduan(hospitalRegistrationId);
		}
}
