package com.ssh.service.operation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.dao.jpa.operation.ShouShuDao;
import com.ssh.dao.jpa.operation.ShouShuTypeDao;
import com.ssh.pojos.ShoushuType;
import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;
import com.ssh.vo.operation.JianyanTypeVo;
import com.ssh.vo.operation.ParentTypeVo;
import com.ssh.vo.operation.ShouShuTypeVo;
import com.ssh.vo.operation.ShouShuVo;
import com.ssh.vo.operation.SurgeryTypeVo;

@Service
@Transactional
public class ShoushuService {
		@Autowired
		private ShouShuDao ssdao;
		
		public List<ShouShuVo> selectAll(){
			return ssdao.selectAll();
		}
		
		/**
		 * 生成手术号
		 * @return
		 */
		public String RNumber(){
			return ssdao.selectLikeRNumber(CommentOrder.dateLike());
		}
		
}