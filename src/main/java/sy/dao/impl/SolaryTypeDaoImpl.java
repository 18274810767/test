package sy.dao.impl;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import sy.dao.SolaryTypeDaoI;
import sy.model.Tsolarytype;

@Repository
public class SolaryTypeDaoImpl extends BaseDaoImpl<Tsolarytype> implements SolaryTypeDaoI {

	@Override
	@Cacheable(value = "solarytypeDaoCache", key = "#id")
	public Tsolarytype getById(String id) {
		return super.get(Tsolarytype.class, id);
	}

}
