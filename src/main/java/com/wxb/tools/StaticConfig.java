package com.wxb.tools;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.IOUtils;

import com.alibaba.fastjson.JSONArray;

public class StaticConfig {
	private static List<AreaZG> AREAZG = null;

	public static List<AreaZG> getAreas() {
		if (AREAZG != null) {
			return AREAZG;
		}
		try {
			InputStream is = StaticConfig.class.getResourceAsStream(
					"/area.json");
			String json = IOUtils.toString(is, "utf-8");
			List<AreaZG> list = JSONArray.parseArray(json, AreaZG.class);
			AREAZG =  list;
			
			return AREAZG;
		} catch (Exception ex) {
ex.printStackTrace();
		}
		return null;
	}

}
