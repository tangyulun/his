
package com.ssh.controller.instrument;

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

import com.ssh.pojos.InstrumentCaigou;
import com.ssh.service.instrument.CaigoService;
import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;
import com.ssh.vo.instrument.CgXIangqingVo;
import com.ssh.vo.instrument.InstrumentCaigouVo;
import com.ssh.vo.instrument.InstrumentVo;
import com.ssh.vo.outpatient.FinacialVo;
import com.ssh.vo.outpatient.MedicalVo;

@Controller
public class CaigoController {
	@Autowired
	public CaigoService servicecaig;
	
	/**
	 * 
	 * 采购单号
	 */
	@RequestMapping("/cgdanhao")
	@ResponseBody	
	public String cgdanhao(){
		return CommentOrder.commOrder(servicecaig.caig(),"QC");
		
	}
	
	@RequestMapping("/cgdanhaoid")
	@ResponseBody	
	public String cgdanhaoid(){
		return servicecaig.caigid();
		
	}
	
	//查询
	@GetMapping("/select_instrumentscaig_types")
	@ResponseBody	
	public Map<String , Object> selectallinstrumentcaig(int page, int rows){
		Map<String , Object> map= new HashMap<>();
		List<InstrumentCaigouVo> list=servicecaig.selectInstrumencaig(page, rows);
		map.put("total", servicecaig.count());
		map.put("rows", list);
		return map;
		
			
	}
	//输入框查询
	@GetMapping("/select_instrumentcaigo_where")
	@ResponseBody
	public Map<String , Object> selecinstrumentWhere(int page , int rows ,String instrumentCaigouId){
		Map<String , Object> map = new HashMap<>();
		List<InstrumentCaigouVo> list =  servicecaig.selectinstrumentcaigoWhere(page, rows, instrumentCaigouId);
		map.put("total", servicecaig.selectinstrumentcaigoWhereCount(instrumentCaigouId));
		map.put("rows", list);
		return map;
	}
	//高级查询
	@GetMapping("/queryDate_andinstrument_String")
	@ResponseBody
	public Map<String,Object> selectInstrument(int page, int rows ,Date startTime,Date endTime,String instrumentCaigouId){
		
		List<InstrumentCaigouVo> listo = servicecaig.selectInstrument(page, rows ,startTime,endTime,instrumentCaigouId);
		Map<String,Object> map = new HashMap<>();
		map.put("total", servicecaig.queryDScountI());
		map.put("rows", listo);
		return map;
	}
	//点击如入
	@PostMapping("/get_andinstrument_String")
	@ResponseBody
	public void InstrumentCaigouer(String instrumentId,String instrumentName,BigDecimal SHULIANG,String DANWEI,BigDecimal DANJIA,BigDecimal JINE,String BEIZHU){
		servicecaig.InstrumentCaigou(instrumentId, instrumentName, SHULIANG, DANWEI, DANJIA, JINE, BEIZHU);
	}
	//查询
	@GetMapping("/get_andinstrument")
	@ResponseBody
	public List<CgXIangqingVo> selectinstrumen(){
		return servicecaig.selectinstrumen();
		
	}
	@GetMapping("/clear_instrument")
	@ResponseBody
	public void clear(){
		servicecaig.clear();
	}
	//添加挂单
	@PostMapping("/get_instrument_String")
	@ResponseBody
	public Errors instrumentguad(InstrumentCaigou ab,String supplierId,String state){
		return servicecaig.instrumentguadan(ab, supplierId,state);
		
	}
	@GetMapping("/delect_instrument")
	@ResponseBody
	//删除采购记录
	public Errors delectinstrument(String qx){
		return servicecaig.deletextinstrument(CommentOrder.dealString(qx));
		
	}
	
	
	@GetMapping("/jisuan_instrument")
	@ResponseBody
	//计算总价格
	public double jisuaniinstrument(){
		return servicecaig.jisuanZMoney();
		
	}
	@PostMapping("/up_instrument_String")
	@ResponseBody
	public void updatinstrument(CgXIangqingVo bb , int cGid){
		servicecaig.updateinstrument(bb, cGid);
	}
	
	//查询显示在table中
	@GetMapping("/select_instrumentna")
	@ResponseBody
	public List<CgXIangqingVo> findinstrumentna(String instrumentCaigouId){
		return servicecaig.selectdingdanxq(instrumentCaigouId);
		
	}
}
