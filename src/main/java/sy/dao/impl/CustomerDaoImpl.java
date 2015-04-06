package sy.dao.impl;

import org.springframework.stereotype.Repository;

import sy.dao.CustomerDaoI;
import sy.dao.UserDaoI;
import sy.model.Tcustomer;
import sy.model.Tuser;

@Repository
public class CustomerDaoImpl extends BaseDaoImpl<Tcustomer> implements CustomerDaoI {

}
