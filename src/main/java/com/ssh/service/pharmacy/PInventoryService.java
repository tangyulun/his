package com.ssh.service.pharmacy;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.dao.jpa.drugstorage.IDrugDao;
import com.ssh.dao.jpa.pharmacy.IPharmacyInventoryDao;
import com.ssh.dao.jpa.pharmacy.IPharmacyInventoryDetaliDao;
import com.ssh.pojos.PharmacyInventory;
import com.ssh.pojos.PharmacyInventoryDetali;
import com.ssh.utils.Errors;
import com.ssh.vo.pharmacy.YaopingPandianVo;

@Service
@Transactional
public class PInventoryService {

	@Autowired
	private IPharmacyInventoryDao IPDao;
	@Autowired
	private IPharmacyInventoryDetaliDao IPIDao;
	@Autowired
	private IDrugDao IDao;
	
	private List<YaopingPandianVo> list=new ArrayList<>();
	
	/**
	 * 点击加入将form表单中的数据传到datagrid中
	 * @param drugId
	 * @param drugName
	 * @param jcnum
	 * @param jcdw
	 * @param drugLsprice
	 * @param kyje
	 * @param kynum
	 * @param ph
	 */
	public void selectPandianXq(String drugId,String drugBname,
			BigDecimal jcnum , String jcdw, BigDecimal drugLsprice , BigDecimal kyje , BigDecimal kynum , String ph , BigDecimal kcnum){
		YaopingPandianVo ypVo=new YaopingPandianVo(list.size()+1, drugId, drugBname, jcnum, jcdw, drugLsprice, kyje, kynum, ph ,kcnum);
		ypVo.setYknum(new BigDecimal((jcnum.intValue() - kcnum.intValue()) > 0 ? (jcnum.intValue() - kcnum.intValue()) : (kcnum.intValue() - jcnum.intValue())));
		list.add(ypVo);
	}
	
	/**
	 * 查询所有
	 * @return
	 */
	public List<YaopingPandianVo> selectAll(){
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
	public Errors delete(List<Long> id){
		for (Long l : id) {
			for (YaopingPandianVo y : list) {
				if(y.getId() == l){
					list.remove(y);
					break;
				}
			}
		}
		return new Errors(true);
	}
	
	/**
	 * 添加盘点处理
	 * @param pi
	 * @return
	 */
	public Errors insertYaofanPd(PharmacyInventory pi){
		try {
			pi.setPharmacyInventoryZt("已盘点");
			IPDao.save(pi);
			insertYaofanPdXq(pi);
			return new Errors(true);
		} catch (Exception e) {
			e.printStackTrace();
			return new Errors(e.getMessage());
		}
	}
	
	/**
	 * 添加详情
	 * @param pi
	 */
	public void insertYaofanPdXq(PharmacyInventory pi){
		for (YaopingPandianVo y : list) {
			PharmacyInventoryDetali pid=new PharmacyInventoryDetali();
			pid.setDrug(IDao.findOne(y.getYpid()));
			pid.setPharmacyInventoryDetalisId(""+IPIDao.maxId());
			pid.setPharmacyIdJcnum(y.getJcnum());
			pid.setPharmacyIdKyje(y.getKyje());
			pid.setPharmacyIdKynum(y.getYknum());
			pid.setPharmacyInventory(IPDao.findOne(pi.getPharmacyInventoryId()));
			pid.setPharmacyInventoryDetalisDj(y.getDj());
			pid.setPharmacyInventoryDetalisPh(y.getPh());
			IPIDao.save(pid);
		}
	}
}
