package sy.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sy.pageModel.Json;
import sy.pageModel.Organization;
import sy.pageModel.Role;
import sy.pageModel.SessionInfo;
import sy.pageModel.Tree;
import sy.service.OrganizationServiceI;
import sy.service.RoleServiceI;
import sy.util.ConfigUtil;

/**
 * 角色控制器
 * 
 * @author 谭楚柱
 * 
 */
@Controller
@RequestMapping("/organizationController")
public class OrganizationController extends BaseController {

	@Autowired
	private RoleServiceI roleService;
	
	@Autowired
	private OrganizationServiceI OrganizationService;

	/**
	 * 跳转到组织机构管理页面
	 * 
	 * @return
	 */
	@RequestMapping("/manager")
	public String manager() {
		return "/organizations/organization";
	}

	/**
	 * 跳转到机构添加页面
	 * 
	 * @return
	 */
	@RequestMapping("/addPage")
	public String addPage(HttpServletRequest request) {
		Organization r = new Organization();
		r.setId(UUID.randomUUID().toString());
		request.setAttribute("organization", r);
		return "/organizations/organizationAdd";
	}

	/**
	 * 添加角色
	 * 
	 * @return
	 */
	@RequestMapping("/add")
	@ResponseBody
	public Json add(Organization organization, HttpSession session) {
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(ConfigUtil.getSessionInfoName());
		Json j = new Json();
		OrganizationService.add(organization, sessionInfo);
		j.setSuccess(true);
		j.setMsg("添加成功！");
		return j;
	}

	/**
	 * 跳转到机构修改页面
	 * 
	 * @return
	 */
	@RequestMapping("/editPage")
	public String editPage(HttpServletRequest request, String id) {
		Organization r = OrganizationService.get(id);
		request.setAttribute("organization", r);
		return "/organizations/organizationEdit";
	}

	/**
	 * 修改角色
	 * 
	 * @param role
	 * @return
	 */
	@RequestMapping("/edit")
	@ResponseBody
	public Json edit(Organization organization) {
		Json j = new Json();
		OrganizationService.edit(organization);
		j.setSuccess(true);
		j.setMsg("编辑成功！");
		return j;
	}

	/**
	 * 获得角色列表
	 * 
	 * @return
	 */
	@RequestMapping("/treeGrid")
	@ResponseBody
	public List<Organization> treeGrid(HttpSession session) {
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(ConfigUtil.getSessionInfoName());
		return OrganizationService.treeGrid(sessionInfo);
	}

	/**
	 * 机构树
	 * 
	 * @return
	 */
	@RequestMapping("/tree")
	@ResponseBody
	public List<Tree> tree(HttpSession session) {
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(ConfigUtil.getSessionInfoName());
		return OrganizationService.tree(sessionInfo);
	}

	/**
	 * 机构树
	 * 
	 * @return
	 */
	@RequestMapping("/allTree")
	@ResponseBody
	public List<Tree> allTree() {
		return OrganizationService.allTree();
	}

	/**
	 * 删除机构
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public Json delete(String id) {
		Json j = new Json();
		OrganizationService.delete(id);
		j.setMsg("删除成功！");
		j.setSuccess(true);
		return j;
	}

	/**
	 * 跳转到用户授权页面
	 * 
	 * @return
	 */
	@RequestMapping("/grantPage")
	public String grantPage(HttpServletRequest request, String id) {
		Organization organization=OrganizationService.get(id);
		request.setAttribute("organization", organization);
		return "/admin/userGrant";
	}

	/**
	 * 授权
	 * 
	 * @param role
	 * @return
	 */
	@RequestMapping("/grant")
	@ResponseBody
	public Json grant(Role role) {
		Json j = new Json();
		roleService.grant(role);
		j.setMsg("授权成功！");
		j.setSuccess(true);
		return j;
	}

}
