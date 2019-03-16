package com.ssh.vo.behospitalized;

import java.math.BigDecimal;
import java.util.Date;

public class OutpaitentRegistVo {
	private String outpaitentRegistId;

	private String outpaitentRegistBinglihao;

	private Date outpaitentRegistGuahaodate;

	private String outpaitentRegistGuahaotime;

	private BigDecimal outpaitentRegistLiushuihao;

	private String outpaitentRegistType;

	private String outpaitentRegistZhuangtai;

	private DclassVo dclass;
	
	private EmpVo emp;
	
	private MedicalCardVo medicalCard;

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

	public String getOutpaitentRegistGuahaotime() {
		return outpaitentRegistGuahaotime;
	}

	public void setOutpaitentRegistGuahaotime(String outpaitentRegistGuahaotime) {
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

	public DclassVo getDclass() {
		return dclass;
	}

	public void setDclass(DclassVo dclass) {
		this.dclass = dclass;
	}

	public EmpVo getEmp() {
		return emp;
	}

	public void setEmp(EmpVo emp) {
		this.emp = emp;
	}

	public MedicalCardVo getMedicalCard() {
		return medicalCard;
	}

	public void setMedicalCard(MedicalCardVo medicalCard) {
		this.medicalCard = medicalCard;
	}

	public OutpaitentRegistVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OutpaitentRegistVo(String outpaitentRegistId, String outpaitentRegistBinglihao,
			Date outpaitentRegistGuahaodate, String outpaitentRegistGuahaotime, BigDecimal outpaitentRegistLiushuihao,
			String outpaitentRegistType, String outpaitentRegistZhuangtai) {
		super();
		this.outpaitentRegistId = outpaitentRegistId;
		this.outpaitentRegistBinglihao = outpaitentRegistBinglihao;
		this.outpaitentRegistGuahaodate = outpaitentRegistGuahaodate;
		this.outpaitentRegistGuahaotime = outpaitentRegistGuahaotime;
		this.outpaitentRegistLiushuihao = outpaitentRegistLiushuihao;
		this.outpaitentRegistType = outpaitentRegistType;
		this.outpaitentRegistZhuangtai = outpaitentRegistZhuangtai;
	}

	public OutpaitentRegistVo(String outpaitentRegistId, String outpaitentRegistBinglihao,
			Date outpaitentRegistGuahaodate, String outpaitentRegistGuahaotime, BigDecimal outpaitentRegistLiushuihao,
			String outpaitentRegistType, String outpaitentRegistZhuangtai, DclassVo dclass, EmpVo emp,
			MedicalCardVo medicalCard) {
		super();
		this.outpaitentRegistId = outpaitentRegistId;
		this.outpaitentRegistBinglihao = outpaitentRegistBinglihao;
		this.outpaitentRegistGuahaodate = outpaitentRegistGuahaodate;
		this.outpaitentRegistGuahaotime = outpaitentRegistGuahaotime;
		this.outpaitentRegistLiushuihao = outpaitentRegistLiushuihao;
		this.outpaitentRegistType = outpaitentRegistType;
		this.outpaitentRegistZhuangtai = outpaitentRegistZhuangtai;
		this.dclass = dclass;
		this.emp = emp;
		this.medicalCard = medicalCard;
	}

	public OutpaitentRegistVo(String outpaitentRegistId) {
		super();
		this.outpaitentRegistId = outpaitentRegistId;
	}

	

	
}
