package com.ssh.dao.jpa.behospitalized;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.ZhuyuanJiezhang;

public interface IZhuyuanJiezhangDAO extends CrudRepository<ZhuyuanJiezhang, String> {
	@Query("select max(z.zhuyuanJiezhangId) from ZhuyuanJiezhang z where z.zhuyuanJiezhangId like ?1")
	public String getNumber(String dateLike);
}
