--테이블과 시퀀스 삭제
execute pro_drop_booklibrary;
--테이블과 시퀀스 생성
execute pro_create_JSPLogin;

--테이블과 시퀀스 삭제
execute pro_drop_booklibrary;
create or replace procedure pro_drop_booklibrary
is
begin
    execute immediate 'drop table visit';
    execute immediate 'drop table login';
    execute immediate 'drop sequence visit_seq';
end;
/
show error;
--테이블과 시퀀스 생성
execute pro_create_JSPLogin;
create or replace procedure pro_create_JSPLogin
    is
    begin
        --방명록 테이블 생성
    
     execute immediate 'CREATE table VISIT (
    NO NUMBER(5,0) NOT NULL,
    WRITER VARCHAR2(20) NOT NULL,
    MEMO VARCHAR2(4000) NOT NULL,
    REGDATE DATE NOT NULL,
    constraint VISIT_PK primary key (NO)
    )';
    --방명록 테이블 시퀀스 생성
     execute immediate 'CREATE SEQUENCE visit_seq -- 시퀀스이름
    START WITH 1 -- 시작을 1로 설정
    INCREMENT BY 1 -- 증가 값을 1씩 증가
    NOMAXVALUE -- 최대 값이 무한대
    NOCACHE
    NOCYCLE';
    
    --회원가입 저장 테이블 생성
     execute immediate 'CREATE table LOGIN (
    ID VARCHAR2(12) NOT NULL,
    PASS VARCHAR2(12) NOT NULL,
    name varchar2(12) not null,
    birth varchar2(8) not null,
    writeCnt Number default 0 not null,
    constraint LOGIN_PK primary key (ID)
    )';
end;
/
show error;

CREATE table LOGIN (
    id VARCHAR2(12) NOT NULL,
    pass VARCHAR2(12) NOT NULL,
    name varchar2(12) not null,
    birth varchar2(8) not null,
    writeCnt Number default 0,
    constraint LOGIN_PK primary key (ID)
    );
    
CREATE table VISIT (
    NO NUMBER(5,0) NOT NULL,
    WRITER VARCHAR2(20) NOT NULL,
    MEMO VARCHAR2(4000) NOT NULL,
    REGDATE VARCHAR2(20) NOT NULL,
    constraint VISIT_PK primary key (NO)
    );

alter table LOGIN add (writeCnt Number default 0 not null);
alter table LOGIN modify (writeCnt Number default 0  not null);
select to_char(sysdate, 'YYYY-MM-DD HH24:MI:SS') from dual;
insert into visit(no, writer, memo, regdate) values(visit_seq.nextval,'123','456',to_char(sysdate, 'YYYY-MM-DD HH24:MI:SS'));
select (select writecnt from login where id='seol1')+1 from dual;

update login set writecnt = (select writecnt from login where id='seol1')+1 where id='seol1';
select writer from visit where no=:new.no;

-- 글을 추가하면 login테이블에서 해당 id의 writecnt를 +1 해주는 트리거
CREATE OR REPLACE TRIGGER login_writecnt_plus
AFTER INSERT ON visit
for each row
DECLARE
    v_id varchar2(12);
    v_writeCnt number;
BEGIN
    v_id := :new.WRITER;
    dbms_output.put_line(v_id);
    select writeCnt into v_writeCnt  from login where id = v_id;
    dbms_output.put_line(v_writeCnt);
    update login set writeCnt=v_writeCnt+1 where id = v_id;
END;
/
show error;
-- 글을 삭제하면 login테이블에서 해당 id의 writecnt를 -1 해주는 트리거
CREATE OR REPLACE TRIGGER login_writecnt_minus
before delete ON visit
for each row
DECLARE
    v_id varchar2(12);
    v_writeCnt number;
BEGIN
    v_id := :old.WRITER;
    dbms_output.put_line(v_id);
    select writeCnt into v_writeCnt  from login where id = v_id;
    dbms_output.put_line(v_writeCnt);
    update login set writeCnt=v_writeCnt-1 where id = v_id;
END;
/
show error;

drop trigger emp_trg01;
drop trigger emp_trg02;

rollback;
select * from visit order by no desc;
select * from login;
describe login;
commit;

delete from visit where writer = 'seol2' and no = 17;

insert into visit(no, writer, memo, regdate) values(visit_seq.nextval,'seol2','456',to_char(sysdate, 'YYYY-MM-DD HH24:MI:SS'));
insert into login(id, pass, name, birth) values('seol2','22222222','설동투','19900202');

CREATE TABLE TEMPMEMBER (
ID VARCHAR2(20) NOT NULL, 
PASSWD VARCHAR2(20), 
NAME VARCHAR2(20), 
MEM_NUM1 VARCHAR2(6), 
MEM_NUM2 VARCHAR2(7), 
E_MAIL VARCHAR2(30), 
PHONE VARCHAR2(30), 
ZIPCODE VARCHAR2(7), 
ADDRESS VARCHAR2(60), 
JOB VARCHAR2(30), 
PRIMARY KEY (ID) ENABLE
 );
-- 주의: NOT NULL ENABLE : NULL 값 입력 불가
-- 주의: NOT NULL DISABLE : NULL 값 입력 가능
insert into tempMember values('aaaaa', '1111', '홍길동', '123456', '7654321', 
'hong@hanmail.net', '02-1234', '100-100', '서울', '프로그래머');
insert into tempMember values('bbbbb', '1111', '홍길동', '123456', '7654321', 
'hong@hanmail.net', '02-1234', '100-100', '서울', '프로그래머');
insert into tempMember values('ccccc', '1111', '홍길동', '123456', '7654321', 
'hong@hanmail.net', '02-1234', '100-100', '서울', '프로그래머');
insert into tempMember values('ddddd', '1111', '홍길동', '123456', '7654321', 
'hong@hanmail.net', '02-1234', '100-100', '서울', '프로그래머');
commit;


CREATE TABLE  person (
    ID VARCHAR2(20) NOT NULL ENABLE, 
    NAME VARCHAR2(20), 
    EMAIL VARCHAR2(30), 
    PRIMARY KEY (ID) ENABLE
);
drop table person;
desc person;
desc person;

drop table projects1member;

create table projects1member(
id varchar2(30) not null,
password varchar2(30) not null,
name varchar2(30) not null,
birthday varchar2(30) not null,
tel varchar2(30) not null,
postcode varchar2(30) not null,
mainaddress varchar2(100) not null,
detailaddress varchar2(100) not null,
constraint projectseolmember_pk PRIMARY KEY (id)
);

select * from projects1member;
select * from projects1member order by rownum;


eolmember;
insert into projectseolmember(id, password, name, birthday, tel, postcode, address) 
values('seol1','11111111','설동원','1990-02-01','1011111111','12915','왕십리 한동타워');
commit;

create table zipcode  (
   seq                  NUMBER(10)  not null,
   zipcode              VARCHAR2(50),
   sido                 VARCHAR2(50),
   gugun                VARCHAR2(50),
   dong                 VARCHAR2(50),
   ri                   VARCHAR2(80),
   bunji                VARCHAR2(50),
   constraint PK_ZIPCODE primary key (seq)
);
commit;

drop table zipcode;
describe zipcode;
select seq, zipcode, sido, gugun, dong, ri, bunji from zipcode order by seq;
select * from zipcode;

drop table trainee;
drop table student;
CREATE table STUDENT (
 ID VARCHAR2(12) NOT NULL,
 PASS VARCHAR2(12) NOT NULL,
 NAME VARCHAR2(10) NOT NULL,
 PHONE1 VARCHAR2(3) NOT NULL,
 PHONE2 VARCHAR2(4) NOT NULL,
 PHONE3 VARCHAR2(4) NOT NULL,
 EMAIL VARCHAR2(30) NOT NULL,
 ZIPCODE VARCHAR2(7) NOT NULL,
 ADDRESS1 VARCHAR2(120) NOT NULL,
 ADDRESS2 VARCHAR2(50) NOT NULL,
 constraint STUDENT_PK primary key (ID)
);
delete from student where id = 'seol2';
select * from student;
desc student;
commit;

drop table board;
drop SEQUENCE board_seq;

CREATE TABLE board (
NUM NUMBER(7,0) NOT NULL ENABLE, 
WRITER VARCHAR2(12) NOT NULL ENABLE, 
EMAIL VARCHAR2(30) NOT NULL ENABLE, 
SUBJECT VARCHAR2(50) NOT NULL ENABLE, 
PASS VARCHAR2(10) NOT NULL ENABLE, 
READCOUNT NUMBER(5,0) DEFAULT 0 NOT NULL ENABLE, 
REF NUMBER(5,0) DEFAULT 0 NOT NULL ENABLE, 
STEP NUMBER(3,0) DEFAULT 0 NOT NULL ENABLE, 
DEPTH NUMBER(3,0) DEFAULT 0 NOT NULL ENABLE, 
REGDATE TIMESTAMP (6) DEFAULT SYSDATE NOT NULL ENABLE, 
CONTENT VARCHAR2(4000) NOT NULL ENABLE, 
IP VARCHAR2(20) NOT NULL ENABLE, 
filename VARCHAR2(20),
origfilename VARCHAR2(20),
CONSTRAINT BOARD_PK PRIMARY KEY (NUM) ENABLE
 );
 describe board;
 
 CREATE SEQUENCE board_seq -- 시퀀스이름
 START WITH 1 -- 시작을 1로 설정
 INCREMENT BY 1 -- 증가값을 1씩 증가
 NOMAXVALUE -- 최대값이 무한대..
 NOCACHE
 NOCYCLE;
 
 select * from board;
 select * from board order by num desc;
 
 --자동 글쓰기
declare
v_num number :=0;
v_WRITER VARCHAR2(12):='autoWriter';
v_EMAIL VARCHAR2(30):='autoEmail';
v_SUBJECT VARCHAR2(50):='autoSubject';
v_CONTENT VARCHAR2(4000):='autoContent<br>password:1111<br>num : ';
v_IP VARCHAR2(20):='100.0';
begin
 for i in 0..30
    loop
    v_num:=board_seq.nextval;
    insert into board(num,writer,email,subject,pass,ref,content,ip) 
    values(v_num,concat(v_WRITER,v_num),concat(v_EMAIL,v_num),concat(v_SUBJECT,v_num),'1111',v_num,concat(v_CONTENT,v_num),v_IP);
    END loop;
 end;
 /
 show error;
 commit;
 
select * from board; 
update board set ref=5 where num=6;
update board set step=step+1, depth=depth+1 where num=7;
 select * from board order by regdate desc, ref desc, step asc;
 select * from board order by ref desc, step asc;
 select * from (select rownum rnum, num, writer, email, subject, pass, regdate, readcount, ref, step, depth, content, ip from (select * from board order by ref desc, step asc)) where rnum>=1 and rnum<=10;
 select * from (select rownum rnum, num, writer, email, subject, pass, regdate, readcount, ref, step, depth, content, ip from (select * from board order by ref desc, step asc)) where rnum>=10 and rnum<=21;
 
 