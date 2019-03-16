package com.ssh.service.login;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.dao.jpa.login.ILoginLoggerDAO;
import com.ssh.dao.jpa.login.LoginDao;
import com.ssh.dao.jpa.menu.IQianDaoDAO;
import com.ssh.dao.jpa.staff.IEmpDAO;
import com.ssh.pojos.Emp;
import com.ssh.pojos.Function;
import com.ssh.pojos.LoginLogger;
import com.ssh.pojos.QianDao;
import com.ssh.pojos.Role;
import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;
import com.ssh.vo.doctor.ChuQinVO;
import com.ssh.vo.login.LoginLoggerVO;
import com.ssh.vo.staff.EmpVO;
import com.ssh.vo.staff.Other;

@Service
@Transactional
public class LoginService {
		@Autowired
		private LoginDao logindao;
		
		@Autowired
		private ILoginLoggerDAO ILDAO;
		
		@Autowired
		private IEmpDAO IEDAO;
		/**
		 * 验证用户名和密码
		 * @param userName
		 * @param passWord
		 * @return
		 */
		public Errors regexEmp(String userName,String passWord){
			Errors err=new Errors();
			if("".equals(userName)){
				err.seteMessage("请输入用户名!");
			}else if("".equals(passWord)){
				err.seteMessage("请输入密码!");
			}else{
				Emp emp=userMessage(userName, passWord);
				if(emp==null){
					err.seteMessage("用户名或密码错误,请重新输入!");
				}else{
					if(!findByUserFunctions(emp).contains(71L)){
						err.seteMessage("权限不足 ! 无法登陆 ！");
					}else if(emp.getEmpState().intValue() == 1){
						err.setError(true);
						//添加登录日志
						LoginLogger ll = new LoginLogger();
						ll.setLoginLogger(ILDAO.selectMaxId());
						Date date = new Date();
						ll.setLoginDate(date);
						ll.setLoginTimes(new SimpleDateFormat("HH:mm:ss").format(date));
						ll.setEmp(emp);
						ILDAO.save(ll);
					}
					else{
						err.seteMessage("该账户已停止使用 !");
					}
				}
			}
			
			return err;
		}
		
		/**
		 * 查询用户名和密码
		 * @param userName
		 * @param passWord
		 * @return
		 */
		public Emp userMessage(String userName,String passWord){
			return logindao.regexEmp(userName, CommentOrder.encode(passWord));
		}
		/**
		 * 查询用户对应的所有功能
		 */
		public Set<Long> findByUserFunctions(Emp e){
			Emp emp = logindao.findOne(e.getEmpId());
			List<Role> list = emp.getRoles();
			Set<Long>  set = new HashSet<>();
			for (Role role : list) {
				List<Function> listF = role.getFunctions();
				for (Function f : listF) {
					set.add(f.getFunctionsId());
				}
			}
			return set;
		}

		public List<LoginLoggerVO> loginLoggerSelect(int page , int rows , Emp emp) {
			return ILDAO.findByToEmp(emp , new PageRequest(page - 1, rows));
		}

		public long empCount(Emp emp) {
			return ILDAO.empCount(emp);
		}

		public List<LoginLoggerVO> loginLoggerSelectWhere(int page, int rows, Emp emp, Date times) {
			return ILDAO.loginLoggerSelectWhere(emp , times , new PageRequest(page - 1, rows));
		}

		public Object empCountWhere(Emp emp, Date times) {
			return ILDAO.empCountWhere(emp , times);
		}
		
		public   List<LoginLoggerVO> selectAllLoginLogger(int page , int rows){
			List<LoginLoggerVO> list =  ILDAO.selectAllLogin(new PageRequest(page - 1, rows));
			for (LoginLoggerVO l : list) {
				LoginLogger lo = ILDAO.findOne(l.getLoginLogger());
				l.setEmp(new EmpVO(lo.getEmp().getEmpId(), lo.getEmp().getEmpLoginName()));
				l.setLoginTimes(l.getLoginDate() + " " + l.getLoginTimes());
			}
			return list;
		}

		public long empCount() {
			return ILDAO.count();
		}
		
		
		/**
		 * 
		 * 统计登录次数
		 * @param year 
		 */
		public List<Object[]> selectCount(){
			List<Object[]> list = ILDAO.selectCount();
			return list;
			
		}

		public List<Object[]> selectLoggerMonth(String month) {
			return ILDAO.selectLoggerMonth(Integer.parseInt(month) > 9 ? month : "0" + month);
		}
		
		@Autowired
		private IQianDaoDAO IQDAO;
		public Errors insertQianDao(Long empId) {
			try {
				if(empId != null){
					Emp emp =  IEDAO.findOne(empId);
					if(IQDAO.findByQianDaoDateAndEmp(new Date() , emp) == null){
						QianDao q = new QianDao();
						q.setQianDaoDate(new Date());
						q.setQianDaoTimes(new SimpleDateFormat("hh:mm:ss").format(new Date()));
						q.setEmp(IEDAO.findOne(empId));
						q.setQianDaoId(IQDAO.count() + 1);
						IQDAO.save(q);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				return new Errors(e.getMessage());
			}
			return new Errors(true);
		}
		
		public QianDao selectToDay(Date date ,Emp emp){
			return IQDAO.findByQianDaoDateAndEmp(date , emp) ;
		}
		
		public Errors isCunZai(Long empId){
			Emp emp =  IEDAO.findOne(empId);
			return selectToDay(new Date() , emp) == null ? new Errors(true) : new Errors();
		}

		public List<Boolean> selectAllQianDao(Integer weekDay, Integer maxDays, Long empId) {
			List<String> strs =  IQDAO.selectMoneyQD(IEDAO.findOne(empId) , new SimpleDateFormat("yyyy-MM").format(new Date()));
			List<Boolean> boo = new ArrayList<>();
			for (int i = 0; i < weekDay; i++) {
				boo.add(false);
			}
			for (int i = 1; i <= maxDays; i++) {
				for (int j = 0; j < strs.size(); j++) {
					String s = i < 10 ? "0"+i : i + "";
					if(strs.get(j).equals(s)){
						boo.add(true);
						break;
					}else if(j == strs.size() - 1){
						boo.add(false);
						break;
					}
				}
				if(strs.size() == 0){
					boo.add(false);
				}
			}
			return boo;
		}

		public List<ChuQinVO> ChuqinSelectAll(Integer maxPage) {
			List<Emp> list = (List<Emp>) IEDAO.findAll();
			List<ChuQinVO> listC = new ArrayList<>();
			for (Emp e : list) {
				ChuQinVO cq = new ChuQinVO();
				cq.setEmpId(e.getEmpId());
				cq.setEmpLoginName(e.getEmpLoginName());
				cq.setDeptName(e.getDept().getDeptName());
				cq.setDclassName(e.getDclass().getDclassName());
				cq.setBenYueDays(maxPage);
				int l = IQDAO.findByToMonth(new SimpleDateFormat("yyyy-MM").format(new Date()) , IEDAO.findOne(e.getEmpId()));
				cq.setChuqinDays(l);
				cq.setYiGuoDays(Integer.valueOf(new SimpleDateFormat("dd").format(new Date())));
				cq.setQueQinDays(cq.getYiGuoDays() - cq.getChuqinDays());
				double dou = ((double)cq.getChuqinDays() / (double)cq.getYiGuoDays())*100;
				String dou2 = df.format(dou);
				cq.setChuqinLv(Double.parseDouble(dou2));
				listC.add(cq);
			}
			return listC;
		}

		public List<ChuQinVO> selectQueQinDays(Long empId, Integer month) {
			List<ChuQinVO> listD = new ArrayList<>();
			if(empId != null){
					Emp e = IEDAO.findOne(empId);
					//获取今天的日期
					Calendar calendar = Calendar.getInstance();  
					try {
						calendar.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(
								new SimpleDateFormat("yyyy").format(new Date()) +"-"+ (month < 10 ? "0"+month :  month) +"-" +"01"));
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					int days = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
					int today =Integer.valueOf(new SimpleDateFormat("dd").format(new Date()));
				int oo = new SimpleDateFormat("MM").format(new Date()).equals(month < 10 ? "0"+month :  month)
					? today : days;
					Calendar c=Calendar.getInstance();
					for (int i = 0 ; i < oo  ; i++) {
						c.setTime(calendar.getTime());
						c.add(Calendar.DATE ,i);
						String str = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
						try {
							QianDao qdao = IQDAO.findByQianDaoDateAndEmp(new SimpleDateFormat("yyyy-MM-dd").parse(str)
									, e);
							if(qdao == null){
								ChuQinVO cq =new ChuQinVO();
								cq.setChuqinDate(new  SimpleDateFormat("yyyy-MM-dd").parse(str));
								listD.add(cq);
							}
						} catch (ParseException e1) {
							e1.printStackTrace();
						}
					}
			}
			return listD;
		}

		DecimalFormat df = new DecimalFormat("#.00"); 
		public List<ChuQinVO> selectMonthChuQin(Integer month, Integer integer) {
			List<ChuQinVO> listC = new ArrayList<>();
			if(month != null){
				Calendar calendar = Calendar.getInstance();  
				try {
					calendar.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(
							new SimpleDateFormat("yyyy").format(new Date()) +"-"+ (month < 10 ? "0"+month :  month) +"-" +"01"));
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				int days = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
				List<Emp> list = (List<Emp>) IEDAO.findAll();
				for (Emp e : list) {
					ChuQinVO cq = new ChuQinVO();
					cq.setEmpId(e.getEmpId());
					cq.setEmpLoginName(e.getEmpLoginName());
					cq.setDeptName(e.getDept().getDeptName());
					cq.setDclassName(e.getDclass().getDclassName());
					cq.setBenYueDays(days);
					int l = IQDAO.findByToMonth(new SimpleDateFormat("yyyy").format(new Date()) +"-"+ (month < 10 ? "0"+month :  month), IEDAO.findOne(e.getEmpId()));
					cq.setChuqinDays(Integer.parseInt(String.valueOf(l)));
					cq.setYiGuoDays(new SimpleDateFormat("MM").format(new Date()).equals(month < 10 ? "0"+month :  month)
							? l : days);
					cq.setQueQinDays(cq.getYiGuoDays() - cq.getChuqinDays());
					System.err.println( (double)cq.getChuqinDays() +"\n"+ (double)cq.getYiGuoDays()*100);
					double dou = ((double)cq.getChuqinDays() / (double)cq.getYiGuoDays())*100;
					String dou2 = df.format(dou);
					cq.setChuqinLv(Double.parseDouble(dou2));
					listC.add(cq);
				}
				return listC;
			}else{
				return ChuqinSelectAll(integer);
			}
		}
		
}
