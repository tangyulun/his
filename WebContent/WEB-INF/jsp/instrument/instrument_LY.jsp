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
<div id="qxys" class="easyui-layout" title="器械领用" data-options="iconCls:'icon-save',modal:true,fit:true">
		 <div id="regist-top-id" data-options="region:'north'" style="height:45px;padding: 8px">
	        	<a id="ly_xinjian" href="#" class="easyui-linkbutton"data-options=iconCls:'icon-add',plain:true style="width:80px;">新建</a>
				
				<a id="ly_chui" href="#" class="easyui-linkbutton"data-options=iconCls:'icon-ok',plain:true style="width:80px;">领用处理</a>
 		</div>   

 <div data-options="region:'center'" style="padding:5px;height:300px">  
  <form id="insert-ly-form"method="post">
  <table width="100%">
 	<tr height="35px">
 	<td>
 	<input name="qxUseId" id="qx_ly"class="easyui-textbox" data-options="required:true,
						label:'领用单编号*',width:240,labelAlign:'right'">
 	</td>
 	<td><input class="easyui-textbox" name="drugTuihuoState" readonly="readonly" data-options="required:true,label:'状态',width:240,labelAlign:'right',value:'待领用'">
   </td>
 	<td>	<input name="qxUseDate"  value="new Date()" class="easyui-datebox" data-options="required:true,label:
						'领用日期*',width:240,labelAlign:'right'">
   </td>
 	<td>
		<select name="qxUseWarehouse" class="easyui-combobox"data-options="required:true,label:'仓库*', width:240,labelAlign:'right'">   
   						 <option value="aa">中药库</option>   
    						<option>西药库</option>   
								</select>  
	</td>
 	</tr>
 	
 	<tr>
 	<td>
			<select name="qxUseKeshi" class="easyui-combobox"data-options="required:true,label:'领用类型*', width:240,labelAlign:'right'">   
   						 <option value="aa">科室</option>   
    						<option>病区</option>  
    						<option>员工</option>  
    						<option>住院病人</option>   
								</select>  
	</td>
 	
 	<td>
 	
			<input name="qxUseDuix" class="easyui-textbox" data-options="required:true,label:'领用对象*',width:240,labelAlign:'right',value:'器械库'">
 
 	</tr>
 	
  
	</table>
	</form>
  	<div style="border: 1px solid lihgtblue ;height:373px; margin-top: 5px">
  	 <form id="instrumently_from" method="post" >  
	  	<table>
	  		<tr>
		<td  colspan="2">
			<input id="instrumentId"name="instrumentId" class="easyui-textbox" data-options="required:true,label:'器械*',width:240,labelAlign:'right'">
			<input id="instrumentName"name="instrumentName" class="easyui-textbox" data-options="required:true,width:240,
			buttonText : '…',
 			onClickButton : function(row){
 					$('#xzqx_ly').window('open');
 			}">
			
		</td>
		<td>
		
		</td>
		<td>
		<input id="instrument_buymoney" name="instrumentZongNum" class="easyui-textbox" data-options="required:true,
						label:'结存数量*',width:240,labelAlign:'right'">
		</td>
		</tr>
							          		
		<tr>
		<td><input id="instrument_shuliang" name="shuliang" class="easyui-textbox" data-options="required:true,
						label:'领用数量*',width:240,labelAlign:'right'">
		</td>
		
		<td  colspan="3"><input name="instrumentRemark" class="easyui-textbox" data-options="required:true,
						label:'备注*',width:250,labelAlign:'right'">
		</td>
		
		<td>
		<a id="jiaru_ly" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" style="width:80px">加入</a> 
		<a id="shanc_ly" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" style="width:80px">删除</a>
		</td>
		</tr>
		</table>
		</form>
		 <table class="easyui-datagrid" 
		 id="table_ly"
			data-options="fitColumns:true,singleSelect:true,fit:true ,method : 'get'">   
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
  	<div id="xzqx_ly" class="easyui-window" title="选择器械" style="width:800px;height:500px" data-options="model : true ,
		 closed:true,
		 minimizable:false,
		 maximizable:false,
		 collapsible:false,
		 modal : true,
		 resizable:false ,href:'href_address?myValue=/instrument/instrumeng_CK_window',method:'get'">
	</div>
<script type="text/javascript">
		$(function(){
			$("#qx_ly_BUT").linkbutton({onClick : function(){
				$("#xzqx_ly").window("open");
			}});
			//领用单号
			$.get("lydanhao", function(date){
				$('#qx_ly').textbox('setValue',date.substring(1,date.length-1));
			});
			//显示器械
			$("#xzqx_ly").window({onLoad : function(){
				$(".select_qx_name").linkbutton({onClick : function(){
					row = $(".select_instrument_type").datagrid("getSelected");
					$("#instrumently_from").form('load',row);
					$("#xzqx_ly").window("close");
				}});
			}});
			
			
			//点击加入table显示器械
			 $("#jiaru_ly").linkbutton({onClick : function(){
					$("#instrumently_from").form("submit" , {
						url : 'get_andinstrument_ly' ,
						onSubmit : function(param){
							param.danwei=row.unit.text;
							return $(this).form("validate");
						},
						success : function(){
							$("#instrumently_from").form('reset');
							//清除
							$('cle_ruku_ly',function(){});
						}
					});
							$("#table_ly").datagrid("reload","select_ruku_ly");
				}});
			
				$("#instrument_shuliang").textbox({onChange : function(newValue,oldValue){
					var num = $("#instrument_buymoney").textbox("getValue");
					if(newValue < 1 ){
						$("#instrument_shuliang").textbox("setValue" , 1);
					}else if(newValue > num){
						$("#instrument_shuliang").textbox("setValue" , num);
					}
				}});
			//点击领用处理进行出库操作
			
			//点击刷新刷新页面
				 $("#ly_xinjian").linkbutton({onClick : function(){
					 $("#insert-ly-form").form('reset');
						//自动生成采购订单号
						$.get("lydanhao", function(date){
							$('#qx_ly').textbox('setValue',date.substring(1,date.length-1));
						});
						$.get("cle_ruku_ly" ,function(){
							$("#table_ly").datagrid("reload" , 'select_ruku_ly');
						}); 
				 }});
			
			
				//删除
				 $("#shanc_ly").linkbutton({onClick : function(){
						var row = $("#table_ly").datagrid('getSelections');
						if(row.length == 0){
							$.messager.alert("提示","请先选择一行")
						}else{
							var str = "";
							for(var i = 0 ; i < row.length ; i++){
								str += row[i].id + ",";
							}
								alert(str);
							$.getJSON("delect_instrument_ly", {qx : str} , function(data){
								$("#table_ly").datagrid("reload" , 'select_ruku_ly');
								
							})
						}
				 }});
				
				//处理
					$("#ly_chui").linkbutton({onClick : function(){
						if($("#table_ly").datagrid('getRows')==0){
		 					$.messager.alert('提示' , '请至少选择一条数据处理!');
							 return ;
		 				}
						lyDeal();
					}});
		});
		
		
		
		
		
		//处理
		function lyDeal(){
 			$("#insert-ly-form").form("submit",{
 				url : "Post_andinstrument_ly",
 				onSubmit : function(data){
					return $(this).form("validate");
				},
				success : function(data){
					var json = eval("("+data+")");
					if(json.error){ 
						$.messager.alert("操作" , "操作成功!");
							$("#insert-ly-form").form('reset');
							//自动生成采购订单号	
								//领用单号
							$.get("lydanhao", function(date){
							$('#qx_ly').textbox('setValue',date.substring(1,date.length-1));
							});
							
							$.get("cle_ruku_ly" ,function(){
								$("#table_ly").datagrid("reload" , "select_ruku_ly");
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