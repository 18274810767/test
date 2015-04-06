package sy.controller;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.ehcache.hibernate.management.impl.BeanUtils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sy.annt.Ext;
import sy.annt.ExtJson;
import sy.pageModel.Customer;
import sy.pageModel.Follow;
import sy.pageModel.Json;
import sy.service.UserServiceI;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.deserializer.StringFieldDeserializer;
import com.wxb.tools.AreaZG;
import com.wxb.tools.StaticConfig;

/**
 * 用户控制器
 * 
 * @author 谭楚柱
 * 
 */
@ExtJson(cls = { Customer.class ,Follow.class})
@Controller
@RequestMapping("/extController")
public class ExtController extends BaseController {

	private static boolean IS_LOAD_CONFIG = false;

	private static Map<String, Object> CONFIG_JSON = new HashMap<String, Object>();

	@Autowired
	private UserServiceI userService;

	/**
	 * 用户登录
	 * 
	 * @param user
	 *            用户对象
	 * @param session
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/basejson")
	public Json extjsons(HttpSession session, HttpServletRequest request,
			HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Headers", "X-Requested-With");

		String q = request.getParameter("q");
		Json j = new Json();
		if (IS_LOAD_CONFIG == false) {
			ExtJson json = this.getClass().getAnnotation(ExtJson.class);
			// JSONArray arr = new JSONArray();
			Class<?>[] cls = json.cls();
			for (Class<?> class1 : cls) {
				Field[] fields = class1.getDeclaredFields();
				for (Field field : fields) {
					Ext ext = field.getAnnotation(Ext.class);
					if (ext == null) {
						continue;
					}
					String json2 = ext.json();
					if (StringUtils.isBlank(json2)) {
						continue;
					}
					if (json2.startsWith("json:")) {
						json2 = json2.substring(5);
						json2.replaceAll("'", "\"");

						// JSONObject jo = new JSONObject();
						// jo.put("id", class1.getSimpleName() + "_" +
						// field.getName());
						// jo.put("value", JSONArray.parse(json2));
						// arr.add(jo);
						CONFIG_JSON.put(
								class1.getSimpleName() + "_" + field.getName(),
								JSONArray.parse(json2));
					} else if (json2.startsWith("hsql:")) {
						json2 = json2.substring(5);
						JSONObject o = JSONObject.parseObject(json2);
						List list = this.userService.exHSql(o.getString("sql"));
						String key = o.getString("text");
						String v = o.getString("value");
						if (list != null) {
							JSONArray tmp = new JSONArray();
							for (Object object : list) {
								JSONObject tmpj = new JSONObject();
								tmpj.put("value",
										BeanUtils.getBeanProperty(object, key)
												.toString());
								tmpj.put("text",
										BeanUtils.getBeanProperty(object, v)
												.toString());
								tmp.add(tmpj);
							}
							// JSONObject jo = new JSONObject();
							// jo.put("id",
							// // class1.getSimpleName() + "_" +
							// field.getName());
							// jo.put("value", tmp);
							// arr.add(jo);
							CONFIG_JSON.put(class1.getSimpleName() + "_"
									+ field.getName(), tmp);

						}

					}

				}
			}

			IS_LOAD_CONFIG = true;
			System.out.println("load!!");
		}
		j.setSuccess(true);
		Object object = CONFIG_JSON.get(q);
		if (object == null) {
			j.setObj(new JSONArray());
		} else {
			j.setObj(object);
		}
		return j;
	}

	@ResponseBody
	@RequestMapping("/areajson")
	public Json getarea(HttpSession session, HttpServletRequest request,
			HttpServletResponse response) {
		Json j = new Json();
		String sheng = request.getParameter("sheng");
		String shi = request.getParameter("shi");
		String a = request.getParameter("a");
		JSONArray arr = new JSONArray();
		
		if("1".equals(a)){
		
		List<AreaZG> areas=StaticConfig.getAreas();
		
		if (StringUtils.isBlank(sheng) && StringUtils.isBlank(shi)) {
			 areas = StaticConfig.getAreas();
		}else if(StringUtils.isNotBlank(sheng)&&StringUtils.isBlank(shi)){
			for(AreaZG t:areas){
				if(t.getAreaID()==Integer.parseInt(sheng)){
					areas=t.getChildren();
					break;
				}
			}
			
		}else if(StringUtils.isNotBlank(sheng)&&StringUtils.isNotBlank(shi)){
			for(AreaZG t:areas){
				if(t.getAreaID()==Integer.parseInt(sheng)){
					areas=t.getChildren();
					break;
				}
			}
			for(AreaZG t:areas){
				if(t.getAreaID()==Integer.parseInt(shi)){
					areas=t.getChildren();
					break;
				}
			}
		}else{
			areas=new ArrayList<AreaZG>();
		}
		for (AreaZG areaZG : areas) {
			JSONObject jo = new JSONObject();
			jo.put("value", areaZG.getAreaID());
			jo.put("text", areaZG.getAreaName());
			arr.add(jo);
		}
		}
		j.setObj(arr);
		j.setSuccess(true);
		return j;
	}

}
