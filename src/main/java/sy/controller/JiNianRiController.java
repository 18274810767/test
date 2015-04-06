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
import sy.pageModel.JiNianRi;
import sy.pageModel.Json;
import sy.pageModel.PageHelper;
import sy.pageModel.SessionInfo;
import sy.service.FollowServiceI;
import sy.service.JiNianRiServiceI;
import sy.util.ConfigUtil;

@Controller
@RequestMapping("/jiNianRiController")
public class JiNianRiController {
	
	@Autowired
	private JiNianRiServiceI jiNianRiService;
	
	/**
	 * 获取纪念日数据表格
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("/dataGrid")
	@ResponseBody
	public DataGrid dataGrid(HttpSession session,JiNianRi jnr, PageHelper ph) {
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(ConfigUtil.getSessionInfoName());
		return jiNianRiService.dataGrid(sessionInfo,jnr, ph);
	}
	
	/**
	 * 跳转到添加纪念日页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/addPage")
	public String addPage(HttpServletRequest request,JiNianRi jnr) {
		JiNianRi u=new JiNianRi();
		u.setId(UUID.randomUUID().toString());
		u.setCustomerId(jnr.getCustomerId());
		request.setAttribute("jnr", u);
		return "/customer/jnr";
	}
	
	/**
	 * 添加纪念日
	 * 
	 * @return
	 */
	@RequestMapping("/add")
	@ResponseBody
	public Json add(HttpSession session,JiNianRi jnr) {
		Json j = new Json();
		try {
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(ConfigUtil.getSessionInfoName());
			jiNianRiService.add(sessionInfo,jnr);
			j.setSuccess(true);
			j.setMsg("添加成功！");
			j.setObj(jnr);
		} catch (Exception e) {
			// e.printStackTrace();
			j.setMsg(e.getMessage());
		}
		return j;
	}
	
}
