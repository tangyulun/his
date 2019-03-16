package com.ssh.vo.behospitalized;

import java.math.BigDecimal;
import java.util.Date;

public class FeiYongHeSuanVo {
	private Long id;
	private String shoufeileixing;
	private String shoufeinumber;
	private String shoufeiname;
	private Date shoufeiDate;
	private String shoufeiTime;
	private BigDecimal shuliang;
	private BigDecimal zmoney;
	private String shoufeistate;
	private String zhuyuandengjihao;
	private String chufanghao;
	private BigDecimal danjia;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getShoufeileixing() {
		return shoufeileixing;
	}
	public void setShoufeileixing(String shoufeileixing) {
		this.shoufeileixing = shoufeileixing;
	}
	public String getShoufeinumber() {
		return shoufeinumber;
	}
	public void setShoufeinumber(String shoufeinumber) {
		this.shoufeinumber = shoufeinumber;
	}
	public String getShoufeiname() {
		return shoufeiname;
	}
	public void setShoufeiname(String shoufeiname) {
		this.shoufeiname = shoufeiname;
	}
	public Date getShoufeiDate() {
		return shoufeiDate;
	}
	public void setShoufeiDate(Date shoufeiDate) {
		this.shoufeiDate = shoufeiDate;
	}
	public String getShoufeiTime() {
		return shoufeiTime;
	}
	public void setShoufeiTime(String shoufeiTime) {
		this.shoufeiTime = shoufeiTime;
	}
	public BigDecimal getZmoney() {
		return zmoney;
	}
	public void setZmoney(BigDecimal zmoney) {
		this.zmoney = zmoney;
	}
	public String getShoufeistate() {
		return shoufeistate;
	}
	public void setShoufeistate(String shoufeistate) {
		this.shoufeistate = shoufeistate;
	}
	public String getZhuyuandengjihao() {
		return zhuyuandengjihao;
	}
	public void setZhuyuandengjihao(String zhuyuandengjihao) {
		this.zhuyuandengjihao = zhuyuandengjihao;
	}
	
	public String getChufanghao() {
		return chufanghao;
	}
	public void setChufanghao(String chufanghao) {
		this.chufanghao = chufanghao;
	}
	
	
	
	
	public BigDecimal getDanjia() {
		return danjia;
	}
	public void setDanjia(BigDecimal danjia) {
		this.danjia = danjia;
	}
	public BigDecimal getShuliang() {
		return shuliang;
	}
	public void setShuliang(BigDecimal shuliang) {
		this.shuliang = shuliang;
	}
	public FeiYongHeSuanVo(Long id, String shoufeileixing, String shoufeinumber, String shoufeiname, Date shoufeiDate,
			String shoufeiTime, BigDecimal zmoney, String shoufeistate, String zhuyuandengjihao) {
		super();
		this.id = id;
		this.shoufeileixing = shoufeileixing;
		this.shoufeinumber = shoufeinumber;
		this.shoufeiname = shoufeiname;
		this.shoufeiDate = shoufeiDate;
		this.shoufeiTime = shoufeiTime;
		this.zmoney = zmoney;
		this.shoufeistate = shoufeistate;
		this.zhuyuandengjihao = zhuyuandengjihao;
	}
	

	public FeiYongHeSuanVo(Long id, String shoufeinumber, String shoufeiname, BigDecimal shuliang, BigDecimal zmoney,
			String shoufeistate, String zhuyuandengjihao, String chufanghao) {
		super();
		this.id = id;
		this.shoufeinumber = shoufeinumber;
		this.shoufeiname = shoufeiname;
		this.shuliang = shuliang;
		this.zmoney = zmoney;
		this.shoufeistate = shoufeistate;
		this.zhuyuandengjihao = zhuyuandengjihao;
		this.chufanghao = chufanghao;
	}
	
	
	
	public FeiYongHeSuanVo(Long id, String shoufeinumber, String shoufeiname, Date shoufeiDate, String shoufeiTime,
			BigDecimal shuliang, BigDecimal zmoney, String shoufeistate, String zhuyuandengjihao, String chufanghao) {
		super();
		this.id = id;
		this.shoufeinumber = shoufeinumber;
		this.shoufeiname = shoufeiname;
		this.shoufeiDate = shoufeiDate;
		this.shoufeiTime = shoufeiTime;
		this.shuliang = shuliang;
		this.zmoney = zmoney;
		this.shoufeistate = shoufeistate;
		this.zhuyuandengjihao = zhuyuandengjihao;
		this.chufanghao = chufanghao;
	}
	
	public FeiYongHeSuanVo(Long id, String shoufeileixing, String shoufeinumber, String shoufeiname, Date shoufeiDate,
			String shoufeiTime, BigDecimal shuliang, BigDecimal zmoney, String shoufeistate, String zhuyuandengjihao,
			String chufanghao) {
		super();
		this.id = id;
		this.shoufeileixing = shoufeileixing;
		this.shoufeinumber = shoufeinumber;
		this.shoufeiname = shoufeiname;
		this.shoufeiDate = shoufeiDate;
		this.shoufeiTime = shoufeiTime;
		this.shuliang = shuliang;
		this.zmoney = zmoney;
		this.shoufeistate = shoufeistate;
		this.zhuyuandengjihao = zhuyuandengjihao;
		this.chufanghao = chufanghao;
	}
	public FeiYongHeSuanVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "FeiYongHeSuanVo [id=" + id + ", shoufeileixing=" + shoufeileixing + ", shoufeinumber=" + shoufeinumber
				+ ", shoufeiname=" + shoufeiname + ", shoufeiDate=" + shoufeiDate + ", shoufeiTime=" + shoufeiTime
				+ ", zmoney=" + zmoney + ", shoufeistate=" + shoufeistate + ", zhuyuandengjihao=" + zhuyuandengjihao
				+ "]";
	}
	
}
