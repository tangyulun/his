package com.ssh.service.behospitalized;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.dao.jpa.behospitalized.IBedTypeDAO;
import com.ssh.dao.jpa.behospitalized.IBedTypeTypeDAO;
import com.ssh.pojos.BedType;
import com.ssh.pojos.BedTypeType;
import com.ssh.utils.Errors;
import com.ssh.vo.behospitalized.BedTypeTypeVo;

@Service
@Transactional
public class BedTypeService {
	@Autowired
	private IBedTypeDAO bedtypedao;
	
	@Autowired
	private IBedTypeTypeDAO TTDAO;
	/**
	 * 添加bedTypeName
	 * @param bedTypeName
	 * @return
	 */
	public Errors addBedType(String bedTypeName,Long bedTypeTypeId) {
		try {
			BedType b = new  BedType();
			BedTypeType bedtypetype = TTDAO.findOne(bedTypeTypeId);
			b.setBedTypeId(bedtypedao.selectIdMax());
			b.setBedTypeName(bedTypeName);
			b.setBedTypeType(bedtypetype);
			bedtypedao.save(b);
			return new Errors(true);
		} catch (Exception e) {
			e.printStackTrace();
			return new Errors(e.getMessage());
		}
	}
	/**
	 * 查询病房分类
	 * @return
	 */
	public List<BedTypeTypeVo> selectAllType(){
		 List<BedTypeTypeVo> list = TTDAO.selectBed();
		 for (BedTypeTypeVo b : list) {
			b.setbType(bedtypedao.findByChildren(TTDAO.findOne(b.getBedTypeTypeId())));
		 }
		 return list;
	}
	/**
	 * 验证BedTypeName是否存在
	 * @param BedTypeName
	 * @return
	 */
	public Errors regexBedTypeName(String BedTypeName){
		BedType bedType = bedtypedao.regexBedTypeName(BedTypeName);
		return bedType == null ? new Errors(true) : new Errors();
	}
	
}
