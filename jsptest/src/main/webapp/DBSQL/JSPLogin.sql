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

CREATE TABLE "TEMPMEMBER" (
"ID" VARCHAR2(20) NOT NULL, 
"PASSWD" VARCHAR2(20), 
"NAME" VARCHAR2(20), 
"MEM_NUM1" VARCHAR2(6), 
"MEM_NUM2" VARCHAR2(7), 
"E_MAIL" VARCHAR2(30), 
"PHONE" VARCHAR2(30), 
"ZIPCODE" VARCHAR2(7), 
"ADDRESS" VARCHAR2(60), 
"JOB" VARCHAR2(30), 
PRIMARY KEY ("ID") ENABLE
 );
-- 주의: NOT NULL ENABLE : NULL 값 입력 불가
-- 주의: NOT NULL DISABLE : NULL 값 입력 가능
insert into tempMember values('fffff', '1111', '홍길동', '123456', '7654321', 
'hong@hanmail.net', '02-1234', '100-100', '서울', '프로그래머');
commit;


CREATE TABLE  person (
    ID VARCHAR2(20) NOT NULL ENABLE, 
    NAME VARCHAR2(20), 
    EMAIL VARCHAR2(30), 
    PRIMARY KEY (ID) ENABLE
);
drop table "person";
desc "person";
desc person;

drop table projects1member;

create table projects1member(
id varchar2(30) not null,
password varchar2(30) not null,
name varchar2(30) not null,
birthday varchar2(30) not null,
tel varchar2(30) not null,
postcode varchar2(30) not null,
address varchar2(100) not null,
constraint projectseolmember_pk PRIMARY KEY (id)
);

select * from projects1member;



eolmember;
insert into projectseolmember(id, password, name, birthday, tel, postcode, address) 
values('seol1','11111111','설동원','1990-02-01','1011111111','12915','왕십리 한동타워');
commit;