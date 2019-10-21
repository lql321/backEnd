/*
	包括初始化用户、菜单、权限、角色
*/
DROP TABLE IF EXISTS t_sys_user_info;                           		/* 系统用户表*/
DROP TABLE IF EXISTS t_sys_menu;                           			/* 后台菜单表 */
DROP TABLE IF EXISTS t_sys_role;										/* 系统角色表*/
DROP TABLE IF EXISTS t_sys_role_menu;									/* 系统角色菜单关联表*/


CREATE TABLE t_sys_user_info (
  	id             		varchar(36)            	NOT NULL DEFAULT ''       	COMMENT '物理主键--统一外键名uid',
  	name           		varchar(100)           	DEFAULT NULL               COMMENT '用户姓名',
  	login_name         varchar(100)           	DEFAULT NULL               COMMENT '用户姓名',
  	password         	varchar(100)           	DEFAULT NULL               COMMENT '登录密码',
  	role_id         	varchar(36)           	DEFAULT NULL               COMMENT '角色id',
  	create_time    	datetime               	DEFAULT NULL               COMMENT '创建时间',
  	create_by      	varchar(36)            DEFAULT NULL               COMMENT '创建人--关联uid',
  	update_time    	datetime               	DEFAULT NULL               COMMENT '更新时间',
  	update_by      	varchar(36)           	DEFAULT NULL               COMMENT '更新人',
  	PRIMARY KEY (id), UNIQUE KEY PK_user_info(id) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='系统后台管理人员用户表';

CREATE TABLE t_sys_menu (
  	id             		varchar(36)            	NOT NULL DEFAULT ''       	COMMENT '物理主键--统一外键名menu_id',
  	parent_id      	varchar(36)            DEFAULT NULL               COMMENT '父级菜单',
  	name           		varchar(100)           	DEFAULT NULL               COMMENT '菜单名称',
  	url            		varchar(100)           	DEFAULT NULL               COMMENT 'url地址',
  	icon				varchar(100)			DEFAULT null 				COMMENT '图标，采用elementUI里面的图标'
  	create_time    		datetime               	DEFAULT NULL               COMMENT '创建时间',
  	create_by      	varchar(36)            DEFAULT NULL               COMMENT '创建人',
  	update_time    	datetime               	DEFAULT NULL               COMMENT '更新时间',
  	update_by      	varchar(36)           	DEFAULT NULL               COMMENT '更新人',
  	rank           		varchar(2)             DEFAULT NULL               COMMENT '节点层级',
  	is_leaf        		varchar(2)             DEFAULT NULL               COMMENT '是否叶子节点（0 否，1是）',
  	seq            		int(11)                	DEFAULT NULL               COMMENT '顺序',
  	PRIMARY KEY (id), UNIQUE KEY PK_sys_menu(id) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='后台菜单表';

CREATE TABLE t_sys_role (
  	id             		varchar(36)            	NOT NULL DEFAULT ''       	COMMENT '物理主键--统一外键名role_id',
  	name           		varchar(100)           	DEFAULT NULL               COMMENT '角色名字',
  	create_time    	datetime               	DEFAULT NULL               COMMENT '创建时间',
  	create_by      	varchar(36)            DEFAULT NULL               COMMENT '创建人--关联uid',
  	update_time    	datetime               	DEFAULT NULL               COMMENT '更新时间',
  	update_by      	varchar(36)           	DEFAULT NULL               COMMENT '更新人',
  	PRIMARY KEY (id), UNIQUE KEY PK_sys_role(id) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='系统角色表';

CREATE TABLE t_sys_role_menu (
  	id             		varchar(36)            	NOT NULL DEFAULT ''       	COMMENT '物理主键--统一外键名role_menu_id',
  	role_id           	varchar(36)           	DEFAULT NULL               COMMENT '角色id,关联t_sys_role',
  	menu_id           	varchar(36)           	DEFAULT NULL               COMMENT '角色id,关联t_sys_menu',
  	create_time    	datetime               	DEFAULT NULL               COMMENT '创建时间',
  	create_by      	varchar(36)            DEFAULT NULL               COMMENT '创建人--关联uid',
  	update_time    	datetime               	DEFAULT NULL               COMMENT '更新时间',
  	update_by      	varchar(36)           	DEFAULT NULL               COMMENT '更新人',
  	PRIMARY KEY (id), UNIQUE KEY PK_role_menu(id) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='角色菜单关联表';

