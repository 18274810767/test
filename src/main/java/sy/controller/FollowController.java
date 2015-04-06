package sy.controller;


import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sy.model.Tfollow;
import sy.pageModel.DataGrid;
import sy.pageModel.Follow;
import sy.pageModel.Json;
import sy.pageModel.PageHelper;
import sy.pageModel.SessionInfo;
import sy.service.FollowServiceI;
import sy.util.ConfigUtil;

@Controller
@RequestMapping("/followController")
public class FollowController {
	
	@Autowired
	private FollowServiceI followService;
	
	/**
	 * 获取客户跟踪数据表格
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("/dataGrid")
	@ResponseBody
	public DataGrid dataGrid(HttpSession session,Follow follow, PageHelper ph) {
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(ConfigUtil.getSessionInfoName());
		return followService.dataGrid(sessionInfo,follow, ph);
	}
	
	/**
	 * 跳转到添加客户跟踪记录页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/addPage")
	public String addPage(HttpServletRequest request,Follow follow) {
		Follow u=new Follow();
		u.setId(UUID.randomUUID().toString());
		u.setCustomerId(follow.getCustomerId());
		request.setAttribute("follower", u);
		return "/customer/follow";
	}
	
	/**
	 * 添加客户跟踪记录
	 * 
	 * @return
	 */
	@RequestMapping("/add")
	@ResponseBody
	public Json add(HttpSession session,Follow follow) {
		Json j = new Json();
		try {
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(ConfigUtil.getSessionInfoName());
			followService.add(sessionInfo,follow);
			j.setSuccess(true);
			j.setMsg("添加成功！");
			j.setObj(follow);
		} catch (Exception e) {
			// e.printStackTrace();
			j.setMsg(e.getMessage());
		}
		return j;
	}
	
}
