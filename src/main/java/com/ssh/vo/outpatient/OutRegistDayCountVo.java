package com.ssh.vo.outpatient;

public class OutRegistDayCountVo {
	private Integer year;
	private Integer income;
	private Integer expenses;
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public Integer getIncome() {
		return income;
	}
	public void setIncome(Integer income) {
		this.income = income;
	}
	public Integer getExpenses() {
		return expenses;
	}
	public void setExpenses(Integer expenses) {
		this.expenses = expenses;
	}
	public OutRegistDayCountVo(Integer year, Integer income, Integer expenses) {
		super();
		this.year = year;
		this.income = income;
		this.expenses = expenses;
	}
	public OutRegistDayCountVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "OutRegistDayCountVo [year=" + year + ", income=" + income + ", expenses=" + expenses + "]";
	}
	
	
}
