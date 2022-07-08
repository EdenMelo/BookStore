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

 Date: 08/07/2022 21:49:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for products
-- ----------------------------
DROP TABLE IF EXISTS `products`;
CREATE TABLE `products`  (
  `id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `price` double(10, 1) NULL DEFAULT NULL,
  `category` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pnum` int(0) NULL DEFAULT NULL,
  `imgurl` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of products
-- ----------------------------
INSERT INTO `products` VALUES ('120f302b-5c05-45f0-b653-1e48879de076', '东京贫困女子', 22.0, '社科', 44, 'WebContent/client/bookImg/dongjingnvzi.jpg', '中村淳彦');
INSERT INTO `products` VALUES ('1f960132-d34a-4547-9592-6518365291fe', '超越期待 : 松浦弥太郎的人生经营原则', 33.0, '经营', 21, 'WebContent/client/bookImg/chaoyueqidai.jpg', '松浦弥太郎');
INSERT INTO `products` VALUES ('2c3ea884-cf8c-4f60-8f7e-7bcdb553413e', '史蒂夫·乔布斯传', 88.0, '科技', 92, 'WebContent/client/bookImg/qiaobusi.jpg', '沃尔特·艾萨克森');
INSERT INTO `products` VALUES ('33eb296c-44a7-465d-a2de-164a3ee2f0a4', '活着', 50.0, '生活', 92, 'WebContent/client/bookImg/huozhe.webp', '余华');
INSERT INTO `products` VALUES ('3626d248-55a8-4cde-9332-040401393f58', '一万天的奇迹 : 一位抗癌女性的坚韧人生', 123123.0, '励志', 7, 'WebContent/client/bookImg/yiwantianqiji.jpg', '朱莉·叶·威廉姆斯');
INSERT INTO `products` VALUES ('40196dab-07a3-4aba-abb6-504d7a6dd41c', '解忧杂货铺', 30.0, '文学', 5, 'WebContent/client/bookImg/jieyouzahuo.jpg', '东野圭吾');
INSERT INTO `products` VALUES ('4452479d-d150-424e-a760-e7460112ba0d', '穿越计算机的迷雾', 11.0, '计算机', 5, 'WebContent/client/bookImg/chuanyuejisuanji.jpg', 'orange');
INSERT INTO `products` VALUES ('4dcb9742-3e07-4e84-97bd-96ac5e7f1f1d', '你当像鸟飞往你的山', 22.0, '励志', 57, 'WebContent/client/bookImg/xiangniaofeiguoshan.jpg', '塔拉·韦斯特弗');
INSERT INTO `products` VALUES ('60ed6ec4-29d0-4ff2-b2e7-83d32832dc6a', '计算机科学概论', 10.0, '计算机', 5, 'WebContent/client/bookImg/kexuegailun.jpg', 'banana');
INSERT INTO `products` VALUES ('709f46ea-ca60-498a-aec4-cdb42965a466', '身边的科学', 888.0, '生活百科', 29, 'WebContent/client/bookImg/shenbiandekexue.jpg', 'strawberry is very delicious');
INSERT INTO `products` VALUES ('72c52302-cd1e-4a22-8ac8-dc300a915be5', '计算机导论', 59.0, '计算机', 47, 'WebContent/client/bookImg/jisuanjidaolun.jpg', '计算机导论');
INSERT INTO `products` VALUES ('7317a248-1adf-460a-9d50-f764bc9fa58f', '知日·杂货', 20.0, '生活百科', 8, 'WebContent/client/bookImg/zhirizahuo.jpg', '苏静');
INSERT INTO `products` VALUES ('7379565b-b585-4d24-82a7-a84021b58a24', '置身事外', 66.0, '经营', 50, 'WebContent/client/bookImg/zhishenshiwai.jpg', '兰小欢');
INSERT INTO `products` VALUES ('79bbe618-d2f8-4081-b35a-62ebbe938b64', '计算机网络', 44.5, '计算机', 55, 'WebContent/client/bookImg/jisuanjiwangluo.jpg', '计算机网络');
INSERT INTO `products` VALUES ('7d032584-c922-4de2-8729-8e791c6a4074', '中日交流标准日本语', 30.0, '外语', 3, 'WebContent/client/bookImg/ribenyu.jpg', '人民教育出版社');
INSERT INTO `products` VALUES ('8020cadd-8966-4b90-913c-5804913a07b0', '五年高考三年模拟', 10.0, '考试', 998, 'WebContent/client/bookImg/wuniansannian.jpg', 'FT');
INSERT INTO `products` VALUES ('84c842da-16b6-4e87-953e-859a1ca62bab', '软件工程', 89.0, '计算机', 42, 'WebContent\\client\\bookImg\\ruanjiangongcheng.jpg', '软件工程');
INSERT INTO `products` VALUES ('912f15ef-0288-4e2d-9b67-43039305270f', '工作消费主义和新穷人', 67.0, '社科', 29, 'WebContent\\client\\bookImg\\xinqiongren.jpg', '齐格蒙特·鲍曼');
INSERT INTO `products` VALUES ('afd0a00f-4652-4a05-8cd0-46514c83560f', '冒险小虎队', 50.0, '少儿', 29, 'WebContent\\client\\bookImg\\xiaohudui.jpg', '托马斯·布热齐纳');
INSERT INTO `products` VALUES ('b012bd74-944b-441e-b499-b72bddcd001b', '艺术的故事', 227.0, '艺术', 10, 'WebContent\\client\\bookImg\\yishugushi.jpg', '贡布里希');
INSERT INTO `products` VALUES ('d415114d-cc2f-4182-9dea-0f765ef2167d', '认知觉醒 : 开启自我改变的原动力', 55.0, '励志', 77, 'WebContent\\client\\bookImg\\renzhijuexing.jpg', '周岭');
INSERT INTO `products` VALUES ('d8b3bd89-53b6-431a-8e67-d38fcff1a3d8', '西瓜', 123123.0, '文学', 114511, 'WebContent\\client\\bookImg\\wenxuehuiyi.jpg', 'watermelon');
INSERT INTO `products` VALUES ('ec1a71c5-cc75-433b-95b8-cb6dae5d460f', 'Harry Potter', 114.0, '原版', 77, 'WebContent\\client\\bookImg\\harrypotter.jpg', 'J. K. Rowling');
INSERT INTO `products` VALUES ('eca5a437-720d-459b-bf8b-b331e4cef7a5', '叫魂 : 1768年中国妖术大恐慌', 30.0, '学术', 30, 'WebContent\\client\\bookImg\\jiaohun.jpg', '孔飞力');

SET FOREIGN_KEY_CHECKS = 1;
