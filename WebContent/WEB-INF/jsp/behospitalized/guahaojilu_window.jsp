<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>挂号记录</title>
</head>
<body>
	<!-- 查询挂号记录 -->
	<div class="easyui-layout" data-options="fit:true" id="guaihaojilu-div">
		<table id="clinic-table"   width="100%" class="easyui-datagrid" data-options="
						fit : true,
						fitColumns:true,
						pagination:true,
						rownumbers:true,
						pageSize:10,
						singleSelect : true,
						url:'select_all_regist',
						method:'get',
						border:false,
						toolbar:'#regist-table',
						pageList:[10,20,30,40]">
				<thead>
					<tr>
						<th data-options="field:'empId',width:20,align:'center',checkbox:true"></th>
						<th data-options="field:'outpaitentRegistId',width:100,align:'center'">门诊号</th>
						<th data-options="field:'code',width:80, formatter(value , row , index){
									if(row.dclass != null){
										return row.dclass.dclassName;
									}
									return value;
								}
								">科室</th>
						<!-- <th data-options="field:'name',width:80,align:'center'">病人姓名</th> -->
						<th data-options="field:'name',width:80, formatter(value , row , index){
									if(row.medicalCard != null){
										return row.medicalCard.medicalCardName;
									}
									return value;
								}
								">病人姓名</th>
						<th data-options="field:'outpaitentRegistType',width:80,align:'center'">挂号类型</th>
						<!-- <th data-options="field:'jingbanren',width:120,align:'center'">经办人</th> -->
						<th data-options="field:'jingbanren',width:120, formatter(value , row , index){
									if(row.emp != null){
										return row.emp.empName;
									}
									return value;
								}
								">经办人</th>
						<th data-options="field:'outpaitentRegistGuahaodate',width:120,align:'center',formatter:date">挂号日期</th>
					</tr>
				</thead>
		</table>
		<div id="regist-table">
			<input class="easyui-datebox" value="new Date()" name="" id="regist-table-start" data-options="width:150,required:true,editable:false"> 至
			<input class="easyui-datebox" value="new Date()" name="" id="regist-table-end" data-options="width:150,required:true,editable:false">
			
			<input class="easyui-searchbox" id="menzhenhao-input" style="width:200px;" data-options="prompt:'门诊号',
			 		 searcher : function(value , name){
			 			if(value == null){
			 				$('#clinic-table').datagrid('reload','select_all_regist');
			 			}else{
			 				$('#clinic-table').datagrid({url : 'select_type_regist'});
			 				$('#clinic-table').datagrid('load',{outpaitentRegistId : value});
			 			}
			 		} 
			 		"/>
			
			<a id="regist-table-search"
			href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true"
			style="width: 60px">搜索</a>
			<a id="regist-search-all"
			href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:true"
			style="width: 90px">显示所有</a>
			<a id="regist-queding"
			href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok',plain:true"
			style="width: 60px">确定</a>
		</div>	
	</div>
	<script type="text/javascript">
	$(function() {
		
			$("#regist-table-search").linkbutton({onClick :function(){
				var startTime = $("#regist-table-start").datebox('getValue');
				
				var endTime = $("#regist-table-end").datebox('getValue');
				var outpaitentRegistId = $("#menzhenhao-input").textbox('getValue');
				alert(outpaitentRegistId);
				$("#clinic-table").datagrid({url : 'selectDate_start_end'});
				$("#clinic-table").datagrid('load' , {startTime : startTime,endTime : endTime,outpaitentRegistId: outpaitentRegistId});
			}});
			
			$("#regist-search-all").linkbutton({onClick : function(){
				$('#clinic-table').datagrid('reload','select_all_regist');
			}});
			
		});
	</script>
</body>
</html>