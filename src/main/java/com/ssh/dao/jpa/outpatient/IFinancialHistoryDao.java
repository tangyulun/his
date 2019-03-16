package com.ssh.dao.jpa.outpatient;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.FinancialHistory;
import com.ssh.pojos.OutpaitentRegist;
import com.ssh.vo.doctor.HospitalProjectVo;
import com.ssh.vo.outpatient.FinancialHistoryVo2;

/**
 * 收费记录表
 * @author Administrator
 *
 */
public interface IFinancialHistoryDao extends CrudRepository<FinancialHistory, String>{

	//查询收费记录
	@Query("select nvl(max(f.financialHistoryId)+2 , 1) from  FinancialHistory f")
	public String queryFinancialCodeId();
	
	@Query("select new com.ssh.vo.outpatient.FinancialHistoryVo2(f.financialHistoryId, f.financialHistoryShoufeije,f.financialHistoryShoufeilx, f.financialHistoryShoufeirq,"
			+ " f.financialHistoryShoufeisj,f.financialHistoryShoufeizt, f.financialHistoryType) from FinancialHistory f where f.outpaitentRegist =?1")
	public List<FinancialHistoryVo2> selectAll(OutpaitentRegist o);

	@Query("select new com.ssh.vo.doctor.HospitalProjectVo(f.financialHistoryId, f.financialHistoryNum, f.financialHistoryShoufeije, f.financialHistoryShoufeizt) from FinancialHistory f"
			+ " where f.financial.financialTypeBean.financialTypeName !='手术费' "
			+ " and   f.financial.financialTypeBean.financialTypeName !='治疗费'"
			+ " and  f.financial.financialTypeBean.financialTypeName !='体检费'"
			+ " and  f.financial.financialTypeBean.financialTypeName !='耗材费'"
			+ " and  f.financial.financialTypeBean.financialTypeName !='门诊收费'"
			+ " and f.outpaitentRegist =?1")
	public List<HospitalProjectVo> queryFinancialByTypeName(OutpaitentRegist o);
	
	@Query("select to_char(f.financialHistoryShoufeirq, 'mm') , sum(f.financialHistoryShoufeije) "
			+ "from FinancialHistory f where f.financialHistoryShoufeizt='结'"
			+ " group by to_char(f.financialHistoryShoufeirq, 'mm')")
	public List<Object[]> selectZhexianTu();
	
	@Query("select to_char(h.financialHistoryShoufeirq , 'mm') , sum(h.financialHistoryShoufeije) "
			+ "from  FinancialHistory h inner join h.outpaitentRegist o inner join o.prescriptions p "
			+ "where p.prescriptionType =?1 and h.financialHistoryShoufeizt='结' group by  "
			+ "to_char(h.financialHistoryShoufeirq , 'mm')")
	public List<Object[]> seelctZhuxingtu(String type);

	
}
