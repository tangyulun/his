package com.ssh.service.operation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.dao.jpa.login.LoginDao;
import com.ssh.dao.jpa.operation.JianyanDao;
import com.ssh.dao.jpa.operation.JianyanRightDao;
import com.ssh.dao.jpa.operation.JianyanTjDao;
import com.ssh.dao.jpa.operation.JianyanTypeDao;
import com.ssh.dao.jpa.operation.JianyanTypesDao;
import com.ssh.dao.jpa.operation.UnitDao;
import com.ssh.pojos.Emp;
import com.ssh.pojos.Financial;
import com.ssh.pojos.FinancialType;
import com.ssh.pojos.Jianyan;
import com.ssh.pojos.JianyanType;
import com.ssh.pojos.Unit;
import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;
import com.ssh.vo.dclass.DClassVO;
import com.ssh.vo.dept.DeptVO;
import com.ssh.vo.operation.JianyanRightVo;
import com.ssh.vo.operation.JianyanTypeVo;
import com.ssh.vo.operation.JianyanVo;
import com.ssh.vo.operation.OperationVo;
import com.ssh.vo.operation.ParentTypeVo;
import com.ssh.vo.operation.ShouShuVo;
import com.ssh.vo.outpatient.FinancialTypeVo;
import com.ssh.vo.outpatient.OutRegistVo;

@Service
@Transactional
public class JianyanTypeService {
	@Autowired
	private JianyanTypeDao jianyantypedao;
	
	@Autowired
	private JianyanTypesDao jianyantypesdao;
	
	@Autowired
	private JianyanRightDao jianyanrightdao;
	
	@Autowired
	private JianyanTjDao jianyantjdao;
	
	@Autowired
	private JianyanDao jianyandao;
	
	@Autowired
	private LoginDao logindao;
	
	@Autowired
	private UnitDao unitdao;
	
	/**
	 * 添加分类
	 * @param JianyanTypeName
	 * @return
	 */
	public Errors addJianyanType(String JianyanTypeName){
		try {
			JianyanType j = new JianyanType();
			j.setJianyanTypeId(jianyantypedao.selectIdMax());
			j.setJianyanTypeName(JianyanTypeName);
			jianyantypedao.save(j);
			return new Errors(true);
		} catch (Exception e) {
			e.printStackTrace();
			return new Errors(e.getMessage());
		}
	}
	
	/**
	 * 左边的文件夹
	 */
	public List<ParentTypeVo> selectJianyantype(){
		List<JianyanTypeVo> list=jianyantypesdao.selectJianyan();
		List<ParentTypeVo> listT = new ArrayList<>();
		listT.add(new ParentTypeVo(1 , "检验项目分类" , list));
		return listT;
	}
	
	/**
	 * 查询数据库表格
	 * @return
	 */
	public List<JianyanVo> selectJianyanRight(int page , int rows){
		PageRequest pages = new PageRequest(page -1, rows);
		List<JianyanVo> list =  jianyandao.selectJianyanRight(pages);
		selectrightOo(list);
		return list;
		
	}
	/**
	 * 外键
	 * @param list
	 */
	private void selectrightOo(List<JianyanVo> list){
		for (JianyanVo o:list){
			o.setJianyantype(new JianyanTypeVo(
					jianyandao.findOne(o.getJianyanId()).getJianyanType().getJianyanTypeId()
					, jianyandao.findOne(o.getJianyanId()).getJianyanType().getJianyanTypeName()));
			
		}
	}
	
	public long count(){
		return jianyanrightdao.count();
	}
	
	
	/**
	 * 查询检验分类
	 * @return
	 */
	public List<JianyanTypeVo> SelectJianyanFenlei(){
		return jianyantypedao.queryJianyanTypeWhere();
	}
	/**
	 * 添加检验项目
	 * @param jianyan
	 * @return
	 */
	public Errors addJianyanTj(Jianyan jianyan,Long empId,Long jianyanTypeId){
		
		try {
			Emp emp=logindao.findOne(empId);
			JianyanType jianyantype=jianyantypedao.findOne(jianyanTypeId);
			
			jianyan.setEmp(emp);
			jianyan.setJianyanType(jianyantype);
			
			jianyanrightdao.save(jianyan);
			System.out.println(jianyan.toString());
			return new Errors(true);
		} catch (Exception e) {
			e.printStackTrace();
			return new Errors(e.getMessage());
		}
	}
	
	public long findByMaxId(){
		return jianyanrightdao.fingByMaxId();
	}
	
	
	/**
	 * 生成添加体检号
	 * @return
	 */
	public String jianyanTj(){
		return jianyantjdao.selectJianyantj();
		
	}
	
	/**
	 * 点击ul，刷新数据表格
	 * @param page
	 * @param rows
	 * @param jianyantypeid
	 * @return
	 */
	public List<JianyanVo> QueryJianyanId(int page,int rows,long jianyantypeid){
		JianyanType jy=jianyantypedao.findOne(jianyantypeid);
		List<JianyanVo> list = jianyandao.findJianyanType(jy, new PageRequest(page -1,rows));
		selectrightOo(list);
		return 	list;
	}
	
	public long findJianyanTypeCount(long jianyantypeid){
		JianyanType jy=jianyantypedao.findOne(jianyantypeid);
		return jianyandao.findJianyanTypeCount(jy);
	}
	/**
	 * 根据检验名称查询
	 * @param page
	 * @param rows
	 * @param JianyanName
	 * @return
	 */
	public List<JianyanVo> selectJianyanNameWhere(int page,int rows,String jianyanName){
		PageRequest pages= new PageRequest(page-1,rows);
		List<JianyanVo> list =  jianyandao.selectJianyanNameWhere("%"+jianyanName+"%" , pages);
		selectrightOo(list);
		return list;
	}
	/**
	 * 查询记录
	 * @param deptFuzeName
	 * @return
	 */
	public long selectJianyanNameCount(String jianyanName) {
		return jianyandao.selectJianyanNameCount("%"+jianyanName+"%");
	}
	
	/**
	 * 修改检验项目
	 * @param jianyan
	 * @param jianyanId
	 * @param jianyanTypeId
	 * @return
	 */
	public Errors updateJianyan(Jianyan jianyan,String jianyanId , String jianyanTypeId){
		try {
			Jianyan j = jianyandao.findOne(jianyanId);
			JianyanType jt=jianyantypesdao.findOne(jianyanTypeId);
			j.setJianyanBetween(jianyan.getJianyanBetween());
			j.setJianyanCreateDate(jianyan.getJianyanCreateDate());
			j.setJianyanName(jianyan.getJianyanName());
			j.setJianyanId(jianyan.getJianyanId());
			j.setJianyanRemark(jianyan.getJianyanRemark());
			j.setJianyanType(jt);
			return new Errors(true);
		} catch (Exception e) {
			e.printStackTrace();
			return new Errors(e.getMessage());
		}
		
	}
	/**
	 * 修改检验分类ul
	 * @param jianyanTypeId
	 * @param jianyanTypeName
	 * @return
	 */
	public Errors updateJianyanUl(Long jianyanTypeId , String jianyanTypeName){
		try {
			JianyanType j = jianyantypedao.findOne(jianyanTypeId);
			j.setJianyanTypeName(jianyanTypeName);
			
			j.setJianyanTypeId(jianyanTypeId);
			return new Errors(true);
		} catch (Exception e) {
			e.printStackTrace();
			return new Errors(e.getMessage());
		}
		
	}
}