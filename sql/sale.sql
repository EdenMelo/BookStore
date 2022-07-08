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

 Date: 08/07/2022 21:49:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sale
-- ----------------------------
DROP TABLE IF EXISTS `sale`;
CREATE TABLE `sale`  (
  `productId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `productName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `productSale` int(0) NULL DEFAULT NULL,
  `latestSaleDate` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`productId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sale
-- ----------------------------
INSERT INTO `sale` VALUES ('120f302b-5c05-45f0-b653-1e48879de076', '东京贫困女子', 11, '2022-06-03 12:09:48');
INSERT INTO `sale` VALUES ('1f960132-d34a-4547-9592-6518365291fe', '超越期待', 12, '2022-06-13 12:08:32');
INSERT INTO `sale` VALUES ('2c3ea884-cf8c-4f60-8f7e-7bcdb553413e', '史蒂夫·乔布斯传', 104, '2022-06-13 12:08:47');
INSERT INTO `sale` VALUES ('33eb296c-44a7-465d-a2de-164a3ee2f0a4', '活着', 5, '2022-06-08 12:09:07');
INSERT INTO `sale` VALUES ('3626d248-55a8-4cde-9332-040401393f58', '一万天的奇迹', 3, '2022-06-07 12:09:21');
INSERT INTO `sale` VALUES ('40196dab-07a3-4aba-abb6-504d7a6dd41c', '解忧杂货铺', 6, '2022-06-03 12:09:48');
INSERT INTO `sale` VALUES ('4452479d-d150-424e-a760-e7460112ba0d', '橙计算机', 1, '2022-06-13 12:08:32');
INSERT INTO `sale` VALUES ('4dcb9742-3e07-4e84-97bd-96ac5e7f1f1d', '你当像鸟飞往你的山', 5, '2022-06-13 12:08:47');
INSERT INTO `sale` VALUES ('60ed6ec4-29d0-4ff2-b2e7-83d32832dc6a', '香蕉', 65, '2022-06-08 12:09:07');
INSERT INTO `sale` VALUES ('709f46ea-ca60-498a-aec4-cdb42965a466', '士多啤梨', 98, '2022-06-07 12:09:21');
INSERT INTO `sale` VALUES ('72c52302-cd1e-4a22-8ac8-dc300a915be5', '计算机导论', 38, '2022-06-03 12:09:48');
INSERT INTO `sale` VALUES ('7317a248-1adf-460a-9d50-f764bc9fa58f', '知日·杂货', 12, '2022-06-13 12:08:32');
INSERT INTO `sale` VALUES ('7379565b-b585-4d24-82a7-a84021b58a24', '置身事外', 15, '2022-06-13 12:08:47');
INSERT INTO `sale` VALUES ('79bbe618-d2f8-4081-b35a-62ebbe938b64', '计算机网络', 95, '2022-06-08 12:09:07');
INSERT INTO `sale` VALUES ('7d032584-c922-4de2-8729-8e791c6a4074', '中日交流标准日本语', 11, '2022-06-07 12:09:21');
INSERT INTO `sale` VALUES ('8020cadd-8966-4b90-913c-5804913a07b0', '五年高考三年模拟', 26, '2022-06-03 12:09:48');
INSERT INTO `sale` VALUES ('84c842da-16b6-4e87-953e-859a1ca62bab', '软件工程', 3, '2022-06-13 12:08:32');
INSERT INTO `sale` VALUES ('912f15ef-0288-4e2d-9b67-43039305270f', '工作消费主义和新穷人', 10, '2022-06-13 12:08:47');
INSERT INTO `sale` VALUES ('afd0a00f-4652-4a05-8cd0-46514c83560f', '冒险小虎队', 36, '2022-06-08 12:09:07');
INSERT INTO `sale` VALUES ('b012bd74-944b-441e-b499-b72bddcd001b', '艺术的故事', 2, '2022-06-07 12:09:21');
INSERT INTO `sale` VALUES ('d415114d-cc2f-4182-9dea-0f765ef2167d', '认知觉醒 ', 0, '2022-06-03 12:09:48');
INSERT INTO `sale` VALUES ('d8b3bd89-53b6-431a-8e67-d38fcff1a3d8', '西瓜', 1, '2022-06-13 12:08:32');
INSERT INTO `sale` VALUES ('ec1a71c5-cc75-433b-95b8-cb6dae5d460f', 'Harry Potter', 2, '2022-06-13 12:08:47');
INSERT INTO `sale` VALUES ('eca5a437-720d-459b-bf8b-b331e4cef7a5', '叫魂 : 1768年中国妖术大恐慌', 3, '2022-06-08 12:09:07');

SET FOREIGN_KEY_CHECKS = 1;
