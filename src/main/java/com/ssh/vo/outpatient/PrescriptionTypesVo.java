package com.ssh.vo.outpatient;
/**
 * 划价表
 */
import java.math.BigDecimal;
import java.util.Date;

import com.ssh.pojos.OutpaitentRegist;

public class PrescriptionTypesVo {
	private String prespricedId;

	private BigDecimal prespricedYsje;

	private BigDecimal prespricedZongfeiyong;

	private String prespricedZt;
	
	private Date prespricednDate;

	private OutpatientVo outpaitentRegist;
	
	public String getPrespricedId() {
		return prespricedId;
	}

	public void setPrespricedId(String prespricedId) {
		this.prespricedId = prespricedId;
	}

	public BigDecimal getPrespricedYsje() {
		return prespricedYsje;
	}

	public void setPrespricedYsje(BigDecimal prespricedYsje) {
		this.prespricedYsje = prespricedYsje;
	}

	public BigDecimal getPrespricedZongfeiyong() {
		return prespricedZongfeiyong;
	}

	public void setPrespricedZongfeiyong(BigDecimal prespricedZongfeiyong) {
		this.prespricedZongfeiyong = prespricedZongfeiyong;
	}

	public String getPrespricedZt() {
		return prespricedZt;
	}

	public void setPrespricedZt(String prespricedZt) {
		this.prespricedZt = prespricedZt;
	}

	public Date getPrespricednDate() {
		return prespricednDate;
	}

	public void setPrespricednDate(Date prespricednDate) {
		this.prespricednDate = prespricednDate;
	}

	
	public OutpatientVo getOutpaitentRegist() {
		return outpaitentRegist;
	}

	public void setOutpaitentRegist(OutpatientVo outpaitentRegist) {
		this.outpaitentRegist = outpaitentRegist;
	}

	public PrescriptionTypesVo(String prespricedId, BigDecimal prespricedYsje, BigDecimal prespricedZongfeiyong,
			String prespricedZt, Date prespricednDate) {
		super();
		this.prespricedId = prespricedId;
		this.prespricedYsje = prespricedYsje;
		this.prespricedZongfeiyong = prespricedZongfeiyong;
		this.prespricedZt = prespricedZt;
		this.prespricednDate = prespricednDate;
	}

	public PrescriptionTypesVo(String prespricedId) {
		super();
		this.prespricedId = prespricedId;
	}
	
	
}
