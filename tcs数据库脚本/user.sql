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

 Date: 31/08/2023 11:10:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `rating` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `open_id` int(11) NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'wl', '磊砸', '$2a$10$GiTUf.zV.dmwn494TvV3.uqGbQwqpesEfEpft2tQ7BBhm9.tCeic2', NULL, '2459405142@qq.com', NULL, '1503', NULL, '2023-07-31 17:08:01');
INSERT INTO `user` VALUES (2, 'wpx', 'wp', '$2a$10$qGfcgxXmYT.g7uOOznemFevBV8mOVY9HjtD44R1.J.EyNTW9HYnwC', NULL, '', NULL, '1503', NULL, '2023-08-28 22:00:47');
INSERT INTO `user` VALUES (3, 'xl', '匿名用户', '$2a$10$wmMXmph9aaHYhac.blHODuvlgJ0MQhTNGbxhvNDBqXdJ/B7LXBo6m', NULL, NULL, NULL, '1500', NULL, '2023-08-29 13:10:49');

SET FOREIGN_KEY_CHECKS = 1;
