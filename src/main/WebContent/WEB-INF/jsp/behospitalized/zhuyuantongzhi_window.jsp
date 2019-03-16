<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>住院通知记录</title>
</head>
<body>
	<!-- 查询住院通知记录 -->
	<div class="easyui-layout" data-options="fit:true" id="zhuyuantongzhijilu-div">
		<table id="zytz-table"   width="100%" class="easyui-datagrid" data-options="
						fit : true,
						fitColumns:true,
						pagination:true,
						rownumbers:true,
						pageSize:10,
						singleSelect : true,
						url:'select_all_hospitalNotify',
						method:'get',
						border:false,
						toolbar:'#zhuyuantongzhi-table',
						pageList:[10,20,30,40]">
				<thead>
					<tr>
						<th data-options="field:'hospitalNotifyNumber',width:100,align:'center'">住院通知号</th>
						<th data-options="field:'hospitalNotifyState',width:80,align:'center'">状态</th>
						<th data-options="field:'hospitalNotifyDate',width:120,align:'center',formatter:date">通知日期</th>
						<th data-options="field:'outpaitentRegistId',width:80, formatter(value , row , index){	
								<!-- alert(JSON.stringify(row)); -->
									if(row.outpaitentRegist != null){
										return row.outpaitentRegist.outpaitentRegistId;
									}
									return value;
								}
								">门诊号</th>
						<th data-options="field:'dclassName',width:80, formatter(value , row , index){
									if(row.outpaitentRegist.dclass != null){
										return row.outpaitentRegist.dclass.dclassName;
									}
									return value;
								}
								">科室</th>
						
						<th data-options="field:'medicalCardName',width:80, formatter(value , row , index){
									if(row.outpaitentRegist.medicalCard != null){
										return row.outpaitentRegist.medicalCard.medicalCardName;
									}
									return value;
								}
								">病人姓名</th>
						
						<th data-options="field:'hospitalNotifyCost',width:80,align:'center'">预计住院费用</th>
						<th data-options="field:'hospitalNotifyCashYanjin',width:80,align:'center'">最低押金</th>
						<th data-options="field:'hospitalNotifyAlertTheJine',width:80,align:'center'">押金警戒金额</th>
						<th data-options="field:'hospitalNotifyExplain',width:80,align:'center'">通知说明</th>
						
					</tr>
				</thead>
		</table>
		<div id="zhuyuantongzhi-table">
			<input class="easyui-datebox" value="new Date()" name="" id="zhuyuantongzhi-table-start" data-options="width:150,required:true,editable:false"> 至
			<input class="easyui-datebox" value="new Date()" name="" id="zhuyuantongzhi-table-end" data-options="width:150,required:true,editable:false">
			
			<input class="easyui-searchbox" id="zhuyuantongzhihao-input" style="width:200px;" data-options="prompt:'住院通知号',
			 		 searcher : function(value , name){
			 			if(value == null){
			 				$('#zytz-table').datagrid('reload','select_all_hospitalNotify');
			 			}else{
			 				$('#zytz-table').datagrid({url : 'select_where_hospitalNotifyName'});
			 				$('#zytz-table').datagrid('load',{hospitalNotifyNumber : value});
			 			}
			 		} 
			 		"/>
			
			<a id="zhuyuantongzhi-table-search"
			href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true"
			style="width: 60px">搜索</a>
			<a id="regist-search-all"
			href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:true"
			style="width: 90px">显示所有</a>
			<a id="zhuyuantongzhi-queding"
			href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok',plain:true"
			style="width: 60px">确定</a>
		</div>	
	</div>
	<script type="text/javascript">
	$(function() {
		
			$("#zhuyuantongzhi-table-search").linkbutton({onClick :function(){
				var startTime = $("#zhuyuantongzhi-table-start").datebox('getValue');
				
				var endTime = $("#zhuyuantongzhi-table-end").datebox('getValue');
				var hospitalNotifyNumber = $("#zhuyuantongzhihao-input").textbox('getValue');
				alert(hospitalNotifyNumber);
				$("#zytz-table").datagrid({url : 'select_hospita_Date_start_end'});
				$("#zytz-table").datagrid('load' , {startTime : startTime,endTime : endTime,hospitalNotifyNumber: hospitalNotifyNumber});
			}});
			
			$("#regist-search-all").linkbutton({onClick : function(){
				$('#zytz-table').datagrid('reload','select_all_hospitalNotify');
			}});
			
		});
	</script>
</body>
</html>