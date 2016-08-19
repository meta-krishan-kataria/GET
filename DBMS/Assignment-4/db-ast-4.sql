/* Assignment 1 */

/* Selecting the database */
USE LIS;

/* To display name of those members who belong to the category as to 
 * which member 'Jon Snow' belongs. Use subquery */
 SELECT m.member_name AS 'Member Name' FROM members m WHERE m.category = 
    (SELECT category FROM members c WHERE c.member_name = 'Jon Snow');

/* To display information on the books that have not been returned till date. 
 * The information should include issue date, title name, member name 
 * and due date. Use Corelated query */
 SELECT bi.issue_dt AS 'Issue Date', t.title_name AS 'Title name',
    m.member_name AS 'Member Name', bi.due_dt AS 'Due Date' FROM book_issue bi
    INNER JOIN members m ON bi.member_id = m.member_id
    INNER JOIN books b ON bi.accession_number = b.accession_number
    INNER JOIN titles t ON b.title_id = t.title_id
    WHERE (bi.issue_dt, bi.accession_number, bi.member_id) NOT IN
    (SELECT br.issue_dt, br.accession_number, br.member_id FROM book_return br);

/* To display information on the books that have been returned after 
 * their due dates. The information should include issue date, title name,
 * member name and due date. Use Corelated query */
 SELECT bi.issue_dt AS 'Issue Date', t.title_name AS 'Title name',
    m.member_name AS 'Member Name', bi.due_dt AS 'Due Date' FROM book_issue bi
    INNER JOIN members m ON bi.member_id = m.member_id
    INNER JOIN books b ON bi.accession_number = b.accession_number
    INNER JOIN titles t ON b.title_id = t.title_id
    WHERE (bi.issue_dt, bi.accession_number, bi.member_id) IN
    (SELECT br.issue_dt, br.accession_number, br.member_id FROM book_return br
        WHERE TIMESTAMPDIFF(DAY, bi.due_dt, br.return_dt) > 0);

/* To display information of those books whose price is equal to the 
 * booksmost expensive book purchase so far */
 SELECT b.accession_number AS 'Book Id', t.title_name AS 'Title Name'
    FROM books b
    INNER JOIN titles t ON b.title_id = t.title_id
    WHERE b.price = (SELECT MAX(price) FROM books);
    
/* To display the second maximum price of a book */
SELECT MAX(price) AS 'Second Max Price' FROM books
    WHERE price != (SELECT MAX(price) FROM books);


/* Assignment 2 */

/* Selecting the database */
USE LIS;

/* Create a View which can be used to display member name and
 * all issue details of the member using a simple SELECT command */
 CREATE VIEW member_issue_details AS
    SELECT m.member_name, bi.issue_dt, bi.accession_number,
        bi.member_id, bi.due_dt FROM book_issue bi
        INNER JOIN members m ON bi.member_id = m.member_id;
        
/* Using the above view to display issue details of a member */
SELECT member_name, issue_dt, due_dt, accession_number
    FROM member_issue_details WHERE member_id = 'M16-004';
    
/* Create a View which contains three columns, member name, member id 
 * and full description of category, i.e., Faculty, Students 
 * and Others instead of F,S and O */
 CREATE VIEW member_category_description AS
    SELECT member_name, member_id, 
        CASE category
            WHEN 'F' THEN 'Faculty'
            WHEN 'S' THEN 'Student'
            ELSE 'Others'
        END as category FROM members;
    
/* Using the above view to display member category */
SELECT member_id, member_name, category FROM member_category_description;

/* Create a View which contains the information – subject name, title name, 
 * member name, category, issue date, due date and return date. If the 
 * books have not been returned, NULL should be displayed instead of return date */
 CREATE VIEW information_view AS
    SELECT s.subject_name, t.title_name, m.member_name, m.category,
        bi.issue_dt, bi.due_dt, br.return_dt FROM book_issue bi
        INNER JOIN members m ON bi.member_id = m.member_id
        INNER JOIN books b ON bi.accession_number = b.accession_number
        INNER JOIN titles t ON b.title_id = t.title_id
        INNER JOIN subjects s ON t.subject_id = s.subject_id
        LEFT JOIN book_return br ON br.accession_number = bi.accession_number 
            AND br.member_id = bi.member_id AND br.issue_dt = bi.issue_dt;
 
 /* Using the above view to display the information */
SELECT subject_name, title_name, member_name, category, issue_dt,
    due_dt, return_dt FROM information_view;