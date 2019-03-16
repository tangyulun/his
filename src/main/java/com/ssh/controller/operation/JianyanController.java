package com.ssh.controller.operation;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssh.service.operation.JianyanBaoBiaoService;
import com.ssh.vo.operation.JianyanMessVo;
import com.ssh.vo.operation.JianyanMessXqVo;

@Controller
public class JianyanController {
	@Autowired
	private JianyanBaoBiaoService jianyanmebaobiaoservice;
	
	@GetMapping("/select_shujubiaoge")
	@ResponseBody
	public List<JianyanMessVo> selectJianyanMess(int page, int rows){
			return jianyanmebaobiaoservice.selectJianyanMessBaobiao(page, rows);
	}
	
	/**
	 * 根据ID
	 * @param JianyanMessId
	 * @return
	 */
	@GetMapping("/select_xq_shujubiaoge")
	@ResponseBody
	public List<JianyanMessXqVo> selectJianyanMessXq(String JianyanMessId){
		System.out.println(JianyanMessId);
			return jianyanmebaobiaoservice.selectJianyanMessXq(JianyanMessId);
	}
	
	/**
	 *根据Id查询 输入框
	 * @param page
	 * @param rows
	 * @param jianyanMessId
	 * @return
	 */
	@GetMapping("/select_Chaxun_ID")
	@ResponseBody
	public  Map<String ,Object> SelectJianyanMessAllId(int page, int rows,String jianyanMessId){
		Map<String,Object> mapa=new HashMap<>();
		List<JianyanMessVo> listb=jianyanmebaobiaoservice.SelectJianyanMessAllId(page, rows, jianyanMessId);
		mapa.put("total", jianyanmebaobiaoservice.selectJianyanMessCount(jianyanMessId));
		mapa.put("rows", listb);
		return mapa;
	}
	
	/**
	 * 高级查询的Controller
	 * @param page
	 * @param rows
	 * @param oneTime
	 * @param trueTime
	 * @param jianyanMessId
	 * @return
	 */
	@GetMapping("/select_Chaxun_Time")
	@ResponseBody
	public  Map<String,Object> selectGaojiTime(int page,int rows,Date oneTime,Date trueTime,String jianyanMessId){
		List<JianyanMessVo> listc=jianyanmebaobiaoservice.selectGaojiTime(page, rows, oneTime, trueTime, jianyanMessId);
		Map<String,Object> map = new HashMap<>();
		map.put("total",jianyanmebaobiaoservice.jianyanMessTimecount());
		map.put("rows", listc);
		return map;
	}
}
