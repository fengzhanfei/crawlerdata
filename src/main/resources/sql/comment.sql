/*
Navicat MySQL Data Transfer

Source Server         : 本地数据库
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : xiechengcourse

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2018-11-07 13:34:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(12) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `user_id` varchar(100) DEFAULT NULL COMMENT '用户id',
  `user_type` varchar(100) DEFAULT NULL COMMENT '用户类型',
  `score` varchar(20) DEFAULT NULL COMMENT '用户评分',
  `comment_info` text COMMENT '用户评论详细内容',
  `comment_tips` datetime DEFAULT NULL COMMENT '评论时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=141 DEFAULT CHARSET=utf8mb4;
