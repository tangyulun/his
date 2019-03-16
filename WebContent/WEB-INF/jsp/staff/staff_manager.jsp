<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="h" uri="http://www.51i-star.com/his" %>
	<link rel="stylesheet" type="text/css" href="<c:url value="/js/easyui/themes/default/easyui.css"/>">   
	<link rel="stylesheet" type="text/css" href="<c:url value="/js/easyui/themes/icon.css"/>"> 
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/tsp/table_height.css"/>"> 
	<script type="text/javascript" src="<c:url value="/js/jquery-3.1.0.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/easyui/jquery.easyui.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/easyui/easyui-lang-zh_CN.js"/>"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="layout-all-emp" class="easyui-layout" style="" data-options="fit:true , border : false">   
	    <div id="east-layout"data-options="region:'east',title:'指定角色' , collapsed:true" style="width:200px;">
	    <!-- -------------------------------------------------------------分配角色 -->
	   	 <div id="role-message-emp-div" style="display:none;border:false;height:500px;">
		    	<table id="role-message-emp" class="easyui-datagrid" 
	      					 data-options="fit:true,toolbar:'#roles_tool_roles' , fitColumns:true,singleSelect:false , method : 'get' , border:false , fit : true , rownumbers : true
	      		">   
				    <thead>   
				        <tr>   
				        	<th data-options="field:'code',width:2 , checkbox : true" ></th>
				            <th data-options="field:'rolesId',width:2 , align:'center'">编号</th>   
				            <th data-options="field:'rolesName',width:3 , align:'center'">角色名</th>   
				        </tr>   
				    </thead>   
				</table>  
				<div id="roles_tool_roles">
			   		  <a id="roles_tool_save" style="margin-left: 170px"  href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true,text:'保存'"></a>
			     </div>
	   	   <!-- -------------------------------------------------------------分配角色 -->
	   	    </div>
	   	    
	   	   <!-- -------------------------------------------------------------查看用户详情 -->
	   	   		<div id="emp-xq-mess-tabs" class="easyui-tabs" style="width:99.9%;height:501px;display:none ;">   
				    <div title="用户信息" style="display:none;border:0px;height:500px">   
				        <table id="emp-message-xq" class="easyui-datagrid" 
	      					data-options="height:500,fitColumns:true,singleSelect:true , method : 'get' , border:false , fit : true , rownumbers : true
	      				">   
						    <thead>   
						        <tr>   
						        	<th data-options="field:'object',width:2" >属性</th>
						            <th data-options="field:'value',width:2">值</th>   
						        </tr>   
						    </thead>   
						</table>   
				    </div>   
				    <div title="拥有角色" data-options="closable:false" style="overflow:auto;display:none;">   
				        <table id="select-emp-roles" class="easyui-datagrid" 
	      					data-options="height:500,fitColumns:true,singleSelect:true , method : 'get' , border:false , fit : true , rownumbers : true
	      				">   
						    <thead>   
						        <tr>   
						        	<th data-options="field:'rolesId',width:2 , align : 'center'">编号</th>
						            <th data-options="field:'rolesName',width:2 , align:'center'">角色名</th>   
						        </tr>   
						    </thead>   
						</table>   
				    </div>   
				    <div title="功能列表" data-options="closable:false" style="display:none;">   
				                           <table id="select-emp-functions" class="easyui-datagrid" 
	      					data-options="height:500,fitColumns:true,singleSelect:true , method : 'get' , border:false , fit : true , rownumbers : true
	      				">   
						    <thead>   
						        <tr>   
						        	<th data-options="field:'functionsId',width:2 , align : 'center'">编号</th>
						            <th data-options="field:'functionsName',width:2 , align:'center'">功能名</th>   
						        </tr>   
						    </thead>   
						</table>   
				    </div>   
				</div> 
	   		 <!-- -------------------------------------------------------------查看用户详情 -->
	    </div>   
	    <div data-options="region:'center' , border:false">
	    	<table class="easyui-datagrid"  id="emp-table"
     				  data-options="fitColumns:true,singleSelect:true,fit:true , toolbar:'#staff_tool' , 
     				  pagination: true,
		             pageSize: 5,
		             pageList: [5,10,15, 20],
		             url : 'select_all_emp' , 
		             striped : 'true',
		             rownumbers : true , border : false,
		             method : 'get'">   
			    <thead>   
			        <tr>   
			            <th data-options="field:'empId',width:10">员工编号 </th>   
			            <th data-options="field:'empName',width:10">员工姓名</th>   
			            <th data-options="field:'empSex',width:10">员工性别</th>   
			            <th data-options="field:'code8',width:10 ,
			            formatter: function(value,row,index){
						if (row.dept){
							return row.dept.deptName;
						} else {
							return value;
						}
					}">所属部门</th>   
			            <th data-options="field:'code10',width:10 , 
			            formatter: function(value,row,index){
						if (row.dclass){
							return row.dclass.dclassName;
						} else {
							return value;
						}
					}">所属科室 </th>   
			            <th data-options="field:'empState',width:10 ,
		            formatter: function(value,row,index){
						if (row.empState == '1'){
							return '启用';
						} else {
							return '禁用';
						}
						
					} ,
						styler: function(value,row,index){
							if (row.empState == '0'){
								return 'color:red;';
							}
						}
					">员工状态 </th>   
			            <th data-options="field:'empDate',width:10 , formatter : date">入职日期 </th>   
			            <th data-options="field:'code16',width:30 , formatter : operationEmp">操作</th>   
			        </tr>   
			    </thead>   
			</table>  
		<div id="staff_tool">
		<h:g id="65">
		     <a id="staff-add" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true,text:'员工入职'"></a>
		 </h:g> 
		     <input id="emp-name-or-id" class="easyui-searchbox" style="width:180px ; height: 20px;" 
					data-options="label : '员工名称' , labelWidth : 55 , 
					searcher : function(value , name){
					 	if(value == null){
					 		$('#emp-table').datagrid('reload' , 'select_all_emp');
					 	}else{
					 	    $('#emp-table').datagrid({url : 'select_emp_where'});
					 		$('#emp-table').datagrid('load' , {empName : value});
					 	}
					 }"/> 
				<input  id="grade-select-dept"  class="easyui-combobox" name="deptId"   
				 data-options="valueField:'deptId',textField:'deptName',url:'select_all_dept_to_dclass_select' ,
				  label:'部门' , labelWidth:40 ,
				   width:150 , height : 20 , labelAlign : 'right' , method : 'get'  , editable : false" />  
			 <input  id="grade-select-dclass" class="easyui-combobox" name="dclassId"   
			 data-options="valueField:'dclassId',textField:'dclassName',url:'where_select_dclass?deptId=1' ,
			  label:'科室' , labelWidth:40 ,
			   width:130 , labelAlign : 'right' , method : 'get'  , editable : false" />  
			 
			  <select id="grade-select-sex" class="easyui-combobox" name="sex-select" style="width:140px;height: 20px;" 
			  data-options="label : '性别' , labelWidth : 32  , editable : false">   
			     <option value="全部">全部</option>   
			     <option value="男">男</option>   
			    <option value="女">女</option>   
			 </select> 
			 <select id="grade-select-state" class="easyui-combobox" name="dept" style="width:140px;height: 20px;" 
			 data-options="label : '员工状态' , labelWidth : 62 , editable : false">   
			     <option value="全部">全部</option>   
			    <option value="0">禁用</option>   
			    <option value="1">启用</option>   
			 </select> 
			  <a id="staff-searcher" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true,text:'搜索'"></a>
			  <a id="staff-show-all" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:true,text:'显示所有'"></a>
		</div> 
	    </div>   
	</div>  
			
			<div id="create-new-staff" class="easyui-window" title="员工入职" data-options="
		collapsible:false,
		minimizable:false,
		maximizable:false,
		modal:true,
		closed: true" 
		style="width:750px;height:500px;padding:5px;">
		<form action="" method="post" id="emp-form">
		<div style=" height:420px;">
			<div>
				<fieldset style="border:1px solid rgb(149,184,231);border-radius: 15px">
					<legend><span>员工基本信息</span></legend>
					<table width="99%">
						<tr height="30px">
							<td>	
								<input id="empId" name="empId" value="10001" class="easyui-textbox" readonly="readonly" data-options="required : true , label:'员工编号' , labelWidth:100 , width:300 , labelAlign : 'right'"/>
							</td>
							<td>	
								<input name="empName" value="谭双平" class="easyui-textbox" data-options="required : true , label:'员工姓名' , labelWidth:100 , width:300 , labelAlign : 'right'"/>
							</td>
						</tr>
						<tr height="30px">
							<td>
								<input class="easyui-textbox" name="empLoginName" value="谭双平" data-options="required : true , validType : 'regexLoginName' , label:'员工登录名' , labelWidth:100 , width:300 , labelAlign : 'right'"/>
							</td>
							<td>	
								<input name="empDate" class="easyui-datebox" value="new Date()" data-options="label:'入职日期' , labelWidth:100 ,
								 width:300 , labelAlign : 'right' , editable : false"/>
							
							</td>
						</tr>
						
						<tr height="30px">
							<td>
								<input name="empPwd" id="empPasswords" class="easyui-passwordbox" value="123456" data-options="required : true ,label:'员工密码' , labelWidth:100 , width:300 , labelAlign : 'right'"/>
							</td>
							<td>
								<input class="easyui-passwordbox" value="123456" validType="equals['#empPasswords']"    data-options="required : true ,label:'确认密码' , labelWidth:100 , width:300 , labelAlign : 'right'"/>	
							</td>
						</tr>
						<tr height="30px">
							<td>
								<input  id="select-all_dept-to-emp" class="easyui-combobox" name="deptId"   
	   									 data-options="valueField:'deptId',textField:'deptName',url:'select_all_dept_to_dclass' ,
	   									  label:'所属部门' , labelWidth:100 ,required : true ,
	   									   width:300 , labelAlign : 'right' , method : 'get'  , editable : false" />  
							<td>
								<input  id="select-all_dclass-to-emp" class="easyui-combobox" name="dclassId"   
	   									 data-options="valueField:'dclassId',textField:'dclassName',url:'where_select_dclass?deptId=1' ,
	   									  label:'所属科室' , labelWidth:100 ,required : true ,
	   									   width:300 , labelAlign : 'right' , method : 'get'  , editable : false" />  
							</td>
						</tr>
					</table>
				</fieldset>
			</div>
			<div style="margin-top:10px;margin-left:14px;width:96%;">
				<fieldset style="border:1px solid rgb(149,184,231) ; border-radius: 15px">
					<legend ><span>员工详细信息</span></legend>
					<table width="99%">
						<tr height="">
							<td>
								<select name="empSex" class="easyui-combobox" data-options="editable : false , label:'性别' , labelWidth:100 , width:300 , labelAlign : 'right'">
									<option value="男">男</option>
									<option value="女">女</option>
									<option value="未知">未知</option>
								</select>
							</td>
							<td>
								<input name="empMessagePhone" class="easyui-textbox" value="15096353299" data-options="required : true ,label:'手机号' , labelWidth:100 , width:300 , labelAlign : 'right'"/>
							</td>
						</tr>
						<tr height="30px">
							<td>
								<select name="empMessageNation" class="easyui-combobox" data-options="editable : false, label:'民族' , labelWidth:100 , width:300 , labelAlign : 'right'">
									<option value="汉族">汉族</option>
									<option value="少数民族">少数民族</option>
									<option value="未知">未知</option>
								</select>
							</td>
							<td>
								<input name="empMessageIdCard" class="easyui-textbox" value="430224199901287233" data-options="required : true ,label:'身份证编号' , labelWidth:100 , width:300 , labelAlign : 'right'"/>
							</td>
						</tr>
						<tr height="30px">
							<td>
								<input name="empMessageBirthday" class="easyui-datebox" value="1999-01-28" data-options="editable : false , label:'出生日期' , labelWidth:100 , width:300 , labelAlign : 'right'"/>
							</td>
							<td>
								<select name="empMessageIsMarry" class="easyui-combobox" data-options="editable : false , label:'婚姻状态' , labelWidth:100 , width:300 , labelAlign : 'right'">
									<option value="已婚">已婚</option>
									<option value="未婚">未婚</option>
									<option value="未知">未知</option>
								</select>
							</td>
						</tr>
						<tr height="30px">
							<td>
								<select name="empMessageFace" class="easyui-combobox" data-options="editable : false ,label:'政治面貌' , labelWidth:100 , width:300 , labelAlign : 'right'">
									<option value="共青党员">共青党员</option>
									<option value="共青团员">共青团员</option>
									<option value="未知">未知</option>
								</select>
							</td>
							<td>	
								<select name="empMessageXueli" class="easyui-combobox" data-options="editable : false ,label:'学历' , labelWidth:100 , width:300 , labelAlign : 'right'">
									<option value="本科">本科</option>
									<option value="专科">专科</option>
									<option value="专科">其他</option>
								</select>
							</td>
						</tr>
						<tr height="30px">
							<td>
								<select name="empMessageDisposeName" class="easyui-combobox" data-options="editable : false , label:'入职处理人' , labelWidth:100 , width:300 , labelAlign : 'right'">
									<option value="${empMessage.empLoginName}">${empMessage.empLoginName}</option>
								</select>
							</td>
							<td>
								<input name="empMessageDisposeDate" class="easyui-datebox" value="new Date()" data-options="label:'入职批准日期' , labelWidth:100 , width:300 , labelAlign : 'right'"/>
							</td>
						</tr>
						<tr height="30px">
							<td>
								<select name="empMessageMajor" class="easyui-combobox" data-options="label:'专业' , labelWidth:100 , width:300 , labelAlign : 'right'">
									<option value="医师">医生</option>
									<option value="医师">医生2</option>
								</select>
							</td>
							<td>
								<input name="empMessageAddress" class="easyui-textbox" value="湖南株洲茶陵湖口" data-options="required : true ,label:'家庭住址' , labelWidth:100 , width:300 , labelAlign : 'right'"/>
							</td>
						</tr>
						<tr height="30px">
							<td colspan="2">
								<input name="empMessageRemark" class="easyui-textbox" data-options="label:'备注' , labelWidth:100 , width:630 , labelAlign : 'right'"/>
							</td>
						</tr>
					</table>
				</fieldset>
			</div>
			</div>
				<div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
					<a id="emp-save" class="easyui-linkbutton" data-options="iconCls:'icon-ok', plain:true">保存</a>
					<a id="emp-not" class="easyui-linkbutton" data-options="iconCls:'icon-cancel', plain:true">取消</a>
				</div>
		</form>
		</div>
		 <div id="update-emp-dept" class="easyui-window" title="部门调换" data-options="
				collapsible:false,
				minimizable:false,
				maximizable:false,
				modal:true,
				method : 'get',
				closed: true" 
				style="width:500px;height:200px;padding:5px;">
				<div class="easyui-layout" data-options="fit:true">
						<div data-options="region:'center'" style="padding:10px;">
				<form id="ff-update-emp-dept" method="post">
					<table width="100%">
						<tr height="40px">
							<td>
								<input id="oldDept" name="oldDept" class="easyui-combobox" data-options="label:'原部门' , validType : 'regexPwdTrue' , 
									labelWidth:80 , width:220 ,editable : false, labelAlign : 'right' , required : true"/>
							</td>
							<td>
								<input id="oldDclass" name="oldDclass" id="newPwd" class="easyui-combobox" data-options="label:'原科室' , 
									labelWidth:80 , width:220 , editable : false, labelAlign : 'right' , method:'get' ,required :true"/>
							</td>
						</tr>
						<tr height="40px">
							<td>
								<input  id="select-dept-to-update" class="easyui-combobox" name="newDept"   
	   									 data-options="valueField:'deptId',textField:'deptName',url:'select_all_dept_to_dclass' ,
	   									  label:'新部门' , labelWidth:80 ,required : true ,
	   									   width:220 , labelAlign : 'right' , method : 'get'  , editable : false" />  
							</td>
							<td>
								<input id="newDclass" name="newDclass" id="newPwd" class="easyui-combobox" data-options="label:'新科室' , 
									labelWidth:80 , valueField:'dclassId',textField:'dclassName' ,width:220 , editable : false, labelAlign : 'right' , method:'get' , required :true"/>
							</td>
						</tr>
						
					</table>
				</form>
						</div>
						<div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
							<a id="update-dept-save" class="easyui-linkbutton" data-options="iconCls:'icon-ok', plain:true">确定</a>
							<a id="update-dept-not" class="easyui-linkbutton" data-options="iconCls:'icon-cancel', plain:true">取消</a>
						</div>
				</div>
		</div> 	
		<!-- 调换部门 -->
		<c:forEach items="${functions}" var="f">
			<input type="hidden" value="${f}" class="funse"/>
		</c:forEach>
		<script type="text/javascript">
		
			$.extend($.fn.validatebox.defaults.rules, {    
			    equals: {    
			        validator: function(value,param){    
			            return value == $(param[0]).val();    
			        },    
			        message: '两次密码输入不一致！'   
			    }    
			}); 
			
			$(function(){
				
				$('#layout-all-emp').layout('collapse' ,'east');
				$("#staff-add").linkbutton({onClick : function(){
					$.get("select_emp_id" , function(data){
						$("#empId").textbox('setValue' , data);
						$("#create-new-staff").window("open");
					});
				}});
				
				$("#emp-not").linkbutton({onClick : function(){
					$("#emp-form").form("reset");
					$("#create-new-staff").window("close");
				}});
				
				$("#create-new-staff").window({onClose : function(){
					$("#emp-form").form("reset");
				}});
				
				$("#select-all_dept-to-emp").combobox({onSelect : function(record){
					$('#select-all_dclass-to-emp').combobox('reload','where_select_dclass?deptId='+record.deptId);  // 使用新的URL重新载入列表数据
					$('#select-all_dclass-to-emp').combobox('clear');  
				}});
				
				$("#select-dept-to-update").combobox({onSelect : function(record){
					$('#newDclass').combobox('reload','where_select_dclass?deptId='+record.deptId);  // 使用新的URL重新载入列表数据
					$('#newDclass').combobox('clear');  
				}});
				
				$("#grade-select-dept").combobox({onSelect : function(record){
					$('#grade-select-dclass').combobox('reload','where_select_dclass_zj?deptId='+record.deptId);  // 使用新的URL重新载入列表数据
					$('#grade-select-dclass').combobox('clear');  
				}});
				
				$("#emp-save").linkbutton({onClick : function(){
					$("#emp-form").form('submit' , {
						url : 'insert_emp',
						onSubmit : function(){
							return $(this).form('validate');
						},
						success : function(data){
							var json = eval('('+data+')');
							if(json.error){
								$("#emp-form").form("reset");
								$("#emp-table").datagrid("load");
								$("#create-new-staff").window("close");
							}else{
								$.messager.alert("提示" , json.message);
							}
						}
					});
				}});
				
				//高级查询
				$("#staff-show-all").linkbutton({onClick : function(){
					$("#emp-name-or-id").textbox('setValue' ,'');
					$("#grade-select-dept").combobox('select' , '全部');
					$("#grade-select-dclass").combobox('select' , '全部');
					$("#grade-select-sex").combobox('select' , '全部');
					$("#grade-select-state").combobox('select' , '全部');
					$('#emp-table').datagrid('reload' , 'select_all_emp');
				}});
				
				$("#staff-searcher").linkbutton({onClick : function(){
					var empName = $("#emp-name-or-id").textbox('getValue');
					var empDeptId = $("#grade-select-dept").combobox('getValue');
					var empDclassId = $("#grade-select-dclass").combobox('getValue');
					var empSex = $("#grade-select-sex").combobox('getValue');
					var empState = $("#grade-select-state").combobox('getValue');
					$('#emp-table').datagrid({url : 'select_all_emp_where_grade'});
					$("#emp-table").datagrid('load' , {empName : empName ,
						empDeptId : empDeptId=='' ? 0 : empDeptId , 
						empDclassId :empDclassId == '' ? 0 : empDclassId ,
						empSex : empSex , empState : empState});
				}});
				//检测登录名唯一
				$.extend($.fn.validatebox.defaults.rules , {
					regexLoginName : {
						validator : function(value){
							var json = null;
							$.post({
								async : false,
								url : 'regex_login_name',
								data : {'loginName' :  value} , 
								success : function(data){
									json = eval('('+data+')');
								}
							});
							return json.error;
						},
						message : '该登录名已存在!'
					}
				});
				
			});
			function operationEmp(value , row , index){
				var selectxq = '' , deletes = '' , update = '' , grantRoles = "" ,  updateDept = "";
				if(row.empId == 10001){
					if(selectIsEmpFunctions(69)){
						selectxq =  "<button class='ope_style' onclick='selectXq("+index+")'>查看详情</button>";
					}
				}else{
					
						if(selectIsEmpFunctions(66)){
							deletes= row.empState==0 ?  "<button class='ope_style' onclick='deletes("+index+")'>启用</button>"
							: "<button class='ope_style' onclick='deletes("+index+")'>禁用</button>";
						}
					
					if(row.empPwd != 'e10adc3949ba59abbe56e057f20f883e'){
						if(selectIsEmpFunctions(70)){
							 update =  "<button class='ope_style' onclick='update("+index+")'>重置密码</button>";
						}
					}
					
					if(row.empState != '0'){
						if(selectIsEmpFunctions(67)){
							 updateDept = "<button class='ope_style' onclick='updateDept("+index+")'>调换部门</button>";
						}
						if(selectIsEmpFunctions(68)){
							 grantRoles = "<button class='ope_style' onclick='grantRole("+index+")'>指定角色</button>";
						}
					}
					
					if(selectIsEmpFunctions(69)){
						selectxq=  "<button class='ope_style' onclick='selectXq("+index+")'>查看详情</button>";
					}
				}
				return deletes + update +updateDept+ grantRoles + selectxq;
			}
			
			//停用
			function deletes(index){
				var row = rowId(index);
				$.messager.confirm('确认' , '你确定要停用或启用编号为'+row.empId+'员工吗?' , function(v){
					if(v){
						$.getJSON('deletes_emp' , {empId : row.empId , state : row.empState == 0 ? 1 : 0} , function(data){
							if(data.error){
								$('#emp-table').datagrid('reload' , 'select_all_emp');
							}
						});
					}
				});
			}
			
			//重置
			function update(index){
				var row = rowId(index);
				$.messager.confirm('确认' ,'你确定要重置编号为'+row.empId+'员工的密码吗?' , function(v){
					if(v){
						$.getJSON('reset_pwd' , {empId : row.empId} , function(data){
							if(data.error){
								$.messager.alert('提示' , '密码重置成功,初始化密码为123456');
							}
						});
					}
				});
				
			}
			
			//指定角色
			function grantRole(index){
				oneAndTwo("#role-message-emp-div" , "#emp-xq-mess-tabs");
				var row = rowId(index);
				var panel=$('#layout-all-emp').layout('panel','east');  
				 $(panel).panel({
					title:'给  <a style="color:red">' + row.empName + '</a> 指定角色',
					width : 235
				}); 
				$('#layout-all-emp').layout('expand' ,'east');
				$("#role-message-emp").datagrid({url: 'select_all_role_to_user?empId='+ row.empId});
				 $.get("select_all_role_to_user" , {'empId' : row.empId} , function(data){
					var json = eval("("+data+")");
					for (var i = 0; i < json.length; i++) {
						if(json[i].frag){
							$("#role-message-emp").datagrid("checkRow" , i);
						}
					}
				 });
				//保存角色
				$("#roles_tool_save").linkbutton({onClick : function(){
					var selectTabs= $("#role-message-emp").datagrid("getSelections");
					var str = "";
					for (var i = 0; i < selectTabs.length; i++) {
						str += selectTabs[i].rolesId + ",";
					}
				    $.post("grant_to_emp_roles" , {"rolesIds" : str , "empId" : row.empId} , function(data){
						var json = eval("("+data+")");
						if(json.error){
							$.messager.alert("操作 " , json.eMessage);
						}
					}); 
				}});
					
			}
			
			//查看用户详情
			function selectXq(index){
				oneAndTwo("#emp-xq-mess-tabs" ,"#role-message-emp-div");
				var row = rowId(index);
				var panel=$('#layout-all-emp').layout('panel','east');  
				 $(panel).panel({
					title:'查看  <a style="color:red">' + row.empName + '</a> 详情',
					width : 235
				});
				 $('#layout-all-emp').layout('expand' ,'east');
				 //基本信息
				 $("#emp-message-xq").datagrid({url :"emp_message_xq?empId="+row.empId});
				 //拥有角色
				 $("#select-emp-roles").datagrid({url : 'select_emp_roles?empId='+row.empId});
				 //功能列表
				 $("#select-emp-functions").datagrid({url : 'select_emp_functions?empId='+row.empId});
			}
			//部门调换
			function updateDept(index){
				$("#update-emp-dept").window('open');
				var row = rowId(index);
				$("#oldDept").combobox("setValue" , row.dept.deptName);
				$("#oldDclass").combobox("setValue" , row.dclass.dclassName);
				//修改部门
				$("#update-dept-save").linkbutton({onClick : function(){
					 $("#ff-update-emp-dept").form('submit',{
						url : 'update_dept_to_emp',
						onSubmit : function(param){
							param.empId = row.empId;
							return $(this).form("validate");
						},
						success : function(data){
							var json = eval('('+data+')');
							if(json.error){
								$('#emp-table').datagrid('reload' , 'select_all_emp');
								$("#ff-update-emp-dept").form("reset");
								$("#update-emp-dept").window('close');
							}else{
								$.messager.alert("提示" , json.eMessage);
							}
						}
					});
				}});
	
				
				//修改部门
				$("#update-dept-not").linkbutton({onClick : function(){
					$("#ff-update-emp-dept").form("reset");
					$("#update-emp-dept").window('close');
				}});
				
			}
			//查找是否有该功能
			function selectIsEmpFunctions(id){
				for (var i = 0; i < $('.funse').length; i++) {
					if($('.funse').eq(i).val() == id){
						 return true;
					}
				}
				return false;
			}
			
			//获取参数
			function rowId(index){
				$('#emp-table').datagrid('selectRow',index);
				var	row = $('#emp-table').datagrid('getSelected'); 
				return row;
			}
			
			
			//隐藏显示
			function oneAndTwo(one , two){
				$(one).show();
				$(two).hide();
			}
			
		</script>
</body>
</html>