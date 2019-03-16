<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="easyui-layout" data-options="fit:true">

		<div id="cc" class="easyui-layout" data-options="fit:true">
			<div data-options="region:'north'"
				style="height: 45px; padding: 8px;">
				<a id="win_btn_add_fenlei" href="#" class="easyui-linkbutton"
					data-options="
				       iconCls:'icon-add',
				        plain:true,
				        width: 80
				        "
					style="margin-left:10px">添加分类 </a> <a id="win_btn_add_bingfang"
					href="#" class="easyui-linkbutton"
					data-options="
				       iconCls:'icon-add',
				        plain:true,
				        width: 80
				        "
					style="margin-left: 10px">添加病房</a>
				<a id="win_btn_bianji" href="#" class="easyui-linkbutton"
					data-options="
						iconCls:'icon-edit',
				       	plain:true,
				        width: 80
				        "
					style="margin-left: 10px">编辑</a><!-- <a id="win_btn_shanchu" href="#"
					class="easyui-linkbutton"
					data-options="
				       iconCls:'icon-cancel',
				       plain:true,
				        width: 80
				        "
					style="margin-left: 20px">删除</a> -->
					<a style="margin-left: 10px">
					
					 <input id="bedName-select"
					class="easyui-searchbox" style="width: 160px; height: 24px;"
					data-options="prompt:'病床名称' , 
					 searcher : function(value , name){
					 	if(value == null){
					 		$('#select_bed_type').datagrid('reload' , 'select_all_bed');
					 	}else{
					 		$('#select_bed_type').datagrid({url : 'select_bedName_where'});
					 		$('#select_bed_type').datagrid('load' ,{bedName : value});
					 	}
					 }
					"></input>
						
					</a>
					 <a id="select-all-bed" href="#"
					class="easyui-linkbutton"
					data-options="
				       iconCls:'icon-search',
				       plain:true,
				        width: 80
				        "
				        style="margin-left: 10px"
					>显示所有</a>
					 <a id="win_bed-btn_ok" href="#"
					class="easyui-linkbutton"
					data-options="
				       iconCls:'icon-ok',
				       plain:true,
				        width: 80
				        "
					style="margin-left: 25px">确定</a>
			</div>

			<div data-options="region:'east'" style="width: 606px;border:none">
				<table class="easyui-datagrid" id="select_bed_type"
					data-options="fitColumns:true,singleSelect:true,fit:true,
					         method : 'get' , 
					         url : 'select_all_bed',
				             singleSelect : true,
					         pagination: true,
				             pageSize: 5,
				             pageList: [5,10,15, 20],
				             rownumbers : true
					        ">
					<thead>
						<tr>
							<th data-options="field:'bedId',width:10">病床编号</th>
							<th data-options="field:'bedName',width:10">病床名称</th>
							<th
								data-options="field:'houseTypeId',width:10 , formatter(value , row , index){
									if(row.houseType != null){
										return row.houseType.text;
									}
									return value;
								}
								">病房</th>
							<th data-options="field:'houseState',width:10">状态</th>
							<th data-options="field:'bedRemark',width:10">备注</th>
						</tr>
					</thead>

				</table>
			</div>
			<div data-options="region:'west'" style="width: 180px;">
				<ul id="tt-type-type" class="easyui-tree"
					data-options="method:'get' ,url : 'select_all_bed_type'">

				</ul>
			</div>

		</div>

		<div id="win-add_fenlei" class="easyui-window" title="添加分类"
			style="width: 350px; height: 200px"
			data-options="model : true ,
		 closed:true,
		 minimizable:false,
		 maximizable:false,
		 collapsible:false,
		 resizable:false">
			<div style="padding-left: 50px; padding-top: 20px">
				<form id="bed-type-ff" method="post">
					<input id="bedTypeTypeId" name="bedTypeTypeId"
						class="easyui-combobox"
						data-options="valueField:'id',
   									 textField:'text',
   									 url:'get_bed_type' , label:'分类名称' ,
   									    width:200 ,  labelAlign : 'right', method : 'get'
   									  , editable : false , required : true" /><br>
					<br> <input id="bedTypeName" class="easyui-textbox"
						name="bedTypeName"
						data-options="label: '病床分类名称',labelAlign: 'right',width: 260,required : true, validType :'regexBedTypeName'"
						style="margin-left: 50px">

				</form>
				<br><br> <a class="easyui-linkbutton"
					data-options="
				       
				        width: 80
				        "
					style="margin-left: 20px" id="save-bed-type">确定</a> <a
					id="win_btn_fenleiqx" class="easyui-linkbutton"
					data-options="
				        width: 80
				        "
					style="margin-left:25px" value="取消"> 取消</a>
			</div>

		</div>
		<div id="win-add_bingfang" class="easyui-window" title="添加病房"
			style="width: 800px; height: 600px"
			data-options="model : true ,
		 closed:true,
		 minimizable:false,
		 maximizable:false,
		 collapsible:false,
		 resizable:false">
			<div style="padding-left: 50px; padding-top: 20px">
				<form id="bed-form" method="post">
					<table width="100%" id="table-bingfang">
						<tr height="40px">
							<td><input id="chuangweihao" class="easyui-textbox"
								type="text" name="bedId"
								data-options="
										readonly : 'ture',
								        label: '床位号*',
								        labelAlign: 'right',
								        width: 260" />
							</td>


						</tr>
						<tr height="40px">
							<td><input class="easyui-textbox" type="text" name="bedName"
								id="bedName"
								data-options="
								        labelAlign: 'right',
								        label: '床位名',
								        width: 260" />
							</td>
						</tr>
						<tr height="40px">
							<td><input id="bedTypeTypeName" name="bedTypeId"
								class="easyui-combotree"
								data-options="
   									 url:'select_all_bed_type' , label:'栋' ,
   									    width:260 ,  labelAlign : 'right', method : 'get'
   									  , editable : false , required : true" /></td>
							<br>
							<br>
						</tr>
						<tr height="40px">

							<td><input id="houseTypeName" name="houseTypeId"
								class="easyui-combobox"
								data-options="valueField:'id',
   									 textField:'text',
   									 url:'get_house_type' , label:'病房' ,
   									    width:260 ,  labelAlign : 'right', method : 'post'
   									  , editable : false , required : true" />
							</td>
							<td><!-- <input class="easyui-combobox" type="text"
								id="houseBingqu" name="houseBingqu"
								data-options="
								        label: '病区',
								        labelAlign: 'right',
								        width: 220" /> -->
								
								<input class="easyui-combobox" value="门诊" name="houseBingqu" id="houseBingqu"
								data-options="
										valueField: 'label',
										textField: 'value',
										data: [{
											label: '一病区',
											value: '一病区'
										},{
											label: '二病区',
											value: '二病区'
										},{
											label: '三病区',
											value: '三病区'
										},{
											label: '四病区',
											value: '四病区'
										},{
											label: '五病区',
											value: '五病区'
										},{
											label: '六病区',
											value: '六病区'
										},{
											label: '七病区',
											value: '七病区'
										},{
											label: '八病区',
											value: '八病区'
										}],
							        labelAlign: 'right',
							        label: '病区',
							        editable : false,
							        width: 260" />
							</td>
						</tr>
						<tr height="40px">
							<td><input class="easyui-combobox" type="text" name="sex" value="男"
								id="sex"
								data-options="
										valueField: 'label',
										textField: 'value',
										data: [{
											label: '男',
											value: '男'
										},{
											label: '女',
											value: '女'
										}],
								        labelAlign: 'right',
								        label: '性别',
								         editable : false,
								        width: 260" />
							</td>
							<td><input class="easyui-combobox" type="text" value="未占用" 
								id="houseState" name="houseState"
								data-options="
								 editable : false,
										valueField: 'label',
										textField: 'value',
										data: [{
											label: '已占用',
											value: '已占用'
										},{
											label: '未占用',
											value: '未占用'
										}],
								        label: '状态',
								        labelAlign: 'right',
								        width: 260" />
							</td>
						</tr>
						<tr height="40px">
							<td><select name="empId" class="easyui-combobox"
								data-options="label:'创建审核人' , width:260 , labelAlign : 'right', editable : false">
									<option value="${empMessage.empId}">${empMessage.empLoginName}</option>
							</select></td>
							<td><input class="easyui-datebox" type="text"
								name="bedCreateDate"
								data-options="
								        value: 'new Date()' ,
								        label: '创建日期',
								        labelAlign: 'right',
								        width: 260" />
							</td>
						</tr>
						<tr height="40px">
							<td rowspan="3" colspan="2"><input class="easyui-textbox"
								type="text" name="bedRemark" id="bedRemark"
								data-options="
								        multiline: 'ture', 
								        labelAlign: 'right',
								        label: '备注',
								        width: 650,
								        height:200" />
							</td>

						</tr>

					</table>
				</form>
				<br> <a id="win_btn_bingfangqd" class="easyui-linkbutton"
					data-options="
				       iconCls:'icon-ok',
				       plain:true,
				        width: 80
				        "
					style="margin-left: 190px">确定</a> <a id="win_btn_bingfangqx"
					href="#" class="easyui-linkbutton"
					data-options="
				       iconCls:'icon-cancel',
				       plain:true,
				        width: 80
				        "
					style="margin-left: 100px">取消</a>
			</div>
		</div>
		<!-- 查询住院登记记录 -->
		<div id="select-zhuyuandengji" class="easyui-window"
			data-options="
			 width:800,
	          height: 460,
	          title: '选择住院登记',
	          maximizable:false,
	          minimizable:false,
	          collapsible:false,
	          resizable:false,
	          closed: true,
	          modal: true,
	          draggable:false
		">
			<!-- <table id="zhuyuan-table" width="100%" class="easyui-datagrid"
				data-options="
						fit : true,
						fitColumns:true,
						pagination:true,
						rownumbers:true,
						pageSize:10,
						singleSelect : true,
						url:'select_all_regist',
						method:'get',
						border:false,
						toolbar:'#zhuyuandengji-table',
						pageList:[10,20,30,40]">
				<thead>
					<tr>
						<th
							data-options="field:'empId',width:20,align:'center',checkbox:true"></th>
						<th
							data-options="field:'outpaitentRegistId',width:100,align:'center'">状态</th>
						<th data-options="field:'keshiname',width:80,align:'center'">住院号</th>
						<th data-options="field:'name',width:80,align:'center'">科室</th>
						<th
							data-options="field:'outpaitentRegistType',width:80,align:'center'">门诊号</th>
						<th data-options="field:'jingbanren',width:120,align:'center'">病人姓名</th>
						<th
							data-options="field:'outpaitentRegistGuahaodate',width:120,align:'center',formatter:date">入院日期</th>
					</tr>
				</thead>
			</table> -->
			<!-- <div id="zhuyuandengji-table">
				<input class="easyui-datebox" value="new Date()" name=""
					id="zhuyuandengji-table-start"
					data-options="width:150,required:true,editable:false"> 至 <input
					class="easyui-datebox" value="new Date()" name=""
					id="zhuyuandengji-table-end"
					data-options="width:150,required:true,editable:false"> <a
					id="zhuyuandengji-table-search" href="#" class="easyui-linkbutton"
					data-options="iconCls:'icon-search',plain:true" style="width: 60px">搜索</a>
				<input class="easyui-searchbox" id="" style="width: 200px;"
					data-options="prompt:'住院号',
			 		 searcher : function(value , name){
			 			if(value == null){
			 				$('#clinic-table').datagrid('reload','select_all_regist');
			 			}else{
			 				$('#clinic-table').datagrid({url : 'select_type_regist'});
			 				$('#clinic-table').datagrid('load',{outpaitentRegistId : value});
			 			}
			 		} 
			 		" />


				<a id="" href="#" class="easyui-linkbutton"
					data-options="iconCls:'icon-reload',plain:true" style="width: 90px">显示所有</a>
				<a id="" href="#" class="easyui-linkbutton"
					data-options="iconCls:'icon-ok',plain:true" style="width: 60px">确定</a>
			</div> -->

		</div>
	</div>
	<script type="text/javascript">
		$(function() {
			
			
			$("#win_btn_add_fenlei").linkbutton({
				onClick : function() {
					$("#win-add_fenlei").window("open");
				}
			});
			$("#win_btn_fenleiqx").linkbutton({
				onClick : function() {
					$("#win-add_fenlei").window("close");
				}
			});
			$("#win_btn_add_bingfang").linkbutton({
				onClick : function() {
					$("#win-add_bingfang").window("open");
					$("#bedName").textbox('setValue', '');
					$("#houseBingqu").combobox('setValue', '');
					$("#sex").textbox('setValue', '');
					$("#houseState").textbox('setValue', '');
					$("#bedRemark").textbox('setValue', '');
					$("#bedTypeTypeName").combotree("reload");
				}
			});
			$("#win_btn_bingfangqx").linkbutton({
				onClick : function() {
					$("#win-add_bingfang").window("close");
				}
			});

			$("#save-bed-type").linkbutton({
				onClick : function() {
					$("#bed-type-ff").form("submit", {
						url : 'add_bed_type',
						onSubmit : function(data) {
							return $(this).form("validate");
						},
						success : function(data) {
							var json = eval("(" + data + ")");
							if (json.error) {
								$("#bedTypeName").textbox('setValue', '');
								$("#win-add_fenlei").window('close');
								$("#tt-type-type").tree("reload");
							} else {
								$.messager.alert("提示", json.message);
							}
						}
					});
				}
			});

			$.get("get_bed_number", function(data) {
				$("#chuangweihao").textbox("setValue",
						data.substring(1, data.length - 1));
			});

			$("#win_btn_bingfangqd").linkbutton({
				onClick : function() {
					$("#bed-form").form("submit", {
						url : 'add_bed',
						onSubmit : function(data) {
							return $(this).form("validate");
						},
						success : function(datas) {
							var json = eval("(" + datas + ")");
							if (json.error) {
								$("#win-add_bingfang").window('close');
								$("#select_bed_type").datagrid("reload");
							} else {
								$.messager.alert("提示", json.message);
							}
						}
					});
				}
			});

			$.extend($.fn.validatebox.defaults.rules, {
				regexBedTypeName : {
					validator : function(value) {
						var json = null;
						$.post({
							async : false,
							url : 'regex_bed_type_name',
							data : {
								BedTypeName : value
							},
							success : function(data) {
								json = eval("(" + data + ")");
							}
						});
						return json.error;
					},
					message : '已存在'
				}
			});
			
			$("#tt-type-type").tree({
				onSelect : function(node) {
					var nodes = node.id;
					if (!$("#tt-type-type").tree('getSelected').children) {
						$("#select_bed_type").datagrid({
							url : 'query_bed_type'
						});
						$("#select_bed_type").datagrid('load', {
							bedTypeId : nodes
						})
					}
				}
			});
			
			//编辑
			$("#win_btn_bianji").linkbutton({onClick : function(){
				var row = $("#select_bed_type").datagrid('getSelected');
				if(row == null){
					$.messager.alert("提示","您选择的这行为空！");
					return;
				}else if(row.houseState =='已占用'){
					$.messager.alert("提示","病床正在使用，不能编辑！");
					return;
				}
				$("#bed-form").form('load',row);
				$("#win-add_bingfang").window({title : '编辑收费项目'});
				$("#win-add_bingfang").window('open');
				$('#bedTypeTypeName').combobox('setValue', row.BedTypeTypeVo.text);
				url = "update_bed?bedId="+ row.bedId;
			}});
			
			
			$("#tt-type-type").tree({onDblClick : function(node){
				$(this).tree('beginEdit', node.target);//开始编辑一个节点
			}});
			
			$("#tt-type-type").tree({onAfterEdit : function(node){
				var id = node.id;
				var text = node.text;
				$.getJSON('update_bedTypeName',{bedTypeId:id,bedTypeName:text},function(data){
					 if(!$("#tt-type-type").tree('getSelected').children){
							$("#select_bed_type").datagrid({url : 'query_bed_type'});
							$("#select_bed_type").datagrid('load' , {bedTypeId : id});//请求参数
							$("#tt-type-type").tree('reload');
					}  
				});
			}});
			
			//打开住院登记记录页面
			/* $("#zhuyuan_btn_open").linkbutton({onClick : function(){
				$("#select-zhuyuandengji").window('open');
				
			}}); */
			$("#select-all-bed").linkbutton({onClick : function(){
				
				$('#select_bed_type').datagrid('reload','select_all_bed');
			}});
		});
	</script>
</body>
</html>