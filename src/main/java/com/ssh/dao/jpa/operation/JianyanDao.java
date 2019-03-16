package com.ssh.dao.jpa.operation;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.Jianyan;
import com.ssh.pojos.JianyanType;
import com.ssh.vo.operation.JianyanRightVo;
import com.ssh.vo.operation.JianyanVo;

public interface JianyanDao extends CrudRepository<Jianyan, String>{
		/**
		 * 点击ul,刷新数据表格
		 * @param jt
		 * @param page
		 * @return
		 */
		@Query("select new com.ssh.vo.operation.JianyanVo(j.jianyanId,j.jianyanBetween,j.jianyanCreateDate,j.jianyanName,j.jianyanRemark) from Jianyan j where j.jianyanType =?1 order by j.id desc")
		public List<JianyanVo> findJianyanType(JianyanType jt, Pageable page);
		
		@Query("select count(j.id) from Jianyan j where j.jianyanType=?1")
		public long findJianyanTypeCount(JianyanType jt);
		
		/**
		 * 查询检验名
		 * @param JianyanName
		 * @param pages
		 * @return
		 */
		@Query("select new com.ssh.vo.operation.JianyanVo(j.jianyanId,j.jianyanBetween,j.jianyanCreateDate,j.jianyanName,j.jianyanRemark) from Jianyan j where j.jianyanName like ?1 order by j.jianyanId desc")
		public List<JianyanVo> selectJianyanNameWhere(String jianyanName, Pageable pages);

		@Query("select count(j.jianyanId) from Jianyan j where j.jianyanName like ?1")
		public long selectJianyanNameCount(String jianyanName);
		
		
		/**
		 * 右边的表格
		 * @param pages
		 * @return
		 */
		@Query("select new com.ssh.vo.operation.JianyanVo(j.jianyanId ,j.jianyanBetween ,j.jianyanCreateDate,j.jianyanName,j.jianyanRemark) from Jianyan j")
		public List<JianyanVo> selectJianyanRight(Pageable pages);
		
		/**
		 * 查询所有数据
		 */
		/*@Query("select new com.ssh.vo.operation.JianyanVo(j.jianyanId,j.jianyanBetween,j.jianyanCreateDate,j.jianyanName,j.jianyanRemark) "
				+ "from Jianyan j")
		public List<JianyanVo> selectJianyanMess(Pageable pages);*/
}
