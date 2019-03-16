<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="<c:url value="/js/easyui/themes/default/easyui.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/js/easyui/themes/icon.css"/>">
	<script type="text/javascript" src="<c:url value="/js/jquery-3.1.0.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/easyui/jquery.easyui.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/easyui/easyui-lang-zh_CN.js"/>"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>门诊发药</title>
</head>
<body>
	<script type="text/javascript">
		//自动生成采购订单号
		
		getOutPatientPillsId();
		
		function getOutPatientPillsId(){
			$.get("to_outpatientpills",function(data){
				$("#fayaoid").textbox('setValue',data.substring(1,data.length-1));
			});
			
		}
		
		function getPillValue(row){
			if(row == null){
				$.messager.alert("提示","选择数据不能为空！");
				return ;
			}
			$("#outpatientpills-id").textbox('setValue', row.idField);
			$("#outpatientpills-patientname").textbox('setValue',row.medical.medicalCardName);
			//后台查询
			$.getJSON("query_prescrition",{outpaitentRegistId : row.idField},function(data){
				if(data.error){
					$("#outpatientpills-cfh").textbox('setValue' , data.eMessage);
				}
				//查询状态已发药的状态
				$.getJSON('query_outpatientpills_state',{outpaitentRegistId : row.idField},function(json){
					if(json.error){
						$('#drugYaofangState').combobox('setValue','已处理');
					}else{
						$('#drugYaofangState').combobox('setValue','未处理');
					}
				});
			});
			LoadDrug(row);
			
		}
		
		function LoadDrug(row){
			$.getJSON('query_regist_fayao',{outpaitentRegistId : row.idField},function(json){
				for (var i = 0; i < json.length; i++) {
					$('#outpatientpills-tbs').datagrid('appendRow',{
						prescriptionRecodeId :json[i].prescriptionRecodeId,
						drugBname :json[i].drugBname,
						prescriptionRecodeDrugType :json[i].prescriptionRecodeDrugType,
						prescriptionRecodeNum :json[i].prescriptionRecodeNum,
						prescriptionRecodePrice :json[i].prescriptionRecodePrice,
						prescriptionRecodeMoney :json[i].prescriptionRecodeNum * json[i].prescriptionRecodePrice,
						prescriptionRecodeZt :json[i].prescriptionRecodeZt,
						prescriptionRecodeExplain :json[i].prescriptionRecodeExplain
					});
				}
				jisuanMoney();
			});
		}
		
		function jisuanMoney(){
			var money = 0.0;
			var drugMoney = $('#outpatientpills-tbs').datagrid('getRows');
			for (var i = 0; i < drugMoney.length; i++) {
				money += drugMoney[i].prescriptionRecodeMoney;
			}
			$('#outpatientpills-zjine').textbox("setValue", money);
		}
		
		//新增发药信息
		$('#outregistpills-fayao').linkbutton({onClick : function(){
			if($('#drugYaofangState').combobox('getValue') == '已处理'){
				$.messager.alert('提示','数据不能重复处理');
				return ;
			}
			$('#outpatientpills-form').form('submit',{
				url : 'add_outpatient_pills' ,
				onSubmit : function(param){
					var rowpill = $('#outpatientpills-tbs').datagrid('getRows');
					var str = "";
					for (var i = 0; i < rowpill.length; i++) {
						str += rowpill[i].prescriptionRecodeId +",";
					}
					param.id = str;
					$(this).form('validate');
				},
				success : function(data){
					var json = eval("("+data+")");
					if(json.error){
						$.messager.alert('提示','门诊发药处理成功！');
						$('#outpatientpills-form').form('reset');
						deleteOutPills();
						getOutPatientPillsId();
					}
				}
			});
		}});
		
		//删除下面表格里的东西
		function deleteOutPills(){
			var rowpill = $('#outpatientpills-tbs').datagrid('getRows');
			for (var i =  rowpill.length - 1; i >= 0; i--) {
				$('#outpatientpills-tbs').datagrid('deleteRow',i);
			}
		}
		
		$('#outregistpills-init').linkbutton({onClick : function(){
			$('#outpatientpills-form').form('reset');
			getOutPatientPillsId();
			deleteOutPills();
			$.messager.alert('提示','数据初始化完毕！');
		}});
	</script>
	
	<div id="" class="easyui-layout" title="门诊发药" data-options="fit:true">
		<div data-options="region:'north'" style="height: 45px; padding: 6px ; border-top: none;border-left: none;border-right: none">
			<a id="outregistpills-init" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" style="width: 80px">新建</a> 
	 		<a id="outregistpills-fayao" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok',plain:true" style="width:80px;">发药处理</a>
	 		<!-- <a id="outregistpills-dy" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-print',plain:true" style="width: 80px">打印</a> -->
		</div>
		<!-- 头部分割线 -->
		<div data-options="region:'center',fit:true,border:false">
			<form action="" method="post" id="outpatientpills-form">
				<table width="100%" style="padding: 5px;">
					<tr height="30">
						<td><input class="easyui-textbox" readonly="readonly" id="fayaoid" name="drugYaofangId" data-options="label:'发药编号',width:240,labelAlign:'right'"></td>
						<td><select class="easyui-combobox" id="drugYaofangState" name="drugYaofangState" data-options="label:'状态',width:240,labelAlign:'right'">
							<option value="未处理">未处理</option>
							<option value="已处理">已处理</option>
							</select>
						</td>
						<td><input class="easyui-datebox" name="drugYaofangDate" data-options="label:'发药日期',width:240,labelAlign:'right'" value="new Date()"></td>
						
					</tr>
					<tr  height="30">
						<td><input name="outpaitentRegistId" class="easyui-textbox" id="outpatientpills-id"
									data-options="label:'门诊号*',required:true,width:280,labelAlign:'right',buttonText:'…',
									onClickButton : function(){
										menzhengh(function(row){
											if(row == null){                                                                                                                                                                                             
												$.messager.alert('操作','请至少选择一行数据!');
												return ;
											}
											getPillValue(row);
										},'已结算');
									}">
						</td>
							<td ><input name="prescriptionId" class="easyui-textbox" id="outpatientpills-cfh"
								data-options="label:'处方号*',width:240,labelAlign:'right',required:true">
							</td>
						<td><input class="easyui-textbox" name="" id="outpatientpills-patientname" data-options="label:'病人姓名',width:240,labelAlign:'right',required:true"></td>
					</tr>
					<tr  height="30">
						<td>
							<input class="easyui-textbox" name="zhuyuanFayaoHouse" id="outpatientpills-drugname" value="门诊发药" data-options="label:'药房',width:240,labelAlign:'right'">
						</td>
						<td><input class="easyui-textbox" id="outpatientpills-zjine" name="zhuyuanFayaoZmoney" data-options="label:'总金额',width:240,labelAlign:'right',value:'0.00'"></td>
						<td><select name="empId" class="easyui-combobox"
									data-options="label:'操作人',width:240,labelAlign:'right'">
								<option value="${empMessage.empId}">${empMessage.empLoginName}</option>
							</select>
						</td>
					</tr>
				</table>
			</form>
		
		<div id="" class="easyui-tabs" data-options="border:false" style="margin-top: 10px; height: 395px;" >
			<div title="药品信息" style="padding: 5px; display: none;">
				<table class="easyui-datagrid" data-options="method:'get',fit:true,fitColumns : true,rownumbers:true,striped:true" 
						id="outpatientpills-tbs">
					<thead style="margin-left:10px;">
						<tr>
							<th data-options="field:'prescriptionRecodeId',width:100,align:'center'">药品编号</th>
							<th data-options="field:'drugBname',width:100,align:'center'">药品名称</th>
							<th data-options="field:'prescriptionRecodeDrugType',width:100,align:'center'">类型</th>
							<th data-options="field:'prescriptionRecodeNum',width:100,align:'center'">数量</th>
							<th data-options="field:'prescriptionRecodePrice',width:100,align:'center'">单价</th>
							<th data-options="field:'prescriptionRecodeMoney',width:150,align:'center'">金额</th>
							<th data-options="field:'prescriptionRecodeZt',width:150,align:'center'">状态</th>
							<th data-options="field:'prescriptionRecodeExplain',width:200,align:'center'">备注</th>
						</tr>
					</thead>
				</table>
			</div>
		</div>
		</div>
	</div>
</body>
</html>