/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50518
Source Host           : localhost:3306
Source Database       : zhongchou

Target Server Type    : MYSQL
Target Server Version : 50518
File Encoding         : 65001

Date: 2016-01-12 14:11:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_d_message_receiver
-- ----------------------------
DROP TABLE IF EXISTS `tb_d_message_receiver`;
CREATE TABLE `tb_d_message_receiver` (
  `ID` bigint(11) NOT NULL AUTO_INCREMENT,
  `MESSAGEID` int(11) DEFAULT NULL,
  `RECEIVERUSERNAME` varchar(64) DEFAULT NULL,
  `ISSEND` int(4) DEFAULT NULL COMMENT '是否已发送，0：草稿，1：发送失败，2：已发送',
  `SENDTIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '发送时间',
  `ISREAD` int(4) DEFAULT NULL COMMENT '是否已阅读，0：未阅读，1：已阅读',
  `READTIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '阅读时间',
  `REMARKS` varchar(200) DEFAULT NULL COMMENT '备注',
  `DELMARK` int(4) NOT NULL DEFAULT '0' COMMENT '删除标记，0：存在，1：删除',
  `CREATETIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `CREATEUSERID` int(11) DEFAULT NULL COMMENT '创建人',
  `MODIFYTIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '修改时间',
  `MODIFYUSERID` int(11) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='公告消息接收者';
