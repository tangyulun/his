package com.ssh.vo.outpatient;
/**
 * 门诊表
 */
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.ssh.pojos.PrescriptionType;

public class OutpatientVo {

	private String outpaitentRegistId;//门诊id

	private String outpaitentRegistBinglihao;//门诊病历号

	private Date outpaitentRegistGuahaodate;//挂号日期

	private Date outpaitentRegistGuahaotime;//挂号时间

	private BigDecimal outpaitentRegistLiushuihao;//流水号

	private String outpaitentRegistType;//类型

	private String outpaitentRegistZhuangtai;//状态
	
	private List<PrescriptionTypesVo> prescriptionTypes;

	public String getOutpaitentRegistId() {
		return outpaitentRegistId;
	}

	public void setOutpaitentRegistId(String outpaitentRegistId) {
		this.outpaitentRegistId = outpaitentRegistId;
	}

	public String getOutpaitentRegistBinglihao() {
		return outpaitentRegistBinglihao;
	}

	public void setOutpaitentRegistBinglihao(String outpaitentRegistBinglihao) {
		this.outpaitentRegistBinglihao = outpaitentRegistBinglihao;
	}

	public Date getOutpaitentRegistGuahaodate() {
		return outpaitentRegistGuahaodate;
	}

	public void setOutpaitentRegistGuahaodate(Date outpaitentRegistGuahaodate) {
		this.outpaitentRegistGuahaodate = outpaitentRegistGuahaodate;
	}

	public Date getOutpaitentRegistGuahaotime() {
		return outpaitentRegistGuahaotime;
	}

	public void setOutpaitentRegistGuahaotime(Date outpaitentRegistGuahaotime) {
		this.outpaitentRegistGuahaotime = outpaitentRegistGuahaotime;
	}

	public BigDecimal getOutpaitentRegistLiushuihao() {
		return outpaitentRegistLiushuihao;
	}

	public void setOutpaitentRegistLiushuihao(BigDecimal outpaitentRegistLiushuihao) {
		this.outpaitentRegistLiushuihao = outpaitentRegistLiushuihao;
	}

	public String getOutpaitentRegistType() {
		return outpaitentRegistType;
	}

	public void setOutpaitentRegistType(String outpaitentRegistType) {
		this.outpaitentRegistType = outpaitentRegistType;
	}

	public String getOutpaitentRegistZhuangtai() {
		return outpaitentRegistZhuangtai;
	}

	public void setOutpaitentRegistZhuangtai(String outpaitentRegistZhuangtai) {
		this.outpaitentRegistZhuangtai = outpaitentRegistZhuangtai;
	}

	public List<PrescriptionTypesVo> getPrescriptionTypes() {
		return prescriptionTypes;
	}

	public void setPrescriptionTypes(List<PrescriptionTypesVo> prescriptionTypes) {
		this.prescriptionTypes = prescriptionTypes;
	}

	public OutpatientVo(String outpaitentRegistId, String outpaitentRegistBinglihao, Date outpaitentRegistGuahaodate,
			Date outpaitentRegistGuahaotime, BigDecimal outpaitentRegistLiushuihao, String outpaitentRegistType,
			String outpaitentRegistZhuangtai) {
		super();
		this.outpaitentRegistId = outpaitentRegistId;
		this.outpaitentRegistBinglihao = outpaitentRegistBinglihao;
		this.outpaitentRegistGuahaodate = outpaitentRegistGuahaodate;
		this.outpaitentRegistGuahaotime = outpaitentRegistGuahaotime;
		this.outpaitentRegistLiushuihao = outpaitentRegistLiushuihao;
		this.outpaitentRegistType = outpaitentRegistType;
		this.outpaitentRegistZhuangtai = outpaitentRegistZhuangtai;
	}

	public OutpatientVo(String outpaitentRegistId, String outpaitentRegistBinglihao
			) {
		super();
		this.outpaitentRegistId = outpaitentRegistId;
		this.outpaitentRegistBinglihao = outpaitentRegistBinglihao;
	}

	
	
	
	
	
}
