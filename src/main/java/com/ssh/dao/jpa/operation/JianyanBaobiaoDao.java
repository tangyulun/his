package com.ssh.dao.jpa.operation;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.JianyanMess;
import com.ssh.vo.operation.JianyanMessVo;
import com.ssh.vo.operation.JianyanMessXqVo;

public interface JianyanBaobiaoDao extends CrudRepository<JianyanMess, String>{
		@Query("select new com.ssh.vo.operation.JianyanMessVo(j.jianyanMessId,j.jianyanMessDate,j.jianyanMessDclass,j.jianyanMessState,j.jianyanMessYangbenType) "
				+ "from JianyanMess j")
		public List<JianyanMessVo> selectJianyanHuiZong(Pageable pages);
		
		//通过检验号查询
		@Query("select new com.ssh.vo.operation.JianyanMessVo(j.jianyanMessId,j.jianyanMessDate,j.jianyanMessDclass,j.jianyanMessState,j.jianyanMessYangbenType)"
				+ "from JianyanMess j where j.jianyanMessId like ?1 order by j.jianyanMessId desc")
		public List<JianyanMessVo> selectGaojiChaxunId(String jianyanMessId, Pageable page);

		@Query("select count(j.jianyanMessId) from JianyanMess j where j.jianyanMessId like ?1")
		public long selectGaojiChaxunCount(String jianyanMessId);
}
