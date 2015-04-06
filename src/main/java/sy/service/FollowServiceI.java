package sy.service;

import sy.pageModel.DataGrid;
import sy.pageModel.Follow;
import sy.pageModel.PageHelper;
import sy.pageModel.SessionInfo;

public interface FollowServiceI {
	
	public DataGrid dataGrid(SessionInfo sessionInfo,Follow follow, PageHelper ph);

	public void add(SessionInfo sessionInfo,Follow follow) throws Exception;

}
