package sy.test;

import java.lang.reflect.Field;
import java.util.Date;

import javax.swing.plaf.metal.MetalIconFactory.FolderIcon16;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sy.annt.ExtBean2JsUtils;
import sy.model.Tcustomer;
import sy.pageModel.Customer;
import sy.pageModel.Follow;
import sy.service.InitServiceI;
import sy.service.UserServiceI;

public class GreantBean2JsForm {

	/**
	 * Bean转换为ext model
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 */
	 @Test
	 public void t1() throws NoSuchFieldException, SecurityException {
	//String beansExtJson = ExtBean2JsUtils.getBeansExtJson(Customer.class, "qq","wx","phone2","email","adr","LCardType",
	//		"LCardCode","brdtype","brd");
//	String beansExtJson2 = ExtBean2JsUtils.getBeansExtJson(Customer.class, "ltdName","ltdAdr","areaCode","ltdDet","ltdZhiwu","ltdYewu","LSheng","LShi","LXian","LWww","ltdWx","ltdChanpin","ltdNote");
	
	//String beansExtJson2 = ExtBean2JsUtils.getBeansExtJson(Customer.class, "kLabel");
	//String beansExtJson2 = ExtBean2JsUtils.getBeansExtJson(Customer.class, "typeLabel");
	
	String beansExtJson = ExtBean2JsUtils.getBeansExtJson(Follow.class, 1);
	System.out.println("json:"+beansExtJson);
	//System.out.println("json:"+beansExtJson2);
	 }

	
}
