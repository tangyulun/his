package com.ssh.dao.jpa.behospitalized;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.HospitalRegistration;
import com.ssh.vo.behospitalized.HospitalRegistrationVo;

public interface IHospitalRegistrationDAO extends CrudRepository<HospitalRegistration, String>{
	@Query("select max(h.hospitalRegistrationId) from HospitalRegistration h where h.hospitalRegistrationId like ?1")
	public String getNumber(String dateLike);
	
	@Query("select new com.ssh.vo.behospitalized.HospitalRegistrationVo(h.hospitalRegistrationId, "
			+ "h.hospitalRegistrationDate,h.hospitalRegistrationState) from HospitalRegistration h order by h.hospitalRegistrationId desc ")
	public List<HospitalRegistrationVo> selectAllHospitalRegistration(Pageable pages);
	
}
