package com.ssh.vo.drugstorage;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;

import com.ssh.pojos.Drug;

public class YaokuKucunVo {
	private long yaokuKucunId;

	private BigDecimal yaofangKaiyaoNum;

	private BigDecimal yaofangKaiyaoShengyuNum;

	private BigDecimal yaofangKucunBottom;
	
	private BigDecimal yaofangKucunNum;

	private BigDecimal yaofangKucunTop;

	private BigDecimal yaokuKucunBottom;

	private BigDecimal yaokuKucunNum;

	private BigDecimal yaokuKucunTop;
	
	private List<Drug> drugs;

	public long getYaokuKucunId() {
		return yaokuKucunId;
	}

	public void setYaokuKucunId(long yaokuKucunId) {
		this.yaokuKucunId = yaokuKucunId;
	}

	public BigDecimal getYaofangKaiyaoNum() {
		return yaofangKaiyaoNum;
	}

	public void setYaofangKaiyaoNum(BigDecimal yaofangKaiyaoNum) {
		this.yaofangKaiyaoNum = yaofangKaiyaoNum;
	}

	public BigDecimal getYaofangKaiyaoShengyuNum() {
		return yaofangKaiyaoShengyuNum;
	}

	public void setYaofangKaiyaoShengyuNum(BigDecimal yaofangKaiyaoShengyuNum) {
		this.yaofangKaiyaoShengyuNum = yaofangKaiyaoShengyuNum;
	}

	public BigDecimal getYaofangKucunBottom() {
		return yaofangKucunBottom;
	}

	public void setYaofangKucunBottom(BigDecimal yaofangKucunBottom) {
		this.yaofangKucunBottom = yaofangKucunBottom;
	}

	public BigDecimal getYaofangKucunNum() {
		return yaofangKucunNum;
	}

	public void setYaofangKucunNum(BigDecimal yaofangKucunNum) {
		this.yaofangKucunNum = yaofangKucunNum;
	}

	public BigDecimal getYaofangKucunTop() {
		return yaofangKucunTop;
	}

	public void setYaofangKucunTop(BigDecimal yaofangKucunTop) {
		this.yaofangKucunTop = yaofangKucunTop;
	}

	public BigDecimal getYaokuKucunBottom() {
		return yaokuKucunBottom;
	}

	public void setYaokuKucunBottom(BigDecimal yaokuKucunBottom) {
		this.yaokuKucunBottom = yaokuKucunBottom;
	}

	public BigDecimal getYaokuKucunNum() {
		return yaokuKucunNum;
	}

	public void setYaokuKucunNum(BigDecimal yaokuKucunNum) {
		this.yaokuKucunNum = yaokuKucunNum;
	}

	public BigDecimal getYaokuKucunTop() {
		return yaokuKucunTop;
	}

	public void setYaokuKucunTop(BigDecimal yaokuKucunTop) {
		this.yaokuKucunTop = yaokuKucunTop;
	}

	public List<Drug> getDrugs() {
		return drugs;
	}

	public void setDrugs(List<Drug> drugs) {
		this.drugs = drugs;
	}

	public YaokuKucunVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public YaokuKucunVo(long yaokuKucunId, BigDecimal yaofangKaiyaoNum, BigDecimal yaofangKaiyaoShengyuNum,
			BigDecimal yaofangKucunBottom, BigDecimal yaofangKucunNum, BigDecimal yaofangKucunTop,
			BigDecimal yaokuKucunBottom, BigDecimal yaokuKucunNum, BigDecimal yaokuKucunTop) {
		super();
		this.yaokuKucunId = yaokuKucunId;
		this.yaofangKaiyaoNum = yaofangKaiyaoNum;
		this.yaofangKaiyaoShengyuNum = yaofangKaiyaoShengyuNum;
		this.yaofangKucunBottom = yaofangKucunBottom;
		this.yaofangKucunNum = yaofangKucunNum;
		this.yaofangKucunTop = yaofangKucunTop;
		this.yaokuKucunBottom = yaokuKucunBottom;
		this.yaokuKucunNum = yaokuKucunNum;
		this.yaokuKucunTop = yaokuKucunTop;
	}

	public YaokuKucunVo(long yaokuKucunId, BigDecimal yaofangKucunBottom, BigDecimal yaofangKucunNum,
			BigDecimal yaofangKucunTop, BigDecimal yaokuKucunBottom, BigDecimal yaokuKucunNum,
			BigDecimal yaokuKucunTop) {
		super();
		this.yaokuKucunId = yaokuKucunId;
		this.yaofangKucunBottom = yaofangKucunBottom;
		this.yaofangKucunNum = yaofangKucunNum;
		this.yaofangKucunTop = yaofangKucunTop;
		this.yaokuKucunBottom = yaokuKucunBottom;
		this.yaokuKucunNum = yaokuKucunNum;
		this.yaokuKucunTop = yaokuKucunTop;
	}

	
}
