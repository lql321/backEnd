package com.xyz.lql.service.IUserManager.Impl;

import com.xyz.lql.dao.SysMenuMapper;
import com.xyz.lql.dao.SysUserInfoMapper;
import com.xyz.lql.dto.rep.userManager.MenuInfo;
import com.xyz.lql.dto.rep.userManager.RepUserLogin;
import com.xyz.lql.dto.req.userManager.ReqMenuInfo;
import com.xyz.lql.dto.req.userManager.ReqUserLogin;
import com.xyz.lql.entity.SysMenu;
import com.xyz.lql.entity.SysUserInfo;
import com.xyz.lql.exception.AppException;
import com.xyz.lql.service.IUserManager.IUserManagerService;
import com.xyz.lql.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author lql
 * @Description: TODO
 * @date 2019-4-17 15:14
 */
@Service
public class UserManagerService implements IUserManagerService {
	@Autowired
	SysUserInfoMapper sysUserMapper;
	@Autowired
	SysMenuMapper sysMenuMapper;

	@Override
	public SysUserInfo userLogin(ReqUserLogin userLogin) {
		String userName = userLogin.getUserName();
		String password = userLogin.getPassword();
		SysUserInfo userInfo = sysUserMapper.getUserInfoByLoginName(userName);
		if (userInfo == null) {
			throw new AppException(-1, "账号不存在");
		}
		if (!userInfo.getPassword().equals(password)) {
			throw new AppException(-1, "账号或密码不正确");
		}
		return userInfo;
	}

	/**
	 * 获取菜单权限
	 *
	 * @param roleId
	 */
	@Override
	public RepUserLogin getMenuList(String roleId) {
		RepUserLogin loginInfo = new RepUserLogin();
		// 获取一级菜单
		List<MenuInfo> mainMenuList = sysUserMapper.getMainMenuListByRoleId(roleId);
		List<MenuInfo> repMenuList = new ArrayList<>();
		// 循环一级菜单获取二级菜单
		for (MenuInfo value : mainMenuList) {
			List<MenuInfo> childMenuList = sysUserMapper.getChildMenuList(roleId, value.getId());
			MenuInfo menuInfo = new MenuInfo();
			menuInfo.setId(value.getId());
			menuInfo.setName(value.getName());
			menuInfo.setIcon(value.getIcon());
			menuInfo.setChildMenuList(childMenuList);
			repMenuList.add(menuInfo);
		}
		loginInfo.setMenuInfoList(repMenuList);
		return loginInfo;
	}

	@Override
	public List<MenuInfo> getMenuList() {
		List<SysMenu> menuList = sysMenuMapper.getMenuList();
		return this.assemblyMenuTree(menuList);
	}

	@Override
	public Integer addMenu(ReqMenuInfo reqMenuInfo) {
		// 判断是否存相同Url
		Integer urlNum = sysUserMapper.getSameMenuUrl(reqMenuInfo.getUrl());
		if (urlNum > 0) {
			throw new AppException(-1, "存在相同的路径");
		}
		// 插入menu
		reqMenuInfo.setId(StringUtils.getUUID());
		reqMenuInfo.setCreateTime(new Date());
		reqMenuInfo.setUpdateTime(new Date());
		return sysMenuMapper.insertSelective(reqMenuInfo);
	}

	/**
	 * 组装菜单树
	 *
	 * @param list
	 * @return
	 */
	private List<MenuInfo> assemblyMenuTree(List<SysMenu> list) {
		List<MenuInfo> menuList = new ArrayList<>();
		for (SysMenu firstMenu : list) {
			MenuInfo menuInfo = new MenuInfo();
			menuInfo.setId(firstMenu.getId());
			menuInfo.setName(firstMenu.getName());
			menuInfo.setIcon(firstMenu.getIcon());
			menuInfo.setUrl(firstMenu.getUrl());
			List<MenuInfo> childList = new ArrayList<>();
			if (firstMenu.getIsLeaf() == "0") {
				// 是根节点，则找响应的子节点
				for (SysMenu secondMenu : list) {
					// 查找子菜单
					if (firstMenu.getId().equals(secondMenu.getParentId())) {
						MenuInfo childMenuInfo = new MenuInfo();
						childMenuInfo.setId(secondMenu.getId());
						childMenuInfo.setName(secondMenu.getName());
						childMenuInfo.setIcon(secondMenu.getIcon());
						childMenuInfo.setParentId(secondMenu.getParentId());
						childMenuInfo.setUrl(secondMenu.getUrl());
						childList.add(childMenuInfo);
					}
				}
				menuInfo.setChildMenuList(childList);
				menuList.add(menuInfo);
			}
		}
		return menuList;
	}


}
