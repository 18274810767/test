package sy.service;


import sy.pageModel.Customer;
import sy.pageModel.DataGrid;
import sy.pageModel.PageHelper;
import sy.pageModel.SessionInfo;
public interface CustomerServiceI {
	/**
	 * 获取用户数据表格
	 * 
	 * @param user
	 * @return
	 */
	public DataGrid dataGrid(SessionInfo sessionInfo,Customer customer, PageHelper ph);
	
	/**
	 * 获取用户数据表格
	 * 
	 * @param user
	 * @return
	 */
	public DataGrid qDataGrid(SessionInfo sessionInfo,Customer customer, PageHelper ph);
	


	/**
	 * 添加用户
	 * 
	 * @param user
	 */
	public void add(SessionInfo sessionInfo,Customer customer) throws Exception;

	/**
	 * 获得用户对象
	 * 
	 * @param id
	 * @return
	 */
	public Customer get(String id);

	/**
	 * 编辑用户
	 * 
	 * @param user
	 */
	public void edit(Customer customer) throws Exception;

	/**
	 * 删除用户
	 * 
	 * @param id
	 */
	public void delete(String id);
	
	/**
	 * 课程选择
	 * 
	 * @param ids
	 * @param customer
	 *          
	 */
	public void grant(String ids, Customer customer);
}
