<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>手术记录汇总</title>
</head>
<body>

	<div data-options="region:'center'" style="height: 45%;">
	
	<table id="Shoushu-tbe"   width="100%" class="easyui-datagrid" data-options="
						fit : true  , 
						fitColumns:true,
						pagination:true  , 
						rownumbers:true,
						pageSize:10  ,  
						singleSelect : true,
						url:'select_mess_shujubiaoge', 
						method:'get',
						border:false  ,  
						toolbar:'#shoushu_tb',
						pageList:[10,20,30,40]">
				<thead>
					<tr>
						<th data-options="field:'shoushuMess',width:15,align:'center'">手术编号</th>
						<th data-options="field:'shoushuId',width:15,align:'center',
							formatter(value , row , index){
									if(row.shoushu != null){
										return row.shoushu.shoushuId;
								}
								return value;
							}">手术项目编号2</th>
							<th data-options="field:'empId',width:15,align:'center',
							formatter(value , row , index){
								
									if(row.emp != null){
										return row.emp.empId;
								}
								return value;
							}">员工编号</th>
							<th data-options="field:'hospitalRegistrationId',width:10,align:'center',
							formatter(value , row , index){
								
									if(row.hospitalRegistration != null){
										return row.hospitalRegistration.hospitalRegistrationId;
								}
								return value;
							}">住院登记号</th>
							<th data-options="field:'shoushuMessState',width:10,align:'center'">状态</th>
							<th data-options="field:'shoushuMessDate',width:10,align:'center',formatter: date">手术日期</th>
							<th data-options="field:'shoushuMessType',width:15,align:'center'">手术类型</th>
							<th data-options="field:'shoushuMessMoney',width:15,align:'center'">金额</th>
					</tr>
				</thead>
		</table>
	
		<div id="shoushu_tb">
			<input class="easyui-searchbox" id="data-shoushuMess" style="width:160px;" data-options="labelWidth:65,prompt:'检验号',
						searcher : function( value , name){
			 			if(!value){
			 				$('#Shoushu-tbe').datagrid('reload','select_mess_shujubiaoge');
			 				return;
			 			}else{
			 				$('#Shoushu-tbe').datagrid({url : 'select_Id_Chaxun'});
			 				$('#Shoushu-tbe').datagrid('load',{shoushuMess : value});
			 			}
			 		} "/>
			<input class="easyui-datebox" value="new Date()" name="" id="aTime" data-options="width:150,required:true,editable:false"> 至
			<input class="easyui-datebox" value="new Date()" name="" id="bTime" data-options="width:150,required:true,editable:false">
			<a id="ShouShusousuossssss"  href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" style="width: 60px">搜索</a>
			<a id="Shoushu-showall"
			href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:true"
			style="width: 90px">显示所有</a>
		</div>
	</div>

	<!-- 第二个记录汇总 -->
	<div  data-options="region:'center'" 
	 style="height:54%;border: 1px solid #66cccc;">
			<table  id="table-shoushu-b" style="width:99%;" class="easyui-datagrid"
						data-options="fit : true,
						border:		false,
						fitColumns:	true,
						striped:	true,
						method	:	'get',
						rownumbers	:	true">
				<thead>
					<tr>
						<th data-options="field:'id',width:3,align:'center'">*</th>
						<th data-options="field:'shoushuMessXqId',width:10,align:'center'">手术编号</th>
						<th data-options="field:'shoushuMessXqName',width:10,align:'center'">手术名称</th>
						<th data-options="field:'shoushuMessXqType',width:10,align:'center'">手术类型</th>
						<th data-options="field:'shoushuMessXqNum',width:10,align:'center'">数量</th>
						<th data-options="field:'shoushuMessXqPrice',width:10,align:'center'">单价</th>
						<th data-options="field:'shoushuMessXqMoney',width:10,align:'center'">金额</th>
						<th data-options="field:'shoushuMessXqResult',width:10,align:'center'">结果</th>
					</tr>
				</thead>					
			</table>
	</div>
	<script type="text/javascript">
	$(function(){
	//显示所有
	 $("#Shoushu-showall").linkbutton({onClick:function(){
			$("#aTime").datebox('setValue',new Date()+"");
			$("#bTime").datebox('setValue',new Date()+"");
			$("#shoushuMess").searchbox('setValue','');
			$('#Shoushu-tbe').datagrid('reload','select_mess_shujubiaoge');
		}});
		
		//上表格点下表格，根据Id点
		$("#Shoushu-tbe").datagrid({onClickRow : function(){
			
			var rows = $("#Shoushu-tbe").datagrid("getSelected");
			$("#table-shoushu-b").datagrid({url : 'select_shoushu_xq'});
			$("#table-shoushu-b").datagrid('load' , {shoushuMess : rows.shoushuMess});
			qingkong()
		}});
		
	//时间查询
		$("#ShouShusousuossssss").linkbutton({onClick :function(){
			var aTime = $("#aTime").datebox('getValue');
			var bTime = $("#bTime").datebox('getValue');
			var shoushuMess = $("#data-shoushuMess").textbox('getValue');
			$("#Shoushu-tbe").datagrid({url : 'select_Time_chaxun'});
			$("#Shoushu-tbe").datagrid('load' , {aTime : aTime,bTime : bTime,shoushuMess: shoushuMess});
			qingkong()
		}});
	});
	//清空
 	function qingkong(){
		var rows = $("#table-shoushu-b").datagrid('getRows');
		for(var i=rows.length -1; i>=0;i--){
			$("#table-shoushu-b").datagrid('deleteRow',i);
		}
	}
	</script>
</body>
</html>