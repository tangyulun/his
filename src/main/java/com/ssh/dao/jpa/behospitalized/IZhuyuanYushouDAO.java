package com.ssh.dao.jpa.behospitalized;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.ZhuyuanYushou;
import com.ssh.vo.behospitalized.ZhuyuanYushouVo;

public interface IZhuyuanYushouDAO extends CrudRepository<ZhuyuanYushou, Long> {
	
	@Query("select new com.ssh.vo.behospitalized.ZhuyuanYushouVo(z.zhuyuanYushouId,z.zhuyuanYushouDate,z.zhuyuanYushouMoney,z.zhuyuanYushouState,z.rushShouqu) from ZhuyuanYushou z ")
	public List<ZhuyuanYushouVo> selectzhuyuanYushouState(Pageable pages);
}
