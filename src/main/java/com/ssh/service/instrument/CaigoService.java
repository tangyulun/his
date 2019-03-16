package com.ssh.service.instrument;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ssh.dao.jpa.drugstorage.ISupplierDao;
import com.ssh.dao.jpa.instrument.ICaigoDAO;
import com.ssh.dao.jpa.instrument.InstrumentDAO;
import com.ssh.dao.jpa.instrument.InstrumentzzDAO;
import com.ssh.dao.mybatis.instrument.InstrumentTameDao;
import com.ssh.utils.CommentOrder;
import com.ssh.pojos.DrugPurchase;
import com.ssh.pojos.DrugPurchaseDetail;
import com.ssh.pojos.Instrument;
import com.ssh.pojos.InstrumentCaigou;
import com.ssh.pojos.InstrumentCaigouXq;
import com.ssh.utils.Errors;
import com.ssh.vo.drugstorage.BuydingdanVo;
import com.ssh.vo.instrument.CgXIangqingVo;
import com.ssh.vo.instrument.InstrumentCaigouVo;
import com.ssh.vo.instrument.SupplierVo;


@Service
@Transactional
public class CaigoService {
	@Autowired
	private ICaigoDAO CIDAO;
	@Autowired
	private InstrumentTameDao TDAO;
	@Autowired
	private ISupplierDao CCA;
	//采购详情
	@Autowired
	private InstrumentzzDAO CC;
	
	@Autowired
	private InstrumentDAO IRDAO;
	
	
	private List<CgXIangqingVo> list = new ArrayList<CgXIangqingVo>();
	//单号
	public String caig(){
		return CIDAO.selectLikeNumber(CommentOrder.dateLike());
		
		
	}
	public String caigid(){
		return CIDAO.selectLikeNumberid();
		
		
	}
	
	//查询
	public List<InstrumentCaigouVo> selectInstrumencaig(int page,int rows){
		PageRequest pagee= new PageRequest(page - 1,rows);
		List<InstrumentCaigouVo> list = CIDAO.selectInstrumentcaig(pagee);
		selectinstrumencaigs(list);
		return list;

	}
	
	public void selectinstrumencaigs(List<InstrumentCaigouVo> list){
		for (InstrumentCaigouVo i : list) {
			
			i.setSupplier(new SupplierVo(CIDAO.findOne(i.getInstrumentCaigouId()).getSupplier().getSupplierId(),
					CIDAO.findOne(i.getInstrumentCaigouId()).getSupplier().getSupplierName(),
					CIDAO.findOne(i.getInstrumentCaigouId()).getSupplier().getSupplierLxr(),
					CIDAO.findOne(i.getInstrumentCaigouId()).getSupplier().getSupplierPhone()));
		}
	}
	
	
	
	public long count(){
		return CIDAO.count();
	}
	//输入框查询
	public List<InstrumentCaigouVo> selectinstrumentcaigoWhere(int page, int rows, String instrumentCaigouId) {
		PageRequest pages = new PageRequest(page - 1, rows);
		List<InstrumentCaigouVo> list = CIDAO.selectAllinstrument("%"+instrumentCaigouId+"%", pages);
		selectinstrumencaigs(list);
		return list;
		
	}
	
	
	//查询记录数
		public long selectinstrumentcaigoWhereCount(String instrumentCaigouId) {
			return CIDAO.selectinstrumentcaigoWhereCount("%"+instrumentCaigouId+"%");
		}
		
	//高级查询
		Page<?> pages ;
		public List<InstrumentCaigouVo> selectInstrument(int page, int rows, Date startTime, Date endTime, String instrumentCaigouId) {
			pages = PageHelper.startPage(page,rows);
			List<InstrumentCaigouVo> list =TDAO.selectInstrument(startTime, endTime, "".equals(instrumentCaigouId) ? null : "%"+ instrumentCaigouId + "%");
			selectinstrumencaigs(list);
			return list;
		}

		public long queryDScountI() {
			return pages.getTotal();
		}
		
		
		//点击显示
		public void InstrumentCaigou(String instrumentId,String instrumentName,BigDecimal SHULIANG,String DANWEI,BigDecimal DANJIA,BigDecimal JINE,String BEIZHU){
			CgXIangqingVo CG= new CgXIangqingVo(list.size()+1, instrumentId, instrumentName, SHULIANG, DANWEI, DANJIA, JINE, BEIZHU);
			System.out.println(CG);
			list.add(CG);
			
		}
		public List<CgXIangqingVo> selectinstrumen(){
			return list;
			
		}
		
		public void clear(){
			list= new ArrayList<>();
		}
		//新增挂单处理
		public Errors instrumentguadan(InstrumentCaigou ab,String supplierId,String state){
			try {
				if("未确定".equals(state)){
			    insertCaigou(ab, supplierId);
					
				}else{
					InstrumentCaigou a=CIDAO.findOne(ab.getInstrumentCaigouId());
					if(a!=null){
						a.setInstrumentCaigouState(state);
					}else{
						 ab.setInstrumentCaigouState(state);
						 insertCaigou(ab, supplierId); 
					}
				}
				instrumentxq(ab);
				System.out.println(ab);
				return new Errors(true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return new Errors(e.getMessage());
			}
		}
		//存在则修改不存在则新增
		private void insertCaigou(InstrumentCaigou ab, String supplierId) {
			InstrumentCaigou bb = CIDAO.findOne(ab.getInstrumentCaigouId());
			if(bb!=null){
				bb.setInstrumentCaigouMoney(ab.getInstrumentCaigouMoney());
				bb.setInstrumentCaigouGhDate(ab.getInstrumentCaigouGhDate());
				bb.setInstrumentCaigouDhDate(ab.getInstrumentCaigouDhDate());
				bb.setInstrumentCaigouAddress(ab.getInstrumentCaigouAddress());
				bb.setSupplier(CCA.findOne(supplierId));
			}else{
			ab.setSupplier(CCA.findOne(supplierId));
			CIDAO.save(ab);
		}
		}
		/**
		 * 详单记录
		 * @param dpd
		 */
		public void instrumentxq(InstrumentCaigou dax){
			InstrumentCaigou aa= CIDAO.findOne(dax.getInstrumentCaigouId());
			if(aa.getInstrumentCaigouXqs()!=null){
				CC.delete(aa.getInstrumentCaigouXqs());
			}
			
			for (CgXIangqingVo x : list) {
				InstrumentCaigouXq ax=new InstrumentCaigouXq();
				ax.setInstrumentCaigouXqId(CC.findinstrument());
				ax.setInstrumentCaigouXqMoney(x.getJINE());
				ax.setInstrumentCaigouXqNum(x.getSHULIANG());
				ax.setInstrumentCaigouXqRemark(x.getBEIZHU());
				ax.setInstrumentCaigouXqPrice(x.getDANJIA());
				ax.setInstrument(IRDAO.findOne(x.getQXCGID()));
				ax.setInstrumentCaigou(CIDAO.findOne(dax.getInstrumentCaigouId()));
				CC.save(ax);
			}
			
		}
		//删除
		
		public Errors deletextinstrument(List<Long> qx){
			for(Long q : qx){
				for(CgXIangqingVo a : list){
					if(a.getCGid() == q){
						list.remove(a);
						break;
					}
				}
			}
			return new Errors(true);
		}
		
		//计算总金额
		public double jisuanZMoney(){
			double money = 0.0;
			for (CgXIangqingVo b : list) {
				money = b.getJINE().doubleValue() + money;
			}
			return money;
		}
		
		//修改
		public void updateinstrument(CgXIangqingVo bb , int cGid) {
			for (CgXIangqingVo a : list) {
				if(a.getCGid()==cGid){
					a.setSHULIANG(bb.getSHULIANG());
					a.setBEIZHU(bb.getBEIZHU());
					a.setDANJIA(bb.getDANJIA());
					a.setJINE(bb.getJINE());
					break;
				}
				
			}
			
			
			
		}
	
		
		// 查询详表显示在table中
		public List<CgXIangqingVo> selectdingdanxq(String instrumentCaigouId){
			InstrumentCaigou dd=CIDAO.findOne(instrumentCaigouId);
			list = new ArrayList<>();
			if(dd.getInstrumentCaigouXqs() !=null){
				for (InstrumentCaigouXq d : dd.getInstrumentCaigouXqs()) {
					CgXIangqingVo ddd= new CgXIangqingVo();
					ddd.setBEIZHU(d.getInstrumentCaigouXqRemark());
					ddd.setJINE(d.getInstrumentCaigouXqMoney());
					ddd.setDANJIA(d.getInstrumentCaigouXqPrice());
					ddd.setSHULIANG(d.getInstrumentCaigouXqNum());
					ddd.setDANWEI(d.getInstrument().getUnit().getUnitsName());
					ddd.setQXCGID(d.getInstrument().getInstrumentId());
					ddd.setQXCGNAME(d.getInstrument().getInstrumentName());
					list.add(ddd);
				}
			}

			return list;
			
		}
		
	}