package com.ssh.controller.behospitalized;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssh.service.behospitalized.ZhuyuanYushouService;
import com.ssh.vo.behospitalized.ZhuyuanYushouVo;

@Controller
public class ZhuyuanYushouController {
	@Autowired
	private ZhuyuanYushouService zyysservice;
	/**
	 * 查询住院预收金额
	 * @param page
	 * @param rows
	 * @return
	 */
	@GetMapping("/select_zhuyuan_yushou")
	@ResponseBody
	public Map<String, Object> selectZhuYuanYushou(int page , int rows){
		Map<String , Object> map = new HashMap<>();
		List<ZhuyuanYushouVo> list = zyysservice.selectZhuyuanYushou(page, rows);
		map.put("total", zyysservice.count());
		map.put("rows", list);
		return map;
	}
}
