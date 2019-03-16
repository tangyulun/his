package com.ssh.service.drugstorage;

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
import com.ssh.dao.jpa.drugstorage.IDrugDao;
import com.ssh.dao.jpa.drugstorage.IDrugPurchaseDetailDao;
import com.ssh.dao.jpa.drugstorage.IPurchaseDao;
import com.ssh.dao.jpa.drugstorage.ISupplierDao;
import com.ssh.dao.jpa.staff.IEmpDAO;
import com.ssh.dao.mybatis.drugstorage.MyDrugPurchaseDao;
import com.ssh.pojos.DrugPurchase;
import com.ssh.pojos.DrugPurchaseDetail;
import com.ssh.pojos.Supplier;
import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;
import com.ssh.vo.drugstorage.BuydingdanVo;
import com.ssh.vo.drugstorage.DrugPurchaseVo;
import com.ssh.vo.drugstorage.SupplierVo;
import com.ssh.vo.outpatient.FinancialHistoryVo;
import com.ssh.vo.staff.EmpVO;

@Service
@Transactional
public class PurchaseService {
	@Autowired
	private IPurchaseDao IPDao;
	
	@Autowired
	private IEmpDAO IEDao;
	
	@Autowired
	private ISupplierDao ISDao;
	
	@Autowired
	private IDrugPurchaseDetailDao IDPDao;
	
	@Autowired
	private IDrugDao IDDAO;
	
	@Autowired
	private MyDrugPurchaseDao MyDPDao;
	
	
	private List<BuydingdanVo> list=new ArrayList<BuydingdanVo>();
	
	public String PNumber(){
		return IPDao.selectDPNumber(CommentOrder.dateLike());
	}
	
	/**
	 * 新增采购。。。。。。
	 * @param id
	 * @param drugId
	 * @param drugName
	 * @param num
	 * @param dw
	 * @param drugPfprice
	 * @param zprice
	 * @param ph
	 * @param bz
	 */
	public void insertCaigou(String drugId,String drugName,BigDecimal num,
			String dw,BigDecimal drugPfprice,BigDecimal zprice,String ph,String bz){
		BuydingdanVo dvo=new BuydingdanVo(list.size() + 1 , drugId,drugName,num,dw,drugPfprice,zprice,ph,bz);
		System.out.println(dvo);
		list.add(dvo);
	}
	
	/**
	 * 查询
	 */
	public  List<BuydingdanVo> selectAll(){
		return list;
	}
	
	/**
	 * 清除
	 */
	public void clear(){
		list.clear();
	}
	
	/**
	 * 新增挂单处理
	 * @param dp
	 * @param state 
	 * @return
	 */
	public Errors insertguadan(DrugPurchase dp,Long empId,String supplierId, String state){
		try {
			if("未处理".equals(state)){
				caigouDeal(dp, empId, supplierId);
			}else{
				DrugPurchase dpu = IPDao.findOne(dp.getDrugPurchaseId());
				if(dpu != null){
					dpu.setDrugPurchaseZt(state);
				}else{
					System.err.println(state);
					dp.setDrugPurchaseZt(state);
					caigouDeal(dp, empId, supplierId);
				}
			}
			insertxq(dp);
			return new Errors(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Errors(e.getMessage());
		}
	}

	/**
	 * 如果订单存在则修改不存在则新增
	 * @param dp
	 * @param empId
	 * @param supplierId
	 */
	private void caigouDeal(DrugPurchase dp, Long empId, String supplierId) {
		DrugPurchase pur = IPDao.findOne(dp.getDrugPurchaseId());
		if(pur != null){
			pur.setDrugPurchaseJhdz(dp.getDrugPurchaseJhdz());
			pur.setDrugPurchaseGhdate(dp.getDrugPurchaseGhdate());
			pur.setDrugPurchaseDhdate(dp.getDrugPurchaseDhdate());
			pur.setDrugPurchaseMoney(dp.getDrugPurchaseMoney());
			pur.setSupplier(ISDao.findOne(supplierId));
		}else{
			dp.setEmp(IEDao.findOne(empId));
			dp.setSupplier(ISDao.findOne(supplierId));
			IPDao.save(dp);
		}
	}


	
	/**
	 * 详单记录
	 * @param dpd
	 */
	public void insertxq(DrugPurchase dpd){
		//先清除所有数据，再去添加一次数据
		DrugPurchase pur = IPDao.findOne(dpd.getDrugPurchaseId());
		if(pur.getDrugPurchaseDetails() != null){
			IDPDao.delete(pur.getDrugPurchaseDetails());
		}
		for (BuydingdanVo b : list) {
			DrugPurchaseDetail dp=new DrugPurchaseDetail();
			dp.setDrugPurchaseDetailsId(IDPDao.findMaxId());
			dp.setDrugPurchaseDetailsBz(b.getBz());
			dp.setDrugPurchaseDetailsDj(b.getPrice());
			dp.setDrugPurchaseDetailsJe(b.getZprice());
			dp.setDrugPurchaseDetailsNum(b.getNum());
			dp.setDrugPurchaseDetailsPh(b.getPh());
			dp.setDrugPurchase(IPDao.findOne(dpd.getDrugPurchaseId()));
			dp.setDrug(IDDAO.findOne(b.getYpid()));
			IDPDao.save(dp);
		}
	}
	
	/**
	 * 计算总金额
	 */
	public double selectZMoney(){
		double money = 0.0;
		for (BuydingdanVo b : list) {
			money = b.getZprice().doubleValue() + money;
		}
		return money;
	}
	
	
	/**
	 * 删除订单
	 * @param xq
	 * @return
	 */
	public Errors deletexd(List<Long> xq){
		for (Long l : xq) {
			for (BuydingdanVo b : list) {
				if(b.getId() == l){
					list.remove(b);
					break;
				}
			}
		}
		return new Errors(true);
	}
	
	/**
	 * 修改采购信息
	 * @param id
	 * @param bd
	 */
	public void updatecaigou(BuydingdanVo bd , int id){
		System.err.println(bd + "\n"+id);
		for (BuydingdanVo b : list) {
			if(b.getId() == id){
				b.setNum(bd.getNum());
				b.setPrice(bd.getPrice());
				b.setZprice(bd.getZprice());
				b.setBz(bd.getBz());
				b.setPh(bd.getPh());
				break;
			}
		}
	}
	
	/**
	 * 连表查询（采购员、供应商）
	 * @param list
	 */
	public void lianbiaofind(List<DrugPurchaseVo> list){
		for (DrugPurchaseVo d : list) {
			d.setEmp(new EmpVO(IPDao.findOne(d.getDrugPurchaseId()).getEmp().getEmpId(),
					IPDao.findOne(d.getDrugPurchaseId()).getEmp().getEmpLoginName()));
			d.setSupplier(new SupplierVo(IPDao.findOne(d.getDrugPurchaseId()).getSupplier().getSupplierId(),
					IPDao.findOne(d.getDrugPurchaseId()).getSupplier().getSupplierName(),
					IPDao.findOne(d.getDrugPurchaseId()).getSupplier().getSupplierLxr(),
					IPDao.findOne(d.getDrugPurchaseId()).getSupplier().getSupplierPhone()));
		}
	}
	
	/**
	 * 查询所有挂单信息
	 * @param curpage
	 * @param pagesize
	 * @return
	 */
	public List<DrugPurchaseVo> selectCaigoudan(int curpage,int pagesize){
		PageRequest p=new PageRequest(curpage - 1, pagesize);
		List<DrugPurchaseVo> list=IPDao.selectDingdan(p);
		lianbiaofind(list);
		return list;
	}
	
	/**
	 * 记录数量
	 * @return
	 */
	public long count(){
		return IPDao.count();
	}
	
	/**
	 * 根据订单编号进行模糊查询
	 * @param curpage
	 * @param pagesize
	 * @param drugPurchaseId
	 * @return
	 */
	public List<DrugPurchaseVo> mohufindDingdan(int curpage,int pagesize,String drugPurchaseId){
		PageRequest p=new PageRequest(curpage-1, pagesize);
		List<DrugPurchaseVo> list=IPDao.mohufindDingdan("%"+drugPurchaseId+"%", p);
		lianbiaofind(list);
		return list;
	}
	
	public long mohuCount(String drugPurchaseId){
		return IPDao.mohuCount(drugPurchaseId);
	}
	
	/**
	 * 高级查询，根据开始日期到结束日期和采购单号进行查询
	 * @param page
	 * @param rows
	 * @param startTime
	 * @param endTime
	 * @param drugPurchaseId
	 * @return
	 */
	Page<?> pages ;
	public List<DrugPurchaseVo> findStartDatetoEndDate(int page,int rows,Date startTime,Date endTime,String drugPurchaseId){
		pages=PageHelper.startPage(page, rows);
		System.out.println(pages);
		System.out.println(startTime+"startTime");
		return MyDPDao.startDateEndDate(startTime, endTime, "".equals(drugPurchaseId) ? null : "%"+ drugPurchaseId +"%");
	}
	
	public long queryStartEndcount() {
		return pages.getTotal();
	}
	
	/**
	 * 查询详表显示在table中
	 * @param drugPurchaseId
	 * @return
	 */
	public List<BuydingdanVo> selectdingdanxq(String drugPurchaseId){
		DrugPurchase dp=IPDao.findOne(drugPurchaseId);
		if(dp.getDrugPurchaseDetails() != null){
			for (DrugPurchaseDetail d : dp.getDrugPurchaseDetails()) {
				BuydingdanVo bu = new BuydingdanVo();
				bu.setBz(d.getDrugPurchaseDetailsBz());
				bu.setId(list.size()+1);
				bu.setNum(d.getDrugPurchaseDetailsNum());
				bu.setPh(d.getDrugPurchaseDetailsPh());
				bu.setPrice(d.getDrugPurchaseDetailsDj());
				bu.setZprice(d.getDrugPurchaseDetailsJe());
				bu.setYpid(d.getDrug().getDrugId());
				bu.setYpname(d.getDrug().getDrugName());
				bu.setDw(d.getDrug().getUnit().getUnitsName());
				list.add(bu);
			}
		}
		return list;
	}
	
	/**
	 * 分页查询购买记录
	 * @param supplierId
	 * @param page
	 * @param rows
	 * @return
	 */
	public List<DrugPurchaseVo> selectSupplier(String supplierId){
		Supplier s=ISDao.findOne(supplierId);
		List<DrugPurchaseVo> list=new ArrayList<>();
		if(s.getDrugPurchases() != null){
			for (DrugPurchase d : s.getDrugPurchases()) {
				if("已处理".equals(d.getDrugPurchaseZt())){
					DrugPurchaseVo dp=new DrugPurchaseVo();
					dp.setDrugPurchaseId(d.getDrugPurchaseId());
					dp.setDrugPurchaseDhdate(d.getDrugPurchaseDhdate());
					dp.setDrugPurchaseGhdate(d.getDrugPurchaseGhdate());
					dp.setDrugPurchaseJhdz(d.getDrugPurchaseJhdz());
					dp.setDrugPurchaseMoney(d.getDrugPurchaseMoney());
					dp.setEmp(new EmpVO(d.getEmp().getEmpId(), d.getEmp().getEmpLoginName()));
					dp.setSupplier(new SupplierVo(d.getSupplier().getSupplierId(),d.getSupplier().getSupplierName()));
					list.add(dp);
				}
			}
		}
		return list;
	}
}
