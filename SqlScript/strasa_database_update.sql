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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

/*Data for the table `location` */

insert  into `location`(`id`,`locationname`,`country`,`province`,`region`,`altitude`,`latitude`,`weatherstation`) values (1,'Los Banos','PHIL',NULL,NULL,NULL,NULL,NULL);
insert  into `location`(`id`,`locationname`,`country`,`province`,`region`,`altitude`,`latitude`,`weatherstation`) values (2,'Nueva Ecija','PHIL',NULL,NULL,NULL,NULL,NULL);
insert  into `location`(`id`,`locationname`,`country`,`province`,`region`,`altitude`,`latitude`,`weatherstation`) values (3,'Location 3','PHIL',NULL,NULL,NULL,NULL,NULL);
insert  into `location`(`id`,`locationname`,`country`,`province`,`region`,`altitude`,`latitude`,`weatherstation`) values (4,'Location 4','PHIL',NULL,NULL,NULL,NULL,NULL);
insert  into `location`(`id`,`locationname`,`country`,`province`,`region`,`altitude`,`latitude`,`weatherstation`) values (5,'Location 5','INDIA',NULL,NULL,NULL,NULL,NULL);
insert  into `location`(`id`,`locationname`,`country`,`province`,`region`,`altitude`,`latitude`,`weatherstation`) values (6,'Location 6','INDIA',NULL,NULL,NULL,NULL,NULL);
insert  into `location`(`id`,`locationname`,`country`,`province`,`region`,`altitude`,`latitude`,`weatherstation`) values (7,'Location 7','AFRICA',NULL,NULL,NULL,NULL,NULL);
insert  into `location`(`id`,`locationname`,`country`,`province`,`region`,`altitude`,`latitude`,`weatherstation`) values (8,'Location 8','AFRICA',NULL,NULL,NULL,NULL,NULL);
insert  into `location`(`id`,`locationname`,`country`,`province`,`region`,`altitude`,`latitude`,`weatherstation`) values (9,'Location 9','Phil',NULL,NULL,NULL,NULL,NULL);
insert  into `location`(`id`,`locationname`,`country`,`province`,`region`,`altitude`,`latitude`,`weatherstation`) values (10,'Palawan','PHIL',NULL,NULL,NULL,NULL,NULL);
insert  into `location`(`id`,`locationname`,`country`,`province`,`region`,`altitude`,`latitude`,`weatherstation`) values (11,'Lacation 10','PHIL','Laguna','Region 4',NULL,NULL,NULL);
insert  into `location`(`id`,`locationname`,`country`,`province`,`region`,`altitude`,`latitude`,`weatherstation`) values (12,'Location 10','PHIL','Batangas','Region 4',NULL,NULL,NULL);

/*Table structure for table `studydatacolumn` */

DROP TABLE IF EXISTS `studydatacolumn`;

CREATE TABLE `studydatacolumn` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `studyid` int(10) DEFAULT NULL,
  `columnheader` varchar(20) DEFAULT NULL,
  `datatype` enum('dd','rd') DEFAULT 'rd',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

/*Data for the table `studydatacolumn` */

insert  into `studydatacolumn`(`id`,`studyid`,`columnheader`,`datatype`) values (1,1,'GName','rd');
insert  into `studydatacolumn`(`id`,`studyid`,`columnheader`,`datatype`) values (2,1,'Source','rd');
insert  into `studydatacolumn`(`id`,`studyid`,`columnheader`,`datatype`) values (3,1,'Rep','rd');
insert  into `studydatacolumn`(`id`,`studyid`,`columnheader`,`datatype`) values (7,1,'Season','rd');
insert  into `studydatacolumn`(`id`,`studyid`,`columnheader`,`datatype`) values (8,1,'Year','rd');
insert  into `studydatacolumn`(`id`,`studyid`,`columnheader`,`datatype`) values (9,1,'Yld','rd');
insert  into `studydatacolumn`(`id`,`studyid`,`columnheader`,`datatype`) values (10,1,'DF','rd');

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

/*Table structure for table `studylocation` */

DROP TABLE IF EXISTS `studylocation`;

CREATE TABLE `studylocation` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `studyid` int(10) DEFAULT NULL,
  `locationid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=latin1;

/*Data for the table `studylocation` */

insert  into `studylocation`(`id`,`studyid`,`locationid`) values (1,1,1);
insert  into `studylocation`(`id`,`studyid`,`locationid`) values (2,2,2);
insert  into `studylocation`(`id`,`studyid`,`locationid`) values (3,3,1);
insert  into `studylocation`(`id`,`studyid`,`locationid`) values (4,4,2);
insert  into `studylocation`(`id`,`studyid`,`locationid`) values (5,5,3);
insert  into `studylocation`(`id`,`studyid`,`locationid`) values (6,6,4);
insert  into `studylocation`(`id`,`studyid`,`locationid`) values (7,7,5);
insert  into `studylocation`(`id`,`studyid`,`locationid`) values (8,8,6);
insert  into `studylocation`(`id`,`studyid`,`locationid`) values (9,9,1);
insert  into `studylocation`(`id`,`studyid`,`locationid`) values (10,10,2);
insert  into `studylocation`(`id`,`studyid`,`locationid`) values (11,11,3);
insert  into `studylocation`(`id`,`studyid`,`locationid`) values (12,12,4);
insert  into `studylocation`(`id`,`studyid`,`locationid`) values (13,13,2);
insert  into `studylocation`(`id`,`studyid`,`locationid`) values (14,14,3);
insert  into `studylocation`(`id`,`studyid`,`locationid`) values (15,15,5);
insert  into `studylocation`(`id`,`studyid`,`locationid`) values (16,16,6);
insert  into `studylocation`(`id`,`studyid`,`locationid`) values (17,17,7);
insert  into `studylocation`(`id`,`studyid`,`locationid`) values (18,18,8);
insert  into `studylocation`(`id`,`studyid`,`locationid`) values (19,19,5);
insert  into `studylocation`(`id`,`studyid`,`locationid`) values (20,20,1);
insert  into `studylocation`(`id`,`studyid`,`locationid`) values (21,21,2);
insert  into `studylocation`(`id`,`studyid`,`locationid`) values (22,1,2);
insert  into `studylocation`(`id`,`studyid`,`locationid`) values (23,11,9);
insert  into `studylocation`(`id`,`studyid`,`locationid`) values (24,10,10);
insert  into `studylocation`(`id`,`studyid`,`locationid`) values (25,11,9);
insert  into `studylocation`(`id`,`studyid`,`locationid`) values (26,11,11);
insert  into `studylocation`(`id`,`studyid`,`locationid`) values (27,11,NULL);
insert  into `studylocation`(`id`,`studyid`,`locationid`) values (28,11,NULL);

/*Table structure for table `studyvariable` */

DROP TABLE IF EXISTS `studyvariable`;

CREATE TABLE `studyvariable` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `variablecode` varchar(50) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `property` varchar(100) DEFAULT NULL,
  `method` varchar(100) DEFAULT NULL,
  `scale` int(100) DEFAULT NULL,
  `applytofilter` enum('Yes','No') DEFAULT 'No',
  `defaultcolumn` enum('Yes','No') DEFAULT 'No',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1283 DEFAULT CHARSET=latin1;

/*Data for the table `studyvariable` */

insert  into `studyvariable`(`id`,`variablecode`,`description`,`property`,`method`,`scale`,`applytofilter`,`defaultcolumn`) values (1190,'1000GW','Weight of the 1000-dehulled grains having pericarp (seed coat). Expressed in grams.','1000-GRAIN WEIGHT','Thousand Grains',0,'No','No');
insert  into `studyvariable`(`id`,`variablecode`,`description`,`property`,`method`,`scale`,`applytofilter`,`defaultcolumn`) values (1191,'100GW','Weight of the 100-dehulled grain having pericarp (seed coat). Expressed in grams.','100-GRAIN WEIGHT','Hundred Grains',0,'No','No');
insert  into `studyvariable`(`id`,`variablecode`,`description`,`property`,`method`,`scale`,`applytofilter`,`defaultcolumn`) values (1192,'AMY','Percent amylose of milled rice.','AMYLOSE CONTENT OF GRAIN','Standard laboratory procedure',0,'No','No');
insert  into `studyvariable`(`id`,`variablecode`,`description`,`property`,`method`,`scale`,`applytofilter`,`defaultcolumn`) values (1193,'AWNING','The presence or absence of awn. Observation may include relative awn size.','AWN PRESENCE','Reproductive Stage',0,'No','No');
insert  into `studyvariable`(`id`,`variablecode`,`description`,`property`,`method`,`scale`,`applytofilter`,`defaultcolumn`) values (1194,'AN','NO-DESC','AWNING','At Growth Stage 7-9',0,'No','No');
insert  into `studyvariable`(`id`,`variablecode`,`description`,`property`,`method`,`scale`,`applytofilter`,`defaultcolumn`) values (1195,'CLK','Defines a representative milled sample for the degree (extent) of chalkiness that will best describe','CHALKINESS OF ENDOSPERM','Milled Rice',0,'No','No');
insert  into `studyvariable`(`id`,`variablecode`,`description`,`property`,`method`,`scale`,`applytofilter`,`defaultcolumn`) values (1196,'CMD','Measurement of diameter of culm.','CULM DIAMETER','Reproductive Stage',0,'No','No');
insert  into `studyvariable`(`id`,`variablecode`,`description`,`property`,`method`,`scale`,`applytofilter`,`defaultcolumn`) values (1197,'CML','Length of the stem.','CULM LENGTH','At Growth Stage 7-9;Reproductive Stage',0,'No','No');
insert  into `studyvariable`(`id`,`variablecode`,`description`,`property`,`method`,`scale`,`applytofilter`,`defaultcolumn`) values (1198,'CMST','The test gives indication of culm stiffness and resilience.','CULM STRENGTH','At Growth Stage 8-9;Reproductive Stage',0,'No','No');
insert  into `studyvariable`(`id`,`variablecode`,`description`,`property`,`method`,`scale`,`applytofilter`,`defaultcolumn`) values (1199,'DTF','Number of days from the seed sowing or the seedling transplant date to the anthesis (flowering) stag','DAYS TO FLOWER','80% Flowering;At Harvest; ',0,'No','No');
insert  into `studyvariable`(`id`,`variablecode`,`description`,`property`,`method`,`scale`,`applytofilter`,`defaultcolumn`) values (1200,'DTH','Number of days required for the inflorescence (head/cob/panicle) to emerge from the flag leaf of a p','DAYS TO HEADING','80% Fully Headed; First Flowering; Full Panicle exsertion',0,'No','No');
insert  into `studyvariable`(`id`,`variablecode`,`description`,`property`,`method`,`scale`,`applytofilter`,`defaultcolumn`) values (1201,'DTM','Number of days required from seeding to seed/grain ripening .','DAYS TO MATURITY','85% Mature Grains',0,'No','No');
insert  into `studyvariable`(`id`,`variablecode`,`description`,`property`,`method`,`scale`,`applytofilter`,`defaultcolumn`) values (1202,'DRR','Scores are taken after 10 days following soaking rain or watering- Indicate the degree of stress bef','DROUGHT RECOVERY','Drought 2 (After 1st stress)',0,'No','No');
insert  into `studyvariable`(`id`,`variablecode`,`description`,`property`,`method`,`scale`,`applytofilter`,`defaultcolumn`) values (1203,'DRRE','Becoming tolerant to drought like conditions of minimal or no water content in the growth environmen','DROUGHT RESISTANCE','Drought 1 (Seedling Vigor)',0,'No','No');
insert  into `studyvariable`(`id`,`variablecode`,`description`,`property`,`method`,`scale`,`applytofilter`,`defaultcolumn`) values (1204,'DRS','NO-DESC','DROUGHT SENSITIVITY','At Maturity',0,'No','No');
insert  into `studyvariable`(`id`,`variablecode`,`description`,`property`,`method`,`scale`,`applytofilter`,`defaultcolumn`) values (1205,'FTP','NO-DESC','FERTILE PANICLES','Not Specified',0,'No','No');
insert  into `studyvariable`(`id`,`variablecode`,`description`,`property`,`method`,`scale`,`applytofilter`,`defaultcolumn`) values (1206,'FTL','NO-DESC','FERTILITY','Fertile Spikelets',0,'No','No');
insert  into `studyvariable`(`id`,`variablecode`,`description`,`property`,`method`,`scale`,`applytofilter`,`defaultcolumn`) values (1207,'FLA','It is measured near the collar as the angle of attachment between the flag leaf blade and the main i','FLAG LEAF ANGLE','At Growth Stage 4-5',0,'No','No');
insert  into `studyvariable`(`id`,`variablecode`,`description`,`property`,`method`,`scale`,`applytofilter`,`defaultcolumn`) values (1208,'GELC','Scoring of carbohydrate composition in grain by gel consistency type in mm.','GEL CONSISTENCY','Milled Rice',0,'No','No');
insert  into `studyvariable`(`id`,`variablecode`,`description`,`property`,`method`,`scale`,`applytofilter`,`defaultcolumn`) values (1209,'GELT','Temperature for the gelatinization process.','GELATINIZATION TEMPERATURE','Cooking Test',0,'No','No');
insert  into `studyvariable`(`id`,`variablecode`,`description`,`property`,`method`,`scale`,`applytofilter`,`defaultcolumn`) values (1210,'GRM','The physiological and developmental changes that occur in a seed commencing with water uptake (imbib','GERMINATION','Not Specified',0,'No','No');
insert  into `studyvariable`(`id`,`variablecode`,`description`,`property`,`method`,`scale`,`applytofilter`,`defaultcolumn`) values (1211,'GRL','Is the average length of the seed or caryopsis fruit in a cereal (with hull).','GRAIN LENGTH','At Growth Stage 9 (Mature Grain)',0,'No','No');
insert  into `studyvariable`(`id`,`variablecode`,`description`,`property`,`method`,`scale`,`applytofilter`,`defaultcolumn`) values (1212,'GRM','Moisture content of grain. Expressed in percentage.','GRAIN MOISTURE','Percent of total weight',0,'No','No');
insert  into `studyvariable`(`id`,`variablecode`,`description`,`property`,`method`,`scale`,`applytofilter`,`defaultcolumn`) values (1213,'GRS','An assay to determine the variation in the shape of the dehulled grain.','GRAIN SHAPE','At Growth Stage 9 (Mature Grain)',0,'No','No');
insert  into `studyvariable`(`id`,`variablecode`,`description`,`property`,`method`,`scale`,`applytofilter`,`defaultcolumn`) values (1214,'GRSZ','Seed size is determined by its length to width ratio.','GRAIN SIZE','Seed (with lemma and palea)',0,'No','No');
insert  into `studyvariable`(`id`,`variablecode`,`description`,`property`,`method`,`scale`,`applytofilter`,`defaultcolumn`) values (1215,'GRT','Thickness of the seed or fruit caryopsis with the hull.','GRAIN THICKNESS','At Growth Stage 9 (Mature Grain)',0,'No','No');
insert  into `studyvariable`(`id`,`variablecode`,`description`,`property`,`method`,`scale`,`applytofilter`,`defaultcolumn`) values (1216,'GW','Weight of the dehulled grains. Expressed in kilograms or grams.','GRAIN WEIGHT','Thousand Grains',0,'No','No');
insert  into `studyvariable`(`id`,`variablecode`,`description`,`property`,`method`,`scale`,`applytofilter`,`defaultcolumn`) values (1217,'GRW','Width of the dehulled grain with pericarp.','GRAIN WIDTH','At Growth Stage 9 (Mature Grain)',0,'No','No');
insert  into `studyvariable`(`id`,`variablecode`,`description`,`property`,`method`,`scale`,`applytofilter`,`defaultcolumn`) values (1218,'YLD','The grain yield, measured in kilograms per hectare at 14 percent moisture.','GRAIN YIELD','Paddy Rice',0,'No','No');
insert  into `studyvariable`(`id`,`variablecode`,`description`,`property`,`method`,`scale`,`applytofilter`,`defaultcolumn`) values (1219,'HDR','The 3/4 or longer whole milled kernels separated from the total milled rice.','HEAD RICE','Exceeding 8/10 of Average Length',0,'No','No');
insert  into `studyvariable`(`id`,`variablecode`,`description`,`property`,`method`,`scale`,`applytofilter`,`defaultcolumn`) values (1220,'FETOX','Sensitivity to the iron ion content in the growth environment.','IRON TOXICITY','Field Trial',0,'No','No');
insert  into `studyvariable`(`id`,`variablecode`,`description`,`property`,`method`,`scale`,`applytofilter`,`defaultcolumn`) values (1221,'LFSC','Color of leaf sheath.','LEAF SHEATH COLOR','At Growth Stage 3-5',0,'No','No');
insert  into `studyvariable`(`id`,`variablecode`,`description`,`property`,`method`,`scale`,`applytofilter`,`defaultcolumn`) values (1222,'LG','Measure of percentage of plants that lodged.','LODGING INCIDENCE','At Growth Stage 6-9',0,'No','No');
insert  into `studyvariable`(`id`,`variablecode`,`description`,`property`,`method`,`scale`,`applytofilter`,`defaultcolumn`) values (1223,'NUMPA','Average number of panicles per plant in a study.','NUMBER OF PANICLES','Count Per Square Meter',0,'No','No');
insert  into `studyvariable`(`id`,`variablecode`,`description`,`property`,`method`,`scale`,`applytofilter`,`defaultcolumn`) values (1224,'PNL','Measurement from panicle base to tip. Expressed in cm.','PANICLE LENGTH','At Maturity',0,'No','No');
insert  into `studyvariable`(`id`,`variablecode`,`description`,`property`,`method`,`scale`,`applytofilter`,`defaultcolumn`) values (1225,'PNW','Average weight of the panicle from the plants or tillers in a given study.','PANICLE WEIGHT','At Maturity',0,'No','No');
insert  into `studyvariable`(`id`,`variablecode`,`description`,`property`,`method`,`scale`,`applytofilter`,`defaultcolumn`) values (1226,'PHA  ','Breeding objectives for each variety and trait varies. The evaluation should reflect the overall acc','PHENOTYPIC ACCEPTABILITY                          ','At Maturity',0,'No','No');
insert  into `studyvariable`(`id`,`variablecode`,`description`,`property`,`method`,`scale`,`applytofilter`,`defaultcolumn`) values (1227,'PLHT','Plant height measured from the soil surface to the tip of extended panicles.','PLANT HEIGHT','MATURITY (Stages 7-9)                             ',0,'No','No');
insert  into `studyvariable`(`id`,`variablecode`,`description`,`property`,`method`,`scale`,`applytofilter`,`defaultcolumn`) values (1228,'PLVG','Represents the growth of plant.','PLANT VIGOR','At Germination Stage;',0,'No','No');
insert  into `studyvariable`(`id`,`variablecode`,`description`,`property`,`method`,`scale`,`applytofilter`,`defaultcolumn`) values (1229,'SDWT','Average weight of seeds obtained from a plant, representing the overall yields or produce from the f','SEED WEIGHT','1000-Seed Weight',0,'No','No');
insert  into `studyvariable`(`id`,`variablecode`,`description`,`property`,`method`,`scale`,`applytofilter`,`defaultcolumn`) values (1230,'SDVG','Represents the seedling growth of the plant.','SEEDLING VIGOR','At Germination Stage',0,'No','No');
insert  into `studyvariable`(`id`,`variablecode`,`description`,`property`,`method`,`scale`,`applytofilter`,`defaultcolumn`) values (1231,'SPFERT','Determined by percent of spikelets with grains identified by pressing the spikelets with the fingers','SPIKELET FERTILITY','At Growth Stage 9',0,'No','No');
insert  into `studyvariable`(`id`,`variablecode`,`description`,`property`,`method`,`scale`,`applytofilter`,`defaultcolumn`) values (1232,'SUB','NO-DESC','SUBMERGENCE TOLERANCE','Field Trial',0,'No','No');
insert  into `studyvariable`(`id`,`variablecode`,`description`,`property`,`method`,`scale`,`applytofilter`,`defaultcolumn`) values (1233,'THR','Percentage of shattered grains, determined by firmly grasping and pulling the hand over the panicle.','THRESHABILITY','At Growth Stage 9',0,'No','No');
insert  into `studyvariable`(`id`,`variablecode`,`description`,`property`,`method`,`scale`,`applytofilter`,`defaultcolumn`) values (1234,'TI','Degree of tillering is affected by variety, spacing of plants in the field, season of planting, and ','TILLERING ABILITY','NO-SCALE',0,'No','No');
insert  into `studyvariable`(`id`,`variablecode`,`description`,`property`,`method`,`scale`,`applytofilter`,`defaultcolumn`) values (1235,'YLDBIO','The material produced by the growth of plants, especially as a product of farming.','YIELD (BIOMASS)','Oven-drying',0,'No','No');
insert  into `studyvariable`(`id`,`variablecode`,`description`,`property`,`method`,`scale`,`applytofilter`,`defaultcolumn`) values (1253,'GName(NULL)','Germplasm Name',NULL,NULL,NULL,'No','Yes');
insert  into `studyvariable`(`id`,`variablecode`,`description`,`property`,`method`,`scale`,`applytofilter`,`defaultcolumn`) values (1254,'Site','Site',NULL,NULL,NULL,'No','No');
insert  into `studyvariable`(`id`,`variablecode`,`description`,`property`,`method`,`scale`,`applytofilter`,`defaultcolumn`) values (1255,'Location','Location',NULL,NULL,NULL,'No','No');
insert  into `studyvariable`(`id`,`variablecode`,`description`,`property`,`method`,`scale`,`applytofilter`,`defaultcolumn`) values (1256,'GID','GID',NULL,NULL,NULL,'No','No');
insert  into `studyvariable`(`id`,`variablecode`,`description`,`property`,`method`,`scale`,`applytofilter`,`defaultcolumn`) values (1257,'Breeder','Breeder',NULL,NULL,NULL,'No','No');
insert  into `studyvariable`(`id`,`variablecode`,`description`,`property`,`method`,`scale`,`applytofilter`,`defaultcolumn`) values (1258,'Parentage',NULL,NULL,NULL,NULL,'No','No');
insert  into `studyvariable`(`id`,`variablecode`,`description`,`property`,`method`,`scale`,`applytofilter`,`defaultcolumn`) values (1259,'Female Parent',NULL,NULL,NULL,NULL,'No','No');
insert  into `studyvariable`(`id`,`variablecode`,`description`,`property`,`method`,`scale`,`applytofilter`,`defaultcolumn`) values (1260,'Male Parent',NULL,NULL,NULL,NULL,'No','No');
insert  into `studyvariable`(`id`,`variablecode`,`description`,`property`,`method`,`scale`,`applytofilter`,`defaultcolumn`) values (1261,'Source',NULL,NULL,NULL,NULL,'No','No');
insert  into `studyvariable`(`id`,`variablecode`,`description`,`property`,`method`,`scale`,`applytofilter`,`defaultcolumn`) values (1262,'Selection History',NULL,NULL,NULL,NULL,'No','No');
insert  into `studyvariable`(`id`,`variablecode`,`description`,`property`,`method`,`scale`,`applytofilter`,`defaultcolumn`) values (1263,'GName',NULL,NULL,NULL,NULL,'No','No');
insert  into `studyvariable`(`id`,`variablecode`,`description`,`property`,`method`,`scale`,`applytofilter`,`defaultcolumn`) values (1264,'Season',NULL,NULL,NULL,NULL,'No','No');
insert  into `studyvariable`(`id`,`variablecode`,`description`,`property`,`method`,`scale`,`applytofilter`,`defaultcolumn`) values (1265,'RowBlock',NULL,NULL,NULL,NULL,'No','No');
insert  into `studyvariable`(`id`,`variablecode`,`description`,`property`,`method`,`scale`,`applytofilter`,`defaultcolumn`) values (1266,'RowColumn',NULL,NULL,NULL,NULL,'No','No');
insert  into `studyvariable`(`id`,`variablecode`,`description`,`property`,`method`,`scale`,`applytofilter`,`defaultcolumn`) values (1267,'FieldRow',NULL,NULL,NULL,NULL,'No','No');
insert  into `studyvariable`(`id`,`variablecode`,`description`,`property`,`method`,`scale`,`applytofilter`,`defaultcolumn`) values (1268,'FieldColumn',NULL,NULL,NULL,NULL,'No','No');
insert  into `studyvariable`(`id`,`variablecode`,`description`,`property`,`method`,`scale`,`applytofilter`,`defaultcolumn`) values (1269,'Year',NULL,NULL,NULL,NULL,'No','No');
insert  into `studyvariable`(`id`,`variablecode`,`description`,`property`,`method`,`scale`,`applytofilter`,`defaultcolumn`) values (1270,'Rep',NULL,NULL,NULL,NULL,'No','No');
insert  into `studyvariable`(`id`,`variablecode`,`description`,`property`,`method`,`scale`,`applytofilter`,`defaultcolumn`) values (1271,'ColBlock',NULL,NULL,NULL,NULL,'No','No');
insert  into `studyvariable`(`id`,`variablecode`,`description`,`property`,`method`,`scale`,`applytofilter`,`defaultcolumn`) values (1272,'Block',NULL,NULL,NULL,NULL,'No','No');
insert  into `studyvariable`(`id`,`variablecode`,`description`,`property`,`method`,`scale`,`applytofilter`,`defaultcolumn`) values (1274,'PH','Plang Height',NULL,NULL,NULL,'No','No');
insert  into `studyvariable`(`id`,`variablecode`,`description`,`property`,`method`,`scale`,`applytofilter`,`defaultcolumn`) values (1275,'DF','Days of Flowering',NULL,NULL,NULL,'No','No');
insert  into `studyvariable`(`id`,`variablecode`,`description`,`property`,`method`,`scale`,`applytofilter`,`defaultcolumn`) values (1276,'DFL','Days of Flowering',NULL,NULL,NULL,'No','No');
insert  into `studyvariable`(`id`,`variablecode`,`description`,`property`,`method`,`scale`,`applytofilter`,`defaultcolumn`) values (1277,'Designation','Germplasm Name',NULL,NULL,NULL,'No','No');
insert  into `studyvariable`(`id`,`variablecode`,`description`,`property`,`method`,`scale`,`applytofilter`,`defaultcolumn`) values (1278,'TN',NULL,NULL,NULL,NULL,'No','No');
insert  into `studyvariable`(`id`,`variablecode`,`description`,`property`,`method`,`scale`,`applytofilter`,`defaultcolumn`) values (1279,'TUNGRO',NULL,NULL,NULL,NULL,'No','No');
insert  into `studyvariable`(`id`,`variablecode`,`description`,`property`,`method`,`scale`,`applytofilter`,`defaultcolumn`) values (1280,'BLAST',NULL,NULL,NULL,NULL,'No','No');
insert  into `studyvariable`(`id`,`variablecode`,`description`,`property`,`method`,`scale`,`applytofilter`,`defaultcolumn`) values (1281,'BLS',NULL,NULL,NULL,NULL,'No','No');
insert  into `studyvariable`(`id`,`variablecode`,`description`,`property`,`method`,`scale`,`applytofilter`,`defaultcolumn`) values (1282,'BLB',NULL,NULL,NULL,NULL,'No','No');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
