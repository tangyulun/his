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
<title>药品退货</title>
</head>
<body>

	<script type="text/javascript">
		$(function(){
			$.get("to_return",function(data){
				$("#tuihuoid").textbox('setValue',data.substring(1,data.length-1));
			});
			
			$("#tuihuo_xinjian").linkbutton({onClick : function(){
				$("#tuihuo-chuli-form").form('reset');
				//自动生成采购订单号
				$.get("to_return",function(data){
					$("#tuihuoid").textbox('setValue',data.substring(1,data.length-1));
				});
				$.get("to_clear_tuihuo_xq" ,function(){
					$("#tuihuo-yanshou-xq-table").datagrid("reload" , 'to_find_tuihuo_xq');
				});
			}});
		});
	</script>
	
	<div id="" class="easyui-layout" title="药品登入" data-options="fit:true">
		<div data-options="region:'north',split:true" style="height:50px">
			<a id="tuihuo_xinjian" href="#" data-options="iconCls:'icon-add',plain:true" class="easyui-linkbutton" style="width:80px;margin-top:10px;margin-left:10px">新建</a>
 			<!-- <a id="" href="#" class="easyui-linkbutton" style="width:80px;margin-top:10px;m">打开</a>
 			<a id="" href="#" class="easyui-linkbutton" style="width:80px;margin-top:10px;">挂单</a> -->
 			<a id="tuihuo_chuli" href="#" data-options="iconCls:'icon-ok',plain:true" class="easyui-linkbutton" style="width:80px;margin-top:10px;">退货处理</a>
		</div>
		<div data-options="region:'center',split:true" style="height:340px">
			<form action="" method="post" id="tuihuo-chuli-form">
				<table width="100%" style="padding: 10px;border-spacing:10px;">
					<tr>
						<td><input class="easyui-textbox" name="drugTuihuoId" readonly="readonly" id="tuihuoid" data-options="label:'药品退货号*',width:240,labelAlign:'right'"></td>
						<td><input class="easyui-textbox" name="drugTuihuoState" readonly="readonly" data-options="required:true,label:'状态',width:240,labelAlign:'right',value:'待退货'"></td>
						<td><input class="easyui-datebox" name="drugTuihuoDate" value="new Date()" data-options="required:true,label:'退货日期',width:240,labelAlign:'right',editable : false"></td>
						<td>
							<select name="empId" id="empId" class="easyui-combobox"
	 	 						 data-options="editable:false,label:'采购员' , width:240 , labelAlign : 'right' , editable : false">
									<option  value="${empMessage.empId}">${empMessage.empLoginName}</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>
							<input name="drugAcceptanceId" class="easyui-textbox" id="tuihuo-yanshou-id" data-options="
							required:true,
							buttonText : '…',
							onClickButton : function(){
								
							}
							,
							editable : false,
							required:true,width:260,label:'药品验收号',labelAlign:'right'">
						</td>
						<td><input class="easyui-textbox" name="drugTuihuoPzId" id="tuihuo-yanshou-pzdh" readonly="readonly" data-options="required:true,label:'凭证单号',width:240,labelAlign:'right'"></td>
						
						<td><input class="easyui-textbox" name="supplierLxr" id="tuihuo-yanshou-lxr" readonly="readonly" data-options="required:true,label:'联系人',width:240,labelAlign:'right'"></td>
						<td><input class="easyui-textbox" name="supplierPhone" id="tuihuo-yanshou-phone" readonly="readonly" data-options="required:true,label:'电话',width:240,labelAlign:'right'"></td>
					</tr>
					<tr>
						<td colspan="2">
							<input class="easyui-textbox" name="supplierId" id="tuihuo-yanshou-supp-id" readonly="readonly" data-options="required:true,label:'供应商',width:200,labelAlign:'right'">
							<input name="supplierName" id="tuihuo-yanshou-supp-name" class="easyui-textbox" readonly="readonly" data-options="required:true,width:240">
						</td>
						<td><input class="easyui-textbox" id="tuihuo-yanshou-je" readonly="readonly" name="drugTuihuoMoney" data-options="required:true,label:'退货金额',width:240,labelAlign:'right',value:'0.00'"></td>
					</tr>
				</table>
			</form>
		</div>
		<div data-options="region:'south',split:true" style="height:340px">
			<table class="easyui-datagrid" id="tuihuo-yanshou-xq-table" data-options="rownumbers:true,fit:true,singleSelect : true,fitColumns: true,method:'get'">
				<thead style="margin-left:10px;">
					<tr>
						<th data-options="field:'ypid',width:10,align:'center'">药品编号</th>
						<th data-options="field:'ypname',width:10,align:'center'">药品名称</th>
						<th data-options="field:'buhegenum',width:10,align:'center'">数量</th>
						<th data-options="field:'dj',width:10,align:'center'">单价</th>
						<th data-options="field:'je',width:10,align:'center'">金额</th>
						<th data-options="field:'ph',width:10,align:'center'">批号</th>
						<th data-options="field:'bz',width:10,align:'center'">备注</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
	
	<!-- 验收窗口  -->
	<div id="tuihuo_yanshou_window" class="easyui-window" title="入库对象" style="width:850px;height:500px"
		data-options="modal:true,collapsible:false,
	 	minimizable:false,maximizable:false,closed:true , href: 'href_address?myValue=drugstorage/tuihuo_window'">
	 	
	 </div>
	 	
	 	
	 	<script type="text/javascript">
	 	var row = null;
	 	
	 	function tuihuo(rows){
	 		$("#tuihuo-yanshou-id").textbox("setValue" , rows.drugAcceptanceId);
				$("#tuihuo-yanshou-pzdh").textbox("setValue" , rows.drugAcceptancePzdh);
				$("#tuihuo-yanshou-lxr").textbox("setValue" , rows.drugPurchase.supplier.supplierLxr);
				$("#tuihuo-yanshou-phone").textbox("setValue" , rows.drugPurchase.supplier.supplierPhone);
				$("#tuihuo-yanshou-supp-id").textbox("setValue" , rows.drugPurchase.supplier.supplierId);
				$("#tuihuo-yanshou-supp-name").textbox("setValue" , rows.drugPurchase.supplier.supplierName);
				$("#tuihuo-yanshou-xq-table").datagrid({url : 'to_select_tuihou_xq'});
				$("#tuihuo-yanshou-xq-table").datagrid('load' , {drugAcceptanceId : rows.drugAcceptanceId});
				$("#tuihuo_yanshou_window").window("close");
				jisuan("#tuihuo-yanshou-xq-table");
	 	}
	 		$(function(){
	 			$.get("to_clear_tuihuo_xq",function(){});
	 			
	 			$("#tuihuo-yanshou-id").textbox({onClickButton : function(){
	 				$("#tuihuo_yanshou_window").window("refresh" , "href_address?myValue=drugstorage/tuihuo_window");
	 				$("#tuihuo_yanshou_window").window("open");
	 			}});
	 			
	 			$("#tuihuo_yanshou_window").window({onLoad : function(){
		 			$("#tuihuo-table").datagrid({onDblClickRow : function(index , rows){
		 				tuihuo(rows);
		 			}});
		 			$("#tuihuo-yanshou-window-button").linkbutton({onClick : function(){
		 				row=$("#tuihuo-table").datagrid("getSelected");
		 				if(row == null){
		 					$.messager.alert('提示' , '请至少选择一条数据!');
		 					return ;
		 				}
		 				tuihuo(row);
		 			}});
	 			}});
	 			
	 			$("#tuihuo_chuli").linkbutton({onClick : function(){
	 				if($("#tuihuo-yanshou-xq-table").datagrid('getRows')==0){
	 					$.messager.alert('提示' , '请至少选择一条数据处理!');
						 return ;
	 				}
	 				TuihuoDeal();
	 			}});
	 			
	 		});
	 		
	 		
	 		function TuihuoDeal(){
	 			$("#tuihuo-chuli-form").form("submit",{
	 				url : "to_insert_tuihuo_chuli",
	 				onSubmit : function(data){
						return $(this).form("validate");
					},
					success : function(data){
						var json = eval("("+data+")");
						if(json.error){ 
							//删掉
							$.messager.alert("提示","操作成功！");
							$("#tuihuo-chuli-form").form('reset');
							//自动生成采购订单号
							$.get("to_return",function(data){
								$("#tuihuoid").textbox('setValue',data.substring(1,data.length-1));
							});
							$.get("to_clear_tuihuo_xq" ,function(){
								$("#tuihuo-yanshou-xq-table").datagrid("reload" , 'to_find_tuihuo_xq');
							});
						}else{
							$.messager.alert("提示",json.eMessage);
						} 
					}
	 			});
	 		}
	 		
	 		
	 		function jisuan(id){
	 			$(id).datagrid({onLoadSuccess : function(){
					var rows = $(id).datagrid('getRows');	
					var money = 0.0;
					for (var i = 0; i < rows.length; i++) {
						money +=rows[i].je;
					}
					$("#tuihuo-yanshou-je").textbox('setValue' , money);
	 			}});
			}
	 		
	 		
	 	</script>
</body>
</html>