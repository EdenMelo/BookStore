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

 Date: 08/07/2022 21:48:36
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `money` double NULL DEFAULT NULL,
  `receiverAddress` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `receiverName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `receiverPhone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `paystate` int(0) NULL DEFAULT NULL,
  `ordertime` timestamp(0) NULL DEFAULT NULL,
  `user_id` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('005e3b79-6f30-4da8-a415-ca768a0bc014', 66, '超越期待-2', 'Test1', '123456789', 1, '2022-06-14 01:07:04', 3);
INSERT INTO `orders` VALUES ('087ecdd0-8a52-4a27-8236-e90368e3b790', 121, 'testPay', 'pay', '123456789', 1, '2022-06-20 00:55:02', 3);
INSERT INTO `orders` VALUES ('0c0796f2-0124-4a13-a891-5efbb63b04f9', 44.5, '北京市昌平区金燕龙办公楼', 'hanyongmeng', '15207545526', 1, '2022-05-01 10:36:36', 4);
INSERT INTO `orders` VALUES ('0ce9abb2-0846-47b8-890b-5d13ce6e3a6c', 138, '动感小西关', 'Rider1', '114514', 1, '2022-05-29 06:44:11', 4);
INSERT INTO `orders` VALUES ('0d29ab05-a214-4cd9-a6bd-ecea5cf4a150', 33, '测试地址', '测试收货人', '13132', 1, '2022-06-20 00:39:10', 3);
INSERT INTO `orders` VALUES ('305a7870-3820-4079-b6f9-5d2b63cbcd2a', 59, '北京市昌平区建材城西路金燕龙办公楼', 'huangyun', '13041019968', 1, '2022-01-13 15:14:54', 3);
INSERT INTO `orders` VALUES ('41b9bf6f-ee9c-4f70-a70f-bb6aeeba47d6', 94, '广州市越秀区动漫星城-负三楼', 'Test1', '123456789', 1, '2022-06-02 02:53:18', 3);
INSERT INTO `orders` VALUES ('4c2eeb61-d917-4ad3-acf9-781e74094738', 50, '广州市越秀区动漫星城-负三楼', 'asdasddas', '123456789', 1, '2022-06-13 11:36:42', 3);
INSERT INTO `orders` VALUES ('51a1cd30-d9c4-4b01-8c83-cab5795417ec', 110, '广州市越秀区动漫星城-负二楼', 'BuyTest', '123456789', 1, '2022-06-16 12:08:08', 3);
INSERT INTO `orders` VALUES ('62913cd4-76ce-4c1f-b80a-6eb00cb4d237', 61, '广州市越秀区动漫星城-负二楼', 'finalTest', '123456789', 0, '2022-06-16 11:04:21', 3);
INSERT INTO `orders` VALUES ('76465caf-ca77-4946-ae31-8d36d89df6e8', 138, '广州市越秀区动漫星城-负二楼', '测试用例1', '123456789', 1, '2022-06-16 15:08:35', 3);
INSERT INTO `orders` VALUES ('831bfeeb-4ce5-4852-9c61-cd57cc61f733', 138, '广州市越秀区动漫星城-负三楼', 'Test1', '123456789', 1, '2022-06-02 02:54:05', 3);
INSERT INTO `orders` VALUES ('a8307033-7b25-41bf-b5e8-dda30a936775', 138, 'testAddress', 'Test1', '123456789', 1, '2022-06-20 00:56:42', 3);
INSERT INTO `orders` VALUES ('c1f5d4ca-3857-45c9-a4a5-4202be309cd1', 88, '123', 'Test1', '123456789', 1, '2022-06-13 11:53:06', 3);
INSERT INTO `orders` VALUES ('ce453ed1-3691-4b38-be9d-849253b1e3e1', 88, 'finalTest', '1111', '123456789', 0, '2022-06-20 00:52:17', 3);
INSERT INTO `orders` VALUES ('e17adbbf-114b-48b1-b823-82147872a0be', 898, '广州市越秀区动漫星城-负三楼', 'Test1', '12345678', 1, '2022-05-28 14:43:46', 3);
INSERT INTO `orders` VALUES ('e773862b-ee8a-44c6-871a-62bae008d33d', 22, '广州市越秀区动漫星城-负三楼', 'Test1', '12345678', 1, '2022-05-29 09:57:06', 3);
INSERT INTO `orders` VALUES ('ea1bf8f5-f9d7-448e-bc1d-015b17fee85c', 88, '广州市越秀区动漫星城-负三楼', 'Test1', '12345678', 1, '2022-05-29 06:44:49', 3);
INSERT INTO `orders` VALUES ('f20e96ef-4e17-4bc8-916f-f1b581d40e14', 88, '广州市越秀区动漫星城-负二楼', 'Test1', '123456789', 0, '2022-06-20 00:38:07', 3);

SET FOREIGN_KEY_CHECKS = 1;
