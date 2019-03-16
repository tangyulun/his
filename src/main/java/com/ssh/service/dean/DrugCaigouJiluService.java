package com.ssh.service.dean;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ssh.dao.jpa.drugstorage.IDrugPurchaseDetailDao;
import com.ssh.dao.jpa.drugstorage.IPurchaseDao;
import com.ssh.dao.mybatis.dean.IMyCaigouJiluDao;
import com.ssh.vo.drugstorage.DrugPurchaseDetaliVo;
import com.ssh.vo.drugstorage.DrugPurchaseVo;
import com.ssh.vo.drugstorage.DrugVo;
import com.ssh.vo.drugstorage.SupplierVo;
import com.ssh.vo.staff.EmpVO;

@Service
@Transactional
public class DrugCaigouJiluService {

	@Autowired
	private IPurchaseDao IPDao;
	@Autowired
	private IDrugPurchaseDetailDao IDPDao;
	@Autowired
	private IMyCaigouJiluDao IMyCDao;
	
	/**
	 * 查询所有采购订单
	 * @param page
	 * @param rows
	 * @return
	 */
	public List<DrugPurchaseVo> selectAll(int page , int rows){
		PageRequest pages = new PageRequest(page - 1, rows);
		List<DrugPurchaseVo> list = IPDao.selectDingdan(pages);
		lianbiaofind(list);
		return list;
	}
	
	/**
	 * 查询供应商和采购员
	 * @param list
	 */
	public void lianbiaofind(List<DrugPurchaseVo> list){
		for (DrugPurchaseVo d : list) {
			d.setEmp(new EmpVO(IPDao.findOne(d.getDrugPurchaseId()).getEmp().getEmpId(),
					IPDao.findOne(d.getDrugPurchaseId()).getEmp().getEmpLoginName()));
			d.setSupplier(new SupplierVo(IPDao.findOne(d.getDrugPurchaseId()).getSupplier().getSupplierId(),
					IPDao.findOne(d.getDrugPurchaseId()).getSupplier().getSupplierName()));
		}
	}
	
	/**
	 * 根据采购订单号查询详情
	 * @param drugPurchaseId
	 * @return
	 */
	public List<DrugPurchaseDetaliVo> selectByPurchaseId(String drugPurchaseId){
		List<DrugPurchaseDetaliVo> list = IDPDao.selectByPurchaseId(drugPurchaseId);
		lianbiaofinXq(list);
		System.out.println(list);
		return list;
	}

	public void lianbiaofinXq(List<DrugPurchaseDetaliVo> list){
		for (DrugPurchaseDetaliVo dp : list) {
			dp.setDrug(new DrugVo(IDPDao.findOne(dp.getDrugPurchaseDetailsId()).getDrug().getDrugId(),
					IDPDao.findOne(dp.getDrugPurchaseDetailsId()).getDrug().getDrugName()));
		}
	}
	
	/**
	 * 根据订单号或供应商查询
	 * @param drugPurchaseId
	 * @param supplierName
	 * @param page
	 * @param rows
	 * @return
	 */
	public List<DrugPurchaseVo> selectByIdAndSup(String drugPurchaseId , String supplierName , int page ,int rows){
		PageRequest pages = new PageRequest(page - 1, rows);
		List<DrugPurchaseVo> list = IPDao.mohufindByIdAndSup("%"+drugPurchaseId+"%", "%"+supplierName+"%", pages);
		lianbiaofind(list);
		return list;
	}

	
	/**
	 * 高级查询
	 * @param page
	 * @param rows
	 * @param startTime
	 * @param endTime
	 * @param drugPurchaseId
	 * @param supplierName
	 * @param state
	 * @return
	 */
	Page<?> pages;
	public List<DrugPurchaseVo> findgaoji(int page,int rows,Date startTime,Date endTime,String drugPurchaseId,String drugPurchaseZt){
		pages=PageHelper.startPage(page, rows);
		System.out.println(startTime+"12333");
		System.out.println(endTime+"132222");
		System.out.println(drugPurchaseId+"333444");
		System.out.println(drugPurchaseZt+"444333");
		List<DrugPurchaseVo> list = IMyCDao.mohufind(startTime, endTime, "".equals(drugPurchaseId) ? null : "%"+ drugPurchaseId +"%", "全部".equals(drugPurchaseZt) ? null : drugPurchaseZt);
		lianbiaofind(list);
		return list;
	}
	
	public long queryMohufindCount(){
		return pages.getTotal();
	}
}
