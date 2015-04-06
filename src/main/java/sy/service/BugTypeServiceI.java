package sy.service;

import java.util.List;

import sy.model.Tbugtype;

/**
 * 
 * @author 谭楚柱
 * 
 */
public interface BugTypeServiceI {

	/**
	 * 获得BUG类型列表
	 * 
	 * @return
	 */
	public List<Tbugtype> getBugTypeList();

}
