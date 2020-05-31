/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1_mysql
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : 127.0.0.1:3306
 Source Schema         : display

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 31/05/2020 22:06:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_corp
-- ----------------------------
DROP TABLE IF EXISTS `t_corp`;
CREATE TABLE `t_corp` (
  `c_id` varchar(32) NOT NULL COMMENT '主键',
  `c_name` varchar(30) DEFAULT NULL COMMENT '名称',
  `n_age` int(255) DEFAULT NULL COMMENT '年龄',
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
