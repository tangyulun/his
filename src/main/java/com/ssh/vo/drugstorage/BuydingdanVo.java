package com.ssh.vo.drugstorage;

import java.math.BigDecimal;

/**
 * 采购订单Vo
 * @author asus
 *
 */
public class BuydingdanVo {
	private int id;//用来删除
	private String ypid;//药品编号
	private String ypname;//药品名称
	private BigDecimal num;//数量
	private String dw;//单位
	private BigDecimal price;//单价
	private BigDecimal zprice;//金额
	private String ph;//批号
	private String bz;//备注
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getYpid() {
		return ypid;
	}
	public void setYpid(String ypid) {
		this.ypid = ypid;
	}
	public String getYpname() {
		return ypname;
	}
	public void setYpname(String ypname) {
		this.ypname = ypname;
	}
	public BigDecimal getNum() {
		return num;
	}
	public void setNum(BigDecimal num) {
		this.num = num;
	}
	public String getDw() {
		return dw;
	}
	public void setDw(String dw) {
		this.dw = dw;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getZprice() {
		return zprice;
	}
	public void setZprice(BigDecimal zprice) {
		this.zprice = zprice;
	}
	public String getPh() {
		return ph;
	}
	public void setPh(String ph) {
		this.ph = ph;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	
	public BuydingdanVo(int id, String ypid, String ypname, BigDecimal num, String dw, BigDecimal price, BigDecimal zprice,
			String ph, String bz) {
		super();
		this.id = id;
		this.ypid = ypid;
		this.ypname = ypname;
		this.num = num;
		this.dw = dw;
		this.price = price;
		this.zprice = zprice;
		this.ph = ph;
		this.bz = bz;
	}
	public BuydingdanVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "BuydingdanVo [ypid=" + ypid + ", ypname=" + ypname + ", num=" + num + ", dw=" + dw + ", price=" + price
				+ ", zprice=" + zprice + ", ph=" + ph + ", bz=" + bz + "]";
	}
	
}
