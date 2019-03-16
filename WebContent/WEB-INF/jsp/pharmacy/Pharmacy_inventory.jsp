<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="<c:url value="/js/easyui/themes/default/easyui.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/js/easyui/themes/icon.css"/>">
	<script type="text/javascript" src="<c:url value="/js/jquery-3.1.0.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/easyui/jquery.easyui.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/easyui/easyui-lang-zh_CN.js"/>"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>药房盘点</title>
</head>
<body>
	<script type="text/javascript">
		//自动生成采购订单号
		$.get("to_pharmacyinventory",function(data){
			$("#pandianid").textbox('setValue',data.substring(1,data.length-1));
		});
		
		$("#yao_pandian_xinjian").linkbutton({onClick : function(){
			$("#yaofan-pandian-from").form('reset');//成功后清除form表单中的值
			$("#yaofan-pandian-xq-form").form('reset');
			//自动生成采购订单号
			$.get("to_pharmacyinventory",function(data){
				$("#pandianid").textbox('setValue',data.substring(1,data.length-1));
			});
			//清除datagrid中的数据
			$.get("to_clear_pandian_xq_all" ,function(){
				$("#yaopin-pandian-xq-table").datagrid("reload" , "select_pharmacy_pandain_xq");
			});
		}});
		
	</script>
	<div  id="" class="easyui-layout" title="门诊发药" data-options="fit:true">
		<div data-options="region:'north',split:true" style="height:50px">
			<a id="yao_pandian_xinjian" href="#" data-options="iconCls:'icon-add',plain:true" class="easyui-linkbutton" style="width:80px;margin-top:10px;margin-left:10px">新建</a>
	 		<a id="yaofan-pandian-chuli" href="#"data-options="iconCls:'icon-ok',plain:true"  class="easyui-linkbutton" style="width:80px;margin-top:10px;">盘点处理</a>
		</div>
		<!-- 头部分割线 -->
		<div data-options="region:'center',split:true" style="height:320px">
			<form action="" method="post" id="yaofan-pandian-from">
				<table width="100%" style="padding: 10px;border-spacing:10px;">
					<tr>
						<td><input class="easyui-textbox" name="pharmacyInventoryId" readonly="readonly" id="pandianid" data-options="label:'盘点单号',width:240,labelAlign:'right'"></td>
						<td><input class="easyui-textbox" name="pharmacyInventoryZt" readonly="readonly" data-options="label:'状态',width:240,labelAlign:'right',value:'待盘点'"></td>
						<td><input class="easyui-datebox" name="pharmacyInventoryPddate" value="new Date()" data-options="label:'盘点日期',width:240,labelAlign:'right', editable : false"></td>
						<td>
							<select name="pharmacyInventoryYf" id="" class="easyui-combobox"
	 	 						 data-options="editable:false,label:'盘点药房' , width:240 , labelAlign : 'right' , editable : false">
									<option  value="中药房">中药房</option>
									<option  value="西药房">西药房</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>
							<select name="" id="" class="easyui-combobox"
	 	 						 data-options="editable:false,label:'仓管员' , width:240 , labelAlign : 'right' , editable : false">
									<option  value="${empMessage.empId}">${empMessage.empLoginName}</option>
							</select>
						</td>
					</tr>
				</table>
			</form>
		</div>
		<!-- 我是中间分割线 -->
		<div data-options="region:'south',split:true" style="height:370px">
			<form action="" method="post" id="yaofan-pandian-xq-form">
				<table width="100%" style="border-spacing:10px;">
					<tr>
						<td colspan="2">
							<input class="easyui-textbox" name="drugId" data-options="required:true,label:'药品',width:240,labelAlign:'right'">
							<input class="easyui-textbox" name="drugBname" data-options="required:true,width:240,
								editable : false,
								required:true,
								buttonText : '…',
								 onClickButton : function(){
	 								$('#yaofan-pandian-window').window({'refresh' : 'href_address?myValue=doctor/drug_chufang'});
									$('#yaofan-pandian-window').window('open');
									
	 							}
							">
						</td>
						<td><input class="easyui-textbox" name="ph" data-options="required:true,label:'批号',width:240,labelAlign:'right'"></td>
						<td><input class="easyui-textbox" name="kcnum" id="yaofan-num" readonly="readonly" data-options="required:true,label:'药房数量',width:240,labelAlign:'right',value:'1'"></td>
					</tr>
					<tr>
						<td><input class="easyui-textbox" name="jcnum" id="yaofan-jcnum"  data-options="required:true,label:'结存数量',width:240,labelAlign:'right',value:'1'"></td>
						<td><input class="easyui-textbox" name="drugLsprice" id="yaofan-dj" readonly="readonly" data-options="required:true,label:'单价',width:240,labelAlign:'right',value:'0.00'"></td>
						<td><input class="easyui-textbox" name="kyje" id="yaofan-kyje" readonly="readonly" data-options="required:true,label:'亏盈金额',width:240,labelAlign:'right',value:'0.00'"></td>
						<td></td>
					</tr>
					<tr>
						<td colspan="3"></td>
						<td>
							<a id="yaofan-pandian-jiaru" href="#" data-options="iconCls:'icon-add',plain:true"  class="easyui-linkbutton" data-options="" style="width:80px;height:22px">加入</a>
 							<a id="yaofan-pandian-delete" href="#" data-options="iconCls:'icon-cancel',plain:true" class="easyui-linkbutton" data-options="" style="width:80px;height:22px">删除</a>
						</td>
					</tr>
				</table>
			</form>
			<table class="easyui-datagrid" id="yaopin-pandian-xq-table" style="height : 245px"
				 data-options="rownumbers:true,singleSelect:true,fitColumns: true,method : 'get'">
				<thead style="margin-left:10px; height : 200px">
					<tr>
						<th data-options="field:'ypid',width:10,align:'center'">药品编号</th>
						<th data-options="field:'ypname',width:10,align:'center'">药品名称</th>
						<th data-options="field:'jcnum',width:10,align:'center'">结存数量</th>
						<th data-options="field:'jcdw',width:10,align:'center'">结存单位</th>
						<th data-options="field:'dj',width:10,align:'center'">单价</th>
						<th data-options="field:'kyje',width:10,align:'center'">亏盈金额</th>
						<th data-options="field:'yknum',width:10,align:'center'">亏盈数量</th>
						<th data-options="field:'ph',width:10,align:'center'">批号</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
	
	<div id="yaofan-pandian-window" class="easyui-window yaofan-pandian-window"
		title="选择药品开药" style="width: 820px; height: 500px"
		data-options="modal:true,minimizable:false,maximizable:false,collapsible:false, resizable:false, closed: true,
			href:'href_address?myValue=/doctor/drug_chufang'
		">
	</div>
	
	<script type="text/javascript">
		var row = null;
	
		//点击选择药品确定传到处方开药界面
		 function xuanzeyaopin(row){
				$("#yaofan-pandian-xq-form").form('load',row);
				$("#yaofan-num").textbox('setValue' , row.kukun.yaofangKucunNum);
				$("#yaofan-pandian-window").window('close');
		} 
		$(function(){
			
			//点击选择药品确定传到处方开药界面
			$("#yaofan-pandian-window").window({onLoad : function(){
				$(".refresh-drug-queding").linkbutton({onClick :function(){
					var row = $(".drug-tables").datagrid("getSelected");
					xuanzeyaopin(row);
				}});
				
				$(".drug-tables").datagrid({onDblClickRow : function(index , rows){
					xuanzeyaopin(rows);
				}});
			}})
			
			$.get("to_clear_pandian_xq_all",function(){});
			
			$("#yaofan-pandian-yaopin").linkbutton({onClick : function(){
				$(".yaofan-pandian-window").window("open");
			}});
			$("#yaofan-pandian-yaopin").linkbutton({onClick : function(){
				$("#yaofan-pandian-window").window('refresh','href_address?myValue=/doctor/drug_chufang');
				$("#yaofan-pandian-window").window('open');
			}});
			
			//点击加入时将form表单中的数据传到datagrid中
			$("#yaofan-pandian-jiaru").linkbutton({onClick : function(){
				$("#yaofan-pandian-xq-form").form("submit" , {
					url : "insert_pharmacy_pandian_xq",
					onSubmit : function(param){
						//获取单位信息
						param.jcdw=row.unit.text;
						return $(this).form("validate");
					},
					success : function(){
						$("#yaofan-pandian-xq-form").form("reset");
						$("#yaopin-pandian-xq-table").datagrid("reload" , "select_pharmacy_pandain_xq");
					}
				});
			}});
			
			//选择数据进行删除
			$("#yaofan-pandian-delete").linkbutton({onClick : function(){
				alert("....");
				var row=$("#yaopin-pandian-xq-table").datagrid("getSelections");
				if(row.length == 0){
					$.messager.alert("提示","请先选择一行");
				}else{
					var str = "";
					for (var i = 0 ; i < row.length ; i++){
						str += row[i].id + "," ;
					}
					$.get("to_delete_pandian_xq_all" , {id : str} , function(data){
						$("#yaopin-pandian-xq-table").datagrid("reload" , "select_pharmacy_pandain_xq");
					});
				}
			}});
			
			//盘点处理
			$("#yaofan-pandian-chuli").linkbutton({onClick : function(){
				$("#yaofan-pandian-from").form("submit" , {
					url : "to_insert_yaofan_xq",
					onSubmit : function(data){
						return $(this).form("validate");
					},
					success : function(data){
						var json = eval("("+data+")");
						if(json.error){ 
							$("#yaofan-pandian-from").form('reset');//成功后清除form表单中的值
							//自动生成采购订单号
							$.get("to_pharmacyinventory",function(data){
								$("#pandianid").textbox('setValue',data.substring(1,data.length-1));
							});
							//清除datagrid中的数据
							$.get("to_clear_pandian_xq_all" ,function(){
								$("#yaopin-pandian-xq-table").datagrid("reload" , "select_pharmacy_pandain_xq");
							});
						}else{
							$.messager.alert("提示",json.eMessage);
						} 
					}
				});
			}});
			
			//计算亏盈金额
			$("#yaofan-jcnum").textbox({onChange : function(newValue, oldValue){
				var num = $("#yaofan-num").textbox("getValue");
				var jg = $("#yaofan-dj").textbox("getValue");
				var kyje = (newValue-num)*jg;
				if(((newValue-num)*jg) < 0){
					$("#yaofan-kyje").textbox("setValue" , kyje * -1);
				}else{
					$("#yaofan-kyje").textbox("setValue" , kyje);
				}
			}});
		});
	</script>
</body>
</html>