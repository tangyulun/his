package com.ssh.dao.jpa.behospitalized;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.Bed;
import com.ssh.pojos.BedType;
import com.ssh.vo.behospitalized.BedVo;
import com.ssh.vo.dean.BingChuangVO;
import com.ssh.vo.dept.DeptVO;

public interface IBedDAO extends CrudRepository<Bed, String> {
	@Query("select nvl(max(b.bedId) + 1 , 10001) from Bed b")
	public String getNumber();
	
	@Query("select new com.ssh.vo.behospitalized.BedVo(b.bedId,b.bedCreateDate,b.bedName,b.bedRemark,b.houseBingqu,b.houseState) from Bed b")
	public List<BedVo> selectAllBed(Pageable pages);
	
	@Query("select new com.ssh.vo.behospitalized.BedVo(b.bedId,b.bedCreateDate,b.bedName,b.bedRemark,b.houseBingqu,b.houseState) from Bed b where b.bedType=?1 order by b.bedId desc")
	public List<BedVo> selectTypeBed(BedType bt, Pageable pages);
	
	@Query("select count(b.bedId) from Bed b where b.bedType =?1")
	public long findBedTypeCount(BedType bt);
	
	@Query("select new com.ssh.vo.behospitalized.BedVo(b.bedId,b.bedCreateDate,b.bedName,b.bedRemark,b.houseBingqu,b.houseState) from Bed b where b.bedName like ?1 order by b.bedId desc")
	public List<BedVo> selectBedNameWhere(String bedName, Pageable pages);
	
	@Query("select count(b.bedId) from Bed b where b.bedName like ?1")
	public long findBedNameCount(String bedName);
	
	@Query("select new com.ssh.vo.dean.BingChuangVO(b.bedId,b.bedCreateDate,b.bedName,b.bedRemark,b.houseState) from Bed b order by b.bedId desc")
	public List<BingChuangVO> selectAllBeds(Pageable pages);

	@Query("select new com.ssh.vo.dean.BingChuangVO(b.bedId,b.bedCreateDate,b.bedName,b.bedRemark,b.houseState)"
			+ " from Bed b left join b.hospitalRegistrations h "
			+ "left join h.hospitaNotify n "
			+ "left join n.outpaitentRegist o "
			+ "left join o.medicalCard m "
			+ "where b.bedId like ?1 or b.bedName like ?2 or  m.medicalCardName like ?3 order by b.bedId desc")
	public List<BingChuangVO> selectAllBedsWhere(String key, String string, String string2, Pageable pageRequest);

	@Query("select count(b.id)"
			+ " from Bed b left join b.hospitalRegistrations h "
			+ "left join h.hospitaNotify n "
			+ "left join n.outpaitentRegist o "
			+ "left join o.medicalCard m "
			+ "where b.bedId like ?1 or b.bedName like ?2 or  m.medicalCardName like ?3 order by b.bedId desc")
	public long countWhere(String key, String string, String string2);
	
}
