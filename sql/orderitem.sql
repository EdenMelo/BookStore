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

 Date: 08/07/2022 21:48:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for orderitem
-- ----------------------------
DROP TABLE IF EXISTS `orderitem`;
CREATE TABLE `orderitem`  (
  `order_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `buynum` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`order_id`, `product_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orderitem
-- ----------------------------
INSERT INTO `orderitem` VALUES ('005e3b79-6f30-4da8-a415-ca768a0bc014', '1f960132-d34a-4547-9592-6518365291fe', 2);
INSERT INTO `orderitem` VALUES ('087ecdd0-8a52-4a27-8236-e90368e3b790', '1f960132-d34a-4547-9592-6518365291fe', 1);
INSERT INTO `orderitem` VALUES ('087ecdd0-8a52-4a27-8236-e90368e3b790', '2c3ea884-cf8c-4f60-8f7e-7bcdb553413e', 1);
INSERT INTO `orderitem` VALUES ('0c0796f2-0124-4a13-a891-5efbb63b04f9', '709f46ea-ca60-498a-aec4-cdb42965a466', 1);
INSERT INTO `orderitem` VALUES ('0ce9abb2-0846-47b8-890b-5d13ce6e3a6c', '2c3ea884-cf8c-4f60-8f7e-7bcdb553413e', 1);
INSERT INTO `orderitem` VALUES ('0ce9abb2-0846-47b8-890b-5d13ce6e3a6c', '33eb296c-44a7-465d-a2de-164a3ee2f0a4', 1);
INSERT INTO `orderitem` VALUES ('0d29ab05-a214-4cd9-a6bd-ecea5cf4a150', '1f960132-d34a-4547-9592-6518365291fe', 1);
INSERT INTO `orderitem` VALUES ('305a7870-3820-4079-b6f9-5d2b63cbcd2a', '72c52302-cd1e-4a22-8ac8-dc300a915be5', 2);
INSERT INTO `orderitem` VALUES ('32f2a7f3-cc03-43ed-abde-bbba265511c8', '33eb296c-44a7-465d-a2de-164a3ee2f0a4', 1);
INSERT INTO `orderitem` VALUES ('41b9bf6f-ee9c-4f70-a70f-bb6aeeba47d6', '1f960132-d34a-4547-9592-6518365291fe', 1);
INSERT INTO `orderitem` VALUES ('41b9bf6f-ee9c-4f70-a70f-bb6aeeba47d6', '33eb296c-44a7-465d-a2de-164a3ee2f0a4', 1);
INSERT INTO `orderitem` VALUES ('41b9bf6f-ee9c-4f70-a70f-bb6aeeba47d6', '4452479d-d150-424e-a760-e7460112ba0d', 1);
INSERT INTO `orderitem` VALUES ('41f6f838-b23b-41a9-a2ca-473f6e7d6fad', '1f960132-d34a-4547-9592-6518365291fe', 1);
INSERT INTO `orderitem` VALUES ('41f6f838-b23b-41a9-a2ca-473f6e7d6fad', '2c3ea884-cf8c-4f60-8f7e-7bcdb553413e', 1);
INSERT INTO `orderitem` VALUES ('44df1a1b-8e03-4482-8e80-3ab24baa4e1b', '33eb296c-44a7-465d-a2de-164a3ee2f0a4', 1);
INSERT INTO `orderitem` VALUES ('4c2eeb61-d917-4ad3-acf9-781e74094738', '33eb296c-44a7-465d-a2de-164a3ee2f0a4', 1);
INSERT INTO `orderitem` VALUES ('51a1cd30-d9c4-4b01-8c83-cab5795417ec', '2c3ea884-cf8c-4f60-8f7e-7bcdb553413e', 1);
INSERT INTO `orderitem` VALUES ('51a1cd30-d9c4-4b01-8c83-cab5795417ec', '4dcb9742-3e07-4e84-97bd-96ac5e7f1f1d', 1);
INSERT INTO `orderitem` VALUES ('61529034-7fbd-4c56-98d4-d84c6c12af5f', '2c3ea884-cf8c-4f60-8f7e-7bcdb553413e', 1);
INSERT INTO `orderitem` VALUES ('61529034-7fbd-4c56-98d4-d84c6c12af5f', '33eb296c-44a7-465d-a2de-164a3ee2f0a4', 1);
INSERT INTO `orderitem` VALUES ('62913cd4-76ce-4c1f-b80a-6eb00cb4d237', '4452479d-d150-424e-a760-e7460112ba0d', 1);
INSERT INTO `orderitem` VALUES ('62913cd4-76ce-4c1f-b80a-6eb00cb4d237', 'afd0a00f-4652-4a05-8cd0-46514c83560f', 1);
INSERT INTO `orderitem` VALUES ('63d8c633-4e5c-4177-beb8-697badba7f79', '33eb296c-44a7-465d-a2de-164a3ee2f0a4', 1);
INSERT INTO `orderitem` VALUES ('6e4a7ecc-9d67-495e-87e4-efe872832df6', '33eb296c-44a7-465d-a2de-164a3ee2f0a4', 1);
INSERT INTO `orderitem` VALUES ('76465caf-ca77-4946-ae31-8d36d89df6e8', '2c3ea884-cf8c-4f60-8f7e-7bcdb553413e', 1);
INSERT INTO `orderitem` VALUES ('76465caf-ca77-4946-ae31-8d36d89df6e8', '33eb296c-44a7-465d-a2de-164a3ee2f0a4', 1);
INSERT INTO `orderitem` VALUES ('831bfeeb-4ce5-4852-9c61-cd57cc61f733', '2c3ea884-cf8c-4f60-8f7e-7bcdb553413e', 1);
INSERT INTO `orderitem` VALUES ('831bfeeb-4ce5-4852-9c61-cd57cc61f733', '33eb296c-44a7-465d-a2de-164a3ee2f0a4', 1);
INSERT INTO `orderitem` VALUES ('a8307033-7b25-41bf-b5e8-dda30a936775', '2c3ea884-cf8c-4f60-8f7e-7bcdb553413e', 1);
INSERT INTO `orderitem` VALUES ('a8307033-7b25-41bf-b5e8-dda30a936775', '33eb296c-44a7-465d-a2de-164a3ee2f0a4', 1);
INSERT INTO `orderitem` VALUES ('ab0659aa-8633-47c9-ba54-007414d0bb85', '2c3ea884-cf8c-4f60-8f7e-7bcdb553413e', 1);
INSERT INTO `orderitem` VALUES ('ab0659aa-8633-47c9-ba54-007414d0bb85', '33eb296c-44a7-465d-a2de-164a3ee2f0a4', 1);
INSERT INTO `orderitem` VALUES ('c1f5d4ca-3857-45c9-a4a5-4202be309cd1', '2c3ea884-cf8c-4f60-8f7e-7bcdb553413e', 1);
INSERT INTO `orderitem` VALUES ('ce453ed1-3691-4b38-be9d-849253b1e3e1', '2c3ea884-cf8c-4f60-8f7e-7bcdb553413e', 1);
INSERT INTO `orderitem` VALUES ('d20f5229-f7a0-4725-bec9-1522bdf6028f', '2c3ea884-cf8c-4f60-8f7e-7bcdb553413e', 1);
INSERT INTO `orderitem` VALUES ('dd1c2af3-35ce-4be4-a6f5-2b7d7274c4d0', '1f960132-d34a-4547-9592-6518365291fe', 1);
INSERT INTO `orderitem` VALUES ('e17adbbf-114b-48b1-b823-82147872a0be', '60ed6ec4-29d0-4ff2-b2e7-83d32832dc6a', 1);
INSERT INTO `orderitem` VALUES ('e17adbbf-114b-48b1-b823-82147872a0be', '709f46ea-ca60-498a-aec4-cdb42965a466', 1);
INSERT INTO `orderitem` VALUES ('e6ce7bc2-34a0-4e16-ae20-c2ab4a27f7a0', '33eb296c-44a7-465d-a2de-164a3ee2f0a4', 1);
INSERT INTO `orderitem` VALUES ('e773862b-ee8a-44c6-871a-62bae008d33d', '120f302b-5c05-45f0-b653-1e48879de076', 1);
INSERT INTO `orderitem` VALUES ('ea1bf8f5-f9d7-448e-bc1d-015b17fee85c', '2c3ea884-cf8c-4f60-8f7e-7bcdb553413e', 1);
INSERT INTO `orderitem` VALUES ('f20e96ef-4e17-4bc8-916f-f1b581d40e14', '2c3ea884-cf8c-4f60-8f7e-7bcdb553413e', 1);
INSERT INTO `orderitem` VALUES ('f35d485b-fe57-4ec5-af24-94cb4c021c55', '2c3ea884-cf8c-4f60-8f7e-7bcdb553413e', 1);

SET FOREIGN_KEY_CHECKS = 1;
