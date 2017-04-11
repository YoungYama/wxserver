/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50515
Source Host           : localhost:3306
Source Database       : wxserver

Target Server Type    : MYSQL
Target Server Version : 50515
File Encoding         : 65001

Date: 2017-04-07 18:55:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for log_type
-- ----------------------------
DROP TABLE IF EXISTS `log_type`;
CREATE TABLE `log_type` (
  `log_type_id` int(11) NOT NULL COMMENT '日志类型ID',
  `name` varchar(20) DEFAULT NULL COMMENT '日志类型名',
  PRIMARY KEY (`log_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of log_type
-- ----------------------------
INSERT INTO `log_type` VALUES ('0', '异常');
INSERT INTO `log_type` VALUES ('1', '添加');
INSERT INTO `log_type` VALUES ('2', '删除');
INSERT INTO `log_type` VALUES ('3', '修改');
INSERT INTO `log_type` VALUES ('4', '查询');

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `sys_log_id` varchar(50) NOT NULL COMMENT '日志ID',
  `log_type_id` int(1) DEFAULT NULL COMMENT '日志类型ID',
  `sys_user_id` varchar(50) DEFAULT NULL COMMENT 'c操作记录对应的用户ID',
  `wx_public_account_id` varchar(50) DEFAULT NULL COMMENT '所属公账号ID',
  `model_type_name` varchar(20) DEFAULT NULL COMMENT '操作所属模块',
  `operation_content` varchar(255) DEFAULT NULL COMMENT '用户具体操作内容',
  `operation_class_name` varchar(100) DEFAULT NULL COMMENT '调用类名',
  `operation_method_name` varchar(50) DEFAULT NULL COMMENT '调用方法名',
  `operation_time` varchar(20) DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`sys_log_id`),
  KEY `log2user` (`sys_user_id`),
  CONSTRAINT `log2user` FOREIGN KEY (`sys_user_id`) REFERENCES `sys_user` (`sys_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_log
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `sys_user_id` varchar(50) NOT NULL COMMENT '系统用户编号',
  `wx_public_account_id` varchar(50) DEFAULT NULL COMMENT '所属公账号ID',
  `sys_user_name` varchar(20) DEFAULT NULL COMMENT '系统用户名',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  `head_url` varchar(255) DEFAULT NULL COMMENT '头像路径',
  `email` varchar(50) DEFAULT NULL COMMENT '电子邮件',
  `tel` varchar(20) DEFAULT NULL COMMENT '电话',
  `register_time` varchar(20) DEFAULT '' COMMENT '注册时间',
  `sys_user_role` int(1) DEFAULT '2' COMMENT '角色：0：系统管理员；1：系统员工；2：系统用户',
  PRIMARY KEY (`sys_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('6784a1e7-425a-47e9-8b70-4363416bb00f-1483702770271', null, '杨志钊', '10470c3b4b1fed12c3baac014be15fac67c6e815', '../../resources/img/userLogo.jpg', '', '', '2017-01-16 10:52:01', '1');
INSERT INTO `sys_user` VALUES ('6784a1e7-425a-47e9-8b70-4363416bb00f-1483702770272', null, '杨志钊', '10470c3b4b1fed12c3baac014be15fac67c6e815', '../../resources/img/userLogo.jpg', '', '', '2017-01-16 10:52:01', '1');
INSERT INTO `sys_user` VALUES ('99e65b98-3fef-4814-91b2-0afda8bca079-1491291441412', null, '杨志钊', '10470c3b4b1fed12c3baac014be15fac67c6e815', null, null, null, null, null);

-- ----------------------------
-- Table structure for wx_news
-- ----------------------------
DROP TABLE IF EXISTS `wx_news`;
CREATE TABLE `wx_news` (
  `wx_news_id` varchar(50) NOT NULL COMMENT '图文ID',
  `sys_user_id` varchar(50) NOT NULL COMMENT '系统用户编号',
  `wx_public_account_id` varchar(50) DEFAULT NULL COMMENT '所属公账号ID',
  `media_id` varchar(200) DEFAULT NULL COMMENT '媒体文件上传后，获取的标识',
  `title` varchar(100) DEFAULT NULL COMMENT '图文消息的标题',
  `thumb_media_id` varchar(200) DEFAULT NULL COMMENT '图文消息的封面图片素材id（必须是永久mediaID）',
  `show_cover_pic` varchar(1) DEFAULT NULL COMMENT '是否显示封面，0为false，即不显示，1为true，即显示',
  `author` varchar(20) DEFAULT NULL COMMENT '作者',
  `digest` varchar(255) DEFAULT NULL COMMENT '图文消息的摘要，仅有单图文消息才有摘要，多图文此处为空',
  `content` text COMMENT '图文消息的具体内容，支持HTML标签，必须少于2万字符，小于1M，且此处会去除JS',
  `url` varchar(255) DEFAULT NULL COMMENT '图文页的URL，或者，当获取的列表是图片素材列表时，该字段是图片的URL',
  `content_source_url` varchar(255) DEFAULT NULL COMMENT '图文消息的原文地址，即点击“阅读原文”后的URL',
  `update_time` varchar(20) DEFAULT NULL COMMENT '这篇图文消息素材的最后更新时间',
  `create_time` varchar(20) DEFAULT NULL COMMENT '这篇图文消息素材的创建时间',
  PRIMARY KEY (`wx_news_id`),
  KEY `news2user` (`sys_user_id`),
  CONSTRAINT `news2user` FOREIGN KEY (`sys_user_id`) REFERENCES `sys_user` (`sys_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wx_news
-- ----------------------------
INSERT INTO `wx_news` VALUES ('6784a1e7-425a-47e9-8b70-4363416bb00f-1483702770270', '6784a1e7-425a-47e9-8b70-4363416bb00f-1483702770271', null, null, null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for wx_public_account
-- ----------------------------
DROP TABLE IF EXISTS `wx_public_account`;
CREATE TABLE `wx_public_account` (
  `wx_public_account_id` varchar(50) NOT NULL,
  PRIMARY KEY (`wx_public_account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wx_public_account
-- ----------------------------
