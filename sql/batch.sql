CREATE TABLE `bills` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint(10) unsigned NOT NULL,
  `fees` double NOT NULL,
  `paid_fees` double NOT NULL,
  `unpaid_fees` double NOT NULL,
  `pay_status` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_BILL_USERS_ID` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=410 DEFAULT CHARSET=utf8;

CREATE TABLE `cdp_job_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键 : 自增主键',
  `name` varchar(100) NOT NULL COMMENT 'job名称',
  `code` varchar(60) NOT NULL COMMENT 'job的code',
  `job_type` int(11) DEFAULT NULL COMMENT '1:upload;2:opds;3:download',
  `project` varchar(60) DEFAULT NULL COMMENT 'job的工程',
  `job_group` varchar(40) DEFAULT NULL COMMENT 'jobGroup的code',
  `sort` int(11) DEFAULT '0' COMMENT '排序 : 排序',
  `job_content` text COMMENT 'job任务脚本内容',
  `status_flag` tinyint(4) DEFAULT '1' COMMENT '状态标识 : 状态标识 1:启用 2:禁用',
  `interrupt_flag` tinyint(4) DEFAULT '1' COMMENT '状态标识 : 状态标识 1:启用 2:禁用',
  `creator_name` varchar(32) DEFAULT NULL COMMENT '创建者名称 : 创建者名称',
  `creator_id` bigint(20) DEFAULT NULL COMMENT '创建者id : 创建者id',
  `updator_name` varchar(32) DEFAULT NULL COMMENT '最后修改者姓名 : 最后修改者姓名',
  `updator_id` bigint(20) DEFAULT NULL COMMENT '更新者id : 更新者id',
  `server_create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '服务器创建时间 : 服务器创建时间',
  `server_update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '服务器更新时间 : 服务器更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_code` (`code`),
  KEY `idx_job_group_type` (`job_group`,`code`,`job_type`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='cdp,odps任务job配置';

CREATE TABLE `customer` (
  `customerID` bigint(20) NOT NULL AUTO_INCREMENT,
  `commercialID` bigint(20) DEFAULT NULL COMMENT '商户id',
  `brandId` bigint(20) DEFAULT NULL COMMENT '品牌表的主键ID',
  `memberID` bigint(20) DEFAULT NULL COMMENT '会员id',
  `commercialMemberId` bigint(20) DEFAULT NULL COMMENT '商家会员id',
  `groupID` bigint(20) NOT NULL DEFAULT '999999',
  `country` varchar(30) DEFAULT NULL,
  `nation` varchar(30) DEFAULT NULL,
  `invoice` varchar(100) DEFAULT NULL COMMENT '发票开头',
  `name` varchar(60) DEFAULT NULL,
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '状态 0 正常 -1异常',
  `modifyDateTime` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '修改时间',
  `sex` tinyint(4) DEFAULT '-1' COMMENT '性别 -1 未知 0女 1男',
  `mobile` varchar(30) DEFAULT NULL,
  `tel` varchar(30) DEFAULT NULL,
  `company` varchar(200) DEFAULT NULL,
  `address` varchar(500) DEFAULT NULL COMMENT '地址',
  `birthday` date DEFAULT NULL,
  `email` varchar(60) DEFAULT NULL,
  `marriage` tinyint(4) DEFAULT NULL COMMENT '婚姻状况(数据为空)',
  `monthlyIncome` varchar(100) DEFAULT NULL COMMENT '月收入',
  `carDetailed` varchar(100) DEFAULT NULL COMMENT '车牌号',
  `department` varchar(1000) DEFAULT NULL COMMENT '部门',
  `idCards` varchar(30) DEFAULT NULL,
  `interest` varchar(200) DEFAULT NULL COMMENT '爱好',
  `createDateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `memo` varchar(500) DEFAULT NULL COMMENT '备注',
  `invoiceTitle` varchar(500) DEFAULT NULL COMMENT '发票开头',
  `ctype` tinyint(1) DEFAULT '0' COMMENT '客户类型，0：商家手动添加，1：找位自动添加,2:熟客',
  `source` tinyint(4) NOT NULL DEFAULT '1' COMMENT '来源：1为Calm，2为手机app，3为其他系统导入，4为微信，5支付宝，6商家官网，7百度，8 后台，9百度外卖，10饿了么，11美团外卖，12大众点评，13熟客,14糯米点菜',
  `channel` tinyint(1) DEFAULT NULL COMMENT '会员渠道：0：客如云，1：点入，2：有米，3：多盟，4：力美,5：大众点评，6：点评团，7：品客团，8：QQ团购',
  `synFlag` varchar(50) DEFAULT NULL COMMENT '同步标识. 32位的唯一值. ',
  `isNeedConfirm` tinyint(1) DEFAULT '0' COMMENT '0:不验证,1:需要验证。隐私开关字段，该开关字段用于客户在开桌前，进行手机验证码校验时使用。',
  `isAcceptSubscription` tinyint(1) DEFAULT '0' COMMENT '是否接受短信订阅 0-接受,1-不接受',
  `consumePassword` varchar(50) DEFAULT NULL COMMENT '会员消费密码',
  `userId` varchar(20) DEFAULT NULL COMMENT '升级会员时的操作人',
  `levelId` bigint(20) DEFAULT NULL COMMENT '会员等级表的UUID',
  `upgradeTime` datetime DEFAULT NULL COMMENT '客户升级成会员的时间',
  `upgradeCommercialId` bigint(20) DEFAULT NULL COMMENT '升级成会员的操作商户ID',
  `memberCard` varchar(50) DEFAULT NULL COMMENT '会员卡号',
  `ext` varchar(30) DEFAULT NULL COMMENT '分机号',
  `entityCard` varchar(30) DEFAULT NULL COMMENT '实体卡号',
  `bizSource` tinyint(1) DEFAULT NULL COMMENT '1:预订，2:排队，3:来电，4:客户，5:外卖，6.堂食 (只在新增客户时写入)',
  `createUser` varchar(20) DEFAULT NULL COMMENT '创建用户',
  `environmentHobby` varchar(100) DEFAULT NULL COMMENT '环境喜好',
  `isDisable` tinyint(4) DEFAULT '2' COMMENT '会员停用：1.是停用; 2.否',
  `updatorId` bigint(20) DEFAULT NULL COMMENT '更新人ID',
  `loginType` tinyint(4) DEFAULT NULL COMMENT '客户类型(0 手机注册顾客，1,微信注册顾客,2,座机注册顾客)',
  `loginId` varchar(100) DEFAULT NULL COMMENT '第三方唯一键（微信openId,...）',
  `customerMainId` bigint(20) DEFAULT NULL COMMENT '自关联（customerId）',
  `wxIconUrl` varchar(255) DEFAULT NULL COMMENT '微信头像链接',
  `attentionWxTime` datetime DEFAULT NULL COMMENT '关注微信时间',
  `bindFlag` tinyint(4) DEFAULT '1' COMMENT '1-未绑定，2-绑定手机注册顾客',
  PRIMARY KEY (`customerID`),
  UNIQUE KEY `idx_syncFlag` (`synFlag`) USING BTREE,
  UNIQUE KEY `uqn_cm` (`brandId`,`loginId`,`loginType`,`status`) USING BTREE,
  KEY `idx_name` (`name`) USING BTREE,
  KEY `uidx_mobile` (`mobile`) USING BTREE,
  KEY `idx_createTime` (`createDateTime`) USING BTREE,
  KEY `idx_mdf_time` (`modifyDateTime`) USING BTREE,
  KEY `idx_memberid` (`memberID`) USING BTREE,
  KEY `idx_commercialID_status_createDateTime_name` (`commercialID`,`status`,`createDateTime`,`name`(1)),
  KEY `idx_brandId_modifyDateTime_status` (`brandId`,`modifyDateTime`,`status`),
  KEY `idx_upgradeCommercialId_upgradeTime` (`upgradeCommercialId`,`upgradeTime`) USING BTREE,
  KEY `idx_status` (`status`) USING BTREE,
  KEY `idx_customer_main_id` (`customerMainId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2103753387 DEFAULT CHARSET=utf8 COMMENT='客户信息表';

CREATE TABLE `logging_event` (
  `timestmp` bigint(20) NOT NULL,
  `formatted_message` text NOT NULL,
  `logger_name` varchar(254) NOT NULL,
  `level_string` varchar(254) NOT NULL,
  `thread_name` varchar(254) DEFAULT NULL,
  `reference_flag` smallint(6) DEFAULT NULL,
  `arg0` varchar(254) DEFAULT NULL,
  `arg1` varchar(254) DEFAULT NULL,
  `arg2` varchar(254) DEFAULT NULL,
  `arg3` varchar(254) DEFAULT NULL,
  `caller_filename` varchar(254) NOT NULL,
  `caller_class` varchar(254) NOT NULL,
  `caller_method` varchar(254) NOT NULL,
  `caller_line` char(4) NOT NULL,
  `event_id` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`event_id`)
) ENGINE=InnoDB AUTO_INCREMENT=41539 DEFAULT CHARSET=utf8;

CREATE TABLE `logging_event_exception` (
  `event_id` bigint(20) NOT NULL,
  `i` smallint(6) NOT NULL,
  `trace_line` varchar(254) NOT NULL,
  PRIMARY KEY (`event_id`,`i`),
  CONSTRAINT `logging_event_exception_ibfk_1` FOREIGN KEY (`event_id`) REFERENCES `logging_event` (`event_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `logging_event_property` (
  `event_id` bigint(20) NOT NULL,
  `mapped_key` varchar(254) NOT NULL,
  `mapped_value` text,
  PRIMARY KEY (`event_id`,`mapped_key`),
  CONSTRAINT `logging_event_property_ibfk_1` FOREIGN KEY (`event_id`) REFERENCES `logging_event` (`event_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `messages` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `USER_ID` int(10) unsigned NOT NULL,
  `CONTENT` text NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_MESSAGE_USER_ID` (`USER_ID`),
  CONSTRAINT `FK_MESSAGE_USER_ID` FOREIGN KEY (`USER_ID`) REFERENCES `users` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `payrecords` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `bill_id` int(10) unsigned NOT NULL,
  `paid_fees` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_PAY_RECORD_BILLS_ID` (`bill_id`),
  CONSTRAINT `FK_PAY_RECORD_BILLS_ID` FOREIGN KEY (`bill_id`) REFERENCES `bills` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `person` (
  `personId` bigint(20) NOT NULL AUTO_INCREMENT,
  `personName` varchar(255) DEFAULT NULL,
  `personAge` int(11) DEFAULT NULL,
  `personSex` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`personId`)
) ENGINE=InnoDB AUTO_INCREMENT=150 DEFAULT CHARSET=utf8;

CREATE TABLE `t_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `permissionname` varchar(32) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

CREATE TABLE `t_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rolename` varchar(32) DEFAULT NULL,
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

CREATE TABLE `t_user_role` (
  `user_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `users` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) NOT NULL,
  `AGE` varchar(45) NOT NULL,
  `BALANCE` double NOT NULL,
  `is_delete` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;




