package sy.service;

import sy.pageModel.DataGrid;
import sy.pageModel.PageHelper;
import sy.pageModel.Wzongjie;

public interface WzongjieServiceI {
	/**
	 * 获取用户数据表格
	 * 
	 * @param user
	 * @return
	 */
	public DataGrid dataGrid(Wzongjie zongjie, PageHelper ph);
	/**
	 * 添加用户
	 * 
	 * @param user
	 */
	public void add(Wzongjie zongjie) throws Exception;
	/**
	 * 获得用户对象
	 * 
	 * @param id
	 * @return
	 */
	public Wzongjie get(String id);
	/**
	 * 删除用户
	 * 
	 * @param id
	 */
	public void delete(String id);
	/**
	 * 修改日报
	 * 
	 * @param bug
	 */
	public void edit(Wzongjie zongjie);

}
