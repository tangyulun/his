package com.ssh.vo.operation;

import java.math.BigDecimal;

import com.ssh.vo.outpatient.FinacialVo;

public class ShouShuXmVo {
	private long id;
	private BigDecimal money;
	private String name;
	private BigDecimal num;
	private BigDecimal danjia;
	private String jieguo;
	private String type;
	private FinacialVo finacialVo;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public BigDecimal getMoney() {
		return money;
	}
	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getNum() {
		return num;
	}
	public void setNum(BigDecimal num) {
		this.num = num;
	}
	public BigDecimal getDanjia() {
		return danjia;
	}
	public void setDanjia(BigDecimal danjia) {
		this.danjia = danjia;
	}
	public String getJieguo() {
		return jieguo;
	}
	public void setJieguo(String jieguo) {
		this.jieguo = jieguo;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public FinacialVo getFinacialVo() {
		return finacialVo;
	}
	public void setFinacialVo(FinacialVo finacialVo) {
		this.finacialVo = finacialVo;
	}
	public ShouShuXmVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ShouShuXmVo(long id, BigDecimal money, String name, BigDecimal num, BigDecimal danjia, String jieguo,
			String type) {
		super();
		this.id = id;
		this.money = money;
		this.name = name;
		this.num = num;
		this.danjia = danjia;
		this.jieguo = jieguo;
		this.type = type;
	}
	
}
