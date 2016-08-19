/* Assignment 1 */

/* Selecting the databse */
USE LIS;

/* To display all columns of member table */
SELECT member_id, member_name, address_line1, address_line2, category FROM members;

/* To display member name, member id and category of member table */
SELECT member_name, member_id, category FROM members;

/* To display member name, member id and category of member table 
 * where the category of member is Faculty i.e. F */
SELECT member_name, member_id, category FROM members WHERE category='F';

/* To display various categories of member */
SELECT DISTINCT category FROM members;

/* To display member name and category in descending order of member name */
SELECT member_name, category FROM members ORDER BY member_name DESC;

/* To display all titles, their subjects and their publishers */
SELECT t.title_name, s.subject_name, p.publisher_name FROM titles t 
    INNER JOIN subjects s ON t.subject_id = s.subject_id
    INNER JOIN publishers p ON t.publisher_id = p.publisher_id;

/* To display number of members present in each category */
SELECT category, COUNT(member_id) AS 'Number Of Members' FROM members GROUP BY category;

/* To display name of those members who belongs to the same category
 * as to which 'Keshav Sharma' belongs */
 SELECT member_name FROM members
    WHERE category=(SELECT category FROM members WHERE member_name='Keshav Sharma');


/* To display information on all the books issued. The result should have issue date, 
 * accessin number, member id, member name and return date. If book is not returned,
 * keep the return date column blank. */
SELECT bi.issue_dt , bi.accession_number, bi.member_id, IFNULL(br.return_dt,'Not Returned')
FROM book_issue bi
INNER JOIN book_return
    ON bi.issue_dt=br.issue_dt AND 
        bi.accession_number=br.accession_number AND
        bi.member_id=br.member_id;

/* Assignment 2 */

/* Selecting the database */
USE LIS;

/* To display information on all the books issued. The result should have issue date, 
 * accessin number, member id, member name and return date. If book is not returned,
 * keep the return date column blank. Sort the result in ascending order of issue date
 * and then ascending ordeer of member name*/
SELECT bi.issue_dt AS 'Issue Date', bi.accession_number AS 'Accession Number',
    bi.member_id AS 'Member ID', m.member_name AS 'Member Name', br.return_dt 
    FROM book_issue bi LEFT JOIN 
        book_return br ON bi.accession_number = br.accession_number
    INNER JOIN members m ON bi.member_id = m.member_id
    ORDER BY bi.issue_dt, m.member_name;

/* Assignment 3 */

/* Creating the database */
CREATE DATABASE eCommerce;

/* Selecting the database */
USE eCommerce;

/* Creting the category table */
CREATE TABLE Categories (
    category_id VARCHAR(30),
    category_name VARCHAR(50),
    parent_category VARCHAR(20),
    PRIMARY KEY (category_id),
    CONSTRAINT fk_parent_category FOREIGN KEY (parent_category)
        REFERENCES Categories (category_id)
);

/* Inserting the values into the table */
INSERT INTO categories VALUES ('CAT-1001', 'Mobiles & Tablets', NULL);

INSERT INTO categories VALUES ('CAT-1001-01', 'Mobiles', 'CAT-1001');
INSERT INTO categories VALUES ('CAT-1001-01-001', 'Smart Phones', 'CAT-1001-01');
INSERT INTO categories VALUES ('CAT-1001-01-002', 'Feature Phones', 'CAT-1001-01');

INSERT INTO categories VALUES ('CAT-1001-02', 'Tablets', 'CAT-1001');
INSERT INTO categories VALUES ('CAT-1001-02-001', '2G', 'CAT-1001-02');
INSERT INTO categories VALUES ('CAT-1001-02-002', '3G', 'CAT-1001-02');

INSERT INTO categories VALUES ('CAT-1001-03', 'Accessories', 'CAT-1001');
INSERT INTO categories VALUES ('CAT-1001-04', 'Cases and Covers', 'CAT-1001');


INSERT INTO categories VALUES ('CAT-1002', 'Computers', NULL);
INSERT INTO categories VALUES ('CAT-1002-01', 'Desktop', 'CAT-1002');
INSERT INTO categories VALUES ('CAT-1002-02', 'Laptop', 'CAT-1002');

INSERT INTO categories VALUES ('CAT-1002-03', 'Laptop Accessories', 'CAT-1002');
INSERT INTO categories VALUES ('CAT-1002-03-001', 'Keyboard', 'CAT-1002-03');
INSERT INTO categories VALUES ('CAT-1002-03-002', 'Mouse', 'CAT-1002-03');
INSERT INTO categories VALUES ('CAT-1002-03-003', 'Headphones', 'CAT-1002-03');

INSERT INTO categories VALUES ('CAT-1002-04', 'Printers', 'CAT-1002');
INSERT INTO categories VALUES ('CAT-1002-04-001', 'Inkjet', 'CAT-1002-04');
INSERT INTO categories VALUES ('CAT-1002-04-002', 'Laser', 'CAT-1002-04');


INSERT INTO categories VALUES ('CAT-1003', 'Home Appliances', NULL);

INSERT INTO categories VALUES ('CAT-1003-01', 'TVs', 'CAT-1003');
INSERT INTO categories VALUES ('CAT-1003-01-001', 'LED', 'CAT-1003-01');
INSERT INTO categories VALUES ('CAT-1003-01-002', 'LCD', 'CAT-1003-01');
INSERT INTO categories VALUES ('CAT-1003-01-003', 'Plasma', 'CAT-1003-01');

INSERT INTO categories VALUES ('CAT-1003-02', 'Air Conditioners', 'CAT-1003');

INSERT INTO categories VALUES ('CAT-1003-03', 'Washing Machines', 'CAT-1003');

INSERT INTO categories VALUES ('CAT-1003-03-001', 'Full Automatic', 'CAT-1003-03');
INSERT INTO categories VALUES ('CAT-1003-03-001-01', 'Top Load', 'CAT-1003-03-001');
INSERT INTO categories VALUES ('CAT-1003-03-001-02', 'Front Load', 'CAT-1003-03-001');

INSERT INTO categories VALUES ('CAT-1003-03-002', 'Semi Automatic', 'CAT-1003-03');

/* To display all the categories along with their parent category */
SELECT c.category_id AS 'ID', c.category_name AS 'Category Name',
    p.category_name AS 'Parent Category' FROM categories c 
    LEFT JOIN categories p ON c.parent_category = p.category_id;

/* To display all the categories along with their parent category,
 * sorted on the basis of parent category */
SELECT c.category_id AS 'ID', c.category_name AS 'Category Name',
    p.category_name AS 'Parent Category' FROM categories c 
    LEFT JOIN categories p ON c.parent_category = p.category_id ORDER BY p.category_name;

/* To display all the categories along with their parent category.
 * If it is top category then display  'Top Category' for parent category */
 SELECT c.category_id AS 'ID', c.category_name AS 'Category Name',
    IFNULL (p.category_name, 'Top Category') AS 'Parent Category'
    FROM categories c LEFT JOIN categories p ON c.parent_category = p.category_id;

/* To display only the top categories. */
SELECT c.category_id AS 'ID', c.category_name AS 'Category Name',
    IFNULL (p.category_name, 'Top Category') AS 'Parent Category'
    FROM categories c LEFT JOIN categories p ON c.parent_category = p.category_id
    WHERE c.parent_category IS NULL;

/* Assignment 4 */

/* Create database */
CREATE DATABASE CityDirectory;

/* Selecting Databse */
USE CityDirectory;

/* Creating Tables */
CREATE TABLE state (
    state_id VARCHAR(10),
    state_name VARCHAR(40),
    PRIMARY KEY (state_id)
);

CREATE TABLE City (
    pincode INT(6),
    city_name VARCHAR(30),
    state_id VARCHAR(10),
    PRIMARY KEY (pincode),
    CONSTRAINT fk_state_id FOREIGN KEY (state_id)
        REFERENCES State (state_id)
);

/* Inserting data into tables */
INSERT INTO state VALUES ('S-001', 'Rajasthan');
INSERT INTO state VALUES ('S-002', 'Jammu & Kashmir');
INSERT INTO state VALUES ('S-003', 'Kerala');
INSERT INTO state VALUES ('S-004', 'Maharashtra');
INSERT INTO state VALUES ('S-005', 'Uttar Pradesh');

INSERT INTO city VALUES (302019, 'Jaipur', 'S-001');
INSERT INTO city VALUES (302001, 'Alwar', 'S-001');
INSERT INTO city VALUES (302058, 'Bisalpur', 'S-001');
INSERT INTO city VALUES (408702, 'Jammu', 'S-002');
INSERT INTO city VALUES (100156, 'Ghatpur', 'S-003');
INSERT INTO city VALUES (100155, 'Trivandram', 'S-003');
INSERT INTO city VALUES (400020, 'Nagpur', 'S-004');
INSERT INTO city VALUES (400005, 'Jamnagar', 'S-004');
INSERT INTO city VALUES (301041, 'Noida', 'S-005');
INSERT INTO city VALUES (301087, 'Gurgaon', 'S-005');
INSERT INTO city VALUES (400001, 'Mumbai', 'S-004');

/* To display zipcode, city name and state name
 * ordered by state name and then by city name */
SELECT c.pincode AS 'Zip Code', c.city_name AS 'City Name', s.state_name AS 'State Name' 
    FROM city c INNER JOIN state s ON c.state_id = s.state_id ORDER BY s.state_name, c.city_name;
