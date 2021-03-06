
CREATE TABLE `department_details` (
  `DEP_ID` bigint(20) NOT NULL,
  `DEPARTMENT_NAME` varchar(255) DEFAULT NULL,
PRIMARY KEY (`DEP_ID`),
 UNIQUE KEY `DEP_ID` (`DEP_ID`));


CREATE TABLE `doctor_details` (
 `DOCTOR_ID` bigint(20) NOT NULL,
 
 `DOCTOR_NAME` varchar(255) DEFAULT NULL,
 `FROM_DATE` datetime DEFAULT NULL,
 `TO_DATE` datetime DEFAULT NULL,
  `FROM_TIME` varchar(50) DEFAULT NULL,
 `TO_TIME` varchar(50) DEFAULT NULL,
 `DEPARTMENT_NAME` varchar(255) DEFAULT NULL,
 
  PRIMARY KEY (`DOCTOR_ID`),
  UNIQUE KEY `DOCTOR_ID` (`DOCTOR_ID`)
  
  
);



CREATE TABLE `APPOINTMENT` (
  `APP_ID` bigint(20) NOT NULL,
  `DATEOFAPP` datetime DEFAULT NULL,
  `DEPARTMENT` varchar(255) DEFAULT NULL,
  `DOCTOR` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`APP_ID`),
  UNIQUE KEY `APP_ID` (`APP_ID`)
);

CREATE TABLE `logindetails` (
  `LOGIN_ID` bigint(20) NOT NULL,
 
  `USERNAME` varchar(50) DEFAULT NULL,
  `PASSWORD` varbinary(250) DEFAULT NULL,
  PRIMARY KEY (`LOGIN_ID`)
  );
CREATE TABLE `PATIENT` (
  `PATIENT_ID` bigint(20) NOT NULL,
  `DOB` datetime DEFAULT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `EMERGENCY_CONTACT_NAME` varchar(255) DEFAULT NULL,
  `EMERGENCY_RELATIONSHIP` varchar(255) DEFAULT NULL,
  `FIRSTNAME` varchar(255) DEFAULT NULL,
  `PATIENT_GENDER` varchar(255) DEFAULT NULL,
  `LASTNAME` varchar(255) DEFAULT NULL,
  `MIDDLENAME` varchar(255) DEFAULT NULL,
  `CELL_PHONE_NUMBER` varchar(255) DEFAULT NULL,
  `OCCUPATION` varchar(255) DEFAULT NULL,
  `PHONE_OFFICE` varchar(255) DEFAULT NULL,
  `PHONE_RESIDENCE` varchar(255) DEFAULT NULL,
  `UHID` varchar(255) NOT NULL,
  PRIMARY KEY (`PATIENT_ID`),
  UNIQUE KEY `PATIENT_ID` (`PATIENT_ID`),
  UNIQUE KEY `UHID` (`UHID`)
);

CREATE TABLE `PATIENT_ADDRESS` (
  `ADDRESS_ID` int(11) NOT NULL AUTO_INCREMENT,
  `ADDRESS_LINE1` varchar(255) DEFAULT NULL,
  `ADDRESS_LINE2` varchar(255) DEFAULT NULL,
  `ADDRESS_TYPE` varchar(255) DEFAULT NULL,
  `CITY` varchar(255) DEFAULT NULL,
  `COUNTRY` varchar(255) DEFAULT NULL,
  `DISTRICT` varchar(255) DEFAULT NULL,
  `EMAIL_ADDRESS` varchar(255) DEFAULT NULL,
  `PHONE_NUMBER` varchar(255) DEFAULT NULL,
  `PHONE_TYPE` varchar(255) DEFAULT NULL,
  `PIN_CODE` varchar(255) DEFAULT NULL,
  `STATE` varchar(255) DEFAULT NULL,
  `patient_PATIENT_ID` bigint(20) DEFAULT NULL,
  `PATIENT_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ADDRESS_ID`),
  UNIQUE KEY `ADDRESS_ID` (`ADDRESS_ID`),
  KEY `FK8BF3907A39C2D593` (`PATIENT_ID`),
  KEY `FK8BF3907A31349B0D` (`patient_PATIENT_ID`),
  CONSTRAINT `FK8BF3907A31349B0D` FOREIGN KEY (`patient_PATIENT_ID`) REFERENCES `PATIENT` (`PATIENT_ID`),
  CONSTRAINT `FK8BF3907A39C2D593` FOREIGN KEY (`PATIENT_ID`) REFERENCES `PATIENT` (`PATIENT_ID`)
);

CREATE TABLE `EMERGENCY_CONTACT_ADDRESS` (
  `ERMERGENCY_CONT_ID` int(11) NOT NULL AUTO_INCREMENT,
  `ADDRESS_LINE1` varchar(255) DEFAULT NULL,
  `ADDRESS_LINE2` varchar(255) DEFAULT NULL,
  `CITY` varchar(255) DEFAULT NULL,
  `COUNTRY` varchar(255) DEFAULT NULL,
  `DISTRICT` varchar(255) DEFAULT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `FIRSTNAME` varchar(255) DEFAULT NULL,
  `LASTNAME` varchar(255) DEFAULT NULL,
  `MIDDLENAME` varchar(255) DEFAULT NULL,
  `CELL_PHONE_NUMBER` varchar(255) DEFAULT NULL,
  `PHONE_OFFICE` varchar(255) DEFAULT NULL,
  `PHONE_RESIDENCE` varchar(255) DEFAULT NULL,
  `PIN_CODE` varchar(255) DEFAULT NULL,
  `RELATIONSHIP_TYPE` varchar(255) DEFAULT NULL,
  `STATE` varchar(255) DEFAULT NULL,
  `patient_PATIENT_ID` bigint(20) DEFAULT NULL,
  `PATIENT_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ERMERGENCY_CONT_ID`),
  UNIQUE KEY `ERMERGENCY_CONT_ID` (`ERMERGENCY_CONT_ID`),
  KEY `FK8DC8A7C739C2D593` (`PATIENT_ID`),
  KEY `FK8DC8A7C731349B0D` (`patient_PATIENT_ID`),
  CONSTRAINT `FK8DC8A7C731349B0D` FOREIGN KEY (`patient_PATIENT_ID`) REFERENCES `PATIENT` (`PATIENT_ID`),
  CONSTRAINT `FK8DC8A7C739C2D593` FOREIGN KEY (`PATIENT_ID`) REFERENCES `PATIENT` (`PATIENT_ID`)
);
