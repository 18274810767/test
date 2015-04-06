package sy.service;

import javax.servlet.http.HttpSession;

import sy.pageModel.Classmate;
import sy.pageModel.DataGrid;
import sy.pageModel.Chengjiao;
import sy.pageModel.PageHelper;
import sy.pageModel.SessionInfo;

public interface ChengjiaoServiceI {
	
	/**
	 * 获取成交数据表格
	 * 
	 * @param deal
	 * @return
	 */
	public DataGrid dataGrid(Chengjiao c, PageHelper ph);
	/**
	 * 添加成交记录
	 * 
	 * @param classmate
	 * 
	 */
	public void add(Chengjiao c,SessionInfo sessionInfo);

	/**
	 * 获得成交记录
	 * 
	 * @param id
	 * @return
	 */
	public Chengjiao get(String id);

	/**
	 * 修改成交记录
	 * 
	 * @param classmate
	 */
	public void edit(Chengjiao c);

	/**
	 * 删除成交记录
	 * 
	 * @param id
	 */
	public void delete(String id);

}
