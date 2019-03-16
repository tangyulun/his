package com.ssh.dao.jpa.operation;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.ShoushuMess;
import com.ssh.vo.operation.ShouShuMessVo;


public interface ShoushuBaobiaoDao extends CrudRepository<ShoushuMess, String>{
	//分页表格
	@Query("select new com.ssh.vo.operation.ShouShuMessVo(s.shoushuMess,s.shoushuMessDate,s.shoushuMessMoney,s.shoushuMessState,s.shoushuMessType) from ShoushuMess s")
	public List<ShouShuMessVo> selectShoushuHuiZong(Pageable pages);
	
	/**
	 * 根据Id查询
	 * @param shoushuMess
	 * @param page
	 * @return
	 */
	@Query("select new com.ssh.vo.operation.ShouShuMessVo(s.shoushuMess,s.shoushuMessDate,s.shoushuMessMoney,s.shoushuMessState,s.shoushuMessType) "
			+ "from ShoushuMess s where s.shoushuMess like ?1 order by s.shoushuMess desc")
	public List<ShouShuMessVo> selectShoushuIdchaxun(String shoushuMess, Pageable page);
	
	@Query("select count(s.shoushuMess) from ShoushuMess s where s.shoushuMess like ?1")
	public long SelectShoushuIdcount(String shoushuMess);
}
