<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>器械领用汇总表</title>
</head>
<body>
	<div id="qx_ly_hz" class="easyui-layout" title="器械领用汇总表" data-options="iconCls:'icon-save',modal:true,fit:true">
		<div id="instrument-tbtwo_ly">
				
			
				<input class="easyui-searchbox" id="qxUseId" 
					 data-options="label : '器械采购单号/供应商' , labelAlign : 'right' , labelWidth :100, width:230,
				 searcher : function( value , name){
				 			if(!value){
				 				$('#instrument_ly_hz').datagrid('reload','select_instrumentsly_types_huizon');
				 				return;
				 			}else{
				 				$('#instrument_ly_hz').datagrid({url : 'select_instrumently_where_huizong'});
				 				$('#instrument_ly_hz').datagrid('load',{qxUseqxId : value});
				 			}
				 		}
				 		"/>
				<input class="easyui-datebox" value="new Date()"  id="stime1" data-options="width:150,required:true,editable:false"> 至
				<input class="easyui-datebox" value="new Date()" id="etime1" data-options="width:150,required:true,editable:false">
				<a>
				
					<select class="easyui-combobox" id="start_instrument_ly" name="" 
						data-options="required:true,editable:false,label:'状态',width:180,labelAlign:'right'" >   
					    <option value="未处理">未处理</option>   
					    <option value="已处理">已处理</option>   
					</select> 
				</a>
					<a id="dateoneshosuo_ly"href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true"style="width: 60px">搜索</a>
				<a id="registration-show_huizon_ly"
				href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:true"
				style="width: 90px">显示所有</a>
				
				
			</div>
			<div  data-options="region : 'north'"  style="height : 45%">
			<table id="instrument_ly_hz" class="easyui-datagrid instrument_ly_hz" data-options="
						fit : true,
						fitColumns:true,
						pagination:true,
						rownumbers:true,
						pageSize:10,
						singleSelect : true,
						url:'select_instrumentsly_types_huizon',
						method:'get',
						border:false,
						toolbar:'#instrument-tbtwo_ly',
						pageList:[10,20,30,40]">
					<thead>
						<tr>
							<th data-options="field:'qxUseId',width:14">器械领用单号</th>
							<th data-options="field:'qxUseDate',width:14">领用日期</th>
							<th data-options="field:'qxUseWarehouse',width:14">领用仓库</th>
							<th data-options="field:'qxUseKeshi',width:14">领用类型</th>
							<th data-options="field:'qxUseState',width:14">状态</th>
							<th data-options="field:'qxUseDuix',width:14">领用对象</th>
						</tr>
					</thead>
			</table>
		</div>
		<div data-options="region : 'south',split : true" style="height:55%">
	 		 <table id="instrument_lyxq_hz" class="easyui-datagrid instrument_lyxq_hz" data-options="
							fit : true,
							fitColumns:true,
							pagination:true,
							rownumbers:true,
							pageSize:10,
							singleSelect : true,
							url:'',
							method:'get',
							border:false,
							pageList:[10,20,30,40]">
					<thead>
						<tr>
							<th data-options="field:'qxUseqxId',width:14">器械领用详情编号</th>
							<th data-options="field:'instrumentId',width:14, formatter(value , row , index){
										if(row.instrument != null){
											return row.instrument.instrumentId;
										}
										return value;
									}">器械编号</th>
							<th data-options="field:'qxUseqxLyshul',width:14">领用数量</th>
							<th data-options="field:'qxUseqxJcshul',width:14">结存数量</th>
							<th data-options="field:'qxUseqxBeizu',width:14">备注</th>
						</tr>
					</thead>
			</table> 
		</div>		
	</div>
	<script type="text/javascript">
		$(function(){
			//点击订单查详单
			$("#instrument_ly_hz").datagrid({onClickRow : function(){
				var rows = $("#instrument_ly_hz").datagrid("getSelected");
				$("#instrument_lyxq_hz").datagrid({url : 'select_instrumentslyxq_types_huizon'});
				$("#instrument_lyxq_hz").datagrid('load' , {qxUseId : rows.qxUseId});	
			}});
			
			
			$("#registration-show_huizon_ly").linkbutton({onClick : function(){
				$('#instrument_ly_hz').datagrid({url : 'select_instrumentsly_types_huizon'});
				$('#instrument_lyxq_hz').datagrid('reload');
			}});
			
			
		 	$("#dateoneshosuo_ly").linkbutton({onClick :function(){
				var startTime = $("#stime1").datebox('getValue');
				var endTime = $("#etime1").datebox('getValue');
				var qxUseState = $("#start_instrument_ly").combobox("getValue");
				var qxUseId = $("#qxUseId").textbox('getValue');	
				$("#instrument_ly_hz").datagrid({url : 'to_gaoji_find_instrument_ly'});
				$("#instrument_ly_hz").datagrid('load' , {startTime : startTime,endTime : endTime,qxUseId: qxUseId});
			}});

		});
	</script>
</body>
</html>