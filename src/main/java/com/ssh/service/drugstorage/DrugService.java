package com.ssh.service.drugstorage;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.dao.jpa.drugstorage.IDrugDao;
import com.ssh.dao.jpa.drugstorage.IDrugTypeDao;
import com.ssh.dao.jpa.drugstorage.ISupplierDao;
import com.ssh.dao.jpa.drugstorage.IUnitDao;
import com.ssh.dao.jpa.drugstorage.YaokuKucunDao;
import com.ssh.pojos.Drug;
import com.ssh.pojos.DrugType;
import com.ssh.pojos.Supplier;
import com.ssh.pojos.YaokuKucun;
import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;
import com.ssh.vo.drugstorage.DrugTypeVo;
import com.ssh.vo.drugstorage.DrugVo;
import com.ssh.vo.drugstorage.ParentTypeDrugVo;
import com.ssh.vo.drugstorage.ParentTypeVo;
import com.ssh.vo.drugstorage.SupplierTypeVo;
import com.ssh.vo.drugstorage.SupplierVo;
import com.ssh.vo.drugstorage.UnitVo;
import com.ssh.vo.drugstorage.YaokuKucunVo;

@Service
@Transactional
public class DrugService {
	
	@Autowired
	private IDrugDao DDao;
	
	@Autowired
	private IDrugTypeDao DTDao;
	
	@Autowired
	private IUnitDao IUDao;
	
	@Autowired
	private YaokuKucunDao YKDao;
	
	/**
	 * 新增药品分类
	 * @param SName
	 * @return
	 */
	public Errors insertDrugType(String drugTypeName){
		try {
			DrugType dt=new DrugType();
			dt.setDrugTypeId(DTDao.selectMaxId());
			dt.setDrugTypeName(drugTypeName);
			DTDao.save(dt);
			return new Errors(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Errors(e.getMessage());
		}
	}
	
	/**
	 * 自动生成药品id
	 * @return
	 */
	public String findDrugId(){
		return DDao.findDrugId();
	}
	
	/**
	 * 查询药品分类用树状图显示
	 * @return
	 */
	public List<ParentTypeDrugVo> selectAllDrugType(){
		List<DrugTypeVo> dt=DTDao.selectDrugTypeName();
		List<ParentTypeDrugVo> list=new ArrayList<>();
		list.add(new ParentTypeDrugVo(1, "药品分类结构", dt));
		return list;
	}
	
	/**
	 * 查询所有药品分类
	 * @return
	 */
	public List<DrugTypeVo> selectDrugTypeName(){
		return DTDao.selectDrugTypeName();
	}
	
	/**
	 * 查询是否有相同的药品分类名称
	 * @param drugTypeName
	 * @return
	 */
	public Errors selectName(String drugTypeName){
		DrugType dt=DTDao.selectName(drugTypeName);
		return dt == null ? new Errors(true) : new Errors();
	}
	
	/**
	 * 分页查询药品信息
	 * @param curpage
	 * @param pagesize
	 * @return
	 */
	public List<DrugVo> findAllDrug(int curpage,int pagesize){
		PageRequest page=new PageRequest(curpage-1, pagesize);
		List<DrugVo> list =  DDao.findAllDrug(page);
		lianbiaochaxun(list);
		return list;
		
	}

	/**
	 * 连表查询方法（查询供应商、药品分类、药品单位）
	 * @param list
	 */
	private void lianbiaochaxun(List<DrugVo> list) {
		for (DrugVo d : list) {
			d.setDrugType(DTDao.selectTypeName(DDao.findOne(d.getDrugId())));
			d.setUnit(new UnitVo(DDao.findOne(d.getDrugId()).getUnit().getUnitsId(),
					DDao.findOne(d.getDrugId()).getUnit().getUnitsName()));
			d.setYaokuKucun(new YaokuKucunVo(DDao.findOne(d.getDrugId()).getYaokuKucun().getYaokuKucunId(),
					DDao.findOne(d.getDrugId()).getYaokuKucun().getYaofangKucunBottom(),
					DDao.findOne(d.getDrugId()).getYaokuKucun().getYaofangKucunNum(), 
					DDao.findOne(d.getDrugId()).getYaokuKucun().getYaofangKucunTop(), 
					DDao.findOne(d.getDrugId()).getYaokuKucun().getYaokuKucunBottom(), 
					DDao.findOne(d.getDrugId()).getYaokuKucun().getYaokuKucunNum(), 
					DDao.findOne(d.getDrugId()).getYaokuKucun().getYaokuKucunTop()));
		}
	}
	
	/**
	 * 查询总的记录数
	 * @return
	 */
	public long count(){
		return DDao.count();
	}
	
	/**
	 * 新增药品
	 * @param DTypeId
	 * @param SupId
	 * @param drug
	 * @return
	 */
	public Errors insertDrug(Long DTypeId,Long Unita,Drug drug,int sx,int xx,int yaokuKucunTop,int yaokuKucunBottom){
		try {
			drug.setDrugType(DTDao.findOne(DTypeId));
			drug.setUnit(IUDao.findOne(Unita));
			YaokuKucun yk = new YaokuKucun();
			yk.setYaokuKucunId(YKDao.findMaxId());
			yk.setYaofangKucunNum(new BigDecimal(0));
			yk.setYaokuKucunNum(new BigDecimal(0));
			yk.setYaokuKucunTop(new BigDecimal(yaokuKucunTop));
			yk.setYaokuKucunBottom(new BigDecimal(yaokuKucunBottom));
			yk.setYaofangKucunTop(new BigDecimal(sx));
			yk.setYaofangKucunBottom(new BigDecimal(xx));
			yk.setYaofangKaiyaoNum(new BigDecimal(0));
			yk.setYaofangKaiyaoShengyuNum(new BigDecimal(0));
			YKDao.save(yk);
			drug.setYaokuKucun(YKDao.findOne(yk.getYaokuKucunId()));
			DDao.save(drug);
			return new Errors(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Errors(e.getMessage());
		}
	}
	
	/**
	 * 编辑药品
	 * @param drugId
	 * @param drug
	 * @param supplierId
	 * @param DTypeId
	 * @param Unita
	 * @param sx
	 * @param xx
	 * @return
	 */
	public Errors upadteDrug(Drug drug,Long DTypeId,Long Unita,int sx,int xx,int yaokuKucunTop,int yaokuKucunBottom){
		try {
			Drug dr=DDao.findOne(drug.getDrugId());
			System.err.println(dr + "\t"+drug.getDrugId());
			
			
			YaokuKucun yk = YKDao.findOne(dr.getYaokuKucun().getYaokuKucunId());
			yk.setYaofangKucunNum(new BigDecimal(0));
			yk.setYaokuKucunNum(new BigDecimal(0));
			yk.setYaokuKucunTop(new BigDecimal(yaokuKucunTop));
			yk.setYaokuKucunBottom(new BigDecimal(yaokuKucunBottom));
			
			dr.setDrugBname(drug.getDrugBname());
			dr.setDrugBz(drug.getDrugBz());
			dr.setDrugBzdate(drug.getDrugBzdate());
			dr.setDrugCf(drug.getDrugCf());
			dr.setDrugGg(drug.getDrugGg());
			dr.setDrugId(drug.getDrugId());
			dr.setDrugJx(drug.getDrugJx());
			dr.setDrugLx(drug.getDrugLx());
			dr.setDrugName(drug.getDrugName());
			dr.setDrugPfprice(drug.getDrugPfprice());
			dr.setDrugLsprice(drug.getDrugLsprice());
			dr.setDrugSccj(drug.getDrugSccj());
			dr.setDrugShr(drug.getDrugShr());
			dr.setDrugYf(drug.getDrugYf());
			dr.setDrugZt(drug.getDrugZt());
			dr.setDrugType(DTDao.findOne(DTypeId));
			dr.setUnit(IUDao.findOne(Unita));
			
			return new Errors(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Errors(e.getMessage());
		}
	}
	
	
	/**
	 * 根据药品分类编号查询药品信息
	 * @param page
	 * @param rows
	 * @param DTypeId
	 * @return
	 */
	public List<DrugVo> findDrugByTypeId(int page,int rows,Long DTypeId){
		DrugType dt=DTDao.findOne(DTypeId);
		List<DrugVo> list=DDao.findDrugByType(dt,new PageRequest(page-1,rows));
		lianbiaochaxun(list);
		return list;
	}
	
	/**
	 * 根据药品分类编号查询药品信息记录数量
	 * @param DTypeId
	 * @return
	 */
	public long findDrugByTypeIdCount(Long DTypeId){
		DrugType dt=DTDao.findOne(DTypeId);
		return DDao.findDrugByTypeCount(dt);
	}
	
	/**
	 * 模糊查询药品信息
	 * @param page
	 * @param rows
	 * @param drugName
	 * @return
	 */
	public List<DrugVo> mohufindDrugByName(int page,int rows,String drugName){
		List<DrugVo> list=DDao.mohufindDrugByName("%"+drugName+"%", new PageRequest(page-1,rows));
		lianbiaochaxun(list);
		return list;
	}
	
	/**
	 * 记录模糊查询中药品信息数量
	 * @param drugName
	 * @return
	 */
	public long mohufindDrugByNameCount(String drugName){
		return DDao.mohufindDrugByNameCount(drugName);
	}
	
	/**
	 * 分页查询所有药品信息
	 * @param page
	 * @param rows
	 * @return
	 */
	public List<DrugVo> findDrugByfenye(int page,int rows){
		List<DrugVo> list= DDao.findAllDrug(new PageRequest(page-1,rows));
		lianbiaochaxun(list);
		return list;
	}
	
	/**
	 * 根据药品分类id修改药品分类名
	 * @param drugTypeId
	 * @param drugTypeName
	 * @return
	 */
	public Errors updateDrugById(Long drugTypeId,String drugTypeName){
		try {
			DrugType d=DTDao.findOne(drugTypeId);
			d.setDrugTypeName(drugTypeName);
			return new Errors(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Errors(e.getMessage());
		}
	}
	
	/**
	 * 分页查询库存大于0的药品
	 * @param page
	 * @param rows
	 * @return
	 */
	public List<DrugVo> selectDrugByKucun(int page , int rows){
		PageRequest pages=new PageRequest(page - 1, rows);
		List<DrugVo> list=DDao.findAllDrugByKucun(pages);
		lianbiaochaxun(list);
		return list;
	}
}
