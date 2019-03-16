<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>出院通知</title>
</head>
<body>
	<div id="chuyuantongzhi_big_win" class="easyui-layout" title="My Window"
		style="width: 800px; height: 500px"
		data-options="iconCls:'icon-save',modal:true,fit:true">
		<div class="easyui-layout" data-options="fit:true">
			<div id="" data-options="region:'north'"
				style="height: 45px; padding: 8px;">
				<a id="cytz_btn_add" href="#" class="easyui-linkbutton"
					data-options="
				        iconCls:'icon-add',
				        width: 80,
				        plain:true
				        "
					style="margin-left: 20px">新建</a><a id="cytz_btn_dispose" href="#"
					class="easyui-linkbutton"
					data-options="
				        iconCls:'icon-ok',
				        width: 80,
				        plain:true
				        "
					style="margin-left: 10px">处理</a> 
			</div>
			<div data-options="region:'center'" style="padding: 5px">

				<form id="chuyuantz-form" method="post">
					<table width="100%">
						<tr height="40px">

							<td><input id="inform_number" class="easyui-textbox"
								type="text" name="chuyuanInformId"
								data-options="
								        required:true,
								        label: '出院通知号*',
								        labelWidth: 100,
								        labelAlign: 'right',
								        editable : false,
								        width: 240" />
							</td>

							<td><input class="easyui-combobox" value="未处理" readonly="readonly" name="chuyuanInformState"
								data-options="
										valueField: 'label',
										textField: 'value',
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
							<td><input class="easyui-datebox" type="text" name="chuyuanInformDate" value="new Date()"
								data-options="
								        required:true,
								        label: '通知日期',
								        labelAlign: 'right',
								        width: 240" />
							</td>
							<td><input class="easyui-combobox" name="chuyuanInformType"
								data-options="
										valueField: 'label',
										textField: 'value',
								        labelAlign: 'right',
								        label: '出院类型',
								        value: '普通出院',
								        width: 240" />
							</td>

						</tr height="40px">
						<tr>
							<td><input class="easyui-textbox" type="text" name="hospitalRegistrationId"
								data-options="
								        required:true,
								        labelAlign: 'right',
								        label: '住院号*',
								          editable : false,
								        buttonText : '…',
								        onClickButton : function(){
								        	selectZhuyuanJilu(function(row){
								        		selectHesuanJilu(row);
								        	});
								        	
								        },
								        width: 260" />
								<!-- <a id="chuyuantz-zhuyuandengjihao" href="#" class="easyui-linkbutton" data-options=""
								style="width: 30px; height: 22px">…</a> --></td>
							<td><input class="easyui-textbox" type="text" name="outpaitentRegistId" id="chuyuan-outpaitentRegistId"
								data-options="
								        required:true,
								        editable : false,
								        labelAlign: 'right',
								        label: '门诊号*',
								        width: 240" />

							</td>
							<td colspan="2"><input class="easyui-textbox" type="text" id="chuyuan-bedId"
								name="bedId" readonly="readonly"
								data-options="
								        required:true,
								        labelAlign: 'right',
								        label: '病床号*',
								        width: 240" />
								<input class="easyui-textbox" readonly="readonly" type="text" name="bedName" id="chuyuan-bedName"
								data-options="
								        required:true,
					
								        width: 285" />
							</td>
						</tr>
						<tr height="40px">
							<td><input class="easyui-textbox" readonly="readonly" type="text" name="medicalCardName" id="chuyuan-medicalCardName"
								data-options="
								        required:true,
								        labelAlign: 'right',
								        label: '病人姓名',
								        width: 240" />


							</td>
							<td><!-- <input class="easyui-textbox" type="text" name="empId" 
								data-options="
								        required:true,
								        labelAlign: 'right',
								        label: '医生',
								        width: 240" /> -->
								<select name="empId" readonly="readonly" class="easyui-combobox" data-options="
										required:true,
								        labelAlign: 'right',
								        label: '医生',
								        width: 240">
									<option value="${empMessage.empId}">${empMessage.empLoginName}</option>
								</select>
							</td>
							<td>
								<select readonly="readonly" class="easyui-combobox" data-options="
										required:true,
								        labelAlign: 'right',
								        label: '通知人',
								        width: 240">
									<option value="${empMessage.empId}">${empMessage.empLoginName}</option>
								</select>
							</td>

						</tr>
						<tr height="40px">

							<td><input class="easyui-textbox" type="text" name="chuyuanInformFeiyongZmoney" id="chuyuan-chuyuanInformFeiyongZmoney"
								data-options="
								        required:true,
								        label: '住院费用合计',
								        labelWidth: 100,
								        labelAlign: 'right',
								        width: 240,
								        value: '0'" />
							</td>

							<td><input class="easyui-textbox" type="text" name="chuyuanInformYajinZmoney" id="chuyuan-chuyuanInformYajinZmoney"
								data-options="
								        required:true,
								        label: '押金合计',
								        labelAlign: 'right',
								        width: 240,
								        value: '0'" />
							</td>
							<td><input style="right: 100px" class="easyui-textbox"
								type="text" name="name"
								data-options="
								        required:true,
								        labelAlign: 'right',
								        label: '器械已借总数',
								        width: 240,
								        value: '0'" />
							</td>
							<td><input class="easyui-textbox" type="text" name="name"
								data-options="
								        required:true,
								        labelAlign: 'right',
								        label: '器械已还总数',
								        width: 240,
								        value: '0'" />

							</td>

						</tr>
						<tr height="40px">
							<td><input class="easyui-textbox" type="text" name="yizhu"
								data-options="
		        					height: 50,
		        					width: 300,
		        					label: '医嘱',
		        					abelPosition: 'before',
		        					multiline: 'ture',
		        					labelAlign: 'right'" />

							</td>
							<td><input class="easyui-textbox" type="text" name="chuyuanInformRemark"
								data-options="
		        					height: 50,
		        					width: 300,
		        					label: '备注',
		        					abelPosition: 'before',
		        					multiline: 'ture',
		        					labelAlign: 'right'" />

							</td>
						</tr>

					</table>
				</form>
				<div id="" class="easyui-tabs" style="height: 260px;"
					data-options="">
					<div title="收费项目明细" style="display: none;padding-top: 5px">
						<form action="">
							<table class="easyui-datagrid" width="100%" id="chuyuan-select-feiyonghesuan-table"
								data-options="
			              			   fitColumns:true,method : 'get'
							           ">
								<thead>
									<tr>
										<th data-options="field:'id',width:4">*</th>
										<th data-options="field:'shoufeileixing',width:12">收费类型</th>
										<th data-options="field:'shoufeinumber',width:14">收费项目编号</th>
										<th data-options="field:'shoufeiname',width:14">收费项目名称</th>
										<th data-options="field:'shoufeiDate',width:12">收费日期</th>
										<th data-options="field:'shoufeiTime',width:12">收费时间</th>
										<th data-options="field:'zmoney',width:10">金额</th>
										<th data-options="field:'shoufeistate',width:10">状态</th>
										<th data-options="field:'zhuyuandengjihao',width:10">住院号</th>

									</tr>
								</thead>
								
							</table>
						</form>
					</div>
					<div title="住院处方" data-options="" style="display: none;padding-top: 5px">
						<form action="">
							<table class="easyui-datagrid" width="100%" id="chuyuan-select-chufang-table"
								data-options="
			              			   fitColumns:true,method : 'get'
							           ">
								<thead>
									<tr>

										<!-- <th data-options="field:'id',width:4">*</th>
										<th data-options="field:'chufanghao',width:16">处方号</th>
										<th data-options="field:'code3',width:16">处方日期</th>
										<th data-options="field:'shoufeistate',width:16">状态</th>
										<th data-options="field:'code5',width:16">处方医生</th>
										
										<th data-options="field:'zhuyuandengjihao',width:10">住院号</th> -->
										
										<th data-options="field:'id',width:2">*</th>
										<th data-options="field:'chufangHao',width:4">处方号</th>
										<th data-options="field:'chufangState',width:2">状态</th>
										<th data-options="field:'chufangDate',width:3">处方日期</th>
										<th data-options="field:'chufangYisheng',width:2">处方医生</th>

									</tr>
								</thead>
								
							</table>
						</form>
					</div>
					<!-- <div title="还器械" data-options="" style="display: none;">
						<form action="">
							<table class="easyui-datagrid" width="100%"
								data-options="
			              			   fitColumns:true,method : 'get'
							           ">
								<thead>
									<tr>

										<th data-options="field:'code1',width:4">*</th>
										<th data-options="field:'name2',width:16">器械编号</th>
										<th data-options="field:'code3',width:16">器械名称</th>
										<th data-options="field:'name4',width:16">还回单编号</th>
										<th data-options="field:'code5',width:16">还回日期</th>

									</tr>
								</thead>
								
							</table>
						</form>
					</div>
					<div title="领器械" data-options="" style="display: none;">
						<form action="">
							<table class="easyui-datagrid" width="100%"
								data-options="
			              			   fitColumns:true
							           ">
								<thead>
									<tr>
										<th data-options="field:'code1',width:4">*</th>
										<th data-options="field:'name2',width:16">器械编号</th>
										<th data-options="field:'code3',width:16">器械名称</th>
										<th data-options="field:'name4',width:16">归还单编号</th>
										<th data-options="field:'code5',width:16">归还日期</th>
										
									</tr>
								</thead>
								
							</table>
						</form>
					</div> -->
				</div>
			</div>
			<!-- <div data-options="region:'south'"
				style="height: 100px; padding: 10px; padding-top: 20px">
				<form id="" method="post">
					<table width="100%">
						<tr height="40px">

							<td><input class="easyui-textbox" type="text" name="chuyuanInformFeiyongZmoney"
								data-options="
								        required:true,
								        label: '住院费用合计',
								        labelWidth: 100,
								        labelAlign: 'right',
								        width: 240" />
							</td>

							<td><input class="easyui-textbox" type="text" name="chuyuanInformYajinZmoney"
								data-options="
								        required:true,
								        label: '押金合计',
								        labelAlign: 'right',
								        width: 240" />
							</td>
							<td><input style="right: 100px" class="easyui-textbox"
								type="text" name="name"
								data-options="
								        required:true,
								        labelAlign: 'right',
								        label: '器械已借总数',
								        width: 240" />
							</td>
							<td><input class="easyui-textbox" type="text" name="name"
								data-options="
								        required:true,
								        labelAlign: 'right',
								        label: '器械已还总数',
								        width: 240" />

							</td>

						</tr>

					</table>
				</form>


			</div> -->
		</div>

	</div>
	<div id="chuyuantz-select-zhuyuandengjijilu" class="easyui-window" data-options="
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
			$.get("get_number_inform", function(data) {
				$("#inform_number").textbox("setValue",
						data.substring(1, data.length - 1));
			});
			$("#chuyuantz-zhuyuandengjihao").linkbutton({
				onClick : function() {
					$("#chuyuantz-select-zhuyuandengjijilu").window("open");
				}
			});
			/* $("#chuyuantz-select-zhuyuandengjijilu").window({onLoad : function(){
				
				$("#zhuyuandengji-queding").linkbutton({onClick : function(){
					row = $("#zydj-table").datagrid("getSelected");
					//alert(JSON.stringify(row));
					$("#chuyuantz-form").form('load',row);
					$.getJSON("select_shouqu_money" , {number : row.hospitalRegistrationId} , function(data){
						$("#chuyuan-chuyuanInformYajinZmoney").textbox("setValue",data.rushShouquYushouMoney);
					});
					$("#chuyuan-medicalCardName").textbox("setValue",row.hospitaNotify.outpaitentRegist.medicalCard.medicalCardName);
					$("#chuyuan-outpaitentRegistId").textbox("setValue",row.hospitaNotify.outpaitentRegist.outpaitentRegistId);
					$("#chuyuan-bedId").textbox("setValue",row.bed.bedId);
					$("#chuyuan-bedName").textbox("setValue",row.bed.bedName);
					selecttable();
					jisuanMoney();
					$("#chuyuantz-select-zhuyuandengjijilu").window("close");
				}});
				$("#zydj-table").datagrid({onDblClickRow : function(index , rows){
					row=rows;
					$("#chuyuantz-form").form('load',rows);
					$.getJSON("select_shouqu_money" , {number : row.hospitalRegistrationId} , function(data){
						$("#chuyuan-chuyuanInformYajinZmoney").textbox("setValue",data.rushShouquYushouMoney);
					});
					$("#chuyuan-medicalCardName").textbox("setValue",row.hospitaNotify.outpaitentRegist.medicalCard.medicalCardName);
					$("#chuyuan-outpaitentRegistId").textbox("setValue",row.hospitaNotify.outpaitentRegist.outpaitentRegistId);
					$("#chuyuan-bedId").textbox("setValue",row.bed.bedId);
					$("#chuyuan-bedName").textbox("setValue",row.bed.bedName);
					selecttable();
					jisuanMoney();
					$("#chuyuantz-select-zhuyuandengjijilu").window("close");
				}});
				
			}}); */
			$("#cytz_entry_orders").linkbutton({
				onClick : function() {
					tijiao("未处理");
				}
			});
			$("#cytz_btn_dispose").linkbutton({
				onClick : function() {
					tijiao("已处理");
					$.messager.alert("提示" , "处理成功!");
					$("#chuyuantz-form").form("reset");
					$.get("get_number_inform", function(data) {
						$("#inform_number").textbox("setValue",
								data.substring(1, data.length - 1));
					});
					var row = $("#chuyuan-select-feiyonghesuan-table").datagrid('getRows');
					for (var i =row.length -1; i >=0; i--) {
						$("#chuyuan-select-feiyonghesuan-table").datagrid('deleteRow',i);
					}
					var rows = $("#chuyuan-select-chufang-table").datagrid('getRows');
					for (var i =rows.length -1; i >=0; i--) {
						$("#chuyuan-select-chufang-table").datagrid('deleteRow',i);
					}
				}
			});
			//新建
			$("#cytz_btn_add").linkbutton({
				onClick : function() {
					$("#chuyuantz-form").form("reset");
					$.get("get_number_inform", function(data) {
						$("#inform_number").textbox("setValue",
								data.substring(1, data.length - 1));
					});
					var row = $("#chuyuan-select-feiyonghesuan-table").datagrid('getRows');
					for (var i =row.length -1; i >=0; i--) {
						$("#chuyuan-select-feiyonghesuan-table").datagrid('deleteRow',i);
					}
					var rows = $("#chuyuan-select-chufang-table").datagrid('getRows');
					for (var i =rows.length -1; i >=0; i--) {
						$("#chuyuan-select-chufang-table").datagrid('deleteRow',i);
					}
				}
			});
			
			
		});
		function tijiao(state){
			$("#chuyuantz-form").form("submit", {
				url : 'add_chuyuanInform',
				onSubmit : function(data) {
					data.state = state;
					return $(this).form("validate");
				},
				success : function(datas) {
					var json = eval("(" + datas + ")");
					if (json.error) {
						//alert(hospitalRegistrationState);
					} else {
						$.messager.alert("提示", json.message);
					}
				}
			});
		}
		function selecttable(){
			$("#chuyuan-select-feiyonghesuan-table").datagrid("load" , "select_all_feiyonghesuan?hospitalRegistrationId="+row.hospitalRegistrationId);
			$("#chuyuan-select-chufang-table").datagrid("load" , "select_all_chufang?hospitalRegistrationId="+row.hospitalRegistrationId);
		};
		function jisuanMoney(){
			$("#chuyuan-select-feiyonghesuan-table").datagrid({onLoadSuccess : function(){
				var rows = $("#chuyuan-select-feiyonghesuan-table").datagrid('getRows');
				var money = 0.0;
				for (var i = 0; i < rows.length; i++) {
					money +=rows[i].zmoney;
				}
				
				$("#chuyuan-chuyuanInformFeiyongZmoney").textbox("setValue",money);
			}});
			
		};
		function selectHesuanJilu(row){
			row = $("#zydj-table").datagrid("getSelected");
			if(row.hospitalRegistrationState =='已出院'){
				$.messager.alert("提示","该病人已出院！");
				return;
			}
			//alert(JSON.stringify(row));
			$("#chuyuantz-form").form('load',row);
			/* $.getJSON("select_shouqu_money" , {number : row.hospitalRegistrationId} , function(data){
				$("#chuyuan-chuyuanInformYajinZmoney").textbox("setValue",data.rushShouquYushouMoney);
			}); */
			$.getJSON("select_shouqu_money" , {number : row.hospitalRegistrationId} , function(data){
				var yajinMoney = 0.0;
				
				for (var i = 0; i < data.length - 1; i++) {
					
					yajinMoney +=data[i].rushShouquYushouMoney; 
					
					$("#chuyuan-chuyuanInformYajinZmoney").textbox("setValue",yajinMoney);
				}
				//$("#chuyuan-chuyuanInformYajinZmoney").textbox("setValue",data.chuyuanInformYajinZmoney);
			});
			$("#chuyuan-medicalCardName").textbox("setValue",row.hospitaNotify.outpaitentRegist.medicalCard.medicalCardName);
			$("#chuyuan-outpaitentRegistId").textbox("setValue",row.hospitaNotify.outpaitentRegist.outpaitentRegistId);
			$("#chuyuan-bedId").textbox("setValue",row.bed.bedId);
			$("#chuyuan-bedName").textbox("setValue",row.bed.bedName);
			/* selecttable(); */
			$("#chuyuan-select-feiyonghesuan-table").datagrid("load" , "select_all_feiyonghesuan?hospitalRegistrationId="+row.hospitalRegistrationId);
			$("#chuyuan-select-chufang-table").datagrid("load" , "select_all_chufang?hospitalRegistrationId="+row.hospitalRegistrationId);
			jisuanMoney();
			
			$("#chuyuantz-select-zhuyuandengjijilu").window("close");
		};
		
	</script>
</body>
</html>