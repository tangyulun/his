<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<table id="sb1"   width="100%" class="easyui-datagrid sb1" data-options="
						fit : true,
						fitColumns:true,
						pagination:true,
						rownumbers:true,
						pageSize:10,
						singleSelect : true,
						url:'select_instrument_buhegeshuliang',
						method:'get',
						border:false,
						toolbar:'#instrument-tb',
						pageList:[10,20,30,40]">
				<thead>
					<tr>
						<th data-options="field:'instrumentYsId',width:10,align:'center'">验收单号</th>
						<th data-options="field:'instrumentYsDate',width:10,align:'center',formatter:date">收货日期</th>
						<th data-options="field:'instrumentYsPzdh',width:10,align:'center'">凭证单号</th>
						<th data-options="field:'instrumentYsState',width:10,align:'center'">验收状态</th>
					</tr>
				</thead>
		</table>
		<div id="instrument-tb">
			<input class="easyui-datebox" value="new Date()" name="" id="stime" data-options="width:150,required:true,editable:false"> 至
			<input class="easyui-datebox" value="new Date()" name="" id="etime" data-options="width:150,required:true,editable:false">
			<a id="sb1lzx"
			href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true"
			style="width: 60px">搜索</a>
			<input class="easyui-searchbox" id="instrumentYsId" style="width:200px;" data-options="label:'',labelWidth:65,prompt:'退货订单编号',
			 		 searcher : function( value , name){
			 			if(!value){
			 				$('#sb1').datagrid('reload','select_instrument_buhegeshuliang');
			 				return;
			 			}else{
			 				$('#sb1').datagrid({url : 'select_instrumentcaigo_where_ys'});
			 				$('#sb1').datagrid('load',{instrumentYsId : value});
			 			}
			 		} 
			 		"/>
			
			
			<a id="registration-showall"
			href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:true"
			style="width: 90px">显示所有</a>
			<a id="registration-sure"
			href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok',plain:true"
			style="width: 60px">确定</a>
		</div>
		

		
	
<script type="text/javascript">
		$(function(){
			$("#qx7").linkbutton({onClick : function(){
				$("#xzqx3").window("open");
			}});
			$("#A3").linkbutton({onClick : function(){
				$("#qxgl3").window("open");
			}});
			$("#fl3").linkbutton({onClick : function(){
				$("#qxfl3").window("open");
			}});
			$("#xj3").linkbutton({onClick : function(){
				$("#create3").window("open");
			}});
			$("#cgddh").linkbutton({onClick : function(){
				$("#xzqxcg").window("open");
			}});
			
			$.get("cgdanhao", function(date){
				$('#qx_cg').textbox('setValue',date.substring(1,date.length-1));
			});
			$("#sb1lzx").linkbutton({onClick :function(){
				var startTime = $("#stime").datebox('getValue');
				var endTime = $("#etime").datebox('getValue');
				var instrumentCaigouId = $("#instrumentYsId").textbox('getValue');	
				$("#sb1").datagrid({url : 'queryDate_andinstrument_String_ys'});
				$("#sb1").datagrid('load' , {startTime : startTime,endTime : endTime,instrumentYsId: instrumentYsId});
			}});
			

		});
		</script>
</body>
</html>