-- Q-1
select * from members;
select  (select count(*) from members where category='F') as Faculty, (select count(*) from members where category='S') as Student,(select count(*) from members where category='M') as others;

-- Q-2
select * from book_issue;
select * from books;

select  t.title_id ,count(t.title_id) from book_issue  b
left join books t 
on b.accession_no = t.accession_no
group by t.title_id having count(t.title_id) > 2;

-- Q-3
select * from book_issue where member_id NOT IN (select member_id from members where category <> 'F');

-- Q-4
select * from authors;
select * from books;
select * from title_authors;

select distinct t.authors_id , n.authors_nm 
from  title_authors t
 left join books b
on b.title_id = t.title_id
left join authors n
on n.authors_id = t.authors_id;

