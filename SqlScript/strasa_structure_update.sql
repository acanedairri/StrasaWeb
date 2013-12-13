/*
SQLyog Community v11.28 (64 bit)
MySQL - 5.7.3-m13-log : Database - strasa
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`strasa` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `strasa`;

/*Table structure for table `germplasm` */

DROP TABLE IF EXISTS `germplasm`;

CREATE TABLE `germplasm` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gid` int(10) DEFAULT NULL,
  `germplasmname` varchar(50) DEFAULT NULL,
  `othername` varchar(50) DEFAULT NULL,
  `breeder` varchar(50) DEFAULT NULL,
  `germplasmtypeid` int(5) DEFAULT NULL,
  `irnumber` varchar(20) DEFAULT NULL,
  `ircross` varchar(20) DEFAULT NULL,
  `parentage` varchar(50) DEFAULT NULL,
  `femaleparent` varchar(50) DEFAULT NULL,
  `maleparent` varchar(50) DEFAULT NULL,
  `selectionhistory` varchar(50) DEFAULT NULL,
  `source` varchar(50) DEFAULT NULL,
  `remarks` varchar(200) DEFAULT NULL,
  `userid` int(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

/*Table structure for table `location` */

DROP TABLE IF EXISTS `location`;

CREATE TABLE `location` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `locationname` varchar(100) DEFAULT NULL,
  `country` varchar(50) DEFAULT NULL,
  `province` varchar(100) DEFAULT NULL,
  `region` varchar(100) DEFAULT NULL,
  `altitude` varchar(50) DEFAULT NULL,
  `latitude` varchar(50) DEFAULT NULL,
  `weatherstation` varchar(50) DEFAULT NULL,
  `userid` int(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=latin1;

/*Table structure for table `studydatacolumn` */

DROP TABLE IF EXISTS `studydatacolumn`;

CREATE TABLE `studydatacolumn` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `studyid` int(10) DEFAULT NULL,
  `dataset` int(10) DEFAULT NULL,
  `columnheader` varchar(20) DEFAULT NULL,
  `datatype` enum('dd','rd') DEFAULT 'rd',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=300 DEFAULT CHARSET=latin1;

/*Table structure for table `studyderiveddata` */

DROP TABLE IF EXISTS `studyderiveddata`;

CREATE TABLE `studyderiveddata` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `studyid` int(10) DEFAULT NULL,
  `dataset` int(10) DEFAULT NULL,
  `datarow` int(10) DEFAULT NULL,
  `datacolumn` varchar(20) DEFAULT NULL,
  `datavalue` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=latin1;

/*Table structure for table `studygermplasm` */

DROP TABLE IF EXISTS `studygermplasm`;

CREATE TABLE `studygermplasm` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `studyid` int(10) DEFAULT NULL,
  `dataset` int(11) DEFAULT NULL,
  `gid` int(10) DEFAULT NULL,
  `germplasmname` varchar(50) DEFAULT NULL,
  `othername` varchar(50) DEFAULT NULL,
  `breeder` varchar(50) DEFAULT NULL,
  `germplasmtypeid` int(5) DEFAULT NULL,
  `irnumber` varchar(20) DEFAULT NULL,
  `ircross` varchar(20) DEFAULT NULL,
  `parentage` varchar(50) DEFAULT NULL,
  `femaleparent` varchar(50) DEFAULT NULL,
  `maleparent` varchar(50) DEFAULT NULL,
  `selectionhistory` varchar(50) DEFAULT NULL,
  `source` varchar(50) DEFAULT NULL,
  `remarks` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=latin1;

/*Table structure for table `studylocation` */

DROP TABLE IF EXISTS `studylocation`;

CREATE TABLE `studylocation` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `studyid` int(10) DEFAULT NULL,
  `dataset` int(11) DEFAULT NULL,
  `locationid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

/*Table structure for table `studyrawdata` */

DROP TABLE IF EXISTS `studyrawdata`;

CREATE TABLE `studyrawdata` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `studyid` int(10) DEFAULT NULL,
  `dataset` int(10) DEFAULT NULL,
  `datarow` int(10) DEFAULT NULL,
  `datacolumn` varchar(20) DEFAULT NULL,
  `datavalue` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=625 DEFAULT CHARSET=latin1;

/*Table structure for table `studysite` */

DROP TABLE IF EXISTS `studysite`;

CREATE TABLE `studysite` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `studyid` int(10) DEFAULT NULL,
  `dataset` int(11) DEFAULT NULL,
  `year` varchar(4) DEFAULT NULL,
  `season` varchar(10) DEFAULT NULL,
  `sitename` varchar(100) DEFAULT NULL,
  `sitelocation` varchar(200) DEFAULT NULL,
  `locationid` int(50) DEFAULT NULL,
  `ecotypeid` int(5) DEFAULT NULL,
  `soiltype` varchar(50) DEFAULT NULL,
  `soilph` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
