package sy.test;

import java.lang.reflect.Field;
import java.util.Date;

import javax.swing.plaf.metal.MetalIconFactory.FolderIcon16;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sy.model.Tcustomer;
import sy.pageModel.Follow;
import sy.service.InitServiceI;
import sy.service.UserServiceI;

public class GreantBean2JsModel {

	/**
	 * Bean转换为ext model
	 */
	 @Test
	 public void t1() {
	 Class cls=Follow.class;
	 Field[] fields = cls.getDeclaredFields();
	 StringBuilder sb=new StringBuilder();
	 for (Field field : fields) {
		String n=field.getName();
		String k="string";
		Class<?> type = field.getType();
		System.out.println(type.getName());
		if(type.equals(String.class)){
			k="string";
		}else if(type.equals(Integer.class)||type.equals(Float.class)||type.equals(Double.class)){
			k="int";
		}else if(type.equals(Date.class)){
			k="date";
		}else{
			k="auto";
		}
		sb.append(String.format("{name:'%s', type: '%s'},\n", n,k));
	}
	 System.out.println(sb.toString());
	 }

	
}
