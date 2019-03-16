package com.ssh.dao.jpa.operation;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.Shoushu;
import com.ssh.pojos.ShoushuType;
import com.ssh.vo.operation.ShouShuVo;

public interface ShouShuDao extends CrudRepository<Shoushu, String>{
		/*查询*/
		@Query("select new com.ssh.vo.operation.ShouShuVo(s.shoushuId,s.shoushuExplain,"
				+ "s.shoushuName,s.shoushuRemark,s.shoushuType)"
				+"from Shoushu s")
		public List<ShouShuVo> selectAll();
		
		/*根据日期模糊查询单号*/
		@Query("select max(s.shoushuId) from Shoushu s where s.shoushuId like ?1")
		public String selectLikeRNumber(String dateLike) ;
		
		/**
		 * 右边的表格
		 * @param pages
		 * @return
		 */
		@Query("select new com.ssh.vo.operation.ShouShuVo(s.shoushuId , s.shoushuExplain , s.shoushuName,s.shoushuRemark,s.shoushuType) from Shoushu s")
		public List<ShouShuVo> selectShoushuRight(Pageable pages);
		
		/**
		 * 添加手术项目
		 * @return
		 */
		@Query("select nvl(max(s.shoushuId) + 1 , 1) from Shoushu s")
		public long addShoushuxm();
		
		/**
		 * 添加手术项目自动生成编号，根据日期模糊查询
		 * @return
		 */
		@Query("select nvl(max(s.shoushuId) +1 ,10001) from Shoushu s")
		public String selectSugeryTjbh();
		
	
		 /**
		  * 根据名字查询数据表格
		  * @param shoushuName
		  * @param pages
		  * @return
		  */
		@Query("select new com.ssh.vo.operation.ShouShuVo(s.shoushuId,s.shoushuExplain,s.shoushuName,s.shoushuRemark,s.shoushuType) from Shoushu s where s.shoushuName like ?1 order by s.shoushuId desc")
		public List<ShouShuVo> selectShoushuNameWhere(String shoushuName, Pageable pages);

		@Query("select count(s.shoushuId) from Shoushu s where s.shoushuName like ?1")
		public long selectShoushusNameCount(String shoushuName);
		
		/**
		 * 点击ul,刷新数据表格
		 * @param jt
		 * @param page
		 * @return
		 */
		@Query("select new com.ssh.vo.operation.ShouShuVo(s.shoushuId,s.shoushuExplain,s.shoushuName,s.shoushuRemark,s.shoushuType) from Shoushu s where s.shoushuTypeBean=?1 order by s.id desc")
		public List<ShouShuVo> findShoushuType(ShoushuType st, Pageable page);
		
		@Query("select count(s.id) from Shoushu s where s.shoushuTypeBean=?1")
		public long findShoushuTypeCount(ShoushuType st);
		
}
