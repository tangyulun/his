<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>住院通知</title>
</head>
<body>
	<div id="zhuyuantongzhi_big_win" class="easyui-layout" title="住院通知"
		
		data-options="
	        modal:true,
	        collapsible:false,
	        minimizable:false,
	        maximizable:false,
	        resizable:false,fit:true">
		<div class="easyui-layout" data-options="fit:true">
			<div id="" data-options="region:'north'"
				style="height: 45px; padding: 8px;">
				<a id="zytz_btn_add" href="#" class="easyui-linkbutton"
					data-options="
				        iconCls:'icon-add',
				        plain : true,
				        width: 80
				        "
					style="margin-left: 20px">新建</a> <a id="zytz_btn_dispose" href="#"
					class="easyui-linkbutton"
					data-options="
				        iconCls:'icon-ok',
				        width: 80,
				        plain:true
				        "
				       style="margin-left: 10px"
				>处理</a> 
			</div>
			<div data-options="region:'center'" style="padding: 5px">
				<form id="zhuyuantongzhi-form" method="post">
					<table width="100%">
						<tr height="40px">

							<td><input id="notify_number" class="easyui-textbox"
								type="text" name="hospitalNotifyNumber"
								data-options="
								        required:true,
								        label: '住院通知号*',
								        labelAlign: 'right',
								        editable : false,
								        width: 240" />
							</td>

							<td><input readonly="readonly" class="easyui-combobox" value="未处理" name="hospitalNotifyState"
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



							<td><input class="easyui-datebox" type="text" name="hospitalNotifyDate" value="new Date()"
								data-options="
								        required:true,
								        label: '通知日期',
								        labelAlign: 'right',
								        editable : false,
								        width: 240" />
							</td>
						</tr>
						<tr height="40px">

							<td><input class="easyui-textbox" id="text_menzhenNumber" type="text" name="outpaitentRegistId"
								data-options="
								        required:true,
								        labelAlign: 'right',
								        label: '门诊号*',
								        width: 260 ,
								        editable : false,
								        buttonText : '…'
								    
								        " />
								</td>


							<td><input class="easyui-combobox" readonly="readonly" value="门诊" name="dclassName" id="zhuyuantongzhi-dclassName"
								data-options="
										valueField: 'label',
										textField: 'value',
										editable : false,
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


							<td><input class="easyui-textbox" readonly="readonly" type="text" name="medicalCardName" id="zhuyuantongzhi-medicalCardName"
								data-options="
								        labelAlign: 'right',
								        label: '病人姓名',
								        editable : false,
								        width: 240" />
							</td>

						</tr>
						<tr height="40px">

							<td><input class="easyui-textbox" type="text" name="empName" id="zhuyuantongzhi-empName"
								data-options="
								        labelAlign: 'right',
								        label: '门诊医生',
								        editable : false,
								        width: 240" />
								<%-- <select name="empId" class="easyui-combobox" data-options="
										required:true,
								        labelAlign: 'right',
								        label: '门诊医生',
								        editable : false,
								        width: 240">
									<option value="${empMessage.empId}">${empMessage.empLoginName}</option>
								</select> --%>
								</td>

							<td><input class="easyui-textbox" type="text" name="hospitalNotifyCost"
								data-options="
								        required:true,
								        labelAlign: 'right',
								        label: '预计住院费用',
								        width: 240,
								        value: '0',
								        validType:'zhuyuantongzhi_num'" />
							</td>

						</tr>
						<tr height="40px">

							<td><input class="easyui-textbox" type="text" name="hospitalNotifyCashFeiyong"
								data-options="
								        required:true,
								        labelAlign: 'right',
								        label: '最低住院押金',
								        width: 240,
								        value: '0',
								        validType:'zhuyuantongzhi_num'" />
							</td>

							<td><input class="easyui-textbox" type="text" name="hospitalNotifyCashYanjin"
								data-options="
								        required:true,
								        labelAlign: 'right',
								        label: '最低押金',
								        width: 240,
								        value: '0',
								        validType:'zhuyuantongzhi_num'" />
							</td>

							<td><input class="easyui-textbox" type="text" name="hospitalNotifyAlertTheJine"
								data-options="
								        required:true,
								        labelAlign: 'right',
								        label: '押金警戒金额',
								        width: 240,
								        value: '0',
								        validType:'zhuyuantongzhi_num'" />

							</td>
						</tr>

					</table>
					<div style="padding: 10px">
						<input class="easyui-textbox" type="text" name="hospitalNotifyExplain"
							data-options="
		        					height: 200,
		        					width: 700,
		        					label: '通知说明',
		        					abelPosition: 'before',
		        					multiline: 'ture',
		        					labelAlign: 'right'" />
					</div>
				</form>
			</div>
		</div>

	</div>
	
	
	<script type="text/javascript">
		$(function() {
			$.get("get_number_notify", function(data) {
				$("#notify_number").textbox("setValue",
						data.substring(1, data.length - 1));
			});
			//打开挂号页面
			$("#text_menzhenNumber").textbox({onClickButton : function(){
				beMenZhen(function(row){
					
					$("#zhuyuantongzhi-form").form('load',row);
					$("#zhuyuantongzhi-medicalCardName").textbox("setValue", row.medicalCard.medicalCardName);
					$("#zhuyuantongzhi-dclassName").textbox("setValue", row.dclass.dclassName);
					$("#zhuyuantongzhi-empName").textbox("setValue", row.emp.empName);
					$("#select-registered").window("close");
				});
			}});
			
			//添加住院通知记录
			$("#zytz_entry_orders").linkbutton({
				onClick : function() {
					tijiao("未处理");
				}
			});
			$("#zytz_btn_dispose").linkbutton({
				onClick : function() {
					tijiao("已处理");
					$.messager.alert("提示" , "处理成功!");
					$("#zhuyuantongzhi-form").form("reset");
					$.get("get_number_notify", function(data) {
						$("#notify_number").textbox("setValue",
								data.substring(1, data.length - 1));
					});
				}
			});
			//新建
			$("#zytz_btn_add").linkbutton({
				onClick : function() {
					$("#zhuyuantongzhi-form").form("reset");
					$.get("get_number_notify", function(data) {
						$("#notify_number").textbox("setValue",
								data.substring(1, data.length - 1));
					});
				}
			});
		});
		//添加
		function tijiao(state){
			$("#zhuyuantongzhi-form").form("submit", {
				url : 'add_hospitaNotify',
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
		//验证是否是数字或小数
		$.extend($.fn.textbox.defaults.rules, { 
			zhuyuantongzhi_num: { 
	                validator : function(value) { 
	                    var zhuyuantongzhi_num = /^[1-9]\d*\,\d*|[1-9]\d*$/; 
	                    return zhuyuantongzhi_num.test(value); 
	                }, 
	                message : '请输入数字或小数' 
	            } 
	    });
	</script>
</body>
</html>