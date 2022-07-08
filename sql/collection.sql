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

 Date: 08/07/2022 21:44:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for collection
-- ----------------------------
DROP TABLE IF EXISTS `collection`;
CREATE TABLE `collection`  (
  `productId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `userId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of collection
-- ----------------------------
INSERT INTO `collection` VALUES ('7379565b-b585-4d24-82a7-a84021b58a24', '4');
INSERT INTO `collection` VALUES ('120f302b-5c05-45f0-b653-1e48879de076', '3');
INSERT INTO `collection` VALUES ('1f960132-d34a-4547-9592-6518365291fe', '3');
INSERT INTO `collection` VALUES ('2c3ea884-cf8c-4f60-8f7e-7bcdb553413e', '3');

SET FOREIGN_KEY_CHECKS = 1;
