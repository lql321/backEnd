package com.xyz.lql.dto.rep.userManager;

import java.util.List;

/**
 * @author lql
 * @Description: TODO
 * @date 2019-4-18 15:02
 */
public class MenuInfo {
	private String id;
	private String name;
	private String url;
	private String icon;
	private String parentId;

	private List<MenuInfo> childMenuList;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<MenuInfo> getChildMenuList() {
		return childMenuList;
	}

	public void setChildMenuList(List<MenuInfo> childMenuList) {
		this.childMenuList = childMenuList;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

}
