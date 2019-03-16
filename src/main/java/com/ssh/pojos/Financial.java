package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the FINANCIAL database table.
 * 
 */
@Entity
@NamedQuery(name="Financial.findAll", query="SELECT f FROM Financial f")
public class Financial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="FINANCIAL_ID")
	private String financialId;

	@Temporal(TemporalType.DATE)
	@Column(name="FINANCIAL_CREATOR_DATE")
	private Date financialCreatorDate;

	@Column(name="FINANCIAL_EXPLAIN")
	private String financialExplain;

	@Column(name="FINANCIAL_MONEY")
	private BigDecimal financialMoney;

	@Column(name="FINANCIAL_NAME")
	private String financialName;

	@Column(name="FINANCIAL_PRICE")
	private BigDecimal financialPrice;

	@Column(name="FINANCIAL_TYPE")
	private String financialType;

	@Column(name="FINANCIAL_ZHEKOUJIA")
	private BigDecimal financialZhekoujia;

	//bi-directional many-to-one association to Emp
	@ManyToOne
	@JoinColumn(name="EMP_ID")
	private Emp emp;

	//bi-directional many-to-one association to FinancialType
	@ManyToOne
	@JoinColumn(name="FINANCIAL_TYPE_ID")
	private FinancialType financialTypeBean;

	//bi-directional many-to-one association to FinancialHistory
	@OneToMany(mappedBy="financial")
	private List<FinancialHistory> financialHistories;

	//bi-directional many-to-one association to ZhiliaoJizhangXq
	@OneToMany(mappedBy="financial")
	private List<ZhiliaoJizhangXq> zhiliaoJizhangXqs;

	public Financial() {
	}

	public String getFinancialId() {
		return this.financialId;
	}

	public void setFinancialId(String financialId) {
		this.financialId = financialId;
	}

	public Date getFinancialCreatorDate() {
		return this.financialCreatorDate;
	}

	public void setFinancialCreatorDate(Date financialCreatorDate) {
		this.financialCreatorDate = financialCreatorDate;
	}

	public String getFinancialExplain() {
		return this.financialExplain;
	}

	public void setFinancialExplain(String financialExplain) {
		this.financialExplain = financialExplain;
	}

	public BigDecimal getFinancialMoney() {
		return this.financialMoney;
	}

	public void setFinancialMoney(BigDecimal financialMoney) {
		this.financialMoney = financialMoney;
	}

	public String getFinancialName() {
		return this.financialName;
	}

	public void setFinancialName(String financialName) {
		this.financialName = financialName;
	}

	public BigDecimal getFinancialPrice() {
		return this.financialPrice;
	}

	public void setFinancialPrice(BigDecimal financialPrice) {
		this.financialPrice = financialPrice;
	}

	public String getFinancialType() {
		return this.financialType;
	}

	public void setFinancialType(String financialType) {
		this.financialType = financialType;
	}

	public BigDecimal getFinancialZhekoujia() {
		return this.financialZhekoujia;
	}

	public void setFinancialZhekoujia(BigDecimal financialZhekoujia) {
		this.financialZhekoujia = financialZhekoujia;
	}

	public Emp getEmp() {
		return this.emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public FinancialType getFinancialTypeBean() {
		return this.financialTypeBean;
	}

	public void setFinancialTypeBean(FinancialType financialTypeBean) {
		this.financialTypeBean = financialTypeBean;
	}

	public List<FinancialHistory> getFinancialHistories() {
		return this.financialHistories;
	}

	public void setFinancialHistories(List<FinancialHistory> financialHistories) {
		this.financialHistories = financialHistories;
	}

	public FinancialHistory addFinancialHistory(FinancialHistory financialHistory) {
		getFinancialHistories().add(financialHistory);
		financialHistory.setFinancial(this);

		return financialHistory;
	}

	public FinancialHistory removeFinancialHistory(FinancialHistory financialHistory) {
		getFinancialHistories().remove(financialHistory);
		financialHistory.setFinancial(null);

		return financialHistory;
	}

	public List<ZhiliaoJizhangXq> getZhiliaoJizhangXqs() {
		return this.zhiliaoJizhangXqs;
	}

	public void setZhiliaoJizhangXqs(List<ZhiliaoJizhangXq> zhiliaoJizhangXqs) {
		this.zhiliaoJizhangXqs = zhiliaoJizhangXqs;
	}

	public ZhiliaoJizhangXq addZhiliaoJizhangXq(ZhiliaoJizhangXq zhiliaoJizhangXq) {
		getZhiliaoJizhangXqs().add(zhiliaoJizhangXq);
		zhiliaoJizhangXq.setFinancial(this);

		return zhiliaoJizhangXq;
	}

	public ZhiliaoJizhangXq removeZhiliaoJizhangXq(ZhiliaoJizhangXq zhiliaoJizhangXq) {
		getZhiliaoJizhangXqs().remove(zhiliaoJizhangXq);
		zhiliaoJizhangXq.setFinancial(null);

		return zhiliaoJizhangXq;
	}

}