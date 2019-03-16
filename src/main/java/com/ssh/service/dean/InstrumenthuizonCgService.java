package com.ssh.service.dean;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ssh.dao.jpa.drugstorage.ISupplierDao;
import com.ssh.dao.jpa.instrument.CaigoxiangqinDAO;
import com.ssh.dao.jpa.instrument.ICaigoDAO;
import com.ssh.dao.jpa.instrument.InstrumentDAO;
import com.ssh.dao.jpa.instrument.InstrumentzzDAO;
import com.ssh.dao.mybatis.dean.IMinstrumenthuizonDAO;
import com.ssh.dao.mybatis.instrument.InstrumentTameDao;
import com.ssh.vo.drugstorage.DrugPurchaseDetaliVo;
import com.ssh.vo.drugstorage.DrugPurchaseVo;
import com.ssh.vo.drugstorage.DrugVo;
import com.ssh.vo.instrument.CaigoXianqingVo;
import com.ssh.vo.instrument.InstrumentCaigouVo;
import com.ssh.vo.instrument.InstrumentVo;
import com.ssh.vo.instrument.SupplierVo;
@Service
@Transactional
public class InstrumenthuizonCgService {
	@Autowired
	private ICaigoDAO CIDAOO;
	@Autowired
	private InstrumentTameDao TDAO;
	@Autowired
	private ISupplierDao CCA;
	//采购详情
	@Autowired
	private InstrumentzzDAO CC;
	
	@Autowired
	private InstrumentDAO IRDAO;
	@Autowired
	private CaigoxiangqinDAO CGXQ;
	@Autowired
	private IMinstrumenthuizonDAO IMDATAE;

	//查询采购订单
	public List<InstrumentCaigouVo> selectInstrumencaighuizon(int page,int rows){
		PageRequest pagee= new PageRequest(page - 1,rows);
		List<InstrumentCaigouVo> list = CIDAOO.selectInstrumentcaig(pagee);
		selectinstrumencaighuizon(list);
		return list;

	}



	public void selectinstrumencaighuizon(List<InstrumentCaigouVo> list){
		for (InstrumentCaigouVo i : list) {
			i.setSupplier(new SupplierVo(CIDAOO.findOne(i.getInstrumentCaigouId()).getSupplier().getSupplierId(),
					CIDAOO.findOne(i.getInstrumentCaigouId()).getSupplier().getSupplierName(),
					CIDAOO.findOne(i.getInstrumentCaigouId()).getSupplier().getSupplierLxr(),
					CIDAOO.findOne(i.getInstrumentCaigouId()).getSupplier().getSupplierPhone()));
		}
	}
	
	
	public long count(){
		return CIDAOO.count();
	}
	
	
	//点击采购订单查询详情根据id
	public List<CaigoXianqingVo> selectByiinstrumentId(String instrumentCaigouId){
		List<CaigoXianqingVo> list = CGXQ.selectByinstrumentCaigouXqId(instrumentCaigouId);
		lianbiaofinXq(list);
		return list;
	}
	public void lianbiaofinXq(List<CaigoXianqingVo> list){
		for (CaigoXianqingVo i : list) {
		i.setInstrument(new InstrumentVo(CGXQ.findOne(i.getInstrumentCaigouXqId()).getInstrument().getInstrumentId()));
	
		
		
		}
	}
	public void selectinstrumencaig(List<InstrumentCaigouVo> list){
		for (InstrumentCaigouVo i : list) {
			
			i.setSupplier(new SupplierVo(CIDAOO.findOne(i.getInstrumentCaigouId()).getSupplier().getSupplierId(),
					CIDAOO.findOne(i.getInstrumentCaigouId()).getSupplier().getSupplierName(),
					CIDAOO.findOne(i.getInstrumentCaigouId()).getSupplier().getSupplierLxr(),
					CIDAOO.findOne(i.getInstrumentCaigouId()).getSupplier().getSupplierPhone()));
		}
	}
	
	
	
	//输入框查询
	public List<InstrumentCaigouVo> selectinstrumentcaigoWherehuizong(int page, int rows, String instrumentCaigouId) {
			PageRequest pages = new PageRequest(page - 1, rows);
			List<InstrumentCaigouVo> list = CIDAOO.selectAllinstrument("%"+instrumentCaigouId+"%", pages);
			selectinstrumencaig(list);
			return list;
			
		}
	//查询记录数
	public long selectinstrumentcaigoWhereCounthuizong(String instrumentCaigouId) {
		return CIDAOO.selectinstrumentcaigoWhereCount("%"+instrumentCaigouId+"%");
	}
	
	//高级查询
	Page<?> pages;
	public List<InstrumentCaigouVo> mohufind(int page,int rows,Date startTime ,
			Date endTime , String instrumentCaigouId , String instrumentCaigouState){
		System.out.println(instrumentCaigouId);
		pages = PageHelper.startPage(page, rows);
		List<InstrumentCaigouVo> list = IMDATAE.mohufindinstrument(startTime, endTime, "".equals(instrumentCaigouId) ? null : "%"+ instrumentCaigouId +"%", instrumentCaigouState);
		return list;
	}
	
	public long queryMohufindCount(){
		return pages.getTotal();
	}
	
}
