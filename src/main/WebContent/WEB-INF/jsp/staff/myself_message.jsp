<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
				  <table id="select_emp_m" class="easyui-datagrid" 
	      					data-options="toolbar:'#emp_emp_emp' ,border:false,
	      					url : 'emp_message_xq?empId=+${empMessage.empId}',
	      					height:500,fitColumns:true,singleSelect:true , method : 'get' , fit : true , rownumbers : true
	      				">   
				    <thead>   
				        <tr>   
				        	<th data-options="field:'object',width:2" >属性</th>
				            <th data-options="field:'value',width:4">值</th>   
				        </tr>   
				    </thead>   
				</table>  
				<!-- <div id="emp_emp_emp">
			   		  <a id="emp_emp_update"  href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true,text:'编辑个人信息'"></a>
			     </div> -->
		
		 <!-- <div id="update_my_message" class="easyui-window" title="查询个人信息" data-options="
				collapsible:false,
				minimizable:false,
				maximizable:false,
				modal:true,
				method : 'get',
				closed: true" 
				style="width:500px;height:350px;padding:5px;">
				<table>
					
				</table>
		</div> -->
		<script type="text/javascript">
		$(function(){
			$("#emp_emp_update").linkbutton({onClick : function(){
				$("#update_my_message").window("open");
			}});
		});
		</script>
</body>
</html>