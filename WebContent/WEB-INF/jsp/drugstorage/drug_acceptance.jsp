<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="<c:url value="/js/easyui/themes/default/easyui.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/js/easyui/themes/icon.css"/>">
	<script type="text/javascript" src="<c:url value="/js/jquery-3.1.0.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/easyui/jquery.easyui.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/easyui/easyui-lang-zh_CN.js"/>"></script>
<title>药品验收</title>
</head>
<body>
	
	<script type="text/javascript">
		$(function(){
			$.get("to_acceptance",function(data){
				$('#a_number').textbox('setValue',data.substring(1,data.length-1));
			});
		});
	</script>

	<div id="" class="easyui-layout" title="药品登入" data-options="fit:true">
		<div data-options="region:'north',split:true" style="height:50px">
			<a id="reset_yanshou" href="#" data-options="iconCls:'icon-add',plain:true" class="easyui-linkbutton" style="width:80px;margin-top:10px;margin-left:10px">新建</a>
 			<!-- <a id="" href="#" class="easyui-linkbutton" style="width:80px;margin-top:10px;">打开</a>
 			<a id="yanshouguadan" href="#" class="easyui-linkbutton" style="width:80px;margin-top:10px;">挂单</a> -->
 			<a id="yanshouchuli" href="#" data-options="iconCls:'icon-ok',plain:true" class="easyui-linkbutton" style="width:80px;margin-top:10px;">验收处理</a>
		</div>
		<div data-options="region:'center',split:true" style="height:340px">
			<form action="" method="post" id="yanshou-form">
				<table width="100%" style="padding: 10px;border-spacing:10px;">
					<tr>
						<td><input class="easyui-textbox" id="a_number" name="drugAcceptanceId" readonly="readonly" data-options="label:'收货单编号*',width:240,labelAlign:'right'"></td>
						<td><input class="easyui-textbox"  id="caigouzt" name="drugAcceptanceZt" readonly="readonly" data-options="label:'状态',width:240,labelAlign:'right',value:'未验收'"></td>
						<td><input class="easyui-datebox" name="drugAcceptanceShdate" value="new Date()" data-options="required:true,label:'收货日期',width:240,labelAlign:'right',editable : false"></td>
						<td>
							<select name="empId" id="empId" class="easyui-combobox"
	 	 						 data-options="editable:false,label:'采购员' , width:240 , labelAlign : 'right' , editable : false">
									<option  value="${empMessage.empId}">${empMessage.empLoginName}</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>
							<input class="easyui-textbox" id="caigoubianhao" name="drugPurchaseId" name="drugPurchaseId" data-options="
							buttonText : '…' ,
							required:true,
							editable:false,
							onClickButton : function(){
								selectCaigouDingdantjian(function(row){
									caigoudindan(row);
								} , '已处理');
							},
							
							label:'采购订单号',width:260,labelAlign:'right'">
							
						</td>
						<td><input class="easyui-textbox" id="pingzhendanhao" name="drugAcceptancePzdh" readonly="readonly" data-options="required:true,label:'凭证单号',width:240,labelAlign:'right'"></td>
						<td colspan="2">
							<input class="easyui-textbox" id="supplierId" readonly="readonly" name="supplierId" data-options="required:true,label:'供应商*',width:200,labelAlign:'right'">
 							<input name="supplierName" id="supplierName" readonly="readonly" class="easyui-textbox" data-options="required:true,width:240">
						</td>
					</tr>
					<tr>
						<td><input class="easyui-textbox" id="phoneman" readonly="readonly" name="supplierLxr" data-options="required:true,label:'联系人',width:240,labelAlign:'right'"></td>
						<td><input class="easyui-textbox" id="phonenumber" readonly="readonly" name="supplierPhone" data-options="required:true,label:'电话',width:240,labelAlign:'right'"></td>
						<td><input class="easyui-textbox" name="drugPurchaseMoney" readonly="readonly" id="shouhujine" data-options="required:true,label:'收货金额',width:240,labelAlign:'right',value:'0.00'"></td>
						<td>
							<select name="" id="" class="easyui-combobox"
	 	 						 data-options="editable:false,label:'验收员' , width:240 , labelAlign : 'right' , editable : false">
									<option  value="${empMessage.empId}">${empMessage.empLoginName}</option>
							</select>
						</td>
					</tr>
				</table>
			</form>
		</div>
		<div data-options="region:'south',split:true" style="height:340px">
			<table id="yanshou_table" class="easyui-datagrid"
			 data-options="rownumbers:true,singleSelect : true,fitColumns: true,method : 'get',fit : true">
				<thead style="margin-left:10px;">
					<tr>
						<th data-options="field:'ypId',width:100,align:'center'">药品编号</th>
						<th data-options="field:'ypName',width:100,align:'center'">药品名称</th>
						<th data-options="field:'drugdw',width:100,align:'center'">单位</th>
						<th data-options="field:'dj',width:100,align:'center'">单价</th>
						<th data-options="field:'je',width:100,align:'center'">金额</th>
						<th data-options="field:'ph',width:100,align:'center'">批号</th>
						<th data-options="field:'hgnum',width:100,align:'center', editor : 'numberbox' ,
							styler: function(value,row,index){
								return 'color:red;  font-weight:bold';
							}
						">合格数</th>
						<th data-options="field:'zongnum',width:100,align:'center'">总数量</th>
						<th data-options="field:'bz',width:100,align:'center'">备注</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
	
	 <!-- 采购订单管理 -->
	 <div id="caiguodindanId" class="easyui-window" title="打开挂单" style="width:850px;height:500px" 
	 	data-options="modal:true,collapsible:false,
	 	minimizable:false,maximizable:false,closed:true,
	 	href:'href_address?myValue=/drugstorage/open_caigouguadan_window'"></div>
	 	
		 <script type="text/javascript">
			 $(function(){
				/*  $("#caigouId").linkbutton({onClick : function(){
					 $("#caiguodindanId").window('refresh','href_address?myValue=/drugstorage/open_caigouguadan_window');
					 $("#caiguodindanId").window('open');
				 }}); */
				 
				 //点击新建时刷新数据
				 $("#reset_yanshou").linkbutton({onClick : function(){
					 $("#yanshou-form").form('reset');
						//自动生成采购订单号
						$.get("to_acceptance",function(data){
							$('#a_number').textbox('setValue',data.substring(1,data.length-1));
						});
						$.get("to_clear" ,function(){
							$("#yanshou_table").datagrid("reload" , 'to_findAll');
						}); 
						$("#yanshou_table").datagrid({onLoadSuccess : function(){
		 					var tables =$("#yanshou_table").datagrid('getRows');
		 					var money = 0.0 ;
		 					for (var i = 0; i < tables.length; i++) {
								money +=tables[i].je;
							}
		 					$("#shouhujine").textbox('setValue' , money);
		 				}});
				 }});
				$("#yanshouchuli").linkbutton({onClick : function(){
					if($("#yanshou_table").datagrid('getRows') ==0){
						 $.messager.alert('提示' , '请至少选择一条数据处理!');
						 return ;
					}
					guadanAndDeal();
				}});
				indexs = -1;
				//双击修改
			 	$("#yanshou_table").datagrid({onDblClickRow : function(index ,  row ){
					 //开始编辑状态=beginEdit  
					 indexs = index;
			 			$('#yanshou_table').datagrid('beginEdit', index);//获取小标开始进行编辑
				}}); 
			 	//双击修改
			 	$("#yanshou_table").datagrid({onClickRow : function(index ,  row ){
			 		if(indexs != -1){
				 		$('#yanshou_table').datagrid('endEdit', indexs);  //获取下标结束编辑
			 			$("#yanshou_table").datagrid('selectRow' , indexs);
			 			var rows = $("#yanshou_table").datagrid('getSelected');
			 			$.get("update_table_ys" , {id : rows.id , hgnum : rows.hgnum}, function(){
			 				$("#yanshou_table").datagrid("reload" , 'to_findAll');
			 				$("#yanshou_table").datagrid({onLoadSuccess : function(){
			 					var tables =$("#yanshou_table").datagrid('getRows');
			 					var money = 0.0 ;
			 					for (var i = 0; i < tables.length; i++) {
									money +=tables[i].je;
								}
			 					$("#shouhujine").textbox('setValue' , money);
			 				}});
			 			});
			 			indexs = -1;
			 		}
				}}); 
			 })
			 
			  function selectMoney(){
				 $.get("to_select_money" , function(data){
					 $("#shouhujine").textbox("setValue" , data);
				 });
			 } 
			
			 //点击打开时选择一条数据并将值传到采购页面
			 var maxnum = null;
			function caigoudindan(row){
				$("#pingzhendanhao").textbox('setValue','PZ'+row.drugPurchaseId.substring(2,row.drugPurchaseId.length));
				$("#caigoubianhao").textbox('setValue',row.drugPurchaseId);
				$("#empId").textbox('setValue',row.emp.empId);
				$("#supplierId").textbox('setValue',row.supplier.supplierId);
				$("#supplierName").textbox('setValue',row.supplier.supplierName);
				$("#shouhujine").textbox('setValue',row.drugPurchaseMoney);
				$("#phoneman").textbox('setValue',row.supplier.supplierLxr);
				$("#phonenumber").textbox('setValue',row.supplier.supplierPhone);
				$.get("to_clear" ,function(){});
				$("#yanshou_table").datagrid({url : 'to_select_Yanshou'});
				$("#yanshou_table").datagrid('load', {drugPurchaseId : row.drugPurchaseId});
				$("#yanshou_table").datagrid({onLoadSuccess : function(){
 					var tables =$("#yanshou_table").datagrid('getRows');
 					var money = 0.0 ;
 					for (var i = 0; i < tables.length; i++) {
						money +=tables[i].je;
					}
 					$("#shouhujine").textbox('setValue' , money);
 				}});
				
			}
			 
			 function guadanAndDeal(){
				if($("#caigouzt").textbox('getValue') == '已验收'){
					$.messager.alert("提示","不能重复处理该订单");
					return;
				}
				$("#yanshou-form").form("submit",{
					url : "to_insert_guadan_and_chuli",
					onSubmit : function(data){
						return $(this).form("validate");
					},
					success : function(data){
						var json = eval("("+data+")");
						if(json.error){ 
							$.messager.alert("提示" ,"操作成功!");
								$("#yanshou-form").form('reset');
								//自动生成采购订单号
								$.get("to_acceptance",function(data){
									$('#a_number').textbox('setValue',data.substring(1,data.length-1));
								});
								$.get("to_clear" ,function(){
									$("#yanshou_table").datagrid("reload" , 'to_findAll');
								}); 
						}else{
							$.messager.alert("提示",json.eMessage);
						} 
					}
				});
			}
		 </script>
</body>
</html>