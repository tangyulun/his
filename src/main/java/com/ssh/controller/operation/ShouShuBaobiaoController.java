package com.ssh.controller.operation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssh.service.operation.ShoushuBaoBiaoService;
import com.ssh.vo.operation.JianyanMessVo;
import com.ssh.vo.operation.ShouBaobiaoVo;
import com.ssh.vo.operation.ShouShuMessVo;
import com.ssh.vo.operation.ShouShuXqVo;

@Controller
public class ShouShuBaobiaoController {
	@Autowired
	private ShoushuBaoBiaoService shoushubaobiaoService;
	/**
	 * 数据表格
	 * @param page
	 * @param rows
	 * @return
	 */
	@GetMapping("/select_mess_shujubiaoge")
	@ResponseBody
	public List<ShouShuMessVo> selectShoushuMessBaobiao(int page,int rows){
		return shoushubaobiaoService.selectShoushuMessBaobiao(page, rows);
	}
	
	/**
	 * 高级查询
	 * @param page
	 * @param rows
	 * @param aTime
	 * @param bTime
	 * @param shoushuMess
	 * @return
	 */
	@GetMapping("/select_Time_chaxun")
	@ResponseBody
	public Map<String,Object> selectGaojiTime(int page,int rows,Date aTime,Date bTime,String shoushuMess){
		List<ShouShuMessVo> listc=shoushubaobiaoService.selectShoushuTime(page, rows, aTime, bTime, shoushuMess);
		Map<String,Object> map=new HashMap<>();
		map.put("total", shoushubaobiaoService.shoushuMessTimecount());
		map.put("rows", listc);
		return map;
	}
	
	/**
	 * 根据Id查询输入框
	 * @return
	 */
	@GetMapping("/select_Id_Chaxun")
	@ResponseBody
	public Map<String ,Object> SelectIdchaxun(int page, int rows,String shoushuMess){
		Map<String,Object> mapa=new HashMap<>();
		List<ShouShuMessVo> list=shoushubaobiaoService.SelectShoushuMessAllId(page, rows, shoushuMess);
		mapa.put("total", shoushubaobiaoService.SelectShoushucount(shoushuMess));
		mapa.put("rows", list);
		return mapa;
	}
	
	/**
	 * 根据Id点下表
	 * @param shoushuMess
	 * @return
	 */
	@GetMapping("/select_shoushu_xq")
	@ResponseBody
	public List<ShouShuXqVo> selectShoushuXq(String shoushuMess){
		System.out.println(shoushuMess);
		return shoushubaobiaoService.selectShoushuXq(shoushuMess);
	}
}
