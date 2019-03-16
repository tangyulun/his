package com.ssh.service.instrument;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.dao.jpa.drugstorage.ISupplierDao;
import com.ssh.dao.jpa.instrument.InstrumentDAO;
import com.ssh.dao.jpa.instrument.ThDao;
import com.ssh.dao.jpa.instrument.ThuihuixiangqingDAO;
import com.ssh.dao.jpa.instrument.YanshoDao;
import com.ssh.dao.jpa.instrument.YanshoxqingqingDAO;
import com.ssh.pojos.Instrument;
import com.ssh.pojos.InstrumentY;
import com.ssh.pojos.InstrumentYanshouXq;
import com.ssh.pojos.QxReturngoo;
import com.ssh.pojos.QxReturngoosqx;
import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;
import com.ssh.vo.instrument.InstrumentVo;
import com.ssh.vo.instrument.InstrumentYanshoxiangqiangVo;
import com.ssh.vo.instrument.SupplierVo;
import com.ssh.vo.instrument.ThVo;
import com.ssh.vo.instrument.ThxiangqingVo;
import com.ssh.vo.instrument.YanshoVo;
import com.ssh.vo.instrument.YanshoxiangqingVo;
@Service
@Transactional
public class ThSevrice {
	@Autowired
	private ThDao THDAO;
	@Autowired
	private YanshoDao ysDao;
	@Autowired
	private ISupplierDao ISDao;
	@Autowired
	private InstrumentDAO i;
	@Autowired
	private ThuihuixiangqingDAO THXQ;
	@Autowired
	private YanshoxqingqingDAO AK;
	private List<YanshoxiangqingVo> list= new ArrayList<YanshoxiangqingVo>();
	
	private List<InstrumentYanshoxiangqiangVo> list3 = null;
	
	public String taig(){
		return THDAO.selectLikeNumber(CommentOrder.dateLike());
		
	
	}

	//table显示
	public List<InstrumentYanshoxiangqiangVo> selecttuihuo(String qxReturngoosId){
		list3 = AK.selecttablew(qxReturngoosId);
		lianbiao(list3);
		return list3;
		
	}
	
	public void lianbiao(List<InstrumentYanshoxiangqiangVo> list){
		for (InstrumentYanshoxiangqiangVo y : list) {
			InstrumentYanshouXq ivoo  = AK.findOne(y.getInstrumentYanshouXqId());
			Instrument ivo = i.findOne(ivoo.getInstrumentId());
			y.setInstrument(new InstrumentVo(ivo.getInstrumentId(),ivo.getInstrumentName()));
			y.setInstrumentYanshouXqMoney(new BigDecimal(ivo.getInstrumentPrice().doubleValue()
					* y.getInstrumentYanshouXqZongNum().intValue()));
		}
	}
	
	//退货处理
		public Errors instrumentTuihuoChuli(QxReturngoo dt,String supplierId,String instrumentYsId){
			try {
				InstrumentY y = ysDao.findOne(instrumentYsId);
				y.setInstrumentYsState("已退货");
				dt.setSupplier(ISDao.findOne(supplierId));
				dt.setInstrumentY(ysDao.findOne(instrumentYsId));
				dt.setQxReturngoosSatae("已退货");
				THDAO.save(dt);
				instrumentTuihuo(dt);
				return new Errors(true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return new Errors(e.getMessage());
			}
		}
	//把下方table填进数据库
		public void instrumentTuihuo(QxReturngoo dt){
			for (InstrumentYanshoxiangqiangVo t : list3) {
				QxReturngoosqx q=new QxReturngoosqx();
				q.setQxReturngoosqxId(THXQ.selectmaxId());
				q.setQxReturngoosqxMoney(t.getInstrumentYanshouXqMoney());
				q.setQxReturngoosqxBeizu(t.getInstrumentYanshouXqRemark());
				q.setQxReturngoosqxNumber(t.getInstrumentYanshouXqZongNum());
				THXQ.save(q);
			}
		}
		
		//清除
		public void qingc(){
			list.clear();
		}
		
		public void chchchgys(List<ThVo> list){
			for (ThVo d : list) {
			d.setSupplier(new SupplierVo(THDAO.findOne(d.getQxReturngoosId()).getSupplier().getSupplierId(),
					THDAO.findOne(d.getQxReturngoosId()).getSupplier().getSupplierName(),
					THDAO.findOne(d.getQxReturngoosId()).getSupplier().getSupplierLxr(),
					THDAO.findOne(d.getQxReturngoosId()).getSupplier().getSupplierPhone()));
			}
		}
		
	}