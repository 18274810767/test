package sy.dao;

import sy.model.Torganization;

/**
 * 角色数据库操作类
 * 
 * @author 谭楚柱
 * 
 */
public interface OrganizationDaoI extends BaseDaoI<Torganization> {
	
	public Torganization getById(String id);
}
