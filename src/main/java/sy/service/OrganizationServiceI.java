package sy.service;

import java.util.List;

import sy.model.Torganization;
import sy.pageModel.Organization;
import sy.pageModel.SessionInfo;
import sy.pageModel.Tree;

/**
 * 角色业务逻辑
 * 
 * @author 谭楚柱
 * 
 */
public interface OrganizationServiceI {

	/**
	 * 获得机构treeGrid
	 * 
	 * @return
	 */
	public List<Organization> treeGrid(SessionInfo sessionInfo);
	
	/**
	 * 机构树
	 * 
	 * @return
	 */
	public List<Tree> tree(SessionInfo sessionInfo);
	
	/**
	 * 获得机构树
	 * 
	 * @return
	 */
	public List<Tree> allTree();

	/**
	 * 保存机构
	 * 
	 * @param organization
	 */
	public void add(Organization organization, SessionInfo sessionInfo);
	
	/**
	 * 获得机构
	 * 
	 * @param id
	 * @return
	 */
	public Organization get(String id);

	/**
	 * 编辑机构
	 * 
	 * @param role
	 */
	public void edit(Organization organization);
	
	/**
	 * 删除机构
	 * 
	 * @param id
	 */
	public void delete(String id);
	
	/**
	 * 机构修改
	 * 
	 * @param ids
	 * @param organization
	 *          
	 */
	public void grant(String ids, Organization organization);
	
	public List<Torganization> getOrganizationtList();
}
