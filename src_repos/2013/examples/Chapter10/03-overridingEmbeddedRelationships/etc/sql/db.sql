DROP TABLE CUST_PHONE;
DROP TABLE EMP_PHONES;
DROP TABLE PHONE;
DROP TABLE CUSTOMER;
DROP TABLE EMPLOYEE;
CREATE TABLE PHONE (NUM VARCHAR(255) NOT NULL, TYPE VARCHAR(255), PRIMARY KEY (NUM));
CREATE TABLE CUSTOMER (ID INTEGER NOT NULL, STREET VARCHAR(255), CITY VARCHAR(255), STATE VARCHAR(255), ZIP VARCHAR(255),  EMERG_PHONE VARCHAR(255), PRIMARY KEY (ID));
CREATE TABLE EMPLOYEE (ID INTEGER NOT NULL, NAME VARCHAR(255), SALARY BIGINT, STREET VARCHAR(255), CITY VARCHAR(255), STATE VARCHAR(255), ZIP_CODE VARCHAR(255), PRI_NUM VARCHAR(255), PRIMARY KEY (ID));
CREATE TABLE CUST_PHONE (Customer_ID INTEGER NOT NULL, phones_NUM VARCHAR(255) NOT NULL, PRIMARY KEY (Customer_ID, phones_NUM));
CREATE TABLE EMP_PHONES (phones_NUM VARCHAR(255) NOT NULL, Customer_ID INTEGER NOT NULL, PRIMARY KEY (phones_NUM, Customer_ID));
