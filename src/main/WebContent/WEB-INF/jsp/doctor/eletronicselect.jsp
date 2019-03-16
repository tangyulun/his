<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>处方查询</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/js/easyui/themes/default/easyui.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/js/easyui/themes/icon.css"/>">
<script type="text/javascript"
	src="<c:url value="/js/jquery-3.1.0.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/js/easyui/jquery.easyui.min.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/js/easyui/easyui-lang-zh_CN.js"/>"></script>
</head>
<body>
	<div class="easyui-layout" data-options="fit:true,">

			<div id="eletronic-tab" >
					<input class="easyui-searchbox" style="width:300px" data-options="menu:'#mmm'" />
					<div id="mmm" style="width:150px">
						<div data-options="name:'item1'">Search Item1</div>
						<div data-options="name:'item2',selected:true">Search Item2</div>
						<div data-options="name:'item3'">Search Item3</div>
					</div>
					<a id=""
					href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true"
					style="width: 70px">删除</a>
					<a id=""
					href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok',plain:true"
					style="width: 70px">确定</a>
			</div>
			
			<div data-options="region:'center' , border:false"
				style="height: 450px;padding: 5px" >
				<table class="easyui-datagrid" data-options="
						fit : true,
						fitColumns:true,
						toolbar:'#eletronic-tab',
						pagination:true,
						rownumbers:true,
						pageSize:10,
						pageList:[10,20,30,40]">
					<thead>
						<tr>
							<th data-options="field:'code',width:50,align:'left'">*</th>
							<th data-options="field:'name',width:150,align:'left'">处方号</th>
							<th data-options="field:'price',width:50,align:'left'">状态</th>
							<th data-options="field:'price1',width:100,align:'left'">处方类型</th>
							<th data-options="field:'price2',width:100,align:'left'">处方日期</th>
							<th data-options="field:'price4',width:150,align:'left'">门诊号</th>
							<th data-options="field:'price3',width:100,align:'left'">住院号</th>
							<th data-options="field:'price5',width:50,align:'left'">科室</th>
							<th data-options="field:'price6',width:100,align:'left'">病人姓名</th>
							<th data-options="field:'price7',width:50,align:'left'">性别</th>
							<th data-options="field:'price8',width:50,align:'left'">年龄</th>
							<th data-options="field:'price9',width:50,align:'left'">处方医生</th>
						</tr>
					</thead>
				</table>
			</div>
	</div>
</body>
</html>