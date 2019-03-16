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
		<table class="easyui-datagrid" id="dept-table"
	        data-options="fitColumns:true,singleSelect:true,fit:true,border:false,
	         method : 'get' , 
	         url : 'select_all_dept',
             singleSelect : true,
	         pagination: true,
             pageSize: 5,
             striped : true,
             pageList: [5,10,15, 20],
             rownumbers : true ,
	         toolbar : '#roles_tool'
	        ">   
		    <thead>   
		        <tr>   
		            <th data-options="field:'deptName',width:10">部门名称 </th>   
		            <th data-options="field:'deptShenheName',width:10">审核人</th>   
		            <th data-options="field:'deptPizhunName',width:10">批准人</th>   
		            <th data-options="field:'deptFuzeName',width:10">负责人</th>   
		            <th data-options="field:'deptState',width:10">状态</th>   
		            <th data-options="field:'deptGrade',width:10">等级</th>   
		            <th data-options="field:'deptCreateDate',width:10 , formatter : date">创建日期 </th>   
		            <th data-options="field:'deptAddress',width:15">部门地址</th>   
		            <th data-options="field:'deptExplain',width:15">部门说明</th>   
		            <th data-options="field:'deptRemark',width:15">备注</th>   
		           <!--  <th data-options="field:'code16' , width : 20 , formatter : operationDept">操作</th> -->
		        </tr>   
		    </thead>   
		</table>  
		<div id="roles_tool">
		<h:g id="61">
		     <a id="dept-add" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true,text:'创建新部门'"></a>
		</h:g>
		     <input id="deptName-select" class="easyui-searchbox" style="width:200px ; height: 20px;" 
					data-options="label : '部门名称' , labelWidth : 55, prompt:'名称'  , 
					searcher : function( value , name){
						if(value == null){
							$('#dept-table').datagrid('reload' , 'select_all_dept');
						}else{
							$('#dept-table').datagrid({url : 'select_dept_where'});
							$('#dept-table').datagrid('load' , {deptName : value});
						}
					}">
		
		     <input id="deptFuzeName-select" class="easyui-searchbox" style="width:200px ; height: 20px;" 
					data-options="label : '负责人' , labelWidth : 42, prompt:'负责人' , 
					 searcher : function(value , name){
					 	if(value == null){
					 		$('#dept-table').datagrid('reload' , 'select_all_dept');
					 	}else{
					 		$('#dept-table').datagrid({url : 'select_deptFuzeName_where'});
					 		$('#dept-table').datagrid('load' , {deptFuzeName : value});
					 	}
					 }
					"></input> 
			  <select id="dept-state" class="easyui-combobox" name="dept" style="width:150px;height: 20px;" data-options="label : '状态' , labelWidth : 32 , editable : false">   
			    <option value="全部">全部</option>   
			    <option value="运行">运行</option>   
			    <option value="不运行">不运行</option>   
			 </select> 
			   <select id="dept-grade" class="easyui-combobox" name="dept" style="width:150px;height: 20px;" data-options="label : '级别' , labelWidth : 32 , editable : false">   
				    <option value="全部">全部</option>   
				    <option value="特级">特级</option>   
				    <option value="一级">一级</option>   
				    <option value="二级">二级</option>   
				    <option value="三级">三级</option>   
			 </select> 
			   <a id="dept-serach" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true,text:'搜索'"></a>
			  <a id="dept-show-all" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:true,text:'显示所有'"></a>
		</div>
		
		<div id="create-new-dept" class="easyui-window" title="创建新部门" data-options="
		collapsible:false,
		minimizable:false,
		maximizable:false,
		modal:true,
		closed: true" 
		style="width:700px;height:330px;padding:5px;">
			<div class="easyui-layout" data-options="fit:true">
		<form method="post" id="create_new_dept">
				<div data-options="region:'center'" style="padding:10px;">
					<table id="dept-table-add"  width="100%">
						<tr height="50px">
							<td><input name="deptName" id="deptName"  class="easyui-textbox" data-options="label:'部门名称' , labelWidth:100 , width:300 , labelAlign : 'right',required : true , validType : 'regexDeptName'"/></td>
							<td>
								<input id="deptFuzeName" name="deptFuzeName"  class="easyui-combobox" name="dept"   
   									 data-options="valueField:'empLoginName',
   									 textField:'empLoginName',
   									 url:'select_emp_to_dept' , label:'部门负责人' ,
   									  labelWidth:100 ,  width:300 ,  labelAlign : 'right', method : 'get'
   									  , editable : false , required : true" />  
							</td>
						</tr>
						<tr>
							<td>
								<select name="deptShenheName" class="easyui-combobox" data-options="label:'创建审核人' , labelWidth:100 , width:300 , labelAlign : 'right', editable : false">
									<option value="${empMessage.empLoginName}">${empMessage.empLoginName}</option>
								</select>
							</td>
							<td>
								<input name="deptShenheDate" value="new Date()" class="easyui-datebox" data-options="label:'创建审核日期' , labelWidth:100 , width:300 , labelAlign : 'right',editable : false"/>
							</td>
						</tr>
						<tr>
							<td>
								<select name="deptPizhunName" class="easyui-combobox" data-options="label:'创建批准人' , labelWidth:100 , width:300 , labelAlign : 'right' , editable : false">
									<option  value="${empMessage.empLoginName}">${empMessage.empLoginName}</option>
								</select>
							</td>
							<td>
								<input name="deptPizhunDate" value="new Date()" class="easyui-datebox" data-options="label:'创建批准日期' , labelWidth:100 , width:300 , labelAlign : 'right' , editable : false"/>
							</td>
						</tr>
						<tr>
							<td>
 								<div style="margin-left: 45px">
	 								部门状态 <input name="deptState" class="easyui-switchbutton" data-options="checked : true,onText:'运行',offText:'不运行' , width:200">
 								</div>
							</td>
							<td>
								<input name="deptCreateDate" value="new Date()" class="easyui-datebox" data-options="label:'部门创建日期' , labelWidth:100 , width:300 , labelAlign : 'right' , editable : false"/>
							</td>
						</tr>
						<tr>
							<td>
 								<select name="deptGrade" class="easyui-combobox" data-options="label:'部门等级' , labelWidth:100 , width:300 , labelAlign : 'right' , editable : false">
									<option value="特级">特级</option>   
								    <option value="一级">一级</option>   
								    <option value="二级">二级</option>   
								    <option value="三级">三级</option>   
								</select>
							</td>
							<td>
								<input id="deptAddress" name="deptAddress" class="easyui-textbox" data-options="required : true , label:'部门地址' , labelWidth:100 , width:300 , labelAlign : 'right'"/>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<input name="deptExplain" id="deptExplain" class="easyui-textbox" data-options="required : true ,label:'部门说明' , labelWidth:100 , width:625 , labelAlign : 'right'"/>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<input name="deptRemark" id="deptRemark" class="easyui-textbox" data-options="label:'备注' , labelWidth:100 , width:625 , labelAlign : 'right'"/>
							</td>
						</tr>
					</table>
				</div>
	</form>
				<div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
					<a id="dept-save" class="easyui-linkbutton" data-options="iconCls:'icon-ok', plain:true">保存</a>
					<a id="dept-not" class="easyui-linkbutton" data-options="iconCls:'icon-cancel', plain:true">取消</a>
				</div>
			</div>
		</div>
		
		
		<script type="text/javascript">
			$(function(){
				//验证部门名
				$.extend($.fn.validatebox.defaults.rules , {
					regexDeptName : {
						validator : function(value){
							var json = null;
							$.post({
								async : false,
								url : 'regex_dept_name',
								data : {'deptName' : value},
								success : function(data){
									 json = eval("("+data+")");
								}
							});
							return json.error;
						},
						message :  '该部门已存在！'
					}
				});
				$("#dept-add").linkbutton({onClick : function(){
					$("#create-new-dept").window("open");
				}});
				$("#dept-not").linkbutton({onClick : function(){
					$("#create_new_dept").form("reset");
					$("#create-new-dept").window("close");
				}});
				$("#create-new-dept").window({onClose : function(){
					$("#create_new_dept").form("reset");
				}});
				$("#dept-save").linkbutton({onClick : function(){
					$("#create_new_dept").form("submit" , {
						url : 'insert_new_dept' ,
						onSubmit : function(data){
							return $(this).form("validate");
						},
						success : function(data){
							 var json = eval("("+data+")");
							if(json.error){
								$("#create_new_dept").form("reset");
								$("#dept-table").datagrid("load");
								$("#create-new-dept").window("close");
							}else{
								$.messager.alert("提示",json.eMessage);
							} 
						}
					});
				}});
				
				//显示所有
				$("#dept-show-all").linkbutton({onClick : function(){
					$("#deptName-select").searchbox('setValue' , '');
					$("#deptFuzeName-select").searchbox('setValue' , '');
					$("#dept-state").combobox('select' , '全部');
					$("#dept-grade").combobox('select' , '全部');
					$('#dept-table').datagrid('reload' , 'select_all_dept');
				}});
				
				//高级查询
				$("#dept-serach").linkbutton({onClick : function(){
					var deptName = $("#deptName-select").searchbox('getValue');
					var deptFuzeName = $("#deptFuzeName-select").searchbox('getValue');
					var state = $("#dept-state").combobox('getValue');
					var grade = $("#dept-grade").combobox('getValue');
					$("#dept-table").datagrid({url : 'select_grade_where'});
					$("#dept-table").datagrid('load' ,  {deptName : deptName , deptFuzeName : deptFuzeName
						, state : state , grade : grade});
				}});
				
				//编辑
				$("#dept-uddate").linkbutton({onClick : function(){
					//获取选择的的行数据
					var row = $("#dept-table").datagrid('getSelected');
					if(row == null){
						$.messager.alert('操作' , '请至少选择一行数据进行编辑!');
						return ;
					}
					
				}});
			});
			
			function operationDept(value , row , index){
				var update =  "<button class='ope_style' onclick='update("+index+")'>编辑</button>";
				var deletes = "<button class='ope_style' onclick='deletes("+index+")'>停止运行</button>";
				return update + deletes;
			}
		</script>
</body>
</html>