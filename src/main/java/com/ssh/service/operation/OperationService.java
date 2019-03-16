package com.ssh.service.operation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.dao.jpa.operation.OperationDao;
import com.ssh.utils.CommentOrder;
import com.ssh.vo.operation.OperationVo;
import com.ssh.vo.operation.ShouShuVo;

@Service
@Transactional
public class OperationService {
	@Autowired
	private OperationDao operationdao;

}
