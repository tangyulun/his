package com.ssh.service.drugstorage;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.dao.jpa.drugstorage.IAcceptanceDao;
import com.ssh.dao.jpa.drugstorage.IAcceptanceXqDao;
import com.ssh.dao.jpa.drugstorage.IDrugDao;
import com.ssh.dao.jpa.drugstorage.IPurchaseDao;
import com.ssh.dao.jpa.drugstorage.ISupplierDao;
import com.ssh.pojos.DrugAcceptance;
import com.ssh.pojos.DrugAcceptanceXq;
import com.ssh.pojos.DrugPurchase;
import com.ssh.pojos.DrugPurchaseDetail;
import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;
import com.ssh.vo.drugstorage.AcceptanceVo;
import com.ssh.vo.drugstorage.BuydingdanVo;
import com.ssh.vo.drugstorage.DrugPurchaseVo;
import com.ssh.vo.drugstorage.SupplierVo;
import com.ssh.vo.drugstorage.YanshouVo;

@Service
@Transactional
public class AcceptanceService {
	
	@Autowired
	private IAcceptanceDao IADao;
	
	@Autowired
	private IPurchaseDao IPDao;
	
	@Autowired
	private IAcceptanceXqDao IAXDao;
	
	@Autowired
	private IDrugDao IDDAO;
	
	@Autowired
	private ISupplierDao ISDao;
	
	private List<YanshouVo> list=new ArrayList<>();
	
	public String ANumber(){
		return IADao.selectNumber(CommentOrder.dateLike());
	}
	
	/**
	 * 根据采购订单号查询详情
	 * @param drugPurchaseId
	 * @return
	 */
	public List<YanshouVo> selectYanshouXq(String drugPurchaseId){
		clear();
		if(drugPurchaseId != null){
			DrugPurchase da=IPDao.findOne(drugPurchaseId);
			if(da.getDrugPurchaseDetails() != null){
				for (DrugPurchaseDetail d : da.getDrugPurchaseDetails()) {
					YanshouVo ys=new YanshouVo();
					ys.setBz(d.getDrugPurchaseDetailsBz());
					ys.setDj(d.getDrugPurchaseDetailsDj());
					ys.setHgnum(d.getDrugPurchaseDetailsNum());
					ys.setId(list.size()+1);
					ys.setJe(d.getDrugPurchaseDetailsJe());
					ys.setNohgnum(new BigDecimal(0));
					ys.setPh(d.getDrugPurchaseDetailsPh());
					ys.setZongnum(d.getDrugPurchaseDetailsNum());
					ys.setDrugdw(d.getDrug().getUnit().getUnitsName());
					ys.setYpId(d.getDrug().getDrugId());
					ys.setYpName(d.getDrug().getDrugName());
					list.add(ys);
				}
			}
		}
		return list;
	}
	
	/**
	 * 挂单和验收处理
	 * @param da
	 * @param drugPurchaseId
	 * @param state
	 * @return
	 */
	public Errors insertGuadanAndChuli(DrugAcceptance da,String drugPurchaseId){
		try {
				DrugPurchase d = IPDao.findOne(drugPurchaseId);
				d.setDrugPurchaseZt("已验收");
					da.setDrugAcceptanceZt("已验收");
					yanshouDeal(da,drugPurchaseId);
					insertAccXq(da);
					return new Errors(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Errors(e.getMessage());
		}
		
	}
	
	/**
	 * 调用方法进行挂单和验收处理
	 * @param da
	 * @param drugPurchaseId
	 */
	public void yanshouDeal(DrugAcceptance da ,String drugPurchaseId){
		DrugAcceptance acc=IADao.findOne(da.getDrugAcceptanceId());
		if(acc != null){
			acc.setDrugAcceptancePzdh(da.getDrugAcceptancePzdh());
			acc.setDrugAcceptanceShdate(da.getDrugAcceptanceShdate());
		}else{
			da.setDrugPurchase(IPDao.findOne(drugPurchaseId));
			IADao.save(da);
		}
	}
	
	/**
	 * 验收详单记录
	 * @param da
	 */
	public void insertAccXq(DrugAcceptance da){
		//先清除所有数据，再去添加一次数据
		DrugAcceptance dac=IADao.findOne(da.getDrugAcceptanceId());
		if(dac.getDrugAcceptanceXqs() != null){
			IAXDao.delete(dac.getDrugAcceptanceXqs());
		}
		for (YanshouVo y : list) {
			DrugAcceptanceXq daxq=new DrugAcceptanceXq();
			daxq.setDrugAcceptanceXq(IAXDao.maxId());
			daxq.setDrugAcceptanceXqBuhegeNum(y.getZongnum());
			daxq.setDrugAcceptanceXqHegeNum(y.getHgnum());
			daxq.setDrugAcceptanceXqMoney(y.getJe());
			daxq.setDrugAcceptanceXqBuhegeNum(y.getNohgnum());
			daxq.setDrugAcceptanceXqPh(y.getPh());
			daxq.setDrugAcceptanceXqPrice(y.getDj());
			daxq.setDrugAcceptanceXqRemark(y.getBz());
			daxq.setDrug(IDDAO.findOne(y.getYpId()));
			daxq.setDrugAcceptance(IADao.findOne(da.getDrugAcceptanceId()));
			daxq.setDrugAcceptanceXqNum(new BigDecimal(daxq.getDrugAcceptanceXqHegeNum().intValue() +
					daxq.getDrugAcceptanceXqBuhegeNum().intValue()));
			IAXDao.save(daxq);
		}
	}
	
	/**
	 * 查询
	 * @return
	 */
	public List<YanshouVo> FindAll(){
		return list;
	}
	
	/**
	 * 清除
	 */
	public void clear(){
		list.clear();
	}
	
	/**
	 * 修改
	 * @param id
	 * @param hgnum
	 */
	public void update(int id, BigDecimal hgnum) {
		if(list != null){
			for (YanshouVo y : list) {
				//如果详情id=选中的id则进行以下操作
				if(y.getId() == id){
					y.setHgnum(hgnum);//开始时将合格数设成总数量
					//判断，如果合格数大于总数量则将合格数设成总数量
					if(hgnum.intValue() > y.getZongnum().intValue()){
						y.setHgnum(y.getZongnum());
					}
					//如果合格数小于0则将合格数变成0
					if(hgnum.intValue() <0){
						y.setHgnum(new BigDecimal(0));
					}
					//不合格数量为：总数量-合格数量=不合格数量
					y.setNohgnum(new BigDecimal(y.getZongnum().intValue() - y.getHgnum().intValue()));
					//金额：合格数量*单价=金额
					y.setJe(new BigDecimal(y.getHgnum().intValue() * y.getDj().intValue()));
					System.err.println("ok");
					break;
				}
			}
		}
	}
	
	/**
	 * 计算总金额
	 */
	public double selectZMoney(){
		double money = 0.0;
		for (YanshouVo b : list) {
			money = b.getHgnum().doubleValue() * b.getDj().doubleValue();
		}
		return money;
	}
	
	
	/**
	 * 查询验收记录
	 * @param page
	 * @param rows
	 * @return
	 */
	public List<AcceptanceVo> selectJilu(int page,int rows){
		PageRequest pages=new PageRequest(page-1, rows);
		List<AcceptanceVo> list=IADao.selectJilu(pages);
		lianbiaofind(list);
		return list;
	}
	
	public long count(){
		return IADao.count();
	}
	
	public void lianbiaofind(List<AcceptanceVo> list){
		for (AcceptanceVo a : list) {
			a.setSupplier(new SupplierVo(IADao.findOne(a.getDrugAcceptanceId()).getDrugPurchase().getSupplier().getSupplierId(),
					IADao.findOne(a.getDrugAcceptanceId()).getDrugPurchase().getSupplier().getSupplierName(),
					IADao.findOne(a.getDrugAcceptanceId()).getDrugPurchase().getSupplier().getSupplierLxr(),
					IADao.findOne(a.getDrugAcceptanceId()).getDrugPurchase().getSupplier().getSupplierPhone()));
			a.setDrugPurchase(new DrugPurchaseVo(IADao.findOne(a.getDrugAcceptanceId()).getDrugPurchase().getDrugPurchaseMoney()));
		}
	}
	
	/**
	 * 查询不合格的验收记录
	 * @param page
	 * @param rows
	 * @return
	 */
	public List<AcceptanceVo> selectNohegeJilu(int page,int rows){
		PageRequest pages=new PageRequest(page-1, rows);
		List<AcceptanceVo> list=IADao.selectNohegeJilu(pages);
		for (AcceptanceVo a : list) {
			a.setDrugAcceptanceZt("待退货");
			DrugPurchase d = IPDao.findOne(IADao.findOne(a.getDrugAcceptanceId()).getDrugPurchase().getDrugPurchaseId());
			a.setDrugPurchase(new DrugPurchaseVo(d.getDrugPurchaseId(),
					new SupplierVo(d.getSupplier().getSupplierId(), 
							d.getSupplier().getSupplierName(),
							d.getSupplier().getSupplierLxr(),
							d.getSupplier().getSupplierPhone())));
		}
		return list;
	}
	
	/**
	 * 模糊查询根据采购订单号
	 * @param drugAcceptanceId
	 * @param page
	 * @param rows
	 * @return
	 */
	public List<AcceptanceVo> mohufindById(String drugAcceptanceId,int page , int rows){
		PageRequest pages = new PageRequest(page - 1, rows);
		List<AcceptanceVo> list = IADao.mohufindById("%"+drugAcceptanceId+"%", pages);
		lianbiaofind(list);
		return list;
	}
	
	public long mohufindByIdCount(String drugAcceptanceId){
		return IADao.mohufindByIdCount(drugAcceptanceId);
	}
	
}
