<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
				  <table id="select_emp_login_jilu" class="easyui-datagrid" 
	      					data-options="toolbar:'#emp_login_logger' ,
	      					url : 'login_logger_select',
						     striped : true,
						     border:false,
					         pagination: true,
				             pageSize: 5,
				             pageList: [5,10,15, 20],
	      					height:500,
	      					fitColumns:true,
	      					singleSelect:true , 
	      					method : 'get' ,
	      					 fit : true ,
	      					 rownumbers : true
	      				">   
				    <thead>   
				        <tr>   
				        	<th data-options="field:'loginDate',width:45, formatter:date">登录日期</th>
				            <th data-options="field:'loginTimes',width:65">登录时间</th>   
				        </tr>   
				    </thead>   
				</table>  
				 <div id="emp_login_logger" style="margin-left:5px">
			   		  <input id="emp_login_logger_input"  value="new Date()" class="easyui-datebox" data-options="editable : false , width:120"/>
			   		    <a id="show_all_jilu" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true ,iconCls : 'icon-reload' , text : '显示所有'"></a>
			     </div>
		<script type="text/javascript">
			$("#emp_login_logger_input").datebox({onChange : function(){
				var times = $("#emp_login_logger_input").datebox("getValue");
				$("#select_emp_login_jilu").datagrid({url : "select_login_jilu_times_where"});
				$("#select_emp_login_jilu").datagrid('load' , {times : times});
			}});
			$("#show_all_jilu").linkbutton({onClick : function(){
				$("#emp_login_logger_input").datebox("setValue" , ''+new Date());
				$("#select_emp_login_jilu").datagrid('reload' , 'login_logger_select');
			}});
		</script>
</body>
</html>