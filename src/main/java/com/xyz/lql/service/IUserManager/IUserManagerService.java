package com.xyz.lql.service.IUserManager;

import com.xyz.lql.dto.rep.userManager.MenuInfo;
import com.xyz.lql.dto.rep.userManager.RepUserLogin;
import com.xyz.lql.dto.req.userManager.ReqMenuInfo;
import com.xyz.lql.dto.req.userManager.ReqUserLogin;
import com.xyz.lql.entity.SysUserInfo;

import java.util.List;

/**
 * @author lql
 * @Description: TODO
 * @date 2019-4-17 15:12
 */
public interface IUserManagerService {
	SysUserInfo userLogin(ReqUserLogin userLogin);

	RepUserLogin getMenuList(String roleId);

	List<MenuInfo> getMenuList();

	Integer addMenu(ReqMenuInfo reqMenuInfo);
}
