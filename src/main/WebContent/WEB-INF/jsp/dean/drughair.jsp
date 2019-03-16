<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>药房发药记录汇总</title> 
</head>
<body>
	<div class="easyui-layout" title="药房发药记录汇总" data-options="fit : true , border:false">
		<div data-options="region : 'north' , border:false" style="height : 45%">
			<table data-options="fit : true,
					rownumbers:true,
					singleSelect : true,
					fitColumns: true,
					toolbar : '#fayao_jilu_table_gaoji',
					method : 'get',
					url : 'to_select_all_fayao'" class="easyui-datagrid" id="fayao_jilu_table">
				<thead>
					<tr>
						<th data-options="field:'drugYaofangIId',width:100,align:'center'">发药编号</th>
						<th data-options="field:'drugYaofangDate',width:100,align:'center' , formatter : date">发药日期</th>
						<th data-options="field:'zhuyuanFayaoType',width:100,align:'center'">发药类型</th>
						<th data-options="field:'prescription',width:100,align:'center',
							formatter(value , row ,index){
									return row.prescription == null ? null : row.prescription.prescriptionId;
							}">处方号</th>
						<th data-options="field:'outpatien',width:100,align:'center',
							formatter(value , row ,index){
									return row.outpatien == null ? null : row.outpatien.outpaitentRegistId;
							}">住院号/门诊号</th>
						<th data-options="field:'emp',width:100,align:'center',
							formatter(value , row ,index){
									return row.emp == null ? null : row.emp.empLoginName;
							}">操作员</th>
						<th data-options="field:'zhuyuanFayaoZmoney',width:100,align:'center'">总金额</th>
						<th data-options="field:'drugYaofangState',width:100,align:'center'">状态</th>
					</tr>
				</thead>
			</table>
		</div>
		<div data-options="region : 'south' , border:false" style="height : 55%">
			<table data-options="fit : true,
					rownumbers : true,
					singleSelect : true,
					fitColumns : true,
					method : 'get'" class="easyui-datagrid" id="fayao_xq_jilu_table">
				<thead>
					<tr>
						<th data-options="field : 'drugId' , width : 100 , align : 'center',
							formatter(value , row ,index){
									return row.drug == null ? null : row.drug.drugId;
							}">药品编号</th>
						<th data-options="field : 'drugName' , width : 100 , align : 'center',
							formatter(value , row ,index){
									return row.drug == null ? null : row.drug.drugName;
							}">药品名称</th>
						<th data-options="field : 'drugYaofangXqNumber' , width : 100 , align : 'center'">数量</th>
						<th data-options="field : 'drugYaofangXqPrice' , width : 100 , align : 'center'">单价</th>
						<th data-options="field : 'drugYaofangXqMoney' , width : 100 , align : 'center'">金额</th>
						<th data-options="field : 'drugHair' , width : 100 , align : 'center',
							formatter(value , row ,index){
									return row.drugHair == null ? null : row.drugHair.drugYaofangIId;
							}">发药编号</th>
						<th data-options="field : 'drugYaofangXqRemark' , width : 100 , align : 'center'">备注</th>
						<th data-options="field : 'drugYaofangXqState' , width : 100 , align : 'center'">状态</th>
					</tr>
				</thead>
			</table>
		</div>
		<div id="fayao_jilu_table_gaoji">
			<a style="margin-left: 20px">
					<input class="easyui-searchbox" id="fayao_jilu_table_gaoji_id" 
					 data-options="label : '发药编号' , labelAlign : 'right' , labelWidth :100, width:230,
					 searcher : function(value,name){
						 var rows = $('#fayao_xq_jilu_table').datagrid('getRows');
						for (var i = rows.length-1; i >=0; i--){
							$('#fayao_xq_jilu_table').datagrid('deleteRow' , i);
						}
						if(!value){
							$('#fayao_jilu_table').datagrid('reload','to_select_all_fayao');
							return;
						}
						$('#fayao_jilu_table').datagrid({url : 'to_select_fayao_By_Id'});
						$('#fayao_jilu_table').datagrid('load', {drugYaofangId : value});
					}">
				</a>
				<a>
					<select class="easyui-combobox" id="fayao_jilu_table_gaoji_type" name="" 
						data-options="required:true,editable:false,label:'类型',width:180,labelAlign:'right'" >   
					    <option value="全部">全部</option>   
					    <option value="门诊发药">门诊发药</option>   
					    <option value="住院发药">住院发药</option>   
					</select> 
				</a>
				<a class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" id="gaoji_find_fayao_sousuo" style="width:80px; margin-left :　25px">搜索</a>
			<a class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:true" id="gaoji_find_sousuo_all_fayao" style="width:80px;">显示所有</a>
		</div>
	</div>
	
	<script type="text/javascript">
		$("#fayao_jilu_table").datagrid({onClickRow : function(){
			var rows = $("#fayao_jilu_table").datagrid("getSelected");
			$("#fayao_xq_jilu_table").datagrid({url : 'to_select_all_by_id'});
			$("#fayao_xq_jilu_table").datagrid('load' , {drugYaofangId : rows.drugYaofangIId , zhuyuanFayaoType : rows.zhuyuanFayaoType});
		}});
		
		$("#gaoji_find_fayao_sousuo").linkbutton({onClick : function(){
			var drugYaofangId = $("#fayao_jilu_table_gaoji_id").textbox("getValue");
			var zhuyuanFayaoType = $("#fayao_jilu_table_gaoji_type").combobox("getValue");
			var rows = $("#fayao_xq_jilu_table").datagrid("getRows");
			for (var i = rows.length-1; i >=0; i--){
				$("#fayao_xq_jilu_table").datagrid("deleteRow" , i);
			}
			$("#fayao_jilu_table").datagrid({url : 'to_gaoji_find_all_by_idAndType'});
			$("#fayao_jilu_table").datagrid('load' , {drugYaofangId : drugYaofangId , zhuyuanFayaoType : zhuyuanFayaoType});
		}});
		
		$("#gaoji_find_sousuo_all_fayao").linkbutton({onClick : function(){
			var rows = $("#fayao_xq_jilu_table").datagrid("getRows");
			for (var i = rows.length-1; i >=0; i--){
				$("#fayao_xq_jilu_table").datagrid("deleteRow" , i);
			}
			$('#fayao_jilu_table').datagrid('reload','to_select_all_fayao');
		}});
		
	</script>
</body>
</html>