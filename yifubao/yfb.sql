/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.6.29 : Database - yfb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`yfb` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `yfb`;

/*Table structure for table `category` */

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL COMMENT '名称',
  `parent_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '父ID',
  `sort` int(11) NOT NULL DEFAULT '1' COMMENT '排序',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '状态:1-正常;2-停用;0-删除',
  `level_path` varchar(50) NOT NULL COMMENT '路径',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COMMENT='类目表';

/*Data for the table `category` */

insert  into `category`(`ID`,`name`,`parent_id`,`sort`,`status`,`level_path`,`create_time`,`update_time`) values (2,'休闲服',0,1,1,'','2016-03-07 02:13:27','2016-03-08 21:59:09'),(3,'西服正装',0,1,1,'','2016-03-07 02:13:27','2016-03-08 21:59:09'),(4,'防寒服',0,1,1,'','2016-03-07 02:13:27','2016-03-08 21:59:08'),(5,'大衣外套',0,1,1,'','2016-03-07 02:13:27','2016-03-08 21:59:07'),(6,'羽绒服',0,1,1,'','2016-03-07 02:13:27','2016-03-08 21:59:07'),(8,'衬衫',3,1,2,'3','2016-03-07 02:20:43','2016-03-08 21:59:14'),(10,'长袖衬衫',8,1,1,'3,8','2016-03-07 02:22:28','2016-03-08 22:01:34'),(12,'工程服',0,1,1,'','2016-03-07 02:13:27','2016-03-08 21:59:06'),(20,'短袖衬衫',8,2,1,'3,8','2016-03-08 04:02:13','2016-03-08 22:01:35');

/*Table structure for table `goods` */

DROP TABLE IF EXISTS `goods`;

CREATE TABLE `goods` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL COMMENT '商品名称',
  `num` varchar(50) DEFAULT NULL COMMENT '商品编号',
  `summary` varchar(500) DEFAULT NULL COMMENT '商品简述',
  `category_id` bigint(20) NOT NULL COMMENT '类目ID',
  `first_image_path` varchar(200) DEFAULT NULL,
  `sort` int(11) NOT NULL DEFAULT '1' COMMENT '排序',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '状态:1-正常;2-停用;0-删除',
  `min_price` decimal(10,2) DEFAULT NULL,
  `max_price` decimal(10,2) DEFAULT NULL,
  `online_time` timestamp NULL DEFAULT NULL,
  `offline_time` timestamp NULL DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='商品SPU';

/*Data for the table `goods` */

insert  into `goods`(`ID`,`name`,`num`,`summary`,`category_id`,`first_image_path`,`sort`,`status`,`min_price`,`max_price`,`online_time`,`offline_time`,`create_time`,`update_time`) values (1,'男士经典弹性棉免烫商务长袖衬衫',NULL,'1231231ssss',2,NULL,1,1,NULL,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-08 22:26:37'),(3,'goods2',NULL,NULL,8,NULL,1,0,NULL,NULL,'2016-03-07 01:48:50','2016-03-01 14:48:43','2016-03-07 01:39:27','2016-03-08 05:00:15'),(5,'goods5',NULL,NULL,2,NULL,1,0,NULL,NULL,NULL,NULL,'2016-03-07 02:04:52','2016-03-07 21:23:24'),(6,'goods4',NULL,NULL,4,NULL,1,1,NULL,NULL,NULL,NULL,'2016-03-07 02:18:49','2016-03-08 21:43:15');

/*Table structure for table `goods_desc` */

DROP TABLE IF EXISTS `goods_desc`;

CREATE TABLE `goods_desc` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `goods_id` bigint(20) NOT NULL COMMENT '商品ID',
  `description` text COMMENT '详情描述',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='商品描述';

/*Data for the table `goods_desc` */

insert  into `goods_desc`(`ID`,`goods_id`,`description`,`create_time`,`update_time`) values (2,3,'descccc','2016-03-07 03:24:38','2016-03-07 03:24:38');

/*Table structure for table `goods_pic` */

DROP TABLE IF EXISTS `goods_pic`;

CREATE TABLE `goods_pic` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `goods_id` bigint(20) NOT NULL COMMENT '商品ID',
  `description` varchar(200) DEFAULT NULL COMMENT '描述',
  `image_path` varchar(200) DEFAULT NULL COMMENT '图片path',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品图片';

/*Data for the table `goods_pic` */

/*Table structure for table `goods_property` */

DROP TABLE IF EXISTS `goods_property`;

CREATE TABLE `goods_property` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `goods_id` bigint(20) NOT NULL COMMENT '商品ID',
  `property_id` bigint(20) NOT NULL COMMENT '属性ID',
  `property_name` varchar(50) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='商品非销售属性';

/*Data for the table `goods_property` */

insert  into `goods_property`(`ID`,`goods_id`,`property_id`,`property_name`,`create_time`,`update_time`) values (1,3,10,'尺码','2016-03-08 01:04:05','2016-03-08 01:41:10'),(2,5,11,'版型','2016-03-08 01:06:45','2016-03-08 01:41:10'),(3,3,11,'版型','2016-03-08 01:07:21','2016-03-08 01:41:10'),(4,1,6,'颜色','2016-03-08 03:40:02','2016-03-08 03:40:02'),(5,6,6,'颜色','2016-03-08 03:40:02','2016-03-08 03:40:02');

/*Table structure for table `goods_property_value` */

DROP TABLE IF EXISTS `goods_property_value`;

CREATE TABLE `goods_property_value` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `goods_property_id` bigint(20) NOT NULL,
  `property_value_id` bigint(20) NOT NULL,
  `property_value_name` varchar(50) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='商品非销售属性值';

/*Data for the table `goods_property_value` */

insert  into `goods_property_value`(`ID`,`goods_property_id`,`property_value_id`,`property_value_name`,`create_time`,`update_time`) values (1,1,11,'XL','2016-03-08 01:49:15','2016-03-08 02:21:47'),(2,2,9,'修身','2016-03-08 01:54:05','2016-03-08 01:54:05'),(3,3,9,'修身','2016-03-08 02:15:56','2016-03-08 02:23:37'),(4,3,10,'加肥','2016-03-08 03:08:32','2016-03-08 03:51:13'),(5,1,12,'XXL','2016-03-08 03:53:03','2016-03-08 03:54:10'),(6,4,1,'红色','2016-03-08 07:10:10','2016-03-08 07:10:10');

/*Table structure for table `goods_sku` */

DROP TABLE IF EXISTS `goods_sku`;

CREATE TABLE `goods_sku` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `goods_id` bigint(20) NOT NULL COMMENT '商品ID',
  `attribute_ids` varchar(200) DEFAULT NULL COMMENT '属性IDs',
  `attribute_names` varchar(200) DEFAULT NULL COMMENT '属性名称s',
  `attribute_value_ids` varchar(200) DEFAULT NULL COMMENT '属性值IDs',
  `attribute_value_names` varchar(200) DEFAULT NULL COMMENT '属性值名称s',
  `image_path` varchar(200) DEFAULT NULL COMMENT '图片路径',
  `price` decimal(10,2) DEFAULT NULL COMMENT '价格',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品SKU';

/*Data for the table `goods_sku` */

/*Table structure for table `measure_goods` */

DROP TABLE IF EXISTS `measure_goods`;

CREATE TABLE `measure_goods` (
  `ID` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '量体商品ID',
  `measure_order_no` varchar(30) DEFAULT NULL COMMENT '量体订单ID',
  `goods_name` varchar(45) DEFAULT NULL COMMENT '商品名称',
  `goods_num` int(11) DEFAULT NULL COMMENT '商品数量',
  `goods_sku_id` bigint(20) unsigned DEFAULT NULL COMMENT '商品SKU',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `is_del` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='量体商品表';

/*Data for the table `measure_goods` */

/*Table structure for table `property` */

DROP TABLE IF EXISTS `property`;

CREATE TABLE `property` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL COMMENT '名称',
  `is_sale` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否销售',
  `sort` int(11) NOT NULL DEFAULT '1' COMMENT '排序',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '状态:1-正常;2-停用;0-删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8 COMMENT='属性';

/*Data for the table `property` */

insert  into `property`(`ID`,`name`,`is_sale`,`sort`,`status`,`create_time`,`update_time`) values (6,'颜色',1,1,1,'2016-03-06 11:50:51','2016-03-08 22:21:37'),(10,'尺码',1,2,1,'2016-03-06 12:01:12','2016-03-08 01:37:16'),(11,'版型',1,3,1,'2016-03-06 12:05:22','2016-03-08 01:37:17'),(12,'袖长',0,4,1,'2016-03-06 12:16:10','2016-03-07 07:31:58'),(13,'衣长',0,5,1,'2016-03-06 12:20:37','2016-03-07 00:28:32'),(14,'领口',0,6,1,'2016-03-07 00:25:13','2016-03-07 00:28:32'),(15,'袖口',0,7,1,'2016-03-07 00:28:32','2016-03-08 01:37:18'),(17,'面料',1,8,1,'2016-03-07 01:17:15','2016-03-08 06:50:00');

/*Table structure for table `property_value` */

DROP TABLE IF EXISTS `property_value`;

CREATE TABLE `property_value` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '值名称',
  `property_id` bigint(20) NOT NULL COMMENT '属性ID',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '状态:1-正常;2-停用;0-删除',
  `sort` int(11) NOT NULL DEFAULT '1' COMMENT '排序',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COMMENT='属性值';

/*Data for the table `property_value` */

insert  into `property_value`(`ID`,`name`,`property_id`,`status`,`sort`,`create_time`,`update_time`) values (1,'红色',6,1,1,'2016-03-07 01:24:46','2016-03-08 22:21:26'),(2,'绿色',6,1,2,'2016-03-07 01:27:21','2016-03-08 22:21:32'),(3,'蓝色',6,1,3,'2016-03-07 01:28:21','2016-03-08 07:09:00'),(4,'紫色',6,1,4,'2016-03-07 01:28:21','2016-03-07 01:28:21'),(5,'黑色',6,1,5,'2016-03-07 01:28:21','2016-03-07 01:28:21'),(7,'白色',6,2,7,'2016-03-07 01:28:21','2016-03-08 07:09:03'),(8,'黄色',6,1,8,'2016-03-07 01:28:21','2016-03-08 03:08:05'),(9,'修身',11,1,1,'2016-03-08 01:43:02','2016-03-08 01:43:02'),(10,'加肥',11,1,1,'2016-03-08 01:43:47','2016-03-08 01:43:47'),(11,'XL',10,1,1,'2016-03-08 02:20:49','2016-03-08 02:20:49'),(12,'XXL',10,1,1,'2016-03-08 03:07:50','2016-03-08 03:08:04');

/*Table structure for table `sp_goods` */

DROP TABLE IF EXISTS `sp_goods`;

CREATE TABLE `sp_goods` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `sp_id` bigint(20) NOT NULL COMMENT '服务商ID',
  `goods_id` bigint(20) NOT NULL COMMENT '商品ID',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='服务商商品关联表';

/*Data for the table `sp_goods` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
