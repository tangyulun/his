package com.ssh.service.dean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ssh.dao.jpa.behospitalized.IBedDAO;
import com.ssh.dao.mybatis.dclass.MyIDClassDAO;
import com.ssh.dao.mybatis.dean.IMyBingChuangDAO;
import com.ssh.pojos.Bed;
import com.ssh.vo.dean.BingChuangVO;

@Service
@Transactional
public class BingChuangService {

	@Autowired 
	private IBedDAO IBDAO;
	
	
	@Autowired
	private IMyBingChuangDAO IMDAO;
	
	public List<BingChuangVO> selectAllBeds(int page , int rows){
		List<BingChuangVO> list =  IBDAO.selectAllBeds(new PageRequest(page - 1, rows));
		getBeds(list);
		return list;
		
	}

	private void getBeds(List<BingChuangVO> list) {
		for (BingChuangVO b : list) {
			System.err.println(b);
			if(b.getBedId() != null){
				Bed bed = IBDAO.findOne(b.getBedId());
				System.err.println(b.getHouseState());
				if("已占用".equals(b.getHouseState())){
					System.err.println(bed.getHospitalRegistrations().get(0).getHospitaNotify().
							getOutpaitentRegist());
					b.setBingRenName(bed.getHospitalRegistrations().get(0).getHospitaNotify().
							getOutpaitentRegist().getMedicalCard().getMedicalCardName());
					b.setBongRenSex(bed.getHospitalRegistrations().get(0).getHospitaNotify().
							getOutpaitentRegist().getMedicalCard().getMedicalCardSex());
					b.setRuYaundate(bed.getHospitalRegistrations().get(0).getHospitalRegistrationDate());;
				}
				b.setBingchaungType(bed.getHouseType().getHouseTypeName());
				b.setBingchuangWeizhi(
						bed.getBedType().getBedTypeType().getBedTypeTypeName()+
						bed.getBedType().getBedTypeName());
				
			}
		}
	}

	public long count() {
		return IBDAO.count();
	}

	public long countWhere(String key) {
		return IBDAO.countWhere("%" +key+"%" ,"%" +key+"%" ,"%" +key+"%");
	}

	public  List<BingChuangVO>  selectAllBedsWhere(int page, int rows, String key) {
		List<BingChuangVO> list =  IBDAO.selectAllBedsWhere(key ,"%" +key+"%" ,"%" +key+"%" ,
				new PageRequest(page - 1, rows));
		getBeds(list);
		return list;
	}

	public long countWhereGrade(String key, String state, String sex) {
		return pages.getTotal();
	}

	Page<?> pages = null;
	public List<BingChuangVO>  selectAllBedsWhereGrade(int page, int rows, String key, String state, String sex) {
		System.err.println(key + state + sex);
		pages = PageHelper.startPage(page, rows);
		List<BingChuangVO> list = IMDAO.selectAllBedsWhereGrade("".equals(key) ? null : "%" +key+"%" , "全部".equals(state) ? null : state , "全部".equals(sex) ? null : sex);
		getBeds(list);
		return list;
	}
}
