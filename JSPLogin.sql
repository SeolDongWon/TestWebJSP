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
    constraint LOGIN_PK primary key (ID)
    )';
end;
/
show error;
drop table visit;
select * from visit;
select * from login;
commit;
CREATE table VISIT (
    NO NUMBER(5,0) NOT NULL,
    WRITER VARCHAR2(20) NOT NULL,
    MEMO VARCHAR2(4000) NOT NULL,
    REGDATE VARCHAR2(20) NOT NULL,
    constraint VISIT_PK primary key (NO)
    );

alter table LOGIN add (writeCnt Number default 0 not null);
select to_char(sysdate, 'YYYY-MM-DD HH24:MI:SS') from dual;
insert into visit(no, writer, memo, regdate) values(visit_seq.nextval,'123','456',to_char(sysdate, 'YYYY-MM-DD HH24:MI:SS'));

CREATE OR REPLACE TRIGGER EMP_TRG01
AFTER INSERT
ON visit
BEGIN

END;
/
