package com.ssh.service.outpatient;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
/**
 * 收费记录业务类
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.dao.jpa.outpatient.IFinancialDao;
import com.ssh.dao.jpa.outpatient.IFinancialHistoryDao;
import com.ssh.dao.jpa.outpatient.IOutpaitentDAO;
import com.ssh.dao.mybatis.outpatient.IOutPatientRegistDao;
import com.ssh.pojos.FinancialHistory;
import com.ssh.pojos.OutpaitentRegist;
import com.ssh.utils.Errors;
import com.ssh.vo.outpatient.FinancialHistoryVo;

@Service
@Transactional
public class FinancialHistoryService {

	@Autowired
	private IFinancialHistoryDao finanCodeDao;
	@Autowired
	private IFinancialDao IFDAO;
	@Autowired
	private IOutpaitentDAO outpaitentDAO;
	@Autowired
	private IOutpaitentDAO IODAO;
	List<FinancialHistoryVo> list = new ArrayList<>();

	public Errors addFinancialCode(FinancialHistoryVo historyVo) {
			historyVo.setId(list.size()+1);
			if(historyVo.getFinancialHistoryShoufeije() == null){
				historyVo.setFinancialHistoryShoufeilx("挂号收费");
			}else{
				historyVo.setFinancialHistoryShoufeilx(historyVo.getFinancialHistoryShoufeije().intValue() > 0 ? "挂号收费" : "挂号退费");
			}
			historyVo.setFinancialHistoryShoufeisj(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			historyVo.setFinancialHistoryShoufeiNum(new BigDecimal(1));
			historyVo.setFinancialHistoryShoufeizt("未");
			list.add(historyVo);
			return new Errors(true);
	}
	/**
	 * 查询所有
	 * @return
	 */
	public List<FinancialHistoryVo> queryFinancialHistory() {
		System.out.println(list);
		return list;
	}
	
	
	public void clearHistory(){
		list.clear();
	}
	

	public List<FinancialHistoryVo> queryFinancialCode(String outpaitentRegistId) {
		list.clear();
		OutpaitentRegist regist = outpaitentDAO.findOne(outpaitentRegistId);
		if(regist.getFinancialHistories() != null){
			for (FinancialHistory f : regist.getFinancialHistories()) {
				list.add(new FinancialHistoryVo(list.size()+1, f.getFinancialHistoryId(), f.getFinancialHistoryShoufeilx(), f.getFinancial().getFinancialName(),
						f.getFinancialHistoryShoufeirq(), f.getFinancialHistoryShoufeisj(), f.getFinancialHistoryShoufeije(), f.getFinancialHistoryShoufeizt()));
			}
		}
		return list;
	}


	/**
	 * 删除记录
	 * @param dealString
	 * @return 
	 */
	public Errors deletesCode(List<Long> dealString) {
			for (Long l : dealString) {
				for (FinancialHistoryVo f : list) {
					if(f.getId() == l){
						list.remove(f);
						break;
					}
			}
		}
		return new Errors(true);
		
	}
	
	public void saveSFJL(OutpaitentRegist regist, String state) {
		//清空记录重新添加
		OutpaitentRegist reg = IODAO.findOne(regist.getOutpaitentRegistId());
		if(reg.getFinancialHistories() == null){
			reg.setFinancialHistories(new ArrayList<>());
		}else{
			finanCodeDao.delete(reg.getFinancialHistories());
		}
		for (FinancialHistoryVo financialHistoryVo : list) {
			System.err.println(financialHistoryVo.getFinancialHistoryShoufeilx());
		}
		for (FinancialHistoryVo f : list) {
			FinancialHistory ft = new FinancialHistory();
			ft.setFinancialHistoryId(finanCodeDao.count()+1+"");
			ft.setFinancialHistoryShoufeilx(f.getFinancialHistoryShoufeilx());
			ft.setOutpaitentRegist(regist);
			ft.setFinancial(IFDAO.findOne(f.getFinancialHistoryId()));
			ft.setFinancialHistoryShoufeije(f.getFinancialHistoryShoufeije());
			ft.setFinancialHistoryShoufeirq(regist.getOutpaitentRegistGuahaodate());
			ft.setFinancialHistoryShoufeisj(regist.getOutpaitentRegistGuahaotime());
			ft.setFinancialHistoryNum(f.getFinancialHistoryShoufeiNum());
			ft.setFinancialHistoryShoufeizt(f.getFinancialHistoryShoufeizt());
			finanCodeDao.save(ft);
		}
	}
}
