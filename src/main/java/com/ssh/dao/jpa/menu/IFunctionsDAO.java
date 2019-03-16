package com.ssh.dao.jpa.menu;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.Function;
import com.ssh.pojos.FunctionType;
import com.ssh.vo.menu.FunctionsVo;
import com.ssh.vo.staff.GrantFunctionsVO;
import com.ssh.vo.staff.GrantFunctionsVO2;

public interface IFunctionsDAO extends CrudRepository<Function,Long>{
	/**
	 * 查询功能
	 * @param f
	 * @return
	 */
	@Query("select new com.ssh.vo.menu.FunctionsVo(f.functionsId , f.functionsHref, "
			+ "f.functionsIcon, f.functionsIsShowLeft,f.functionsName, f.functionsShowOrder)"
			+ "  from Function f where f.functionType=?1 and f.functionsIsShowLeft =1 order by f.functionsShowOrder asc")
	public List<FunctionsVo> findByAllFunctions(FunctionType f);

	/**
	 * 查询功能
	 * @param functionTypeId
	 * @return
	 */
	@Query("select new com.ssh.vo.staff.GrantFunctionsVO(f.functionsId , f.functionsName) from Function f where f.functionType.functionTypeId =?1  order by f.functionsShowOrder asc")
	public List<GrantFunctionsVO> findByChildren(long functionTypeId);

}
