package com.wxb.tools;

import java.util.List;
import java.util.Set;

public class AreaZG {
	private Integer AreaID;
	private String AreaName;
	private List<AreaZG> children;

	public Integer getAreaID() {
		return AreaID;
	}

	public void setAreaID(Integer areaID) {
		AreaID = areaID;
	}

	public String getAreaName() {
		return AreaName;
	}

	public void setAreaName(String areaName) {
		AreaName = areaName;
	}


	public List<AreaZG> getChildren() {
		return children;
	}

	public void setChildren(List<AreaZG> children) {
		this.children = children;
	}

	@Override
	public int hashCode() {
		// TODO 自动生成的方法存根
		return this.AreaID.hashCode();
	}
}
