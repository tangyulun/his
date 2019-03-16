<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>住院发药</title>
</head>
<body>
	<div id="big_win" class="easyui-layout" title="My Window"
		style="width: 800px; height: 500px"
		data-options="iconCls:'icon-save',modal:true,fit:true">
		<div class="easyui-layout" data-options="fit:true">
			<div id="" data-options="region:'north'"
				style="height: 185px; padding: 8px;">
				<a id="btn_add" href="#" class="easyui-linkbutton"
					data-options="
				        iconCls:'icon-add',
				        width: 80
				        "
					style="margin-left: 20px">新增</a> <a id="btn_open" href="#"
					class="easyui-linkbutton"
					data-options="
				        iconCls:'icon-search',
				        width: 80
				        "
					style="margin-left: 20px">打开</a> <a id="btn_entry_orders" href="#"
					class="easyui-linkbutton"
					data-options="
				        iconCls:'icon-search',
				        width: 80
				        "
					style="margin-left: 120px">挂单</a> <a id="btn_dispose" href="#"
					class="easyui-linkbutton"
					data-options="
				        iconCls:'icon-search',
				        width: 80
				        "
					style="margin-left: 120px">记账处理</a> <a id="btn_print" href="#"
					class="easyui-linkbutton"
					data-options="
				        iconCls:'icon-search',
				        width: 80
				        "
					style="margin-left: 20px">打印</a> <a id="btn_close" href="#"
					class="easyui-linkbutton"
					data-options="
				        iconCls:'icon-search',
				        width: 80
				        "
					style="margin-left: 20px">关闭</a>
				<form id="" method="post">
					<table width="100%">
						<tr height="40px">
							<td><input class="easyui-textbox" type="text" name="name" readonly="readonly"
								data-options=" 
									        label: '发药编号*',
									        labelWidth: 100,
									        labelAlign: 'right',
									        width: 240" />
							</td>
							<td><input class="easyui-combobox" value="未处理"
								data-options="
										valueField: 'label',
										textField: 'value',
										disabled: 'ture',
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
							<td><input class="easyui-datebox" type="text" name="name"
								data-options="
								        label: '发药日期',
								        labelAlign: 'right',
								        width: 240" />
							</td>
							<td><input style="right: 100px" class="easyui-combobox"
								type="text" name="name"
								data-options="
									        labelAlign: 'right',
									        label: '发药类型',
									        width: 240" />
							</td>

						</tr>
						<tr height="40px">

							<td><input style="right: 100px" class="easyui-textbox"
								type="text" name="name"
								data-options="
									        labelAlign: 'right',
									        label: '住院号*',
									        width: 240" />
								<a id="" href="#" class="easyui-linkbutton" data-options=""
								style="width: 30px; height: 22px">…</a></td>

							<td><input class="easyui-textbox" type="text" name="name"
								data-options="
									        labelAlign: 'right',
									        label: '操作员',
									        width: 240" />
							<td><input class="easyui-combobox" type="text" name="name"
								data-options="
									        labelAlign: 'right',
									        label: '药房',
									        width: 240" />
								<a id="" href="#" class="easyui-linkbutton" data-options=""
								style="width: 30px; height: 22px">…</a></td>
							<td><input class="easyui-combobox" type="text" name="name"
								data-options="
									        labelAlign: 'right',
									        label: '处方',
									        width: 240" />
								<a id="" href="#" class="easyui-linkbutton" data-options=""
								style="width: 30px; height: 22px">…</a></td>
						</tr>
						<tr>
							<td><input class="easyui-combobox" type="text" name="name"
								data-options="
									        labelAlign: 'right',
									        label: '总金额',
									        width: 240" />
						</tr>
					</table>
				</form>

			</div>
			<div data-options="region:'center'" style="padding: 5px">
				<form id="" method="post">
					<table width="100%">
						<tr height="40px">
							<td colspan="2"><input class="easyui-textbox" type="text"
								name="name"
								data-options="
								        labelAlign: 'right',
								        label: '药品*',
								        width: 220" />
								<input class="easyui-textbox" type="text" name="name"
								data-options="
								        width: 255" /> <a id=""
								href="#" class="easyui-linkbutton" data-options=""
								style="width: 30px; height: 22px">…</a></td>
							<td><input class="easyui-textbox" type="text" name="name"
								data-options="
									        labelAlign: 'right',
									        label: '批号',
									        width: 240" /></td>
						</tr>
						<tr height="40px">
							<td><input class="easyui-textbox" type="text" name="name"
								data-options="
									        labelAlign: 'right',
									        label: '结存数量',
									        width: 240" /></td>
							<td><input class="easyui-textbox" type="text" name="name"
								data-options="
									        labelAlign: 'right',
									        label: '数量*',
									        width: 240" /></td>
							<td><input class="easyui-textbox" type="text" name="name"
								data-options="
									        labelAlign: 'right',
									        label: '剂量',
									        width: 240" /></td>

							<td><a id="btn_add" href="#" class="easyui-linkbutton"
								data-options="
				        iconCls:'icon-add',
				        width: 80
				        "
								style="margin-left: 20px">加入</a></td>

						</tr>
						<tr height="40px">
							<td><input class="easyui-textbox" type="text" name="name"
								data-options="
									        labelAlign: 'right',
									        label: '单价',
									        width: 240" /></td>
							<td><input class="easyui-textbox" type="text" name="name"
								data-options="
									        labelAlign: 'right',
									        label: '金额',
									        width: 240" /></td>
							<td><input class="easyui-textbox" type="text" name="name"
								data-options="
									        labelAlign: 'right',
									        label: '备注',
									        width: 240" /></td>

							<td><a id="btn_add" href="#" class="easyui-linkbutton"
								data-options="
				        iconCls:'icon-add',
				        width: 80
				        "
								style="margin-left: 20px">删除</a></td>

						</tr>
					</table>
				</form>
				<form action="">
					<table class="easyui-datagrid" width="100%"
						data-options="
			              			   fitColumns:true
							           ">
						<thead>
							<tr>
								<th data-options="field:'code1',width:4">*</th>
								<th data-options="field:'name2',width:12">药品编号</th>
								<th data-options="field:'code3',width:12">药品名称</th>
								<th data-options="field:'name4',width:12">药房数量</th>
								<th data-options="field:'code5',width:12">药房单位</th>
								<th data-options="field:'name6',width:12">单价</th>
								<th data-options="field:'code7',width:10">金额</th>
								<th data-options="field:'name8',width:10">批号</th>
								<th data-options="field:'name9',width:10">状态</th>
								<th data-options="field:'name10',width:10">条形码</th>
								<th data-options="field:'name11',width:10">备注</th>
							</tr>
						</thead>
						<tbody>

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
							<tr>

							</tr>
						</tbody>
					</table>
				</form>
			</div>
		</div>

	</div>
</body>
</html>