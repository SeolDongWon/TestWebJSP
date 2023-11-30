--���̺�� ������ ����
execute pro_drop_booklibrary;
--���̺�� ������ ����
execute pro_create_JSPLogin;

--���̺�� ������ ����
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
--���̺�� ������ ����
execute pro_create_JSPLogin;
create or replace procedure pro_create_JSPLogin
    is
    begin
        --���� ���̺� ����
    
     execute immediate 'CREATE table VISIT (
    NO NUMBER(5,0) NOT NULL,
    WRITER VARCHAR2(20) NOT NULL,
    MEMO VARCHAR2(4000) NOT NULL,
    REGDATE DATE NOT NULL,
    constraint VISIT_PK primary key (NO)
    )';
    --���� ���̺� ������ ����
     execute immediate 'CREATE SEQUENCE visit_seq -- �������̸�
    START WITH 1 -- ������ 1�� ����
    INCREMENT BY 1 -- ���� ���� 1�� ����
    NOMAXVALUE -- �ִ� ���� ���Ѵ�
    NOCACHE
    NOCYCLE';
    
    --ȸ������ ���� ���̺� ����
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
