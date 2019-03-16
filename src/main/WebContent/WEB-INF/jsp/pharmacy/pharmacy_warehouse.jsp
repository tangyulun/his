<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="<c:url value="/js/easyui/themes/default/easyui.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/js/easyui/themes/icon.css"/>">
	<script type="text/javascript" src="<c:url value="/js/jquery-3.1.0.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/easyui/jquery.easyui.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/easyui/easyui-lang-zh_CN.js"/>"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>药房入库</title>
</head>
<body>

	<script type="text/javascript">
		$(function(){
			$("#ypgl").linkbutton({onClick:function(){
				$("#yaopingguanli").window('open');
			}});
			$("#yp").linkbutton({onClick:function(){
				$("#glyp").window('open');
			}});
		});
	</script>

	<div id="win" class="easyui-layout" title="药房入库" data-options="modal:true,fit:true">
 		<!-- 头部按钮   -->
 		<div data-options="region:'north',split:true" style="height:50px">
 			<a id="new_" href="#" class="easyui-linkbutton" style="width:88px;margin-top:10px;margin-left:110px">新建</a>
 			<a id="open" href="#" class="easyui-linkbutton" style="width:88px;margin-top:10px;margin-left:15px">打开</a>
 			<a id="guadan" href="#" class="easyui-linkbutton" style="width:88px;margin-top:10px;margin-left:15px">挂单</a>
 			<a id="chuli" href="#" class="easyui-linkbutton" style="width:88px;margin-top:10px;margin-left:80px">处理</a>
 			<a id="baobiao" href="#" class="easyui-linkbutton" style="width:88px;margin-top:10px;margin-left:80px">报表</a>
 			<a id="daying" href="#" class="easyui-linkbutton" style="width:88px;margin-top:10px;margin-left:15px">打印</a>
 			<a id="close" href="#" class="easyui-linkbutton" style="width:88px;margin-top:10px;margin-left:125px">关闭</a>
 		</div>
 		<!-- 中间文本框  -->
 		<div data-options="region:'center',split:true" style="height:70px;">
 			<form id="ff" method="post">
 				<table width="100%" style="padding: 10px;margin-left:-10px;border-spacing:10px;">
 					<tr>
 						<td><input class="easyui-textbox" data-options="disabled:true,label:'入库编号*',width:240,labelAlign:'right'"></td>
 						<td><input class="easyui-textbox" data-options="label:'状态',width:240,labelAlign:'right'"></td>
 						<td><input class="easyui-datebox" required ="required" data-options="label:'入库日期',width:240,labelAlign:'right'"></td>
 						<td><input class="easyui-textbox" data-options="label:'操作员',width:240,labelAlign:'right'"></td>
 					</tr>
 					<tr>
 						<td>
 							<input class="easyui-combobox" data-options="label:'药房*',width:240,labelAlign:'right',valueField:'',textField:'',url:''">
 							<!-- <select id="" class="easyui-combobox" name="" style="width:200px;" data-options="label:'药房*',labelAlign:'right',">
 								<option>西药房</option>
 								<option>中药房</option>
 							</select> -->
 						</td>
 						<td><input class="easyui-textbox" data-options="label:'总金额',width:240,labelAlign:'right'"></td>
 					</tr>
 				</table>
 			</form>
 		</div>
 		
 		<!-- 最下面的一些查询的东东 -->
 		<div data-options="region:'south',split:true" style="height:380px">
 			<form action="" method="post">
 				<table width="100%" style="padding: 10px;border-spacing:10px;margin-left:-30px">
 					<tr>
 						<td  colspan="2">
 							<input class="easyui-textbox" data-options="label:'药品*',width:200,labelAlign:'right'">
 							<input name="" class="easyui-textbox" data-options="required:true,width:240">
				          	<a id="ypgl" href="#" class="easyui-linkbutton" data-options="" style="width:30px;height:22px">…</a> 
 						</td>
 						<td><input class="easyui-textbox" data-options="label:'批号',width:240,labelAlign:'right'"></td>
 						<td><input class="easyui-textbox" data-options="label:'单价',width:240,labelAlign:'right',value:'0.00'"></td>
 					</tr>
 					<tr>
 						<td><input class="easyui-textbox" data-options="label:'数量*',width:240,labelAlign:'right',value:'0'"></td>
 						<td><input class="easyui-textbox" data-options="label:'金额 ',width:240,labelAlign:'right',value:'0.00'"></td>
 						<td><input class="easyui-datebox" data-options="required:true,label:'生产日期 ',width:240,labelAlign:'right'"></td>
 						<td><input class="easyui-datebox" data-options="required:true,label:'有效期至 ',width:240,labelAlign:'right'"></td>
 					</tr>
 					<tr>
 						<td  colspan="3"><input class="easyui-textbox" data-options="label:'备注',width:600,labelAlign:'right'"></td>
 						<td>
 							<a id="" href="#" class="easyui-linkbutton" data-options="" style="width:80px;height:22px">加入</a>
 							<a id="" href="#" class="easyui-linkbutton" data-options="" style="width:80px;height:22px">删除</a>
 						</td>
 					</tr>
 				</table>
 			</form>
			<table class="easyui-datagrid" data-options="fit:true">
				<thead style="margin-left:10px;">
					<tr>
						<th data-options="field:'wu',width:30,align:'center'">*</th>
						<th data-options="field:'code',width:100,align:'center'">药品编号</th>
						<th data-options="field:'name',width:100,align:'center'">药品名称</th>
						<th data-options="field:'num',width:100,align:'center'">数量</th>
						<th data-options="field:'dw',width:100,align:'center'">单位</th>
						<th data-options="field:'jg',width:100,align:'center'">单价</th>
						<th data-options="field:'je',width:100,align:'center'">金额</th>
						<th data-options="field:'bzq',width:100,align:'center'">保质期至</th>
						<th data-options="field:'scrq',width:100,align:'center'">生产日期</th>
						<th data-options="field:'pb',width:100,align:'center'">批号</th>
						<th data-options="field:'txm',width:100,align:'center'">条形码</th>
						<th data-options="field:'bz',width:100,align:'center'">备注</th>
					</tr>
				</thead>
			</table>
 		</div>
	 </div>
	 <!-- 药品管理 -->
	 <div id="yaopingguanli" class="easyui-window" title="选择药品" style="width:800px;height:500px"
		 data-options="modal:true,collapsible:false,minimizable:false,maximizable:false,closed:true">
	 	<div class="easyui-layout" data-options="fit:true">
	 		<div data-options="region:'north',split:true" style="height:50px;padding:8px">
	 			<a class="easyui-linkbutton" style="margin-left:200px" href="#" id="yp">+(A)</a>
	 			<input class="easyui-textbox" style="width:200px">
	 			<a class="easyui-linkbutton" style="width:80px" href="#" id="">查询</a>
	 			<a class="easyui-linkbutton" style="width:80px;margin-left:130px" href="#" id="">确定</a>
	 		</div>
	 		<div data-options="region:'west',split:true" style="width:200px">
	 			<ul id="" class="easyui-tree">
	 				<li>
	 					<span>药品分类结构</span>
	 					<ul>
	 						<li>
	 							<span><a href="#">A.西药</a></span>
	 						</li>
	 						<li>
	 							<span><a href="#">B.中药</a></span>
	 						</li>
	 						<li>
	 							<span><a href="#">C.注射剂</a></span>
	 						</li>
	 						<li>
	 							<span><a href="#">D.外用药</a></span>
	 						</li>
	 					</ul>
	 				</li>
	 			</ul>
	 		</div>
	 		<div data-options="region:'center',split:true">
	 			<table class="easyui-datagrid" data-options="fit:true">
 					<thead>
 						<tr>
 							<th data-options="field:'code',width:30,align:'center'">*</th>
 							<th data-options="field:'ypbh',width:70,align:'center'">药品编号</th>
 							<th data-options="field:'ypmc',width:100,align:'center'">药品名称</th>
 							<th data-options="field:'jx',width:70,align:'center'">剂型</th>
 							<th data-options="field:'dw',width:70,align:'center'">单位</th>
 							<th data-options="field:'cf',width:70,align:'center'">处方</th>
 							<th data-options="field:'mryf',width:100,align:'center'">默认药房</th>
 							<th data-options="field:'flmc',width:70,align:'center'">分类名称</th>
 							<th data-options="field:'flm',width:100,align:'center'">分类码</th>
 						</tr>
 					</thead>
 				</table>
	 		</div>
	 	</div>
	 </div>
	 
	 <div id="glyp" class="easyui-window" title="药品管理" style="width:800px;height:500px"
	 	data-options="modal:true,collapsible:false,minimizable:false,maximizable:false,closed:true">
	 	<div class="easyui-layout" data-options="fit:true">
	 		<div data-options="region:'north',split:true" style="height:50px;padding:8px">
	 			<a class="easyui-linkbutton" style="width:80px;margin-left:150px" href="#" id="">分类</a>
	 			<a class="easyui-linkbutton" style="width:80px" href="#" id="">查询</a>
	 			<a class="easyui-linkbutton" style="width:80px;margin-left:150px" href="#" id="">新建</a>
	 			<a class="easyui-linkbutton" style="width:80px" href="#" id="">编辑</a>
	 			<a class="easyui-linkbutton" style="width:80px" href="#" id="">删除</a>
	 		</div>
	 		<div data-options="region:'west',split:true" style="width:200px">
	 			<ul id="" class="easyui-tree">
	 				<li>
	 					<span>药品分类结构</span>
	 					<ul>
	 						<li>
	 							<span><a href="#">A.西药</a></span>
	 						</li>
	 						<li>
	 							<span><a href="#">B.中药</a></span>
	 						</li>
	 						<li>
	 							<span><a href="#">C.注射剂</a></span>
	 						</li>
	 						<li>
	 							<span><a href="#">D.外用药</a></span>
	 						</li>
	 					</ul>
	 				</li>
	 			</ul>
	 		</div>
	 		<div data-options="region:'center',split:true">
	 			<table class="easyui-datagrid" data-options="fit:true">
 					<thead>
 						<tr>
 							<th data-options="field:'code',width:30,align:'center'">*</th>
 							<th data-options="field:'ypbh',width:70,align:'center'">药品编号</th>
 							<th data-options="field:'ypmc',width:100,align:'center'">药品名称</th>
 							<th data-options="field:'jx',width:70,align:'center'">剂型</th>
 							<th data-options="field:'dw',width:70,align:'center'">单位</th>
 							<th data-options="field:'cf',width:70,align:'center'">处方</th>
 							<th data-options="field:'mryf',width:100,align:'center'">默认药房</th>
 							<th data-options="field:'flmc',width:70,align:'center'">分类名称</th>
 							<th data-options="field:'flm',width:100,align:'center'">分类码</th>
 						</tr>
 					</thead>
 				</table>
	 		</div>
	 	</div>
	 </div>
</body>
</html>