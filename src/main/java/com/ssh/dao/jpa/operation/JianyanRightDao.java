package com.ssh.dao.jpa.operation;


import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.Jianyan;
import com.ssh.vo.operation.JianyanRightVo;

public interface JianyanRightDao extends CrudRepository<Jianyan, String>{
		/**
		 * 右边的表格
		 * @param pages
		 * @return
		 */
		@Query("select new com.ssh.vo.operation.JianyanRightVo(j.jianyanId , j.jianyanName , j.jianyanRemark) from Jianyan j")
		public List<JianyanRightVo> selectJianyanRight(Pageable pages);
		
		/**
		 * 添加检验项目
		 * @return
		 */
		@Query("select nvl(max(j.jianyanId) + 1 , 1) from Jianyan j")
		public long fingByMaxId();
		
}
