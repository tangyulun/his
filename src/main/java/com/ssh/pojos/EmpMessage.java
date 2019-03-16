package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the EMP_MESSAGE database table.
 * 
 */
@Entity
@Table(name="EMP_MESSAGE")
@NamedQuery(name="EmpMessage.findAll", query="SELECT e FROM EmpMessage e")
public class EmpMessage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="EMP_MESSAGE_ID")
	private long empMessageId;

	@Column(name="EMP_MESSAGE_ADDRESS")
	private String empMessageAddress;

	@Temporal(TemporalType.DATE)
	@Column(name="EMP_MESSAGE_BIRTHDAY")
	private Date empMessageBirthday;

	@Column(name="EMP_MESSAGE_DISPOSE_DATE")
	private String empMessageDisposeDate;

	@Column(name="EMP_MESSAGE_DISPOSE_NAME")
	private String empMessageDisposeName;

	@Column(name="EMP_MESSAGE_FACE")
	private String empMessageFace;

	@Column(name="EMP_MESSAGE_ID_CARD")
	private String empMessageIdCard;

	@Column(name="EMP_MESSAGE_IS_MARRY")
	private String empMessageIsMarry;

	@Column(name="EMP_MESSAGE_MAJOR")
	private String empMessageMajor;

	@Column(name="EMP_MESSAGE_NATION")
	private String empMessageNation;

	@Column(name="EMP_MESSAGE_PHONE")
	private String empMessagePhone;

	@Column(name="EMP_MESSAGE_REMARK")
	private String empMessageRemark;

	@Column(name="EMP_MESSAGE_XUELI")
	private String empMessageXueli;

	//bi-directional many-to-one association to Emp
	@ManyToOne
	@JoinColumn(name="EMP_ID")
	private Emp emp;

	public EmpMessage() {
	}

	public long getEmpMessageId() {
		return this.empMessageId;
	}

	public void setEmpMessageId(long empMessageId) {
		this.empMessageId = empMessageId;
	}

	public String getEmpMessageAddress() {
		return this.empMessageAddress;
	}

	public void setEmpMessageAddress(String empMessageAddress) {
		this.empMessageAddress = empMessageAddress;
	}

	public Date getEmpMessageBirthday() {
		return this.empMessageBirthday;
	}

	public void setEmpMessageBirthday(Date empMessageBirthday) {
		this.empMessageBirthday = empMessageBirthday;
	}

	public String getEmpMessageDisposeDate() {
		return this.empMessageDisposeDate;
	}

	public void setEmpMessageDisposeDate(String empMessageDisposeDate) {
		this.empMessageDisposeDate = empMessageDisposeDate;
	}

	public String getEmpMessageDisposeName() {
		return this.empMessageDisposeName;
	}

	public void setEmpMessageDisposeName(String empMessageDisposeName) {
		this.empMessageDisposeName = empMessageDisposeName;
	}

	public String getEmpMessageFace() {
		return this.empMessageFace;
	}

	public void setEmpMessageFace(String empMessageFace) {
		this.empMessageFace = empMessageFace;
	}

	public String getEmpMessageIdCard() {
		return this.empMessageIdCard;
	}

	public void setEmpMessageIdCard(String empMessageIdCard) {
		this.empMessageIdCard = empMessageIdCard;
	}

	public String getEmpMessageIsMarry() {
		return this.empMessageIsMarry;
	}

	public void setEmpMessageIsMarry(String empMessageIsMarry) {
		this.empMessageIsMarry = empMessageIsMarry;
	}

	public String getEmpMessageMajor() {
		return this.empMessageMajor;
	}

	public void setEmpMessageMajor(String empMessageMajor) {
		this.empMessageMajor = empMessageMajor;
	}

	public String getEmpMessageNation() {
		return this.empMessageNation;
	}

	public void setEmpMessageNation(String empMessageNation) {
		this.empMessageNation = empMessageNation;
	}

	public String getEmpMessagePhone() {
		return this.empMessagePhone;
	}

	public void setEmpMessagePhone(String empMessagePhone) {
		this.empMessagePhone = empMessagePhone;
	}

	public String getEmpMessageRemark() {
		return this.empMessageRemark;
	}

	public void setEmpMessageRemark(String empMessageRemark) {
		this.empMessageRemark = empMessageRemark;
	}

	public String getEmpMessageXueli() {
		return this.empMessageXueli;
	}

	public void setEmpMessageXueli(String empMessageXueli) {
		this.empMessageXueli = empMessageXueli;
	}

	public Emp getEmp() {
		return this.emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

}