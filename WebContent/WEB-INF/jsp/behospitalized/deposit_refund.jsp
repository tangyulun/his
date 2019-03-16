<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>押金退费</title>
</head>
<body>
	<div id="yajintuifei_big_win" class="easyui-layout" title="押金退费"
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
				<a id="tuifei_btn_add" href="#" class="easyui-linkbutton"
					data-options="
				        iconCls:'icon-add',
				        width: 80,
				        plain:true
				        "
					style="margin-left: 20px">新增</a>
					<a id="tuifei_btn_dispose" href="#"
					class="easyui-linkbutton"
					data-options="
				        iconCls:'icon-ok',
				        width: 80,
				        plain:true
				        "
					style="margin-left: 10px">处理</a>
			</div>
			<div data-options="region:'center'" style="padding: 5px">
				<form id="tuifei-form" method="post">
					<table width="100%">
						<tr height="40px">

							<td><input class="easyui-textbox" type="text" name="yajinTuifeiId" id="cuifeinumber"
								data-options="
								        required:true,
								        label: '押金退费号*',
								        labelAlign: 'right',
								        editable : false,
								        width: 240" />
							</td>

							<td><input class="easyui-combobox" value="未处理" name="yajinTuifeiState" id="yajintuifei-yajinTuifeiState" readonly="readonly"
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



							<td><input class="easyui-datebox" type="text" name="name" value="new Date()"
								data-options="
								        required:true,
								        label: '退费日期',
								        labelAlign: 'right',
								        width: 240" />
							</td>
						</tr>
						<tr height="40px">

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
							</td>
							<td><input class="easyui-textbox" type="text" name="chuyuanInformId" id="tuifei-chuyuanInformId"
								data-options="
								        required:true,
								        editable : false,
								        labelAlign: 'right',
								        label: '出院通知号',
								        width: 240" />
								
							<td><input class="easyui-textbox" readonly="readonly" type="text" name="medicalCardName" id="tuifei-medicalCardName"
								data-options="
								        required:true,
								        labelAlign: 'right',
								        label: '病人姓名',
								        width: 240" />
							</td>

						</tr>
						<tr height="40px">

							<!-- <td><input class="easyui-textbox" type="text" name="name"
								data-options="
								        required:true,
								        labelAlign: 'right',
								        label: '机台号',
								        width: 240" /> -->
								
							<td><input class="easyui-combobox" readonly="readonly" value="门诊" id="tuifei-dclassName" name="dclassName"
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
								
							<td>
								<select name="empId" readonly="readonly" class="easyui-combobox" data-options="
										required:true,
								        labelAlign: 'right',
								        label: '经办人',
								        width: 240">
									<option value="${empMessage.empId}">${empMessage.empLoginName}</option>
								</select>
							</td>

						</tr>
						<tr height="40px">

							<td><input class="easyui-textbox" type="text" name="yajinTuifeiYue" id="tuifei-rushShouquYushouMoney"
								data-options="
								        required:true,
								        labelAlign: 'right',
								        label: '押金余额',
								        width: 240,
								        value : 0.00" />
							</td>

							<td><input class="easyui-textbox" type="text" name="yajinTuifeiYtJine" id="tuifei-yajinTuifeiYtJine"
								data-options="
								        required:true,
								        labelAlign: 'right',
								        label: '应退余额',
								        width: 240,
								        value : 0.00" />
							</td>

							<td><input class="easyui-textbox" type="text" name="yajinTuifeiStJine" id="tuifei-yajinTuifeiStJine"
								data-options="
								        required:true,
								        labelAlign: 'right',
								        label: '实退金额',
								        width: 240,
								        value : 0.00" />

							</td>
						</tr>

					</table>
					<div style="padding: 10px">
						<input class="easyui-textbox" type="text" name="yajinTuifeiRemark"
							data-options="
		        					height: 200,
		        					width: 700,
		        					label: '备注',
		        					abelPosition: 'before',
		        					multiline: 'ture',
		        					labelAlign: 'right'" />
					</div>
				</form>
			</div>
		</div>

	</div>
	<script type="text/javascript">
		var money = 0;
		var price = 0;
		var zmoney = 0;
		function selectJilu(row){
			/* if(row.hospitalRegistrationState =='已出院'){
				$.messager.alert("提示","该病人已出院！");
				return;
			} */
			
			$.get("select_chuyuan_tongzhi" , {number : row.hospitalRegistrationId} , function(data){
				if(data == ''){
					$.messager.alert('提示','该住院号还没有办理出院通知！');
					return;
				}
				var json = eval('('+data+')'); 
				
				$("#tuifei-form").form('load',row);
				
				$("#tuifei-chuyuanInformId").textbox("setValue",json.chuyuanInformId);
				
				$.getJSON("select_yijie_money" , {number : row.hospitalRegistrationId} , function(data){
					/* price = data.zhuyuanJiezhangZmoney;
					alert(price); */
					var price = 0.0;
					for (var i = 0; i < data.length - 1; i++) {
						price +=data[i].zhuyuanJiezhangZmoney; 
						
					}
					$.getJSON("select_shouqu_money" , {number : row.hospitalRegistrationId} , function(data){
						var yajinMoney = 0.0;
						for (var i = 0; i < data.length - 1; i++) {
							yajinMoney +=data[i].rushShouquYushouMoney; 
						}
						zmoney = yajinMoney - price;
						
						$("#tuifei-rushShouquYushouMoney").textbox("setValue",zmoney);
						$("#tuifei-yajinTuifeiYtJine").textbox("setValue", zmoney);
						$("#tuifei-yajinTuifeiStJine").textbox("setValue", zmoney);
						alert(zmoney);
					});
				});
		
				
				//$("#yajintuifei-yajinTuifeiState").textbox("setValue",row.hospitalRegistrationState);
				$("#tuifei-medicalCardName").textbox("setValue",row.hospitaNotify.outpaitentRegist.medicalCard.medicalCardName);
				$("#tuifei-dclassName").textbox("setValue",row.hospitaNotify.outpaitentRegist.dclass.dclassName);
			});
		}
		$(function() {
			$.get("get_yajintuifei_number", function(data) {
				$("#cuifeinumber").textbox("setValue",
						data.substring(1, data.length - 1));
			});
			$("#tuifei_btn_dispose").linkbutton({
				onClick : function() {
					//判断状态是否是未处理，如果不是则进行提示
					/* if($("#yajintuifei-yajinTuifeiState").textbox('getValue') != '未处理'){
						$.messager.alert("提示","不能重复处理该订单");
						return;
					} */
					tijiao("已处理");
					$.messager.alert("提示" , "处理成功!");
					$("#tuifei-form").form("reset");
					$.get("get_yajintuifei_number", function(data) {
						$("#cuifeinumber").textbox("setValue",
								data.substring(1, data.length - 1));
					});
				}
			});
			//新建
			$("#tuifei_btn_add").linkbutton({
				onClick : function() {
					$("#tuifei-form").form("reset");
					$.get("get_yajintuifei_number", function(data) {
						$("#cuifeinumber").textbox("setValue",
								data.substring(1, data.length - 1));
					});
				}
			});
		});
		function tijiao(state){
			$("#tuifei-form").form("submit", {
				url : 'add_yajinTuifei',
				onSubmit : function(data) {
					data.state = state;
					return $(this).form("validate");
				},
				success : function(datas) {
					var json = eval("(" + datas + ")");
					if (json.error) {
						$("#tuifei-form").form("reset");
						$.get("get_yajintuifei_number", function(data) {
							$("#cuifeinumber").textbox("setValue",
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