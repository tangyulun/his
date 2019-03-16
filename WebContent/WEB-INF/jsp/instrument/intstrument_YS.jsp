<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<link rel="stylesheet" type="text/css" href="<c:url value="/js/easyui/themes/default/easyui.css"/>">   
	<link rel="stylesheet" type="text/css" href="<c:url value="/js/easyui/themes/icon.css"/>"> 
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/tsp/table_height.css"/>"> 
	<script type="text/javascript" src="<c:url value="/js/jquery-3.1.0.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/easyui/jquery.easyui.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/easyui/easyui-lang-zh_CN.js"/>"></script>
</head>
<body>
<div id="qxys" class="easyui-layout" title="器械登记" data-options="iconCls:'icon-save',modal:true,fit:true">
		 <div id="regist-top-id" data-options="region:'north'" style="height:45px;padding: 8px">
	        	<a id="yansho_xinjian" href="#" class="easyui-linkbutton"data-options=iconCls:'icon-add',plain:true style="width:80px;">新建</a>
				
				<a id="yans_chul" href="#" class="easyui-linkbutton"data-options=iconCls:'icon-ok',plain:true style="width:80px;">验收处理</a>

 		</div>   

 <div data-options="region:'center'">  
  <form id="yansho_from" method="post">
  <table width="100%"id="yansho_table">
 
 	<tr height="35px">
 	<td><input name="instrumentYsId" id="qx_ys" readonly="readonly" class="easyui-textbox" data-options="required:true,label:'验收单号*',width:250,labelAlign:'right'"></td>
 	<td><input class="easyui-textbox" name="drugTuihuoState" readonly="readonly" data-options="required:true,label:'状态',width:240,labelAlign:'right',value:'待验收'">
   </td>
 	<td><select name="" class="easyui-combobox"data-options="required:true,label:'采购员*', width:240,labelAlign:'right' , editable : false">   
   						<option  value="${empMessage.empId}">${empMessage.empLoginName}</option> 
								</select> 
   </td>
 	<td>
	<input name="instrumentCaigouGhDate" class="easyui-datebox" data-options="required:true,label:
	'收货日期*',width:240,labelAlign:'right' , editable : false">
	</td>
 	</tr>
 	
 	<tr height="35px">
 	<td colspan="2">
			<input name="supplierId" id="qxsupplierId"class="easyui-textbox qxsupplierId" data-options="required:true,label:'供应商*',width:250,labelAlign:'right' , editable : false">
			<input name="supplierName" id="qxsupplierName"class="easyui-textbox qxsupplierName" data-options="required:true,width:310 , editable : false">
			
	</td>
 	
 	<td>
 	<input name="supplierLxr" id="instrument_lxr"class="easyui-textbox instrument_lxr" data-options="required:true,
						label:'联系人*',width:240,labelAlign:'right',editable : false">
 	</td>
 	
 	<td>
 	<input id="pzdh" name="instrumentYsPzdh" class="easyui-textbox" data-options="required:true,
						label:'凭证单号*',width:240,labelAlign:'right',editable : false">
 	</td>
 	</tr>
 	<tr height="35px">
 	<td>
 	<input name="instrumentCaigouId" class="easyui-textbox" data-options="required:true,label:'采购订单号*',editable : false,width:270,labelAlign:'right',
 		buttonText : '…',
 		onClickButton : function(){
 			seelctQxYanshou(function(row){
 				showCGShuju(row);
 			} , '已确定');
 		}
 		
 	">
			 
 	</td>
 	<td>
 	<input name="instrumentCaigouMoney" id ="instrumentCaigouMoney" class="easyui-textbox" data-options="required:true,
						label:'收货金额*',width:240,labelAlign:'right' ,editable : false">
 	</td>
 	<td>
 	<input name="supplierPhone" id="instrument_shoji"class="easyui-textbox instrument_shoji" data-options="required:true,
						label:'手机*',width:240,labelAlign:'right' ,
						editable : false
						">
 	</td>

 	</tr>
  
	</table>
	</form>
  	
	  	
	  	
		 <table 
		 id="yansho_biaoid" 
		 class="easyui-datagrid"  
		 data-options="fitColumns:true,singleSelect:true,fit:true,method:'get'">   
		 <thead>   
			<tr>   
				<th data-options="field:'code1',width:1">*</th>   
				<th data-options="field:'qXCGID',width:10">器械编号</th> 
				<th data-options="field:'qXCGNAME',width:10">器械名称</th>   
				<th data-options="field:'sHULIANG',width:10">总数量</th>
				<th data-options="field:'hEGESHU' ,editor : 'numberbox' ,width:10 ,
						styler: function(value,row,index){
							return 'color:red;font-weight:bold';
					}

					">合格数</th>     
				<th data-options="field:'dANWEI',width:10">单位</th>   
				<th data-options="field:'dANJIA',width:10">单价</th>  
				<th data-options="field:'jINE',width:10">金额</th> 
				<th data-options="field:'bEIZHU',width:10">备注</th>  
				
		   </tr>   
		</thead>  
		</table> 
		
	 
	 
 </div>
 </div>
 

<div id="gys-open" class="easyui-window" data-options="
			 width:900,
	          height: 550,
	          title: '选择供应商',
	          maximizable:false,
	          minimizable:false,
	          collapsible:false,
	          resizable:false,
	          closed: true,
	          modal: true,
	          href : 'href_address?myValue=/drugstorage/supplier_window',
	          draggable:false,method:'get'
		">
</div> 

<script type="text/javascript">
	//显示数据
	function showCGShuju(rows){
		$(".qxsupplierId").textbox('setValue',rows.supplier.suplierId);
		$(".qxsupplierName").textbox('setValue',rows.supplier.suplierName);
		$(".instrument_lxr").textbox('setValue',rows.supplier.suplierLxr);
		$(".instrument_shoji").textbox('setValue',rows.supplier.suplierPhone);
		$("#yansho_from").form('load',rows);
		$("#pzdh").textbox('setValue','PZ'+rows.instrumentCaigouId.substring(2,rows.instrumentCaigouId.length));
		$.get("to_clear" ,function(){});
		$("#yansho_biaoid").datagrid({url : 'ysdan_dao_table'});
		$("#yansho_biaoid").datagrid('load',{instrumentYsId : rows.instrumentCaigouId});
	}


		$(function(){
			$.get("ysdanhao", function(data){
				$("#qx_ys").textbox('setValue',data.substring(1,data.length-1));
			});
			
			$("#qx8").linkbutton({onClick : function(){
				$("#xzqx3").window("open");
			}});
			$("#A3").linkbutton({onClick : function(){
				$("#qxgl3").window("open");
			}});
			$("#fl3").linkbutton({onClick : function(){
				$("#qxfl3").window("open");
			}});
			$("#xj3").linkbutton({onClick : function(){
				$("#create3").window("open");
			}});
			
			$("#cgddh").linkbutton({onClick : function(){
				$("#xq-open—yansho").window("open");
			}});
			
			$("#gys_id").linkbutton({onClick : function(){
				$("#gys-open").window("open");
			}});
			
			$("#yans_chul").linkbutton({onClick : function(){
				 guadanAndDeal();
			}});
			
			//入库对象显示
			 $("#xq-open—ruku").window({onLoad : function(){
					$("#select_qx_ys_qd").linkbutton({onClick : function(){
						var rows = $("#sb").datagrid("getSelected");
					}});
					
			}});
			
			
			//供应商显示
			 $("#xq-open—yansho").window({onLoad : function(){
					$("#registration-sure").linkbutton({onClick : function(){
						var rows = $("#sb").datagrid("getSelected");
						$("#xq-open—yansho").window("close");
					}});
					
			}});
			
			 indexs = -1 ;
			//双击编辑
			 $("#yansho_biaoid").datagrid({onDblClickRow : function(index ,  row ){
				 //开始编辑状态=beginEdit  
				 indexs = index;
		 			$('#yansho_biaoid').datagrid('beginEdit', index);
			}}); 
			//修改
			 $("#yansho_biaoid").datagrid({onClickRow : function(index ,  row ){
			 		if(indexs != -1){
				 		$('#yansho_biaoid').datagrid('endEdit', indexs);  
			 			$("#yansho_biaoid").datagrid('selectRow' , indexs);
			 			var rows = $("#yansho_biaoid").datagrid('getSelected');
			 			$.get("update_dao_xinxi" , {id : rows.cGid ,HEGESHU : rows.hEGESHU}, function(){
			 				$("#yansho_biaoid").datagrid("reload" , 'select_dao_xinxi');
			 				$("#yansho_biaoid").datagrid({onLoadSuccess : function(){
			 					var rows = $("#yansho_biaoid").datagrid("getRows");
			 					var money = 0.0;
			 					for (var i = 0; i < rows.length; i++) {
									money +=rows[i].jINE;
								}
			 					$("#instrumentCaigouMoney").textbox('setValue' , money);
			 				}})
			 			});
			 			indexs = -1;
			 		}
			}}); 
			
		});
		
		
		
		
		//点击新建时刷新数据
		 $("#yansho_xinjian").linkbutton({onClick : function(){
			 $("#yansho_from").form('reset');
				//自动生成采购订单号
				$.get("ysdanhao", function(data){
					$("#qx_ys").textbox('setValue',data.substring(1,data.length-1));
					});
				$.get("to_clear" ,function(){
					$("#yansho_biaoid").datagrid("reload" , 'to_findAll');
				}); 
		 }});
		 
		//验收处理
		 function guadanAndDeal(){
				$("#yansho_from").form("submit",{
					url : "ysdan_chul_weichul",
					onSubmit : function(data){
						return $(this).form("validate");
					},
					success : function(data){
						var json = eval("("+data+")");
						if(json.error){ 
							$.messager.alert("提示","验收成功！");
							$("#yansho_from").form('reset');
							//自动生成采购订单号
							$.get("ysdanhao", function(data){
								$("#qx_ys").textbox('setValue',data.substring(1,data.length-1));
									});
							 $.get("to_clear" ,function(){
								$("#yansho_biaoid").datagrid("reload" , 'to_findAll');
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