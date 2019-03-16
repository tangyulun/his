package com.ssh.service.operation;

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
import com.ssh.dao.jpa.behospitalized.IHospitalRegistrationDAO;
import com.ssh.dao.jpa.behospitalized.IOutpaitentRegistDAO;
import com.ssh.dao.jpa.login.LoginDao;
import com.ssh.dao.jpa.operation.JianyanDao;
import com.ssh.dao.jpa.operation.JianyanMessDao;
import com.ssh.dao.jpa.operation.JianyanMessXqDao;
import com.ssh.dao.jpa.outpatient.IOutpaitentDAO;
import com.ssh.dao.mybatis.operation.TimeMessDao;
import com.ssh.pojos.Emp;
import com.ssh.pojos.FinancialHistory;
import com.ssh.pojos.HospitaNotify;
import com.ssh.pojos.HospitalRegistration;
import com.ssh.pojos.InstrumentCaigouXq;
import com.ssh.pojos.Jianyan;
import com.ssh.pojos.JianyanMess;
import com.ssh.pojos.JianyanMessXq;
import com.ssh.pojos.OutpaitentRegist;
import com.ssh.pojos.ShoushuMess;
import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;
import com.ssh.vo.behospitalized.HospitalRegistrationVo;
import com.ssh.vo.drugstorage.PandianVo;
import com.ssh.vo.instrument.YanshoxiangqingVo;
import com.ssh.vo.operation.JianyanMessVo;
import com.ssh.vo.operation.JianyanMessXqVo;
import com.ssh.vo.operation.JianyanTypeVo;
import com.ssh.vo.operation.JianyanVo;
import com.ssh.vo.operation.JianyanXmVo;
import com.ssh.vo.operation.OutpaitentRegistVo;

@Service
@Transactional
public class JianyanMessService {
		@Autowired
		private JianyanMessDao jianyanmessdao;
		
		@Autowired
		private TimeMessDao timemessdao;
		
		@Autowired
		private LoginDao logindao;
		
		@Autowired
		private IOutpaitentDAO ioutpaitendao;
		
		@Autowired
		private JianyanMessXqDao jianyanmessxqdao;
		
		@Autowired
		private JianyanDao jianyandao;
		
		@Autowired
		private IOutpaitentDAO ioutpaitentdao;
		
		@Autowired
		private IHospitalRegistrationDAO hospitalreigstrationdao;
		
		@Autowired
		private  IOutpaitentRegistDAO registdao;
		
		private List<JianyanXmVo> list=new ArrayList<>();
		/**
		 * 检验页面打开里面数据
		 * @param page
		 * @param rows
		 * @return
		 */
		public List<JianyanMessVo> selectJianyanMess(int page, int rows){
			PageRequest pt=new PageRequest(page -1, rows);
			return jianyanmessdao.selectJianyanMess(pt);
		}
		
		public long count(){
			return jianyanmessdao.count();
		}
		
		/**
		 * 通过编号查询
		 * @param page
		 * @param rows
		 * @param jianyanMessId
		 * @return
		 */
		public List<JianyanMessVo> selectJianyanMessId(int page, int rows,String jianyanMessId){
			PageRequest pt=new PageRequest(page -1, rows);
			return jianyanmessdao.selectJianyanMessId("%"+jianyanMessId+"%", pt);
		}
		
		public long selectJianyanMessCount(String jianyanMessId){
			return jianyanmessdao.selectJianyanMessCount("%"+jianyanMessId+"%");
		}
		
		/**
		 * 高级查询
		 */
		Page<?> pages ;
		public List<JianyanMessVo> selectMessTime(int page,int rows,Date firstTime,Date endTime,String jianyanMessId){
			pages = PageHelper.startPage(page,rows);
			return timemessdao.selectMessTime(firstTime, endTime,"".equals(jianyanMessId) ? null:"%"+jianyanMessId+"%");
		}
		
		public long jianyanMessTimecount() {
			return pages.getTotal();
		}
		
		
		/**
		 * 添加挂单
		 * @param JianyanMess
		 * @param dclassId
		 * @param hospitalRegistrationId
		 * @return
		 */
		public Errors addjianyanGuadan(String state,JianyanMess jianyanMess,Long empId,String outpaitentRegistId){
			try {
				if (jianyanMess !=null) {
					JianyanMess j = jianyanmessdao.findOne(jianyanMess.getJianyanMessId());
					if (j !=null) {
						j.setJianyanMessState("已确定");
					}else {
						Emp emp = logindao.findOne(empId);
						OutpaitentRegist outpaiten = ioutpaitendao.findOne(outpaitentRegistId);
						jianyanMess.setEmp(emp);
						jianyanMess.setOutpaitentRegist(outpaiten);
						jianyanMess.setJianyanMessState(state);
						jianyanmessdao.save(jianyanMess);
					}
				}
				//调用
				addtijianxiangqing(jianyanMess , outpaitentRegistId);
				return new Errors(true);
			} catch (Exception e) {
				return new Errors(e.getMessage());
			}
			
		}
		/**
		 * 添加挂单调用dao层的方法
		 * @return
		 */
		public String addjianyanGuadan(){
			return jianyanmessdao.addjianyanGuadan(CommentOrder.dateLike());
		}
		
		
		/**
		 * 检验详情表添加加入
		 * @param jianyanmeessxq
		 * @param jianyanId
		 * @param jianyanMessId
		 * @return
		 */
		public Errors addJianyanMessXq(JianyanMessXq jianyanmeessxq,String jianyanId,String jianyanMessId){
				try {
					Jianyan jy = jianyandao.findOne(jianyanId);
					JianyanMess jymess = jianyanmessdao.findOne(jianyanMessId);
					jianyanmeessxq.setJianyan(jy);
					jianyanmeessxq.setJianyanMess(jymess);
					jianyanmessxqdao.save(jianyanmeessxq);
					return new Errors(true);
				} catch (Exception e) {
					return new Errors(e.getMessage());
				}
				
		}
		
		/**
		 * 检验详情外键
		 * @param list
		 */
		private void selectJyMessXq(List<JianyanMessXqVo> list){
			for (JianyanMessXqVo jy:list){
				
				jy.setJianyan(new JianyanVo(jianyanmessxqdao.findOne(jy.getJianyanMessXqId()).getJianyan().getJianyanId(),
						jianyanmessxqdao.findOne(jy.getJianyanMessXqId()).getJianyan().getJianyanName()));
			}
		}
		
		public long cosunt(){
			return jianyanmessdao.count();
		}
		/**
		 * 查询检验详情
		 * @param page
		 * @param rows
		 * @return
		 */
		public List<JianyanMessXqVo> selectJianyanMessXq(){
			return jianyanmessdao.selectJianyanMessXq();
		}
		
	
		/**
		 * 检验项目门诊点收费
		 * @param outpaitentRegistId
		 * @return
		 */
		public List<JianyanXmVo> selectAllMenzhen(String outpaitentRegistId){
			OutpaitentRegist o= ioutpaitentdao.findOne(outpaitentRegistId);
			System.err.println(o);
			if(o.getFinancialHistories() == null){
				o.setFinancialHistories(new ArrayList<>());
			}
			List<FinancialHistory>  list2 = o.getFinancialHistories();
			list = new ArrayList<>();
			for (FinancialHistory f : list2) {
			
				if("体检费".equals(f.getFinancial().getFinancialTypeBean().getFinancialTypeName())){
					System.err.println(f.getFinancial().getFinancialName());
					JianyanXmVo jx = new JianyanXmVo(list.size()+1,
							f.getFinancial().getFinancialId(), f.getFinancial().getFinancialName(), 
							null, null, null, null);
					
					list.add(jx);
				}
			}
			return list;
		}
		
		
		/**
		 * 清除
		 */
		public void clear(){
			list.clear();
		}
		
		/**
		 * 新增草拟吗
		 * @param outpaitentRegistId 
		 * @param jianyan
		 */
		public void addtijianxiangqing(JianyanMess jianyanmess, String outpaitentRegistId){			
			JianyanMess j=jianyanmessdao.findOne(jianyanmess.getJianyanMessId());
			System.err.println(j);
			System.out.println(list.size());
			for (JianyanXmVo jv : list) {
				System.out.println(jv);
			
				System.err.println(jianyanmess.getJianyanMessId());
				JianyanMessXq jxq=new JianyanMessXq();
				jxq.setJianyanMess(j);
				jxq.setJianyanMessXq(jv.getYichang());
				jxq.setJianyanMessXqBetween(jv.getCsfw());
				jxq.setJianyanMessXqResult(jv.getJiegao());
				jxq.setJianyanMessXqId(jianyanmessxqdao.maxId());
				jianyanmessxqdao.save(jxq);
				System.err.println(jxq);
			}
		}
	
		
		/**
		 * 编辑
		 * @return
		 */
		public void UpdapteJianyanBianji(int id,String csfw,String jiegao,String yichang){
				if(list!=null){
					for(JianyanXmVo j:list){
							if(j.getId()==id){
									j.setCsfw(csfw);
									j.setJiegao(jiegao);
									j.setYichang(yichang);
									
									System.err.println("ok");								
							}
					}
				}
			}
		//查
		public List<JianyanXmVo> selectBianjiJianyanXm(){
			return list;
			
		}
		
		/**
		 * 判断
		 * @param outpaitentRegistId
		 * @return
		 */
		public Errors SelectJianyanMenzhen(String outpaitentRegistId){
			try {
				OutpaitentRegist o = registdao.findOne(outpaitentRegistId);
				if (o.getJianyanMesses().isEmpty()) {
					return new Errors(true);
				}
			} catch (Exception e) {
				// TODO: handle exception
				return new Errors(e.getMessage());
			}
			return new Errors();
			
		}
}
