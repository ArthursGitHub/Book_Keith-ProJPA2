DROP TABLE EMPLOYEE;

CREATE TABLE EMPLOYEE(ID INTEGER  NOT NULL, NAME VARCHAR(255), VERSION INTEGER, STATUS INTEGER, SALARY BIGINT, VACATIONDAYS FLOAT, PRIMARY KEY (ID));

INSERT INTO EMPLOYEE (ID, NAME, VERSION, STATUS, SALARY, VACATIONDAYS) VALUES (1, 'Jane', 1, 1, 25000, 20.33);
INSERT INTO EMPLOYEE (ID, NAME, VERSION, STATUS, SALARY, VACATIONDAYS) VALUES (2, 'John', 1, 2, 35000, 12.0);
INSERT INTO EMPLOYEE (ID, NAME, VERSION, STATUS, SALARY, VACATIONDAYS) VALUES (3, 'Tom', 1, 3, 45000, 10.66);
INSERT INTO EMPLOYEE (ID, NAME, VERSION, STATUS, SALARY, VACATIONDAYS) VALUES (4, 'Dick', 1, 1, 32000, 12.0);
INSERT INTO EMPLOYEE (ID, NAME, VERSION, STATUS, SALARY, VACATIONDAYS) VALUES (5, 'Hank', 1, 0, 56000, 11.5);
INSERT INTO EMPLOYEE (ID, NAME, VERSION, STATUS, SALARY, VACATIONDAYS) VALUES (6, 'Lily', 1, 2, 61000, 14.33);

