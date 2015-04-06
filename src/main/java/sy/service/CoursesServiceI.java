package sy.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import sy.model.Tcourses;
import sy.model.Tsolarytype;
import sy.pageModel.Courses;
import sy.pageModel.DataGrid;
import sy.pageModel.PageHelper;
import sy.pageModel.SessionInfo;
import sy.pageModel.Tree;

public interface CoursesServiceI {
	/**
	 * 获取课程数据表格
	 * 
	 * @param classes
	 * @return
	 */
	public DataGrid dataGrid(Courses courses, PageHelper ph);

	/**
	 * 添加课程
	 * 
	 * @param classes
	 */
	public void add(Courses courses) throws Exception;

	/**
	 * 获得课程对象
	 * 
	 * @param id
	 * @return
	 */
	public Courses get(String id);

	/**
	 * 编辑课程
	 * 
	 * @param courses
	 */
	public void edit(Courses courses) throws Exception;

	/**
	 * 删除课程
	 * 
	 * @param id
	 */
	public void delete(String id);
	
	/**
	 * 课程列表
	 * 
	 */
	public List<Tcourses> getCourseList();
	
	/**
	 * 课程树
	 * 
	 */
	public List<Tree> tree(SessionInfo session) ;
	
	
}
