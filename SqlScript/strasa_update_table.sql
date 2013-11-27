/*
SQLyog Community Edition- MySQL GUI v6.03
Host - 5.5.23-log : Database - strasa
*********************************************************************
Server version : 5.5.23-log
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=512 DEFAULT CHARSET=latin1;

/*Table structure for table `germplasmcharacteristics` */

DROP TABLE IF EXISTS `germplasmcharacteristics`;

CREATE TABLE `germplasmcharacteristics` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `germplasmname` varchar(50) DEFAULT NULL,
  `attribute` varchar(30) DEFAULT NULL,
  `value` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5628 DEFAULT CHARSET=latin1;

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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

/*Table structure for table `program` */

DROP TABLE IF EXISTS `program`;

CREATE TABLE `program` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `userid` int(10) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `objective` varchar(200) DEFAULT NULL,
  `coordinator` varchar(100) DEFAULT NULL,
  `leadinginstitute` varchar(200) DEFAULT NULL,
  `collaborator` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

/*Table structure for table `project` */

DROP TABLE IF EXISTS `project`;

CREATE TABLE `project` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `userid` int(10) DEFAULT NULL,
  `programid` int(10) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `objective` varchar(200) DEFAULT NULL,
  `pi` varchar(100) DEFAULT NULL,
  `leadinginstitute` varchar(100) DEFAULT NULL,
  `collaborators` varchar(200) DEFAULT NULL,
  `fundingagency` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
