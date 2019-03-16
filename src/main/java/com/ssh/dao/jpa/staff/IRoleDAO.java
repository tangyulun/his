package com.ssh.dao.jpa.staff;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.Role;
import com.ssh.vo.staff.RoleVO;
 
public interface IRoleDAO extends CrudRepository<Role, Long> {
	
	/**
	 * 查询所有角色
	 * @param pages
	 * @return
	 */
	@Query("select new com.ssh.vo.staff.RoleVO(r.rolesId , r.rolesDate , r.rolesEffect , r.rolesName)"
			+ " from Role r order by r.id desc")
	public List<RoleVO> findByAllRole(Pageable pages);
	
	/**
	 * 验证角色名
	 * @param rolesName
	 * @return
	 */
	@Query("select r from Role r where r.rolesName =?1")
	public Role findByName(String rolesName);
	
	/**
	 * 查找编号
	 * @return
	 */
	@Query("select nvl(max(r.rolesId) + 1 , 1) from Role r")
	public long findByMaxId();

	/**
	 * 验证角色名
	 * @param rolesName
	 * @param yRolesName
	 * @return
	 */
	@Query("select r from Role r where r.rolesName =?1 and r.rolesName !=?2")
	public Role findByUpdateName(String rolesName, String yRolesName);

	/**
	 * 根据名字模糊查询角色
	 * @param key
	 * @param pages
	 * @return
	 */
	@Query("select new com.ssh.vo.staff.RoleVO(r.rolesId , r.rolesDate , r.rolesEffect , r.rolesName)"
			+ " from Role r where r.rolesName like ?1 order by r.id desc")
	public List<RoleVO> findByWhereRoles(String key, Pageable pages);

	/**
	 * 根基名字模糊查询记录数
	 * @param key
	 * @return
	 */
	@Query("select count(r.rolesId) from Role r where r.rolesName like ?1")
	public long findWhereCount(String key);

	@Query("select new com.ssh.vo.staff.RoleVO(r.rolesId , r.rolesDate , r.rolesEffect , r.rolesName)"
			+ " from Role r order by r.id desc")
	public List<RoleVO> findByAllRoleTo();
}
