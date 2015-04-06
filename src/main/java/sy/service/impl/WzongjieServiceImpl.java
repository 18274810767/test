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
import sy.dao.WzongjieDaoI;
import sy.model.Cdzongjie;
import sy.model.Cwzongjie;
import sy.pageModel.DataGrid;
import sy.pageModel.Dzongjie;
import sy.pageModel.PageHelper;
import sy.pageModel.Wzongjie;
import sy.service.WzongjieServiceI;
import sy.util.ClobUtil;
@Service
public class WzongjieServiceImpl implements WzongjieServiceI{
	@Autowired
	private WzongjieDaoI wDao;

	@Override
	public DataGrid dataGrid(Wzongjie zongjie, PageHelper ph) {
		System.out.println("进人、。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。");
		DataGrid dg=new DataGrid();
		List<Wzongjie> ul=new ArrayList<Wzongjie>();
		Map<String ,Object> params=new HashMap<String, Object>();
		String hql="from Cwzongjie t";
		List<Cwzongjie> l=wDao.find(hql+whereHql(zongjie, params) + orderHql(ph), params, ph.getPage(), ph.getRows());
	    if(l!=null&&l.size()>0){
	    	for(Cwzongjie t:l){
	    		Wzongjie u=new Wzongjie();
	    		BeanUtils.copyProperties(t, u,new String[]{"zongjie"});
	    		ul.add(u);
	    	}
	    }
	    dg.setRows(ul);
	    dg.setTotal(wDao.count("select count(*) " + hql + whereHql(zongjie, params), params));
	    return dg;
	}
	
	private String whereHql(Wzongjie zongjie, Map<String, Object> params) {
		String hql = "";
		if (zongjie != null) {
			hql += " where 1=1 ";
			if (zongjie.getName() != null) {
				hql += " and t.name like :name";
				System.out.println("++++++++++++++++，模糊查询："+zongjie.getName());
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
	public void add(Wzongjie zongjie) throws Exception {
		Cwzongjie u = new Cwzongjie();
		BeanUtils.copyProperties(zongjie, u, new String[] { "zongjie" });
		u.setFinished(zongjie.getFinished());
		u.setZongjie(ClobUtil.getClob(zongjie.getZongjie()));
		u.setCreatedatetime(new Date());
		u.setName(zongjie.getName());
		u.setHudong(zongjie.getHudong());
		u.setJilu(zongjie.getJilu());
		wDao.save(u);
		
	}

	@Override
	public Wzongjie get(String id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		Cwzongjie t = wDao.get("select distinct t from Cwzongjie t  where t.id = :id", params);
		Wzongjie u = new Wzongjie();
		BeanUtils.copyProperties(t, u,new String[] { "zongjie" });
		u.setZongjie(ClobUtil.getString(t.getZongjie()));
		return u;
	}

	@Override
	public void delete(String id) {
		wDao.delete(wDao.get(Cwzongjie.class, id));
		
	}

	@Override
	public void edit(Wzongjie zongjie) {
		Cwzongjie t=wDao.get(Cwzongjie.class,zongjie.getId());
		if(t!=null){
			BeanUtils.copyProperties(zongjie, t, new String[] { "id", "finished", "createdatetime","name","zongjie","jilu","hudong"});
			t.setModifydatetime(new Date());
			t.setZongjie(ClobUtil.getClob(zongjie.getZongjie()));
			t.setFinished(zongjie.getFinished());
			t.setName(zongjie.getName());
			t.setJilu(zongjie.getJilu());
			t.setHudong(zongjie.getHudong());
			
		}
		
	}

}
