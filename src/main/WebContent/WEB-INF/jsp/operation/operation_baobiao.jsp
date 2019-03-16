<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div data-options="region:'center'" style="height: 45%;">
		<table id="JianyanMess-tbe"   width="100%" class="easyui-datagrid" data-options="
						fit : true  , 
						fitColumns:true,
						pagination:true  , 
						rownumbers:true,
						pageSize:10  ,  
						singleSelect : true,
						url:'select_shujubiaoge', 
						method:'get',
						border:false  ,  
						toolbar:'#JianyanMess-tb',
						pageList:[10,20,30,40]">
				<thead>
					<tr>
							<th data-options="field:'jianyanMessId',width:10,align:'center'">检验编号</th>
							<th data-options="field:'outpaitentRegistId',width:10,align:'center',
							formatter(value , row , index){
								if(row.outpaitentRegist.outpaitentRegistId != null){
									return row.outpaitentRegist.outpaitentRegistId;
								}
								return value;
							}">门诊号</th>
							<th data-options="field:'empId',width:10,align:'center',
							formatter(value , row , index){
								if(row.emp.empId != null){
									return row.emp.empId;
								}
								return value;
							}">员工编号</th>
							<th data-options="field:'jianyanMessState',width:10,align:'center'">检验状态</th>
							<th data-options="field:'jianyanMessDate',width:10,align:'center',formatter: date">检验日期</th>
							<th data-options="field:'jianyanMessDclass',width:10,align:'center'">检验室</th>
							<th data-options="field:'jianyanMessYangbenType',width:10,align:'center'">样本类型</th>
					</tr>
				</thead>
		</table>
		<div id="JianyanMess-tb">
			<input class="easyui-searchbox" id="jianyanMessId" style="width:160px;" data-options="labelWidth:65,prompt:'检验号',
						searcher : function( value , name){
			 			if(!value){
			 				$('#JianyanMess-tbe').datagrid('reload','select_shujubiaoge');
			 				return;
			 			}else{
			 				$('#JianyanMess-tbe').datagrid({url : 'select_Chaxun_ID'});
			 				$('#JianyanMess-tbe').datagrid('load',{jianyanMessId : value});
			 			}
			 		} "/>
			<input class="easyui-datebox" value="new Date()" name="" id="oneTime" data-options="width:150,required:true,editable:false"> 至
			<input class="easyui-datebox" value="new Date()" name="" id="trueTime" data-options="width:150,required:true,editable:false">
			<a id="datesousuo"  href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" style="width: 60px">搜索</a>
			<a id="JianyanMess-all"
			href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:true"
			style="width: 90px">显示所有</a>
		</div>
	</div>
	<!-- 第二个记录汇总 -->
	<div  data-options="region:'center'" 
	 style="height:54%;border: 1px solid #66cccc;">
			<table  id="table-tijian-b" style="width:99%;" class="easyui-datagrid"
						data-options="fit : true,
						border:		false,
						fitColumns:	true,
						striped:	true,
						method	:	'get',
						rownumbers	:	true">
				<thead>
					<tr>
						<th data-options="field:'jianyanMessXqId',width:10,align:'center'">检验项目编号</th>
						<th data-options="field:'jianyanMessId',width:10,align:'center',
						formatter(value , row , index){
								if(row.jianyanMess.jianyanMessId != null){
									return row.jianyanMess.jianyanMessId;
								}
								return value;
							}">检验编号</th>
						<th data-options="field:'jianyanMessXqBetween',width:10,align:'center'">参考范围</th>
						<th data-options="field:'jianyanMessXqResult',width:10,align:'center'">检验结果</th>
						<th data-options="field:'jianyanMessXq',width:10,align:'center'">是否异常</th>
					</tr>
				</thead>					
			</table>
	</div>
	<script type="text/javascript">
	$(function(){
	//显示所有
	 $("#JianyanMess-all").linkbutton({onClick:function(){
			$("#oneTime").datebox('setValue',new Date()+"");
			$("#trueTime").datebox('setValue',new Date()+"");
			$("#jianyanMessId").searchbox('setValue','');
			$('#JianyanMess-tbe').datagrid('reload','select_shujubiaoge');
		}});
		
		//上面表格点下面表格,通过Id搜索来点
		$("#JianyanMess-tbe").datagrid({onClickRow : function(){
			var rows = $("#JianyanMess-tbe").datagrid("getSelected");
			$("#table-tijian-b").datagrid({url : 'select_xq_shujubiaoge'});
			$("#table-tijian-b").datagrid('load' , {JianyanMessId : rows.jianyanMessId});
			qingkong();
		}});
		//时间查询
		$("#datesousuo").linkbutton({onClick :function(){
			var oneTime = $("#oneTime").datebox('getValue');
			var trueTime = $("#trueTime").datebox('getValue');
			var jianyanMessId = $("#jianyanMessId").textbox('getValue');	
			$("#JianyanMess-tbe").datagrid({url : 'select_Chaxun_Time'});
			$("#JianyanMess-tbe").datagrid('load' , {oneTime : oneTime,trueTime : trueTime,jianyanMessId: jianyanMessId});
			qingkong();
		}});
	});
	//清空
 	function qingkong(){
		var rows = $("#table-tijian-b").datagrid('getRows');
		for(var i=rows.length -1; i>=0;i--){
			$("#table-tijian-b").datagrid('deleteRow',i);
		}
	}
	</script>
</body>
</html>