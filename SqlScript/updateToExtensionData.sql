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

/*Table structure for table `distributionandextension` */

DROP TABLE IF EXISTS `distributionandextension`;

CREATE TABLE `distributionandextension` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `programid` int(5) DEFAULT NULL,
  `projectid` int(5) DEFAULT NULL,
  `germplasmname` varchar(50) DEFAULT NULL,
  `yearextension` varchar(8) DEFAULT NULL,
  `locationextension` varchar(50) DEFAULT NULL,
  `countryextension` varchar(100) DEFAULT NULL,
  `plantingarea` double(10,2) DEFAULT NULL,
  `datasource` varchar(200) DEFAULT NULL,
  `seedavailability` int(10) DEFAULT NULL,
  `amountseeddistributed` int(10) DEFAULT NULL COMMENT 'number of seeds distributed',
  `numfarmersadopted` int(10) DEFAULT NULL COMMENT 'number of farmers adopted',
  `amountseedsproduced` double(10,2) DEFAULT NULL COMMENT 'seeds produced',
  `userid` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;

/*Data for the table `distributionandextension` */

insert  into `distributionandextension`(`id`,`programid`,`projectid`,`germplasmname`,`yearextension`,`locationextension`,`countryextension`,`plantingarea`,`datasource`,`seedavailability`,`amountseeddistributed`,`numfarmersadopted`,`amountseedsproduced`,`userid`) values (1,4,8,'IR1','2009','IRRI','Philippines',1000.00,'IRRI',20000,NULL,NULL,NULL,1);
insert  into `distributionandextension`(`id`,`programid`,`projectid`,`germplasmname`,`yearextension`,`locationextension`,`countryextension`,`plantingarea`,`datasource`,`seedavailability`,`amountseeddistributed`,`numfarmersadopted`,`amountseedsproduced`,`userid`) values (3,4,6,'IR1','2011','IRRI','Philippines',1500.00,'IRRI',100,NULL,NULL,NULL,1);
insert  into `distributionandextension`(`id`,`programid`,`projectid`,`germplasmname`,`yearextension`,`locationextension`,`countryextension`,`plantingarea`,`datasource`,`seedavailability`,`amountseeddistributed`,`numfarmersadopted`,`amountseedsproduced`,`userid`) values (4,4,6,'IR1','2012','IRRI','Philippines',1700.00,'IRRI',100,NULL,NULL,NULL,1);
insert  into `distributionandextension`(`id`,`programid`,`projectid`,`germplasmname`,`yearextension`,`locationextension`,`countryextension`,`plantingarea`,`datasource`,`seedavailability`,`amountseeddistributed`,`numfarmersadopted`,`amountseedsproduced`,`userid`) values (5,4,1,'IR1','2013','IRRI','Philippines',1000.00,'IRRI',100,NULL,NULL,NULL,1);
insert  into `distributionandextension`(`id`,`programid`,`projectid`,`germplasmname`,`yearextension`,`locationextension`,`countryextension`,`plantingarea`,`datasource`,`seedavailability`,`amountseeddistributed`,`numfarmersadopted`,`amountseedsproduced`,`userid`) values (6,1,1,'IR6','2010','BRRI','Bangladesh',1000.00,'BRRI',100,NULL,NULL,NULL,1);
insert  into `distributionandextension`(`id`,`programid`,`projectid`,`germplasmname`,`yearextension`,`locationextension`,`countryextension`,`plantingarea`,`datasource`,`seedavailability`,`amountseeddistributed`,`numfarmersadopted`,`amountseedsproduced`,`userid`) values (7,1,1,'IR7','2009','BRRI','Bangladesh',1000.00,'BRRI',100,NULL,NULL,NULL,1);
insert  into `distributionandextension`(`id`,`programid`,`projectid`,`germplasmname`,`yearextension`,`locationextension`,`countryextension`,`plantingarea`,`datasource`,`seedavailability`,`amountseeddistributed`,`numfarmersadopted`,`amountseedsproduced`,`userid`) values (8,1,1,'IR8','2010','BRRI','Bangladesh',1500.00,'BRRI',100,NULL,NULL,NULL,1);
insert  into `distributionandextension`(`id`,`programid`,`projectid`,`germplasmname`,`yearextension`,`locationextension`,`countryextension`,`plantingarea`,`datasource`,`seedavailability`,`amountseeddistributed`,`numfarmersadopted`,`amountseedsproduced`,`userid`) values (9,1,1,'IR8','2011','BRRI','Bangladesh',1700.00,'BRRI',100,NULL,NULL,NULL,1);
insert  into `distributionandextension`(`id`,`programid`,`projectid`,`germplasmname`,`yearextension`,`locationextension`,`countryextension`,`plantingarea`,`datasource`,`seedavailability`,`amountseeddistributed`,`numfarmersadopted`,`amountseedsproduced`,`userid`) values (10,1,1,'IR10','2012','BRRI','Bangladesh',1000.00,'BRRI',100,NULL,NULL,NULL,1);
insert  into `distributionandextension`(`id`,`programid`,`projectid`,`germplasmname`,`yearextension`,`locationextension`,`countryextension`,`plantingarea`,`datasource`,`seedavailability`,`amountseeddistributed`,`numfarmersadopted`,`amountseedsproduced`,`userid`) values (11,1,1,'IR11','2013','BRRI','Bangladesh',1000.00,'BRRI',100,NULL,NULL,NULL,1);
insert  into `distributionandextension`(`id`,`programid`,`projectid`,`germplasmname`,`yearextension`,`locationextension`,`countryextension`,`plantingarea`,`datasource`,`seedavailability`,`amountseeddistributed`,`numfarmersadopted`,`amountseedsproduced`,`userid`) values (12,1,1,'IR12','2010','BRRI','Bangladesh',1000.00,'BRRI',100,NULL,NULL,NULL,1);
insert  into `distributionandextension`(`id`,`programid`,`projectid`,`germplasmname`,`yearextension`,`locationextension`,`countryextension`,`plantingarea`,`datasource`,`seedavailability`,`amountseeddistributed`,`numfarmersadopted`,`amountseedsproduced`,`userid`) values (13,2,3,'IR26','2010','PAJANCOA ','India',1000.00,'PAJANCOA ',100,NULL,NULL,NULL,1);
insert  into `distributionandextension`(`id`,`programid`,`projectid`,`germplasmname`,`yearextension`,`locationextension`,`countryextension`,`plantingarea`,`datasource`,`seedavailability`,`amountseeddistributed`,`numfarmersadopted`,`amountseedsproduced`,`userid`) values (14,2,3,'IR26','2011','PAJANCOA ','India',1000.00,'PAJANCOA ',100,NULL,NULL,NULL,1);
insert  into `distributionandextension`(`id`,`programid`,`projectid`,`germplasmname`,`yearextension`,`locationextension`,`countryextension`,`plantingarea`,`datasource`,`seedavailability`,`amountseeddistributed`,`numfarmersadopted`,`amountseedsproduced`,`userid`) values (15,2,3,'IR26','2012','PAJANCOA ','India',1000.00,'PAJANCOA ',100,NULL,NULL,NULL,1);
insert  into `distributionandextension`(`id`,`programid`,`projectid`,`germplasmname`,`yearextension`,`locationextension`,`countryextension`,`plantingarea`,`datasource`,`seedavailability`,`amountseeddistributed`,`numfarmersadopted`,`amountseedsproduced`,`userid`) values (16,2,3,'IR26','2013','PAJANCOA ','India',1000.00,'PAJANCOA ',100,NULL,NULL,NULL,1);
insert  into `distributionandextension`(`id`,`programid`,`projectid`,`germplasmname`,`yearextension`,`locationextension`,`countryextension`,`plantingarea`,`datasource`,`seedavailability`,`amountseeddistributed`,`numfarmersadopted`,`amountseedsproduced`,`userid`) values (17,2,3,'IR26','2014','PAJANCOA ','India',1000.00,'PAJANCOA ',100,NULL,NULL,NULL,1);
insert  into `distributionandextension`(`id`,`programid`,`projectid`,`germplasmname`,`yearextension`,`locationextension`,`countryextension`,`plantingarea`,`datasource`,`seedavailability`,`amountseeddistributed`,`numfarmersadopted`,`amountseedsproduced`,`userid`) values (18,2,3,'IR31','2013','PAJANCOA ','India',1000.00,'PAJANCOA ',100,NULL,NULL,NULL,1);
insert  into `distributionandextension`(`id`,`programid`,`projectid`,`germplasmname`,`yearextension`,`locationextension`,`countryextension`,`plantingarea`,`datasource`,`seedavailability`,`amountseeddistributed`,`numfarmersadopted`,`amountseedsproduced`,`userid`) values (19,2,3,'IR32','2013','PAJANCOA ','India',1000.00,'PAJANCOA ',100,NULL,NULL,NULL,1);
insert  into `distributionandextension`(`id`,`programid`,`projectid`,`germplasmname`,`yearextension`,`locationextension`,`countryextension`,`plantingarea`,`datasource`,`seedavailability`,`amountseeddistributed`,`numfarmersadopted`,`amountseedsproduced`,`userid`) values (20,2,3,'IR33','2013','PAJANCOA ','India',1000.00,'PAJANCOA ',100,NULL,NULL,NULL,1);
insert  into `distributionandextension`(`id`,`programid`,`projectid`,`germplasmname`,`yearextension`,`locationextension`,`countryextension`,`plantingarea`,`datasource`,`seedavailability`,`amountseeddistributed`,`numfarmersadopted`,`amountseedsproduced`,`userid`) values (21,2,3,'IR34','2013','PAJANCOA ','India',1000.00,'PAJANCOA ',100,NULL,NULL,NULL,1);
insert  into `distributionandextension`(`id`,`programid`,`projectid`,`germplasmname`,`yearextension`,`locationextension`,`countryextension`,`plantingarea`,`datasource`,`seedavailability`,`amountseeddistributed`,`numfarmersadopted`,`amountseedsproduced`,`userid`) values (22,2,3,'IR35','2013','PAJANCOA ','India',1000.00,'PAJANCOA ',100,NULL,NULL,NULL,1);
insert  into `distributionandextension`(`id`,`programid`,`projectid`,`germplasmname`,`yearextension`,`locationextension`,`countryextension`,`plantingarea`,`datasource`,`seedavailability`,`amountseeddistributed`,`numfarmersadopted`,`amountseedsproduced`,`userid`) values (23,2,3,'IR36','2013','PAJANCOA ','India',1000.00,'PAJANCOA ',100,NULL,NULL,NULL,1);
insert  into `distributionandextension`(`id`,`programid`,`projectid`,`germplasmname`,`yearextension`,`locationextension`,`countryextension`,`plantingarea`,`datasource`,`seedavailability`,`amountseeddistributed`,`numfarmersadopted`,`amountseedsproduced`,`userid`) values (24,2,3,'IR37','2013','PAJANCOA ','India',1000.00,'PAJANCOA ',100,NULL,NULL,NULL,1);
insert  into `distributionandextension`(`id`,`programid`,`projectid`,`germplasmname`,`yearextension`,`locationextension`,`countryextension`,`plantingarea`,`datasource`,`seedavailability`,`amountseeddistributed`,`numfarmersadopted`,`amountseedsproduced`,`userid`) values (25,2,3,'IR38','2013','PAJANCOA ','India',1000.00,'PAJANCOA ',100,NULL,NULL,NULL,1);
insert  into `distributionandextension`(`id`,`programid`,`projectid`,`germplasmname`,`yearextension`,`locationextension`,`countryextension`,`plantingarea`,`datasource`,`seedavailability`,`amountseeddistributed`,`numfarmersadopted`,`amountseedsproduced`,`userid`) values (26,2,3,'IR39','2013','PAJANCOA ','India',1000.00,'PAJANCOA ',100,NULL,NULL,NULL,1);

/*Table structure for table `releaseinfo` */

DROP TABLE IF EXISTS `releaseinfo`;

CREATE TABLE `releaseinfo` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `programid` int(5) DEFAULT NULL,
  `projectid` int(5) DEFAULT NULL,
  `germplasmname` varchar(30) DEFAULT NULL,
  `datasource` varchar(200) CHARACTER SET latin1 DEFAULT NULL,
  `yearrelease` varchar(4) CHARACTER SET latin1 DEFAULT NULL,
  `countryrelease` varchar(100) CHARACTER SET latin1 DEFAULT NULL,
  `seedavailability` int(10) DEFAULT NULL,
  `userid` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

/*Data for the table `releaseinfo` */

insert  into `releaseinfo`(`id`,`programid`,`projectid`,`germplasmname`,`datasource`,`yearrelease`,`countryrelease`,`seedavailability`,`userid`) values (1,4,8,NULL,'IRRI','1980','Philippines',20000,1);
insert  into `releaseinfo`(`id`,`programid`,`projectid`,`germplasmname`,`datasource`,`yearrelease`,`countryrelease`,`seedavailability`,`userid`) values (3,4,6,NULL,'IRRI','1980','Philippines',100,1);
insert  into `releaseinfo`(`id`,`programid`,`projectid`,`germplasmname`,`datasource`,`yearrelease`,`countryrelease`,`seedavailability`,`userid`) values (4,4,6,NULL,'IRRI','1980','Philippines',100,1);
insert  into `releaseinfo`(`id`,`programid`,`projectid`,`germplasmname`,`datasource`,`yearrelease`,`countryrelease`,`seedavailability`,`userid`) values (5,4,1,NULL,'IRRI','1980','Philippines',100,1);
insert  into `releaseinfo`(`id`,`programid`,`projectid`,`germplasmname`,`datasource`,`yearrelease`,`countryrelease`,`seedavailability`,`userid`) values (6,1,1,NULL,'BRRI','1980','Bangladesh',100,1);
insert  into `releaseinfo`(`id`,`programid`,`projectid`,`germplasmname`,`datasource`,`yearrelease`,`countryrelease`,`seedavailability`,`userid`) values (7,1,1,NULL,'BRRI','1982','Bangladesh',100,1);
insert  into `releaseinfo`(`id`,`programid`,`projectid`,`germplasmname`,`datasource`,`yearrelease`,`countryrelease`,`seedavailability`,`userid`) values (8,1,1,NULL,'BRRI','1984','Bangladesh',100,1);
insert  into `releaseinfo`(`id`,`programid`,`projectid`,`germplasmname`,`datasource`,`yearrelease`,`countryrelease`,`seedavailability`,`userid`) values (9,1,1,NULL,'BRRI','1980','Bangladesh',100,1);
insert  into `releaseinfo`(`id`,`programid`,`projectid`,`germplasmname`,`datasource`,`yearrelease`,`countryrelease`,`seedavailability`,`userid`) values (10,1,1,NULL,'BRRI','1980','Bangladesh',100,1);
insert  into `releaseinfo`(`id`,`programid`,`projectid`,`germplasmname`,`datasource`,`yearrelease`,`countryrelease`,`seedavailability`,`userid`) values (11,1,1,NULL,'BRRI','1982','Bangladesh',100,1);
insert  into `releaseinfo`(`id`,`programid`,`projectid`,`germplasmname`,`datasource`,`yearrelease`,`countryrelease`,`seedavailability`,`userid`) values (12,1,1,NULL,'BRRI','1984','Bangladesh',100,1);
insert  into `releaseinfo`(`id`,`programid`,`projectid`,`germplasmname`,`datasource`,`yearrelease`,`countryrelease`,`seedavailability`,`userid`) values (13,2,3,NULL,'PAJANCOA ','1980','India',100,1);
insert  into `releaseinfo`(`id`,`programid`,`projectid`,`germplasmname`,`datasource`,`yearrelease`,`countryrelease`,`seedavailability`,`userid`) values (14,2,3,NULL,'PAJANCOA ','1980','India',100,1);
insert  into `releaseinfo`(`id`,`programid`,`projectid`,`germplasmname`,`datasource`,`yearrelease`,`countryrelease`,`seedavailability`,`userid`) values (15,2,3,NULL,'PAJANCOA ','1982','India',100,1);
insert  into `releaseinfo`(`id`,`programid`,`projectid`,`germplasmname`,`datasource`,`yearrelease`,`countryrelease`,`seedavailability`,`userid`) values (16,2,3,NULL,'PAJANCOA ','1984','India',100,1);
insert  into `releaseinfo`(`id`,`programid`,`projectid`,`germplasmname`,`datasource`,`yearrelease`,`countryrelease`,`seedavailability`,`userid`) values (17,2,3,NULL,'PAJANCOA ','1984','India',100,1);
insert  into `releaseinfo`(`id`,`programid`,`projectid`,`germplasmname`,`datasource`,`yearrelease`,`countryrelease`,`seedavailability`,`userid`) values (18,2,3,NULL,'PAJANCOA ','1980','India',100,1);
insert  into `releaseinfo`(`id`,`programid`,`projectid`,`germplasmname`,`datasource`,`yearrelease`,`countryrelease`,`seedavailability`,`userid`) values (19,2,3,NULL,'PAJANCOA ','1980','India',100,1);
insert  into `releaseinfo`(`id`,`programid`,`projectid`,`germplasmname`,`datasource`,`yearrelease`,`countryrelease`,`seedavailability`,`userid`) values (20,2,3,NULL,'PAJANCOA ','1982','India',100,1);
insert  into `releaseinfo`(`id`,`programid`,`projectid`,`germplasmname`,`datasource`,`yearrelease`,`countryrelease`,`seedavailability`,`userid`) values (21,2,3,NULL,'PAJANCOA ','1984','India',100,1);
insert  into `releaseinfo`(`id`,`programid`,`projectid`,`germplasmname`,`datasource`,`yearrelease`,`countryrelease`,`seedavailability`,`userid`) values (22,2,3,NULL,'PAJANCOA ','1984','India',100,1);
insert  into `releaseinfo`(`id`,`programid`,`projectid`,`germplasmname`,`datasource`,`yearrelease`,`countryrelease`,`seedavailability`,`userid`) values (23,2,3,NULL,'PAJANCOA ','1980','India',100,1);
insert  into `releaseinfo`(`id`,`programid`,`projectid`,`germplasmname`,`datasource`,`yearrelease`,`countryrelease`,`seedavailability`,`userid`) values (24,2,3,NULL,'PAJANCOA ','1980','India',100,1);
insert  into `releaseinfo`(`id`,`programid`,`projectid`,`germplasmname`,`datasource`,`yearrelease`,`countryrelease`,`seedavailability`,`userid`) values (25,2,3,NULL,'PAJANCOA ','1982','India',100,1);
insert  into `releaseinfo`(`id`,`programid`,`projectid`,`germplasmname`,`datasource`,`yearrelease`,`countryrelease`,`seedavailability`,`userid`) values (26,2,3,NULL,'PAJANCOA ','1984','India',100,1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
