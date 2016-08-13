
Assignment 1:
1.select member_num,member_id from members where cateogry in(select cateogry from members where member_num='Joe Snow');
        
2.select bi.issue_dt,bi.due_dt,member_num,titles.title_nm from book_issue as bi INNER JOIN members on 
bi.member_id=members.member_id INNER JOIN books on  books.accession_no=bi.accession_no INNER JOIN titles on books.title_id=titles.title_id where not exists(select * from book_return where bi.issue_dt=book_return.issue_dt)


3.
SELECT title_nm,member_num,BI.issue_dt,BI.due_dt,t.title_nm, BR.return_dt

FROM book_issue BI
INNER JOIN members m
ON BI.member_id=m.member_id

INNER JOIN Books b
ON b.accession_no=BI.accession_no
INNER JOIN titles t
ON t.title_id= b.title_id

INNER JOIN book_return BR
ON BR.issue_dt = BI.issue_dt and BI.accession_no=BR.accession_no and BI.member_id=BR.member_id where DATEDIFF(BR.return_dt,BI.due_dt)>0;

        
4.select accession_no,title_nm from books INNER JOIN titles on books.title_id=titles.title_id where price in (select max(price) from books);

5.select accession_no,title_nm,price from books INNER JOIN titles on books.title_id=titles.title_id where price = (select max(price) from books where price <(select max(price) from books));



Assignment 2:

1.CREATE OR REPLACE VIEW  MEMBERDATA As SELECT  distinct  member_num,accession_no,due_dt,issue_dt from members INNER JOIN book_issue on  book_issue.member_id=members.member_id;



select * from MEMBERDATA;

2.CREATE VIEW member AS select member_num,member_id, CASE cateogry when 'F' THEN 'FACULTY' WHEN 'S' THEN 'STUDENT' ELSE 'OTHERS' END  from members;
 
 
 
 SELECT * from member;

3.CREATE OR REPLACE VIEW overallView
AS
SELECT subject_nm,title_nm,member_num,cateogry,BI.issue_dt, return_dt,BI.due_dt

FROM book_issue BI
INNER JOIN members m
ON BI.member_id=m.member_id

INNER JOIN Books b
ON b.accession_no=BI.accession_no
INNER JOIN titles t
ON t.title_id= b.title_id
INNER JOIN subjects s
ON s.subject_id=t.subject_id
LEFT JOIN book_return BR
ON BR.issue_dt = BI.issue_dt and BI.accession_no=BR.accession_no and BI.member_id=BR.member_id;
SELECT * from overallView;

 
