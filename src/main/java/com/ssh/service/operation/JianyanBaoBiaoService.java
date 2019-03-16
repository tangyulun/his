package com.ssh.service.operation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ssh.dao.jpa.behospitalized.IOutpaitentRegistDAO;
import com.ssh.dao.jpa.login.LoginDao;
import com.ssh.dao.jpa.operation.JianyanBaobiaoDao;
import com.ssh.dao.jpa.operation.JianyanMessXqDao;
import com.ssh.dao.mybatis.operation.GaojiChaxunDao;
import com.ssh.dao.mybatis.operation.TimeMessDao;
import com.ssh.pojos.Emp;
import com.ssh.pojos.OutpaitentRegist;
import com.ssh.vo.login.EmpVo;
import com.ssh.vo.operation.EmpsVo;
import com.ssh.vo.operation.JianyanMessVo;
import com.ssh.vo.operation.JianyanMessXqVo;
import com.ssh.vo.operation.JianyanVo;
import com.ssh.vo.operation.OutpaitentRegistVo;

@Service
@Transactional
public class JianyanBaoBiaoService {
	@Autowired
	private JianyanBaobiaoDao jianyanbaobiaodao;
	
	@Autowired
	private TimeMessDao timemessdao;
	
	@Autowired
	private LoginDao logindao;
	
	@Autowired
	private IOutpaitentRegistDAO ioutpaitentregistdao;
	
	@Autowired
	private GaojiChaxunDao gaojichaxundao;
	
	@Autowired
	private JianyanMessXqDao jianyanMessXqdao;
	
	
	
	//查询
	public List<JianyanMessVo> selectJianyanMessBaobiao(int page,int rows){
		PageRequest pt=new PageRequest(page -1, rows);
		List<JianyanMessVo> list=jianyanbaobiaodao.selectJianyanHuiZong(pt);
		selectJianyanBaoBiao(list);
		return list;
	}
	
	public long count(){
		return jianyanbaobiaodao.count();
	}
	
	
	public void selectJianyanBaoBiao(List<JianyanMessVo> list){
		
		for (JianyanMessVo j : list) {
			j.setEmp(new EmpsVo(jianyanbaobiaodao.findOne(j.getJianyanMessId()).getEmp().getEmpId(),
					jianyanbaobiaodao.findOne(j.getJianyanMessId()).getEmp().getEmpName()));
			j.setOutpaitentRegist(new OutpaitentRegistVo(jianyanbaobiaodao.findOne(j.getJianyanMessId()).getOutpaitentRegist().getOutpaitentRegistId(), null, null, null, null, null, null));
		}
	}
	//	第二个表格的东西
	public List<JianyanMessXqVo> selectJianyanMessXq(String JianyanMessId){
		List<JianyanMessXqVo> list=jianyanMessXqdao.selectJianyanXqHuiZong(JianyanMessId);
		selectJianyanXqBaoBiao(list);
		System.out.println(JianyanMessId);
		return list;
	}
	//外键
	public void selectJianyanXqBaoBiao(List<JianyanMessXqVo> list){
		for(JianyanMessXqVo a: list){
			a.setJianyanMess(new JianyanMessVo(jianyanMessXqdao.findOne(a.getJianyanMessXqId()).getJianyanMess().getJianyanMessId(), null, null, null, null));
		}
	}
	
	/**
	 * 通过Id查询
	 * @param page
	 * @param rows
	 * @param jianyanMessId
	 * @return
	 */
	public List<JianyanMessVo> SelectJianyanMessAllId(int page, int rows,String jianyanMessId){
		PageRequest pt=new PageRequest(page -1, rows);
		List<JianyanMessVo> list=jianyanbaobiaodao.selectGaojiChaxunId("%"+jianyanMessId+"%", pt);
		selectJianyanBaoBiao(list);
		return list;
		
	}
	/**
	 * 查询记录
	 * @param jianyanMessId
	 * @return
	 */
	public long selectJianyanMessCount(String jianyanMessId){
		return jianyanbaobiaodao.selectGaojiChaxunCount("%"+jianyanMessId+"%");
	}
	
	/**
	 * 高级查询
	 */
	Page<?> pages ;
	public List<JianyanMessVo> selectGaojiTime(int page,int rows,Date oneTime,Date trueTime,String jianyanMessId){
		pages =PageHelper.startPage(page,rows);
		List<JianyanMessVo> list=gaojichaxundao.selectMessShijian(oneTime, trueTime,"".equals(jianyanMessId) ? null:"%"+jianyanMessId+"%");
		selectJianyanBaoBiao(list);
		return list;
	}
	//不知道是啥
	public long jianyanMessTimecount() {
		return pages.getTotal();
	}
}
