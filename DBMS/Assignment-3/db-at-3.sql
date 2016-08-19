/* Assignment 1 */

/* Selecting the databse */
USE LIS;

/* To display information on books issued for more than 2 months.
 * It should include member name, member id, title name, accession number
 * issue date, due date and issued for how many months and be sorted on 
 * member name and then on title name. */
SELECT m.member_name AS 'Member Name', bi.member_id AS 'Member ID',
    t.title_name AS 'Title', bi.accession_number AS 'Accession Number',
    bi.issue_dt AS 'Issue Date', bi.due_dt AS 'Due Date', br.return_dt AS 'Return Date',
    TIMESTAMPDIFF(MONTH, bi.issue_dt, IFNULL(br.return_dt, CURRENT_TIMESTAMP)) AS 'Number of Months' 
    FROM book_issue bi
    INNER JOIN members m ON bi.member_id = m.member_id
    INNER JOIN books b ON bi.accession_number = b.accession_number
    INNER JOIN titles t ON b.title_id = t.title_id
    LEFT JOIN book_return br ON br.accession_number = bi.accession_number 
        AND br.member_id = bi.member_id AND br.issue_dt = bi.issue_dt
    WHERE TIMESTAMPDIFF(MONTH, bi.issue_dt, IFNULL(br.return_dt, CURRENT_TIMESTAMP)) > 2 
    ORDER BY m.member_name, t.title_name;
    
/* To display those rows from members table having maximum length for member name */
SELECT member_name, LENGTH(member_name) AS 'Length' FROM members 
    WHERE LENGTH(member_name) = (SELECT MAX(LENGTH(member_name)) FROM members);
    
/* To display count of number of books issued so far */
SELECT COUNT(accession_number) FROM book_issue;


/* Assignment 2 */

/* Selecting the database */
USE LIS;

/* To display subjectwise information on number of books purchased.
 * It should include subject name, subject id and number of books purchased */
SELECT s.subject_id AS 'Subject ID', s.subject_name AS 'Subject Name',
    COUNT(b.accession_number) AS 'Number of books' FROM subjects s
    INNER JOIN titles t ON s.subject_id = t.subject_id
    INNER JOIN books b ON t.title_id = b.title_id
    GROUP BY s.subject_id;
    
/* To display those rows from book_issue table where a book can be returned 
 * after 2 months i.e. difference between issue and due date is greater than 2 months*/
SELECT issue_dt AS 'Issue Date', due_dt AS 'Due Date',
    accession_number AS 'Book ID', member_id AS 'Member ID'
    FROM book_issue WHERE TIMESTAMPDIFF(MONTH, issue_dt, due_dt) > 2;

/* To display the list of books having price greater than the 
 * minimum price of books purchased so far */
SELECT accession_number AS 'Book Id', title_id AS 'Title Id',
    purchase_dt AS 'Purchase Date', price AS 'Price',
    status AS 'Status' FROM books WHERE price > 
    (SELECT MIN(price) FROM books);

/* Assignment 3 */

/* Selecting the database */
USE LIS;

/* To display total number of students, total number of faculty and total number of others
 * in library information system in a single row */
SELECT GROUP_CONCAT(m.category) AS 'Category', GROUP_CONCAT(m.count_value) AS 'Count'
    FROM (SELECT category, COUNT(member_id) AS count_value FROM members GROUP BY category) AS m;

/* To display the information of those titles that have been issued more than 2 times */
SELECT t.title_id AS 'Title Id', t.title_name AS 'Title Name',
    t.subject_id AS 'Subject Id', t.publisher_id AS 'Publisher Id',
    b.accession_number AS 'Book Id' FROM titles t 
    INNER JOIN books b ON t.title_id = b.title_id
    INNER JOIN book_issue bi ON b.accession_number = bi.accession_number
    GROUP BY bi.accession_number HAVING COUNT(bi.accession_number) > 2;

/* To display information on books  issued to members of category other than 'F' */
SELECT b.accession_number AS 'Book Id', b.title_id AS 'Title Id',
    t.title_name AS 'Title Name', m.member_name AS 'Member Name',
    m.category AS 'Category' FROM books b
    INNER JOIN titles t ON b.title_id = t.title_id
    INNER JOIN book_issue bi ON b.accession_number = bi.accession_number
    INNER JOIN members m ON bi.member_id = m.member_id
    WHERE m.category != 'F';

/* To display information on those authors for which atleast one book has been purchased*/
SELECT a.author_id AS 'Author Id', a.author_name AS 'Author Name'
    FROM authors a
    INNER JOIN title_author ta ON a.author_id = ta.author_id
    INNER JOIN books b ON ta.title_id = b.title_id
    WHERE b.status LIKE 'p%'
    GROUP BY a.author_id HAVING COUNT(b.accession_number) > 0;
