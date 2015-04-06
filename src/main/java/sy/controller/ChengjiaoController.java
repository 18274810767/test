package sy.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sy.pageModel.DataGrid;
import sy.pageModel.Chengjiao;
import sy.pageModel.Json;
import sy.pageModel.PageHelper;
import sy.pageModel.SessionInfo;
import sy.service.ChengjiaoServiceI;
import sy.util.ConfigUtil;

@Controller
@RequestMapping("/chengjiaoController")
public class ChengjiaoController {

	@Autowired
	private ChengjiaoServiceI chengjiaoService;
	
	/**
	 * 跳转到成交管理页面
	 * 
	 * @return
	 */
	@RequestMapping("/manager")
	private String manager(){
		return "/chengjiao/chengjiao";
	}
	
	/**
	 * 获取成交数据表格
	 * 
	 * @param deal
	 * @return
	 */
	@RequestMapping("/dataGrid")
	@ResponseBody
	public DataGrid dataGrid(Chengjiao c, PageHelper ph) {
		return chengjiaoService.dataGrid(c, ph);
	}
	
	/**
	 * 跳转到添加成交记录页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/addPage")
	public String addPage(HttpServletRequest request) {
		Chengjiao chengjiao= new Chengjiao();
		chengjiao.setId(UUID.randomUUID().toString());
		request.setAttribute("cj", chengjiao);
		return "/chengjiao/chengjiaoAdd";
	}
	
	/**
	 * 添加成交记录
	 * 
	 * @return
	 */
	@RequestMapping("/add")
	@ResponseBody
	public Json add(Chengjiao cj,HttpSession session) {
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(ConfigUtil.getSessionInfoName());
		Json j = new Json();
		try {
			chengjiaoService.add(cj, sessionInfo);
			j.setSuccess(true);
			j.setMsg("添加成功！");
		} catch (Exception e) {
			// e.printStackTrace();
			j.setMsg(e.getMessage());
		}
		return j;
	}
	
	/**
	 * 跳转到成交记录修改页面
	 * 
	 * @return
	 */
	@RequestMapping("/editPage")
	public String editPage(HttpServletRequest request, String id) {
		Chengjiao b = chengjiaoService.get(id);
		request.setAttribute("cj", b);
		return "/chengjiao/chengjiaoEdit";
	}

	/**
	 * 修改成交记录
	 * 
	 * @param classmate
	 * @return
	 */
	@RequestMapping("/edit")
	@ResponseBody
	public Json edit(Chengjiao cj) {
		Json j = new Json();
		try {
			chengjiaoService.edit(cj);
			j.setSuccess(true);
			j.setMsg("编辑成功！");
		} catch (Exception e) {
			// e.printStackTrace();
			j.setMsg(e.getMessage());
		}
		return j;
	}

	/**
	 * 删除成交记录
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public Json delete(String id) {
		Json j = new Json();
		chengjiaoService.delete(id);
		j.setMsg("删除成功！");
		j.setSuccess(true);
		return j;
	}

	/**
	 * 批量删除成交记录
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
					this.delete(id);
				}
			}
		}
		j.setMsg("批量删除成功！");
		j.setSuccess(true);
		return j;
	}
}
