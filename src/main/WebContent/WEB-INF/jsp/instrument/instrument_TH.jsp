<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
<div id="qxys" class="easyui-layout" title="器械退货" data-options="iconCls:'icon-save',modal:true,fit:true">
		 <div id="regist-top-id" data-options="region:'north'" style="height:45px;padding: 8px">
	        	<a id="xinjian_th" href="#" class="easyui-linkbutton"data-options=iconCls:'icon-add',plain:true style="width:80px;">新建</a>
				<a id="tuihuo_chuli" href="#" class="easyui-linkbutton"data-options=iconCls:'icon-ok',plain:true style="width:80px;">退货处理</a>
				
 		</div>   

 <div data-options="region:'center'" style="padding:5px;height:380px">  
  <form id="tuihuo_from" method="post">
  <table width="100%">
 	<tr height="35px">
 	<td>
 	<input name="qxReturngoosId" id="qx_th" class="easyui-textbox" data-options="required:true,
						label:'器械退货号*',width:240,labelAlign:'right'">
 	</td>
 	<td><input class="easyui-textbox" name="instrumentYsState" readonly="readonly" data-options="required:true,label:'状态',width:240,labelAlign:'right',value:'待退货'"></td>
   
 	<td>	<input name="qxReturngoosDate" class="easyui-datebox" value="new Date()"data-options="required:true,label:
						'退货日期*',width:240,labelAlign:'right'">
   </td>
 	<td>
		<input name="instrument_lxr" id="suplierLxr"class="easyui-textbox" data-options="required:true,
						label:'联系人*',width:240,labelAlign:'right'">
	</td>
 	</tr>
 	
 	<tr height="35px">
 	<td colspan="2">
			<input name="supplierId" id="qx_th_supplierId" class="easyui-textbox" data-options="required:true,label:'供应商*',width:240,labelAlign:'right'">
			<input name="qxsupplierName" id="supplierName" class="easyui-textbox" data-options="required:true,width:330">
			
	</td>
 	
 	<td>
 	<select name="empId" class="easyui-combobox"data-options="required:true,label:'采购员*', width:240,labelAlign:'right'">   
   					<option  value="${empMessage.empId}">${empMessage.empLoginName}</option> 
								</select> 
	
 	</td>
 	
 	<td>
 	<input name="instrument_shoji" id="suplierPhone"class="easyui-textbox" data-options="required:true,
						label:'手机*',width:240,labelAlign:'right'">
 	</td>
 	</tr>
 	<tr height="35px">
 	<td>
 	<input name="instrumentYsId" class="easyui-textbox" data-options="required:true,label:'器械验收号*',width:260,labelAlign:'right',
 	   buttonText : '…',
 		onClickButton : function(){
				selectQXTuihui(function(row){
					qxTuihong(row);
				});
			}, 
 	
 	">
 	</td>
 	<td>
 	<input name="instrumentYsPzdh" id="pzdh"class="easyui-textbox" data-options="required:true,
						label:'凭证单号*',width:240,labelAlign:'right'">
 	</td>
 	<td>
 	<input id="tuihuojine" name="qxReturngoosMoney" class="easyui-textbox" data-options="required:true,
						label:'退货金额*',width:240,labelAlign:'right'">
 	</td>
 	</tr>
  
	</table>
	  </form>
	  
			 <table 
			 	
		 		class="easyui-datagrid" 
				id="th_table" 
				data-options="fitColumns:true,singleSelect:true,method:'get'">   
			 <thead>   
			<tr>   
				<th data-options="field:'o',width:3">*</th>   
				<th data-options="field:'instrumentId',width:12.5,formatter(value , row , index){	
									if(row.instrument != null){
										return row.instrument.instrumentId;
									}
									return value;
								}">器械编号</th> 
				<th data-options="field:'instrumentName',width:12.5,formatter(value , row , index){	
									if(row.instrument != null){
										return row.instrument.instrumentName;
									}
									return value;
								}">器械名称</th>   
				<th data-options="field:'instrumentYanshouXqZongNum',width:12.5">数量</th>   
				<th data-options="field:'instrumentYanshouXqMoney',width:12.5">金额</th>    
				<th data-options="field:'instrumentYanshouXqRemark',width:12.5">备注</th>  
		   </tr>   
		</thead>  
		</table> 
	
	 
 </div>
 </div>

<script type="text/javascript">

function qxTuihong(row){

	$("#tuihuo_from").form('load',row);
	$("#qx_th_supplierId").textbox('setValue',row.supplier.suplierId);
 	$("#supplierName").textbox('setValue',row.supplier.suplierName);
	$("#suplierLxr").textbox('setValue',row.supplier.suplierLxr);
	$("#suplierPhone").textbox('setValue',row.supplier.suplierPhone);  
	$("#th_table").datagrid({url : 'th_dao_table'});
	$("#th_table").datagrid('load',{qxReturngoosId : row.instrumentYsId});
	jisuan("#th_table");
}
		$(function(){
			
			$('clear_instrument_th',function(){});
			
			$("#qx6").linkbutton({onClick : function(){
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
				$("#xzqxcg").window("open");
			}});
			$.get("thdanhao", function(date){
				$('#qx_th').textbox('setValue',date.substring(1,date.length-1));
			});
			$.get("clear_instrument_th" ,function(){
				$("#th_table").datagrid("reload" , 'to_findAll');
			}); 
			//退货处理
			$("#tuihuo_chuli").linkbutton({onClick : function(){
				TuihuoDeal();
			}});
			//点击新建刷新
			 $("#xinjian_th").linkbutton({onClick : function(){
				 $("#tuihuo_from").form('reset');
					//自动生成采购订单号
					$.get("thdanhao", function(date){
						$('#qx_th').textbox('setValue',date.substring(1,date.length-1));
					});
					$.get("clear_instrument_th" ,function(){
						$("#th_table").datagrid("reload" , 'to_findAll');
					});
					
			 }});
			
			
			 
			 
			 
			 
			 
		});
		
		//退货处理
		function TuihuoDeal(){
 			$("#tuihuo_from").form("submit",{
 				url : "to_instrument_tuihuo_chuli",
 				onSubmit : function(data){
					return $(this).form("validate");
				},
				success : function(data){
					var json = eval("("+data+")");
					if(json.error){ 
						$.messager.alert("操作" , "操作成功!");
						$("#tuihuo_from").form('reset');
						//自动生成采购订单号
						$(function(){
							$.get("thdanhao", function(date){
								$('#qx_th').textbox('setValue',date.substring(1,date.length-1));
							});
						});
						$.get("clear_instrument_th" ,function(){
							$("#th_table").datagrid("reload" , 'to_findAll');
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
					money +=rows[i].instrumentYanshouXqMoney;
				}
				$("#tuihuojine").textbox('setValue' , money);
 			}});
		}
 		
</script>
		
</body>
</html>