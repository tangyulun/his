select * from shoushu;
select * from EMP;
insert into JIANYAN_MESS values(1002,1,10001,null,sysdate,null,null);
select * from JIANYAN_MESS;
select * from Jianyan_Mess_xq;
select * from outpaitent_regist;
update outpaitent_regist o set o.outpaitent_regist_zhuangtai='已结算' where o.outpaitent_regist_id = 'MG-2018033100002'
