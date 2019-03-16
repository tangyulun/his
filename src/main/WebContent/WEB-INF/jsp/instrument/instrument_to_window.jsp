.<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

		<table id="sb"   width="100%" class="easyui-datagrid sb" data-options="
						fit : true,
						fitColumns:true,
						pagination:true,
						rownumbers:true,
						pageSize:10,
						singleSelect : true,
						url:'select_instrumentscaig_types',
						method:'get',
						border:false,
						toolbar:'#instrument-tb',
						pageList:[10,20,30,40]">
				<thead>
					<tr>
						<th data-options="field:'instrumentCaigouId',width:160,align:'center'">采购订单编号</th>
						<th
								data-options="field:'supplierName',width:130, formatter(value , row , index){
									if(row.supplier != null){
										return row.supplier.suplierName;
									}
									return value;
								}
								">供应商</th>
						<th data-options="field:'instrumentCaigouDhDate',width:130,align:'center',formatter:date">订货日期</th>
						<th data-options="field:'instrumentCaigouGhDate',width:150,align:'center',formatter:date">供货日期</th>
						<th data-options="field:'instrumentCaigouMoney',width:150,align:'center'">订货金额</th>
						<th data-options="field:'instrumentCaigouAddress',width:150,align:'center'">交货地点</th>
						<th data-options="field:'instrumentCaigouState',width:200,align:'center'">状态</th>
					</tr>
				</thead>
		</table>
		<div id="instrument-tb">
			<input class="easyui-datebox" value="new Date()" name="" id="stime" data-options="width:150,required:true,editable:false"> 至
			<input class="easyui-datebox" value="new Date()" name="" id="etime" data-options="width:150,required:true,editable:false">
			<a id="sblzx"
			href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true"
			style="width: 60px">搜索</a>
			<input class="easyui-searchbox" id="instrumentCaigouId" style="width:200px;" data-options="label:'',labelWidth:65,prompt:'采购订单编号',
			 		 searcher : function( value , name){
			 			if(!value){
			 				$('#sb').datagrid('reload','select_instrumentscaig_types');
			 				return;
			 			}else{
			 				$('#sb').datagrid({url : 'select_instrumentcaigo_where'});
			 				$('#sb').datagrid('load',{instrumentCaigouId : value});
			 			}
			 		} 
			 		"/>
			
			<a id="show_all_qixiess_cg" href="#" class="easyui-linkbutton"data-options="iconCls:'icon-reload',plain:true" style="width: 80px">显示所有</a> 
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
			
			$("#show_all_qixiess_cg").linkbutton({onClick : function(){
				$("#instrumentCaigouId").textbox('setValue' , '');
				$('#sb').datagrid('reload' , 'select_instrumentscaig_types');
			}});
			$.get("cgdanhao", function(date){
				$('#qx_cg').textbox('setText',date.substring(1,date.length-1));
			});
			$("#sblzx").linkbutton({onClick :function(){
				var startTime = $("#stime").datebox('getValue');
				var endTime = $("#etime").datebox('getValue');
				var instrumentCaigouId = $("#instrumentCaigouId").textbox('getValue');	
				$("#sb").datagrid({url : 'queryDate_andinstrument_String'});
				$("#sb").datagrid('load' , {startTime : startTime,endTime : endTime,instrumentCaigouId: instrumentCaigouId});
			}});
			

		});
</script>
</body>
</html>