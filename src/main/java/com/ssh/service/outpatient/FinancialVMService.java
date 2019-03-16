package com.ssh.service.outpatient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.dao.jpa.outpatient.IFinancialDao;
import com.ssh.vo.outpatient.FinacialVo;

@Service
@Transactional
public class FinancialVMService {

	@Autowired
	private IFinancialDao financialDao;
	
	/**
	 *查询收费项目选项卡
	 * @param page
	 * @param rows
	 * @return
	 */
	public List<FinacialVo> queryFinancialXM(int page, int rows){
		PageRequest p = new PageRequest(page - 1, rows);
		return financialDao.queryFinacialXM(p);
	}
	
	public long queryFinancialXMCount(){
		return financialDao.financialNameCount();
	}
}
