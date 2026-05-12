/*
Navicat MySQL Data Transfer

Source Server         : Wjl
Source Server Version : 80034
Source Host           : localhost:3306
Source Database       : jdbc

Target Server Type    : MYSQL
Target Server Version : 80034
File Encoding         : 65001

Date: 2024-04-29 09:40:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `jg`;
CREATE TABLE `jg` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `sex` varchar(2) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;

CREATE TABLE `jiaoguan` (
                            `Id` INT NOT NULL AUTO_INCREMENT,
                            `name` VARCHAR(9) DEFAULT NULL,
                            `sex` VARCHAR(2) DEFAULT NULL,
                            `miaoshu` VARCHAR(50) DEFAULT NULL,
                            `shengri` DATE DEFAULT NULL,
                            PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;

create table users
(
    id       int auto_increment
        primary key,
    name     varchar(40) null,
    password varchar(40) null,
    email    varchar(60) null,
    birthday date        null
)
    charset = utf8mb3;
