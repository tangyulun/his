package com.ssh.dao.jpa.behospitalized;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.ZhuyuanHesuan;

public interface IZhuyuanHesuanDAO extends CrudRepository<ZhuyuanHesuan, String> {
	@Query("select max(z.zhuyuanHesuanId) from ZhuyuanHesuan z where z.zhuyuanHesuanId like ?1")
	public String getNumber(String dateLike);
}
