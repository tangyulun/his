package com.ssh.vo.operation;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.ssh.pojos.Dclass;
import com.ssh.pojos.Emp;
import com.ssh.pojos.ShoushuMess;
import com.ssh.pojos.ShoushuType;

public class ShouShuVo {
	private String shoushuId;

	private String shoushuExplain;

	private String shoushuName;

	private String shoushuRemark;

	private String shoushuType;
	
	private DclasssVo dclass;

	private EmpsVo emp;
	
	private ShouShuTypeVo shoushuTypeBean;

	public String getShoushuId() {
		return shoushuId;
	}

	public DclasssVo getDclass() {
		return dclass;
	}

	public void setDclass(DclasssVo dclass) {
		this.dclass = dclass;
	}

	public EmpsVo getEmp() {
		return emp;
	}

	public void setEmp(EmpsVo emp) {
		this.emp = emp;
	}

	public ShouShuTypeVo getShoushuTypeBean() {
		return shoushuTypeBean;
	}

	public void setShoushuTypeBean(ShouShuTypeVo shoushuTypeBean) {
		this.shoushuTypeBean = shoushuTypeBean;
	}

	public void setShoushuId(String shoushuId) {
		this.shoushuId = shoushuId;
	}

	public String getShoushuExplain() {
		return shoushuExplain;
	}

	public void setShoushuExplain(String shoushuExplain) {
		this.shoushuExplain = shoushuExplain;
	}

	public String getShoushuName() {
		return shoushuName;
	}

	public void setShoushuName(String shoushuName) {
		this.shoushuName = shoushuName;
	}

	public String getShoushuRemark() {
		return shoushuRemark;
	}

	public void setShoushuRemark(String shoushuRemark) {
		this.shoushuRemark = shoushuRemark;
	}

	public String getShoushuType() {
		return shoushuType;
	}

	public void setShoushuType(String shoushuType) {
		this.shoushuType = shoushuType;
	}

	public ShouShuVo(String shoushuId, String shoushuExplain, String shoushuName, String shoushuRemark,
			String shoushuType) {
		super();
		this.shoushuId = shoushuId;
		this.shoushuExplain = shoushuExplain;
		this.shoushuName = shoushuName;
		this.shoushuRemark = shoushuRemark;
		this.shoushuType = shoushuType;
	}
	
	public ShouShuVo(String shoushuId, String shoushuName) {
		super();
		this.shoushuId = shoushuId;
		this.shoushuName = shoushuName;
	}

	public ShouShuVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
