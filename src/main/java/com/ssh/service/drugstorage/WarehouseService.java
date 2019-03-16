package com.ssh.service.drugstorage;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.dao.jpa.doctor.IYaokuKucunDao;
import com.ssh.dao.jpa.drugstorage.IAcceptanceDao;
import com.ssh.dao.jpa.drugstorage.IDrugDao;
import com.ssh.dao.jpa.drugstorage.IDrugWarehouseXqDao;
import com.ssh.dao.jpa.drugstorage.IPurchaseDao;
import com.ssh.dao.jpa.drugstorage.IWarehouseDao;
import com.ssh.pojos.Drug;
import com.ssh.pojos.DrugAcceptance;
import com.ssh.pojos.DrugAcceptanceXq;
import com.ssh.pojos.DrugPurchase;
import com.ssh.pojos.DrugWarehouse;
import com.ssh.pojos.DrugWarehouseXq;
import com.ssh.pojos.YaokuKucun;
import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;

@Service
@Transactional
public class WarehouseService {
	@Autowired
	private IWarehouseDao IWDao;
	
	@Autowired
	private IAcceptanceDao IADao;
	
	@Autowired
	private IPurchaseDao IPDAO;
	
	@Autowired
	private IDrugWarehouseXqDao IWXDao;
	
	@Autowired
	private IDrugDao IDDAO;
	
	@Autowired
	private IYaokuKucunDao IYKDAO;
	
	private List<RukuVo> list=new ArrayList<>();
	
	public String WNumber(){
		return IWDao.selectWNumber(CommentOrder.dateLike());
	}
	
	/**
	 * 根据验收单号查询验收详情
	 * @param drugAcceptanceId
	 * @return
	 */
	public List<RukuVo> selectRukuXq(String drugAcceptanceId){
		list.clear();
		if(drugAcceptanceId != null){
			DrugAcceptance da=IADao.findOne(drugAcceptanceId);
			if(da.getDrugAcceptanceXqs() != null){
				for (DrugAcceptanceXq r : da.getDrugAcceptanceXqs()) {
					RukuVo ru=new RukuVo();
					ru.setId(list.size()+1);
					ru.setBz(r.getDrugAcceptanceXqRemark());
					ru.setCgrq(r.getDrugAcceptance().getDrugPurchase().getDrugPurchaseDhdate());
					ru.setDw(r.getDrug().getUnit().getUnitsName());
					ru.setNum(r.getDrugAcceptanceXqHegeNum());
					ru.setPh(r.getDrugAcceptanceXqPh());
					//ru.setScrq(new Date());
					ru.setYpid(r.getDrug().getDrugId());
					ru.setYpname(r.getDrug().getDrugName());
					list.add(ru);
				}
			}
		}
		return list;
	}
	
	/**
	 * 入库处理
	 * @param dw
	 * @param drugAcceptanceId
	 * @param state
	 * @return
	 */
	public Errors insertChuli(DrugWarehouse dw,String drugAcceptanceId){
		try {
			DrugAcceptance da=IADao.findOne(drugAcceptanceId);
			da.setDrugAcceptanceZt("已入库");
			if(da.getDrugPurchase() != null){
				DrugPurchase p = IPDAO.findOne(da.getDrugPurchase().getDrugPurchaseId());
				p.setDrugPurchaseZt("已入库");
			}
			dw.setDrugAcceptance(IADao.findOne(drugAcceptanceId));
			dw.setDrugWarehouseZt("已入库");
			IWDao.save(dw);
			insertWareXq(dw);
			rukuKuCun();
			return new Errors(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Errors(e.getMessage());
		}
	}
	
	public void insertWareXq(DrugWarehouse dw){
		//先清除所有数据，再去添加一次数据
		DrugWarehouse dwh=IWDao.findOne(dw.getDrugWarehouseId());
		if(dwh.getDrugWarehouseXqs() != null){
			IWXDao.delete(dwh.getDrugWarehouseXqs());
		}
		for (RukuVo r : list) {
			DrugWarehouseXq dwxq=new DrugWarehouseXq();
			dwxq.setDrugWarehouseXqId(IWXDao.maxId());
			dwxq.setDrugWarehouseXqBzDate(new Date());
			dwxq.setDrugWarehouseXqCgDate(r.getCgrq());
			dwxq.setDrugWarehouseXqNum(r.getNum());
			dwxq.setDrugWarehouseXqPh(r.getPh());
			dwxq.setDrugWarehouseXqRemark(r.getBz());
			dwxq.setDrugWarehouseXqScDate(r.getScrq());
			dwxq.setDrug(IDDAO.findOne(r.getYpid()));
			dwxq.setDrugWarehouse(IWDao.findOne(dw.getDrugWarehouseId()));
			IWXDao.save(dwxq);
		}
	}
	
	/**
	 * 入库库存处理
	 */
	public void rukuKuCun(){
			//获取该药品对应的库存
		for (RukuVo r : list) {
			Drug drug = IDDAO.findOne(r.getYpid());
			System.err.println(drug.getDrugId());
			YaokuKucun yk = drug.getYaokuKucun();
			YaokuKucun ykk = IYKDAO.findOne(yk.getYaokuKucunId());
			ykk.setYaokuKucunNum(new BigDecimal(ykk.getYaokuKucunNum().intValue() + r.getNum().intValue()));
		}
	}
	
	/**
	 * 查询
	 * @return
	 */
	public List<RukuVo> findAll(){
		return list;
	}
	
	/**
	 * 清除
	 */
	public void clear(){
		list.clear();
	}
}
