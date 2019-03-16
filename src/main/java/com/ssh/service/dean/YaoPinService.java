package com.ssh.service.dean;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ssh.dao.jpa.drugstorage.IDrugDao;
import com.ssh.dao.jpa.drugstorage.IDrugTypeDao;
import com.ssh.dao.mybatis.dean.IMyDrugDAO;
import com.ssh.pojos.Drug;
import com.ssh.pojos.YaokuKucun;
import com.ssh.vo.drugstorage.DrugTypeVo;
import com.ssh.vo.drugstorage.DrugVo;
import com.ssh.vo.drugstorage.UnitVo;
import com.ssh.vo.drugstorage.YaokuKucunVo;

@Service
@Transactional
public class YaoPinService {
	
	@Autowired
	private IDrugDao DDAO;
	
	@Autowired
	private IDrugTypeDao DTDao;
	
	@Autowired
	private IMyDrugDAO IMDAO;
	/**
	 * 查询所有药品分类
	 * @return
	 */
	public List<DrugTypeVo> selectDrugTypeName(){
		List<DrugTypeVo> list2 = new  ArrayList<>();
		List<DrugTypeVo> list =  DTDao.selectDrugTypeName();
		list2.add(new DrugTypeVo(0, "全部"));
		for (DrugTypeVo d : list) {
			list2.add(d);
		}
		return list2 ;
	}
	
	public List<DrugVo> findAllDrug(int page , int rows){
		List<DrugVo> list = DDAO.findAllDrug(new PageRequest(page - 1, rows));
		findByDrug(list);
		return list;
	}

	private void findByDrug(List<DrugVo> list) {
		for (DrugVo d : list) {
			Drug r = DDAO.findOne(d.getDrugId());
			d.setDrugType(new DrugTypeVo(r.getDrugType().getDrugTypeId(), r.getDrugType().getDrugTypeName()));
			d.setUnit(new UnitVo(r.getUnit().getUnitsId(), r.getUnit().getUnitsName()));
			YaokuKucun y = r.getYaokuKucun();
			d.setYaokuKucun(new YaokuKucunVo(y.getYaokuKucunId(), y.getYaofangKucunBottom(), 
					y.getYaofangKucunNum(), 
					y.getYaofangKucunTop(), y.getYaokuKucunBottom(), y.getYaokuKucunNum(), y.getYaokuKucunTop()));
		}
	}

	public long count() {
		return DDAO.count();
	}

	public Object findAllDrugWhere(int page, int rows, String key) {
		List<DrugVo> list = DDAO.findAllDrugWhere("%"+key+"%"  , "%"+key+"%" ,new PageRequest(page - 1, rows));
		findByDrug(list);
		return list;
	}

	public long countWhere(String key) {
		return DDAO.countWhere("%"+key+"%" ,"%"+key+"%" );
	}

	Page<?> pages = null;
	public Object selectAllDrugDeanGradeWhere(int page, int rows, String key, String type, String ku, String fang) {
		//验证
		pages = PageHelper.startPage(page, rows);
		System.err.println(ku + " \n" + "dfsfs"+fang);
		List<DrugVo> list = IMDAO.selectAllDrugDeanGradeWhere( "%"+key+"%" ,  "0".equals(type) ? null : type, ku,  fang);
		findByDrug(list);
		return list;
	}

	public long countGradeWhere(String key, String type, String ku, String fang) {
		return pages.getTotal();
	}
	
}
