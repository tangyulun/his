select * from FUNCTION_TYPE;
select * from OUTPAITENT_REGIST;
select * from DEPT;
delete from dept;
insert into emp(EMP_ID, EMP_LOGIN_NAME) values(10001 , 'admin');
select * from dept where dept_name like '%行政%';
select * from DCLASS;
delete from DCLASS;
select * from emp;
delete from emp;
select * from EMP_MESSAGE;
insert into Emp(EMP_ID,EMP_LOGIN_NAME,EMP_PWD) values(1001,'admin','admin');


select * from DRUG_ACCEPTANCE;
select * from DRUG_ACCEPTANCE_XQ;
select * from HOSPITAL_REGISTRATION;

select * from INSTRUMENT_YS;
select * from INSTRUMENT_YANSHOU_XQ;
select * from INSTRUMENT_RK_XQ;
select * from INSTRUMENT_RK;

select * from DRUG_WAREHOUSE;
select * from DRUG_WAREHOUSE_XQ;
select * from Drug;
select * from YAOKU_KUCUN;
select * from INSTRUMENT;
select * from HOSPITAL_REGISTRATION;
update YAOKU_KUCUN set yaoku_kucun_num = 100;

select to_char(login_date , 'dd') , count(*) from login_logger  where  
to_char(login_date , 'yyyy') = '2018'  and to_char(login_date , 'mm') = '04' group by  to_char(login_date , 'dd')