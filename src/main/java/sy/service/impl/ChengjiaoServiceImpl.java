package sy.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sy.dao.ChengjiaoDaoI;
import sy.dao.UserDaoI;
import sy.model.Tchengjiao;
import sy.model.Tclassmate;
import sy.model.Tcustomer;
import sy.model.Tuser;
import sy.pageModel.Classmate;
import sy.pageModel.DataGrid;
import sy.pageModel.Chengjiao;
import sy.pageModel.PageHelper;
import sy.pageModel.SessionInfo;
import sy.service.ChengjiaoServiceI;

@Service
public class ChengjiaoServiceImpl implements ChengjiaoServiceI {

	@Autowired
	private ChengjiaoDaoI chengjiaoDao;
	
	@Autowired
	private UserDaoI UserDao;

	@Override
	public DataGrid dataGrid(Chengjiao deal, PageHelper ph) {
		DataGrid dg = new DataGrid();
		List<Chengjiao> ul = new ArrayList<Chengjiao>();
		Map<String, Object> params = new HashMap<String, Object>();
		String hql = " from Tchengjiao t ";
		List<Tchengjiao> l = chengjiaoDao.find(hql + whereHql(deal, params) + orderHql(ph), params, ph.getPage(), ph.getRows());
		if (l != null && l.size() > 0) {
			for (Tchengjiao t : l) {
				Chengjiao u = new Chengjiao();
				BeanUtils.copyProperties(t, u);
				
				if(t.getTuser()!=null){
					u.setUserName(t.getTuser().getName());
				}
				
				ul.add(u);
			}
		}
		dg.setRows(ul);
		dg.setTotal(chengjiaoDao.count("select count(*) " + hql + whereHql(deal, params), params));
		return dg;
	}
	
	private String whereHql(Chengjiao deal, Map<String, Object> params) {
		String hql = "";
		if (deal != null) {
			hql += " where 1=1 ";
			/*if (deal.getCustomerName()!= null) {
				hql += " and  c.name  like :name";
				params.put("name", "%%" + deal.getCustomerName() + "%%");
			}
			if (deal.getCreatedatetimeStart() != null) {
				hql += " and t.serviceTime >= :createdatetimeStart";
				params.put("createdatetimeStart", deal.getCreatedatetimeStart());
			}
			if (deal.getCreatedatetimeEnd() != null) {
				hql += " and t.serviceTime <= :createdatetimeEnd";
				params.put("createdatetimeEnd", deal.getCreatedatetimeEnd());
			}*/
			
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
	public void add(Chengjiao cj,SessionInfo sessionInfo) {
		Tchengjiao t = new Tchengjiao();
		BeanUtils.copyProperties(cj, t);
		t.setCreatedatetime(new Date());
		t.setTuser(UserDao.get(Tuser.class,sessionInfo.getId()));
		chengjiaoDao.save(t);
	}

	@Override
	public Chengjiao get(String id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		Tchengjiao t = chengjiaoDao.get("from Tchengjiao t  where t.id = :id", params);
		Chengjiao c = new Chengjiao();
		BeanUtils.copyProperties(t, c);
		return c;
	}

	@Override
	public void edit(Chengjiao cj) {
		Tchengjiao t = chengjiaoDao.get(Tchengjiao.class, cj.getId());
		if (t != null) {
			BeanUtils.copyProperties(cj, t, new String[] { "id"});
		}
	}

	@Override
	public void delete(String id) {
		chengjiaoDao.delete(chengjiaoDao.get(Tchengjiao.class, id));
	}
}
