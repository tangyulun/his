package com.ssh.service.behospitalized;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.dao.jpa.behospitalized.IHouseTypeDAO;
import com.ssh.pojos.HouseType;
import com.ssh.utils.Errors;

@Service
@Transactional
public class HouseTypeService {
	@Autowired
	private IHouseTypeDAO housetypedao;
	
	public Errors addHouseType(String bedTypeName) {
		try {
			HouseType h = new  HouseType();
			h.setHouseTypeId(housetypedao.selectIdMax());
			h.setHouseTypeName(bedTypeName);
			housetypedao.save(h);
			return new Errors(true);
		} catch (Exception e) {
			e.printStackTrace();
			return new Errors(e.getMessage());
		}
	}
}
