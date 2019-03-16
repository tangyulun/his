<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>住院治疗记账</title>
</head>
<body>
	<div id="big_win" class="easyui-layout" title="My Window"
		style="width: 800px; height: 500px"
		data-options="iconCls:'icon-save',modal:true,fit:true">
		<div class="easyui-layout" data-options="fit:true">
			<div id="" data-options="region:'north'"
				style="height: 140px; padding: 8px;">
				<a id="zhiliaojizhang_btn_add" href="#" class="easyui-linkbutton"
					data-options="
				        iconCls:'icon-add',
				        width: 80,
				        plain:true
				        "
					style="margin-left: 20px">新建</a> <a id="zhiliaojizhang_btn_dispose" href="#"
					class="easyui-linkbutton"
					data-options="
				        iconCls:'icon-ok',
				        width: 80,
				        plain:true
				        "
					style="margin-left: 10px">记账处理</a> 
				<form id="zhiliao-form" method="post">
					<table width="100%">
						<tr height="40px">
							<td><input id="zhiliao_number" class="easyui-textbox" readonly="readonly"
								type="text" name="zhiliaoJizhangId"
								data-options=" 
									        label: '住院治疗号*',
									        labelWidth: 100,
									        labelAlign: 'right',
									        width: 240" />
							</td>
							<td><input class="easyui-combobox" value="未处理" readonly="readonly" name="zhiliaoJizhangState"
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
							<td><input style="right: 100px" class="easyui-textbox"
								type="text" name="zhiliaoJizhangSate"
								data-options="
									        labelAlign: 'right',
									        label: '住院状态',
									        width: 240,
									        editable : false,
									        value: '住院'" />
							</td>
						</tr>
						<tr height="40px">

							<td><input class="easyui-datebox" type="text" name="zhiliaoJizhangDate" value="new Date()"
								data-options="
								        label: '发药日期',
								        labelAlign: 'right',
								        width: 240" />
							</td>

							<td>
								<select class="easyui-combobox" data-options="
										required:true,
								        labelAlign: 'right',
								        label: '护士',
								        editable : false,
								        width: 240">
									<option value="${empMessage.empId}">${empMessage.empLoginName}</option>
								</select>
							</td>
							<td><select name="empId" class="easyui-combobox" data-options="
										required:true,
								        labelAlign: 'right',
								        label: '记账人',
								        editable : false,
								        width: 240">
									<option value="${empMessage.empId}">${empMessage.empLoginName}</option>
								</select>
							</td>

						</tr>
					</table>
				</form>

			</div>
			<div data-options="region:'center'" style="padding: 5px">
				<form id="zhuyuanzhiliaoxq-form" method="post">
					<table width="100%">
						<tr height="40px">
							<!-- <td colspan="2"><input class="easyui-textbox" type="text"
								name="financialId"
								data-options="
								        labelAlign: 'right',
								        label: '项目*',
								        width: 220" />
								<input class="easyui-textbox" type="text" name="financialHistoryShoufeixm"
								data-options="
								        width: 255" /> <a id=""
								href="#" class="easyui-linkbutton" data-options=""
								style="width: 30px; height: 22px">…</a></td> -->
							<td colspan="1">
								<input id="zhuyuanzhiliao-shoufeiId" name="financialId" class="easyui-combobox"
									data-options="editable : false,method: 'get' , label:'项目*',width:230,labelAlign:'right',url:'queryFinan',valueField:'financialId' , textField : 'financialId'">
								<input id="zhuyuanzhiliao-shoufeiName" name="financialName"
								    class="easyui-textbox"  data-options="editable : false,width:250,buttonText:'…', 
										onClickButton : function(){
											comm(function(row){
												if(row == null){
													$.messager.alert('提示','您选择的这行为空！');
													return;
													
												}
												
												$('#inancialistory-win-window').window('close');
												$('#zhuyuanzhiliao-shoufeiId').textbox('setValue' , row.financialId);
												$('#zhuyuanzhiliao-shoufeiName').textbox('setValue' , row.financialName);
												$('#danjia').textbox('setValue' , row.financialPrice);
												
											});
									}">
							</td>	
							
							<!-- <td><input class="easyui-textbox" type="text" name="chufanhao" 
								data-options="
									        labelAlign: 'right',
									        label: '处方|凭证号',
									        width: 240" />
								<a id="" href="#" class="easyui-linkbutton" data-options=""
								style="width: 30px; height: 22px">…</a></td> -->
							<td><input name="chufanhao"
								class="easyui-combobox"
								data-options="valueField:'prescriptionId',textField:'prescriptionId',
   									 url:'select_all_prescription' , label:'处方|凭证号' ,
   									    width:280 ,  labelAlign : 'right', method : 'get'
   									  , editable : false , required : true" />
							</td>
							<td></td>
							<td><a id="zhuyuanzhiliaoxq_btn_add" href="#" class="easyui-linkbutton"
								data-options="
				        iconCls:'icon-add',
				        width: 80
				        "
								style="float: right;">加入</a></td>
							
						</tr>
						<tr>
							<td><input style="right: 100px" class="easyui-textbox"
								type="text" name="number" id="zhiliao-shuliang"
								data-options="
									        labelAlign: 'right',
									        label: '数量',
									        width: 240,
								        	validType:'zhuyuanzhiliao_num'" />
							</td>
							<td><input style="right: 100px" class="easyui-textbox"
								type="text" name="money" id="zhiliao-jine"
								data-options="
									        labelAlign: 'right',
									        label: '金额',
									        width: 240" />
							</td>
							<td><input style="right: 100px" class="easyui-textbox"
								type="text" name="danjia" id="danjia" readonly="readonly"
								data-options="
									        labelAlign: 'right',
									        label: '单价',
									        width: 240" />
							</td>
							
							<td><a id="zhuyuanzhiliaoxq_btn_delete" href="#" class="easyui-linkbutton"
								data-options="
							        iconCls:'icon-cancel',
							        
							        width: 80
							        "
								style="float: right;">删除</a></td>
							
						</tr>

					</table>
				</form>
				<form action="">
					<table class="easyui-datagrid" width="100%" id="zhiliao-table"
						data-options="
			              		   rownumbers:true,
		              			   singleSelect:true,
		              			   fitColumns: true,
		              			   method : 'get'
							           ">
						<thead>
							<tr>
								<th data-options="field:'id',width:4">*</th>
								<th data-options="field:'financialId',width:12">收费项目编号</th>
								<th data-options="field:'financialName',width:12">收费项目名称</th>
								
								<th data-options="field:'number',width:12">数量</th>
								<th data-options="field:'money',width:12">金额</th>
								<th data-options="field:'state',width:10">状态</th>
								<th data-options="field:'chufanhao',width:10">处方号</th>
							</tr>
						</thead>
						
					</table>
				</form>
			</div>
		</div>
		
	</div>
	<div id="zhiliao-select-zhuyuandengjijilu" class="easyui-window" data-options="
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
				$.get("get_zhiliao_number", function(data) {
					$("#zhiliao_number").textbox("setValue",
							data.substring(1, data.length - 1));
				});
				
				$("#zhiliao-zhyuandengjihao").linkbutton({
					onClick : function() {
						$("#zhiliao-select-zhuyuandengjijilu").window("open");
					}
				});
				
				$("#zhiliao-select-zhuyuandengjijilu").window({onLoad : function(){
					
					$("#zhuyuandengji-queding").linkbutton({onClick : function(){
						row = $("#zydj-table").datagrid("getSelected");
						//alert(JSON.stringify(row));
						$("#zhiliao-form").form('load',row);
						$("#zhiliao-select-zhuyuandengjijilu").window("close");
					}});
					$("#zydj-table").datagrid({onDblClickRow : function(index , rows){
						row=rows;
						$("#zhiliao-form").form('load',rows);
						
						$("#zhiliao-select-zhuyuandengjijilu").window("close");
					}});
				}});
				$("#zhiliaojizhang_btn_entry_orders").linkbutton({
					onClick : function() {
						tijiao("未处理");
					}
				});
				
				
				$("#zhiliaojizhang_btn_dispose").linkbutton({
					onClick : function() {
						if($("#zhiliao-table").datagrid('getRows') ==0){
							 $.messager.alert('提示' , '请至少选择一条数据处理!');
							 return ;
						}
						tijiao("已处理");
						$.messager.alert("提示" , "处理成功!");
						$("#zhiliao-form").form("reset");
						$.get("get_zhiliao_number", function(data) {
							$("#zhiliao_number").textbox("setValue",
									data.substring(1, data.length - 1));
						});
						deletetable();
					}
				});
				//新建
				$("#zhiliaojizhang_btn_add").linkbutton({
					onClick : function() {
						$("#zhiliao-form").form("reset");
						$.get("get_zhiliao_number", function(data) {
							$("#zhiliao_number").textbox("setValue",
									data.substring(1, data.length - 1));
						});
					}
				});
				$("#zhuyuanzhiliaoxq_btn_add").linkbutton({onClick : function(){
					jiaru();
				}}) ;
				$.get("clear_all_ZhuyuanZhiliaojizhang",function(){}); 
				
				$("#zhuyuanzhiliaoxq_btn_delete").linkbutton({onClick : function(){
						var row=$("#zhiliao-table").datagrid("getSelections");
						if(row.length == 0){
							$.messager.alert("提示","请先选择一行");
						}else{
							var str = "";
							for (var i = 0 ; i < row.length ; i++){
								str += row[i].id + "," ;
							}
							$.get("delete_all_ZhuyuanZhiliaojizhang" , {id : str} , function(data){
								$("#zhiliao-table").datagrid("reload" , "select_ZhuyuanZhiliaojizhang");
							});
						}
				}}); 
				//计算金额（单价乘以数量）
				$("#zhiliao-shuliang").textbox({onChange :function(newValue, oldValue){
					var danjia = $("#danjia").textbox("getValue");
					var jine= $("#zhiliao-jine").textbox("setValue" , newValue*danjia);
					
				}});
				
			});
			function tijiao(state){
				$("#zhiliao-form").form("submit",{
					url : 'add_ZhiliaoJizhang',
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
			function jiaru(){
				$("#zhuyuanzhiliaoxq-form").form("submit" , {
					url: 'add_ZhuyuanZhiliaojizhang',
					onSubmit : function(param){
						return $(this).form("validate");
					},
					success : function(){
						$("#zhuyuanzhiliaoxq-form").form("reset");
						$("#zhiliao-table").datagrid("reload" , "select_ZhuyuanZhiliaojizhang");
					}
				});
			}
			function selectJilu(row){
				row = $("#zydj-table").datagrid("getSelected");
				//alert(JSON.stringify(row));
				$("#zhiliao-form").form('load',row);
				$("#zhiliao-select-zhuyuandengjijilu").window("close");
			}
			function deletetable(){
				var row = $("#zhiliao-table").datagrid('getRows');
				for (var i =row.length -1; i >=0; i--) {
					$("#zhiliao-table").datagrid('deleteRow',i);
				}
			}
			//验证是否是数字
			$.extend($.fn.textbox.defaults.rules, { 
				zhuyuanzhiliao_num: { 
		                validator : function(value) { 
		                    var zhuyuanzhiliao_num = /^[0-9]*$/; 
		                    return zhuyuanzhiliao_num.test(value); 
		                }, 
		                message : '请输入数字' 
		            } 
		    });
		</script>
</body>
</html>