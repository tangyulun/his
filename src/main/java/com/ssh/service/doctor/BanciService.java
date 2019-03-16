package com.ssh.service.doctor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.dao.jpa.doctor.IBancDAO;
import com.ssh.dao.jpa.doctor.IZhiBanPlan;
import com.ssh.pojos.Bclass;
import com.ssh.utils.Errors;
import com.ssh.vo.doctor.BanciVO;

@Service
@Transactional
public class BanciService {
	@Autowired
	private IBancDAO IBDAO;
	
	@Autowired
	private IZhiBanPlan IZDAO;
	
	/**
	 * 查询所有
	 */
	public List<BanciVO> selectAll(int page ,int rows){
		return IBDAO.selectAll(new PageRequest(page-1, rows));
	}
	/**
	 * 记录数
	 */
	public long count(){
		return IBDAO.count();
	}
	/**
	 * 查询编号
	 */
	public long selectMaxID(){
		return IBDAO.selectMaxId();
	}
	
	/**
	 * 添加班次
	 * @param bclassesBetTimeEnd 
	 */
	public Errors insert(Bclass b, String bclassesBetTimeEnd){
		try {
			b.setBclassesId(IBDAO.selectMaxId());
			b.setBclassesBetTime(b.getBclassesBetTime() + " - " + bclassesBetTimeEnd);
			IBDAO.save(b);
			return new Errors(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Errors(e.getMessage());
		}
	}
	
	/**
	 * 修改班次
	 * @param bclassesBetTimeEnd 
	 */
	public Errors update(Bclass b, String bclassesBetTimeEnd){
		try {
			Bclass bc = IBDAO.findOne(b.getBclassesId());
			bc.setBclassesBetTime(b.getBclassesBetTime()+" - "+bclassesBetTimeEnd);
			bc.setBclassesColor(b.getBclassesColor());
			bc.setBclassesName(b.getBclassesName());
			bc.setBclassesType(b.getBclassesType());
			return new Errors(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Errors(e.getMessage());
		}
	}
	
	/**
	 * 删除班次
	 */
	public Errors delete(long bclassId){
		try {
			Bclass bc = IBDAO.findOne(bclassId);
			if(bc.getBeOnDutyPlanXqs().size() == 0){
				IBDAO.delete(bc);
				return new Errors(true);
			}
			return new Errors("该班次已应用！不能删除！");
		} catch (Exception e) {
			e.printStackTrace();
			return new Errors(e.getMessage());
		}
		
	}
}
