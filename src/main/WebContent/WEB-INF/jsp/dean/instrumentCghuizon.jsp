<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>器械采购汇总表</title>
</head>
<body>
<div id="qxcghz" class="easyui-layout" title="器械采购汇总表" data-options="iconCls:'icon-save',modal:true,fit:true">

<div style="height:270px; margin-top: 5px">

<table id="instrument_cg_hz" height="200" class="easyui-datagrid instrument_cg_hz" data-options="
						fit : true,
						fitColumns:true,
						pagination:true,
						rownumbers:true,
						pageSize:10,
						singleSelect : true,
						url:'select_instrumentscaig_types_huizon',
						method:'get',
						border:false,
						toolbar:'#instrument-tb',
						pageList:[10,20,30,40]">
				<thead>
					<tr>
						<th data-options="field:'instrumentCaigouId',width:14">器械采购订单号</th>
						<th data-options="field:'instrumentCaigouDhDate',width:14,formatter : date">订货日期</th>
						<th
								data-options="field:'supplierName',width:14, formatter(value , row , index){
									if(row.supplier != null){
										return row.supplier.suplierName;
									}
									return value;
								}
								">供应商</th>
						<th data-options="field:'instrumentCaigouGhDate',width:14,formatter : date">供货日期</th>
						<th data-options="field:'instrumentCaigouMoney',width:14">订货金额</th>
						<th data-options="field:'instrumentCaigouState',width:14">状态</th>
						<th data-options="field:'instrumentCaigouAddress',width:14">交货地点</th>
					</tr>
				</thead>
		</table>
		</div>
 <table id="instrument_cgxq_hz"  class="easyui-datagrid instrument_cgxq_hz" data-options="
						fit : true,
						fitColumns:true,
						pagination:true,
						rownumbers:true,
						pageSize:10,
						singleSelect : true,
						url:'',
						method:'get',
						border:false,
						toolbar:'#instrument-tb-xq',
						pageList:[10,20,30,40]">
				<thead>
					<tr>
						<th data-options="field:'instrumentCaigouXqId',width:14">器械采购详情编号</th>
						<th data-options="field:'instrumentId',width:14, formatter(value , row , index){
									if(row.instrument != null){
										return row.instrument.instrumentId;
									}
									return value;
								}">器械编号</th>
						<th data-options="field:'instrumentCaigouXqPrice',width:14">器械单价</th>
						<th data-options="field:'instrumentCaigouXqNum',width:14">采购数量</th>
						<th data-options="field:'instrumentCaigouXqRemark',width:14">备注</th>
						<th data-options="field:'instrumentCaigouXqMoney',width:14">金额</th>
					</tr>
				</thead>
		</table> 
		<div id="instrument-tb">
			
			
			<input class="easyui-searchbox" id="instrumentCaigouId" 
					 data-options="label : '器械采购单号/供应商' , labelAlign : 'right' , labelWidth :100, width:230,
			 		 searcher : function( value , name){
			 			if(!value){
			 				$('#instrument_cg_hz').datagrid('reload','select_instrumentscaig_types_huizon');
			 				return;
			 			}else{
			 				$('#instrument_cg_hz').datagrid({url : 'select_instrumentcaigo_where_huizong'});
			 				$('#instrument_cg_hz').datagrid('load',{instrumentCaigouId : value});
			 			}
			 		} 
			 		"/>
			
			<input class="easyui-datebox" value="new Date()" name="" id="stime" data-options="width:150,required:true,editable:false"> 至
			
			<input class="easyui-datebox" value="new Date()" name="" id="etime" data-options="width:150,required:true,editable:false">
			<a>
				<select class="easyui-combobox" id="start_instrument" name="" 
					data-options="required:true,editable:false,label:'状态',width:180,labelAlign:'right'" >   
				   <option value="未处理">全部</option>   
				    <option value="未处理">未处理</option>   
				    <option value="已处理">已处理</option>  
				     <option value="未验收">未验收</option>   
				    <option value="已验收">已验收</option>  
				     <option value="已入库">已入库</option>   
				    <option value="已退货">已退货</option>   
				    <option value="已出库">已出库</option>   
				    <option value="已盘点">已盘点</option>   
				</select> 
			</a>
			<a id="dateshosuo"href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true"style="width: 60px">搜索</a>
			<a id="registration-show_huizon"
			href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:true"
			style="width: 90px">显示所有</a>
			
			
		</div>
		</div>
		
		
	<script type="text/javascript">
		$(function(){
			$("#instrument_cg_hz").datagrid({onClickRow : function(){
				var rows = $("#instrument_cg_hz").datagrid("getSelected");
				$("#instrument_cgxq_hz").datagrid({url : 'select_instrumentscaigxq_types_huizon'});
				$("#instrument_cgxq_hz").datagrid('load' , {instrumentCaigouId : rows.instrumentCaigouId});
				
			}});
			
			
			$("#registration-show_huizon").linkbutton({onClick : function(){
				$('#instrument_cg_hz').datagrid({url : 'select_instrumentscaig_types_huizon'});
				$('#instrument_cgxq_hz').datagrid('reload');
			}});
			
			
			$("#dateshosuo").linkbutton({onClick :function(){
				var startTime = $("#stime").datebox('getValue');
				var endTime = $("#etime").datebox('getValue');
				var instrumentCaigouState = $("#start_instrument").combobox("getValue");
				var instrumentCaigouId = $("#instrumentCaigouId").textbox('getValue');
				$("#instrument_cg_hz").datagrid({url : 'to_gaoji_find_instrument'});
				$("#instrument_cg_hz").datagrid('load' , {startTime : startTime,endTime : endTime,instrumentCaigouId: instrumentCaigouId});
			}});
			
		
		});
	</script>
</body>
</html>