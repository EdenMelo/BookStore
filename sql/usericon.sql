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

 Date: 08/07/2022 21:49:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for usericon
-- ----------------------------
DROP TABLE IF EXISTS `usericon`;
CREATE TABLE `usericon`  (
  `userId` int(0) NOT NULL,
  `userIconUrl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`userId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of usericon
-- ----------------------------
INSERT INTO `usericon` VALUES (3, 'WebContent/client/userIconImg/gundam.jpg');

SET FOREIGN_KEY_CHECKS = 1;
