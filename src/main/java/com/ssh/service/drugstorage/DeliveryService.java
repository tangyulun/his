package com.ssh.service.drugstorage;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.dao.jpa.drugstorage.IDeliveryDao;
import com.ssh.dao.jpa.drugstorage.IDrugDao;
import com.ssh.dao.jpa.drugstorage.IDrugDeliveryDetalisDao;
import com.ssh.dao.jpa.drugstorage.YaokuKucunDao;
import com.ssh.dao.jpa.staff.IEmpDAO;
import com.ssh.pojos.Drug;
import com.ssh.pojos.DrugDelivery;
import com.ssh.pojos.DrugDeliveryDetali;
import com.ssh.pojos.YaokuKucun;
import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;
import com.ssh.vo.drugstorage.BuydingdanVo;
import com.ssh.vo.drugstorage.RukuXqVo;

@Service
@Transactional
public class DeliveryService {
	@Autowired
	private IDeliveryDao IDDao;
	@Autowired
	private IEmpDAO IEDao;
	@Autowired
	private IDrugDeliveryDetalisDao IDDDao;
	@Autowired
	private IDrugDao IDDAO;
	@Autowired
	private YaokuKucunDao YKDao;
	
	private List<RukuXqVo> list=new ArrayList<>();
	
	public String DNumber(){
		return IDDao.selectDNumber(CommentOrder.dateLike());
	}
	
	
	/**
	 * 点击加入将值传到table中
	 * @param ypid
	 * @param ypname
	 * @param num
	 * @param ph
	 * @param bz
	 * @param dw
	 */
	public void addrukuxq(String drugId,String drugName,BigDecimal num,String ph,String bz){
		RukuXqVo ruku=new RukuXqVo(list.size()+1, drugId, drugName, num, ph, bz);
		System.out.println(ruku);
		list.add(ruku);
	}
	
	/**
	 * 查询
	 */
	public  List<RukuXqVo> selectAll(){
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
	 * @param xq
	 * @return
	 */
	private boolean isFlag = false;
	public Errors deletexd(List<Long> xq){
		for (Long l : xq) {
			for (RukuXqVo b : list) {
				if(b.getId() == l){
					list.remove(b);
					isFlag = true;
					updateKuCunNum(IDDAO.findOne(b.getYpid()).getYaokuKucun().getYaokuKucunId(), b.getNum());
					break;
				}
			}
		}
		return new Errors(true);
	}
	
	/**
	 * 出库处理
	 * @param dd
	 * @param empId
	 * @return
	 */
	public Errors insertchuli(DrugDelivery dd,Long empId){
		try {
			dd.setEmp(IEDao.findOne(empId));
			dd.setDrugDeliveryZt("已出库");
			IDDao.save(dd);
			insertrukuxq(dd);
			updatechukuxq();
			return new Errors(true);
		} catch (Exception e) {
			e.printStackTrace();
			return new Errors(e.getMessage());
		}
	}
	
	/**
	 * 详情记录
	 * @param dd
	 */
	public void insertrukuxq(DrugDelivery dd){
		for (RukuXqVo r : list) {
			DrugDeliveryDetali ddd=new DrugDeliveryDetali();
			ddd.setDrugDeliveryDetalisId(IDDDao.maxId());
			ddd.setDrugDeliveryDetalisBz(r.getBz());
			ddd.setDrugDeliveryDetalisNum(""+r.getNum());
			ddd.setDrugDeliveryDetalisPh(r.getPh());
			ddd.setDrug(IDDAO.findOne(r.getYpid()));
			ddd.setDrugDelivery(IDDao.findOne(dd.getDrugDeliveryId()));
			IDDDao.save(ddd);
		}
	}
	
	/**
	 * 修改库存数量
	 */
	public void updatechukuxq(){
		for (RukuXqVo r : list) {
			Drug d=IDDAO.findOne(r.getYpid());
			YaokuKucun yk=YKDao.findOne(d.getYaokuKucun().getYaokuKucunId());
			yk.setYaofangKucunNum(new BigDecimal(yk.getYaofangKucunNum().intValue() + r.getNum().intValue()));
			yk.setYaofangKaiyaoShengyuNum(new BigDecimal(yk.getYaofangKucunNum().intValue() - yk.getYaofangKaiyaoNum().intValue()));
		}
	}
	
	/**
	 * 修改table中的数据
	 * @param rk
	 * @param id
	 */
	public void updatechuku(RukuXqVo rk , int id,BigDecimal num , BigDecimal numC){
		System.err.println(rk + "\n"+id);
		for (RukuXqVo b : list) {
			Drug d=IDDAO.findOne(rk.getYpid());
			YaokuKucun yk=YKDao.findOne(d.getYaokuKucun().getYaokuKucunId());
			b.setNum(rk.getNum());
			if(yk.getYaokuKucunNum().intValue() < num.intValue()){
				b.setNum(yk.getYaokuKucunNum());
			}
			yk.setYaokuKucunNum(new BigDecimal(yk.getYaokuKucunNum().intValue() + numC.intValue()));
			b.setBz(rk.getBz());
			b.setPh(rk.getPh());
			break;
		}
	}
	
	/**
	 * 修改库存数量
	 * @param kucunId
	 * @param num
	 */
	public void updateKuCunNum(Long  kucunId , BigDecimal num){
		if(kucunId != null){
			YaokuKucun yk = YKDao.findOne(kucunId);
			if(isFlag){
				yk.setYaokuKucunNum(new BigDecimal(yk.getYaokuKucunNum().intValue() + num.intValue()));
				isFlag = false;
			}else{
				yk.setYaokuKucunNum(new BigDecimal(yk.getYaokuKucunNum().intValue() - num.intValue()));
			}
		}
	}
}
