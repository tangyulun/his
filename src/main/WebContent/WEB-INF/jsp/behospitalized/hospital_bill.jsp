<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>住院费用结账</title>
</head>
<body>
	<div id="zhuyuanfeiyongjiezhan_big_win" class="easyui-layout" title="My Window"
		style="width: 800px; height: 500px"
		data-options="iconCls:'icon-save',modal:true,fit:true">
		<div class="easyui-layout" data-options="fit:true">
			<div id="" data-options="region:'north'"
				style="height: 45px; padding: 8px;">
				<a id="jiezhang_btn_add" href="#" class="easyui-linkbutton"
					data-options="
				        iconCls:'icon-add',
				        width: 80,
				        plain:true
				        "
					style="margin-left: 20px">新建</a><a id="jiezhang_btn_dispose" href="#"
					class="easyui-linkbutton"
					data-options="
				        iconCls:'icon-ok',
				        width: 80,
				        plain:true
				        "
					style="margin-left: 10px">处理</a><a id="jiezhang_btn_dayin" href="#"
					class="easyui-linkbutton"
					data-options="
				        iconCls:'icon-ok',
				        width: 80,
				        plain:true
				        "
					style="margin-left: 10px">打印</a>
			</div>
			<div data-options="region:'center'" style="padding: 5px">

				<form id="jiezhang-form" method="post">
					<table width="100%">
						<tr height="40px">

							<td><input id="jiezhang_number" class="easyui-textbox"
								type="text" name="zhuyuanJiezhangId"
								data-options="
								        required:true,
								        label: '住院费用结账号*',
								        labelWidth: 100,
								        labelAlign: 'right',
								        editable : false,
								        width: 240" />
							</td>

							<td><input class="easyui-datebox" type="text" id="jiezhang-date" name="zhuyuanJiezhangDate" value="new Date()"
								data-options="
								        required:true,
								        label: '结账日期',
								        labelAlign: 'right',
								        width: 240" />
							</td>
							<td><input style="right: 100px" class="easyui-textbox"
								type="text" name="zhuyuanJiezhangState"
								data-options="
								        required:true,
								        labelAlign: 'right',
								        label: '住院状态',
								        width: 240,
								        editable : false,
								        value: '住院'" />
							</td>
							<td><input class="easyui-textbox" type="text" name="hospitalRegistrationId" id="jiezhan-zhuyuanhao"
								data-options="
								        required:true,
								        labelAlign: 'right',
								        label: '住院号*',
								          editable : false,
								        buttonText : '…',
								        onClickButton : function(){
								        	selectZhuyuanJilu(function(row){
								        		selectHesuanJilu(row);
								        	});
								        	
								        },
								        width: 260" />
								<!-- <!-- <a id="jiezhang-zhuyuandengjihao" href="#" class="easyui-linkbutton" data-options=""
								style="width: 30px; height: 22px">…</a> --></td>

						</tr>
						<tr>
							<td><input class="easyui-textbox" type="text" name="medicalCardName" id="zhuyuanjiezhang-medicalCardName"
								data-options="
								        required:true,
								        labelAlign: 'right',
								        label: '病人姓名',
								        editable : false,
								        width: 240" />

							</td>
							<td><input class="easyui-textbox" type="text" name="rushShouquYushouMoney" id="zhuyuanjiezhang-rushShouquYushouMoney"
								data-options="
								        required:true,
								        labelAlign: 'right',
								        label: '押金金额',
								        width: 240,
								        value: '0.00'" />

							</td>
						</tr>
						<tr height="40px">

							<td><input class="easyui-textbox" type="text" name="zhuyuanJiezhangZmoney" id="zhuyuanjiezhang-zhuyuanJiezhangZmoney"
								data-options="
								        required:true,
								        label: '结账总额',
								        labelWidth: 100,
								        labelAlign: 'right',
								        width: 240,
								        value: '0.00'" />
							</td>

							<td><input class="easyui-textbox" type="text" name="zhuyuanJiezhangYqmoney" id="zhuyuanjiezhang-zhuyuanJiezhangYqmoney"
								data-options="
								        required:true,
								        label: '已清总额',
								        labelAlign: 'right',
								        width: 240,
								        value: '0.00'" />
							</td>
							<td><input style="right: 100px" class="easyui-textbox"
								type="text" name="zhuyuanJiezhangYhmoney" id="zhuyuanjiezhang-zhuyuanJiezhangYhmoney"
								data-options="
								        required:true,
								        labelAlign: 'right',
								        label: '已核应收总额',
								        width: 240,
								        value: '0.00'" />
							</td>
							<td><input class="easyui-textbox" type="text" name="zhuyuanJiezhangYsmoney" id="zhuyuanjiezhang-zhuyuanJiezhangYsmoney"
								data-options="
								        required:true,
								        labelAlign: 'right',
								        label: '实收总额',
								        width: 240,
								        value: '0.00'" />

							</td>

						</tr>
					</table>
				</form>
				<div id="" class="easyui-tabs" 
					data-options="border:false">
					<div title="已核算项目" style="display: none;padding-top: 5px">
						<form action="">
							<table class="easyui-datagrid" width="100%" id="zhuyuanjiezhang-yihesuan-table"
								data-options="
			              			   fitColumns:true,method : 'get'
							           ">
								<thead>
									<tr>
										<th data-options="field:'id',width:4">*</th>			
										<th data-options="field:'shoufeinumber',width:10">收费项目编号</th>
										<th data-options="field:'shoufeiname',width:10">收费项目名称</th>
										<th data-options="field:'shuliang',width:10">数量</th>
										<th data-options="field:'zmoney',width:10">金额</th>
										<th data-options="field:'shoufeistate',width:10">状态</th>
										<th data-options="field:'chufanghao',width:10">处方号</th>
										<th data-options="field:'zhuyuandengjihao',width:10">住院号</th>

									</tr>
								</thead>
								
							</table>
						</form>
						<!-- <a id="btn_delete" href="#" class="easyui-linkbutton"
							data-options="
						        iconCls:'icon-search',
						        width: 80
						        "
							style="float: right; margin-top: 10px">删除</a> -->
					</div>
					<div title="费用清单" data-options="border:false" style="display: none;padding-top: 5px">
						<form action="">
							<table class="easyui-datagrid" width="100%" id="zhuyuanjiezhang-feiyongqingdan-table"
								data-options="
			              			   fitColumns:true,method : 'get'
							           ">
								<thead>
									<tr>
										<th data-options="field:'id',width:4">*</th>
										<th data-options="field:'shoufeinumber',width:10">收费项目编号</th>
										<th data-options="field:'shoufeiname',width:10">收费项目名称</th>
										<th data-options="field:'shuliang',width:10">数量</th>
										<th data-options="field:'zmoney',width:10">金额</th>
										<th data-options="field:'shoufeistate',width:10">状态</th>
										<th data-options="field:'chufanghao',width:10">处方号</th>
										<th data-options="field:'zhuyuandengjihao',width:10">住院号</th>
									</tr>
								</thead>
							</table>
						</form>
					</div>

				</div>
			</div>
			<!-- <div data-options="region:'south'"
				style="height: 100px; padding: 10px; padding-top: 20px">
				<form id="" method="post">
					<table width="100%">
						<tr height="40px">

							<td><input class="easyui-textbox" type="text" name="zhuyuanJiezhangZmoney"
								data-options="
								        required:true,
								        label: '结账总额',
								        labelWidth: 100,
								        labelAlign: 'right',
								        width: 240" />
							</td>

							<td><input class="easyui-textbox" type="text" name="zhuyuanJiezhangYqmoney"
								data-options="
								        required:true,
								        label: '已清总额',
								        labelAlign: 'right',
								        width: 240" />
							</td>
							<td><input style="right: 100px" class="easyui-textbox"
								type="text" name="zhuyuanJiezhangYhmoney"
								data-options="
								        required:true,
								        labelAlign: 'right',
								        label: '已核应收总额',
								        width: 240" />
							</td>
							<td><input class="easyui-textbox" type="text" name="zhuyuanJiezhangYsmoney"
								data-options="
								        required:true,
								        labelAlign: 'right',
								        label: '实收总额',
								        width: 240" />

							</td>

						</tr>

					</table>
				</form>


			</div> -->
		</div>

	</div>
	<div id="jiezhang-select-zhuyuandengjijilu" class="easyui-window" data-options="
			 width:800,
	          height: 460,
	          title: '选择住院登记',
	          maximizable:false,
	          minimizable:false,
	          collapsible:false,
	          resizable:false,
	          closed: true,
	          modal: true,
	          draggable:false, href :'href_address?myValue=/behospitalized/zhuyuandengji_window' , method : 'get'
		">
	</div>
	<div id="zhuyuanfeiyong-dayin-window" class="easyui-window dayin-dayin-div" title="打印" style="width:800px;height:450px" 
		 	data-options="modal:true,collapsible:false,minimizable:false,maximizable:false,closed:true">
			<div class="easyui-layout" data-options="fit:true">
				<div data-options="region : 'center' , split : true" style="height:50px">
					<div>
						<h2 style="text-align: center;">住院费用结账单</h2>
					</div>
					<table border="1" cellpadding="0" cellspacing="0" style="border-collapse: collapse;" width="100%">
						<thead>
							<tr style="text-align: center">
								<td style="height:23px;width:90px">
									住院费用结账号：
								</td>
								<td style="height:23px;width:150px" id="dayin-zhuyuanfeiyonghao">
									
								</td>
								<td style="height:23px;width:90px">
									结账日期：
								</td>
								<td style="height:23px;width:150px" id="dayin-date">
									
								</td>
								
							</tr>
							<tr style="text-align: center">
								<td style="height:23px;width:90px">
									住院号：
								</td>
								<td style="height:23px;width:150px" id="dayin-zhuyuanhao">
									
								</td>
								<td style="height:23px;width:90px">
									病人姓名：
								</td>
								<td style="height:23px;width:150px" id="dayin-bingrenname">
									
								</td>
								
							</tr>
							<tr style="text-align: center">
								<td style="height:23px;width:90px">
									已结总额：
								</td>
								<td style="height:23px;width:150px" id="yijiezonger">
									
								</td>
								<td style="height:23px;width:90px">
									已核应收金额：
								</td>
								<td style="height:23px;width:150px" id="yiheyingshoujiner">
									
								</td>
								
							</tr>
							<tr style="text-align: center">
								<td style="height:23px;width:90px">
									实收金额：
								</td>
								<td style="height:23px;width:150px" id="shishoujiner">
									
								</td>
								
								
							</tr>
							<tr height="25px"></tr>
						</thead>
					</table>
					<table border="1" id="jiezhang-dayin-table" cellpadding="0" cellspacing="0" style="border-collapse: collapse;" width="100%">
						<thead>
							<tr>
								<th>*</th>
								<th>收费项目编号</th>
								<th>收费项目名称</th>
								<th>数量</th>
								<th>金额</th>
								<th>状态</th>
								<th>处方号</th>
								<th>住院号</th>
							</tr>
							<tbody>
								
							</tbody>
						</thead>
						
					</table>
				</div>
				
				<a class="easyui-linkbutton" id="jiezhang-dayin-input"
					style="width: 60px; margin-top: 2px;margin-right: 2px;margin-bottom: 2px"
					data-options="iconCls:'icon-print'">打印
				</a>
	
			</div>
			
		</div>
	<script type="text/javascript">
	
		function selectHesuanJilu(row){
			row = $("#zydj-table").datagrid("getSelected");
			if(row.hospitalRegistrationState =='已出院'){
				$.messager.alert("提示","该病人已出院！");
				return;
			}
			$("#jiezhang-form").form('load',row);
			$.getJSON("select_shouqu_money" , {number : row.hospitalRegistrationId} , function(data){
				var yushouMoney = 0.0;
				
				for (var i = 0; i <= data.length - 1; i++) {
					
					yushouMoney +=data[i].rushShouquYushouMoney; 
					//alert(yushouMoney);
					$("#zhuyuanjiezhang-rushShouquYushouMoney").textbox("setValue",yushouMoney);
				} 
				//$("#zhuyuanjiezhang-rushShouquYushouMoney").textbox("setValue",data.rushShouquYushouMoney);
			});
			$("#zhuyuanjiezhang-medicalCardName").textbox("setValue",row.hospitaNotify.outpaitentRegist.medicalCard.medicalCardName);
			/* selectzhuyuanjiezhangtable(); */
			$("#zhuyuanjiezhang-yihesuan-table").datagrid("load" , "select_all_feiyonghesuan?hospitalRegistrationId="+row.hospitalRegistrationId);
			$("#zhuyuanjiezhang-feiyongqingdan-table").datagrid("load" , "select_all_feiyonghesuan?hospitalRegistrationId="+row.hospitalRegistrationId);
			$("#zhuyuanjiezhang-yihesuan-table").datagrid({onLoadSuccess : function(){
				var rows = $("#zhuyuanjiezhang-yihesuan-table").datagrid('getRows');
				
				for (var i =rows.length -1; i >=0; i--) {
					if(rows[i].shoufeistate=="未"||rows[i].shoufeistate=="结"){
						$("#zhuyuanjiezhang-yihesuan-table").datagrid('deleteRow',i);
					}
					
				}
				
			}});
			$("#zhuyuanjiezhang-feiyongqingdan-table").datagrid({onLoadSuccess : function(){
				var rows = $("#zhuyuanjiezhang-feiyongqingdan-table").datagrid('getRows');
				for (var i =rows.length -1; i >=0; i--) {
					if(rows[i].shoufeistate=="未"){
						$("#zhuyuanjiezhang-feiyongqingdan-table").datagrid('deleteRow',i);
					}
					
				}
				
			}});
			jisuanMoney(); 
			$("#jiezhang-select-zhuyuandengjijilu").window("close");
		}
		function totable(){
			 var rows = $("#zhuyuanjiezhang-feiyongqingdan-table").datagrid("getRows");
			 $('.clear-tr').remove();
			 for(var i = 0; i< rows.length; i++){
				 var trr = $("<tr class='clear-tr' style='text-align : center;height : 20px'></tr>");
				 trr.append("<td>"+rows[i].id+"</td>");
				 trr.append("<td>"+rows[i].shoufeinumber+"</td>");
				 trr.append("<td>"+rows[i].shoufeiname+"</td>");
				 trr.append("<td>"+rows[i].shuliang+"</td>");
				 trr.append("<td>"+rows[i].zmoney+"</td>");
				 trr.append("<td>"+rows[i].shoufeistate+"</td>");
				 trr.append("<td>"+rows[i].chufanghao+"</td>");
				 trr.append("<td>"+rows[i].zhuyuandengjihao+"</td>");
				 trr.appendTo("#jiezhang-dayin-table");
			 }
		 }
		$(function() {
			//打印
			$("#jiezhang_btn_dayin").linkbutton({onClick : function(){
				
				$("#dayin-zhuyuanfeiyonghao").html($("#jiezhang_number").textbox("getValue"));
				$("#dayin-date").html($("#jiezhang-date").textbox("getValue"));
				$("#dayin-zhuyuanhao").html($("#jiezhan-zhuyuanhao").textbox("getValue"));
				$("#dayin-bingrenname").html($("#zhuyuanjiezhang-medicalCardName").textbox("getValue"));
				$("#yijiezonger").html($("#zhuyuanjiezhang-zhuyuanJiezhangZmoney").textbox("getValue"));
				$("#yiheyingshoujiner").html($("#zhuyuanjiezhang-zhuyuanJiezhangYhmoney").textbox("getValue"));
				$("#shishoujiner").html($("#zhuyuanjiezhang-zhuyuanJiezhangYsmoney").textbox("getValue"));
				totable();
				
				for (var i = 0; i <6; i++) {
					var trr = $("<tr align='center' class='clear-tr' height='20px'></tr>");
					for (var j = 0; j < 8; j++) {
						trr.append('<td></td>');
					}
					trr.appendTo('#jiezhang-dayin-table');
				}
				$("#zhuyuanfeiyong-dayin-window").window("open");
			}});
			
			$(document).ready(function(){
				$('#jiezhang-dayin-input').linkbutton({onClick :function(){
					$('.dayin-dayin-div').printArea();
				}});
			});
			
			$.get("get_number_jiezhang", function(data) {
				$("#jiezhang_number").textbox("setValue",
						data.substring(1, data.length - 1));
			});
			
			$("#jiezhang-zhuyuandengjihao").linkbutton({
				onClick : function() {
					$("#jiezhang-select-zhuyuandengjijilu").window("open");
				}
			});
			/* $("#jiezhang-select-zhuyuandengjijilu").window({onLoad : function(){
				
				$("#zhuyuandengji-queding").linkbutton({onClick : function(){
					row = $("#zydj-table").datagrid("getSelected");
					//alert(JSON.stringify(row));
					$("#jiezhang-form").form('load',row);
					$.getJSON("select_shouqu_money" , {number : row.hospitalRegistrationId} , function(data){
						$("#zhuyuanjiezhang-rushShouquYushouMoney").textbox("setValue",data.rushShouquYushouMoney);
					});
					$("#zhuyuanjiezhang-medicalCardName").textbox("setValue",row.hospitaNotify.outpaitentRegist.medicalCard.medicalCardName);
					//$("#hospitalNotifyCashYanjin").textbox("setValue",row.hospitaNotify.hospitalNotifyCashYanjin);
					selectzhuyuanjiezhangtable();
					jisuanMoney();
					$("#jiezhang-select-zhuyuandengjijilu").window("close");
				}});
				$("#zydj-table").datagrid({onDblClickRow : function(index , rows){
					row=rows;
					$("#jiezhang-form").form('load',rows);
					$.getJSON("select_shouqu_money" , {number : row.hospitalRegistrationId} , function(data){
						$("#zhuyuanjiezhang-rushShouquYushouMoney").textbox("setValue",data.rushShouquYushouMoney);
					});
					
					$("#zhuyuanjiezhang-medicalCardName").textbox("setValue",row.hospitaNotify.outpaitentRegist.medicalCard.medicalCardName);
					//$("#hospitalNotifyCashYanjin").textbox("setValue",row.hospitaNotify.hospitalNotifyCashYanjin);
					selectzhuyuanjiezhangtable();
					jisuanMoney();
					$("#jiezhang-select-zhuyuandengjijilu").window("close");
				}});
				
			}}); */
			$("#jiezhang_btn_dispose").linkbutton({
				onClick : function() {
					if($("#zhuyuanjiezhang-yihesuan-table").datagrid('getRows') ==0){
						 $.messager.alert('提示' , '住院费用已全部结账!');
						 return ;
					}
					var yue=$("#zhuyuanjiezhang-rushShouquYushouMoney").textbox("getValue");
					var jie=$("#zhuyuanjiezhang-zhuyuanJiezhangYqmoney").textbox("getValue");
					var zong=$("#zhuyuanjiezhang-zhuyuanJiezhangZmoney").textbox("getValue");
					var jin = zong - jie;
					
					var money= yue - jin;
					
					if (money<0) {
						$.messager.alert('提示' , '余额不足!');
						 return ;
					}
					
					$("#jiezhang-form").form("submit", {
						url : 'add_zhuyuanjiezhang',
						onSubmit : function(data) {
							return $(this).form("validate");
						},
						success : function(datas) {
							var json = eval("(" + datas + ")");
							if (json.error) {
								//$('#jiezhang_btn_dayin').linkbutton('enable');
								
							} else {
								$.messager.alert("提示", json.message);
								
							}
						}
					});
					$.messager.alert("提示" , "处理成功!");
					$("#jiezhang-form").form("reset");
					$.get("get_number_jiezhang", function(data) {
						$("#jiezhang_number").textbox("setValue",
								data.substring(1, data.length - 1));
					});
					var row = $("#zhuyuanjiezhang-yihesuan-table").datagrid('getRows');
					for (var i =row.length -1; i >=0; i--) {
						$("#zhuyuanjiezhang-yihesuan-table").datagrid('deleteRow',i);
					}
					var rows = $("#zhuyuanjiezhang-feiyongqingdan-table").datagrid('getRows');
					for (var i =rows.length -1; i >=0; i--) {
						$("#zhuyuanjiezhang-feiyongqingdan-table").datagrid('deleteRow',i);
					}
				}
			});
			//新建
			$("#jiezhang_btn_add").linkbutton({
				onClick : function() {
					var yue=$("#zhuyuanjiezhang-rushShouquYushouMoney").textbox("getValue");
					if (yue<0) {
						ret
					}
					alert(yue);
					$("#jiezhang-form").form("reset");
					$.get("get_number_jiezhang", function(data) {
						$("#jiezhang_number").textbox("setValue",
								data.substring(1, data.length - 1));
					});
					var row = $("#zhuyuanjiezhang-yihesuan-table").datagrid('getRows');
					for (var i =row.length -1; i >=0; i--) {
						$("#zhuyuanjiezhang-yihesuan-table").datagrid('deleteRow',i);
					}
					var rows = $("#zhuyuanjiezhang-feiyongqingdan-table").datagrid('getRows');
					for (var i =rows.length -1; i >=0; i--) {
						$("#zhuyuanjiezhang-feiyongqingdan-table").datagrid('deleteRow',i);
					}
				}
			});
		});
		//查询table里数据
		/* function selectzhuyuanjiezhangtable(){
			$("#zhuyuanjiezhang-yihesuan-table").datagrid("load" , "select_all_feiyonghesuan?hospitalRegistrationId="+row.hospitalRegistrationId);
			$("#zhuyuanjiezhang-feiyongqingdan-table").datagrid("load" , "select_all_feiyonghesuan?hospitalRegistrationId="+row.hospitalRegistrationId);
			$("#zhuyuanjiezhang-yihesuan-table").datagrid({onLoadSuccess : function(){
				var rows = $("#zhuyuanjiezhang-yihesuan-table").datagrid('getRows');
				
				for (var i =rows.length -1; i >=0; i--) {
					if(rows[i].shoufeistate=="未"||rows[i].shoufeistate=="结"){
						$("#zhuyuanjiezhang-yihesuan-table").datagrid('deleteRow',i);
					}
					
				}
				
			}});
			$("#zhuyuanjiezhang-feiyongqingdan-table").datagrid({onLoadSuccess : function(){
				var rows = $("#zhuyuanjiezhang-feiyongqingdan-table").datagrid('getRows');
				
				for (var i =rows.length -1; i >=0; i--) {
					if(rows[i].shoufeistate=="未"){
						$("#zhuyuanjiezhang-feiyongqingdan-table").datagrid('deleteRow',i);
					}
					
				}
				
			}});
			
		} */
	
		function jisuanMoney(){
			
			$("#zhuyuanjiezhang-yihesuan-table").datagrid({onLoadSuccess : function(){
				var rows = $("#zhuyuanjiezhang-yihesuan-table").datagrid('getRows');
				for (var i =rows.length -1; i >=0; i--) {
					
					if(rows[i].shoufeistate !="核"){
						$("#zhuyuanjiezhang-yihesuan-table").datagrid('deleteRow',i);
					}
					
				}
				var money = 0.0;
				for (var i = 0; i < rows.length; i++) {
					money +=rows[i].zmoney;
				}
				$("#zhuyuanjiezhang-zhuyuanJiezhangYhmoney").textbox("setValue",money);
				$("#zhuyuanjiezhang-zhuyuanJiezhangYsmoney").textbox("setValue",money);
				
			}});
			$("#zhuyuanjiezhang-feiyongqingdan-table").datagrid({onLoadSuccess : function(){
				var rows = $("#zhuyuanjiezhang-feiyongqingdan-table").datagrid('getRows');
				for (var i =rows.length -1; i >=0; i--) {
					if(rows[i].shoufeistate=="未"){
						$("#zhuyuanjiezhang-feiyongqingdan-table").datagrid('deleteRow',i);
					}
					
				}
				var money = 0.0;
				var moneyQ = 0.0;
				for (var i = 0; i < rows.length; i++) {
					if(rows[i].shoufeistate =="结"){
						moneyQ +=rows[i].zmoney;
					}
					
					money +=rows[i].zmoney;
				}
				
				$("#zhuyuanjiezhang-zhuyuanJiezhangZmoney").textbox("setValue",money);
				$("#zhuyuanjiezhang-zhuyuanJiezhangYqmoney").textbox("setValue",moneyQ);
				if(boo){
					$("#zhuyuanjiezhang-rushShouquYushouMoney").textbox("setValue",
							$("#zhuyuanjiezhang-rushShouquYushouMoney").textbox("getValue")
							-moneyQ);
					boo =false;
				}
			}});
			var boo = true;
		};
		
		
	</script>
</body>
</html>