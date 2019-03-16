package com.ssh.dao.jpa.operation;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.FinancialHistory;
import com.ssh.vo.operation.JianyanMessXqVo;
import com.ssh.vo.operation.SelectFinanVo;

public interface SelectFinancialDao extends CrudRepository<FinancialHistory, String>{
		/**
		 * 查询收费记录表格
		 * @param pages
		 * @return
		 */
		@Query("select new com.ssh.vo.operation.SelectFinanVo(f.financialHistoryId)"
				+ " from FinancialHistory f")
		public List<SelectFinanVo> selectfinanialbiao(Pageable pages);
}
