<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="h" uri="http://www.51i-star.com/his" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>角色列表</title>
</head>
<body>
	<div id="layout-roles-all-s" class="easyui-layout" data-options="fit:true , border : false">   
		<div data-options="region:'east',title:'角色详情' , collapsed:true"  style="width:220px;">
			<div id="tt_grant" style="margin:5px 0px 0px 10px ;height:100%;display:none">
				<a style="margin-left: 145px" id="save_grant_functions" class="easyui-linkbutton" data-options="iconCls:'icon-save', plain:true">保存</a>
		    	<div style="height:92%;overflow: auto;">
			    	<ul id="tt_grant_functions" class="easyui-tree" data-options="lines:true">   
					   
					</ul> 
				</div> 
		    </div>
		    <div  id="tt_grant_tabs" class="easyui-tabs" data-options="fit:true , border:false" style="display:none">   
			   <div title="角色信息 " style="padding:2px;">   
			      	<table id="roles_message" class="easyui-datagrid" 
       					 data-options="fitColumns:true,singleSelect:true , method : 'get' , border:false , fit : true , rownumbers : true
       					 ">   
					    <thead>   
					        <tr>   
					            <th data-options="field:'attr',width:5">名称</th>   
					            <th data-options="field:'values',width:5">值</th>   
					        </tr>   
					    </thead>   
					</table>  
			    </div>   
			    <div title="拥有用户"  style="overflow:auto;padding:2px;">   
			         <table id="user_message" class="easyui-datagrid" 
       					 data-options="fitColumns:true,singleSelect:true , method : 'get' , border:false , fit : true , rownumbers : true
       					 ">   
					    <thead>   
					        <tr>   
					            <th data-options="field:'empId',width:2 , align:'center'">编号</th>   
					            <th data-options="field:'empName',width:3 , align:'center'">用户名</th>   
					            <th data-options="field:'dclass',width:5 , align:'center',
					             formatter: function(value,row,index){
									if (row.dclass != null){
										return row.dclass.dclassName;
									} else {
										return value;
									}
								}	
					            ">科室</th>   
					        </tr>   
					    </thead>   
					</table>  
			    </div>   
			    <div title="功能列表"  style="overflow:auto;padding:2px;display:none;">   
			          <table id="functions_message" class="easyui-datagrid" 
       					 data-options="fitColumns:true,singleSelect:true , method : 'get' , border:false , fit : true , rownumbers : true
       					 ">   
					    <thead>   
					        <tr>   
					            <th data-options="field:'functionsId',width:25">编号</th>   
					            <th data-options="field:'functionsName',width:75">功能名称</th>   
					        </tr>   
					    </thead>   
					</table>         
			    </div>   
			</div>  
			
			<div id="grant_users" style="display: none">
				<table id="grant_user_s" class="easyui-datagrid" style="width:240px;height:485px;overflow:auto;"   
       					 data-options="fitColumns:true,singleSelect:false ,  method : 'get' , border:false , rownumbers : true , toolbar:'#emp_tools_emp' ,
       					 ">   
				    <thead>   
				        <tr>   
				        	<th data-options="field:'code', checkbox : true"></th>
				            <th data-options="field:'empLoginName',width:3 ">用户名</th>   
				            <th data-options="field:'dclass',width:5,
					             formatter: function(value,row,index){
									if (row.dclass != null){
										return row.dclass.dclassName;
									} else {
										return value;
									}
								}	
					          ">科室</th>  
				        </tr>   
				    </thead>   
				</table>  
				
			</div>
			<div id="emp_tools_emp">
		   		  <a id="save_grant_users" style="margin-left: 157px"  href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true,text:'保存'"></a>
		     </div>
		</div>   
	    <div data-options="region:'center' , border:false" >
	    	<table id="roles_tab" class="easyui-datagrid"
		        data-options="fitColumns:true,singleSelect:true,fit:true,
		         toolbar : '#limit_tool',
			     url: 'select_all_roles',
			     fitColumns : true,
			     striped : true,
			     method: 'get',
		         pagination: true,
	             pageSize: 5,
	             singleSelect : true,
	             pageList: [5,10,15, 20],
	             rownumbers : true
	              , border:false
		      ">   
			    <thead> 
			        <tr>   
			            <th data-options="field:'rolesName',width:10">角色名称</th>   
			            <th data-options="field:'rolesEffect',width:20">角色作用</th>   
			            <th data-options="field:'rolesDate',width:15 , formatter : date">角色创建日期</th>   
			            <th data-options="field:'code16',width:50 , formatter : operationRoles" >操作</th>   
			        </tr>   
			    </thead>   
			</table> 
			<div id="limit_tool">
			<h:g id="58">
			     <a id="limit-add" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true,text:'创建新角色'"></a>
			</h:g>	
			     <input id="key_value" class="easyui-searchbox" style="width:200px ; height: 20px;" 
						data-options="label : '角色名' , labelWidth : 55, prompt:'角色名' , 
				    		searcher : function(value , name){
					    		if(value == null){
					    			$('#roles_tab').datagrid('reload' , 'select_all_roles');
					    		}else{
					    			$('#roles_tab').datagrid({url : 'select_where_roles'});
					    			$('#roles_tab').datagrid('load' , {key : value});
					    		}
					    	}
						"></input> 
				<input id="start_date" class="easyui-datebox" value="new Date()" style="width:200px ; height: 20px;" 
						data-options="label : '日期' , labelWidth : 35 , editable : false"></input> 
						至
				<input id="end_date" class="easyui-datebox" value="new Date()" style="width:140px ; height: 20px;" 
				data-options="labelWidth : 55 ,editable : false"></input> 
				   <a id="roles-serach" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true,text:'搜索'
				    "></a>
				  <a id="roles-show-all" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:true,text:'显示所有'"></a>
			</div> 	   
	    </div>   
	</div>  
	
	<div id="create-new-limit" class="easyui-window" title="创建新角色" data-options="
				collapsible:false,
				minimizable:false,
				maximizable:false,
				modal:true,
				closed: true" 
				style="width:400px;height:230px;padding:5px;">
				
					<div class="easyui-layout" data-options="fit:true">
						<div data-options="region:'center'" style="padding:10px;">
			<form id="ff_create_new_roles" method="post">
					<table width="100%">
						<tr height="40px">
							<td>
								<input name="rolesName" class="easyui-textbox" data-options="label:'角色名称' , 
									validType : 'regexRolesName', labelWidth:100 , width:300 , labelAlign : 'right' , required : true"/>
							</td>
						</tr>
						<tr height="40px">
							<td>
								<input name="rolesEffect" class="easyui-textbox" data-options="label:'角色作用' , 
									labelWidth:100 , width:300 , labelAlign : 'right' , required :true"/>
							</td>
						</tr>
						<tr height="40px">
							<td>
								<input name="rolesDate" value="new Date()" id="create_date"  class="easyui-datebox" data-options="label:'创建日期' , 
									labelWidth:100 , width:300 , labelAlign : 'right' , editable : false"/>
							</td>
						</tr>
						
					</table>
			</form>
						</div>
						<div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
							<a id="grant-save" class="easyui-linkbutton" data-options="iconCls:'icon-ok', plain:true">Ok</a>
							<a id="grant-not" class="easyui-linkbutton" data-options="iconCls:'icon-cancel', plain:true">Cancel</a>
						</div>
				</div>
			</div> 	
	
		<c:forEach items="${functions}" var="f">
			<input type="hidden" value="${f}" class="funs"/>
		</c:forEach>
	<script type="text/javascript">
			$(function(){
				  $("#roles-serach").linkbutton({onClick : function(){
						var start_date = $("#start_date").datebox('getValue');
						var end_date = $("#end_date").datebox('getValue');
						var value = $("#key_value").searchbox('getValue');
						$("#roles_tab").datagrid({url : 'select_grade_where_roles'});
						$("#roles_tab").datagrid('load' , {key : value , startDate : start_date , endDate : end_date});
					}});
					
					$("#roles-show-all").linkbutton({onClick : function(){
						$("#start_date").datebox('setValue' , new Date()+"");
						$("#end_date").datebox('setValue' ,  new Date()+"");
						$("#key_value").searchbox('setValue' , '');
						$("#roles_tab").datagrid('reload' , 'select_all_roles');
					}});
					
				  
				  $("#limit-add").linkbutton({onClick : function(){
						yRolesName = null;
						url = 'insert_roles';
						$("#create-new-limit").window("open");
				  }});
				  $("#grant-not").linkbutton({onClick : function(){
					  $("#ff_create_new_roles").form('reset');
					  $("#create-new-limit").window("close");
					  
				  }});
				  
				  $("#grant-save").linkbutton({onClick : function(){
						$("#ff_create_new_roles").form('submit' , {
							url : url,
							success : function(data){
								var json = eval("("+data+")");
								if(json.error){
									$("#ff_create_new_roles").form("clear");
									$("#roles_tab").datagrid("load");
									$("#create_date").datebox('setValue' , new Date()+"");
									$("#create-new-limit").window("close");
								}else{
									$.messager.alert("操作",json.message);
								} 
							},
							onSubmit : function(data){
								return $(this).form('validate');
							}
						});
					}});
				  
				  $.extend($.fn.validatebox.defaults.rules , {
						regexRolesName : {
							validator : function(value){
								var json = null;
								$.post({
									async : false,
									url : 'regex_roles_is_exist',
									data : {'rolesName' : value , 'yRolesName' : yRolesName},
									success : function(data){
										 json = eval("("+data+")");
									}
								});
								return json.error;
							},
							message :  '该角色名已存在！'
						}
					});
			});
			
			function operationRoles(value , row , index){
					var update = '' , deletes = '' , grantLi ='', grantUser = '' , rolexq = '';
					if(row.rolesName == '系统管理员'){
						if(selectIsFunctions(62)){
							 rolexq ="<button class='ope_style' onclick='roleXq("+index+")'>角色详情</button>";
						}
					}else{
						if(selectIsFunctions(59)){
							 deletes ="<button class='ope_style' onclick='deletes("+index+")'>删除</button>";
						}
						if(selectIsFunctions(60)){
							 grantLi ="<button class='ope_style' onclick='grantLi("+index+")'>授权</button>";
						}
						if(selectIsFunctions(61)){
							 grantUser ="<button class='ope_style' onclick='grantUser("+index+")'>分配用户</button>";
						}
						if(selectIsFunctions(62)){
							 rolexq ="<button class='ope_style' onclick='roleXq("+index+")'>角色详情</button>";
						}
						if(selectIsFunctions(63)){
							 update = "<button class='ope_style' onclick='update("+index+")'>编辑</button>";
						}
					}
				return update + deletes + grantLi + grantUser + rolexq;
			}
			//查找是否有该功能
			function selectIsFunctions(id){
				for (var i = 0; i < $('.funs').length; i++) {
					if($('.funs').eq(i).val() == id){
						 return true;
					}
				}
				return false;
			}
			
			//删除
			
			function deletes(index){
				$('#roles_tab').datagrid('selectRow',index);
				row = $('#roles_tab').datagrid('getSelected'); 
				$.messager.confirm('确认','您确定想要删除角色 '+row.rolesName+' 吗？',function(v){    
				    if (v){    
						$.post("deletes_roles" , {'rolesId' : row.rolesId} , function(data){
							var json = eval('('+data+')');
							if(json.error){
								$("#roles_tab").datagrid("load");
							}else{
								$.messager.alert('操作' , json.eMessage);
							}
						});
				    }    
				}); 
			}
			
			var yRolesName = null;
			var url = null;
			function update(index){
				var row = empMessage(index);
			    yRolesName = row.rolesName;
				url = 'update_roles?rolesId='+row.rolesId;
				$("#ff_create_new_roles").form('load' , row); 
				$("#create-new-limit").window("open");
			}
			
			//授权
			function grantLi(index){
				var row = empMessage(index);
					showAndHide("#tt_grant" , "#tt_grant_tabs" , "#grant_users");
					var row = empMessage(index);
				    var panel=$('#layout-roles-all-s').layout('panel','east');  
						$(panel).panel({
							title:'给  <a style="color:red">' + row.rolesName + '</a> 授权',
						});
					$('#layout-roles-all-s').layout('expand' ,'east');
					 $('#tt_grant_functions').tree({ 
							method : 'get',
						    url:'select_all_functions?rolesId='+row.rolesId,
						    checkbox : true 
					 }); 
					 
					 $("#save_grant_functions").linkbutton({onClick : function(){
						var checkedNodes = $("#tt_grant_functions").tree("getChecked");
						var str = "";
						for (var i = 0; i < checkedNodes.length; i++) {
							str += checkedNodes[i].id + ",";
						}
					
						 $.post("grant_functions" , {"functionsId" : str , "rolesId" : row.rolesId} , function(data){
							var json = eval("("+data+")");
							$.messager.alert("操作 " , json.eMessage);
						}); 
					}});
			}
			
			//分配用户
			function grantUser(index){
				showAndHide("#grant_users" , "#tt_grant" , "#tt_grant_tabs");
				 var row = empMessage(index);
				 var panel=$('#layout-roles-all-s').layout('panel','east');  
					$(panel).panel({
					title:'给  <a style="color:red">' + row.rolesName + '</a> 分配用户',
					width : 220
				});
				$('#layout-roles-all-s').layout('expand' ,'east');
				 $("#grant_user_s").datagrid({url: 'select_grant_user?rolesId='+ row.rolesId});
				 $.get("select_grant_user" , {'rolesId' : row.rolesId} , function(data){
					var json = eval("("+data+")");
					for (var i = 0; i < json.length; i++) {
						if(json[i].frag){
							$("#grant_user_s").datagrid("checkRow" , i);
						}
					}
				 });
				 
				 $("#save_grant_users").linkbutton({onClick : function(){
					var selectTabs = $("#grant_user_s").datagrid("getSelections");
					var str = "";
					for (var i = 0; i < selectTabs.length; i++) {
						str += selectTabs[i].empId + ",";
					}
					$.post("grant_users" , {"empIds" : str , "rolesId" : row.rolesId} , function(data){
						var json = eval("("+data+")");
						$.messager.alert("操作 " , json.eMessage);
					});
				}});
				 
				
			}
			
			//查看角色详情
			function roleXq(index){
				showAndHide("#tt_grant_tabs" , "#tt_grant" , "#grant_users");
				var row = empMessage(index);
				 var panel=$('#layout-roles-all-s').layout('panel','east');  
					$(panel).panel({
					title:'查看 <a style="color:red">' + row.rolesName + '</a> 详情',
					width : 240
				});
				$('#layout-roles-all-s').layout('expand' ,'east');
				$("#roles_message").datagrid({url : 'select_roles_xq?rolesId='+row.rolesId});
				$("#user_message").datagrid({url : 'select_roles_users?rolesId='+row.rolesId});
				$("#functions_message").datagrid({url : 'select_functions_message?rolesId='+row.rolesId});
			}
			
			//获取参数
			function empMessage(index){
				$('#roles_tab').datagrid('selectRow',index);
				var	row = $('#roles_tab').datagrid('getSelected'); 
				return row;
			}
			//隐藏和显示
			function showAndHide(one , two , three){
				$(one).show();
				$(two).hide();
				$(three).hide();
			}
	</script>
</body>
</html> 