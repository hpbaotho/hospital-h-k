-- HMS --
CREATE DATABASE HMS /*!40100 DEFAULT CHARACTER SET utf8 */;

-- User_Master --
create table HMS.User_Master
(
  User_ID           VARCHAR(20),
  Password          VARCHAR(20),
  User_Name         VARCHAR(40),
  Email        			VARCHAR(40),
  Address      			VARCHAR(100),
  Phone_Number      VARCHAR(20),
  User_Level        INT,
  Number_of_Login   INT,
  Last_Login_Date   DATETIME,
  Register          VARCHAR(40),
  Updater           VARCHAR(40),
  Register_Date     DATETIME,
  Update_Date       DATETIME,
  Record_Status     CHAR
);

-- Doctor --
create table HMS.Doctor
(
  Doctor_ID         VARCHAR(20),
  Doctor_Name       VARCHAR(40),
  Dept_ID           VARCHAR(20),
  Sex        				CHAR,
  Phone_Number      VARCHAR(20),
  Email        			VARCHAR(40),
  Address      			VARCHAR(100),
  Register          VARCHAR(40),
  Updater           VARCHAR(40),
  Register_Date     DATETIME,
  Update_Date       DATETIME,
  Record_Status     CHAR
);

-- Department --
create table HMS.Department
(
  Dept_ID         	VARCHAR(20),
  Dept_Name       	VARCHAR(40),
  Register          VARCHAR(40),
  Updater           VARCHAR(40),
  Register_Date     DATETIME,
  Update_Date       DATETIME,
  Record_Status     CHAR
);

-- Patient --
create table HMS.Patient
(
  Patient_ID        VARCHAR(20),
  Patient_Name      VARCHAR(40),
  Day_Of_Birth      DATETIME,
  Sex        				CHAR,
  Phone_Number      VARCHAR(20),
  Email        			VARCHAR(40),
  Career      			VARCHAR(100),
  StreetNo					VARCHAR(40),
  Ward							VARCHAR(5),
  District					VARCHAR(20),
  City							VARCHAR(20),
  Register          VARCHAR(40),
  Updater           VARCHAR(40),
  Register_Date     DATETIME,
  Update_Date       DATETIME,
  Record_Status     CHAR
);

-- Service --
create table HMS.Service
(
  Service_No        INT,
  Patient_ID      	VARCHAR(20),
  Dept_ID      			VARCHAR(20),
  Price        			DOUBLE,
  Register          VARCHAR(40),
  Updater           VARCHAR(40),
  Register_Date     DATETIME,
  Update_Date       DATETIME,
  Record_Status     CHAR
);

-- Medical_Record --
create table HMS.Medical_Record
(
  Record_ID        	VARCHAR(20),
  Patient_ID      	VARCHAR(20),
  Doctor_ID      		VARCHAR(20),
  Dept_ID        		VARCHAR(20),
  Basic_Record_ID		VARCHAR(20),
  Clinical_Symptoms VARCHAR(200),
  Pre_Diagnosis 		VARCHAR(200),
  Diagnosis 				VARCHAR(200),
  Register          VARCHAR(40),
  Updater           VARCHAR(40),
  Register_Date     DATETIME,
  Update_Date       DATETIME,
  Record_Status     CHAR
);

-- Basic_Medical_Record --
create table HMS.Basic_Medical_Record
(
  Basic_Record_ID   VARCHAR(20),
  Patient_ID      	VARCHAR(20),
  Pulse      				DOUBLE,
  Temperature       VARCHAR(20),
  Breathing					VARCHAR(20),
  Blood_Pressure 		VARCHAR(200),
  Height 						VARCHAR(200),
  Weight 						VARCHAR(200),
  Record_Date				DATETIME,
  Register          VARCHAR(40),
  Updater           VARCHAR(40),
  Register_Date     DATETIME,
  Update_Date       DATETIME,
  Record_Status     CHAR
);


insert into HMS.User_Master (User_ID, Password, User_Name, Address, Phone_Number, User_Level, Number_of_Login, Last_Login_Date, Register, Updater, Register_Date, Update_Date, Record_Status)
values ('admin', 'admin', 'Administrator', 'aaaa', '0939249015', 1, 0, null, 'Huan Pham', null, null, null, 'A');

insert into HMS.User_Master (User_ID, Password, User_Name, Address, Phone_Number, User_Level, Number_of_Login, Last_Login_Date, Register, Updater, Register_Date, Update_Date, Record_Status)
values ('user', 'user', 'User', 'bbbb', '00000000', 0, 0, null, 'Huan Pham', null, null, null, 'A');