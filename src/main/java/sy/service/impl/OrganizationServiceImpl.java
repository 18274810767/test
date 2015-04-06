package sy.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sy.dao.OrganizationDaoI;
import sy.dao.UserDaoI;
import sy.model.Torganization;
import sy.model.Tresource;
import sy.model.Trole;
import sy.model.Tuser;
import sy.pageModel.Organization;
import sy.pageModel.SessionInfo;
import sy.pageModel.Tree;
import sy.pageModel.User;
import sy.service.OrganizationServiceI;

@Service
public class OrganizationServiceImpl implements OrganizationServiceI {

	@Autowired
	private OrganizationDaoI organizationDao;
	
	@Autowired
	private UserDaoI userDao;
	
	@Override
	public List<Organization> treeGrid(SessionInfo sessionInfo) {
		List<Organization> rl = new ArrayList<Organization>();
		List<Torganization> tl = null;
		Map<String, Object> params = new HashMap<String, Object>();
		/*if (sessionInfo != null) {
			params.put("userId", sessionInfo.getId());// 查自己有权限的角色
			tl = organizationDao.find("select distinct t from Torganization t left join fetch t.tresources resource join fetch t.tusers user where user.id = :userId order by t.seq", params);
		} else {
		}*/
		tl = organizationDao.find("select distinct t from Torganization t  order by t.seq");
		if (tl != null && tl.size() > 0) {
			for (Torganization t : tl) {
				Organization r = new Organization();
				BeanUtils.copyProperties(t, r);
				r.setIconCls("chart_pie");
				if (t.getTorganization() != null) {
					r.setPid(t.getTorganization().getId());
					r.setPname(t.getTorganization().getName());
				}
				
				if(t.getNote()!=null){
					Tuser tuser=userDao.get(Tuser.class, t.getNote());
					r.setUserNames(tuser.getName());
				}
				
				rl.add(r);
			}
		}
		return rl;
	}

	@Override
	public List<Tree> allTree() {
		return this.tree(null);
	}

	@Override
	public List<Tree> tree(SessionInfo sessionInfo) {
		List<Torganization> l = null;
		List<Tree> lt = new ArrayList<Tree>();
		
		l = organizationDao.find("from Torganization t order by t.seq");

		if (l != null && l.size() > 0) {
			for (Torganization t : l) {
				Tree tree = new Tree();
				BeanUtils.copyProperties(t, tree);
				tree.setText(t.getName());
				tree.setIconCls("chart_pie");
				if (t.getTorganization() != null) {
					tree.setPid(t.getTorganization().getId());
				}
				lt.add(tree);
			}
		}
		return lt;
	}

	@Override
	public void add(Organization organization, SessionInfo sessionInfo) {
		Torganization t = new Torganization();
		BeanUtils.copyProperties(organization, t);
		if (organization.getPid() != null && !organization.getPid().equalsIgnoreCase("")) {
			t.setTorganization(organizationDao.get(Torganization.class, organization.getPid()));
		}
		organizationDao.save(t);

/*		// 刚刚添加的角色，赋予给当前的用户
		Tuser user = userDao.get(Tuser.class, sessionInfo.getId());
		user.getTroles().add(t);*/
		
	}

	@Override
	public Organization get(String id) {
		Organization r = new Organization();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		Torganization t = organizationDao.get("select distinct t from Torganization t  where t.id = :id", params);
		if (t != null) {
			BeanUtils.copyProperties(t, r);
			if (t.getTorganization() != null) {
				r.setPid(t.getTorganization().getId());
				r.setPname(t.getTorganization().getName());
			}
			


		}
		return r;
	}

	@Override
	public void edit(Organization organization) {
		Torganization t = organizationDao.get(Torganization.class, organization.getId());
		if (t != null) {
			BeanUtils.copyProperties(organization, t);
			if (organization.getPid() != null && !organization.getPid().equalsIgnoreCase("")) {
				t.setTorganization(organizationDao.get(Torganization.class, organization.getPid()));
			}
			if (organization.getPid() != null && !organization.getPid().equalsIgnoreCase("")) {// 说明前台选中了上级资源
				Torganization pt = organizationDao.get(Torganization.class, organization.getPid());
				isChildren(t, pt);// 说明要将当前资源修改到当前资源的子/孙子资源下
				t.setTorganization(pt);
			} else {
				t.setTorganization(null);// 前台没有选中上级资源，所以就置空
			}
		}
		
	}
	
	/**
	 * 判断是否是将当前节点修改到当前节点的子节点
	 * 
	 * @param t
	 *            当前节点
	 * @param pt
	 *            要修改到的节点
	 * @return
	 */
	private boolean isChildren(Torganization t, Torganization pt) {
		if (pt != null && pt.getTorganization() != null) {
			if (pt.getTorganization().getId().equalsIgnoreCase(t.getId())) {
				pt.setTorganization(null);
				return true;
			} else {
				return isChildren(t, pt.getTorganization());
			}
		}
		return false;
	}

	@Override
	public void delete(String id) {
		Torganization t = organizationDao.get(Torganization.class, id);
		del(t);
	}
	
	private void del(Torganization t) {
		if (t.getTorganizations() != null && t.getTorganizations().size() > 0) {
			for (Torganization r : t.getTorganizations()) {
				del(r);
			}
		}
		organizationDao.delete(t);
	}

	@Override
	public void grant(String ids, Organization organization) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", organization.getId());
			Torganization t = organizationDao.get("select distinct t from Torganization t  where t.id = :id", params);
			if (t != null) {
				t.setNote(organization.getUserIds());
				organizationDao.saveOrUpdate(t);
			}
		
	}

	@Override
	public List<Torganization> getOrganizationtList() {
		return organizationDao.find("from Torganization t");
	}
	}


