package com.ssh.service.instrument;


import com.ssh.dao.jpa.drugstorage.IUnitDao;
import com.ssh.dao.jpa.instrument.InstrumentDAO;
import com.ssh.dao.jpa.instrument.InstrumentTypeDAO;
import com.ssh.dao.jpa.login.LoginDao;
import com.ssh.pojos.Emp;
import com.ssh.pojos.Instrument;
import com.ssh.pojos.InstrumentType;
import com.ssh.pojos.Unit;
import com.ssh.utils.Errors;
import com.ssh.vo.drugstorage.UnitVo;
import com.ssh.vo.instrument.InstrumentTypeVo;
import com.ssh.vo.instrument.InstrumentVo;
import com.ssh.vo.instrument.ParentTypeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class IinstrumenttypeService {
	
	@Autowired
	private InstrumentDAO BADD;
	@Autowired
	private InstrumentTypeDAO ADD;
	
	@Autowired
	private LoginDao Logindao;
	
	@Autowired
	private IUnitDao IUDao;
	
	//点击ul查询
	public List<InstrumentVo> queryInstrument(int page,int rows,Long instrumentTypeId){
		InstrumentType ss=ADD.findOne(instrumentTypeId);
		List<InstrumentVo> list=BADD.findByAllinstrument(ss, new PageRequest(page - 1,rows));
		selectInstrumentDclassTo(list);
		return list ;
		
	}

	public long queryInCount(long instrumentTypeId){
		InstrumentType ss=ADD.findOne(instrumentTypeId);
		return BADD.finByinstrumentCount(ss);
	}
	
	
	
	
	//添加器械
	public Errors addType(String instrumentTypeName){
		try {
			InstrumentType h=new InstrumentType();
			h.setInstrumentTypeId(ADD.selectidMAX());
			h.setInstrumentTypeName(instrumentTypeName);
			ADD.save(h);
			return new Errors(true);
		} catch (Exception e) {
			
			e.printStackTrace();
			return new Errors(e.getMessage());
		}
		
	
	}
	//树
	public List<ParentTypeVo> selectALL(){
		List<InstrumentTypeVo> list= ADD.findByAllDept();
		List<ParentTypeVo>listT=new ArrayList<>();
		listT.add(new ParentTypeVo(1,"器械分类结构",list));
		return listT;

	}
	//查询分类
	public List<InstrumentTypeVo> selectALL2(){
		List<InstrumentTypeVo> list= ADD.findByAllDept();
		return list;

	}
	//验证分类名是否存在
	public Errors  regexiTypeName(String instrumentTypeName){
		InstrumentType iclass= ADD.regexiTypeName(instrumentTypeName);
		return iclass==null ? new Errors(true) : new Errors();
		
	}
	//验证器械名是否存在
		public Errors  regexiName(String instrumentName){
			Instrument pclass= BADD.regexiName(instrumentName);
			return pclass==null ? new Errors(true) : new Errors();
			
		}
	//查询
	public List<InstrumentVo> selectInstrumen(int page,int rows){
		PageRequest pagee= new PageRequest(page - 1,rows);
		List <InstrumentVo> list =BADD.selectInstrument(pagee);
		selectInstrumentDclassTo(list);
		return list;

	}
	
	public long count(){
		return BADD.count();
	}
	
	//新增器械
	public Errors addinstrument(Instrument instrument, long instrumentTypeId, long empId, long unitId){
		try {
			InstrumentType instrumenttype=ADD.findOne(instrumentTypeId);
			System.err.println(instrument);
			Emp emp=Logindao.findOne(empId);
			Unit unit=IUDao.findOne(unitId);
			instrument.setEmp(emp);
			instrument.setInstrumentType(instrumenttype);
			instrument.setInstrumentZongNum(new BigDecimal(0));
			instrument.setInstrumentShengNum(new BigDecimal(0));
			instrument.setInstrumentWaijieNum(new BigDecimal(0));
			instrument.setUnit(unit);
			BADD.save(instrument);
			return new Errors(true);
		} catch (Exception e) {
			e.printStackTrace();
			return new Errors(e.getMessage());
		}
		
	}
	//查询记录数
	public long selectinstrumentWhereCount(String instrumentName) {
		return BADD.selectinstrumentWhereCount("%"+instrumentName+"%");
	}

	
	//输入框查询
	public List<InstrumentVo> selectinstrumentWhere(int page, int rows, String instrumentName) {
		PageRequest pages = new PageRequest(page - 1, rows);
		List<InstrumentVo> list= BADD.selectAllinstrument("%"+instrumentName+"%" , pages);
		selectInstrumentDclassTo(list);
		return list;
	}
	

	public Errors updateinstrument(Instrument instrument,String instrumentId,long instrumentTypeId,long empId ){
		try {
		Instrument i = BADD.findOne(instrumentId);
		InstrumentType In=ADD.findOne(instrumentTypeId);
		i.setInstrumentBaofeiDate(instrument.getInstrumentBaofeiDate());
		i.setInstrumentChicun(instrument.getInstrumentChicun());
		i.setInstrumentId(instrument.getInstrumentId());
		i.setInstrumentName(instrument.getInstrumentName());
		i.setInstrumentQiyongDate(instrument.getInstrumentQiyongDate());
		i.setInstrumentRemark(instrument.getInstrumentRemark());
		i.setInstrumentType(In);
		i.setEmp(instrument.getEmp());
		return new Errors(true);
	} catch (Exception e) {
		e.printStackTrace();
		return new Errors(e.getMessage());
	}
	
}
	//修改分类码
	public Errors updataInstrumentTypeName(long instrumentTypeId,String instrumentTypeName){
		try {
			InstrumentType f = ADD.findOne(instrumentTypeId);
			f.setInstrumentTypeName(instrumentTypeName);
			return new Errors(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Errors(e.getMessage());
		}
	}
	
	private void selectInstrumentDclassTo(List<InstrumentVo> list) {
		for (InstrumentVo o : list) {
			o.setInstrumentType(new InstrumentTypeVo(BADD.findOne(o.getInstrumentId()).getInstrumentType().getInstrumentTypeId() ,
					BADD.findOne(o.getInstrumentId()).getInstrumentType().getInstrumentTypeName()) 
					);
			
			o.setUnit(new UnitVo(BADD.findOne(o.getInstrumentId()).getUnit().getUnitsId(),
					BADD.findOne(o.getInstrumentId()).getUnit().getUnitsName()
					));
		}
	}
	//查询分类
	public List<InstrumentTypeVo> getInstrumentType(){
		return ADD.findByAllDept();
	}
	
	
}
