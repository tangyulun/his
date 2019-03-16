<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="<c:url value="/js/easyui/themes/default/easyui.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/js/easyui/themes/icon.css"/>">
	<script type="text/javascript" src="<c:url value="/js/jquery-3.1.0.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/easyui/jquery.easyui.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/easyui/easyui-lang-zh_CN.js"/>"></script>
<title>药品出库</title>
</head>
<body>
	<script type="text/javascript">
		$(function(){
			$.get("to_delivery",function(data){
				$("#chukuid").textbox('setValue',data.substring(1,data.length-1));
				var pzdh=$("#chukuid").textbox("getValue");
				$("#pingzhengdanhao").textbox('setValue','DH'+pzdh.substring(2,pzdh.length));
			});
			
			$("#chuku_xinjian").linkbutton({onClick : function(){
				$("#insert-ruku-form").form('reset');
				//自动生成采购订单号	
				$.get("to_delivery",function(data){
					$("#chukuid").textbox('setValue',data.substring(1,data.length-1));
					var pzdh=$("#chukuid").textbox("getValue");
					$("#pingzhengdanhao").textbox('setValue','DH'+pzdh.substring(2,pzdh.length));
				});
				$.get("clear_ruku_xq_a" ,function(){
					$("#ruku-xq-table").datagrid("reload" , "select_ruku_xq_a");
				}); 
			}});
			
			
		});
	</script>

	<div id="" class="easyui-layout" title="药品登入" data-options="fit:true">
		<div data-options="region:'north',split:true" style="height:50px">
			<a id="chuku_xinjian" href="#" data-options="iconCls:'icon-add',plain:true" class="easyui-linkbutton" style="width:80px;margin-top:10px;margin-left:10px">新建</a>
 			<a id="chuku-chuli" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok',plain:true" style="width:80px;margin-top:10px;">出库处理</a>
		</div>
		<div data-options="region:'center',split:true" >
			<form action="" method="post" id="insert-ruku-form">
				<table width="100%" style="padding: 10px;border-spacing:10px;">
					<tr>
						<td><input class="easyui-textbox" readonly="readonly" name="drugDeliveryId" id="chukuid" data-options="label:'出库单号*',width:240,labelAlign:'right'"></td>
						<td><input class="easyui-textbox" readonly="readonly" name="drugDeliveryZt" data-options="label:'状态',width:240,labelAlign:'right',value:'待出库'"></td>
						<td>
							<select name="drugDeliveryCk" id="" class="easyui-combobox"
	 	 						 data-options="editable:false,label:'出库仓' , width:240 , labelAlign : 'right' , editable : false">
									<option  value="中药库">中药库</option>
									<option  value="西药库">西药库</option>
							</select>
						</td>
						<td><input class="easyui-datebox" name="drugDeliveryCkdate" value="new Date()" data-options="label:'出库日期',width:240,labelAlign:'right'"></td>
					</tr>
					<tr>
						<td><input class="easyui-textbox" name="drugDeliveryCklx" readonly="readonly" data-options="required:true,label:'出库类型',width:240,labelAlign:'right',value:'药库出库'"></td>
						<td>
							<input name="drugDeliveryCkdx" class="easyui-textbox" readonly="readonly" data-options="required:true,required:true,width:240,label:'出库对象',labelAlign:'right',value:'药房'">
						</td>
						<td>
							<select name="drugDeliveryCgy" id="" class="easyui-combobox"
	 	 						 data-options="editable:false,label:'仓管员' , width:240 , labelAlign : 'right' , editable : false">
									<option  value="${empMessage.empId}">${empMessage.empLoginName}</option>
							</select>
						</td>
						<td><input class="easyui-textbox" name="drugDeliveryPzdh" id="pingzhengdanhao" data-options="required:true,label:'凭证单号',width:240,labelAlign:'right'"></td>
					</tr>
					<tr>
						<td>
					        <select name="empId" id="" class="easyui-combobox"
	 	 						 data-options="editable:false,label:'经办人' , width:240 , labelAlign : 'right' , editable : false">
									<option  value="${empMessage.empId}">${empMessage.empLoginName}</option>
							</select>
						</td>
					</tr>
				</table>
			</form>
		</div>
		<div data-options="region:'south',split:true" style="height:340px">
			<form id="drug-chuku-form" action="" method="post">
				<table width="100%" style="padding: 10px;border-spacing:10px;">
					<tr>
						<td colspan="2">
							<input id="drug-Id-yaopin" name="drugId" readonly="readonly" class="easyui-textbox" data-options="required:true,label:'药品',width:200,labelAlign:'right'">
							<input id="drug-Name-yaopin" name="drugName" class="easyui-textbox" 
							data-options="required:true,width:240,
								editable : false,
								buttonText : '…',
								required:true,
								 onClickButton : function(){
	 								kucunWindow(function(row){
	 									findDrugAll(row);
	 								});
	 							}
							">
						</td>
						<td><input id="drug-ph-yaopin" name="ph" class="easyui-textbox" data-options="required:true,label:'批号',width:240,labelAlign:'right'"></td>
					</tr>
					<tr>
						<td colspan="1"><input id="drug-kucun-num" name="num" class="easyui-textbox" data-options="required:true,label:'数量',width:240,labelAlign:'right',value:'1'"></td>
						<td colspan="1"><input id="drug-bz-yaopin" name="bz" class="easyui-textbox" data-options="required:true,label:'备注',width:400,labelAlign:'right'"></td>
						<td colspan="1"></td>
						<td>
							<a id="add-drug-jiaru" href="#" class="easyui-linkbutton"  data-options="iconCls:'icon-ok', plain:true" style="width:80px;height:22px">加入</a>
 							<a id="del-drug-shangchu" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel', plain:true" style="width:80px;height:22px">删除</a>
						</td>
					</tr>
				</table>
			</form>
			
			<table class="easyui-datagrid" id="ruku-xq-table" data-options="fitColumns: true,fit:true,method:'get',rownumbers:true" style="width:100%">
				<thead style="margin-left:10px;">
					<tr>
						<th data-options="field:'ypid',width:10,align:'center'">药品编号</th>
						<th data-options="field:'ypName',width:10,align:'center'">药品名称</th>
						<th data-options="field:'num',width:10,align:'center'">数量</th>
						<th data-options="field:'ph',width:10,align:'center'">批号</th>
						<th data-options="field:'bz',width:10,align:'center'">备注</th>
					</tr>
				</thead>
			</table>
	</div>
</div>
	
	
	<div id="bianji-chuku-window" class="easyui-window" title="编辑" style="width:350px;height:400px" 
		 	data-options="modal:true,collapsible:false,minimizable:false,maximizable:false,closed:true">
		 	<form action="" method="post" id="bianji_chuku_form">
		 		<table id="bianji_chuku_tab" data-options="fit:true,singleSelect:true,fitColumns: true" style="width:100%;border-spacing:10px;">
	 				<tr>
	 					<td><input class="easyui-textbox" name="ypid" id="ypid" readonly="readonly" data-options="label : '药品编号' , width : 240 , labelAlign : 'right'"></td>
	 				</tr>
	 				<tr>
	 					<td><input class="easyui-textbox" name="ypName" id="" readonly="readonly" data-options="label : '药品名称' , width : 240 , labelAlign : 'right'"></td>
	 				</tr>
	 				<tr>
	 					<td><input class="easyui-textbox" name="num" id="chuku-num" data-options="label : '数量' , width : 240, labelAlign : 'right'"></td>
	 				</tr>
	 				<tr>
	 					<td><input class="easyui-textbox" name="ph" id="" data-options="label : '批号' , width : 240 , labelAlign : 'right'"></td>
	 				</tr>
	 				<tr>
	 					<td><input class="easyui-textbox" name="bz" id="" data-options="label : '备注' , width : 240 , labelAlign : 'right'"></td>
	 				</tr>
		 		</table>
		 	</form>
	 		<div style="margin-left: 100px;margin-top:15px">
					<a class="easyui-linkbutton" name="" id="update_chuku_queding"  data-options="iconCls:'icon-ok', plain:true" style="width : 80px; height :25px ">确定</a>
					<a class="easyui-linkbutton" name="" id="" data-options="iconCls:'icon-cancel', plain:true" style="width : 80px; height : 25px">取消</a>
	 		</div>
		 </div>
	
	
	<script type="text/javascript">
	var rowK = null;
	
		//打开药品窗口
		function findDrugAll(row){
			rowK = row;
			$("#drug-Id-yaopin").textbox('setValue',row.drugId);
			$("#drug-Name-yaopin").textbox('setValue',row.drugName);
		}
		$(function(){
			$.get("clear_ruku_xq_a" ,function(){});
			var row=null;
			//点击出库处理进行出库操作
			$("#chuku-chuli").linkbutton({onClick : function(){
				if($("#ruku-xq-table").datagrid('getRows')==0){
 					$.messager.alert('提示' , '请至少选择一条数据处理!');
					 return ;
 				}
				chukuDeal();
			}});
			
			//双击进行编辑
			$("#ruku-xq-table").datagrid({onDblClickRow : function(index,rows){
				row=rows;
				$("#bianji-chuku-window").window('open');
				$("#bianji_chuku_form").form('load',rows);
			}});
			$("#update_chuku_queding").linkbutton({onClick : function(){
				if(rowK.yaokuKucun.yaokuKucunNum < $("#chuku-num").textbox('getValue')){
					$.messager.alert('提示' , "库存不足！");
					return;
				}
				$("#bianji_chuku_form").form("submit" , {
					url : 'update_chuku_xq',
					onSubmit : function(data){
						data.id=row.id;
						data.numC = row.num - $("#chuku-num").textbox('getValue');
						return $(this).form("validate");
					},
					success : function(){
						$("#bianji-chuku-window").window("close");
						$("#ruku-xq-table").datagrid("reload" , "select_ruku_xq_a");
					}
				});
			}});
			
			//点击加入将form表单的数据传到table中
			$("#add-drug-jiaru").linkbutton({onClick : function(){
				if(rowK.yaokuKucun.yaokuKucunNum < $("#drug-kucun-num").textbox('getValue')){
					$.messager.alert('提示' , "库存不足！");
					return;
				}
				updateKucunNum(rowK.yaokuKucun.yaokuKucunId ,  $("#drug-kucun-num").textbox('getValue'));
				$("#drug-chuku-form").form("submit",{
					url : "to_add_ruku_xq_a",
					onSubmit : function(param){
						return $(this).form("validate");
					},
					success : function(){
						$("#drug-chuku-form").form('reset');
						$("#ruku-xq-table").datagrid("reload" , "select_ruku_xq_a");
					}
				});
			}});
			
			//点击table中的数据进行删除
			$("#del-drug-shangchu").linkbutton({onClick : function(){
				var row = $("#ruku-xq-table").datagrid('getSelections');
				if($("#ruku-xq-table").datagrid('getRows') ==0){
					 $.messager.alert('提示' , '请至少选择一条数据处理!');
					 return ;
				}
				if(row.length == 0){
					$.messager.alert("提示","请先选择一行");
				}else{
					var str = "";
					var str1 = "";
					for(var i = 0 ; i < row.length ; i++){
						str += row[i].id + ",";
					}
					$.getJSON("delete_ruku_xq_a", {xq : str} , function(data){
						$("#ruku-xq-table").datagrid("reload" , 'select_ruku_xq_a');
					});
				}
			}});
			
			
			//出库处理
			function chukuDeal(){
	 			$("#insert-ruku-form").form("submit",{
	 				url : "to_insert_chuli_xq",
	 				onSubmit : function(data){
						return $(this).form("validate");
					},
					success : function(data){
						var json = eval("("+data+")");
						if(json.error){ 
								$("#insert-ruku-form").form('reset');
								//自动生成采购订单号	
								$.get("to_delivery",function(data){
									$("#chukuid").textbox('setValue',data.substring(1,data.length-1));
									var pzdh=$("#chukuid").textbox("getValue");
									$("#pingzhengdanhao").textbox('setValue','DH'+pzdh.substring(2,pzdh.length));
								});
								$.get("clear_ruku_xq_a" ,function(){
									$("#ruku-xq-table").datagrid("reload" , "select_ruku_xq_a");
								}); 
						}else{
							$.messager.alert("提示",json.eMessage);
						} 
					}
	 			});
	 		}
			
		});
		function updateKucunNum(kucunId , num){
			$.get("update_kucun_num_" , {kucunId : kucunId , num : num} , function(){});
		}
	</script>
	
	
</body>
</html>