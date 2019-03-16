package com.ssh.service.behospitalized;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.dao.jpa.behospitalized.IZhuyuanYushouDAO;
import com.ssh.vo.behospitalized.ZhuyuanYushouVo;

@Service
@Transactional
public class ZhuyuanYushouService {
	@Autowired
	private IZhuyuanYushouDAO zyysdao;
	
	/**
	 * 住院登记预收金额
	 * @param page
	 * @param rows
	 * @return
	 */
	public List<ZhuyuanYushouVo> selectZhuyuanYushou(int page , int rows){
		PageRequest pages = new PageRequest(page - 1, rows);
		System.out.println(pages+"111111111111111111111111111111111111111");
		return zyysdao.selectzhuyuanYushouState(pages);
	}
	/**
	 * 
	 * 查询总记录数
	 * @return
	 */
	public long count() {
		return zyysdao.count();
	}
}
