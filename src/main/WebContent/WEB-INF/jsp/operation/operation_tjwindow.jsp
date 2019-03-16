<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 打开页面--时间查询 -->
	        
<table id="JianyanMess-tbe"   width="100%" class="easyui-datagrid" data-options="
						fit : true  , 
						fitColumns:true,
						pagination:true  , 
						rownumbers:true,
						pageSize:10  ,  
						singleSelect : true,
						url:'select_JianyanMess_biaoge', 
						method:'get',
						border:false  ,  
						toolbar:'#JianyanMess-tb',
						pageList:[10,20,30,40]">
				<thead>
					<tr>
						<th data-options="field:'jianyanMessId',width:15,align:'left'">检验号</th>
							<th data-options="field:'jianyanMessState',width:15,align:'left'">状态</th>
							<th data-options="field:'jianyanMessDate',width:10,align:'left'">检验日期</th>
							<th data-options="field:'jianyanTypeName',width:10,align:'left'">门诊号</th>
							<th data-options="field:'Selectprice4',width:10,align:'left'">住院号</th>
							<th data-options="field:'Selectprice5',width:10,align:'left'">病人姓名</th>
							<th data-options="field:'jianyanMessDclass',width:15,align:'left'">检验室</th>
					</tr>
				</thead>
		</table>
		<div id="JianyanMess-tb">
			<input class="easyui-datebox" value="new Date()" name="" id="oneTime" data-options="width:150,required:true,editable:false"> 至
			<input class="easyui-datebox" value="new Date()" name="" id="trueTime" data-options="width:150,required:true,editable:false">
			<input class="easyui-searchbox" id="jianyanMessId" style="width:200px;" data-options="labelWidth:65,prompt:'检验号',
						searcher : function( value , name){
			 			if(value==null){
			 				$('#JianyanMess-tbe').datagrid('reload','select_JianyanMess_biaoge');
			 			}else{
			 				$('#JianyanMess-tbe').datagrid({url : 'select_JianyanMessAll_Id'});
			 				$('#JianyanMess-tbe').datagrid('load',{jianyanMessId : value});
			 			}
			 		} "/>
			 		<a id="JianyanMess-shousuo"
			href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true"
			style="width: 60px">搜索</a>
			<a id="JianyanMess-showall"
			href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:true"
			style="width: 90px">显示所有</a>
			<a id="registration-sure"
			href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok',plain:true"
			style="width: 60px">确定</a>
		</div>
	</div>
	
	<script type="text/javascript">
	//显示所有
	 $("#JianyanMess-showall").linkbutton({onClick:function(){
			$("#firstTime").datebox('setValue',new Date()+"");
			$("#endTime").datebox('setValue',new Date()+"");
			$("#jianyanMessId").searchbox('setValue','');
			$('#JianyanMess-tbe').datagrid('reload','select_JianyanMess_biaoge');
		}}); 
	//高级查询
		$("#JianyanMess-shousuo").linkbutton({onClick :function(){
			var firstTime = $("#firstTime").datebox('getValue');
			var endTime = $("#endTime").datebox('getValue');
			var jianyanMessId = $("#jianyanMessId").textbox('getValue');
			$("#JianyanMess-tbe").datagrid({url : 'select_jianyanMess_Time'});
			$("#JianyanMess-tbe").datagrid('load' , {firstTime : firstTime,endTime : endTime,jianyanMessId: jianyanMessId});
		}});
	</script>
</body>
</html>