package com.xyz.lql.dto.rep.userManager;

import com.xyz.lql.dto.rep.Response;
import com.xyz.lql.entity.SysUserInfo;
import lombok.Data;

import java.util.List;

/**
 * @author lql
 * @Description: TODO
 * @date 2019-4-17 14:21
 */
@Data
public class RepUserLogin {
	private SysUserInfo userInfo;
	private List<MenuInfo> menuInfoList;
}

