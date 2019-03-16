package com.ssh.service.dean;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.dao.jpa.dean.IZhuyuanFayaoXqDao;
import com.ssh.dao.jpa.dean.MengzhengFayaoXqDao;
import com.ssh.dao.jpa.doctor.IEletronicDAO;
import com.ssh.dao.jpa.doctor.IPrescriCodeDao;
import com.ssh.dao.jpa.nurse.IPrescriptionDAO;
import com.ssh.dao.jpa.outpatient.IFinancialHistoryDao;
import com.ssh.dao.jpa.outpatient.IOutpaitentDAO;
import com.ssh.dao.mybatis.dean.IMinstrumenthuizonDAO;
import com.ssh.pojos.DrugYaofangXq;
import com.ssh.pojos.FinancialHistory;
import com.ssh.pojos.OutpaitentRegist;
import com.ssh.pojos.Prescription;
import com.ssh.pojos.PrescriptionRecode;
import com.ssh.pojos.ZhuyuanFayaoXq;
import com.ssh.vo.dean.HospitalZongTongJiVO;
import com.ssh.vo.dean.ShouFeiOrDrugVO;
import com.ssh.vo.dean.ZheXianTuVO;

@Service
@Transactional
public class HospitalZongService {
	
	@Autowired
	private IFinancialHistoryDao IFDAO;
	
	@Autowired
	private IOutpaitentDAO IODAO;
	
	@Autowired
	private IEletronicDAO IEDAO;
	
	@Autowired
	private IPrescriCodeDao IPDAO;
	
	@Autowired
	private MengzhengFayaoXqDao IMDAO;
	
	@Autowired
	private IZhuyuanFayaoXqDao IZDAO;
	public List<ShouFeiOrDrugVO> selectAllMen(){
		//查询所有门诊号，用listMen接收
		List<ShouFeiOrDrugVO> list = returnSelect("门诊处方");
		return list;
	}

	
	private List<ShouFeiOrDrugVO> returnSelect(String type){
		List<ShouFeiOrDrugVO> list = new ArrayList<>();
		List<Prescription> listP = (List<Prescription>) IEDAO.findAll();
		for (Prescription p : listP) {
			if(type.equals(p.getPrescriptionType())){
				OutpaitentRegist o = p.getOutpaitentRegist();
					for(FinancialHistory f : o.getFinancialHistories()){
						if("结".equals(f.getFinancialHistoryShoufeizt())){
							ShouFeiOrDrugVO sd = new ShouFeiOrDrugVO(f.getFinancialHistoryShoufeilx(),
									f.getFinancial().getFinancialId(), 
									f.getFinancial().getFinancialName(),
									f.getFinancialHistoryNum(),
									new  BigDecimal(f.getFinancial().getFinancialPrice().doubleValue() * 0.8),
									f.getFinancial().getFinancialPrice(),
									f.getFinancialHistoryShoufeije());
							sd.setTimes(f.getFinancialHistoryShoufeirq() + " " + f.getFinancialHistoryShoufeisj());
							System.err.println(f.getFinancial().getFinancialPrice().doubleValue() * 0.8);
							list.add(sd);
						}
				}
			}
		}
		return list;
	}
	
	
	public List<ShouFeiOrDrugVO> selectAllZhu(){
		//查询所有门诊号，用listZhu接收
		return returnSelect("住院处方");
	}
	
	public List<ShouFeiOrDrugVO> selectMenDrug(){
		return returnSelectDrug();
		//查询所有的处方号，用listDMen接收
	}
	
	public List<ShouFeiOrDrugVO> selectZhuDrug(){
		//查询所有的处方号。用listDZhu接收
		return returnZhuYuan();
	}
	
	
	/**
	 * 门诊住院总的
	 */
	private List<ShouFeiOrDrugVO> returnSelectDrug(){
		List<ShouFeiOrDrugVO> list = new ArrayList<>();
		List<DrugYaofangXq> listF =  (List<DrugYaofangXq>) IMDAO.findAll();
		for (DrugYaofangXq f : listF) {
			ShouFeiOrDrugVO sd = new ShouFeiOrDrugVO("门诊发药",
					f.getDrug().getDrugId(),
					f.getDrug().getDrugName(),
					f.getDrugYaofangXqNumber(),
					f.getDrug().getDrugPfprice(),
					f.getDrugYaofangXqPrice(),
					f.getDrugYaofangXqMoney());
			sd.setXiangmuDanwei(f.getDrug().getUnit().getUnitsName());
			list.add(sd);
		}
		return list;
	}
	
	/**	 
	 *门诊住院总的
	 */
	private List<ShouFeiOrDrugVO> returnZhuYuan(){
		List<ShouFeiOrDrugVO> list = new ArrayList<>();
		List<ZhuyuanFayaoXq> listF =  (List<ZhuyuanFayaoXq>) IZDAO.findAll();
		for (ZhuyuanFayaoXq f : listF) {
			ShouFeiOrDrugVO sd = new ShouFeiOrDrugVO("住院发药",
					f.getDrug().getDrugId(),
					f.getDrug().getDrugName(),
					f.getZhuyuanFayaoXqNumber(),
					f.getDrug().getDrugPfprice(),
					f.getZhuyuanFayaoXqPrice(),
					f.getZhuyuanFayaoXqMoney());
			sd.setXiangmuDanwei(f.getDrug().getUnit().getUnitsName());
			list.add(sd);
		}
		return list;
	}
	/**
	 * @return
	 */
	DecimalFormat d = new DecimalFormat("#.00");
	public List<HospitalZongTongJiVO> selectAllShanXingTu(){
		List<ShouFeiOrDrugVO>  t1 = selectAllMen();
		List<ShouFeiOrDrugVO>  t2 = selectAllZhu();
		List<ShouFeiOrDrugVO>  t3 = selectMenDrug();
		List<ShouFeiOrDrugVO>  t4 = selectZhuDrug();
		
		double dou = jisuanBaifen(t1) + jisuanBaifen(t2)+jisuanBaifen(t3)+jisuanBaifen(t4);
		HospitalZongTongJiVO tj = new HospitalZongTongJiVO("门诊收费项目", Double.valueOf(d.format((jisuanBaifen(t1)/ dou)*100)), "#4572a7");
		HospitalZongTongJiVO tj2 = new HospitalZongTongJiVO("住院收费项目", Double.valueOf(d.format((jisuanBaifen(t2) / dou)*100)), "#aa4643");
		HospitalZongTongJiVO tj3 = new HospitalZongTongJiVO("门诊发药",  Double.valueOf(d.format((jisuanBaifen(t3) / dou)*100)), "#89a54e");
		HospitalZongTongJiVO tj4 = new HospitalZongTongJiVO("住院发药",  Double.valueOf(d.format((jisuanBaifen(t4) / dou)*100)), "#80699b");
		
		List<HospitalZongTongJiVO> list = new ArrayList<>();
		 list.add(tj);
		 list.add(tj2);
		 list.add(tj3);
		 list.add(tj4);
		 
		 return list;
	}
	
	public double jisuanBaifen(List<ShouFeiOrDrugVO> list){
		double m = 0.0;
		for (ShouFeiOrDrugVO s : list) {
			m += s.getXiangmuMoney().doubleValue();
		}
		return m;
	}
	
	public double jisuanZongChengBenMoney(List<ShouFeiOrDrugVO> list){
		double m = 0.0;
		for (ShouFeiOrDrugVO s : list) {
			m += s.getXiangmuChengBen().doubleValue() * s.getXiangmuNum().intValue();
		}
		return m;
	}
	
	public double jisuanZongChengBen(){
		List<ShouFeiOrDrugVO>  t1 = selectAllMen();
		List<ShouFeiOrDrugVO>  t2 = selectAllZhu();
		List<ShouFeiOrDrugVO>  t3 = selectMenDrug();
		List<ShouFeiOrDrugVO>  t4 = selectZhuDrug();
		return Double.parseDouble(d.format(jisuanZongChengBenMoney(t1) +  jisuanZongChengBenMoney(t2) + 
				 jisuanZongChengBenMoney(t3) +  jisuanZongChengBenMoney(t4)));
	}
	
	/**
	 * 折线图
	 */
	public List<ZheXianTuVO> selectZheXian(){
		//分组查询
		List<Object[]> list = IFDAO.selectZhexianTu();
		List<Object[]> list2 = IPDAO.selectZhexianTu();
		List<ZheXianTuVO> listZ = new ArrayList<>();
		
		ZheXianTuVO z = new ZheXianTuVO("收费项目情况", selectDoubel(list), 3, "#1f7e92");
		ZheXianTuVO z2 = new ZheXianTuVO("药房发药情况",selectDoubel(list2),3 , "#ed23e3");
		listZ.add(z);
		listZ.add(z2);
		return listZ;
	}
	
	
	public List<ZheXianTuVO>  selectZhuXiang2(){
		List<Object[]> list1 = IPDAO.selectZhuXingTu("门诊开药");
		List<Object[]> list2 = IPDAO.selectZhuXingTu("住院开药");
		List<Object[]> list3 = IFDAO.seelctZhuxingtu("门诊处方");
		List<Object[]> list4 = IFDAO.seelctZhuxingtu("住院处方");
		
		List<ZheXianTuVO> listZ = new ArrayList<>();
		
		listZ.add(new ZheXianTuVO("门诊收费项目", selectDoubel(list3), 0, "#de9972"));
		listZ.add(new ZheXianTuVO("住院收费项目", selectDoubel(list4), 0, "#28847f"));
		listZ.add(new ZheXianTuVO("门诊药房发药", selectDoubel(list1), 0, "#90abc0"));
		listZ.add(new ZheXianTuVO("住院药房发药", selectDoubel(list2), 0, "#80cb56"));
		
		return listZ;
	}
	
	public List<Double> selectDoubel(List<Object[]> list){
		for (Object[] o : list) {
			System.err.println(o[0]+"\t"+o[1]);
		}
		List<Double>  listD = new ArrayList<>();
		for(int i = 1 ; i<= 12 ; i++){
			for (int j = 0; j < list.size(); j++) {
				if(i==Integer.valueOf(list.get(j)[0].toString())){
					listD.add(Double.valueOf(list.get(j)[1].toString()));
					break;
				}else if(j == list.size() - 1){
					listD.add(0.0);
					break;
				}
			}
			
		}
		System.err.println(listD);
		return listD;
	}
	public List<ZheXianTuVO> selectZheXianWhere(int  index){
		List<ZheXianTuVO> list = selectZheXian();
		list.remove(index);
		return list;
	}
}
