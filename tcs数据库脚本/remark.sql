/*
 Navicat Premium Data Transfer

 Source Server         : test
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : kob

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 31/08/2023 11:10:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for remark
-- ----------------------------
DROP TABLE IF EXISTS `remark`;
CREATE TABLE `remark`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `parent_id` int(11) NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of remark
-- ----------------------------
INSERT INTO `remark` VALUES (1, 2, '1111', NULL, '2023-08-28 22:21:33');
INSERT INTO `remark` VALUES (2, 2, '2222', NULL, '2023-08-28 22:39:27');
INSERT INTO `remark` VALUES (3, 2, '111', NULL, '2023-08-29 09:50:17');
INSERT INTO `remark` VALUES (4, 1, '11121', NULL, '2023-08-29 09:51:03');

SET FOREIGN_KEY_CHECKS = 1;
