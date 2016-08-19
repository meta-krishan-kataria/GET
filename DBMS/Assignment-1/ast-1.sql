/*Assignment 2*/
CREATE DATABASE LIS;

USE LIS;

/*Creating tables for the library information system */
CREATE TABLE members(
    member_id VARCHAR(20) PRIMARY KEY,
    member_name VARCHAR(60) NOT NULL,
    address_line1 VARCHAR(50) NOT NULL,
    address_line2 VARCHAR(50),
    category VARCHAR(30) NOT NULL
);

CREATE TABLE subjects(
    subject_id VARCHAR(20) PRIMARY KEY,
    subject_name VARCHAR(30) NOT NULL
);

CREATE TABLE publishers(
    publisher_id VARCHAR(20) PRIMARY KEY,
    publisher_name VARCHAR(60) NOT NULL
);

CREATE TABLE authors(
    author_id VARCHAR(20) PRIMARY KEY,
    author_name VARCHAR(60) NOT NULL
);

CREATE TABLE titles(
    title_id INT PRIMARY KEY,
    title_name VARCHAR(50) NOT NULL,
    subject_id VARCHAR(20),
    publisher_id VARCHAR(20),
    CONSTRAINT fk_publisher_id FOREIGN KEY (publisher_id)
        REFERENCES publishers (publisher_id),
    CONSTRAINT fk_subject_id FOREIGN KEY (subject_id)
        REFERENCES subjects (subject_id)
);

CREATE TABLE books(
    accession_number INT PRIMARY KEY,
    title_id INT,
    purchase_dt DATE NOT NULL,
    price DECIMAL(7,2) NOT NULL,
    status VARCHAR(20),
    CONSTRAINT fk_title_id_books FOREIGN KEY (title_id)
        REFERENCES titles (title_id)
);

CREATE TABLE title_author(
    title_id INT,
    author_id VARCHAR(20),
    PRIMARY KEY (title_id,author_id),
    CONSTRAINT fk_title_id_title_author FOREIGN KEY (title_id)
        REFERENCES titles (title_id),
    CONSTRAINT fk_author_id_title_author FOREIGN KEY (author_id)
        REFERENCES authors (author_id)
);

CREATE TABLE book_issue(
    issue_dt TIMESTAMP,
    accession_number INT,
    member_id VARCHAR(20),
    due_dt TIMESTAMP,
    PRIMARY KEY (issue_dt,accession_number,member_id),
    CONSTRAINT fk_accession_number_book_issue FOREIGN KEY (accession_number)
        REFERENCES books (accession_number),
    CONSTRAINT fk_member_id_book_issue FOREIGN KEY (member_id)
        REFERENCES members (member_id)
);

CREATE TABLE book_return(
    return_dt DATE,
    accession_number INT,
    member_id VARCHAR(20),
    issue_dt TIMESTAMP,
    PRIMARY KEY (return_dt,accession_number,member_id),
    CONSTRAINT fk_accession_number_book_return FOREIGN KEY (accession_number)
        REFERENCES books (accession_number),
    CONSTRAINT fk_member_id_book_return FOREIGN KEY (member_id)
        REFERENCES members (member_id),
    CONSTRAINT fk_issue_dt_book_return FOREIGN KEY (issue_dt)
        REFERENCES book_issue (issue_dt)
);
    
/* Displaying all the table names present in the LIS */
SHOW TABLES;

/* Setting default values */
select CURRENT_TIMESTAMP+INTERVAL 15  DAY;
SELECT CURDATE();
ALTER TABLE book_issue MODIFY COLUMN 
    issue_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP;
ALTER TABLE book_issue MODIFY COLUMN 
    due_dt TIMESTAMP DEFAULT DATE_ADD(CURRENT_TIMESTAMP,INTERVAL 15 DAY);

/* Removing the members table from the database */
ALTER TABLE book_issue DROP 
    FOREIGN KEY fk_member_id_book_issue;
ALTER TABLE book_return DROP 
    FOREIGN KEY fk_member_id_book_return;
DROP TABLE members;

/* Recreating the members table */
CREATE TABLE members(
    member_id VARCHAR(20) PRIMARY KEY,
    member_name VARCHAR(40),
    address_line1 VARCHAR(50),
    address_line2 VARCHAR(50),
    category VARCHAR(30)
);

/* Restting the Foreign Key Constraints */
ALTER TABLE book_issue ADD 
    CONSTRAINT fk_member_id_book_issue FOREIGN KEY (member_id) 
        REFERENCES members (member_id);
        
ALTER TABLE book_return ADD 
    CONSTRAINT fk_member_id_book_return FOREIGN KEY (member_id) 
        REFERENCES members (member_id);

/* Assignment 3 */

/* Selecting database */
USE LIS;

/* Inserting values to the table */
INSERT INTO members VALUES ( 'M16-001', 'XYZ', 'E-87', 'Vaishali Nagar', 'F' );
INSERT INTO members VALUES ( 'M16-002', 'Adam', 'Street no. 1', 'Jodhpur', 'F' );
INSERT INTO members VALUES ( 'M16-003', 'Luke', 'Flat F-2', 'Nirman Nagar', 'M' );
INSERT INTO members VALUES ( 'M16-004', 'Ardena', 'A/12, Shastri Nagar', 'Tonk Road', 'F' );
INSERT INTO members VALUES ( 'M16-005', 'abc', 'Row House No. 3', 'Sitapura', 'M' );

INSERT INTO subjects VALUES ( 'S-001', 'Fiction' );
INSERT INTO subjects VALUES ( 'S-002', 'Action' );
INSERT INTO subjects VALUES ( 'S-003', 'Romance' );
INSERT INTO subjects VALUES ( 'S-004', 'Fantasy' );
INSERT INTO subjects VALUES ( 'S-005', 'Study' );

INSERT INTO publishers VALUES ( '1', 'TMH' );
INSERT INTO publishers VALUES ( '2', 'Oracle Publications' );
INSERT INTO publishers VALUES ( '3', 'Salesforce' );
INSERT INTO publishers VALUES ( '4', 'Pearson' );
INSERT INTO publishers VALUES ( '5', 'Genius Publications' );

INSERT INTO authors VALUES ( 'A13-001', 'R.K.Sharma' );
INSERT INTO authors VALUES ( 'A13-002', 'Bipul Jain' );
INSERT INTO authors VALUES ( 'A14-001', 'Martin Luthor' );
INSERT INTO authors VALUES ( 'A14-002', 'Adam' );
INSERT INTO authors VALUES ( 'A14-003', 'Adil Mohammad' );

INSERT INTO titles VALUES ( 90001, 'The book of Life', 'S-001', '4' );
INSERT INTO titles VALUES ( 90002, 'Make It Happen', 'S-003', '4' );
INSERT INTO titles VALUES ( 90003, 'The Case of Missing City', 'S-002', '1' );
INSERT INTO titles VALUES ( 90004, 'All About Cloud', 'S-005', '3' );

INSERT INTO books VALUES ( 30001, 90001, '2015/01/01', 230.15, 'Rented' );
INSERT INTO books VALUES ( 30002, 90002, '2015/03/22', 1230.15, 'Purchased' );
INSERT INTO books VALUES ( 30003, 90003, '2016/04/15', 49.89, 'Rented' );
INSERT INTO books VALUES ( 30004, 90004, '2016/08/01', 5001.01, 'Rented' );

INSERT INTO title_author VALUES ( 90001, 'A13-002' );
INSERT INTO title_author VALUES ( 90002, 'A13-001' );
INSERT INTO title_author VALUES ( 90003, 'A13-002' );
INSERT INTO title_author VALUES ( 90004, 'A14-003' );

INSERT INTO book_issue VALUES ( '2016/08/10', 30001, 'M16-001', '2016/08/25' );
INSERT INTO book_issue VALUES ( '2016/08/10', 30002, 'M16-003', '2016/08/25' );
INSERT INTO book_issue VALUES ( '2016/08/10', 30003, 'M16-003', '2016/08/25' );

INSERT INTO book_return VALUES ( '2016/08/20', 30003, 'M16-003', '2016/08/10' );
INSERT INTO book_return VALUES ( '2016/08/25', 30001, 'M16-001', '2016/08/10' );

/* Change values of address_line2 in members table to 'Jaipur' */
UPDATE members SET address_line2 = 'Jaipur';

/* Change values of address_line1 in members table to 'EPIP, Sitapura' */
UPDATE members SET address_line1 = 'EPIP, Sitapura' WHERE category = 'F';

/* Deleting all rows from publisher table */
ALTER TABLE titles DROP 
    FOREIGN KEY fk_publisher_id;
DELETE FROM publishers;

/* Inserting the data back to the publisher table using substitution variables */
SET @id = '1';
SET @name = 'TMH';
INSERT INTO publishers VALUES ( @id, @name );

SET @id = '2';
SET @name = 'Oracle Publications';
INSERT INTO publishers VALUES ( @id, @name );

SET @id = '3';
SET @name = 'Salesforce';
INSERT INTO publishers VALUES ( @id, @name );

SET @id = '4';
SET @name = 'pEARSON';
INSERT INTO publishers VALUES ( @id, @name );

SET @id = '5';
SET @name = 'Genius Publications';
INSERT INTO publishers VALUES ( @id, @name );

ALTER TABLE titles ADD 
    CONSTRAINT fk_publisher_id FOREIGN KEY (publisher_id) 
        REFERENCES publishers (publisher_id);

/* Deleting rows of title table with publisher id = 1 */
DELETE FROM titles WHERE publisher_id = '1';

