package com.ssh.service.behospitalized;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.dao.jpa.behospitalized.IBedDAO;
import com.ssh.dao.jpa.behospitalized.IBedTypeDAO;
import com.ssh.dao.jpa.behospitalized.IHouseTypeDAO;
import com.ssh.dao.jpa.login.LoginDao;
import com.ssh.pojos.Bed;
import com.ssh.pojos.BedType;
import com.ssh.pojos.Emp;
import com.ssh.pojos.Financial;
import com.ssh.pojos.FinancialType;
import com.ssh.pojos.HouseType;
import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;
import com.ssh.vo.behospitalized.BedTypeTypeVo;
import com.ssh.vo.behospitalized.BedVo;
import com.ssh.vo.behospitalized.HouseTypeVo;
import com.ssh.vo.dclass.DClassVO;
import com.ssh.vo.dept.DeptVO;
import com.ssh.vo.outpatient.FinancialHistoryVo;
import com.ssh.vo.outpatient.OutRegistVo;

@Service
@Transactional
public class BedService {
	@Autowired
	private IBedDAO beddao;
	
	@Autowired
	private IBedTypeDAO bedtypedao;
	
	@Autowired
	private IHouseTypeDAO housertypedao;
	
	@Autowired
	private LoginDao loginDao;

	public String getNumber() {
		return beddao.getNumber();
	}
	/**
	 * 添加病房
	 * @param bed
	 * @return
	 */
	public Errors addBed(Bed bed,Long bedTypeId,Long houseTypeId,Long empId) {
		try {
			BedType bedType = bedtypedao.findOne(bedTypeId);
			HouseType houseType = housertypedao.findOne(houseTypeId);
			Emp emp = loginDao.findOne(empId);
			bed.setBedType(bedType);
			bed.setHouseType(houseType);
			bed.setEmp(emp);
			beddao.save(bed);
			return new Errors(true);
		} catch (Exception e) {
			e.printStackTrace();
			return new Errors(e.getMessage());
		}
	}
	/**
	 * 查询所有病房
	 * @param page
	 * @param rows
	 * @return
	 */
	public List<BedVo> selectAllBed(int page , int rows){
		PageRequest pages = new PageRequest(page - 1, rows);
		List<BedVo> list = beddao.selectAllBed(pages);
		selectHouseType(list);
		return list;
	}

	private void selectHouseType(List<BedVo> list){
		for (BedVo b : list) {
			b.setHouseType(new HouseTypeVo(beddao.findOne(b.getBedId()).getHouseType().getHouseTypeId(),
					beddao.findOne(b.getBedId()).getHouseType().getHouseTypeName()));
		}
	}
	
	/**
	 * 查询总记录数
	 * @return
	 */
	public long count() {
		return beddao.count();
	}
	
	public List<BedVo> selectBedTypeId(int page,int rows,Long bedTypeId){
		BedType bt = bedtypedao.findOne(bedTypeId);
		List<BedVo> list =beddao.selectTypeBed(bt, new PageRequest(page - 1, rows));
		selectHouseType(list);
		return list;
	}
	
	public long queryBTCount(Long bedTypeId){
		BedType bt = bedtypedao.findOne(bedTypeId);
		return beddao.findBedTypeCount(bt);
	}
	
	public List<HouseTypeVo> getHouseType(){
		return housertypedao.selectHouse();
	}
	
	/**
	 * 根据bedName来查询
	 * @param page
	 * @param rows
	 * @param bedName
	 * @return
	 */
	public List<BedVo> selectBedNameWhere(int page, int rows , String bedName){
		PageRequest pages = new PageRequest(page - 1, rows);
		List<BedVo> list =beddao.selectBedNameWhere("%"+bedName+"%", pages);
		selectHouseType(list);
		return list;
	}
	/**
	 * bedName查询记录数
	 * @param bedName
	 * @return
	 */
	public long selectBedNameWhereCount(String bedName){
		return beddao.findBedNameCount("%"+bedName+"%");
	}
	
	
	public Errors updateBed(Bed bed,String bedId,Long bedTypeId,Long houseTypeId,Long empId){
		try {
			
			Bed b = beddao.findOne(bedId);
			BedType bedType = bedtypedao.findOne(bedTypeId);
			HouseType houseType = housertypedao.findOne(houseTypeId);
			Emp emp = loginDao.findOne(empId);
			b.setBedCreateDate(bed.getBedCreateDate());
			b.setBedName(bed.getBedName());
			b.setBedRemark(bed.getBedRemark());
			b.setBedTiaozhengs(bed.getBedTiaozhengs());
			b.setBedType(bedType);
			b.setEmp(emp);
			b.setHospitalRegistrations(bed.getHospitalRegistrations());
			b.setHouseBingqu(bed.getHouseBingqu());
			b.setHouseType(houseType);
			return new Errors(true);
		} catch (Exception e) {
			e.printStackTrace();
			return new Errors(e.getMessage());
		}
		
	}
	public Errors updataBedTypeName(Long bedTypeId,String bedTypeName){
		try {
			
			BedType bedtype = bedtypedao.findOne(bedTypeId);
			bedtype.setBedTypeName(bedTypeName);
			return new Errors(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Errors(e.getMessage());
		}
	}
	
}
