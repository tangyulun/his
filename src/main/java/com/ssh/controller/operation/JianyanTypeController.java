package com.ssh.controller.operation;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssh.pojos.Jianyan;
import com.ssh.pojos.JianyanMess;
import com.ssh.pojos.JianyanMessXq;
import com.ssh.pojos.ShoushuMess;
import com.ssh.service.operation.JianyanMessService;
import com.ssh.service.operation.JianyanTypeService;
import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;
import com.ssh.vo.behospitalized.HospitalRegistrationVo;
import com.ssh.vo.dept.DeptVO;
import com.ssh.vo.instrument.YanshoxiangqingVo;
import com.ssh.vo.operation.JianyanMessVo;
import com.ssh.vo.operation.JianyanMessXqVo;
import com.ssh.vo.operation.JianyanRightVo;
import com.ssh.vo.operation.JianyanTypeVo;
import com.ssh.vo.operation.JianyanVo;
import com.ssh.vo.operation.JianyanXmVo;
import com.ssh.vo.operation.OperationVo;
import com.ssh.vo.operation.OutpaitentRegistVo;
import com.ssh.vo.operation.ParentTypeVo;
import com.ssh.vo.outpatient.FinancialTypeVo;

@Controller
public class JianyanTypeController {
	@Autowired
	private JianyanTypeService jianyantypeservice;
	
	@Autowired
	private JianyanMessService jianyanmesservice;
	
	/**
	 * 添加分类名称
	 * @param jianyanTypeName
	 * @return
	 */
	@PostMapping("add_jianyan_type")
	@ResponseBody
	public Errors addjianyantype(String jianyanTypeName){
		return jianyantypeservice.addJianyanType(jianyanTypeName);
	}
	/**
	 * 文件夹
	 * @return
	 */
	@GetMapping("/select_jiayan_type")
	@ResponseBody
	public List<ParentTypeVo> selectJianyanType(){
		return jianyantypeservice.selectJianyantype();
	}
	/**
	 * 右边的表格
	 * @param page
	 * @param rows
	 * @return
	 */
	@GetMapping("/select_jianyan_right")
	@ResponseBody
	public Map<String,Object> selectJianyanRight(int page ,int rows){
		Map<String,Object> map	=	new HashMap<>();
		List<JianyanVo> list =	jianyantypeservice.selectJianyanRight(page, rows);
		map.put("total", jianyantypeservice.count());
		map.put("rows", list);
		return map;
	}
	
	/**
	 * 添加检验项目
	 * @param jianyan
	 * @return
	 */
	@PostMapping("/add_jianyan_tj")
	@ResponseBody
	public  Errors addjianyantj(Jianyan jianyan,Long empId,Long jianyanTypeId){
		return jianyantypeservice.addJianyanTj(jianyan,empId,jianyanTypeId);
	}
	/**
	 * 随机编号
	 * @return
	 */
	@GetMapping("/tj_jianyan")
	@ResponseBody
	public String jianyanTj(){
		return jianyantypeservice.jianyanTj();
	}
	
	@GetMapping("/j_jianyan")
	@ResponseBody
	public String addjianyanGuadan(){
		return CommentOrder.commOrder(jianyanmesservice.addjianyanGuadan(),"JY");
	}
	/**
	 * 点击ul，刷新右边数据表格的方法
	 * @param page
	 * @param rows
	 * @param jianyantypeid
	 * @return
	 */
	@GetMapping("/qh_jianyan")
	@ResponseBody
	public Map<String,Object> qhjianyan(int page,int rows,long jianyantypeid){
		List<JianyanVo> list	=	jianyantypeservice.QueryJianyanId(page, rows, jianyantypeid);
		Map<String,Object> map=new HashMap<>();
		map.put("total", jianyantypeservice.findJianyanTypeCount(jianyantypeid));
		map.put("rows", list);
		return map;
	}
	/**
	 * 查询检验项目分类
	 * @return
	 */
		@GetMapping("/select_jianyan_fenlei")
		@ResponseBody
		public List<JianyanTypeVo> SelectJianyanFenlei(){
			return jianyantypeservice.SelectJianyanFenlei();
		}
		
		/**
		 * 查询表格
		 * @param page
		 * @param rows
		 * @param jianyanName
		 * @return
		 */
		@GetMapping("select_jianyanname_where")
		@ResponseBody
		public Map<String , Object> selectJianyanNameWhere(int page ,int rows,String jianyanName){
			Map<String , Object> map = new HashMap<>();
			List<JianyanVo> list = jianyantypeservice.selectJianyanNameWhere(page, rows, jianyanName);
			map.put("total", jianyantypeservice.selectJianyanNameCount(jianyanName));
			map.put("rows", list);
			return map;
		}
		/**
		 * 修改检验项目
		 * @param jianyan
		 * @param jianyanId
		 * @param jianyanTypeId
		 * @return
		 */
		@GetMapping("update_jianyan")
		@ResponseBody
		public Errors UpdateJianyan(Jianyan jianyan,String jianyanId , String jianyanTypeId){
			return jianyantypeservice.updateJianyan(jianyan, jianyanId, jianyanTypeId);
		}
		/**
		 * 修改分类ul
		 * @param jianyanTypeId
		 * @param jianyanTypeName
		 * @return
		 */
		@GetMapping("update_jianyan_ul")
		@ResponseBody
		public Errors UpdateJianyanUl(Long jianyanTypeId , String jianyanTypeName){
			return jianyantypeservice.updateJianyanUl(jianyanTypeId, jianyanTypeName);
		}
		/**
		 * 查询
		 * @param page
		 * @param rows
		 * @return
		 */
		@GetMapping("/select_JianyanMess_biaoge")
		@ResponseBody
		public Map<String, Object> selectJianyanMess(int page,int rows){
			Map<String,Object> map	=	new HashMap<>();
			List<JianyanMessVo> list =	jianyanmesservice.selectJianyanMess(page, rows);
			map.put("total", jianyanmesservice.count());
			map.put("rows", list);
			return map;
		}
		
	
		/**
		 * 根据id查询数据
		 * @param page
		 * @param rows
		 * @param jianyanMessId
		 * @return
		 */
		@GetMapping("select_JianyanMessAll_Id")
		@ResponseBody
		public Map<String ,Object> SelectJianyanMessAllId(int page, int rows,String jianyanMessId){
			List<JianyanMessVo> listb = jianyanmesservice.selectJianyanMessId(page, rows, jianyanMessId);
			Map<String,Object> mapb=new HashMap<>();
			mapb.put("total",jianyanmesservice.selectJianyanMessCount(jianyanMessId));
			mapb.put("rows", listb);
			return mapb;
		}
		
		/**
		 * 高级查询
		 * @param page
		 * @param rows
		 * @param firstTime
		 * @param endTime
		 * @param jianyanMessId
		 * @return
		 */
		@GetMapping("select_jianyanMess_Time")
		@ResponseBody
		public  Map<String,Object> selectMessTime(int page, int rows ,Date firstTime,Date endTime,String jianyanMessId){
			List<JianyanMessVo> listc = jianyanmesservice.selectMessTime(page, rows, firstTime, endTime, jianyanMessId);
			Map<String,Object> mapc = new HashMap<>();
			mapc.put("total", jianyanmesservice.jianyanMessTimecount());
			mapc.put("rows", listc);
			return mapc;
		}
		
		/**
		 * 检验管理挂单处理
		 * @param jianyanMess
		 * @param empId
		 * @param outpaitentRegistId
		 * @return
		 */
		@PostMapping("/insert_jianyan_guadan")
		@ResponseBody
		public Errors add1jianyanGuadan(String state,JianyanMess jianyanMess,Long empId,String outpaitentRegistId){
			System.err.println(empId+"\n"+outpaitentRegistId);
			return jianyanmesservice.addjianyanGuadan(state,jianyanMess, empId, outpaitentRegistId);
		}
		
		/**
		 * 检验详情加入添加表格
		 * @param jianyanmeessxq
		 * @param jianyanId
		 * @param jianyanMessId
		 * @return
		 */
		@PostMapping("/insert_jianyanmessxq_jiaru")
		@ResponseBody
		public Errors addJianyanMessXq(JianyanMessXq jianyanmeessxq,String jianyanId,String jianyanMessId){
			System.err.println(jianyanId+"\n"+jianyanMessId);
			return jianyanmesservice.addJianyanMessXq(jianyanmeessxq, jianyanId, jianyanMessId);
		}
		
		/**
		 * 详情表
		 * @param page
		 * @param rows
		 * @return
		 */
		@GetMapping("/select_jianyanmess_xq")
		@ResponseBody
		public List<JianyanMessXqVo> selectJianyanMessXq(){
			return jianyanmesservice.selectJianyanMessXq();
		}
		
		/**
		 * 清除
		 */
		@GetMapping("/qc_form_bd")
		@ResponseBody
		public void clear(){
			jianyanmesservice.clear();
		}
		
		/**
		 * 检验项目门诊点收费记录
		 * @param outpaitentRegistId
		 * @return
		 */
		@GetMapping("/select_menzhen_shoufei")
		@ResponseBody
		public List<JianyanXmVo> SelectmenzhenShoufei(String outpaitentRegistId){		
			return jianyanmesservice.selectAllMenzhen(outpaitentRegistId);
		}
		
		//修改
		@GetMapping("/update_jianyan_bianji")
		@ResponseBody	
		public void UpdapteJianyanBianji(int id,String csfw,String jiegao,String yichang) {
			jianyanmesservice.UpdapteJianyanBianji(id, csfw, jiegao, yichang);
		}
		//显
		@GetMapping("/select_jianyan_bianji")
		@ResponseBody	
		public List<JianyanXmVo> SelectJianyanBianji(){
			return jianyanmesservice.selectBianjiJianyanXm();
			
		}
		@GetMapping("/select_jianyan_menzhen")
		@ResponseBody
		public Errors SelectJianyanMenzhen(String outpaitentRegistId){
			return jianyanmesservice.SelectJianyanMenzhen(outpaitentRegistId);
		}
}

