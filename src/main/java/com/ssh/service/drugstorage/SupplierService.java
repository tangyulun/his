package com.ssh.service.drugstorage;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.method.annotation.ErrorsMethodArgumentResolver;

import com.ssh.dao.jpa.drugstorage.ISupplierDao;
import com.ssh.dao.jpa.drugstorage.ISupplierTypeDao;
import com.ssh.pojos.Supplier;
import com.ssh.pojos.SupplierType;
import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;
import com.ssh.vo.drugstorage.ParentTypeVo;
import com.ssh.vo.drugstorage.SupplierTypeVo;
import com.ssh.vo.drugstorage.SupplierVo;

@Service
@Transactional
public class SupplierService {
	@Autowired
	private ISupplierDao ISDao;
	@Autowired
	private ISupplierTypeDao ISTDao;
	
	/*private List<SupplierVo> list = new ArrayList<>();*/
	
	/**
	 * 查询供应商
	 * @return
	 */
	public List<SupplierVo> findAll(){
		List<SupplierVo> list=ISDao.findAllSupplierVo();
		for (SupplierVo s : list) {
			s.setSupplierTypeVo(ISTDao.findAllSupplier(ISDao.findOne(s.getSupplierId())));
		}
		return list;
	}
	
	/**
	 * 自动生成id编号
	 * @return
	 */
	public String findId(){
		return ISDao.findId();
	}
	
	/**
	 * 新增供应商分类
	 * @param SName
	 */
	public Errors insertSupplierType(String SName){
		try{
			SupplierType type=new SupplierType();
			type.setSupplierTypeId(ISTDao.selectSupplierId());
			type.setSupplierTypeName(SName);
			ISTDao.save(type);
			return new Errors(true);
		}catch (Exception e) {
			return new Errors(e.getMessage());
		}
	}
	
	/**
	 * 分页查询所有供应商
	 * @return
	 */
	public List<SupplierVo> selectAllSupplier(int curpage,int pagesize){
		PageRequest page=new PageRequest(curpage-1,pagesize);
		List<SupplierVo> list=ISDao.selectAllSupplierVo(page);
		findSupplierTypeAll(list);
		return list;
	}
	/**
	 * 查询所有供应商
	 * @return
	 */
	public List<SupplierVo> selectAll(){
		return ISDao.selectAllSupplierV();
	}
	
	/**
	 * 查询总的记录数
	 * @return
	 */
	public long count(){
		return ISDao.count();
	}
	
	/**
	 * 根据id删除供应商
	 * @param supplierId
	 * @return
	 */
	public Errors deleteOneSupplier(String supplierId){
		try {
			Supplier listVo=ISDao.findOne(supplierId);
			ISDao.delete(listVo);
			return new Errors(true);
		} catch (Exception e) {
			e.printStackTrace();
			return new Errors(e.getMessage());
		}
	}
	
	/**
	 * 从数据库中查询数据到树状图
	 * @return
	 */
	public List<ParentTypeVo> findSupplierType(){
		List<SupplierTypeVo> st=ISTDao.findAllSupplierType();
		 List<ParentTypeVo> list = new ArrayList<>();
		 list.add(new ParentTypeVo(1, "供应商分类结构", st));
		return list;
	}
	
	/**
	 * 查询所有供应商分类
	 * @return
	 */
	public List<SupplierTypeVo> findAllSupplierType(){
		return ISTDao.findAllSupplierType();
	}
	
	/**
	 * 查询是否有相同的供应商分类名称
	 * @param supplierTypeName
	 * @return
	 */
	public Errors findSupplierTypeName(String SName){
		SupplierType st=ISTDao.findSupplierTypeName(SName);
		return st == null ? new Errors(true) : new Errors();
	}
	
	/**
	 * 根据供应商分类id修改分类名称
	 * @param supplierTypeId
	 * @param SName
	 * @return
	 */
	public Errors updateSupplierType(Long supplierTypeId,String supplierTypeName){
		try {
			SupplierType st=ISTDao.findOne(supplierTypeId);
			st.setSupplierTypeName(supplierTypeName);
			return new Errors(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Errors(e.getMessage());
		}
	}
	
	/**
	 * 根据供应商编号修改供应商信息
	 * @param supplierId
	 * @param sup
	 * @return
	 */
	public Errors updateSupplier(String supplierId,Supplier sup,Long TypeId){
		try {
			Supplier sl=ISDao.findOne(supplierId);
			sl.setSupplierName(sup.getSupplierName());
			sl.setSupplierAddress(sup.getSupplierAddress());
			sl.setSupplierBgdz(sup.getSupplierBgdz());
			sl.setSupplierBurman(sup.getSupplierBurman());
			sl.setSupplierFkfs(sup.getSupplierFkfs());
			sl.setSupplierGsxz(sup.getSupplierGsxz());
			sl.setSupplierIssh(sup.getSupplierIssh());
			sl.setSupplierJc(sup.getSupplierJc());
			sl.setSupplierJzfs(sup.getSupplierJzfs());
			sl.setSupplierLxr(sup.getSupplierLxr());
			sl.setSupplierPd(sup.getSupplierPd());
			sl.setSupplierPhone(sup.getSupplierPhone());
			sl.setSupplierShfs(sup.getSupplierShfs());
			sl.setSupplierSm(sup.getSupplierSm());
			sl.setSupplierType(ISTDao.findOne(TypeId));
			return new Errors(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Errors(e.getMessage());
		}
	}
	
	/**
	 * 新增供应商
	 * @param StypeId
	 * @param supplier
	 * @return
	 */
	public Errors insertSupplier(Long TypeId,Supplier supplier){
		try {
			supplier.setSupplierType(ISTDao.findOne(TypeId));
			ISDao.save(supplier);
			return new Errors(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Errors(e.getMessage());
		}
		
	}
	
	public void findSupplierTypeAll(List<SupplierVo> list){
		for (SupplierVo s : list) {
			System.out.println(ISDao.findOne(s.getSupplierId())+"11111");
			System.out.println(ISDao.findOne(s.getSupplierId()).getSupplierType()+"22222");
			System.out.println(ISDao.findOne(s.getSupplierId()).getSupplierType().getSupplierTypeId()+"33333");
			System.out.println(ISDao.findOne(s.getSupplierId()).getSupplierType().getSupplierTypeName()+"44444");
			s.setSupplierTypeVo(new SupplierTypeVo(ISDao.findOne(s.getSupplierId()).getSupplierType().getSupplierTypeId(),
					ISDao.findOne(s.getSupplierId()).getSupplierType().getSupplierTypeName()));
		}
	}
	
	/**
	 * 根据供应商类型分页查询供应商信息
	 * @param page
	 * @param rows
	 * @param typeId
	 * @return
	 */
	public List<SupplierVo> querySupplierTypeId(int page,int rows,long typeId){
		SupplierType st=ISTDao.findOne(typeId);
		List<SupplierVo> list=ISDao.selectSupplierByTypeId(st, new PageRequest(page-1, rows));
		findSupplierTypeAll(list);
		return list;
	}
	
	/**
	 * 记录总页数
	 * @param typeId
	 * @return
	 */
	public long querySupplierTypeCount(long typeId){
		SupplierType st=ISTDao.findOne(typeId);
		return ISDao.findByTypeSupplierCount(st);
	}
	
	/**
	 * 模糊查询供应商信息
	 * @param supplierName
	 * @return
	 */
	public List<SupplierVo> mohufindSupplier(int page,int rows,String supplierName){
		List<SupplierVo> list = ISDao.mohuSupplierVo("%"+supplierName+"%",new PageRequest(page - 1, rows));
		findSupplierTypeAll(list);
		return list;
	}
	
	public long mohuoSuplierCount(String supplierName){
		return ISDao.mohuSupplierCount(supplierName);
	}
}
