package com.ssh.vo.operation;

import java.math.BigDecimal;

public class ShouBaobiaoVo {
		private int id;
		private String souId;
		private String souName;
		private String soutype;
		private BigDecimal soushuliang;
		private BigDecimal soudanjia;
		private BigDecimal soujine;
		private OutpaitentRegistVo outpaitentRegist;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getSouId() {
			return souId;
		}
		public void setSouId(String souId) {
			this.souId = souId;
		}
		public String getSouName() {
			return souName;
		}
		public void setSouName(String souName) {
			this.souName = souName;
		}
		public String getSoutype() {
			return soutype;
		}
		public void setSoutype(String soutype) {
			this.soutype = soutype;
		}
		public BigDecimal getSoushuliang() {
			return soushuliang;
		}
		public void setSoushuliang(BigDecimal soushuliang) {
			this.soushuliang = soushuliang;
		}
		public BigDecimal getSoudanjia() {
			return soudanjia;
		}
		public void setSoudanjia(BigDecimal soudanjia) {
			this.soudanjia = soudanjia;
		}
		public BigDecimal getSoujine() {
			return soujine;
		}
		public void setSoujine(BigDecimal soujine) {
			this.soujine = soujine;
		}
		public OutpaitentRegistVo getOutpaitentRegist() {
			return outpaitentRegist;
		}
		public void setOutpaitentRegist(OutpaitentRegistVo outpaitentRegist) {
			this.outpaitentRegist = outpaitentRegist;
		}
		public ShouBaobiaoVo() {
			super();
			// TODO Auto-generated constructor stub
		}
		public ShouBaobiaoVo(int id, String souId, String souName, String soutype, BigDecimal soushuliang,
				BigDecimal soudanjia, BigDecimal soujine) {
			super();
			this.id = id;
			this.souId = souId;
			this.souName = souName;
			this.soutype = soutype;
			this.soushuliang = soushuliang;
			this.soudanjia = soudanjia;
			this.soujine = soujine;
		}
		
		
		
}
