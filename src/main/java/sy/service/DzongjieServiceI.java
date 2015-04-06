package sy.service;

import sy.pageModel.Bug;
import sy.pageModel.DataGrid;
import sy.pageModel.Dzongjie;
import sy.pageModel.PageHelper;
import sy.pageModel.User;

public interface DzongjieServiceI {
	/**
	 * 获取用户数据表格
	 * 
	 * @param user
	 * @return
	 */
	public DataGrid dataGrid(Dzongjie zongjie, PageHelper ph);
	/**
	 * 添加用户
	 * 
	 * @param user
	 */
	public void add(Dzongjie zongjie) throws Exception;
	/**
	 * 获得用户对象
	 * 
	 * @param id
	 * @return
	 */
	public Dzongjie get(String id);
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
	public void edit(Dzongjie zongjie);
}
