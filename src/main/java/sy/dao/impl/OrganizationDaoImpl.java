package sy.dao.impl;

import org.springframework.stereotype.Repository;

import sy.dao.OrganizationDaoI;
import sy.model.Torganization;

@Repository
public class OrganizationDaoImpl extends BaseDaoImpl<Torganization> implements OrganizationDaoI {

	@Override
	public Torganization getById(String id) {
		return super.get(Torganization.class, id);
	}

}
