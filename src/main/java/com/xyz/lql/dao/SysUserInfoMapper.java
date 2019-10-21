package com.xyz.lql.dao;

import com.xyz.lql.entity.SysUserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.xyz.lql.dto.rep.userManager.MenuInfo;

import java.util.List;

/**
 * @author lql
 * @Description: TODO
 * @date 2019-4-17 12:55
 */
@Mapper
public interface SysUserInfoMapper extends BaseDao<SysUserInfo, String> {
	// 用户登录，获取用户信息
	SysUserInfo getUserInfoByLoginName(@Param("loginName") String loginName);

	// 获取以及菜单列表
	List<MenuInfo> getMainMenuListByRoleId(@Param("roleId") String roleId);

	// 获取二级菜单列表
	List<MenuInfo> getChildMenuList(@Param("roleId") String roleId, @Param("menuId") String menuId);

	Integer getSameMenuUrl(@Param("url") String url);

}
