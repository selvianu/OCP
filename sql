create table bookDetails(booksId VARCHAR2(7) not null PRIMARY KEY, booksName VARCHAR2(100) not null, authors VARCHAR2(50) not null, 
publishers VARCHAR2(50) not null, edition NUMBER(4) not null, category VARCHAR2(30)not null, price NUMBER(10) not null, 
mrp_rate NUMBER(10) not null, act_rate NUMBER(10)not null, avl_quantity NUMBER(10) not null);

alter table bookDetails add language VARCHAR2(20);

alter table bookDetails add book_image BLOB;

alter table bookDetails add rating NUMBER(10);

ALTER TABLE bookDetails MODIFY authors VARCHAR2(300);

create table userDetails(userName VARCHAR2(30) not null PRIMARY KEY, password VARCHAR2(30) not null, emailId VARCHAR2(30) not null,
name VARCHAR2(50), phoneno VARCHAR2(10), address VARCHAR2(100), district VARCHAR2(30), state VARCHAR2(30), pincode varchar(30));

create table orderHistory(orderId NUMBER(10) not null PRIMARY KEY, booksId VARCHAR2(7) not null, userName VARCHAR2(30) not null, 
orderDate DATE not null, quantity NUMBER(10) not null, totalPrice NUMBER(10) not null, advanceAmt NUMBER(10), status VARCHAR2(20) not null,
FOREIGN key (booksId) references bookDetails(booksId), FOREIGN key (userName) references userDetails(userName));

select * from bookDetails;

select * from userDetails;

create sequence orderId increment by 1 start with 2743 minvalue 2743 maxvalue 100000;

create table cartDetails(cart_id NUMBER NOT NULL PRIMARY KEY, userName VARCHAR2(30) not null, booksId varchar2(7) not null, 
quantity NUMBER(10) not null, price NUMBER(10) not NULL, total_price NUMBER(10) not null, FOREIGN KEY (userName) REFERENCES userDetails(userName), 
FOREIGN KEY (booksId) REFERENCES bookDetails(booksId));

create sequence cardId increment by 1 start with 1 minvalue 1 maxvalue 10000; 

select * from cartDetails;

create table admin(user_name VARCHAR2(30) not null UNIQUE, password VARCHAR2(30) not null);

select * from admin;

select * from orderhistory;

select * from orderhistory inner join userdetails on orderhistory.username = userdetails.username;
    
select booksid from (SELECT booksid, COUNT(*) 
FROM orderhistory GROUP BY booksid ORDER BY booksid) WHERE ROWNUM <= 3;

INSERT INTO cartdetails(cart_id, username, booksid)values(cardId.nextval, 'Rose2000', 'WF123');

select ct.cart_id, bk.booksid, bk.booksname, bk.authors, bk.publishers, bk.edition, bk.category, bk.act_rate, bk.book_image from cartdetails ct
inner join bookdetails bk on ct.booksid = bk.booksid WHERE ct.username = 'Rose2000';

update userdetails set password = '2000@roseliani' WHERE username = 'Roselie@2000';

SELECT * FROM bookdetails WHERE booksname LIKE '%World University%' OR authors LIKE '%World University%' OR publishers LIKE '%World University%';

create table bookReviews(bookId VARCHAR2(7) not null, userName VARCHAR2(30) not null, review VARCHAR2(300), rating NUMBER(10), 
FOREIGN KEY (bookId) REFERENCES bookDetails(booksId));

select * from bookreviews;

Select count(username)From bookreviews Where bookid = 'WF123' Group by bookid;

select sum(rating) from bookreviews where bookid = 'WF123';

update bookdetails SET rating = 5 where booksid = 'WF123';

select * from bookdetails where act_rate BETWEEN 200 and 500;

select * from bookdetails where avl_quantity < 15;

select username from(select username, sum(quantity) from orderhistory GROUP BY username ORDER by username desc)where ROWNUM <= 5;

select od.orderid, od.booksid, od.username, od.orderdate, od.quantity, od.totalprice, od.advanceamt, od.status, bk.booksname, bk.act_rate,
bk.book_image from orderhistory od inner join bookdetails bk on od.booksid = bk.booksid WHERE od.username = 'Rose2000';