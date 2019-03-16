package com.ssh.dao.jpa.operation;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.Jianyan;
import com.ssh.vo.operation.OperationVo;

public interface OperationDao extends CrudRepository<Jianyan, Long>{

}
