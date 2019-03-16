package com.ssh.service.operation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ssh.dao.jpa.behospitalized.IHospitalRegistrationDAO;
import com.ssh.dao.jpa.operation.SelectFinancialDao;
import com.ssh.dao.jpa.operation.ShouShuXqDao;
import com.ssh.dao.jpa.operation.ShoushuBaobiaoDao;
import com.ssh.dao.mybatis.operation.ShoushuTimeDao;
import com.ssh.pojos.HospitalRegistration;
import com.ssh.pojos.OutpaitentRegist;
import com.ssh.vo.operation.EmpsVo;
import com.ssh.vo.operation.HotregistionVo;
import com.ssh.vo.operation.JianyanMessVo;
import com.ssh.vo.operation.JianyanMessXqVo;
import com.ssh.vo.operation.OutpaitentRegistVo;
import com.ssh.vo.operation.SelectFinanVo;
import com.ssh.vo.operation.ShouBaobiaoVo;
import com.ssh.vo.operation.ShouShuMessVo;
import com.ssh.vo.operation.ShouShuVo;
import com.ssh.vo.operation.ShouShuXqVo;
import com.ssh.vo.operation.ShoushuChuanzhiVo;
import com.ssh.vo.operation.SurgeryTypeVo;

@Service
@Transactional
public class ShoushuBaoBiaoService {
	@Autowired
	private ShoushuBaobiaoDao shoushubaobiaodao;
	
	@Autowired
	private ShoushuTimeDao shoushutimedao;
	
	@Autowired
	private SelectFinancialDao selectfinancialdao;
	
	@Autowired
	private IHospitalRegistrationDAO hospitalregistrationdao;
	
	@Autowired
	private ShouShuXqDao shoushuxqdao;
	
	private List<ShouBaobiaoVo> list=new ArrayList<>();
	
	//查询分页表格
	public List<ShouShuMessVo> selectShoushuMessBaobiao(int page,int rows){
		PageRequest pa=new PageRequest(page -1, rows);
		List<ShouShuMessVo> list=shoushubaobiaodao.selectShoushuHuiZong(pa);
		selectShoushuBaoBiao(list);
		return list;
	}
	
	public long count(){
		return shoushubaobiaodao.count();
	}
	
	//外键
	public void selectShoushuBaoBiao(List<ShouShuMessVo> list){
		for(ShouShuMessVo s:list){
			s.setEmp(new EmpsVo(shoushubaobiaodao.findOne(s.getShoushuMess()).getEmp().getEmpId(),
					shoushubaobiaodao.findOne(s.getShoushuMess()).getEmp().getEmpName()));
			s.setHospitalRegistration(new HotregistionVo(shoushubaobiaodao.findOne(s.getShoushuMess()).getHospitalRegistration().getHospitalRegistrationId(), null, null));
			s.setShoushu(new ShouShuVo(shoushubaobiaodao.findOne(s.getShoushuMess()).getShoushu().getShoushuId(),
					shoushubaobiaodao.findOne(s.getShoushuMess()).getShoushu().getShoushuName()));
		}
	}
	
	/**
	 * 高级查询
	 */
	Page<?> pages ;
	public List<ShouShuMessVo> selectShoushuTime(int page,int rows,Date aTime,Date bTime,String shoushuMess){
		pages =PageHelper.startPage(page,rows);
		 List<ShouShuMessVo> list=shoushutimedao.selectMessShijiana(aTime, bTime, "".equals(shoushuMess) ? null:"%"+shoushuMess+"%");
		 selectShoushuBaoBiao(list);
		 System.err.println(list.size());
		 return list;
	}
	//记录
	public long shoushuMessTimecount() {
		return pages.getTotal();
	}
	
	/**
	 * 根据Id查询,输入框
	 * @param page
	 * @param rows
	 * @param shoushuMess
	 * @return
	 */
	public List<ShouShuMessVo> SelectShoushuMessAllId(int page, int rows,String shoushuMess){
		PageRequest pt=new PageRequest(page -1, rows);
		List<ShouShuMessVo> list=shoushubaobiaodao.selectShoushuIdchaxun("%"+shoushuMess+"%", pt);
		selectShoushuBaoBiao(list);
		return list;
		
	}
	/**
	 * 查询记录数
	 * @param shoushuMess
	 * @return
	 */
	public long SelectShoushucount(String shoushuMess){
		return shoushubaobiaodao.SelectShoushuIdcount("%"+shoushuMess+"%");
	}

	/**
	 * 第二个表格的东西
	 * @param shoushuMess
	 * @return
	 */
	public List<ShouShuXqVo> selectShoushuXq(String shoushuMess){
		List<ShouShuXqVo> list=shoushuxqdao.selectShoushuXqHuiZong(shoushuMess);
		System.out.println(shoushuMess);
		return list;
	}
}
