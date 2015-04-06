package sy.service;

import sy.pageModel.DataGrid;
import sy.pageModel.JiNianRi;
import sy.pageModel.PageHelper;
import sy.pageModel.SessionInfo;

public interface JiNianRiServiceI {
	
	public DataGrid dataGrid(SessionInfo sessionInfo,JiNianRi jnr, PageHelper ph);

	public void add(SessionInfo sessionInfo,JiNianRi jnr) throws Exception;

}
