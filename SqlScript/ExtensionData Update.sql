/*
SQLyog Community Edition- MySQL GUI v6.03
Host - 5.6.15 : Database - strasa
*********************************************************************
Server version : 5.6.15
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

USE `strasa`;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

/*Table structure for table `extensiondata` */

DROP TABLE IF EXISTS `extensiondata`;

CREATE TABLE `extensiondata` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `germplasmname` varchar(50) DEFAULT NULL,
  `year` varchar(8) DEFAULT NULL,
  `location` varchar(50) DEFAULT NULL,
  `area` double(5,2) DEFAULT NULL,
  `datasource` varchar(200) DEFAULT NULL,
  `country` varchar(100) DEFAULT NULL,
  `yearrelease` varchar(4) DEFAULT NULL,
  `seedavailability` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `extensiondata` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
