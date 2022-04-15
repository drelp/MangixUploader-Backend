SET NAMES utf8mb4;
use mangix;

-- drop table if exists file;

CREATE TABLE `file` (
    `file_id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `app_id` varchar(64) NOT NULL DEFAULT '' COMMENT 'app_id',
    `app_file_id` varchar(64) NOT NULL DEFAULT '' COMMENT 'app_file_id',
    `file_name` varchar(64) NOT NULL DEFAULT '' COMMENT '文件名称',
    `md5` varchar(32) NOT NULL DEFAULT '' COMMENT 'md5',
    `path` varchar(256) NOT NULL DEFAULT '' COMMENT 'path',
    `upload_time` int NOT NULL DEFAULT '0' COMMENT '更新时间',
    `status` tinyint NOT NULL DEFAULT '0' COMMENT '状态 -1-删除 1-正常',
    `operator_id` int NOT NULL DEFAULT '0' COMMENT '操作人ID',
    `operator` varchar(20) NOT NULL DEFAULT '' COMMENT '操作人 记录操作人用户名，程序自动执行时记system',
    `comment` varchar(100) NOT NULL DEFAULT '' COMMENT '备注(如：基站描述)',
    `create_time` int NOT NULL DEFAULT '0' COMMENT '创建时间',
    `update_time` int NOT NULL DEFAULT '0' COMMENT '更新时间',
    PRIMARY KEY (`file_id`),
    UNIQUE KEY `idx_mobile` (`app_id`, `app_file_id`),
    KEY `idx_file_name` (`file_name`),
    KEY `idx_st_ct` (`status`,`create_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='file';