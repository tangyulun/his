<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>住院费用核算</title>
</head>
<body>
	<div id="zhuyuanfeiyonghesuan_big_win" class="easyui-layout" title="My Window"
		style="width: 800px; height: 500px"
		data-options="iconCls:'icon-save',modal:true,fit:true">
		<div class="easyui-layout" data-options="fit:true">
			<div id="" data-options="region:'north'"
				style="height: 45px; padding: 8px;">
				<a id="hesuan_btn_add" href="#" class="easyui-linkbutton"
					data-options="
				        iconCls:'icon-add',
				        width: 80,
				        plain:true
				        "
					style="margin-left: 20px">新增</a> <a id="hesuan_btn_dispose" href="#"
					class="easyui-linkbutton"
					data-options="
				        iconCls:'icon-ok',
				        width: 80,
				        plain:true
				        "
					style="margin-left: 10px">处理</a>
			</div>
			<div data-options="region:'center'" style="padding: 5px">

				<form id="feiyongheshuan-form" method="post">
					<table width="100%">
						<tr height="40px">

							<td><input id="hesuan_number" class="easyui-textbox"
								type="text" name="zhuyuanHesuanId"
								data-options="
								        required:true,
								        label: '住院费用核算号*',
								        labelWidth: 100,
								        labelAlign: 'right',
								        editable : false,
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
								        		selectHesuanJilu(row);
								        	});
								        	
								        },
								        width: 260" />
								<!-- <a id="heshuan-zhuyuandengjihao" href="#" class="easyui-linkbutton" data-options=""
								style="width: 30px; height: 22px">…</a> --></td>

							<td><input class="easyui-datebox" type="text" name="zhuyuanHesuanDate" value="new Date()"
								data-options="
								        required:true,
								        label: '核算日期',
								        labelAlign: 'right',
								        width: 240" />
							</td>
							<td><input style="right: 100px" class="easyui-textbox" id="feiyonghesuan-medicalCardName" name="medicalCardName"
								type="text"
								data-options="
								        required:true,
								        labelAlign: 'right',
								        label: '病人姓名',
								        editable : false,
								        width: 240" />
							</td>
						</tr>
					</table>
				</form>
				<div id="tt" class="easyui-tabs" style="height: 200px;"
					data-options="border:false">
					<div title="处方" style="display: none;padding-top: 5px">
						<form action="">
							<table class="easyui-datagrid" width="100%" id="select-chufang-table"
								data-options="fitColumns:true,method : 'get'">
								<thead>
									<tr>
										<th data-options="field:'id',width:2,hidden : true">*</th>
										<th data-options="field:'chufangHao',width:3">处方号</th>
										<th data-options="field:'chufangState',width:3">状态</th>
										<th data-options="field:'chufangDate',width:3">处方日期</th>
										<th data-options="field:'chufangYisheng',width:2">处方医生</th>
										<!-- <th data-options="field:'chufangMoney',width:4">处方金额</th> -->
									</tr>
								</thead>
								
							</table>
						</form>
					</div>
					<div title="医疗" data-options="border:false" style="display: none; padding-top: 5px">
						<form action="">
							<table class="easyui-datagrid" width="100%" id="select-all-yiliao-table"
								data-options="fitColumns:true,method : 'get'">
								<thead>
									<tr>
										<th data-options="field:'id',width:4,hidden : true">*</th>
										
										<th data-options="field:'shoufeinumber',width:10">收费项目编号</th>
										<th data-options="field:'shoufeiname',width:10">收费项目名称</th>
										<th data-options="field:'shuliang',width:10">数量</th>
										<th data-options="field:'zmoney',width:10">金额</th>
										<th data-options="field:'shoufeistate',width:10">状态</th>
										<th data-options="field:'chufanghao',width:10">处方号</th>
										<th data-options="field:'zhuyuandengjihao',width:10">住院号</th>
									</tr>
								</thead>
								
							</table>
						</form>
					</div>
					<div title="药品" data-options="border:false" style="display: none;padding-top: 5px">
						<form action="">
							<table class="easyui-datagrid" width="100%" id="select-all-yaoping-table"
								data-options="fitColumns:true,method : 'get'">
								<thead>
									<tr>
										<th data-options="field:'id',width:4,hidden : true">*</th>
										<th data-options="field:'shoufeinumber',width:10">收费项目编号</th>
										<th data-options="field:'shoufeiname',width:10">收费项目名称</th>
										<th data-options="field:'shuliang',width:10">数量</th>
										<th data-options="field:'zmoney',width:10">金额</th>
										<th data-options="field:'shoufeistate',width:10">状态</th>
										<th data-options="field:'chufanghao',width:10">处方号</th>
										<th data-options="field:'zhuyuandengjihao',width:10">住院号</th>
									</tr>
								</thead>
							</table>
						</form>
					</div>
				</div>
			</div>
			<div data-options="region:'south'" style="height: 230px;">
				<form action="">
					<table>
						<tr>
							<td><input style="right: 100px" class="easyui-textbox"
								type="text" name="zhuyuanHesuanMoney" id="feiyonghesuan-zhuyuanHesuanMoney"
								data-options="
								        
								        labelAlign: 'right',
								        label: '核算金额',
								        width: 240" />
							</td>
							<td><a id="btn_open" href="#" class="easyui-linkbutton"
								data-options="
								        iconCls:'icon-search',
								        width: 80
								        "
								style="margin-left: 20px">费用核算</a></td>
							<td width="300px"></td>
							
						</tr>
					</table>
				</form>
				<div style="padding: 10px">
					<div style="border: 1px; height: 175px;">
						<table class="easyui-datagrid" width="100%" id="select-feiyonghesuan-table"
							data-options="fitColumns:true,singleSelect:true,fit:true,
					         method : 'get' , 
					         url : '',
				             singleSelect : true,
					         pagination: true,
				             pageSize: 5,
				             pageList: [5,10,15, 20],
				             rownumbers : true
					        ">
							<thead>
								<tr>
									<th data-options="field:'id',width:4,hidden : true">*</th>
									<th data-options="field:'shoufeileixing',width:12">收费类型</th>
									<th data-options="field:'shoufeinumber',width:14">收费项目编号</th>
									<th data-options="field:'shoufeiname',width:14">收费项目名称</th>
									<th data-options="field:'shoufeiDate',width:12" value="new Date()">收费日期</th>
									<th data-options="field:'shoufeiTime',width:12">收费时间</th>
									<th data-options="field:'zmoney',width:10">金额</th>
									<th data-options="field:'shoufeistate',width:10">状态</th>
									<th data-options="field:'zhuyuandengjihao',width:10">住院号</th>

								</tr>
							</thead>
							
						</table>
					</div>
					<!-- <div style="border: 1px; width: 580px; float: right;">
						<table class="easyui-datagrid" width="100%"
							data-options="fitColumns:true">
							<thead>
								<tr>
									<th data-options="field:'code1',width:2">*</th>
									<th data-options="field:'name2',width:10">处方号</th>
									<th data-options="field:'name3',width:12">收费类型</th>
									<th data-options="field:'code4',width:18">收费项目编号</th>
									<th data-options="field:'name5',width:18">收费项目名称</th>
									<th data-options="field:'code6',width:12">收费日期</th>
									<th data-options="field:'name7',width:12">收费时间</th>
									<th data-options="field:'price8',width:10">数量</th>
									<th data-options="field:'code9',width:10">金额</th>
									<th data-options="field:'code10',width:10">金额</th>
									<th data-options="field:'code11',width:10">金额</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>001</td>
									<td>名称1</td>
									<td>2323</td>
									<td>001</td>
									<td>名称1</td>
									<td>2323</td>
									<td>001</td>
									<td>名称1</td>
									<td>2323</td>
									<td>名称1</td>
									<td>2323</td>
								</tr>
								<tr>
									<td>001</td>
									<td>名称1</td>
									<td>2323</td>
									<td>001</td>
									<td>名称1</td>
									<td>2323</td>
									<td>001</td>
									<td>名称1</td>
									<td>2323</td>
									<td>名称1</td>
									<td>2323</td>
								</tr>
								<tr>

								</tr>
								<tr>

								</tr>
								<tr>

								</tr>
								<tr>

								</tr>
								<tr>

								</tr>
								<tr>

								</tr>
								<tr>

								</tr>

							</tbody>
						</table>

					</div> -->
				</div>

			</div>
		</div>

	</div>
	<div id="heshuan-select-zhuyuandengjijilu" class="easyui-window" data-options="
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
			$.get("get_number_hesuan", function(data) {
				$("#hesuan_number").textbox("setValue",
						data.substring(1, data.length - 1));
			});
			$("#heshuan-zhuyuandengjihao").linkbutton({
				onClick : function() {
					$("#heshuan-select-zhuyuandengjijilu").window("open");
				}
			});
			/* $("#heshuan-select-zhuyuandengjijilu").window({onLoad : function(){
				
				$("#zhuyuandengji-queding").linkbutton({onClick : function(){
					
					row = $("#zydj-table").datagrid("getSelected");
					alert(JSON.stringify(row));
					$("#feiyongheshuan-form").form('load',row);
					//$("#select-feiyonghesuan-table").datagrid("load" , "select_all_feiyonghesuan?hospitalRegistrationId="+row.hospitalRegistrationId);
					$("#feiyonghesuan-medicalCardName").textbox("setValue",row.hospitaNotify.outpaitentRegist.medicalCard.medicalCardName);
					selectfeiyonghesuan();
					$("#heshuan-select-zhuyuandengjijilu").window("close");
				}});
				$("#zydj-table").datagrid({onDblClickRow : function(index , rows){
					
					row=rows;
					$("#feiyongheshuan-form").form('load',rows);
					
					$("#feiyonghesuan-medicalCardName").textbox("setValue",row.hospitaNotify.outpaitentRegist.medicalCard.medicalCardName);
					selectfeiyonghesuan();
					$("#heshuan-select-zhuyuandengjijilu").window("close");
				}});
				
			}}); */
			$("#hesuan_btn_dispose").linkbutton({
				
				onClick : function() {
					if($("#select-feiyonghesuan-table").datagrid('getRows') ==0){
						 $.messager.alert('提示' , '住院费用已全部核算!');
						 return ;
					}
					$("#feiyongheshuan-form").form("submit", {
						url : 'add_zhuyuanHesuan',
						onSubmit : function(data) {
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
					$.messager.alert("提示" , "处理成功!");
					$("#feiyongheshuan-form").form("reset");
					$.get("get_number_hesuan", function(data) {
						$("#hesuan_number").textbox("setValue",
								data.substring(1, data.length - 1));
					});
					deletehesuan();
				}
			});
			//新建
			$("#hesuan_btn_add").linkbutton({
				onClick : function() {
					$("#feiyongheshuan-form").form("reset");
					$.get("get_number_hesuan", function(data) {
						$("#hesuan_number").textbox("setValue",
								data.substring(1, data.length - 1));
					});
					var row = $("#select-feiyonghesuan-table").datagrid('getRows');
					for (var i =row.length -1; i >=0; i--) {
						$("#select-feiyonghesuan-table").datagrid('deleteRow',i);
					}
					var rows = $("#select-chufang-table").datagrid('getRows');
					for (var i =rows.length -1; i >=0; i--) {
						$("#select-chufang-table").datagrid('deleteRow',i);
					}
					var rowss = $("#select-all-yiliao-table").datagrid('getRows');
					for (var i =rowss.length -1; i >=0; i--) {
						$("#select-all-yiliao-table").datagrid('deleteRow',i);
					}
					var rowsss = $("#select-all-yaoping-table").datagrid('getRows');
					for (var i =rowsss.length -1; i >=0; i--) {
						$("#select-all-yaoping-table").datagrid('deleteRow',i);
					}
				}
			});
			//$.get("clear_all_feiyonghesuan",function(){}); 
		});

		/* function selectfeiyonghesuan(){
			$("#select-feiyonghesuan-table").datagrid("load" , "select_all_feiyonghesuan?hospitalRegistrationId="+row.hospitalRegistrationId);
			$("#select-chufang-table").datagrid("load" , "select_all_chufang?hospitalRegistrationId="+row.hospitalRegistrationId);
			$("#select-all-yiliao-table").datagrid("load" , "select_all_yiliao?hospitalRegistrationId="+row.hospitalRegistrationId);
			$("#select-all-yaoping-table").datagrid("load" , "select_all_yaoping?hospitalRegistrationId="+row.hospitalRegistrationId);
			$("#select-feiyonghesuan-table").datagrid({onLoadSuccess : function(){
				var rows = $("#select-feiyonghesuan-table").datagrid('getRows');
				for (var i =rows.length -1; i >=0; i--) {
					
					if(rows[i].shoufeistate!="未"){
						$("#select-feiyonghesuan-table").datagrid('deleteRow',i);
					}
					
				}
				var money = 0.0;
				for (var i = 0; i < rows.length; i++) {
					money +=rows[i].zmoney;
				}
				$("#feiyonghesuan-zhuyuanHesuanMoney").textbox("setValue",money);
				
			}});
		}  */
		function deletehesuan(){
			var row = $("#select-feiyonghesuan-table").datagrid('getRows');
			for (var i =row.length -1; i >=0; i--) {
				$("#select-feiyonghesuan-table").datagrid('deleteRow',i);
			}
			var rows = $("#select-chufang-table").datagrid('getRows');
			for (var i =rows.length -1; i >=0; i--) {
				$("#select-chufang-table").datagrid('deleteRow',i);
			}
			var rowss = $("#select-all-yiliao-table").datagrid('getRows');
			for (var i =rowss.length -1; i >=0; i--) {
				$("#select-all-yiliao-table").datagrid('deleteRow',i);
			}
			var rowsss = $("#select-all-yaoping-table").datagrid('getRows');
			for (var i =rowsss.length -1; i >=0; i--) {
				$("#select-all-yaoping-table").datagrid('deleteRow',i);
			}
				
		}
		function selectHesuanJilu(row){
			row = $("#zydj-table").datagrid("getSelected");
			if(row.hospitalRegistrationState =='已出院'){
				$.messager.alert("提示","该病人已出院！");
				return;
			}
			//alert(JSON.stringify(row));
			$("#feiyongheshuan-form").form('load',row);
			//$("#select-feiyonghesuan-table").datagrid("load" , "select_all_feiyonghesuan?hospitalRegistrationId="+row.hospitalRegistrationId);
			$("#feiyonghesuan-medicalCardName").textbox("setValue",row.hospitaNotify.outpaitentRegist.medicalCard.medicalCardName);
			/* selectfeiyonghesuan(); */
			$("#select-feiyonghesuan-table").datagrid("load" , "select_all_feiyonghesuan?hospitalRegistrationId="+row.hospitalRegistrationId);
			$("#select-chufang-table").datagrid("load" , "select_all_chufang?hospitalRegistrationId="+row.hospitalRegistrationId);
			$("#select-all-yiliao-table").datagrid("load" , "select_all_yiliao?hospitalRegistrationId="+row.hospitalRegistrationId);
			$("#select-all-yaoping-table").datagrid("load" , "select_all_yaoping?hospitalRegistrationId="+row.hospitalRegistrationId);
			$("#select-feiyonghesuan-table").datagrid({onLoadSuccess : function(){
				var rows = $("#select-feiyonghesuan-table").datagrid('getRows');
				for (var i =rows.length -1; i >=0; i--) {
					if(rows[i].shoufeistate!="已"){
						$("#select-feiyonghesuan-table").datagrid('deleteRow',i);
					}
					
				}
				var money = 0.0;
				for (var i = 0; i < rows.length; i++) {
					money +=rows[i].zmoney;
				}
				$("#feiyonghesuan-zhuyuanHesuanMoney").textbox("setValue",money);
				
			}});
			$("#heshuan-select-zhuyuandengjijilu").window("close");
		}
	</script>
</body>
</html>