package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the BCLASSES database table.
 * 
 */
@Entity
@Table(name="BCLASSES")
@NamedQuery(name="Bclass.findAll", query="SELECT b FROM Bclass b")
public class Bclass implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="BCLASSES_ID")
	private long bclassesId;

	@Column(name="BCLASSES_BET_TIME")
	private String bclassesBetTime;

	@Column(name="BCLASSES_COLOR")
	private String bclassesColor;

	@Column(name="BCLASSES_NAME")
	private String bclassesName;

	@Column(name="BCLASSES_TYPE")
	private String bclassesType;

	//bi-directional many-to-one association to BeOnDutyPlanXq
	@OneToMany(mappedBy="bclass")
	private List<BeOnDutyPlanXq> beOnDutyPlanXqs;

	public Bclass() {
	}

	public long getBclassesId() {
		return this.bclassesId;
	}

	public void setBclassesId(long bclassesId) {
		this.bclassesId = bclassesId;
	}

	public String getBclassesBetTime() {
		return this.bclassesBetTime;
	}

	public void setBclassesBetTime(String bclassesBetTime) {
		this.bclassesBetTime = bclassesBetTime;
	}

	public String getBclassesColor() {
		return this.bclassesColor;
	}

	public void setBclassesColor(String bclassesColor) {
		this.bclassesColor = bclassesColor;
	}

	public String getBclassesName() {
		return this.bclassesName;
	}

	public void setBclassesName(String bclassesName) {
		this.bclassesName = bclassesName;
	}

	public String getBclassesType() {
		return this.bclassesType;
	}

	public void setBclassesType(String bclassesType) {
		this.bclassesType = bclassesType;
	}

	public List<BeOnDutyPlanXq> getBeOnDutyPlanXqs() {
		return this.beOnDutyPlanXqs;
	}

	public void setBeOnDutyPlanXqs(List<BeOnDutyPlanXq> beOnDutyPlanXqs) {
		this.beOnDutyPlanXqs = beOnDutyPlanXqs;
	}

	public BeOnDutyPlanXq addBeOnDutyPlanXq(BeOnDutyPlanXq beOnDutyPlanXq) {
		getBeOnDutyPlanXqs().add(beOnDutyPlanXq);
		beOnDutyPlanXq.setBclass(this);

		return beOnDutyPlanXq;
	}

	public BeOnDutyPlanXq removeBeOnDutyPlanXq(BeOnDutyPlanXq beOnDutyPlanXq) {
		getBeOnDutyPlanXqs().remove(beOnDutyPlanXq);
		beOnDutyPlanXq.setBclass(null);

		return beOnDutyPlanXq;
	}

}