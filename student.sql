/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 80022
Source Host           : localhost:3306
Source Database       : keshe

Target Server Type    : MYSQL
Target Server Version : 80022
File Encoding         : 65001

Date: 2021-01-14 10:01:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `admin_id` char(255) NOT NULL,
  `admin_name` char(255) DEFAULT NULL,
  `admin_password` char(255) DEFAULT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('666', null, '888');

-- ----------------------------
-- Table structure for `course`
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `course_id` int NOT NULL,
  `course_name` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `course_time` char(255) DEFAULT NULL,
  `course_place` char(255) DEFAULT NULL,
  `tea_name` char(255) DEFAULT NULL,
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('101', 'Chinese', '周一第一大节', 'B211', '黄某');
INSERT INTO `course` VALUES ('102', 'Math', '周二第三大节', 'A415', '黄某');
INSERT INTO `course` VALUES ('103', 'English', '周三第五大节', 'C101', '黄某');
INSERT INTO `course` VALUES ('104', '计网', '周四第二大节', 'D505', '蔡某');

-- ----------------------------
-- Table structure for `score`
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score` (
  `stu_id` int NOT NULL,
  `course_id` int NOT NULL,
  `score` char(255) DEFAULT NULL,
  `stu_name` char(255) DEFAULT NULL,
  `course_name` char(255) DEFAULT NULL,
  PRIMARY KEY (`stu_id`,`course_id`),
  KEY `key2` (`course_id`),
  CONSTRAINT `key1` FOREIGN KEY (`stu_id`) REFERENCES `student` (`stu_id`),
  CONSTRAINT `key2` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES ('1', '101', '100', '何东就', ' Chinese');
INSERT INTO `score` VALUES ('1', '102', null, '何东就', ' Math');
INSERT INTO `score` VALUES ('1', '103', null, '何东就', ' English');
INSERT INTO `score` VALUES ('1', '104', null, '何东就', ' 计网');
INSERT INTO `score` VALUES ('2', '101', '100', '黄朗星', ' Chinese');
INSERT INTO `score` VALUES ('3', '101', null, '黄志成', ' Chinese');
INSERT INTO `score` VALUES ('3', '102', null, '黄志成', ' Math');
INSERT INTO `score` VALUES ('3', '103', null, '黄志成', ' English');
INSERT INTO `score` VALUES ('3', '104', null, '黄志成', ' 计网');
INSERT INTO `score` VALUES ('4', '101', null, '陆俊江', ' Chinese');
INSERT INTO `score` VALUES ('4', '102', null, '陆俊江', ' Math');
INSERT INTO `score` VALUES ('4', '103', null, '陆俊江', ' English');
INSERT INTO `score` VALUES ('4', '104', null, '陆俊江', ' 计网');
INSERT INTO `score` VALUES ('5', '101', null, '蔡诗芸', ' Chinese');
INSERT INTO `score` VALUES ('5', '102', null, '蔡诗芸', ' Math');
INSERT INTO `score` VALUES ('5', '103', null, '蔡诗芸', ' English');
INSERT INTO `score` VALUES ('5', '104', null, '蔡诗芸', ' 计网');

-- ----------------------------
-- Table structure for `select_course`
-- ----------------------------
DROP TABLE IF EXISTS `select_course`;
CREATE TABLE `select_course` (
  `stu_id` int NOT NULL,
  `course_id` int NOT NULL,
  `course_name` char(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `course_time` char(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `course_place` char(255) DEFAULT NULL,
  PRIMARY KEY (`stu_id`,`course_id`),
  KEY `key4` (`course_id`),
  CONSTRAINT `key3` FOREIGN KEY (`stu_id`) REFERENCES `student` (`stu_id`),
  CONSTRAINT `key4` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of select_course
-- ----------------------------
INSERT INTO `select_course` VALUES ('1', '101', ' Chinese', ' 周一第一大节', ' B211');
INSERT INTO `select_course` VALUES ('1', '102', ' Math', ' 周二第三大节', ' A415');
INSERT INTO `select_course` VALUES ('1', '103', ' English', ' 周三第五大节', ' C101');
INSERT INTO `select_course` VALUES ('1', '104', ' 计网', ' 周四第二大节', ' D505');
INSERT INTO `select_course` VALUES ('2', '101', ' Chinese', ' 周一第一大节', ' B211');
INSERT INTO `select_course` VALUES ('3', '101', ' Chinese', ' 周一第一大节', ' B211');
INSERT INTO `select_course` VALUES ('3', '102', ' Math', ' 周二第三大节', ' A415');
INSERT INTO `select_course` VALUES ('3', '103', ' English', ' 周三第五大节', ' C101');
INSERT INTO `select_course` VALUES ('3', '104', ' 计网', ' 周四第二大节', ' D505');
INSERT INTO `select_course` VALUES ('4', '101', ' Chinese', ' 周一第一大节', ' B211');
INSERT INTO `select_course` VALUES ('4', '102', ' Math', ' 周二第三大节', ' A415');
INSERT INTO `select_course` VALUES ('4', '103', ' English', ' 周三第五大节', ' C101');
INSERT INTO `select_course` VALUES ('4', '104', ' 计网', ' 周四第二大节', ' D505');
INSERT INTO `select_course` VALUES ('5', '101', ' Chinese', ' 周一第一大节', ' B211');
INSERT INTO `select_course` VALUES ('5', '102', ' Math', ' 周二第三大节', ' A415');
INSERT INTO `select_course` VALUES ('5', '103', ' English', ' 周三第五大节', ' C101');
INSERT INTO `select_course` VALUES ('5', '104', ' 计网', ' 周四第二大节', ' D505');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `stu_id` int NOT NULL,
  `stu_name` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `password` char(255) DEFAULT NULL,
  PRIMARY KEY (`stu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '何东就', '111');
INSERT INTO `student` VALUES ('2', '黄朗星', '222');
INSERT INTO `student` VALUES ('3', '黄志成', '333');
INSERT INTO `student` VALUES ('4', '陆俊江', '444');
INSERT INTO `student` VALUES ('5', '蔡诗芸', '555');
INSERT INTO `student` VALUES ('7', '麦凯晴', '777');

-- ----------------------------
-- Table structure for `teacher`
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `tea_id` int NOT NULL,
  `tea_name` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `password` char(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`tea_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('6', '何某', '666');

-- ----------------------------
-- Table structure for `teach_course`
-- ----------------------------
DROP TABLE IF EXISTS `teach_course`;
CREATE TABLE `teach_course` (
  `tea_id` int NOT NULL,
  `course_id` int NOT NULL,
  `teach_time` char(20) DEFAULT NULL,
  `course_name` char(255) DEFAULT NULL,
  `teach_place` char(255) DEFAULT NULL,
  PRIMARY KEY (`tea_id`,`course_id`),
  KEY `key6` (`course_id`),
  CONSTRAINT `key5` FOREIGN KEY (`tea_id`) REFERENCES `teacher` (`tea_id`),
  CONSTRAINT `key6` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of teach_course
-- ----------------------------
INSERT INTO `teach_course` VALUES ('6', '101', '周一第一大节', 'Chinese', 'B211');
INSERT INTO `teach_course` VALUES ('6', '102', '周二第三大节', 'Math', 'A415');
INSERT INTO `teach_course` VALUES ('6', '103', '周三第五大节', 'English', 'C101');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int NOT NULL,
  `username` char(255) DEFAULT NULL,
  `password` char(255) DEFAULT NULL,
  `role` char(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
