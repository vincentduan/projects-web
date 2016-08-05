/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50518
Source Host           : localhost:3306
Source Database       : zhongchou

Target Server Type    : MYSQL
Target Server Version : 50518
File Encoding         : 65001

Date: 2016-01-12 14:11:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_d_message
-- ----------------------------
DROP TABLE IF EXISTS `tb_d_message`;
CREATE TABLE `tb_d_message` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `FROMUSERNAME` varchar(64) DEFAULT NULL COMMENT '发消息人，系统UISERID',
  `ISALL` tinyint(4) DEFAULT NULL,
  `TITLE` varchar(50) DEFAULT NULL COMMENT '标题',
  `CONTENT` longtext COMMENT '内容',
  `URL` varchar(200) DEFAULT NULL COMMENT 'URL,图文消息',
  `EXTFILE` varchar(200) DEFAULT NULL COMMENT '附件,地址',
  `REMARKS` varchar(200) DEFAULT NULL COMMENT '备注',
  `DELMARK` int(4) NOT NULL DEFAULT '0' COMMENT '删除标记，0：存在，1：删除',
  `CREATETIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATEUSERID` int(11) DEFAULT NULL COMMENT '创建人',
  `MODIFYTIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '修改时间',
  `MODIFYUSERID` int(11) DEFAULT NULL COMMENT '修改人',
  `ALLOWCOMMENT` tinyint(4) DEFAULT NULL COMMENT '是否允许评论,0:否,1:是',
  `ALLOWWATERMARK` tinyint(4) DEFAULT NULL COMMENT '是否添加水印,0:否,1:是',
  `ALLOWSHARE` tinyint(4) DEFAULT NULL COMMENT '是否允许分享,0:否,1:是',
  `ALLOWMASS` tinyint(4) DEFAULT NULL COMMENT '群发提醒,0:否,1:是',
  `ALLOWONTIME` tinyint(4) DEFAULT NULL COMMENT '是否开启定时,0:否,1:是',
  `ONTIME` timestamp NULL DEFAULT NULL COMMENT '预约发送时间[定时]',
  `STATUS` tinyint(4) DEFAULT NULL COMMENT '状态,0:草稿,1:已发送,2:已作废',
  `KINDSID` int(11) DEFAULT NULL COMMENT '分类ID,目前我的猜测这个是[标签]',
  `ALLOWSHOW` tinyint(4) DEFAULT NULL COMMENT '是否显示,0:否,1:是',
  `AGREECOUNT` int(11) DEFAULT NULL COMMENT '赞成数[点赞]',
  `MSG_TYPE` varchar(16) DEFAULT NULL COMMENT '消息类型',
  `AGENT_ID` varchar(16) DEFAULT NULL COMMENT '微信应用ID',
  `TO_USER` varchar(17000) DEFAULT NULL COMMENT '用户ID列表',
  `TO_PARTY` varchar(512) DEFAULT NULL COMMENT '部门ID列表',
  `TO_TAG` varchar(512) DEFAULT NULL COMMENT '标签ID列表',
  `PIC_URL` varchar(512) DEFAULT NULL COMMENT '图文消息对应的图片URL',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='公告消息表';
