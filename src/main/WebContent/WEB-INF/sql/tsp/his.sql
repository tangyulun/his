/*==============================================================*/
/* DBMS name:      ORACLE Version 10g                           */
/* Created on:     2018-01-27 15:12:59                          */
/*==============================================================*/


alter table be_on_duty_plan_xq
   drop constraint FK_BE_ON_DU_BANCI_ZHI_bCLASSES;

alter table be_on_duty_plan_xq
   drop constraint FK_BE_ON_DU_EMP_ZHIBA_EMP;

alter table be_on_duty_plan_xq
   drop constraint FK_BE_ON_DU_ZHIBAN_ZH_BE_ON_DU;

alter table bed
   drop constraint FK_BED_BINGCHUAN_BED_TYPE;

alter table bed
   drop constraint FK_BED_BINGFANGF_HOUSE_TY;

alter table bed
   drop constraint FK_BED_EMP_BED_EMP;
   

alter table bed_tiaozheng
   drop constraint FK_BED_TIAO_BINGCHUAN_BED;

alter table bed_tiaozheng
   drop constraint FK_BED_TIAO_DENGJI_CH_HOSPITAL;

alter table bed_tiaozheng
   drop constraint FK_BED_TIAO_EMP_CWTIA_EMP;

alter table bed_tiaozheng
   drop constraint FK_BED_TIAO_EMP_CWTZ_EMP;

alter table bed_type
   drop constraint FK_BED_TYPE_FENLEI_BE_BED_TYPE;

alter table caozuo_logger
   drop constraint FK_CAOZUO_L_YG_ZHAOZO_EMP;

alter table charge_jiesuan
   drop constraint FK_CHARGE_J_JIESUANFA_SETTLE_W;

alter table charge_jiesuan
   drop constraint FK_CHARGE_J_YG_CAIWUS_EMP;

alter table charge_management
   drop constraint FK_CHARGE_M_CF_SFGL_PRESCRIP;

alter table charge_management
   drop constraint FK_CHARGE_M_GUAHAO_SH_OUTPAITE;

alter table chuyuan_inform
   drop constraint FK_CHUYUAN__DENGJI_CH_HOSPITAL;

alter table chuyuan_inform
   drop constraint "FK_CHUYUAN__员工  -----_EMP";

alter table "chuyuan_login"
   drop constraint FK_CHUYUAN__TONGZHI_D_CHUYUAN_;

alter table dclass
   drop constraint FK_DCLASS_DEPT_KESH_DEPT;

alter table drug
   drop constraint "FK_DRUG_DRUG--->S_SUPPLIER";

alter table drug
   drop constraint FK_DRUG_DRUG_DRUG_DRUG_TYP;

alter table drug
   drop constraint FK_DRUG_DW_YP_UNITS;

alter table drug
   drop constraint FK_DRUG_YKKC_YP_YAOKU_KU;

alter table drug_acceptance
   drop constraint FK_DRUG_ACC_YPCG_YPYS_DRUG_PUR;

alter table drug_acceptance_xq
   drop constraint FK_DRUG_ACC_YP_YS_XQ_DRUG;

alter table drug_acceptance_xq
   drop constraint FK_DRUG_ACC_YS_YS_XQ_DRUG_ACC;

alter table drug_delivery
   drop constraint FK_DRUG_DEL_EMP_YAOPC_EMP;

alter table drug_delivery_detalis
   drop constraint "FK_DRUG_DEL_CK------>_DRUG_DEL";

alter table drug_delivery_detalis
   drop constraint FK_DRUG_DEL_YP_CK_XQ_DRUG;

alter table drug_inventory
   drop constraint FK_DRUG_INV_EMP_YKPD_EMP;

alter table drug_inventory_detalis
   drop constraint "FK_DRUG_INV_PD----->P_DRUG_INV";

alter table drug_inventory_detalis
   drop constraint FK_DRUG_INV_YP_PD_XQ_DRUG;

alter table drug_login
   drop constraint FK_DRUG_LOG_DRUG_LOGI_DRUG;

alter table drug_purchase
   drop constraint FK_DRUG_PUR_EMP_CGDD_EMP;

alter table drug_purchase
   drop constraint "FK_DRUG_PUR_PURCHASE-_SUPPLIER";

alter table drug_purchase_details_
   drop constraint FK_DRUG_PUR_CG_XQ_YP_DRUG;

alter table drug_purchase_details_
   drop constraint FK_DRUG_PUR_CGDD_CG_X_DRUG_PUR;

alter table drug_tuihuo
   drop constraint FK_DRUG_TUI_EMP_YPTH_EMP;

alter table drug_tuihuo
   drop constraint "FK_DRUG_TUI_GYS----->_SUPPLIER";

alter table drug_tuihuo
   drop constraint FK_DRUG_TUI_YS_TH_DRUG_ACC;

alter table drug_tuihuo_xq
   drop constraint "FK_DRUG_TUI_TH---->TH_DRUG_TUI";

alter table drug_tuihuo_xq
   drop constraint FK_DRUG_TUI_YP_TH_XQ_DRUG;

alter table drug_warehouse
   drop constraint FK_DRUG_WAR_YS_RK_DRUG_ACC;

alter table drug_warehouse_xq
   drop constraint "FK_DRUG_WAR_RK---->RK_DRUG_WAR";

alter table drug_warehouse_xq
   drop constraint FK_DRUG_WAR_YP_RK_XQ_DRUG;

alter table drug_yaofang
   drop constraint FK_DRUG_YAO_DZCF_MZFY_PRESCRIP;

alter table drug_yaofang
   drop constraint FK_DRUG_YAO_GH_YFFY_OUTPAITE;

alter table drug_yaofang
   drop constraint FK_DRUG_YAO_YG_MZFY_EMP;

alter table drug_yaofang_xq
   drop constraint FK_DRUG_YAO_MZFY_ZFY__DRUG_YAO;

alter table drug_yaofang_xq
   drop constraint FK_DRUG_YAO_YP_MZFY_X_DRUG;

alter table emp
   drop constraint FK_EMP_DEPT_YUAN_DEPT;

alter table emp
   drop constraint FK_EMP_KESHI_YUA_DCLASS;

alter table emp
   drop constraint FK_EMP_ZHIWU_YUA_ZHIWU;

alter table emp_message
   drop constraint FK_EMP_MESS_YG_YGXING_EMP;

alter table fayao_jizhang
   drop constraint FK_FAYAO_JI_EMP_FAYAO_EMP;

alter table fayao_jizhang
   drop constraint FK_FAYAO_JI_ZHUYUANDE_HOSPITAL;

alter table fayao_jizhang_xq
   drop constraint FK_FAYAO_JI_RELATIONS_DRUG;

alter table fayao_jizhang_xq
   drop constraint FK_FAYAO_JI_DIANZICHU_PRESCRIP;

alter table fayao_jizhang_xq
   drop constraint FK_FAYAO_JI_ZHUYUAN_Z_FAYAO_JI;

alter table finance_sumup
   drop constraint FK_FINANCE__YG_CAIFEI_EMP;

alter table financial
   drop constraint FK_FINANCIA_SHOUFEIFE_FINANCIA;

alter table financial
   drop constraint FK_FINANCIA_YG_SHOFEI_EMP;

alter table financial_history
   drop constraint FK_FINANCIA_DIANZICHU_PRESCRIP;

alter table financial_history
   drop constraint FK_FINANCIA_SHOUFEIXI_FINANCIA;

alter table fukuan_record
   drop constraint FK_FUKUAN_R_CW_GONGYI_SUPPLIER;

alter table fukuan_record
   drop constraint FK_FUKUAN_R_YINGFU_CA_FUKUAN;

alter table functions
   drop constraint FK_FUNCTION_F_TYPE_FU_FUNCTION;

alter table hospita_notify
   drop constraint FK_HOSPITA__MZGH_ZHUY_OUTPAITE;

alter table hospital_registration
   drop constraint FK_HOSPITAL_RELATIONS_EMP;

alter table hospital_registration
   drop constraint FK_HOSPITAL_BINGCHUAN_BED;

alter table hospital_registration
   drop constraint FK_HOSPITAL_TZ_DENGJI_HOSPITA_;

alter table instrument
   drop constraint FK_INSTRUME_DW_QX_UNITS;

alter table instrument
   drop constraint FK_INSTRUME_EMP_QIXIE_EMP;

alter table instrument
   drop constraint FK_INSTRUME_QXB_QXFLB_INSTRUME;

alter table instrument_caigou
   drop constraint FK_INSTRUME_RELATIONS_SUPPLIER;

alter table instrument_caigou_xq
   drop constraint FK_INSTRUME_QXB_QXCGX_INSTRUME;

alter table instrument_caigou_xq
   drop constraint FK_INSTRUME_QXCG_QXCG_INSTRUME;

alter table instrument_login
   drop constraint FK_INSTRUME_REFERENCE_INSTRUME;

alter table instrument_rk
   drop constraint FK_INSTRUME_EMP_RUKU_EMP;

alter table instrument_rk
   drop constraint FK_INSTRUME_QIXIEYANS_INSTRUME;

alter table instrument_rk_xq
   drop constraint FK_INSTRUME_QIXIE_QIX_INSTRUME;

alter table instrument_rk_xq
   drop constraint FK_INSTRUME_QIXIERUKU_INSTRUME;

alter table instrument_ys
   drop constraint FK_INSTRUME_QXCGB_QXY_INSTRUME;

alter table jianyan
   drop constraint FK_JIANYAN_DW_TJXM_UNITS;

alter table jianyan
   drop constraint FK_JIANYAN_EMP_XM_EMP;

alter table jianyan
   drop constraint FK_JIANYAN_JIANYANXI_JIANYAN_;

alter table jianyan_mess
   drop constraint FK_JIANYAN__EMP_JIANY_EMP;

alter table jianyan_mess
   drop constraint FK_JIANYAN__MZ_JYAN_OUTPAITE;

alter table jianyan_mess_xq
   drop constraint FK_JIANYAN__JIANYAN_J_JIANYAN_;

alter table jianyan_mess_xq
   drop constraint FK_JIANYAN__JIANYANXI_JIANYAN;

alter table login_logger
   drop constraint FK_LOGIN_LO_YG_DENGLU_EMP;

alter table outpaitent_regist
   drop constraint FK_OUTPAITE_KESHI_GUA_DCLASS;

alter table outpaitent_regist
   drop constraint FK_OUTPAITE_YG_GUAHAO_EMP;

alter table outpaitent_regist
   drop constraint FK_OUTPAITE_ZL_GUAHAO_MEDICAL_;

alter table pharmace_return
   drop constraint FK_PHARMACE_RELATIONS_OUTPAITE;

alter table pharmace_return
   drop constraint FK_PHARMACE_RELATIONS_PRESCRIP;

alter table pharmacy_inventory_detalis
   drop constraint FK_PHARMACY_YFPD_XQ_Y_PHARMACY;

alter table pharmacy_inventory_detalis
   drop constraint FK_PHARMACY_YP_YFPD_X_DRUG;

alter table pharmacy_recipients_detalis
   drop constraint FK_PHARMACY_YP_YPLY_X_DRUG;

alter table pharmacy_recipients_detalis
   drop constraint FK_PHARMACY_YPLY_YPLY_PHARMACY;

alter table pharmacy_return_detalis
   drop constraint FK_PHARMACY_YFTY_YFTY_PHARMACE;

alter table pharmacy_return_detalis
   drop constraint FK_PHARMACY_YP_YFTY_X_DRUG;

alter table pharmacy_warehouse_detalis
   drop constraint FK_PHARMACY_YFRK_YFRK_YAOFANG_;

alter table pharmacy_warehouse_detalis
   drop constraint FK_PHARMACY_YP_YFRK_X_DRUG;

alter table prescription
   drop constraint FK_PRESCRIP_RELATIONS_PRESCRIP;

alter table prescription
   drop constraint FK_PRESCRIP_MZ_DIZICH_OUTPAITE;

alter table prescription
   drop constraint FK_PRESCRIP_YG_DIZICH_EMP;

alter table prescription
   drop constraint FK_PRESCRIP_ZHUYUANDE_HOSPITAL;

alter table prescription_recode
   drop constraint FK_PRESCRIP_RELATIONS_DRUG;

alter table prescription_type
   drop constraint FK_PRESCRIP_DIANZICHU_PRESCRIP;

alter table prescription_type
   drop constraint FK_PRESCRIP_MZ_HUAIJI_OUTPAITE;

alter table prescription_type
   drop constraint FK_PRESCRIP_YG_HUAIJI_EMP;

alter table qx_lnventoryqx
   drop constraint FK_QX_LNVEN_QIXIE_QIX_INSTRUME;

alter table qx_lnventoryqx
   drop constraint FK_QX_LNVEN_QIXIEPAND_QX_LNVEN;

alter table qx_returngoos
   drop constraint FK_QX_RETUR_RELATIONS_SUPPLIER;

alter table qx_returngoos
   drop constraint FK_QX_RETUR_QIXIEYANS_INSTRUME;

alter table qx_returngoosqx
   drop constraint FK_QX_RETUR_QIXIETUIH_QX_RETUR;

alter table qx_returngoosqx
   drop constraint FK_QX_RETUR_QXB_QXTHX_INSTRUME;

alter table qx_returnqx
   drop constraint FK_QX_RETUR_QIXIEHUAN_QX_RETUR;

alter table qx_returnqx
   drop constraint FK_QX_RETUR_QXB_XQHHX_INSTRUME;

alter table qx_thelibrary
   drop constraint FK_QX_THELI_EMP_CHUKU_EMP;

alter table qx_thelibraryqx
   drop constraint FK_QX_THELI_QIXIE_QIX_INSTRUME;

alter table qx_thelibraryqx
   drop constraint FK_QX_THELI_QIXIECHUK_QX_THELI;

alter table qx_useqx
   drop constraint FK_QX_USEQX_QIXIE_QIX_INSTRUME;

alter table qx_useqx
   drop constraint FK_QX_USEQX_QIXIELING_QX_USE;

alter table rece_record
   drop constraint FK_RECE_REC_SHOFEIJS__CHARGE_J;

alter table rece_record
   drop constraint FK_RECE_REC_YINGFU_CA_RECE;

alter table rush_fee
   drop constraint FK_RUSH_FEE_DENGJI_YA_HOSPITAL;

alter table rush_shouqu
   drop constraint FK_RUSH_SHO_DENGJI_YA_HOSPITAL;

alter table rush_shouqu
   drop constraint FK_RUSH_SHO_EMP_YAJIN_EMP;

alter table rush_shouqu
   drop constraint FK_RUSH_SHO_TZ_YANJIS_HOSPITA_;

alter table shoushu
   drop constraint FK_SHOUSHU_EMP_SHOUS_EMP;

alter table shoushu
   drop constraint FK_SHOUSHU_KESHI_SHO_DCLASS;

alter table shoushu
   drop constraint FK_SHOUSHU_SHOUSHUSH_SHOUSHU_;

alter table shoushu_mess
   drop constraint FK_SHOUSHU__EMP_SSZL_EMP;

alter table shoushu_mess
   drop constraint FK_SHOUSHU__SOHUSHUSH_SHOUSHU;

alter table shoushu_mess
   drop constraint FK_SHOUSHU__ZHUYUAN_D_HOSPITAL;

alter table supplier
   drop constraint "FK_SUPPLIER_SUPPLIER-_SUPPLIER";

alter table supplier_jiesuan
   drop constraint FK_SUPPLIER_EMP_GYS_EMP;

alter table supplier_jiesuan
   drop constraint FK_SUPPLIER_GONG_JIES_SETTLE_W;

alter table user_roles
   drop constraint FK_USER_ROL_EMP_ROLES_ROLES;

alter table user_roles
   drop constraint "FK_USER_ROL_员工<——>角色_EMP";

alter table yajin_tuifei
   drop constraint FK_YAJIN_TU_EMP_YJTF_EMP;

alter table yajin_tuifei
   drop constraint FK_YAJIN_TU_TZHI_TUIF_CHUYUAN_;

alter table yaofang_ruku
   drop constraint FK_YAOFANG__RELATIONS_EMP;

alter table yaofang_ruku
   drop constraint FK_YAOFANG__EMP_YFRK_EMP;

alter table zhiliao_jizhang
   drop constraint FK_ZHILIAO__EMP_ZLJZ_EMP;

alter table zhiliao_jizhang
   drop constraint FK_ZHILIAO__ZHUYUANDE_HOSPITAL;

alter table zhiliao_jizhang_xq
   drop constraint FK_ZHILIAO__DZCF_ZYZL_PRESCRIP;

alter table zhiliao_jizhang_xq
   drop constraint FK_ZHILIAO__SHOUFEIXI_FINANCIA;

alter table zhiliao_jizhang_xq
   drop constraint FK_ZHILIAO__ZL_ZLXQ_ZHILIAO_;

alter table zhiwu
   drop constraint FK_ZHIWU_DEPT_ZHIW_DEPT;

alter table zhuyuan_fayao
   drop constraint FK_ZHUYUAN__RELATIONS_HOSPITAL;

alter table zhuyuan_fayao
   drop constraint FK_ZHUYUAN__RELATIONS_PRESCRIP;

alter table zhuyuan_fayao
   drop constraint FK_ZHUYUAN__RELATIONS_EMP;

alter table zhuyuan_fayao_xq
   drop constraint FK_ZHUYUAN__YP_ZYFY_X_DRUG;

alter table zhuyuan_fayao_xq
   drop constraint "FK_ZHUYUAN__ZYFY-----_ZHUYUAN_";

alter table zhuyuan_hesuan
   drop constraint FK_ZHUYUAN__DJ_FYHS_HOSPITAL;

alter table zhuyuan_jiezhang
   drop constraint FK_ZHUYUAN__DJ_FYJZ_HOSPITAL;

alter table zhuyuan_yushou
   drop constraint FK_ZHUYUAN__YAJINSHOU_RUSH_SHO;

drop table be_on_duty_plan cascade constraints;

drop index zhiban_zhiban_xq_FK;

drop index banci_zhibanjihuaxiangqing_FK;

drop index emp_zhibanjihuaxq_FK;

drop table be_on_duty_plan_xq cascade constraints;

drop index emp_bed_FK;

drop index bingfangfenlei_bingchuang_FK;

drop index bingchuangfenlei_bingchuang_FK;

drop table bed cascade constraints;

drop index emp_cwtiaozheng_FK;

drop index emp_cwtz_FK;

drop index bingchuang_14;

drop index dengji_chuangweitiaozheng_FK;

drop table bed_tiaozheng cascade constraints;

drop index fenlei_bed_type_FK;

drop table bed_type cascade constraints;

drop table bed_type_type cascade constraints;

drop index yg_zhaozourizhi_FK;

drop table caozuo_logger cascade constraints;

drop index jiesuanfanshi_shofeijiesuan_FK;

drop index yg_caiwushofei_FK;

drop table charge_jiesuan cascade constraints;

drop index guahao_shoufeiguanli_FK;

drop index cf_sfgl_FK;

drop table charge_management cascade constraints;

drop index "员工  ------- > 出院通知_FK";

drop index dengji_chuyuantongzhi_FK;

drop table chuyuan_inform cascade constraints;

drop index tongzhi_dengji_FK;

drop table "chuyuan_login" cascade constraints;

drop table bCLASSES cascade constraints;

drop index dept_keshi_FK;

drop table dclass cascade constraints;

drop table dept cascade constraints;

drop index dw_yp_FK;

drop index ykkc_yp_FK;

drop index "drug--->supplier_FK";

drop index drug_drug_type_FK;

drop table drug cascade constraints;

drop index ypcg_ypys_FK;

drop table drug_acceptance cascade constraints;

drop index ys_ys_xq_FK;

drop index yp_ys_xq_FK;

drop table drug_acceptance_xq cascade constraints;

drop index emp_yaopck_FK;

drop table drug_delivery cascade constraints;

drop index "ck------>ck_xq_FK";

drop index yp_ck_xq_FK;

drop table drug_delivery_detalis cascade constraints;

drop index emp_ykpd_FK;

drop table drug_inventory cascade constraints;

drop index "pd----->pd_xq_FK";

drop index yp_pd_xq_FK;

drop table drug_inventory_detalis cascade constraints;

drop index drug_login_FK;

drop table drug_login cascade constraints;

drop index emp_cgdd_FK;

drop index "purchase--->supplier_FK";

drop table drug_purchase cascade constraints;

drop index cg_xq_yp_FK;

drop index cgdd_cg_xq_FK;

drop table drug_purchase_details_ cascade constraints;

drop index emp_ypth_FK;

drop index ys_th_FK;

drop index "gys----->th_FK";

drop table drug_tuihuo cascade constraints;

drop index "th---->th_xq_FK";

drop index yp_th_xq_FK;

drop table drug_tuihuo_xq cascade constraints;

drop table drug_type cascade constraints;

drop index ys_rk_FK;

drop table drug_warehouse cascade constraints;

drop index "rk---->rk_xq_FK";

drop index yp_rk_xq_FK;

drop table drug_warehouse_xq cascade constraints;

drop index yg_mzfy_FK;

drop index gh_yffy_FK;

drop index dzcf_mzfy_FK;

drop table drug_yaofang cascade constraints;

drop index yp_mzfy_xq_FK;

drop index mzfy_zfy_xq_FK;

drop table drug_yaofang_xq cascade constraints;

drop index keshi_yuangong_FK;

drop index zhiwu_yuangong_FK;

drop index dept_yuangong_FK;

drop table emp cascade constraints;

drop index yg_ygxingxi_FK;

drop table emp_message cascade constraints;

drop index emp_fayaojizhang_FK;

drop index zhuyuandengji_fayaojiezhang_FK;

drop table fayao_jizhang cascade constraints;

drop index Relationship_158_FK;

drop index zhuyuan_zhuyuan_xq_FK;

drop index dianzichufang1;

drop table fayao_jizhang_xq cascade constraints;

drop index yg_caifeifyongzong_FK;

drop table finance_sumup cascade constraints;

drop index yg_shofeixiangmiu_FK;

drop index shoufeifenlei15;

drop table financial cascade constraints;

drop index dianzichufang_shoufeijilu_FK;

drop index shoufeixiangmu_shoufeijilu_FK;

drop table financial_history cascade constraints;

drop table financial_type cascade constraints;

drop table fukuan cascade constraints;

drop index cw_gongyingshang_FK;

drop index yingfu_caifuyingyong_FK;

drop table fukuan_record cascade constraints;

drop table function_type cascade constraints;

drop index f_type_function_FK;

drop table functions cascade constraints;

drop index mzgh_zhuytongzhi_FK;

drop table hospita_notify cascade constraints;

drop index Relationship_157_FK;

drop index bingchuang_dengji_FK;

drop index tz_dengji_FK;

drop table hospital_registration cascade constraints;

drop table house_type cascade constraints;

drop index emp_qixie_FK;

drop index dw_qx_FK;

drop index qixie_qixie_type_FK;

drop table instrument cascade constraints;

drop index Relationship_159_FK;

drop table instrument_caigou cascade constraints;

drop index qixiecaig11;

drop index qixie_qixiecaigoxiangqing_FK;

drop table instrument_caigou_xq cascade constraints;

drop table instrument_login cascade constraints;

drop index emp_ruku_FK;

drop index qixieyansho_qixieruku_FK;

drop table instrument_rk cascade constraints;

drop index qixie_qixierukuxiangqing_FK;

drop index qixieruku5;

drop table instrument_rk_xq cascade constraints;

drop table instrument_type cascade constraints;

drop index qixiecaigo_qixieyansho_FK;

drop table instrument_ys cascade constraints;

drop index emp_xm_FK;

drop index dw_tjxm_FK;

drop index jianyanxiangm17;

drop table jianyan cascade constraints;

drop index mz_jyan_FK;

drop index emp_jianyan_FK;

drop table jianyan_mess cascade constraints;

drop index jianyanxiangmu16;

drop index jianyan_jianyanxiangqing_FK;

drop table jianyan_mess_xq cascade constraints;

drop table jianyan_type cascade constraints;

drop index yg_denglurizhi_FK;

drop table login_logger cascade constraints;

drop table medical_card cascade constraints;

drop index zl_guahao_FK;

drop index keshi_guahao_FK;

drop index yg_guahao_FK;

drop table outpaitent_regist cascade constraints;

drop index Relationship_155_FK;

drop index Relationship_154_FK;

drop table pharmace_return cascade constraints;

drop table pharmacy_inventory cascade constraints;

drop index yfpd_xq_yfpd_FK;

drop index yp_yfpd_xq_FK;

drop table pharmacy_inventory_detalis cascade constraints;

drop table pharmacy_recipients cascade constraints;

drop index yply_yply_xq_FK;

drop index yp_yply_xq_FK;

drop table pharmacy_recipients_detalis cascade constraints;

drop index yfty_yfty_xq_FK;

drop index yp_yfty_xq_FK;

drop table pharmacy_return_detalis cascade constraints;

drop index yfrk_yfrk_xq_FK;

drop index yp_yfrk_xq_FK;

drop table pharmacy_warehouse_detalis cascade constraints;

drop index zhuyuandengji_dianzichufang_FK;

drop index Relationship_102_FK;

drop index yg_dizichufan_FK;

drop index mz_dizichufan_FK;

drop table prescription cascade constraints;

drop index Relationship_156_FK;

drop table prescription_recode cascade constraints;

drop index dianzichufang_huajia_FK;

drop index mz_huaijia_FK;

drop index yg_huaijia_FK;

drop table prescription_type cascade constraints;

drop table qx_lnventory cascade constraints;

drop index qixie_qixiepandianxiagqing_FK;

drop index qixiepandian7;

drop table qx_lnventoryqx cascade constraints;

drop table qx_return cascade constraints;

drop index Relationship_160_FK;

drop index qixieyansho_qixietuihuo_FK;

drop table qx_returngoos cascade constraints;

drop index qixie_qixietuihuoxiangqing_FK;

drop index qixietuihuo10;

drop table qx_returngoosqx cascade constraints;

drop index qixie_qixiehuanhuixiangqing_FK;

drop index qixiehuanhui9;

drop table qx_returnqx cascade constraints;

drop index emp_chuku_FK;

drop table qx_thelibrary cascade constraints;

drop index qixie_qixiechukuxiangqing_FK;

drop index qixiechuku6;

drop table qx_thelibraryqx cascade constraints;

drop table qx_use cascade constraints;

drop index qixie_13;

drop index qixielingyong12;

drop table qx_useqx cascade constraints;

drop table rece cascade constraints;

drop index shofeijs_cawujilu_FK;

drop index yingfu_caiwuyingshou_FK;

drop table rece_record cascade constraints;

drop table roles cascade constraints;

drop index dengji_yajinshoufei_FK;

drop table rush_fee cascade constraints;

drop index emp_yajinshouqu_FK;

drop index dengji_yajinshouqu_FK;

drop index tz_yanjishoqu_FK;

drop table rush_shouqu cascade constraints;

drop table settle_way cascade constraints;

drop index emp_shoushushi_FK;

drop index keshi_shoshu_FK;

drop index shoushushifenlei_shoushushi_FK;

drop table shoushu cascade constraints;

drop index zhuyuan_dengji_shoushu_FK;

drop index emp_sszl_FK;

drop index sohushushi_shoushizhiliao_FK;

drop table shoushu_mess cascade constraints;

drop table shoushu_type cascade constraints;

drop index "supplier--->supplier_type_FK";

drop table supplier cascade constraints;

drop index emp_gys_FK;

drop index gong_jiesuan_FK;

drop table supplier_jiesuan cascade constraints;

drop table supplier_type cascade constraints;

drop table units cascade constraints;

drop index "员工<——>角色2_FK";

drop index "员工<——>角色_FK";

drop table user_roles cascade constraints;
drop table roles_functions cascade constraints;

drop index emp_yjtf_FK;

drop index tzhi_tuifei_FK;

drop table yajin_tuifei cascade constraints;

drop index Relationship_153_FK;

drop index emp_yfrk_FK;

drop table yaofang_ruku cascade constraints;

drop table yaoku_kucun cascade constraints;

drop index emp_zljz_FK;

drop index zhuyuandengji2;

drop table zhiliao_jizhang cascade constraints;

drop index shoufeixiangmu3;

drop index zl_zlxq_FK;

drop index dzcf_zyzljzxq_FK;

drop table zhiliao_jizhang_xq cascade constraints;

drop index dept_zhiwu_FK;

drop table zhiwu cascade constraints;

drop index Relationship_152_FK;

drop index Relationship_151_FK;

drop index Relationship_150_FK;

drop table zhuyuan_fayao cascade constraints;

drop index yp_zyfy_xq_FK;

drop index "zyfy----->zyfy_xq_FK";

drop table zhuyuan_fayao_xq cascade constraints;

drop index dengji_feiyonghesuan_FK;

drop table zhuyuan_hesuan cascade constraints;

drop index dengji_feiyongjiezhang_FK;

drop table zhuyuan_jiezhang cascade constraints;

drop index yajinshouqu_4;

drop table zhuyuan_yushou cascade constraints;

/*==============================================================*/
/* Table: be_on_duty_plan                                       */
/*==============================================================*/
create table be_on_duty_plan  (
   be_on_duty_plan_id   VARCHAR2(225)                   not null,
   be_on_duty_plan_date DATE,
   be_on_duty_plan_start_date DATE,
   be_on_duty_plan_end_date DATE,
   be_on_duty_plan_type VARCHAR2(225),
   be_on_duty_plan_message blob,
   constraint PK_BE_ON_DUTY_PLAN primary key (be_on_duty_plan_id)
);

/*==============================================================*/
/* Table: be_on_duty_plan_xq                                    */
/*==============================================================*/
create table be_on_duty_plan_xq  (
   be_on_duty_plan_xq   INTEGER                         not null,
   bCLASSES_id           INTEGER,
   be_on_duty_plan_id   VARCHAR2(225),
   emp_id               INTEGER,
   be_on_duty_plan_xq_date DATE,
   constraint PK_BE_ON_DUTY_PLAN_XQ primary key (be_on_duty_plan_xq)
);

/*==============================================================*/
/* Index: emp_zhibanjihuaxq_FK                                  */
/*==============================================================*/
create index emp_zhibanjihuaxq_FK on be_on_duty_plan_xq (
   emp_id ASC
);

/*==============================================================*/
/* Index: banci_zhibanjihuaxiangqing_FK                         */
/*==============================================================*/
create index banci_zhibanjihuaxiangqing_FK on be_on_duty_plan_xq (
   bCLASSES_id ASC
);

/*==============================================================*/
/* Index: zhiban_zhiban_xq_FK                                   */
/*==============================================================*/
create index zhiban_zhiban_xq_FK on be_on_duty_plan_xq (
   be_on_duty_plan_id ASC
);

/*==============================================================*/
/* Table: bed                                                   */
/*==============================================================*/
create table bed  (
   bed_id               VARCHAR2(225)                   not null,
   bed_type_id          INTEGER,
   house_type_id        INTEGER,
   emp_id               INTEGER,
   bed_name             VARCHAR2(225),
   house_bingqu         VARCHAR2(225),
   house_state          VARCHAR2(225),
   bed_create_date      DATE,
   bed_remark           VARCHAR2(225),
   constraint PK_BED primary key (bed_id)
);

/*==============================================================*/
/* Index: bingchuangfenlei_bingchuang_FK                        */
/*==============================================================*/
create index bingchuangfenlei_bingchuang_FK on bed (
   bed_type_id ASC
);

/*==============================================================*/
/* Index: bingfangfenlei_bingchuang_FK                          */
/*==============================================================*/
create index bingfangfenlei_bingchuang_FK on bed (
   house_type_id ASC
);

/*==============================================================*/
/* Index: emp_bed_FK                                            */
/*==============================================================*/
create index emp_bed_FK on bed (
   emp_id ASC
);

/*==============================================================*/
/* Table: bed_tiaozheng                                         */
/*==============================================================*/
create table bed_tiaozheng  (
   bed_tiaozheng_id     VARCHAR2(225)                   not null,
   hospital_registration_id VARCHAR2(225),
   emp_id               INTEGER,
   emp_emp_id           INTEGER,
   bed_id               VARCHAR2(225),
   bed_tiaozheng_state  VARCHAR2(225),
   bed_tiaozheng_date   DATE,
   bed_tiaozheng_remark VARCHAR2(225),
   constraint PK_BED_TIAOZHENG primary key (bed_tiaozheng_id)
);

/*==============================================================*/
/* Index: dengji_chuangweitiaozheng_FK                          */
/*==============================================================*/
create index dengji_chuangweitiaozheng_FK on bed_tiaozheng (
   hospital_registration_id ASC
);

/*==============================================================*/
/* Index: bingchuang_14                                         */
/*==============================================================*/
create index bingchuang_14 on bed_tiaozheng (
   bed_id ASC
);

/*==============================================================*/
/* Index: emp_cwtz_FK                                           */
/*==============================================================*/
create index emp_cwtz_FK on bed_tiaozheng (
   emp_emp_id ASC
);

/*==============================================================*/
/* Index: emp_cwtiaozheng_FK                                    */
/*==============================================================*/
create index emp_cwtiaozheng_FK on bed_tiaozheng (
   emp_id ASC
);

/*==============================================================*/
/* Table: bed_type                                              */
/*==============================================================*/
create table bed_type  (
   bed_type_id          INTEGER                         not null,
   bed_type_type_id     INTEGER,
   bed_type_name        VARCHAR2(225),
   constraint PK_BED_TYPE primary key (bed_type_id)
);

/*==============================================================*/
/* Index: fenlei_bed_type_FK                                    */
/*==============================================================*/
create index fenlei_bed_type_FK on bed_type (
   bed_type_type_id ASC
);

/*==============================================================*/
/* Table: bed_type_type                                         */
/*==============================================================*/
create table bed_type_type  (
   bed_type_type_id     INTEGER                         not null,
   bed_type_type_name   VARCHAR2(225),
   constraint PK_BED_TYPE_TYPE primary key (bed_type_type_id)
);

/*==============================================================*/
/* Table: caozuo_logger                                         */
/*==============================================================*/
create table caozuo_logger  (
   caozuo_logger        INTEGER                         not null,
   emp_id               INTEGER,
   caozuo_date          TIMESTAMP,
   caozuo_message       VARCHAR2(225),
   constraint PK_CAOZUO_LOGGER primary key (caozuo_logger)
);

/*==============================================================*/
/* Index: yg_zhaozourizhi_FK                                    */
/*==============================================================*/
create index yg_zhaozourizhi_FK on caozuo_logger (
   emp_id ASC
);

/*==============================================================*/
/* Table: charge_jiesuan                                        */
/*==============================================================*/
create table charge_jiesuan  (
   charge_jiesuan_id    VARCHAR2(225)                        not null,
   emp_id               INTEGER,
   settle_way_id        VARCHAR2(225),
   charge_jiesuan_state VARCHAR2(225),
   jiesuan_type         VARCHAR2(225),
   charge_jiesuan_date  DATE,
   menzhen_id           VARCHAR2(225),
   charge_jiesuan_time  VARCHAR2(225),
   charge_jiesuan_invoice VARCHAR2(225),
   charge_jiesuan_yf    NUMBER(9,2),
   charge_jiesuan_sf    NUMBER(9,2),
   charge_jiesuan_remark VARCHAR2(225),
   constraint PK_CHARGE_JIESUAN primary key (charge_jiesuan_id)
);

/*==============================================================*/
/* Index: yg_caiwushofei_FK                                     */
/*==============================================================*/
create index yg_caiwushofei_FK on charge_jiesuan (
   emp_id ASC
);

/*==============================================================*/
/* Index: jiesuanfanshi_shofeijiesuan_FK                        */
/*==============================================================*/
create index jiesuanfanshi_shofeijiesuan_FK on charge_jiesuan (
   settle_way_id ASC
);

/*==============================================================*/
/* Table: charge_management                                     */
/*==============================================================*/
create table charge_management  (
   charge_management_id VARCHAR2(225)                   not null,
   prescription_id      VARCHAR2(225),
   outpaitent_regist_id VARCHAR2(225),
   charge_management_zt VARCHAR2(225),
   charge_management_chargedate DATE,
   charge_management_ysjine NUMBER(9,2),
   charge_management_ytjine NUMBER(9,2),
   charge_management_ssjine NUMBER(9,2),
   constraint PK_CHARGE_MANAGEMENT primary key (charge_management_id)
);

/*==============================================================*/
/* Index: cf_sfgl_FK                                            */
/*==============================================================*/
create index cf_sfgl_FK on charge_management (
   prescription_id ASC
);

/*==============================================================*/
/* Index: guahao_shoufeiguanli_FK                               */
/*==============================================================*/
create index guahao_shoufeiguanli_FK on charge_management (
   outpaitent_regist_id ASC
);

/*==============================================================*/
/* Table: chuyuan_inform                                        */
/*==============================================================*/
create table chuyuan_inform  (
   chuyuan_inform_id    VARCHAR2(225)                   not null,
   hospital_registration_id VARCHAR2(225),
   emp_id               INTEGER,
   chuyuan_inform_state VARCHAR2(225),
   chuyuan_inform_date  DATE,
   chuyuan_inform_type  VARCHAR2(225),
   chuyuan_inform_feiyong_zmoney NUMBER(9,2),
   chuyuan_inform_yajin_zmoney NUMBER(9,2),
   chuyuan_inform_remark VARCHAR2(225),
   constraint PK_CHUYUAN_INFORM primary key (chuyuan_inform_id)
);

/*==============================================================*/
/* Index: dengji_chuyuantongzhi_FK                              */
/*==============================================================*/
create index dengji_chuyuantongzhi_FK on chuyuan_inform (
   hospital_registration_id ASC
);

/*==============================================================*/
/* Index: "员工  ------- > 出院通知_FK"                               */
/*==============================================================*/
create index "员工  ------- > 出院通知_FK" on chuyuan_inform (
   emp_id ASC
);

/*==============================================================*/
/* Table: "chuyuan_login"                                      */
/*==============================================================*/
create table "chuyuan_login"  (
   chuyuan_login_id     VARCHAR2(225)                   not null,
   chuyuan_inform_id    VARCHAR2(225),
   chuyuan_login_state  VARCHAR2(225),
   chuyuan_login_date   DATE,
   constraint "PK_chuyuan_login" primary key (chuyuan_login_id)
);

/*==============================================================*/
/* Index: tongzhi_dengji_FK                                     */
/*==============================================================*/
create index tongzhi_dengji_FK on "chuyuan_login" (
   chuyuan_inform_id ASC
);

/*==============================================================*/
/* Table: bCLASSES                                               */
/*==============================================================*/
create table bCLASSES  (
   bCLASSES_id           INTEGER                         not null,
   bCLASSES_name         VARCHAR2(225),
   bCLASSES_bet_time     VARCHAR2(225),
   bCLASSES_type         VARCHAR2(225),
   bCLASSES_color        VARCHAR2(225),
   constraint PK_bCLASSES primary key (bCLASSES_id)
);

/*==============================================================*/
/* Table: dclass                                                */
/*==============================================================*/
create table dclass  (
   dclass_id            INTEGER                         not null,
   dept_id              INTEGER,
   dclass_name          VARCHAR2(225),
   dclass_state         VARCHAR2(225),
   dclass_create_date   DATE,
   dclass_address       VARCHAR2(225),
   dclass_grade         VARCHAR2(225),
   dclass_explain       VARCHAR2(225),
   dclass_remark        VARCHAR2(225),
   dclass_fuze_name     VARCHAR2(225),
   constraint PK_DCLASS primary key (dclass_id)
);

/*==============================================================*/
/* Index: dept_keshi_FK                                         */
/*==============================================================*/
create index dept_keshi_FK on dclass (
   dept_id ASC
);

/*==============================================================*/
/* Table: dept                                                  */
/*==============================================================*/
create table dept  (
   dept_id              INTEGER                         not null,
   dept_name            VARCHAR2(225),
   dept_fuze_name       VARCHAR2(225),
   dept_shenhe_name     VARCHAR2(225),
   dept_pizhun_name     VARCHAR2(225),
   dept_create_date     DATE,
   dept_shenhe_date     DATE,
   dept_pizhun_date     DATE,
   dept_state           VARCHAR2(225),
   dept_address         VARCHAR2(225),
   dept_explain         VARCHAR2(225),
   dept_remark          VARCHAR2(225),
   dept_grade           VARCHAR2(225),
   constraint PK_DEPT primary key (dept_id)
);

/*==============================================================*/
/* Table: drug                                                  */
/*==============================================================*/
create table drug  (
   drug_id              VARCHAR2(225)      not null,
   drug_type_id         INTEGER,
   yaoku_kucun_id       INTEGER,
   units_id             INTEGER,
   drug_name            VARCHAR2(225),
   drug_bzdate          VARCHAR2(225),
   drug_gg              VARCHAR2(225),
   drug_sccj            VARCHAR2(225),
   drug_zt              VARCHAR2(225),
   drug_cf              VARCHAR2(225),
   drug_jx              VARCHAR2(225),
   drug_pfprice         number(9,2),
   drug_lsprice         number(9,2),
   drug_yf              VARCHAR2(225),
   drug_lx              VARCHAR2(225),
   drug_shr             VARCHAR2(225),
   drug_bz              VARCHAR2(225),
   drug_bname           VARCHAR2(225),
   constraint PK_DRUG primary key (drug_id)
);

/*==============================================================*/
/* Index: drug_drug_type_FK                                     */
/*==============================================================*/
create index drug_drug_type_FK on drug (
   drug_type_id ASC
);


/*==============================================================*/
/* Index: ykkc_yp_FK                                            */
/*==============================================================*/
create index ykkc_yp_FK on drug (
   yaoku_kucun_id ASC
);

/*==============================================================*/
/* Index: dw_yp_FK                                              */
/*==============================================================*/
create index dw_yp_FK on drug (
   units_id ASC
);

/*==============================================================*/
/* Table: drug_acceptance                                       */
/*==============================================================*/
create table drug_acceptance  (
   drug_acceptance_id   VARCHAR2(225)                   not null,
   drug_purchase_id     VARCHAR2(225),
   drug_acceptance_zt   VARCHAR2(225),
   drug_acceptance_shdate DATE,
   drug_acceptance_pzdh VARCHAR2(225),
   constraint PK_DRUG_ACCEPTANCE primary key (drug_acceptance_id)
);

/*==============================================================*/
/* Index: ypcg_ypys_FK                                          */
/*==============================================================*/
create index ypcg_ypys_FK on drug_acceptance (
   drug_purchase_id ASC
);

/*==============================================================*/
/* Table: drug_acceptance_xq                                    */
/*==============================================================*/
create table drug_acceptance_xq  (
   drug_acceptance_xq   INTEGER                         not null,
   drug_id              VARCHAR2(225),
   drug_acceptance_id   VARCHAR2(225),
   drug_acceptance_xq_ph VARCHAR2(225),
   drug_acceptance_xq_price number(9,2),
   drug_acceptance_xq_money number(9,2),
   drug_acceptance_xq_remark VARCHAR2(225),
   drug_acceptance_xq_num INTEGER,
   drug_acceptance_xq_hege_num integer ,
   drug_acceptance_xq_buhege_num integer,
   constraint PK_DRUG_ACCEPTANCE_XQ primary key (drug_acceptance_xq)
);

/*==============================================================*/
/* Index: yp_ys_xq_FK                                           */
/*==============================================================*/
create index yp_ys_xq_FK on drug_acceptance_xq (
   drug_id ASC
);

/*==============================================================*/
/* Index: ys_ys_xq_FK                                           */
/*==============================================================*/
create index ys_ys_xq_FK on drug_acceptance_xq (
   drug_acceptance_id ASC
);

/*==============================================================*/
/* Table: drug_delivery                                         */
/*==============================================================*/
create table drug_delivery  (
   drug_delivery_id     VARCHAR2(225)                   not null,
   emp_id               INTEGER,
   drug_delivery_zt     VARCHAR2(225),
   drug_delivery_ck     VARCHAR2(225),
   drug_delivery_ckdate DATE,
   drug_delivery_cklx   VARCHAR2(225),
   drug_delivery_ckdx   VARCHAR2(225),
   drug_delivery_cgy    VARCHAR2(225),
   drug_delivery_pzdh   VARCHAR2(225),
   constraint PK_DRUG_DELIVERY primary key (drug_delivery_id)
);

/*==============================================================*/
/* Index: emp_yaopck_FK                                         */
/*==============================================================*/
create index emp_yaopck_FK on drug_delivery (
   emp_id ASC
);

/*==============================================================*/
/* Table: drug_delivery_detalis                                 */
/*==============================================================*/
create table drug_delivery_detalis  (
   Drug_delivery_detalis_id INTEGER                         not null,
   drug_delivery_id     VARCHAR2(225),
   drug_id              VARCHAR2(225),
   Drug_delivery_detalis_num VARCHAR2(225),
   Drug_delivery_detalis_ph VARCHAR2(225),
   Drug_delivery_detalis_bz VARCHAR2(225),
   constraint PK_DRUG_DELIVERY_DETALIS primary key (Drug_delivery_detalis_id)
);

/*==============================================================*/
/* Index: yp_ck_xq_FK                                           */
/*==============================================================*/
create index yp_ck_xq_FK on drug_delivery_detalis (
   drug_id ASC
);

/*==============================================================*/
/* Index: "ck------>ck_xq_FK"                                   */
/*==============================================================*/
create index "ck------>ck_xq_FK" on drug_delivery_detalis (
   drug_delivery_id ASC
);

/*==============================================================*/
/* Table: drug_inventory                                        */
/*==============================================================*/
create table drug_inventory  (
   Drug_inventory_id    VARCHAR2(225)                   not null,
   emp_id               INTEGER,
   Drug_invertory_zt    VARCHAR2(225),
   Drug_invertory_pddate DATE,
   Drug_invertory_pdyk  VARCHAR2(225),
   constraint PK_DRUG_INVENTORY primary key (Drug_inventory_id)
);

/*==============================================================*/
/* Index: emp_ykpd_FK                                           */
/*==============================================================*/
create index emp_ykpd_FK on drug_inventory (
   emp_id ASC
);

/*==============================================================*/
/* Table: drug_inventory_detalis                                */
/*==============================================================*/
create table drug_inventory_detalis  (
   Drug_inventory_detalis_id VARCHAR2(225)                   not null,
   drug_id              VARCHAR2(225),
   Drug_inventory_id    VARCHAR2(225),
   Drug_inventory_detalis_jcnum INTEGER,
   Drug_inventory_detalis_dj number(9,2),
   Drug_inventory_detalis_kynum INTEGER,
   Drug_inventory_detalis_kymoney number(9,2),
   Drug_inventory_detalis_ph VARCHAR2(225),
   constraint PK_DRUG_INVENTORY_DETALIS primary key (Drug_inventory_detalis_id)
);

/*==============================================================*/
/* Index: yp_pd_xq_FK                                           */
/*==============================================================*/
create index yp_pd_xq_FK on drug_inventory_detalis (
   drug_id ASC
);

/*==============================================================*/
/* Index: "pd----->pd_xq_FK"                                    */
/*==============================================================*/
create index "pd----->pd_xq_FK" on drug_inventory_detalis (
   Drug_inventory_id ASC
);

/*==============================================================*/
/* Table: drug_login                                            */
/*==============================================================*/
create table drug_login  (
   drug_login_id        VARCHAR2(225)                   not null,
   drug_id              VARCHAR2(225),
   drug_login_num       INTEGER,
   drug_login_price     number(9,2),
   drug_login_scdate    DATE,
   drug_login_yxqdate   DATE,
   drug_login_cgdate    DATE,
   drug_login_yxdate    VARCHAR2(225),
   drug_login_ph        VARCHAR2(225),
   constraint PK_DRUG_LOGIN primary key (drug_login_id)
);

/*==============================================================*/
/* Index: drug_login_FK                                         */
/*==============================================================*/
create index drug_login_FK on drug_login (
   drug_id ASC
);

/*==============================================================*/
/* Table: drug_purchase                                         */
/*==============================================================*/
create table drug_purchase  (
   drug_purchase_id     VARCHAR2(225)                   not null,
   supplier_id          VARCHAR2(225),
   emp_id               INTEGER,
   drug_purchase_zt     VARCHAR2(225),
   drug_purchase_ghdate DATE,
   drug_purchase_dhdate DATE,
   drug_purchase_jhdz   VARCHAR2(225),
   drug_purchase_money  number(9,2),
   constraint PK_DRUG_PURCHASE primary key (drug_purchase_id)
);

/*==============================================================*/
/* Index: "purchase--->supplier_FK"                             */
/*==============================================================*/
create index "purchase--->supplier_FK" on drug_purchase (
   supplier_id ASC
);

/*==============================================================*/
/* Index: emp_cgdd_FK                                           */
/*==============================================================*/
create index emp_cgdd_FK on drug_purchase (
   emp_id ASC
);

/*==============================================================*/
/* Table: drug_purchase_details_                                */
/*==============================================================*/
create table drug_purchase_details_  (
   drug_purchase_details_id INTEGER                         not null,
   drug_id              VARCHAR2(225),
   drug_purchase_id     VARCHAR2(225),
   drug_purchase_details_num INTEGER,
   drug_purchase_details_dj number(9,2),
   drug_purchase_details_je number(9,2),
   drug_purchase_details_ph VARCHAR2(225),
   drug_purchase_details_bz VARCHAR2(225),
   constraint PK_DRUG_PURCHASE_DETAILS_ primary key (drug_purchase_details_id)
);

/*==============================================================*/
/* Index: cgdd_cg_xq_FK                                         */
/*==============================================================*/
create index cgdd_cg_xq_FK on drug_purchase_details_ (
   drug_purchase_id ASC
);

/*==============================================================*/
/* Index: cg_xq_yp_FK                                           */
/*==============================================================*/
create index cg_xq_yp_FK on drug_purchase_details_ (
   drug_id ASC
);

/*==============================================================*/
/* Table: drug_tuihuo                                           */
/*==============================================================*/
create table drug_tuihuo  (
   drug_tuihuo_id       VARCHAR2(225)                   not null,
   emp_id               INTEGER,
   drug_acceptance_id   VARCHAR2(225),
   supplier_id          VARCHAR2(225),
   drug_tuihuo_state    VARCHAR2(225),
   drug_tuihuo_date     DATE,
   drug_tuihuo_pz_id    VARCHAR2(225),
   drug_tuihuo_money    number(9,2),
   constraint PK_DRUG_TUIHUO primary key (drug_tuihuo_id)
);

/*==============================================================*/
/* Index: "gys----->th_FK"                                      */
/*==============================================================*/
create index "gys----->th_FK" on drug_tuihuo (
   supplier_id ASC
);

/*==============================================================*/
/* Index: ys_th_FK                                              */
/*==============================================================*/
create index ys_th_FK on drug_tuihuo (
   drug_acceptance_id ASC
);

/*==============================================================*/
/* Index: emp_ypth_FK                                           */
/*==============================================================*/
create index emp_ypth_FK on drug_tuihuo (
   emp_id ASC
);

/*==============================================================*/
/* Table: drug_tuihuo_xq                                        */
/*==============================================================*/
create table drug_tuihuo_xq  (
   drug_tuihuo_xq_id    INTEGER                         not null,
   drug_tuihuo_id       VARCHAR2(225),
   drug_id              VARCHAR2(225),
   drug_acceptance_xq_ph VARCHAR2(225),
   drug_acceptance_xq_num INTEGER,
   drug_acceptance_xq_price number(9,2),
   drug_acceptance_xq_money number(9,2),
   drug_acceptance_xq_remark VARCHAR2(225),
   constraint PK_DRUG_TUIHUO_XQ primary key (drug_tuihuo_xq_id)
);

/*==============================================================*/
/* Index: yp_th_xq_FK                                           */
/*==============================================================*/
create index yp_th_xq_FK on drug_tuihuo_xq (
   drug_id ASC
);

/*==============================================================*/
/* Index: "th---->th_xq_FK"                                     */
/*==============================================================*/
create index "th---->th_xq_FK" on drug_tuihuo_xq (
   drug_tuihuo_id ASC
);

/*==============================================================*/
/* Table: drug_type                                             */
/*==============================================================*/
create table drug_type  (
   drug_type_id         INTEGER                         not null,
   drug_type_name       VARCHAR2(225),
   constraint PK_DRUG_TYPE primary key (drug_type_id)
);

/*==============================================================*/
/* Table: drug_warehouse                                        */
/*==============================================================*/
create table drug_warehouse  (
   drug_warehouse_id    VARCHAR2(225)                   not null,
   drug_acceptance_id   VARCHAR2(225),
   drug_warehouse_zt    VARCHAR2(225),
   drug_warehouse_rkdate DATE,
   drug_warehouse_rklx  VARCHAR2(225),
   drug_warehouse_pzdh  VARCHAR2(225),
   drug_warehouse_name  VARCHAR2(225),
   drug_warehouse_cgy   VARCHAR2(225),
   constraint PK_DRUG_WAREHOUSE primary key (drug_warehouse_id)
);

/*==============================================================*/
/* Index: ys_rk_FK                                              */
/*==============================================================*/
create index ys_rk_FK on drug_warehouse (
   drug_acceptance_id ASC
);

/*==============================================================*/
/* Table: drug_warehouse_xq                                     */
/*==============================================================*/
create table drug_warehouse_xq  (
   drug_warehouse_xq_id INTEGER                         not null,
   drug_warehouse_id    VARCHAR2(225),
   drug_id              VARCHAR2(225),
   drug_warehouse_xq_num INTEGER,
   drug_warehouse_xq_ph VARCHAR2(225),
   drug_warehouse_xq_bz_date DATE,
   drug_warehouse_xq_sc_date DATE,
   drug_warehouse_xq_cg_date DATE,
   drug_warehouse_xq_remark VARCHAR2(225),
   constraint PK_DRUG_WAREHOUSE_XQ primary key (drug_warehouse_xq_id)
);

/*==============================================================*/
/* Index: yp_rk_xq_FK                                           */
/*==============================================================*/
create index yp_rk_xq_FK on drug_warehouse_xq (
   drug_id ASC
);

/*==============================================================*/
/* Index: "rk---->rk_xq_FK"                                     */
/*==============================================================*/
create index "rk---->rk_xq_FK" on drug_warehouse_xq (
   drug_warehouse_id ASC
);

/*==============================================================*/
/* Table: drug_yaofang                                          */
/*==============================================================*/
create table drug_yaofang  (
   drug_yaofang_id      VARCHAR2(225)                   not null,
   prescription_id      VARCHAR2(225),
   outpaitent_regist_id VARCHAR2(225),
   emp_id               INTEGER,
   drug_yaofang_state   VARCHAR2(225),
   drug_yaofang_date    DATE,
   zhuyuan_fayao_house  VARCHAR2(225),
   zhuyuan_fayao_zmoney number(9,2),
   constraint PK_DRUG_YAOFANG primary key (drug_yaofang_id)
);

/*==============================================================*/
/* Index: dzcf_mzfy_FK                                          */
/*==============================================================*/
create index dzcf_mzfy_FK on drug_yaofang (
   prescription_id ASC
);

/*==============================================================*/
/* Index: gh_yffy_FK                                            */
/*==============================================================*/
create index gh_yffy_FK on drug_yaofang (
   outpaitent_regist_id ASC
);

/*==============================================================*/
/* Index: yg_mzfy_FK                                            */
/*==============================================================*/
create index yg_mzfy_FK on drug_yaofang (
   emp_id ASC
);

/*==============================================================*/
/* Table: drug_yaofang_xq                                       */
/*==============================================================*/
create table drug_yaofang_xq  (
   drug_yaofang_xq_id   INTEGER                         not null,
   drug_yaofang_id      VARCHAR2(225),
   drug_id              VARCHAR2(225),
   drug_yaofang_xq_ph   VARCHAR2(225),
   drug_yaofang_xq_number INTEGER,
   drug_yaofang_xq_price number(9,2),
   drug_yaofang_xq_money number(9,2),
   drug_yaofang_xq_state VARCHAR2(225),
   drug_yaofang_xq_remark VARCHAR2(225),
   constraint PK_DRUG_YAOFANG_XQ primary key (drug_yaofang_xq_id)
);

/*==============================================================*/
/* Index: mzfy_zfy_xq_FK                                        */
/*==============================================================*/
create index mzfy_zfy_xq_FK on drug_yaofang_xq (
   drug_yaofang_id ASC
);

/*==============================================================*/
/* Index: yp_mzfy_xq_FK                                         */
/*==============================================================*/
create index yp_mzfy_xq_FK on drug_yaofang_xq (
   drug_id ASC
);

/*==============================================================*/
/* Table: emp                                                   */
/*==============================================================*/
create table emp  (
   emp_id               INTEGER                         not null,
   zhiwu_id             INTEGER,
   dept_id              INTEGER,
   dclass_id            INTEGER,
   emp_login_name       VARCHAR2(225),
   emp_name             VARCHAR2(225),
   emp_pwd              VARCHAR2(225),
   emp_sex              VARCHAR2(225),
   emp_date             DATE,
   emp_state            INTEGER,
   constraint PK_EMP primary key (emp_id)
);

/*==============================================================*/
/* Index: dept_yuangong_FK                                      */
/*==============================================================*/
create index dept_yuangong_FK on emp (
   dept_id ASC
);

/*==============================================================*/
/* Index: zhiwu_yuangong_FK                                     */
/*==============================================================*/
create index zhiwu_yuangong_FK on emp (
   zhiwu_id ASC
);

/*==============================================================*/
/* Index: keshi_yuangong_FK                                     */
/*==============================================================*/
create index keshi_yuangong_FK on emp (
   dclass_id ASC
);

/*==============================================================*/
/* Table: emp_message                                           */
/*==============================================================*/
create table emp_message  (
   emp_message_id       INTEGER                         not null,
   emp_id               INTEGER,
   emp_message_phone    VARCHAR2(225),
   emp_message_nation   VARCHAR2(225),
   emp_message_id_card  VARCHAR2(225),
   emp_message_is_marry VARCHAR2(225),
   emp_message_birthday DATE,
   emp_message_face     VARCHAR2(225),
   emp_message_xueli    VARCHAR2(225),
   emp_message_dispose_date VARCHAR2(225),
   emp_message_dispose_name VARCHAR2(225),
   emp_message_address  VARCHAR2(225),
   emp_message_major    VARCHAR2(225),
   emp_message_remark   VARCHAR2(225),
   constraint PK_EMP_MESSAGE primary key (emp_message_id)
);

/*==============================================================*/
/* Index: yg_ygxingxi_FK                                        */
/*==============================================================*/
create index yg_ygxingxi_FK on emp_message (
   emp_id ASC
);

/*==============================================================*/
/* Table: fayao_jizhang                                         */
/*==============================================================*/
create table fayao_jizhang  (
   zhuyuan_jizhang_id   VARCHAR2(225)                   not null,
   hospital_registration_id VARCHAR2(225),
   emp_id               INTEGER,
   zhuyuan_jizhang_state VARCHAR2(225),
   zhuyuan_jizhang_date DATE,
   zhuyuan_jizhang_sate VARCHAR2(225),
   constraint PK_FAYAO_JIZHANG primary key (zhuyuan_jizhang_id)
);

/*==============================================================*/
/* Index: zhuyuandengji_fayaojiezhang_FK                        */
/*==============================================================*/
create index zhuyuandengji_fayaojiezhang_FK on fayao_jizhang (
   hospital_registration_id ASC
);

/*==============================================================*/
/* Index: emp_fayaojizhang_FK                                   */
/*==============================================================*/
create index emp_fayaojizhang_FK on fayao_jizhang (
   emp_id ASC
);

/*==============================================================*/
/* Table: fayao_jizhang_xq                                      */
/*==============================================================*/
create table fayao_jizhang_xq  (
   fayao_jizhang_xq_id  INTEGER                         not null,
   prescription_id     VARCHAR2(225),
   zhuyuan_jizhang_id   VARCHAR2(225),
   drug_id              VARCHAR2(225),
   fayao_jizhang_xq_num INTEGER,
   fayao_jizhang_xq_price NUMBER(9,2),
   fayao_jizhang_xq_jiliang INTEGER,
   fayao_jizhang_xq_state VARCHAR2(225),
   fayao_jizhang_xq_date DATE,
   fayao_jizhang_xq_time VARCHAR2(225),
   constraint PK_FAYAO_JIZHANG_XQ primary key (fayao_jizhang_xq_id)
);

/*==============================================================*/
/* Index: dianzichufang1                                        */
/*==============================================================*/
create index dianzichufang1 on fayao_jizhang_xq (
   prescription_id ASC
);

/*==============================================================*/
/* Index: zhuyuan_zhuyuan_xq_FK                                 */
/*==============================================================*/
create index zhuyuan_zhuyuan_xq_FK on fayao_jizhang_xq (
   zhuyuan_jizhang_id ASC
);

/*==============================================================*/
/* Index: Relationship_158_FK                                   */
/*==============================================================*/
create index Relationship_158_FK on fayao_jizhang_xq (
   drug_id ASC
);

/*==============================================================*/
/* Table: finance_sumup                                         */
/*==============================================================*/
create table finance_sumup  (
   finance_sumup_id     VARCHAR2(225)                   not null,
   emp_id               INTEGER,
   finance_sumup_type   VARCHAR2(225),
   finance_sumup_is     VARCHAR2(225),
   finance_sumup_smoney NUMBER(9,2),
   finance_sumup_ymoney NUMBER(9,2),
   finance_sumup_dispose_date DATE,
   finance_sumup_dispose_time DATE,
   constraint PK_FINANCE_SUMUP primary key (finance_sumup_id)
);

/*==============================================================*/
/* Index: yg_caifeifyongzong_FK                                 */
/*==============================================================*/
create index yg_caifeifyongzong_FK on finance_sumup (
   emp_id ASC
);

/*==============================================================*/
/* Table: financial                                             */
/*==============================================================*/
create table financial  (
   financial_id         VARCHAR2(225)                   not null,
   emp_id               INTEGER,
   financial_type_id    VARCHAR2(225),
   financial_money      NUMBER(9,2),
   financial_zhekoujia  NUMBER(9,2),
   financial_explain    VARCHAR2(225),
   financial_creator_date DATE,
   financial_type       VARCHAR2(225),
   financial_name       VARCHAR2(225),
   financial_price      NUMBER(9,2),
   constraint PK_FINANCIAL primary key (financial_id)
);

/*==============================================================*/
/* Index: shoufeifenlei15                                       */
/*==============================================================*/
create index shoufeifenlei15 on financial (
   financial_type_id ASC
);

/*==============================================================*/
/* Index: yg_shofeixiangmiu_FK                                  */
/*==============================================================*/
create index yg_shofeixiangmiu_FK on financial (
   emp_id ASC
);

/*==============================================================*/
/* Table: financial_history                                     */
/*==============================================================*/
create table financial_history  (
   financial_history_id VARCHAR2(225)                   not null,
   outpaitent_regist_id	 VARCHAR2(225),
   financial_id        VARCHAR2(225),
   financial_history_shoufeirq DATE,
   financial_history_shoufeilx VARCHAR2(225),
   financial_history_shoufeije NUMBER(9,2),
   financial_history_num int,
   financial_history_shoufeizt VARCHAR2(225),
   financial_history_shoufeisj VARCHAR2(225),
   financial_history_type VARCHAR2(225),
   constraint PK_FINANCIAL_HISTORY primary key (financial_history_id)
);

/*==============================================================*/
/* Index: shoufeixiangmu_shoufeijilu_FK                         */
/*==============================================================*/
create index shoufeixiangmu_shoufeijilu_FK on financial_history (
   financial_id ASC
);

/*==============================================================*/
/* Index: dianzichufang_shoufeijilu_FK                          */
/*==============================================================*/
create index dianzichufang_shoufeijilu_FK on financial_history (
   outpaitent_regist_id ASC
);

/*==============================================================*/
/* Table: financial_type                                        */
/*==============================================================*/
create table financial_type  (
   financial_type_id     VARCHAR2(225)                  not null,
   financial_type_name  VARCHAR2(225),
   constraint PK_FINANCIAL_TYPE primary key (financial_type_id)
);

/*==============================================================*/
/* Table: fukuan                                                */
/*==============================================================*/
create table fukuan  (
   fukuan_id            INTEGER                         not null,
   fukuan_name          VARCHAR2(225),
   constraint PK_FUKUAN primary key (fukuan_id)
);

/*==============================================================*/
/* Table: fukuan_record                                         */
/*==============================================================*/
create table fukuan_record  (
   fukuan_record_id     INTEGER                         not null,
   fukuan_id            INTEGER,
   supplier_jiesuan_id  VARCHAR2(225),
   fukuan_money         NUMBER(9,2),
   fukuan_remark        VARCHAR2(225),
   constraint PK_FUKUAN_RECORD primary key (fukuan_record_id)
);

/*==============================================================*/
/* Index: yingfu_caifuyingyong_FK                               */
/*==============================================================*/
create index yingfu_caifuyingyong_FK on fukuan_record (
   fukuan_id ASC
);

/*==============================================================*/
/* Index: cw_gongyingshang_FK                                   */
/*==============================================================*/
create index cw_gongyingshang_FK on fukuan_record (
   supplier_jiesuan_id ASC
);

/*==============================================================*/
/* Table: function_type                                         */
/*==============================================================*/
create table function_type  (
   function_type_id     INTEGER                         not null,
   function_type_name   VARCHAR2(20),
   function_type_icon   VARCHAR2(50),
   function_type_show_order INTEGER,
   constraint PK_FUNCTION_TYPE primary key (function_type_id)
);

/*==============================================================*/
/* Table: functions                                             */
/*==============================================================*/
create table functions  (
   functions_id         INTEGER                         not null,
   function_type_id     INTEGER,
   functions_name       VARCHAR2(225),
   functions_icon       VARCHAR2(225),
   functions_href       VARCHAR2(225),
   functions_is_show_left INTEGER,
   functions_show_order INTEGER,
   constraint PK_FUNCTIONS primary key (functions_id)
);

/*==============================================================*/
/* Index: f_type_function_FK                                    */
/*==============================================================*/
create index f_type_function_FK on functions (
   function_type_id ASC
);

/*==============================================================*/
/* Table: hospita_notify                                        */
/*==============================================================*/
create table hospita_notify  (
   hospital_notify_number VARCHAR2(225)                   not null,
   outpaitent_regist_id VARCHAR2(225),
   hospital_notify_state VARCHAR2(225),
   hospital_notify_date DATE,
   hospital_notify_cost NUMBER(9,2),
   hospital_notify_cash_feiyong NUMBER(9,2),
   hospital_notify_cash_yanjin NUMBER(9,2),
   hospital_notify_alert_the_jine NUMBER(9,2),
   hospital_notify_explain VARCHAR2(225),
   constraint PK_HOSPITA_NOTIFY primary key (hospital_notify_number)
);

/*==============================================================*/
/* Index: mzgh_zhuytongzhi_FK                                   */
/*==============================================================*/
create index mzgh_zhuytongzhi_FK on hospita_notify (
   outpaitent_regist_id ASC
);

/*==============================================================*/
/* Table: hospital_registration                                 */
/*==============================================================*/
create table hospital_registration  (
   hospital_registration_id VARCHAR2(225)                   not null,
   bed_id               VARCHAR2(225),
   hospital_notify_number VARCHAR2(225),
   emp_id               INTEGER,
   hospital_registration_state VARCHAR2(225),
   hospital_registration_date DATE,
   constraint PK_HOSPITAL_REGISTRATION primary key (hospital_registration_id)
);

/*==============================================================*/
/* Index: tz_dengji_FK                                          */
/*==============================================================*/
create index tz_dengji_FK on hospital_registration (
   hospital_notify_number ASC
);

/*==============================================================*/
/* Index: bingchuang_dengji_FK                                  */
/*==============================================================*/
create index bingchuang_dengji_FK on hospital_registration (
   bed_id ASC
);

/*==============================================================*/
/* Index: Relationship_157_FK                                   */
/*==============================================================*/
create index Relationship_157_FK on hospital_registration (
   emp_id ASC
);

/*==============================================================*/
/* Table: house_type                                            */
/*==============================================================*/
create table house_type  (
   house_type_id        INTEGER                         not null,
   house_type_name      VARCHAR2(225),
   constraint PK_HOUSE_TYPE primary key (house_type_id)
);

/*==============================================================*/
/* Table: instrument                                            */
/*==============================================================*/
create table instrument  (
   instrument_id        VARCHAR2(225)                   not null,
   instrument_type_id   INTEGER,
   units_id             INTEGER,
   emp_id               INTEGER,
   instrument_name      VARCHAR2(225),
   instrument_qiyong_date DATE,
   instrument_price number(9,2),
   instrument_baofei_date DATE,
   instrument_waijie_num INTEGER,
   instrument_chicun    NUMBER(9,2),
   instrument_remark    VARCHAR2(225),
   instrument_zong_num  integer,
   instrument_sheng_num integer, 
   instruemnt_top integer ,
   instrument_buttom integer,
   constraint PK_INSTRUMENT primary key (instrument_id)
);

/*==============================================================*/
/* Index: qixie_qixie_type_FK                                   */
/*==============================================================*/
create index qixie_qixie_type_FK on instrument (
   instrument_type_id ASC
);

/*==============================================================*/
/* Index: dw_qx_FK                                              */
/*==============================================================*/
create index dw_qx_FK on instrument (
   units_id ASC
);

/*==============================================================*/
/* Index: emp_qixie_FK                                          */
/*==============================================================*/
create index emp_qixie_FK on instrument (
   emp_id ASC
);

/*==============================================================*/
/* Table: instrument_caigou                                     */
/*==============================================================*/
create table instrument_caigou  (
   instrument_caigou_id VARCHAR2(225)                   not null,
   supplier_id          VARCHAR2(225),
   instrument_caigou_state VARCHAR2(225),
   instrument_caigou_dh_date DATE,
   instrument_caigou_gh_date DATE,
   instrument_caigou_money number(9,2),
   instrument_caigou_address VARCHAR2(225),
   constraint PK_INSTRUMENT_CAIGOU primary key (instrument_caigou_id)
);

/*==============================================================*/
/* Index: Relationship_159_FK                                   */
/*==============================================================*/
create index Relationship_159_FK on instrument_caigou (
   supplier_id ASC
);

/*==============================================================*/
/* Table: instrument_caigou_xq                                  */
/*==============================================================*/
create table instrument_caigou_xq  (
   instrument_caigou_xq_id INTEGER                         not null,
   instrument_caigou_id VARCHAR2(225),
   instrument_id        VARCHAR2(225),
   instrument_caigou_xq_price NUMBER(9,2),
   instrument_caigou_xq_num INTEGER,
   instrument_caigou_xq_remark VARCHAR2(225),
   instrument_caigou_xq_ph VARCHAR2(225),
   instrument_caigou_xq_money NUMBER(9,2),
   constraint PK_INSTRUMENT_CAIGOU_XQ primary key (instrument_caigou_xq_id)
);

/*==============================================================*/
/* Index: qixie_qixiecaigoxiangqing_FK                          */
/*==============================================================*/
create index qixie_qixiecaigoxiangqing_FK on instrument_caigou_xq (
   instrument_id ASC
);

/*==============================================================*/
/* Index: qixiecaig11                                           */
/*==============================================================*/
create index qixiecaig11 on instrument_caigou_xq (
   instrument_caigou_id ASC
);

/*==============================================================*/
/* Table: instrument_login                                      */
/*==============================================================*/
create table instrument_login  (
   instrument_login_id  VARCHAR2(225)                   not null,
   instrument_id        VARCHAR2(225),
   instrument_login_pihao VARCHAR2(225),
   instrument_login_num INTEGER,
   instrument_login_caigou_date DATE,
   instrument_login_sc_date DATE,
   instrument_login_baofei_date DATE,
   instrument_login_remark VARCHAR2(225),
   constraint PK_INSTRUMENT_LOGIN primary key (instrument_login_id)
);

/*==============================================================*/
/* Table: instrument_rk                                         */
/*==============================================================*/
create table instrument_rk  (
   instrument_rk_id     VARCHAR2(225)                   not null,
   instrument_ys_id     VARCHAR2(225),
   emp_id               INTEGER,
   qx_returngoos_satae  VARCHAR2(225),
   instrument_rk_date   DATE,
   instrument_rk_rklx   VARCHAR2(225),
   instrument_rk__name  VARCHAR2(225),
   qx_returngoos_pzdh   VARCHAR2(225),
   constraint PK_INSTRUMENT_RK primary key (instrument_rk_id)
);

/*==============================================================*/
/* Index: qixieyansho_qixieruku_FK                              */
/*==============================================================*/
create index qixieyansho_qixieruku_FK on instrument_rk (
   instrument_ys_id ASC
);

/*==============================================================*/
/* Index: emp_ruku_FK                                           */
/*==============================================================*/
create index emp_ruku_FK on instrument_rk (
   emp_id ASC
);

/*==============================================================*/
/* Table: instrument_rk_xq                                      */
/*==============================================================*/
create table instrument_rk_xq  (
   instrument_rk_xqid   INTEGER                         not null,
   instrument_rk_id     VARCHAR2(225),
   instrument_id        VARCHAR2(225),
   instrument_rk_xqnumber NUMBER(9,2),
   instrument_rk_xqpihao VARCHAR2(225),
   instrument_rk_xqcgdate DATE,
   instrument_rk_xqscdate DATE,
   instrument_rk_xqbfdate DATE,
   instrument_rk_xqbeizu VARCHAR2(225),
   constraint PK_INSTRUMENT_RK_XQ primary key (instrument_rk_xqid)
);

/*==============================================================*/
/* Index: qixieruku5                                            */
/*==============================================================*/
create index qixieruku5 on instrument_rk_xq (
   instrument_rk_id ASC
);

/*==============================================================*/
/* Index: qixie_qixierukuxiangqing_FK                           */
/*==============================================================*/
create index qixie_qixierukuxiangqing_FK on instrument_rk_xq (
   instrument_id ASC
);

/*==============================================================*/
/* Table: instrument_type                                       */
/*==============================================================*/
create table instrument_type  (
   instrument_type_id   INTEGER                         not null,
   instrument_type_name VARCHAR2(225),
   constraint PK_INSTRUMENT_TYPE primary key (instrument_type_id)
);

/*==============================================================*/
/* Table: instrument_ys                                         */
/*==============================================================*/
create table instrument_ys  (
   instrument_ys_id     VARCHAR2(225)                   not null,
   instrument_caigou_id VARCHAR2(225),
   instrument_ys_state  VARCHAR2(225),
   instrument_ys_date   DATE,
   instrument_ys_pzdh   VARCHAR2(225),
   constraint PK_INSTRUMENT_YS primary key (instrument_ys_id)
);

/*==============================================================*/
/* Table: instrument_yanshou_xq                                  */
/*==============================================================*/
create table instrument_yanshou_xq  (
   instrument_yanshou_xq_id INTEGER                         not null,
   instrument_ys_id VARCHAR2(225),
   instrument_id        VARCHAR2(225),
    instrument_yanshou_xq_zong_num INTEGER,
	    instrument_yanshou_xq_bhge_num INTEGER,
   instrument_yanshou_xq_hege_num INTEGER,
   instrument_yanshou_xq_remark VARCHAR2(225),
   instrument_yanshou_xq_ph VARCHAR2(225),
   instrument_yanshou_xq_money NUMBER(9,2),
   constraint PK_INSTT_yanshou_xq primary key (instrument_yanshou_xq_id)
);

/*==============================================================*/
/* Index: qixie_qixiecaigoxiangqing_FK                          */
/*==============================================================*/
create index qixie_qicaangqssing_FK on instrument_yanshou_xq (
   instrument_ys_id ASC
);


/*==============================================================*/
/* Index: qixiecaig11                                           */
/*==============================================================*/
create index qixiecaddigsa1 on instrument_yanshou_xq (
   instrument_yanshou_xq_id ASC
);
/*==============================================================*/
/* Index: qixiecaigo_qixieyansho_FK                             */
/*==============================================================*/
create index qixieacaigo_qixieyansho_FK on instrument_ys (
   instrument_caigou_id ASC
);

/*==============================================================*/
/* Table: jianyan                                               */
/*==============================================================*/
create table jianyan  (
   jianyan_id           VARCHAR2(255)                   not null,
   emp_id               INTEGER,
   jianyan_type_id      INTEGER,
   units_id             INTEGER,
   jianyan_name         VARCHAR2(255),
   jianyan_create_date  DATE,
   jianyan_between      VARCHAR2(255),
   jianyan_remark       VARCHAR2(255),
   constraint PK_JIANYAN primary key (jianyan_id)
);

/*==============================================================*/
/* Index: jianyanxiangm17                                       */
/*==============================================================*/
create index jianyanxiangm17 on jianyan (
   jianyan_type_id ASC
);

/*==============================================================*/
/* Index: dw_tjxm_FK                                            */
/*==============================================================*/
create index dw_tjxm_FK on jianyan (
   units_id ASC
);

/*==============================================================*/
/* Index: emp_xm_FK                                             */
/*==============================================================*/
create index emp_xm_FK on jianyan (
   emp_id ASC
);

/*==============================================================*/
/* Table: jianyan_mess                                          */
/*==============================================================*/
create table jianyan_mess  (
   jianyan_mess_id      VARCHAR2(255)                   not null,
   outpaitent_regist_id VARCHAR2(225),
   emp_id               INTEGER,
   jianyan_mess_state   VARCHAR2(255),
   jianyan_mess_date    DATE,
   jianyan_mess_dclass  VARCHAR2(255),
   jianyan_mess_yangben_type VARCHAR2(255),
   constraint PK_JIANYAN_MESS primary key (jianyan_mess_id)
);

/*==============================================================*/
/* Index: emp_jianyan_FK                                        */
/*==============================================================*/
create index emp_jianyan_FK on jianyan_mess (
   emp_id ASC
);

/*==============================================================*/
/* Index: mz_jyan_FK                                            */
/*==============================================================*/
create index mz_jyan_FK on jianyan_mess (
   outpaitent_regist_id ASC
);

/*==============================================================*/
/* Table: jianyan_mess_xq                                       */
/*==============================================================*/
create table jianyan_mess_xq  (
   jianyan_mess_xq_id   INTEGER                         not null,
   jianyan_mess_id      VARCHAR2(255),
   jianyan_id           VARCHAR2(255),
   jianyan_mess_xq_between VARCHAR2(255),
   jianyan_mess_xq_result VARCHAR2(255),
   jianyan_mess_xq      VARCHAR2(255),
   constraint PK_JIANYAN_MESS_XQ primary key (jianyan_mess_xq_id)
);

/*==============================================================*/
/* Index: jianyan_jianyanxiangqing_FK                           */
/*==============================================================*/
create index jianyan_jianyanxiangqing_FK on jianyan_mess_xq (
   jianyan_mess_id ASC
);

/*==============================================================*/
/* Index: jianyanxiangmu16                                      */
/*==============================================================*/
create index jianyanxiangmu16 on jianyan_mess_xq (
   jianyan_id ASC
);

/*==============================================================*/
/* Table: jianyan_type                                          */
/*==============================================================*/
create table jianyan_type  (
   jianyan_type_id      INTEGER                         not null,
   jianyan_type_name    VARCHAR2(255),
   constraint PK_JIANYAN_TYPE primary key (jianyan_type_id)
);

/*==============================================================*/
/* Table: login_logger                                          */
/*==============================================================*/
create table login_logger  (
   login_logger         INTEGER                         not null,
   emp_id               INTEGER,
   login_date           DATE,	
   login_times varchar2(255),
   constraint PK_LOGIN_LOGGER primary key (login_logger)
);

/*==============================================================*/
/* Index: yg_denglurizhi_FK                                     */
/*==============================================================*/
create index yg_denglurizhi_FK on login_logger (
   emp_id ASC
);

/*==============================================================*/
/* Table: qian_dao                                          */
/*==============================================================*/
create table qian_dao  (
   qian_dao_id         INTEGER                         not null,
   qian_dao_date           DATE,	
   emp_id    INTEGER , 
   qian_dao_times varchar2(255),
   constraint pk_qian_dao primary key (qian_dao_id)
);

alter table qian_dao add constraint fk_qian_dao foreign key(emp_id) references emp(emp_id);

/*==============================================================*/
/* Table: medical_card                                          */
/*==============================================================*/
create table medical_card  (
   medical_card_card_id VARCHAR2(225)                   not null,
   medical_card_name    VARCHAR2(225),
   medical_card_sex     VARCHAR2(225),
   medical_card_age     VARCHAR2(225),
   medical_card_idencard VARCHAR2(225),
   medical_card_hunyanzk VARCHAR2(225),
   medical_card_bingzhuang VARCHAR2(225),
   medical_card_date Date,
   emp_id               INTEGER   ,
   constraint PK_MEDICAL_CARD primary key (medical_card_card_id)
);

/*==============================================================*/
/* Table: outpaitent_regist                                     */
/*==============================================================*/
create table outpaitent_regist  (
   outpaitent_regist_id VARCHAR2(225)                   not null,
   dclass_id            INTEGER,
   emp_id               INTEGER,
   medical_card_card_id VARCHAR2(225),
   outpaitent_regist_zhuangtai VARCHAR2(225),
   outpaitent_regist_guahaodate DATE,
   outpaitent_regist_guahaotime VARCHAR2(225),
   outpaitent_regist_liushuihao INTEGER,
   outpaitent_regist_type VARCHAR2(225),
   outpaitent_regist_binglihao VARCHAR2(225),
   constraint PK_OUTPAITENT_REGIST primary key (outpaitent_regist_id)
);

/*==============================================================*/
/* Index: yg_guahao_FK                                          */
/*==============================================================*/
create index yg_guahao_FK on outpaitent_regist (
   emp_id ASC
);

/*==============================================================*/
/* Index: yg_guahao_FK                                          */
/*==============================================================*/
create index medical_card_emp_s on medical_card (
   emp_id ASC
);
/*==============================================================*/
/* Index: keshi_guahao_FK                                       */
/*==============================================================*/
create index keshi_guahao_FK on outpaitent_regist (
   dclass_id ASC
);

/*==============================================================*/
/* Index: zl_guahao_FK                                          */
/*==============================================================*/
create index zl_guahao_FK on outpaitent_regist (
   medical_card_card_id ASC
);

/*==============================================================*/
/* Table: pharmace_return                                       */
/*==============================================================*/
create table pharmace_return  (
   Pharmace_return_id   VARCHAR2(255)                   not null,
   outpaitent_regist_id VARCHAR2(225),
   prescription_id      VARCHAR2(225),
   Pharmace_return_zt   VARCHAR2(255),
   Pharmace_return_yf   VARCHAR2(255),
   Pharmace_return_tydate DATE,
   Pharmace_return_brname VARCHAR2(255),
   Pharmacy_return_tkje number(9,2),
   constraint PK_PHARMACE_RETURN primary key (Pharmace_return_id)
);

/*==============================================================*/
/* Index: Relationship_154_FK                                   */
/*==============================================================*/
create index Relationship_154_FK on pharmace_return (
   outpaitent_regist_id ASC
);

/*==============================================================*/
/* Index: Relationship_155_FK                                   */
/*==============================================================*/
create index Relationship_155_FK on pharmace_return (
   prescription_id ASC
);

/*==============================================================*/
/* Table: pharmacy_inventory                                    */
/*==============================================================*/
create table pharmacy_inventory  (
   Pharmacy_inventory_id VARCHAR2(255)                   not null,
   Pharmacy_inventory_zt VARCHAR2(255),
   Pharmacy_inventory_pddate DATE,
   Pharmacy_inventory_yf VARCHAR2(255),
   constraint PK_PHARMACY_INVENTORY primary key (Pharmacy_inventory_id)
);

/*==============================================================*/
/* Table: pharmacy_inventory_detalis                            */
/*==============================================================*/
create table pharmacy_inventory_detalis  (
   pharmacy_inventory_detalis_id VARCHAR2(255)                   not null,
   Pharmacy_inventory_id VARCHAR2(255),
   drug_id              VARCHAR2(225),
   Pharmacy_id_jcnum    INTEGER,
   Pharmacy_inventory_detalis_dj number(9,2),
   Pharmacy_id_kynum    INTEGER,
   Pharmacy_id_kyje     number(9,2),
   Pharmacy_inventory_detalis_ph VARCHAR2(255),
   constraint PK_PHARMACY_INVENTORY_DETALIS primary key (pharmacy_inventory_detalis_id)
);

/*==============================================================*/
/* Index: yp_yfpd_xq_FK                                         */
/*==============================================================*/
create index yp_yfpd_xq_FK on pharmacy_inventory_detalis (
   drug_id ASC
);

/*==============================================================*/
/* Index: yfpd_xq_yfpd_FK                                       */
/*==============================================================*/
create index yfpd_xq_yfpd_FK on pharmacy_inventory_detalis (
   Pharmacy_inventory_id ASC
);

/*==============================================================*/
/* Table: pharmacy_recipients                                   */
/*==============================================================*/
create table pharmacy_recipients  (
   Pharmacy_recipients_id VARCHAR2(255)                   not null,
   Pharmacy_recipients_zt VARCHAR2(255),
   Pharmacy_recipients_yf VARCHAR2(255),
   Pharmacy_recipients_lydate DATE,
   Pharmacy_recipients_duixiang VARCHAR2(255),
   Pharmacy_recipients_dx VARCHAR2(255),
   constraint PK_PHARMACY_RECIPIENTS primary key (Pharmacy_recipients_id)
);

/*==============================================================*/
/* Table: pharmacy_recipients_detalis                           */
/*==============================================================*/
create table pharmacy_recipients_detalis  (
   pharmacy_recipients_detalis_id VARCHAR2(255)                   not null,
   Pharmacy_recipients_id VARCHAR2(255),
   drug_id              VARCHAR2(225),
   Pharmacy_num         INTEGER,
   Pharmacy_recipients_detalis_ph VARCHAR2(255),
   Pharmacy_ricipients_detalis_bz VARCHAR2(255),
   constraint PK_PHARMACY_RECIPIENTS_DETALIS primary key (pharmacy_recipients_detalis_id)
);

/*==============================================================*/
/* Index: yp_yply_xq_FK                                         */
/*==============================================================*/
create index yp_yply_xq_FK on pharmacy_recipients_detalis (
   drug_id ASC
);

/*==============================================================*/
/* Index: yply_yply_xq_FK                                       */
/*==============================================================*/
create index yply_yply_xq_FK on pharmacy_recipients_detalis (
   Pharmacy_recipients_id ASC
);

/*==============================================================*/
/* Table: pharmacy_return_detalis                               */
/*==============================================================*/
create table pharmacy_return_detalis  (
   pharmacy_return_detalis_id VARCHAR2(255)                   not null,
   drug_id              VARCHAR2(225),
   Pharmace_return_id   VARCHAR2(255),
   Pharmacy_return_detalis_num INTEGER,
   Pharmacy_return_detalis_dj number(9,2),
   Pharmacy_return_detalis_je number(9,2),
   Pharmacy_return_detalis_ph VARCHAR2(255),
   Pharmacy_return_detalis_zt VARCHAR2(255),
   Pharmacy_return_detalis_bz VARCHAR2(255),
   constraint PK_PHARMACY_RETURN_DETALIS primary key (pharmacy_return_detalis_id)
);

/*==============================================================*/
/* Index: yp_yfty_xq_FK                                         */
/*==============================================================*/
create index yp_yfty_xq_FK on pharmacy_return_detalis (
   drug_id ASC
);

/*==============================================================*/
/* Index: yfty_yfty_xq_FK                                       */
/*==============================================================*/
create index yfty_yfty_xq_FK on pharmacy_return_detalis (
   Pharmace_return_id ASC
);

/*==============================================================*/
/* Table: pharmacy_warehouse_detalis                            */
/*==============================================================*/
create table pharmacy_warehouse_detalis  (
   pharmacy_warehouse_detalis_id VARCHAR2(255)                   not null,
   drug_id              VARCHAR2(225),
   Pharmacy_warehouse_id VARCHAR2(255),
   Pharmacy_warehouse_detalis_num INTEGER,
   Pharmacy_warehouse_detalis_dj number(9,2),
   Pharmacy_warehouse_detalis_je number(9,2),
   Pharmacy_wd_bzqz     DATE,
   Pharmacy_wd_scrq     DATE,
   Pharmacy_warehouse_detalis_ph VARCHAR2(255),
   Pharmacy_warehouse_detalis_bz VARCHAR2(255),
   constraint PK_PHARMACY_WAREHOUSE_DETALIS primary key (pharmacy_warehouse_detalis_id)
);

/*==============================================================*/
/* Index: yp_yfrk_xq_FK                                         */
/*==============================================================*/
create index yp_yfrk_xq_FK on pharmacy_warehouse_detalis (
   drug_id ASC
);

/*==============================================================*/
/* Index: yfrk_yfrk_xq_FK                                       */
/*==============================================================*/
create index yfrk_yfrk_xq_FK on pharmacy_warehouse_detalis (
   Pharmacy_warehouse_id ASC
);

/*==============================================================*/
/* Table: prescription                                          */
/*==============================================================*/
create table prescription  (
   prescription_id   VARCHAR2(225)                           not null,
   outpaitent_regist_id VARCHAR2(225),
   emp_id               INTEGER,
   hospital_registration_id VARCHAR2(225),
   pre_prescription_id  VARCHAR2(225),
   prescription_zt      VARCHAR2(225),
   prescription_yzzx    VARCHAR2(225),
   prescription_date    DATE,
   prescription_type    VARCHAR2(225),
   constraint PK_PRESCRIPTION primary key (prescription_id)
);

/*==============================================================*/
/* Index: mz_dizichufan_FK                                      */
/*==============================================================*/
create index mz_dizichufan_FK on prescription (
   outpaitent_regist_id ASC
);

/*==============================================================*/
/* Index: yg_dizichufan_FK                                      */
/*==============================================================*/
create index yg_dizichufan_FK on prescription (
   emp_id ASC
);

/*==============================================================*/
/* Index: Relationship_102_FK                                   */
/*==============================================================*/
create index Relationship_102_FK on prescription (
   pre_prescription_id ASC
);

/*==============================================================*/
/* Index: zhuyuandengji_dianzichufang_FK                        */
/*==============================================================*/
create index zhuyuandengji_dianzichufang_FK on prescription (
   hospital_registration_id ASC
);

/*==============================================================*/
/* Table: prescription_recode                                   */
/*==============================================================*/
create table prescription_recode  (
   prescription_recode_id VARCHAR2(225)                   not null,
   drug_id              VARCHAR2(225),
   prescription_recode_type VARCHAR2(225),
   prescription_recode_num INTEGER,
   prescription_id      VARCHAR2(225) , 
   prescription_recode_money NUMBER(9,2),
   prescription_recode_zt VARCHAR2(225),
   prescription_recode_price NUMBER(9,2),
   prescription_recode_explain VARCHAR2(225),
   prescription_recode_drug_type VARCHAR2(225),
   prescription_recode_rq DATE,
   prescription_recode_sj VARCHAR2(225),
   constraint PK_PRESCRIPTION_RECODE primary key (prescription_recode_id)
);
create index dasdadassdsadx on prescription_recode (
   prescription_id ASC
);
/*==============================================================*/
/* Index: Relationship_156_FK                                   */
/*==============================================================*/
create index Relationship_156_FK on prescription_recode (
   drug_id ASC
);

/*==============================================================*/
/* Table: prescription_type                                     */
/*==============================================================*/
create table prescription_type  (
   prespriced_id        VARCHAR2(225)                   not null,
   prescription_id      VARCHAR2(225),
   emp_id               INTEGER,
   outpaitent_regist_id VARCHAR2(225),
   prespriced_zt        VARCHAR2(225),
   prespricedn_date     DATE,
   prespriced_zongfeiyong NUMBER(9,2),
   prespriced_ysje      NUMBER(9,2),
   constraint PK_PRESCRIPTION_TYPE primary key (prespriced_id)
);

/*==============================================================*/
/* Index: yg_huaijia_FK                                         */
/*==============================================================*/
create index yg_huaijia_FK on prescription_type (
   emp_id ASC
);

/*==============================================================*/
/* Index: mz_huaijia_FK                                         */
/*==============================================================*/
create index mz_huaijia_FK on prescription_type (
   outpaitent_regist_id ASC
);

/*==============================================================*/
/* Index: dianzichufang_huajia_FK                               */
/*==============================================================*/
create index dianzichufang_huajia_FK on prescription_type (
   prescription_id ASC
);

/*==============================================================*/
/* Table: qx_lnventory                                          */
/*==============================================================*/
create table qx_lnventory  (
   qx_lnventory_id      VARCHAR2(225)                   not null,
   qx_lnventory_state   INTEGER,
   qx_lnventory_date    DATE,
   qx_lnventory_Warehouse VARCHAR2(225),
   constraint PK_QX_LNVENTORY primary key (qx_lnventory_id)
);

/*==============================================================*/
/* Table: qx_lnventoryqx                                        */
/*==============================================================*/
create table qx_lnventoryqx  (
   qx_lnventoryqx_id    INTEGER                         not null,
   qx_lnventory_id      VARCHAR2(225),
   instrument_id        VARCHAR2(225),
   qx_lnventoryqx_pihao INTEGER,
   qx_lnventoryqx_beizu VARCHAR2(225),
   qx_lnventoryqx_num   INTEGER,
   qx_lnventoryqx_yk_num INTEGER,
   constraint PK_QX_LNVENTORYQX primary key (qx_lnventoryqx_id)
);

/*==============================================================*/
/* Index: qixiepandian7                                         */
/*==============================================================*/
create index qixiepandian7 on qx_lnventoryqx (
   qx_lnventory_id ASC
);

/*==============================================================*/
/* Index: qixie_qixiepandianxiagqing_FK                         */
/*==============================================================*/
create index qixie_qixiepandianxiagqing_FK on qx_lnventoryqx (
   instrument_id ASC
);

/*==============================================================*/
/* Table: qx_return                                             */
/*==============================================================*/
create table qx_return  (
   qx_return_id         VARCHAR2(225)                   not null,
   qx_return_state      VARCHAR2(225),
   qx_return_date       DATE,
   qx_return_Warehouse  VARCHAR2(225),
   qx_return_duixiang   VARCHAR2(225),
   qx_return_keshi      VARCHAR2(225),
   constraint PK_QX_RETURN primary key (qx_return_id)
);

/*==============================================================*/
/* Table: qx_returngoos                                         */
/*==============================================================*/
create table qx_returngoos  (
   qx_returngoos_id     VARCHAR2(225)                   not null,
   supplier_id          VARCHAR2(225),
   instrument_ys_id     VARCHAR2(225),
   qx_returngoos_satae  VARCHAR2(225),
   qx_returngoos_date   DATE,
   qx_returngoos_pzdh   VARCHAR2(225),
   qx_returngoos_money  NUMBER(9,2),
   constraint PK_QX_RETURNGOOS primary key (qx_returngoos_id)
);

/*==============================================================*/
/* Index: qixieyansho_qixietuihuo_FK                            */
/*==============================================================*/
create index qixieyansho_qixietuihuo_FK on qx_returngoos (
   instrument_ys_id ASC
);

/*==============================================================*/
/* Index: Relationship_160_FK                                   */
/*==============================================================*/
create index Relationship_160_FK on qx_returngoos (
   supplier_id ASC
);

/*==============================================================*/
/* Table: qx_returngoosqx                                       */
/*==============================================================*/
create table qx_returngoosqx  (
   qx_returngoosqx_id   INTEGER                         not null,
   instrument_id        VARCHAR2(225),
   qx_returngoos_id     VARCHAR2(225),
   qx_returngoosqx_number NUMBER(9,2),
   qx_returngoosqx_money NUMBER(9,2),
   qx_returngoosqx_beizu VARCHAR2(225),
   qx_returngoosqx_price NUMBER(9,2),
   qx_returngoosqx_xqpihao VARCHAR2(225),
   constraint PK_QX_RETURNGOOSQX primary key (qx_returngoosqx_id)
);

/*==============================================================*/
/* Index: qixietuihuo10                                         */
/*==============================================================*/
create index qixietuihuo10 on qx_returngoosqx (
   qx_returngoos_id ASC
);

/*==============================================================*/
/* Index: qixie_qixietuihuoxiangqing_FK                         */
/*==============================================================*/
create index qixie_qixietuihuoxiangqing_FK on qx_returngoosqx (
   instrument_id ASC
);

/*==============================================================*/
/* Table: qx_returnqx                                           */
/*==============================================================*/
create table qx_returnqx  (
   qx_returnqx_id       INTEGER                         not null,
   qx_return_id         VARCHAR2(225),
   instrument_id        VARCHAR2(225),
   qx_returnqx_pihao    INTEGER,
   qx_returnqx_beizu    VARCHAR2(225),
   qx_returnqx_number   INTEGER,
   constraint PK_QX_RETURNQX primary key (qx_returnqx_id)
);

/*==============================================================*/
/* Index: qixiehuanhui9                                         */
/*==============================================================*/
create index qixiehuanhui9 on qx_returnqx (
   qx_return_id ASC
);

/*==============================================================*/
/* Index: qixie_qixiehuanhuixiangqing_FK                        */
/*==============================================================*/
create index qixie_qixiehuanhuixiangqing_FK on qx_returnqx (
   instrument_id ASC
);

/*==============================================================*/
/* Table: qx_thelibrary                                         */
/*==============================================================*/
create table qx_thelibrary  (
   qx_thelibrary_id     VARCHAR2(225)                   not null,
   emp_id               INTEGER,
   qx_thelibrary_type   VARCHAR2(225),
   qx_thelibrary_date   DATE,
   qx_thelibrary_duixiang VARCHAR2(225),
   qx_thelibrary_state  VARCHAR2(225),
   qx_thelibrary_Warehouse VARCHAR2(225),
   qx_thelibrary_pz_id  VARCHAR2(225),
   constraint PK_QX_THELIBRARY primary key (qx_thelibrary_id)
);

/*==============================================================*/
/* Index: emp_chuku_FK                                          */
/*==============================================================*/
create index emp_chuku_FK on qx_thelibrary (
   emp_id ASC
);

/*==============================================================*/
/* Table: qx_thelibraryqx                                       */
/*==============================================================*/
create table qx_thelibraryqx  (
   qx_thelibraryqx_id   INTEGER                         not null,
   qx_thelibrary_id     VARCHAR2(225),
   instrument_id        VARCHAR2(225),
   qx_thelibraryqx_number INTEGER,
   qx_thelibraryqx_money NUMBER(9,2),
   qx_thelibraryqx_beizu VARCHAR2(225),
   qx_thelibraryqx_pihao VARCHAR2(225),
   constraint PK_QX_THELIBRARYQX primary key (qx_thelibraryqx_id)
);

/*==============================================================*/
/* Index: qixiechuku6                                           */
/*==============================================================*/
create index qixiechuku6 on qx_thelibraryqx (
   qx_thelibrary_id ASC
);

/*==============================================================*/
/* Index: qixie_qixiechukuxiangqing_FK                          */
/*==============================================================*/
create index qixie_qixiechukuxiangqing_FK on qx_thelibraryqx (
   instrument_id ASC
);

/*==============================================================*/
/* Table: qx_use                                                */
/*==============================================================*/
create table qx_use  (
   qx_use_id            VARCHAR2(225)                   not null,
   qx_use_state         VARCHAR2(225),
   qx_use_date          DATE,
   qx_use_Warehouse     VARCHAR2(225),
   qx_use_keshi         VARCHAR2(225),
   qx_use_duix          VARCHAR2(225),
   constraint PK_QX_USE primary key (qx_use_id)
);

/*==============================================================*/
/* Table: qx_useqx                                              */
/*==============================================================*/
create table qx_useqx  (
   qx_useqx_id          INTEGER                         not null,
   instrument_id        VARCHAR2(225),
   qx_use_id            VARCHAR2(225),
   qx_useqx_lyshul      INTEGER,
   qx_useqx_jcshul      INTEGER,
   qx_useqx_pihao       INTEGER,
   qx_useqx_beizu       VARCHAR2(225),
   constraint PK_QX_USEQX primary key (qx_useqx_id)
);

/*==============================================================*/
/* Index: qixielingyong12                                       */
/*==============================================================*/
create index qixielingyong12 on qx_useqx (
   qx_use_id ASC
);

/*==============================================================*/
/* Index: qixie_13                                              */
/*==============================================================*/
create index qixie_13 on qx_useqx (
   instrument_id ASC
);

/*==============================================================*/
/* Table: rece                                                  */
/*==============================================================*/
create table rece  (
   rece_id              INTEGER                         not null,
   rece_name            VARCHAR2(225),
   constraint PK_RECE primary key (rece_id)
);

/*==============================================================*/
/* Table: rece_record                                           */
/*==============================================================*/
create table rece_record  (
   rece_record_id       INTEGER                         not null,
   rece_id              INTEGER,
   charge_jiesuan_id    INTEGER,
   rece_money           NUMBER(9,2),
   rece_remark          VARCHAR2(225),
   constraint PK_RECE_RECORD primary key (rece_record_id)
);

/*==============================================================*/
/* Index: yingfu_caiwuyingshou_FK                               */
/*==============================================================*/
create index yingfu_caiwuyingshou_FK on rece_record (
   rece_id ASC
);

/*==============================================================*/
/* Index: shofeijs_cawujilu_FK                                  */
/*==============================================================*/
create index shofeijs_cawujilu_FK on rece_record (
   charge_jiesuan_id ASC
);

/*==============================================================*/
/* Table: roles                                                 */
/*==============================================================*/
create table roles  (
   roles_id             INTEGER                         not null,
   roles_name           VARCHAR2(225),
   roles_effect         VARCHAR2(225),
   roles_date           DATE,
   constraint PK_ROLES primary key (roles_id)
);

/*==============================================================*/
/* Table: rush_fee                                              */
/*==============================================================*/
create table rush_fee  (
   rush_fee_id          VARCHAR2(225)                   not null,
   hospital_registration_id VARCHAR2(225),
   rush_fee_state       VARCHAR2(225),
   rush_fee_date        DATE,
   rush_fee_hospital_rental NUMBER(9,2),
   rush_fee_settle      NUMBER(9,2),
   rush_fee_worth_of_value NUMBER(9,2),
   rush_fee_limit_payment_date DATE,
   rush_fee_remark      VARCHAR2(225),
   constraint PK_RUSH_FEE primary key (rush_fee_id)
);

/*==============================================================*/
/* Index: dengji_yajinshoufei_FK                                */
/*==============================================================*/
create index dengji_yajinshoufei_FK on rush_fee (
   hospital_registration_id ASC
);

/*==============================================================*/
/* Table: rush_shouqu                                           */
/*==============================================================*/
create table rush_shouqu  (
   rush_shouqu_id       VARCHAR2(225)                   not null,
   emp_id               INTEGER,
   hospital_notify_number VARCHAR2(225),
   hospital_registration_id VARCHAR2(225),
   rush_shouqu_state    VARCHAR2(225),
   rush_shouqu_date     DATE,
   rush_shouqu_yingshou_money NUMBER(9,2),
   rush_shouqu_yushou_money NUMBER(9,2),
   constraint PK_RUSH_SHOUQU primary key (rush_shouqu_id)
);

/*==============================================================*/
/* Index: tz_yanjishoqu_FK                                      */
/*==============================================================*/
create index tz_yanjishoqu_FK on rush_shouqu (
   hospital_notify_number ASC
);

/*==============================================================*/
/* Index: dengji_yajinshouqu_FK                                 */
/*==============================================================*/
create index dengji_yajinshouqu_FK on rush_shouqu (
   hospital_registration_id ASC
);

/*==============================================================*/
/* Index: emp_yajinshouqu_FK                                    */
/*==============================================================*/
create index emp_yajinshouqu_FK on rush_shouqu (
   emp_id ASC
);

/*==============================================================*/
/* Table: settle_way                                            */
/*==============================================================*/
create table settle_way  (
   settle_way_id        VARCHAR2(225)                   not null,
   settle_way_name      VARCHAR2(225),
   constraint PK_SETTLE_WAY primary key (settle_way_id)
);

/*==============================================================*/
/* Table: shoushu                                               */
/*==============================================================*/
create table shoushu  (
   shoushu_id           VARCHAR2(255)                   not null,
   dclass_id            INTEGER,
   shoushu_type_id      INTEGER,
   emp_id               INTEGER,
   shoushu_name         VARCHAR2(255),
   shoushu_type         VARCHAR2(255),
   shoushu_explain      VARCHAR2(255),
   shoushu_remark       VARCHAR2(255),
   constraint PK_SHOUSHU primary key (shoushu_id)
);

/*==============================================================*/
/* Index: shoushushifenlei_shoushushi_FK                        */
/*==============================================================*/
create index shoushushifenlei_shoushushi_FK on shoushu (
   shoushu_type_id ASC
);

/*==============================================================*/
/* Index: keshi_shoshu_FK                                       */
/*==============================================================*/
create index keshi_shoshu_FK on shoushu (
   dclass_id ASC
);

/*==============================================================*/
/* Index: emp_shoushushi_FK                                     */
/*==============================================================*/
create index emp_shoushushi_FK on shoushu (
   emp_id ASC
);

/*==============================================================*/
/* Table: shoushu_mess                                          */
/*==============================================================*/
create table shoushu_mess  (
   shoushu_mess         VARCHAR2(255)                   not null,
   emp_id               INTEGER,
   shoushu_id           VARCHAR2(255),
   hospital_registration_id VARCHAR2(225),
   shoushu_mess_state   VARCHAR2(255),
   shoushu_mess_date    DATE,
   shoushu_mess_type    VARCHAR2(255),
   shoushu_mess_money   NUMBER(9,2),
   constraint PK_SHOUSHU_MESS primary key (shoushu_mess)
);
drop table shoushu_mess_xq;
/*手术详情表*/
create table shoushu_mess_xq (
	shoushu_mess_xq_id  INTEGER   not null,
	shoushu_mess_xq_name VARCHAR2(255) ,
	shoushu_mess VARCHAR2(255) ,         
	shoushu_mess_xq_type varchar2(255),
	shoushu_mess_xq_num number(9 , 2), 
	shoushu_mess_xq_price number(9 , 2), 
	shoushu_mess_xq_money number(9 , 2), 
	shoushu_mess_xq_result varchar2(255),
	constraint shoushu_mess_xq_id_pk primary key (shoushu_mess_xq_id)
);

alter table shoushu_mess_xq add constraint fk_shoushu_mess_fk2 foreign key(shoushu_mess) references shoushu_mess(shoushu_mess);

/*==============================================================*/
/* Index: sohushushi_shoushizhiliao_FK                          */
/*==============================================================*/
create index sohushushi_shoushizhiliao_FK on shoushu_mess (
   shoushu_id ASC
);

/*==============================================================*/
/* Index: emp_sszl_FK                                           */
/*==============================================================*/
create index emp_sszl_FK on shoushu_mess (
   emp_id ASC
);

/*==============================================================*/
/* Index: zhuyuan_dengji_shoushu_FK                             */
/*==============================================================*/
create index zhuyuan_dengji_shoushu_FK on shoushu_mess (
   hospital_registration_id ASC
);

/*==============================================================*/
/* Table: shoushu_type                                          */
/*==============================================================*/
create table shoushu_type  (
   shoushu_type_id      INTEGER                         not null,
   shoushu_type_name    VARCHAR2(255),
   constraint PK_SHOUSHU_TYPE primary key (shoushu_type_id)
);

/*==============================================================*/
/* Table: supplier                                              */
/*==============================================================*/
create table supplier  (
   supplier_id          VARCHAR2(225)                   not null,
   supplier_type_id     INTEGER,
   supplier_jc          VARCHAR2(225),
   supplier_name        VARCHAR2(225),
   supplier_issh        INTEGER,
   supplier_gsxz        VARCHAR2(225),
   supplier_bgdz        VARCHAR2(225),
   supplier_jzfs        VARCHAR2(225),
   supplier_shfs        VARCHAR2(225),
   supplier_burman      VARCHAR2(225),
   supplier_pd          VARCHAR2(225),
   supplier_fkfs        VARCHAR2(225),
   supplier_address     VARCHAR2(225),
   supplier_sm          VARCHAR2(225),
   supplier_lxr         VARCHAR2(225),
   supplier_phone       VARCHAR2(225),
   constraint PK_SUPPLIER primary key (supplier_id)
);

/*==============================================================*/
/* Index: "supplier--->supplier_type_FK"                        */
/*==============================================================*/
create index "supplier--->supplier_type_FK" on supplier (
   supplier_type_id ASC
);

/*==============================================================*/
/* Table: supplier_jiesuan                                      */
/*==============================================================*/
create table supplier_jiesuan  (
   supplier_jiesuan_id  VARCHAR2(225)                   not null,
   settle_way_id        VARCHAR2(225),
   emp_id               INTEGER,
   supplier_jiesuan_state INTEGER,
   supplier_jiesuan_type INTEGER,
   supplier_jiesuan_date DATE,
   deal_money           NUMBER(9,2),
   outo_money           NUMBER(9,2),
   supplier_jiesuan_remark VARCHAR2(225),
   supplier_jiesuan_invoice VARCHAR2(225),
   supplier_jiesuan_time VARCHAR2(255),
   constraint PK_SUPPLIER_JIESUAN primary key (supplier_jiesuan_id)
);

/*==============================================================*/
/* Index: gong_jiesuan_FK                                       */
/*==============================================================*/
create index gong_jiesuan_FK on supplier_jiesuan (
   settle_way_id ASC
);

/*==============================================================*/
/* Index: emp_gys_FK                                            */
/*==============================================================*/
create index emp_gys_FK on supplier_jiesuan (
   emp_id ASC
);

/*==============================================================*/
/* Table: supplier_type                                         */
/*==============================================================*/
create table supplier_type  (
   supplier_type_id     INTEGER                         not null,
   supplier_type_name   VARCHAR2(225),
   constraint PK_SUPPLIER_TYPE primary key (supplier_type_id)
);

/*==============================================================*/
/* Table: units                                                 */
/*==============================================================*/
create table units  (
   units_id             INTEGER                         not null,
   units_name           VARCHAR2(225),
   constraint PK_UNITS primary key (units_id)
);

/*==============================================================*/
/* Table: user_roles                                            */
/*==============================================================*/
create table user_roles  (
   emp_id               INTEGER                         not null,
   roles_id             INTEGER                         not null,
   constraint PK_USER_ROLES primary key (emp_id, roles_id)
);

/*==============================================================*/
/* Table: roles_functions                                 */
/*==============================================================*/
create table roles_functions  (
   functions_id          INTEGER                        not null,
   roles_id             INTEGER                         not null,
   constraint PK_ROLES_FUNCTIONS primary key (functions_id, roles_id)
);
/*==============================================================*/
/* Index: "员工<——>角色_FK"                                         */
/*==============================================================*/
create index "员工<——>角色_FK" on user_roles (
   emp_id ASC
);


/*==============================================================*/
/* Index: "员工<——>角色2_FK"                                        */
/*==============================================================*/
create index "员工<——>角色2_FK" on user_roles (
   roles_id ASC
);


create index "功能<——>角色_FK" on roles_functions (
   functions_id ASC
);

create index "功能<——>角色2_FK" on roles_functions (
   roles_id ASC
);

/*==============================================================*/
/* Table: yajin_tuifei                                          */
/*==============================================================*/
create table yajin_tuifei  (
   yajin_tuifei_id      VARCHAR2(225)                   not null,
   emp_id               INTEGER,
   chuyuan_inform_id    VARCHAR2(225),
   yajin_tuifei_state   VARCHAR2(225),
   yajin_tuifei_remark  VARCHAR2(225),
   yajin_tuifei_yue     NUMBER(9,2),
   yajin_tuifei_yt_jine NUMBER(9,2),
   yajin_tuifei_st_jine NUMBER(9,2),
   constraint PK_YAJIN_TUIFEI primary key (yajin_tuifei_id)
);

/*==============================================================*/
/* Index: tzhi_tuifei_FK                                        */
/*==============================================================*/
create index tzhi_tuifei_FK on yajin_tuifei (
   chuyuan_inform_id ASC
);

/*==============================================================*/
/* Index: emp_yjtf_FK                                           */
/*==============================================================*/
create index emp_yjtf_FK on yajin_tuifei (
   emp_id ASC
);

/*==============================================================*/
/* Table: yaofang_ruku                                          */
/*==============================================================*/
create table yaofang_ruku  (
   Pharmacy_warehouse_id VARCHAR2(255)                   not null,
   emp_id               INTEGER,
   emp_emp_id           INTEGER,
   Pharmacy_warehouse_zt VARCHAR2(255),
   Pharmacy_warehouse_rkdate DATE,
   Pharmacy_warehouse_zje VARCHAR2(255),
   constraint PK_YAOFANG_RUKU primary key (Pharmacy_warehouse_id)
);

/*==============================================================*/
/* Index: emp_yfrk_FK                                           */
/*==============================================================*/
create index emp_yfrk_FK on yaofang_ruku (
   emp_id ASC
);

/*==============================================================*/
/* Index: Relationship_153_FK                                   */
/*==============================================================*/
create index Relationship_153_FK on yaofang_ruku (
   emp_emp_id ASC
);

/*==============================================================*/
/* Table: yaoku_kucun                                           */
/*==============================================================*/
create table yaoku_kucun  (
   yaoku_kucun_id       INTEGER                         not null,
   yaoku_kucun_top      INTEGER,
   yaoku_kucun_bottom   INTEGER,
   yaoku_kucun_num      INTEGER,
   yaofang_kucun_num   INTEGER ,
   yaofang_kucun_top      INTEGER,
   yaofang_kucun_bottom   INTEGER,
   yaofang_kaiyao_num  INTEGER,
   yaofang_kaiyao_shengyu_num INTEGER,
   constraint PK_YAOKU_KUCUN primary key (yaoku_kucun_id)
);

/*==============================================================*/
/* Table: zhiliao_jizhang                                       */
/*==============================================================*/
create table zhiliao_jizhang  (
   zhiliao_jizhang_id   VARCHAR2(225)                   not null,
   emp_id               INTEGER,
   hospital_registration_id VARCHAR2(225),
   zhiliao_jizhang_state VARCHAR2(225),
   zhiliao_jizhang_date DATE,
   zhiliao_jizhang_sate VARCHAR2(225),
   constraint PK_ZHILIAO_JIZHANG primary key (zhiliao_jizhang_id)
);

/*==============================================================*/
/* Index: zhuyuandengji2                                        */
/*==============================================================*/
create index zhuyuandengji2 on zhiliao_jizhang (
   hospital_registration_id ASC
);

/*==============================================================*/
/* Index: emp_zljz_FK                                           */
/*==============================================================*/
create index emp_zljz_FK on zhiliao_jizhang (
   emp_id ASC
);

/*==============================================================*/
/* Table: zhiliao_jizhang_xq                                    */
/*==============================================================*/
create table zhiliao_jizhang_xq  (
   zhiliao_jizhang_xq_id INTEGER                         not null,
   zhiliao_jizhang_id   VARCHAR2(225),
   zhiliao_jizhang_xq_date DATE,
   zhiliao_jizhang_xq_time VARCHAR2(225),
   financial_id         VARCHAR2(225),
   prescription_id      VARCHAR2(225),
   zhiliao_jizhang_xq_state VARCHAR2(225),
   zhiliao_jizhang_xq_number INTEGER,
   constraint PK_ZHILIAO_JIZHANG_XQ primary key (zhiliao_jizhang_xq_id)
);

/*==============================================================*/
/* Index: dzcf_zyzljzxq_FK                                      */
/*==============================================================*/
create index dzcf_zyzljzxq_FK on zhiliao_jizhang_xq (
   prescription_id ASC
);

/*==============================================================*/
/* Index: zl_zlxq_FK                                            */
/*==============================================================*/
create index zl_zlxq_FK on zhiliao_jizhang_xq (
   zhiliao_jizhang_id ASC
);

/*==============================================================*/
/* Index: shoufeixiangmu3                                       */
/*==============================================================*/
create index shoufeixiangmu3 on zhiliao_jizhang_xq (
   financial_id ASC
);

/*==============================================================*/
/* Table: zhiwu                                                 */
/*==============================================================*/
create table zhiwu  (
   zhiwu_id             INTEGER                         not null,
   dept_id              INTEGER,
   zhiwu_name           VARCHAR2(225),
   constraint PK_ZHIWU primary key (zhiwu_id)
);

/*==============================================================*/
/* Index: dept_zhiwu_FK                                         */
/*==============================================================*/
create index dept_zhiwu_FK on zhiwu (
   dept_id ASC
);

/*==============================================================*/
/* Table: zhuyuan_fayao                                         */
/*==============================================================*/
create table zhuyuan_fayao  (
   zhuyuan_fayao_id     VARCHAR2(225)                         not null,
   hospital_registration_id VARCHAR2(225),
   prescription_id     VARCHAR2(225),
   emp_id               INTEGER,
   zhuyuan_fayao_state  VARCHAR2(225),
   zhuyuan_fayao_date   DATE,
   zhuyuan_fayao_type   VARCHAR2(225),
   zhuyuan_fayao_house  VARCHAR2(225),
   zhuyuan_fayao_zmoney number(9,2),
   constraint PK_ZHUYUAN_FAYAO primary key (zhuyuan_fayao_id)
);

/*==============================================================*/
/* Index: Relationship_150_FK                                   */
/*==============================================================*/
create index Relationship_150_FK on zhuyuan_fayao (
   hospital_registration_id ASC
);

/*==============================================================*/
/* Index: Relationship_151_FK                                   */
/*==============================================================*/
create index Relationship_151_FK on zhuyuan_fayao (
   prescription_id ASC
);

/*==============================================================*/
/* Index: Relationship_152_FK                                   */
/*==============================================================*/
create index Relationship_152_FK on zhuyuan_fayao (
   emp_id ASC
);

/*==============================================================*/
/* Table: zhuyuan_fayao_xq                                      */
/*==============================================================*/
create table zhuyuan_fayao_xq  (
   zhuyuan_fayao_xq_id  INTEGER                         not null,
   drug_id              VARCHAR2(225),
   zhuyuan_fayao_id     VARCHAR2(225),
   zhuyuan_fayao_xq_ph  VARCHAR2(225),
   zhuyuan_fayao_xq_number INTEGER,
   zhuyuan_fayao_xq_price number(9,2),
   zhuyuan_fayao_xq_money number(9,2),
   zhuyuan_fayao_xq_state VARCHAR2(225),
   zhuyuan_fayao_xq_remark VARCHAR2(225),
   constraint PK_ZHUYUAN_FAYAO_XQ primary key (zhuyuan_fayao_xq_id)
);

/*==============================================================*/
/* Index: "zyfy----->zyfy_xq_FK"                                */
/*==============================================================*/
create index "zyfy----->zyfy_xq_FK" on zhuyuan_fayao_xq (
   zhuyuan_fayao_id ASC
);

/*==============================================================*/
/* Index: yp_zyfy_xq_FK                                         */
/*==============================================================*/
create index yp_zyfy_xq_FK on zhuyuan_fayao_xq (
   drug_id ASC
);

/*==============================================================*/
/* Table: zhuyuan_hesuan                                        */
/*==============================================================*/
create table zhuyuan_hesuan  (
   zhuyuan_hesuan_id    VARCHAR2(225)                   not null,
   hospital_registration_id VARCHAR2(225),
   zhuyuan_hesuan_date  DATE,
   zhuyuan_hesuan_money NUMBER(9,2),
   constraint PK_ZHUYUAN_HESUAN primary key (zhuyuan_hesuan_id)
);

/*==============================================================*/
/* Index: dengji_feiyonghesuan_FK                               */
/*==============================================================*/
create index dengji_feiyonghesuan_FK on zhuyuan_hesuan (
   hospital_registration_id ASC
);

/*==============================================================*/
/* Table: zhuyuan_jiezhang                                      */
/*==============================================================*/
create table zhuyuan_jiezhang  (
   zhuyuan_jiezhang_id  VARCHAR2(225)                   not null,
   hospital_registration_id VARCHAR2(225),
   zhuyuan_jiezhang_date DATE,
   zhuyuan_jiezhang_state VARCHAR2(225),
   zhuyuan_jiezhang_zmoney NUMBER(9,2),
   zhuyuan_jiezhang_yqmoney NUMBER(9,2),
   zhuyuan_jiezhang_yhmoney NUMBER(9,2),
   zhuyuan_jiezhang_ysmoney NUMBER(9,2),
   constraint PK_ZHUYUAN_JIEZHANG primary key (zhuyuan_jiezhang_id)
);

/*==============================================================*/
/* Index: dengji_feiyongjiezhang_FK                             */
/*==============================================================*/
create index dengji_feiyongjiezhang_FK on zhuyuan_jiezhang (
   hospital_registration_id ASC
);

/*==============================================================*/
/* Table: zhuyuan_yushou                                        */
/*==============================================================*/
create table zhuyuan_yushou  (
   zhuyuan_yushou_id    INTEGER                         not null,
   rush_shouqu_id       VARCHAR2(225),
   zhuyuan_yushou_money NUMBER(9,2),
   zhuyuan_yushou_date  DATE,
   zhuyuan_yushou_state VARCHAR2(225),
   constraint PK_ZHUYUAN_YUSHOU primary key (zhuyuan_yushou_id)
);

/*==============================================================*/
/* Index: yajinshouqu_4                                         */
/*==============================================================*/
create index yajinshouqu_4 on zhuyuan_yushou (
   rush_shouqu_id ASC
);

alter table be_on_duty_plan_xq
   add constraint FK_BE_ON_DU_BANCI_ZHI_bCLASSES foreign key (bCLASSES_id)
      references bCLASSES (bCLASSES_id);

alter table be_on_duty_plan_xq
   add constraint FK_BE_ON_DU_EMP_ZHIBA_EMP foreign key (emp_id)
      references emp (emp_id);

alter table be_on_duty_plan_xq
   add constraint FK_BE_ON_DU_ZHIBAN_ZH_BE_ON_DU foreign key (be_on_duty_plan_id)
      references be_on_duty_plan (be_on_duty_plan_id);

alter table bed
   add constraint FK_BED_BINGCHUAN_BED_TYPE foreign key (bed_type_id)
      references bed_type (bed_type_id);

alter table bed
   add constraint FK_BED_BINGFANGF_HOUSE_TY foreign key (house_type_id)
      references house_type (house_type_id);

alter table bed
   add constraint FK_BED_EMP_BED_EMP foreign key (emp_id)
      references emp (emp_id);

alter table bed_tiaozheng
   add constraint FK_BED_TIAO_BINGCHUAN_BED foreign key (bed_id)
      references bed (bed_id);

alter table bed_tiaozheng
   add constraint FK_BED_TIAO_DENGJI_CH_HOSPITAL foreign key (hospital_registration_id)
      references hospital_registration (hospital_registration_id);

alter table bed_tiaozheng
   add constraint FK_BED_TIAO_EMP_CWTIA_EMP foreign key (emp_id)
      references emp (emp_id);

alter table bed_tiaozheng
   add constraint FK_BED_TIAO_EMP_CWTZ_EMP foreign key (emp_emp_id)
      references emp (emp_id);

alter table bed_type
   add constraint FK_BED_TYPE_FENLEI_BE_BED_TYPE foreign key (bed_type_type_id)
      references bed_type_type (bed_type_type_id);

alter table caozuo_logger
   add constraint FK_CAOZUO_L_YG_ZHAOZO_EMP foreign key (emp_id)
      references emp (emp_id);

alter table charge_jiesuan
   add constraint FK_CHARGE_J_JIESUANFA_SETTLE_W foreign key (settle_way_id)
      references settle_way (settle_way_id);

alter table charge_jiesuan
   add constraint FK_CHARGE_J_YG_CAIWUS_EMP foreign key (emp_id)
      references emp (emp_id);

alter table charge_management
   add constraint FK_CHARGE_M_CF_SFGL_PRESCRIP foreign key (prescription_id)
      references prescription (prescription_id);

alter table charge_management
   add constraint FK_CHARGE_M_GUAHAO_SH_OUTPAITE foreign key (outpaitent_regist_id)
      references outpaitent_regist (outpaitent_regist_id);

alter table chuyuan_inform
   add constraint FK_CHUYUAN__DENGJI_CH_HOSPITAL foreign key (hospital_registration_id)
      references hospital_registration (hospital_registration_id);

alter table chuyuan_inform
   add constraint "FK_CHUYUAN__员工  -----_EMP" foreign key (emp_id)
      references emp (emp_id);

alter table "chuyuan_login"
   add constraint FK_CHUYUAN__TONGZHI_D_CHUYUAN_ foreign key (chuyuan_inform_id)
      references chuyuan_inform (chuyuan_inform_id);

alter table dclass
   add constraint FK_DCLASS_DEPT_KESH_DEPT foreign key (dept_id)
      references dept (dept_id);

alter table drug
   add constraint "FK_DRUG_DRUG--->S_SUPPLIER" foreign key (supplier_id)
      references supplier (supplier_id);

alter table drug
   add constraint FK_DRUG_DRUG_DRUG_DRUG_TYP foreign key (drug_type_id)
      references drug_type (drug_type_id);

alter table drug
   add constraint FK_DRUG_DW_YP_UNITS foreign key (units_id)
      references units (units_id);

alter table drug
   add constraint FK_DRUG_YKKC_YP_YAOKU_KU foreign key (yaoku_kucun_id)
      references yaoku_kucun (yaoku_kucun_id);

alter table drug_acceptance
   add constraint FK_DRUG_ACC_YPCG_YPYS_DRUG_PUR foreign key (drug_purchase_id)
      references drug_purchase (drug_purchase_id);

alter table drug_acceptance_xq
   add constraint FK_DRUG_ACC_YP_YS_XQ_DRUG foreign key (drug_id)
      references drug (drug_id);

alter table drug_acceptance_xq
   add constraint FK_DRUG_ACC_YS_YS_XQ_DRUG_ACC foreign key (drug_acceptance_id)
      references drug_acceptance (drug_acceptance_id);

alter table drug_delivery
   add constraint FK_DRUG_DEL_EMP_YAOPC_EMP foreign key (emp_id)
      references emp (emp_id);

alter table drug_delivery_detalis
   add constraint "FK_DRUG_DEL_CK------>_DRUG_DEL" foreign key (drug_delivery_id)
      references drug_delivery (drug_delivery_id);

alter table drug_delivery_detalis
   add constraint FK_DRUG_DEL_YP_CK_XQ_DRUG foreign key (drug_id)
      references drug (drug_id);

alter table drug_inventory
   add constraint FK_DRUG_INV_EMP_YKPD_EMP foreign key (emp_id)
      references emp (emp_id);

alter table drug_inventory_detalis
   add constraint "FK_DRUG_INV_PD----->P_DRUG_INV" foreign key (Drug_inventory_id)
      references drug_inventory (Drug_inventory_id);

alter table drug_inventory_detalis
   add constraint FK_DRUG_INV_YP_PD_XQ_DRUG foreign key (drug_id)
      references drug (drug_id);

alter table drug_login
   add constraint FK_DRUG_LOG_DRUG_LOGI_DRUG foreign key (drug_id)
      references drug (drug_id);

alter table drug_purchase
   add constraint FK_DRUG_PUR_EMP_CGDD_EMP foreign key (emp_id)
      references emp (emp_id);

alter table drug_purchase
   add constraint "FK_DRUG_PUR_PURCHASE-_SUPPLIER" foreign key (supplier_id)
      references supplier (supplier_id);

alter table drug_purchase_details_
   add constraint FK_DRUG_PUR_CG_XQ_YP_DRUG foreign key (drug_id)
      references drug (drug_id);

alter table drug_purchase_details_
   add constraint FK_DRUG_PUR_CGDD_CG_X_DRUG_PUR foreign key (drug_purchase_id)
      references drug_purchase (drug_purchase_id);

alter table drug_tuihuo
   add constraint FK_DRUG_TUI_EMP_YPTH_EMP foreign key (emp_id)
      references emp (emp_id);

alter table drug_tuihuo
   add constraint "FK_DRUG_TUI_GYS----->_SUPPLIER" foreign key (supplier_id)
      references supplier (supplier_id);

alter table drug_tuihuo
   add constraint FK_DRUG_TUI_YS_TH_DRUG_ACC foreign key (drug_acceptance_id)
      references drug_acceptance (drug_acceptance_id);

alter table drug_tuihuo_xq
   add constraint "FK_DRUG_TUI_TH---->TH_DRUG_TUI" foreign key (drug_tuihuo_id)
      references drug_tuihuo (drug_tuihuo_id);

alter table drug_tuihuo_xq
   add constraint FK_DRUG_TUI_YP_TH_XQ_DRUG foreign key (drug_id)
      references drug (drug_id);

alter table drug_warehouse
   add constraint FK_DRUG_WAR_YS_RK_DRUG_ACC foreign key (drug_acceptance_id)
      references drug_acceptance (drug_acceptance_id);

alter table drug_warehouse_xq
   add constraint "FK_DRUG_WAR_RK---->RK_DRUG_WAR" foreign key (drug_warehouse_id)
      references drug_warehouse (drug_warehouse_id);

alter table drug_warehouse_xq
   add constraint FK_DRUG_WAR_YP_RK_XQ_DRUG foreign key (drug_id)
      references drug (drug_id);

alter table drug_yaofang
   add constraint FK_DRUG_YAO_DZCF_MZFY_PRESCRIP foreign key (prescription_id)
      references prescription (prescription_id);

alter table drug_yaofang
   add constraint FK_DRUG_YAO_GH_YFFY_OUTPAITE foreign key (outpaitent_regist_id)
      references outpaitent_regist (outpaitent_regist_id);

alter table drug_yaofang
   add constraint FK_DRUG_YAO_YG_MZFY_EMP foreign key (emp_id)
      references emp (emp_id);

alter table drug_yaofang_xq
   add constraint FK_DRUG_YAO_MZFY_ZFY__DRUG_YAO foreign key (drug_yaofang_id)
      references drug_yaofang (drug_yaofang_id);

alter table drug_yaofang_xq
   add constraint FK_DRUG_YAO_YP_MZFY_X_DRUG foreign key (drug_id)
      references drug (drug_id);

alter table emp
   add constraint FK_EMP_DEPT_YUAN_DEPT foreign key (dept_id)
      references dept (dept_id);

alter table emp
   add constraint FK_EMP_KESHI_YUA_DCLASS foreign key (dclass_id)
      references dclass (dclass_id);

alter table emp
   add constraint FK_EMP_ZHIWU_YUA_ZHIWU foreign key (zhiwu_id)
      references zhiwu (zhiwu_id);

alter table emp_message
   add constraint FK_EMP_MESS_YG_YGXING_EMP foreign key (emp_id)
      references emp (emp_id);

alter table fayao_jizhang
   add constraint FK_FAYAO_JI_EMP_FAYAO_EMP foreign key (emp_id)
      references emp (emp_id);

alter table fayao_jizhang
   add constraint FK_FAYAO_JI_ZHUYUANDE_HOSPITAL foreign key (hospital_registration_id)
      references hospital_registration (hospital_registration_id);

alter table fayao_jizhang_xq
   add constraint FK_FAYAO_JI_RELATIONS_DRUG foreign key (drug_id)
      references drug (drug_id);

alter table fayao_jizhang_xq
   add constraint FK_FAYAO_JI_DIANZICHU_PRESCRIP foreign key (prescription_id)
      references prescription (prescription_id);

alter table fayao_jizhang_xq
   add constraint FK_FAYAO_JI_ZHUYUAN_Z_FAYAO_JI foreign key (zhuyuan_jizhang_id)
      references fayao_jizhang (zhuyuan_jizhang_id);

alter table finance_sumup
   add constraint FK_FINANCE__YG_CAIFEI_EMP foreign key (emp_id)
      references emp (emp_id);

alter table financial
   add constraint FK_FINANCIA_SHOUFEIFE_FINANCIA foreign key (financial_type_id)
      references financial_type (financial_type_id);

alter table financial
   add constraint FK_FINANCIA_YG_SHOFEI_EMP foreign key (emp_id)
      references emp (emp_id);

alter table financial_history
   add constraint FK_FINANCIA_DIANZICHU_PRESCRIP foreign key (outpaitent_regist_id)
      references outpaitent_regist (outpaitent_regist_id);

alter table financial_history
   add constraint FK_FINANCIA_SHOUFEIXI_FINANCIA foreign key (financial_id)
      references financial (financial_id);

alter table fukuan_record
   add constraint FK_FUKUAN_R_CW_GONGYI_SUPPLIER foreign key (supplier_jiesuan_id)
      references supplier_jiesuan (supplier_jiesuan_id);

alter table fukuan_record
   add constraint FK_FUKUAN_R_YINGFU_CA_FUKUAN foreign key (fukuan_id)
      references fukuan (fukuan_id);

alter table functions
   add constraint FK_FUNCTION_F_TYPE_FU_FUNCTION foreign key (function_type_id)
      references function_type (function_type_id);

alter table hospita_notify
   add constraint FK_HOSPITA__MZGH_ZHUY_OUTPAITE foreign key (outpaitent_regist_id)
      references outpaitent_regist (outpaitent_regist_id);

alter table hospital_registration
   add constraint FK_HOSPITAL_RELATIONS_EMP foreign key (emp_id)
      references emp (emp_id);

alter table hospital_registration
   add constraint FK_HOSPITAL_BINGCHUAN_BED foreign key (bed_id)
      references bed (bed_id);

alter table hospital_registration
   add constraint FK_HOSPITAL_TZ_DENGJI_HOSPITA_ foreign key (hospital_notify_number)
      references hospita_notify (hospital_notify_number);

alter table instrument
   add constraint FK_INSTRUME_DW_QX_UNITS foreign key (units_id)
      references units (units_id);

alter table instrument
   add constraint FK_INSTRUME_EMP_QIXIE_EMP foreign key (emp_id)
      references emp (emp_id);

alter table instrument
   add constraint FK_INSTRUME_QXB_QXFLB_INSTRUME foreign key (instrument_type_id)
      references instrument_type (instrument_type_id);

alter table instrument_caigou
   add constraint FK_INSTRUME_RELATIONS_SUPPLIER foreign key (supplier_id)
      references supplier (supplier_id);

alter table instrument_caigou_xq
   add constraint FK_INSTRUME_QXB_QXCGX_INSTRUME foreign key (instrument_id)
      references instrument (instrument_id);

alter table instrument_caigou_xq
   add constraint FK_INSTRUME_QXCG_QXCG_INSTRUME foreign key (instrument_caigou_id)
      references instrument_caigou (instrument_caigou_id);

alter table instrument_login
   add constraint FK_INSTRUME_REFERENCE_INSTRUME foreign key (instrument_id)
      references instrument (instrument_id);

alter table instrument_rk
   add constraint FK_INSTRUME_EMP_RUKU_EMP foreign key (emp_id)
      references emp (emp_id);

alter table instrument_rk
   add constraint FK_INSTRUME_QIXIEYANS_INSTRUME foreign key (instrument_ys_id)
      references instrument_ys (instrument_ys_id);

alter table instrument_rk_xq
   add constraint FK_INSTRUME_QIXIE_QIX_INSTRUME foreign key (instrument_id)
      references instrument (instrument_id);

alter table instrument_rk_xq
   add constraint FK_INSTRUME_QIXIERUKU_INSTRUME foreign key (instrument_rk_id)
      references instrument_rk (instrument_rk_id);

alter table instrument_ys
   add constraint FK_INSTRUME_QXCGB_QXY_INSTRUME foreign key (instrument_caigou_id)
      references instrument_caigou (instrument_caigou_id);

alter table jianyan
   add constraint FK_JIANYAN_DW_TJXM_UNITS foreign key (units_id)
      references units (units_id);

alter table jianyan
   add constraint FK_JIANYAN_EMP_XM_EMP foreign key (emp_id)
      references emp (emp_id);

alter table jianyan
   add constraint FK_JIANYAN_JIANYANXI_JIANYAN_ foreign key (jianyan_type_id)
      references jianyan_type (jianyan_type_id);

alter table jianyan_mess
   add constraint FK_JIANYAN__EMP_JIANY_EMP foreign key (emp_id)
      references emp (emp_id);

alter table jianyan_mess
   add constraint FK_JIANYAN__MZ_JYAN_OUTPAITE foreign key (outpaitent_regist_id)
      references outpaitent_regist (outpaitent_regist_id);

alter table jianyan_mess_xq
   add constraint FK_JIANYAN__JIANYAN_J_JIANYAN_ foreign key (jianyan_mess_id)
      references jianyan_mess (jianyan_mess_id);

alter table jianyan_mess_xq
   add constraint FK_JIANYAN__JIANYANXI_JIANYAN foreign key (jianyan_id)
      references jianyan (jianyan_id);

alter table login_logger
   add constraint FK_LOGIN_LO_YG_DENGLU_EMP foreign key (emp_id)
      references emp (emp_id);

alter table outpaitent_regist
   add constraint FK_OUTPAITE_KESHI_GUA_DCLASS foreign key (dclass_id)
      references dclass (dclass_id);

alter table outpaitent_regist
   add constraint FK_OUTPAITE_YG_GUAHAO_EMP foreign key (emp_id)
      references emp (emp_id);

alter table outpaitent_regist
   add constraint FK_OUTPAITE_ZL_GUAHAO_MEDICAL_ foreign key (medical_card_card_id)
      references medical_card (medical_card_card_id);

alter table pharmace_return
   add constraint FK_PHARMACE_RELATIONS_OUTPAITE foreign key (outpaitent_regist_id)
      references outpaitent_regist (outpaitent_regist_id);

alter table pharmace_return
   add constraint FK_PHARMACE_RELATIONS_PRESCRIP foreign key (prescription_id)
      references prescription (prescription_id);

alter table pharmacy_inventory_detalis
   add constraint FK_PHARMACY_YFPD_XQ_Y_PHARMACY foreign key (Pharmacy_inventory_id)
      references pharmacy_inventory (Pharmacy_inventory_id);

alter table pharmacy_inventory_detalis
   add constraint FK_PHARMACY_YP_YFPD_X_DRUG foreign key (drug_id)
      references drug (drug_id);

alter table pharmacy_recipients_detalis
   add constraint FK_PHARMACY_YP_YPLY_X_DRUG foreign key (drug_id)
      references drug (drug_id);

alter table pharmacy_recipients_detalis
   add constraint FK_PHARMACY_YPLY_YPLY_PHARMACY foreign key (Pharmacy_recipients_id)
      references pharmacy_recipients (Pharmacy_recipients_id);

alter table pharmacy_return_detalis
   add constraint FK_PHARMACY_YFTY_YFTY_PHARMACE foreign key (Pharmace_return_id)
      references pharmace_return (Pharmace_return_id);

alter table pharmacy_return_detalis
   add constraint FK_PHARMACY_YP_YFTY_X_DRUG foreign key (drug_id)
      references drug (drug_id);

alter table pharmacy_warehouse_detalis
   add constraint FK_PHARMACY_YFRK_YFRK_YAOFANG_ foreign key (Pharmacy_warehouse_id)
      references yaofang_ruku (Pharmacy_warehouse_id);

alter table pharmacy_warehouse_detalis
   add constraint FK_PHARMACY_YP_YFRK_X_DRUG foreign key (drug_id)
      references drug (drug_id);

alter table prescription
   add constraint FK_PRESCRIP_RELATIONS_PRESCRIP foreign key (pre_prescription_id)
      references prescription (prescription_id);

alter table prescription
   add constraint FK_PRESCRIP_MZ_DIZICH_OUTPAITE foreign key (outpaitent_regist_id)
      references outpaitent_regist (outpaitent_regist_id);

alter table prescription
   add constraint FK_PRESCRIP_YG_DIZICH_EMP foreign key (emp_id)
      references emp (emp_id);

alter table prescription
   add constraint FK_PRESCRIP_ZHUYUANDE_HOSPITAL foreign key (hospital_registration_id)
      references hospital_registration (hospital_registration_id);

alter table prescription_recode
   add constraint FK_PRESCRIP_RELATIONS_DRUG foreign key (drug_id)
      references drug (drug_id);

alter table prescription_type
   add constraint FK_PRESCRIP_DIANZICHU_PRESCRIP foreign key (prescription_id)
      references prescription (prescription_id);

alter table prescription_type
   add constraint FK_PRESCRIP_MZ_HUAIJI_OUTPAITE foreign key (outpaitent_regist_id)
      references outpaitent_regist (outpaitent_regist_id);

alter table prescription_type
   add constraint FK_PRESCRIP_YG_HUAIJI_EMP foreign key (emp_id)
      references emp (emp_id);

alter table qx_lnventoryqx
   add constraint FK_QX_LNVEN_QIXIE_QIX_INSTRUME foreign key (instrument_id)
      references instrument (instrument_id);

alter table qx_lnventoryqx
   add constraint FK_QX_LNVEN_QIXIEPAND_QX_LNVEN foreign key (qx_lnventory_id)
      references qx_lnventory (qx_lnventory_id);

alter table qx_returngoos
   add constraint FK_QX_RETUR_RELATIONS_SUPPLIER foreign key (supplier_id)
      references supplier (supplier_id);

alter table qx_returngoos
   add constraint FK_QX_RETUR_QIXIEYANS_INSTRUME foreign key (instrument_ys_id)
      references instrument_ys (instrument_ys_id);

alter table qx_returngoosqx
   add constraint FK_QX_RETUR_QIXIETUIH_QX_RETUR foreign key (qx_returngoos_id)
      references qx_returngoos (qx_returngoos_id);

alter table qx_returngoosqx
   add constraint FK_QX_RETUR_QXB_QXTHX_INSTRUME foreign key (instrument_id)
      references instrument (instrument_id);

alter table qx_returnqx
   add constraint FK_QX_RETUR_QIXIEHUAN_QX_RETUR foreign key (qx_return_id)
      references qx_return (qx_return_id);

alter table qx_returnqx
   add constraint FK_QX_RETUR_QXB_XQHHX_INSTRUME foreign key (instrument_id)
      references instrument (instrument_id);

alter table qx_thelibrary
   add constraint FK_QX_THELI_EMP_CHUKU_EMP foreign key (emp_id)
      references emp (emp_id);

alter table qx_thelibraryqx
   add constraint FK_QX_THELI_QIXIE_QIX_INSTRUME foreign key (instrument_id)
      references instrument (instrument_id);

alter table qx_thelibraryqx
   add constraint FK_QX_THELI_QIXIECHUK_QX_THELI foreign key (qx_thelibrary_id)
      references qx_thelibrary (qx_thelibrary_id);

alter table qx_useqx
   add constraint FK_QX_USEQX_QIXIE_QIX_INSTRUME foreign key (instrument_id)
      references instrument (instrument_id);

alter table qx_useqx
   add constraint FK_QX_USEQX_QIXIELING_QX_USE foreign key (qx_use_id)
      references qx_use (qx_use_id);

alter table rece_record
   add constraint FK_RECE_REC_SHOFEIJS__CHARGE_J foreign key (charge_jiesuan_id)
      references charge_jiesuan (charge_jiesuan_id);

alter table rece_record
   add constraint FK_RECE_REC_YINGFU_CA_RECE foreign key (rece_id)
      references rece (rece_id);

alter table rush_fee
   add constraint FK_RUSH_FEE_DENGJI_YA_HOSPITAL foreign key (hospital_registration_id)
      references hospital_registration (hospital_registration_id);

alter table rush_shouqu
   add constraint FK_RUSH_SHO_DENGJI_YA_HOSPITAL foreign key (hospital_registration_id)
      references hospital_registration (hospital_registration_id);

alter table rush_shouqu
   add constraint FK_RUSH_SHO_EMP_YAJIN_EMP foreign key (emp_id)
      references emp (emp_id);

alter table rush_shouqu
   add constraint FK_RUSH_SHO_TZ_YANJIS_HOSPITA_ foreign key (hospital_notify_number)
      references hospita_notify (hospital_notify_number);

alter table shoushu
   add constraint FK_SHOUSHU_EMP_SHOUS_EMP foreign key (emp_id)
      references emp (emp_id);

alter table shoushu
   add constraint FK_SHOUSHU_KESHI_SHO_DCLASS foreign key (dclass_id)
      references dclass (dclass_id);

alter table shoushu
   add constraint FK_SHOUSHU_SHOUSHUSH_SHOUSHU_ foreign key (shoushu_type_id)
      references shoushu_type (shoushu_type_id);

alter table shoushu_mess
   add constraint FK_SHOUSHU__EMP_SSZL_EMP foreign key (emp_id)
      references emp (emp_id);

alter table shoushu_mess
   add constraint FK_SHOUSHU__SOHUSHUSH_SHOUSHU foreign key (shoushu_id)
      references shoushu (shoushu_id);

alter table shoushu_mess
   add constraint FK_SHOUSHU__ZHUYUAN_D_HOSPITAL foreign key (hospital_registration_id)
      references hospital_registration (hospital_registration_id);

alter table supplier
   add constraint "FK_SUPPLIER_SUPPLIER-_SUPPLIER" foreign key (supplier_type_id)
      references supplier_type (supplier_type_id);

alter table supplier_jiesuan
   add constraint FK_SUPPLIER_EMP_GYS_EMP foreign key (emp_id)
      references emp (emp_id);

alter table supplier_jiesuan
   add constraint FK_SUPPLIER_GONG_JIES_SETTLE_W foreign key (settle_way_id)
      references settle_way (settle_way_id);

alter table user_roles
   add constraint FK_USER_ROL_EMP_ROLES_ROLES foreign key (roles_id)
      references roles (roles_id);
	  
alter table user_roles
   add constraint "FK_USER_ROL_员工<——>角色_EMP" foreign key (emp_id)
      references emp (emp_id);

alter table roles_functions
   add constraint FK_USER_roles_functions foreign key (roles_id)
      references roles (roles_id);

alter table roles_functions
   add constraint "FK_USER_ROL_功能<——>角色_EMP" foreign key (functions_id)
      references functions (functions_id);  
	  
alter table yajin_tuifei
   add constraint FK_YAJIN_TU_EMP_YJTF_EMP foreign key (emp_id)
      references emp (emp_id);

alter table yajin_tuifei
   add constraint FK_YAJIN_TU_TZHI_TUIF_CHUYUAN_ foreign key (chuyuan_inform_id)
      references chuyuan_inform (chuyuan_inform_id);

alter table yaofang_ruku
   add constraint FK_YAOFANG__RELATIONS_EMP foreign key (emp_emp_id)
      references emp (emp_id);

alter table yaofang_ruku
   add constraint FK_YAOFANG__EMP_YFRK_EMP foreign key (emp_id)
      references emp (emp_id);

alter table zhiliao_jizhang
   add constraint FK_ZHILIAO__EMP_ZLJZ_EMP foreign key (emp_id)
      references emp (emp_id);

alter table zhiliao_jizhang
   add constraint FK_ZHILIAO__ZHUYUANDE_HOSPITAL foreign key (hospital_registration_id)
      references hospital_registration (hospital_registration_id);

alter table zhiliao_jizhang_xq
   add constraint FK_ZHILIAO__DZCF_ZYZL_PRESCRIP foreign key (prescription_id)
      references prescription (prescription_id);

alter table zhiliao_jizhang_xq
   add constraint FK_ZHILIAO__SHOUFEIXI_FINANCIA foreign key (financial_id)
      references financial (financial_id);

alter table zhiliao_jizhang_xq
   add constraint FK_ZHILIAO__ZL_ZLXQ_ZHILIAO_ foreign key (zhiliao_jizhang_id)
      references zhiliao_jizhang (zhiliao_jizhang_id);

alter table zhiwu
   add constraint FK_ZHIWU_DEPT_ZHIW_DEPT foreign key (dept_id)
      references dept (dept_id);

alter table zhuyuan_fayao
   add constraint FK_ZHUYUAN__RELATIONS_HOSPITAL foreign key (hospital_registration_id)
      references hospital_registration (hospital_registration_id);

alter table zhuyuan_fayao
   add constraint FK_ZHUYUAN__RELATIONS_PRESCRIP foreign key (prescription_id)
      references prescription (prescription_id);

alter table zhuyuan_fayao
   add constraint FK_ZHUYUAN__RELATIONS_EMP foreign key (emp_id)
      references emp (emp_id);

alter table zhuyuan_fayao_xq
   add constraint FK_ZHUYUAN__YP_ZYFY_X_DRUG foreign key (drug_id)
      references drug (drug_id);

alter table zhuyuan_fayao_xq
   add constraint "FK_ZHUYUAN__ZYFY-----_ZHUYUAN_" foreign key (zhuyuan_fayao_id)
      references zhuyuan_fayao (zhuyuan_fayao_id);

alter table zhuyuan_hesuan
   add constraint FK_ZHUYUAN__DJ_FYHS_HOSPITAL foreign key (hospital_registration_id)
      references hospital_registration (hospital_registration_id);

alter table zhuyuan_jiezhang
   add constraint FK_ZHUYUAN__DJ_FYJZ_HOSPITAL foreign key (hospital_registration_id)
      references hospital_registration (hospital_registration_id);

alter table zhuyuan_yushou
   add constraint FK_ZHUYUAN__YAJINSHOU_RUSH_SHO foreign key (rush_shouqu_id)
      references rush_shouqu (rush_shouqu_id);

