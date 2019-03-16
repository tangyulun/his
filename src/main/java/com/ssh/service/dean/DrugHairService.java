package com.ssh.service.dean;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.dao.jpa.dean.IZhuyuanFayaoDao;
import com.ssh.dao.jpa.dean.IZhuyuanFayaoXqDao;
import com.ssh.dao.jpa.dean.MengzhengFayaoDao;
import com.ssh.dao.jpa.dean.MengzhengFayaoXqDao;
import com.ssh.pojos.DrugYaofang;
import com.ssh.pojos.DrugYaofangXq;
import com.ssh.pojos.ZhuyuanFayao;
import com.ssh.pojos.ZhuyuanFayaoXq;
import com.ssh.vo.behospitalized.HospitalRegistrationVo;
import com.ssh.vo.dean.DrugHairVo;
import com.ssh.vo.dean.DrugHairXqVo;
import com.ssh.vo.drugstorage.DrugVo;
import com.ssh.vo.nurse.PrescriptionVo;
import com.ssh.vo.outpatient.OutpatientVo;
import com.ssh.vo.staff.EmpVO;

@Service
@Transactional
public class DrugHairService {

	@Autowired
	private MengzhengFayaoDao mDao;
	@Autowired
	private IZhuyuanFayaoDao IZDao;
	@Autowired
	private IZhuyuanFayaoXqDao IZXDao;
	@Autowired
	private MengzhengFayaoXqDao mxqDao;
	
	
	/**
	 * 查询所有发药记录
	 * @return
	 */
	public List<DrugHairVo> selectFayao(){
		List<DrugHairVo> list = new ArrayList<>();
		List<DrugYaofang> mzFayao = mDao.selectMzFy();
		List<ZhuyuanFayao> zyFayao = IZDao.selectZhuyuanFayao();
		chaxun(list, mzFayao, zyFayao);
		return list;
	}
	
	/**
	 * 连表查询住院发药
	 * @param list
	 */
	public void zyfayaoLianbiao(List<DrugHairVo> list){
		for (DrugHairVo d : list) {
			if(d.getZhuyuanFayaoType() == "住院发药"){
				System.out.println(IZDao.findOne(d.getDrugYaofangIId())+"1111111111");
				System.out.println(IZDao.findOne(d.getDrugYaofangIId()).getEmp()+"2222222222222");
				System.out.println(IZDao.findOne(d.getDrugYaofangIId()).getEmp().getEmpId()+"333333333333333333333");
				d.setEmp(new EmpVO(IZDao.findOne(d.getDrugYaofangIId()).getEmp().getEmpId(),
						IZDao.findOne(d.getDrugYaofangIId()).getEmp().getEmpLoginName()));
				d.setPrescription(new PrescriptionVo(IZDao.findOne(d.getDrugYaofangIId()).getPrescription().getPrescriptionId()));
				d.setOutpatien(new OutpatientVo(IZDao.findOne(d.getDrugYaofangIId()).getHospitalRegistration().getHospitaNotify().getOutpaitentRegist().getOutpaitentRegistId(),
						IZDao.findOne(d.getDrugYaofangIId()).getHospitalRegistration().getHospitaNotify().getOutpaitentRegist().getOutpaitentRegistBinglihao()));
			}
		}
	}
	
	/**
	 * 连表查询门诊发药
	 * @param list
	 */
	public void mzfayaoLianbiao(List<DrugHairVo> list){
		for (DrugHairVo d : list) {
			if(d.getZhuyuanFayaoType() == "门诊发药"){
				System.out.println(mDao.findOne(d.getDrugYaofangIId())+"44444444444444444");
				d.setEmp(new EmpVO(mDao.findOne(d.getDrugYaofangIId()).getEmp().getEmpId(),
						mDao.findOne(d.getDrugYaofangIId()).getEmp().getEmpLoginName()));
				d.setPrescription(new PrescriptionVo(mDao.findOne(d.getDrugYaofangIId()).getPrescription().getPrescriptionId()));
				d.setOutpatien(new OutpatientVo(mDao.findOne(d.getDrugYaofangIId()).getOutpaitentRegist().getOutpaitentRegistId(), 
						mDao.findOne(d.getDrugYaofangIId()).getOutpaitentRegist().getOutpaitentRegistBinglihao()));
			}
		}
	}
	
	/**
	 * 根据发药编号查询详情
	 * @param drugYaofangId
	 * @return
	 */
	public List<DrugHairXqVo> selectXqById(String drugYaofangId,String zhuyuanFayaoType){
		if("住院发药".equals(zhuyuanFayaoType)){
			List<DrugHairXqVo> zyxq = IZXDao.selectXqById(drugYaofangId);
			zxqlianbiao(zyxq);
			return zyxq;
		}else{
			List<DrugHairXqVo> mzxq = mxqDao.selectXqById(drugYaofangId);
			dxqlianbiao(mzxq);
			return mzxq;
		}
	}
	
	public void dxqlianbiao(List<DrugHairXqVo> list){
		for (DrugHairXqVo d : list) {
			d.setDrugHair(new DrugHairVo(mxqDao.findOne(d.getDrugYaofangXqId()).getDrugYaofang().getDrugYaofangId()));
			d.setDrug(new DrugVo(mxqDao.findOne(d.getDrugYaofangXqId()).getDrug().getDrugId(), 
					mxqDao.findOne(d.getDrugYaofangXqId()).getDrug().getDrugName()));
		}
	}
	
	public void zxqlianbiao(List<DrugHairXqVo> list){
		for (DrugHairXqVo d : list) {
			d.setDrugHair(new DrugHairVo(IZXDao.findOne(d.getDrugYaofangXqId()).getZhuyuanFayao().getZhuyuanFayaoId()));
			d.setDrug(new DrugVo(IZXDao.findOne(d.getDrugYaofangXqId()).getDrug().getDrugId(),
					IZXDao.findOne(d.getDrugYaofangXqId()).getDrug().getDrugName()));
		}
	}

	/**
	 * 模糊查询
	 * @param drugYaofangId
	 * @return
	 */
	public List<DrugHairVo> mohuFindFayao(String drugYaofangId) {
		List<DrugHairVo> list = new ArrayList<>();
		List<DrugYaofang> mzFayao = mDao.mohufind("%"+drugYaofangId+"%");
		List<ZhuyuanFayao> zyFayao = IZDao.mohufind("%"+drugYaofangId+"%");
		chaxun(list, mzFayao, zyFayao);
		return list;
	}

	/**
	 * 公共查询
	 * @param list
	 * @param mzFayao
	 * @param zyFayao
	 */
	private void chaxun(List<DrugHairVo> list, List<DrugYaofang> mzFayao, List<ZhuyuanFayao> zyFayao) {
		for (DrugYaofang m : mzFayao) {
			DrugHairVo dh = new DrugHairVo();
			dh.setDrugYaofangIId(m.getDrugYaofangId());
			dh.setDrugYaofangDate(m.getDrugYaofangDate());
			dh.setDrugYaofangState(m.getDrugYaofangState());
			dh.setZhuyuanFayaoZmoney(m.getZhuyuanFayaoZmoney());
			dh.setZhuyuanFayaoType("门诊发药");
			list.add(dh);
		}
		mzfayaoLianbiao(list);
		for (ZhuyuanFayao z : zyFayao) {
			DrugHairVo dh = new DrugHairVo();
			dh.setDrugYaofangIId(z.getZhuyuanFayaoId());
			System.out.println(z.getZhuyuanFayaoId());
			dh.setDrugYaofangDate(z.getZhuyuanFayaoDate());
			dh.setDrugYaofangState(z.getZhuyuanFayaoState());
			dh.setZhuyuanFayaoType("住院发药");
			dh.setZhuyuanFayaoZmoney(z.getZhuyuanFayaoZmoney());
			list.add(dh);
		}
		zyfayaoLianbiao(list);
	}
	
	/**
	 * 根据发药编号和状态高级查询
	 * @param drugYaofangId
	 * @param zhuyuanFayaoType
	 * @return
	 */
	public List<DrugHairVo> gaojifind(String drugYaofangId , String zhuyuanFayaoType){
		List<DrugHairVo> list = new ArrayList<>();
		if("全部".equals(zhuyuanFayaoType) && drugYaofangId == ""){
			List<DrugYaofang> mzFayao = mDao.selectMzFy();
			List<ZhuyuanFayao> zyFayao = IZDao.selectZhuyuanFayao();
			chaxun(list, mzFayao, zyFayao);
		}else if("门诊发药".equals(zhuyuanFayaoType) && drugYaofangId == ""){
			List<DrugYaofang> mzFayao = mDao.selectMzFy();
			for (DrugYaofang m : mzFayao) {
				DrugHairVo dh = new DrugHairVo();
				dh.setDrugYaofangIId(m.getDrugYaofangId());
				dh.setDrugYaofangDate(m.getDrugYaofangDate());
				dh.setDrugYaofangState(m.getDrugYaofangState());
				dh.setZhuyuanFayaoZmoney(m.getZhuyuanFayaoZmoney());
				dh.setZhuyuanFayaoType("门诊发药");
				list.add(dh);
				mzfayaoLianbiao(list);
			}
		}else if("住院发药".equals(zhuyuanFayaoType) && drugYaofangId == ""){
			List<ZhuyuanFayao> zyFayao = IZDao.selectZhuyuanFayao();
			for (ZhuyuanFayao z : zyFayao) {
				DrugHairVo dh = new DrugHairVo();
				dh.setDrugYaofangIId(z.getZhuyuanFayaoId());
				dh.setDrugYaofangDate(z.getZhuyuanFayaoDate());
				dh.setDrugYaofangState(z.getZhuyuanFayaoState());
				dh.setZhuyuanFayaoType("住院发药");
				dh.setZhuyuanFayaoZmoney(z.getZhuyuanFayaoZmoney());
				list.add(dh);
				zyfayaoLianbiao(list);
			}
		}else if("全部".equals(zhuyuanFayaoType) && drugYaofangId != ""){
			List<DrugYaofang> mzFayao = mDao.mohufind("%"+drugYaofangId+"%");
			List<ZhuyuanFayao> zyFayao = IZDao.mohufind("%"+drugYaofangId+"%");
			chaxun(list, mzFayao, zyFayao);
		}else if("门诊发药".equals(zhuyuanFayaoType) && drugYaofangId != ""){
			List<DrugYaofang> mzFayao = mDao.mohufind("%"+drugYaofangId+"%");
			for (DrugYaofang m : mzFayao) {
				DrugHairVo dh = new DrugHairVo();
				dh.setDrugYaofangIId(m.getDrugYaofangId());
				dh.setDrugYaofangDate(m.getDrugYaofangDate());
				dh.setDrugYaofangState(m.getDrugYaofangState());
				dh.setZhuyuanFayaoZmoney(m.getZhuyuanFayaoZmoney());
				dh.setZhuyuanFayaoType("门诊发药");
				list.add(dh);
				mzfayaoLianbiao(list);
			}
		}else if("住院发药".equals(zhuyuanFayaoType) && drugYaofangId != ""){
			List<ZhuyuanFayao> zyFayao = IZDao.mohufind("%"+drugYaofangId+"%");
			for (ZhuyuanFayao z : zyFayao) {
				DrugHairVo dh = new DrugHairVo();
				dh.setDrugYaofangIId(z.getZhuyuanFayaoId());
				dh.setDrugYaofangDate(z.getZhuyuanFayaoDate());
				dh.setDrugYaofangState(z.getZhuyuanFayaoState());
				dh.setZhuyuanFayaoType("住院发药");
				dh.setZhuyuanFayaoZmoney(z.getZhuyuanFayaoZmoney());
				list.add(dh);
				zyfayaoLianbiao(list);
			}
		}
		return list;
	}
}
