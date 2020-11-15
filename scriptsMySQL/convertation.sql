
-- Table structure for table `convertation`
--

DROP TABLE IF EXISTS `convertation`;

CREATE TABLE `convertation` (
  `convertationnumber` int(11) NOT NULL auto_increment,
  `valutefrom` varchar(45) DEFAULT NULL,
  `valuteto` varchar(45) DEFAULT NULL,
  `valutefromid` int(20) DEFAULT NULL,
  `valutetoid` int(20) DEFAULT NULL,
  `valutefromvalue` double(11,4) DEFAULT NULL,
  `valutetovalue` double(11,4) default null,
  `valutefromcharcode` varchar(45) DEFAULT NULL,
  `valutetocharcode` varchar(45) DEFAULT NULL,
  
  convertationday varchar(45) default null,
  number int(11) not null,
  
  result double(11,4) not null,
  
  PRIMARY KEY (`convertationnumber`)
) ENGINE=InnoDB auto_increment=1 CHARSET=utf8 ;




	

