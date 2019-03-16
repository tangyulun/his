package com.ssh.service.outpatient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.dao.jpa.outpatient.IPrescriptionTypeDAO;
import com.ssh.utils.CommentOrder;

/**
 * 划价业务类
 * @author Administrator
 *
 */
@Service
@Transactional
public class PrescriptionService {

	@Autowired
	private IPrescriptionTypeDAO iprescriptionDAO;
	
	public String selectLikeNumber(){
		return iprescriptionDAO.selectLikeNumber(CommentOrder.dateLike());
	}
}
