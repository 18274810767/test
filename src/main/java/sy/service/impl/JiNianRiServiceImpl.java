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
import sy.dao.JiNianRiDaoI;
import sy.dao.SolaryTypeDaoI;
import sy.dao.UserDaoI;
import sy.model.Tcourses;
import sy.model.Tcustomer;
import sy.model.Tfollow;
import sy.model.Tjinianri;
import sy.model.Torganization;
import sy.model.Trole;
import sy.model.Tsolarytype;
import sy.model.Tuser;
import sy.pageModel.Customer;
import sy.pageModel.DataGrid;
import sy.pageModel.Follow;
import sy.pageModel.JiNianRi;
import sy.pageModel.PageHelper;
import sy.pageModel.SessionInfo;
import sy.pageModel.User;
import sy.service.CustomerServiceI;
import sy.service.FollowServiceI;
import sy.service.JiNianRiServiceI;
import sy.util.ConfigUtil;
import sy.util.DateUtil;
import sy.util.MD5Util;

@Service
public class JiNianRiServiceImpl implements JiNianRiServiceI {
	
	@Autowired
	private JiNianRiDaoI jiNianRiDao;
	
	@Autowired
	private CustomerDaoI customerDao;
	
	@Override
	public DataGrid dataGrid(SessionInfo sessionInfo,JiNianRi jnr, PageHelper ph) {
		DataGrid dg = new DataGrid();
		List<JiNianRi> ul = new ArrayList<JiNianRi>();
		Map<String, Object> params = new HashMap<String, Object>();
		String hql = " from Tjinianri t  left join fetch t.tcustomer tc ";
		List<Tjinianri> l = jiNianRiDao.find(hql + whereHql(jnr, params) + orderHql(ph), params, ph.getPage(), ph.getRows());
		if (l != null && l.size() > 0) {
			for (Tjinianri t : l) {
				JiNianRi u = new JiNianRi();
				BeanUtils.copyProperties(t, u);
				
				ul.add(u);
			}
		}
		dg.setRows(ul);
		dg.setTotal(new Long((ul.size())));
		return dg;
	}

	private String whereHql(JiNianRi jnr, Map<String, Object> params) {
		String hql = "";
		if (jnr != null) {
			hql += " where 1=1 ";
			if (jnr.getCustomerId()!= null) {
				hql += " and tc.id=:id";
				params.put("id", jnr.getCustomerId());
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
	public void add(SessionInfo sessionInfo, JiNianRi jnr) throws Exception {
		Tjinianri u=new Tjinianri();
		BeanUtils.copyProperties(jnr, u);
		if (jnr.getCustomerId() != null) {
			u.setTcustomer(customerDao.get(Tcustomer.class,jnr.getCustomerId()));
		}
		
		jiNianRiDao.save(u);
		
	}
	
}
