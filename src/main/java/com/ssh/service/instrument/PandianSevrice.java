package com.ssh.service.instrument;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.dao.jpa.instrument.InstrumentDAO;
import com.ssh.dao.jpa.instrument.PandianDAO;
import com.ssh.dao.jpa.instrument.PandianxqDAO;
import com.ssh.pojos.QxLnventory;
import com.ssh.pojos.QxLnventoryqx;
import com.ssh.pojos.QxThelibrary;
import com.ssh.pojos.QxThelibraryqx;
import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;
import com.ssh.vo.instrument.CKxiangqingVo;
import com.ssh.vo.instrument.PdxiangqingVo;

@Service
@Transactional
public class PandianSevrice {
	@Autowired
	private PandianDAO PDDAO;
	@Autowired
	private InstrumentDAO IN;
	@Autowired
	private PandianxqDAO PDXQ;
	private List<PdxiangqingVo> list = new ArrayList<PdxiangqingVo>();
	
	public String pdaig(){
		return PDDAO.selectLikeNumber(CommentOrder.dateLike());
		
		
	}
	//添加到tabel
	public void slelectqxxq(String instrumentId,String instrumentName,BigDecimal shuliang,String danwei,String instrumentRemark){
		PdxiangqingVo dvo=new PdxiangqingVo(list.size() + 1, instrumentId,instrumentName,shuliang,danwei,instrumentRemark);
		System.out.println(dvo);
		list.add(dvo);
	}
	//查询所有
	public List<PdxiangqingVo> selectpdo(){
		return list;
		
	}
	//清楚
	public void cle(){
		list.clear();
	}
	//删除
	public Errors deletextinstrument(List<Long> qx){
		for(Long q : qx){
			for(PdxiangqingVo a : list){
				if(a.getId() == q){
					list.remove(a);
					break;
				}
			}
		}
		return new Errors(true);
	}
	
	
	
	//处理
	public Errors instrumentpd(QxLnventory a ){
		try {
			a.setQxLnventoryState(new BigDecimal(1));
			insertpdxq(a);
			PDDAO.save(a);
			return new Errors(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Errors(e.getMessage());
		}
		
	}
	//详情
	private void insertpdxq(QxLnventory a) {
		for (PdxiangqingVo r : list) {
			QxLnventoryqx aa=new QxLnventoryqx();
			aa.setQxLnventoryqxBeizu(r.getBeizhu());
			aa.setQxLnventoryqxYkNum(r.getShuliang());
			aa.setQxLnventoryqxId(r.getId());
			aa.setQxLnventoryqxNum(r.getShuliang());
			aa.setQxLnventory(PDDAO.findOne(a.getQxLnventoryId()));
			aa.setInstrument(IN.findOne(r.getQxid()));
			PDXQ.save(aa);
			
			
		}
		
	}
	
	
	
	
	
	
	}