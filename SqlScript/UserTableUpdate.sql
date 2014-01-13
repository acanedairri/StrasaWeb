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

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `lastname` varchar(30) DEFAULT NULL,
  `firstname` varchar(30) DEFAULT NULL,
  `mi` varchar(30) DEFAULT NULL,
  `agency` varchar(100) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(200) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `country` varchar(50) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `role` varchar(20) DEFAULT 'ROLE_USER',
  `active` tinyint(1) DEFAULT '1',
  `dateregistered` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `user` */

insert  into `user`(`id`,`lastname`,`firstname`,`mi`,`agency`,`username`,`password`,`email`,`address`,`country`,`status`,`role`,`active`,`dateregistered`) values (1,'Talay ','Darwin','','IRRI','user1','24c9e15e52afc47c225b757e7bee1f9d','','College, Los Banos Laguna','Phil',0,'ROLE_USER',1,'2013-10-18 14:19:03'),(2,'Caneda','Alexander','A','IRRI','admin','21232f297a57a5a743894a0e4a801fc3','a.caneda@irri.org','College Laguna','Phil',1,'ROLE_ADMIN',1,'2013-10-18 14:19:03'),(3,'Gouyou','Ye',NULL,'PHILRICE','user2','7e58d63b60197ceb55a1c487989a3720','ye.gouyou@irri.org','College, Laguna','Phil',1,'ROLE_USER',1,'2013-10-18 14:19:03'),(4,'Racquel','Angel',NULL,'PHILRICE','user3','92877af70a45fd6a2ed7fe81e1236b78',NULL,NULL,NULL,0,'ROLE_USER',1,'2013-10-18 14:19:03');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
