package com.ssh.dao.jpa.operation;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.JianyanMess;
import com.ssh.vo.operation.JianyanMessVo;
import com.ssh.vo.operation.JianyanMessXqVo;
import com.ssh.vo.operation.JianyanXmVo;
import com.ssh.vo.operation.OutpaitentRegistVo;
import com.ssh.vo.outpatient.MedicalVo;

public interface JianyanMessDao extends CrudRepository<JianyanMess, String>{
		/**
		 * 查询数据
		 */
		@Query("select new com.ssh.vo.operation.JianyanMessVo(j.jianyanMessId,j.jianyanMessDate,j.jianyanMessDclass,j.jianyanMessState,j.jianyanMessYangbenType) "
				+ "from JianyanMess j")
		public List<JianyanMessVo> selectJianyanMess(Pageable pages);
	
		//通过检验号查询
		@Query("select new com.ssh.vo.operation.JianyanMessVo(j.jianyanMessId,j.jianyanMessDate,j.jianyanMessDclass,j.jianyanMessState,j.jianyanMessYangbenType)"
				+ "from JianyanMess j where j.jianyanMessId like ?1 order by j.jianyanMessId desc")
		public List<JianyanMessVo> selectJianyanMessId(String jianyanMessId, Pageable page);

		@Query("select count(j.jianyanMessId) from JianyanMess j where j.jianyanMessId like ?1")
		public long selectJianyanMessCount(String jianyanMessId);
		
		/**
		 * 挂单处理
		 * @return
		 */
		@Query("select max(j.jianyanMessId) from JianyanMess j where j.jianyanMessId like ?1")
		public String addjianyanGuadan(String dateLike);
		
		/**
		 * 查询检验详情表
		 * @param pages
		 * @return
		 */
		@Query("select new com.ssh.vo.operation.JianyanMessXqVo(j.jianyanMessXqId,j.jianyanMessXq,j.jianyanMessXqBetween,j.jianyanMessXqResult)"
				+ "from JianyanMessXq j")
		public List<JianyanMessXqVo> selectJianyanMessXq();
		
		
		/*//查询表格，进行编辑
		@Query("select new com.ssh.vo.operation.JianyanXmVo(j.id,j.xmbianhao,j.xmname,j.csfw,j.danwei,j.jiegao,j.yichang) from JianyanMess j")
		public List<JianyanXmVo> SelectJianyanBianji();*/
}