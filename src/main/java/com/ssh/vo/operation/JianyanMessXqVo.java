package com.ssh.vo.operation;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.ssh.pojos.Jianyan;
import com.ssh.pojos.JianyanMess;

public class JianyanMessXqVo {
		private long jianyanMessXqId;

		private String jianyanMessXq;

		private String jianyanMessXqBetween;

		private String jianyanMessXqResult;

		private JianyanVo jianyan;

		private JianyanMessVo jianyanMess;

		public long getJianyanMessXqId() {
			return jianyanMessXqId;
		}

		public void setJianyanMessXqId(long jianyanMessXqId) {
			this.jianyanMessXqId = jianyanMessXqId;
		}

		public String getJianyanMessXq() {
			return jianyanMessXq;
		}

		public void setJianyanMessXq(String jianyanMessXq) {
			this.jianyanMessXq = jianyanMessXq;
		}

		public String getJianyanMessXqBetween() {
			return jianyanMessXqBetween;
		}

		public void setJianyanMessXqBetween(String jianyanMessXqBetween) {
			this.jianyanMessXqBetween = jianyanMessXqBetween;
		}

		public String getJianyanMessXqResult() {
			return jianyanMessXqResult;
		}

		public void setJianyanMessXqResult(String jianyanMessXqResult) {
			this.jianyanMessXqResult = jianyanMessXqResult;
		}

		public JianyanVo getJianyan() {
			return jianyan;
		}

		public void setJianyan(JianyanVo jianyan) {
			this.jianyan = jianyan;
		}

		public JianyanMessVo getJianyanMess() {
			return jianyanMess;
		}

		public void setJianyanMess(JianyanMessVo jianyanMess) {
			this.jianyanMess = jianyanMess;
		}

		public JianyanMessXqVo() {
			super();
			// TODO Auto-generated constructor stub
		}

		public JianyanMessXqVo(long jianyanMessXqId, String jianyanMessXq, String jianyanMessXqBetween,
				String jianyanMessXqResult) {
			super();
			this.jianyanMessXqId = jianyanMessXqId;
			this.jianyanMessXq = jianyanMessXq;
			this.jianyanMessXqBetween = jianyanMessXqBetween;
			this.jianyanMessXqResult = jianyanMessXqResult;
		}
		
}
