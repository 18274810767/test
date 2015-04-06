package sy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import sy.dao.BugTypeDaoI;
import sy.dao.SolaryTypeDaoI;
import sy.model.Tbugtype;
import sy.model.Tsolarytype;
import sy.service.BugTypeServiceI;
import sy.service.SolaryTypeServiceI;

@Service
public class SolaryTypeServiceImpl implements SolaryTypeServiceI {

	@Autowired
	private SolaryTypeDaoI solaryTypeDao;

	@Override
	@Cacheable(value = "solarytypeServiceCache", key = "'solarytypeList'")
	public List<Tsolarytype> getSolarytypeList() {
		return solaryTypeDao.find("from Tsolarytype t");
	}

}
