package com.xyz.lql.dao;

import com.xyz.lql.dto.rep.userManager.MenuInfo;
import com.xyz.lql.entity.SysMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author lql
 * @Description: TODO
 * @date 2019-4-17 12:55
 */
@Mapper
public interface SysMenuMapper extends BaseDao<SysMenu, String> {

	List<SysMenu> getMenuList();
}
