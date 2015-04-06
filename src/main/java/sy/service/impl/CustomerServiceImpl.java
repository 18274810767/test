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
import sy.dao.SolaryTypeDaoI;
import sy.dao.UserDaoI;
import sy.model.Tcourses;
import sy.model.Tcustomer;
import sy.model.Torganization;
import sy.model.Trole;
import sy.model.Tsolarytype;
import sy.model.Tuser;
import sy.pageModel.Customer;
import sy.pageModel.DataGrid;
import sy.pageModel.PageHelper;
import sy.pageModel.SessionInfo;
import sy.pageModel.User;
import sy.service.CustomerServiceI;
import sy.util.ConfigUtil;
import sy.util.DateUtil;
import sy.util.MD5Util;

@Service
public class CustomerServiceImpl implements CustomerServiceI {
	
	@Autowired
	private CustomerDaoI customerDao;
	
	@Autowired
	private UserDaoI userDao;
	
	@Autowired
	private CoursesDaoI coursesDao;
	
	@Override
	public DataGrid dataGrid(SessionInfo sessionInfo, Customer customer, PageHelper ph) {
		DataGrid dg = new DataGrid();
		List<Customer> ul = new ArrayList<Customer>();
		Map<String, Object> params = new HashMap<String, Object>();
		String hql = " from Tcustomer t  ";
		List<Tcustomer> l = customerDao.find(hql + whereHql(customer, params,sessionInfo) + orderHql(ph), params, ph.getPage(), ph.getRows());
		if (l != null && l.size() > 0) {
			for (Tcustomer t : l) {
				Customer u = new Customer();
				
				try{
				BeanUtils.copyProperties(t, u);
				}catch(Exception e){
					e.printStackTrace();
				}
				if(t.getTuser()!=null){
					u.setUserName(t.getTuser().getName());
				}
				
				u.setPstatus(t.getBtype().toString());
				
				Set<Tcourses> courses = t.getTcourseses();
				if (courses != null && !courses.isEmpty()) {
					String courseIds = "";
					String courseNames = "";
					boolean b = false;
					for (Tcourses tr : courses) {
						if (b) {
							courseIds += ",";
							courseNames += ",";
						} else {
							b = true;
						}
						courseIds += tr.getId();
						courseNames += tr.getName();
					}
					u.setCourseIds(courseIds);
					u.setCourseNames(courseNames);
				}
				
				
				ul.add(u);
			}
		}
		dg.setRows(ul);
		dg.setTotal(customerDao.count("select count(*) " + hql + whereHql(customer, params,sessionInfo), params));
		return dg;
	}

	
	@Override
	public DataGrid qDataGrid(SessionInfo sessionInfo, Customer customer, PageHelper ph) {
		DataGrid dg = new DataGrid();
		List<Customer> ul = new ArrayList<Customer>();
		Map<String, Object> params = new HashMap<String, Object>();
		String hql = " from Tcustomer t  ";
		List<Tcustomer> l = customerDao.find(hql + qWhereHql(customer, params,sessionInfo) + orderHql(ph), params, ph.getPage(), ph.getRows());
		if (l != null && l.size() > 0) {
			for (Tcustomer t : l) {
				Customer u = new Customer();
				
				try{
				BeanUtils.copyProperties(t, u);
				}catch(Exception e){
					e.printStackTrace();
				}
				u.setPstatus(t.getBtype().toString());
				ul.add(u);
			}
		}
		dg.setRows(ul);
		dg.setTotal(customerDao.count("select count(*) " + hql + qWhereHql(customer, params,sessionInfo), params));
		return dg;
	}
	
	private String qWhereHql(Customer customer, Map<String, Object> params,SessionInfo sessionInfo) {
		String hql = "";
		if (customer != null) {
			hql += " where 1=1  ";
			if (customer.getName() != null&&!"".equals(customer.getName())) {
				hql += " and t.name like :name";
				params.put("name", "%%" + customer.getName() + "%%");
			}
			if (customer.getPhone()!= null&&!"".equals(customer.getPhone())) {
				hql += " and t.phone =:phone";
				params.put("phone", customer.getPhone());
			}

/*			if (customer.getPstatus() != null) {
				hql += " and t.pstatus = :pstatus";
				params.put("pstatus", customer.getPstatus());
			}*/
	
		}
		return hql;
	}
	
	private String whereHql(Customer customer, Map<String, Object> params,SessionInfo sessionInfo) {
		String hql = "";
		if (customer != null) {
			hql += " where 1=1 ";
			if (customer.getName() != null&&!"".equals(customer.getName())) {
				hql += " and t.name like :name";
				params.put("name", "%%" + customer.getName() + "%%");
			}
			if (customer.getPhone()!= null&&!"".equals(customer.getPhone())) {
				hql += " and t.phone =:phone";
				params.put("phone", customer.getPhone());
			}
			if (sessionInfo.getId() != null) {
				hql += " and t.tuser.id = :userid";
				params.put("userid", sessionInfo.getId());
			}
			if (customer.getCreatedatetimeStart() != null) {
				hql += " and t.createdatetime >= :createdatetimeStart";
				params.put("createdatetimeStart", customer.getCreatedatetimeStart());
			}
			if (customer.getCreatedatetimeEnd() != null) {
				hql += " and t.createdatetime <= :createdatetimeEnd";
				params.put("createdatetimeEnd", customer.getCreatedatetimeEnd());
			}
			if (customer.getModifydatetimeStart() != null) {
				hql += " and t.modifydatetime >= :modifydatetimeStart";
				params.put("modifydatetimeStart", customer.getModifydatetimeStart());
			}
			if (customer.getModifydatetimeEnd() != null) {
				hql += " and t.modifydatetime <= :modifydatetimeEnd";
				params.put("modifydatetimeEnd", customer.getModifydatetimeEnd());
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
	public void add(SessionInfo sessionInfo,Customer customer) throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", customer.getName());
		if (customerDao.count("select count(*) from Tcustomer t where t.name = :name", params) > 0) {
			throw new Exception("姓名已存在！");
		} else {
			Tcustomer u=new Tcustomer();
			BeanUtils.copyProperties(customer, u);
			if (sessionInfo != null) {
				u.setTuser(userDao.get(Tuser.class,sessionInfo.getId()));
			}
			
			customerDao.save(u);
		}
	}

	@Override
	public Customer get(String id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		Tcustomer t = customerDao.get("select distinct t from Tcustomer t  where t.id = :id", params);
		Customer u = new Customer();
		BeanUtils.copyProperties(t, u);
		return u;
	}

	@Override
	public void edit(Customer customer) throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", customer.getId());
		params.put("name", customer.getName());
		if (customerDao.count("select count(*) from Tcustomer t where t.name = :name and t.id != :id", params) > 0) {
			throw new Exception("姓名已存在！");
		} else {
			Tcustomer u = customerDao.get(Tcustomer.class, customer.getId());
			BeanUtils.copyProperties(customer, u);
			u.setModifydatetime(new Date());
		}
	}

	@Override
	public void delete(String id) {
		customerDao.delete(customerDao.get(Tcustomer.class, id));
	}

	@Override
	public void grant(String ids, Customer customer) {
		if (ids != null && ids.length() > 0) {
			List<Tcourses> courses = new ArrayList<Tcourses>();
			if (customer.getCourseIds() != null) {
				for (String courseId : customer.getCourseIds().split(",")) {
					courses.add(coursesDao.get(Tcourses.class, courseId));
				}
			}
			for (String id : ids.split(",")) {
				if (id != null && !id.equalsIgnoreCase("")) {
					Tcustomer t = customerDao.get(Tcustomer.class, id);
					t.setTcourseses(new HashSet<Tcourses>(courses));
				}
			}
		}
	}
}
