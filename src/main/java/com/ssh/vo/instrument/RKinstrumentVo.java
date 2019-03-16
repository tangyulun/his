package com.ssh.vo.instrument;

import java.util.Date;

public class RKinstrumentVo {
private String rkid;
private String rkname;
private String rkshuliang;
private Date rkscdate;
private Date rkcgdate;
private String rkbz;
private String danwei;
public String getRkid() {
	return rkid;
}
public void setRkid(String rkid) {
	this.rkid = rkid;
}
public String getRkname() {
	return rkname;
}
public void setRkname(String rkname) {
	this.rkname = rkname;
}
public String getRkshuliang() {
	return rkshuliang;
}
public void setRkshuliang(String rkshuliang) {
	this.rkshuliang = rkshuliang;
}
public Date getRkscdate() {
	return rkscdate;
}
public void setRkscdate(Date rkscdate) {
	this.rkscdate = rkscdate;
}
public Date getRkcgdate() {
	return rkcgdate;
}
public void setRkcgdate(Date rkcgdate) {
	this.rkcgdate = rkcgdate;
}
public String getRkbz() {
	return rkbz;
}
public void setRkbz(String rkbz) {
	this.rkbz = rkbz;
}
public String getDanwei() {
	return danwei;
}
public void setDanwei(String danwei) {
	this.danwei = danwei;
}
public RKinstrumentVo(String rkid, String rkname, String rkshuliang, Date rkscdate, Date rkcgdate, String rkbz,
		String danwei) {
	super();
	this.rkid = rkid;
	this.rkname = rkname;
	this.rkshuliang = rkshuliang;
	this.rkscdate = rkscdate;
	this.rkcgdate = rkcgdate;
	this.rkbz = rkbz;
	this.danwei = danwei;
}
public RKinstrumentVo() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "RKinstrumentVo [rkid=" + rkid + ", rkname=" + rkname + ", rkshuliang=" + rkshuliang + ", rkscdate="
			+ rkscdate + ", rkcgdate=" + rkcgdate + ", rkbz=" + rkbz + ", danwei=" + danwei + "]";
}

}
