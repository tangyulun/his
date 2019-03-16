<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>处方记录</title>
</head>
<body>
	<!-- 查询处方记录 -->
	<div class="easyui-layout" data-options="fit:true" id="chufanjilu-div">
		<table id="chufan-table"   width="100%" class="easyui-datagrid" data-options="
						fit : true,
						fitColumns:true,
						pagination:true,
						rownumbers:true,
						pageSize:10,
						singleSelect : true,
						url:'select_all_prescriptions',
						method:'get',
						border:false,
						toolbar:'#chufan-div',
						pageList:[10,20,30,40]">
				<thead>
					<tr>
						<th data-options="field:'prescriptionId',width:100,align:'center'">处方号</th>
						<th data-options="field:'prescriptionZt',width:80,align:'center'">状态</th>
						<th data-options="field:'prescriptionDate',width:120,align:'center',formatter:date">处方日期</th>
						<th data-options="field:'prescriptionYzzx',width:120,align:'center'">医嘱执行</th>
						<th data-options="field:'prescriptionType',width:120,align:'center'">处方类型</th>
						<%-- <th data-options="field:'outpaitentRegistId',width:80, formatter(value , row , index){	
								<!-- alert(JSON.stringify(row)); -->
									if(row.outpaitentRegist != null){
										return row.outpaitentRegist.outpaitentRegistId;
									}
									return value;
								}
								">门诊号</th> --%>
						
					</tr>
				</thead>
		</table>
		<div id="chufan-div">
			<input class="easyui-datebox" value="new Date()" name="" id="chufan-table-start" data-options="width:150,required:true,editable:false"> 至
			<input class="easyui-datebox" value="new Date()" name="" id="chufan-table-end" data-options="width:150,required:true,editable:false">
			
			<input class="easyui-searchbox" id="chufanhao-input" style="width:200px;" data-options="prompt:'处方号',
			 		 searcher : function(value , name){
			 			if(value == null){
			 				$('#chufan-table').datagrid('reload','select_all_prescriptions');
			 			}else{
			 				$('#chufan-table').datagrid({url : 'select_where_prescriptionId'});
			 				$('#chufan-table').datagrid('load',{prescriptionId : value});
			 			}
			 		} 
			 		"/>
			
			<a id="chufan-table-search"
			href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true"
			style="width: 60px">搜索</a>
			<a id="chufan-search-all"
			href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:true"
			style="width: 90px">显示所有</a>
			<a id="chufan-queding"
			href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok',plain:true"
			style="width: 60px">确定</a>
		</div>	
	</div>
	<script type="text/javascript">
	$(function() {
		$("#chufan-table-search").linkbutton({onClick :function(){
			var startTime = $("#chufan-table-start").datebox('getValue');
			
			var endTime = $("#chufan-table-end").datebox('getValue');
			var prescriptionId = $("#chufanhao-input").textbox('getValue');
			alert(prescriptionId);
			$("#chufan-table").datagrid({url : 'select_prescription_Date_start_end'});
			$("#chufan-table").datagrid('load' , {startTime : startTime,endTime : endTime,prescriptionId: prescriptionId});
		}});
		$("#chufan-search-all").linkbutton({onClick : function(){
			$('#chufan-table').datagrid('reload','select_all_prescriptions');
		}});
			
	});
	</script>
</body>
</html>