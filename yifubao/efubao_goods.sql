/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.6.29 : Database - efubao_goods
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`efubao_goods` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `efubao_goods`;

/*Table structure for table `category` */

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `ID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '名称',
  `parent_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '父ID',
  `sort` int(11) NOT NULL DEFAULT '1' COMMENT '排序',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '状态:1-正常;2-停用',
  `level_path` varchar(50) NOT NULL COMMENT '当前类目路径ids(用逗号分隔)',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_del` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8 COMMENT='类目表';

/*Data for the table `category` */

insert  into `category`(`ID`,`name`,`parent_id`,`sort`,`status`,`level_path`,`create_time`,`update_time`,`is_del`) values (2,'休闲服',0,2,1,'','2016-03-07 02:13:27','2016-03-11 01:18:47',0),(3,'西服正装',0,1,1,'','2016-03-07 02:13:27','2016-03-08 21:59:09',0),(4,'防寒服',0,4,1,'','2016-03-07 02:13:27','2016-03-11 01:19:39',0),(5,'大衣外套',0,5,1,'','2016-03-07 02:13:27','2016-03-11 01:20:16',0),(6,'羽绒服',4,6,1,'4','2016-03-07 02:13:27','2016-03-11 02:05:26',0),(8,'衬衫',3,1,1,'3','2016-03-07 02:20:43','2016-03-09 02:48:14',0),(10,'长袖衬衫',8,1,1,'3,8','2016-03-07 02:22:28','2016-03-09 03:19:24',0),(12,'工程服',0,3,1,'','2016-03-07 02:13:27','2016-03-11 01:19:39',0),(20,'短袖衬衫',8,2,1,'3,8','2016-03-08 04:02:13','2016-03-08 22:01:35',0),(35,'短袖衬衫',8,2,1,'3,8','2016-03-08 04:02:13','2016-03-08 22:01:35',1);

/*Table structure for table `goods` */

DROP TABLE IF EXISTS `goods`;

CREATE TABLE `goods` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL COMMENT '商品名称',
  `num` varchar(50) DEFAULT NULL COMMENT '商品编号',
  `summary` varchar(500) DEFAULT NULL COMMENT '商品简述',
  `category_id` bigint(20) unsigned NOT NULL COMMENT '类目ID',
  `first_image_path` varchar(200) DEFAULT NULL COMMENT '首图图片路径',
  `sort` int(11) NOT NULL DEFAULT '1' COMMENT '排序',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '状态:1-正常;2-停用',
  `min_price` decimal(10,2) DEFAULT NULL COMMENT '最小价格',
  `max_price` decimal(10,2) DEFAULT NULL COMMENT '最大价格',
  `online_time` datetime DEFAULT NULL COMMENT '上线时间',
  `offline_time` datetime DEFAULT NULL COMMENT '下线时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_del` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=104 DEFAULT CHARSET=utf8 COMMENT='商品SPU';

/*Data for the table `goods` */

insert  into `goods`(`ID`,`name`,`num`,`summary`,`category_id`,`first_image_path`,`sort`,`status`,`min_price`,`max_price`,`online_time`,`offline_time`,`create_time`,`update_time`,`is_del`) values (1,'1男士经典弹性棉免烫商务长袖衬衫','','1231231ssss的的的的的的的的的的的的的的的的的的的的的的的的的的的的的的的的的的的的的ssss的的的的的的的的的的的的的的的的的的的的的的的的的的的的的的的的的的的的的ssss的的的的的的的的的的的的的的的的的的的的的的的的的的的的的的的的的的的的的ssss的的的的的的的的的的的的的的的的的的的的的的的的的的的的的的的的的的的的的',2,'http://localhost:8080/core-web-C/resources/img/test1.png',1,1,300.00,900.00,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-12 05:01:55',0),(3,'goods2','','',8,'',1,1,NULL,NULL,'2016-03-07 01:48:50','2016-03-01 14:48:43','2016-03-07 01:39:27','2016-03-09 02:40:20',0),(6,'goods4','','',4,'',1,1,NULL,NULL,'2016-03-09 14:10:03','2016-03-09 14:10:12','2016-03-07 02:18:49','2016-03-10 02:50:09',0),(7,'3男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',3,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 03:17:36',0),(8,'2男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',2,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 03:17:36',0),(9,'4男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',4,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 03:17:36',0),(10,'5男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',5,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 03:17:36',0),(11,'6男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',6,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 03:17:36',0),(12,'7男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',7,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 03:17:36',0),(13,'8男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 03:17:36',0),(14,'81男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 05:34:38',0),(15,'81男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 05:34:38',0),(16,'81男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 05:34:38',0),(17,'81男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 05:34:38',0),(18,'81男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 05:34:38',0),(19,'81男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 05:35:13',0),(20,'81男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 05:34:38',0),(21,'81男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 05:34:38',0),(22,'81男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 05:34:38',0),(23,'81男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 05:34:38',0),(24,'81男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 05:34:38',0),(25,'81男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 05:35:13',0),(26,'81男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 05:35:13',0),(27,'81男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 05:35:37',0),(28,'8男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-12 03:53:38',0),(29,'8男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 03:17:36',0),(30,'8男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 03:17:36',0),(31,'8男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 03:17:36',0),(32,'8男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 03:17:36',0),(33,'8男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 03:17:36',0),(34,'8男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-12 03:49:29',1),(35,'8男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-12 03:47:13',1),(36,'8男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 03:17:36',0),(37,'8男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-12 03:52:40',1),(38,'8男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 03:17:36',0),(39,'8男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 03:17:36',0),(40,'8男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-12 03:45:40',0),(41,'8男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 03:17:36',0),(42,'8男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 03:17:36',0),(43,'8男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 03:17:36',0),(44,'8男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-12 03:47:03',0),(45,'8男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-12 03:45:44',1),(46,'8男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 03:17:36',0),(47,'8男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 03:17:36',0),(48,'8男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 03:17:36',0),(49,'8男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 03:17:36',0),(50,'8男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 03:17:36',0),(51,'8男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 03:17:36',0),(52,'8男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 03:17:36',0),(53,'8男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 03:17:36',0),(54,'8男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 03:17:36',0),(55,'8男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 03:17:36',0),(56,'8男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 03:17:36',0),(57,'8男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 03:17:36',0),(58,'8男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 03:17:36',0),(59,'8男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 03:17:36',0),(60,'8男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 03:17:36',0),(61,'8男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 03:17:36',0),(62,'8男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 03:17:36',0),(63,'8男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 03:17:36',0),(64,'8男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 03:17:36',0),(65,'8男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 03:17:36',0),(66,'8男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 03:17:36',0),(67,'8男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 03:17:36',0),(68,'8男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 03:17:36',0),(69,'8男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 03:17:36',0),(70,'8男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 03:17:36',0),(71,'8男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 03:17:36',0),(72,'8男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 03:17:36',0),(73,'8男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 03:17:36',0),(74,'8男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 03:17:36',0),(75,'8男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 03:17:36',0),(76,'8男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 03:17:36',0),(77,'8男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 03:17:36',0),(78,'8男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 03:17:36',0),(79,'8男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 03:17:36',0),(80,'8男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 03:17:36',0),(81,'8男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 03:17:36',0),(82,'8男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 03:17:36',0),(83,'8男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 03:17:36',0),(84,'8男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 03:17:36',0),(85,'8男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 03:17:36',0),(86,'8男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 03:17:36',0),(87,'8男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 03:17:36',0),(88,'8男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 03:17:36',0),(89,'8男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 03:17:36',0),(90,'8男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 03:17:36',0),(91,'8男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 03:17:36',0),(92,'8男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 03:17:36',0),(93,'8男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 03:17:36',0),(94,'8男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 03:17:36',0),(95,'8男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 03:17:36',0),(96,'8男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 03:17:36',0),(97,'8男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 03:17:36',0),(98,'8男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 03:17:36',0),(99,'8男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 03:17:36',0),(100,'8男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 03:17:36',0),(101,'8男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 03:17:36',0),(102,'8男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 03:17:36',0),(103,'8男士经典弹性棉免烫商务长袖衬衫','','1231231ssss',2,'',8,1,100.00,NULL,'2016-03-04 19:55:12','2016-03-05 19:53:17','2016-03-04 19:47:50','2016-03-11 03:17:36',0);

/*Table structure for table `goods_desc` */

DROP TABLE IF EXISTS `goods_desc`;

CREATE TABLE `goods_desc` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `goods_id` bigint(20) unsigned NOT NULL COMMENT '商品ID',
  `description` text COMMENT '详情描述',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_del` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='商品描述';

/*Data for the table `goods_desc` */

insert  into `goods_desc`(`ID`,`goods_id`,`description`,`create_time`,`update_time`,`is_del`) values (2,3,'<div class=\"title\"><span>产品展示</span></div>\n                    <div class=\"show_cont\"><img src=\"http://localhost:8080/core-web-C/resources/img/img/pic1.jpg\" /></div>\n                    <div class=\"title\"><span>定制介绍</span></div>\n                    <div class=\"show_cont\"><img src=\"http://localhost:8080/core-web-C/resources/img/pic2.jpg\" /></div>\n                    <div class=\"title2\"><span>定制流程</span></div>\n                    <div class=\"show_cont\"><img src=\"http://localhost:8080/core-web-C/resources/img/pic3.jpg\" /></div>\n                    <div class=\"title\"><span>产品信息</span></div>\n                    <div class=\"show_cont\"><img src=\"http://localhost:8080/core-web-C/resources/img/pic4.jpg\" /></div>\n                    <div class=\"title2\"><span>洗涤说明</span></div>\n                    <div class=\"show_cont\"><img src=\"http://localhost:8080/core-web-C/resources/img/pic5.jpg\" /></div>\n                    <div class=\"title\"><span>细节展示</span></div>\n                    <div class=\"show_cont\"><img src=\"http://localhost:8080/core-web-C/resources/img/pic6.jpg\" /></div>\n                    <div class=\"title\"><span>服务承诺</span></div>\n                    <div class=\"show_cont cont_text\"><p>依服宝平台销售并发货的商品，由平台依服宝提供发票和相应的售后服务。<span>请您放心购买！</span></p></div>','2016-03-07 03:24:38','2016-03-11 08:22:17',0),(3,1,'ssssss','2016-03-11 08:22:28','2016-03-11 08:33:10',0);

/*Table structure for table `goods_pic` */

DROP TABLE IF EXISTS `goods_pic`;

CREATE TABLE `goods_pic` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `goods_id` bigint(20) unsigned NOT NULL COMMENT '商品ID',
  `description` varchar(200) DEFAULT NULL COMMENT '描述',
  `image_path` varchar(200) DEFAULT NULL COMMENT '图片路径',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_del` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='商品图片';

/*Data for the table `goods_pic` */

insert  into `goods_pic`(`ID`,`goods_id`,`description`,`image_path`,`create_time`,`update_time`,`is_del`) values (1,1,NULL,'../resources/img/img17.png','2016-03-11 08:08:35','2016-03-12 04:46:49',0),(2,1,NULL,'../resources/img/img18.png','2016-03-11 08:08:35','2016-03-12 04:49:32',0),(3,1,NULL,'../resources/img/img16.png','2016-03-11 08:08:35','2016-03-12 04:49:32',0),(4,1,NULL,'http://localhost:8080/core-web-C/resources/img/img17.png','2016-03-11 08:08:40','2016-03-11 08:08:40',0),(5,1,NULL,'http://localhost:8080/core-web-C/resources/img/img18.png','2016-03-11 08:08:40','2016-03-11 08:08:40',0),(6,1,NULL,'http://localhost:8080/core-web-C/resources/img/img16.png','2016-03-11 08:08:40','2016-03-11 08:08:40',0),(7,1,NULL,'http://localhost:8080/core-web-C/resources/img/img17.png','2016-03-11 08:08:41','2016-03-11 08:08:41',0),(8,1,NULL,'http://localhost:8080/core-web-C/resources/img/img18.png','2016-03-11 08:08:41','2016-03-11 08:08:41',0),(9,1,NULL,'http://localhost:8080/core-web-C/resources/img/img16.png','2016-03-11 08:08:41','2016-03-11 08:08:41',0),(10,1,NULL,'http://localhost:8080/core-web-C/resources/img/img17.png','2016-03-11 08:08:42','2016-03-11 08:08:42',0),(11,1,NULL,'http://localhost:8080/core-web-C/resources/img/img18.png','2016-03-11 08:08:42','2016-03-11 08:08:42',0),(12,1,NULL,'http://localhost:8080/core-web-C/resources/img/img16.png','2016-03-11 08:08:42','2016-03-11 08:08:42',0);

/*Table structure for table `goods_property` */

DROP TABLE IF EXISTS `goods_property`;

CREATE TABLE `goods_property` (
  `ID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `goods_id` bigint(20) unsigned NOT NULL COMMENT '商品ID',
  `property_id` bigint(20) unsigned NOT NULL COMMENT '属性ID',
  `property_name` varchar(50) DEFAULT NULL COMMENT '属性名',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_del` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='商品非销售属性';

/*Data for the table `goods_property` */

insert  into `goods_property`(`ID`,`goods_id`,`property_id`,`property_name`,`create_time`,`update_time`,`is_del`) values (1,3,10,'尺码','2016-03-08 01:04:05','2016-03-08 01:41:10',0),(2,5,11,'版型','2016-03-08 01:06:45','2016-03-08 01:41:10',0),(3,3,11,'版型','2016-03-08 01:07:21','2016-03-08 01:41:10',0),(4,1,6,'颜色','2016-03-08 03:40:02','2016-03-08 03:40:02',0),(5,6,6,'颜色','2016-03-08 03:40:02','2016-03-08 03:40:02',0);

/*Table structure for table `goods_property_value` */

DROP TABLE IF EXISTS `goods_property_value`;

CREATE TABLE `goods_property_value` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `goods_property_id` bigint(20) unsigned NOT NULL COMMENT '商品非销售属性ID',
  `property_value_id` bigint(20) unsigned NOT NULL COMMENT '属性值ID',
  `property_value_name` varchar(50) DEFAULT NULL COMMENT '属性值名称',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_del` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='商品非销售属性值';

/*Data for the table `goods_property_value` */

insert  into `goods_property_value`(`ID`,`goods_property_id`,`property_value_id`,`property_value_name`,`create_time`,`update_time`,`is_del`) values (1,1,11,'XL','2016-03-08 01:49:15','2016-03-08 02:21:47',0),(2,2,9,'修身','2016-03-08 01:54:05','2016-03-08 01:54:05',0),(3,3,9,'修身','2016-03-08 02:15:56','2016-03-08 02:23:37',0),(4,3,10,'加肥','2016-03-08 03:08:32','2016-03-08 03:51:13',0),(5,1,12,'XXL','2016-03-08 03:53:03','2016-03-08 03:54:10',0),(6,4,1,'红色','2016-03-08 07:10:10','2016-03-08 07:10:10',0);

/*Table structure for table `goods_sku` */

DROP TABLE IF EXISTS `goods_sku`;

CREATE TABLE `goods_sku` (
  `ID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `goods_id` bigint(20) unsigned NOT NULL COMMENT '商品ID',
  `attribute_ids` varchar(200) DEFAULT NULL COMMENT '属性IDs',
  `attribute_names` varchar(200) DEFAULT NULL COMMENT '属性名称s',
  `attribute_value_ids` varchar(200) DEFAULT NULL COMMENT '属性值IDs',
  `attribute_value_names` varchar(200) DEFAULT NULL COMMENT '属性值名称s',
  `image_path` varchar(200) DEFAULT NULL COMMENT '图片路径',
  `price` decimal(10,2) DEFAULT NULL COMMENT '价格',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_del` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='商品SKU';

/*Data for the table `goods_sku` */

insert  into `goods_sku`(`ID`,`goods_id`,`attribute_ids`,`attribute_names`,`attribute_value_ids`,`attribute_value_names`,`image_path`,`price`,`create_time`,`update_time`,`is_del`) values (1,1,'1,2','颜色,尺寸','1,4','黄色,S','http://localhost:8080/core-web-C/resources/img/img18.png, ',300.00,'2016-03-11 08:40:28','2016-03-11 22:29:43',0),(2,1,'1,2','颜色,尺寸','1,5','黄色,M','http://localhost:8080/core-web-C/resources/img/img18.png, ',400.00,'2016-03-11 08:40:28','2016-03-11 22:29:43',0),(3,1,'1,2','颜色,尺寸','2,4','红色,S','http://localhost:8080/core-web-C/resources/img/img17.png, ',500.00,'2016-03-11 08:40:28','2016-03-11 22:29:43',0),(4,1,'1,2','颜色,尺寸','2,5','红色,M','http://localhost:8080/core-web-C/resources/img/img17.png, ',700.00,'2016-03-11 08:40:28','2016-03-11 22:29:43',0),(5,1,'1,2','颜色,尺寸','3,4','黑色,S','http://localhost:8080/core-web-C/resources/img/img17.png, ',800.00,'2016-03-11 08:40:28','2016-03-11 22:29:43',0),(6,1,'1,2','颜色,尺寸','3,5','黑色,M','http://localhost:8080/core-web-C/resources/img/img17.png, ',900.00,'2016-03-11 08:40:28','2016-03-11 22:29:43',0);

/*Table structure for table `measure_property` */

DROP TABLE IF EXISTS `measure_property`;

CREATE TABLE `measure_property` (
  `ID` bigint(20) unsigned NOT NULL COMMENT '量体属性ID',
  `property_name` varchar(45) DEFAULT NULL COMMENT '属性名称',
  `measure_type_id` bigint(20) unsigned DEFAULT NULL COMMENT '量体类型ID',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_del` tinyint(1) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='量体属性';

/*Data for the table `measure_property` */

/*Table structure for table `measure_type` */

DROP TABLE IF EXISTS `measure_type`;

CREATE TABLE `measure_type` (
  `ID` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '量体类型ID',
  `type_name` varchar(45) DEFAULT NULL COMMENT '类型名称',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_del` tinyint(1) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='量体类型';

/*Data for the table `measure_type` */

/*Table structure for table `property` */

DROP TABLE IF EXISTS `property`;

CREATE TABLE `property` (
  `ID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '名称',
  `is_sale` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否销售',
  `sort` int(11) NOT NULL DEFAULT '1' COMMENT '排序',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '状态:1-正常;2-停用',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_del` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COMMENT='属性';

/*Data for the table `property` */

insert  into `property`(`ID`,`name`,`is_sale`,`sort`,`status`,`create_time`,`update_time`,`is_del`) values (6,'颜色',1,1,2,'2016-03-06 11:50:51','2016-03-09 04:14:13',0),(10,'尺码',1,2,2,'2016-03-06 12:01:12','2016-03-09 06:35:04',1),(11,'版型',1,3,1,'2016-03-06 12:05:22','2016-03-08 01:37:17',0),(12,'袖长',0,4,1,'2016-03-06 12:16:10','2016-03-07 07:31:58',0),(13,'衣长',0,5,1,'2016-03-06 12:20:37','2016-03-07 00:28:32',0),(14,'领口',0,6,1,'2016-03-07 00:25:13','2016-03-07 00:28:32',0),(15,'袖口',0,7,1,'2016-03-07 00:28:32','2016-03-08 01:37:18',0),(17,'面料',1,8,1,'2016-03-07 01:17:15','2016-03-08 06:50:00',0);

/*Table structure for table `property_value` */

DROP TABLE IF EXISTS `property_value`;

CREATE TABLE `property_value` (
  `ID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL COMMENT '值名称',
  `property_id` bigint(20) unsigned NOT NULL COMMENT '属性ID',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '状态:1-正常;2-停用',
  `sort` int(11) NOT NULL DEFAULT '1' COMMENT '排序',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_del` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='属性值';

/*Data for the table `property_value` */

insert  into `property_value`(`ID`,`name`,`property_id`,`status`,`sort`,`create_time`,`update_time`,`is_del`) values (1,'红色',6,1,1,'2016-03-07 01:24:46','2016-03-08 22:21:26',0),(2,'绿色',6,1,2,'2016-03-07 01:27:21','2016-03-08 22:21:32',0),(3,'蓝色',6,1,3,'2016-03-07 01:28:21','2016-03-08 07:09:00',0),(4,'紫色',6,1,4,'2016-03-07 01:28:21','2016-03-07 01:28:21',0),(5,'黑色',6,1,5,'2016-03-07 01:28:21','2016-03-07 01:28:21',0),(7,'白色',6,2,7,'2016-03-07 01:28:21','2016-03-09 04:14:32',0),(8,'黄色',6,1,8,'2016-03-07 01:28:21','2016-03-08 03:08:05',0),(9,'修身',11,1,1,'2016-03-08 01:43:02','2016-03-08 01:43:02',0),(10,'加肥',11,1,1,'2016-03-08 01:43:47','2016-03-08 01:43:47',0),(11,'XL',10,1,1,'2016-03-08 02:20:49','2016-03-08 02:20:49',0),(12,'XXL',10,1,1,'2016-03-08 03:07:50','2016-03-08 03:08:04',0),(13,'',6,1,1,'2016-03-09 04:14:19','2016-03-09 04:14:20',1);

/*Table structure for table `sp_goods` */

DROP TABLE IF EXISTS `sp_goods`;

CREATE TABLE `sp_goods` (
  `ID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `sp_id` bigint(20) unsigned NOT NULL COMMENT '服务商ID',
  `goods_id` bigint(20) unsigned NOT NULL COMMENT '商品ID',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_del` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='服务商商品关联表';

/*Data for the table `sp_goods` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
