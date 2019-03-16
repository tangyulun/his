package com.ssh.service.instrument;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.dao.jpa.instrument.HuanhuiDAO;
import com.ssh.dao.jpa.instrument.HuanhuixqDAO;
import com.ssh.dao.jpa.instrument.InstrumentDAO;
import com.ssh.pojos.QxLnventory;
import com.ssh.pojos.QxLnventoryqx;
import com.ssh.pojos.QxReturn;
import com.ssh.pojos.QxReturnqx;
import com.ssh.pojos.QxUse;
import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;
import com.ssh.vo.instrument.HhuixiangqingVo;
import com.ssh.vo.instrument.LingyongXqVo;
import com.ssh.vo.instrument.PdxiangqingVo;

@Service
@Transactional
public class HuanhuiService {
	@Autowired
	private HuanhuiDAO HHDAO;
	@Autowired
	private InstrumentDAO IN;
	@Autowired
	private HuanhuixqDAO HHXA;
	private List<HhuixiangqingVo> list = new ArrayList<HhuixiangqingVo>();
	
	//生成还回单号
    public String haig(){
		return HHDAO.selectLikeNumber(CommentOrder.dateLike());
    	
    }

	//添加到tabel
	public void sleleclyxxq(String instrumentId,String instrumentName,BigDecimal shuliang,String danwei,String instrumentRemark){
		HhuixiangqingVo ddd=new HhuixiangqingVo(list.size() + 1, instrumentId,instrumentName,shuliang,danwei,instrumentRemark);
		list.add(ddd);
	}
	//查询所有
	public List<HhuixiangqingVo> selecthh(){
		return list;
		
	}
	//清除
	public void qingc(){
		list.clear();
	}
	//处理
		public Errors instrumentpd(QxReturn i ){
			try {
				i.setQxReturnState("已还回");
				HHDAO.save(i);
				inserthhxq(i);
				return new Errors(true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return new Errors(e.getMessage());
			}
			
		}
		
		
		//详情
		private void inserthhxq(QxReturn a) {
			for (HhuixiangqingVo r : list) {
				QxReturnqx hh=new QxReturnqx();
				hh.setQxReturnqxBeizu(r.getBeizhu());
				hh.setQxReturnqxNumber(r.getShuliang());
				hh.setQxReturnqxId(r.getId());
				hh.setInstrument(IN.findOne(r.getQxid()));
				hh.setQxReturn(HHDAO.findOne(a.getQxReturnId()));
				HHXA.save(hh);
				
				
			}
			
		}
		
		
		
		//删除
		public Errors deletextinstrument(List<Long> qx){
			for(Long q : qx){
				for(HhuixiangqingVo a : list){
					if(a.getId() == q){
						list.remove(a);
						break;
					}
				}
			}
			return new Errors(true);
		}
}
