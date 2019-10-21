delete from t_sys_user_info;
delete from t_sys_menu;
delete from t_sys_role;
delete from t_sys_role_menu;

/*
	初始化用户
*/
insert into t_sys_user_info (id, name, login_name, password, role_id, create_time, create_by, update_time, update_by) values
 			 				 ('0','超级管理员','admin','admin','0','2019-01-01','0','2019-01-01','0');

/*
	初始化菜单
*/
insert into t_sys_menu (id, parent_id, name, url, icon, create_time, create_by, update_time, update_by, rank, is_leaf, seq) values
						('1','','用户管理','','el-icon-info','2019-10-10','0','2019-10-10','0','0',0,1);
insert into t_sys_menu (id, parent_id, name, url, icon, create_time, create_by, update_time, update_by, rank, is_leaf, seq) values
						('2','1','菜单管理','menulist',null,'2019-10-10','0','2019-10-10','0','0',1,1);
insert into t_sys_menu (id, parent_id, name, url, icon, create_time, create_by, update_time, update_by, rank, is_leaf, seq) values
						('3','1','用户列表','userlist',null,'2019-10-10','0','2019-10-10','0','0',1,2);
/*
	初始化叫角色
*/
insert into t_sys_role(id, name, create_time, create_by, update_time, update_by) values ('0','超级管理员','2019-10-10','0','2019-10-10','0');

/*
	初始化权限
*/
insert into t_sys_role_menu(id, role_id, menu_id, create_time, create_by, update_time, update_by) values ('0','0','1',null ,null ,null ,null);
insert into t_sys_role_menu(id, role_id, menu_id, create_time, create_by, update_time, update_by) values ('1','0','2',null ,null ,null ,null);
insert into t_sys_role_menu(id, role_id, menu_id, create_time, create_by, update_time, update_by) values ('2','0','3',null ,null ,null ,null);