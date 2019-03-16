select * from OUTPAITENT_REGIST;
select * from "我的";
insert into OUTPAITENT_REGIST(OUTPAITENT_REGIST_id) values('MG-2018022500001');
delete from OUTPAITENT_REGIST;
select * from MEDICAL_CARD;
insert into MEDICAL_CARD(MEDICAL_CARD_CARD_ID) values('NO:000002');
select * from MEDICAL_CARD;
delete from MEDICAL_CARD
delete from emp;
select * from MEDICAL_CARD where MEDICAL_CARD_CARD_ID between '1'and '2';
select * from FINANCIAL;
delete from FINANCIAL;
delete from FINANCIAL_HISTORY;
select * from FINANCIAL_TYPE;
select * from FINANCIAL_TYPE;
insert into Financial( FINANCIAL_ID,FINANCIAL_MONEY) values('100001','500.0');
insert into FINANCIAL_TYPE( FINANCIAL_TYPE_ID,FINANCIAL_TYPE_NAME) values('1','手术');
insert into FINANCIAL_TYPE( FINANCIAL_TYPE_ID,FINANCIAL_TYPE_NAME) values('2','化验');
select * from FINANCIAL_HISTORY;
delete from FINANCIAL_HISTORY where  FINANCIAL_HISTORY_ID=6;

select * from PRESCRIPTION;
delete form PRESCRIPTION;
select * from PRESCRIPTION_RECODE;
select * from CHARGE_MANAGEMENT;
select * from FUNCTIONS where  functions_id=49;
select * from DRUG_YAOFANG;
select * from DRUG_YAOFANG_XQ;
select * from PRESCRIPTION_RECODE;
update PRESCRIPTION_RECODE set PRESCRIPTION_RECODE_NUM = 1 where PRESCRIPTION_RECODE_ID = 9;
select * from YAOKU_KUCUN;
update functions set functions_href = 'outpatient/regist_treegridselect' where functions_id = 47;
select to_char(OUTPAITENT_REGIST_GUAHAODATE,'dd') ,count(OUTPAITENT_REGIST_id) from OUTPAITENT_REGIST 
where to_char(OUTPAITENT_REGIST_GUAHAODATE,'mm') = '04' group by to_char(OUTPAITENT_REGIST_GUAHAODATE,'dd');
select * from FINANCIAL_HISTORY;

select  fi.FINANCIAL_ID , fi.FINANCIAL_Name , t.FINANCIAL_TYPE_NAME , o.OUTPAITENT_REGIST_id , f.FINANCIAL_HISTORY_shoufeizt from FINANCIAL_HISTORY f  inner join FINANCIAL fi on  fi.FINANCIAL_ID = f.FINANCIAL_ID 
inner join FINANCIAL_TYPE t on fi.FINANCIAL_TYPE_ID = t.FINANCIAL_TYPE_ID
inner join OUTPAITENT_REGIST o on o.OUTPAITENT_REGIST_id = f.OUTPAITENT_REGIST_id
 where
			 o.OUTPAITENT_REGIST_id='MG-2018041200002';

select * from FINANCIAL_HISTORY;		`	 
select nvl(max(FINANCIAL_HISTORY_id)+2, 1) from  FINANCIAL_HISTORY ;
select count(*) from FINANCIAL_HISTORY;