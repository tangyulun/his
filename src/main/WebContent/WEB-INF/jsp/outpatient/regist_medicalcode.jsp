<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>办卡记录</title>
</head>
<body>
<script type="text/javascript">
	//高级查询
	$("#registration-seacher").linkbutton({onClick :function(){
		var startTime = $("#reStratTime").textbox('getValue');
		var endTime = $("#reEndTime").textbox('getValue');
		var searcherId = $("#reSearcher").searchbox('getValue');
		$("#banka-tb").datagrid({url : 'queryDate_and_String'});
		$("#banka-tb").datagrid('load' , {startTime : startTime,endTime : endTime,searcherId: searcherId});
	}});
	
	//查询所有
	 $("#registration-showall").linkbutton({onClick:function(){
		$("#reStratTime").datebox('setValue',new Date()+"");
		$("#reEndTime").datebox('setValue',new Date()+"");
		$("#reSearcher").searchbox('setValue','');
		$('#banka-tb').datagrid('reload','queryMedical');
	}}); 
	
	//确定选择卡号
	 $("#registration-sure").linkbutton({onClick : function(){
		var row = $("#banka-tb").datagrid('getSelected');
		if(row == null){
			$.messager.alert("提示","您选择的 一行为空！");
			return;
		}
		loadTable(row);
		
	}});
	
	//双击卡号的某一行，传入文本框
	$("#banka-tb").datagrid({onDblClickRow : function(index ,row){
		loadTable(row);
	}});


</script>
	<table id="banka-tb"   width="100%" class="easyui-datagrid" data-options="
						fit : true,
						fitColumns:true,
						pagination:true,
						rownumbers:true,
						pageSize:10,
						singleSelect : true,
						url:'queryMedical',
						method:'get',
						border:false,
						toolbar:'#registkh-tb',
						pageList:[10,20,30,40]">
				<thead>
					<tr>
						<th data-options="field:'empId',width:20,align:'center',checkbox:true">操作人</th>
						<th data-options="field:'medicalCardCardId',width:100,align:'center'">就诊编号</th>
						<th data-options="field:'medicalCardName',width:80,align:'center'">姓名</th>
						<th data-options="field:'medicalCardSex',width:80,align:'center'">性别</th>
						<th data-options="field:'medicalCardAge',width:80,align:'center'">年龄</th>
						<th data-options="field:'medicalCardHunyanzk',width:120,align:'center'">婚姻状况</th>
						<th data-options="field:'medicalCardIdencard',width:220,align:'center'">身份证号</th>
						<th data-options="field:'medicalCardDate',width:120,align:'center',formatter:date">办卡日期</th>
						<th data-options="field:'medicalCardBingzhuang',width:180,align:'center'">病状</th>
					</tr>
				</thead>
		</table>
		<div id="registkh-tb">
			<input class="easyui-datebox" value="new Date()" name="" id="reStratTime" data-options="width:150,required:true,editable:false"> 至
			<input class="easyui-datebox" value="new Date()" name="" id="reEndTime" data-options="width:150,required:true,editable:false">
			<input class="easyui-searchbox" id="reSearcher" style="width:200px;" data-options="label:'就诊卡号',labelWidth:65,prompt:'就诊卡号',
			 		 searcher : function( value , name){
			 			if(value==null){
			 				$('#banka-tb').datagrid('reload','queryMedical');
			 			}else{
			 				$('#banka-tb').datagrid({url : 'queryMedical_where_Id'});
			 				$('#banka-tb').datagrid('load',{MedicalId : value});
			 			}
			 		} 
			 		"/>
			
			<a id="registration-seacher"
			href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true"
			style="width: 60px">搜索</a>
			<a id="registration-showall"
			href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:true"
			style="width: 90px">显示所有</a>
			<a id="registration-sure"
			href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok',plain:true"
			style="width: 60px">确定</a>
		</div>
	
</body>
</html>