package com.ssh.dao.jpa.finance;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.Fukuan;
import com.ssh.vo.finance.FuKuanVo;

public interface IFuKuanDAO extends CrudRepository<Fukuan , Long> {
	@Query("select new com.ssh.vo.finance.FuKuanVo(f.fukuanId, f.fukuanName) from Fukuan f")
	public List<FuKuanVo> selectAllShoufei();
}
