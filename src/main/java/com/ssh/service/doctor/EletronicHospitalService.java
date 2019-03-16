package com.ssh.service.doctor;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
/**
 * 电子处方选项卡医疗项目
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.dao.jpa.behospitalized.IHospitalRegistrationDAO;
import com.ssh.dao.jpa.doctor.DrugChuFnag;
import com.ssh.dao.jpa.doctor.IEletronicDAO;
import com.ssh.dao.jpa.drugstorage.IDrugTypeDao;
import com.ssh.dao.jpa.outpatient.IFinancialDao;
import com.ssh.dao.jpa.outpatient.IFinancialHistoryDao;
import com.ssh.dao.jpa.outpatient.IOutpaitentDAO;
import com.ssh.pojos.DrugType;
import com.ssh.pojos.Financial;
import com.ssh.pojos.FinancialHistory;
import com.ssh.pojos.OutpaitentRegist;
import com.ssh.pojos.Prescription;
import com.ssh.vo.doctor.DrugChuFangVO;
import com.ssh.vo.doctor.HospitalProjectVo;
import com.ssh.vo.doctor.KuCunVO;
import com.ssh.vo.drugstorage.DrugTypeVo;
import com.ssh.vo.drugstorage.UnitVo;
import com.ssh.vo.outpatient.FinancialHistoryVo;

@Service
@Transactional
public class EletronicHospitalService {
	
	@Autowired
	private IOutpaitentDAO IODAO;
	
	@Autowired
	private IFinancialHistoryDao finanCodeDao;
	
	
	@Autowired
	private IHospitalRegistrationDAO IHDAO;
	
	@Autowired
	private IFinancialDao IFDAO;
	List<HospitalProjectVo> list = new ArrayList<>();
	
	/**
	 * 新增记录
	 * @param project
	 */
	public void addHospitalProject(HospitalProjectVo project){
		project.setFinancialzt("未");
		project.setFinancialTypeName("处方医疗");
		project.setId(String.valueOf(list.size() + 1));
		if(list.size()==0){
			list.add(project);
			return;
		}
		
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getFinancialId().equals(project.getFinancialId())){
				list.get(i).setFinancialNum(new BigDecimal(list.get(i).getFinancialNum().intValue()
						+project.getFinancialNum().intValue()));
				list.get(i).setFinancialMoney(new BigDecimal(list.get(i).getFinancialNum().intValue()
						*list.get(i).getFinancialPrice().intValue()));
				break;
			}else if(i == list.size() - 1){
				list.add(project);
				break;
			}
			
		}
		
	}
	
	/**
	 * 查询所有
	 */
	public List<HospitalProjectVo> queryHospital(){
		return list;
	}
	
	public void clearHospital(){
		list.clear();
	}
	
	/**
	 * 删除表格
	 */
	public void deleteGridCode(List<Long> shanchu){
		for (Long l : shanchu) {
			for (HospitalProjectVo h : list) {
				if(Long.parseLong(h.getId())== l){
					list.remove(h);
					break;
				}
			}
		}
	}
	
	public void saveSFJL(String outRegistId, String hId) {
		OutpaitentRegist reg = null;
		//清空记录重新添加
		if(!"".equals(hId)){
			reg = IODAO.findOne(IHDAO.findOne(hId).getHospitaNotify().getOutpaitentRegist().getOutpaitentRegistId());
		}else{
			 reg = IODAO.findOne(outRegistId);
		}
		System.err.println("aas"+reg);
		for (HospitalProjectVo f : list) {
			FinancialHistory ft = new FinancialHistory();
			ft.setFinancialHistoryId((finanCodeDao.count() + 1)+"");
			ft.setFinancialHistoryShoufeilx(f.getFinancialTypeName());
			ft.setOutpaitentRegist(reg);
			ft.setFinancial(IFDAO.findOne(f.getFinancialId()));
			ft.setFinancialHistoryShoufeije(f.getFinancialMoney());
			ft.setFinancialHistoryNum(f.getFinancialNum());
			ft.setFinancialHistoryShoufeirq(new Date());
			ft.setFinancialHistoryShoufeisj(new SimpleDateFormat("HH:mm:ss").format(new Date()));
			ft.setFinancialHistoryShoufeizt(f.getFinancialzt());
			finanCodeDao.save(ft);
		}
	}

	public double sumMoney() {
		double money =0.0;
		for (HospitalProjectVo h : list) {
			money +=h.getFinancialMoney().doubleValue();
		}
		return money;
	}

}
