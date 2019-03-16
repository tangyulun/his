package com.ssh.dao.jpa.behospitalized;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.RushFee;
import com.ssh.vo.behospitalized.HospitalRegistrationVo;
import com.ssh.vo.behospitalized.RushFeeVo;

public interface IRushFeeDAO extends CrudRepository<RushFee, String> {
	@Query("select max(r.rushFeeId) from RushFee r where r.rushFeeId like ?1")
	public String getNumber(String dateLike);
	
	@Query("select new com.ssh.vo.behospitalized.RushFeeVo(r.rushFeeId,r.rushFeeDate, "
			+ "r.rushFeeHospitalRental,r.rushFeeLimitPaymentDate,r.rushFeeRemark, "
			+ "r.rushFeeSettle,r.rushFeeState,r.rushFeeWorthOfValue) from RushFee r order by r.rushFeeId desc ")
	public List<RushFeeVo> selectAllRushFee(Pageable pages);
}
