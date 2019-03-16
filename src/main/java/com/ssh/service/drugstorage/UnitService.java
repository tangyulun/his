package com.ssh.service.drugstorage;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.dao.jpa.drugstorage.IUnitDao;
import com.ssh.pojos.Unit;
import com.ssh.utils.Errors;
import com.ssh.vo.drugstorage.ParentTypeUnitVo;
import com.ssh.vo.drugstorage.ParentTypeVo;
import com.ssh.vo.drugstorage.UnitVo;

@Service
@Transactional
public class UnitService {
	
	@Autowired
	private IUnitDao IUDao;
	
	
	/*public Errors insertUnit(String unitsName){
		try {
			Unit unit=new Unit();
			unit.setUnitsId(IUDao.maxId());
			unit.setUnitsName(unitsName);
			IUDao.save(unit);
			return new Errors(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Errors(e.getMessage());
		}
	}*/
	/**
	 * 新增药品单位
	 * @param unitsName
	 * @return
	 */
	public Errors insertUnit(String unitsName){
		try {
			Unit unit =  new Unit();
			unit.setUnitsId(IUDao.maxId());
			unit.setUnitsName(unitsName);
			IUDao.save(unit);
			return new Errors(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Errors(e.getMessage());
		}
	}
	
	/**
	 * 查询是否有相同的药品单位名称
	 * @param unitsName
	 * @return
	 */
	public Errors selectName(String unitsName){
		Unit unit=IUDao.selectName(unitsName);
		return unit == null ? new Errors(true) : new Errors();
	}
	
	/**
	 * 按树状图查询所有药品单位
	 * @return
	 */
	public List<ParentTypeUnitVo> selectAllUnit(){
		List<UnitVo> uv=IUDao.selectAllUnit();
		List<ParentTypeUnitVo> list=new ArrayList<>();
		list.add(new ParentTypeUnitVo(1, "药品单位管理", uv));
		return list;
	}
	
	/**
	 * 查询所有药品单位
	 * @return
	 */
	public List<UnitVo> selectAllUnitName(){
		return IUDao.selectAllUnit();
	}
	
	/**
	 * 根据单位编号修改名称
	 * @param unitId
	 * @param unitName
	 * @return
	 */
	public Errors updateUnitName(Long unitId,String unitsName){
		try {
			Unit unit=IUDao.findOne(unitId);
			unit.setUnitsName(unitsName);
			return new Errors(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Errors(e.getMessage());
		}
		
	}
}
