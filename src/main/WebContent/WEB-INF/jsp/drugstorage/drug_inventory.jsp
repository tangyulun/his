<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>药品盘点</title>
</head>
<body>

	<script type="text/javascript">
		$(function(){
			$.get("to_inventory",function(data){
				$("#pandianid").textbox('setValue',data.substring(1,data.length-1));
			});
			$("#pandian_xinjian").linkbutton({onClick : function(){
				$("#pandian-zhu-form").form('reset');//成功后清除佛人民表单中的值
				//自动生成采购订单号
				$.get("to_inventory",function(data){
					$("#pandianid").textbox('setValue',data.substring(1,data.length-1));
				});
				//清除datagrid中的数据
				$.get("to_clear_all" ,function(){
					$("#pandian-xq-table").datagrid("reload" , "to_select_all");
				});
			}});
		});
	</script>
	
	<div id="" class="easyui-layout" title="药品登入" data-options="fit:true">
		<div data-options="region:'north',split:true" style="height:50px">
			<a id="pandian_xinjian" href="#" data-options="iconCls:'icon-add',plain:true" class="easyui-linkbutton" style="width:80px;margin-top:10px;margin-left:10px">新建</a>
 			<!-- <a id="" href="#" class="easyui-linkbutton" style="width:80px;margin-top:10px;">打开</a>
 			<a id="" href="#" class="easyui-linkbutton" style="width:80px;margin-top:10px;">挂单</a> -->
 			<a id="pandian-pandianchuli" href="#" data-options="iconCls:'icon-ok',plain:true" class="easyui-linkbutton" style="width:80px;margin-top:10px;">盘点处理</a>
		</div>
		<div data-options="region:'center',split:true">
			<form action="" method="post" id="pandian-zhu-form">
				<table width="100%" style="padding: 10px;border-spacing:10px;">
					<tr>
						<td></td>
						<td><input class="easyui-textbox" readonly="readonly" name="drugInventoryId" id="pandianid" data-options="label:'盘点单号*',width:240,labelAlign:'right'"></td>
						<td><input class="easyui-textbox" readonly="readonly" name="drugInvertoryZt" data-options="label:'状态',width:240,labelAlign:'right',value:'待盘点'"></td>
						<td><input class="easyui-datebox" value="new Date()" name="drugInvertoryPddate" data-options="label:'盘点日期',width:240,labelAlign:'right' , editable : false"></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td>
							<select name="drugInvertoryPdyk" id="" class="easyui-combobox"
	 	 						 data-options="editable:false,label:'盘点药库' , width:240 , labelAlign : 'right' , editable : false">
									<option  value="中药库">中药库</option>
									<option  value="西药库">西药库</option>
							</select>
						</td>
						<td>
							<select name="empId" id="empId" class="easyui-combobox"
	 	 						 data-options="editable:false,label:'仓管员' , width:240 , labelAlign : 'right' , editable : false">
									<option  value="${empMessage.empId}">${empMessage.empLoginName}</option>
							</select>
						</td>
						<td></td>
						<td></td>
					</tr>
				</table>
			</form>
		</div>
		<div data-options="region:'south',split:true" style="height:350px">
			<form action="" method="post" id="pandian-form">
				<table width="100%" style="padding: 10px;border-spacing:10px;">
					<tr>
						<td colspan="2">
							<input class="easyui-textbox" readonly="readonly" name="drugId" data-options="required:true,label:'药品',width:200,labelAlign:'right'">
							<input name="drugName" class="easyui-textbox" data-options="required:true,width:240,
								buttonText : '…',
								required:true,
								 onClickButton : function(){
	 								kucunWindow(function(row){
	 									findDrug(row);
	 								});
	 							}
							">
						</td>
						<td><input name="ph" class="easyui-textbox" data-options="required:true,label:'批号',width:240,labelAlign:'right'"></td>
						<td><input name="kynum" readonly="readonly" id="kuncunnum" class="easyui-textbox" data-options="required:true,label:'数量',width:240,labelAlign:'right',value:'1'"></td>
					</tr>
					<tr>
						<td><input name="jcnum" id="pandiannum" class="easyui-textbox" data-options="required:true,label:'盘点数量',width:240,labelAlign:'right',value:'1'"></td>
						<td><input name="drugPfprice" id="chengbendj" readonly="readonly" class="easyui-textbox" data-options="required:true,label:'成本单价',width:240,labelAlign:'right',value:'0.00'"></td>
						<td><input name="kyje" id="kyje" readonly="readonly" class="easyui-textbox" data-options="required:true,label:'亏盈金额',width:240,labelAlign:'right',value:'0.00'"></td>
					</tr>
					<tr>
						<td colspan="3"></td>
						<td>
							<a id="insert-pandian-jiaru" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok', plain:true" style="width:80px;height:22px">加入</a>
 							<a id="delete-pandian-shangchu" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel', plain:true" style="width:80px;height:22px">删除</a>
						</td>
					</tr>
				</table>
			</form>
			<table class="easyui-datagrid" id="pandian-xq-table" style="height : 206px" data-options="rownumbers:true,singleSelect:true,fitColumns: true,method : 'get'">
				<thead style="margin-left:10px; height : 200px">
					<tr>
						<th data-options="field:'ypid',width:10,align:'center'">药品编号</th>
						<th data-options="field:'ypName',width:10,align:'center'">药品名称</th>
						<th data-options="field:'jcnum',width:10,align:'center'">结存数量</th>
						<th data-options="field:'jcdw',width:10,align:'center'">结存单位</th>
						<th data-options="field:'dj',width:10,align:'center'">单价</th>
						<th data-options="field:'kynum',width:10,align:'center'">亏盈数量</th>
						<th data-options="field:'kyje',width:10,align:'center'">亏盈金额</th>
						<th data-options="field:'ph',width:10,align:'center'">批号</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
	
		 <script type="text/javascript">
		 var rows = null;
		 
		//打开药品窗口
			function findDrug(row){
				rows = row;
				$("#pandian-form").form('load',rows);
				$("#kuncunnum").textbox('setValue' , row.yaokuKucun.yaokuKucunNum);
			}
		 
			 $(function(){
				 $.get("to_clear_all" , function(){});
				 
				//点击添加按钮时将值传到下面的datagrid中
				$("#insert-pandian-jiaru").linkbutton({onClick : function(){
					$("#pandian-form").form("submit",{
						url : "to_add_pdXq",
						onSubmit : function(param){
							//获取单位信息
							param.jcdw = rows.unit.text;
							return $(this).form("validate");
						},
						success : function(){
							//刷新表单
							$("#pandian-form").form('reset');
							//刷新表格
							$("#pandian-xq-table").datagrid("reload" , "to_select_all");
						}
					})
				}});
				
				//点击删除按钮时将datagrid中的数据进行删除
				$("#delete-pandian-shangchu").linkbutton({onClick : function(){
					var row = $("#pandian-xq-table").datagrid('getSelections');
					if(row.length == 0){
						$.messager.alert("提示","请先选择一行");
					}else{
						var str = "";
						for(var i = 0 ; i < row.length ; i++){
							str += row[i].id + ",";
						}
						$.getJSON("to_delete_all", {id : str} , function(data){
							$("#pandian-xq-table").datagrid("reload" , "to_select_all");
						})
					}
				}});
				
				//修改亏盈数量
				var kynumber = -1;
				$("#pandiannum").textbox({onChange : function(newValue, oldValue){
					var num = $("#kuncunnum").textbox("getValue");
					var cbdj = $("#chengbendj").textbox("getValue");
					var kyzongje = (newValue-num)*cbdj;
					if(((newValue-num)*cbdj) < 0){
						$("#kyje").textbox('setValue' , kyzongje * kynumber);
					}else{ 
						$("#kyje").textbox('setValue' , kyzongje);
					}
				}});
				
				
				//盘点处理
				$("#pandian-pandianchuli").linkbutton({onClick : function(){
					if($("#pandian-xq-table").datagrid('getRows') ==0){
						 $.messager.alert('提示' , '请至少选择一条数据处理!');
						 return ;
					}
					$("#pandian-zhu-form").form("submit",{
						url : "to_insert_pandian_chuli",//路径
						onSubmit : function(data){
							return $(this).form("validate");
						},
						success : function(data){
							var json = eval("("+data+")");
							if(json.error){ 
								$("#pandian-zhu-form").form('reset');//成功后清除佛人民表单中的值
								//自动生成采购订单号
								$.get("to_inventory",function(data){
									$("#pandianid").textbox('setValue',data.substring(1,data.length-1));
								});
								//清除datagrid中的数据
								$.get("to_clear_all" ,function(){
									$("#pandian-xq-table").datagrid("reload" , "to_select_all");
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