package com.ssh.service.instrument;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.dao.jpa.instrument.ICaigoDAO;
import com.ssh.dao.jpa.instrument.IThelibrayDAO;
import com.ssh.dao.jpa.instrument.InstrumentDAO;
import com.ssh.dao.jpa.instrument.RkxqDAO;
import com.ssh.dao.jpa.instrument.YanshoDao;
import com.ssh.dao.jpa.instrument.YanshoxqingqingDAO;
import com.ssh.dao.jpa.staff.IEmpDAO;
import com.ssh.pojos.Instrument;
import com.ssh.pojos.InstrumentCaigou;
import com.ssh.pojos.InstrumentCaigouXq;
import com.ssh.pojos.InstrumentRk;
import com.ssh.pojos.InstrumentRkXq;
import com.ssh.pojos.InstrumentY;
import com.ssh.pojos.InstrumentYanshouXq;
import com.ssh.pojos.QxReturnqx;
import com.ssh.pojos.QxThelibrary;
import com.ssh.pojos.QxThelibraryqx;
import com.ssh.pojos.YaokuKucun;
import com.ssh.service.drugstorage.RukuVo;
import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;
import com.ssh.vo.drugstorage.YanshouVo;
import com.ssh.vo.instrument.InstrumentTypeVo;
import com.ssh.vo.instrument.RKinstrumentVo;
import com.ssh.vo.instrument.ThelibraryVo;
import com.ssh.vo.instrument.YanshoVo;
import com.ssh.vo.instrument.YanshoxiangqingVo;
import com.ssh.vo.instrument.ZyanshoxqVo;
@Service
@Transactional
public class ThelibrayService {
	@Autowired
	private IThelibrayDAO LIDAO;
	@Autowired
	private RkxqDAO RKXQD;
	@Autowired
	private YanshoDao ysDao;
	@Autowired
	private YanshoxqingqingDAO YSXQD;
	@Autowired
	private InstrumentDAO QX;
	@Autowired
	private ICaigoDAO CG;
	@Autowired
	private IEmpDAO IEDao;
	private List<RKinstrumentVo> list=new ArrayList<>();
	
	public List<ThelibraryVo> selectALL(){
		return LIDAO.selectAll();
		
	}
	
	//生成入库单号
    public String ruku(){
		return LIDAO.selectLikeNumber(CommentOrder.dateLike());
    	
    }
    
   
    
  //入库到表格
   public List<RKinstrumentVo> sleleqxrk(String instrumentYsId){
			List<ZyanshoxqVo> xq=YSXQD.selecttable(instrumentYsId);
			for (ZyanshoxqVo z : xq) {
				RKinstrumentVo y=new RKinstrumentVo();
				Instrument i=QX.findOne(z.getInstrumentId());
				y.setRkid(i.getInstrumentId());
				y.setRkname(i.getInstrumentName());
				y.setDanwei(i.getUnit().getUnitsName());
				y.setRkshuliang(""+z.getInstrumentYanshouXqHegeNum());
				y.setRkbz(z.getInstrumentYanshouXqRemark());
				y.setRkcgdate(new Date());
				System.err.println(y);
				list.add(y);
			}
			return list;
	}
	
	//入库处理
	public Errors instrumentRK(InstrumentRk a,String instrumentYsId,Long EmpId){
		try {
			a.setInstrumentY(ysDao.findOne(instrumentYsId));
			a.setEmp(IEDao.findOne(EmpId));
			a.setQxReturngoosSatae("已入库");
			LIDAO.save(a);
			insertWareXq(a);
			return new Errors(true);
		} catch (Exception e) {
			e.printStackTrace();
			return new Errors(e.getMessage());
		}
		
	}
		
	public void insertWareXq(InstrumentRk a){
		for (RKinstrumentVo i : list) {
			InstrumentRkXq q=new InstrumentRkXq();
			q.setInstrumentRkXqid(RKXQD.maxId());
			q.setInstrumentRkXqbeizu(i.getRkbz());
			q.setInstrumentRkXqnumber(new BigDecimal(i.getRkshuliang()));
			q.setInstrumentRkXqcgdate(new Date());
			q.setInstrumentRkXqbeizu(i.getRkbz());
			q.setInstrumentRkXqscdate(i.getRkscdate());
			q.setInstrumentRkXqcgdate(i.getRkcgdate());
			Instrument il = QX.findOne(i.getRkid());
			il.setInstrumentZongNum(
					new BigDecimal(
					il.getInstrumentZongNum().intValue() + Integer.valueOf(i.getRkshuliang())));
			il.setInstrumentShengNum(il.getInstrumentZongNum());
			q.setInstrument(QX.findOne(i.getRkid()));
			q.setInstrumentRk(LIDAO.findOne(a.getInstrumentRkId()));
			System.out.println(q);
			RKXQD.save(q);
		}
	}
	
	//清楚
	public void clear(){
		list.clear();
	}

}


