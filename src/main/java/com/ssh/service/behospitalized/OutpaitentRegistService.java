package com.ssh.service.behospitalized;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ssh.dao.jpa.behospitalized.IOutpaitentRegistDAO;
import com.ssh.dao.mybatis.behospitalized.IMyOutpaitentRegistDAO;
import com.ssh.vo.behospitalized.DclassVo;
import com.ssh.vo.behospitalized.EmpVo;
import com.ssh.vo.behospitalized.MedicalCardVo;
import com.ssh.vo.behospitalized.OutpaitentRegistVo;

@Service
@Transactional
public class OutpaitentRegistService {
	@Autowired
	private IOutpaitentRegistDAO ioprdao;
	
	@Autowired
	private IMyOutpaitentRegistDAO myregistdao;
	
	/**
	 * 查询门诊挂号
	 * @param page
	 * @param rows
	 * @return
	 */
	public List<OutpaitentRegistVo> selectAllRegist(int page , int rows){
		PageRequest pages = new PageRequest(page - 1 , rows);
		List<OutpaitentRegistVo> list= ioprdao.selectAllRegist(pages); 
		selectDclass(list);
		return list;
	}
	/**
	 * 查询总记录数
	 * @return
	 */
	public long count() {
		return ioprdao.count();
	}
	/**
	 * 根据outpaitentRegistId来查询
	 * @param page
	 * @param rows
	 * @param outpaitentRegistId
	 * @return
	 */
	public List<OutpaitentRegistVo> selectOutpaitentRegistIdWhere(int page, int rows , String outpaitentRegistId){
		PageRequest pages = new PageRequest(page - 1, rows);
		List<OutpaitentRegistVo> list= ioprdao.selectTypeRegist(pages,"%" + outpaitentRegistId + "%"); 
		selectDclass(list);
		return list;
	}
	/**
	 * outpaitentRegistId查询记录数
	 * @param outpaitentRegistId
	 * @return
	 */
	public long selectOutpaitentRegistIdWhereCount(String outpaitentRegistId){
		return ioprdao.findOutpaitentRegistIdCount("%" + outpaitentRegistId + "%");
	}
	
	Page<?> pages ;
	public List<OutpaitentRegistVo> selectStartDateToEndDate(int page , int rows , Date startTime, Date endTime,String outpaitentRegistId){
		pages = PageHelper.startPage(page , rows);
		System.out.println(startTime+"startTime");
		return myregistdao.selectStartDateToEndDate(startTime, endTime, "".equals(outpaitentRegistId) ? null : "%"+ outpaitentRegistId + "%");
	}

	public long queryStartEndcount() {
		return pages.getTotal();
	}
	
	private void selectDclass(List<OutpaitentRegistVo> list) {
		for (OutpaitentRegistVo o : list) {
			o.setDclass(new DclassVo(ioprdao.findOne(o.getOutpaitentRegistId()).getDclass().getDclassName()));
			o.setEmp(new EmpVo(ioprdao.findOne(o.getOutpaitentRegistId()).getEmp().getEmpId(), 
					ioprdao.findOne(o.getOutpaitentRegistId()).getEmp().getEmpName()));
			o.setMedicalCard(new MedicalCardVo(ioprdao.findOne(o.getOutpaitentRegistId()).getMedicalCard().getMedicalCardName()));
		}
	}
	
}
