<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>押金催费记录</title>
</head>
<body>
	<!-- 查询押金催费记录 -->
	<div class="easyui-layout" data-options="fit:true" id="yajincuifeijilu-div">
		<table id="yjcf-table"   width="100%" class="easyui-datagrid" data-options="
						fit : true,
						fitColumns:true,
						pagination:true,
						rownumbers:true,
						pageSize:10,
						singleSelect : true,
						url:'select_all_RushFee',
						method:'get',
						border:false,
						toolbar:'#yajincuifei-table',
						pageList:[10,20,30,40]">
				<thead>
					<tr>
						<th data-options="field:'ID',width:20,align:'center',checkbox:true">*</th>
						<th data-options="field:'rushFeeId',width:100,align:'center'">押金催费号</th>
						<th data-options="field:'rushFeeState',width:80,align:'center'">状态</th>
						<th data-options="field:'rushFeeDate',width:120,align:'center',formatter:date">入院日期</th>
						<!-- <th data-options="field:'hospitalRegistrationId',width:80, formatter(value , row , index){	
									if(row.hospitaNotify != null){
										return row.hospitaNotify.outpaitentRegist.outpaitentRegistId;
									}
									return value;
								}
								">住院号</th> 
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
								">病人姓名</th>  -->
						<th data-options="field:'rushFeeWorthOfValue',width:80">催缴金额</th>
						
					</tr>
				</thead>
		</table>
		<div id="yajincuifei-table">
			<input class="easyui-datebox" value="new Date()" name="" id="yajincuifei-table-start" data-options="width:150,required:true,editable:false"> 至
			<input class="easyui-datebox" value="new Date()" name="" id="yajincuifei-table-end" data-options="width:150,required:true,editable:false">
			
			<input class="easyui-searchbox" id="yajincuifeihao-input" style="width:200px;" data-options="prompt:'住院登记号',
			 		 searcher : function(value , name){
			 			if(value == null){
			 				$('#yjcf-table').datagrid('reload','select_all_RushFee');
			 			}else{
			 				$('#yjcf-table').datagrid({url : 'select_where_hospitalNotifyName'});
			 				$('#yjcf-table').datagrid('load',{hospitalNotifyNumber : value});
			 			}
			 		} 
			 		"/>
			
			<a id="yajincuifei-table-search"
			href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true"
			style="width: 60px">搜索</a>
			<a id="regist-search-all"
			href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:true"
			style="width: 90px">显示所有</a>
			<a id="yajincuifei-queding"
			href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok',plain:true"
			style="width: 60px">确定</a>
		</div>	
	</div>
	<script type="text/javascript">
	$(function() {
		
			/* $("#yajincuifei-table-search").linkbutton({onClick :function(){
				var startTime = $("#yajincuifei-table-start").datebox('getValue');
				
				var endTime = $("#yajincuifei-table-end").datebox('getValue');
				var hospitalNotifyNumber = $("#yajincuifeihao-input").textbox('getValue');
				alert(hospitalNotifyNumber);
				$("#yjcf-table").datagrid({url : 'select_hospita_Date_start_end'});
				$("#yjcf-table").datagrid('load' , {startTime : startTime,endTime : endTime,hospitalNotifyNumber: hospitalNotifyNumber});
			}}); */
			
			$("#regist-search-all").linkbutton({onClick : function(){
				$('#yjcf-table').datagrid('reload','select_all_RushFee');
			}});
			
		});
	</script>
</body>
</html>