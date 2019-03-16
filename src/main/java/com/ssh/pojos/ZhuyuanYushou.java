package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the ZHUYUAN_YUSHOU database table.
 * 
 */
@Entity
@Table(name="ZHUYUAN_YUSHOU")
@NamedQuery(name="ZhuyuanYushou.findAll", query="SELECT z FROM ZhuyuanYushou z")
public class ZhuyuanYushou implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ZHUYUAN_YUSHOU_ID")
	private long zhuyuanYushouId;

	@Temporal(TemporalType.DATE)
	@Column(name="ZHUYUAN_YUSHOU_DATE")
	private Date zhuyuanYushouDate;

	@Column(name="ZHUYUAN_YUSHOU_MONEY")
	private BigDecimal zhuyuanYushouMoney;

	@Column(name="ZHUYUAN_YUSHOU_STATE")
	private String zhuyuanYushouState;

	//bi-directional many-to-one association to RushShouqu
	@ManyToOne
	@JoinColumn(name="RUSH_SHOUQU_ID")
	private RushShouqu rushShouqu;

	public ZhuyuanYushou() {
	}

	public long getZhuyuanYushouId() {
		return this.zhuyuanYushouId;
	}

	public void setZhuyuanYushouId(long zhuyuanYushouId) {
		this.zhuyuanYushouId = zhuyuanYushouId;
	}

	public Date getZhuyuanYushouDate() {
		return this.zhuyuanYushouDate;
	}

	public void setZhuyuanYushouDate(Date zhuyuanYushouDate) {
		this.zhuyuanYushouDate = zhuyuanYushouDate;
	}

	public BigDecimal getZhuyuanYushouMoney() {
		return this.zhuyuanYushouMoney;
	}

	public void setZhuyuanYushouMoney(BigDecimal zhuyuanYushouMoney) {
		this.zhuyuanYushouMoney = zhuyuanYushouMoney;
	}

	public String getZhuyuanYushouState() {
		return this.zhuyuanYushouState;
	}

	public void setZhuyuanYushouState(String zhuyuanYushouState) {
		this.zhuyuanYushouState = zhuyuanYushouState;
	}

	public RushShouqu getRushShouqu() {
		return this.rushShouqu;
	}

	public void setRushShouqu(RushShouqu rushShouqu) {
		this.rushShouqu = rushShouqu;
	}

}