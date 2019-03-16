<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/js/easyui/themes/default/easyui.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/js/easyui/themes/icon.css"/>">
<script type="text/javascript"
	src="<c:url value="/js/jquery-3.1.0.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/js/easyui/jquery.easyui.min.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/js/easyui/easyui-lang-zh_CN.js"/>"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>住院发药</title>
</head>
<body>
	<script type="text/javascript">
		//自动生成采购订单号
		$.get("to_hospitalpills", function(data) {
			$("#zhuyuanfayaoid").textbox('setValue',
					data.substring(1, data.length - 1));
		})
		$(function() {
			
			/* $("#zhuyuanfayao-prescriptionId").combobox({
				onChange : function() {
					//alert(123);
					
				}
			}); */
			/* $("#chufanhao").linkbutton({
				onClick : function() {
					
					$("#select-chufan").window("open");
				}
			}); */
			$("#zhuyuanfayao_btn_dispose").linkbutton({
				onClick : function() {
					
					$("#zhuyuanfayao-form").form("submit", {
						url : 'add_Zhuyuanfayao',
						onSubmit : function(data) {
							
							return $(this).form("validate");
						},
						success : function(datas) {
							var json = eval("(" + datas + ")");
							if (json.error) {
								$.messager.alert("提示" , "处理成功!");
								$("#zhuyuanfayao-form").form("reset");
								$.get("to_hospitalpills", function(data) {
									$("#zhuyuanfayaoid").textbox('setValue',
											data.substring(1, data.length - 1));
								});
							} else {
								$.messager.alert("提示", json.message);
							}
						}
					});
					var row = $("#select-zhuyuanfayao-table").datagrid('getRows');
					for (var i =row.length -1; i >=0; i--) {
						$("#select-zhuyuanfayao-table").datagrid('deleteRow',i);
					}
				}
			});
			$("#zhuyuanfayao-prescriptionId").textbox({onClickButton : function(){
				$("#select-chufan").window("open");
			}});
			$("#select-chufan").window({onLoad : function(){
				
				$("#chufan-queding").linkbutton({onClick : function(){
					row = $("#chufan-table").datagrid("getSelected");
					//alert(JSON.stringify(row));
					
					$("#zhuyuanfayao-form").form('load',row);
					$.getJSON("select_zhuyuan_dengji" , {number : row.prescriptionId} , function(data){
						$("#fayao-hospitalRegistrationId").textbox("setValue",data.hospitalRegistrationId);
					});
					$("#select-zhuyuanfayao-table").datagrid("load" , "select_all_prescriptionRecode?prescriptionId="+row.prescriptionId);
					jisuanMoney();
					$("#select-chufan").window("close");
				}});
				$("#chufan-table").datagrid({onDblClickRow : function(index , rows){
					row=rows;
					//alert(JSON.stringify(row));
					$("#zhuyuanfayao-form").form('load',rows);
					$.getJSON("select_zhuyuan_dengji" , {number : row.prescriptionId} , function(data){
						$("#fayao-hospitalRegistrationId").textbox("setValue",data.hospitalRegistrationId);
					});
					$("#select-zhuyuanfayao-table").datagrid("load" , "select_all_prescriptionRecode?prescriptionId="+row.prescriptionId);
					jisuanMoney();
					$("#select-chufan").window("close");
				}});
			}});
		});
		function selectJilu(row) {
			$("#zhuyuanfayao-form").form('load', row);
			//alert(JSON.stringify(row));
			$("#select-zhuyuanfayao-table").datagrid("load" , "select_all_prescriptionRecode?prescriptionId="+row.prescriptionId);
		}
		function jisuanMoney(){
			$("#select-zhuyuanfayao-table").datagrid({onLoadSuccess : function(){
				var rows = $("#select-zhuyuanfayao-table").datagrid('getRows');
				
				var money = 0.0;
				for (var i = 0; i < rows.length; i++) {
					money +=rows[i].prescriptionRecodeMoney;
				}
				$("#zhuyuanfayao-zhuyuanFayaoZmoney").textbox("setValue",money);
				
			}});
		}
		
	</script>
	<div id="" class="easyui-layout" title="门诊发药" data-options="fit:true">
		<div data-options="region:'north',split:true" style="height: 50px">
			<a id="" href="#" class="easyui-linkbutton" data-options="
				        iconCls:'icon-add',
				        width: 80,
				        plain:true
				        "
				style="width: 80px; margin-top: 10px; margin-left: 10px">新建</a>
			<a id="zhuyuanfayao_btn_dispose" href="#" data-options="
				        iconCls:'icon-ok',
				        width: 80,
				        plain:true
				        "
				class="easyui-linkbutton" style="width: 80px; margin-top: 10px;">发药处理</a>
	
		</div>
		<!-- 头部分割线 -->
		<div data-options="region:'center',split:true" style="height: 350px">
			<form method="post" id="zhuyuanfayao-form">
				<table width="100%" style="padding: 10px; border-spacing: 10px;">
					<tr height="30">
						<td><input class="easyui-textbox" readonly="readonly"
							id="zhuyuanfayaoid" name="zhuyuanFayaoId"
							data-options="label:'发药编号',width:240,labelAlign:'right'"></td>
						<td><select class="easyui-combobox" id="" name="zhuyuanFayaoState"
							data-options="label:'状态',width:240,labelAlign:'right'">
								<option value="未处理">未处理</option>
								<option value="已处理">已处理</option>
						</select></td>
						<td><input class="easyui-datebox" value="new Date()"
							name="zhuyuanFayaoDate"
							data-options="label:'发药日期',width:240,labelAlign:'right'"></td>
						<td><input class="easyui-textbox" name="zhuyuanFayaoType"
							data-options="label:'发药类型',width:240,labelAlign:'right',value : '普通发药',editable : false"></td>
					</tr>
					<tr height="30">
						<td><!-- <input name="prescriptionId" id="zhuyuanfayao-prescriptionId"
								class="easyui-combobox"
								data-options="valueField:'prescriptionId',textField:'prescriptionId',
   									 url:'select_all_prescription' , label:'处方号' ,
   									    width:240 ,  labelAlign : 'right', method : 'get'
   									  , editable : false , required : true" /> -->
   							<input class="easyui-textbox" id="zhuyuanfayao-prescriptionId" type="text" name="prescriptionId"
								data-options="
								        required:true,
								        labelAlign: 'right',
								        label: '处方号',
								        width: 260 ,
								        editable : false,
								        buttonText : '…'
								    
								        " />
   							<!-- <a id="chufanhao" href="#" class="easyui-linkbutton" data-options=""
								style="width: 30px; height: 22px">...</a>	 -->	  
						</td>
						<td><select name="empId" class="easyui-combobox"
							data-options="label:'操作人',width:240,labelAlign:'right',editable : false">
								<option value="${empMessage.empId}">${empMessage.empLoginName}</option>
						</select></td>
						<td><input class="easyui-combobox" value="住院发药"
							data-options="label:'药房',width:240,labelAlign:'right',editable : false"
							name="zhuyuanFayaoHouse"></td>
						
						<td><!-- <input class="easyui-textbox"
							name="hospitalRegistrationId" id="fayao-hospitalRegistrationId"
							data-options="
								        required:true,
								        labelAlign: 'right',
								        label: '住院号*',
								        editable : false,
								        buttonText : '…',
								        onClickButton : function(){
								        	selectZhuyuanJilu(function(row){
								        		selectJilu(row);
								        	});
								        },
								        width: 260"> -->
							<input class="easyui-textbox"
							name="hospitalRegistrationId" id="fayao-hospitalRegistrationId"
							data-options="
								        required:true,
								        labelAlign: 'right',
								        label: '住院号*',
								        editable : false,
								        
								        width: 240">
						</td>
					</tr>
					<tr height="30">
						<td><input class="easyui-textbox" name="zhuyuanFayaoZmoney" id="zhuyuanfayao-zhuyuanFayaoZmoney"
							data-options="label:'总金额',width:240,labelAlign:'right',value:'0.00',editable : false"></td>
					</tr>
				</table>
			</form>
		</div>
		<!-- 我是中间的分割线 -->
		<div data-options="region:'south',split:true" style="height: 340px">
			<!-- <form action="" method="post" id="">
				<table width="100%" style="border-spacing:10px;">
					<tr>
						<td colspan="2">
							<input class="easyui-textbox" data-options="label:'药品',width:240,labelAlign:'right'">
							<input class="easyui-textbox" data-options="required:true,width:240">
							<a id="" href="#" data-options="" class="easyui-linkbutton" style="width:30px;height:22px">…</a>
						</td>
						<td><input class="easyui-textbox" data-options="label:'批号',width:240,labelAlign:'right'"></td>
						<td><input class="easyui-textbox" data-options="label:'结存数量',width:240,labelAlign:'right',value:'0'"></td>
					</tr>
					<tr>
						<td><input class="easyui-textbox" data-options="label:'数量',width:240,labelAlign:'right',value:'0'"></td>
						<td><input class="easyui-textbox" data-options="label:'剂量',width:240,labelAlign:'right',value:'0'"></td>
						<td><input class="easyui-textbox" data-options="label:'单价',width:240,labelAlign:'right',value:'0.00'"></td>
						<td></td>
					</tr>
					<tr>
						<td><input class="easyui-textbox" data-options="label:'金额',width:240,labelAlign:'right',value:'0.00'"></td>
						<td colspan="3">
							<input class="easyui-textbox" data-options="label:'备注',width:540,labelAlign:'right'">
						</td>
					</tr>
					<tr>
						<td colspan="3"></td>
						<td>
							<a id="" href="#" class="easyui-linkbutton" data-options="" style="width:80px;height:22px">加入</a>
 							<a id="" href="#" class="easyui-linkbutton" data-options="" style="width:80px;height:22px">删除</a>
						</td>
					</tr>
				</table>
			</form> -->
			<!-- <table class="easyui-datagrid" data-options="fit:true">
				<thead style="margin-left: 10px;">
					<tr>
						<th data-options="field:'ee',width:30,align:'center'">*</th>
						<th data-options="field:'bh',width:100,align:'center'">药品编号</th>
						<th data-options="field:'name',width:100,align:'center'">药品名称</th>
						<th data-options="field:'num',width:100,align:'center'">数量</th>
						<th data-options="field:'dw',width:100,align:'center'">单位</th>
						<th data-options="field:'jg',width:100,align:'center'">单价</th>
						<th data-options="field:'je',width:100,align:'center'">金额</th>
						<th data-options="field:'sl',width:100,align:'center'">状态</th>
						<th data-options="field:'ph',width:100,align:'center'">批号</th>
						<th data-options="field:'txm',width:100,align:'center'">条形码</th>
						<th data-options="field:'bz',width:100,align:'center'">备注</th>
					</tr>
				</thead>
			</table> -->
			<div id="" class="easyui-tabs" data-options="border:false" style="margin-top: 10px; height: 370px;" >
				<div title="药品信息" style="padding: 5px; display: none;">
					<table class="easyui-datagrid" data-options="method:'get',fit:true,fitColumns : true,rownumbers:true,striped:true" 
							id="select-zhuyuanfayao-table">
						<thead style="margin-left:10px;">
							<tr>
								<th data-options="field:'id',width:30,align:'center'">*</th>
								<th data-options="field:'drugId',width:100,align:'center',
								formatter(value , row ,index){
									return row.drugVo == null ? null : row.drugVo.drugId;
								}">药品编号</th>
								<th data-options="field:'drugName',width:100,align:'center',formatter(value , row ,index){
									return row.drugVo == null ? null : row.drugVo.drugName;
								}">药品名称</th>
								<th data-options="field:'prescriptionRecodeNum',width:100,align:'center'">数量</th>
								
								<th data-options="field:'prescriptionRecodePrice',width:100,align:'center'">单价</th>
								<th data-options="field:'prescriptionRecodeMoney',width:100,align:'center'">金额</th>
								<th data-options="field:'prescriptionRecodeZt',width:100,align:'center'">状态</th>
								<!-- <th data-options="field:'pihao',width:100,align:'center'">批号</th> -->
								
								<th data-options="field:'beizhu',width:100,align:'center'">备注</th>
							</tr>
						</thead>
					</table>
				</div>
			</div>
		</div>
	</div>
	<div id="select-chufan" class="easyui-window" data-options="
			 width:800,
	          height: 460,
	          title: '选择处方',
	          maximizable:false,
	          minimizable:false,
	          collapsible:false,
	          resizable:false,
	          closed: true,
	          modal: true,
	          draggable:false, href :'href_address?myValue=/nurse/prescription_window' , method : 'get'
		">
	</div>
	
</body>
</html>