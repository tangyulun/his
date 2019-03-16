DELETE FROM functions;
DELETE FROM function_type;
INSERT INTO function_type VALUES ('1', '门诊管理', 'icon-menzhenguanli', '1');
INSERT INTO function_type VALUES ('2', '住院管理', 'icon-zhuyuanguanli', '2');
INSERT INTO function_type VALUES ('3', '排班管理', 'icon-paibanguanli', '3');
INSERT INTO function_type VALUES ('4', '手术管理', 'icon-shoushuguanli', '4');
INSERT INTO function_type VALUES ('5', '药库管理', 'icon-yaokuguanli', '5');
INSERT INTO function_type VALUES ('6', '药房管理', 'icon-yaofangguanli', '6');
INSERT INTO function_type VALUES ('7', '器械管理', 'icon-qixieguanli', '7');
INSERT INTO function_type VALUES ('8', '行政管理', 'icon-xingzhengguanli', '8');
INSERT INTO function_type VALUES ('9', '记录汇总', 'icon-jiluhuizong', '9');
--INSERT INTO function_type VALUES ('10', '财务管理', null, '10');
INSERT INTO function_type VALUES ('11', '体检管理', 'icon-tijianguanli', '11');
INSERT INTO function_type VALUES ('12', '权限管理', 'icon-quanxianguanli', '12');

--门诊管理 
 select *  from BE_ON_DUTY_PLAN;
INSERT INTO functions VALUES ('72', '1', '挂号管理', null, 'outpatient/registration', '1', '1');
INSERT INTO functions VALUES ('73', '1', '门诊处方', null, 'doctor/electronicprescribing', '1', '2');
INSERT INTO functions VALUES ('74', '1', '划价管理', null, 'outpatient/pricemanagement', '1', '3');
INSERT INTO functions VALUES ('75', '1', '门诊收费', null, 'outpatient/outpatientcharges', '1', '4');

--住院管理 
INSERT INTO functions VALUES ('80', '2', '住院处方', null, 'doctor/electronicprescribing', '1', '1');
INSERT INTO functions VALUES ('81', '2', '住院通知', null, 'behospitalized/hospitalization_notify', '1', '2');
INSERT INTO functions VALUES ('82', '2', '住院登记', null, 'behospitalized/hospital_registration', '1', '3');
INSERT INTO functions VALUES ('83', '2', '押金催费', null, 'behospitalized/push_the_deposit_fee', '1', '6');
INSERT INTO functions VALUES ('84', '2', '押金收取', null, 'behospitalized/charge_the_deposit', '1', '7');
INSERT INTO functions VALUES ('85', '2', '住院发药记账', null, 'nurse/send_medicine_to_account', '1', '4');
INSERT INTO functions VALUES ('89', '2', '床位调整', null, 'behospitalized/beds_to_adjust', '1', '8');
INSERT INTO functions VALUES ('86', '2', '住院治疗记账', null, 'nurse/hospitalization', '1', '5');
INSERT INTO functions VALUES ('87', '2', '住院费用核算', null, 'behospitalized/hospitalization_expense_account', '1', '9');
INSERT INTO functions VALUES ('88', '2', '住院费用结账', null, 'behospitalized/hospital_bill', '1', '10');
INSERT INTO functions VALUES ('92', '2', '出院登记', null, 'behospitalized/discharged_registration', '1', '12');
INSERT INTO functions VALUES ('90', '2', '出院通知', null, 'behospitalized/hospital_notice', '1', '11');
INSERT INTO functions VALUES ('91', '2', '押金退费', null, 'behospitalized/deposit_refund', '1', '13');

--医生工作站 
INSERT INTO functions VALUES ('76', '3', '班次设置', null, 'doctor/banci', '1', '1');
INSERT INTO functions VALUES ('77', '3', '排班计划', null, 'doctor/doctor_zh_plan', '1', '2');
INSERT INTO functions VALUES ('78', '3', '排班查询', null, 'doctor/paiban_select', '1', '3');
INSERT INTO functions VALUES ('79', '3', '出勤统计', null, 'doctor/chuqing_tongji', '1', '4');

--手术管理
INSERT INTO functions VALUES ('93', '4', '手术治疗', null, 'operation/surgery_operation', '1', '1');
INSERT INTO functions VALUES ('21', '4', '手术记录汇总', null, 'operation/ShoushuBaobiao', '1', '2');

--药库管理
INSERT INTO functions VALUES ('22', '5', '药品采购', null, 'drugstorage/drug_purchase', '1', '1');
INSERT INTO functions VALUES ('23', '5', '药品验收', null, 'drugstorage/drug_acceptance', '1', '2');
INSERT INTO functions VALUES ('24', '5', '药品入库', null, 'drugstorage/drug_warehouse', '1', '3');
INSERT INTO functions VALUES ('25', '5', '药品退货', null, 'drugstorage/drug_return', '1', '4');
INSERT INTO functions VALUES ('26', '5', '药品出库', null, 'drugstorage/drug_delivery', '1', '5');
INSERT INTO functions VALUES ('27', '5', '药库盘点', null, 'drugstorage/drug_inventory', '1', '6');
INSERT INTO functions VALUES ('28', '5', '药品查询', null, 'dean/yaoping_select', '1', '7');

--药房管理
INSERT INTO functions VALUES ('29', '6', '门诊发药', null, 'pharmacy/Outpatient_pills', '1', '1');
INSERT INTO functions VALUES ('30', '6', '住院发药', null, 'pharmacy/Hospital_pills', '1', '2');
INSERT INTO functions VALUES ('31', '6', '药房盘点', null, 'pharmacy/Pharmacy_inventory', '1', '3');

--器械管理
INSERT INTO functions VALUES ('32', '7', '器械采购', null, 'instrument/instrument_to', '1', '1');
INSERT INTO functions VALUES ('33', '7', '器械验收', null, 'instrument/intstrument_YS', '1', '2');
INSERT INTO functions VALUES ('34', '7', '器械入库', null, 'instrument/instrument_RK', '1', '3');
INSERT INTO functions VALUES ('35', '7', '器械退货', null, 'instrument/instrument_TH', '1', '4');
INSERT INTO functions VALUES ('37', '7', '器械领用', null, 'instrument/instrument_LY', '1', '5');
INSERT INTO functions VALUES ('38', '7', '器械还回', null, 'instrument/instrument_HH', '1', '6');
INSERT INTO functions VALUES ('39', '7', '器械盘点', null, 'instrument/instrument_PD', '1', '7');

--行政管理
INSERT INTO functions VALUES ('40', '8', '部门管理', null, 'dept/dept_manager', '1', '1');
INSERT INTO functions VALUES ('41', '8', '创建新部门', null, null, '60', '1');
INSERT INTO functions VALUES ('42', '8', '编辑部门', null, null, '60', '1');
INSERT INTO functions VALUES ('43', '8', '科室管理', null, 'dclass/dclass_manager', '1', '2');
INSERT INTO functions VALUES ('44', '8', '创建新科室', null, null, '63', '1');
INSERT INTO functions VALUES ('45', '8', '编辑科室信息', null, null, '63', '1');

--记录汇总
INSERT INTO functions VALUES ('46', '9', '医院经营总表', null, 'dean/hospital_zong', '1', '1');
INSERT INTO functions VALUES ('47', '9', '门诊情况总表', null, 'outpatient/regist_treegridselect', '1', '2');
INSERT INTO functions VALUES ('48', '9', '病床情况总表', null, 'dean/bingchuangqingkuang', '1', '3');
INSERT INTO functions VALUES ('49', '9', '药品采购单查询', null, 'dean/drugcaigouJilu', '1', '4');
INSERT INTO functions VALUES ('50', '9', '药房发药汇总表', null, 'dean/drughair', '1', '5');
INSERT INTO functions VALUES ('51', '9', '器械领用汇总表', null, 'dean/instrumentLYhuizong', '1', '6');
INSERT INTO functions VALUES ('52', '9', '登录记录查询', null, 'login/login_select_all', '1', '7');
INSERT INTO functions VALUES ('53', '9', '器械采购单查询', null,'dean/instrumentCghuizon', '1', '8');

--财务管理
INSERT INTO functions VALUES ('54', '10', '供应商结账', null, 'finance/finance_sup', '1', '1');

--体检管理
INSERT INTO functions VALUES ('55', '11', '检验管理', null, 'operation/to_operation', '1', '1');
INSERT INTO functions VALUES ('56', '11', '检验记录汇总', null, 'operation/operation_baobiao', '1', '2');
--权限管理
INSERT INTO functions VALUES ('57', '12', '角色列表', null, 'staff/limit_manager', '1', '1');
INSERT INTO functions VALUES ('58', '12', '创建新角色', null, null, '79', '1');
INSERT INTO functions VALUES ('59', '12', '删除角色', null, null, '79', '2');
INSERT INTO functions VALUES ('60', '12', '给角色授权', null, null, '79', '3');
INSERT INTO functions VALUES ('61', '12', '分配用户', null, null, '79', '4');
INSERT INTO functions VALUES ('62', '12', '查看角色详情', null,null, '79', '5');
INSERT INTO functions VALUES ('63', '12', '编辑', null,null, '79', '6');

INSERT INTO functions VALUES ('64', '12', '用户列表', null, 'staff/staff_manager', '1', '2');
INSERT INTO functions VALUES ('65', '12', '创建新用户', null, null, '86', '1');
INSERT INTO functions VALUES ('66', '12', '禁用/启用', null, null, '86', '2');
INSERT INTO functions VALUES ('67', '12', '调换部门', null, null, '86', '3');
INSERT INTO functions VALUES ('68', '12', '指定角色', null, null, '86', '4');
INSERT INTO functions VALUES ('69', '12', '查看用户详情', null,null, '86', '5');
INSERT INTO functions VALUES ('70', '12', '重置密码', null,null, '86', '6');
INSERT INTO functions VALUES ('71', '12', '登录', null,null, '86', '7');
commit;
