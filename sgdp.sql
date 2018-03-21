/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50715
Source Host           : localhost:3306
Source Database       : sgdp

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2018-03-22 00:08:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_org
-- ----------------------------
DROP TABLE IF EXISTS `sys_org`;
CREATE TABLE `sys_org` (
  `orgid` varchar(36) NOT NULL,
  `orgname` varchar(50) DEFAULT NULL,
  `orgcode` varchar(20) DEFAULT NULL,
  `orgtype` int(1) DEFAULT NULL,
  `parentorgid` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`orgid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sys_org
-- ----------------------------

-- ----------------------------
-- Table structure for sys_resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_resource`;
CREATE TABLE `sys_resource` (
  `resourceid` varchar(36) NOT NULL,
  `resourcename` varchar(50) DEFAULT NULL,
  `resourcecode` varchar(50) DEFAULT NULL,
  `resourcepath` varchar(200) DEFAULT NULL,
  `resourcetype` int(1) DEFAULT NULL,
  `resourcesymbol` varchar(100) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `parentresourceid` varchar(36) DEFAULT NULL,
  `resourceicon` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`resourceid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sys_resource
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `roleid` varchar(36) NOT NULL,
  `rolename` varchar(50) DEFAULT NULL,
  `mark` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`roleid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sys_role
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role_resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_resource`;
CREATE TABLE `sys_role_resource` (
  `id` varchar(36) NOT NULL,
  `roleid` varchar(36) DEFAULT NULL,
  `resourceid` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sys_role_resource
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `userid` varchar(36) NOT NULL,
  `username` varchar(50) DEFAULT NULL,
  `usercode` varchar(50) DEFAULT NULL,
  `password` varchar(36) DEFAULT NULL,
  `orgid` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('146af582-0331-4e89-aaf1-e0387261a53d', 'admin', 'admin', 'admin', 'admin');
INSERT INTO `sys_user` VALUES ('31e25a59-cc31-43bd-8d52-dee9e1d31425', 'ls', 'ls', '1234', 'ls');
INSERT INTO `sys_user` VALUES ('96218cd9-a3aa-4b6d-adef-d3fbd294c485', 'zhangqiang', 'zq', '1234', 'za');
INSERT INTO `sys_user` VALUES ('b552af7e-70ed-4c77-ae50-feb8fe1ce991', 'sdfsdfsd', 'sdfsdfsd', 'fsdfsdf', 'fsdfsdf');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` varchar(36) NOT NULL,
  `userid` varchar(36) DEFAULT NULL,
  `roleid` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
