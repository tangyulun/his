package com.ssh.service.drugstorage;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.dao.jpa.drugstorage.IDrugDao;
import com.ssh.dao.jpa.drugstorage.IInventoryDao;
import com.ssh.dao.jpa.drugstorage.IInventoryDetaliDao;
import com.ssh.dao.jpa.drugstorage.YaokuKucunDao;
import com.ssh.dao.jpa.staff.IEmpDAO;
import com.ssh.pojos.Drug;
import com.ssh.pojos.DrugInventory;
import com.ssh.pojos.DrugInventoryDetali;
import com.ssh.pojos.YaokuKucun;
import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;
import com.ssh.vo.drugstorage.PandianVo;

@Service
@Transactional
public class InventoryService {
	@Autowired
	private IInventoryDao IIDao;
	@Autowired
	private IEmpDAO IEDao;
	@Autowired
	private IInventoryDetaliDao IIDDao;
	@Autowired
	private IDrugDao IDDAO;
	@Autowired
	private YaokuKucunDao YKDao;
	
	private List<PandianVo> list=new ArrayList<>();
	
	public String INumber(){
		return IIDao.INumber(CommentOrder.dateLike());
	}
	
	/**
	 * 添加盘点详情
	 * @param drugId
	 * @param drugName
	 * @param drugPfprice
	 * @param jcnum
	 * @param jcdw
	 * @param kynum
	 * @param kyje
	 * @param ph
	 */
	public void addPdXq(String drugId,String drugName,BigDecimal drugPfprice,BigDecimal jcnum,String jcdw,BigDecimal kynum,BigDecimal kyje,String ph){
		PandianVo pd=new PandianVo(list.size()+1, drugId, drugName, jcnum, jcdw, drugPfprice, kynum, kyje, ph);
		list.add(pd);
	}
	
	/**
	 * 查询
	 * @return
	 */
	public List<PandianVo> selectAll(){
		return list;
	}
	
	/**
	 * 清除
	 */
	public void clear(){
		list.clear();
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public Errors delectAll(List<Long> id){
		for (Long l : id) {
			for (PandianVo p : list) {
				if(p.getId() == l){
					list.remove(p);
					break;
				}
			}
		}
		return new Errors(true);
	}
	
	/**
	 * 新增盘点处理
	 * @param di
	 * @param empId
	 * @return
	 */
	public Errors insertPandianChuli(DrugInventory di,Long empId){
		try {
			//绑定与管理员的关系
			//通过查询id来绑定
			di.setEmp(IEDao.findOne(empId));
			//修改状态
			di.setDrugInvertoryZt("已盘点");
			//保存
			IIDao.save(di);
			//调用添加盘点详情方法
			insertPandianXq(di);
			updateKucunNum();
			return new Errors(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Errors(e.getMessage());
		}
	}
	
	/**
	 * 添加盘点详情表
	 * @param di
	 */
	public void insertPandianXq(DrugInventory di){
		for (PandianVo p : list) {
			DrugInventoryDetali did = new DrugInventoryDetali();
			did.setDrugInventoryDetalisDj(p.getDj());
			did.setDrugInventoryDetalisId(""+IIDDao.maxId());
			did.setDrugInventoryDetalisJcnum(p.getJcnum());
			did.setDrugInventoryDetalisKymoney(p.getKyje());
			did.setDrugInventoryDetalisKynum(p.getKynum());
			did.setDrugInventoryDetalisPh(p.getPh());
			did.setDrugInventory(IIDao.findOne(di.getDrugInventoryId()));
			did.setDrug(IDDAO.findOne(p.getYpid()));
			IIDDao.save(did);
		}
	}
	
	public void updateKucunNum(){
		for (PandianVo p : list) {
			Drug d=IDDAO.findOne(p.getYpid());
			YaokuKucun yk=YKDao.findOne(d.getYaokuKucun().getYaokuKucunId());
			yk.setYaokuKucunNum(new BigDecimal(p.getJcnum().intValue()));
		}
	}
}
