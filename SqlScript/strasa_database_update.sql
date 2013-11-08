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

/*Table structure for table `studyderiveddata` */

DROP TABLE IF EXISTS `studyderiveddata`;

CREATE TABLE `studyderiveddata` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `studyid` int(10) DEFAULT NULL,
  `datarow` int(10) DEFAULT NULL,
  `datacolumn` varchar(20) DEFAULT NULL,
  `datavalue` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `studyderiveddata` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
