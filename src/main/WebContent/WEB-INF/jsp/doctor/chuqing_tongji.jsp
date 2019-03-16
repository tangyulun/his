<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>出勤统计</title>
</head>
<body>
	<!-- <table class="easyui-datagrid" 
        data-options="fit:true,fitColumns:true,singleSelect:true">   
	    <thead>   
	        <tr>   
	            <th data-options="field:'code',width:100">编码</th>   
	            <th data-options="field:'name',width:100">名称</th>   
	            <th data-options="field:'price',width:100">价格</th>   
	        </tr>   
	    </thead>   
	</table> -->
	<div class="easyui-layout" id="chuqin_layout" data-options="fit:true">   
	    <div data-options="region:'east',title:'West',title :'签到详情',  collapsed:true" style="width:150px;">
	    	  <table class="easyui-datagrid" 
	    	  	id="que_qin_table"
		        data-options="border:false,fit:true,method : 'get',fitColumns:true,singleSelect:true,rownumbers : true">   
			    <thead>   
			        <tr>   
			            <th data-options="field:'chuqinDate',width:100 , formatter:date">缺勤日期</th>   
			        </tr>   
			    </thead>   
			</table>
	    </div>   
	    <div data-options="region:'center' , border:false"  style="">
			  <table class="easyui-datagrid"  id="chuqin_table"
		        data-options="fit:true,fitColumns:true,border:false,
		        url: 'select_all_chu_qin_new_month',
			     striped : true,
			     singleSelect:true,
			     method: 'get',
			     toolbar : '#chuqin_toolbar',
	             rownumbers : true">   
			    <thead>   
			        <tr>   
			            <th data-options="field:'empId',width:100">员工编号</th>   
			            <th data-options="field:'empLoginName',width:100">员工姓名</th>   
			            <th data-options="field:'deptName',width:100">所属部门</th>   
			            <th data-options="field:'dclassName',width:100">所属科室</th>   
			            <th data-options="field:'benYueDays',width:100">本月总天数</th>   
			            <th data-options="field:'chuqinDays',width:100">出勤天数</th>   
			            <th data-options="field:'queQinDays',width:100">缺勤天数</th>   
			            <th data-options="field:'chuqinLv',width:100 ,
			            formatter : function(value ,row , index){
			            	return row.chuqinLv + '%';
			            }
			            ">出勤率</th>   
			        </tr>   
			    </thead>   
			</table>
	    </div>   
	</div>  
	<div id="chuqin_toolbar">
				<select id="chuqin_com" class="easyui-combobox"
				data-options="editable: false"
				 name="" style="width:80px;height:20px">   
					<c:forEach begin="1" end="12" var="y">
						    <option value="${y}">${y}月份</option>   
					</c:forEach>
				</select> 
	</div>
	
	<script type="text/javascript">
		$(function(){
			$("#chuqin_table").datagrid({onClickRow : function(index , rows){
				   var panel=$('#chuqin_layout').layout('panel','east');  
					$(panel).panel({
						title:'查看  <a style="color:red">' + rows.empLoginName + '</a> 签到情况'
					});
				$('#chuqin_layout').layout('expand' ,'east');
				$("#que_qin_table").datagrid({url : 'select_que_qin_days'});
				$("#que_qin_table").datagrid('load' , {empId : rows.empId , month : $("#chuqin_com").combobox('getValue')});
			}});
			$("#chuqin_com").combobox({onChange : function(n , o){
				//加载
				$("#chuqin_table").datagrid('load' , 'select_month_chu_qin?month='+n);
			}});
			var date = new Date();
			var month = date.getMonth() + 1;
			$("#chuqin_com").combobox('select' , month);
		});
	</script>
</body>
</html>