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
  Record_Status     CHAR,
  PRIMARY KEY (User_ID)
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
  Record_Status     CHAR,
  PRIMARY KEY (Dept_ID)
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
  Street_No					VARCHAR(40),
  Ward							VARCHAR(5),
  District					VARCHAR(20),
  City							VARCHAR(20),
  Register          VARCHAR(40),
  Updater           VARCHAR(40),
  Register_Date     DATETIME,
  Update_Date       DATETIME,
  Record_Status     CHAR,
  PRIMARY KEY (Patient_ID)
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
  Record_Status     CHAR,
  PRIMARY KEY (Doctor_ID),
  CONSTRAINT FK_DOCTOR_DEPT FOREIGN KEY FK_DOCTOR_DEPT (Dept_ID)
  REFERENCES DEPARTMENT (Dept_ID)
  ON DELETE CASCADE
  ON UPDATE CASCADE
);

-- Service --
create table HMS.Service
(
  Service_No        INT AUTO_INCREMENT,
  Patient_ID      	VARCHAR(20),
  Dept_ID      			VARCHAR(20),
  Price        			DOUBLE,
  Register          VARCHAR(40),
  Updater           VARCHAR(40),
  Register_Date     DATETIME,
  Update_Date       DATETIME,
  Record_Status     CHAR,
  PRIMARY KEY (Service_No),
  CONSTRAINT FK_SERVICE_PATIENT FOREIGN KEY FK_SERVICE_PATIENT (Patient_ID)
  REFERENCES PATIENT (Patient_ID)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
  CONSTRAINT FK_SERVICE_DEPT FOREIGN KEY FK_SERVICE_DEPT (Dept_ID)
  REFERENCES DEPARTMENT (Dept_ID)
  ON DELETE CASCADE
  ON UPDATE CASCADE
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
  Record_Status     CHAR,
  PRIMARY KEY (Basic_Record_ID),
  CONSTRAINT FK_BASIC_PATIENT FOREIGN KEY FK_BASIC_PATIENT (Patient_ID)
  REFERENCES PATIENT (Patient_ID)
  ON DELETE CASCADE
  ON UPDATE CASCADE
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
  Record_Status     CHAR,
  PRIMARY KEY (Record_ID),
  CONSTRAINT FK_MEDICAL_RECORD_PATIENT FOREIGN KEY FK_MEDICAL_RECORD_PATIENT (Patient_ID)
  REFERENCES PATIENT (Patient_ID)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
  CONSTRAINT FK_MEDICAL_RECORD_DOCTOR FOREIGN KEY FK_MEDICAL_RECORD_DOCTOR (Doctor_ID)
  REFERENCES DOCTOR (Doctor_ID)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
  CONSTRAINT FK_MEDICAL_RECORD_DEPT FOREIGN KEY FK_MEDICAL_RECORD_DEPT (Dept_ID)
  REFERENCES DEPARTMENT (Dept_ID)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
  CONSTRAINT FK_MEDICAL_RECORD_BASIC FOREIGN KEY FK_MEDICAL_RECORD_BASIC (Basic_Record_ID)
  REFERENCES BASIC_MEDICAL_RECORD (Basic_Record_ID)
  ON DELETE CASCADE
  ON UPDATE CASCADE
);

-- V_Material --
create table HMS.V_Material
(
  No                 INT AUTO_INCREMENT,
  Type      	      VARCHAR(20),
  Value     		   VARCHAR(100),
  Value_Disp        	VARCHAR(100),
  Register          VARCHAR(40),
  Updater           VARCHAR(40),
  Register_Date     DATETIME,
  Update_Date       DATETIME,
  Record_Status     CHAR,
  PRIMARY KEY (No)
);

-- Medicine_Group --
create table HMS.Medicine_Group
(
  Group_ID          VARCHAR(20),
  Group_Name        VARCHAR(100),
  Description       VARCHAR(200),
  Register          VARCHAR(40),
  Updater           VARCHAR(40),
  Register_Date     DATETIME,
  Update_Date       DATETIME,
  Record_Status     CHAR,
  PRIMARY KEY (Group_ID)
);

-- Medicine --
create table HMS.Medicine
(
  Medicine_ID        VARCHAR(20),
  Medicine_Name      VARCHAR(100),
  Group_ID      		VARCHAR(20),
  Parameter          VARCHAR(200),
  Price					DOUBLE,
  Cost					DOUBLE,
  Unit 					VARCHAR(10),
  Manufacturer 		VARCHAR(100),
  Whole_Sale_Price	DOUBLE,
  Insurance_Price	   DOUBLE,
  Register           VARCHAR(40),
  Updater            VARCHAR(40),
  Register_Date      DATETIME,
  Update_Date        DATETIME,
  Record_Status      CHAR,
  PRIMARY KEY (Medicine_ID),
  CONSTRAINT FK_MEDICINE_GROUP FOREIGN KEY FK_MEDICINE_GROUP (Group_ID)
  REFERENCES Medicine_Group (Group_ID)
  ON DELETE CASCADE
  ON UPDATE CASCADE
);

---------------------------------------------------- RECORD ---------------------------------------------------------
-- User_Master --
insert into HMS.User_Master (User_ID, Password, User_Name, Address, Phone_Number, User_Level, Number_of_Login, Last_Login_Date, Register, Updater, Register_Date, Update_Date, Record_Status)
values ('admin', 'admin', 'Administrator', 'aaaa', '0939249015', 1, 0, null, 'Huan Pham', null, null, null, 'A');

insert into HMS.User_Master (User_ID, Password, User_Name, Address, Phone_Number, User_Level, Number_of_Login, Last_Login_Date, Register, Updater, Register_Date, Update_Date, Record_Status)
values ('user', 'user', 'User', 'bbbb', '00000000', 0, 0, null, 'Huan Pham', null, null, null, 'A');

-- Department --
insert into HMS.Department (Dept_ID, Dept_Name, Register, Updater, Register_Date, Update_Date, Record_Status)
values ('DEPT1', 'Department1', 'Huan Pham', null, null, null, 'A');

insert into HMS.Department (Dept_ID, Dept_Name, Register, Updater, Register_Date, Update_Date, Record_Status)
values ('DEPT2', 'Department2', 'Huan Pham', null, null, null, 'A');

-- Patient --
insert into HMS.Patient (Patient_ID, Patient_Name, Day_Of_Birth, Sex, Phone_Number, Email, Career, Street_No, Ward, District, City, Register, Updater, Register_Date, Update_Date, Record_Status)
values ('P1', 'PATIENT1', null, 'M', '000000000', 'email@yaho.com', 'aaaaa', 'Duong so 51', '14', 'Go Vap', 'Ho Chi Minh', 'Huan Pham', null, null, null, 'A');

insert into HMS.Patient (Patient_ID, Patient_Name, Day_Of_Birth, Sex, Phone_Number, Email, Career, Street_No, Ward, District, City, Register, Updater, Register_Date, Update_Date, Record_Status)
values ('P2', 'PATIENT2', null, 'F', '000000000', 'email@yaho.com', 'aaaaa', 'Duong so 51', '14', 'Go Vap', 'Ho Chi Minh', 'Huan Pham', null, null, null, 'A');

-- Doctor --
insert into HMS.Doctor (Doctor_ID, Doctor_Name, Dept_ID, Sex, Phone_Number, Email, Address, Register, Updater, Register_Date, Update_Date, Record_Status)
values ('DT1', 'Doctor1', 'DEPT1', 'M', '0939249015', 'email@yahoo.com', 'aaaaaaaaaaaaaaaaa', 'Huan Pham', null, null, null, 'A');

insert into HMS.Doctor (Doctor_ID, Doctor_Name, Dept_ID, Sex, Phone_Number, Email, Address, Register, Updater, Register_Date, Update_Date, Record_Status)
values ('DT2', 'Doctor2', 'DEPT1', 'F', '0939249015', 'email@yahoo.com', 'aaaaaaaaaaaaaaaaa', 'Huan Pham', null, null, null, 'A');

insert into HMS.Doctor (Doctor_ID, Doctor_Name, Dept_ID, Sex, Phone_Number, Email, Address, Register, Updater, Register_Date, Update_Date, Record_Status)
values ('DT3', 'Doctor3', 'DEPT2', 'M', '0939249015', 'email@yahoo.com', 'aaaaaaaaaaaaaaaaa', 'Huan Pham', null, null, null, 'A');

insert into HMS.Doctor (Doctor_ID, Doctor_Name, Dept_ID, Sex, Phone_Number, Email, Address, Register, Updater, Register_Date, Update_Date, Record_Status)
values ('DT4', 'Doctor4', 'DEPT2', 'F', '0939249015', 'email@yahoo.com', 'aaaaaaaaaaaaaaaaa', 'Huan Pham', null, null, null, 'A');

-- Service --
insert into HMS.Service (Service_No, Patient_ID, Dept_ID, Price, Register, Updater, Register_Date, Update_Date, Record_Status)
values (1, 'P1', 'DEPT1', '15000', 'Huan Pham', null, null, null, 'A');

insert into HMS.Service (Service_No, Patient_ID, Dept_ID, Price, Register, Updater, Register_Date, Update_Date, Record_Status)
values (2, 'P2', 'DEPT2', '35000', 'Huan Pham', null, null, null, 'A');

-- Basic_Medical_Record --
insert into HMS.Basic_Medical_Record (Basic_Record_ID, Patient_ID, Pulse, Temperature, Breathing, Blood_Pressure, Height, Weight, Record_Date, Register, Updater, Register_Date, Update_Date, Record_Status)
values ('BMR1', 'P1', 0, 0, 0, 0, 0, 0, null, 'Huan Pham', null, null, null, 'A');

insert into HMS.Basic_Medical_Record (Basic_Record_ID, Patient_ID, Pulse, Temperature, Breathing, Blood_Pressure, Height, Weight, Record_Date, Register, Updater, Register_Date, Update_Date, Record_Status)
values ('BMR2', 'P1', 1, 1, 1, 1, 1, 1, now(), 'Huan Pham', null, null, null, 'A');

-- Medical_Record --
insert into HMS.Medical_Record (Record_ID, Patient_ID, Doctor_ID, Dept_ID, Basic_Record_ID, Clinical_Symptoms, Pre_Diagnosis, Diagnosis, Register, Updater, Register_Date, Update_Date, Record_Status)
values ('MR1', 'P1', 'DT1', 'DEPT1', 'BMR2', 'aaaaaaa', 'bbbbbb', 'cccccc', 'Huan Pham', null, null, null, 'A');

-- V_Material --
insert into HMS.V_Material (No, Type, value, value_disp, Register, Updater, Register_Date, Update_Date, Record_Status)
values (1, 'department', 'Department1', 'Department1', 'Huan Pham', null, null, null, 'A');

insert into HMS.V_Material (No, Type, value, value_disp, Register, Updater, Register_Date, Update_Date, Record_Status)
values (2, 'department', 'Department2', 'Department2', 'Huan Pham', null, null, null, 'A');

insert into HMS.V_Material (No, Type, value, value_disp, Register, Updater, Register_Date, Update_Date, Record_Status)
values (3, 'unit', 'hop', 'Hop', 'Huan Pham', null, null, null, 'A');

insert into HMS.V_Material (No, Type, value, value_disp, Register, Updater, Register_Date, Update_Date, Record_Status)
values (4, 'unit', 'vi', 'Vi', 'Huan Pham', null, null, null, 'A');

insert into HMS.V_Material (No, Type, value, value_disp, Register, Updater, Register_Date, Update_Date, Record_Status)
values (5, 'unit', 'vien', 'Vien', 'Huan Pham', null, null, null, 'A');

insert into HMS.V_Material (No, Type, value, value_disp, Register, Updater, Register_Date, Update_Date, Record_Status)
values (6, 'unit', 'cai', 'Cai', 'Huan Pham', null, null, null, 'A');

-- Medicine_Group --
insert into HMS.Medicine_Group (Group_ID, Group_Name, Description, Register, Updater, Register_Date, Update_Date, Record_Status)
values ('Group1', 'Group 1', 'Group Medicine 1', 'Huan Pham', null, null, null, 'A');

insert into HMS.Medicine_Group (Group_ID, Group_Name, Description, Register, Updater, Register_Date, Update_Date, Record_Status)
values ('Group2', 'Group 2', 'Group Medicine 2', 'Huan Pham', null, null, null, 'A');

-- Medicine --
insert into HMS.Medicine (Medicine_ID, Medicine_Name, Group_ID, Parameter, Price, Cost, Unit, Manufacturer, Whole_Sale_Price, Insurance_Price, Register, Updater, Register_Date, Update_Date, Record_Status)
values ('Para', 'Paradol', 'Group1', 'Para, Suger', 5000, 4000, 'Hop', 'Ho Chi Minh', 5000, 5000, 'Huan Pham', null, null, null, 'A');

insert into HMS.Medicine (Medicine_ID, Medicine_Name, Group_ID, Parameter, Price, Cost, Unit, Manufacturer, Whole_Sale_Price, Insurance_Price, Register, Updater, Register_Date, Update_Date, Record_Status)
values ('Treps', 'Trepsil', 'Group2', 'Paracitamol, Suger', 15000, 14000, 'Vi', 'Ho Chi Minh', 15000, 15000, 'Huan Pham', null, null, null, 'A');