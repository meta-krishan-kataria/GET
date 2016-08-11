
/* Creating library database*/
CREATE Database IF NOT EXISTS lis;

USE Library;

/* Creating tables for library database*/
CREATE  TABLE IF NOT EXISTS Members(  
`member_id` VARCHAR(20) NOT NULL ,  
`member_name` VARCHAR(100) NOT NULL ,  
`addressline1` VARCHAR(100)  ,  
`addressline2` VARCHAR(100)  ,
`category` VARCHAR  ,
PRIMARY KEY (`member_id`) );

CREATE TABLE IF NOT EXISTS subjects(
`subject_id` varchar(10) PRIMARY KEY,
`subject_nm` varchar(50));

CREATE TABLE IF NOT EXISTS publishers(
`publisher_id` varchar(10) PRIMARY KEY,
`publisher_nm` varchar(50));

CREATE TABLE IF NOT EXISTS authors(
`author_id` varchar(10),
`author_nm` varchar(50));

CREATE TABLE IF NOT EXISTS title(
`title_id` varchar(20) PRIMARY KEY,
`title_nm` varchar(50),
`subject_id` varchar(10),
`publisher_id` varchar(10),
FOREIGN KEY (`subject_id`) REFERENCES subjects(`subject_id`),
FOREIGN KEY (`publisher_id`) REFERENCES publishers(`publisher_id`));

CREATE TABLE IF NOT EXISTS title_author(
`title_id` varchar(20),
`author_id` varchar(10));

CREATE TABLE IF NOT EXISTS Book(  
`accession_no` VARCHAR(20) NOT NULL ,  
`title_id` VARCHAR(20),  
`price` INT,  
`status` INT(1),  
PRIMARY KEY (`accession_no`) ,
FOREIGN KEY (`title_id`) REFERENCES title(`title_id`));

CREATE TABLE IF NOT EXISTS book_issue (  
`issue_dt` DATE NOT NULL ,  
`accession_no` VARCHAR(20) NOT NULL ,
`member_id` VARCHAR(20) NOT NULL ,  
`due_dt` DATE,
PRIMARY KEY (`issue_dt`, `accession_no`, `member_id`) , 
FOREIGN KEY(`accession_no`) REFERENCES book(`accession_no`), 
FOREIGN KEY(`member_id`) REFERENCES members(`member_id`));

CREATE TABLE IF NOT EXISTS book_return (  
`return_dt` DATE NOT NULL ,  
`accession_no` VARCHAR(20) NOT NULL ,
`member_id` VARCHAR(20) NOT NULL ,  
`issue_dt` DATE,
PRIMARY KEY (`return_dt`, `accession_no`, `member_id`) , 
FOREIGN KEY(`accession_no`) REFERENCES book(`accession_no`), 
FOREIGN KEY(`member_id`) REFERENCES members(`member_id`),
FOREIGN KEY(`issue_dt`) REFERENCES book_issue(`issue_dt`));

/* show all tables contain in the database library*/
show tables;

ALTER TABLE book_issue MODIFY COLUMN 
issue_dt DATE DEFAULT CURDATE();

ALTER TABLE book_issue MODIFY COLUMN 
due_dt DATE DEFAULT DATE_ADD(issue_dt, INTERVAL 15 DAY);


/* Setting foreign key constraint off for deleting the member table*/

set FOREIGN_KEY_CHECKS=0;

DROP TABLE members;

/* Creating the new member table */
CREATE  TABLE IF NOT EXISTS Members(  
`member_id` VARCHAR(20) NOT NULL ,  
`member_name` VARCHAR(45) NOT NULL ,  
`addressline1` VARCHAR(45) NULL ,  
`addressline2` VARCHAR(45) NULL ,  
PRIMARY KEY (`member_id`) );

/* Creating references again for new member table*/
ALTER TABLE book_issue ADD 
CONSTRAINT fk_member_id_book_issue FOREIGN KEY (member_id) REFERENCES members (member_id);

ALTER TABLE book_return ADD 
CONSTRAINT fk_member_id_book_return FOREIGN KEY (member_id) REFERENCES members (member_id);

/* Setting foreign key contraint on */
set FOREIGN_KEY_CHECKS=1; 

