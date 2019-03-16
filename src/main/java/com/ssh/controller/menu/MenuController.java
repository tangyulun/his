package com.ssh.controller.menu;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;

import com.alibaba.fastjson.JSONException;
import com.ssh.pojos.Emp;
import com.ssh.pojos.QianDao;
import com.ssh.service.login.LoginService;
import com.ssh.service.menu.MenuService;
import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;
import com.ssh.vo.doctor.ChuQinVO;
import com.ssh.vo.login.LoginLoggerVO;
import com.ssh.vo.menu.CityVO;
import com.ssh.vo.menu.FunctionTypeVo;
import com.ssh.vo.menu.QianDaoVO;

@Controller
public class MenuController {
	@Autowired
	private MenuService menuSer;
	
	@Autowired 
	private LoginService lSer;
	/**
	 * 主界面
	 */
	@GetMapping("/to_menu")
	public String toMenu(Model model){
		List<FunctionTypeVo> FunctionTypeVo = menuSer.selectAll();
		model.addAttribute("FunctionTypeVo", FunctionTypeVo);
		return "menu/to_menu";
	}
	@GetMapping("/select_all_functions_sasa")
	@ResponseBody
	public List selectAllFunctions(){
		
		return menuSer.selectAll();
	} 
	@GetMapping("/href_address")
	public String toAllJSP(String myValue , HttpSession session , String e){
		Emp emp = (Emp) session.getAttribute("empMessage");
		if(emp == null){
			myValue = "menu/no_login"; 
		}
		if("门诊处方".equals(e)){
			session.setAttribute("e", "门诊处方");
		}else{
			session.setAttribute("e", "住院处方");
		}
		return myValue;
	}

	/**
	 * 查询登录日志
	 */
	@GetMapping("/login_logger_select")
	@ResponseBody
	public Map<String, Object> loginLoggerSelect(int page , int rows,HttpSession session){
		Map<String , Object> map = new HashMap<>();
		Emp emp = (Emp) session.getAttribute("empMessage");
		List<LoginLoggerVO> list = lSer.loginLoggerSelect(page, rows, emp);
		map.put("total", lSer.empCount(emp));
		map.put("rows", list);
		return map;
	}
	
	/**
	 * 时间查询日志
	 */
	@GetMapping("/select_login_jilu_times_where")
	@ResponseBody
	public Map<String, Object> loginLoggerSelectWhere(int page , int rows,Date times , HttpSession session){
		Map<String , Object> map = new HashMap<>();
		Emp emp = (Emp) session.getAttribute("empMessage");
		List<LoginLoggerVO> list = lSer.loginLoggerSelectWhere(page, rows, emp , times);
		map.put("total", lSer.empCountWhere(emp , times));
		map.put("rows", list);
		return map;
	} 
	
	//查询所有登录记录
	@GetMapping("/select_all_login_logger")
	@ResponseBody
	public Map<String, Object> selectAllLogin(int page , int rows){
		Map<String , Object> map = new HashMap<>();
		List<LoginLoggerVO> list = lSer.selectAllLoginLogger(page, rows);
		map.put("total", lSer.empCount());
		map.put("rows", list);
		return map;
	} 
	
	
	//查询所有的本月所有的日期
	@GetMapping("/select_all_qian_dao_days")
	@ResponseBody
	public QianDaoVO selectDateToDay(HttpSession session){
		//总集合
		QianDaoVO qd = new QianDaoVO();
		//天数集合
		List<String> listD = new ArrayList<>();
		//获取本月的最大天数
		Integer maxDays = maxDays();
		//循环添加
		for(int j = 0 ; j < weekDay(mondayDay()) ; j++){
			listD.add("");
		}
		for(int i = 1 ; i <= maxDays ; i++){
			listD.add(String.valueOf(i));
		}
		List<Boolean> listB = lSer.selectAllQianDao(weekDay(mondayDay()) , maxDays , 
				((Emp)session.getAttribute("empMessage")).getEmpId());
		int count = 0 ;
		for (Boolean b : listB) {
			if(b){
				count ++;
			}
		}
		qd.setQdAllDate(listD);
		qd.setMaxDay(maxDays);
		qd.setIsFlag(listB);
		qd.setMoneyDay(weekDay(mondayDay()));
		qd.setQdDay(count);
		qd.setNoDay(qd.getMaxDay() - qd.getQdDay());
		return qd;
	}
	
	/**
	 * 获取本月的最大天数
	 * @return
	 */
	public Integer maxDays(){
        Calendar calendar = Calendar.getInstance();  
        int days = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);  
        return days;  
	}
	
	/**
	 * 获取一号是星期几
	 */
	public String mondayDay(){
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		SimpleDateFormat format = new SimpleDateFormat("E");
		return format.format(calendar.getTime());
	}
	
	
	/**
	 * 转位数字
	 */
	public Integer weekDay(String w){
		String str [] = new String[]{ "星期天" , "星期一" ,"星期二" ,"星期三" ,"星期四" ,"星期五" ,"星期六"};
		for (int i = 0; i < str.length; i++) {
			if(str[i].equals(w)){
				return i;
			}
		}
		return 0;
	}
	
	@GetMapping("/insert_qian_dao")
	@ResponseBody
	public Errors insertQianDao(HttpSession session){
		return lSer.insertQianDao(((Emp)session.getAttribute("empMessage")).getEmpId());
	}
	
	@GetMapping("/select_to_day_qian_dao")
	@ResponseBody
	public Errors selectToDayQianDao(HttpSession session){
		return lSer.isCunZai(((Emp)session.getAttribute("empMessage")).getEmpId());
	}
	
	@GetMapping("/select_all_chu_qin_new_month")
	@ResponseBody
	public List<ChuQinVO> selectAllChuQInNewMonth(){
		List<ChuQinVO> list =  lSer.ChuqinSelectAll(maxDays());
		return list;
	}
	
	@GetMapping("/select_que_qin_days")
	@ResponseBody
	public List<ChuQinVO> selectQueQinDays(Long empId , Integer month){
		return lSer.selectQueQinDays(empId , month);
	}
	
	
	@GetMapping("/select_month_chu_qin")
	@ResponseBody
	public List<ChuQinVO> selectMonthChuQin(Integer month)  {
		List<ChuQinVO> list =  lSer.selectMonthChuQin(month , maxDays());
		return list;
	}
	
	/**
	 * 天气
	 * @throws IOException 
	 */
	@GetMapping("/select_zz_weather")
	@ResponseBody
	public CityVO selectZZWeather(HttpServletRequest request , String cityId) throws IOException {
		return CommentOrder.getWeatherVo(request , cityId);
	}
	
}	