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

import com.ssh.pojos.InstrumentY;
import com.ssh.service.instrument.CaigoService;
import com.ssh.service.instrument.YanshoService;
import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;
import com.ssh.vo.drugstorage.AcceptanceVo;
import com.ssh.vo.instrument.CgXIangqingVo;
import com.ssh.vo.instrument.InstrumentCaigouVo;
import com.ssh.vo.instrument.YanshoVo;
import com.ssh.vo.instrument.YanshoxiangqingVo;
import com.ssh.vo.instrument.ZyanshoxqVo;

@Controller
public class YanshoController {
	@Autowired
	public YanshoService servic;
	
	/**
	 * 
	 * 验收单号
	 */
	@GetMapping("/ysdanhao")
	@ResponseBody	
	public String ysdanhao(){
		return CommentOrder.commOrder(servic.yaig(),"QY");
		
	}
	//下方table显示数据
	@GetMapping("/ysdan_dao_table")
	@ResponseBody	
	public List<YanshoxiangqingVo> slelectqxxq(String instrumentYsId){
		return servic.slelectqxxq(instrumentYsId);
		
	}
	//挂单处理
	@PostMapping("/ysdan_chul_weichul")
	@ResponseBody
	public  Errors instrumentyans(InstrumentY ak , String instrumentCaigouId){
		return servic.instrumentyans(ak , instrumentCaigouId);
	}
	//修改
	@GetMapping("/update_dao_xinxi")
	@ResponseBody	
	public void updateinstrument(int id, BigDecimal HEGESHU) {
		servic.updateinstrument(id, HEGESHU);
	}
	//显
	@GetMapping("/select_dao_xinxi")
	@ResponseBody	
	public List<YanshoxiangqingVo> selectyanshoo(){
		return servic.selectyanshoo();
		
	}
	//查询验收记录
	@GetMapping("/find_instrument_yanshou_jilu")
	@ResponseBody
	public Map selectJilu(int page,int rows){
		List<YanshoVo> list=servic.selectJilu(page, rows);
		Map map=new HashMap<>();
		map.put("total",servic.count());
		map.put("rows", list);
		return map;
	}
	
	
	//查询验收andg供应商记录
	@GetMapping("/find_instrument_yanshouandgys_jilu")
	@ResponseBody
	public Map selectJiluandgys(int page,int rows){
		List<YanshoVo> list=servic.selectJiluandgys(page, rows);
		Map map=new HashMap<>();
		map.put("total",servic.count());
		map.put("rows", list);
		return map;
	}
	//输入框查询
		@GetMapping("/select_instrumentcaigo_where_ys")
		@ResponseBody
		public Map<String , Object> selecinstrumentWhereys(int page , int rows ,String instrumentYsId){
			Map<String , Object> map = new HashMap<>();
			List<YanshoVo> list =  servic.selectinstrumentcaigoWhereys(page, rows, instrumentYsId);
			map.put("total", servic.selectinstrumentcaigoWhereCountys(instrumentYsId));
			map.put("rows", list);
			return map;
		}
		//高级查询
		@GetMapping("/queryDate_andinstrument_String_ys")
		@ResponseBody
		public Map<String,Object> selectInstrumentyss(int page, int rows ,Date startTime,Date endTime,String instrumentYsId){
			List<YanshoVo> listo = servic.selectInstrumentys(page, rows, startTime, endTime, instrumentYsId);
			Map<String,Object> map = new HashMap<>();
			map.put("total", servic.queryDScountI());
			map.put("rows", listo);
			return map;
		}
		//查询不合格数量
		@GetMapping("/select_instrument_buhegeshuliang")
		@ResponseBody
		public List<YanshoVo> selectyanshoTuihuo(){
			return servic.selectyanshoTuihuo();
			
		}
	
}