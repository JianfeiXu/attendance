/*
Navicat MySQL Data Transfer

Source Server         : 10.1.51.239
Source Server Version : 50547
Source Host           : 10.1.51.239:3306
Source Database       : attendance

Target Server Type    : MYSQL
Target Server Version : 50547
File Encoding         : 65001

Date: 2016-08-31 18:10:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `attendance_leave`
-- ----------------------------
DROP TABLE IF EXISTS `attendance_leave`;
CREATE TABLE `attendance_leave` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `period_id` varchar(32) NOT NULL COMMENT '考勤周期id',
  `name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `department` varchar(50) DEFAULT NULL COMMENT '部门',
  `start_date` varchar(15) DEFAULT NULL COMMENT '起始日期',
  `start_time` varchar(10) DEFAULT NULL COMMENT '起始时间',
  `end_date` varchar(15) DEFAULT NULL COMMENT '结束日期',
  `end_time` varchar(10) DEFAULT NULL COMMENT '结束时间',
  `type` char(1) DEFAULT NULL,
  `reason` varchar(150) DEFAULT NULL COMMENT '理由',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='请假记录表';

-- ----------------------------
-- Records of attendance_leave
-- ----------------------------

-- ----------------------------
-- Table structure for `attendance_period`
-- ----------------------------
DROP TABLE IF EXISTS `attendance_period`;
CREATE TABLE `attendance_period` (
  `id` varchar(32) NOT NULL COMMENT '主键id',
  `period_name` varchar(50) NOT NULL COMMENT '周期名称',
  `period_start_date` varchar(15) DEFAULT NULL COMMENT '开始日期',
  `period_end_date` varchar(15) DEFAULT NULL COMMENT '结束日期',
  `work_day` varchar(200) DEFAULT NULL COMMENT '工作日',
  `status` int(11) DEFAULT '0' COMMENT '状态(2:工牌打卡,4:叮叮打卡,8:请假记录)位与运算',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='考勤周期管理表';

-- ----------------------------
-- Records of attendance_period
-- ----------------------------

-- ----------------------------
-- Table structure for `attendance_raw_clock_record`
-- ----------------------------
DROP TABLE IF EXISTS `attendance_raw_clock_record`;
CREATE TABLE `attendance_raw_clock_record` (
  `id` varchar(32) NOT NULL DEFAULT '' COMMENT '主键id',
  `name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `department` varchar(50) DEFAULT NULL COMMENT '部门',
  `date` varchar(15) DEFAULT NULL COMMENT '日期',
  `clock_in` varchar(10) DEFAULT NULL COMMENT '上班打卡时间',
  `clock_off` varchar(10) DEFAULT NULL COMMENT '下班打卡时间',
  `type` char(1) DEFAULT NULL COMMENT '打卡类型(1:工牌打卡,2:叮叮打卡)',
  `is_in_company` char(1) DEFAULT '1' COMMENT '是否在公司打卡(叮叮在外地考勤,1:是,0:否)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='打卡原始记录';

-- ----------------------------
-- Records of attendance_raw_clock_record
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `username` varchar(32) NOT NULL COMMENT '账号',
  `password` varchar(30) DEFAULT NULL COMMENT '密码',
  `enabled` char(1) DEFAULT '1' COMMENT '是否启用(1:启用,0:禁用)',
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('admin', 'admin{id}', '1');
