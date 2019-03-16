<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>押金催费</title>
</head>
<body>
	<div id="yajincuifei_big_win" class="easyui-layout" title="押金催费"
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
				<a id="push_btn_add" href="#" class="easyui-linkbutton"
					data-options="
				        iconCls:'icon-add',
				        width: 80,
				        plain:true
				        "
					style="margin-left: 20px">新建</a>  <a id="push_btn_dispose" href="#"
					class="easyui-linkbutton"
					data-options="
				        iconCls:'icon-ok',
				        width: 80,
				        plain:true
				        "
					style="margin-left: 10px">处理</a>
			</div>
			<div data-options="region:'center'" style="padding: 5px">
				<form id="push-form" method="post">
					<table width="100%">
						<tr height="40px">

							<td><input id="rush_number" class="easyui-textbox"
								type="text" name="rushFeeId"
								data-options="
								        required:true,
								        label: '押金催费号*',
								        editable : false,
								        labelAlign: 'right',
								        width: 240" />
							</td>

							<td><input class="easyui-combobox" value="未处理" readonly="readonly" name="rushFeeState"
								data-options="
										valueField: 'label',
										  editable : false,
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



							<td><input class="easyui-datebox" type="text" name="rushFeeDate" value="new Date()"
								data-options="
								        required:true,
								        label: '催费日期',
								          editable : false,
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


							<td><input class="easyui-combobox" readonly="readonly" value="门诊" name="dclassName" id="push-dclassName"
								data-options="
										valueField: 'label',
										  editable : false,
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
							<td><input class="easyui-textbox" type="text" name="medicalCardName" id="push-medicalCardName"
								data-options="
								        required:true,
								        labelAlign: 'right',
								          editable : false,
								        label: '病人姓名',
								        width: 240" />
							</td>
							<td colspan="2"><input class="easyui-textbox" type="text" id="push-bedId"
								name="bedId"
								data-options="
								        required:true,
								        labelAlign: 'right',
								        label: '病床',
								          editable : false,
								        width: 220" />
								<input class="easyui-textbox" type="text" name="bedName" id="push-bedName"
								data-options="
								        required:true,
					  					editable : false,
								        width: 235" />
								   </td>

						</tr>
						<tr height="40px">

							<td><input class="easyui-textbox" type="text" name="hospitalNotifyCashFeiyong" id="push-hospitalNotifyCashFeiyong"
								data-options="
								        required:true,
								        labelAlign: 'right',
								          editable : false,
								        label: '押金总额',
								        width: 240,
								        value:'0'" />
							</td>

							<td><input class="easyui-textbox" type="text" name="rushFeeHospitalRental"
								data-options="
								        required:true,
								        labelAlign: 'right',
								        label: '住院费用总额',
								        width: 240,
								        value:'0',
								        validType:'yajincuifei_num'" />
							</td>

							<td><input class="easyui-textbox" type="text" name="rushFeeSettle"
								data-options="
								        required:true,
								        labelAlign: 'right',
								        label: '已结费用总额',
								        width: 240,
								        value:'0',
								        validType:'yajincuifei_num'" />

							</td>
						</tr>
						<tr height="40px">

							<td><input class="easyui-textbox" type="text" name="hospitalNotifyCashYanjin" id="push-hospitalNotifyCashYanjin"
								data-options="
								        required:true,
								        labelAlign: 'right',
								        label: '最低押金',
								          editable : false,
								        width: 240,
								        value:'0'" />
							</td>
							<td><input class="easyui-textbox" type="text" name="rushFeeWorthOfValue"
								data-options="
								        required:true,
								        labelAlign: 'right',
								        label: '催缴押金',
								        width: 240,
								        value:'0',
								        validType:'yajincuifei_num'" />
							</td>

							<td><input class="easyui-datebox" type="text" name="rushFeeLimitPaymentDate" value="new Date()"
								data-options="
								        required:true,
								        label: '限缴日期',
								          editable : false,
								        labelAlign: 'right',
								        width: 240" />
							</td>
						</tr>

					</table>
					<div style="padding: 10px">
						<input class="easyui-textbox" type="text" name="rushFeeRemark"
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
	
	<!-- 查询押金催费记录 -->
	<div id="push-select-yajincuifeijilu" class="easyui-window" data-options="
			 width:800,
	          height: 460,
	          title: '选择押金催费',
	          maximizable:false,
	          minimizable:false,
	          collapsible:false,
	          resizable:false,
	          closed: true,
	          modal: true,
	          draggable:false, href :'href_address?myValue=/behospitalized/rushfeejilu_window' , method : 'get'
		">
	</div>
	<script type="text/javascript">
	
		//填充记录
		function selectJilu(row){
			$("#push-form").form('load',row);
			if(row.hospitalRegistrationState =='已出院'){
				$.messager.alert("提示","该病人已出院！");
				return;
			}
			$("#push-bedId").textbox("setValue",row.bed.bedId);
			$("#push-bedName").textbox("setValue",row.bed.bedName);
			$("#push-medicalCardName").textbox("setValue",row.hospitaNotify.outpaitentRegist.medicalCard.medicalCardName);
			$("#push-dclassName").textbox("setValue",row.hospitaNotify.outpaitentRegist.dclass.dclassName);
			$("#push-hospitalNotifyCashYanjin").textbox("setValue",row.hospitaNotify.hospitalNotifyCashYanjin);
			$("#push-hospitalNotifyCashFeiyong").textbox("setValue",row.hospitaNotify.hospitalNotifyCashFeiyong);
		}
	
		$(function() {
			$.get("get_number_rush", function(data) {
				$("#rush_number").textbox("setValue",
						data.substring(1, data.length - 1));
			});
			$("#push-zhuyuandengjihao").linkbutton({
				onClick : function() {
					$("#push-select-zhuyuandengjijilu").window("open");
				}
			});
			$("#pushfee_btn_open").linkbutton({
				onClick : function() {
					$("#push-select-yajincuifeijilu").window("open");
				}
			});
			
			$("#push_btn_dispose").linkbutton({
				onClick : function() {
					tijiao("已处理");
				}
			});
			//新建
			$("#push_btn_add").linkbutton({
				onClick : function() {
					$("#push-form").form("reset");
					$.get("get_number_rush", function(data) {
						$("#rush_number").textbox("setValue",
								data.substring(1, data.length - 1));
					});
					
				}
			});
			
		});
		function tijiao(state){
			$("#push-form").form("submit", {
				url : 'add_rushFee',
				onSubmit : function(data) {
					return $(this).form("validate");
				},
				success : function(datas) {
					var json = eval("(" + datas + ")");
					if (json.error) {
						$.messager.alert("提示" , "操作成功！");
						$("#push-form").form("reset");
						$.get("get_number_rush", function(data) {
							$("#rush_number").textbox("setValue",
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
			yajincuifei_num: { 
	                validator : function(value) { 
	                    var yajincuifei_num = /^[1-9]\d*\,\d*|[1-9]\d*$/; 
	                    return yajincuifei_num.test(value); 
	                }, 
	                message : '请输入数字或小数' 
	            } 
	    });
	</script>
</body>
</html>