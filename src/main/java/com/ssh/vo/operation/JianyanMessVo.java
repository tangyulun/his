package com.ssh.vo.operation;

import java.util.Date;
import java.util.List;

import com.ssh.pojos.Emp;
import com.ssh.pojos.JianyanMess;
import com.ssh.pojos.JianyanMessXq;
import com.ssh.pojos.OutpaitentRegist;
import com.ssh.vo.login.EmpVo;

public class JianyanMessVo {
		private String jianyanMessId;
		
		private Date jianyanMessDate;
		
		private String jianyanMessDclass;
		
		private String jianyanMessState;

		private String jianyanMessYangbenType;
		
		private EmpsVo emp;
		
		private OutpaitentRegistVo outpaitentRegist;

		public String getJianyanMessId() {
			return jianyanMessId;
		}

		public void setJianyanMessId(String jianyanMessId) {
			this.jianyanMessId = jianyanMessId;
		}

		public Date getJianyanMessDate() {
			return jianyanMessDate;
		}

		public void setJianyanMessDate(Date jianyanMessDate) {
			this.jianyanMessDate = jianyanMessDate;
		}

		public String getJianyanMessDclass() {
			return jianyanMessDclass;
		}

		public void setJianyanMessDclass(String jianyanMessDclass) {
			this.jianyanMessDclass = jianyanMessDclass;
		}

		public String getJianyanMessState() {
			return jianyanMessState;
		}

		public void setJianyanMessState(String jianyanMessState) {
			this.jianyanMessState = jianyanMessState;
		}

		public String getJianyanMessYangbenType() {
			return jianyanMessYangbenType;
		}

		public void setJianyanMessYangbenType(String jianyanMessYangbenType) {
			this.jianyanMessYangbenType = jianyanMessYangbenType;
		}

		public EmpsVo getEmp() {
			return emp;
		}

		public void setEmp(EmpsVo emp) {
			this.emp = emp;
		}

		public OutpaitentRegistVo getOutpaitentRegist() {
			return outpaitentRegist;
		}

		public void setOutpaitentRegist(OutpaitentRegistVo outpaitentRegist) {
			this.outpaitentRegist = outpaitentRegist;
		}

		public JianyanMessVo() {
			super();
			// TODO Auto-generated constructor stub
		}

		public JianyanMessVo(String jianyanMessId, Date jianyanMessDate, String jianyanMessDclass,
				String jianyanMessState, String jianyanMessYangbenType) {
			super();
			this.jianyanMessId = jianyanMessId;
			this.jianyanMessDate = jianyanMessDate;
			this.jianyanMessDclass = jianyanMessDclass;
			this.jianyanMessState = jianyanMessState;
			this.jianyanMessYangbenType = jianyanMessYangbenType;
		}

		

		
		
		
}
