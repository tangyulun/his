<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>住院登记记录</title>
</head>
<body>
	<!-- 查询住院登记记录 -->
	<div class="easyui-layout" data-options="fit:true" id="zhuyuandengjijilu-div">
		<table id="zydj-table"   width="100%" class="easyui-datagrid" data-options="
						fit : true,
						fitColumns:true,
						pagination:true,
						rownumbers:true,
						pageSize:10,
						singleSelect : true,
						url:'select_all_hospitalRegistration',
						method:'get',
						border:false,
						toolbar:'#zhuyuandengji-table',
						pageList:[10,20,30,40]">
				<thead>
					<tr>
						<th data-options="field:'ID',width:20,align:'center',checkbox:true">*</th>
						<th data-options="field:'hospitalRegistrationId',width:100,align:'center'">住院登记号</th>
						<th data-options="field:'hospitalRegistrationState',width:80,align:'center'">状态</th>
						<th data-options="field:'hospitalRegistrationDate',width:120,align:'center',formatter:date">入院日期</th>
						<th data-options="field:'outpaitentRegistId',width:80, formatter(value , row , index){	
									if(row.hospitaNotify != null){
										return row.hospitaNotify.outpaitentRegist.outpaitentRegistId;
									}
									return value;
								}
								">门诊号</th> 
						<th data-options="field:'dclassName',width:80, formatter(value , row , index){
									if(row.hospitaNotify.outpaitentRegist.dclass != null){
										return row.hospitaNotify.outpaitentRegist.dclass.dclassName;
									}
									return value;
								}
								">科室</th>
						
						<th data-options="field:'medicalCardName',width:80, formatter(value , row , index){
									if(row.hospitaNotify.outpaitentRegist.medicalCard != null){
										return row.hospitaNotify.outpaitentRegist.medicalCard.medicalCardName;
									}
									return value;
								}
								">病人姓名</th>
						<th data-options="field:'bedId',width:80, formatter(value , row , index){	
									if(row.bed != null){
										return row.bed.bedId;
									}
									return value;
								}
								">病床号</th> 
						
					</tr>
				</thead>
		</table>
		<div id="zhuyuandengji-table">
			<input class="easyui-datebox" value="new Date()" name="" id="zhuyuandengji-table-start" data-options="width:150,required:true,editable:false"> 至
			<input class="easyui-datebox" value="new Date()" name="" id="zhuyuandengji-table-end" data-options="width:150,required:true,editable:false">
			
			<input class="easyui-searchbox" id="zhuyuandengjihao-input" style="width:200px;" data-options="prompt:'住院登记号',
			 		 searcher : function(value , name){
			 			if(value == null){
			 				$('#zydj-table').datagrid('reload','select_all_hospitalRegistration');
			 			}else{
			 				$('#zydj-table').datagrid({url : 'select_where_hospitalNotifyName'});
			 				$('#zydj-table').datagrid('load',{hospitalNotifyNumber : value});
			 			}
			 		} 
			 		"/>
			
			<a id="zhuyuandengji-table-search"
			href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true"
			style="width: 60px">搜索</a>
			<a id="regist-search-all"
			href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:true"
			style="width: 90px">显示所有</a>
			<a id="zhuyuandengji-queding"
			href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok',plain:true"
			style="width: 60px">确定</a>
		</div>	
	</div>
	<script type="text/javascript">
	$(function() {
		
			$("#zhuyuandengji-table-search").linkbutton({onClick :function(){
				var startTime = $("#zhuyuandengji-table-start").datebox('getValue');
				
				var endTime = $("#zhuyuandengji-table-end").datebox('getValue');
				var hospitalNotifyNumber = $("#zhuyuandengjihao-input").textbox('getValue');
				alert(hospitalNotifyNumber);
				$("#zydj-table").datagrid({url : 'select_hospita_Date_start_end'});
				$("#zydj-table").datagrid('load' , {startTime : startTime,endTime : endTime,hospitalNotifyNumber: hospitalNotifyNumber});
			}});
			
			$("#regist-search-all").linkbutton({onClick : function(){
				$('#zydj-table').datagrid('reload','select_all_hospitalRegistration');
			}});
			
		});
	</script>
</body>
</html>