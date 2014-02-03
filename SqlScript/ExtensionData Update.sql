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
  `userid` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=latin1;

/*Data for the table `extensiondata` */

insert  into `extensiondata`(`id`,`germplasmname`,`year`,`location`,`area`,`datasource`,`countryextension`,`yearrelease`,`seedavailability`,`programid`,`projectid`,`countryrelease`,`userid`) values (4,'Gen1','2009','IRRI',100.00,'IRRI','Philippines','1980',100,2,1,'Philippines',1);
insert  into `extensiondata`(`id`,`germplasmname`,`year`,`location`,`area`,`datasource`,`countryextension`,`yearrelease`,`seedavailability`,`programid`,`projectid`,`countryrelease`,`userid`) values (5,'Gen2','2009','IRRI',100.00,'LB','Philippines','1980',100,2,1,'Philippines',1);
insert  into `extensiondata`(`id`,`germplasmname`,`year`,`location`,`area`,`datasource`,`countryextension`,`yearrelease`,`seedavailability`,`programid`,`projectid`,`countryrelease`,`userid`) values (6,'Gen3','2009','IRRI',100.00,'IRRI','Philippines','1982',100,2,1,'Philippines',1);
insert  into `extensiondata`(`id`,`germplasmname`,`year`,`location`,`area`,`datasource`,`countryextension`,`yearrelease`,`seedavailability`,`programid`,`projectid`,`countryrelease`,`userid`) values (7,'Gen4','2009','IRRI',100.00,'','Philippines','1984',100,2,1,'Philippines',1);
insert  into `extensiondata`(`id`,`germplasmname`,`year`,`location`,`area`,`datasource`,`countryextension`,`yearrelease`,`seedavailability`,`programid`,`projectid`,`countryrelease`,`userid`) values (8,'Gen5','2010','Bangladesh Rice Research Institute (BRRI) ',100.00,'','Bangladesh','1980',100,2,1,'Bangladesh',1);
insert  into `extensiondata`(`id`,`germplasmname`,`year`,`location`,`area`,`datasource`,`countryextension`,`yearrelease`,`seedavailability`,`programid`,`projectid`,`countryrelease`,`userid`) values (9,'Gen6','2010','Bangladesh Rice Research Institute (BRRI) ',100.00,'','Bangladesh','1980',100,2,4,'Bangladesh',1);
insert  into `extensiondata`(`id`,`germplasmname`,`year`,`location`,`area`,`datasource`,`countryextension`,`yearrelease`,`seedavailability`,`programid`,`projectid`,`countryrelease`,`userid`) values (10,'Gen7','2010','Bangladesh Rice Research Institute (BRRI) ',100.00,'','Bangladesh','1982',100,2,4,'Bangladesh',1);
insert  into `extensiondata`(`id`,`germplasmname`,`year`,`location`,`area`,`datasource`,`countryextension`,`yearrelease`,`seedavailability`,`programid`,`projectid`,`countryrelease`,`userid`) values (11,'Gen8','2010','Bangladesh Rice Research Institute (BRRI) ',100.00,'','Bangladesh','1984',100,2,4,'Bangladesh',1);
insert  into `extensiondata`(`id`,`germplasmname`,`year`,`location`,`area`,`datasource`,`countryextension`,`yearrelease`,`seedavailability`,`programid`,`projectid`,`countryrelease`,`userid`) values (12,'Gen9','2010','Bangladesh Rice Research Institute (BRRI) ',100.00,'','Bangladesh','1980',100,2,4,'Bangladesh',1);
insert  into `extensiondata`(`id`,`germplasmname`,`year`,`location`,`area`,`datasource`,`countryextension`,`yearrelease`,`seedavailability`,`programid`,`projectid`,`countryrelease`,`userid`) values (13,'Gen10','2010','Bangladesh Rice Research Institute (BRRI) ',100.00,'','Bangladesh','1980',100,2,4,'Bangladesh',1);
insert  into `extensiondata`(`id`,`germplasmname`,`year`,`location`,`area`,`datasource`,`countryextension`,`yearrelease`,`seedavailability`,`programid`,`projectid`,`countryrelease`,`userid`) values (14,'Gen11','2011','Bangladesh Rice Research Institute (BRRI) ',100.00,'','Bangladesh','1982',100,2,4,'Bangladesh',1);
insert  into `extensiondata`(`id`,`germplasmname`,`year`,`location`,`area`,`datasource`,`countryextension`,`yearrelease`,`seedavailability`,`programid`,`projectid`,`countryrelease`,`userid`) values (15,'Gen12','2011','Bangladesh Rice Research Institute (BRRI) ',100.00,'','Bangladesh','1984',100,2,4,'Bangladesh',1);
insert  into `extensiondata`(`id`,`germplasmname`,`year`,`location`,`area`,`datasource`,`countryextension`,`yearrelease`,`seedavailability`,`programid`,`projectid`,`countryrelease`,`userid`) values (16,'Gen13','2011','Bangladesh Rice Research Institute (BRRI) ',100.00,'','Bangladesh','1980',100,2,4,'Bangladesh',1);
insert  into `extensiondata`(`id`,`germplasmname`,`year`,`location`,`area`,`datasource`,`countryextension`,`yearrelease`,`seedavailability`,`programid`,`projectid`,`countryrelease`,`userid`) values (17,'Gen14','2011','Bangladesh Rice Research Institute (BRRI) ',100.00,'','Bangladesh','1980',100,2,4,'Bangladesh',1);
insert  into `extensiondata`(`id`,`germplasmname`,`year`,`location`,`area`,`datasource`,`countryextension`,`yearrelease`,`seedavailability`,`programid`,`projectid`,`countryrelease`,`userid`) values (18,'Gen15','2011','Bangladesh Rice Research Institute (BRRI) ',100.00,'','Bangladesh','1982',100,2,4,'Bangladesh',3);
insert  into `extensiondata`(`id`,`germplasmname`,`year`,`location`,`area`,`datasource`,`countryextension`,`yearrelease`,`seedavailability`,`programid`,`projectid`,`countryrelease`,`userid`) values (19,'Gen16','2012','Bangladesh Rice Research Institute (BRRI) ',100.00,'','Bangladesh','1984',100,2,4,'Bangladesh',3);
insert  into `extensiondata`(`id`,`germplasmname`,`year`,`location`,`area`,`datasource`,`countryextension`,`yearrelease`,`seedavailability`,`programid`,`projectid`,`countryrelease`,`userid`) values (20,'Gen17','2012','Bangladesh Rice Research Institute (BRRI) ',100.00,'','Bangladesh','1980',100,2,4,'Bangladesh',3);
insert  into `extensiondata`(`id`,`germplasmname`,`year`,`location`,`area`,`datasource`,`countryextension`,`yearrelease`,`seedavailability`,`programid`,`projectid`,`countryrelease`,`userid`) values (21,'Gen18','2012','Bangladesh Institute of Nuclear Agriculture (BINA)',100.00,'','Bangladesh','1980',100,2,4,'Bangladesh',3);
insert  into `extensiondata`(`id`,`germplasmname`,`year`,`location`,`area`,`datasource`,`countryextension`,`yearrelease`,`seedavailability`,`programid`,`projectid`,`countryrelease`,`userid`) values (22,'Gen19','2012','Bangladesh Institute of Nuclear Agriculture (BINA)',100.00,'','Bangladesh','1982',100,2,4,'Bangladesh',3);
insert  into `extensiondata`(`id`,`germplasmname`,`year`,`location`,`area`,`datasource`,`countryextension`,`yearrelease`,`seedavailability`,`programid`,`projectid`,`countryrelease`,`userid`) values (23,'Gen20','2012','Bangladesh Institute of Nuclear Agriculture (BINA)',100.00,'','Bangladesh','1984',100,2,4,'Bangladesh',3);
insert  into `extensiondata`(`id`,`germplasmname`,`year`,`location`,`area`,`datasource`,`countryextension`,`yearrelease`,`seedavailability`,`programid`,`projectid`,`countryrelease`,`userid`) values (24,'Gen21','2012','Bangladesh Institute of Nuclear Agriculture (BINA)',100.00,'','Bangladesh','1980',100,2,4,'Bangladesh',3);
insert  into `extensiondata`(`id`,`germplasmname`,`year`,`location`,`area`,`datasource`,`countryextension`,`yearrelease`,`seedavailability`,`programid`,`projectid`,`countryrelease`,`userid`) values (25,'Gen22','2012','Bangladesh Institute of Nuclear Agriculture (BINA)',100.00,'','Bangladesh','1980',100,2,4,'Bangladesh',3);
insert  into `extensiondata`(`id`,`germplasmname`,`year`,`location`,`area`,`datasource`,`countryextension`,`yearrelease`,`seedavailability`,`programid`,`projectid`,`countryrelease`,`userid`) values (26,'Gen23','2012','Bangladesh Institute of Nuclear Agriculture (BINA)',100.00,'','Bangladesh','1982',100,2,4,'Bangladesh',3);
insert  into `extensiondata`(`id`,`germplasmname`,`year`,`location`,`area`,`datasource`,`countryextension`,`yearrelease`,`seedavailability`,`programid`,`projectid`,`countryrelease`,`userid`) values (27,'Gen24','2012','Bangladesh Institute of Nuclear Agriculture (BINA)',100.00,'','Bangladesh','1984',100,2,4,'Bangladesh',3);
insert  into `extensiondata`(`id`,`germplasmname`,`year`,`location`,`area`,`datasource`,`countryextension`,`yearrelease`,`seedavailability`,`programid`,`projectid`,`countryrelease`,`userid`) values (28,'Gen25','2012','Bangladesh Institute of Nuclear Agriculture (BINA)',100.00,'','Bangladesh','1984',100,2,4,'Bangladesh',3);
insert  into `extensiondata`(`id`,`germplasmname`,`year`,`location`,`area`,`datasource`,`countryextension`,`yearrelease`,`seedavailability`,`programid`,`projectid`,`countryrelease`,`userid`) values (29,'Gen26','2013','PAJANCOA ',100.00,'','India','1980',100,2,3,'India',5);
insert  into `extensiondata`(`id`,`germplasmname`,`year`,`location`,`area`,`datasource`,`countryextension`,`yearrelease`,`seedavailability`,`programid`,`projectid`,`countryrelease`,`userid`) values (30,'Gen27','2013','PAJANCOA ',100.00,'','India','1980',100,2,3,'India',5);
insert  into `extensiondata`(`id`,`germplasmname`,`year`,`location`,`area`,`datasource`,`countryextension`,`yearrelease`,`seedavailability`,`programid`,`projectid`,`countryrelease`,`userid`) values (31,'Gen28','2013','PAJANCOA ',100.00,'','India','1982',100,2,3,'India',5);
insert  into `extensiondata`(`id`,`germplasmname`,`year`,`location`,`area`,`datasource`,`countryextension`,`yearrelease`,`seedavailability`,`programid`,`projectid`,`countryrelease`,`userid`) values (32,'Gen29','2013','PAJANCOA ',100.00,'','India','1984',100,2,3,'India',5);
insert  into `extensiondata`(`id`,`germplasmname`,`year`,`location`,`area`,`datasource`,`countryextension`,`yearrelease`,`seedavailability`,`programid`,`projectid`,`countryrelease`,`userid`) values (33,'Gen30','2013','PAJANCOA ',100.00,'','India','1984',100,2,3,'India',5);
insert  into `extensiondata`(`id`,`germplasmname`,`year`,`location`,`area`,`datasource`,`countryextension`,`yearrelease`,`seedavailability`,`programid`,`projectid`,`countryrelease`,`userid`) values (34,'Gen31','2013','PAJANCOA ',100.00,'','India','1980',100,2,3,'India',5);
insert  into `extensiondata`(`id`,`germplasmname`,`year`,`location`,`area`,`datasource`,`countryextension`,`yearrelease`,`seedavailability`,`programid`,`projectid`,`countryrelease`,`userid`) values (35,'Gen32','2013','PAJANCOA ',100.00,'','India','1980',100,2,3,'India',5);
insert  into `extensiondata`(`id`,`germplasmname`,`year`,`location`,`area`,`datasource`,`countryextension`,`yearrelease`,`seedavailability`,`programid`,`projectid`,`countryrelease`,`userid`) values (36,'Gen33','2013','PAJANCOA ',100.00,'','India','1982',100,2,3,'India',5);
insert  into `extensiondata`(`id`,`germplasmname`,`year`,`location`,`area`,`datasource`,`countryextension`,`yearrelease`,`seedavailability`,`programid`,`projectid`,`countryrelease`,`userid`) values (37,'Gen34','2013','PAJANCOA ',100.00,'','India','1984',100,2,3,'India',5);
insert  into `extensiondata`(`id`,`germplasmname`,`year`,`location`,`area`,`datasource`,`countryextension`,`yearrelease`,`seedavailability`,`programid`,`projectid`,`countryrelease`,`userid`) values (38,'Gen35','2013','PAJANCOA ',100.00,'','India','1984',100,2,3,'India',5);
insert  into `extensiondata`(`id`,`germplasmname`,`year`,`location`,`area`,`datasource`,`countryextension`,`yearrelease`,`seedavailability`,`programid`,`projectid`,`countryrelease`,`userid`) values (39,'Gen36','2013','PAJANCOA ',100.00,'','India','1980',100,2,3,'India',5);
insert  into `extensiondata`(`id`,`germplasmname`,`year`,`location`,`area`,`datasource`,`countryextension`,`yearrelease`,`seedavailability`,`programid`,`projectid`,`countryrelease`,`userid`) values (40,'Gen37','2013','PAJANCOA ',100.00,'','India','1980',100,2,3,'India',5);
insert  into `extensiondata`(`id`,`germplasmname`,`year`,`location`,`area`,`datasource`,`countryextension`,`yearrelease`,`seedavailability`,`programid`,`projectid`,`countryrelease`,`userid`) values (41,'Gen38','2013','PAJANCOA ',100.00,'','India','1982',100,2,3,'India',5);
insert  into `extensiondata`(`id`,`germplasmname`,`year`,`location`,`area`,`datasource`,`countryextension`,`yearrelease`,`seedavailability`,`programid`,`projectid`,`countryrelease`,`userid`) values (42,'Gen39','2013','PAJANCOA ',100.00,'','India','1984',100,2,3,'India',5);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
