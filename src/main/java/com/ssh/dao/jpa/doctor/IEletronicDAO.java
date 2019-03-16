package com.ssh.dao.jpa.doctor;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.Prescription;

public interface IEletronicDAO extends CrudRepository<Prescription, String>{

	@Query("select max(r.prescriptionId) from Prescription r where  r.prescriptionId like ?1")
	public String selectLikeNUmber(String dateLike);
}

