package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the YAOKU_KUCUN database table.
 * 
 */
@Entity
@Table(name="YAOKU_KUCUN")
@NamedQuery(name="YaokuKucun.findAll", query="SELECT y FROM YaokuKucun y")
public class YaokuKucun implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="YAOKU_KUCUN_ID")
	private long yaokuKucunId;

	@Column(name="YAOFANG_KAIYAO_NUM")
	private BigDecimal yaofangKaiyaoNum;

	@Column(name="YAOFANG_KAIYAO_SHENGYU_NUM")
	private BigDecimal yaofangKaiyaoShengyuNum;

	@Column(name="YAOFANG_KUCUN_BOTTOM")
	private BigDecimal yaofangKucunBottom;

	@Column(name="YAOFANG_KUCUN_NUM")
	private BigDecimal yaofangKucunNum;

	@Column(name="YAOFANG_KUCUN_TOP")
	private BigDecimal yaofangKucunTop;

	@Column(name="YAOKU_KUCUN_BOTTOM")
	private BigDecimal yaokuKucunBottom;

	@Column(name="YAOKU_KUCUN_NUM")
	private BigDecimal yaokuKucunNum;

	@Column(name="YAOKU_KUCUN_TOP")
	private BigDecimal yaokuKucunTop;

	//bi-directional many-to-one association to Drug
	@OneToMany(mappedBy="yaokuKucun")
	private List<Drug> drugs;

	public YaokuKucun() {
	}

	public long getYaokuKucunId() {
		return this.yaokuKucunId;
	}

	public void setYaokuKucunId(long yaokuKucunId) {
		this.yaokuKucunId = yaokuKucunId;
	}

	public BigDecimal getYaofangKaiyaoNum() {
		return this.yaofangKaiyaoNum;
	}

	public void setYaofangKaiyaoNum(BigDecimal yaofangKaiyaoNum) {
		this.yaofangKaiyaoNum = yaofangKaiyaoNum;
	}

	public BigDecimal getYaofangKaiyaoShengyuNum() {
		return this.yaofangKaiyaoShengyuNum;
	}

	public void setYaofangKaiyaoShengyuNum(BigDecimal yaofangKaiyaoShengyuNum) {
		this.yaofangKaiyaoShengyuNum = yaofangKaiyaoShengyuNum;
	}

	public BigDecimal getYaofangKucunBottom() {
		return this.yaofangKucunBottom;
	}

	public void setYaofangKucunBottom(BigDecimal yaofangKucunBottom) {
		this.yaofangKucunBottom = yaofangKucunBottom;
	}

	public BigDecimal getYaofangKucunNum() {
		return this.yaofangKucunNum;
	}

	public void setYaofangKucunNum(BigDecimal yaofangKucunNum) {
		this.yaofangKucunNum = yaofangKucunNum;
	}

	public BigDecimal getYaofangKucunTop() {
		return this.yaofangKucunTop;
	}

	public void setYaofangKucunTop(BigDecimal yaofangKucunTop) {
		this.yaofangKucunTop = yaofangKucunTop;
	}

	public BigDecimal getYaokuKucunBottom() {
		return this.yaokuKucunBottom;
	}

	public void setYaokuKucunBottom(BigDecimal yaokuKucunBottom) {
		this.yaokuKucunBottom = yaokuKucunBottom;
	}

	public BigDecimal getYaokuKucunNum() {
		return this.yaokuKucunNum;
	}

	public void setYaokuKucunNum(BigDecimal yaokuKucunNum) {
		this.yaokuKucunNum = yaokuKucunNum;
	}

	public BigDecimal getYaokuKucunTop() {
		return this.yaokuKucunTop;
	}

	public void setYaokuKucunTop(BigDecimal yaokuKucunTop) {
		this.yaokuKucunTop = yaokuKucunTop;
	}

	public List<Drug> getDrugs() {
		return this.drugs;
	}

	public void setDrugs(List<Drug> drugs) {
		this.drugs = drugs;
	}

	public Drug addDrug(Drug drug) {
		getDrugs().add(drug);
		drug.setYaokuKucun(this);

		return drug;
	}

	public Drug removeDrug(Drug drug) {
		getDrugs().remove(drug);
		drug.setYaokuKucun(null);

		return drug;
	}

}