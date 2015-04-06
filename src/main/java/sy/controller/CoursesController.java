package sy.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sy.pageModel.Courses;
import sy.pageModel.DataGrid;
import sy.pageModel.Json;
import sy.pageModel.PageHelper;
import sy.service.CoursesServiceI;


/**
 * 课程控制器
 * 
 * @author 谭楚柱
 * 
 */
@Controller
@RequestMapping("/coursesController")
public class CoursesController extends BaseController {

	@Autowired
	private CoursesServiceI CoursesService;

	/**
	 * 跳转到课程管理页面
	 * 
	 * @return
	 */
	@RequestMapping("/manager")
	public String manager() {
		return "/courses/courses";
	}

	/**
	 * 获取课程数据表格
	 * 
	 * @param courses
	 * @return
	 */
	@RequestMapping("/dataGrid")
	@ResponseBody
	public DataGrid dataGrid(Courses courses, PageHelper ph) {
		return CoursesService.dataGrid(courses, ph);
	}

	/**
	 * 跳转到添加课程页面
	 * 
	 * @param request 
	 * @return
	 */
	@RequestMapping("/addPage")
	public String addPage(HttpServletRequest request) {
		Courses u = new Courses();
		u.setId(UUID.randomUUID().toString());
		request.setAttribute("courses", u);
		return "/courses/coursesAdd";
	}

	/**
	 * 添加课程
	 * 
	 * @return
	 */
	@RequestMapping("/add")
	@ResponseBody
	public Json add(Courses courses) {
		Json j = new Json();
		try {
			CoursesService.add(courses);
			j.setSuccess(true);
			j.setMsg("添加成功！");
			j.setObj(courses);
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
		Courses u = CoursesService.get(id);
		request.setAttribute("courses", u);
		return "/courses/coursesEdit";
	}

	/**
	 * 修改课程
	 * 
	 * @param courses
	 * @return
	 */
	@RequestMapping("/edit")
	@ResponseBody
	public Json edit(Courses courses) {
		Json j = new Json();
		try {
			CoursesService.edit(courses);
			j.setSuccess(true);
			j.setMsg("编辑成功！");
			j.setObj(courses);
		} catch (Exception e) {
			// e.printStackTrace();
			j.setMsg(e.getMessage());
		}
		return j;
	}

	/**
	 * 删除课程
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public Json delete(String id, HttpSession session) {
		Json j = new Json();
		CoursesService.delete(id);
		j.setMsg("删除成功！");
		j.setSuccess(true);
		return j;
	}

	/**
	 * 批量删除课程
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
