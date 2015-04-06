package sy.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sy.pageModel.Bug;
import sy.pageModel.Classmate;
import sy.pageModel.DataGrid;
import sy.pageModel.Json;
import sy.pageModel.PageHelper;
import sy.service.ClassMateServiceI;

/**
 * ClassMate管理控制器
 * 
 * @author 谭楚柱
 * 
 */

@Controller
@RequestMapping("/classMateController")
public class ClassMateController {
	
	@Autowired
	private ClassMateServiceI classMateService;
	
	/**
	 * 跳转到班级管理页面
	 * 
	 * @return
	 */
	@RequestMapping("/manager")
	public String manager(HttpServletRequest request) {
		return "/classmate/classmate";
	}

	/**
	 * 获取班级数据表格
	 * 
	 * @param classmate
	 * @return
	 */
	@RequestMapping("/dataGrid")
	@ResponseBody
	public DataGrid dataGrid(Classmate classmate, PageHelper ph) {
		return classMateService.dataGrid(classmate, ph);
	}

	/**
	 * 跳转到添加班级页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/addPage")
	public String addPage(HttpServletRequest request) {
		Classmate classmate= new Classmate();
		classmate.setId(UUID.randomUUID().toString());
		request.setAttribute("classmate", classmate);
		return "/classmate/classmateAdd";
	}
	
	/**
	 * 添加班级
	 * 
	 * @return
	 */
	@RequestMapping("/add")
	@ResponseBody
	public Json add(Classmate classmate) {
		Json j = new Json();
		try {
			classMateService.add(classmate);
			j.setSuccess(true);
			j.setMsg("添加成功！");
		} catch (Exception e) {
			// e.printStackTrace();
			j.setMsg(e.getMessage());
		}
		return j;
	}
	
	/**
	 * 跳转到班级修改页面
	 * 
	 * @return
	 */
	@RequestMapping("/editPage")
	public String editPage(HttpServletRequest request, String id) {
		Classmate b = classMateService.get(id);
		request.setAttribute("classmate", b);
		return "/classmate/classmateEdit";
	}

	/**
	 * 修改班级
	 * 
	 * @param classmate
	 * @return
	 */
	@RequestMapping("/edit")
	@ResponseBody
	public Json edit(Classmate classmate) {
		Json j = new Json();
		try {
			classMateService.edit(classmate);
			j.setSuccess(true);
			j.setMsg("编辑成功！");
		} catch (Exception e) {
			// e.printStackTrace();
			j.setMsg(e.getMessage());
		}
		return j;
	}

	/**
	 * 删除班级
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public Json delete(String id) {
		Json j = new Json();
		classMateService.delete(id);
		j.setMsg("删除成功！");
		j.setSuccess(true);
		return j;
	}

	/**
	 * 批量删除班级
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
