/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 80012
Source Host           : localhost:3306
Source Database       : rent

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2018-10-18 10:28:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `registerdate` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('admin', 'admin', '系统管理员', '13700000000', 'admin@rent.com', '/picture/862388f9-790f-4d1d-9445-1deb93f0e8b9.jpg', '2018-9-1');
INSERT INTO `admin` VALUES ('root', 'root', '超级用户', '13700000000', 'root@rent.com', '/picture/2600c2ac-9755-4cf6-b748-318565f75027.jpg', '2018-9-18');

-- ----------------------------
-- Table structure for checklog
-- ----------------------------
DROP TABLE IF EXISTS `checklog`;
CREATE TABLE `checklog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `admin` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `house` int(11) NOT NULL,
  `checkdate` varchar(255) DEFAULT NULL,
  `checkresult` bit(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `admin` (`admin`) USING BTREE,
  KEY `house` (`house`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of checklog
-- ----------------------------
INSERT INTO `checklog` VALUES ('18', 'root', '15', '2018-10-16 16:02:31', '');
INSERT INTO `checklog` VALUES ('19', 'root', '16', '2018-10-16 16:02:31', '');
INSERT INTO `checklog` VALUES ('20', 'root', '19', '2018-10-16 16:02:31', '');
INSERT INTO `checklog` VALUES ('21', 'root', '17', '2018-10-17 22:01:01', '');
INSERT INTO `checklog` VALUES ('22', 'root', '21', '2018-10-17 22:01:01', '\0');
INSERT INTO `checklog` VALUES ('23', 'root', '21', '2018-10-17 22:01:01', '');
INSERT INTO `checklog` VALUES ('24', 'root', '22', '2018-10-17 22:17:02', '');
INSERT INTO `checklog` VALUES ('25', 'root', '23', '2018-10-17 22:47:41', '');
INSERT INTO `checklog` VALUES ('26', 'root', '24', '2018-10-17 22:47:41', '');
INSERT INTO `checklog` VALUES ('27', 'root', '25', '2018-10-17 23:28:15', '\0');
INSERT INTO `checklog` VALUES ('28', 'root', '25', '2018-10-17 23:28:15', '');
INSERT INTO `checklog` VALUES ('29', 'root', '26', '2018-10-17 23:28:15', '');
INSERT INTO `checklog` VALUES ('30', 'root', '27', '2018-10-17 23:28:15', '');
INSERT INTO `checklog` VALUES ('31', 'root', '28', '2018-10-17 23:35:05', '');
INSERT INTO `checklog` VALUES ('32', 'root', '30', '2018-10-18 00:24:18', '');
INSERT INTO `checklog` VALUES ('33', 'root', '31', '2018-10-18 00:24:18', '');
INSERT INTO `checklog` VALUES ('34', 'root', '32', '2018-10-18 00:30:34', '');
INSERT INTO `checklog` VALUES ('35', 'root', '17', '2018-10-18 00:30:34', '');
INSERT INTO `checklog` VALUES ('36', 'root', '26', '2018-10-18 08:41:03', '');
INSERT INTO `checklog` VALUES ('37', 'root', '34', '2018-10-18 08:41:03', '');
INSERT INTO `checklog` VALUES ('38', 'root', '35', '2018-10-18 08:41:03', '\0');

-- ----------------------------
-- Table structure for house
-- ----------------------------
DROP TABLE IF EXISTS `house`;
CREATE TABLE `house` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '房屋id',
  `landlord` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '房东id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '发布标题',
  `picture` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL COMMENT '房屋地点',
  `category` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '房屋类别',
  `area` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '房屋面积',
  `floor` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '楼层',
  `price` int(11) DEFAULT NULL COMMENT '租金',
  `publishdate` varchar(255) DEFAULT NULL COMMENT '发布日期',
  `ischeck` bit(1) DEFAULT NULL COMMENT '是否审核通过',
  `islease` bit(1) DEFAULT NULL COMMENT '是否被租',
  PRIMARY KEY (`id`),
  KEY `landlord` (`landlord`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of house
-- ----------------------------
INSERT INTO `house` VALUES ('15', '15205201', '南昌市红谷滩沿江住宅', '/picture/09a3f0a9-46a2-4fc5-b75b-8b46f82c37af.jpg', '江西省南昌市红谷滩区', '公寓', '100', '10', '100', '2018-10-16', '', '\0');
INSERT INTO `house` VALUES ('19', '15205202', '南昌市新建区赣江边公寓', '/picture/8856436a-7f7d-447c-8d5f-c9f2282b69d4.jpg', '江西省南昌市新建区', '合租', '300', '2', '80', '2018-10-18', '', '\0');
INSERT INTO `house` VALUES ('26', '15205202', '上海市青浦区住宅', '/picture/7173b36e-79c7-4a55-8ec5-07e7fd34b22d.jpg', '上海市青浦区', '单间', '80', '3', '200', '2018-10-18', '', '');
INSERT INTO `house` VALUES ('30', '15205201', '湖北省武汉市火车站边公寓', '/picture/7cd557f8-cf51-4708-bf1d-ee2e75831f06.jpg', '湖北省武汉市武昌火车站', '复式楼', '120', '8', '200', '2018-10-18', '', '\0');
INSERT INTO `house` VALUES ('31', '15205201', '江西师范大学校园宿舍', '/picture/99c6f467-b1eb-459b-8168-18a98735ce14.jpg', '江西省南昌市', '单间', '80', '5', '60', '2018-10-18', '', '');
INSERT INTO `house` VALUES ('32', '15205201', '南昌航空大学海军楼宿舍', '/picture/a8dcc2db-435f-49b0-8fc6-6862226f8a35.jpg', '江西省南昌市新建区丰和南大道696号', '单间', '40', '3', '40', '2018-10-18', '', '');
INSERT INTO `house` VALUES ('34', '15205201', '111', '/picture/ef14efd0-6396-4cbc-ada5-41f03b30233a.jpg', '111', '公寓', '111', '3', '11', '2018-10-18', '', '\0');
INSERT INTO `house` VALUES ('35', '15205201', '1111', '/picture/4d60aaef-ba6c-4725-a72a-654067e2ebb2.jpg', '11111', '单间', '120', '12312', '200', '2018-10-18', '\0', '');

-- ----------------------------
-- Table structure for landlord
-- ----------------------------
DROP TABLE IF EXISTS `landlord`;
CREATE TABLE `landlord` (
  `id` varchar(255) NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `registerdate` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of landlord
-- ----------------------------
INSERT INTO `landlord` VALUES ('15205201', '15205201', '张女士', '13300000000', 'zhang@qq.com', '/picture/2c958d77-b7f8-4a03-a63f-0d76eedc3417.jpg', '2018-10-10');
INSERT INTO `landlord` VALUES ('15205202', '15205202', '王先生', '13800000000', 'wang@163.com', '/picture/73039163-5da4-449c-8a96-5c040f3d80e4.jpg', '2018-9-30');
INSERT INTO `landlord` VALUES ('15205203', '15205203', '黄先生', '13800000000', 'huang@163.com', '/picture/181a34a6-5f89-4d6a-b8be-50337f20f704.jpg', '2018-9-28');
INSERT INTO `landlord` VALUES ('15205204', '15205204', '刘女士', '18000000000', 'liu@qq.com', '/picture/633bde01-148b-41eb-8f35-0565ed24c317.jpg', '2018-9-1');
INSERT INTO `landlord` VALUES ('15205205', '15205205', '王女士', '13800000000', 'wang@qq.com', '/picture/bca5c7da-06c2-4e58-a6d8-a1d47caabed7.jpg', '2018-9-11');
INSERT INTO `landlord` VALUES ('15205206', '15205206', '张先生', '13800000000', 'zhang@163.com', '/picture/e5ef664d-a212-4214-a6a0-d6ba6c8a5ed2.jpg', '2018-9-2');
INSERT INTO `landlord` VALUES ('15205207', '15205207', '卢女士', '13800000000', 'lu@qq.com', '/picture/user.png', '2018-9-10');
INSERT INTO `landlord` VALUES ('15205208', '15205208', '余女士', '17700000000', 'yu@123.com', '/picture/user.png', '2018-10-1');
INSERT INTO `landlord` VALUES ('15205209', '15205209', '蔡先生', '13800000000', 'cai@123.com', '/picture/user.png', '2018-9-10');
INSERT INTO `landlord` VALUES ('15205210', '15205210', '陈先生', '13800000000', 'chen@qq.com', '/picture/user.png', '2018-9-19');
INSERT INTO `landlord` VALUES ('15205211', '15205211', '范先生', '12200000000', 'fan@163.com', '/picture/user.png', '2018-10-1');

-- ----------------------------
-- Table structure for leaseholder
-- ----------------------------
DROP TABLE IF EXISTS `leaseholder`;
CREATE TABLE `leaseholder` (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `registerdate` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of leaseholder
-- ----------------------------
INSERT INTO `leaseholder` VALUES ('15205201', '15205201', '李女士', '13300000000', 'li@qq.com', '/picture/6d00ad85-6f93-4440-abf5-1063ab164052.jpg', '2018-10-2');
INSERT INTO `leaseholder` VALUES ('15205202', '15205202', '王先生', '13000000000', 'wang@qq.com', '/picture/55291a9c-c1fe-499c-8748-234a96fb4a01.jpg', '2018-10-10');
INSERT INTO `leaseholder` VALUES ('15205203', '15205203', '余先生', '13700000000', 'yu@123.com', '/picture/user.png', '2018-10-1');

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `landlord` varchar(255) DEFAULT NULL,
  `leaseholder` varchar(255) DEFAULT NULL,
  `house` int(11) DEFAULT NULL,
  `orderdate` varchar(255) DEFAULT NULL,
  `duration` int(11) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `state` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `order_ibfk_1` (`landlord`),
  KEY `order_ibfk_2` (`leaseholder`),
  KEY `house` (`house`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES ('28', '15205201', '15205201', '15', '2018-10-16 16:02:31', '6', '600', '');
INSERT INTO `t_order` VALUES ('36', '15205202', '15205201', '19', '2018-10-17 22:17:02', '10', '800', '');
INSERT INTO `t_order` VALUES ('42', '15205201', '15205201', '30', '2018-10-18 08:41:03', '3', '600', '');
INSERT INTO `t_order` VALUES ('46', '15205201', '15205201', '34', '2018-10-18 08:41:03', '1', '11', '\0');
