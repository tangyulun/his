package com.ssh.vo.doctor;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Id;

public class KuCunVO {
	private long yaokuKucunId;

	private BigDecimal yaofangKaiyaoNum;

	private BigDecimal yaofangKaiyaoShengyuNum;

	private BigDecimal yaofangKucunBottom;

	private BigDecimal yaofangKucunNum;

	private BigDecimal yaofangKucunTop;

	private BigDecimal yaokuKucunBottom;

	private BigDecimal yaokuKucunNum;

	private BigDecimal yaokuKucunTop;

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

	public KuCunVO(long yaokuKucunId, BigDecimal yaofangKaiyaoNum, BigDecimal yaofangKaiyaoShengyuNum,
			BigDecimal yaofangKucunNum) {
		super();
		this.yaokuKucunId = yaokuKucunId;
		this.yaofangKaiyaoNum = yaofangKaiyaoNum;
		this.yaofangKaiyaoShengyuNum = yaofangKaiyaoShengyuNum;
		this.yaofangKucunNum = yaofangKucunNum;
	}

	public KuCunVO(long yaokuKucunId, BigDecimal yaofangKaiyaoShengyuNum) {
		super();
		this.yaokuKucunId = yaokuKucunId;
		this.yaofangKaiyaoShengyuNum = yaofangKaiyaoShengyuNum;
	}

	public KuCunVO(long yaokuKucunId, BigDecimal yaofangKaiyaoShengyuNum, BigDecimal yaofangKucunNum) {
		super();
		this.yaokuKucunId = yaokuKucunId;
		this.yaofangKaiyaoShengyuNum = yaofangKaiyaoShengyuNum;
		this.yaofangKucunNum = yaofangKucunNum;
	}
	
	
}
