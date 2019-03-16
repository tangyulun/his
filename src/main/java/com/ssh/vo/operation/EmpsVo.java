package com.ssh.vo.operation;


public class EmpsVo {
		private long empId;
	
		private String empName;

		public long getEmpId() {
			return empId;
		}

		public void setEmpId(long empId) {
			this.empId = empId;
		}

		public String getEmpName() {
			return empName;
		}

		public void setEmpName(String empName) {
			this.empName = empName;
		}

		public EmpsVo() {
			super();
			// TODO Auto-generated constructor stub
		}

		public EmpsVo(long empId, String empName) {
			super();
			this.empId = empId;
			this.empName = empName;
		}
		
}
