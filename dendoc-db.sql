#--------FALL BACK scriptss --------
USE DENDOC;

DROP TABLE USERS;
DROP TABLE SERVICE;
DROP TABLE INSURANCE;

DROP DATABASE DENDOC;

#--------CREATION scriptss --------
CREATE DATABASE DENDOC;

USE DENDOC;

CREATE TABLE USERS
(
    USER_ID INT(11) NOT NULL AUTO_INCREMENT UNIQUE,
    LOGIN_NAME VARCHAR(100) NOT NULL UNIQUE,
    LOGIN_PASSWORD VARCHAR(100) DEFAULT NULL,
    USER_TYPE int(2) DEFAULT 0,
	LOGIN_TYPE int(2) DEFAULT 0,
    PRIMARY KEY (USER_ID)
);

CREATE TABLE SERVICE
(
    SERVICE_ID INT(10) NOT NULL AUTO_INCREMENT UNIQUE,
    SERVICE_NAME VARCHAR(100) DEFAULT NULL,
    SERVICE_DETAILS VARCHAR(1000) DEFAULT NULL ,
    PRIMARY KEY (SERVICE_ID)
);

INSERT INTO SERVICE(SERVICE_NAME, SERVICE_DETAILS) VALUES
('Cosmetic','Cosmetic'),('Dermal','Dermal'),
('Plastic surgeons','Plastic surgeons'),('Body ','Body'),
('Contouring','Contouring'),('Skin','Skin '),
('resurfacing','resurfacing'),('Beautician','Beautician'),
('facial','facial'),('hair removal ','hair removal');

CREATE TABLE INSURANCE 
(
    INSURANCE_ID INT(10) NOT NULL AUTO_INCREMENT UNIQUE,
    INSURANCE_NAME VARCHAR(100) DEFAULT NULL,
    INSURANCE_DETAILS VARCHAR(1000) DEFAULT NULL ,
    PRIMARY KEY (INSURANCE_ID)
);

INSERT INTO INSURANCE(INSURANCE_NAME, INSURANCE_DETAILS) VALUES
('HBF','HBF'),('Medibank','Medibank'),
('HIF','HIF'),('BUPA','BUPA'),
('MEDICARE','MEDICARE'),('MEDIBANK','MEDIBANK');


CREATE TABLE DENDOC.PROVIDER (
    PROVIDER_ID INT(10) NOT NULL UNIQUE,
    PROVIDER_NAME VARCHAR(1000) DEFAULT NULL,
    PHONE_NUMBER VARCHAR(20) DEFAULT NULL,
    EMAIL VARCHAR(100) DEFAULT NULL,
	STATUS VARCHAR(10) DEFAULT NULL,
    PRIMARY KEY (PROVIDER_ID),
    FOREIGN KEY (PROVIDER_ID) REFERENCES DENDOC.USERS(USER_ID)
);

CREATE TABLE DENDOC.CLIENT (
    CLIENT_ID INT(10) NOT NULL UNIQUE,
    CLIENT_NAME VARCHAR(1000) DEFAULT NULL,
    PHONE_NUMBER VARCHAR(20) DEFAULT NULL,
    EMAIL VARCHAR(100) DEFAULT NULL,
    PRIMARY KEY (CLIENT_ID)
);

CREATE TABLE DENDOC.ADDRESS
(
    ADDRESS_ID INT(10) NOT NULL AUTO_INCREMENT UNIQUE,
    PINCODE INT(10) DEFAULT NULL,
    ADDRESS VARCHAR(1000) DEFAULT NULL ,
    STATE VARCHAR(100) DEFAULT NULL ,
	COUNTRY VARCHAR(100) DEFAULT NULL ,
    PROVIDER_ID INT(10) NOT NULL UNIQUE,	
	PROVIDER_ID_PK INT(10) NOT NULL UNIQUE,
    PRIMARY KEY (ADDRESS_ID),
    FOREIGN KEY (PROVIDER_ID_PK) REFERENCES DENDOC.PROVIDER(PROVIDER_ID)
);
 
CREATE TABLE provider_insurance 
(
INSURANCE_ID INT(10) NOT NULL,
FOREIGN KEY (INSURANCE_ID) REFERENCES INSURANCE(INSURANCE_ID),
PROVIDER_ID INT(10) NOT NULL,
FOREIGN KEY (PROVIDER_ID) REFERENCES PROVIDER(PROVIDER_ID)
);

CREATE TABLE PROVIDER_SERVICE 
(
SERVICE_ID INT(10) NOT NULL,
FOREIGN KEY (SERVICE_ID) REFERENCES SERVICE(SERVICE_ID),
PROVIDER_ID INT(10) NOT NULL,
FOREIGN KEY (PROVIDER_ID) REFERENCES PROVIDER(PROVIDER_ID)
);