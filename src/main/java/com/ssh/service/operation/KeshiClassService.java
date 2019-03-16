package com.ssh.service.operation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.dao.jpa.operation.KeshiClassDao;
import com.ssh.dao.jpa.operation.SugeryFlDao;
import com.ssh.pojos.JianyanType;
import com.ssh.pojos.ShoushuType;
import com.ssh.utils.Errors;

@Service
@Transactional
public class KeshiClassService {
		@Autowired
		private KeshiClassDao keshiclassdao;
		
		/**
		 * 验证科室是否存在的
		 * @param dclassName
		 * @return
		 */
		public Errors regexKeshiclassName(String jianyanTypeName){
			JianyanType dclass	=	keshiclassdao.regexKeshiclassName(jianyanTypeName);
				return dclass	==	null ? new Errors(true)	:	new Errors();
		}
		
}
