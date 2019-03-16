<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>选择挂号</title>
</head>
<body>
<script type="text/javascript">
	$(function(){
		$("#data-refresh-button").linkbutton({onClick : function(){
			$(".select_datagrid").datagrid('reload','select_outRegist_all');
		}});
		
		$('#data-seacher-linkbutton').linkbutton({onClick : function(){
			var registdataStartTime = $('#regist_startTime').datebox('getValue');
			var registdataEndTime = $('#regist_endTime').datebox('getValue');
			var registdataSearcher = $('#registdata-searcher').searchbox('getValue');
			$('#select_datagrid').datagrid({url : 'query_gaojiregistration'});
			$('#select_datagrid').datagrid('load',{registdataStartTime : registdataStartTime,
				registdataEndTime : registdataEndTime,registdataSearcher  : registdataSearcher});
		}});
		
	});
</script>
<div class="easyui-layout" data-options="fit:true,">
		<div id="regist-tb" >		
			<input id="registdata-searcher" class="easyui-searchbox" style="width:200px;"
				 data-options="label:'门诊号',labelWidth:50,prompt:'门诊号',searcher : function(value , name){
				 			if(value==null){
				 				$('.select_datagrid').datagrid('reload','select_outRegist_all');
				 			}else{
				 				$('.select_datagrid').datagrid({url : 'query_registdata_like'});
				 				$('.select_datagrid').datagrid('load',{outpaitentRegistId : value});
				 			}
				 		} " />
			<input name="" class="easyui-datebox" value="new Date()" id="regist_startTime"
					data-options="label:'查询区间',width:220,labelAlign:'right'">
		   至 <input name="" class="easyui-datebox" value="new Date()" id="regist_endTime" data-options="width:130">
			<a id="data-seacher-linkbutton"
				href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true"
				style="width: 70px">搜索</a>
			<a id="data-refresh-button"
				href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-reload'"
				style="width: 90px">显示所有</a>
			<a id="save-linkbutton"
				href="#" class="easyui-linkbutton save-linkbutton" data-options="iconCls:'icon-ok',plain:true"
				style="width: 70px">确定</a>
		</div>
		
		<div data-options="region:'center' , border:false"
			style="height: 450px;padding: 5px" >
				<table id="select_datagrid" class="easyui-datagrid  select_datagrid" data-options="
									fit : true,
									fitColumns:true,
									pagination:true,
									rownumbers:true,
									pageSize:10,
									method:'get',
									singleSelect:true,
									toolbar:'#regist-tb',
									url:'select_outRegist_all',
									pageList:[10,20,30,40]">
						<thead>
							<tr>
								<th data-options="field:'code',width:100,align:'left',checkbox:true">*</th>
								<th data-options="field:'treeField',width:200,align:'left'">门诊记录号</th>
								<th data-options="field:'code1',width:100,align:'left',
									formatter(value , row , index){
										if(row.dclass != null){
											return row.dclass.dclassName;
										}
										return value;
									}
									">科室</th>
								<th data-options="field:'code2',width:100,align:'left',
									formatter(value , row , index){
										if(row.medical != null){
											return row.medical.medicalCardName;
										}
										return value;
									}">病人姓名</th>
								<th data-options="field:'outpaitentRegistType',width:100,align:'left'">挂号类型</th>
								<th data-options="field:'code3',width:100,align:'left',
									formatter(value , row , index){
									if(row.emp != null){
											return row.emp.empLoginName;
										}
										return value;
								
								}">创建人</th>
								<th data-options="field:'outpaitentRegistGuahaoTime',width:200,align:'left'">挂号日期</th>
								<th data-options="field:'outpaitentRegistZhuangtai',width:100,align:'left'">状态</th>
							</tr>
					</thead>
				</table>
			</div>
		</div>
</body>
</html>