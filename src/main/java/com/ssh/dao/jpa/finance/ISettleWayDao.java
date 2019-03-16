package com.ssh.dao.jpa.finance;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.SettleWay;
import com.ssh.vo.finance.SettleWayVo;

public interface ISettleWayDao extends CrudRepository<SettleWay, String>{

	/**
	 * 查询所有支付方式
	 * @return
	 */
	@Query("select new com.ssh.vo.finance.SettleWayVo(s.settleWayId, s.settleWayName) from SettleWay s")
	public List<SettleWayVo> selectSW();
}
