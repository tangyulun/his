<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>床位调整</title>
</head>
<body>
	<div id="bingfantiaozheng_big_win" class="easyui-layout" title="床位调整"
		
		data-options="
	        modal:true,
	        collapsible:false,
	        minimizable:false,
	        maximizable:false,
	        resizable:false,fit:true">
		<div class="easyui-layout" data-options="fit:true">
			<div id="" data-options="region:'north'"
				style="height: 45px; padding: 8px;">
				<a id="bed_btn_add" href="#" class="easyui-linkbutton"
					data-options="
				        iconCls:'icon-add',
				        width: 80,
				        plain:true
				        "
					style="margin-left: 20px">新建</a>  <a id="beds_btn_dispose" href="#"
					class="easyui-linkbutton"
					data-options="
				        iconCls:'icon-ok',
				        width: 80,
				        plain:true
				        "
					style="margin-left: 10px">处理</a>
			</div>
			<div data-options="region:'center'" style="padding: 5px">
				<form id="beds-from" method="post">
					<table width="100%">
						<tr height="40px">
							<td><input id="beds_number" class="easyui-textbox"
								type="text" name="bedTiaozhengId"
								data-options="
								        label: '病床调整号*',
								        labelAlign: 'right',
								        editable : false,
								        width: 240" />
							</td>

							<td><input class="easyui-combobox" value="未处理" readonly="readonly" name="bedTiaozhengState"
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

							<td><input class="easyui-datebox" type="text" name="bedTiaozhengDate" value="new Date()"
								data-options="
								         
								        label: '调整日期',
								        labelAlign: 'right',
								        width: 240" />
							</td>
						</tr>
						<tr height="40px">

							<td><input class="easyui-textbox" type="text" name="hospitalRegistrationId"
								data-options="
										required:true,
								         buttonText : '…', 
								         editable : false,
										onClickButton : function(){
											selectZhuyuanJilu(function(row){
												selectZhuyuan(row);
											});
										}, 
								        labelAlign: 'right',
								        label: '住院号*',
								        width: 260" />
								</td>


							<td><input class="easyui-textbox" readonly="readonly" type="text" name="medicalCardName" id="bed-medicalCardName"
								data-options="
								         
								        labelAlign: 'right',
								        label: '病人姓名',
								        width: 240" />
							</td>


							<td><select name="empId" readonly="readonly" class="easyui-combobox" data-options="
										required:true,
								        labelAlign: 'right',
								        label: '操作人',
								        width: 240">
									<option value="${empMessage.empId}">${empMessage.empLoginName}</option>
								</select>
							</td>

						</tr>
						<tr height="40px">

							<td colspan="2"><input class="easyui-textbox" type="text" id="oldbedId"
								name="oldbedId" readonly="readonly"
								data-options="
								        labelAlign: 'right',
								        label: '原病床*',
								        width: 220" />
								<input class="easyui-textbox" readonly="readonly" type="text" name="oldbedName" id="oldbedName"
								data-options="
								        width: 255" />
								</td>


						</tr>
						<tr height="40px">

							<td colspan="2"><input class="easyui-textbox" type="text"
								name="bedId"
								data-options="
										required:true,
								        labelAlign: 'right',
								        editable : false,
								        label: '现病床*',
								        width: 220" />
								<input class="easyui-textbox" type="text" name="bedName"
								data-options="
										required:true,
								        buttonText : '…', 
								        editable : false,
										onClickButton : function(){
											bedanpai(function(row){
												$('#beds-from').form('load' , row);
											});
										},
								        width: 275" />
								</td>
						</tr>

					</table>
					<div style="padding: 10px">
						<input class="easyui-textbox" type="text" name="bedTiaozhengRemark"
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
	<!-- 查询住院登记记录 -->
	<div id="bed-select-zhuyuandengjijilu" class="easyui-window" data-options="
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
	function selectZhuyuan(row){
		if(row.hospitalRegistrationState =='已出院'){
			$.messager.alert("提示","该出院号已出院！");
			return;
		}
		$("#beds-from").form('load',row);
		$("#bed-medicalCardName").textbox("setValue", row.hospitaNotify.outpaitentRegist.medicalCard.medicalCardName);
		$("#oldbedId").textbox("setValue",row.bed.bedId);
		$("#oldbedName").textbox("setValue",row.bed.bedName);
	}
		$(function() {
			$.get("get_number1", function(data) {
				$("#beds_number").textbox("setValue",
						data.substring(1, data.length - 1));
			});
			
			$("#new-beds").linkbutton({
				onClick : function() {
					$("#new-beds-window").window("open");
				}
			});
			$("#beds-zhuyuandengjihao").linkbutton({
				onClick : function() {
					$("#bed-select-zhuyuandengjijilu").window("open");
				}
			});
			$("#beds_btn_entry_orders").linkbutton({
				onClick : function() {
					tijiao();
				}
			});
			$("#beds_btn_dispose").linkbutton({
				onClick : function() {
					tijiao("已处理");
					$.messager.alert("提示" , "处理成功!");
					//url = "update_beds?bedId="+ row.bedId;
					$("#beds-from").form("reset");
					$.get("get_number1", function(data) {
						$("#beds_number").textbox("setValue",
								data.substring(1, data.length - 1));
					});
					
				}
			});
			//新建
			$("#bed_btn_add").linkbutton({
				onClick : function() {
					$("#beds-from").form("reset");
					$.get("get_number1", function(data) {
						$("#beds_number").textbox("setValue",
								data.substring(1, data.length - 1));
					});
				}
			});
		});
		
		function tijiao(){
			$("#beds-from").form("submit", {
				url : 'add_bedTiaozheng',
				onSubmit : function(data) {
					return $(this).form("validate");
				},
				success : function(datas) {
					var json = eval("(" + datas + ")");
					if (json.error) {
						/* $.messager.alert("提示" , "操作成功!");
						$("#beds-from").form("reset");
						$.get("get_number1", function(data) {
							$("#beds_number").textbox("setValue",
									data.substring(1, data.length - 1));
						}); */
					} else {
						$.messager.alert("提示", json.message);
					}
				}
			});
		}
		
	</script>
</body>
</html>