package sy.annt;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import sy.enums.ExtType;

public class ExtBean2JsUtils {

	static Logger logger = Logger.getLogger(ExtBean2JsUtils.class);

	public static String getFileType(ExtType t) {

		return "{\r\n" + "										xtype : '" + t.toString() + "',\r\n"
				+ "										name : '${name}',\r\n"
				+ "										label : '${label}',\r\n"
				+ "										placeHolder : '${place}',\r\n"
				+ "										  ${regx}\r\n"
				+ "										required : ${required},\r\n"
				+ "										clearIcon : true\r\n" + "									${other}}";

	}

	public static String getBeansExtJson(Class cls, int group) {
		StringBuilder sb = new StringBuilder();
		Field[] fields = cls.getDeclaredFields();
		List<ExtField<String, Ext>> lexts = new ArrayList<ExtField<String, Ext>>();

		for (Field field : fields) {

			Ext ext = field.getAnnotation(Ext.class);

			if (ext == null) {
				continue;
			}

			int[] group2 = ext.group();
			for (int i : group2) {
				if (i == group) {
					System.out.println(ext);
					ExtField t = new ExtField<String, Ext>(field.getName(), ext);
					lexts.add(t);
				}
			}
		}
		Collections.sort(lexts, new Comparator<ExtField<String, Ext>>() {// 排序
					public int compare(ExtField<String, Ext> arg0,
							ExtField<String, Ext> arg1) {

						
						if(arg0.getValue().index() > arg1.getValue().index()){
							return 1;
							
						}else if(arg0.getValue().index() > arg1.getValue().index()){
							return -1;
						}else {
							return 0;
						}
						// return arg0.index()>arg1.index();
					}
				});
		for (ExtField<String, Ext> tmp : lexts) {
			Ext ext = tmp.getValue();
			String moban = ext.type().getMoban();
			Map<String, String> data = new HashMap<String, String>();

			data.put("label", ext.label());
			data.put("name", ext.qianzhui() + tmp.getKey());
			if (false == ext.json().equals("")) {

				if (!ext.type().equals(ExtType.checkboxgroup)) {
					data.put("store", cls.getSimpleName() + "_" + tmp.getKey());
					
				}else{
					String json = ext.json();
					if (json.startsWith("json:")) {
						json = json.substring(5);
						json = json.replaceAll("'", "\"");
						JSONArray arr = JSONArray.parseArray(json);
						StringBuilder sb_json = new StringBuilder();
						for (int i = 0; i < arr.size(); i++) {
							JSONObject object = arr.getJSONObject(i);

							String m = "";
							
								m = "{\r\n" + "										value : '"
										+ object.getString("value") + "',\r\n"
										+ "										label : '"
										+ object.getString("text") + "'\r\n"
										+ "									},";

							
							sb_json.append(m);
						}
						String string = sb_json.toString();
						string = string.substring(0, string.length() - 1);

						data.put("json", string);

					}
				}

			}

			data.put("required", String.valueOf(ext.required()));
			data.put("place", ext.place());
			if (true == ext.regx().equals("")) {
				data.put("regx", "");

			} else {
				data.put("regx", "matcher: " + ext.regx() + ",");
			}
			data.put("minValue", String.valueOf(ext.minValue()));
			data.put("maxValue", String.valueOf(ext.maxValue()));
			data.put("stepValue", String.valueOf(ext.stepValue()));
			data.put("other", "");

			try {
				moban = composeMessage(moban, data);
			} catch (Exception e) {
			}
			sb.append(moban);
			sb.append(",\n");
		}
		if (sb.toString().endsWith(",")) {
			sb.deleteCharAt(sb.length());
		}

		String string = sb.toString();
		string = string.substring(0, string.length() - 1);
		// logger.info(string);
		return string;

	}

	public static String getBeansExtJson(Class cls, String... fnames)
			throws NoSuchFieldException, SecurityException {
		StringBuilder sb = new StringBuilder();
		// Field[] fields = cls.getDeclaredFields();
		List<ExtField<String, Ext>> lexts = new ArrayList<ExtField<String, Ext>>();

		for (String ftmp : fnames) {

			Field field = cls.getDeclaredField(ftmp);

			Ext ext = field.getAnnotation(Ext.class);

			if (ext == null) {
				continue;
			}

			System.out.println(ext);
			ExtField t = new ExtField<String, Ext>(field.getName(), ext);
			lexts.add(t);

		}
		// Collections.sort(lexts, new Comparator<ExtField<String,Ext>>() {//排序
		// public int compare(ExtField<String,Ext> arg0, ExtField<String,Ext>
		// arg1) {
		//
		// return Integer.compare(arg0.getValue().index(),
		// arg1.getValue().index());
		// // return arg0.index()>arg1.index();
		// }
		// });
		for (ExtField<String, Ext> tmp : lexts) {
			Ext ext = tmp.getValue();
			String moban = ext.type().getMoban();
			Map<String, String> data = new HashMap<String, String>();
			data.put("label", ext.label());
			data.put("name", ext.qianzhui() + tmp.getKey());
			if (false == ext.json().equals("")) {
				if (!ext.type().equals(ExtType.checkboxgroup)) {
					data.put("store", cls.getSimpleName() + "_" + tmp.getKey());
					
				}else{
					String json = ext.json();
					if (json.startsWith("json:")) {
						json = json.substring(5);
						json = json.replaceAll("'", "\"");
						JSONArray arr = JSONArray.parseArray(json);
						StringBuilder sb_json = new StringBuilder();
						for (int i = 0; i < arr.size(); i++) {
							JSONObject object = arr.getJSONObject(i);

							String m = "";
							
								m = "{\r\n" + "										value : '"
										+ object.getString("value") + "',\r\n"
										+ "										label : '"
										+ object.getString("text") + "'\r\n"
										+ "									},";

							
							sb_json.append(m);
						}
						String string = sb_json.toString();
						string = string.substring(0, string.length() - 1);

						data.put("json", string);

					}
				}

			}

			data.put("required", String.valueOf(ext.required()));
			data.put("place", ext.place());
			if (true == ext.regx().equals("")) {
				data.put("regx", "");

			} else {
				data.put("regx", "matcher: " + ext.regx() + ",");
			}
			data.put("minValue", String.valueOf(ext.minValue()));
			data.put("maxValue", String.valueOf(ext.maxValue()));
			data.put("stepValue", String.valueOf(ext.stepValue()));
			data.put("other", "");

			try {
				moban = composeMessage(moban, data);
			} catch (Exception e) {
			}
			sb.append(moban);
			sb.append(",\n");
		}
		if (sb.toString().endsWith(",")) {
			sb.deleteCharAt(sb.length());
		}

		String string = sb.toString();
		string = string.substring(0, string.length() - 1);
		// logger.info(string);
		return string;

	}

	public static String composeMessage(String template, Map data)
			throws Exception {
		String regex = "\\$\\{(.+?)\\}";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(template);
		/*
		 * sb用来存储替换过的内容，它会把多次处理过的字符串按源字符串序 存储起来。
		 */
		StringBuffer sb = new StringBuffer();
		while (matcher.find()) {
			String name = matcher.group(1);// 键名
			String value = (String) data.get(name);// 键值
			if (value == null) {
				value = "";
			} else {
				/*
				 * 由于$出现在replacement中时，表示对捕获组的反向引用，所以要对上面替换内容 中的 $ 进行替换，让它们变成
				 * "\$1000.00" 或 "\$1000000000.00" ，这样 在下面使用
				 * matcher.appendReplacement(sb, value) 进行替换时就不会把 $1
				 * 看成是对组的反向引用了，否则会使用子匹配项值amount 或 balance替换 $1 ，最后会得到错误结果：
				 * 
				 * 尊敬的客户刘明你好！本次消费金额amount000.00，您帐户888888888上的余额
				 * 为balance000000.00，欢迎下次光临！
				 * 
				 * 要把 $ 替换成 \$ ，则要使用 \\\\\\& 来替换，因为一个 \ 要使用 \\\ 来进 行替换，而一个 $ 要使用
				 * \\$ 来进行替换，因 \ 与 $ 在作为替换内容时都属于 特殊字符：$ 字符表示反向引用组，而 \ 字符又是用来转义 $
				 * 字符的。
				 */
				value = value.replaceAll("\\$", "\\\\\\$");
				// System.out.println("value=" + value);
			}
			/*
			 * 经过上面的替换操作，现在的 value 中含有 $ 特殊字符的内容被换成了"\$1000.00" 或
			 * "\$1000000000.00" 了，最后得到下正确的结果：
			 * 
			 * 尊敬的客户刘明你好！本次消费金额$1000.00，您帐户888888888上的 余额为$1000000.00，欢迎下次光临！
			 * 
			 * 另外，我们在这里使用Matcher对象的appendReplacement()方法来进行替换操作，而
			 * 不是使用String对象的replaceAll()或replaceFirst()方法来进行替换操作，因为
			 * 它们都能只能进行一次性简单的替换操作，而且只能替换成一样的内容，而这里则是要求每
			 * 一个匹配式的替换值都不同，所以就只能在循环里使用appendReplacement方式来进行逐 个替换了。
			 */
			matcher.appendReplacement(sb, value);
			// System.out.println("sb = " + sb.toString());
		}
		// 最后还得要把尾串接到已替换的内容后面去，这里尾串为“，欢迎下次光临！”
		matcher.appendTail(sb);
		return sb.toString();
	}

}
