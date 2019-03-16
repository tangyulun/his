package com.ssh.service.instrument;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ssh.dao.jpa.instrument.ICaigoDAO;
import com.ssh.dao.jpa.instrument.InstrumentDAO;
import com.ssh.dao.jpa.instrument.YanshoDao;
import com.ssh.dao.jpa.instrument.YanshoxqingqingDAO;
import com.ssh.dao.mybatis.instrument.InstrumentYanshiTimeDAO;
import com.ssh.pojos.DrugDelivery;
import com.ssh.pojos.DrugDeliveryDetali;
import com.ssh.pojos.DrugPurchase;
import com.ssh.pojos.DrugPurchaseDetail;
import com.ssh.pojos.Instrument;
import com.ssh.pojos.InstrumentCaigou;
import com.ssh.pojos.InstrumentCaigouXq;
import com.ssh.pojos.InstrumentY;
import com.ssh.pojos.InstrumentYanshouXq;
import com.ssh.pojos.Supplier;
import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;
import com.ssh.vo.drugstorage.AcceptanceVo;
import com.ssh.vo.drugstorage.DrugPurchaseVo;
import com.ssh.vo.drugstorage.RukuXqVo;
import com.ssh.vo.drugstorage.YanshouVo;
import com.ssh.vo.instrument.CgXIangqingVo;
import com.ssh.vo.instrument.InstrumentCaigouVo;
import com.ssh.vo.instrument.InstrumentYanshoxiangqiangVo;
import com.ssh.vo.instrument.QixieYanshoVO;
import com.ssh.vo.instrument.SupplierVo;
import com.ssh.vo.instrument.YanshoVo;
import com.ssh.vo.instrument.YanshoxiangqingVo;
import com.ssh.vo.instrument.ZyanshoxqVo;
import com.ssh.vo.staff.EmpVO;

import javassist.expr.NewArray;

@Service
@Transactional
public class YanshoService {
	@Autowired
	private YanshoDao YANDAO;
	@Autowired
	private ICaigoDAO CIDAO;
	@Autowired
	private YanshoxqingqingDAO BA;
	@Autowired
	private InstrumentDAO ISDao;
	@Autowired
	private InstrumentYanshiTimeDAO Tdao;
	private List<YanshoxiangqingVo> list= new ArrayList<YanshoxiangqingVo>();
	
	public String yaig(){
		return YANDAO.selectLikeNumber(CommentOrder.dateLike());
	}
	
	
	
	//传到table
	public List<YanshoxiangqingVo> slelectqxxq(String instrumentYsId){
		clear();
		if(instrumentYsId !=null){
			InstrumentCaigou qx=CIDAO.findOne(instrumentYsId);
			if(qx.getInstrumentCaigouXqs() != null){
				for (InstrumentCaigouXq d : qx.getInstrumentCaigouXqs()) {
					YanshoxiangqingVo ys=new YanshoxiangqingVo();
					ys.setBEIZHU(d.getInstrumentCaigouXqRemark());
					ys.setJINE(d.getInstrumentCaigouXqMoney());
					ys.setDANJIA(d.getInstrumentCaigouXqPrice());
					ys.setSHULIANG(d.getInstrumentCaigouXqNum());
					ys.setHEGESHU(d.getInstrumentCaigouXqNum());
					ys.setCGid(list.size()+1);
					ys.setQXCGNAME(d.getInstrument().getInstrumentName());
					ys.setQXCGID(d.getInstrument().getInstrumentId());
					ys.setDANWEI(d.getInstrument().getUnit().getUnitsName());
					list.add(ys);
				}
			}
		}
		return list;
	}

	//挂单处理
	public Errors instrumentyans(InstrumentY ak, String instrumentCaigouId){
		try {
			InstrumentCaigou ins = CIDAO.findOne(instrumentCaigouId);
			ak.setInstrumentCaigou(ins);
			ak.setInstrumentYsState("已验收");
			ak.setInstrumentYsDate(new Date());
			ins.setInstrumentCaigouState("已验收");
			YANDAO.save(ak);
			insertrukuxq(ak);
			return new Errors(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Errors(e.getMessage());
		}
		
	}
	public void insertrukuxq(InstrumentY ak){
		for (YanshoxiangqingVo k : list) {
			InstrumentYanshouXq ka=new InstrumentYanshouXq();
			ka.setInstrumentYanshouXqId(BA.maxId());
			ka.setInstrumentYanshouXqRemark(k.getBEIZHU());
			ka.setInstrumentYanshouXqZongNum(k.getSHULIANG());
			ka.setInstrumentYanshouXqBhgeNum(new BigDecimal(0));
			ka.setInstrumentYanshouXqHegeNum(k.getHEGESHU());
			ka.setInstrumentYanshouXqMoney(k.getJINE());
			ka.setInstrumentYsId(ak.getInstrumentYsId());
			ka.setInstrumentId(k.getQXCGID());
			ka.setInstrumentYanshouXqBhgeNum(new BigDecimal( ka.getInstrumentYanshouXqZongNum().intValue()
					- ka.getInstrumentYanshouXqHegeNum().intValue()));
			BA.save(ka);
		}
	}
	
	
	
	//修改
	public void updateinstrument(int cGid, BigDecimal hEGESHU) {
		System.err.println("欧阳皮"+hEGESHU);
		if(list != null){
			for (YanshoxiangqingVo y : list) {
				System.err.println("欧阳皮"+y.getSHULIANG());
				if(y.getCGid() == cGid){
					y.setHEGESHU(hEGESHU);
					if(hEGESHU.intValue() > y.getSHULIANG().intValue()){
						y.setHEGESHU(y.getSHULIANG());
					}
					if(hEGESHU.intValue() <0){
						y.setHEGESHU(new BigDecimal(0));
					}
					y.setBHEGESHU(new BigDecimal(y.getSHULIANG().intValue() - y.getHEGESHU().intValue()));
					y.setJINE(new BigDecimal(y.getHEGESHU().intValue() * y.getDANJIA().intValue()));
					
					break;
				}
			}
		}
	}
	
	
	public List<YanshoxiangqingVo> selectyanshoo(){
		return list;
		
	}
	
	
	
	
	public void clear(){
		list.clear();
	}
	
	//查询验收记录
	public List<YanshoVo> selectJilu(int page,int rows){
		PageRequest pages=new PageRequest(page-1, rows);
		List<YanshoVo> list=YANDAO.selectyansho(pages);
		chchch(list);
		return list;
	}
	
	
	
	//查询验收记录加供应商
	public List<YanshoVo> selectJiluandgys(int page,int rows){
		PageRequest pages=new PageRequest(page-1, rows);
		List<YanshoVo> list=YANDAO.selectyansho(pages);
		chchch(list);
		return list;
	}
	
	
	public void chchch(List<YanshoVo> list){
		for (YanshoVo d : list) {
			System.err.println(d.getInstrumentYsId());
			System.err.println(YANDAO.findOne(d.getInstrumentYsId()));
		d.setSupplier(new SupplierVo(YANDAO.findOne(d.getInstrumentYsId()).getInstrumentCaigou().getSupplier().getSupplierId(),
					YANDAO.findOne(d.getInstrumentYsId()).getInstrumentCaigou().getSupplier().getSupplierName(),
					YANDAO.findOne(d.getInstrumentYsId()).getInstrumentCaigou().getSupplier().getSupplierLxr(),
					YANDAO.findOne(d.getInstrumentYsId()).getInstrumentCaigou().getSupplier().getSupplierPhone()));
		}
	}

	public long count() {
		return YANDAO.count();
	}
	
	
	//输入框查询
		public List<YanshoVo> selectinstrumentcaigoWhereys(int page, int rows, String instrumentYsId) {
			PageRequest pages = new PageRequest(page - 1, rows);
			List<YanshoVo> list = YANDAO.selectAllinstrumentys("%"+instrumentYsId+"%", pages);
			return list;
			
		}
	
		//查询记录数
				public long selectinstrumentcaigoWhereCountys(String instrumentYsId) {
					return YANDAO.selectinstrumentcaigoWhereCountys("%"+instrumentYsId+"%");
				}
				
				//高级查询
		Page<?> pages ;
		public List<YanshoVo> selectInstrumentys(int page, int rows, Date startTime, Date endTime, String instrumentYsId) {
			pages = PageHelper.startPage(page,rows);
			List<YanshoVo> list =Tdao.selectInstrumentystiem(startTime, endTime, "".equals(instrumentYsId) ? null : "%"+ instrumentYsId + "%");
			chchch(list);
			return list;
				}
		
		public long queryDScountI() {
			return pages.getTotal();
		}
		/**
		 * 查询不合格的验收记录
		 * @param page
		 * @param rows
		 * @return
		 *//*
		public List<YanshoVo> selectNohegeJilu(int page,int rows){
			PageRequest pages=new PageRequest(page-1, rows);
			List<YanshoVo> list=YANDAO.selectNohegeJilu(pages);
			for (AcceptanceVo a : list) {
				a.setDrugAcceptanceZt("待退货");
				DrugPurchase d = IPDao.findOne(IADao.findOne(a.getDrugAcceptanceId()).getDrugPurchase().getDrugPurchaseId());
				a.setDrugPurchase(new DrugPurchaseVo(d.getDrugPurchaseId(),
						new SupplierVo(d.getSupplier().getSupplierId(), 
								d.getSupplier().getSupplierName(),
								d.getSupplier().getSupplierLxr(),
								d.getSupplier().getSupplierPhone())));
			}
			return list;
		}*/
		
		
		public List<YanshoVo> selectyanshoTuihuo(){
			List<YanshoVo> list =YANDAO.selectyanshoww();
			List<YanshoVo> list2 = new ArrayList<>();
			for (YanshoVo Ut : list) {
				List<InstrumentYanshoxiangqiangVo> list1= BA.selecttablew(Ut.getInstrumentYsId());
				if(!list1.isEmpty() && !"已退货".equals(Ut.getInstrumentYsState())){
					list2.add(new YanshoVo(Ut.getInstrumentYsId(), Ut.getInstrumentYsDate(),
							Ut.getInstrumentYsPzdh(), Ut.getInstrumentYsState()));
				}
			}
			chchch(list2);
			return list2;
		}
		
		
		
		
		
		
		
	
}