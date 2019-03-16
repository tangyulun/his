package com.ssh.service.finance;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.dao.jpa.drugstorage.IAcceptanceDao;
import com.ssh.dao.jpa.finance.IFuKuanDAO;
import com.ssh.dao.jpa.finance.ISettleWayDao;
import com.ssh.dao.jpa.finance.ISupplierJiesuanDao;
import com.ssh.dao.jpa.staff.IEmpDAO;
import com.ssh.pojos.DrugAcceptance;
import com.ssh.pojos.SupplierJiesuan;
import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;
import com.ssh.vo.drugstorage.AcceptanceVo;
import com.ssh.vo.drugstorage.DrugPurchaseVo;
import com.ssh.vo.finance.FuKuanVo;
import com.ssh.vo.finance.JieZhangMingXiVo;
import com.ssh.vo.finance.ParentTypeVo;
import com.ssh.vo.finance.SettleWayVo;

@Service
@Transactional
public class SupplierJiesuanService {

	@Autowired
	private ISupplierJiesuanDao supplierJiesuanDao;
	@Autowired
	private ISettleWayDao ISWDao;
	@Autowired
	private IAcceptanceDao IADao;
	@Autowired
	private IEmpDAO IEDao;
	
	private List<JieZhangMingXiVo> list=new ArrayList<>();
	
	@Autowired
	private IFuKuanDAO IFDAO;
	public String supplierNumber(){
		return supplierJiesuanDao.sNumber(CommentOrder.dateLike());
	}
	
	/**
	 * 查询所有应收款项
	 */
	public List<ParentTypeVo> selectAllYF(){
		List<FuKuanVo> list = IFDAO.selectAllShoufei();
		List<ParentTypeVo> listP = new ArrayList<>();
		listP.add(new ParentTypeVo(0, "应付账款", list));
		return listP;
	}
	
	/**
	 * 查询所有支付方式
	 * @return
	 */
	public List<SettleWayVo> selectSW(){
		return ISWDao.selectSW();
	}
	
	/**
	 * 根据凭证单号查询
	 * @param drugAcceptancePzdh
	 * @return
	 */
	private List<AcceptanceVo> da=null;
	public List<AcceptanceVo> select(String drugAcceptancePzdh){
		da=IADao.select(drugAcceptancePzdh);
		lianbaio(da);
		return da;
	}
	
	public void lianbaio(List<AcceptanceVo> sj){
		for (AcceptanceVo s : da) {
			s.setDrugPurchase(new DrugPurchaseVo(IADao.findOne(s.getDrugAcceptanceId()).getDrugPurchase().getDrugPurchaseMoney()));
		}
	}
	
	/**
	 * 结账处理
	 * @param sj
	 * @param empId
	 * @param settleWayId
	 * @return
	 */
	public Errors insertChuli(SupplierJiesuan sj,Long empId,String settleWayId,String drugAcceptancePzdh){
		try {
			sj.setEmp(IEDao.findOne(empId));
			sj.setSettleWay(ISWDao.findOne(settleWayId));
			sj.setSupplierJiesuanState(new BigDecimal(1));
			DrugAcceptance drug=IADao.selectByPzdh(drugAcceptancePzdh);
			drug.setDrugAcceptanceZt("已结账");
			supplierJiesuanDao.save(sj);
			return new Errors(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Errors(e.getMessage());
		}
	}
	
	public List<JieZhangMingXiVo> selectAll(){
		return list;
	}
	
	public void clear(){
		list.clear();
	}
}
