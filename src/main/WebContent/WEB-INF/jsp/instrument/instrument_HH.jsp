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
<div id="qxys" class="easyui-layout" title="器械还回" data-options="iconCls:'icon-save',modal:true,fit:true">
		 <div id="regist-top-id" data-options="region:'north'" style="height:45px;padding: 8px">
	        	<a id="hh_xinjian" href="#" class="easyui-linkbutton"data-options=iconCls:'icon-add',plain:true style="width:80px;">新建</a>
				
				<a id="hh_chui" href="#" class="easyui-linkbutton"data-options=iconCls:'icon-ok',plain:true style="width:80px;">还回处理</a>
				
 		</div>   

 <div data-options="region:'center'" style="padding:5px;height:310px">  
 <form id="insert-hh-form"method="post">
  <table width="100%">
 	<tr height="35px">
 	<td>
 	<input name="qxReturnId" id="qx_hh"class="easyui-textbox" data-options="required:true,
						label:'还回单编号*',width:240,labelAlign:'right'">
 	</td>
 	<td><input class="easyui-textbox" name="drugTuihuoState" readonly="readonly" data-options="required:true,label:'状态',width:240,labelAlign:'right',value:'待还回'">
   </td>
 	<td>	<input name="qxReturnDate" value="new Date()" class="easyui-datebox" data-options="required:true,label:
						'还回日期*',width:240,labelAlign:'right'">
   </td>
 	<td>
		<select name="qxReturnWarehouse" class="easyui-combobox"data-options="required:true,label:'仓库*', width:240,labelAlign:'right'">   
   						 <option value="aa">中药库</option>   
    						<option>西药库</option>   
								</select>  
	</td>
 	</tr>
 	
 	<tr>
 	<td>
			<select name="qxReturnKeshi" class="easyui-combobox"data-options="required:true,label:'还回类型*', width:240,labelAlign:'right'">   
   						 <option value="aa">科室</option>   
    						<option>病区</option>  
    						<option>员工</option>  
    						<option>住院病人</option>   
								</select>  
	</td>
 	
 	<td>
 	
			<input name="qxReturnDuixiang" class="easyui-textbox" data-options="required:true,label:'还回对象*',width:240,labelAlign:'right',value:'器械库'">
 	</tr>
 	
  
	</table>
	</form>
  	
  	  	 <form id="instrumenthh_from" method="post" >  
	  	<table>
	  		<tr>
		<td  colspan="2">
			<input id="instrumentId"name="instrumentId"  class="easyui-textbox" data-options="required:true,label:'器械*',width:240,labelAlign:'right'">
			<input id="instrumentName"name="instrumentName" class="easyui-textbox" data-options="required:true,width:240,
			buttonText : '…',
 			onClickButton : function(row){
 				$('#xzqx_hh').window('open');
 			}">
			
		</td>
		
		<td>
		<input id="instrumentZongNumg" name="instrumentZongNum" class="easyui-textbox" data-options="required:true,
						label:'结存数量*',width:240,labelAlign:'right'">
		</td>
		</tr>
							          		
		<tr>
		<td><input id="shuliangg" name="shuliang" class="easyui-textbox" data-options="required:true,
						label:'还回数量*',width:240,labelAlign:'right'">
		</td>
		
		<td colspan="2"><input name="instrumentRemark" class="easyui-textbox" data-options="required:true,
						label:'备注*',width:245,labelAlign:'right'">
		</td>
		
		<td>
		<a id="jiaru_hh" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" style="width:80px">加入</a> 
		<a id="shanc_hh" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" style="width:80px">删除</a>
		</td>
		</tr>
			</table> 
			</form>
		 <table class="easyui-datagrid" 
				id="table_hh"
			data-options=" url : 'select_hh_hh' ,fitColumns:true,singleSelect:true,fit:true,method : 'get'">   
		 <thead>   
			<tr>   
				<th data-options="field:'8',width:14.2">*</th>   
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
 
 
 	<div id="xzqx_hh" class="easyui-window" title="选择器械" style="width:800px;height:500px" data-options="model : true ,
		 closed:true,
		 minimizable:false,
		 maximizable:false,
		 collapsible:false,
		 modal : true,
		 resizable:false ,href:'href_address?myValue=/instrument/instrumeng_CK_window',method:'get'">
	</div>
		
<script type="text/javascript">
		$(function(){
			$("#qx_hh_butt").linkbutton({onClick : function(){
				$("#xzqx_hh").window("open");
			}});
			$.get("hhdanhao", function(date){
				$('#qx_hh').textbox('setValue',date.substring(1,date.length-1));
			});
			
			
			//显示器械
			$("#xzqx_hh").window({onLoad : function(){
				$(".select_qx_name").linkbutton({onClick : function(){
					row = $(".select_instrument_type").datagrid("getSelected");
					$("#instrumenthh_from").form('load',row);
					$("#xzqx_hh").window("close");
				}});
			}});
			
			//点击加入table显示器械
			 $("#jiaru_hh").linkbutton({onClick : function(){
					$("#instrumenthh_from").form("submit" , {
						url : 'get_andinstrument_hh' ,
						onSubmit : function(param){
							param.danwei=row.unit.text;
							return $(this).form("validate");
						},
						success : function(){
							$("#instrumenthh_from").form('reset');
							$("#table_hh").datagrid("reload","select_hh_hh");
							//清除
						}
					});
				}});
			
			 $("#shuliangg").textbox({onChange : function(newValue,oldValue){
					var num = $("#instrumentZongNumg").textbox("getValue");
					if(newValue < 1 ){
						$("#shuliangg").textbox("setValue" , 1);
					}else if(newValue > num){
						$("#shuliangg").textbox("setValue" , num);
					}
				}});
			
				//点击盘点处理进行出库操作
				$("#hh_chui").linkbutton({onClick : function(){
					if($("#table_hh").datagrid('getRows')==0){
	 					$.messager.alert('提示' , '请至少选择一条数据处理!');
						 return ;
	 				}
					hhDeal();
				}});

				//删除
				 $("#shanc_hh").linkbutton({onClick : function(){
						var row = $("#table_hh").datagrid('getSelections');
						if(row.length == 0){
							$.messager.alert("提示","请先选择一行")
						}else{
							var str = "";
							for(var i = 0 ; i < row.length ; i++){
							str += row[i].id + ",";
							}	
							$.getJSON("delect_instrument_hh", {qx : str} , function(data){
							$("#table_hh").datagrid("reload" , 'select_hh_hh');
								
							})
						}
					}});
				
				
					//点击新建刷新
				 $("#hh_xinjian").linkbutton({onClick : function(){
					 $("#instrumenthh_from").form('reset');
						//自动生成采购订单号
						$.get("hhdanhao", function(date){
						$('#qx_hh').textbox('setValue',date.substring(1,date.length-1));
							});
						$.get("cel_hh_hh" ,function(){
							$("#table_hh").datagrid("reload" , 'select_hh_hh');
						}); 
				 }});
		});
		
		
	
		
		//处理
		function hhDeal(){
 			$("#insert-hh-form").form("submit",{
 				url : "post_andinstrument_hh",
 				onSubmit : function(data){
					return $(this).form("validate");
				},
				success : function(data){
					var json = eval("("+data+")");
					if(json.error){ 
						$.messager.alert("操作" , "操作成功!");
						$("#insert-hh-form").form('reset');
							//自动生成采购订单号	
								//领用单号
						$.get("hhdanhao", function(date){
								$('#qx_hh').textbox('setValue',date.substring(1,date.length-1));
						});
						$.get("cel_hh_hh" ,function(){
								$("#table_hh").datagrid("reload" , "select_hh_hh");
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