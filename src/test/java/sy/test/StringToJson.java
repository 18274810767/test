package sy.test;

import org.junit.Test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class StringToJson {
	@Test
	public void s2j(){
		String s="短信、电话、上门拜访、微信";
//		String s="总裁未听、总裁已听、总裁已报、总裁已上、职场未听、职场已听、职场已报、职场已上";
//		String s="已电话沟通、已拜访送票、已报出价格、已听体验课、已成交-定金、已成交-全款";
//		String s="绝对保护、相对保护、公池";
//		String s="电话帅选、400电话咨询、座机咨询、手机咨询、talk99咨询、QQ咨询、微信咨询、后台留言、短信群发、合作机构、转介绍、其他";
		String[] split = s.split("、");
		JSONArray arr=new JSONArray();
		int i=1;
		for (String tmp : split) {
			JSONObject jso=new JSONObject();
			jso.put("value", i+"");
			jso.put("text", tmp);
			arr.add(jso);
			i++;
		}
		
		System.out.println(arr.toJSONString());
		
	}

}
