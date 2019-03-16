package com.ssh.vo.operation;

import com.alibaba.fastjson.annotation.JSONField;

public class JianyanTypeVo {
		@JSONField(name="id")
		private long jianyanId;
		
		@JSONField(name="text")
		private String jianyanName;

		public long getJianyanId() {
			return jianyanId;
		}

		public void setJianyanId(long jianyanId) {
			this.jianyanId = jianyanId;
		}

		public String getJianyanName() {
			return jianyanName;
		}

		public void setJianyanName(String jianyanName) {
			this.jianyanName = jianyanName;
		}

		public JianyanTypeVo() {
			super();
			// TODO Auto-generated constructor stub
		}

		public JianyanTypeVo(long jianyanId, String jianyanName) {
			super();
			this.jianyanId = jianyanId;
			this.jianyanName = jianyanName;
		}

	
}
