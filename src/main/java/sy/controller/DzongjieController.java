package sy.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sy.pageModel.Bug;
import sy.pageModel.DataGrid;
import sy.pageModel.Dzongjie;
import sy.pageModel.Json;
import sy.pageModel.PageHelper;
import sy.pageModel.SessionInfo;
import sy.pageModel.User;
import sy.pageModel.Wzongjie;
import sy.service.DzongjieServiceI;
import sy.util.ConfigUtil;

@Controller
@RequestMapping("/dzongjieController")
public class DzongjieController {
	@Autowired
	private DzongjieServiceI dService;
	
	/**
	 * 添加用户
	 * 
	 * @return
	 */
	@RequestMapping("/add")
	@ResponseBody
	public Json add(Dzongjie zongjie) {
		Json j = new Json();
		try {
			dService.add(zongjie);
			j.setSuccess(true);
			j.setMsg("添加成功！");
			j.setObj(zongjie);
		} catch (Exception e) {
			// e.printStackTrace();
			j.setMsg(e.getMessage());
		}
		return j;
	}
	
	@RequestMapping("/addPage")
	public String addPage(HttpServletRequest request){
		Dzongjie d=new Dzongjie();
		d.setId(UUID.randomUUID().toString());
		request.setAttribute("zongjie", d);
		return "/zongjie/dzongjieAdd";
	}
	
	/**
	 * 跳转到用户管理页面
	 * 
	 * @return
	 */
	@RequestMapping("/manager")
	public String manager() {
		return "/zongjie/dzongjie";
	}
	/**
	 * 获取用户数据表格
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("/dataGrid")
	@ResponseBody
	public DataGrid dataGrid(Dzongjie zongjie, PageHelper ph) {
		return dService.dataGrid(zongjie, ph);
	}
	
	/**
	 * 修改日报
	 * 
	 * @param bug
	 * @return
	 */
	@RequestMapping("/edit")
	@ResponseBody
	public Json edit(Dzongjie zongjie) {
		Json j = new Json();
		try {
			dService.edit(zongjie);
			j.setSuccess(true);
			j.setMsg("编辑成功！");
		} catch (Exception e) {
			// e.printStackTrace();
			j.setMsg(e.getMessage());
		}
		return j;
	}
	
	/**
	 * 跳转到用户修改页面
	 * 
	 * @return
	 */
	@RequestMapping("/editPage")
	public String editPage(HttpServletRequest request, String id) {
		Dzongjie u = dService.get(id);
		request.setAttribute("zongjie", u);
		return "/zongjie/dzongjieEdit";
	}
	
	/**
	 * 删除日报
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public Json delete(String id, HttpSession session) {
		Json j = new Json();
		dService.delete(id);
		j.setMsg("删除成功！");
		j.setSuccess(true);
		return j;
	}
	
	/**
	 * 跳转到周报查看页面
	 * 
	 * @return
	 */
	@RequestMapping("/view")
	public String view(HttpServletRequest request, String id) {
		Dzongjie b = dService.get(id);
		request.setAttribute("zongjie", b);
		return "/zongjie/dzongjieView";
	}
	/**
	 * 批量删除日报
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
