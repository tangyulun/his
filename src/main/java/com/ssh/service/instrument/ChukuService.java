package com.ssh.service.instrument;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.dao.jpa.instrument.ChukuDAO;
import com.ssh.dao.jpa.instrument.CkxiangqingDAO;
import com.ssh.dao.jpa.instrument.InstrumentDAO;
import com.ssh.dao.jpa.staff.IEmpDAO;
import com.ssh.pojos.Drug;
import com.ssh.pojos.DrugDelivery;
import com.ssh.pojos.DrugDeliveryDetali;
import com.ssh.pojos.Instrument;
import com.ssh.pojos.InstrumentCaigou;
import com.ssh.pojos.InstrumentCaigouXq;
import com.ssh.pojos.QxThelibrary;
import com.ssh.pojos.QxThelibraryqx;
import com.ssh.pojos.YaokuKucun;
import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;
import com.ssh.vo.drugstorage.BuydingdanVo;
import com.ssh.vo.drugstorage.RukuXqVo;
import com.ssh.vo.instrument.CKxiangqingVo;
import com.ssh.vo.instrument.CgXIangqingVo;
import com.ssh.vo.instrument.YanshoxiangqingVo;

@Service
@Transactional
public class ChukuService {
	@Autowired
	private ChukuDAO CKDAO;
	
	@Autowired
	private InstrumentDAO ins;
	
	@Autowired
	private IEmpDAO IEDao;
	@Autowired
	private CkxiangqingDAO CKXQDAO;
	
	private List<CKxiangqingVo> list = new ArrayList<CKxiangqingVo>();
	/**
	 * 
	 * 出库单号
	 */
	public String ckuku(){
		return CKDAO.selectLikeNumber(CommentOrder.dateLike());
	}

	public String maxid() {
		return ins.selectMaxId();
	}
	
	//传table
	public void slelectqxxq(String instrumentId,String instrumentName,BigDecimal shuliang,String danwei,String instrumentRemark){
		CKxiangqingVo dvo=new CKxiangqingVo(list.size() + 1, instrumentId,instrumentName,shuliang,danwei,instrumentRemark);
		System.out.println(dvo);
		list.add(dvo);
	}
	
	
	//查询所有
	public List<CKxiangqingVo> selectyanshoo(){
		return list;
		
	}
	//删除选中记录
	public Errors deletextinstrument(List<Long> qx){
		for(Long q : qx){
			for(CKxiangqingVo a : list){
				if(a.getId() == q){
					list.remove(a);
					break;
				}
			}
		}
		return new Errors(true);
	}
	
	//出库处理
	public Errors instrumentck(QxThelibrary a , Long empId){
		try {
			a.setEmp(IEDao.findOne(empId));
			a.setQxThelibraryState("已出库");
			insertrukuxq(a);
			CKDAO.save(a);
			return new Errors(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Errors(e.getMessage());
		}
		
	}
	
	//详情记录
	public void insertrukuxq(QxThelibrary dd){
		for (CKxiangqingVo r : list) {
			QxThelibraryqx a=new QxThelibraryqx();
			a.setQxThelibraryqxBeizu(r.getBeizhu());
			a.setQxThelibraryqxId(CKXQDAO.maxId());
			a.setQxThelibraryqxNumber(r.getShuliang());
			a.setQxThelibrary(CKDAO.findOne(dd.getQxThelibraryId()));
			a.setInstrument(ins.findOne(r.getQxid()));
			CKXQDAO.save(a);
			
		}
	}
	
	

	//修改库存数量
	/*public void updatechukuxq(){
		for (CKxiangqingVo r : list) {
			Instrument d=ins.findOne(r.getQxid());
			Instrument yk=ins.findOne(d.getInstrumentId());
			yk.setInstrumentZongNum(new BigDecimal(yk.getInstrumentZongNum().intValue() + r.getShuliang().intValue()));
			yk.setInstrumentShengNum(new BigDecimal(yk.getInstrumentZongNum().intValue() - yk.getInstrumentWaijieNum().intValue()));
		}
	}
	*/
	/**
	 * 查询
	 */
	public  List<CKxiangqingVo> selectAll(){
		return list;
	}
	
	/**
	 * 清除
	 */
	public void clear(){
		list.clear();
	}
	
	
	
	
	}