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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

/*Data for the table `location` */

insert  into `location`(`id`,`locationname`,`country`,`province`,`region`,`altitude`,`latitude`,`weatherstation`) values (1,'Los Banos','PHIL',NULL,NULL,NULL,NULL,NULL);
insert  into `location`(`id`,`locationname`,`country`,`province`,`region`,`altitude`,`latitude`,`weatherstation`) values (2,'Nueva Ecija','PHIL',NULL,NULL,NULL,NULL,NULL);
insert  into `location`(`id`,`locationname`,`country`,`province`,`region`,`altitude`,`latitude`,`weatherstation`) values (3,'Location 3','PHIL',NULL,NULL,NULL,NULL,NULL);
insert  into `location`(`id`,`locationname`,`country`,`province`,`region`,`altitude`,`latitude`,`weatherstation`) values (4,'Location 4','PHIL',NULL,NULL,NULL,NULL,NULL);
insert  into `location`(`id`,`locationname`,`country`,`province`,`region`,`altitude`,`latitude`,`weatherstation`) values (5,'Location 5','INDIA',NULL,NULL,NULL,NULL,NULL);
insert  into `location`(`id`,`locationname`,`country`,`province`,`region`,`altitude`,`latitude`,`weatherstation`) values (6,'Location 6','INDIA',NULL,NULL,NULL,NULL,NULL);
insert  into `location`(`id`,`locationname`,`country`,`province`,`region`,`altitude`,`latitude`,`weatherstation`) values (7,'Location 7','AFRICA',NULL,NULL,NULL,NULL,NULL);
insert  into `location`(`id`,`locationname`,`country`,`province`,`region`,`altitude`,`latitude`,`weatherstation`) values (8,'Location 8','AFRICA',NULL,NULL,NULL,NULL,NULL);

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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

/*Data for the table `program` */

insert  into `program`(`id`,`userid`,`name`,`objective`,`coordinator`,`leadinginstitute`,`collaborator`) values (1,1,'Program1','objective1','coordinator 1','leading institute 1','collaborator 1');
insert  into `program`(`id`,`userid`,`name`,`objective`,`coordinator`,`leadinginstitute`,`collaborator`) values (2,1,'Program2','objective 2','coordinator 1','leading institute 2','collaborator 2');
insert  into `program`(`id`,`userid`,`name`,`objective`,`coordinator`,`leadinginstitute`,`collaborator`) values (3,1,'Program3','objective 3','coordinator 2','leading institute 3','collaborator 3');
insert  into `program`(`id`,`userid`,`name`,`objective`,`coordinator`,`leadinginstitute`,`collaborator`) values (4,2,'Program4','objective 4','coordinator 3','leading institute 4','collaborator 4');
insert  into `program`(`id`,`userid`,`name`,`objective`,`coordinator`,`leadinginstitute`,`collaborator`) values (5,2,'Program5','objective 5','coordinator 4','leading institute 5','collaborator 5');
insert  into `program`(`id`,`userid`,`name`,`objective`,`coordinator`,`leadinginstitute`,`collaborator`) values (6,3,'Program6','objective 6','coordinator 8','leading institute 6','collaborator 6');
insert  into `program`(`id`,`userid`,`name`,`objective`,`coordinator`,`leadinginstitute`,`collaborator`) values (7,3,'Program7','objective 7','coordinator 6','leading institute 7','collaborator 7');

/*Table structure for table `project` */

DROP TABLE IF EXISTS `project`;

CREATE TABLE `project` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `userid` int(10) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `objective` varchar(200) DEFAULT NULL,
  `pi` varchar(100) DEFAULT NULL,
  `leadinginstitute` varchar(100) DEFAULT NULL,
  `collaborators` varchar(200) DEFAULT NULL,
  `fundingagency` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `project` */

insert  into `project`(`id`,`userid`,`name`,`objective`,`pi`,`leadinginstitute`,`collaborators`,`fundingagency`) values (1,1,'Project 1','objective','pi 1','li 1','col 1','funding 1');
insert  into `project`(`id`,`userid`,`name`,`objective`,`pi`,`leadinginstitute`,`collaborators`,`fundingagency`) values (2,1,'Project 2','objective','pi 2','li 2','col 2','funding 2');
insert  into `project`(`id`,`userid`,`name`,`objective`,`pi`,`leadinginstitute`,`collaborators`,`fundingagency`) values (3,1,'Project 3','objective','pi 3','li 3','col 3','funding 2');
insert  into `project`(`id`,`userid`,`name`,`objective`,`pi`,`leadinginstitute`,`collaborators`,`fundingagency`) values (4,2,'Project 4','objective','pi 4','li 4','col 4','funding 3');
insert  into `project`(`id`,`userid`,`name`,`objective`,`pi`,`leadinginstitute`,`collaborators`,`fundingagency`) values (5,2,'Project 5','objective','pi 5','li 5','col 5','funding 4');

/*Table structure for table `study` */

DROP TABLE IF EXISTS `study`;

CREATE TABLE `study` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `userid` int(10) DEFAULT NULL,
  `programid` int(10) DEFAULT NULL,
  `projectid` int(10) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `studytypeid` int(5) DEFAULT NULL,
  `startyear` varchar(4) DEFAULT NULL,
  `endyear` varchar(4) DEFAULT NULL,
  `remarks` varchar(200) DEFAULT NULL,
  `shared` enum('private','public') DEFAULT 'private',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;

/*Data for the table `study` */

insert  into `study`(`id`,`userid`,`programid`,`projectid`,`name`,`description`,`studytypeid`,`startyear`,`endyear`,`remarks`,`shared`) values (1,1,1,1,'Study1',NULL,1,'2012','2013',NULL,'private');
insert  into `study`(`id`,`userid`,`programid`,`projectid`,`name`,`description`,`studytypeid`,`startyear`,`endyear`,`remarks`,`shared`) values (2,1,1,1,'Study2',NULL,2,'2012','2013',NULL,'private');
insert  into `study`(`id`,`userid`,`programid`,`projectid`,`name`,`description`,`studytypeid`,`startyear`,`endyear`,`remarks`,`shared`) values (3,1,1,1,'Study3',NULL,2,'2011','2012',NULL,'private');
insert  into `study`(`id`,`userid`,`programid`,`projectid`,`name`,`description`,`studytypeid`,`startyear`,`endyear`,`remarks`,`shared`) values (4,1,1,1,'Study4',NULL,2,'2011','2012',NULL,'public');
insert  into `study`(`id`,`userid`,`programid`,`projectid`,`name`,`description`,`studytypeid`,`startyear`,`endyear`,`remarks`,`shared`) values (5,1,1,1,'Study5',NULL,2,'2013','2014',NULL,'public');
insert  into `study`(`id`,`userid`,`programid`,`projectid`,`name`,`description`,`studytypeid`,`startyear`,`endyear`,`remarks`,`shared`) values (6,1,1,2,'Study6',NULL,3,'2010','2012',NULL,'public');
insert  into `study`(`id`,`userid`,`programid`,`projectid`,`name`,`description`,`studytypeid`,`startyear`,`endyear`,`remarks`,`shared`) values (7,1,1,2,'Study7',NULL,3,'2010','2012',NULL,'private');
insert  into `study`(`id`,`userid`,`programid`,`projectid`,`name`,`description`,`studytypeid`,`startyear`,`endyear`,`remarks`,`shared`) values (8,1,1,2,'Study8',NULL,3,'2010','2013',NULL,'private');
insert  into `study`(`id`,`userid`,`programid`,`projectid`,`name`,`description`,`studytypeid`,`startyear`,`endyear`,`remarks`,`shared`) values (9,1,1,2,'Study9',NULL,4,'2011','2013',NULL,'public');
insert  into `study`(`id`,`userid`,`programid`,`projectid`,`name`,`description`,`studytypeid`,`startyear`,`endyear`,`remarks`,`shared`) values (10,1,1,2,'Study10',NULL,4,'2013','2014',NULL,'public');
insert  into `study`(`id`,`userid`,`programid`,`projectid`,`name`,`description`,`studytypeid`,`startyear`,`endyear`,`remarks`,`shared`) values (11,1,1,2,'Study11',NULL,4,'2013','2014',NULL,'private');
insert  into `study`(`id`,`userid`,`programid`,`projectid`,`name`,`description`,`studytypeid`,`startyear`,`endyear`,`remarks`,`shared`) values (13,NULL,2,3,'Study12',NULL,1,NULL,NULL,NULL,'private');
insert  into `study`(`id`,`userid`,`programid`,`projectid`,`name`,`description`,`studytypeid`,`startyear`,`endyear`,`remarks`,`shared`) values (14,NULL,2,3,'Study13',NULL,1,NULL,NULL,NULL,'private');
insert  into `study`(`id`,`userid`,`programid`,`projectid`,`name`,`description`,`studytypeid`,`startyear`,`endyear`,`remarks`,`shared`) values (15,NULL,2,3,'Study14',NULL,1,NULL,NULL,NULL,'private');
insert  into `study`(`id`,`userid`,`programid`,`projectid`,`name`,`description`,`studytypeid`,`startyear`,`endyear`,`remarks`,`shared`) values (16,NULL,2,4,'Study15',NULL,2,NULL,NULL,NULL,'private');
insert  into `study`(`id`,`userid`,`programid`,`projectid`,`name`,`description`,`studytypeid`,`startyear`,`endyear`,`remarks`,`shared`) values (17,NULL,2,4,'Study16',NULL,3,NULL,NULL,NULL,'private');
insert  into `study`(`id`,`userid`,`programid`,`projectid`,`name`,`description`,`studytypeid`,`startyear`,`endyear`,`remarks`,`shared`) values (18,NULL,2,4,'Study17',NULL,3,NULL,NULL,NULL,'private');
insert  into `study`(`id`,`userid`,`programid`,`projectid`,`name`,`description`,`studytypeid`,`startyear`,`endyear`,`remarks`,`shared`) values (19,NULL,2,5,'Study18',NULL,4,NULL,NULL,NULL,'private');
insert  into `study`(`id`,`userid`,`programid`,`projectid`,`name`,`description`,`studytypeid`,`startyear`,`endyear`,`remarks`,`shared`) values (20,NULL,2,5,'Study19',NULL,4,NULL,NULL,NULL,'private');
insert  into `study`(`id`,`userid`,`programid`,`projectid`,`name`,`description`,`studytypeid`,`startyear`,`endyear`,`remarks`,`shared`) values (21,NULL,2,6,'Study20',NULL,4,NULL,NULL,NULL,'private');

/*Table structure for table `studylocation` */

DROP TABLE IF EXISTS `studylocation`;

CREATE TABLE `studylocation` (
  `id` int(5) DEFAULT NULL,
  `studyid` int(10) DEFAULT NULL,
  `locationid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `studylocation` */

insert  into `studylocation`(`id`,`studyid`,`locationid`) values (NULL,1,1);
insert  into `studylocation`(`id`,`studyid`,`locationid`) values (NULL,2,2);
insert  into `studylocation`(`id`,`studyid`,`locationid`) values (NULL,3,1);
insert  into `studylocation`(`id`,`studyid`,`locationid`) values (NULL,4,2);
insert  into `studylocation`(`id`,`studyid`,`locationid`) values (NULL,5,3);
insert  into `studylocation`(`id`,`studyid`,`locationid`) values (NULL,6,4);
insert  into `studylocation`(`id`,`studyid`,`locationid`) values (NULL,7,5);
insert  into `studylocation`(`id`,`studyid`,`locationid`) values (NULL,8,6);
insert  into `studylocation`(`id`,`studyid`,`locationid`) values (NULL,9,1);
insert  into `studylocation`(`id`,`studyid`,`locationid`) values (NULL,10,2);
insert  into `studylocation`(`id`,`studyid`,`locationid`) values (NULL,11,3);
insert  into `studylocation`(`id`,`studyid`,`locationid`) values (NULL,12,4);
insert  into `studylocation`(`id`,`studyid`,`locationid`) values (NULL,13,2);
insert  into `studylocation`(`id`,`studyid`,`locationid`) values (NULL,14,3);
insert  into `studylocation`(`id`,`studyid`,`locationid`) values (NULL,15,5);
insert  into `studylocation`(`id`,`studyid`,`locationid`) values (NULL,16,6);
insert  into `studylocation`(`id`,`studyid`,`locationid`) values (NULL,17,7);
insert  into `studylocation`(`id`,`studyid`,`locationid`) values (NULL,18,8);
insert  into `studylocation`(`id`,`studyid`,`locationid`) values (NULL,19,5);
insert  into `studylocation`(`id`,`studyid`,`locationid`) values (NULL,20,1);
insert  into `studylocation`(`id`,`studyid`,`locationid`) values (NULL,21,2);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
