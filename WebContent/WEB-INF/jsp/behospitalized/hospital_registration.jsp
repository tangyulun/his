<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>住院登记</title>
</head>
<body>
	<div id="zhuyuandengji_big_win" class="easyui-layout" title="住院登记"
		style="width: 800px; height: 500px"
		data-options="
	        modal:true,
	        collapsible:false,
	        minimizable:false,
	        maximizable:false,
	        resizable:false,fit:true">
		<div class="easyui-layout" data-options="fit:true">
			<div id="" data-options="region:'north'"
				style="height: 45px; padding: 8px;">
				<a id="zydj_btn_add" href="#" class="easyui-linkbutton"
					data-options="
				        iconCls:'icon-add',
				        width: 80,
				        plain:true
				        "
					style="margin-left: 20px">新建</a><a id="zydj_btn_dispose" href="#"
					class="easyui-linkbutton"
					data-options="
				        iconCls:'icon-ok',
				        width: 80,
				        plain:true
				        "
					style="margin-left: 10px">处理</a>
			</div>
			<div data-options="region:'center'" style="padding: 5px">
				<form id="zhuyuandengji-form" method="post">
					<table width="100%">
						<tr height="40px">

							<td><input id="zynumber" class="easyui-textbox" type="text"
								name="hospitalRegistrationId"
								data-options="
								         editable : false,
								        label: '住院登记号*',
								        labelAlign: 'right',
								        editable : false,
								        width: 240" />
							</td>

							<td><input readonly="readonly" class="easyui-combobox" value="未处理" name="zhuyuandengji-hospitalRegistrationState" 
								data-options="
										valueField: 'label',
										textField: 'value',
										 editable : false,
										data: [{
											label: '已处理',
											value: '已处理'
										},{
											label: '未处理',
											value: '未处理'
										}],
							        labelAlign: 'right',
							        label: '状态',
							        width: 240" />
							</td>

							<td><input class="easyui-datebox" type="text" name="hospitalRegistrationDate" value="new Date()"
								data-options="
								         
								        label: '入院日期',
								        editable : false,
								        labelAlign: 'right',
								        width: 240" />
							</td>
						</tr>
						<tr height="40px">

							<td><input class="easyui-textbox" type="text" name="hospitalNotifyNumber"
								data-options="
								        required:true,
								        labelAlign: 'right',
								        label: '住院通知号',
								         editable : false,
								        buttonText : '…',
								        onClickButton : function(){
								        	zhuyuantongzhiwindow(function(row){
								        		selectTongzhi(row);
								        	} , '已处理');
								        },
								        width: 260" />
							<td><input class="easyui-textbox" type="text" name="outpaitentRegistId" id="zhuyuandengji-outpaitentRegistId"
								data-options="
								        required:true, 
								        labelAlign: 'right',
								        label: '门诊号',
								        editable : false,
								        width: 240" />
								
								</td>

							<td>
						        <select name="empId" class="easyui-combobox" data-options="
									required:true,
							        labelAlign: 'right',
							        label: '门诊医生',
							        editable : false,
							        width: 240">
									<option value="${empMessage.empId}">${empMessage.empLoginName}</option>
								</select>
							</td>

						</tr>
						<tr height="40px">
							<td><input class="easyui-combobox" readonly="readonly" value="门诊" id="zhuyuandengji-dclassName"
								data-options="
								 editable : false,
										valueField: 'label',
										textField: 'value',
										data: [{
											label: '门诊',
											value: '门诊'
										},{
											label: '住院',
											value: '住院'
										},{
											label: '内科',
											value: '内科'
										},{
											label: '外科',
											value: '外科'
										},{
											label: '儿科',
											value: '儿科'
										},{
											label: '妇科',
											value: '妇科'
										},{
											label: '眼科',
											value: '眼科'
										},{
											label: '骨科',
											value: '骨科'
										}],
							        labelAlign: 'right',
							        label: '科室',
							        width: 240" />
							</td>

							<td><input class="easyui-textbox" readonly="readonly" type="text" name="medicalCardName" id="zhuyuandengji-medicalCardNames"
								data-options="
								          editable : false,
								        labelAlign: 'right',
								        label: '病人姓名',
								        width: 240" />
							</td>
							<td><select class="easyui-combobox" data-options="
									required:true,
							        labelAlign: 'right',
							        label: '医生',
							        editable : false,
							        width: 240">
									<option value="${empMessage.empId}">${empMessage.empLoginName}</option>
								</select>
							</td>
						</tr>
						<tr height="40px">
						<td colspan="2"><input class="easyui-textbox" type="text" name="bedId"
								data-options="
								 editable : false,
								        labelAlign: 'right',
								        label: '病床号',
								        width: 180" />
								<input class="easyui-textbox" type="text" name="bedName"
								data-options="
								        width: 205,
								         editable : false
								        ,buttonText : '…' ,
								        onClickButton : function(){
								        	bedanpai(function(row){
									        	$('#zhuyuandengji-form').form('load',row);
								        	});
								        }" />
							</td>
						</tr>
					</table>
				</form>
				<form action="">
					<table class="easyui-datagrid" width="100%" style="height: 342px;"
						data-options="fitColumns:true,singleSelect:true,
					         method : 'get' , 
					         url : 'select_zhuyuan_yushou',
				             singleSelect : true,
					         pagination: true,
				             pageSize: 5,
				             pageList: [5,10,15, 20],
				             rownumbers : true
					        ">
						<thead>
							<tr>
								<th data-options="field:'zhuyuanYushouId',width:5">*</th>
								<th data-options="field:'zhuyuanYushouMoney',width:16">预收金额</th>
								<th data-options="field:'zhuyuanYushouDate',width:16">收取日期</th>
								<th data-options="field:'rushShouqu',width:16">押金收取号</th>
								<th data-options="field:'zhuyuanYushouState',width:16">状态</th>
							</tr>
						</thead>

					</table>

				</form>
			</div>
		</div>

	</div>
	<!-- 查询住院登记记录 -->
	<div id="select-zhuyuandengjijilu" class="easyui-window" data-options="
			 width:800,
	          height: 460,
	          title: '选择住院登记',
	          maximizable:false,
	          minimizable:false,
	          collapsible:false,
	          resizable:false,
	          closed: true,
	          modal: true,
	          draggable:false, href :'href_address?myValue=/behospitalized/zhuyuandengji_window' , method : 'get'
		">
	</div>
	
	<script type="text/javascript">
		$(function() {
			$.get("get_number", function(data) {
				$("#zynumber").textbox("setValue",
						data.substring(1, data.length - 1));
			});
			
			
			//添加住院登记记录
			$("#zydj_btn_dispose").linkbutton({
				onClick : function() {
					tijiao("已处理");
				}
			});
			//新建
			$("#zydj_btn_add").linkbutton({
				onClick : function() {
					$("#zhuyuandengji-form").form("reset");
					$.get("get_number", function(data) {
						$("#zynumber").textbox("setValue",
								data.substring(1, data.length - 1));
					});
					
				}
			});
			
			$("#zhuyuan_btn_open").linkbutton({onClick : function(){
				selectZhuyuanJilu(function(row){
					
				});
			}});
			
		});
		
		//查询通知数据
		function selectTongzhi(row){
			$("#zhuyuandengji-form").form('load',row);
			$("#zhuyuandengji-outpaitentRegistId").textbox("setValue", row.outpaitentRegist.outpaitentRegistId);
			$("#zhuyuandengji-medicalCardNames").textbox("setValue", row.outpaitentRegist.medicalCard.medicalCardName);
			$("#zhuyuandengji-dclassName").textbox("setValue", row.outpaitentRegist.dclass.dclassName);
		}
		
		
		//添加
		function tijiao(){
			$("#zhuyuandengji-form").form("submit", {
				url : 'add_hospitalRegistration',
				onSubmit : function() {
					return $(this).form("validate");
				},
				success : function(datas) {
					var json = eval("(" + datas + ")");
					if (json.error) {
						$.messager.alert("提示" , "操作成功！");
						$("#zhuyuandengji-form").form("reset");
						$.get("get_number", function(data) {
							$("#zynumber").textbox("setValue",
									data.substring(1, data.length - 1));
						});
					} else {
						$.messager.alert("提示", json.message);
					}
				}
			});
		}
		
	</script>
</body>
</html>