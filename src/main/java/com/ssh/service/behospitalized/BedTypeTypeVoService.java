package com.ssh.service.behospitalized;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.dao.jpa.behospitalized.IBedTypeTypeDAO;
import com.ssh.pojos.BedTypeType;
import com.ssh.utils.Errors;
import com.ssh.vo.behospitalized.BedTypeTypeVo;

@Service
@Transactional
public class BedTypeTypeVoService {
	@Autowired
	private IBedTypeTypeDAO ibedtypetypedao;
	
	public List<BedTypeTypeVo> getIBedType(){
		return ibedtypetypedao.selectBed();
	}
	
	public Errors addBedTypeType(String bedTypeName) {
		try {
			BedTypeType b = new  BedTypeType();
			b.setBedTypeTypeId(ibedtypetypedao.selectIdMax());
			b.setBedTypeTypeName(bedTypeName);
			ibedtypetypedao.save(b);
			return new Errors(true);
		} catch (Exception e) {
			e.printStackTrace();
			return new Errors(e.getMessage());
		}
	}
}
