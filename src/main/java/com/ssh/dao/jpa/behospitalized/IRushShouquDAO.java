package com.ssh.dao.jpa.behospitalized;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.RushShouqu;

public interface IRushShouquDAO extends CrudRepository<RushShouqu, String> {
	@Query("select max(r.rushShouquId) from RushShouqu r where r.rushShouquId like ?1")
	public String getNumber(String dateLike);
}
