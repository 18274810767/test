package sy.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sy.dao.CoursesDaoI;
import sy.dao.CustomerDaoI;
import sy.dao.FollowDaoI;
import sy.dao.SolaryTypeDaoI;
import sy.dao.UserDaoI;
import sy.model.Tcourses;
import sy.model.Tcustomer;
import sy.model.Tfollow;
import sy.model.Torganization;
import sy.model.Trole;
import sy.model.Tsolarytype;
import sy.model.Tuser;
import sy.pageModel.Customer;
import sy.pageModel.DataGrid;
import sy.pageModel.Follow;
import sy.pageModel.PageHelper;
import sy.pageModel.SessionInfo;
import sy.pageModel.User;
import sy.service.CustomerServiceI;
import sy.service.FollowServiceI;
import sy.util.ConfigUtil;
import sy.util.DateUtil;
import sy.util.MD5Util;

@Service
public class FollowServiceImpl implements FollowServiceI {
	
	@Autowired
	private FollowDaoI followDao;
	
	@Autowired
	private CustomerDaoI customerDao;
	
	@Override
	public DataGrid dataGrid(SessionInfo sessionInfo,Follow follow, PageHelper ph) {
		DataGrid dg = new DataGrid();
		List<Follow> ul = new ArrayList<Follow>();
		Map<String, Object> params = new HashMap<String, Object>();
		String hql = " from Tfollow t  left join fetch t.tcustomer tc ";
		List<Tfollow> l = followDao.find(hql + whereHql(follow, params) + orderHql(ph), params, ph.getPage(), ph.getRows());
		if (l != null && l.size() > 0) {
			for (Tfollow t : l) {
				Follow u = new Follow();
				BeanUtils.copyProperties(t, u);

				if(t.getTcustomer()!=null){
					u.setCustomerName(t.getTcustomer().getName());
				}
				
				ul.add(u);
			}
		}
		dg.setRows(ul);
		dg.setTotal(new Long((ul.size())));
		return dg;
	}

	private String whereHql(Follow follow, Map<String, Object> params) {
		String hql = "";
		if (follow != null) {
			hql += " where 1=1 ";
			if (follow.getCustomerId()!= null) {
				hql += " and tc.id=:id";
				params.put("id", follow.getCustomerId());
			}
			
		}
		return hql;
	}

	private String orderHql(PageHelper ph) {
		String orderString = "";
		if (ph.getSort() != null && ph.getOrder() != null) {
			orderString = " order by t." + ph.getSort() + " " + ph.getOrder();
		}
		return orderString;
	}
	
	@Override
	public void add(SessionInfo sessionInfo,Follow follow) throws Exception {
			Tfollow u=new Tfollow();
			BeanUtils.copyProperties(follow, u);
			u.setCreateDatetime(new Date());
			if (follow.getCustomerId() != null) {
				u.setTcustomer(customerDao.get(Tcustomer.class,follow.getCustomerId()));
			}
			
			followDao.save(u);
	}
	
}
