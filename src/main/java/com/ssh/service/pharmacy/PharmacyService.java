package com.ssh.service.pharmacy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.dao.jpa.pharmacy.IHospitalPillsDao;
import com.ssh.dao.jpa.pharmacy.IOutpatientPillsDao;
import com.ssh.dao.jpa.pharmacy.IPharmacyInventoryDao;
import com.ssh.utils.CommentOrder;

@Service
@Transactional
public class PharmacyService {
	@Autowired
	private IOutpatientPillsDao IOPDao;
	@Autowired
	private IHospitalPillsDao IHPDao;
	@Autowired
	private IPharmacyInventoryDao IPIDao;
	
	/**
	 * 门诊发药
	 * @return
	 */
	public String OPNumber(){
		return IOPDao.selectOPNumber(CommentOrder.dateLike());
	}
	
	/**
	 * 住院发药
	 * @return
	 */
	public String HPNumber(){
		return IHPDao.selectHPNumber(CommentOrder.dateLike());
	}
	
	/**
	 * 药房盘点
	 * @return
	 */
	public String PINumber(){
		return IPIDao.selectPINumber(CommentOrder.dateLike());
	}
}
