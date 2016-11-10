CREATE DATABASE  IF NOT EXISTS `vehicle_details` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `vehicle_details`;


--
-- Table structure for table `car`
--

DROP TABLE IF EXISTS `car`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `car` (
  `CompanyName` varchar(30) NOT NULL DEFAULT '',
  `ModelName` varchar(30) NOT NULL DEFAULT '',
  `EngineInCC` decimal(6,2) DEFAULT NULL,
  `FuelCapacity` decimal(6,2) DEFAULT NULL,
  `Mileage` decimal(5,2) DEFAULT NULL,
  `Price` decimal(10,2) DEFAULT NULL,
  `RoadTax` decimal(4,2) DEFAULT NULL,
  `AC` tinyint(1) DEFAULT NULL,
  `PowerSteering` tinyint(1) DEFAULT NULL,
  `AccessoryKit` tinyint(1) DEFAULT NULL,
  `OnRoadPrice` decimal(11,2) DEFAULT NULL,
  PRIMARY KEY (`CompanyName`,`ModelName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `car`
--

LOCK TABLES `car` WRITE;
/*!40000 ALTER TABLE `car` DISABLE KEYS */;
INSERT INTO `car` VALUES ('Chevrolet','Beat',100.00,30.00,20.00,250000.00,2.00,1,0,1,255000.00),('Maruti','abc',140.00,25.00,20.00,250000.00,3.00,1,1,1,257500.00),('Maruti','Ninja',145.00,45.00,20.00,452000.00,4.00,1,1,1,470080.00),('Maruti','Suzuki',145.00,23.00,20.00,125000.00,2.00,0,1,1,127500.00),('Maruti','Swift',10.00,25.00,20.00,125000.00,2.00,0,1,1,127500.00),('Toyota','Etios',118.00,35.00,22.00,340000.00,2.00,1,1,0,346800.00);

