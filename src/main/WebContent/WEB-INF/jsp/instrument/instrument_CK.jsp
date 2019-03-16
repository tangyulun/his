<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<div id="qxys" class="easyui-layout" title="器械出库" data-options="iconCls:'icon-save',modal:true,fit:true">
		 <div id="regist-top-id" data-options="region:'north'" style="height:45px;padding: 8px">
	        	<a id="btn" href="#" class="easyui-linkbutton"data-options=""style="width:80px;">新建</a>
				<a id="chuku_chul" href="#" class="easyui-linkbutton"data-options=""style="width:80px;">出库处理</a>
 		</div>   

 <div data-options="region:'center'" style="padding:5px;height:300px">  
 <form id="insert-ck-form"method="post">
  <table width="100%">
 	<tr height="35px">
 	<td>
 	<input name="qxThelibraryId" id="qx_ck"class="easyui-textbox" data-options="required:true,
						label:'出库单号*',width:240,labelAlign:'right'">
 	</td>
 	<td><select name="qxThelibraryState" class="easyui-combobox"data-options="required:true,label:'状态*', width:240,labelAlign:'right'">   
   						 <option value="aa">未确认</option>   
    						<option>确认</option>   
								</select>  
   </td>
 	<td>	<input name="qxThelibraryDate" class="easyui-datebox" value="new Date()" data-options="required:true,label:
						'出库日期*',width:240,labelAlign:'right'">
   </td>
 	<td>
		<select name="qxThelibraryType" class="easyui-combobox"data-options="required:true,label:'出库类型*', width:240,labelAlign:'right'">   
   						 <option value="aa">领用出库</option>   
    						<option>退货出库</option>   
								</select>  
	</td>
 	</tr>
 	
 	<tr>
 	<td>
			<input name="qxThelibraryDuixiang" class="easyui-textbox" data-options="required:true,label:'出库对象*',width:240,labelAlign:'right',value:'器械库'">
			
	</td>
 	
 
 
 	<td>
 	<select name="qxThelibraryWarehouse" class="easyui-combobox"data-options="required:true,label:'出库仓库*', width:240,labelAlign:'right'">   
   						 <option value="aa">中药库</option>   
    						<option>西药库</option>   
								</select>  
 	</td>
 	<td>
		<select name="empId" class="easyui-combobox" data-options="editable:false,required:true,label:'经办人*',width:240,labelAlign:'right'">
			<option  value="${empMessage.empId}">${empMessage.empLoginName}</option> 
		</select> 
	</td>
 	</tr>
 	
  
	</table>
	</form>
  
  	   <form id="instrumentCK_from" method="post" style="margin-top: 5px">  
	  	<table>
	  		<tr>
		<td  colspan="2">
			<input id="instrumentId" name="instrumentId" class="easyui-textbox" data-options="required:true,label:'器械*',width:240,labelAlign:'right'">
			<input id="instrumentName"name="instrumentName" class="easyui-textbox" data-options="required:true,width:240,
			buttonText : '…',
 			onClickButton : function(row){
 				$('#xzqx3').window('open');
 			}">
		
		</td>
		<td>
	
		</td>
		<td>
		<input name="instrumentZongNum" class="easyui-textbox" data-options="required:true,
						label:'库存数量*',width:240,labelAlign:'right'">
		</td>
		</tr>
							          		
		<tr>
		
		
		<td colspan="4"><input name="shuliang" class="easyui-textbox" data-options="required:true,
						label:'出库数量*',width:240,labelAlign:'right'">
		</td>
		
		<td>
		<a id="jiaru_chku" href="#" class="easyui-linkbutton" data-options="" style="width:80px">加入</a> 
		<a id="shanchu_chuku" href="#" class="easyui-linkbutton" data-options="" style="width:80px">删除</a>
		</td>
		</tr>
		</table> 
		</form>
		 <table class="easyui-datagrid" 
		 id="ck_table"
			data-options="fitColumns:true,singleSelect:true,fit:true,method : 'get'">   
		 <thead>   
			<tr>   
				<th data-options="field:'code1',width:10">*</th>   
				<th data-options="field:'qxid',width:10">器械编号</th>   
				<th data-options="field:'qxname',width:10">器械名称</th>   
				<th data-options="field:'shuliang',width:10">结存数量</th>   
				<th data-options="field:'danwei',width:10">单位</th>   
				<th data-options="field:'beizhu',width:10">备注</th>  
		   </tr>   
		</thead>  
		</table> 
		
	  </div>
	 
 </div>
 
 
 <div id="xzqx3" class="easyui-window" title="选择器械" style="width:800px;height:500px" data-options="model : true ,
		 closed:true,
		 minimizable:false,
		 maximizable:false,
		 collapsible:false,
		 modal : true,
		 resizable:false ,href:'href_address?myValue=/instrument/instrumeng_CK_window',method:'get'">
		
					
</div>
	<script type="text/javascript">
	var row = null;
		$(function(){
			//清除
			$.get("update_ruku_xq" ,function(){});
			
			 $("#qx1").linkbutton({onClick : function(){
				 $("#xzqx3").window("open"); 
			}}); 
			
			$.get("ckdanhao", function(date){
				$('#qx_ck').textbox('setValue',date.substring(1,date.length-1));
			});
			//选择舔数据
			$("#xzqx3").window({onLoad : function(){
				$(".select_qx_name").linkbutton({onClick : function(){
					row = $(".select_instrument_type").datagrid("getSelected");
					alert(JSON.stringify(row));
					$("#instrumentCK_from").form('load',row);
					$("#xzqx3").window("close");
				}});
			}});
			
			
			
			//点击采购如入按钮 显示采购器械
			 $("#jiaru_chku").linkbutton({onClick : function(){
					$("#instrumentCK_from").form("submit" , {
						url : 'get_andinstrument_ck' ,
						onSubmit : function(param){
							param.danwei=row.unit.text;
							return $(this).form("validate");
						},
						success : function(){
							$("#instrumentCK_from").form('reset');
							$("#ck_table").datagrid("reload","select_dao_ddddd");
							$.get("update_ruku_xq" ,function(){});
						}
					});
				}});
			//删除
			  $("#shanchu_chuku").linkbutton({onClick : function(){
					var row = $("#ck_table").datagrid('getSelections');
					if(row.length == 0){
						$.messager.alert("提示","请先选择一行")
					}else{
						var str = "";
						for(var i = 0 ; i < row.length ; i++){
							str += row[i].id + ",";
						}
							alert(str);
						$.getJSON("delect_instrument_chuku", {qx : str} , function(data){
							$("#ck_table").datagrid("reload" , 'select_dao_ddddd');
							
						})
					}
				}});
			
			
			
			//点击出库处理进行出库操作
				$("#chuku_chul").linkbutton({onClick : function(){
					if($("#ck_table").datagrid('getRows')==0){
	 					$.messager.alert('提示' , '请至少选择一条数据处理!');
						 return ;
	 				}
					chukuDeal();
				}});
			
		});
		
		//处理
		function chukuDeal(){
 			$("#insert-ck-form").form("submit",{
 				url : "chuli_andinstrument_ck",
 				onSubmit : function(data){
					return $(this).form("validate");
				},
				success : function(data){
					var json = eval("("+data+")");
					if(json.error){ 
							$("#insert-ck-form").form('reset');
							//自动生成采购订单号	
							$.get("ckdanhao", function(date){
							$('#qx_ck').textbox('setValue',date.substring(1,date.length-1));
							});
								var pzdh=$("#qx_ck").textbox("getValue");
							
							$.get("update_ruku_xq" ,function(){
								$("#ck_table").datagrid("reload" , "select_ruku_xq");
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