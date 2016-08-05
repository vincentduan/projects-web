/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.6.29 : Database - efubao_order
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`efubao_order` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `efubao_order`;

/*Table structure for table `base_order` */

DROP TABLE IF EXISTS `base_order`;

CREATE TABLE `base_order` (
  `order_no` varchar(30) NOT NULL COMMENT '订单号',
  `status` int(11) DEFAULT '100' COMMENT '订单状态:100-发布需求;110-管家受理;120-选择服务商;125-中标录合同;130-付订金;140-上门量体;150-生产制作;160-付尾款;170-待发货;180-待签收;190-已签收;200-交易完成;210-取消订单',
  `type` int(11) DEFAULT '10' COMMENT '订单类型:10-量体订单;20-商品订单',
  `sp_id` bigint(20) unsigned DEFAULT NULL COMMENT '服务商ID',
  `customer_id` bigint(20) unsigned DEFAULT NULL COMMENT '用户ID',
  `order_contract_id` bigint(20) unsigned DEFAULT NULL COMMENT '订单合同表ID',
  `total_money` decimal(10,2) DEFAULT NULL COMMENT '订单总金额',
  `quality_deposit` decimal(10,2) DEFAULT NULL COMMENT '质保金',
  `credit_deposit` decimal(10,2) DEFAULT NULL COMMENT '履约保证金',
  `front_money` decimal(10,2) DEFAULT NULL COMMENT '订金',
  `balance_payment` decimal(10,2) DEFAULT NULL COMMENT '尾款',
  `remarks` varchar(500) DEFAULT NULL COMMENT '备注信息',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_del` tinyint(1) DEFAULT '0' COMMENT '删除标记0-正常订单状态，1-删除订单状态',
  PRIMARY KEY (`order_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单表';

/*Data for the table `base_order` */

insert  into `base_order`(`order_no`,`status`,`type`,`sp_id`,`customer_id`,`order_contract_id`,`total_money`,`quality_deposit`,`credit_deposit`,`front_money`,`balance_payment`,`remarks`,`create_time`,`update_time`,`is_del`) values ('101457772570783380',120,10,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2016-03-12 03:49:30','2016-03-12 05:01:44',0),('101457777651701352',100,10,NULL,NULL,NULL,NULL,NULL,NULL,10.00,NULL,NULL,'2016-03-12 05:14:11','2016-03-12 05:35:40',0),('1324247',180,10,6,NULL,NULL,99.00,NULL,NULL,7.00,NULL,NULL,'2016-03-11 05:25:26','2016-03-12 01:09:38',0),('1862332',200,10,1,NULL,NULL,88.00,NULL,NULL,9.00,NULL,NULL,'2016-03-11 05:07:11','2016-03-12 01:09:37',0),('1918410',110,10,1,NULL,NULL,77.00,NULL,NULL,7.00,2.00,NULL,'2016-03-11 03:37:04','2016-03-12 01:09:46',0),('2016104',100,10,NULL,NULL,NULL,66.00,NULL,NULL,6.00,NULL,NULL,'2016-03-11 04:51:24','2016-03-12 01:09:47',0),('2134872',160,10,8,NULL,NULL,55.00,NULL,NULL,5.00,NULL,NULL,'2016-03-11 04:48:41','2016-03-12 01:09:48',0),('2435067',140,10,1,NULL,NULL,44.00,NULL,NULL,4.00,NULL,NULL,'2016-03-11 02:53:29','2016-03-12 01:09:49',0),('3004100',100,10,NULL,NULL,NULL,33.00,NULL,NULL,8.00,NULL,NULL,'2016-03-11 22:36:07','2016-03-12 01:09:51',0),('3014963',120,10,NULL,NULL,NULL,22.00,NULL,NULL,92.00,NULL,NULL,'2016-03-11 02:53:21','2016-03-12 01:09:51',0),('3118167',100,10,NULL,NULL,NULL,11.00,NULL,NULL,1.00,NULL,NULL,'2016-03-11 07:02:24','2016-03-12 01:09:54',0),('3209262',170,10,3,NULL,NULL,1.00,NULL,NULL,0.10,NULL,NULL,'2016-03-11 02:52:56','2016-03-11 06:51:17',0),('3802551',130,10,9,NULL,NULL,10.00,NULL,NULL,9.00,NULL,NULL,'2016-03-11 07:33:21','2016-03-12 05:45:37',0),('4034538',100,10,NULL,NULL,NULL,65.00,NULL,NULL,62.00,NULL,NULL,'2016-03-11 22:56:53','2016-03-12 01:09:58',0),('4704046',100,10,NULL,NULL,NULL,32.00,NULL,NULL,21.00,NULL,NULL,'2016-03-11 05:22:49','2016-03-12 01:09:59',0),('5011389',100,10,NULL,NULL,NULL,64.00,NULL,NULL,11.00,NULL,NULL,'2016-03-11 06:54:04','2016-03-12 01:10:01',0),('5028656',100,10,NULL,NULL,NULL,989.00,NULL,NULL,50.00,NULL,NULL,'2016-03-11 08:53:10','2016-03-12 01:10:03',0),('5074995',100,10,NULL,NULL,NULL,56.00,NULL,NULL,40.00,NULL,NULL,'2016-03-11 21:15:50','2016-03-12 01:10:05',0),('5501374',100,10,NULL,NULL,NULL,12.00,NULL,NULL,11.00,NULL,NULL,'2016-03-11 21:10:56','2016-03-12 01:10:06',0),('5613329',100,10,NULL,NULL,NULL,5454.00,NULL,NULL,5.00,NULL,NULL,'2016-03-11 07:42:28','2016-03-12 01:10:08',0),('5944425',210,10,1,NULL,NULL,6569.00,NULL,NULL,78.00,NULL,NULL,'2016-03-11 02:53:11','2016-03-12 01:10:10',0),('7254781',140,10,4,NULL,NULL,64548.00,NULL,NULL,96.00,NULL,NULL,'2016-03-11 03:34:50','2016-03-12 03:11:44',0),('7310717',100,10,NULL,NULL,NULL,9566.00,NULL,NULL,94.00,NULL,NULL,'2016-03-11 05:40:09','2016-03-12 01:10:14',0),('7525985',130,10,NULL,NULL,NULL,16512565.00,NULL,NULL,33.00,NULL,NULL,'2016-03-11 07:19:52','2016-03-12 03:14:02',0),('7745087',100,10,NULL,NULL,NULL,66.00,NULL,NULL,2.00,NULL,NULL,'2016-03-11 21:14:36','2016-03-12 01:10:18',0),('7800031',100,10,NULL,NULL,NULL,6.00,NULL,NULL,1.00,NULL,NULL,'2016-03-11 21:08:45','2016-03-12 01:10:21',0),('7953522',100,10,NULL,NULL,NULL,6.00,NULL,NULL,2.00,NULL,NULL,'2016-03-11 07:05:14','2016-03-12 01:10:23',0),('8297781',160,10,7,NULL,NULL,6.00,NULL,NULL,4.00,NULL,NULL,'2016-03-11 04:47:42','2016-03-12 01:10:24',0),('8459913',130,10,NULL,NULL,NULL,6565.00,NULL,NULL,484.00,NULL,NULL,'2016-03-11 08:22:25','2016-03-12 03:14:02',0),('8706283',100,10,NULL,NULL,NULL,64.00,NULL,NULL,62.00,NULL,NULL,'2016-03-11 23:32:04','2016-03-12 01:10:28',0),('8787908',130,10,6,NULL,NULL,4.00,NULL,NULL,2.00,NULL,NULL,'2016-03-11 05:09:59','2016-03-12 05:13:30',0),('9022373',100,10,NULL,NULL,NULL,848.00,NULL,NULL,448.00,NULL,NULL,'2016-03-11 08:22:37','2016-03-12 01:10:33',0),('9371275',100,10,NULL,NULL,NULL,8945.00,NULL,NULL,954.00,NULL,NULL,'2016-03-11 04:57:03','2016-03-12 01:10:35',0),('972456',100,10,NULL,NULL,NULL,95.00,NULL,NULL,91.00,NULL,NULL,'2016-03-11 05:21:34','2016-03-12 01:10:37',0);

/*Table structure for table `measure_goods` */

DROP TABLE IF EXISTS `measure_goods`;

CREATE TABLE `measure_goods` (
  `ID` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '量体商品ID',
  `measure_order_no` varchar(30) DEFAULT NULL COMMENT '量体订单号',
  `goods_name` varchar(50) DEFAULT NULL COMMENT '商品名称',
  `goods_num` int(11) DEFAULT NULL COMMENT '商品数量',
  `goods_sku_id` bigint(20) unsigned DEFAULT NULL COMMENT '商品SKU',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `is_del` tinyint(1) DEFAULT '0',
  `first_image_path` varchar(200) DEFAULT NULL COMMENT '首图图片路径',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='量体商品表';

/*Data for the table `measure_goods` */

/*Table structure for table `measure_info` */

DROP TABLE IF EXISTS `measure_info`;

CREATE TABLE `measure_info` (
  `ID` bigint(20) unsigned NOT NULL,
  `name` varchar(45) DEFAULT NULL COMMENT '被量体人姓名',
  `gender` int(11) DEFAULT NULL COMMENT '性别:1-男;2-女',
  `phone` varchar(45) DEFAULT NULL COMMENT '被量体人电话',
  `department` varchar(200) DEFAULT NULL COMMENT '部门',
  `measure_order_no` varchar(30) DEFAULT NULL COMMENT '量体订单号',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '录入时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_del` tinyint(1) DEFAULT '0',
  `remarks` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='量体信息表';

/*Data for the table `measure_info` */

/*Table structure for table `measure_info_property` */

DROP TABLE IF EXISTS `measure_info_property`;

CREATE TABLE `measure_info_property` (
  `ID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `measure_info_id` bigint(20) unsigned DEFAULT NULL COMMENT '量体信息ID',
  `measure_property` varchar(45) DEFAULT NULL COMMENT '量体属性',
  `measure_property_value` varchar(45) DEFAULT NULL COMMENT '量体属性值',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_del` tinyint(1) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='量体信息扩展表';

/*Data for the table `measure_info_property` */

/*Table structure for table `measure_order` */

DROP TABLE IF EXISTS `measure_order`;

CREATE TABLE `measure_order` (
  `measure_order_no` varchar(30) NOT NULL,
  `measure_master_id` bigint(20) DEFAULT NULL COMMENT '量体师Id',
  `order_no` varchar(30) DEFAULT NULL COMMENT '订单号',
  `source` int(11) DEFAULT '1' COMMENT '量体订单来源:1-efubao',
  `status` int(11) DEFAULT '1' COMMENT '状态1:待量体2:量体中3:量体完成',
  `remarks` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_del` tinyint(1) DEFAULT '0' COMMENT '是否删除',
  `measure_num` int(11) DEFAULT NULL COMMENT '量体数据',
  PRIMARY KEY (`measure_order_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='量体订单';

/*Data for the table `measure_order` */

/*Table structure for table `measure_order_address` */

DROP TABLE IF EXISTS `measure_order_address`;

CREATE TABLE `measure_order_address` (
  `ID` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '量体地址Id',
  `measure_order_no` varchar(30) DEFAULT NULL COMMENT '量体订单号',
  `contacts` varchar(45) DEFAULT NULL COMMENT '联系人',
  `contract_phone` varchar(45) DEFAULT NULL COMMENT '联系电话',
  `city_ids` varchar(20) DEFAULT NULL COMMENT '地址编码',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `address_detail` varchar(45) DEFAULT NULL COMMENT '详细地址',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_del` tinyint(1) DEFAULT '0' COMMENT '删除标记0:正常1:删除',
  `remarks` varchar(500) CHARACTER SET latin1 DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `measure_order_address` */

/*Table structure for table `measure_order_property` */

DROP TABLE IF EXISTS `measure_order_property`;

CREATE TABLE `measure_order_property` (
  `ID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `measure_order_no` varchar(30) DEFAULT NULL COMMENT '量体订单号',
  `measure_property` varchar(45) DEFAULT NULL COMMENT '量体属性',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_del` tinyint(1) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='量体订单属性表';

/*Data for the table `measure_order_property` */

/*Table structure for table `measure_order_status_stream` */

DROP TABLE IF EXISTS `measure_order_status_stream`;

CREATE TABLE `measure_order_status_stream` (
  `ID` bigint(20) unsigned NOT NULL,
  `measure_order_no` varchar(30) DEFAULT NULL COMMENT '量体订单号',
  `status` int(11) DEFAULT NULL COMMENT '量体订单状态',
  `finish_time` timestamp NULL DEFAULT NULL COMMENT '状态完成时间',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_del` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `measure_order_status_stream` */

/*Table structure for table `order_contract` */

DROP TABLE IF EXISTS `order_contract`;

CREATE TABLE `order_contract` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单合同ID',
  `sp_id` bigint(20) unsigned DEFAULT NULL COMMENT '供应商ID',
  `make_days` int(11) DEFAULT NULL COMMENT '生产天数',
  `custom_cycle` int(11) DEFAULT NULL COMMENT '定制周期',
  `custom_money` decimal(2,0) DEFAULT NULL COMMENT '定制金额',
  `custom_category` varchar(45) DEFAULT NULL COMMENT '定制品类',
  `custom_property` varchar(45) DEFAULT NULL COMMENT '定制属性',
  `valid_start_date` datetime DEFAULT NULL COMMENT '合同有效开始日期',
  `valid_end_date` datetime DEFAULT NULL COMMENT '合同有效结束日期',
  `total_money` decimal(10,2) DEFAULT NULL COMMENT '订单总费用',
  `front_money` decimal(10,2) DEFAULT NULL COMMENT '订金',
  `quality_deposit` decimal(10,2) DEFAULT NULL COMMENT '质保金',
  `credit_deposit` decimal(10,2) DEFAULT NULL COMMENT '履约保证金',
  `commission` decimal(10,2) DEFAULT NULL COMMENT '平台佣金',
  `balance_payment` decimal(10,2) DEFAULT NULL COMMENT '尾款',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_del` tinyint(1) DEFAULT '0' COMMENT '是否删除',
  `is_customer_agree` tinyint(1) DEFAULT NULL COMMENT '客户是否同意合同',
  `measure_num` int(11) DEFAULT NULL COMMENT '量体数据',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单合同表';

/*Data for the table `order_contract` */

/*Table structure for table `order_contract_goods` */

DROP TABLE IF EXISTS `order_contract_goods`;

CREATE TABLE `order_contract_goods` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `goods_sku_id` bigint(20) unsigned DEFAULT NULL COMMENT '商品SKU_ID',
  `goods_num` int(11) DEFAULT NULL COMMENT '商品数量',
  `goods_name` varchar(200) DEFAULT NULL COMMENT '商品名称',
  `order_contract_id` bigint(20) DEFAULT NULL COMMENT '订单合同ID',
  `goods_price` decimal(10,2) DEFAULT NULL COMMENT '商品单价',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_del` tinyint(1) DEFAULT '0' COMMENT '是否删除',
  `attribute_ids` varchar(200) DEFAULT NULL COMMENT '属性IDs',
  `attribute_names` varchar(200) DEFAULT NULL COMMENT '属性名称s',
  `attribute_value_ids` varchar(200) DEFAULT NULL COMMENT '属性值IDs',
  `attribute_value_names` varchar(200) DEFAULT NULL COMMENT '属性值名称s',
  `first_image_path` varchar(200) DEFAULT NULL COMMENT '首图图片路径',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单合同商品表';

/*Data for the table `order_contract_goods` */

/*Table structure for table `order_custom_demand` */

DROP TABLE IF EXISTS `order_custom_demand`;

CREATE TABLE `order_custom_demand` (
  `ID` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '订单客户定制需求表ID',
  `order_no` varchar(30) DEFAULT NULL COMMENT '订单号',
  `category_id` bigint(20) DEFAULT NULL COMMENT '品类ID',
  `category_name` varchar(50) DEFAULT NULL COMMENT '品类名称',
  `custom_num` int(11) DEFAULT NULL COMMENT '定制数量',
  `custom_budget` decimal(10,2) DEFAULT NULL COMMENT '定制预算',
  `custom_cycle` int(11) DEFAULT NULL COMMENT '定制周期',
  `category_property` varchar(50) DEFAULT NULL COMMENT '定制属性',
  `sp_id` bigint(20) unsigned DEFAULT NULL COMMENT '意向服务商ID',
  `custom_type` int(11) DEFAULT '1' COMMENT '定制方式1:量体定制',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_del` tinyint(1) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8 COMMENT='订单客户定制需求表';

/*Data for the table `order_custom_demand` */

insert  into `order_custom_demand`(`ID`,`order_no`,`category_id`,`category_name`,`custom_num`,`custom_budget`,`custom_cycle`,`category_property`,`sp_id`,`custom_type`,`create_time`,`update_time`,`is_del`) values (23,'3209262',3,'西服正装',11,2000.00,15,'如面料属性、颜色、版号等',1,1,'2016-03-11 02:52:56','2016-03-11 23:26:15',0),(24,'5944425',4,'防寒服',20,NULL,NULL,NULL,1,1,'2016-03-11 02:53:11','2016-03-11 04:19:55',0),(25,'3014963',5,'大衣外套',30,301.00,16,'如面料属性、颜色、版号等',1,1,'2016-03-11 02:53:22','2016-03-12 06:26:56',0),(26,'2435067',3,'西服正装',200,2000.00,15,'如面料属性、颜色、版号等',1,1,'2016-03-11 02:53:29','2016-03-12 01:06:13',0),(27,'7254781',5,'大衣外套',50,NULL,NULL,NULL,1,1,'2016-03-11 03:34:50','2016-03-11 04:19:55',0),(28,'1918410',3,'西服正装',60,NULL,NULL,NULL,1,1,'2016-03-11 03:37:04','2016-03-11 04:19:55',0),(29,'8297781',5,'大衣外套',10,NULL,NULL,NULL,NULL,1,'2016-03-11 04:47:42','2016-03-11 08:44:22',0),(30,'2134872',3,'西服正装',10,NULL,NULL,NULL,NULL,1,'2016-03-11 04:48:41','2016-03-11 08:44:23',0),(31,'2016104',4,'防寒服',10,NULL,NULL,NULL,NULL,1,'2016-03-11 04:51:24','2016-03-11 08:44:23',0),(32,'9371275',3,'西服正装',10,NULL,NULL,NULL,NULL,1,'2016-03-11 04:57:03','2016-03-11 08:44:24',0),(33,'1862332',3,'西服正装',10,NULL,NULL,NULL,NULL,1,'2016-03-11 05:07:11','2016-03-11 08:44:25',0),(34,'8787908',4,'防寒服',10,NULL,NULL,NULL,1,1,'2016-03-11 05:09:59','2016-03-11 08:44:26',0),(35,'972456',3,'西服正装',10,NULL,NULL,NULL,NULL,1,'2016-03-11 05:21:34','2016-03-11 08:44:26',0),(36,'4704046',4,'防寒服',10,NULL,NULL,NULL,NULL,1,'2016-03-11 05:22:49','2016-03-11 08:44:27',0),(37,'1324247',3,'西服正装',10,NULL,NULL,NULL,NULL,1,'2016-03-11 05:25:26','2016-03-11 08:44:28',0),(38,'7310717',3,'西服正装',200,2000.00,15,'。。。',NULL,1,'2016-03-11 05:40:09','2016-03-11 23:02:40',0),(39,'5011389',3,'西服正装',10,NULL,NULL,NULL,NULL,1,'2016-03-11 06:54:04','2016-03-11 08:44:30',0),(40,'3118167',4,'防寒服',10,NULL,NULL,NULL,NULL,1,'2016-03-11 07:02:24','2016-03-11 08:44:31',0),(41,'7953522',5,'大衣外套',10,NULL,NULL,NULL,NULL,1,'2016-03-11 07:05:14','2016-03-11 08:44:33',0),(42,'7525985',4,'防寒服',10,NULL,NULL,NULL,NULL,1,'2016-03-11 07:19:52','2016-03-11 08:44:34',0),(43,'3802551',3,'西服正装',10,NULL,NULL,NULL,NULL,1,'2016-03-11 07:33:21','2016-03-11 08:44:35',0),(44,'5613329',3,'西服正装',10,NULL,NULL,NULL,NULL,1,'2016-03-11 07:42:28','2016-03-11 08:44:36',0),(45,'9022373',4,'防寒服',10,NULL,NULL,NULL,NULL,1,'2016-03-11 08:22:37','2016-03-11 08:44:38',0),(46,'8459913',3,'西服正装',10,NULL,NULL,NULL,NULL,1,'2016-03-11 08:49:25','2016-03-11 08:52:50',0),(47,'5028656',3,'西服正装',7,NULL,NULL,NULL,NULL,1,'2016-03-11 08:53:10','2016-03-12 05:45:19',0),(48,'7800031',4,'防寒服',3,NULL,NULL,NULL,NULL,1,'2016-03-11 21:08:45','2016-03-12 05:45:22',0),(49,'5501374',4,'防寒服',26,NULL,NULL,NULL,NULL,1,'2016-03-11 21:10:56','2016-03-12 05:45:23',0),(50,'7745087',3,'西服正装',565,NULL,NULL,NULL,NULL,1,'2016-03-11 21:14:36','2016-03-12 05:45:24',0),(51,'5074995',3,'西服正装',126,50000.00,12,'...',NULL,1,'2016-03-11 21:15:50','2016-03-12 05:45:25',0),(52,'3004100',4,'防寒服',645,NULL,NULL,NULL,NULL,1,'2016-03-11 22:36:07','2016-03-12 05:45:26',0),(53,'4034538',3,'防寒服',200,50000.00,15,'如面料属性、颜色、版号等',NULL,1,'2016-03-11 22:56:53','2016-03-11 22:57:39',0),(54,'8706283',3,'西服正装',200,2000.00,15,'如面料属性、颜色、版号等',NULL,1,'2016-03-11 23:32:04','2016-03-11 23:38:55',0),(55,'101457772570783380',5,'大衣外套',98,NULL,NULL,NULL,NULL,1,'2016-03-12 03:49:30','2016-03-12 05:45:29',0),(56,'101457777651701352',10,'长袖衬衫',45,NULL,NULL,NULL,NULL,1,'2016-03-12 05:14:11','2016-03-12 05:45:32',0);

/*Table structure for table `order_custom_goods` */

DROP TABLE IF EXISTS `order_custom_goods`;

CREATE TABLE `order_custom_goods` (
  `ID` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '订单客户定制商品表ID',
  `goods_num` int(11) DEFAULT NULL COMMENT '商品数量',
  `goods_name` varchar(200) DEFAULT NULL COMMENT '商品名称',
  `goods_sku_id` bigint(20) unsigned DEFAULT NULL COMMENT '商品SKU_ID',
  `order_custom_demand_id` bigint(20) unsigned DEFAULT NULL COMMENT '订单客户定制需求表ID',
  `goods_price` decimal(10,2) DEFAULT NULL COMMENT '商品单价',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_del` tinyint(1) DEFAULT '0' COMMENT '是否删除',
  `attribute_ids` varchar(200) DEFAULT NULL COMMENT '属性IDs',
  `attribute_names` varchar(200) DEFAULT NULL COMMENT '属性名称s',
  `attribute_value_ids` varchar(200) DEFAULT NULL COMMENT '属性值IDs',
  `attribute_value_names` varchar(200) DEFAULT NULL COMMENT '属性值名称s',
  `first_image_path` varchar(200) DEFAULT NULL COMMENT '首图图片路径',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单客户定制商品表';

/*Data for the table `order_custom_goods` */

/*Table structure for table `order_customer_info` */

DROP TABLE IF EXISTS `order_customer_info`;

CREATE TABLE `order_customer_info` (
  `ID` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '订单客户信息表ID',
  `order_no` varchar(30) DEFAULT NULL COMMENT '订单号',
  `company_name` varchar(45) DEFAULT NULL COMMENT '企业名称',
  `custom_department` varchar(45) DEFAULT NULL COMMENT '定制部门',
  `recive_address_id` bigint(20) unsigned DEFAULT NULL COMMENT '收货地址ID',
  `bespeak_name` varchar(45) DEFAULT NULL COMMENT '预约姓名',
  `bespeak_phone` varchar(45) DEFAULT NULL COMMENT '预约电话',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_del` tinyint(1) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8 COMMENT='订单客户信息表';

/*Data for the table `order_customer_info` */

insert  into `order_customer_info`(`ID`,`order_no`,`company_name`,`custom_department`,`recive_address_id`,`bespeak_name`,`bespeak_phone`,`create_time`,`update_time`,`is_del`) values (23,'3209262','111','全部',NULL,'冯俊','18518758217','2016-03-11 02:52:56','2016-03-11 02:58:28',0),(24,'5944425','111','全部',NULL,'小红','18518758217','2016-03-11 02:53:11','2016-03-11 02:58:28',0),(25,'3014963','111','全部',NULL,'小花','18518758217','2016-03-11 02:53:22','2016-03-11 02:58:28',0),(26,'2435067','111','全部',25,'小白','18518758217','2016-03-11 02:53:29','2016-03-11 02:58:28',0),(27,'7254781',NULL,NULL,NULL,'小黑','18518758217','2016-03-11 03:34:50','2016-03-11 03:34:50',0),(28,'1918410','efubao','全部',NULL,'小黄','18518758217','2016-03-11 03:37:04','2016-03-11 03:43:14',0),(29,'8297781',NULL,NULL,NULL,'小红','18518758217','2016-03-11 04:47:42','2016-03-11 04:47:42',0),(30,'2134872',NULL,NULL,NULL,'冯俊','18518758217','2016-03-11 04:48:41','2016-03-11 04:48:41',0),(31,'2016104',NULL,NULL,NULL,'小白','18518758217','2016-03-11 04:51:24','2016-03-11 04:51:24',0),(32,'9371275',NULL,NULL,NULL,'小黑','18518758217','2016-03-11 04:57:03','2016-03-11 04:57:03',0),(33,'1862332',NULL,NULL,NULL,'小红','18518758217','2016-03-11 05:07:11','2016-03-11 05:07:11',0),(34,'8787908',NULL,NULL,NULL,'小黑','18518758217','2016-03-11 05:09:59','2016-03-11 05:09:59',0),(35,'972456',NULL,NULL,NULL,'小花','18518758217','2016-03-11 05:21:34','2016-03-11 05:21:34',0),(36,'4704046',NULL,NULL,NULL,'风','18518758217','2016-03-11 05:22:49','2016-03-11 05:22:49',0),(37,'1324247',NULL,NULL,NULL,'小子','18518758217','2016-03-11 05:25:26','2016-03-11 05:25:26',0),(38,'7310717','efubao','技术部',23,'小花','18518758217','2016-03-11 05:40:09','2016-03-11 06:15:36',0),(39,'5011389',NULL,NULL,NULL,'小白','18518758217','2016-03-11 06:54:04','2016-03-11 06:54:04',0),(40,'3118167',NULL,NULL,NULL,'小柴','18518758217','2016-03-11 07:02:24','2016-03-11 07:02:24',0),(41,'7953522',NULL,NULL,NULL,'冯俊','18518758217','2016-03-11 07:05:14','2016-03-11 07:05:14',0),(42,'7525985',NULL,NULL,4,'小黑','18518758217','2016-03-11 07:19:52','2016-03-11 07:31:39',0),(43,'3802551',NULL,NULL,NULL,'小风','18518758217','2016-03-11 07:33:21','2016-03-11 07:33:21',0),(44,'5613329','efubao','全部',12,'小红','18518758217','2016-03-11 07:42:28','2016-03-11 07:42:28',0),(45,'9022373',NULL,NULL,NULL,'冯俊','18518758217','2016-03-11 08:22:37','2016-03-11 08:23:09',0),(46,'5028656','','',13,'段郎','18518758217','2016-03-11 08:53:10','2016-03-11 08:53:10',0),(47,'7800031',NULL,NULL,NULL,'小张','18518758217','2016-03-11 21:08:45','2016-03-11 21:08:45',0),(48,'5501374',NULL,NULL,NULL,'小张','18518758217','2016-03-11 21:10:56','2016-03-11 21:10:56',0),(49,'7745087',NULL,NULL,NULL,'小华','18518758217','2016-03-11 21:14:36','2016-03-11 21:14:36',0),(50,'5074995','efubao','全部',16,'小华','18518758217','2016-03-11 21:15:50','2016-03-11 21:15:50',0),(51,'3004100',NULL,NULL,NULL,'小白','18518758217','2016-03-11 22:36:07','2016-03-11 22:36:07',0),(52,'4034538','efubao','技术部',21,'小兰','18518758217','2016-03-11 22:56:53','2016-03-11 22:56:53',0),(53,'8706283','efubao','技术部',24,'小李','18518758217','2016-03-11 23:32:04','2016-03-11 23:32:04',0),(54,'101457772570783380',NULL,NULL,NULL,'冯俊','18518758217','2016-03-12 03:49:30','2016-03-12 03:49:30',0),(55,'101457777651701352',NULL,NULL,NULL,'小黑','18518758217','2016-03-12 05:14:11','2016-03-12 05:14:11',0);

/*Table structure for table `order_measure_address` */

DROP TABLE IF EXISTS `order_measure_address`;

CREATE TABLE `order_measure_address` (
  `ID` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '量体地址Id',
  `order_no` varchar(30) DEFAULT NULL COMMENT '订单ID',
  `contacts` varchar(45) DEFAULT NULL COMMENT '联系人',
  `contract_phone` varchar(45) DEFAULT NULL COMMENT '联系电话',
  `city_ids` varchar(20) DEFAULT NULL COMMENT '地址编码',
  `address_detail` varchar(200) DEFAULT NULL COMMENT '详细地址',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_del` tinyint(1) DEFAULT '0' COMMENT '删除标记0:正常1:删除',
  `remarks` varchar(500) CHARACTER SET latin1 DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COMMENT='量体地址表';

/*Data for the table `order_measure_address` */

insert  into `order_measure_address`(`ID`,`order_no`,`contacts`,`contract_phone`,`city_ids`,`address_detail`,`create_time`,`update_time`,`is_del`,`remarks`) values (6,'5613329','小红','18518758217',NULL,'左岸','2016-03-11 07:52:37','2016-03-11 07:52:37',0,NULL),(7,'5028656','段郎','18518758217',NULL,'','2016-03-11 09:00:33','2016-03-11 09:00:33',0,NULL),(8,'5074995','小华','18518758217',NULL,'清华大学','2016-03-11 22:18:32','2016-03-11 22:18:32',0,NULL),(9,'5074995','小华','18518758217',NULL,'','2016-03-11 22:23:17','2016-03-11 22:23:17',0,NULL),(10,'5074995','小华','18518758217',NULL,'','2016-03-11 22:27:58','2016-03-11 22:27:58',0,NULL),(11,'3014963','冯俊','18518758217',NULL,'清华大学','2016-03-11 22:34:38','2016-03-12 05:23:22',0,NULL),(12,'','冯俊','18518758217',NULL,'','2016-03-11 22:46:06','2016-03-11 22:46:06',0,NULL),(13,'','冯俊','18518758217',NULL,'','2016-03-11 22:51:30','2016-03-11 22:51:30',0,NULL),(14,'4034538','小兰','18518758217',NULL,'左岸','2016-03-11 22:57:04','2016-03-11 22:57:04',0,NULL),(15,'4034538','小兰','18518758217',NULL,'','2016-03-11 22:57:20','2016-03-11 22:57:20',0,NULL),(16,'7310717','小花','18518758217',NULL,'','2016-03-11 23:07:15','2016-03-11 23:07:15',0,NULL),(17,'7310717','小花','18518758217',NULL,'清华大学','2016-03-11 23:07:26','2016-03-11 23:07:26',0,NULL),(18,'8706283','小李','18518758217',NULL,'清华大学','2016-03-11 23:38:41','2016-03-11 23:38:41',0,NULL),(19,'2435067','小白','18518758217',NULL,'清华大学','2016-03-12 01:05:32','2016-03-12 01:05:32',0,NULL);

/*Table structure for table `order_payment` */

DROP TABLE IF EXISTS `order_payment`;

CREATE TABLE `order_payment` (
  `order_payment_no` varchar(30) NOT NULL COMMENT '支付流水号',
  `order_no` varchar(30) DEFAULT NULL COMMENT '订单名称',
  `thrid_payment_num` bigint(20) unsigned DEFAULT NULL COMMENT '第三方支付账单',
  `pay_type` int(11) DEFAULT NULL COMMENT '支付类型1:订金2:尾款',
  `pay_status` varchar(45) DEFAULT NULL COMMENT '支付状态1:支付完成2:支付失败3:待支付;4-已退款',
  `pay_money` decimal(10,2) DEFAULT NULL COMMENT '支付金额',
  `pay_way` int(11) DEFAULT '1' COMMENT '支付通路:1-易极付',
  `pay_finish_time` timestamp NULL DEFAULT NULL COMMENT '支付时间',
  `refund_finish_time` timestamp NULL DEFAULT NULL COMMENT '退款时间',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_del` tinyint(1) DEFAULT '0' COMMENT '是否删除',
  `remarks` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`order_payment_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单支付流水表';

/*Data for the table `order_payment` */

insert  into `order_payment`(`order_payment_no`,`order_no`,`thrid_payment_num`,`pay_type`,`pay_status`,`pay_money`,`pay_way`,`pay_finish_time`,`refund_finish_time`,`create_time`,`update_time`,`is_del`,`remarks`) values ('301457770304588806','7254781',NULL,1,'1',20.00,1,NULL,NULL,'2016-03-12 03:11:44','2016-03-12 03:11:44',0,NULL),('301457772933745131','8787908',NULL,1,'1',2.00,1,NULL,NULL,'2016-03-12 03:55:33','2016-03-12 03:55:33',0,NULL);

/*Table structure for table `order_service_provider` */

DROP TABLE IF EXISTS `order_service_provider`;

CREATE TABLE `order_service_provider` (
  `ID` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '订单供应商表ID',
  `order_no` varchar(30) DEFAULT NULL COMMENT '订单号',
  `sp_id` bigint(20) unsigned DEFAULT NULL COMMENT '供应商ID',
  `status` int(11) DEFAULT '1' COMMENT '1:竞标2:中标3:弃标4:淘汰',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_del` tinyint(1) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='订单供应商表';

/*Data for the table `order_service_provider` */

insert  into `order_service_provider`(`ID`,`order_no`,`sp_id`,`status`,`create_time`,`update_time`,`is_del`) values (1,'3014963',1,1,'2016-03-11 04:21:38','2016-03-11 04:21:38',0),(2,'3014963',2,1,'2016-03-11 04:21:41','2016-03-11 04:21:41',0),(3,'3014963',3,1,'2016-03-11 04:21:48','2016-03-11 04:21:48',0),(4,'3014963',4,1,'2016-03-11 22:45:04','2016-03-11 22:45:11',0),(5,'8787908',5,4,'2016-03-12 01:12:44','2016-03-12 01:12:44',0),(6,'8787908',6,2,'2016-03-12 01:12:48','2016-03-12 01:12:53',0),(7,'8787908',7,4,'2016-03-12 01:12:49','2016-03-12 01:12:55',0),(8,'3802551',8,4,'2016-03-12 02:12:36','2016-03-12 02:12:42',0),(9,'3802551',9,2,'2016-03-12 02:12:40','2016-03-12 02:12:50',0);

/*Table structure for table `order_status_stream` */

DROP TABLE IF EXISTS `order_status_stream`;

CREATE TABLE `order_status_stream` (
  `ID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `order_no` varchar(30) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `finish_time` timestamp NULL DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_del` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `order_status_stream` */

insert  into `order_status_stream`(`ID`,`order_no`,`status`,`finish_time`,`create_time`,`update_time`,`is_del`) values (1,'5074995',100,'2016-03-11 21:15:50','2016-03-11 21:15:50','2016-03-11 21:15:50',0),(2,'3004100',100,NULL,'2016-03-11 22:36:07','2016-03-11 22:36:07',0),(3,'4034538',100,NULL,'2016-03-11 22:56:53','2016-03-11 22:56:53',0),(4,'101457772570783380',110,NULL,'2016-03-11 23:32:04','2016-03-12 04:22:41',0),(6,'101457777651701352',110,NULL,'2016-03-12 05:23:13','2016-03-12 05:23:13',0),(7,'3802551',110,NULL,'2016-03-12 05:45:20','2016-03-12 05:45:20',0),(8,'3802551',120,NULL,'2016-03-12 05:45:20','2016-03-12 05:45:20',0);

/*Table structure for table `recive_address` */

DROP TABLE IF EXISTS `recive_address`;

CREATE TABLE `recive_address` (
  `ID` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '收货地址ID',
  `order_no` varchar(30) DEFAULT NULL,
  `contacts` varchar(45) DEFAULT NULL COMMENT '联系人',
  `contact_phone` varchar(45) DEFAULT NULL COMMENT '联系电话',
  `city_ids` varchar(20) DEFAULT NULL COMMENT '地址编码',
  `address_detail` varchar(200) DEFAULT NULL COMMENT '联系地址',
  `remarks` varchar(500) DEFAULT NULL COMMENT '备注信息',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_del` tinyint(1) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COMMENT='收货地址表';

/*Data for the table `recive_address` */

insert  into `recive_address`(`ID`,`order_no`,`contacts`,`contact_phone`,`city_ids`,`address_detail`,`remarks`,`create_time`,`update_time`,`is_del`) values (1,NULL,'å¯ä¿','18518758217',NULL,NULL,NULL,'2016-03-11 07:15:12','2016-03-11 07:15:12',0),(2,'7953522','å¯ä¿','18518758217',NULL,NULL,NULL,'2016-03-11 07:18:22','2016-03-11 07:18:22',0),(3,'7525985','å°é»','18518758217',NULL,NULL,NULL,'2016-03-11 07:20:06','2016-03-11 07:20:06',0),(4,'7525985','å°é»','18518758217',NULL,'å·¦å²¸å¬ç¤¾',NULL,'2016-03-11 07:24:40','2016-03-11 07:24:40',0),(5,'3802551',NULL,NULL,NULL,'å·¦å²¸',NULL,'2016-03-11 07:33:45','2016-03-11 07:33:45',0),(6,'3802551',NULL,NULL,NULL,'å·¦å²¸',NULL,'2016-03-11 07:37:07','2016-03-11 07:37:07',0),(8,'5613329','小红','18518758217',NULL,'左岸',NULL,'2016-03-11 07:45:41','2016-03-11 07:45:41',0),(9,'5613329','小红','18518758217',NULL,'左岸',NULL,'2016-03-11 07:47:20','2016-03-11 07:47:20',0),(10,'5613329','小红','18518758217',NULL,'左岸',NULL,'2016-03-11 07:48:01','2016-03-11 07:48:01',0),(11,'5613329','小红','18518758217',NULL,'左岸',NULL,'2016-03-11 07:50:40','2016-03-11 07:50:40',0),(12,'5613329','小红','18518758217',NULL,'左岸',NULL,'2016-03-11 07:52:37','2016-03-11 07:52:37',0),(13,'5028656','段郎','18518758217',NULL,'',NULL,'2016-03-11 09:00:33','2016-03-11 09:00:33',0),(16,'5074995','小华','18518758217',NULL,'左岸公社',NULL,'2016-03-11 22:27:58','2016-03-11 22:27:58',0),(18,'','冯俊','18518758217',NULL,'北大',NULL,'2016-03-11 22:46:06','2016-03-11 22:46:06',0),(19,'3014963','冯俊','18518758217',NULL,'北大',NULL,'2016-03-11 22:51:30','2016-03-12 05:20:35',0),(20,'4034538','小兰','18518758217',NULL,'左岸公社',NULL,'2016-03-11 22:57:04','2016-03-11 22:57:04',0),(21,'4034538','小兰','18518758217',NULL,'左岸公社',NULL,'2016-03-11 22:57:20','2016-03-11 22:57:20',0),(22,'7310717','小花','18518758217',NULL,'左岸',NULL,'2016-03-11 23:07:15','2016-03-11 23:07:15',0),(23,'7310717','小花','18518758217',NULL,'左岸',NULL,'2016-03-11 23:07:26','2016-03-11 23:07:26',0),(24,'8706283','小李','18518758217',NULL,'左岸公社',NULL,'2016-03-11 23:38:41','2016-03-11 23:38:41',0),(25,'2435067','小白','18518758217',NULL,'左岸公社',NULL,'2016-03-12 01:05:32','2016-03-12 01:05:32',0);

/* Procedure structure for procedure `generate_serialNumber` */

/*!50003 DROP PROCEDURE IF EXISTS  `generate_serialNumber` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`%` PROCEDURE `generate_serialNumber`(in type int, out serialNumber varchar(25))
BEGIN    
  DECLARE num varCHAR (18) ;-- 临时变量          

  if type = 1 then -- 生成订单号     
    SELECT CONCAT('10',unix_timestamp(now()), FLOOR( 100000 + RAND() * (1000000 - 100000))) INTO num ;-- 订单号形式:前缀+unix_timestamp+流水号，如：101457753087176576    

  elseif type = 2 then -- 生成量体订单号     
    SELECT CONCAT('20',unix_timestamp(now()), FLOOR( 100000 + RAND() * (1000000 - 100000))) INTO num ;-- 量体订单号形式：前缀+unix_timestamp+流水号,如：201457753121225253     
  else 
		SELECT CONCAT('30',unix_timestamp(now()), FLOOR( 100000 + RAND() * (1000000 - 100000))) INTO num ;-- 支付流水号形式：前缀+unix_timestamp+流水号,如：201457753121225253     
	end if ;    
   
   set serialNumber = num;
END */$$
DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
