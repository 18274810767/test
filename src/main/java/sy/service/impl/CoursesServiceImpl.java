package sy.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import sy.dao.CoursesDaoI;
import sy.model.Tcourses;
import sy.model.Torganization;
import sy.model.Tsolarytype;
import sy.pageModel.Courses;
import sy.pageModel.DataGrid;
import sy.pageModel.PageHelper;
import sy.pageModel.SessionInfo;
import sy.pageModel.Tree;
import sy.service.CoursesServiceI;

@Service
public class CoursesServiceImpl implements CoursesServiceI {
	
	@Autowired
	private CoursesDaoI coursesDao;
	
	@Override
	public DataGrid dataGrid(Courses courses, PageHelper ph) {
		DataGrid dg = new DataGrid();
		List<Courses> ul = new ArrayList<Courses>();
		Map<String, Object> params = new HashMap<String, Object>();
		String hql = " from Tcourses t ";
		List<Tcourses> l = coursesDao.find(hql + whereHql(courses, params) + orderHql(ph), params, ph.getPage(), ph.getRows());
		if (l != null && l.size() > 0) {
			for (Tcourses t : l) {
				Courses u = new Courses();
				BeanUtils.copyProperties(t, u);
				
				ul.add(u);
			}
		}
		dg.setRows(ul);
		dg.setTotal(coursesDao.count("select count(*) " + hql + whereHql(courses, params), params));
		return dg;
	}

	private String whereHql(Courses Courseses, Map<String, Object> params) {
		String hql = "";
		if (Courseses != null) {
			hql += " where 1=1 ";
			if (Courseses.getName() != null) {
				hql += " and t.name like :name";
				params.put("name", "%%" + Courseses.getName() + "%%");
			}
			if (Courseses.getCreatedatetimeStart() != null) {
				hql += " and t.createdatetime >= :createdatetimeStart";
				params.put("createdatetimeStart", Courseses.getCreatedatetimeStart());
			}
			if (Courseses.getCreatedatetimeEnd() != null) {
				hql += " and t.createdatetime <= :createdatetimeEnd";
				params.put("createdatetimeEnd", Courseses.getCreatedatetimeEnd());
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
	public void add(Courses courses) throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", courses.getName());
		if (coursesDao.count("select count(*) from Tcourses t where t.name = :name", params) > 0) {
			throw new Exception("课程已存在！");
		} else {
			Tcourses u = new Tcourses();
			BeanUtils.copyProperties(courses, u);
			u.setCreateDateTime(new Date());
			coursesDao.save(u);
		}
	}

	@Override
	public Courses get(String id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		Tcourses t = coursesDao.get("select distinct t from Tcourses t  where t.id = :id", params);
		Courses u = new Courses();
		BeanUtils.copyProperties(t, u);
		return u;
	}

	@Override
	public void edit(Courses courses) throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", courses.getId());
		params.put("name", courses.getName());
		if (coursesDao.count("select count(*) from Tcourses t where t.name = :name and t.id != :id", params) > 0) {
			throw new Exception("课程已存在！");
		} else {
			Tcourses u = coursesDao.get(Tcourses.class, courses.getId());
			BeanUtils.copyProperties(courses, u, new String[] {"createdatetime" });
			u.setModifydatetime(new Date());
		}
	}

	@Override
	public void delete(String id) {
		coursesDao.delete(coursesDao.get(Tcourses.class, id));
	}
	
	@Override
	@Cacheable(value = "courseListServiceCache", key = "'getCourseList'")
	public List<Tcourses> getCourseList() {
		return coursesDao.find("from Tcourses t");
	}

	@Override
	public List<Tree> tree(SessionInfo session) {
		List<Tcourses> l = null;
		List<Tree> lt = new ArrayList<Tree>();
		
		l = coursesDao.find("from Tcourses t");

		if (l != null && l.size() > 0) {
			for (Tcourses t : l) {
				Tree tree = new Tree();
				BeanUtils.copyProperties(t, tree);
				tree.setText(t.getName());
				tree.setIconCls("box");
				lt.add(tree);
			}
		}
		return lt;
	}
}
