<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>出院登记</title>
</head>
<body>
	<div id="chuyuandengji_big_win" class="easyui-layout" title="My Window"
		style="width: 800px; height: 500px"
		data-options="iconCls:'icon-save',modal:true,fit:true">
		<div class="easyui-layout" data-options="fit:true">
			<div id="" data-options="region:'north'"
				style="height: 45px; padding: 8px;">
				<a id="cydj_btn_add" href="#" class="easyui-linkbutton"
					data-options="
				        iconCls:'icon-add',
				        width: 80,
				        plain:true
				        "
					style="margin-left: 20px">新建</a><a id="cydj_btn_dispose" href="#"
					class="easyui-linkbutton"
					data-options="
						iconCls:'icon-ok',
				        width: 80,
				        plain:true
				        "
					style="margin-left: 10px">处理</a>
			</div>
			<div data-options="region:'center'" style="padding: 5px">

				<form id="chuyuandengji-form" method="post">
					<table width="100%">
						<tr height="40px">

							<td><input id="chuyuan_number" class="easyui-textbox"
								type="text" name="chuyuanLoginId"
								data-options="
								        required:true,
								        label: '出院号*',
								        labelWidth: 100,
								        labelAlign: 'right',
								        editable : false,
								        width: 240" />
							</td>

							<td><input class="easyui-combobox" value="未处理" readonly="readonly" name="chuyuanLoginState"
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
							<td><input class="easyui-datebox" type="text" name="chuyuanLoginDate" value="new Date()"
								data-options="
								        required:true,
								        label: '出院日期',
								        labelAlign: 'right',
								        width: 240" />
							</td>
							<td><input class="easyui-textbox" type="text" name="hospitalRegistrationId"
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
								        width: 260" />
								<!-- <a id="chuyuandengji-zhuyuandengjihao" href="#" class="easyui-linkbutton" data-options=""
								style="width: 30px; height: 22px">…</a></td> -->

						</tr>
						<tr height="40px">
							<td><input class="easyui-textbox" type="text" name="chuyuanInformId" id="chuyuandengji-chuyuanInformId"
								data-options="
								        required:true,
								        labelAlign: 'right',
								        label: '出院通知号*',
								        width: 240" />
							</td>
							<td><input class="easyui-textbox" readonly="readonly" type="text" name="medicalCardName" id="chuyuandengji-medicalCardName"
								data-options="
								        required:true,
								        labelAlign: 'right',
								        label: '病人姓名',
								        width: 240" />

							</td>
							<td><input class="easyui-textbox" readonly="readonly" type="text" name="outpaitentRegistId" id="chuyuandengji-outpaitentRegistId"
								data-options="
								        required:true,
								        labelAlign: 'right',
								        label: '门诊号',
								        width: 240" />
								

							<td><input class="easyui-combobox" readonly="readonly" value="门诊" name="dclassName" id="chuyuandengji-dclassName"
								data-options="
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
						</tr>
						<tr height="40px">

							<td><select name="empId" readonly="readonly" class="easyui-combobox" data-options="
										required:true,
								        labelAlign: 'right',
								        label: '医生',
								        width: 240">
									<option value="${empMessage.empId}">${empMessage.empLoginName}</option>
								</select>
								</td>
							<td colspan="2"><input class="easyui-textbox" type="text"
								name="bedId" id="chuyuandengji-bedId" readonly="readonly"
								data-options="
								        required:true,
								        labelAlign: 'right',
								        label: '病床号*',
								        width: 240" />
								<input class="easyui-textbox" readonly="readonly" type="text" name="bedName" id="chuyuandengji-bedName"
								data-options="
								        required:true,
								        width: 285" />
								
						</tr>
						<tr height="40px">
							<td><input class="easyui-textbox" type="text" name="chuyuanInformYajinZmoney" id="chuyuandengji-chuyuanInformYajinZmoney"
								data-options="
								        required:true,
								        label: '押金合计',
								        labelAlign: 'right',
								        width: 240" />
							</td>
							<td><input class="easyui-textbox" type="text" name="chuyuanInformFeiyongZmoney" id="chuyuandengji-chuyuanInformFeiyongZmoney"
								data-options="
								        required:true,
								        label: '住院费用合计',
								        labelWidth: 100,
								        labelAlign: 'right',
								        width: 240" />
							</td>

						</tr>

					</table>
				</form>
				<div id="" class="easyui-tabs" style="height: 340px;"
					data-options="">
					<div title="已结算项目" style="display: none;">
						<form action="">
							<table class="easyui-datagrid" width="100%" id="chuyuandengj-select-yijiexiangmiu-table"
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
					<div title="费用清单" data-options="" style="display: none;">
						<form action="">
							<table class="easyui-datagrid" width="100%" id="chuyuandengj-select-feiyongqingdan-table"
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

				</div>
			</div>

		</div>

	</div>
	<div id="chuyuandengji-select-zhuyuandengjijilu" class="easyui-window" data-options="
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
			$.get("get_number_chuyuan", function(data) {
				$("#chuyuan_number").textbox("setValue",
						data.substring(1, data.length - 1));
			});
			$("#chuyuandengji-zhuyuandengjihao").linkbutton({
				onClick : function() {
					$("#chuyuandengji-select-zhuyuandengjijilu").window("open");
				}
			});
			
			/* $("#chuyuandengji-select-zhuyuandengjijilu").window({onLoad : function(){
				
				$("#zhuyuandengji-queding").linkbutton({onClick : function(){
					
					row = $("#zydj-table").datagrid("getSelected");
					$.get("select_chuyuan_tongzhi" , {number : row.hospitalRegistrationId} , function(data){
						if(data == ''){
							$.messager.alert('提示','该住院号还没有办理出院通知！');
							return;
						}
						var json = eval('('+data+')'); 
						alert(JSON.stringify(row));
						//alert(row.chuyuanInformId);
						$("#chuyuandengji-form").form('load',row);
						$("#chuyuandengji-chuyuanInformId").textbox("setValue",json.chuyuanInformId);
						$("#chuyuandengji-chuyuanInformYajinZmoney").textbox("setValue",json.chuyuanInformYajinZmoney);
						$("#chuyuandengji-chuyuanInformFeiyongZmoney").textbox("setValue",json.chuyuanInformFeiyongZmoney);
						$("#chuyuandengji-bedId").textbox("setValue",row.bed.bedId);
						$("#chuyuandengji-bedName").textbox("setValue",row.bed.bedName);
						$("#chuyuandengji-outpaitentRegistId").textbox("setValue",row.hospitaNotify.outpaitentRegist.outpaitentRegistId);
						$("#chuyuandengji-medicalCardName").textbox("setValue",row.hospitaNotify.outpaitentRegist.medicalCard.medicalCardName);
						$("#chuyuandengji-dclassName").textbox("setValue",row.hospitaNotify.outpaitentRegist.dclass.dclassName);
						selecttable();
						$("#chuyuandengji-select-zhuyuandengjijilu").window("close");
					});
				}});
				$("#zydj-table").datagrid({onDblClickRow : function(index , rows){
					row=rows;
					$.get("select_chuyuan_tongzhi" , {number : row.hospitalRegistrationId} , function(data){
						if(data == ''){
							$.messager.alert('提示','该住院号还没有办理出院通知！');
							return;
						}
						var json = eval('('+data+')'); 
						alert(JSON.stringify(row));
						//alert(row.chuyuanInformId);
						
						$("#chuyuandengji-form").form('load',row);
						$("#chuyuandengji-chuyuanInformId").textbox("setValue",json.chuyuanInformId);
						$("#chuyuandengji-chuyuanInformYajinZmoney").textbox("setValue",json.chuyuanInformYajinZmoney);
						$("#chuyuandengji-chuyuanInformFeiyongZmoney").textbox("setValue",json.chuyuanInformFeiyongZmoney);
						$("#chuyuandengji-bedId").textbox("setValue",row.bed.bedId);
						$("#chuyuandengji-bedName").textbox("setValue",row.bed.bedName);
						$("#chuyuandengji-outpaitentRegistId").textbox("setValue",row.hospitaNotify.outpaitentRegist.outpaitentRegistId);
						$("#chuyuandengji-medicalCardName").textbox("setValue",row.hospitaNotify.outpaitentRegist.medicalCard.medicalCardName);
						$("#chuyuandengji-dclassName").textbox("setValue",row.hospitaNotify.outpaitentRegist.dclass.dclassName);
						selecttable();
						$("#chuyuandengji-select-zhuyuandengjijilu").window("close");
					});
				
				}});
				
			}}); */
			
			//处理
			$("#cydj_btn_dispose").linkbutton({
				onClick : function() {
					tijiao("已处理");
					$.messager.alert("提示" , "处理成功!");
					$("#chuyuandengji-form").form("reset");
					$.get("get_number_chuyuan", function(data) {
						$("#chuyuan_number").textbox("setValue",
								data.substring(1, data.length - 1));
					});
					var row = $("#chuyuandengj-select-yijiexiangmiu-table").datagrid('getRows');
					for (var i =row.length -1; i >=0; i--) {
						$("#chuyuandengj-select-yijiexiangmiu-table").datagrid('deleteRow',i);
					}
					var rows = $("#chuyuandengj-select-feiyongqingdan-table").datagrid('getRows');
					for (var i =rows.length -1; i >=0; i--) {
						$("#chuyuandengj-select-feiyongqingdan-table").datagrid('deleteRow',i);
					}
				}
			});
			//新建
			$("#cydj_btn_add").linkbutton({
				onClick : function() {
					$("#chuyuandengji-form").form("reset");
					$.get("get_number_chuyuan", function(data) {
						$("#chuyuan_number").textbox("setValue",
								data.substring(1, data.length - 1));
					});
					var row = $("#chuyuandengj-select-yijiexiangmiu-table").datagrid('getRows');
					for (var i =row.length -1; i >=0; i--) {
						$("#chuyuandengj-select-yijiexiangmiu-table").datagrid('deleteRow',i);
					}
					var rows = $("#chuyuandengj-select-feiyongqingdan-table").datagrid('getRows');
					for (var i =rows.length -1; i >=0; i--) {
						$("#chuyuandengj-select-feiyongqingdan-table").datagrid('deleteRow',i);
					}
				}
			});
		});
		function tijiao(state){
			$("#chuyuandengji-form").form("submit" , {
				url: 'add_chuyuanLongin',
				onSubmit : function(data) {
					data.state = state;
					return $(this).form("validate");
				},
				success : function(datas) {
					var json = eval("(" + datas + ")");
					if (json.error) {
						
					} else {
						$.messager.alert("提示", json.message);
					}
				}
			});
		}
		//查询table里数据
		function selecttable(){
			$("#chuyuandengj-select-feiyongqingdan-table").datagrid("load" , "select_all_feiyonghesuan?hospitalRegistrationId="+row.hospitalRegistrationId);
			$("#chuyuandengj-select-yijiexiangmiu-table").datagrid("load" , "select_all_feiyonghesuan?hospitalRegistrationId="+row.hospitalRegistrationId);
			$("#chuyuandengj-select-yijiexiangmiu-table").datagrid({onLoadSuccess : function(){
				var rows = $("#chuyuandengj-select-yijiexiangmiu-table").datagrid('getRows');
				for (var i =rows.length -1; i >=0; i--) {
					if(rows[i].shoufeistate=="未"){
						$("#chuyuandengj-select-yijiexiangmiu-table").datagrid('deleteRow',i);
					}
					
				}
				
			}});
		}
		function selectJilu(row){
			row = $("#zydj-table").datagrid("getSelected");
			if(row.hospitalRegistrationState =='已出院'){
				$.messager.alert("提示","该病人已出院！");
				return;
			}
			$.get("select_chuyuan_tongzhi" , {number : row.hospitalRegistrationId} , function(data){
				if(data == ''){
					$.messager.alert('提示','该住院号还没有办理出院通知！');
					return;
				}
				var json = eval('('+data+')'); 
				//alert(JSON.stringify(row));
				//alert(row.chuyuanInformId);
				$("#chuyuandengji-form").form('load',row);
				$("#chuyuandengji-chuyuanInformId").textbox("setValue",json.chuyuanInformId);
				$("#chuyuandengji-chuyuanInformYajinZmoney").textbox("setValue",json.chuyuanInformYajinZmoney);
				$("#chuyuandengji-chuyuanInformFeiyongZmoney").textbox("setValue",json.chuyuanInformFeiyongZmoney);
				$("#chuyuandengji-bedId").textbox("setValue",row.bed.bedId);
				$("#chuyuandengji-bedName").textbox("setValue",row.bed.bedName);
				$("#chuyuandengji-outpaitentRegistId").textbox("setValue",row.hospitaNotify.outpaitentRegist.outpaitentRegistId);
				$("#chuyuandengji-medicalCardName").textbox("setValue",row.hospitaNotify.outpaitentRegist.medicalCard.medicalCardName);
				$("#chuyuandengji-dclassName").textbox("setValue",row.hospitaNotify.outpaitentRegist.dclass.dclassName);
				//selecttable();
				$("#chuyuandengj-select-feiyongqingdan-table").datagrid("load" , "select_all_feiyonghesuan?hospitalRegistrationId="+row.hospitalRegistrationId);
				$("#chuyuandengj-select-yijiexiangmiu-table").datagrid("load" , "select_all_feiyonghesuan?hospitalRegistrationId="+row.hospitalRegistrationId);
				$("#chuyuandengj-select-yijiexiangmiu-table").datagrid({onLoadSuccess : function(){
					var rows = $("#chuyuandengj-select-yijiexiangmiu-table").datagrid('getRows');
					for (var i =rows.length -1; i >=0; i--) {
						if(rows[i].shoufeistate=="未"){
							$("#chuyuandengj-select-yijiexiangmiu-table").datagrid('deleteRow',i);
						}
						
					}
					
				}});
				$("#chuyuandengji-select-zhuyuandengjijilu").window("close");
			});
		}
	</script>
</body>
</html>