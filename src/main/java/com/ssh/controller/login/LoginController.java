package com.ssh.controller.login;


import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.ssh.pojos.Emp;
import com.ssh.service.login.LoginService;
import com.ssh.utils.Errors;
import com.ssh.vo.staff.Other;

@Controller
@SessionAttributes({"empMessage" , "functions"})
public class LoginController {
	@Autowired
	private LoginService loginservice;
	
	@GetMapping("/select_is_user")
	@ResponseBody
	public Errors selectIsUser(HttpSession session){
		if(session.getAttribute("empMessage") != null){
			return new Errors(true);
		}
		return new Errors();
	}
	@GetMapping("/to_login")
	public String tologin(){
		return "login/to_login";
		
	}
	
	/**
	 * 查询用户名或密码是否正确
	 * @param userName
	 * @param passWord
	 * @param model
	 * @return
	 */
	@PostMapping("/yanzheng_user")
	@ResponseBody
	public Errors yanzhengUser(String userName,String passWord,Model model){
		Errors err=loginservice.regexEmp(userName, passWord);
		if(err.isError()){
			model.addAttribute("empMessage",loginservice.userMessage(userName, passWord));
			model.addAttribute("functions",loginservice.
					findByUserFunctions(loginservice.userMessage(userName, passWord)));
		}
		return err;
	}
	@PostMapping("/yanzheng_user2")
	@ResponseBody
	public Errors yanzhengUser2(String userName,String passWord,Model model){
		Errors err=loginservice.regexEmp(userName, passWord);
		return err;
	}
	
	/**
	 * 注销
	 * @param ss
	 * @return
	 */
	 @RequestMapping("/login")
	public String clearSession(SessionStatus ss){
		 ss.setComplete();
		 return "login/to_login";
	}

	 /**
	  * 次数
	  */
	 @GetMapping("/select_login_group_by")
	 @ResponseBody
	 public List<Object[]> selectGruopBy(){
		 return loginservice.selectCount();
	 }
	 
	 /**
	  * 查询每日的次数
	  */
	 @GetMapping("/select_login_logger_month")
	 @ResponseBody
	 public List<Object[]> selectLoginLoggerMonth(String months){
		 return loginservice.selectLoggerMonth(months);
	 }
	 
	 /**
	  * 获取当前本月的天数
	  */
	 @GetMapping("/select_tomonth_days")
	 @ResponseBody
	 public int selectMonthDays(int month , int year){
		//获取calendar实例
		 Calendar calendar = Calendar.getInstance();
		 //在set之前需要先clear，否则有时会默认系统时间
		 calendar.clear();
		 if (year > 0) {
		 calendar.set(Calendar.YEAR, year);
		 }
		 if (month > 0) {
		 //注意：calendar的1月为0，所以set时应该-1
		 calendar.set(Calendar.MONTH, month-1);
		 }
		// 得到实际月份的最大天数。
		 return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

	 }
}
