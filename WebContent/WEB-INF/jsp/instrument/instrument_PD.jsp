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
<div id="qxys" class="easyui-layout" title="器械盘点" data-options="iconCls:'icon-save',modal:true,fit:true">
		 <div id="regist-top-id" data-options="region:'north'" style="height:45px;padding: 8px">
	        	<a id="pd_xinjian" href="#" class="easyui-linkbutton"data-options=iconCls:'icon-add',plain:true style="width:80px;">新建</a>
			
				<a id="pd_chui" href="#" class="easyui-linkbutton"data-options=iconCls:'icon-ok',plain:true style="width:80px;">盘点处理</a>
		
 		</div>   

 <div data-options="region:'center'" style="padding:5px;height:300px">  
 <form id="insert-pd-form"method="post">
  <table width="100%">
 	<tr height="35px">
 	<td>
 	<input name="qxLnventoryId"id="qx_pd" class="easyui-textbox" data-options="required:true,
						label:'盘点单编号*',width:240,labelAlign:'right'">
 	</td>
 	<td><input class="easyui-textbox" name="drugTuihuoState" readonly="readonly" data-options="required:true,label:'状态',width:240,labelAlign:'right',value:'待盘点'">
   </td>
 	<td>	<input name="qxLnventoryDate" class="easyui-datebox" value="new Date()"data-options="required:true,label:
						'盘点日期*',width:240,labelAlign:'right'">
   </td>
 	<td>
		<select name="qxLnventoryWarehouse" class="easyui-combobox"data-options="required:true,label:'仓库*', width:240,labelAlign:'right'">   
   						 <option value="aa">中药库</option>   
    						<option>西药库</option>   
								</select>  
	</td>
 	</tr>
 	
  
	</table>
	</form>
  	<div style="border: 1px solid lihgtblue ;height:378px; margin-top: 5px">
  	 <form id="instrumentpd_from" method="post" >  
	  	<table>
	  		<tr height="40px">
		<td  colspan="2">
			<input id="instrumentId"name="instrumentId" class="easyui-textbox" data-options="required:true,label:'器械*',width:240,labelAlign:'right'">
			<input id="instrumentName"name="instrumentName" class="easyui-textbox" data-options="required:true,width:240,
			buttonText : '…',
 			onClickButton : function(row){
 				$('#xzqx_pd').window('open');
 			}">
			 
		</td>
		<td>
		
		</td>
		<td>
		<input id="instrumentZongNum"name="instrumentZongNum" class="easyui-textbox" data-options="required:true,
						label:'结存数量*',width:240,labelAlign:'right'">
		</td>
		</tr>
							          		
		<tr height="40px">
		<td ><input id="shuliang"name="shuliang" class="easyui-textbox" data-options="required:true,
						label:'盘点数量*',width:240,labelAlign:'right'">
		</td>
		
		<td colspan="3"><input name="instrumentRemark" class="easyui-textbox" data-options="required:true,
						label:'备注*',width:250,labelAlign:'right'">
		</td>
		
		<td>
		<a id="jiaru_pd" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" style="width:80px">加入</a> 
		<a id="shanc_pd" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" style="width:80px">删除</a>
		</td>
		</tr>
		</table> 
		</form>
		 <table id="pd_table" class="easyui-datagrid" data-options="fitColumns:true,singleSelect:true,fit:true, method : 'get'" style="height: 100%">   
		 <thead>   
			<tr>   
				<th data-options="field:'code1',width:14.2">*</th>   
				<th data-options="field:'qxid',width:14.2">器械编号</th>   
				<th data-options="field:'qxname',width:14.2">器械名称</th>   
				<th data-options="field:'shuliang',width:14.2">数量</th>   
				<th data-options="field:'danwei',width:14.2">单位</th>
				<th data-options="field:'beizhu',width:14.2">备注</th>  
		   </tr>   
		</thead>  
		</table> 
		
	  </div>
	 
 </div>
 </div>
 
 
 
 <div id="xzqx_pd" class="easyui-window" title="选择器械" style="width:800px;height:500px" data-options="model : true ,
		 closed:true,
		 minimizable:false,
		 maximizable:false,
		 collapsible:false,
		 modal : true,
		 resizable:false ,href:'href_address?myValue=/instrument/instrumeng_CK_window',method:'get'">
		</div>
<script type="text/javascript">
			var row =  null;
		$(function(){
			$("#qx_pd_BUT").linkbutton({onClick : function(){
				$("#xzqx_pd").window("open");
			}});
			$.get("pddanhao", function(date){
				$('#qx_pd').textbox('setValue',date.substring(1,date.length-1));
			});
			//显示器械
			$("#xzqx_pd").window({onLoad : function(){
				$(".select_qx_name").linkbutton({onClick : function(){
					row = $(".select_instrument_type").datagrid("getSelected");
					
					$("#instrumentpd_from").form('load',row);
					$("#xzqx_pd").window("close");
				}});
			}});
			//点击加入table显示器械
			 $("#jiaru_pd").linkbutton({onClick : function(){
					$("#instrumentpd_from").form("submit" , {
						url : 'get_andinstrument_pd' ,
						onSubmit : function(param){
							param.danwei=row.unit.text;
							return $(this).form("validate");
						},
						success : function(){
							$("#instrumentpd_from").form('reset');
							$("#pd_table").datagrid("reload","select_ruku_pd");
							//清除
							$('cle_ruku_pd',function(){});
						}
					});
				}});
			
			//删除
			 $("#shanc_pd").linkbutton({onClick : function(){
					var row = $("#pd_table").datagrid('getSelections');
					if(row.length == 0){
						$.messager.alert("提示","请先选择一行")
					}else{
						var str = "";
						for(var i = 0 ; i < row.length ; i++){
							str += row[i].id + ",";
						}
							
						$.getJSON("delect_instrument_pd", {qx : str} , function(data){
							$("#pd_table").datagrid("reload" , 'select_ruku_pd');
							
						})
					}
				}});
			

				//点击盘点处理进行出库操作
					$("#pd_chui").linkbutton({onClick : function(){
						if($("#pd_table").datagrid('getRows')==0){
		 					$.messager.alert('提示' , '请至少选择一条数据处理!');
							 return ;
		 				}
						pandianDeal();
					}});
				
				//点击新建刷新
					 $("#pd_xinjian").linkbutton({onClick : function(){
						 $("#insert-pd-form").form('reset');
							//自动生成采购订单号
							$.get("pddanhao", function(date){
								$('#qx_pd').textbox('setValue',date.substring(1,date.length-1));
							});
							$.get("cle_ruku_pd" ,function(){
								$("#pd_table").datagrid("reload" , 'to_findAll');
							}); 
					 }});
				
					 $("#shuliang").textbox({onChange : function(newValue,oldValue){
							var num = $("#instrumentZongNum").textbox("getValue");
							if(newValue < 1 ){
								$("#shuliang").textbox("setValue" , 1);
							}else if(newValue > num){
								$("#shuliang").textbox("setValue" , num);
							}
						}});
					 
			
		});
	
		
		
		function pandianDeal(){
 			$("#insert-pd-form").form("submit",{
 				url : "chuli_andinstrument_pd",
 				onSubmit : function(data){
					return $(this).form("validate");
				},
				success : function(data){
					var json = eval("("+data+")");
					if(json.error){ 
						$.messager.alert("操作" , "操作成功!");
							$("#insert-pd-form").form('reset');
							//自动生成采购订单号	
							$.get("pddanhao", function(date){
							$('#qx_pd').textbox('setValue',date.substring(1,date.length-1));
								});
							
							$.get("cle_ruku_pd" ,function(){
								$("#pd_table").datagrid("reload" , "select_ruku_pd");
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