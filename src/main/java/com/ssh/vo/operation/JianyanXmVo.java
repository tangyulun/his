package com.ssh.vo.operation;

import java.math.BigDecimal;

import com.ssh.vo.outpatient.FinacialVo;

public class JianyanXmVo {
	private int id;
	private String xmbianhao;
	private String xmname;
	private String csfw;
	private String danwei;
	private String jiegao;
	private String yichang;
	private FinacialVo finacialVo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getXmbianhao() {
		return xmbianhao;
	}
	public void setXmbianhao(String xmbianhao) {
		this.xmbianhao = xmbianhao;
	}
	public String getXmname() {
		return xmname;
	}
	public void setXmname(String xmname) {
		this.xmname = xmname;
	}
	public String getCsfw() {
		return csfw;
	}
	public void setCsfw(String csfw) {
		this.csfw = csfw;
	}
	public String getDanwei() {
		return danwei;
	}
	public void setDanwei(String danwei) {
		this.danwei = danwei;
	}
	public String getJiegao() {
		return jiegao;
	}
	public void setJiegao(String jiegao) {
		this.jiegao = jiegao;
	}
	public String getYichang() {
		return yichang;
	}
	public void setYichang(String yichang) {
		this.yichang = yichang;
	}
	public JianyanXmVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public JianyanXmVo(int id, String xmbianhao, String xmname, String csfw, String danwei, String jiegao,
			String yichang) {
		super();
		this.id = id;
		this.xmbianhao = xmbianhao;
		this.xmname = xmname;
		this.csfw = csfw;
		this.danwei = danwei;
		this.jiegao = jiegao;
		this.yichang = yichang;
	}
	public FinacialVo getFinacialVo() {
		return finacialVo;
	}
	public void setFinacialVo(FinacialVo finacialVo) {
		this.finacialVo = finacialVo;
	}
	public void setJiegao(BigDecimal bigDecimal) {
		// TODO Auto-generated method stub
		
	}
	public void setCsfw(BigDecimal bigDecimal) {
		// TODO Auto-generated method stub
		
	}
	public void setYichang(BigDecimal bigDecimal) {
		// TODO Auto-generated method stub
		
	}
	
	
}
