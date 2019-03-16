package com.ssh.service.drugstorage;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.dao.jpa.drugstorage.IAcceptanceDao;
import com.ssh.dao.jpa.drugstorage.IAcceptanceXqDao;
import com.ssh.dao.jpa.drugstorage.IDrugDao;
import com.ssh.dao.jpa.drugstorage.IReturnDao;
import com.ssh.dao.jpa.drugstorage.IReturnXqDao;
import com.ssh.dao.jpa.drugstorage.ISupplierDao;
import com.ssh.dao.jpa.drugstorage.YaokuKucunDao;
import com.ssh.dao.jpa.staff.IEmpDAO;
import com.ssh.pojos.Drug;
import com.ssh.pojos.DrugAcceptance;
import com.ssh.pojos.DrugAcceptanceXq;
import com.ssh.pojos.DrugTuihuo;
import com.ssh.pojos.DrugTuihuoXq;
import com.ssh.pojos.YaokuKucun;
import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;
import com.ssh.vo.drugstorage.TuihuoVo;
import com.ssh.vo.drugstorage.YanshouVo;

@Service
@Transactional
public class ReturnService {
	
	@Autowired
	private IReturnDao IRDao;
	@Autowired
	private IAcceptanceDao IADao;
	@Autowired
	private ISupplierDao ISDao;
	@Autowired
	private IEmpDAO IEDao;
	@Autowired
	private IDrugDao IDDAO;
	@Autowired
	private IReturnXqDao IRXDao;
	@Autowired
	private IAcceptanceXqDao AXQDao;
	
	private List<TuihuoVo> list=new ArrayList<>();
	
	public String RNumber(){
		return IRDao.selectRNumber(CommentOrder.dateLike());
	}
	
	/**
	 * 鏌ヨ閫�璐ц鎯�
	 * @param drugAcceptanceId
	 * @return
	 */
	public List<TuihuoVo> selectThxq(String drugAcceptanceId){
		if(drugAcceptanceId != null){
			list = new ArrayList<>();
			DrugAcceptance da=IADao.findOne(drugAcceptanceId);
			if(da.getDrugAcceptanceXqs() != null){
				for (DrugAcceptanceXq t : da.getDrugAcceptanceXqs()) {
					if(t.getDrugAcceptanceXqBuhegeNum().intValue() > 0){
						TuihuoVo th=new TuihuoVo();
						th.setId(list.size()+1);
						th.setBuhegenum(t.getDrugAcceptanceXqBuhegeNum());
						th.setBz(null);
						th.setDj(t.getDrugAcceptanceXqPrice());
						th.setJe(t.getDrugAcceptanceXqMoney());
						th.setPh(t.getDrugAcceptanceXqPh());
						th.setYpid(t.getDrug().getDrugId());
						th.setYpname(t.getDrug().getDrugName());
						list.add(th);
					}
				}
			}
		}
		return list;
	}
	
	
	/**
	 * 鏌ヨ
	 * @return
	 */
	public List<TuihuoVo> FindAll(){
		return list;
	}
	
	/**
	 * 娓呴櫎
	 */
	public void clear(){
		list.clear();
	}
	
	/**
	 * 閫�璐�
	 * @param dt
	 * @param empId
	 * @param supplierId
	 * @param drugAcceptanceId
	 * @return
	 */
	public Errors insertTuihuoChuli(DrugTuihuo dt,Long empId,String supplierId,String drugAcceptanceId){
		try {
			dt.setEmp(IEDao.findOne(empId));
			dt.setSupplier(ISDao.findOne(supplierId));
			dt.setDrugAcceptance(IADao.findOne(drugAcceptanceId));
			dt.setDrugTuihuoState("已退货�");
			IRDao.save(dt);
			insertTuihuo(dt);
			upadteBuhegenum(drugAcceptanceId);
			return new Errors(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Errors(e.getMessage());
		}
	}
	
	/**
	 * 娣诲姞閫�璐ц鎯呭崟
	 * @param dt
	 */
	public void insertTuihuo(DrugTuihuo dt){
		for (TuihuoVo t : list) {
			DrugTuihuoXq dtxq=new DrugTuihuoXq();
			dtxq.setDrug(IDDAO.findOne(t.getYpid()));
			dtxq.setDrugAcceptanceXqMoney(t.getJe());
			dtxq.setDrugAcceptanceXqNum(t.getBuhegenum());
			dtxq.setDrugAcceptanceXqPh(t.getPh());
			dtxq.setDrugAcceptanceXqPrice(t.getDj());
			dtxq.setDrugAcceptanceXqRemark(t.getBz());
			dtxq.setDrugTuihuo(IRDao.findOne(dt.getDrugTuihuoId()));
			dtxq.setDrugTuihuoXqId(IRXDao.selectmaxId());
			IRXDao.save(dtxq);
		}
	}
	
	/**
	 * 淇敼涓嶅悎鏍兼暟閲�
	 * @param drugAcceptanceId
	 */
	public void upadteBuhegenum(String drugAcceptanceId){
		DrugAcceptance da=IADao.findOne(drugAcceptanceId);
		if(da.getDrugAcceptanceXqs() != null){
			for (DrugAcceptanceXq d : da.getDrugAcceptanceXqs()) {
				DrugAcceptanceXq dxq=AXQDao.findOne(d.getDrugAcceptanceXq());
				dxq.setDrugAcceptanceXqBuhegeNum(new BigDecimal(0));
			}
		}
	}
	
	/**
	 * 璁＄畻閫�璐ч噾棰�
	 * @return
	 */
	public double JisuanMoney(){
		double moeny = 0.0;
		for (TuihuoVo t : list) {
			moeny = t.getBuhegenum().doubleValue() * t.getDj().doubleValue();
		}
		return moeny;
	}
}
