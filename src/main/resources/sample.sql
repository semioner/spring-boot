CREATE TABLE `t_user` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `use_type` tinyint NOT NULL COMMENT '用户类型 1:个人,2:企业',
  `user_name` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '姓名',
  `phone` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '电话',
  `created_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modified_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户表';
