package com.ssh.dao.jpa.operation;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.JianyanType;
import com.ssh.vo.operation.JianyanTypeVo;

public interface JianyanTypesDao extends CrudRepository<JianyanType, String>{
	/**
	 * 左边的文件夹
	 * @return
	 */
	@Query("select new com.ssh.vo.operation.JianyanTypeVo(j.jianyanTypeId , j.jianyanTypeName) from JianyanType j")
	public  List<JianyanTypeVo> selectJianyan();
	
}
