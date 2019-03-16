package com.ssh.service.menu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssh.dao.jpa.menu.IFunctionTypeDAO;
import com.ssh.dao.jpa.menu.IFunctionsDAO;
import com.ssh.vo.menu.FunctionTypeVo;
import com.ssh.vo.menu.FunctionsVo;

@Service
public class MenuService {
	@Autowired
	private IFunctionTypeDAO IFTDAO;
	
	@Autowired
	private IFunctionsDAO IFDAO;
	
	public List<FunctionTypeVo> selectAll(){
		List<FunctionTypeVo> list = IFTDAO.selectAllFunction();
		for (FunctionTypeVo fType : list) {
			List<FunctionsVo> listFunctions = IFDAO.findByAllFunctions(IFTDAO.findOne(fType.getFunctionTypeId()));
			fType.setFunctions(listFunctions);
		}
		return list;
	}
}
