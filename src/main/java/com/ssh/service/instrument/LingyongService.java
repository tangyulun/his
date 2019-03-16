package com.ssh.service.instrument;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.dao.jpa.instrument.InstrumentDAO;
import com.ssh.dao.jpa.instrument.LingyongDAO;
import com.ssh.dao.jpa.instrument.LingyongxqDAO;
import com.ssh.pojos.QxLnventory;
import com.ssh.pojos.QxLnventoryqx;
import com.ssh.pojos.QxUse;
import com.ssh.pojos.QxUseqx;
import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;
import com.ssh.vo.instrument.LingyongXqVo;
import com.ssh.vo.instrument.PdxiangqingVo;

@Service
@Transactional
public class LingyongService {
	@Autowired
	private LingyongDAO LYDAO;
	@Autowired
	private InstrumentDAO LY;
	@Autowired
	private LingyongxqDAO LXXQ;
	
	private List<LingyongXqVo> list = new ArrayList<LingyongXqVo>();
	
	public String Laig(){
		return LYDAO.selectLikeNumber(CommentOrder.dateLike());
		
		
	}
	//添加到tabel
	public void sleleclyxxq(String instrumentId,String instrumentName,BigDecimal shuliang,String danwei,String instrumentRemark){
		LingyongXqVo dvo=new LingyongXqVo(list.size() + 1, instrumentId,instrumentName,shuliang,danwei,instrumentRemark);
		System.out.println(dvo);
		list.add(dvo);
	}
	//清楚
	public void cle(){
		list.clear();
	}
	//查询所有
	public List<LingyongXqVo> selectpdo(){
			return list;
			
		}
	//处理
	public Errors instrumentpd(QxUse a ){
		try {
			a.setQxUseState("已领用");
			LYDAO.save(a);
			insertpdly(a);
			return new Errors(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Errors(e.getMessage());
		}
		
	}
	//详情
	public void insertpdly(QxUse a) {
		for (LingyongXqVo r : list) {
			QxUseqx ly=new QxUseqx();
			ly.setQxUseqxId(r.getId());
			ly.setQxUseqxLyshul(r.getShuliang());
			ly.setQxUseqxBeizu(r.getBeizhu());
			ly.setQxUseqxJcshul(r.getShuliang());
			ly.setInstrument(LY.findOne(r.getQxid()));
			ly.setQxUse(LYDAO.findOne(a.getQxUseId()));
			System.err.println(LYDAO.findOne(a.getQxUseId()));
			LXXQ.save(ly);
			
			
			
		}
		
	}
	
	//删除
		public Errors deletextinstrumently(List<Long> qx){
			for(Long q : qx){
				for(LingyongXqVo a : list){
					if(a.getId() == q){
						list.remove(a);
						break;
					}
				}
			}
			return new Errors(true);
		}
	
	}