package com.ssh.service.operation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.dao.jpa.behospitalized.IHospitalRegistrationDAO;
import com.ssh.dao.jpa.dclass.IDClassDAO;
import com.ssh.dao.jpa.login.LoginDao;
import com.ssh.dao.jpa.operation.DclassDao;
import com.ssh.dao.jpa.operation.SelectFinancialDao;
import com.ssh.dao.jpa.operation.ShouShuDao;
import com.ssh.dao.jpa.operation.ShouShuMessDao;
import com.ssh.dao.jpa.operation.ShouShuTypeDao;
import com.ssh.dao.jpa.operation.ShouShuXqDao;
import com.ssh.dao.jpa.operation.SugeryFlDao;
import com.ssh.pojos.Dclass;
import com.ssh.pojos.Emp;
import com.ssh.pojos.FinancialHistory;
import com.ssh.pojos.HospitalRegistration;
import com.ssh.pojos.OutpaitentRegist;
import com.ssh.pojos.Shoushu;
import com.ssh.pojos.ShoushuMess;
import com.ssh.pojos.ShoushuMessXq;
import com.ssh.pojos.ShoushuType;
import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;
import com.ssh.vo.login.EmpVo;
import com.ssh.vo.operation.DclasssVo;
import com.ssh.vo.operation.EmpsVo;
import com.ssh.vo.operation.JianyanXmVo;
import com.ssh.vo.operation.SelectFinanVo;
import com.ssh.vo.operation.ShouShuTypeVo;
import com.ssh.vo.operation.ShouShuVo;
import com.ssh.vo.operation.ShouShuXmVo;
import com.ssh.vo.operation.ShoushuChuanzhiVo;
import com.ssh.vo.operation.SurgeryTypeVo;
@Service
@Transactional
public class SugeryService {
		@Autowired
		private ShouShuTypeDao sstypedao;
		
		@Autowired
		private SugeryFlDao sydao;
		
		@Autowired
		private ShouShuDao ssdao;
		
		@Autowired
		private LoginDao logindao;
		
		@Autowired
		private IDClassDAO dclassdao;
		
		@Autowired
		private ShouShuMessDao ssmessdao;
		
		@Autowired
		private IHospitalRegistrationDAO hospitaldao;
		
		@Autowired
		private SelectFinancialDao selectfinancialdao;
		
		@Autowired
		private ShouShuXqDao shoushuxqdao;
		
		@Autowired
		private DclassDao dclassadao;
		
		private List<ShoushuChuanzhiVo> list=new ArrayList<>();
		
	/**
	 * 添加手术分类
	 * @param shoushuTypeName
	 * @return
	 */
	public Errors selectAddss(String shoushuTypeName){
		try {
			ShoushuType s = new ShoushuType();
			s.setShoushuTypeId(sstypedao.selectAddfl());
			s.setShoushuTypeName(shoushuTypeName);
			sstypedao.save(s);
			return new Errors(true);
		} catch (Exception e) {
			e.printStackTrace();
			return new Errors(e.getMessage());
		}
	}
	
	/**
	 * 左边的文件夹
	 */
	public List<SurgeryTypeVo> selectshoushutype(){
		List<ShouShuTypeVo> list=sstypedao.selectshoushu();
		List<SurgeryTypeVo> listb = new ArrayList<>();
		listb.add(new SurgeryTypeVo(1,"手术项目分类",list));
		return listb;
	}
	
	/**
	 * 验证手术分类是否存在的
	 * @param shoushuTypeName
	 * @return
	 */
	public Errors sugeryflclassName(String shoushuTypeName){
		ShoushuType ss =sydao.sugeryflclassName(shoushuTypeName);
		return ss== null ? new Errors(true) : new Errors();
	}
	
	/**
	 * 生成添加手术号
	 * @return
	 */
	public String selectSugeryTjbh(){
		return ssdao.selectSugeryTjbh();
		
	}
	/**
	 * 查询检验分类
	 * @return
	 */
	public List<ShouShuTypeVo> SelectSugeryIdFl(){
		return sstypedao.SelectSugeryIdFl();
	}
	/**
	 * 查询数据库表格
	 * @return
	 */
	public List<ShouShuVo> selectShoushuRight(int page , int rows){
		PageRequest pages = new PageRequest(page -1, rows);
		List<ShouShuVo> list =  ssdao.selectShoushuRight(pages);
		selectsugeryright(list);
		return list;
		
	}
	
	public long count(){
		return ssdao.count();
	}
	/**
	 * 外键
	 * @param list
	 */
	public void selectsugeryright(List<ShouShuVo> list){
		for (ShouShuVo s:list){
			Dclass d = ssdao.findOne(s.getShoushuId()).getDclass();
			if(d != null){
				s.setDclass(new DclasssVo(d.getDclassId(), d.getDclassName()));
			}
			ShoushuType dd=ssdao.findOne(s.getShoushuId()).getShoushuTypeBean();
			if(dd !=null){
				s.setShoushuTypeBean(new ShouShuTypeVo(dd.getShoushuTypeId(),dd.getShoushuTypeName()));
			}
			Emp ee=ssdao.findOne(s.getShoushuId()).getEmp();
			if(ee !=null){
				s.setEmp(new EmpsVo(ee.getEmpId(),ee.getEmpName()));
			}
		}
	}
	/**
	 * 添加手术项目
	 * @param Shoushu
	 * @return
	 */
	public Errors addShoushuxm(Shoushu shoushu,Long empId,Long dclassId,Long shoushuTypeId){
		
		try {
			Emp emp=logindao.findOne(empId);
			Dclass dclass=dclassdao.findOne(dclassId);	
			ShoushuType shoushuType=sstypedao.findOne(shoushuTypeId);
			shoushu.setEmp(emp);
			shoushu.setDclass(dclass);
			shoushu.setShoushuTypeBean(shoushuType);
			ssdao.save(shoushu);
			System.out.println(shoushu);
			return new Errors(true);
		} catch (Exception e) {
			e.printStackTrace();
			return new Errors(e.getMessage());
		}
	}
	
	public long findByMaxId(){
		return ssdao.addShoushuxm();
	}
	/**
	 * 修改手术项目
	 * @param shoushu
	 * @param shoushuId
	 * @param shoushuTypeId
	 * @return
	 */
	public Errors updateSugery(Shoushu shoushu,String shoushuId,Long shoushuTypeId){
		try {
			Shoushu s = ssdao.findOne(shoushuId);
			ShoushuType stype = sydao.findOne(shoushuTypeId);
			s.setShoushuExplain(shoushu.getShoushuExplain());
			s.setShoushuId(shoushu.getShoushuId());
			s.setShoushuName(shoushu.getShoushuName());
			s.setShoushuRemark(shoushu.getShoushuRemark());
			s.setShoushuType(shoushu.getShoushuType());
			s.setShoushuTypeBean(stype);
			return new Errors(true);
		} catch (Exception e) {
			e.printStackTrace();
			return new Errors(e.getMessage());
		}
	}
	
	/**
	 *  根据手术名称查询
	 * @param page
	 * @param rows
	 * @param shoushuName
	 * @return
	 */
	public List<ShouShuVo> selectShoushuNameWhere(int page,int rows,String shoushuName){
		PageRequest pages= new PageRequest(page-1,rows);
		List<ShouShuVo> list =  ssdao.selectShoushuNameWhere("%"+shoushuName+"%", pages);
		selectsugeryright(list);
		return list;
	}
	/**
	 * 查询记录
	 * @param shoushuName
	 * @return
	 */
	public long selectShoushusNameCount(String shoushuName) {
		return ssdao.selectShoushusNameCount("%"+shoushuName+"%");
	}
	
	/**
	 * 点击左边ul，刷新右边数据库格
	 * @param page
	 * @param rows
	 * @param shoushuTypeId
	 * @return
	 */	
	public List<ShouShuVo> findShoushuTypeId(int page,int rows,Long shoushuTypeId){
		ShoushuType sy=sstypedao.findOne(shoushuTypeId);
		List<ShouShuVo> list = ssdao.findShoushuType(sy, new PageRequest(page -1,rows));
		selectsugeryright(list);
		return 	list;
	}
	
	public long findShoushuTypeCount(Long shoushuTypeId){
		ShoushuType jy=sstypedao.findOne(shoushuTypeId);
		return ssdao.findShoushuTypeCount(jy);
	}
	/**
	 * 添加挂单
	 * @param ShoushuMess
	 * @param dclassId
	 * @param hospitalRegistrationId
	 * @return
	 */
	public Errors addShoushuGd(String state,ShoushuMess shoushuMess,Long empId,String hospitalRegistrationId,String shoushuId){
		try {
			
			if (shoushuMess !=null) {
				ShoushuMess s =ssmessdao.findOne(shoushuMess.getShoushuMess());
				if (s!=null) {
					s.setShoushuMessState(state);
				}else{
					Emp emp = logindao.findOne(empId);
					HospitalRegistration hospital = hospitaldao.findOne(hospitalRegistrationId);
					Shoushu shoushu=ssdao.findOne(shoushuId);
					shoushuMess.setEmp(emp);
					shoushuMess.setHospitalRegistration(hospital);
					shoushuMess.setShoushu(shoushu);
					shoushuMess.setShoushuMessState(state);
					ssmessdao.save(shoushuMess);
				}
			}
			//调用
			addShoushuxiangqing(shoushuMess, hospitalRegistrationId);
			return new Errors(true);
		} catch (Exception e) {
			return new Errors(e.getMessage());
		}
	
	}
	/**
	 * 添加挂单调用dao层的方法
	 * @return
	 */
	public String addShoushuGd(){
		return ssmessdao.addShoushuGd(CommentOrder.dateLike());
	}
	
	
	/**
	 * 手术主页面查询收费记录表格
	 * @param page
	 * @param rows
	 * @return
	 */
	public List<SelectFinanVo> selectfinan(int page , int rows){
		PageRequest pages = new PageRequest(page -1, rows);
		List<SelectFinanVo> list =  selectfinancialdao.selectfinanialbiao(pages);
		return list;
		
	}
	
	public long countb(){
		return selectfinancialdao.count();
	}
	
	/**
	 * 编辑左边ul
	 * @param shoushuTypeId
	 * @param shoushuTypeName
	 * @return
	 */
	public Errors updateShoushuUl(Long shoushuTypeId , String shoushuTypeName){
			try {
				ShoushuType s = sstypedao.findOne(shoushuTypeId);
				s.setShoushuTypeName(shoushuTypeName);
				s.setShoushuTypeId(shoushuTypeId);
				return new Errors(true);
			} catch (Exception e) {
				e.printStackTrace();
				return new Errors(e.getMessage());
			}
			
	}
	
	/**
	 * 手术主页面点击住院号传值到下面手术治疗表格中
	 * @param hospitalRegistrationId
	 * @return
	 */
	public 	List<ShoushuChuanzhiVo> SelectChuanZhi(String hospitalRegistrationId){
		list = new ArrayList<>();
		HospitalRegistration h=hospitaldao.findOne(hospitalRegistrationId);
			
			OutpaitentRegist o=h.getHospitaNotify().getOutpaitentRegist();

			if (o.getFinancialHistories()!=null) {
				for(FinancialHistory f :o.getFinancialHistories()){
					if("手术费".equals(f.getFinancial().getFinancialTypeBean().getFinancialTypeName())){
						list.add(new ShoushuChuanzhiVo(list.size()+1,
								f.getFinancial().getFinancialId(),
								f.getFinancial().getFinancialName(),f.getFinancial().getFinancialType(),
								f.getFinancialHistoryNum(),f.getFinancial().getFinancialPrice(),"",f.getFinancial().getFinancialMoney()));
						break;
					}
					
				}
			}
			return list;
	}
	/**
	 * 修改手术结果
	 * @param Ssid
	 * @param SsName
	 * @param Ssleixing
	 * @param Shuliang
	 * @param Danjia
	 * @param jieguo
	 * @param Jine
	 */
	public void UpdateShouShuBianji(int id,String jieguo){
			if(list!=null){
				for(ShoushuChuanzhiVo s:list){
					if(s.getId()==id){
						s.setJieguo(jieguo);
						System.err.println("ok");
					}
				}
			}
	}
	
	//查
	public List<ShoushuChuanzhiVo> selectShoushuBianji(){
		return list;
	}
	
	/**
	 * 判断是否为已处理未处理
	 * @param hospitalRegistrationId
	 * @return
	 */
	public Errors SelectShoushuPanduan(String hospitalRegistrationId){
		try {
			HospitalRegistration h=hospitaldao.findOne(hospitalRegistrationId);
				if (h.getShoushuMesses().isEmpty()) {
					return new Errors(true);
				}
			} catch (Exception e) {
				// TODO: handle exception
				return new Errors(e.getMessage());
			}
			return new Errors();
	}
	
	/**
	 * 新增草拟吗
	 * @param shoushuMess
	 * @param hospitalRegistrationId
	 */
	public void addShoushuxiangqing(ShoushuMess shoushuMess,String hospitalRegistrationId){
		ShoushuMess s=ssmessdao.findOne(shoushuMess.getShoushuMess());
		System.out.println(list.size());
		for(ShoushuChuanzhiVo sv: list){
			System.err.println(shoushuMess.getShoushuMess());
			ShoushuMessXq sxq=new ShoushuMessXq();
			sxq.setShoushuMessBean(s);
			sxq.setShoushuMessXqId(shoushuxqdao.maxId());
			sxq.setShoushuMessXqMoney(sv.getJine());
			sxq.setShoushuMessXqName(sv.getSsName());
			sxq.setShoushuMessXqNum(sv.getShuliang());
			sxq.setShoushuMessXqPrice(sv.getDanjia());
			sxq.setShoushuMessXqResult(sv.getJieguo());
			sxq.setShoushuMessXqType(sv.getSsleixing());
			shoushuxqdao.save(sxq);
			System.err.println(sxq+"1233354");
		}
	}
}
