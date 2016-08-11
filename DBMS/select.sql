use lis;
select * from members;

-- Display member-nm and m-id and category
-- ----------------------------------------
select member_nm , member_id , category from members;

-- Display member-nm , member-id , category where category = F
-- ------------------------------------------------------------
select member_nm , member_id , category from members where category = 'F';

-- Display various category
-- ------------------------------
select DISTINCT category from members; 

-- Display member-nm and their category  in decending order of member-nm
-- ---------------------------------------------------------------------
select member_nm , category from members;
select member_nm , category from members order by member_nm;

-- Display titles , their subject and publisher;
-- --------------------------------------------------
select * from title;
select * from subjects;
select * from publishers;
select title.title_nm , subjects.subject_nm , publishers.publisher_nm from title , subjects , publishers where title.subject_id = subjects.subject_id and title.publisher_id = publishers.publisher_id;


-- Display Number of cadidate belongs to each category
-- --------------------------------------------------------
select count(member_id) , category from members group by category;

-- Display members who belong to same category as keshav sharma's category
-- ------------------------------------------------------------------------
select m1.member_nm from members m1 inner join members m2 ON m2.member_nm = 'Keshav Sharma' and m2.category = m1.category and m2.member_nm <> m1.member_nm;


-- Display all issued book
-- -------------------------------
select * from book_issue;
select * from book_return;
select I.accession_no as 'Accession Number' , I.member_id as 'Member ID', I.issue_dt as 'Issue Date' ,
IFNULL(R.return_date,'Not Returned') as 'Return Date'
from book_issue I left join book_return R on 
I.accession_no = R.accession_no and I.member_id = R.member_id and I.issue_dt = R.issue_dt ;