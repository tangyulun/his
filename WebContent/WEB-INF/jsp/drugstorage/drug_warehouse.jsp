<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="<c:url value="/js/easyui/themes/default/easyui.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/js/easyui/themes/icon.css"/>">
	<script type="text/javascript" src="<c:url value="/js/jquery-3.1.0.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/easyui/jquery.easyui.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/easyui/easyui-lang-zh_CN.js"/>"></script>
<title>药品入库</title>
</head>
<body>
	
	 <script type="text/javascript">
		$(function(){
			$.get("to_warehouse",function(data){
				$("#rukuid").textbox('setValue',data.substring(1,data.length-1));
			});
		});
	</script> 

	<div id="" class="easyui-layout" title="药品登入" data-options="fit:true">
		<div data-options="region:'north',split:true" style="height:50px">
			<a id="reset_ruku" href="#" data-options="iconCls:'icon-add',plain:true" class="easyui-linkbutton" style="width:80px;margin-top:10px;margin-left:10px">新建</a>
 			<!-- <a id="" href="#" class="easyui-linkbutton" style="width:80px;margin-top:10px;">打开</a> -->
 			<a id="ruku_chuli" href="#" data-options="iconCls:'icon-ok',plain:true" class="easyui-linkbutton" style="width:80px;margin-top:10px;">入库处理</a>
		</div>
		<div data-options="region:'center',split:true" style="height:340px">
			<form action="" method="post" id="ruku_form">
				<table width="100%" style="padding: 10px;border-spacing:10px;">
					<tr>
						<td><input class="easyui-textbox" name="drugWarehouseId" readonly="readonly" id="rukuid" data-options="label:'入库单号*',width:240,labelAlign:'right'"></td>
						<td><input class="easyui-textbox" id="rukuzt" name="drugWarehouseZt" readonly="readonly" data-options="label:'状态',width:240,labelAlign:'right',value:'待入库'"></td>
						<td><input class="easyui-datebox" name="drugWarehouseRkdate" value="new Date()" data-options="required:true,editable:false,label:'入库日期',width:240,labelAlign:'right'"></td>
						<td><input class="easyui-textbox" name="drugWarehouseRklx" readonly="readonly" data-options="required:true,label:'入库类型*',width:240,labelAlign:'right',value:'采购入库'"></td>
					</tr>
					<tr>
						<td>
							<input class="easyui-textbox" name="drugAcceptanceId"  id="rukuduixiang" data-options="
							buttonText : '…',
							required:true,
							editable : false,
							onClickButton : function(){
								selectYanshouRuku(function(row){
									yanshouguadan(row);
								} , '已验收');
							},
							label:'验收单号*',width:260,labelAlign:'right'">
						</td>
						<td>
							<select name="" id="" class="easyui-combobox"
	 	 						 data-options="editable:false,label:'仓库*' , width:240 , labelAlign : 'right' , editable : false">
									<option  value="中药库">中药库</option>
									<option  value="西药库">西药库</option>
							</select>
						</td>
						<td><input class="easyui-textbox" name="drugWarehousePzdh" id="pzdh" readonly="readonly" data-options="required:true,label:'凭证单号',width:240,labelAlign:'right'"></td>
						<td>
							<select name="empId" id="empId" class="easyui-combobox"
	 	 						 data-options="editable:false,label:'经手人' , width:240 , labelAlign : 'right' , editable : false">
									<option  value="${empMessage.empId}">${empMessage.empLoginName}</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>
							<select name="drugWarehouseCgy" id="" class="easyui-combobox"
	 	 						 data-options="editable:false,label:'采购员' , width:240 , labelAlign : 'right' , editable : false">
									<option  value="${empMessage.empId}">${empMessage.empLoginName}</option>
							</select>
						</td>
					</tr>
				</table>
			</form>
		</div>
		<div data-options="region:'south',split:true" style="height:340px">
			<table class="easyui-datagrid" id="yanshouxq_table" data-options="rownumbers:true,singleSelect : true,fitColumns: true,fit:true,method:'get'">
				<thead style="margin-left:10px;">
					<tr>
						<th data-options="field:'ypid',width:10,align:'center'">药品编号</th>
						<th data-options="field:'ypname',width:10,align:'center'">药品名称</th>
						<th data-options="field:'num',width:10,align:'center'">数量</th>
						<th data-options="field:'dw',width:10,align:'center'">单位</th>
						<th data-options="field:'cgrq',width:10,align:'center' , formatter : date">采购日期</th>
						<th data-options="field:'ph',width:10,align:'center'">批号</th>
						<th data-options="field:'bz',width:10,align:'center'">备注</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
	
	 	
	 	<script type="text/javascript">
	 		$(function(){
	 			$.get("to_clear_yanshou_all",function(){});
	 			//点击验收单号时将验收窗口打开
	 			$("#yanshouduixiang").linkbutton({onClick : function(){
	 				$("#yanshou_window").window('open');
	 			}});
	 			
	 			//点击新建时刷新
	 			$("#reset_ruku").linkbutton({onClick : function(){
	 				$("#ruku_form").form('reset');
	 				$.get("to_warehouse",function(data){
						$("#rukuid").textbox('setValue',data.substring(1,data.length-1));
					});
					$.get("to_clear_yanshou_all" ,function(){
						$("#yanshouxq_table").datagrid("reload" , 'to_findAll_yanshou');
					}); 
	 			}});
	 			var indexs = -1;
	 			//双击修改
			 	$("#yanshouxq_table").datagrid({onDblClickRow : function(index ,  row ){
					 //开始编辑状态=beginEdit  
					 indexs = index;
			 			$('#yanshouxq_table').datagrid('beginEdit', index);//获取小标开始进行编辑
				}}); 
			 	//双击修改
			 	$("#yanshouxq_table").datagrid({onClickRow : function(index ,  row ){
			 		if(indexs != -1){
				 		$('#yanshouxq_table').datagrid('endEdit', indexs);  //获取下标结束编辑
			 			$("#yanshouxq_table").datagrid('selectRow' , indexs);
			 			indexs = -1;
			 		}
				}}); 
	 			$("#ruku_chuli").linkbutton({onClick : function(){
	 				if($("#yanshouxq_table").datagrid('getRows')==0){
	 					$.messager.alert('提示' , '请至少选择一条数据处理!');
						 return ;
	 				}
	 				rukuDeal();
	 			}});
	 		});
	 		
	 		//方法，选择验收窗口中的一行数据传值
	 		function yanshouguadan(row){
	 			$("#pzdh").textbox('setValue',row.drugAcceptancePzdh);
	 			$("#rukuduixiang").textbox('setValue',row.drugAcceptanceId);
	 			$("#yanshouxq_table").datagrid({url : 'to_findruku_byAccId'})
	 			$("#yanshouxq_table").datagrid('load', {drugAcceptanceId : row.drugAcceptanceId});
	 		}
	 		
	 		
	 		function rukuDeal(){
	 			$("#ruku_form").form("submit",{
	 				url : "to_insert_ware_chuli",
	 				onSubmit : function(data){
						return $(this).form("validate");
					},
					success : function(data){
						var json = eval("("+data+")");
						if(json.error){ 
								$.messager.alert("操作" , "操作成功!");
								$("#ruku_form").form('reset');
								//自动生成采购订单号
								$.get("to_warehouse",function(data){
									$("#rukuid").textbox('setValue',data.substring(1,data.length-1));
								});
								$.get("to_clear_yanshou_all" ,function(){
									$("#yanshouxq_table").datagrid("reload" , 'to_findAll_yanshou');
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