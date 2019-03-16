package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the RUSH_FEE database table.
 * 
 */
@Entity
@Table(name="RUSH_FEE")
@NamedQuery(name="RushFee.findAll", query="SELECT r FROM RushFee r")
public class RushFee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="RUSH_FEE_ID")
	private String rushFeeId;

	@Temporal(TemporalType.DATE)
	@Column(name="RUSH_FEE_DATE")
	private Date rushFeeDate;

	@Column(name="RUSH_FEE_HOSPITAL_RENTAL")
	private BigDecimal rushFeeHospitalRental;

	@Temporal(TemporalType.DATE)
	@Column(name="RUSH_FEE_LIMIT_PAYMENT_DATE")
	private Date rushFeeLimitPaymentDate;

	@Column(name="RUSH_FEE_REMARK")
	private String rushFeeRemark;

	@Column(name="RUSH_FEE_SETTLE")
	private BigDecimal rushFeeSettle;

	@Column(name="RUSH_FEE_STATE")
	private String rushFeeState;

	@Column(name="RUSH_FEE_WORTH_OF_VALUE")
	private BigDecimal rushFeeWorthOfValue;

	//bi-directional many-to-one association to HospitalRegistration
	@ManyToOne
	@JoinColumn(name="HOSPITAL_REGISTRATION_ID")
	private HospitalRegistration hospitalRegistration;

	public RushFee() {
	}

	public String getRushFeeId() {
		return this.rushFeeId;
	}

	public void setRushFeeId(String rushFeeId) {
		this.rushFeeId = rushFeeId;
	}

	public Date getRushFeeDate() {
		return this.rushFeeDate;
	}

	public void setRushFeeDate(Date rushFeeDate) {
		this.rushFeeDate = rushFeeDate;
	}

	public BigDecimal getRushFeeHospitalRental() {
		return this.rushFeeHospitalRental;
	}

	public void setRushFeeHospitalRental(BigDecimal rushFeeHospitalRental) {
		this.rushFeeHospitalRental = rushFeeHospitalRental;
	}

	public Date getRushFeeLimitPaymentDate() {
		return this.rushFeeLimitPaymentDate;
	}

	public void setRushFeeLimitPaymentDate(Date rushFeeLimitPaymentDate) {
		this.rushFeeLimitPaymentDate = rushFeeLimitPaymentDate;
	}

	public String getRushFeeRemark() {
		return this.rushFeeRemark;
	}

	public void setRushFeeRemark(String rushFeeRemark) {
		this.rushFeeRemark = rushFeeRemark;
	}

	public BigDecimal getRushFeeSettle() {
		return this.rushFeeSettle;
	}

	public void setRushFeeSettle(BigDecimal rushFeeSettle) {
		this.rushFeeSettle = rushFeeSettle;
	}

	public String getRushFeeState() {
		return this.rushFeeState;
	}

	public void setRushFeeState(String rushFeeState) {
		this.rushFeeState = rushFeeState;
	}

	public BigDecimal getRushFeeWorthOfValue() {
		return this.rushFeeWorthOfValue;
	}

	public void setRushFeeWorthOfValue(BigDecimal rushFeeWorthOfValue) {
		this.rushFeeWorthOfValue = rushFeeWorthOfValue;
	}

	public HospitalRegistration getHospitalRegistration() {
		return this.hospitalRegistration;
	}

	public void setHospitalRegistration(HospitalRegistration hospitalRegistration) {
		this.hospitalRegistration = hospitalRegistration;
	}

}