select * from EMP;
select * from BCLASSES;
select * from BE_ON_DUTY_PLAN;
update bed set bed_type_id=1;

insert into bed_type_type values(1 , 'a');
insert into bed_type values(1 ,1, '1');
insert into bed_type_type values(2 , 'b');
insert into bed_type values(7 ,2, '1');
insert into house_type values(1,'1111111');

INSERT INTO functions VALUES ('40', '3', '出院通知', null, 'behospitalized/hospital_notice', '1', '12');
INSERT INTO functions VALUES ('41', '3', '押金退费', null, 'behospitalized/deposit_refund', '1', '13');
insert into roles_functions values(40 , 1);
insert into roles_functions values(41 , 1);
insert into ZHUYUAN_YUSHOU values(1,null,1,null,'1');
commit;
