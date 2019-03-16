<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="h" uri="http://www.51i-star.com/his" %>
	<link rel="stylesheet" type="text/css" href="<c:url value="/js/easyui/themes/default/easyui.css"/>">   
	<link rel="stylesheet" type="text/css" href="<c:url value="/js/easyui/themes/icon.css"/>"> 
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/tsp/table_height.css"/>"> 
	<script type="text/javascript" src="<c:url value="/js/jquery-3.1.0.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/easyui/jquery.easyui.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/easyui/easyui-lang-zh_CN.js"/>"></script>
</head>
<body>
	<table id="dclass-table" class="easyui-datagrid"
	        data-options="fitColumns:true,singleSelect:true,fit:true,border:false,
	         toolbar : '#dclass_tool' ,
	         url : 'select_all_dclass',
	         method : 'get' , 
	          pagination: true,
             pageSize: 5,
             rownumbers : true ,
             striped : true,
             pageList: [5,10,15, 20]
	        ">   
		    <thead>   
		        <tr>   
		            <th data-options="field:'dclassName',width:10">科室名称 </th>   
		            <th data-options="field:'dclassFuzeName',width:10">科室负责人</th>   
		            <th data-options="field:'dclassCreateDate',width:10 , formatter : date">创建时间</th>   
		            <th data-options="field:'dclassState',width:10">科室状态</th>   
		            <th data-options="field:'dept',width:10 ,
		            formatter: function(value,row,index){
						if (row.dept){
							return row.dept.deptName;
						} else {
							return value;
						}
					}
		            
		            ">所属部门</th>   
		            <th data-options="field:'dclassGrade',width:10">科室等级</th>   
		            <th data-options="field:'dclassAddress',width:15">科室地址 </th>   
		            <th data-options="field:'dclassExplain',width:15">科室说明</th>   
		            <th data-options="field:'dclassRemark',width:15">备注</th>   
		         <!--    <th data-options="field:'code16',width:15 , formatter : operationDClass">操作</th>    -->
		        </tr>   
		    </thead>  
		</table>  
		
		<div id="dclass_tool">
		<h:g id="64">
		     <a id="dclass-add" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true,text:'创建新科室'"></a>
		</h:g>
		     <input id="dclass-name" class="easyui-searchbox" style="width:200px ; height: 20px;" 
					data-options="label : '科室名称' , labelWidth : 55, prompt:'名称' , 
						searcher : function(value , name){
							if(value == null){
								$('#dclass-table').datagrid('reload' , 'select_all_dclass');
							}else{
								$('#dclass-table').datagrid({url : 'select_dclass_where_dclassName'});
								$('#dclass-table').datagrid('load' , {dclassName : value});
							}
						}
					"></input> 
		     <input id="dclass-fuzeName" class="easyui-searchbox" style="width:200px ; height: 20px;" 
					data-options="label : '负责人' , labelWidth : 42, prompt:'负责人' , 
						searcher : function(value , name){
							if(value == null){
								$('#dclass-table').datagrid('reload' , 'select_all_dclass');
							}else{
								$('#dclass-table').datagrid({url : 'select_dclass_where_fuzeName'});
								$('#dclass-table').datagrid('load' , {fuzeName : value});
							}
						}
					"></input> 
	<a style="margin-left: -40px">
			 <input  id="select-all-dept-to-dclass"  class="easyui-combobox" name="deptId"   
				 data-options="valueField:'deptId',textField:'deptName',url:'select_all_dept_to_dclass_select' ,
				  label:'所属部门' , labelWidth:100 ,
				   width:225 , height : 20 , labelAlign : 'right' , method : 'get'  , editable : false" />  
			  <select id="dclass-state" class="easyui-combobox" name="dept" style="width:150px;height: 20px;" data-options="editable : false,label : '状态' , labelWidth : 32">   
			    <option value="全部">全部</option>   
			    <option value="运行">运行</option>   
			    <option value="不运行">不运行</option>   
			 </select> 
			   <select id="dclass-grade" class="easyui-combobox" name="dept" style="width:150px;height: 20px;" data-options="editable : false , label : '级别' , labelWidth : 32">   
			 	<option value="全部">全部</option>
			    <option value="特级">特级</option>   
			    <option value="一级">一级</option>   
			    <option value="二级">二级</option>   
			    <option value="三级">三级</option>   
			 </select> 
			   <a id="dclass-grade-serach" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true,text:'搜索'"></a>
			  <a id="dclass-show-all" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:true,text:'显示所有'"></a>
		</div>
	</a>	
		<div id="create-new-dclass" class="easyui-window" title="创建新科室" data-options="
		collapsible:false,
		minimizable:false,
		maximizable:false,
		modal:true,
		closed: true" 
		style="width:700px;height:270px;padding:5px;">
		
			<div class="easyui-layout" data-options="fit:true">
				<div data-options="region:'center'" style="padding:10px;">
					<form action="" method="post" id="insert-dclass-form">
						<table id="dept-table-add"  width="100%">
							<tr height="40px">
								<td>
								<input class="easyui-textbox" id="dclassName" name="dclassName" 
									data-options=" label:'科室名称' , required : true , validType : 'regexDClassName'
								 , labelWidth:100 , width:300 , labelAlign : 'right'"/>
								</td>
								<td>
									<input id="deptFuzeName" name="dclassFuzeName"  class="easyui-combobox" name="dept"   
   									 data-options="valueField:'empLoginName',
   									 textField:'empLoginName',
   									 url:'select_emp_to_dept' , label:'科室负责人' ,
   									  labelWidth:100 ,  width:300 ,  labelAlign : 'right', method : 'get'
   									  , editable : false , required : true" />  
								</td>
							</tr>
							<tr height="40px">
								<td>
	 								<div style="margin-left: 45px">
		 								科室状态 <input name="dclassState" class="easyui-switchbutton" data-options="checked : true,onText:'运行',offText:'不运行' , width:200">
	 								</div>
								</td>
								<td>
									<input class="easyui-datebox"  name="dclassCreateDate" value="new Date()" data-options="label:'创建日期' , labelWidth:100 , width:300 , labelAlign : 'right' ,  editable : false"/>
								</td>
							</tr>
							
							<tr height="40px">
								<td>
									<input  id="select-all_dept-to-dclass" class="easyui-combobox" name="deptId"   
	   									 data-options="valueField:'deptId',textField:'deptName',url:'select_all_dept_to_dclass' ,
	   									  label:'所属部门' , labelWidth:100 ,required : true ,
	   									   width:300 , labelAlign : 'right' , method : 'get'  , editable : false" />  
								</td>
								<td>
									<input class="easyui-textbox" id="dclassAddress" name="dclassAddress" data-options="label:'科室地址' , labelWidth:100 , width:300 , labelAlign : 'right' , required : true "/>
								</td>
							</tr>
							<tr height="40px">
								<td>
									<select class="easyui-combobox" id="dclassGrade" name="dclassGrade" data-options="label:'科室等级' , labelWidth:100 , width:300 , labelAlign : 'right'  , editable : false">
										<option value="特级">特级</option>   
									    <option value="一级">一级</option>   
									    <option value="二级">二级</option>   
									    <option value="三级">三级</option>   
									</select>
								</td>
								<td>
									<input class="easyui-textbox" id="dclassExplain" name="dclassExplain" data-options="label:'科室说明' , labelWidth:100 , width:300 , labelAlign : 'right' ,required : true "/>
								</td>
							</tr>
							<tr height="40px">
								<td colspan="2">
									<input class="easyui-textbox" id="dclassRemark" name="dclassRemark" data-options="label:'备注' , labelWidth:100 , width:625 , labelAlign : 'right'"/>
								</td>
							</tr>
						</table>
					</form>
				</div>
				<div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
					<a id="dclass-save" class="easyui-linkbutton" data-options="iconCls:'icon-ok', plain:true">保存</a>
					<a id="dclass-not" class="easyui-linkbutton" data-options="iconCls:'icon-cancel', plain:true">取消</a>
				</div>
			</div>
		</div>
		
		
		<script type="text/javascript">
			$(function(){
				
				$("#dclass-add").linkbutton({onClick : function(){
					$("#create-new-dclass").window("open");
				}});
				
				$("#dclass-not").linkbutton({onClick : function(){
					$("#insert-dclass-form").form("reset");
					$("#create-new-dclass").window("close");
				}});
				$("#create-new-dclass").window({onClose : function(){
					$("#insert-dclass-form").form("reset");
				}})
				$("#dclass-save").linkbutton({onClick : function(){
					$("#insert-dclass-form").form("submit" , {
						url : 'insert_dclass' ,
						onSubmit : function(data){
							return $(this).form("validate");
						},
						success : function(data){
							var json = eval("("+data+")");
							if(json.error){
								$("#dclass-table").datagrid("load");
								$("#create-new-dclass").window("close");
							}else{
								$.messager.alert("提示" , json.message);
							}
						}
					});
					
				}});
				
				//验证科室名
				$.extend($.fn.validatebox.defaults.rules , {
					//regexDClassName 自定义验证名
					regexDClassName : {
						validator : function(value){
							var json = null;
							$.post({
								//async 异步请求
								async : false,
								//url 请求路径
								url : 'regex_dclass_name',
								//data 请求参数
								data : {dClassName : value},
								//success请求结果
								success :function(data){
									 json = eval("("+data+")");
								}
							});
							return json.error;
						},
						message : '该科室已存在！'
					}
				});
				
				$("#dclass-show-all").linkbutton({onClick : function(){
					 $("#dclass-name").textbox('setValue' , '');
					 $("#dclass-fuzeName").textbox('setValue' , '');
					$("#select-all-dept-to-dclass").combobox('select' , '全部');
					$("#dclass-state").combobox('select' , '全部');
					$("#dclass-grade").combobox('select' , '全部');
					$('#dclass-table').datagrid('reload' , 'select_all_dclass');
				}});
				$("#dclass-grade-serach").linkbutton({onClick : function(){
					var dclassName = $("#dclass-name").textbox('getValue');
					var dclassFuzeName = $("#dclass-fuzeName").textbox('getValue');
					var dclassDept = $("#select-all-dept-to-dclass").combobox('getValue');
					var dclassState = $("#dclass-state").combobox('getValue');
					var dclassGrade = $("#dclass-grade").combobox('getValue');
					if(dclassDept == ''){
						dclassDept = 0 ;					
					}
					$("#dclass-table").datagrid({url : 'select_dclass_grade_where'});
					$("#dclass-table").datagrid('load' , {dclassName : dclassName
						, dclassFuzeName : dclassFuzeName , dclassDept : dclassDept ,
						dclassState : dclassState , dclassGrade : dclassGrade});
				}});
				
			});
			
			function operationDClass(value , row , index){
				var update =  "<button class='ope_style' onclick='update("+index+")'>编辑</button>";
				var deletes = "<button class='ope_style' onclick='deletes("+index+")'>停止运行</button>";
				return update + deletes;
			}
		</script>
</body>
</html>