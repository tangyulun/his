package com.ssh.dao.jpa.behospitalized;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.HospitaNotify;
import com.ssh.vo.behospitalized.HospitaNotifyVo;

public interface IHospitaNotifyDAO extends CrudRepository<HospitaNotify, String> {
	@Query("select max(h.hospitalNotifyNumber) from HospitaNotify h where h.hospitalNotifyNumber like ?1")
	public String getNumber(String dateLike);
	
	@Query("select new com.ssh.vo.behospitalized.HospitaNotifyVo(h.hospitalNotifyNumber, "
			+ "h.hospitalNotifyAlertTheJine,h.hospitalNotifyCashFeiyong,h.hospitalNotifyCashYanjin, "
			+ "h.hospitalNotifyCost,h.hospitalNotifyDate,h.hospitalNotifyExplain,h.hospitalNotifyState) "
			+ "from HospitaNotify h order by h.hospitalNotifyNumber desc ")
	public List<HospitaNotifyVo> selectAllHospitaNotify(Pageable pages);

	@Query("select new com.ssh.vo.behospitalized.HospitaNotifyVo(h.hospitalNotifyNumber, "
			+ "h.hospitalNotifyAlertTheJine,h.hospitalNotifyCashFeiyong,h.hospitalNotifyCashYanjin, "
			+ "h.hospitalNotifyCost,h.hospitalNotifyDate,h.hospitalNotifyExplain,h.hospitalNotifyState) "
			+ "from HospitaNotify h where h.hospitalNotifyNumber like ?1 order by h.hospitalNotifyNumber desc ")
	public List<HospitaNotifyVo> selectHospitaNotify(Pageable pages, String hospitalNotifyNumber);
	
	@Query("select count(h.hospitalNotifyNumber) from HospitaNotify h where h.hospitalNotifyNumber like ?1")
	public long findHospitalNotifyNumber(String hospitalNotifyNumber);
}
