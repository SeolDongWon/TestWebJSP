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
    writeCnt Number default 0 not null,
    constraint LOGIN_PK primary key (ID)
    )';
end;
/
show error;

CREATE table LOGIN (
    ID VARCHAR2(12) NOT NULL,
    PASS VARCHAR2(12) NOT NULL,
    name varchar2(12) not null,
    birth varchar2(8) not null,
    writeCnt Number default 0 not null,
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
select to_char(sysdate, 'YYYY-MM-DD HH24:MI:SS') from dual;
insert into visit(no, writer, memo, regdate) values(visit_seq.nextval,'123','456',to_char(sysdate, 'YYYY-MM-DD HH24:MI:SS'));
select (select writecnt from login where id='seol1')+1 from dual;

update login set writecnt = (select writecnt from login where id='seol1')+1 where id='seol1';
select writer from visit where no=:new.no;

-- ���� �߰��ϸ� login���̺��� �ش� id�� writecnt�� +1 ���ִ� Ʈ����
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
-- ���� �����ϸ� login���̺��� �ش� id�� writecnt�� -1 ���ִ� Ʈ����
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
select * from visit;
select * from login;
commit;

delete from visit where writer = 'seol2' and no = 17;

insert into visit(no, writer, memo, regdate) values(visit_seq.nextval,'seol2','456',to_char(sysdate, 'YYYY-MM-DD HH24:MI:SS'));
