/*
 Navicat Premium Data Transfer

 Source Server         : 03112022demo
 Source Server Type    : MySQL
 Source Server Version : 50737
 Source Host           : 192.144.213.195:3310
 Source Schema         : morandi

 Target Server Type    : MySQL
 Target Server Version : 50737
 File Encoding         : 65001

 Date: 01/05/2022 20:39:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int(11) NOT NULL,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `imaurl` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'root', 'admin', 'nmae', 'null');

-- ----------------------------
-- Table structure for cj
-- ----------------------------
DROP TABLE IF EXISTS `cj`;
CREATE TABLE `cj`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `kemu` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `price` double(10, 2) NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT ' 发布者laoshi',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1007 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cj
-- ----------------------------
INSERT INTO `cj` VALUES (1000, NULL, 20.00, '6687');
INSERT INTO `cj` VALUES (1001, NULL, 59.00, '0001');
INSERT INTO `cj` VALUES (1002, ' ', 1.00, '123');
INSERT INTO `cj` VALUES (1003, ' ', 13.00, '1234577');
INSERT INTO `cj` VALUES (1004, ' ', 19.00, '01');
INSERT INTO `cj` VALUES (1005, ' ', 123.00, '02');
INSERT INTO `cj` VALUES (1006, ' ', 98.00, '03');

-- ----------------------------
-- Table structure for homewokeS
-- ----------------------------
DROP TABLE IF EXISTS `homewokeS`;
CREATE TABLE `homewokeS`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `homewokeid` int(11) NULL DEFAULT NULL COMMENT '对应作业id',
  `username` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '对应的学生',
  `state` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '作业提交状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 51 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of homewokeS
-- ----------------------------
INSERT INTO `homewokeS` VALUES (2, 1, '6687', '已完成');
INSERT INTO `homewokeS` VALUES (3, 1, '0001', '已完成');
INSERT INTO `homewokeS` VALUES (4, 18, '6687', '已完成');
INSERT INTO `homewokeS` VALUES (5, 18, '6687', '已完成');
INSERT INTO `homewokeS` VALUES (6, 18, '6687', '已完成');
INSERT INTO `homewokeS` VALUES (7, 18, '0001', '已完成');
INSERT INTO `homewokeS` VALUES (8, 18, '0001', '已完成');
INSERT INTO `homewokeS` VALUES (9, 18, '6687', '已完成');
INSERT INTO `homewokeS` VALUES (10, 18, '6687', '已完成');
INSERT INTO `homewokeS` VALUES (11, 18, '6687', '已完成');
INSERT INTO `homewokeS` VALUES (16, 25, '123', '已完成');
INSERT INTO `homewokeS` VALUES (20, 25, '6687', '已完成');
INSERT INTO `homewokeS` VALUES (23, 25, '0001', '已完成');
INSERT INTO `homewokeS` VALUES (24, 25, '1234577', '已完成');
INSERT INTO `homewokeS` VALUES (29, 26, '6687', '已完成');
INSERT INTO `homewokeS` VALUES (30, 1, '6688', '已完成');
INSERT INTO `homewokeS` VALUES (32, 30, '01', '已完成');
INSERT INTO `homewokeS` VALUES (33, 30, '', '已完成');
INSERT INTO `homewokeS` VALUES (34, 30, '12345', '已完成');
INSERT INTO `homewokeS` VALUES (35, 30, '16544', '已完成');
INSERT INTO `homewokeS` VALUES (36, 30, '12345', '已完成');
INSERT INTO `homewokeS` VALUES (37, 30, '16544', '已完成');
INSERT INTO `homewokeS` VALUES (38, 30, '16544', '已完成');
INSERT INTO `homewokeS` VALUES (39, 30, '12345', '已完成');
INSERT INTO `homewokeS` VALUES (40, 32, '01', '已完成');
INSERT INTO `homewokeS` VALUES (41, 32, '02', '已完成');
INSERT INTO `homewokeS` VALUES (42, 31, '01', '已完成');
INSERT INTO `homewokeS` VALUES (43, 31, '02', '已完成');
INSERT INTO `homewokeS` VALUES (44, 1, '6688', '已完成');
INSERT INTO `homewokeS` VALUES (45, 1, '6688', '已完成');
INSERT INTO `homewokeS` VALUES (46, 1, '6688', '已完成');
INSERT INTO `homewokeS` VALUES (47, 1, '6688', '已完成');
INSERT INTO `homewokeS` VALUES (48, 1, '6688', '已完成');
INSERT INTO `homewokeS` VALUES (49, 30, '02', '已完成');
INSERT INTO `homewokeS` VALUES (50, 30, '03', '已完成');

-- ----------------------------
-- Table structure for homework
-- ----------------------------
DROP TABLE IF EXISTS `homework`;
CREATE TABLE `homework`  (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `time` date NULL DEFAULT NULL,
  `teacher` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `context` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 39 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of homework
-- ----------------------------
INSERT INTO `homework` VALUES (30, '数学作业', '2022-04-05', NULL, '全品P97');
INSERT INTO `homework` VALUES (31, '语文作业', '2022-04-05', NULL, '出师表背诵第三段');
INSERT INTO `homework` VALUES (32, '英语作业', '2022-04-06', NULL, '五三P35');
INSERT INTO `homework` VALUES (33, '我是张三', '2022-04-06', 'wu', '这是正文');
INSERT INTO `homework` VALUES (34, '我是张三', '2022-04-07', 'wu', '这是正文');
INSERT INTO `homework` VALUES (35, '我是张三', '2022-04-07', 'wu', '这是正文');
INSERT INTO `homework` VALUES (36, '我是张三', '2022-04-07', 'wu', '这是正文');
INSERT INTO `homework` VALUES (37, '我是张三', '2022-04-07', 'wu', '这是正文');
INSERT INTO `homework` VALUES (38, '地理作业', '2022-04-10', NULL, '34');

-- ----------------------------
-- Table structure for homeworkstate
-- ----------------------------
DROP TABLE IF EXISTS `homeworkstate`;
CREATE TABLE `homeworkstate`  (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'username of student\r\nusername of the student',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'name of the student',
  `state` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'state of the homework of the student',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of homeworkstate
-- ----------------------------

-- ----------------------------
-- Table structure for jz
-- ----------------------------
DROP TABLE IF EXISTS `jz`;
CREATE TABLE `jz`  (
  `int` int(11) NOT NULL AUTO_INCREMENT,
  `son` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT ' 写学生的username',
  `parent` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '家长的username',
  PRIMARY KEY (`int`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1000 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of jz
-- ----------------------------
INSERT INTO `jz` VALUES (1, '6687', '1234');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `imaurl` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `role` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `sonusername` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1042 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (4, '1234', '1234567', '莫大123', 'https://morandizj.oss-cn-beijing.aliyuncs.com/1234/75f412ad-5b94-4a2f-9ac0-59ffd00eb71dfiles612f53d9-b95b-46b5-a54f-ec6219c70d5e.png.png', 'guardian', '6687');
INSERT INTO `user` VALUES (1027, 'trr', 'trr', NULL, NULL, 'parents', 'trr');
INSERT INTO `user` VALUES (1035, '234', '345', NULL, NULL, 'guardian', '120183503012');
INSERT INTO `user` VALUES (1036, '01', '123456', '王诗琪', 'https://morandizj.oss-cn-beijing.aliyuncs.com/01/612395d8-eeff-4bf3-a93b-b4bebc0ac47efiles33b010fe-455e-4cd9-8735-b21b9c0574d0.png', 'student', '');
INSERT INTO `user` VALUES (1037, '001', '123456', '王诗琪妈妈', NULL, 'guardian', '01');
INSERT INTO `user` VALUES (1038, '02', '123456', '张偲露', 'https://morandizj.oss-cn-beijing.aliyuncs.com/02/05defe5b-ea85-400c-9444-c3c5f6ab27a2files6dd2784d-9bf3-424d-9a5c-5fa21893c551.png', 'student', '');
INSERT INTO `user` VALUES (1039, '002', '123456', NULL, NULL, 'guardian', '02');
INSERT INTO `user` VALUES (1040, '03', '123456', '郭颖', 'https://morandizj.oss-cn-beijing.aliyuncs.com/03/ae326e21-9df8-4769-87b6-65ff30a9ea56files8bf62613-285e-459d-8856-499f65470cf3.png.png', 'student', '');
INSERT INTO `user` VALUES (1041, '003', '123456', NULL, NULL, 'guardian', '03');

-- ----------------------------
-- Table structure for zpq
-- ----------------------------
DROP TABLE IF EXISTS `zpq`;
CREATE TABLE `zpq`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `imaurl` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `miaoshu` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of zpq
-- ----------------------------
INSERT INTO `zpq` VALUES (1, 'https://cube.elemecdn.com/6/94/4d3ea53c084bad6931a56d5158a48jpeg.jpeg', '123', '123');
INSERT INTO `zpq` VALUES (2, 'https://morandizj.oss-cn-beijing.aliyuncs.com/1234/8625a87b-9a5f-463b-9f63-ec91b5a213d0filesafc4c8a2-0e52-43c1-8711-a8761fab9bc2.png', '456', '123');
INSERT INTO `zpq` VALUES (3, 'https://morandizj.oss-cn-beijing.aliyuncs.com/1234/1b491c7d-0db9-46e8-8d92-c319929300d8filesd5552cda-3a53-43ca-9d53-9f53433469f9.png', '567', '098');
INSERT INTO `zpq` VALUES (8, 'https://morandizj.oss-cn-beijing.aliyuncs.com/1234/99eabd34-8f40-497d-97ea-8fa40e2c5801files.png', 'ps作业', '');
INSERT INTO `zpq` VALUES (9, 'https://morandizj.oss-cn-beijing.aliyuncs.com/03/2c613d0f-34bd-401e-8061-460350515e9dfiles.png', '过年好', '');

-- ----------------------------
-- Table structure for zpqly
-- ----------------------------
DROP TABLE IF EXISTS `zpqly`;
CREATE TABLE `zpqly`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `zpdly` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `zpqid` int(11) NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of zpqly
-- ----------------------------
INSERT INTO `zpqly` VALUES (1, '123', 2, '123');
INSERT INTO `zpqly` VALUES (2, '123', 2, '12345');
INSERT INTO `zpqly` VALUES (3, '1234444', 2, '1234');
INSERT INTO `zpqly` VALUES (4, 'test', 3, '1234');
INSERT INTO `zpqly` VALUES (5, '111', 2, '1234');
INSERT INTO `zpqly` VALUES (6, '123123', 2, NULL);
INSERT INTO `zpqly` VALUES (7, '年后', 1, '123456');
INSERT INTO `zpqly` VALUES (8, '在这里了能发布评论\n', 1, '123456');
INSERT INTO `zpqly` VALUES (9, '这里有评论', 6, '1234');
INSERT INTO `zpqly` VALUES (10, '', 2, '03');
INSERT INTO `zpqly` VALUES (11, '123\n', 2, '03');

SET FOREIGN_KEY_CHECKS = 1;
