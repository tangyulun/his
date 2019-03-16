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
<div id="qxys" class="easyui-layout" title="器械入库" data-options="iconCls:'icon-save',modal:true,fit:true">
		 <div id="regist-top-id" data-options="region:'north'" style="height:45px;padding: 8px">
	        	<a id="xinjian_rk" href="#" class="easyui-linkbutton"data-options=iconCls:'icon-add',plain:true style="width:80px;">新建</a>
				<a id="instrument_ruku_chuli_butt" href="#" class="easyui-linkbutton"data-options=iconCls:'icon-ok',plain:true style="width:80px;">入库处理</a>
				
 		</div>   

 <div data-options="region:'center'" style="padding:5px;height:300px">  
 <form id="ruku_from" method="post">
  <table width="100%">
 	<tr height="35px">
 	<td>
 	<input name="instrumentRkId" id="qx_rk"class="easyui-textbox"readonly="readonly" data-options="label:'入库编号*',width:240,labelAlign:'right'">
 	</td>
 	<td><input class="easyui-textbox" name="drugTuihuoState" readonly="readonly" data-options="required:true,label:'状态',width:240,labelAlign:'right',value:'待入库'">
   </td>
 	<td>	<input name="instrumentRkDate" id="ruku_date" value="new Date()" class="easyui-datebox" data-options="required:true,label:
						'入库日期*',width:240,labelAlign:'right'">
   </td>
 	<td>
		<select name="instrumentRkRklx" class="easyui-combobox"data-options="required:true,label:'入库类型*', width:240,labelAlign:'right'">   
   				<option value="采购入库">采购入库</option>   
		</select>  
	</td>
 	</tr>
 	
 	<tr height="35px">
 	<td>
			<input name="instrumentYsId" id="yansho_d" class="easyui-textbox" data-options="
			buttonText : '…' ,
			onClickButton : function(){
				selectQXYanshou(function(row){
					qxYanshou(row);
				});
			}, 
			required:true,label:'入库对象*',width:260,labelAlign:'right'">
			  
	</td>
 	
 	<td>
 	<input name="qxReturngoosPzdh" id="ruku_pzdh"class="easyui-textbox" data-options="required:true,
						label:'凭证单号*',width:240,labelAlign:'right'">
 	</td>
 	
 	<td>
 	<select name="instrumentRkName" class="easyui-combobox"data-options="required:true,label:'仓库*', width:240,labelAlign:'right'">   
   						 <option value="aa">器械库</option>   
								</select> 
 	</td>
 	</tr>
 	<tr height="35px">
 	<td>
	 	<select name="EmpId" class="easyui-combobox" data-options="editable:false,required:true,label:'经办人*',width:240,labelAlign:'right'">
			<option  value="${empMessage.empId}">${empMessage.empLoginName}</option> 
		</select> 
 	</td>
 	
 	</tr>
  
	</table>
</form>
		 <table class="easyui-datagrid" 
		 id="ruku_table"
				data-options="fitColumns:true,singleSelect:true,fit:true,method:'get'">   
		 <thead>   
			<tr>   
				<th data-options="field:'rkid',width:10">器械编号</th> 
				<th data-options="field:'rkname',width:10">器械名称</th>   
				<th data-options="field:'rkshuliang',width:10">数量</th>   
				<th data-options="field:'danwei',width:10">单位</th>   
				<th data-options="field:'rkcgdate',width:10 , formatter : date">采购日期</th>    
				<th data-options="field:'rkbz',width:10">备注</th>  
		   </tr>   
		</thead>  
		</table> 
	  </div>
 </div>

		
<script type="text/javascript">
//查询入库的对象
function qxYanshou(rows){
	$("#ruku_from").form('load',rows);
	$("#yansho_d").textbox('setValue',rows.instrumentYsId);
	$("#ruku_pzdh").textbox('setValue',rows.instrumentYsPzdh);
	$.get("cleare_ruku_xq" ,function(){});
	$("#ruku_table").datagrid({url : "ruku_dao_table"});
	$("#ruku_table").datagrid('load',{instrumentYsId : rows.instrumentYsId});
}

		$(function(){
			$("#qx5").linkbutton({onClick : function(){
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
			$("#ruku_").linkbutton({onClick : function(){
				$("#xq-open—ruku").window("open");
			}});
			//入库单号
			$.get("rkdanhao", function(date){
				$('#qx_rk').textbox('setValue',date.substring(1,date.length-1));
			});
			
			//入库对象显示
			 $("#xq-open—ruku").window({onLoad : function(){
					$("#registration-sure").linkbutton({onClick : function(){
						var rows = $("#sb").datagrid("getSelected");
					}});
					
			}});
			
			
			
			//点击新建时刷新数据
			 $("#xinjian_rk").linkbutton({onClick : function(){
				 $("#ruku_from").form('reset');
					//自动生成采购订单号
					$.get("rkdanhao", function(date){
					$('#qx_rk').textbox('setValue',date.substring(1,date.length-1));
					});
					$.get("to_clear" ,function(){
						$("#ruku_table").datagrid("reload" , 'to_findAll');
					}); 
			 }});
			
			//点击入库处理
			 $("#instrument_ruku_chuli_butt").linkbutton({onClick : function(){
	 				if($("#ruku_table").datagrid('getRows')==0){
	 					$.messager.alert('提示' , '请至少选择一条数据处理!');
						 return ;
	 				}
	 				ruku();
	 			}});
		});
		
		//入库处理
		 function ruku(){
				$("#ruku_from").form("submit",{
					url : "instrument_ruku_chuli",
					onSubmit : function(data){
						return $(this).form("validate");
					},
					success : function(data){
						var json = eval("("+data+")");
						if(json.error){ 
							$.messager.alert("操作" , "操作成功!");
							$("#ruku_from").form('reset');
							//自动生成入库订单号
							$.get("rkdanhao", function(date){
								$('#qx_rk').textbox('setValue',date.substring(1,date.length-1));
							});
							 $.get("to_clear" ,function(){
								$("#ruku_table").datagrid("reload" , 'to_findAll');
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