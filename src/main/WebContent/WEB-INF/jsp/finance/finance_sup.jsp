<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 供应商结算</title>
</head>
<body class="easyui-layout">
	<script type="text/javascript">
		$(function(){
			$.get("s_number",function(data){
				$("#supplier-danhao").textbox('setValue',data.substring(1,data.length - 1));
			});
			
			$("#open-jiesuan-window").linkbutton({onClick : function(){
				$("#jie-suan-fang-shi").window('open');
			}});
		});
	</script>
         <div class="easyui-layout" data-options="fit:true">
         	  <div id="fina-top-id" data-options="region:'north'" style="height:45px;padding: 8px">
	        	<a id="fina-init" href="#" class="easyui-linkbutton" data-options="" style="width:80px">新建</a>  
				<a id="fina-ghcl" href="#" class="easyui-linkbutton" data-options="" style="width:100px;">结账处理</a>  
				<a id="fina-open" href="#" class="easyui-linkbutton" data-options="" style="width:80px;">关闭</a>  
	        </div>   
	        
	        <div data-options="region:'center',fit:true" style="height:450px;">   
         		 <form id="regist-patient-add-form" action="" method="post">
	           		<table width="100%" style="margin-left:20px">
	           			<tr height="30">
	           				<td width="250px"><input name="supplierJiesuanId" id="supplier-danhao" class="easyui-textbox" readonly="readonly" data-options="label:'供应商结账单号*' ,labelWidth : 100,width:240,labelAlign:'right'"></td>
	           				 
	           				
	           				<td>
	           					<select id="" class="easyui-combobox" name="" style="width:240px;" data-options="label : '状态' , labelWidth : 100,labelAlign:'right' , ediatble : false">   
								    <option value="0">未结账</option>   
								</select>  
	           				</td>
	           				<td>
	           				<select id="" class="easyui-combobox" name="supplierJiesuanType" style="width:240px;" data-options="label : '结账类型' , labelWidth :100,labelAlign:'right'">   
								    <option value="1">采购药品</option> 
								    <option value="2">采购器械</option>   
								</select>  
	           				</td>
	           				<td><input name="supplierJiesuanDate" class="easyui-datebox" value="new Date()" readonly="readonly" data-options="editable : false,label:'结账日期',labelWidth :100,width:240,labelAlign:'right'"></td>
	           			</tr>
	           			
	           			<tr height="30">
	           				<td >
	           					<input name="drugAcceptancePzdh" class="easyui-textbox" data-options="label:'凭证单号' , editable : false
	           					 ,labelWidth : 100,width:240,labelAlign:'right' , buttonText : '…' , onClickButton: function(){
	           					 	$('#jiesuan_gys').window('open');
	           					 	$('#jiesuan-gys-win-table').datagrid({onLoadSuccess : function(data){
									 var tables = $('#jiesuan-gys-win-table').datagrid('getRows');
									 for (var i = tables.length-1; i >=0; i--) {
										if(tables[i].drugAcceptanceZt != '已验收' &&
										tables[i].drugAcceptanceZt != '已入库'){
											$('#jiesuan-gys-win-table').datagrid('deleteRow' , i);
										}
									  }
								 }});
	           					 }">
	           					 
		           			</td>
		           			<td>
	           					<input style="margin-left: 15px" name="dealMoney" id="jiesuan-gys-dealMoney" class="easyui-textbox" data-options="label:'应付账款'
	           					 ,labelWidth :100,width:240,labelAlign:'right' , editable : false">
		           			</td>
		           			<td>
	           					 <input style="margin-left: 55px" name="outoMoney" id="jiesuan-gys-outoMoney" class="easyui-textbox" data-options="label:'实付账款'
	           					 ,labelWidth : 100,width:240,labelAlign:'right'">
	           				</td>
	           				<td><input name="supplierJiesuanTime" id="jiesuan-gys-time" class="easyui-timespinner"  data-options="editable : false,label:'结账时间',labelWidth :100,width:240,labelAlign:'right'"></td>
	           			</tr>
	           			<tr height="30">
	           				<td>
	           				<input id="settleWayId" name="settleWayId" class="easyui-combobox" data-options="
	 	 							editable:false,
									label:'结账方式',
									labelWidth :100,
									width:240,
									method:'get',
									labelAlign:'right',
									valueField:'settleWayId',
									textField:'settleWayName',
									url:'to_select_sw_fs'">
	           				</td>
	           				<td>
	           					<input name="supplierLxr" id="jiesuan-gys-supplierLxr" class="easyui-textbox" data-options="label:'联系人' , editable : false
	           					 ,labelWidth : 100,width:240,labelAlign:'right'">
	           				</td>
	           				
	           				<td>
	           					<input name="supplierPhone" id="jiesuan-gys-supplierPhone" class="easyui-textbox" data-options="label:'联系电话'  , editable : false
	           					 ,labelWidth : 100,width:240,labelAlign:'right'">
	           				</td> 
	           				<td>
	           					<select id="cc" class="easyui-combobox" name="empId" style="width:240px;" data-options="editable : false,label : '操作员' , labelWidth : 100,labelAlign:'right'"">   
								    <option value="${empMessage.empId}">${empMessage.empLoginName}</option>   
								</select> 
	           				</td>
	           			</tr>
	           		
	           			<tr height="30">
	           				<td colspan="4">
	           					<input name="supplierId" id="jiesuan-gys-supplierId" class="easyui-textbox" data-options="label:'供应商*',
	           					editable : false ,labelWidth : 100,width:240,labelAlign:'right'">
	           					 <input name="supplierName" id="jiesuan-gys-supplierName" class="easyui-textbox" data-options="editable : false,width:248,labelAlign:'right'"></td>
	           				<td>
	           			</tr>
	           		</table>	
	           </form>
	           <div id="regist-patient-add-tabs" data-options="fit:true" class="easyui-tabs" style="margin-top: 10px; height : 310px" >  
           			<div title="结账明细" style="padding:5px;display:none;">   
				       <table class="easyui-datagrid" id="jiesuan-gys-datagrid" data-options="rownumbers:true,singleSelect : true,fitColumns: true,method : 'post' , fit : true">   
						    <thead>   
						        <tr>   
						            <th data-options="field:'drugAcceptanceId',width:10,align:'center'">货单编号</th>   
						            <th data-options="field:'drugAcceptanceZt',width:10,align:'center'">货单状态</th>   
						            <th data-options="field:'drugPurchase',width:10,align:'center',
							            formatter(value , row ,index){
											return row.drugPurchase == null ? null : row.drugPurchase.drugPurchaseMoney;
										}
						            ">货单金额</th>   
						        </tr>   
						    </thead>   
						</table>  
				    </div>  
	           	</div>
         	</div>
         </div>

		 <!-- 结算验收款分类设置 -->
	 <div id="jie-suan-fang-shi" class="easyui-window" title="供应商分类设置"  style="width:400px;height:350px"
	 	 data-options="modal:true,collapsible:false,minimizable:false,maximizable:false,closed:true">
	 	 <div class="easyui-layout" data-options="fit:true">
		 	<div data-options="region:'west',split:true" style="width:250px;">
		 		<div style="margin-top:20px">
		 			<ul class="easyui-tree" name="tree-name" id="tree-ys-id"  data-options="lines:true  , method:'get',url:'select_all_shoukuan'"></ul>
		 		</div>
		 	</div>
		 	<div data-options="region:'center',split:true">
		 		<div style="margin-top:20px;padding-left:20px">
			 		<a class="easyui-linkbutton" data-options="" id="add_jiesuanys" style="width:80px">新建</a>
			 		<a class="easyui-linkbutton" data-options="" id="update_jiesuanys" style="width:80px;margin-top:10px">编辑</a>
			 		<a class="easyui-linkbutton" data-options="" id="ok_jiesuanys" style="width:80px;margin-top:100px">确定</a>
			 		<a class="easyui-linkbutton" data-options="" id="not_jiesuanys" style="width:80px;margin-top:10px">关闭</a>
		 		</div>
		 	</div>
		</div>
	 </div>
	 
	 <div id="jiesuan_gys" class="easyui-window" title="供应商结算" style="width:600px;height:400px"   
        data-options="iconCls:'icon-save',modal:true , closed : true">   
    	<table class="easyui-datagrid" id="jiesuan-gys-win-table" 
        data-options="url:'to_find_yanshou_jilu',fitColumns:true,singleSelect:true ,method:'get',
        	 fit:true , pageSize: 15 , pagination: true, pageList: [15, 30, 45, 60]">   
		    <thead>   
		        <tr>   
		            <th data-options="field:'drugAcceptancePzdh',width:3,align:'center'">凭证单号</th>   
		            <th data-options="field:'drugAcceptanceId',width:3,align:'center'">采购订单号</th>   
		            <th data-options="field:'supplier',width:2,align:'center',
		            	formatter(value , row ,index){
							return row.supplier == null ? null : row.supplier.supplierName;
						}
		            ">供应商名称</th>   
		            <th data-options="field:'drugAcceptanceZt',width:2,align:'center'">订单状态</th> 
		        </tr>   
		    </thead>   
		</table>  
	</div>  
	
	
	<script type="text/javascript">
		$(function(){
			$.get('huoqu-time',function(data){
				$("#jiesuan-gys-time").textbox('setValue',data.substring(1,data.length - 1));
			});
			
			$("#jiesuan-gys-win-table").datagrid({onClickRow : function(index, rows){
				$("#regist-patient-add-form").form("load" , rows);
				$("#jiesuan-gys-supplierId").textbox("setValue" , rows.supplier.supplierId);
				$("#jiesuan-gys-supplierName").textbox("setValue" , rows.supplier.supplierName);
				$("#jiesuan-gys-supplierLxr").textbox("setValue" , rows.supplier.supplierLxr);
				$("#jiesuan-gys-supplierPhone").textbox("setValue" , rows.supplier.supplierPhone);
				$("#jiesuan-gys-dealMoney").textbox("setValue" , rows.drugPurchase.drugPurchaseMoney);
				$("#jiesuan-gys-outoMoney").textbox("setValue" , rows.drugPurchase.drugPurchaseMoney);
				$("#jiesuan-gys-datagrid").datagrid({url : 'to_select_xq_Bypzdh'});
				$("#jiesuan-gys-datagrid").datagrid('load' , {drugAcceptancePzdh : rows.drugAcceptancePzdh});
				$("#jiesuan_gys").window("close");
			}});
			
			$("#fina-ghcl").linkbutton({onClick : function(){
				$("#regist-patient-add-form").form("submit" , {
					url : "to_insert_jiezhang_chuli",
					success : function(data){
						var json = eval("("+data+")");
						if(json.error){ 
							$("#regist-patient-add-form").form('reset');//成功后清除佛人民表单中的值
							//自动生成采购订单号
							$.get("s_number",function(data){
								$("#supplier-danhao").textbox('setValue',data.substring(1,data.length - 1));
							});
							//清除datagrid中的数据
							$.get("to_clear_jiezhang_all" ,function(){
								$("#jiesuan-gys-datagrid").datagrid("reload" , "to_select_jiezhang_all");
							});
						}else{
							$.messager.alert("提示",json.eMessage);
						} 
					}
				});
			}});
		});
	</script>
	
	
</body>
</html>