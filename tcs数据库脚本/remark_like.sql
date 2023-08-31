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

 Date: 31/08/2023 11:10:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for remark_like
-- ----------------------------
DROP TABLE IF EXISTS `remark_like`;
CREATE TABLE `remark_like`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `remark_id` int(11) NULL DEFAULT NULL,
  `like_user_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of remark_like
-- ----------------------------
INSERT INTO `remark_like` VALUES (2, 1, 2);

SET FOREIGN_KEY_CHECKS = 1;
