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
  `countryextension` varchar(100) DEFAULT NULL,
  `yearrelease` varchar(4) DEFAULT NULL,
  `seedavailability` int(10) DEFAULT NULL,
  `programid` int(5) DEFAULT NULL,
  `projectid` int(5) DEFAULT NULL,
  `countryrelease` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `extensiondata` */

insert  into `extensiondata`(`id`,`germplasmname`,`year`,`location`,`area`,`datasource`,`countryextension`,`yearrelease`,`seedavailability`,`programid`,`projectid`,`countryrelease`) values (1,'IR64','2010','IRRI',100.00,'IRRI','Philippines','1980',100,2,3,NULL);
insert  into `extensiondata`(`id`,`germplasmname`,`year`,`location`,`area`,`datasource`,`countryextension`,`yearrelease`,`seedavailability`,`programid`,`projectid`,`countryrelease`) values (2,'IR64','2011','LB',999.99,'LB','Philippines','1980',100,2,3,NULL);
insert  into `extensiondata`(`id`,`germplasmname`,`year`,`location`,`area`,`datasource`,`countryextension`,`yearrelease`,`seedavailability`,`programid`,`projectid`,`countryrelease`) values (3,'IR72','2010','IRRI',999.99,'IRRI','Philippines','1982',100,2,3,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
