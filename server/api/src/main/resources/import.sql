
-- ----------------------------
-- Records of t_cms_dish
-- ----------------------------
INSERT INTO `t_cms_dish` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `content`, `id_channel`,`img`, `inventory`, `price`, `title`)VALUES ('1', '1', '2019-03-09 16:24:58', '1', '2019-05-10 13:22:49', '赠送咪咕音乐白金会员月卡', '1', '1','10','39','翅桶');
INSERT INTO `t_cms_dish` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `content`, `id_channel`,`img`, `inventory`, `price`, `title`)VALUES ('2', '1', '2019-03-09 16:24:58', '1', '2019-05-10 13:22:49', '赠送咪咕音乐白金会员月卡', '1', '1','19','78','双堡翅尖桶');
INSERT INTO `t_cms_dish` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `content`, `id_channel`,`img`, `inventory`, `price`, `title`)VALUES ('3', '1', '2019-03-09 16:24:58', '1', '2019-05-10 13:22:49', '鸡心4串+鸡肫2串+牛肚1串+木耳2串+油豆腐2串+黄喉1串 主要原料：鸡心，鸡肫，牛肚，黄喉，木耳，油豆腐，红油，红汤底酱', '2', '2','99','59','川香燃辣撸串桶');
INSERT INTO `t_cms_dish` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `content`, `id_channel`,`img`, `inventory`, `price`, `title`)VALUES ('4', '1', '2019-03-09 16:24:58', '1', '2019-05-10 13:22:49', '香卤手撕鸡1份+香卤鸡翅尖1份+香卤鸡心1份+香卤鸡肫1份+香辣鸡翅2块+新奥尔良烤翅2块', '2', '3','25','69','香卤系列辣翅烤翅');
INSERT INTO `t_cms_dish` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `content`, `id_channel`,`img`, `inventory`, `price`, `title`)VALUES ('5', '1', '2019-03-09 16:24:58', '1', '2019-05-10 13:22:49', '香辣鸡翅4块+吮指原味鸡3块+葡式蛋挞（经典）2个+红豆派2个+九珍果汁饮料4杯（可加价换购）', '3', '4','33','51','4人下午茶欢享桶');
INSERT INTO `t_cms_dish` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `content`, `id_channel`,`img`, `inventory`, `price`, `title`)VALUES ('6', '1', '2019-03-09 16:24:58', '1', '2019-05-10 13:22:49', '热辣香骨鸡3块+新奥尔良烤翅4块+黄金鸡块5块+劲爆鸡米花（小）1份+葡式蛋挞（经典）1个+红豆派2个+九珍果汁饮料3杯（可加价换购）', '3', '5','55','53','3人下午茶欢享桶');
INSERT INTO `t_cms_dish` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `content`, `id_channel`,`img`, `inventory`, `price`, `title`)VALUES ('7', '1', '2019-03-09 16:24:58', '1', '2019-05-10 13:22:49', '华夫3份（可选）', '3', '6','22','27','下午茶华夫礼盒');
INSERT INTO `t_cms_dish` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `content`, `id_channel`,`img`, `inventory`, `price`, `title`)VALUES ('8', '1', '2019-03-09 16:24:58', '1', '2019-05-10 13:22:49', '香辣鸡腿堡2个+新奥尔良烤鸡腿堡1个+吮指原味鸡3块+香辣鸡翅2块+新奥尔良烤翅4块+醇香土豆泥2份+红豆派2只+1.25升百事可乐1瓶', '4', '7','5','123','超级外送全家桶S');

-- ----------------------------
-- Records of t_cms_banner
-- ----------------------------
INSERT INTO `t_cms_banner` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `title`, `url`, `type`, `id_file`) VALUES ('1', '1', '2019-03-09 16:29:03', null, null, '不打开链接', 'javascript:', 'index', '1');
INSERT INTO `t_cms_banner` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `title`, `url`, `type`, `id_file`) VALUES ('2', '1', '2019-03-09 16:29:03', null, null, '打打开站内链接', '/contact', 'index', '2');


-- ----------------------------
-- Records of t_cms_channel
-- ----------------------------
INSERT INTO `t_cms_channel` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `name`, `code`) VALUES ('1', null, null, '1', '2019-03-13 22:52:46', '人气热卖', 'popular');
INSERT INTO `t_cms_channel` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `name`, `code`) VALUES ('2', null, null, '1', '2019-03-13 22:53:11', '新品上市', 'new');
INSERT INTO `t_cms_channel` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `name`, `code`) VALUES ('3', null, null, '1', '2019-03-13 22:53:37', '欢乐送下午茶', 'afternoon');
INSERT INTO `t_cms_channel` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `name`, `code`) VALUES ('4', null, null, '1', '2019-03-13 22:53:41', '当季主打', 'seasonal');

-- ----------------------------
-- Records of t_cms_order
-- ----------------------------
INSERT INTO `t_cms_order` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `content`, `mobile`, `remark`, `status`, `userid`) VALUES(1, NULL, '2019-03-11 22:30:17', NULL, NULL, '{\"list\":[{\"id\":1,\"name\":\"翅桶\",\"amount\":1,\"price\":39},{\"id\":2,\"name\":\"双堡翅尖桶\",\"amount\":2,\"price\":156},{\"id\":3,\"name\":\"川香燃辣撸串桶\",\"amount\":3,\"price\":177}]}', '15706589233', '不要辣', '备货中', '3');
-- ----------------------------
-- Records of t_snow_product
-- ----------------------------

-- ----------------------------
-- Records of t_sys_cfg
-- ----------------------------
INSERT INTO `t_sys_cfg` VALUES ('1', null, null, '1', '2019-04-15 21:36:07', '应用名称update by 2019-03-27 11:47:04', 'system.app.name', 'web-flash');
INSERT INTO `t_sys_cfg` VALUES ('2', null, null, '1', '2019-04-15 21:36:17', '系统默认上传文件路径', 'system.file.upload.path', 'runtime/upload');
INSERT INTO `t_sys_cfg` VALUES ('3', null, null, '1', '2019-04-15 21:36:17', '腾讯sms接口appid', 'api.tencent.sms.appid', '1400219425');
INSERT INTO `t_sys_cfg` VALUES ('4', null, null, '1', '2019-04-15 21:36:17', '腾讯sms接口appkey', 'api.tencent.sms.appkey', '5f71ed5325f3b292946530a1773e997a');
INSERT INTO `t_sys_cfg` VALUES ('5', null, null, '1', '2019-04-15 21:36:17', '腾讯sms接口签名参数', 'api.tencent.sms.sign', '需要去申请咯');

-- ----------------------------
-- Records of t_sys_dept
-- ----------------------------
INSERT INTO `t_sys_dept` (`id`, `num`, `pid`, `pids`, `simplename`, `fullname`, `tips`, `version`, `create_time`, `create_by`, `modify_time`, `modify_by`) VALUES ('1', '1', '0', '[0],', '海甸岛店', '海甸岛店', '', null, null, null, null, null);
INSERT INTO `t_sys_dept` (`id`, `num`, `pid`, `pids`, `simplename`, `fullname`, `tips`, `version`, `create_time`, `create_by`, `modify_time`, `modify_by`) VALUES ('2', '2', '1', '[0],[24],', '开发部', '开发部', '', null, null, null, null, null);
INSERT INTO `t_sys_dept` (`id`, `num`, `pid`, `pids`, `simplename`, `fullname`, `tips`, `version`, `create_time`, `create_by`, `modify_time`, `modify_by`) VALUES ('3', '3', '1', '[0],[24],', '运营部', '运营部', '', null, null, null, null, null);
INSERT INTO `t_sys_dept` (`id`, `num`, `pid`, `pids`, `simplename`, `fullname`, `tips`, `version`, `create_time`, `create_by`, `modify_time`, `modify_by`) VALUES ('4', '4', '1', '[0],[24],', '战略部', '战略部', '', null, null, null, null, null);
INSERT INTO `t_sys_dept` (`id`, `num`, `pid`, `pids`, `simplename`, `fullname`, `tips`, `version`, `create_time`, `create_by`, `modify_time`, `modify_by`) VALUES ('5', '5', '3', '[0],[24],[3],', '用户', '用户', '', null, null, null, null, null);

-- ----------------------------
-- Records of t_sys_dict
-- ----------------------------
INSERT INTO `t_sys_dict` (`id`, `num`, `pid`, `name`, `tips`, `create_time`, `create_by`, `modify_time`, `modify_by`) VALUES ('16', '0', '0', '状态', null, null, null, null, null);
INSERT INTO `t_sys_dict` (`id`, `num`, `pid`, `name`, `tips`, `create_time`, `create_by`, `modify_time`, `modify_by`) VALUES ('17', '1', '16', '启用', null, null, null, null, null);
INSERT INTO `t_sys_dict` (`id`, `num`, `pid`, `name`, `tips`, `create_time`, `create_by`, `modify_time`, `modify_by`) VALUES ('18', '2', '16', '禁用', null, null, null, null, null);
INSERT INTO `t_sys_dict` (`id`, `num`, `pid`, `name`, `tips`, `create_time`, `create_by`, `modify_time`, `modify_by`) VALUES ('29', '0', '0', '性别', null, null, null, null, null);
INSERT INTO `t_sys_dict` (`id`, `num`, `pid`, `name`, `tips`, `create_time`, `create_by`, `modify_time`, `modify_by`) VALUES ('30', '1', '29', '男', null, null, null, null, null);
INSERT INTO `t_sys_dict` (`id`, `num`, `pid`, `name`, `tips`, `create_time`, `create_by`, `modify_time`, `modify_by`) VALUES ('31', '2', '29', '女', null, null, null, null, null);
INSERT INTO `t_sys_dict` (`id`, `num`, `pid`, `name`, `tips`, `create_time`, `create_by`, `modify_time`, `modify_by`) VALUES ('35', '0', '0', '账号状态', null, null, null, null, null);
INSERT INTO `t_sys_dict` (`id`, `num`, `pid`, `name`, `tips`, `create_time`, `create_by`, `modify_time`, `modify_by`) VALUES ('36', '1', '35', '启用', null, null, null, null, null);
INSERT INTO `t_sys_dict` (`id`, `num`, `pid`, `name`, `tips`, `create_time`, `create_by`, `modify_time`, `modify_by`) VALUES ('37', '2', '35', '冻结', null, null, null, null, null);
INSERT INTO `t_sys_dict` (`id`, `num`, `pid`, `name`, `tips`, `create_time`, `create_by`, `modify_time`, `modify_by`) VALUES ('38', '3', '35', '已删除', null, null, null, null, null);
INSERT INTO `t_sys_dict` (`id`, `num`, `pid`, `name`, `tips`, `create_time`, `create_by`, `modify_time`, `modify_by`) VALUES ('53', '0', '0', '证件类型', null, null, null, null, null);
INSERT INTO `t_sys_dict` (`id`, `num`, `pid`, `name`, `tips`, `create_time`, `create_by`, `modify_time`, `modify_by`) VALUES ('54', '1', '53', '身份证', null, null, null, null, null);
INSERT INTO `t_sys_dict` (`id`, `num`, `pid`, `name`, `tips`, `create_time`, `create_by`, `modify_time`, `modify_by`) VALUES ('55', '2', '53', '护照', null, null, null, null, null);
INSERT INTO `t_sys_dict` (`id`, `num`, `pid`, `name`, `tips`, `create_time`, `create_by`, `modify_time`, `modify_by`) VALUES ('68', '0', '0', '是否', null, '2019-01-13 14:18:21', '1', '2019-01-13 14:18:21', '1');
INSERT INTO `t_sys_dict` (`id`, `num`, `pid`, `name`, `tips`, `create_time`, `create_by`, `modify_time`, `modify_by`) VALUES ('69', '1', '68', '是', null, '2019-01-13 14:18:21', '1', '2019-01-13 14:18:21', '1');
INSERT INTO `t_sys_dict` (`id`, `num`, `pid`, `name`, `tips`, `create_time`, `create_by`, `modify_time`, `modify_by`) VALUES ('70', '0', '68', '否', null, '2019-01-13 14:18:21', '1', '2019-01-13 14:18:21', '1');

-- ----------------------------
-- Records of t_sys_file_info
-- ----------------------------
INSERT INTO `t_sys_file_info` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `original_file_name`, `real_file_name`) VALUES ('1', '1', '2019-03-18 10:34:34', '1', '2019-03-18 10:34:34', 'dish1.jpg', 'dish1.jpg');
INSERT INTO `t_sys_file_info` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `original_file_name`, `real_file_name`) VALUES ('2', '1', '2019-03-18 10:54:04', '1', '2019-03-18 10:54:04', 'dish2.jpg', 'dish2.jpg');
INSERT INTO `t_sys_file_info` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `original_file_name`, `real_file_name`) VALUES ('3', '1', '2019-03-18 20:09:59', '1', '2019-03-18 20:09:59', 'dish3.jpg', 'dish3.jpg');
INSERT INTO `t_sys_file_info` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `original_file_name`, `real_file_name`) VALUES ('4', '1', '2019-03-18 20:10:18', '1', '2019-03-18 20:10:18', 'dish4.jpg', 'dish4.jpg');
INSERT INTO `t_sys_file_info` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `original_file_name`, `real_file_name`) VALUES ('5', '1', '2019-03-18 20:20:14', '1', '2019-03-18 20:20:14', 'dish5.jpg', 'dish5.jpg');
INSERT INTO `t_sys_file_info` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `original_file_name`, `real_file_name`) VALUES ('6', '1', '2019-03-18 20:22:09', '1', '2019-03-18 20:22:09', 'dish6.jpg', 'dish6.jpg');
INSERT INTO `t_sys_file_info` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `original_file_name`, `real_file_name`) VALUES ('7', '1', '2019-03-20 09:05:54', '1', '2019-03-20 09:05:54', 'dish7.jpg', 'dish7.jpg');
INSERT INTO `t_sys_file_info` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `original_file_name`, `real_file_name`) VALUES ('8', '1', '2019-03-20 09:05:54', '1', '2019-03-20 09:05:54', 'dish8.jpg', 'dish8.jpg');

-- ----------------------------
-- Records of t_sys_login_log
-- ----------------------------
INSERT INTO `t_sys_login_log` (`id`, `logname`, `userid`, `create_time`, `succeed`, `message`, `ip`) VALUES ('71', '登录日志', '1', '2019-05-10 13:17:43', '成功', null, '127.0.0.1');
INSERT INTO `t_sys_login_log` (`id`, `logname`, `userid`, `create_time`, `succeed`, `message`, `ip`) VALUES ('72', '登录日志', '1', '2019-05-12 13:36:56', '成功', null, '127.0.0.1');

-- ----------------------------
-- Records of t_sys_menu
-- ----------------------------
INSERT INTO `t_sys_menu` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `code`, `component`, `hidden`, `icon`, `ismenu`, `isopen`, `levels`, `name`, `num`, `pcode`, `pcodes`, `status`, `tips`, `url`) VALUES (1, 1, '2019-7-31 22:04:30', 1, '2019-7-31 22:04:30', 'system', 'layout', 0, 'system', 1, 1, 1, '系统管理', 1, '0', '[0],', 1, NULL, '/system');
INSERT INTO `t_sys_menu` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `code`, `component`, `hidden`, `icon`, `ismenu`, `isopen`, `levels`, `name`, `num`, `pcode`, `pcodes`, `status`, `tips`, `url`) VALUES (2, 1, '2019-7-31 22:04:30', 1, '2019-3-11 22:25:38', 'cms', 'layout', 0, 'documentation', 1, NULL, 1, 'CMS管理', 3, '0', '[0],', 1, NULL, '/cms');
INSERT INTO `t_sys_menu` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `code`, `component`, `hidden`, `icon`, `ismenu`, `isopen`, `levels`, `name`, `num`, `pcode`, `pcodes`, `status`, `tips`, `url`) VALUES (3, 1, '2019-7-31 22:04:30', 1, '2019-6-2 10:09:09', 'operationMgr', 'layout', 0, 'operation', 1, NULL, 1, '运维管理', 2, '0', '[0],', 1, NULL, '/optionMgr');
INSERT INTO `t_sys_menu` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `code`, `component`, `hidden`, `icon`, `ismenu`, `isopen`, `levels`, `name`, `num`, `pcode`, `pcodes`, `status`, `tips`, `url`) VALUES (4, 1, '2019-7-31 22:04:30', 1, '2019-4-16 18:59:15', 'mgr', 'views/system/user/index', 0, 'user', 1, NULL, 2, '用户管理', 1, 'system', '[0],[system],', 1, NULL, '/mgr');
INSERT INTO `t_sys_menu` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `code`, `component`, `hidden`, `icon`, `ismenu`, `isopen`, `levels`, `name`, `num`, `pcode`, `pcodes`, `status`, `tips`, `url`) VALUES (5, 1, '2019-7-31 22:04:30', 1, '2019-7-31 22:04:30', 'mgrAdd', NULL, 0, NULL, 0, NULL, 3, '添加用户', 1, 'mgr', '[0],[system],[mgr],', 1, NULL, '/mgr/add');
INSERT INTO `t_sys_menu` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `code`, `component`, `hidden`, `icon`, `ismenu`, `isopen`, `levels`, `name`, `num`, `pcode`, `pcodes`, `status`, `tips`, `url`) VALUES (6, 1, '2019-7-31 22:04:30', 1, '2019-7-31 22:04:30', 'mgrEdit', NULL, 0, NULL, 0, NULL, 3, '修改用户', 2, 'mgr', '[0],[system],[mgr],', 1, NULL, '/mgr/edit');
INSERT INTO `t_sys_menu` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `code`, `component`, `hidden`, `icon`, `ismenu`, `isopen`, `levels`, `name`, `num`, `pcode`, `pcodes`, `status`, `tips`, `url`) VALUES (7, 1, '2019-7-31 22:04:30', 1, '2019-7-31 22:04:30', 'mgrDelete', NULL, 0, NULL, 0, 0, 3, '删除用户', 3, 'mgr', '[0],[system],[mgr],', 1, NULL, '/mgr/delete');
INSERT INTO `t_sys_menu` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `code`, `component`, `hidden`, `icon`, `ismenu`, `isopen`, `levels`, `name`, `num`, `pcode`, `pcodes`, `status`, `tips`, `url`) VALUES (8, 1, '2019-7-31 22:04:30', 1, '2019-7-31 22:04:30', 'mgrReset', NULL, 0, NULL, 0, 0, 3, '重置密码', 4, 'mgr', '[0],[system],[mgr],', 1, NULL, '/mgr/reset');
INSERT INTO `t_sys_menu` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `code`, `component`, `hidden`, `icon`, `ismenu`, `isopen`, `levels`, `name`, `num`, `pcode`, `pcodes`, `status`, `tips`, `url`) VALUES (9, 1, '2019-7-31 22:04:30', 1, '2019-7-31 22:04:30', 'mgrFreeze', NULL, 0, NULL, 0, 0, 3, '冻结用户', 5, 'mgr', '[0],[system],[mgr],', 1, NULL, '/mgr/freeze');
INSERT INTO `t_sys_menu` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `code`, `component`, `hidden`, `icon`, `ismenu`, `isopen`, `levels`, `name`, `num`, `pcode`, `pcodes`, `status`, `tips`, `url`) VALUES (10, 1, '2019-7-31 22:04:30', 1, '2019-7-31 22:04:30', 'mgrUnfreeze', NULL, 0, NULL, 0, 0, 3, '解除冻结用户', 6, 'mgr', '[0],[system],[mgr],', 1, NULL, '/mgr/unfreeze');
INSERT INTO `t_sys_menu` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `code`, `component`, `hidden`, `icon`, `ismenu`, `isopen`, `levels`, `name`, `num`, `pcode`, `pcodes`, `status`, `tips`, `url`) VALUES (11, 1, '2019-7-31 22:04:30', 1, '2019-7-31 22:04:30', 'mgrSetRole', NULL, 0, NULL, 0, 0, 3, '分配角色', 7, 'mgr', '[0],[system],[mgr],', 1, NULL, '/mgr/setRole');
INSERT INTO `t_sys_menu` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `code`, `component`, `hidden`, `icon`, `ismenu`, `isopen`, `levels`, `name`, `num`, `pcode`, `pcodes`, `status`, `tips`, `url`) VALUES (12, 1, '2019-7-31 22:04:30', 1, '2019-7-31 22:04:30', 'role', 'views/system/role/index', 0, 'peoples', 1, 0, 2, '角色管理', 2, 'system', '[0],[system],', 1, NULL, '/role');
INSERT INTO `t_sys_menu` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `code`, `component`, `hidden`, `icon`, `ismenu`, `isopen`, `levels`, `name`, `num`, `pcode`, `pcodes`, `status`, `tips`, `url`) VALUES (13, 1, '2019-7-31 22:04:30', 1, '2019-7-31 22:04:30', 'roleAdd', NULL, 0, NULL, 0, 0, 3, '添加角色', 1, 'role', '[0],[system],[role],', 1, NULL, '/role/add');
INSERT INTO `t_sys_menu` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `code`, `component`, `hidden`, `icon`, `ismenu`, `isopen`, `levels`, `name`, `num`, `pcode`, `pcodes`, `status`, `tips`, `url`) VALUES (14, 1, '2019-7-31 22:04:30', 1, '2019-7-31 22:04:30', 'roleEdit', NULL, 0, NULL, 0, 0, 3, '修改角色', 2, 'role', '[0],[system],[role],', 1, NULL, '/role/edit');
INSERT INTO `t_sys_menu` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `code`, `component`, `hidden`, `icon`, `ismenu`, `isopen`, `levels`, `name`, `num`, `pcode`, `pcodes`, `status`, `tips`, `url`) VALUES (15, 1, '2019-7-31 22:04:30', 1, '2019-7-31 22:04:30', 'roleDelete', NULL, 0, NULL, 0, 0, 3, '删除角色', 3, 'role', '[0],[system],[role],', 1, NULL, '/role/remove');
INSERT INTO `t_sys_menu` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `code`, `component`, `hidden`, `icon`, `ismenu`, `isopen`, `levels`, `name`, `num`, `pcode`, `pcodes`, `status`, `tips`, `url`) VALUES (16, 1, '2019-7-31 22:04:30', 1, '2019-7-31 22:04:30', 'roleSetAuthority', NULL, 0, NULL, 0, 0, 3, '配置权限', 4, 'role', '[0],[system],[role],', 1, NULL, '/role/setAuthority');
INSERT INTO `t_sys_menu` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `code`, `component`, `hidden`, `icon`, `ismenu`, `isopen`, `levels`, `name`, `num`, `pcode`, `pcodes`, `status`, `tips`, `url`) VALUES (17, 1, '2019-7-31 22:04:30', 1, '2019-7-31 22:04:30', 'menu', 'views/system/menu/index', 0, 'menu', 1, 0, 2, '菜单管理', 4, 'system', '[0],[system],', 1, NULL, '/menu');
INSERT INTO `t_sys_menu` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `code`, `component`, `hidden`, `icon`, `ismenu`, `isopen`, `levels`, `name`, `num`, `pcode`, `pcodes`, `status`, `tips`, `url`) VALUES (18, 1, '2019-7-31 22:04:30', 1, '2019-7-31 22:04:30', 'menuAdd', NULL, 0, NULL, 0, 0, 3, '添加菜单', 1, 'menu', '[0],[system],[menu],', 1, NULL, '/menu/add');
INSERT INTO `t_sys_menu` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `code`, `component`, `hidden`, `icon`, `ismenu`, `isopen`, `levels`, `name`, `num`, `pcode`, `pcodes`, `status`, `tips`, `url`) VALUES (19, 1, '2019-7-31 22:04:30', 1, '2019-7-31 22:04:30', 'menuEdit', NULL, 0, NULL, 0, 0, 3, '修改菜单', 2, 'menu', '[0],[system],[menu],', 1, NULL, '/menu/edit');
INSERT INTO `t_sys_menu` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `code`, `component`, `hidden`, `icon`, `ismenu`, `isopen`, `levels`, `name`, `num`, `pcode`, `pcodes`, `status`, `tips`, `url`) VALUES (20, 1, '2019-7-31 22:04:30', 1, '2019-7-31 22:04:30', 'menuDelete', NULL, 0, NULL, 0, 0, 3, '删除菜单', 3, 'menu', '[0],[system],[menu],', 1, NULL, '/menu/remove');
INSERT INTO `t_sys_menu` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `code`, `component`, `hidden`, `icon`, `ismenu`, `isopen`, `levels`, `name`, `num`, `pcode`, `pcodes`, `status`, `tips`, `url`) VALUES (21, 1, '2019-7-31 22:04:30', 1, '2019-7-31 22:04:30', 'dept', 'views/system/dept/index', 0, 'dept', 1, NULL, 2, '部门管理', 3, 'system', '[0],[system],', 1, NULL, '/dept');
INSERT INTO `t_sys_menu` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `code`, `component`, `hidden`, `icon`, `ismenu`, `isopen`, `levels`, `name`, `num`, `pcode`, `pcodes`, `status`, `tips`, `url`) VALUES (22, 1, '2019-7-31 22:04:30', 1, '2019-7-31 22:04:30', 'dict', 'views/system/dict/index', 0, 'dict', 1, NULL, 2, '字典管理', 4, 'system', '[0],[system],', 1, NULL, '/dict');
INSERT INTO `t_sys_menu` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `code`, `component`, `hidden`, `icon`, `ismenu`, `isopen`, `levels`, `name`, `num`, `pcode`, `pcodes`, `status`, `tips`, `url`) VALUES (23, 1, '2019-7-31 22:04:30', 1, '2019-7-31 22:04:30', 'deptEdit', NULL, 0, NULL, 0, NULL, 3, '修改部门', 1, 'dept', '[0],[system],[dept],', 1, NULL, '/dept/update');
INSERT INTO `t_sys_menu` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `code`, `component`, `hidden`, `icon`, `ismenu`, `isopen`, `levels`, `name`, `num`, `pcode`, `pcodes`, `status`, `tips`, `url`) VALUES (24, 1, '2019-7-31 22:04:30', 1, '2019-7-31 22:04:30', 'deptDelete', NULL, 0, NULL, 0, NULL, 3, '删除部门', 1, 'dept', '[0],[system],[dept],', 1, NULL, '/dept/delete');
INSERT INTO `t_sys_menu` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `code`, `component`, `hidden`, `icon`, `ismenu`, `isopen`, `levels`, `name`, `num`, `pcode`, `pcodes`, `status`, `tips`, `url`) VALUES (25, 1, '2019-7-31 22:04:30', 1, '2019-7-31 22:04:30', 'dictAdd', NULL, 0, NULL, 0, NULL, 3, '添加字典', 1, 'dict', '[0],[system],[dict],', 1, NULL, '/dict/add');
INSERT INTO `t_sys_menu` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `code`, `component`, `hidden`, `icon`, `ismenu`, `isopen`, `levels`, `name`, `num`, `pcode`, `pcodes`, `status`, `tips`, `url`) VALUES (26, 1, '2019-7-31 22:04:30', 1, '2019-7-31 22:04:30', 'dictEdit', NULL, 0, NULL, 0, NULL, 3, '修改字典', 1, 'dict', '[0],[system],[dict],', 1, NULL, '/dict/update');
INSERT INTO `t_sys_menu` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `code`, `component`, `hidden`, `icon`, `ismenu`, `isopen`, `levels`, `name`, `num`, `pcode`, `pcodes`, `status`, `tips`, `url`) VALUES (27, 1, '2019-7-31 22:04:30', 1, '2019-7-31 22:04:30', 'dictDelete', NULL, 0, NULL, 0, NULL, 3, '删除字典', 1, 'dict', '[0],[system],[dict],', 1, NULL, '/dict/delete');
INSERT INTO `t_sys_menu` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `code`, `component`, `hidden`, `icon`, `ismenu`, `isopen`, `levels`, `name`, `num`, `pcode`, `pcodes`, `status`, `tips`, `url`) VALUES (28, 1, '2019-7-31 22:04:30', 1, '2019-7-31 22:04:30', 'deptList', NULL, 0, NULL, 0, NULL, 3, '部门列表', 5, 'dept', '[0],[system],[dept],', 1, NULL, '/dept/list');
INSERT INTO `t_sys_menu` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `code`, `component`, `hidden`, `icon`, `ismenu`, `isopen`, `levels`, `name`, `num`, `pcode`, `pcodes`, `status`, `tips`, `url`) VALUES (29, 1, '2019-7-31 22:04:30', 1, '2019-7-31 22:04:30', 'deptDetail', NULL, 0, NULL, 0, NULL, 3, '部门详情', 6, 'dept', '[0],[system],[dept],', 1, NULL, '/dept/detail');
INSERT INTO `t_sys_menu` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `code`, `component`, `hidden`, `icon`, `ismenu`, `isopen`, `levels`, `name`, `num`, `pcode`, `pcodes`, `status`, `tips`, `url`) VALUES (30, 1, '2019-7-31 22:04:30', 1, '2019-7-31 22:04:30', 'dictList', NULL, 0, NULL, 0, NULL, 3, '字典列表', 5, 'dict', '[0],[system],[dict],', 1, NULL, '/dict/list');
INSERT INTO `t_sys_menu` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `code`, `component`, `hidden`, `icon`, `ismenu`, `isopen`, `levels`, `name`, `num`, `pcode`, `pcodes`, `status`, `tips`, `url`) VALUES (31, 1, '2019-7-31 22:04:30', 1, '2019-7-31 22:04:30', 'dictDetail', NULL, 0, NULL, 0, NULL, 3, '字典详情', 6, 'dict', '[0],[system],[dict],', 1, NULL, '/dict/detail');
INSERT INTO `t_sys_menu` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `code`, `component`, `hidden`, `icon`, `ismenu`, `isopen`, `levels`, `name`, `num`, `pcode`, `pcodes`, `status`, `tips`, `url`) VALUES (32, 1, '2019-7-31 22:04:30', 1, '2019-7-31 22:04:30', 'deptAdd', NULL, 0, NULL, 0, NULL, 3, '添加部门', 1, 'dept', '[0],[system],[dept],', 1, NULL, '/dept/add');
INSERT INTO `t_sys_menu` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `code`, `component`, `hidden`, `icon`, `ismenu`, `isopen`, `levels`, `name`, `num`, `pcode`, `pcodes`, `status`, `tips`, `url`) VALUES (33, 1, '2019-7-31 22:04:30', 1, '2019-7-31 22:04:30', 'cfg', 'views/system/cfg/index', 0, 'cfg', 1, NULL, 2, '参数管理', 10, 'system', '[0],[system],', 1, NULL, '/cfg');
INSERT INTO `t_sys_menu` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `code`, `component`, `hidden`, `icon`, `ismenu`, `isopen`, `levels`, `name`, `num`, `pcode`, `pcodes`, `status`, `tips`, `url`) VALUES (34, 1, '2019-7-31 22:04:30', 1, '2019-7-31 22:04:30', 'cfgAdd', NULL, 0, NULL, 0, NULL, 3, '添加系统参数', 1, 'cfg', '[0],[system],[cfg],', 1, NULL, '/cfg/add');
INSERT INTO `t_sys_menu` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `code`, `component`, `hidden`, `icon`, `ismenu`, `isopen`, `levels`, `name`, `num`, `pcode`, `pcodes`, `status`, `tips`, `url`) VALUES (35, 1, '2019-7-31 22:04:30', 1, '2019-7-31 22:04:30', 'cfgEdit', NULL, 0, NULL, 0, NULL, 3, '修改系统参数', 2, 'cfg', '[0],[system],[cfg],', 1, NULL, '/cfg/update');
INSERT INTO `t_sys_menu` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `code`, `component`, `hidden`, `icon`, `ismenu`, `isopen`, `levels`, `name`, `num`, `pcode`, `pcodes`, `status`, `tips`, `url`) VALUES (36, 1, '2019-7-31 22:04:30', 1, '2019-7-31 22:04:30', 'cfgDelete', NULL, 0, NULL, 0, NULL, 3, '删除系统参数', 3, 'cfg', '[0],[system],[cfg],', 1, NULL, '/cfg/delete');
INSERT INTO `t_sys_menu` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `code`, `component`, `hidden`, `icon`, `ismenu`, `isopen`, `levels`, `name`, `num`, `pcode`, `pcodes`, `status`, `tips`, `url`) VALUES (37, 1, '2019-7-31 22:04:30', 1, '2019-7-31 22:04:30', 'task', 'views/system/task/index', 0, 'task', 1, NULL, 2, '任务管理', 11, 'system', '[0],[system],', 1, NULL, '/task');
INSERT INTO `t_sys_menu` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `code`, `component`, `hidden`, `icon`, `ismenu`, `isopen`, `levels`, `name`, `num`, `pcode`, `pcodes`, `status`, `tips`, `url`) VALUES (38, 1, '2019-7-31 22:04:30', 1, '2019-7-31 22:04:30', 'taskAdd', NULL, 0, NULL, 0, NULL, 3, '添加任务', 1, 'task', '[0],[system],[task],', 1, NULL, '/task/add');
INSERT INTO `t_sys_menu` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `code`, `component`, `hidden`, `icon`, `ismenu`, `isopen`, `levels`, `name`, `num`, `pcode`, `pcodes`, `status`, `tips`, `url`) VALUES (39, 1, '2019-7-31 22:04:30', 1, '2019-7-31 22:04:30', 'taskEdit', NULL, 0, NULL, 0, NULL, 3, '修改任务', 2, 'task', '[0],[system],[task],', 1, NULL, '/task/update');
INSERT INTO `t_sys_menu` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `code`, `component`, `hidden`, `icon`, `ismenu`, `isopen`, `levels`, `name`, `num`, `pcode`, `pcodes`, `status`, `tips`, `url`) VALUES (40, 1, '2019-7-31 22:04:30', 1, '2019-7-31 22:04:30', 'taskDelete', NULL, 0, NULL, 0, NULL, 3, '删除任务', 3, 'task', '[0],[system],[task],', 1, NULL, '/task/delete');
INSERT INTO `t_sys_menu` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `code`, `component`, `hidden`, `icon`, `ismenu`, `isopen`, `levels`, `name`, `num`, `pcode`, `pcodes`, `status`, `tips`, `url`) VALUES (41, 1, '2019-3-11 22:29:54', 1, '2019-3-11 22:29:54', 'channel', 'views/cms/channel/index', 0, 'channel', 1, NULL, 2, '栏目管理', 1, 'cms', '[0],[cms],', 1, NULL, '/channel');
INSERT INTO `t_sys_menu` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `code`, `component`, `hidden`, `icon`, `ismenu`, `isopen`, `levels`, `name`, `num`, `pcode`, `pcodes`, `status`, `tips`, `url`) VALUES (42, 1, '2019-3-11 22:30:17', 1, '2019-3-11 22:30:17', 'dish', 'views/cms/dish/index', 0, 'documentation', 1, NULL, 2, '菜品管理', 2, 'cms', '[0],[cms],', 1, NULL, '/dish');
INSERT INTO `t_sys_menu` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `code`, `component`, `hidden`, `icon`, `ismenu`, `isopen`, `levels`, `name`, `num`, `pcode`, `pcodes`, `status`, `tips`, `url`) VALUES (43, 1, '2019-3-11 22:30:52', 1, '2019-3-11 22:30:52', 'banner', 'views/cms/banner/index', 0, 'banner', 1, NULL, 2, 'banner管理', 3, 'cms', '[0],[cms],', 1, NULL, '/banner');
INSERT INTO `t_sys_menu` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `code`, `component`, `hidden`, `icon`, `ismenu`, `isopen`, `levels`, `name`, `num`, `pcode`, `pcodes`, `status`, `tips`, `url`) VALUES (44, 1, '2019-3-18 19:45:37', 1, '2019-3-18 19:45:37', 'order', 'views/cms/order/index', 0, 'contacts', 1, NULL, 2, '订单管理', 4, 'cms', '[0],[cms],', 1, NULL, '/order');
INSERT INTO `t_sys_menu` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `code`, `component`, `hidden`, `icon`, `ismenu`, `isopen`, `levels`, `name`, `num`, `pcode`, `pcodes`, `status`, `tips`, `url`) VALUES (45, 1, '2019-3-19 10:25:05', 1, '2019-3-19 10:25:05', 'file', 'views/cms/file/index', 0, 'file', 1, NULL, 2, '文件管理', 5, 'cms', '[0],[cms],', 1, NULL, '/fileMgr');
INSERT INTO `t_sys_menu` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `code`, `component`, `hidden`, `icon`, `ismenu`, `isopen`, `levels`, `name`, `num`, `pcode`, `pcodes`, `status`, `tips`, `url`) VALUES (46, 1, '2019-3-11 22:30:17', 1, '2019-3-11 22:30:17', 'editDish', 'views/cms/dish/edit.vue', 0, 'articleEdit', 1, NULL, 2, '新建文章', 1, 'cms', '[0],[cms],', 1, NULL, '/cms/dishEdit');
INSERT INTO `t_sys_menu` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `code`, `component`, `hidden`, `icon`, `ismenu`, `isopen`, `levels`, `name`, `num`, `pcode`, `pcodes`, `status`, `tips`, `url`) VALUES (47, 1, '2019-7-31 22:04:30', 1, '2019-7-31 22:04:30', 'taskLog', 'views/system/taskLog/index', 1, 'task', 1, NULL, 2, '任务日志', 4, 'system', '[0],[system]', 1, NULL, '/taskLog');
INSERT INTO `t_sys_menu` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `code`, `component`, `hidden`, `icon`, `ismenu`, `isopen`, `levels`, `name`, `num`, `pcode`, `pcodes`, `status`, `tips`, `url`) VALUES (48, 1, '2019-7-31 22:04:30', 1, '2019-6-2 10:25:31', 'log', 'views/operation/log/index', 0, 'log', 1, NULL, 2, '业务日志', 6, 'operationMgr', '[0],[operationMgr],', 1, NULL, '/log');
INSERT INTO `t_sys_menu` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `code`, `component`, `hidden`, `icon`, `ismenu`, `isopen`, `levels`, `name`, `num`, `pcode`, `pcodes`, `status`, `tips`, `url`) VALUES (49, 1, '2019-7-31 22:04:30', 1, '2019-6-2 10:25:36', 'loginLog', 'views/operation/loginLog/index', 0, 'logininfor', 1, NULL, 2, '登录日志', 6, 'operationMgr', '[0],[operationMgr],', 1, NULL, '/loginLog');
INSERT INTO `t_sys_menu` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `code`, `component`, `hidden`, `icon`, `ismenu`, `isopen`, `levels`, `name`, `num`, `pcode`, `pcodes`, `status`, `tips`, `url`) VALUES (50, 1, '2019-7-31 22:04:30', 1, '2019-7-31 22:04:30', 'logClear', NULL, 0, NULL, 0, NULL, 3, '清空日志', 3, 'log', '[0],[system],[log],', 1, NULL, '/log/delLog');
INSERT INTO `t_sys_menu` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `code`, `component`, `hidden`, `icon`, `ismenu`, `isopen`, `levels`, `name`, `num`, `pcode`, `pcodes`, `status`, `tips`, `url`) VALUES (51, 1, '2019-7-31 22:04:30', 1, '2019-7-31 22:04:30', 'logDetail', NULL, 0, NULL, 0, NULL, 3, '日志详情', 3, 'log', '[0],[system],[log],', 1, NULL, '/log/detail');
INSERT INTO `t_sys_menu` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `code`, `component`, `hidden`, `icon`, `ismenu`, `isopen`, `levels`, `name`, `num`, `pcode`, `pcodes`, `status`, `tips`, `url`) VALUES (52, 1, '2019-7-31 22:04:30', 1, '2019-7-31 22:04:30', 'loginLogClear', NULL, 0, NULL, 0, NULL, 3, '清空登录日志', 1, 'loginLog', '[0],[system],[loginLog],', 1, NULL, '/loginLog/delLoginLog');
INSERT INTO `t_sys_menu` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `code`, `component`, `hidden`, `icon`, `ismenu`, `isopen`, `levels`, `name`, `num`, `pcode`, `pcodes`, `status`, `tips`, `url`) VALUES (53, 1, '2019-7-31 22:04:30', 1, '2019-7-31 22:04:30', 'loginLogList', NULL, 0, NULL, 0, NULL, 3, '登录日志列表', 2, 'loginLog', '[0],[system],[loginLog],', 1, NULL, '/loginLog/list');
INSERT INTO `t_sys_menu` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `code`, `component`, `hidden`, `icon`, `ismenu`, `isopen`, `levels`, `name`, `num`, `pcode`, `pcodes`, `status`, `tips`, `url`) VALUES (54, 1, '2019-6-2 10:10:20', 1, '2019-6-2 10:10:20', 'druid', 'views/operation/druid/index', 0, 'monitor', 1, NULL, 2, '数据库管理', 1, 'operationMgr', '[0],[operationMgr],', 1, NULL, '/druid');
INSERT INTO `t_sys_menu` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `code`, `component`, `hidden`, `icon`, `ismenu`, `isopen`, `levels`, `name`, `num`, `pcode`, `pcodes`, `status`, `tips`, `url`) VALUES (55, 1, '2019-6-2 10:10:20', 1, '2019-6-2 10:10:20', 'swagger', 'views/operation/api/index', 0, 'swagger', 1, NULL, 2, '接口文档', 2, 'operationMgr', '[0],[operationMgr],', 1, NULL, '/swagger');
INSERT INTO `t_sys_menu` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `code`, `component`, `hidden`, `icon`, `ismenu`, `isopen`, `levels`, `name`, `num`, `pcode`, `pcodes`, `status`, `tips`, `url`) VALUES (56, 1, '2019-6-10 21:26:52', 1, '2019-6-10 21:26:52', 'messageMgr', 'layout', 0, 'message', 1, NULL, 1, '消息管理', 4, '0', '[0],', 1, NULL, '/message');
INSERT INTO `t_sys_menu` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `code`, `component`, `hidden`, `icon`, `ismenu`, `isopen`, `levels`, `name`, `num`, `pcode`, `pcodes`, `status`, `tips`, `url`) VALUES (57, 1, '2019-6-10 21:27:34', 1, '2019-6-10 21:27:34', 'msg', 'views/message/message/index', 0, 'message', 1, NULL, 2, '历史消息', 1, 'messageMgr', '[0],[messageMgr],', 1, NULL, '/history');
INSERT INTO `t_sys_menu` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `code`, `component`, `hidden`, `icon`, `ismenu`, `isopen`, `levels`, `name`, `num`, `pcode`, `pcodes`, `status`, `tips`, `url`) VALUES (58, 1, '2019-6-10 21:27:56', 1, '2019-6-10 21:27:56', 'msgTpl', 'views/message/template/index', 0, 'template', 1, NULL, 2, '消息模板', 2, 'messageMgr', '[0],[messageMgr],', 1, NULL, '/template');
INSERT INTO `t_sys_menu` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `code`, `component`, `hidden`, `icon`, `ismenu`, `isopen`, `levels`, `name`, `num`, `pcode`, `pcodes`, `status`, `tips`, `url`) VALUES (59, 1, '2019-6-10 21:28:21', 1, '2019-6-10 21:28:21', 'msgSender', 'views/message/sender/index', 0, 'sender', 1, NULL, 2, '消息发送者', 3, 'messageMgr', '[0],[messageMgr],', 1, NULL, '/sender');
INSERT INTO `t_sys_menu` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `code`, `component`, `hidden`, `icon`, `ismenu`, `isopen`, `levels`, `name`, `num`, `pcode`, `pcodes`, `status`, `tips`, `url`) VALUES (60, 1, '2019-6-10 21:28:21', 1, '2019-6-10 21:28:21', 'msgClear', NULL, 0, NULL, 1, NULL, 2, '清空历史消息', 3, 'messageMgr', '[0],[messageMgr],', 1, NULL, NULL);
INSERT INTO `t_sys_menu` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `code`, `component`, `hidden`, `icon`, `ismenu`, `isopen`, `levels`, `name`, `num`, `pcode`, `pcodes`, `status`, `tips`, `url`) VALUES (61, 1, '2019-7-31 22:04:30', 1, '2019-7-31 22:04:30', 'msgTplEdit', NULL, 0, NULL, 0, NULL, 3, '编辑消息模板', 1, 'msgTpl', '[0],[messageMgr],[msgTpl]', 1, NULL, NULL);
INSERT INTO `t_sys_menu` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `code`, `component`, `hidden`, `icon`, `ismenu`, `isopen`, `levels`, `name`, `num`, `pcode`, `pcodes`, `status`, `tips`, `url`) VALUES (62, 1, '2019-7-31 22:04:30', 1, '2019-7-31 22:04:30', 'msgTplDelete', NULL, 0, NULL, 0, NULL, 3, '删除消息模板', 2, 'msgTpl', '[0],[messageMgr],[msgTpl]', 1, NULL, NULL);
INSERT INTO `t_sys_menu` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `code`, `component`, `hidden`, `icon`, `ismenu`, `isopen`, `levels`, `name`, `num`, `pcode`, `pcodes`, `status`, `tips`, `url`) VALUES (63, 1, '2019-7-31 22:04:30', 1, '2019-7-31 22:04:30', 'msgSenderEdit', NULL, 0, NULL, 0, NULL, 3, '编辑消息发送器', 1, 'msgSender', '[0],[messageMgr],[msgSender]', 1, NULL, NULL);
INSERT INTO `t_sys_menu` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `code`, `component`, `hidden`, `icon`, `ismenu`, `isopen`, `levels`, `name`, `num`, `pcode`, `pcodes`, `status`, `tips`, `url`) VALUES (64, 1, '2019-7-31 22:04:30', 1, '2019-7-31 22:04:30', 'msgSenderDelete', NULL, 0, NULL, 0, NULL, 3, '删除消息发送器', 2, 'msgSender', '[0],[messageMgr],[msgSender]', 1, NULL, NULL);
INSERT INTO `t_sys_menu` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `code`, `component`, `hidden`, `icon`, `ismenu`, `isopen`, `levels`, `name`, `num`, `pcode`, `pcodes`, `status`, `tips`, `url`) VALUES (65, 1, '2019-7-31 22:04:30', 1, '2019-7-31 22:04:30', 'fileUpload', NULL, 0, NULL, 0, NULL, 3, '上传文件', 1, 'file', '[0],[cms],[file],', 1, NULL, NULL);
INSERT INTO `t_sys_menu` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `code`, `component`, `hidden`, `icon`, `ismenu`, `isopen`, `levels`, `name`, `num`, `pcode`, `pcodes`, `status`, `tips`, `url`) VALUES (66, 1, '2019-7-31 21:51:33', 1, '2019-7-31 21:51:33', 'bannerEdit', NULL, 0, NULL, 0, NULL, 3, '编辑banner', 1, 'banner', '[0],[cms],[banner],', 1, NULL, NULL);
INSERT INTO `t_sys_menu` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `code`, `component`, `hidden`, `icon`, `ismenu`, `isopen`, `levels`, `name`, `num`, `pcode`, `pcodes`, `status`, `tips`, `url`) VALUES (67, 1, '2019-7-31 21:51:33', 1, '2019-7-31 21:51:33', 'bannerDelete', NULL, 0, NULL, 0, NULL, 3, '删除banner', 2, 'banner', '[0],[cms],[banner],', 1, NULL, NULL);
INSERT INTO `t_sys_menu` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `code`, `component`, `hidden`, `icon`, `ismenu`, `isopen`, `levels`, `name`, `num`, `pcode`, `pcodes`, `status`, `tips`, `url`) VALUES (68, 1, '2019-7-31 22:04:30', 1, '2019-7-31 22:04:30', 'channelEdit', NULL, 0, NULL, 0, NULL, 3, '编辑栏目', 1, 'channel', '[0],[cms],[channel],', 1, NULL, NULL);
INSERT INTO `t_sys_menu` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `code`, `component`, `hidden`, `icon`, `ismenu`, `isopen`, `levels`, `name`, `num`, `pcode`, `pcodes`, `status`, `tips`, `url`) VALUES (69, 1, '2019-7-31 22:04:30', 1, '2019-7-31 22:04:30', 'channelDelete', NULL, 0, NULL, 0, NULL, 3, '删除栏目', 2, 'channel', '[0],[cms],[channel],', 1, NULL, NULL);
INSERT INTO `t_sys_menu` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `code`, `component`, `hidden`, `icon`, `ismenu`, `isopen`, `levels`, `name`, `num`, `pcode`, `pcodes`, `status`, `tips`, `url`) VALUES (70, 1, '2019-7-31 22:04:30', 1, '2019-7-31 22:04:30', 'deleteDish', NULL, 0, NULL, 0, NULL, 3, '删除菜品', 2, 'dish', '[0],[cms],[dish]', 1, NULL, NULL);

-- ----------------------------
-- Records of t_sys_notice
-- ----------------------------
INSERT INTO `t_sys_notice` (`id`, `title`, `type`, `content`, `create_time`, `create_by`, `modify_time`, `modify_by`) VALUES ('1', '超级管理员', '10', 'Welcome', '2017-01-11 08:53:20', '1', '2019-01-08 23:30:58', '1');

-- ----------------------------
-- Records of t_sys_operation_log
-- ----------------------------
INSERT INTO `t_sys_operation_log` (`id`, `logtype`, `logname`, `userid`, `classname`, `method`, `create_time`, `succeed`, `message`) VALUES ('1', '业务日志', '添加参数', '1', 'cn.ChaosWongWong.guns.api.controller.cms.DishMgrController', 'upload', '2019-05-10 13:22:49', '成功', '参数名称=system.app.name');
INSERT INTO `t_sys_operation_log` (`id`, `logtype`, `logname`, `userid`, `classname`, `method`, `create_time`, `succeed`, `message`) VALUES ('2', '业务日志', '修改参数', '1', 'cn.ChaosWongWong.guns.api.controller.cms.DishMgrController', 'upload', '2019-06-10 13:31:09', '成功', '参数名称=system.app.name');
INSERT INTO `t_sys_operation_log` (`id`, `logtype`, `logname`, `userid`, `classname`, `method`, `create_time`, `succeed`, `message`) VALUES ('3', '业务日志', '编辑文章', '1', 'cn.ChaosWongWong.guns.api.controller.cms.DishMgrController', 'upload', '2019-07-10 13:22:49', '成功', '参数名称=system.app.name');
INSERT INTO `t_sys_operation_log` (`id`, `logtype`, `logname`, `userid`, `classname`, `method`, `create_time`, `succeed`, `message`) VALUES ('4', '业务日志', '编辑栏目', '1', 'cn.ChaosWongWong.guns.api.controller.cms.DishMgrController', 'upload', '2019-08-10 13:31:09', '成功', '参数名称=system.app.name');

-- ----------------------------
-- Records of t_sys_relation
-- ----------------------------

INSERT INTO `t_sys_relation` VALUES ('1', '42', '1');
INSERT INTO `t_sys_relation` VALUES ('2', '70', '1');
INSERT INTO `t_sys_relation` VALUES ('3', '46', '1');
INSERT INTO `t_sys_relation` VALUES ('4', '43', '1');
INSERT INTO `t_sys_relation` VALUES ('5', '67', '1');
INSERT INTO `t_sys_relation` VALUES ('6', '66', '1');
INSERT INTO `t_sys_relation` VALUES ('7', '33', '1');
INSERT INTO `t_sys_relation` VALUES ('8', '34', '1');
INSERT INTO `t_sys_relation` VALUES ('9', '36', '1');
INSERT INTO `t_sys_relation` VALUES ('10', '35', '1');
INSERT INTO `t_sys_relation` VALUES ('11', '41', '1');
INSERT INTO `t_sys_relation` VALUES ('12', '69', '1');
INSERT INTO `t_sys_relation` VALUES ('13', '68', '1');
INSERT INTO `t_sys_relation` VALUES ('14', '2', '1');
INSERT INTO `t_sys_relation` VALUES ('15', '44', '1');
INSERT INTO `t_sys_relation` VALUES ('16', '21', '1');
INSERT INTO `t_sys_relation` VALUES ('17', '32', '1');
INSERT INTO `t_sys_relation` VALUES ('18', '24', '1');
INSERT INTO `t_sys_relation` VALUES ('19', '29', '1');
INSERT INTO `t_sys_relation` VALUES ('20', '23', '1');
INSERT INTO `t_sys_relation` VALUES ('21', '28', '1');
INSERT INTO `t_sys_relation` VALUES ('22', '22', '1');
INSERT INTO `t_sys_relation` VALUES ('23', '25', '1');
INSERT INTO `t_sys_relation` VALUES ('24', '27', '1');
INSERT INTO `t_sys_relation` VALUES ('25', '31', '1');
INSERT INTO `t_sys_relation` VALUES ('26', '26', '1');
INSERT INTO `t_sys_relation` VALUES ('27', '30', '1');
INSERT INTO `t_sys_relation` VALUES ('28', '54', '1');
INSERT INTO `t_sys_relation` VALUES ('29', '45', '1');
INSERT INTO `t_sys_relation` VALUES ('30', '65', '1');
INSERT INTO `t_sys_relation` VALUES ('31', '48', '1');
INSERT INTO `t_sys_relation` VALUES ('32', '50', '1');
INSERT INTO `t_sys_relation` VALUES ('33', '51', '1');
INSERT INTO `t_sys_relation` VALUES ('34', '49', '1');
INSERT INTO `t_sys_relation` VALUES ('35', '52', '1');
INSERT INTO `t_sys_relation` VALUES ('36', '53', '1');
INSERT INTO `t_sys_relation` VALUES ('37', '17', '1');
INSERT INTO `t_sys_relation` VALUES ('38', '18', '1');
INSERT INTO `t_sys_relation` VALUES ('39', '20', '1');
INSERT INTO `t_sys_relation` VALUES ('40', '19', '1');
INSERT INTO `t_sys_relation` VALUES ('41', '56', '1');
INSERT INTO `t_sys_relation` VALUES ('42', '4', '1');
INSERT INTO `t_sys_relation` VALUES ('43', '5', '1');
INSERT INTO `t_sys_relation` VALUES ('44', '7', '1');
INSERT INTO `t_sys_relation` VALUES ('45', '6', '1');
INSERT INTO `t_sys_relation` VALUES ('46', '9', '1');
INSERT INTO `t_sys_relation` VALUES ('47', '8', '1');
INSERT INTO `t_sys_relation` VALUES ('48', '11', '1');
INSERT INTO `t_sys_relation` VALUES ('49', '10', '1');
INSERT INTO `t_sys_relation` VALUES ('50', '57', '1');
INSERT INTO `t_sys_relation` VALUES ('51', '60', '1');
INSERT INTO `t_sys_relation` VALUES ('52', '59', '1');
INSERT INTO `t_sys_relation` VALUES ('53', '64', '1');
INSERT INTO `t_sys_relation` VALUES ('54', '63', '1');
INSERT INTO `t_sys_relation` VALUES ('55', '58', '1');
INSERT INTO `t_sys_relation` VALUES ('56', '62', '1');
INSERT INTO `t_sys_relation` VALUES ('57', '61', '1');
INSERT INTO `t_sys_relation` VALUES ('58', '3', '1');
INSERT INTO `t_sys_relation` VALUES ('59', '12', '1');
INSERT INTO `t_sys_relation` VALUES ('60', '13', '1');
INSERT INTO `t_sys_relation` VALUES ('61', '15', '1');
INSERT INTO `t_sys_relation` VALUES ('62', '14', '1');
INSERT INTO `t_sys_relation` VALUES ('63', '16', '1');
INSERT INTO `t_sys_relation` VALUES ('64', '55', '1');
INSERT INTO `t_sys_relation` VALUES ('65', '1', '1');
INSERT INTO `t_sys_relation` VALUES ('66', '37', '1');
INSERT INTO `t_sys_relation` VALUES ('67', '38', '1');
INSERT INTO `t_sys_relation` VALUES ('68', '40', '1');
INSERT INTO `t_sys_relation` VALUES ('69', '39', '1');
INSERT INTO `t_sys_relation` VALUES ('70', '47', '1');

INSERT INTO `t_sys_relation` VALUES ('128', '41', '2');
INSERT INTO `t_sys_relation` VALUES ('129', '42', '2');
INSERT INTO `t_sys_relation` VALUES ('130', '43', '2');
INSERT INTO `t_sys_relation` VALUES ('131', '44', '2');
INSERT INTO `t_sys_relation` VALUES ('132', '45', '2');
INSERT INTO `t_sys_relation` VALUES ('133', '46', '2');
INSERT INTO `t_sys_relation` VALUES ('134', '65', '2');
INSERT INTO `t_sys_relation` VALUES ('135', '66', '2');
INSERT INTO `t_sys_relation` VALUES ('136', '67', '2');
INSERT INTO `t_sys_relation` VALUES ('137', '68', '2');
INSERT INTO `t_sys_relation` VALUES ('138', '69', '2');
INSERT INTO `t_sys_relation` VALUES ('139', '70', '2');
INSERT INTO `t_sys_relation` VALUES ('143', '2', '2');

-- ----------------------------
-- Records of t_sys_role
-- ----------------------------
INSERT INTO `t_sys_role` VALUES ('1', null, null, null, null, '24', '超级管理员', '1', '0', 'administrator', '1');
INSERT INTO `t_sys_role` VALUES ('2', null, null, null, null, '3', '网站管理员', '2', '1', 'developer', null);
INSERT INTO `t_sys_role` VALUES ('3', null, null, null, null, '5', '用户', '3', '1', 'user', null);

-- ----------------------------
-- Records of t_sys_task
-- ----------------------------
INSERT INTO `t_sys_task` (`id`, `name`, `job_group`, `job_class`, `note`, `cron`, `data`, `exec_at`, `exec_result`, `disabled`, `create_time`, `create_by`, `concurrent`, `modify_time`, `modify_by`) VALUES ('1', '测试任务', 'default', '.service.task.job.HelloJob', '测试任务,每30分钟执行一次', '0 0/30 * * * ?', '{\n\"appname\": \"web-flash\",\n\"version\":1\n}\n            \n            \n            \n            \n            \n            \n            \n            \n            \n            \n            \n            ', '2019-03-27 11:47:00', '执行成功', '0', '2018-12-28 09:54:00', '1', '0', '2019-03-27 11:47:11', '-1');

-- ----------------------------
-- Records of t_sys_task_log
-- ----------------------------

-- ----------------------------
-- Records of t_sys_user
-- ----------------------------

INSERT INTO `t_sys_user` VALUES ('-1', null, null, null, null, 'system', null, null, null, null, '应用系统', null, null, null, null, null, null, null);
INSERT INTO `t_sys_user` VALUES ('1', null, '2016-01-29 08:49:53', '1', '2019-03-20 23:45:24', 'admin', null, '2017-05-05 00:00:00', '2', '123@qq.com', '管理员', 'b5a51391f271f062867e5984e2fcffee', '15021222222', '1', '8pgby', '2', '1', '25');
INSERT INTO `t_sys_user` VALUES ('2', null, '2018-09-13 17:21:02', '1', '2019-01-09 23:05:51', 'developer', null, '2017-12-31 00:00:00', '3', '456@qq.com', '网站管理员', 'fac36d5616fe9ebd460691264b28ee27', '15022222222', '2,', 'vscp9', '1', '1', null);
INSERT INTO `t_sys_user` VALUES ('4', null, '2019-10-20 18:53:40', '1', '2019-10-20 18:53:53', 'ChaosWong', null, '1998-09-07 00:00:00', '5', 'chaoswang@chaoswang.Hainanu', 'ChaosWong', 'c56ca76684b08eb6c344206c804aa383', '15706589233', '3', '47067', '1' , '2' , null);

-- ----------------------------
-- Records of t_test_boy
-- ----------------------------
INSERT INTO `t_test_boy` (`id`, `create_by`, `create_time`, `modify_by`, `modify_time`, `age`, `birthday`, `has_girl_friend`, `name`) VALUES ('1', null, null, null, null, '18', '2000-01-01', '1', '张三');


-- ----------------------------
-- Records of t_message_sender
-- ----------------------------
INSERT INTO `t_message_sender` VALUES ('1', null, null, null, null, 'tencentSmsSender', ' 腾讯短信服务', null);
INSERT INTO `t_message_sender` VALUES ('2', null, null, null, null, 'defaultEmailSender', '默认邮件发送器', null);

-- ----------------------------
-- Records of t_message_template
-- ----------------------------
INSERT INTO `t_message_template` VALUES ('1', null, null, null, null, 'REGISTER_CODE', '注册页面，点击获取验证码', '【腾讯云】校验码{1}，请于5分钟内完成验证，如非本人操作请忽略本短信。', '1', '注册验证码', 0);
INSERT INTO `t_message_template` VALUES ('2', null, null, null, null, 'EMAIL_TEST', '测试发送', '你好:{1},欢迎使用{2}', '2', '测试邮件', 1);
INSERT INTO `t_message_template` VALUES ('3', null, null, null, null, 'EMAIL_HTML_TEMPLATE_TEST', '测试发送模板邮件', '你好<strong>${userName}</strong>欢迎使用<font color=\"red\">${appName}</font>,这是html模板邮件', '2', '测试发送模板邮件', 1);

-- ----------------------------
-- Records of t_message
-- ----------------------------
INSERT INTO `t_message` VALUES ('1', null, '2019-06-10 21:20:16', null, null, '【腾讯云】校验码1032，请于5分钟内完成验证，如非本人操作请忽略本短信。', '15021592814', '2', 'REGISTER_CODE', '0');
