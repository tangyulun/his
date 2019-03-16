package com.ssh.vo.operation;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.ssh.pojos.Dclass;
import com.ssh.pojos.Emp;
import com.ssh.pojos.MedicalCard;

public class OutpaitentRegistVo {
	private String outpaitentRegistId;

	private String outpaitentRegistBinglihao;

	private Date outpaitentRegistGuahaodate;

	private String outpaitentRegistGuahaotime;

	private BigDecimal outpaitentRegistLiushuihao;

	private String outpaitentRegistType;

	private String outpaitentRegistZhuangtai;
	
	private Dclass dclass;

	private Emp emp;

	private MedicalCard medicalCard;

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

	public Dclass getDclass() {
		return dclass;
	}

	public void setDclass(Dclass dclass) {
		this.dclass = dclass;
	}

	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public MedicalCard getMedicalCard() {
		return medicalCard;
	}

	public void setMedicalCard(MedicalCard medicalCard) {
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
	
	
}
