-- 添加部门信息
insert into DEPT values(1 , '行政部门' , 'admin' , 'admin' , 'admin' , sysdate , sysdate , sysdate
, '运行' , '湖南工业大学' , '行政部管理中心' , null , '特级');
insert into DEPT values(2 , '临床门诊部门' , 'admin' , 'admin' , 'admin' , sysdate , sysdate , sysdate
, '运行' , '湖南工业大学' , '门诊部中心' , null , '特级');
insert into DEPT values(3 , '住院部门' , 'admin' , 'admin' , 'admin' , sysdate , sysdate , sysdate
, '运行' , '湖南工业大学' , '住院部中心' , null , '特级');
insert into DEPT values(4 , '药剂科部门' , 'admin' , 'admin' , 'admin' , sysdate , sysdate , sysdate
, '运行' , '湖南工业大学' , '药库、药房中心' , null , '特级');
-- 添加科室信息(20-30个)
insert into DCLASS values(1 , 1 , '院长办公室' , '运行' , sysdate , '湖南工业大学新校区' , '特级' , null , null , 'admin');
insert into DCLASS values(2 , 1 , '副院长办公室' , '运行' , sysdate , '湖南工业大学新校区' , '特级' , null , null , 'admin');
insert into DCLASS values(3 , 1 , '主任办公室' , '运行' , sysdate , '湖南工业大学新校区' , '特级' , null , null , 'admin');
insert into DCLASS values(4 , 1 , '院长办公室' , '运行' , sysdate , '湖南工业大学新校区' , '特级' , null , null , 'admin');
insert into DCLASS values(5 , 1 , '事业处' , '运行' , sysdate , '湖南工业大学新校区' , '特级' , null , null , 'admin');
insert into DCLASS values(6 , 1 , '总务处' , '运行' , sysdate , '湖南工业大学新校区' , '特级' , null , null , 'admin');
insert into DCLASS values(7 , 1 , '安保科' , '运行' , sysdate , '湖南工业大学新校区' , '特级' , null , null , 'admin');
insert into DCLASS values(8 , 1 , '人事处' , '运行' , sysdate , '湖南工业大学新校区' , '特级' , null , null , 'admin');
insert into DCLASS values(9 , 1 , '秘书处' , '运行' , sysdate , '湖南工业大学新校区' , '特级' , null , null , 'admin');
insert into DCLASS values(10 , 1 , '医务科' , '运行' , sysdate , '湖南工业大学新校区' , '特级' , null , null , 'admin');
insert into DCLASS values(11, 1 , '护理部' , '运行' , sysdate , '湖南工业大学新校区' , '特级' , null , null , 'admin');
insert into DCLASS values(12 , 2 , '内科' , '运行' , sysdate , '湖南工业大学新校区' , '特级' , null , null , 'admin');
insert into DCLASS values(13, 2 , '儿科' , '运行' , sysdate , '湖南工业大学新校区' , '特级' , null , null , 'admin');
insert into DCLASS values(14 , 2 , '传染科' , '运行' , sysdate , '湖南工业大学新校区' , '特级' , null , null , 'admin');
insert into DCLASS values(15 , 2 , '外科' , '运行' , sysdate , '湖南工业大学新校区' , '特级' , null , null , 'admin');
insert into DCLASS values(16 , 2 , '骨科' , '运行' , sysdate , '湖南工业大学新校区' , '特级' , null , null , 'admin');
insert into DCLASS values(17 , 2 , '皮肤科' , '运行' , sysdate , '湖南工业大学新校区' , '特级' , null , null , 'admin');
insert into DCLASS values(18, 2 , '眼科' , '运行' , sysdate , '湖南工业大学新校区' , '特级' , null , null , 'admin');
insert into DCLASS values(19, 3 , '住院儿科' , '运行' , sysdate , '湖南工业大学新校区' , '特级' , null , null , 'admin');
insert into DCLASS values(20, 3 , '住院外科' , '运行' , sysdate , '湖南工业大学新校区' , '特级' , null , null , 'admin');
insert into DCLASS values(21, 4 , '药库' , '运行' , sysdate , '湖南工业大学新校区' , '特级' , null , null , 'admin');
insert into DCLASS values(22, 4 , '药房' , '运行' , sysdate , '湖南工业大学新校区' , '特级' , null , null , 'admin');


-- 添加一个用户(5个)
insert into EMP values(10001 , null , 1 , 1 , 'admin' , 'admin' , '21232f297a57a5a743894a0e4a801fc3' , '男' , sysdate , 1);
insert into EMP values(10002 , null , 2 , 12 , '谭丽' , '谭丽' , '21232f297a57a5a743894a0e4a801fc3' , '女' , sysdate , 1);
insert into EMP values(10003 , null , 4 , 21 , '李杨妙' , '李杨妙' , '21232f297a57a5a743894a0e4a801fc3' , '女' , sysdate , 1);
insert into EMP values(10004 , null , 4 , 22 , '刘振' , '刘振' , '21232f297a57a5a743894a0e4a801fc3' , '女' , sysdate , 1);
insert into EMP values(10005 , null , 3 , 19 , '李佳' , '李佳' , '21232f297a57a5a743894a0e4a801fc3' , '男' , sysdate , 1);
insert into EMP values(10006 , null , 3 , 20 , '唐雨' , '唐雨' , '21232f297a57a5a743894a0e4a801fc3' , '男' , sysdate , 1);

-- 添加角色(5-10个)
insert into roles values(1 , '系统管理员' , '管理医院整个系统' , sysdate);
insert into roles values(2 , '院长' , '管理全院事物' , sysdate);
insert into roles values(3 , '副院长' , '协助院长管理全院事物' , sysdate);
insert into roles values(4 , '科室主任' , '管理各科室' , sysdate);
insert into roles values(5 , '医生' , '看病人' , sysdate);
-- 绑定角色与用户的关系
insert into user_roles values(10001 , 1);
-- 添加角色的功能
insert into roles_functions values(21 , 1);
insert into roles_functions values(22 , 1);
insert into roles_functions values(23 , 1);
insert into roles_functions values(24 , 1);
insert into roles_functions values(25 , 1);
insert into roles_functions values(26 , 1);
insert into roles_functions values(27 , 1);
insert into roles_functions values(28 , 1);
insert into roles_functions values(29 , 1);
insert into roles_functions values(30 , 1);
insert into roles_functions values(31 , 1);
insert into roles_functions values(32 , 1);
insert into roles_functions values(33 , 1);
insert into roles_functions values(34 , 1);
insert into roles_functions values(35 , 1);
insert into roles_functions values(37 , 1);
insert into roles_functions values(38 , 1);
insert into roles_functions values(39 , 1);
insert into roles_functions values(40 , 1);
insert into roles_functions values(41 , 1);
insert into roles_functions values(42 , 1);
insert into roles_functions values(43 , 1);
insert into roles_functions values(44 , 1);
insert into roles_functions values(45 , 1);
insert into roles_functions values(46 , 1);
insert into roles_functions values(47 , 1);
insert into roles_functions values(48 , 1);
insert into roles_functions values(49 , 1);
insert into roles_functions values(50 , 1);
insert into roles_functions values(51 , 1);
insert into roles_functions values(52 , 1);
insert into roles_functions values(53 , 1);
insert into roles_functions values(54 , 1);
insert into roles_functions values(55 , 1);
insert into roles_functions values(56 , 1);
insert into roles_functions values(57 , 1);
insert into roles_functions values(58 , 1);
insert into roles_functions values(59 , 1);
insert into roles_functions values(60 , 1);
insert into roles_functions values(61 , 1);
insert into roles_functions values(62 , 1);
insert into roles_functions values(63 , 1);
insert into roles_functions values(64 , 1);
insert into roles_functions values(65 , 1);
insert into roles_functions values(66 , 1);
insert into roles_functions values(68 , 1);
insert into roles_functions values(73 , 1);
insert into roles_functions values(67 , 1);
insert into roles_functions values(69 , 1);
insert into roles_functions values(70 , 1);
insert into roles_functions values(71 , 1);
insert into roles_functions values(72 , 1);
insert into roles_functions values(74 , 1);
insert into roles_functions values(75 , 1);
insert into roles_functions values(76 , 1);
insert into roles_functions values(77 , 1);
insert into roles_functions values(78 , 1);
insert into roles_functions values(79 , 1);
insert into roles_functions values(80 , 1);
insert into roles_functions values(81 , 1);
insert into roles_functions values(82 , 1);
insert into roles_functions values(83 , 1);
insert into roles_functions values(84 , 1);
insert into roles_functions values(85 , 1);
insert into roles_functions values(86 , 1);
insert into roles_functions values(87 , 1);
insert into roles_functions values(88 , 1);
insert into roles_functions values(89 , 1);
insert into roles_functions values(90 , 1);
insert into roles_functions values(91 , 1);
insert into roles_functions values(92 , 1);
insert into roles_functions values(93 , 1);
-- 医疗项目分类
insert into financial_type values(1 ,'门诊收费');
insert into financial_type values(2 ,'治疗费');
insert into financial_type values(3 , '手术费');
insert into financial_type values(4 , '器械费');
insert into financial_type values(5 , '耗材费');
insert into financial_type values(6 , '体检费');
insert into financial_type values(7 , '处置费');
-- 医疗项目
insert into financial values(10001 , 10001 , 1 , 2 , 2 , '在挂号里面必须要选择的' , sysdate ,'单项','挂号费.普通' , 2);
insert into financial values(10002 , 10001 , 1 , 4 , 4 , '如果是严重的情况，就选择急诊' , sysdate ,'单项','挂号费.急诊' , 4);
insert into financial values(10003 , 10001 , 1 , 3 , 3 , '普通门诊诊查费' , sysdate ,'单项','普通门诊诊查费' , 3);
insert into financial values(10004 , 10001 , 1 , 5 , 5 , '急诊诊查费' , sysdate ,'单项','急诊诊查费' , 5);
insert into financial values(10005 , 10001 , 2 , 100 , 100 , '治疗收费1' , sysdate ,'单项','治疗收费1' , 100);
insert into financial values(10006 , 10001 , 2 , 188 , 188 , '治疗收费2' , sysdate ,'单项','治疗收费2' , 188);
insert into financial values(10007 , 10001 , 3 , 490 , 490 , '腱鞘囊肿切除术' , sysdate ,'单项','腱鞘囊肿切除术' , 490);
insert into financial values(10008 , 10001 , 3 , 800 , 800 , '腹股沟疝修补术' , sysdate ,'单项','腹股沟疝修补术' , 800);
insert into financial values(10009 , 10001 , 3 , 950 , 950 , '腹股沟斜疝修补术/单侧' , sysdate ,'单项','腹股沟斜疝修补术/单侧' , 950);
insert into financial values(10010 , 10001 , 3 , 40 , 40 , '腹腔穿刺术' , sysdate ,'单项','腹腔穿刺术' , 40);
insert into financial values(10011 , 10001 , 3 , 940 , 940 , '骨骼肌软组织肿瘤切除术' , sysdate ,'单项','骨骼肌软组织肿瘤切除术' , 940);
insert into financial values(10012 , 10001 , 3 , 200 , 200 , '关节粘连松解术' , sysdate ,'单项','关节粘连松解术' , 200);
insert into financial values(10013 , 10001 , 3 , 1120 , 1120 , '骨折粘连松解术' , sysdate ,'单项','腹腔穿刺术' , 1120);
insert into financial values(10014 , 10001 , 3 , 200 , 200 , '骨折手法整复术' , sysdate ,'单项','骨折手法整复术' , 200);
insert into financial values(10015 , 10001 , 3 , 520 , 520 , '甲床修补术' , sysdate ,'单项','甲床修补术' , 520);
insert into financial values(10016 , 10001 , 3 , 490 , 490 , '截指术' , sysdate ,'单项','截指术' , 490);
insert into financial values(10017 , 10001 , 3 , 1130 , 1130 , '髌骨骨折切开复位内固定术' , sysdate ,'单项','髌骨骨折切开复位内固定术' , 1130);
insert into financial values(10018 , 10001 , 3 , 970 , 970 , '口腔颌面部软组织清创术' , sysdate ,'单项','口腔颌面部软组织清创术' , 970);
insert into financial values(10019 , 10001 , 3 , 490 , 490 , '截指术' , sysdate ,'单项','截指术' , 490);
insert into financial values(10020 , 10001 , 3 , 500 , 500 , '阑尾炎切除术' , sysdate ,'单项','阑尾炎切除术' , 500);
insert into financial values(10021 , 10001 , 3 , 750 , 750 , '腘窝囊肿切除术' , sysdate ,'单项','腘窝囊肿切除术' , 750);
insert into financial values(10022 , 10001 , 3 , 190 , 190 , '浅表肿物切除术' , sysdate ,'单项','浅表肿物切除术' , 190);
insert into financial values(10023 , 10001 , 3 , 680 , 680 , '屈伸指肌腱吻合术' , sysdate ,'单项','屈伸指肌腱吻合术' , 680);
insert into financial values(10024 , 10001 , 3 , 50 , 50 , '脓肿切开引流术' , sysdate ,'单项','脓肿切开引流术' , 50);
insert into financial values(10040 , 10001 , 3 , 100 , 100 , '移植术' , sysdate ,'单项','移植术' , 100);
insert into financial values(10025 , 10001 , 4 , 99 , 99 , '器械费1' , sysdate ,'单项','器械费1' , 99);
insert into financial values(10026 , 10001 , 4 , 199 , 199 , '器械费2' , sysdate ,'单项','器械费2' , 199);
insert into financial values(10027 , 10001 , 4 , 299 , 299 , '器械费3' , sysdate ,'单项','器械费3' , 299);
insert into financial values(10028 , 10001 , 5 , 99.8 , 99.8 , '耗材费1' , sysdate ,'单项','耗材费2' , 99.8);
insert into financial values(10029 , 10001 , 5 , 199.8 , 199.8 , '耗材费2' , sysdate ,'单项','耗材费2' , 199.8);
insert into financial values(10030 , 10001 , 6 , 10 , 10 , '尿常规检查' , sysdate ,'单项','尿常规检查' , 10);
insert into financial values(10031 , 10001 , 6 , 20 , 20 , 'B超' , sysdate ,'单项','B超' , 20);
insert into financial values(10032 , 10001 , 6 , 10 , 10 , '肝功能检查' , sysdate ,'单项','肝功能检查' , 10);
insert into financial values(10033 , 10001 , 6 , 20 , 20 , '肾功能检查' , sysdate ,'单项','肾功能检查' , 20);
insert into financial values(10034 , 10001 , 6 , 25 , 25 , '乙肝检查' , sysdate ,'单项','乙肝检查' , 25);
insert into financial values(10035 , 10001 , 7 , 5 , 5 , '小换药' , sysdate ,'单项','小换药' , 5);
insert into financial values(10036 , 10001 , 7 , 25 , 25 , '大换药' , sysdate ,'单项','大换药' , 25);
insert into financial values(10037 , 10001 , 7 , 10 , 15 , '中换药' , sysdate ,'单项','中换药' , 15);
insert into financial values(10038 , 10001 , 7 , 20 , 20 , '肾功能检查' , sysdate ,'单项','肾功能检查' , 20);
insert into financial values(10039 , 10001 , 7 , 25 , 25 , '乙肝检查' , sysdate ,'单项','乙肝检查' , 25);
-- 班次表
insert into BCLASSES values(1 , '门诊早班' , '2.00 - 5.00' , '工作' ,'#FFA54F');
insert into BCLASSES values(2 , '门诊中班' , '5.00 - 7.00' , '工作' ,'#EE7600');
insert into BCLASSES values(3 , '门诊晚班' , '7.00 - 9.00' , '工作' ,'#C9C9C9');
insert into BCLASSES values(4 , '住院早班' , '9.00 - 11.00' , '工作' ,'#FFA54F');
insert into BCLASSES values(5 , '住院中班' , '14.00 - 18.00' , '工作' ,'#EE7600');
insert into BCLASSES values(6 , '住院晚班' , '19.00 - 22.00' , '工作' ,'#C9C9C9');
--单位表
insert into units values(1 , '箱');
insert into units values(2 , '盒');
insert into units values(3 , '袋');
insert into units values(4 , '支');
insert into units values(5 , '瓶');
insert into units values(6 , '板');
insert into units values(7 , '副');
insert into units values(8 , '片');
insert into units values(9 , '张');
--药库库存数据
delete from yaoku_kucun;
insert into yaoku_kucun values(1 , 2000 , 10 , 1000 , 1000 , 1000 , 10 , 0 ,1000);
insert into yaoku_kucun values(2 , 2000 , 10 , 1000 , 1000 , 1000 , 10 , 0 ,1000);
insert into yaoku_kucun values(3 , 2000 , 10 , 1000 , 1000 , 1000 , 10 , 0 ,1000);
insert into yaoku_kucun values(4 , 2000 , 10 , 8 , 8 , 1000 , 10 , 0 ,1000);
insert into yaoku_kucun values(5 , 2000 , 10 , 1000 , 1000 , 1000 , 10 , 0 ,1000);
insert into yaoku_kucun values(6 , 2000 , 10 , 1000 , 1000 , 1000 , 10 , 0 ,1000);
insert into yaoku_kucun values(7 , 2000 , 10 , 1000 , 1000 , 1000 , 10 , 0 ,1000);
insert into yaoku_kucun values(8 , 2000 , 10 , 1000 , 1000 , 1000 , 10 , 0 ,1000);
insert into yaoku_kucun values(9 , 2000 , 10 , 1000 , 1000 , 1000 , 10 , 0 ,1000);
insert into yaoku_kucun values(10 , 2000 , 10 , 8 , 8 , 1000 , 10 , 0 ,1000);
--药品分类数据
delete from drug_type;
insert into drug_type values(1 , '西药');
insert into drug_type values(2 , '中药');
insert into drug_type values(3 , '注射剂');
insert into drug_type values(4 , '外用药');
insert into drug_type values(5 , '酊水');
insert into drug_type values(6 , '卫材');
insert into drug_type values(7 , '西中药');
select * from drug_type;
--药品信息表(10)
insert into drug values(10001 , 1 , 1 , 1 ,'大严迪1' , '365' , 100  ,
 null , 1 , null , '片剂' , 12 , 16 , '西药房' , '口服' , 'admin' , '备注' , '大严迪');
insert into drug values(10002 , 1 , 2 , 2 ,'小严迪2' , '365' , 100  ,
 null , 1 , null , '片剂' , 10 , 13.5 , '西药房' , '口服' , 'admin' , '备注' , '小严迪');
insert into drug values(10003 ,1 , 3 , 3 ,'利君沙颗粒3' , '365' , 100  ,
 null , 1 , null , '片剂' , 13 , 22 , '西药房' , '口服' , 'admin' , '备注' , '利君沙颗粒');
 insert into drug values(10004 , 1 , 4 , 4 ,'阿奇霉素颗粒4' , '365' , 100  ,
 null , 1 , null , '片剂' , 13 , 22 , '西药房' , '口服' , 'admin' , '备注' , '阿奇霉素颗粒');
insert into drug values(10005 , 1 , 5 , 5 ,'阿奇霉素分散片5' , '365' , 100  ,
 null , 1 , null , '片剂' , 13 , 22 , '西药房' , '口服' , 'admin' , '备注' , '阿奇霉素颗粒');
 insert into drug values(10006 , 1 , 6 , 6 ,'青霉素V钾片6' , '365' , 100  ,
 null , 1 , null , '片剂' , 13 , 22 , '西药房' , '口服' , 'admin' , '备注' , '阿奇霉素颗粒');
 insert into drug values(10007 , 2 , 1 , 1 ,'大严迪7' , '365' , 100  ,
 null , 1 , null , '片剂' , 12 , 16 , '西药房' , '口服' , 'admin' , '备注' , '大严迪');
insert into drug values(10008, 2 , 2 , 2 ,'小严迪8' , '365' , 100  ,
 null , 1 , null , '片剂' , 10 , 13.5 , '西药房' , '口服' , 'admin' , '备注' , '小严迪');
insert into drug values(10009 , 1 , 3 , 3 ,'利君沙颗粒9' , '365' , 100  ,
 null , 1 , null , '片剂' , 13 , 22 , '西药房' , '口服' , 'admin' , '备注' , '利君沙颗粒');
 insert into drug values(10010 , 4 , 4 , 4 ,'阿奇霉素颗粒10' , '365' , 100  ,
 null , 1 , null , '片剂' , 13 , 22 , '西药房' , '口服' , 'admin' , '备注' , '阿奇霉素颗粒');
insert into drug values(10011 , 1 , 5 , 5 ,'阿奇霉素分散片11' , '365' , 100  ,
 null , 1 , null , '片剂' , 13 , 22 , '西药房' , '口服' , 'admin' , '备注' , '阿奇霉素颗粒');
 insert into drug values(10012 , 5 , 6 , 6 ,'青霉素V钾片12' , '365' , 100  ,
 null , 1 , null , '片剂' , 13 , 22 , '西药房' , '口服' , 'admin' , '备注' , '阿奇霉素颗粒');
 --供应商分类和供应商记录
insert into supplier_type values(1 , '药品供应');
insert into supplier_type values(2 , '器械供应');
insert into supplier values(10001 , 1 , '湖南生产' , '湖南药品生产有限公司' , 1 , '国营企业'
 , '湖南工业大学一食堂' , '现金结账' , '空运' , 'admin' , '高级' , '现金付款' , '中科韬睿智能之星' , 
'这个供应商很好，以后多多合作','谭双平' , '15096353299');
insert into supplier values(10002 , 1 , '株洲生产' , '株洲药品生产有限公司' , 1 , '私营企业' , 
'株洲火车站' , '支付宝结账' , '船运' , 'admin' , '特级' , '支付宝付款' , '职教城创业大厦' , 
'这个供应商更好，以后更多合作','谭丽' , '13874145313');
insert into supplier values(10003 , 1 , '茶陵生产' , '茶陵药品生产有限公司' , 1 , '私营企业' , 
'茶陵湖口' , '微信转账' , '空投' , 'admin' , '高级' , '微信付款' , '创业大厦湖南工业大学' , 
'还行' , '李杨妙' , '15645362713');
insert into supplier values(10004 , 2 , '日本生产' , '日本东京器械生产公司' , 1 , '私营企业' , 
'日本东京大大的' , '银行转账' , '空运' , 'admin' , '中级' , '银行转账' , '中科韬睿智能之星' , 
'还行','李家俊' , '15435267123');
insert into supplier values(10005 , 2 , '美国生产' , '美国洛杉矶器械生产有限公司' , 1 , '私营企业' , 
'洛杉矶机场' , '支付宝结账' , '空运' , 'admin' , '特级' , '支付宝付款' , '职教城创业大厦' , 
'这个供应商更好，以后更多合作','刘贞' , '15676534212');
insert into supplier values(10006 , 2 , '法国生产' , '法国巴黎铁塔' , 1 , '私营企业' , 
'铁塔上面' , '微信转账' , '空投' , 'admin' , '高级' , '微信付款' , '创业大厦湖南工业大学' , 
'还行' , '唐玉伦' , '17834252134');
-- 病床数据
insert into bed_type_type values(1 , 'A栋');
insert into bed_type_type values(2 , 'B栋');
insert into bed_type_type values(3 , 'C栋');
insert into bed_type values(1 , 1 , '一楼');
insert into bed_type values(2 , 1 , '二楼');
insert into bed_type values(3 , 1 , '三楼');
insert into bed_type values(4 , 1 , '四楼');
insert into bed_type values(5 , 1 , '五楼');
insert into bed_type values(6 , 2 , '一楼');
insert into bed_type values(7 , 2 , '二楼');
insert into bed_type values(8 , 2 , '三楼');
insert into bed_type values(9 , 2 , '四楼');
insert into bed_type values(10 , 2 , '五楼');
insert into bed_type values(11 , 3 , '一楼');
insert into bed_type values(12 , 3 , '二楼');
insert into bed_type values(13 , 3 , '三楼');
insert into bed_type values(14 , 3 , '四楼');
insert into bed_type values(15 , 3 , '五楼');
insert into house_type values(1 , '普通病房A');
insert into house_type values(2 , '普通病房B');
insert into house_type values(3 , '普通病房C');
insert into house_type values(4 , '重症病房A');
insert into house_type values(5 , '重症病房B');
insert into house_type values(6 , '重症病房C');
-- 病床数据 (6 - 10条)
insert into bed values(10001 , 1 , 1 , 10001 , '普通病床A' , '普通' , '未占用' , sysdate , '普通人的');
insert into bed values(10002 , 2 , 3 , 10001 , '普通病床B' , '普通' , '未占用' , sysdate , '普通人的');
insert into bed values(10003 , 3 , 2 , 10001 , '普通病床C' , '普通' , '未占用' , sysdate , '普通人的');
insert into bed values(10004 , 14 , 4 , 10001 , '普通病床D' , '普通' , '未占用' , sysdate , '普通人的');
insert into bed values(10005 , 10 , 5 , 10001 , '普通病床E' , '普通' , '未占用' , sysdate , '普通人的');
insert into bed values(10006 , 15 , 1 , 10001 , '普通病床F' , '普通' , '未占用' , sysdate , '普通人的');

-- 器械分类(3 - 5 个)
insert into instrument_type values(1 , '医生专用');
insert into instrument_type values(2 , '护士专用');
insert into instrument_type values(3 , '病人专用');

-- 器械表(5 - 10 个)
insert into INSTRUMENT values(10001 , 1 , 1 , 10001 , '器械A' , sysdate , 100.0 , sysdate ,
0 , '13.4' ,'医生用的' , 100 , 100 , 1000 , 10);
insert into INSTRUMENT values(10002 , 2 , 1 , 10001 , '器械B' , sysdate , 990.0 , sysdate ,
0 , '13.4' ,'护士专用' , 100 , 100 , 1000 , 10);
insert into INSTRUMENT values(10003 , 3 , 1 , 10001 , '器械C' , sysdate , 14.0 , sysdate ,
0 , '13.4' ,'病人专用' , 100 , 100 , 1000 , 10);
insert into INSTRUMENT values(10004 , 1 , 1 , 10001 , '器械D' , sysdate , 10.0 , sysdate ,
0 , '13.4' ,'医生用的' , 100 , 100 , 1000 , 10);
insert into INSTRUMENT values(10005 , 2 , 1 , 10001 , '器械E' , sysdate , 220.0 , sysdate ,
0 , '13.4' ,'护士专用' , 100 , 100 , 1000 , 10);
 INSTRUMENT_BUTTOM
-- 结算方式表(3-5个)
insert into settle_way values(1 , '支付宝');
insert into settle_way values(2 , '微信');
insert into settle_way values(3 , '银行卡转账');
insert into settle_way values(4 , '现金支付');
-- 诊疗卡表(5-10 个)
insert into medical_card values('NO:000001' , '陈丽君' , '男' , '19' , '430224199801252457' , '未婚' , null , sysdate , 10001);
insert into medical_card values('NO:000002' , '陈艳龙' , '男' , '20' , '430224199701252457' , '未婚' , null , sysdate , 10001);
insert into medical_card values('NO:000003' , '周洪春' , '女' , '89' , '43022418501252457' , '已婚' , null , sysdate , 10001);
insert into medical_card values('NO:000004' , '刘科' , '男' , '38' , '430224198801252457' , '已婚' , null , sysdate , 10001);
insert into medical_card values('NO:000005' , '陈晓龙' , '女' , '8' , '430224200801252457' , '未婚' , null , sysdate , 10001);
commit;
