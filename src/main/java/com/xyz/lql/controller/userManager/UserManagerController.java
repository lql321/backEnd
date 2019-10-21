package com.xyz.lql.controller.userManager;

import com.xyz.lql.dto.rep.Response;
import com.xyz.lql.dto.rep.userManager.MenuInfo;
import com.xyz.lql.dto.rep.userManager.RepUserLogin;
import com.xyz.lql.dto.req.userManager.ReqMenuInfo;
import com.xyz.lql.dto.req.userManager.ReqUserLogin;
import com.xyz.lql.entity.SysUserInfo;
import com.xyz.lql.service.IUserManager.IUserManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lql
 * @Description: TODO
 * @date 2019-4-17 14:11
 */
@RestController
@RequestMapping("userManager")
public class UserManagerController {
	private final static Logger logger = LoggerFactory.getLogger(UserManagerController.class);

	@Autowired
	IUserManagerService userManagerService;
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Response userLogin(@RequestBody ReqUserLogin userLogin) {
		SysUserInfo userInfo = userManagerService.userLogin(userLogin);
		RepUserLogin repUserLogin = userManagerService.getMenuList(userInfo.getRoleId());
		repUserLogin.setUserInfo(userInfo);
		Response response = new Response(repUserLogin);
		return response;
	}
	@RequestMapping(value = "/getMenuList", method = RequestMethod.GET)
	public Response getMenuList() {
		List<MenuInfo> menuList = userManagerService.getMenuList();
		Response response = new Response(menuList);
		return response;
	}
	/**
	 *
	 */
	@RequestMapping(value = "/addMenu", method = RequestMethod.POST)
	public Response getMenuList(@RequestBody ReqMenuInfo menuInfo) {
		Integer result = userManagerService.addMenu(menuInfo);
		if(result == 1){
			return new Response("新增成功");
		} else {
			return new Response("新增失败");
		}
	}
}
