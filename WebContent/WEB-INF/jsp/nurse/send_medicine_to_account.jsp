<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>住院发药记账</title>
</head>
<body>
	<div id="big_win" class="easyui-layout" title="My Window"
		style="width: 800px; height: 500px"
		data-options="iconCls:'icon-save',modal:true,fit:true">
		<div class="easyui-layout" data-options="fit:true">
			<div id="" data-options="region:'north'"
				style="height: 140px; padding: 8px;">
				<a id="fayaojizhang_btn_add" href="#" class="easyui-linkbutton"
					data-options="
				        iconCls:'icon-add',
				        width: 80,
				        plain:true
				        "
					style="margin-left: 20px">新建</a><a id="fayaojizhang_btn_dispose" href="#"
					class="easyui-linkbutton"
					data-options="
				        iconCls:'icon-ok',
				        width: 80,
				        plain:true
				        "
					style="margin-left: 10px">记账处理</a>
				<form id="fayao-form" method="post">
					<table width="100%">
						<tr height="40px">
							<td><input id="fayao_number" class="easyui-textbox" readonly="readonly"
								type="text" name="zhuyuanJizhangId"
								data-options=" 
									        label: '住院发药号*',
									        labelWidth: 100,
									        labelAlign: 'right',
									        width: 240" />
							</td> 
							<td><input class="easyui-combobox" value="未处理" readonly="readonly" name="zhuyuanJizhangState"
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
							<td><input class="easyui-datebox" type="text" name="zhuyuanJizhangDate" value="new Date()"
								data-options="
								        label: '发药日期',
								        labelAlign: 'right',
								        width: 240" />
							</td>
							<td><input class="easyui-textbox" type="text" name="hospitalRegistrationId" id="hospitalRegistrationId"
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
								        width: 240" />
								</td>

						</tr>
						<tr height="40px">
							<td><input style="right: 100px" class="easyui-textbox"
								type="text" name="zhuyuanJizhangSate"
								data-options="
									        labelAlign: 'right',
									        label: '住院状态',
									        width: 240,
									        editable : false,
									        value: '住院'" />
							</td>
							<td><select name="empId" class="easyui-combobox" data-options="
										required:true,
								        labelAlign: 'right',
								        label: '发药人',
								        editable : false,
								        width: 240">
									<option value="${empMessage.empId}">${empMessage.empLoginName}</option>
								</select></td>
							<td>
								<select class="easyui-combobox" data-options="
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
				<form id="zhuyuan-yaoping-form" method="post">
					<table width="100%" id="zhuyuan-yaping-table">
						<tr height="40px">
							<td colspan="2"><input class="easyui-textbox" type="text" 
								name="drugId"
								data-options="
										editable : false,
								        labelAlign: 'right',
								        label: '药品*',
								        width: 220" />
								<input class="easyui-textbox" type="text" name="drugBname" id="fayaojizhang-yaopings" 
								data-options="editable : false,
								        width: 255,buttonText:'…'" /><!--  <a id="fayaojizhang-yaoping"
								href="#" class="easyui-linkbutton" data-options=""
								style="width: 30px; height: 22px">…</a> --></td>
							<td><input class="easyui-textbox" type="text"
								name="money" id="fayao-jine" readonly="readonly"
								data-options="
								        labelAlign: 'right',
								        label: '金额',
								        width: 240" />
								</td>
							<!-- <td><input class="easyui-textbox" type="text" name="pingzhengdaohao"
								data-options="
									        labelAlign: 'right',
									        label: '处方|凭证号',
									        width: 240,
									        url:'select_all_prescription'" />
								<a id="" href="#" class="easyui-linkbutton" data-options=""
								style="width: 30px; height: 22px">…</a></td> -->
							
							<td><input name="pingzhengdaohao"
								class="easyui-combobox"
								data-options="valueField:'prescriptionId',textField:'prescriptionId',
   									 url:'select_all_prescription' , label:'处方|凭证号' ,
   									    width:280 ,  labelAlign : 'right', method : 'get'
   									  , editable : false , required : true" />
							</td>
							<td><a id="zhuyuanfayao_btn_add" href="#" class="easyui-linkbutton"
								data-options="
				        iconCls:'icon-add',
				        width: 80
				        "
								style="float: right;">加入</a></td>

						</tr>
						<tr height="40px">
							<td><input class="easyui-textbox" type="text"
								name="number" id="shuliang"
								data-options="
								        labelAlign: 'right',
								        label: '数量*',
								        width: 220,
								        validType:'zhuyuanfayao_num'" />
								</td>
							<td><input class="easyui-textbox" type="text" name="jilian"
								data-options="
									        labelAlign: 'right',
									        label: '剂量',
									        width: 250" />
								</td>
							<td><input class="easyui-textbox" id="fayaoJizhangXqPrice" type="text" name="danjia" readonly="readonly"
								data-options="
									        labelAlign: 'right',
									        label: '单价',
									        width: 240" />
							</td>
							<td></td>
							<td><a id="zhuyuanfayao_btn_delete" href="#" class="easyui-linkbutton"
								data-options="
				       				iconCls:'icon-cancel',
							        
							        width: 80
							        "
								style="float: right;">删除</a></td>

						</tr>
					</table>
				</form>
				<table class="easyui-datagrid" id="shoufeiyaping-table" width="100%"
					data-options="
              			   rownumbers:true,
              			   singleSelect:true,
              			   fitColumns: true,
              			   method : 'get'
				     ">
					<thead>
						<tr>
							<th data-options="field:'shoufeiid',width:12">收费药品编号</th>
							<th data-options="field:'shoufeiname',width:12">收费药品名称</th>
							<th data-options="field:'jilian',width:12">剂量</th>
							<th data-options="field:'number',width:12">数量</th>
							<th data-options="field:'money',width:12">金额</th>
							<th data-options="field:'state',width:10">状态</th>
							<th data-options="field:'pingzhengdaohao',width:10">凭证单号</th>
						</tr>
					</thead>
				</table>
			</div>
		</div>
	</div>
	<div id="fayao-select-zhuyuandengjijilu" class="easyui-window" data-options="
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
	<div id="yaofanjizhang-window" class="easyui-window"
		title="选择药品开药" style="width: 820px; height: 500px"
		data-options="modal:true,minimizable:false,maximizable:false,collapsible:false, resizable:false, closed: true,
			href:'href_address?myValue=/doctor/drug_chufang'
		">
	</div>
	<script type="text/javascript">
	var row = null;
			$(function() {
				$.get("get_fayao_number", function(data) {
					$("#fayao_number").textbox("setValue",
							data.substring(1, data.length - 1));
				});
				
				
				$("#fayao-zhyuandengjihao").linkbutton({
					onClick : function() {
						$("#fayao-select-zhuyuandengjijilu").window("open");
					}
				});
				
				
				
				$("#fayao-select-zhuyuandengjijilu").window({onLoad : function(){
					
					$("#zhuyuandengji-queding").linkbutton({onClick : function(){
						row = $("#zydj-table").datagrid("getSelected");
						//alert(JSON.stringify(row));
						
						$("#fayao-form").form('load',row);
						
						
						$("#fayao-select-zhuyuandengjijilu").window("close");
					}});
					$("#zydj-table").datagrid({onDblClickRow : function(index , rows){
						row=rows;
						$("#fayao-form").form('load',rows);
						
						$("#fayao-select-zhuyuandengjijilu").window("close");
					}});
				}});
				
				
				$("#fayaojizhang_btn_dispose").linkbutton({
					onClick : function() {
						if($("#shoufeiyaping-table").datagrid('getRows') ==0){
							 $.messager.alert('提示' , '请至少选择一条数据处理!');
							 return ;
						}
						tijiao("已处理");
						$.messager.alert("提示" , "处理成功!");
						$("#fayao-form").form("reset");
						$.get("get_fayao_number", function(data) {
							$("#fayao_number").textbox("setValue",
									data.substring(1, data.length - 1));
						});
						deletetable();
					}
				});
				//新建
				$("#fayaojizhang_btn_add").linkbutton({
					onClick : function() {
						$("#fayao-form").form("reset");
						$.get("get_fayao_number", function(data) {
							$("#fayao_number").textbox("setValue",
									data.substring(1, data.length - 1));
						});
					}
				});
				
				
				//打开发药记账的药品
				 $("#fayaojizhang-yaoping").linkbutton({onClick : function(){
					//alert("...");
					$("#yaofanjizhang-window").window("open");
				}}); 
				 $("#fayaojizhang-yaopings").textbox({onClickButton : function(){
						$("#yaofanjizhang-window").window("open");
					}});
				
				$("#fayaojizhang-yaoping").linkbutton({onClick : function(){
					$("#yaofanjizhang-window").window('refresh','href_address?myValue=/doctor/drug_chufang');
					$("#yaofanjizhang-window").window('open');
				}});
				
				//点击选择药品确定传到处方开药界面
				$("#yaofanjizhang-window").window({onLoad : function(){
					$(".refresh-drug-queding").linkbutton({onClick :function(){
						row = $(".drug-tables").datagrid("getSelected");
						$("#zhuyuan-yaoping-form").form('load',row);
						alert(JSON.stringify(row));
						$("#fayaoJizhangXqPrice").textbox("setValue" , row.drugLsprice);
						$("#yaofanjizhang-window").window('close');
					}});
					
					$(".drug-tables").datagrid({onDblClickRow : function(index , rows){
						row = rows;
						$("#zhuyuan-yaoping-form").form('load',rows);
						$("#fayaoJizhangXqPrice").textbox("setValue" , row.drugLsprice);
						$("#yaofanjizhang-window").window('close');
					}});
				}});
				$("#zhuyuanfayao_btn_add").linkbutton({onClick : function(){
					jiaru();
				}}) ;
				$.get("clear_all_zhuyuanyaoping",function(){}); 
				
				$("#zhuyuanfayao_btn_delete").linkbutton({onClick : function(){
						var row=$("#shoufeiyaping-table").datagrid("getSelections");
						if(row.length == 0){
							$.messager.alert("提示","请先选择一行");
						}else{
							var str = "";
							for (var i = 0 ; i < row.length ; i++){
								str += row[i].id + "," ;
							}
							$.get("delete_all_zhuyuanyaoping" , {id : str} , function(data){
								$("#shoufeiyaping-table").datagrid("reload" , "select_all_zhuyuanyaoping");
							});
						}
				}}); 
				//计算金额（单价乘以数量）
				$("#shuliang").textbox({onChange :function(newValue, oldValue){
					var danjia = $("#fayaoJizhangXqPrice").textbox("getValue");
					var jine= $("#fayao-jine").textbox("setValue" , newValue*danjia);
					
				}})
			});
			function tijiao(state){
				$("#fayao-form").form("submit" , {
					url: 'add_FayaoJizhang',
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
				$("#zhuyuan-yaoping-form").form("submit" , {
					url: 'add_ZhuyuanFayaoXq',
					onSubmit : function(param){
						return $(this).form("validate");
					},
					success : function(){
						$("#zhuyuan-yaoping-form").form("reset");
						$("#shoufeiyaping-table").datagrid("reload" , "select_all_zhuyuanyaoping");
					}
				});
			}
			function selectJilu(row){
				row = $("#zydj-table").datagrid("getSelected");
				$("#fayao-form").form('load',row);
				
				$("#fayao-select-zhuyuandengjijilu").window("close");
			}
			function deletetable(){
				var row = $("#shoufeiyaping-table").datagrid('getRows');
				for (var i =row.length -1; i >=0; i--) {
					$("#shoufeiyaping-table").datagrid('deleteRow',i);
				}
			}
			//验证是否是数字
			$.extend($.fn.textbox.defaults.rules, { 
				zhuyuanfayao_num: { 
		                validator : function(value) { 
		                    var zhuyuanfayao_num = /^[0-9]*$/; 
		                    return zhuyuanfayao_num.test(value); 
		                }, 
		                message : '请输入数字' 
		            } 
		    });
		</script>
</body>
</html>