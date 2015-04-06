package sy.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sy.dao.BugDaoI;
import sy.dao.BugTypeDaoI;
import sy.dao.OrganizationDaoI;
import sy.dao.ResourceDaoI;
import sy.dao.ResourceTypeDaoI;
import sy.dao.RoleDaoI;
import sy.dao.SolaryTypeDaoI;
import sy.dao.UserDaoI;
import sy.model.Tbugtype;
import sy.model.Torganization;
import sy.model.Tresource;
import sy.model.Tresourcetype;
import sy.model.Trole;
import sy.model.Tsolarytype;
import sy.model.Tuser;
import sy.pageModel.Organization;
import sy.service.InitServiceI;
import sy.service.SolaryTypeServiceI;
import sy.util.MD5Util;

@Service
public class InitServiceImpl implements InitServiceI {

	@Autowired
	private UserDaoI userDao;

	@Autowired
	private RoleDaoI roleDao;

	@Autowired
	private ResourceDaoI resourceDao;

	@Autowired
	private ResourceTypeDaoI resourceTypeDao;

	@Autowired
	private BugDaoI bugDao;

	@Autowired
	private BugTypeDaoI bugTypeDao;
	
	@Autowired
	private OrganizationDaoI organizationDao;
	
	@Autowired
	private SolaryTypeDaoI solaryTypeDao;
	
	@Override
	synchronized public void init() {

		initBugType();// 初始化BUG类型

		initResourceType();// 初始化资源类型

		initResource();// 初始化资源

		initOrganization();// 初始化机构
		
		initRole();// 初始化角色

		initUser();// 初始化用户
		
		initSolary();
		
	}
	private void initSolary() {
		Tsolarytype bz1=new Tsolarytype();
		bz1.setLevel("0");
		bz1.setName("A0");
		bz1.setBaseGz(3000);
		bz1.setBz("A0");
		bz1.setGdGz(4000);
		bz1.setGt(2000.0);
		solaryTypeDao.saveOrUpdate(bz1);
		
		Tsolarytype bz2=new Tsolarytype();
		bz2.setLevel("1");
		bz2.setName("S1");
		bz2.setBaseGz(4000);
		bz2.setBz("S1");
		bz2.setGdGz(5000);
		bz2.setGt(3000.0);
		solaryTypeDao.saveOrUpdate(bz2);
		
		Tsolarytype bz3=new Tsolarytype();
		bz3.setLevel("2");
		bz3.setName("M2");
		bz3.setBaseGz(5000);
		bz3.setBz("M2");
		bz3.setGdGz(6000);
		bz3.setGt(4000.0);
		solaryTypeDao.saveOrUpdate(bz3);
	}

	private void initBugType() {
		Tbugtype cw = new Tbugtype();
		cw.setId("0");
		cw.setName("错误");
		bugTypeDao.saveOrUpdate(cw);

		Tbugtype gn = new Tbugtype();
		gn.setId("1");
		gn.setName("功能");
		bugTypeDao.saveOrUpdate(gn);
	}

	private void initResource() {
		Tresourcetype menuType = resourceTypeDao.get(Tresourcetype.class, "0");// 菜单类型
		Tresourcetype funType = resourceTypeDao.get(Tresourcetype.class, "1");// 功能类型

		Tresource xtgl = new Tresource();
		xtgl.setId("xtgl");
		xtgl.setName("系统管理");
		xtgl.setTresourcetype(menuType);
		xtgl.setSeq(0);
		xtgl.setIcon("plugin");
		resourceDao.saveOrUpdate(xtgl);

		Tresource zygl = new Tresource();
		zygl.setId("zygl");
		zygl.setName("资源管理");
		zygl.setTresourcetype(menuType);
		zygl.setTresource(xtgl);
		zygl.setSeq(1);
		zygl.setUrl("/resourceController/manager");
		zygl.setIcon("database_gear");
		zygl.setRemark("管理系统中所有的菜单或功能");
		resourceDao.saveOrUpdate(zygl);

		Tresource zyglTreeGrid = new Tresource();
		zyglTreeGrid.setId("zyglTreeGrid");
		zyglTreeGrid.setName("资源表格");
		zyglTreeGrid.setTresourcetype(funType);
		zyglTreeGrid.setTresource(zygl);
		zyglTreeGrid.setSeq(1);
		zyglTreeGrid.setUrl("/resourceController/treeGrid");
		zyglTreeGrid.setIcon("wrench");
		zyglTreeGrid.setRemark("显示资源列表");
		resourceDao.saveOrUpdate(zyglTreeGrid);

		Tresource zyglMenu = new Tresource();
		zyglMenu.setId("zyglMenu");
		zyglMenu.setName("功能菜单");
		zyglMenu.setTresourcetype(funType);
		zyglMenu.setTresource(zygl);
		zyglMenu.setSeq(2);
		zyglMenu.setUrl("/resourceController/tree");
		zyglMenu.setIcon("wrench");
		resourceDao.saveOrUpdate(zyglMenu);

		Tresource zyglAddPage = new Tresource();
		zyglAddPage.setId("zyglAddPage");
		zyglAddPage.setName("添加资源页面");
		zyglAddPage.setTresourcetype(funType);
		zyglAddPage.setTresource(zygl);
		zyglAddPage.setSeq(3);
		zyglAddPage.setUrl("/resourceController/addPage");
		zyglAddPage.setIcon("wrench");
		resourceDao.saveOrUpdate(zyglAddPage);

		Tresource zyglAdd = new Tresource();
		zyglAdd.setId("zyglAdd");
		zyglAdd.setName("添加资源");
		zyglAdd.setTresourcetype(funType);
		zyglAdd.setTresource(zygl);
		zyglAdd.setSeq(4);
		zyglAdd.setUrl("/resourceController/add");
		zyglAdd.setIcon("wrench");
		resourceDao.saveOrUpdate(zyglAdd);

		Tresource zyglEditPage = new Tresource();
		zyglEditPage.setId("zyglEditPage");
		zyglEditPage.setName("编辑资源页面");
		zyglEditPage.setTresourcetype(funType);
		zyglEditPage.setTresource(zygl);
		zyglEditPage.setSeq(5);
		zyglEditPage.setUrl("/resourceController/editPage");
		zyglEditPage.setIcon("wrench");
		resourceDao.saveOrUpdate(zyglEditPage);

		Tresource zyglEdit = new Tresource();
		zyglEdit.setId("zyglEdit");
		zyglEdit.setName("编辑资源");
		zyglEdit.setTresourcetype(funType);
		zyglEdit.setTresource(zygl);
		zyglEdit.setSeq(6);
		zyglEdit.setUrl("/resourceController/edit");
		zyglEdit.setIcon("wrench");
		resourceDao.saveOrUpdate(zyglEdit);

		Tresource zyglDelete = new Tresource();
		zyglDelete.setId("zyglDelete");
		zyglDelete.setName("删除资源");
		zyglDelete.setTresourcetype(funType);
		zyglDelete.setTresource(zygl);
		zyglDelete.setSeq(7);
		zyglDelete.setUrl("/resourceController/delete");
		zyglDelete.setIcon("wrench");
		resourceDao.saveOrUpdate(zyglDelete);

		Tresource jsgl = new Tresource();
		jsgl.setId("jsgl");
		jsgl.setName("角色管理");
		jsgl.setTresourcetype(menuType);
		jsgl.setTresource(xtgl);
		jsgl.setSeq(2);
		jsgl.setUrl("/roleController/manager");
		jsgl.setIcon("tux");
		resourceDao.saveOrUpdate(jsgl);
		
		Tresource jsglTreeGrid = new Tresource();
		jsglTreeGrid.setId("jsglTreeGrid");
		jsglTreeGrid.setName("角色表格");
		jsglTreeGrid.setTresourcetype(funType);
		jsglTreeGrid.setTresource(jsgl);
		jsglTreeGrid.setSeq(1);
		jsglTreeGrid.setUrl("/roleController/treeGrid");
		jsglTreeGrid.setIcon("wrench");
		resourceDao.saveOrUpdate(jsglTreeGrid);

		Tresource jsglAddPage = new Tresource();
		jsglAddPage.setId("jsglAddPage");
		jsglAddPage.setName("添加角色页面");
		jsglAddPage.setTresourcetype(funType);
		jsglAddPage.setTresource(jsgl);
		jsglAddPage.setSeq(2);
		jsglAddPage.setUrl("/roleController/addPage");
		jsglAddPage.setIcon("wrench");
		resourceDao.saveOrUpdate(jsglAddPage);

		Tresource jsglAdd = new Tresource();
		jsglAdd.setId("jsglAdd");
		jsglAdd.setName("添加角色");
		jsglAdd.setTresourcetype(funType);
		jsglAdd.setTresource(jsgl);
		jsglAdd.setSeq(3);
		jsglAdd.setUrl("/roleController/add");
		jsglAdd.setIcon("wrench");
		resourceDao.saveOrUpdate(jsglAdd);

		Tresource jsglEditPage = new Tresource();
		jsglEditPage.setId("jsglEditPage");
		jsglEditPage.setName("编辑角色页面");
		jsglEditPage.setTresourcetype(funType);
		jsglEditPage.setTresource(jsgl);
		jsglEditPage.setSeq(4);
		jsglEditPage.setUrl("/roleController/editPage");
		jsglEditPage.setIcon("wrench");
		resourceDao.saveOrUpdate(jsglEditPage);

		Tresource jsglEdit = new Tresource();
		jsglEdit.setId("jsglEdit");
		jsglEdit.setName("编辑角色");
		jsglEdit.setTresourcetype(funType);
		jsglEdit.setTresource(jsgl);
		jsglEdit.setSeq(5);
		jsglEdit.setUrl("/roleController/edit");
		jsglEdit.setIcon("wrench");
		resourceDao.saveOrUpdate(jsglEdit);

		Tresource jsglDelete = new Tresource();
		jsglDelete.setId("jsglDelete");
		jsglDelete.setName("删除角色");
		jsglDelete.setTresourcetype(funType);
		jsglDelete.setTresource(jsgl);
		jsglDelete.setSeq(6);
		jsglDelete.setUrl("/roleController/delete");
		jsglDelete.setIcon("wrench");
		resourceDao.saveOrUpdate(jsglDelete);

		Tresource jsglGrantPage = new Tresource();
		jsglGrantPage.setId("jsglGrantPage");
		jsglGrantPage.setName("角色授权页面");
		jsglGrantPage.setTresourcetype(funType);
		jsglGrantPage.setTresource(jsgl);
		jsglGrantPage.setSeq(7);
		jsglGrantPage.setUrl("/roleController/grantPage");
		jsglGrantPage.setIcon("wrench");
		resourceDao.saveOrUpdate(jsglGrantPage);

		Tresource jsglGrant = new Tresource();
		jsglGrant.setId("jsglGrant");
		jsglGrant.setName("角色授权");
		jsglGrant.setTresourcetype(funType);
		jsglGrant.setTresource(jsgl);
		jsglGrant.setSeq(8);
		jsglGrant.setUrl("/roleController/grant");
		jsglGrant.setIcon("wrench");
		resourceDao.saveOrUpdate(jsglGrant);

		Tresource yhgl = new Tresource();
		yhgl.setId("yhgl");
		yhgl.setName("用户管理");
		yhgl.setTresourcetype(menuType);
		yhgl.setTresource(xtgl);
		yhgl.setSeq(3);
		yhgl.setUrl("/userController/manager");
		yhgl.setIcon("status_online");
		resourceDao.saveOrUpdate(yhgl);

		Tresource yhglDateGrid = new Tresource();
		yhglDateGrid.setId("yhglDateGrid");
		yhglDateGrid.setName("用户表格");
		yhglDateGrid.setTresourcetype(funType);
		yhglDateGrid.setTresource(yhgl);
		yhglDateGrid.setSeq(1);
		yhglDateGrid.setUrl("/userController/dataGrid");
		yhglDateGrid.setIcon("wrench");
		resourceDao.saveOrUpdate(yhglDateGrid);

		Tresource yhglAddPage = new Tresource();
		yhglAddPage.setId("yhglAddPage");
		yhglAddPage.setName("添加用户页面");
		yhglAddPage.setTresourcetype(funType);
		yhglAddPage.setTresource(yhgl);
		yhglAddPage.setSeq(2);
		yhglAddPage.setUrl("/userController/addPage");
		yhglAddPage.setIcon("wrench");
		resourceDao.saveOrUpdate(yhglAddPage);

		Tresource yhglAdd = new Tresource();
		yhglAdd.setId("yhglAdd");
		yhglAdd.setName("添加用户");
		yhglAdd.setTresourcetype(funType);
		yhglAdd.setTresource(yhgl);
		yhglAdd.setSeq(3);
		yhglAdd.setUrl("/userController/add");
		yhglAdd.setIcon("wrench");
		resourceDao.saveOrUpdate(yhglAdd);

		Tresource yhglEditPage = new Tresource();
		yhglEditPage.setId("yhglEditPage");
		yhglEditPage.setName("编辑用户页面");
		yhglEditPage.setTresourcetype(funType);
		yhglEditPage.setTresource(yhgl);
		yhglEditPage.setSeq(4);
		yhglEditPage.setUrl("/userController/editPage");
		yhglEditPage.setIcon("wrench");
		resourceDao.saveOrUpdate(yhglEditPage);

		Tresource yhglEdit = new Tresource();
		yhglEdit.setId("yhglEdit");
		yhglEdit.setName("编辑用户");
		yhglEdit.setTresourcetype(funType);
		yhglEdit.setTresource(yhgl);
		yhglEdit.setSeq(5);
		yhglEdit.setUrl("/userController/edit");
		yhglEdit.setIcon("wrench");
		resourceDao.saveOrUpdate(yhglEdit);

		Tresource yhglDelete = new Tresource();
		yhglDelete.setId("yhglDelete");
		yhglDelete.setName("删除用户");
		yhglDelete.setTresourcetype(funType);
		yhglDelete.setTresource(yhgl);
		yhglDelete.setSeq(6);
		yhglDelete.setUrl("/userController/delete");
		yhglDelete.setIcon("wrench");
		resourceDao.saveOrUpdate(yhglDelete);

		Tresource yhglBatchDelete = new Tresource();
		yhglBatchDelete.setId("yhglBatchDelete");
		yhglBatchDelete.setName("批量删除用户");
		yhglBatchDelete.setTresourcetype(funType);
		yhglBatchDelete.setTresource(yhgl);
		yhglBatchDelete.setSeq(7);
		yhglBatchDelete.setUrl("/userController/batchDelete");
		yhglBatchDelete.setIcon("wrench");
		resourceDao.saveOrUpdate(yhglBatchDelete);

		Tresource yhjsGrantPage = new Tresource();
		yhjsGrantPage.setId("yhjsGrantPage");
		yhjsGrantPage.setName("用户角色授权页面");
		yhjsGrantPage.setTresourcetype(funType);
		yhjsGrantPage.setTresource(yhgl);
		yhjsGrantPage.setSeq(8);
		yhjsGrantPage.setUrl("/userController/userRoleGrant");
		yhjsGrantPage.setIcon("wrench");
		resourceDao.saveOrUpdate(yhjsGrantPage);

		Tresource yhjsGrant = new Tresource();
		yhjsGrant.setId("yhjsGrant");
		yhjsGrant.setName("用户角色授权");
		yhjsGrant.setTresourcetype(funType);
		yhjsGrant.setTresource(yhgl);
		yhjsGrant.setSeq(9);
		yhjsGrant.setUrl("/userController/grantRole");
		yhjsGrant.setIcon("wrench");
		resourceDao.saveOrUpdate(yhjsGrant);
		
		Tresource yhjgGrantPage = new Tresource();
		yhjgGrantPage.setId("yhjgGrantPage");
		yhjgGrantPage.setName("用户机构授权页面");
		yhjgGrantPage.setTresourcetype(funType);
		yhjgGrantPage.setTresource(yhgl);
		yhjgGrantPage.setSeq(12);
		yhjgGrantPage.setUrl("/userController/userOrganizationGrant");
		yhjgGrantPage.setIcon("wrench");
		resourceDao.saveOrUpdate(yhjgGrantPage);

		Tresource yhjgGrant = new Tresource();
		yhjgGrant.setId("yhjgGrant");
		yhjgGrant.setName("用户机构授权");
		yhjgGrant.setTresourcetype(funType);
		yhjgGrant.setTresource(yhgl);
		yhjgGrant.setSeq(13);
		yhjgGrant.setUrl("/userController/grantOrganization");
		yhjgGrant.setIcon("wrench");
		resourceDao.saveOrUpdate(yhjgGrant);

		Tresource yhglEditPwdPage = new Tresource();
		yhglEditPwdPage.setId("yhglEditPwdPage");
		yhglEditPwdPage.setName("用户修改密码页面");
		yhglEditPwdPage.setTresourcetype(funType);
		yhglEditPwdPage.setTresource(yhgl);
		yhglEditPwdPage.setSeq(10);
		yhglEditPwdPage.setUrl("/userController/editPwdPage");
		yhglEditPwdPage.setIcon("wrench");
		resourceDao.saveOrUpdate(yhglEditPwdPage);

		Tresource yhglEditPwd = new Tresource();
		yhglEditPwd.setId("yhglEditPwd");
		yhglEditPwd.setName("用户修改密码");
		yhglEditPwd.setTresourcetype(funType);
		yhglEditPwd.setTresource(yhgl);
		yhglEditPwd.setSeq(11);
		yhglEditPwd.setUrl("/userController/editPwd");
		yhglEditPwd.setIcon("wrench");
		resourceDao.saveOrUpdate(yhglEditPwd);
		
		Tresource yhglAllTree = new Tresource();
		yhglAllTree.setId("yhglAllTree");
		yhglAllTree.setName("用户全树");
		yhglAllTree.setTresourcetype(funType);
		yhglAllTree.setTresource(yhgl);
		yhglAllTree.setSeq(12);
		yhglAllTree.setUrl("/userController/allTree");
		yhglAllTree.setIcon("wrench");
		resourceDao.saveOrUpdate(yhglAllTree);

		Tresource buggl = new Tresource();
		buggl.setId("buggl");
		buggl.setName("BUG管理");
		buggl.setTresourcetype(menuType);
		buggl.setTresource(xtgl);
		buggl.setSeq(4);
		buggl.setUrl("/bugController/manager");
		buggl.setIcon("bug");
		resourceDao.saveOrUpdate(buggl);
		
		Tresource bugglDateGrid = new Tresource();
		bugglDateGrid.setId("bugglDateGrid");
		bugglDateGrid.setName("BUG表格");
		bugglDateGrid.setTresourcetype(funType);
		bugglDateGrid.setTresource(buggl);
		bugglDateGrid.setSeq(1);
		bugglDateGrid.setUrl("/bugController/dataGrid");
		bugglDateGrid.setIcon("bug_link");
		resourceDao.saveOrUpdate(bugglDateGrid);

		Tresource bugglAddPage = new Tresource();
		bugglAddPage.setId("bugglAddPage");
		bugglAddPage.setName("添加BUG页面");
		bugglAddPage.setTresourcetype(funType);
		bugglAddPage.setTresource(buggl);
		bugglAddPage.setSeq(2);
		bugglAddPage.setUrl("/bugController/addPage");
		bugglAddPage.setIcon("bug_add");
		resourceDao.saveOrUpdate(bugglAddPage);

		Tresource bugglAdd = new Tresource();
		bugglAdd.setId("bugglAdd");
		bugglAdd.setName("添加BUG");
		bugglAdd.setTresourcetype(funType);
		bugglAdd.setTresource(buggl);
		bugglAdd.setSeq(3);
		bugglAdd.setUrl("/bugController/add");
		bugglAdd.setIcon("bug_add");
		resourceDao.saveOrUpdate(bugglAdd);

		Tresource bugglEditPage = new Tresource();
		bugglEditPage.setId("bugglEditPage");
		bugglEditPage.setName("编辑BUG页面");
		bugglEditPage.setTresourcetype(funType);
		bugglEditPage.setTresource(buggl);
		bugglEditPage.setSeq(4);
		bugglEditPage.setUrl("/bugController/editPage");
		bugglEditPage.setIcon("bug_edit");
		resourceDao.saveOrUpdate(bugglEditPage);

		Tresource bugglEdit = new Tresource();
		bugglEdit.setId("bugglEdit");
		bugglEdit.setName("编辑BUG");
		bugglEdit.setTresourcetype(funType);
		bugglEdit.setTresource(buggl);
		bugglEdit.setSeq(5);
		bugglEdit.setUrl("/bugController/edit");
		bugglEdit.setIcon("bug_edit");
		resourceDao.saveOrUpdate(bugglEdit);

		Tresource bugglDelete = new Tresource();
		bugglDelete.setId("bugglDelete");
		bugglDelete.setName("删除BUG");
		bugglDelete.setTresourcetype(funType);
		bugglDelete.setTresource(buggl);
		bugglDelete.setSeq(6);
		bugglDelete.setUrl("/bugController/delete");
		bugglDelete.setIcon("bug_delete");
		resourceDao.saveOrUpdate(bugglDelete);

		Tresource bugglView = new Tresource();
		bugglView.setId("bugglView");
		bugglView.setName("查看BUG");
		bugglView.setTresourcetype(funType);
		bugglView.setTresource(buggl);
		bugglView.setSeq(7);
		bugglView.setUrl("/bugController/view");
		bugglView.setIcon("bug_link");
		resourceDao.saveOrUpdate(bugglView);

		Tresource sjygl = new Tresource();
		sjygl.setId("sjygl");
		sjygl.setName("数据源管理");
		sjygl.setTresourcetype(menuType);
		sjygl.setTresource(xtgl);
		sjygl.setSeq(5);
		sjygl.setUrl("/druidController/druid");
		sjygl.setIcon("server_database");
		resourceDao.saveOrUpdate(sjygl);

		Tresource wjgl = new Tresource();
		wjgl.setId("wjgl");
		wjgl.setName("文件管理");
		wjgl.setTresourcetype(funType);
		wjgl.setTresource(xtgl);
		wjgl.setSeq(6);
		wjgl.setUrl("");
		wjgl.setIcon("server_database");
		resourceDao.saveOrUpdate(wjgl);

		Tresource wjglView = new Tresource();
		wjglView.setId("wjglView");
		wjglView.setName("浏览服务器文件");
		wjglView.setTresourcetype(funType);
		wjglView.setTresource(wjgl);
		wjglView.setSeq(1);
		wjglView.setUrl("/fileController/fileManage");
		wjglView.setIcon("server_database");
		resourceDao.saveOrUpdate(wjglView);

		Tresource wjglUpload = new Tresource();
		wjglUpload.setId("wjglUpload");
		wjglUpload.setName("上传文件");
		wjglUpload.setTresourcetype(funType);
		wjglUpload.setTresource(wjgl);
		wjglUpload.setSeq(2);
		wjglUpload.setUrl("/fileController/upload");
		wjglUpload.setIcon("server_database");
		resourceDao.saveOrUpdate(wjglUpload);

		Tresource chart = new Tresource();
		chart.setId("chart");
		chart.setName("图表管理");
		chart.setTresourcetype(menuType);
		chart.setSeq(7);
		chart.setIcon("chart_bar");
		resourceDao.saveOrUpdate(chart);

		Tresource userCreateDatetimeChart = new Tresource();
		userCreateDatetimeChart.setId("userCreateDatetimeChart");
		userCreateDatetimeChart.setName("用户图表");
		userCreateDatetimeChart.setTresourcetype(menuType);
		userCreateDatetimeChart.setUrl("/chartController/userCreateDatetimeChart");
		userCreateDatetimeChart.setSeq(1);
		userCreateDatetimeChart.setIcon("chart_curve");
		userCreateDatetimeChart.setTresource(chart);
		resourceDao.saveOrUpdate(userCreateDatetimeChart);

		Tresource jeasyuiApi = new Tresource();
		jeasyuiApi.setId("jggl");
		jeasyuiApi.setName("jeasyuiApi");
		jeasyuiApi.setTresourcetype(menuType);
		jeasyuiApi.setUrl("http://jeasyui.com/documentation");
		jeasyuiApi.setSeq(1000);
		jeasyuiApi.setIcon("book");
		resourceDao.saveOrUpdate(jeasyuiApi);

		Tresource zzgl = new Tresource();
		zzgl.setId("zzgl");
		zzgl.setName("机构管理");
		zzgl.setTresourcetype(menuType);
		zzgl.setTresource(xtgl);
		zzgl.setSeq(7);
		zzgl.setUrl("/organizationController/manager");
		zzgl.setIcon("chart_pie");
		resourceDao.saveOrUpdate(zzgl);

		Tresource zzglTreeGrid = new Tresource();
		zzglTreeGrid.setId("zzglTreeGrid");
		zzglTreeGrid.setName("机构表格");
		zzglTreeGrid.setTresourcetype(funType);
		zzglTreeGrid.setTresource(zzgl);
		zzglTreeGrid.setSeq(1);
		zzglTreeGrid.setUrl("/organizationController/treeGrid");
		zzglTreeGrid.setIcon("chart_pie");
		resourceDao.saveOrUpdate(zzglTreeGrid);
		
		Tresource zzglAddPage = new Tresource();
		zzglAddPage.setId("zzglAddPage");
		zzglAddPage.setName("添加机构页面");
		zzglAddPage.setTresourcetype(funType);
		zzglAddPage.setTresource(zzgl);
		zzglAddPage.setSeq(2);
		zzglAddPage.setUrl("/organizationController/addPage");
		zzglAddPage.setIcon("chart_pie");
		resourceDao.saveOrUpdate(zzglAddPage);
		
		Tresource zzglAllTree = new Tresource();
		zzglAllTree.setId("zzglAllTree");
		zzglAllTree.setName("机构全树");
		zzglAllTree.setTresourcetype(funType);
		zzglAllTree.setTresource(zzgl);
		zzglAllTree.setSeq(3);
		zzglAllTree.setUrl("/organizationController/allTree");
		zzglAllTree.setIcon("chart_pie");
		resourceDao.saveOrUpdate(zzglAllTree);
		
		Tresource zzglAdd = new Tresource();
		zzglAdd.setId("zzglAdd");
		zzglAdd.setName("添加机构");
		zzglAdd.setTresourcetype(funType);
		zzglAdd.setTresource(zzgl);
		zzglAdd.setSeq(4);
		zzglAdd.setUrl("/organizationController/add");
		zzglAdd.setIcon("chart_pie");
		resourceDao.saveOrUpdate(zzglAdd);
		
		Tresource zzglEditPage = new Tresource();
		zzglEditPage.setId("zzglEditPage");
		zzglEditPage.setName("编辑机构页面");
		zzglEditPage.setTresourcetype(funType);
		zzglEditPage.setTresource(zzgl);
		zzglEditPage.setSeq(5);
		zzglEditPage.setUrl("/organizationController/editPage");
		zzglEditPage.setIcon("chart_pie");
		resourceDao.saveOrUpdate(zzglEditPage);

		Tresource zzglEdit = new Tresource();
		zzglEdit.setId("zzglEdit");
		zzglEdit.setName("编辑机构");
		zzglEdit.setTresourcetype(funType);
		zzglEdit.setTresource(zzgl);
		zzglEdit.setSeq(6);
		zzglEdit.setUrl("/organizationController/edit");
		zzglEdit.setIcon("chart_pie");
		resourceDao.saveOrUpdate(zzglEdit);

		Tresource zzglDelete = new Tresource();
		zzglDelete.setId("zzglDelete");
		zzglDelete.setName("删除机构");
		zzglDelete.setTresourcetype(funType);
		zzglDelete.setTresource(zzgl);
		zzglDelete.setSeq(7);
		zzglDelete.setUrl("/organizationController/delete");
		zzglDelete.setIcon("chart_pie");
		resourceDao.saveOrUpdate(zzglDelete);

		Tresource zzglView = new Tresource();
		zzglView.setId("zzglView");
		zzglView.setName("查看机构");
		zzglView.setTresourcetype(funType);
		zzglView.setTresource(zzgl);
		zzglView.setSeq(8);
		zzglView.setUrl("/organizationController/view");
		zzglView.setIcon("chart_pie");
		resourceDao.saveOrUpdate(zzglView);

		Tresource zzglGrantPage = new Tresource();
		zzglGrantPage.setId("zzglGrantPage");
		zzglGrantPage.setName("机构授权页面");
		zzglGrantPage.setTresourcetype(funType);
		zzglGrantPage.setTresource(zzgl);
		zzglGrantPage.setSeq(9);
		zzglGrantPage.setUrl("/organizationController/grantPage");
		zzglGrantPage.setIcon("chart_pie");
		resourceDao.saveOrUpdate(zzglGrantPage);

		Tresource zzglGrant = new Tresource();
		zzglGrant.setId("zzglGrant");
		zzglGrant.setName("机构授权");
		zzglGrant.setTresourcetype(funType);
		zzglGrant.setTresource(zzgl);
		zzglGrant.setSeq(10);
		zzglGrant.setUrl("/organizationController/grant");
		zzglGrant.setIcon("chart_pie");
		resourceDao.saveOrUpdate(zzglGrant);

		Tresource zzglTree = new Tresource();
		zzglTree.setId("zzglTree");
		zzglTree.setName("机构树");
		zzglTree.setTresourcetype(funType);
		zzglTree.setTresource(zzgl);
		zzglTree.setSeq(11);
		zzglTree.setUrl("/organizationController/tree");
		zzglTree.setIcon("chart_pie");
		resourceDao.saveOrUpdate(zzglTree);
		
		Tresource khgl = new Tresource();
		khgl.setId("khgl");
		khgl.setName("客户管理");
		khgl.setTresourcetype(menuType);
		khgl.setTresource(xtgl);
		khgl.setSeq(8);
		khgl.setUrl("/customerController/manager");
		khgl.setIcon("bricks");
		resourceDao.saveOrUpdate(khgl);

		Tresource khglTreeGrid = new Tresource();
		khglTreeGrid.setId("khglTreeGrid");
		khglTreeGrid.setName("客户表格");
		khglTreeGrid.setTresourcetype(funType);
		khglTreeGrid.setTresource(khgl);
		khglTreeGrid.setSeq(1);
		khglTreeGrid.setUrl("/customerController/dataGrid");
		khglTreeGrid.setIcon("bricks");
		resourceDao.saveOrUpdate(khglTreeGrid);
		
		Tresource khglAddPage = new Tresource();
		khglAddPage.setId("khglAddPage");
		khglAddPage.setName("添加客户页面");
		khglAddPage.setTresourcetype(funType);
		khglAddPage.setTresource(khgl);
		khglAddPage.setSeq(2);
		khglAddPage.setUrl("/customerController/addPage");
		khglAddPage.setIcon("bricks");
		resourceDao.saveOrUpdate(khglAddPage);
		
		Tresource khglAdd = new Tresource();
		khglAdd.setId("khglAdd");
		khglAdd.setName("添加机构");
		khglAdd.setTresourcetype(funType);
		khglAdd.setTresource(khgl);
		khglAdd.setSeq(3);
		khglAdd.setUrl("/customerController/add");
		khglAdd.setIcon("bricks");
		resourceDao.saveOrUpdate(khglAdd);
		
		Tresource khglEditPage = new Tresource();
		khglEditPage.setId("khglEditPage");
		khglEditPage.setName("编辑客户页面");
		khglEditPage.setTresourcetype(funType);
		khglEditPage.setTresource(khgl);
		khglEditPage.setSeq(4);
		khglEditPage.setUrl("/customerController/editPage");
		khglEditPage.setIcon("bricks");
		resourceDao.saveOrUpdate(khglEditPage);

		Tresource khglEdit = new Tresource();
		khglEdit.setId("khglEdit");
		khglEdit.setName("编辑客户");
		khglEdit.setTresourcetype(funType);
		khglEdit.setTresource(khgl);
		khglEdit.setSeq(5);
		khglEdit.setUrl("/customerController/edit");
		khglEdit.setIcon("bricks");
		resourceDao.saveOrUpdate(khglEdit);

		Tresource khglDelete = new Tresource();
		khglDelete.setId("khglDelete");
		khglDelete.setName("删除客户");
		khglDelete.setTresourcetype(funType);
		khglDelete.setTresource(khgl);
		khglDelete.setSeq(6);
		khglDelete.setUrl("/customerController/delete");
		khglDelete.setIcon("bricks");
		resourceDao.saveOrUpdate(khglDelete);

		Tresource khglBatchDelete = new Tresource();
		khglBatchDelete.setId("khglBatchDelete");
		khglBatchDelete.setName("批量删除客户");
		khglBatchDelete.setTresourcetype(funType);
		khglBatchDelete.setTresource(khgl);
		khglBatchDelete.setSeq(7);
		khglBatchDelete.setUrl("/customerController/batchDelete");
		khglBatchDelete.setIcon("bricks");
		resourceDao.saveOrUpdate(khglBatchDelete);
		
		Tresource kcgl = new Tresource();
		kcgl.setId("kcgl");
		kcgl.setName("课程管理");
		kcgl.setTresourcetype(menuType);
		kcgl.setTresource(xtgl);
		kcgl.setSeq(9);
		kcgl.setUrl("/coursesController/manager");
		kcgl.setIcon("box");
		resourceDao.saveOrUpdate(kcgl);

		Tresource kcglDataGrid = new Tresource();
		kcglDataGrid.setId("kcglDataGrid");
		kcglDataGrid.setName("课程表格");
		kcglDataGrid.setTresourcetype(funType);
		kcglDataGrid.setTresource(kcgl);
		kcglDataGrid.setSeq(1);
		kcglDataGrid.setUrl("/coursesController/dataGrid");
		kcglDataGrid.setIcon("box");
		resourceDao.saveOrUpdate(kcglDataGrid);
		
		Tresource kcglAddPage = new Tresource();
		kcglAddPage.setId("kcglAddPage");
		kcglAddPage.setName("添加课程页面");
		kcglAddPage.setTresourcetype(funType);
		kcglAddPage.setTresource(kcgl);
		kcglAddPage.setSeq(2);
		kcglAddPage.setUrl("/coursesController/addPage");
		kcglAddPage.setIcon("box");
		resourceDao.saveOrUpdate(kcglAddPage);
		
		Tresource kcglAdd = new Tresource();
		kcglAdd.setId("kcglAdd");
		kcglAdd.setName("添加课程");
		kcglAdd.setTresourcetype(funType);
		kcglAdd.setTresource(kcgl);
		kcglAdd.setSeq(3);
		kcglAdd.setUrl("/coursesController/add");
		kcglAdd.setIcon("box");
		resourceDao.saveOrUpdate(kcglAdd);
		
		Tresource kcglEditPage = new Tresource();
		kcglEditPage.setId("kcglEditPage");
		kcglEditPage.setName("编辑课程页面");
		kcglEditPage.setTresourcetype(funType);
		kcglEditPage.setTresource(kcgl);
		kcglEditPage.setSeq(4);
		kcglEditPage.setUrl("/coursesController/editPage");
		kcglEditPage.setIcon("box");
		resourceDao.saveOrUpdate(kcglEditPage);

		Tresource kcglEdit = new Tresource();
		kcglEdit.setId("kcglEdit");
		kcglEdit.setName("编辑课程");
		kcglEdit.setTresourcetype(funType);
		kcglEdit.setTresource(kcgl);
		kcglEdit.setSeq(5);
		kcglEdit.setUrl("/coursesController/edit");
		kcglEdit.setIcon("box");
		resourceDao.saveOrUpdate(kcglEdit);

		Tresource kcglDelete = new Tresource();
		kcglDelete.setId("kcglDelete");
		kcglDelete.setName("删除课程");
		kcglDelete.setTresourcetype(funType);
		kcglDelete.setTresource(kcgl);
		kcglDelete.setSeq(6);
		kcglDelete.setUrl("/coursesController/delete");
		kcglDelete.setIcon("box");
		resourceDao.saveOrUpdate(kcglDelete);

		Tresource kcglBatchDelete = new Tresource();
		kcglBatchDelete.setId("kcglBatchDelete");
		kcglBatchDelete.setName("批量删除课程");
		kcglBatchDelete.setTresourcetype(funType);
		kcglBatchDelete.setTresource(kcgl);
		kcglBatchDelete.setSeq(7);
		kcglBatchDelete.setUrl("/coursesController/batchDelete");
		kcglBatchDelete.setIcon("box");
		resourceDao.saveOrUpdate(kcglBatchDelete);
		
		Tresource bjgl = new Tresource();
		bjgl.setId("bjgl");
		bjgl.setName("班级管理");
		bjgl.setTresourcetype(menuType);
		bjgl.setTresource(xtgl);
		bjgl.setSeq(10);
		bjgl.setUrl("/classMateController/manager");
		bjgl.setIcon("rainbow");
		resourceDao.saveOrUpdate(bjgl);

		Tresource bjglDataGrid = new Tresource();
		bjglDataGrid.setId("bjglDataGrid");
		bjglDataGrid.setName("班级表格");
		bjglDataGrid.setTresourcetype(funType);
		bjglDataGrid.setTresource(bjgl);
		bjglDataGrid.setSeq(1);
		bjglDataGrid.setUrl("/classMateController/dataGrid");
		bjglDataGrid.setIcon("rainbow");
		resourceDao.saveOrUpdate(bjglDataGrid);
		
		Tresource bjglAddPage = new Tresource();
		bjglAddPage.setId("bjglAddPage");
		bjglAddPage.setName("添加班级页面");
		bjglAddPage.setTresourcetype(funType);
		bjglAddPage.setTresource(bjgl);
		bjglAddPage.setSeq(2);
		bjglAddPage.setUrl("/classMateController/addPage");
		bjglAddPage.setIcon("rainbow");
		resourceDao.saveOrUpdate(bjglAddPage);
		
		Tresource bjglAdd = new Tresource();
		bjglAdd.setId("bjglAdd");
		bjglAdd.setName("添加班级");
		bjglAdd.setTresourcetype(funType);
		bjglAdd.setTresource(bjgl);
		bjglAdd.setSeq(3);
		bjglAdd.setUrl("/classMateController/add");
		bjglAdd.setIcon("rainbow");
		resourceDao.saveOrUpdate(bjglAdd);
		
		Tresource bjglEditPage = new Tresource();
		bjglEditPage.setId("bjglEditPage");
		bjglEditPage.setName("编辑班级页面");
		bjglEditPage.setTresourcetype(funType);
		bjglEditPage.setTresource(bjgl);
		bjglEditPage.setSeq(4);
		bjglEditPage.setUrl("/classMateController/editPage");
		bjglEditPage.setIcon("rainbow");
		resourceDao.saveOrUpdate(bjglEditPage);

		Tresource bjglEdit = new Tresource();
		bjglEdit.setId("bjglEdit");
		bjglEdit.setName("编辑班级");
		bjglEdit.setTresourcetype(funType);
		bjglEdit.setTresource(bjgl);
		bjglEdit.setSeq(5);
		bjglEdit.setUrl("/classMateController/edit");
		bjglEdit.setIcon("rainbow");
		resourceDao.saveOrUpdate(bjglEdit);

		Tresource bjglDelete = new Tresource();
		bjglDelete.setId("bjglDelete");
		bjglDelete.setName("删除班级");
		bjglDelete.setTresourcetype(funType);
		bjglDelete.setTresource(bjgl);
		bjglDelete.setSeq(6);
		bjglDelete.setUrl("/classMateController/delete");
		bjglDelete.setIcon("rainbow");
		resourceDao.saveOrUpdate(bjglDelete);

		Tresource bjglBatchDelete = new Tresource();
		bjglBatchDelete.setId("bjglBatchDelete");
		bjglBatchDelete.setName("批量删除班级");
		bjglBatchDelete.setTresourcetype(funType);
		bjglBatchDelete.setTresource(bjgl);
		bjglBatchDelete.setSeq(7);
		bjglBatchDelete.setUrl("/classMateController/batchDelete");
		bjglBatchDelete.setIcon("rainbow");
		resourceDao.saveOrUpdate(bjglBatchDelete);
		
		Tresource cjgl = new Tresource();
		cjgl.setId("cjgl");
		cjgl.setName("成交管理");
		cjgl.setTresourcetype(menuType);
		cjgl.setTresource(xtgl);
		cjgl.setSeq(11);
		cjgl.setUrl("/chengjiaoController/manager");
		cjgl.setIcon("briefcase");
		resourceDao.saveOrUpdate(cjgl);

		Tresource cjglDataGrid = new Tresource();
		cjglDataGrid.setId("cjglDataGrid");
		cjglDataGrid.setName("成交记录表格");
		cjglDataGrid.setTresourcetype(funType);
		cjglDataGrid.setTresource(cjgl);
		cjglDataGrid.setSeq(1);
		cjglDataGrid.setUrl("/chengjiaoController/dataGrid");
		cjglDataGrid.setIcon("briefcase");
		resourceDao.saveOrUpdate(cjglDataGrid);

		Tresource cjglAddPage = new Tresource();
		cjglAddPage.setId("cjglAddPage");
		cjglAddPage.setName("添加成交记录页面");
		cjglAddPage.setTresourcetype(funType);
		cjglAddPage.setTresource(cjgl);
		cjglAddPage.setSeq(2);
		cjglAddPage.setUrl("/chengjiaoController/addPage");
		cjglAddPage.setIcon("briefcase");
		resourceDao.saveOrUpdate(cjglAddPage);
		
		Tresource cjglAdd = new Tresource();
		cjglAdd.setId("cjglAdd");
		cjglAdd.setName("添加成交记录");
		cjglAdd.setTresourcetype(funType);
		cjglAdd.setTresource(cjgl);
		cjglAdd.setSeq(3);
		cjglAdd.setUrl("/chengjiaoController/add");
		cjglAdd.setIcon("briefcase");
		resourceDao.saveOrUpdate(cjglAdd);
		
		Tresource cjglEditPage = new Tresource();
		cjglEditPage.setId("cjglEditPage");
		cjglEditPage.setName("编辑提交记录页面");
		cjglEditPage.setTresourcetype(funType);
		cjglEditPage.setTresource(cjgl);
		cjglEditPage.setSeq(4);
		cjglEditPage.setUrl("/chengjiaoController/editPage");
		cjglEditPage.setIcon("briefcase");
		resourceDao.saveOrUpdate(cjglEditPage);

		Tresource cjglEdit = new Tresource();
		cjglEdit.setId("cjglEdit");
		cjglEdit.setName("编辑提交记录");
		cjglEdit.setTresourcetype(funType);
		cjglEdit.setTresource(cjgl);
		cjglEdit.setSeq(5);
		cjglEdit.setUrl("/chengjiaoController/edit");
		cjglEdit.setIcon("briefcase");
		resourceDao.saveOrUpdate(cjglEdit);

		Tresource cjglDelete = new Tresource();
		cjglDelete.setId("cjglDelete");
		cjglDelete.setName("删除成交记录");
		cjglDelete.setTresourcetype(funType);
		cjglDelete.setTresource(cjgl);
		cjglDelete.setSeq(6);
		cjglDelete.setUrl("/chengjiaoController/delete");
		cjglDelete.setIcon("briefcase");
		resourceDao.saveOrUpdate(cjglDelete);

		Tresource cjglBatchDelete = new Tresource();
		cjglBatchDelete.setId("cjglBatchDelete");
		cjglBatchDelete.setName("批量删除成交记录");
		cjglBatchDelete.setTresourcetype(funType);
		cjglBatchDelete.setTresource(cjgl);
		cjglBatchDelete.setSeq(7);
		cjglBatchDelete.setUrl("/chengjiaoController/batchDelete");
		cjglBatchDelete.setIcon("briefcase");
		resourceDao.saveOrUpdate(cjglBatchDelete);
		
		Tresource fzdgl = new Tresource();
		fzdgl.setId("fzdgl");
		fzdgl.setName("防撞单管理");
		fzdgl.setTresourcetype(menuType);
		fzdgl.setTresource(xtgl);
		fzdgl.setSeq(12);
		fzdgl.setUrl("/customerController/qManager");
		fzdgl.setIcon("money");
		resourceDao.saveOrUpdate(fzdgl);

		Tresource fzdglGrid = new Tresource();
		fzdglGrid.setId("fzdglGrid");
		fzdglGrid.setName("客户表格");
		fzdglGrid.setTresourcetype(funType);
		fzdglGrid.setTresource(fzdgl);
		fzdglGrid.setSeq(1);
		fzdglGrid.setUrl("/customerController/qDataGrid");
		fzdglGrid.setIcon("money");
		resourceDao.saveOrUpdate(fzdglGrid);
		
	}

	private void initResourceType() {
		Tresourcetype t = new Tresourcetype();
		t.setId("0");
		t.setName("菜单");
		resourceTypeDao.saveOrUpdate(t);

		Tresourcetype t2 = new Tresourcetype();
		t2.setId("1");
		t2.setName("功能");
		resourceTypeDao.saveOrUpdate(t2);
		
	}
	
	private void initOrganization() {
		Torganization dsh = new Torganization();
		dsh.setId("0");
		dsh.setName("董事会");
		dsh.setSeq(0);
		organizationDao.saveOrUpdate(dsh);
		
		Torganization dsz = new Torganization();
		dsz.setId("dsz");
		dsz.setName("董事长");
		dsz.setTorganization(dsh);
		dsz.setSeq(1);
		organizationDao.saveOrUpdate(dsz);
		
		Torganization zjl = new Torganization();
		zjl.setId("zjl");
		zjl.setName("总经理");
		zjl.setTorganization(dsz);
		zjl.setSeq(1);
		organizationDao.saveOrUpdate(zjl);
		
		Torganization cwzx = new Torganization();
		cwzx.setId("cwzx");
		cwzx.setName("财务中心");
		cwzx.setTorganization(dsz);
		cwzx.setSeq(2);
		organizationDao.saveOrUpdate(cwzx);
	}

	private void initRole() {
		Trole superAdmin = new Trole();
		superAdmin.setId("0");
		superAdmin.setName("超管");
		superAdmin.getTresources().addAll(resourceDao.find("from Tresource t"));// 让超管可以访问所有资源
		superAdmin.setSeq(0);
		superAdmin.setRemark("超级管理员角色，拥有系统中所有的资源访问权限");
		roleDao.saveOrUpdate(superAdmin);

		Trole zyAdmin = new Trole();
		zyAdmin.setId("zyAdmin");
		zyAdmin.setName("资源管理员");
		zyAdmin.setTrole(superAdmin);// 父级是超管
		zyAdmin.setSeq(1);
		zyAdmin.getTresources().addAll(resourceDao.find("from Tresource t where t.tresource.id in ('zygl') or t.id in ('zygl')"));
		roleDao.saveOrUpdate(zyAdmin);

		Trole jsAdmin = new Trole();
		jsAdmin.setId("jsAdmin");
		jsAdmin.setName("角色管理员");
		jsAdmin.setTrole(superAdmin);// 父级是超管
		jsAdmin.setSeq(2);
		jsAdmin.getTresources().addAll(resourceDao.find("from Tresource t where t.tresource.id in ('jsgl') or t.id in ('jsgl')"));
		roleDao.saveOrUpdate(jsAdmin);

		Trole yhAdmin = new Trole();
		yhAdmin.setId("yhAdmin");
		yhAdmin.setName("用户管理员");
		yhAdmin.setTrole(superAdmin);// 父级是超管
		yhAdmin.setSeq(3);
		yhAdmin.getTresources().addAll(resourceDao.find("from Tresource t where t.tresource.id in ('yhgl') or t.id in ('yhgl')"));
		roleDao.saveOrUpdate(yhAdmin);

		Trole sjyAdmin = new Trole();
		sjyAdmin.setId("sjyAdmin");
		sjyAdmin.setName("数据源管理员");
		sjyAdmin.setTrole(superAdmin);// 父级是超管
		sjyAdmin.setSeq(4);
		sjyAdmin.getTresources().addAll(resourceDao.find("from Tresource t where t.tresource.id in ('sjygl') or t.id in ('sjygl')"));
		roleDao.saveOrUpdate(sjyAdmin);

		Trole bugAdmin = new Trole();
		bugAdmin.setId("bugAdmin");
		bugAdmin.setName("BUG管理员");
		bugAdmin.setTrole(superAdmin);// 父级是超管
		bugAdmin.setSeq(5);
		bugAdmin.getTresources().addAll(resourceDao.find("from Tresource t where t.tresource.id in ('buggl') or t.id in ('buggl')"));
		roleDao.saveOrUpdate(bugAdmin);

		Trole customerAdmin = new Trole();
		customerAdmin.setId("customerAdmin");
		customerAdmin.setName("客户管理员");
		customerAdmin.setTrole(superAdmin);// 父级是超管
		customerAdmin.setSeq(6);
		customerAdmin.getTresources().addAll(resourceDao.find("from Tresource t where t.tresource.id in ('khgl','kcgl','bjgl','cjgl','fzdgl') or t.id in ('khgl','kcgl','bjgl','cjgl','fzdgl')"));
		roleDao.saveOrUpdate(customerAdmin);
		
		Trole guest = new Trole();
		guest.setId("guest");
		guest.setName("Guest");
		guest.getTresources().addAll(resourceDao.find("from Tresource t where t.id in ('xtgl','zygl','zyglTreeGrid','jsgl','jsglTreeGrid','yhgl','yhglDateGrid','jeasyuiApi','khgl','khglTreeGrid')"));
		guest.setSeq(1);
		guest.setRemark("只拥有只看的权限");
		roleDao.saveOrUpdate(guest);
	}

	private void initUser() {
		List<Tuser> l = userDao.find("from Tuser t where t.name in ('admin','admin1','admin2','admin3','admin4','admin5','guest')");
		if (l != null && l.size() > 0) {
			for (Tuser user : l) {
				userDao.delete(user);
			}
		}

		Tuser admin = new Tuser();
		admin.setId("0");
		admin.setName("admin");
		admin.setPwd(MD5Util.md5("123456"));
		admin.setCreatedatetime(new Date());
		admin.getTroles().addAll(roleDao.find("from Trole t"));// 给用户赋予所有角色
		userDao.saveOrUpdate(admin);

		Tuser admin1 = new Tuser();
		admin1.setId("1");
		admin1.setName("admin1");
		admin1.setPwd(MD5Util.md5("123456"));
		admin1.setCreatedatetime(new Date());
		admin1.getTroles().addAll(roleDao.find("from Trole t where t.id = 'zyAdmin'"));// 给用户赋予资源管理员角色
		userDao.saveOrUpdate(admin1);

		Tuser admin2 = new Tuser();
		admin2.setId("2");
		admin2.setName("admin2");
		admin2.setPwd(MD5Util.md5("123456"));
		admin2.setCreatedatetime(new Date());
		admin2.getTroles().addAll(roleDao.find("from Trole t where t.id = 'jsAdmin'"));// 给用户赋予角色管理员角色
		userDao.saveOrUpdate(admin2);

		Tuser admin3 = new Tuser();
		admin3.setId("3");
		admin3.setName("admin3");
		admin3.setPwd(MD5Util.md5("123456"));
		admin3.setCreatedatetime(new Date());
		admin3.getTroles().addAll(roleDao.find("from Trole t where t.id = 'yhAdmin'"));// 给用户赋予用户管理员角色
		userDao.saveOrUpdate(admin3);

		Tuser admin4 = new Tuser();
		admin4.setId("4");
		admin4.setName("admin4");
		admin4.setPwd(MD5Util.md5("123456"));
		admin4.setCreatedatetime(new Date());
		admin4.getTroles().addAll(roleDao.find("from Trole t where t.id = 'sjyAdmin'"));// 给用户赋予数据源管理员角色
		userDao.saveOrUpdate(admin4);

		Tuser admin5 = new Tuser();
		admin5.setId("5");
		admin5.setName("admin5");
		admin5.setPwd(MD5Util.md5("123456"));
		admin5.setCreatedatetime(new Date());
		admin5.getTroles().addAll(roleDao.find("from Trole t where t.id = 'bugAdmin'"));// 给用户赋予BUG管理员角色
		userDao.saveOrUpdate(admin5);

		Tuser guest = new Tuser();
		guest.setId("guest");
		guest.setName("guest");
		guest.setPwd(MD5Util.md5("123456"));
		guest.setCreatedatetime(new Date());
		guest.getTroles().addAll(roleDao.find("from Trole t where t.id = 'guest'"));// 给用户赋予Guest角色
		userDao.saveOrUpdate(guest);
	}
}
