CREATE DATABASE IF NOT EXISTS LIBRARY_MANAGE;
use LIBRARY_MANAGE;
CREATE TABLE IF NOT EXISTS Publisher(
  publishid VARCHAR(10) PRIMARY KEY,
  publishname VARCHAR(100)
);


CREATE TABLE IF NOT EXISTS Book(
  bookid VARCHAR(10)  PRIMARY KEY,
  title VARCHAR(50),
  author VARCHAR(100),
  pubid  VARCHAR (10),
  availability ENUM ('Available','Borrowed'),
  CONSTRAINT fk_publisher FOREIGN KEY (pubid) REFERENCES Publisher(publishid)



);

CREATE TABLE IF NOT EXISTS Member (
  memberid varchar(10) PRIMARY KEY,
  member_name  VARCHAR(50),
  membertype VARCHAR(100),
   memberdate VARCHAR(10)
);
CREATE TABLE IF NOT EXISTS Borrow(
  book_id VARCHAR(12),
  mem_id VARCHAR(15),
  issuedate VARCHAR(10),
 expidate VARCHAR(10),
  CONSTRAINT pk_borrow PRIMARY KEY (book_id,mem_id),
  CONSTRAINT fk_book FOREIGN KEY (book_id) REFERENCES Book(bookid ),
  CONSTRAINT fk_mem FOREIGN KEY (mem_id) REFERENCES Member(memberid)


);
CREATE TABLE IF NOT EXISTS Returnbook (
  returnid    VARCHAR(10) PRIMARY KEY,
  returndate      DATE,
  books_id    VARCHAR(10),
  memb_id     VARCHAR(10),

  CONSTRAINT fk_book1 FOREIGN KEY (books_id) REFERENCES Book (bookid),
  CONSTRAINT fk_member FOREIGN KEY (memb_id) REFERENCES Member (memberid)
);



