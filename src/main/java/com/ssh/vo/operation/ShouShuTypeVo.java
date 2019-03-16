package com.ssh.vo.operation;

import com.alibaba.fastjson.annotation.JSONField;

public class ShouShuTypeVo {
		@JSONField(name="id")
		private long shoushuTypeId;
		
		@JSONField(name="text")
		private String shoushuTypeName;

		public long getShoushuTypeId() {
			return shoushuTypeId;
		}

		public void setShoushuTypeId(long shoushuTypeId) {
			this.shoushuTypeId = shoushuTypeId;
		}

		public String getShoushuTypeName() {
			return shoushuTypeName;
		}

		public void setShoushuTypeName(String shoushuTypeName) {
			this.shoushuTypeName = shoushuTypeName;
		}

		public ShouShuTypeVo() {
			super();
			// TODO Auto-generated constructor stub
		}

		public ShouShuTypeVo(long shoushuTypeId, String shoushuTypeName) {
			super();
			this.shoushuTypeId = shoushuTypeId;
			this.shoushuTypeName = shoushuTypeName;
		}
		
}
