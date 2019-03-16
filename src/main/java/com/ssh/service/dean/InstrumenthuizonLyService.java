package com.ssh.service.dean;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ssh.dao.jpa.instrument.InstrumentDAO;
import com.ssh.dao.jpa.instrument.LingyongDAO;
import com.ssh.dao.jpa.instrument.LingyongxqDAO;
import com.ssh.dao.mybatis.dean.IMinstrumentUseDAO;
import com.ssh.vo.instrument.CaigoXianqingVo;
import com.ssh.vo.instrument.InstrumentCaigouVo;
import com.ssh.vo.instrument.InstrumentVo;
import com.ssh.vo.instrument.LingyongHuizonXqVo;
import com.ssh.vo.instrument.LingyongVo;
import com.ssh.vo.instrument.LingyongXqVo;
@Service
@Transactional
public class InstrumenthuizonLyService {
	@Autowired
	private LingyongDAO LYDAO;
	@Autowired
	private InstrumentDAO LY;
	@Autowired
	private LingyongxqDAO LXXQ;
	@Autowired
	private IMinstrumentUseDAO IMUSE;
	
	
	//查询领用订单
	public List<LingyongVo> selectInstrumenlyhuizon(int page,int rows){
		PageRequest pagee= new PageRequest(page - 1,rows);
		List<LingyongVo> list = LYDAO.selectInstrumently(pagee);
		return list;

	}
	
	public long count(){
		return LYDAO.count();
	}
	
	//点击采购订单查询详情根据id
		public List<LingyongHuizonXqVo> selectByiinstrumentId(String qxUseId){
			List<LingyongHuizonXqVo> list = LXXQ.selectByinstrumentLYXqId(qxUseId);
			lianbiaofinXq(list);
			return list;
		}

		public void lianbiaofinXq(List<LingyongHuizonXqVo> list){
			for (LingyongHuizonXqVo i : list) {
			i.setInstrument(new InstrumentVo(LXXQ.findOne(i.getQxUseqxId()).getInstrument().getInstrumentId()));
			
			
			}
		}
		
		//输入框查询
		public List<LingyongVo> selectinstrumentcaigoWherehuizong(int page, int rows, String qxUseId) {
				PageRequest pages = new PageRequest(page - 1, rows);
				List<LingyongVo> list = LYDAO.selectAllinstrument("%"+qxUseId+"%", pages);
				return list;
				
			}
		
		//查询记录数
		public long selectinstrumentlyWhereCounthuizong(String qxUseId) {
			return LYDAO.selectinstrumentlyWhereCount("%"+qxUseId+"%");
		}
		
		//高级查询
		Page<?> pages;
		public List<LingyongVo> mohufind(int page,int rows,Date startTime ,
				Date endTime , String qxUseId , String qxUseState){
			pages = PageHelper.startPage(page, rows);
			List<LingyongVo> list = IMUSE.mohufindinstrumentUse(startTime, endTime, "".equals(qxUseId) ? null : "%"+ qxUseId +"%", qxUseState);
			return list;
		}
		
		public long queryMohufindCountly(){
			return pages.getTotal();
		}
}
