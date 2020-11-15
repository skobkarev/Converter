CREATE DATABASE  IF NOT EXISTS `course`;
USE `course`;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;

CREATE TABLE `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `charcode` varchar(45) DEFAULT NULL,
  `nominal` int(10) DEFAULT 0,
  `valutename` varchar(45) DEFAULT NULL,
  `valutevalue` double(10,4) default null,
  today varchar(45) default null,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

--
-- Data for table `course`
--


	

