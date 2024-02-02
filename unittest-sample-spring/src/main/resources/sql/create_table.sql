DROP TABLE IF EXISTS action;
CREATE TABLE action (
  `id` int(10)  NOT NULL AUTO_INCREMENT COMMENT '行为Id,自增主键',
  `user_id` bigint(20) NOT NULL DEFAULT '' COMMENT '用户ID',
  `action_type` int(10) NOT NULL COMMENT '行为类型',
  `title` varchar(100)   DEFAULT '' COMMENT '名称',
  `description` varchar(100)   DEFAULT '' COMMENT '描述',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='行为表'