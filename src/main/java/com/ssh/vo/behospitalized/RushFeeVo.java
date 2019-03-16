package com.ssh.vo.behospitalized;

import java.math.BigDecimal;
import java.util.Date;

import com.ssh.pojos.HospitalRegistration;

public class RushFeeVo {
	private String rushFeeId;

	private Date rushFeeDate;

	private BigDecimal rushFeeHospitalRental;

	private Date rushFeeLimitPaymentDate;

	private String rushFeeRemark;

	private BigDecimal rushFeeSettle;

	private String rushFeeState;

	private BigDecimal rushFeeWorthOfValue;

	private HospitalRegistrationVo hospitalRegistration;

	public String getRushFeeId() {
		return rushFeeId;
	}

	public void setRushFeeId(String rushFeeId) {
		this.rushFeeId = rushFeeId;
	}

	public Date getRushFeeDate() {
		return rushFeeDate;
	}

	public void setRushFeeDate(Date rushFeeDate) {
		this.rushFeeDate = rushFeeDate;
	}

	public BigDecimal getRushFeeHospitalRental() {
		return rushFeeHospitalRental;
	}

	public void setRushFeeHospitalRental(BigDecimal rushFeeHospitalRental) {
		this.rushFeeHospitalRental = rushFeeHospitalRental;
	}

	public Date getRushFeeLimitPaymentDate() {
		return rushFeeLimitPaymentDate;
	}

	public void setRushFeeLimitPaymentDate(Date rushFeeLimitPaymentDate) {
		this.rushFeeLimitPaymentDate = rushFeeLimitPaymentDate;
	}

	public String getRushFeeRemark() {
		return rushFeeRemark;
	}

	public void setRushFeeRemark(String rushFeeRemark) {
		this.rushFeeRemark = rushFeeRemark;
	}

	public BigDecimal getRushFeeSettle() {
		return rushFeeSettle;
	}

	public void setRushFeeSettle(BigDecimal rushFeeSettle) {
		this.rushFeeSettle = rushFeeSettle;
	}

	public String getRushFeeState() {
		return rushFeeState;
	}

	public void setRushFeeState(String rushFeeState) {
		this.rushFeeState = rushFeeState;
	}

	public BigDecimal getRushFeeWorthOfValue() {
		return rushFeeWorthOfValue;
	}

	public void setRushFeeWorthOfValue(BigDecimal rushFeeWorthOfValue) {
		this.rushFeeWorthOfValue = rushFeeWorthOfValue;
	}
	

	public HospitalRegistrationVo getHospitalRegistration() {
		return hospitalRegistration;
	}

	public void setHospitalRegistration(HospitalRegistrationVo hospitalRegistration) {
		this.hospitalRegistration = hospitalRegistration;
	}

	public RushFeeVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RushFeeVo(String rushFeeId, Date rushFeeDate, BigDecimal rushFeeHospitalRental, Date rushFeeLimitPaymentDate,
			String rushFeeRemark, BigDecimal rushFeeSettle, String rushFeeState, BigDecimal rushFeeWorthOfValue) {
		super();
		this.rushFeeId = rushFeeId;
		this.rushFeeDate = rushFeeDate;
		this.rushFeeHospitalRental = rushFeeHospitalRental;
		this.rushFeeLimitPaymentDate = rushFeeLimitPaymentDate;
		this.rushFeeRemark = rushFeeRemark;
		this.rushFeeSettle = rushFeeSettle;
		this.rushFeeState = rushFeeState;
		this.rushFeeWorthOfValue = rushFeeWorthOfValue;
	}
	
	
}
