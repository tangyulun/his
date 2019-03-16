<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>押金收取</title>
</head>
<body>
	<div id="yajinshouxu_big_win" class="easyui-layout" title="押金收取"
		
		data-options="
	        modal:true,
	        collapsible:false,
	        minimizable:false,
	        maximizable:false,
	        resizable:false,fit:true">
		<div class="easyui-layout" data-options="fit:true">
			<div id="" data-options="region:'north'"
				style="height: 45px; padding: 8px;">
				<a id="shouqu_btn_add" href="#" class="easyui-linkbutton"
					data-options="
				        iconCls:'icon-add',
				        width: 80,
				        plain:true
				        "
					style="margin-left: 20px">新建</a> <a id="shouqu_btn_dispose" href="#"
					class="easyui-linkbutton"
					data-options="
				        iconCls:'icon-ok',
				        width: 80,
				        plain:true
				        "
					style="margin-left: 10px">处理</a> 
			</div>
			<div data-options="region:'center'" style="padding: 5px">
				<form id="shouqu-form" method="post">
					<table width="100%">
						<tr height="40px">

							<td><input class="easyui-textbox" type="text" name="rushShouquId" id="rush_shouqu_number"
								data-options="
								        required:true,
								        label: '押金收取号*',
								        labelAlign: 'right',
								        editable : false,
								        width: 220" />
							</td>

							<td><input class="easyui-combobox" value="未处理" readonly="readonly" name="rushShouquState"
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
							        width: 220" />
							</td>



							<td><input class="easyui-datebox" type="text" name="rushShouquDate" value="new Date()"
								data-options="
								        required:true,
								        label: '收取日期',
								        labelAlign: 'right',
								        width: 220" />
							</td>
						</tr>
						<tr height="40px">

							<td><input class="easyui-textbox" type="text" name="hospitalRegistrationId" id="shouqu-hospitalRegistrationId"
								data-options="
								        required:true,
								        labelAlign: 'right',
								        label: '住院号*',
								        editable : false,
								        buttonText : '…',
								        onClickButton : function(){
								        	selectZhuyuanJilu(function(row){
								        		selectMessages(row);
								        	});
								        },
								        width: 240" />
								</td>
							<td><input class="easyui-textbox" type="text" name="hospitalNotifyNumber" id="shouqu-hospitalNotifyNumber"
								data-options="
								        required:true,
								        labelAlign: 'right',
								        label: '住院通知号',
								        editable : false,
								        buttonText : '…',
								        onClickButton : function(){
								        	zhuyuantongzhiwindow(function(row){
								        		selectMessages2(row);
								        	} , '已登记');
								        },
								        width: 240" />
								</td>
							<td>
								<select name="empId" readonly="readonly" class="easyui-combobox" data-options="
										required:true,
								        labelAlign: 'right',
								        label: '经办人',
								        width: 220">
									<option value="${empMessage.empId}">${empMessage.empLoginName}</option>
								</select>
							</td>
						</tr>
						<tr height="40px">
								<td><input class="easyui-combobox" readonly="readonly" value="门诊" name="dclassName" id="shouqu-dclassName"
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
							        width: 220" />


							</td>
							<td><input class="easyui-textbox" readonly="readonly" type="text" name="medicalCardName" id="shouqu-medicalCardName"
								data-options="
								        required:true,
								        labelAlign: 'right',
								        label: '病人姓名',
								        width: 220" />

							</td>
							<td><input class="easyui-textbox" type="text" name="hospitalNotifyAlertTheJine" id="shouqu-hospitalNotifyAlertTheJine"
								data-options="
								        required:true,
								        labelAlign: 'right',
								        label: '押金警戒金额',
								        editable : false,
								        width: 220,
								        value: '0'" />
							</td>
						</tr>
						<tr height="40px">

							<td><input class="easyui-textbox" type="text" name="hospitalNotifyCost" id="shouqu-hospitalNotifyCost"
								data-options="
								        required:true,
								        labelAlign: 'right',
								        label: '当前金额',
								        editable : false,
								        width: 220,
								        value: '0'" />
							</td>

							<td><input class="easyui-textbox" type="text" name="rushShouquYingshouMoney" id="shouqu-rushShouquYingshouMoney"
								data-options="
								        required:true,
								        labelAlign: 'right',
								        label: '应收金额',
								        editable : false,
								        width: 220,
								        value: '0'" />
							</td>

							<td><input class="easyui-textbox" type="text" name="rushShouquYushouMoney"
								data-options="
								        required:true,
								        labelAlign: 'right',
								        label: '预收金额',
								        width: 220,
								        value: '0',
								        validType:'yajinshouqu_num'" />

							</td>
						</tr>

					</table>
					<div style="padding: 10px">
						<input class="easyui-textbox" type="text" name="beizhu"
							data-options="
		        					height: 160,
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
	
	//填充
	function selectMessages(row){
		if(row.hospitalRegistrationState =='已出院'){
			$.messager.alert("提示","该病人已出院！");
			return;
		}
		$("#shouqu-form").form('load',row);
		$("#shouqu-medicalCardName").textbox("setValue",row.hospitaNotify.outpaitentRegist.medicalCard.medicalCardName);
		$("#shouqu-dclassName").textbox("setValue",row.hospitaNotify.outpaitentRegist.dclass.dclassName);
		$("#shouqu-hospitalNotifyAlertTheJine").textbox("setValue",row.hospitaNotify.hospitalNotifyAlertTheJine);
		$("#shouqu-hospitalNotifyNumber").textbox("setValue",row.hospitaNotify.hospitalNotifyNumber);
		$("#shouqu-hospitalNotifyCost").textbox("setValue",row.hospitaNotify.hospitalNotifyCost);
		$("#shouqu-rushShouquYingshouMoney").textbox("setValue",row.hospitaNotify.hospitalNotifyCashYanjin);
		
	}
	
	function selectMessages2(row){
		/* if(row.hospitalRegistrationState =='已出院'){
			$.messager.alert("提示","该病人已出院！");
			return;
		} */
		$.getJSON("select_zhiyuan_dengji" , {number : row.hospitalNotifyNumber} , function(data){
			$("#shouqu-hospitalRegistrationId").textbox("setValue",data.hospitalRegistrationId);
		});
		$("#shouqu-form").form('load',row);
		$("#shouqu-medicalCardName").textbox("setValue",row.outpaitentRegist.medicalCard.medicalCardName);
		$("#shouqu-dclassName").textbox("setValue",row.outpaitentRegist.dclass.dclassName);
	}
	
		$(function() {
			//获取收取号
			$.get("get_number_rush_shouqu", function(data) {
				$("#rush_shouqu_number").textbox("setValue",
						data.substring(1, data.length - 1));
			});
			
			$("#shouqu-zhuyuanhao").linkbutton({
				onClick : function() {
					$("#shouqu-select-zhuyuandengjijilu").window("open");
				}
			});
			$("#shouqu-zhuyuantongzhihao").linkbutton({
				onClick : function() {
					$("#shouqu-select-zhuyuantongzhijilu").window("open");
				}
			});
			
			//处理
			$("#shouqu_btn_dispose").linkbutton({
				onClick : function() {
					tijiao("已处理");
					$.messager.alert("提示" , "处理成功!");
					$("#shouqu-form").form("reset");
					$.get("get_number_rush_shouqu", function(data) {
						$("#rush_shouqu_number").textbox("setValue",
								data.substring(1, data.length - 1));
					});
				}
			});
			//新建
			$("#shouqu_btn_add").linkbutton({
				onClick : function() {
					$("#shouqu-form").form("reset");
					$.get("get_number_rush_shouqu", function(data) {
						$("#rush_shouqu_number").textbox("setValue",
								data.substring(1, data.length - 1));
					});
				}
			});
			
		});
		function tijiao(state){
			$("#shouqu-form").form("submit", {
				url : 'add_rushShouqu',
				onSubmit : function(data) {
					data.state = state;
					return $(this).form("validate");
				},
				success : function(datas) {
					var json = eval("(" + datas + ")");
					if (json.error) {
						$("#shouqu-form").form("reset");
						$.get("get_number_rush_shouqu", function(data) {
							$("#rush_shouqu_number").textbox("setValue",
									data.substring(1, data.length - 1));
						});
					} else {
						$.messager.alert("提示", json.message);
					}
				}
			});
		}
		//验证是否是数字或小数
		$.extend($.fn.textbox.defaults.rules, { 
			yajinshouqu_num: { 
	                validator : function(value) { 
	                    var yajinshouqu_num = /^[1-9]\d*\,\d*|[1-9]\d*$/; 
	                    return yajinshouqu_num.test(value); 
	                }, 
	                message : '请输入数字或小数' 
	            } 
	    });
	</script>
</body>
</html>