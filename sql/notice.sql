/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : localhost:3306
 Source Schema         : bookstore

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 08/07/2022 21:45:29
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice`  (
  `n_id` int(0) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `details` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `n_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`n_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES (13, '网上书城联系电话', '1145141919810', '2022-06-13 12:09:48');
INSERT INTO `notice` VALUES (15, '本周新增书籍', 'XXXX,XXXX,XXX', '2022-06-12 12:08:32');
INSERT INTO `notice` VALUES (16, '购物注意事项', 'NONE', '2022-06-13 12:08:47');
INSERT INTO `notice` VALUES (17, '网站升级公告', 'Update', '2022-06-13 12:09:07');
INSERT INTO `notice` VALUES (18, '客服在线时间', '996', '2022-06-13 12:09:21');
INSERT INTO `notice` VALUES (19, '书城升级内容', '更多前后台互动', '2022-06-13 12:19:41');

SET FOREIGN_KEY_CHECKS = 1;
