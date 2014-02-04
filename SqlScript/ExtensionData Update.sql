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
  `area` double(10,2) DEFAULT NULL,
  `datasource` varchar(200) DEFAULT NULL,
  `countryextension` varchar(100) DEFAULT NULL,
  `yearrelease` varchar(4) DEFAULT NULL,
  `seedavailability` int(10) DEFAULT NULL,
  `programid` int(5) DEFAULT NULL,
  `projectid` int(5) DEFAULT NULL,
  `countryrelease` varchar(100) DEFAULT NULL,
  `userid` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=latin1;

/*Data for the table `extensiondata` */

insert  into `extensiondata`(`id`,`germplasmname`,`year`,`location`,`area`,`datasource`,`countryextension`,`yearrelease`,`seedavailability`,`programid`,`projectid`,`countryrelease`,`userid`) values (1,'IR1','2009','IRRI',1000.00,'IRRI','Philippines','1980',1001,4,8,'Philippines',1);
insert  into `extensiondata`(`id`,`germplasmname`,`year`,`location`,`area`,`datasource`,`countryextension`,`yearrelease`,`seedavailability`,`programid`,`projectid`,`countryrelease`,`userid`) values (3,'IR1','2011','IRRI',1500.00,'IRRI','Philippines','1980',100,4,6,'Philippines',1);
insert  into `extensiondata`(`id`,`germplasmname`,`year`,`location`,`area`,`datasource`,`countryextension`,`yearrelease`,`seedavailability`,`programid`,`projectid`,`countryrelease`,`userid`) values (4,'IR1','2012','IRRI',1700.00,'IRRI','Philippines','1980',100,4,6,'Philippines',1);
insert  into `extensiondata`(`id`,`germplasmname`,`year`,`location`,`area`,`datasource`,`countryextension`,`yearrelease`,`seedavailability`,`programid`,`projectid`,`countryrelease`,`userid`) values (5,'IR1','2013','IRRI',1000.00,'IRRI','Philippines','1980',100,4,1,'Philippines',1);
insert  into `extensiondata`(`id`,`germplasmname`,`year`,`location`,`area`,`datasource`,`countryextension`,`yearrelease`,`seedavailability`,`programid`,`projectid`,`countryrelease`,`userid`) values (6,'IR6','2010','BRRI',1000.00,'BRRI','Bangladesh','1980',100,1,1,'Bangladesh',1);
insert  into `extensiondata`(`id`,`germplasmname`,`year`,`location`,`area`,`datasource`,`countryextension`,`yearrelease`,`seedavailability`,`programid`,`projectid`,`countryrelease`,`userid`) values (7,'IR7','2009','BRRI',1000.00,'BRRI','Bangladesh','1982',100,1,1,'Bangladesh',1);
insert  into `extensiondata`(`id`,`germplasmname`,`year`,`location`,`area`,`datasource`,`countryextension`,`yearrelease`,`seedavailability`,`programid`,`projectid`,`countryrelease`,`userid`) values (8,'IR8','2010','BRRI',1500.00,'BRRI','Bangladesh','1984',100,1,1,'Bangladesh',1);
insert  into `extensiondata`(`id`,`germplasmname`,`year`,`location`,`area`,`datasource`,`countryextension`,`yearrelease`,`seedavailability`,`programid`,`projectid`,`countryrelease`,`userid`) values (9,'IR8','2011','BRRI',1700.00,'BRRI','Bangladesh','1980',100,1,1,'Bangladesh',1);
insert  into `extensiondata`(`id`,`germplasmname`,`year`,`location`,`area`,`datasource`,`countryextension`,`yearrelease`,`seedavailability`,`programid`,`projectid`,`countryrelease`,`userid`) values (10,'IR10','2012','BRRI',1000.00,'BRRI','Bangladesh','1980',100,1,1,'Bangladesh',1);
insert  into `extensiondata`(`id`,`germplasmname`,`year`,`location`,`area`,`datasource`,`countryextension`,`yearrelease`,`seedavailability`,`programid`,`projectid`,`countryrelease`,`userid`) values (11,'IR11','2013','BRRI',1000.00,'BRRI','Bangladesh','1982',100,1,1,'Bangladesh',1);
insert  into `extensiondata`(`id`,`germplasmname`,`year`,`location`,`area`,`datasource`,`countryextension`,`yearrelease`,`seedavailability`,`programid`,`projectid`,`countryrelease`,`userid`) values (12,'IR12','2010','BRRI',1000.00,'BRRI','Bangladesh','1984',100,1,1,'Bangladesh',1);
insert  into `extensiondata`(`id`,`germplasmname`,`year`,`location`,`area`,`datasource`,`countryextension`,`yearrelease`,`seedavailability`,`programid`,`projectid`,`countryrelease`,`userid`) values (13,'IR26','2010','PAJANCOA ',1000.00,'PAJANCOA ','India','1980',100,2,3,'India',1);
insert  into `extensiondata`(`id`,`germplasmname`,`year`,`location`,`area`,`datasource`,`countryextension`,`yearrelease`,`seedavailability`,`programid`,`projectid`,`countryrelease`,`userid`) values (14,'IR26','2011','PAJANCOA ',1000.00,'PAJANCOA ','India','1980',100,2,3,'India',1);
insert  into `extensiondata`(`id`,`germplasmname`,`year`,`location`,`area`,`datasource`,`countryextension`,`yearrelease`,`seedavailability`,`programid`,`projectid`,`countryrelease`,`userid`) values (15,'IR26','2012','PAJANCOA ',1000.00,'PAJANCOA ','India','1982',100,2,3,'India',1);
insert  into `extensiondata`(`id`,`germplasmname`,`year`,`location`,`area`,`datasource`,`countryextension`,`yearrelease`,`seedavailability`,`programid`,`projectid`,`countryrelease`,`userid`) values (16,'IR26','2013','PAJANCOA ',1000.00,'PAJANCOA ','India','1984',100,2,3,'India',1);
insert  into `extensiondata`(`id`,`germplasmname`,`year`,`location`,`area`,`datasource`,`countryextension`,`yearrelease`,`seedavailability`,`programid`,`projectid`,`countryrelease`,`userid`) values (17,'IR26','2014','PAJANCOA ',1000.00,'PAJANCOA ','India','1984',100,2,3,'India',1);
insert  into `extensiondata`(`id`,`germplasmname`,`year`,`location`,`area`,`datasource`,`countryextension`,`yearrelease`,`seedavailability`,`programid`,`projectid`,`countryrelease`,`userid`) values (18,'IR31','2013','PAJANCOA ',1000.00,'PAJANCOA ','India','1980',100,2,3,'India',1);
insert  into `extensiondata`(`id`,`germplasmname`,`year`,`location`,`area`,`datasource`,`countryextension`,`yearrelease`,`seedavailability`,`programid`,`projectid`,`countryrelease`,`userid`) values (19,'IR32','2013','PAJANCOA ',1000.00,'PAJANCOA ','India','1980',100,2,3,'India',1);
insert  into `extensiondata`(`id`,`germplasmname`,`year`,`location`,`area`,`datasource`,`countryextension`,`yearrelease`,`seedavailability`,`programid`,`projectid`,`countryrelease`,`userid`) values (20,'IR33','2013','PAJANCOA ',1000.00,'PAJANCOA ','India','1982',100,2,3,'India',1);
insert  into `extensiondata`(`id`,`germplasmname`,`year`,`location`,`area`,`datasource`,`countryextension`,`yearrelease`,`seedavailability`,`programid`,`projectid`,`countryrelease`,`userid`) values (21,'IR34','2013','PAJANCOA ',1000.00,'PAJANCOA ','India','1984',100,2,3,'India',1);
insert  into `extensiondata`(`id`,`germplasmname`,`year`,`location`,`area`,`datasource`,`countryextension`,`yearrelease`,`seedavailability`,`programid`,`projectid`,`countryrelease`,`userid`) values (22,'IR35','2013','PAJANCOA ',1000.00,'PAJANCOA ','India','1984',100,2,3,'India',1);
insert  into `extensiondata`(`id`,`germplasmname`,`year`,`location`,`area`,`datasource`,`countryextension`,`yearrelease`,`seedavailability`,`programid`,`projectid`,`countryrelease`,`userid`) values (23,'IR36','2013','PAJANCOA ',1000.00,'PAJANCOA ','India','1980',100,2,3,'India',1);
insert  into `extensiondata`(`id`,`germplasmname`,`year`,`location`,`area`,`datasource`,`countryextension`,`yearrelease`,`seedavailability`,`programid`,`projectid`,`countryrelease`,`userid`) values (24,'IR37','2013','PAJANCOA ',1000.00,'PAJANCOA ','India','1980',100,2,3,'India',1);
insert  into `extensiondata`(`id`,`germplasmname`,`year`,`location`,`area`,`datasource`,`countryextension`,`yearrelease`,`seedavailability`,`programid`,`projectid`,`countryrelease`,`userid`) values (25,'IR38','2013','PAJANCOA ',1000.00,'PAJANCOA ','India','1982',100,2,3,'India',1);
insert  into `extensiondata`(`id`,`germplasmname`,`year`,`location`,`area`,`datasource`,`countryextension`,`yearrelease`,`seedavailability`,`programid`,`projectid`,`countryrelease`,`userid`) values (26,'IR39','2013','PAJANCOA ',1000.00,'PAJANCOA ','India','1984',100,2,3,'India',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
