package sy.dao;

import sy.model.Tsolarytype;

public interface SolaryTypeDaoI extends BaseDaoI<Tsolarytype> {

	/**
	 * 通过ID获得BUG类型
	 * 
	 * @param id
	 * @return
	 */
	public Tsolarytype getById(String id);

}
