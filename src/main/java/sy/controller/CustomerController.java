package sy.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sy.pageModel.Customer;
import sy.pageModel.DataGrid;
import sy.pageModel.Json;
import sy.pageModel.PageHelper;
import sy.pageModel.SessionInfo;
import sy.pageModel.Tree;
import sy.pageModel.User;
import sy.service.CoursesServiceI;
import sy.service.CustomerServiceI;
import sy.util.ConfigUtil;

/**
 * 客户控制器
 * 
 * @author 谭楚柱
 * 
 */
@Controller
@RequestMapping("/customerController")
public class CustomerController extends BaseController {

	@Autowired
	private CustomerServiceI customerService;
	
	@Autowired
	private CoursesServiceI coursesService;

	/**
	 * 跳转到客户管理页面
	 * 
	 * @return
	 */
	@RequestMapping("/manager")
	public String manager() {
		return "/customer/customer";
	}

	/**
	 * 跳转到我的客户管理页面
	 * 
	 * @return
	 */
	@RequestMapping("/qManager")
	public String qManager() {
		return "/myCutomer/customer";
	}
	
	/**
	 * 获取客户数据表格
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("/dataGrid")
	@ResponseBody
	public DataGrid dataGrid(HttpSession session, Customer customer, PageHelper ph) {
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(ConfigUtil.getSessionInfoName());
		return customerService.dataGrid(sessionInfo,customer, ph);
	}
	
	/**
	 * 获取客户数据表格
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("/qDataGrid")
	@ResponseBody
	public DataGrid qDataGrid(HttpSession session, Customer customer, PageHelper ph) {
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(ConfigUtil.getSessionInfoName());
		return customerService.qDataGrid(sessionInfo,customer, ph);
	}
	
	/**
	 * 跳转到添加客户页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/addPage")
	public String addPage(HttpServletRequest request) {
		Customer u = new Customer();
		u.setId(UUID.randomUUID().toString());
		request.setAttribute("courseList", coursesService.getCourseList());
		request.setAttribute("customer", u);
		return "/customer/customerAdd";
	}
	
	/**
	 * 课程树
	 * 
	 * @return
	 */
	@RequestMapping("/tree")
	@ResponseBody
	public List<Tree> tree(HttpSession session) {
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(ConfigUtil.getSessionInfoName());
		return coursesService.tree(sessionInfo);
	}

	/**
	 * 跳转到课程选择页面
	 * 
	 * @return
	 */
	@RequestMapping("/choiceCoursePage")
	public String choiceCoursePage(String ids, HttpServletRequest request) {
		request.setAttribute("ids", ids);
		if (ids != null && !ids.equalsIgnoreCase("") && ids.indexOf(",") == -1) {
			Customer u = customerService.get(ids);
			request.setAttribute("customer", u);
		}
		return "/customer/choiceCourse";
	}
	
	/**
	 * 客户选择课程
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping("/choiceCourse")
	@ResponseBody
	public Json choiceCourse(String ids, Customer customer) {
		Json j = new Json();
		customerService.grant(ids, customer);
		j.setSuccess(true);
		j.setMsg("授权成功！");
		return j;
	}
	
	/**
	 * 添加客户
	 * 
	 * @return
	 */
	@RequestMapping("/add")
	@ResponseBody
	public Json add(HttpSession session, Customer customer) {
		Json j = new Json();
		try {
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(ConfigUtil.getSessionInfoName());
			customerService.add(sessionInfo,customer);
			j.setSuccess(true);
			j.setMsg("添加成功！");
			j.setObj(customer);
		} catch (Exception e) {
			// e.printStackTrace();
			j.setMsg(e.getMessage());
		}
		return j;
	}

	/**
	 * 跳转到客户修改页面
	 * 
	 * @return
	 */
	@RequestMapping("/editPage")
	public String editPage(HttpServletRequest request, String id) {
		Customer u = customerService.get(id);
		request.setAttribute("customer", u);
		return "/customer/customerEdit";
	}

	/**
	 * 修改用户
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("/edit")
	@ResponseBody
	public Json edit(Customer customer) {
		Json j = new Json();
		try {
			customerService.edit(customer);
			j.setSuccess(true);
			j.setMsg("编辑成功！");
			j.setObj(customer);
		} catch (Exception e) {
			// e.printStackTrace();
			j.setMsg(e.getMessage());
		}
		return j;
	}

	/**
	 * 删除客户
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public Json delete(String id, HttpSession session) {
		Json j = new Json();
		customerService.delete(id);
		j.setMsg("删除成功！");
		j.setSuccess(true);
		return j;
	}

	/**
	 * 批量删除客户
	 * 
	 * @param ids
	 *            ('0','1','2')
	 * @return
	 */
	@RequestMapping("/batchDelete")
	@ResponseBody
	public Json batchDelete(String ids, HttpSession session) {
		Json j = new Json();
		if (ids != null && ids.length() > 0) {
			for (String id : ids.split(",")) {
				if (id != null) {
					this.delete(id, session);
				}
			}
		}
		j.setMsg("批量删除成功！");
		j.setSuccess(true);
		return j;
	}
	
}
