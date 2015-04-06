package sy.service;

import sy.pageModel.Bug;
import sy.pageModel.Classmate;
import sy.pageModel.DataGrid;
import sy.pageModel.PageHelper;

/**
 * 
 * @author 谭楚柱
 * 
 */
public interface ClassMateServiceI {

	/**
	 * 获取ClassMate数据表格
	 * 
	 * @param classmate
	 *            参数
	 * @param ph
	 *            分页帮助类
	 * @return
	 */
	public DataGrid dataGrid(Classmate classmate, PageHelper ph);
	
	/**
	 * 添加班级
	 * 
	 * @param classmate
	 * 
	 */
	public void add(Classmate classmate);

	/**
	 * 获得班级对象
	 * 
	 * @param id
	 * @return
	 */
	public Classmate get(String id);

	/**
	 * 修改班级
	 * 
	 * @param classmate
	 */
	public void edit(Classmate classmate);

	/**
	 * 删除班级
	 * 
	 * @param id
	 */
	public void delete(String id);
}
