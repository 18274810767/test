package sy.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sy.dao.ClassmateDaoI;
import sy.model.Tbug;
import sy.model.Tclassmate;
import sy.model.Torganization;
import sy.model.Trole;
import sy.model.Tsolarytype;
import sy.model.Tuser;
import sy.pageModel.Bug;
import sy.pageModel.Classmate;
import sy.pageModel.DataGrid;
import sy.pageModel.PageHelper;
import sy.pageModel.User;
import sy.service.ClassMateServiceI;
import sy.util.ClobUtil;

@Service
public class ClassMateServiceImpl implements ClassMateServiceI {
	
	@Autowired
	private ClassmateDaoI classmateDao;
	
	@Override
	public DataGrid dataGrid(Classmate classmate, PageHelper ph) {
		DataGrid dg = new DataGrid();
		List<Classmate> ul = new ArrayList<Classmate>();
		Map<String, Object> params = new HashMap<String, Object>();
		String hql = " from Tclassmate t ";
		List<Tclassmate> l = classmateDao.find(hql + whereHql(classmate, params) + orderHql(ph), params, ph.getPage(), ph.getRows());
		if (l != null && l.size() > 0) {
			for (Tclassmate t : l) {
				Classmate u = new Classmate();
				BeanUtils.copyProperties(t, u);
				
				ul.add(u);
			}
		}
		dg.setRows(ul);
		dg.setTotal(classmateDao.count("select count(*) " + hql + whereHql(classmate, params), params));
		return dg;
	}

	private String whereHql(Classmate classmate, Map<String, Object> params) {
		String hql = "";
		if (classmate != null) {
			hql += " where 1=1 ";
			if (classmate.getName() != null) {
				hql += " and t.name like :name";
				params.put("name", "%%" + classmate.getName() + "%%");
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
	public void add(Classmate classmate) {
		Tclassmate t = new Tclassmate();
		BeanUtils.copyProperties(classmate, t);
		classmateDao.save(t);
	}

	@Override
	public Classmate get(String id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		Tclassmate t = classmateDao.get("from Tclassmate t  where t.id = :id", params);
		Classmate c = new Classmate();
		BeanUtils.copyProperties(t, c);
		return c;
	}

	@Override
	public void edit(Classmate classmate) {
		Tclassmate t = classmateDao.get(Tclassmate.class, classmate.getId());
		if (t != null) {
			BeanUtils.copyProperties(classmate, t, new String[] { "id"});
		}
	}

	@Override
	public void delete(String id) {
		classmateDao.delete(classmateDao.get(Tclassmate.class, id));
	}
}
