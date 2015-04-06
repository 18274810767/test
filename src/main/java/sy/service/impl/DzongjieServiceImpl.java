package sy.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sy.dao.DzongjieDaoI;
import sy.model.Tcourses;
import sy.model.Tcustomer;
import sy.model.Cdzongjie;
import sy.model.Tuser;
import sy.pageModel.Customer;
import sy.pageModel.DataGrid;
import sy.pageModel.Dzongjie;
import sy.pageModel.PageHelper;
import sy.pageModel.User;
import sy.service.DzongjieServiceI;
import sy.util.ClobUtil;
import sy.util.MD5Util;
@Service
public class DzongjieServiceImpl implements DzongjieServiceI{
	@Autowired
	private DzongjieDaoI dDao;

	@Override
	public DataGrid dataGrid(Dzongjie zongjie, PageHelper ph) {
		DataGrid dg=new DataGrid();
		List<Dzongjie> ul=new ArrayList<Dzongjie>();
		Map<String ,Object> params=new HashMap<String, Object>();
		String hql="from Cdzongjie t";
		List<Cdzongjie> l=dDao.find(hql+whereHql(zongjie, params) + orderHql(ph), params, ph.getPage(), ph.getRows());
	    if(l!=null&&l.size()>0){
	    	for(Cdzongjie t:l){
	    		Dzongjie u=new Dzongjie();
	    		BeanUtils.copyProperties(t, u,new String[]{"zongjie"});
	    		ul.add(u);
	    	}
	    }
	    dg.setRows(ul);
	    dg.setTotal(dDao.count("select count(*) " + hql + whereHql(zongjie, params), params));
	    return dg;
	}
	
	private String whereHql(Dzongjie zongjie, Map<String, Object> params) {
		String hql = "";
		if (zongjie != null) {
			hql += " where 1=1 ";
			if (zongjie.getName() != null) {
				hql += " and t.name like :name";
				params.put("name", "%%" + zongjie.getName() + "%%");
			}
			if (zongjie.getCreatedatetimeStart() != null) {
				hql += " and t.createdatetime >= :createdatetimeStart";
				params.put("createdatetimeStart", zongjie.getCreatedatetimeStart());
			}
			if (zongjie.getCreatedatetimeEnd() != null) {
				hql += " and t.createdatetime <= :createdatetimeEnd";
				params.put("createdatetimeEnd", zongjie.getCreatedatetimeEnd());
			}
			if (zongjie.getModifydatetimeStart() != null) {
				hql += " and t.modifydatetime >= :modifydatetimeStart";
				params.put("modifydatetimeStart", zongjie.getModifydatetimeStart());
			}
			if (zongjie.getModifydatetimeEnd() != null) {
				hql += " and t.modifydatetime <= :modifydatetimeEnd";
				params.put("modifydatetimeEnd", zongjie.getModifydatetimeEnd());
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
	public void add(Dzongjie zongjie) throws Exception {
		
			Cdzongjie u = new Cdzongjie();
			BeanUtils.copyProperties(zongjie, u, new String[] { "zongjie" });
			u.setFinished(zongjie.getFinished());
			u.setZongjie(ClobUtil.getClob(zongjie.getZongjie()));
			u.setCreatedatetime(new Date());
			u.setNotes(zongjie.getNotes());
			dDao.save(u);
		
		
	}

	@Override
	public Dzongjie get(String id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		Cdzongjie t = dDao.get("select distinct t from Cdzongjie t  where t.id = :id", params);
		Dzongjie u = new Dzongjie();
		BeanUtils.copyProperties(t, u,new String[] { "zongjie" });
		u.setZongjie(ClobUtil.getString(t.getZongjie()));
		return u;
	}

	@Override
	public void delete(String id) {
		dDao.delete(dDao.get(Cdzongjie.class, id));
		
	}

	@Override
	public void edit(Dzongjie zongjie) {
		Cdzongjie t=dDao.get(Cdzongjie.class,zongjie.getId());
		if(t!=null){
			BeanUtils.copyProperties(zongjie, t, new String[] { "id", "finished", "createdatetime","name","zongjie","notes"});
			t.setModifydatetime(new Date());
			t.setZongjie(ClobUtil.getClob(zongjie.getZongjie()));
			t.setFinished(zongjie.getFinished());
			t.setName(zongjie.getName());
			t.setNotes(zongjie.getNotes());
			
		}
		
	}
}
