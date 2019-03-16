<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>收费记录的选择收费项目</title>
</head>
<body>

<script type="text/javascript">
			function addFenleiForm(){
				$("#edit-fenlei").form('submit',{
					onSubmit : function(param){
						return $(this).form('validate');
					},
					success : function(data){
						var json = eval("("+data+")");
						if(json.error){
							/* $("#financial-type-name").textbox('setValue',''); */
							$("#financialName-window-fenlei").window('close');
							$("#edit-fenlei").form('reset');
							$("#financial-ul").tree('reload');
						}else{
							$.messager.alert("提示",json.eMessage);
						}
					}
				});
			}

			$("#regist-financialhistory-fenlei").linkbutton({onClick : function(){
				$("#regist-window-fenlei").window('open');
			}});
			
			//打开新增收费项目的页面
			$("#add-inancialistory").linkbutton({onClick : function(){
				url = "add_financial";
				$("#inancialistory-win-window-add-manager").window({title : '新建收费项目'});
				$("#inancialistory-win-window-add-manager").window('open');
				$('#finan-fenlei').combobox('reload','query_fianaical_fenlei');
				//收费项目编号
				$.get("query_finanicalid",function(data){
					$("#finanical-xmbianhao").textbox('setValue',data.substring(1 , data.length-1));
				}); 
			}});
			
			$("#add-shoufei-guanbi").linkbutton({onClick : function(){
				$("#inancialistory-win-window-add-manager").window('close');
			}});
			
			//新增收费项目
			 $("#financial-save-btn").linkbutton({onClick : function(){
					$("#addfinancial-ff").form({
						url :url,
						onSubmit: function(param){
			                return $(this).form('validate');
			            }, 
			            success: function(datas){
			            	var json = eval("("+datas+")");
			            	if(json.error){
			            		 $("#inancialistory-win-window-add-manager").window('close'); 
								 $("#addfinancial-ff").form('reset');
			            		 $("#financial-tb").datagrid('reload');
			            	}else{
			            		$.messager.alert("提示",json.eMessage);
			            	} 
						}
					}).submit();
				}});
			
			//编辑收费项目
			$("#editor-financial").linkbutton({onClick : function(){
				var row = $("#financial-tb").datagrid('getSelected');
				if(row == null){
					$.messager.alert("提示","您选择的这行为空！");
					return;
				}
				$("#addfinancial-ff").form('load',row);
				$("#inancialistory-win-window-add-manager").window({title : '编辑收费项目'});
				$("#inancialistory-win-window-add-manager").window('open');
				$("#finan-fenlei").combobox('reload','query_fianaical_fenlei');
				$('#finan-fenlei').combobox('setValue', row.finanTypeVo.id);
				url = "update_financial";
			}});
			
			//点击左边ul，刷新右边数据表格
			$("#financial-ul").tree({onSelect : function(node){
				var nodes = node.id;//获取id
			 if(!$("#financial-ul").tree('getSelected').children){
					$("#financial-tb").datagrid({url : 'query_financial_all_where'});
					$("#financial-tb").datagrid('load' , {financialTypeId : nodes});//请求参数
				}  
			}});
			
			//左边表格显示所有
			$("#financial-showall").linkbutton({onClick : function(){
				$("#financialName-searcher").searchbox('setValue','');
				$("#financial-tb").datagrid('reload','query_financial_all');
				$("#financial-ul").tree('reload');//重新tree载入数据
			}});
			
			$("#add-financialTypeName").linkbutton({onClick : function(){
				$("#financialName-window-fenlei").window('open');
			}});
			
			//新增分类
			$("#add-shoufei-save").linkbutton({onClick : function(){
				addFenleiForm();
			}});
			
			
			/* $("#add-shoufei-save").keydown(function(e){
				if(e.keyCode==13){
					addFenleiForm();
				}
			}); */
			
			//编辑左边，在用户双击一个节点的时候触发
			$("#financial-ul").tree({onDblClick : function(node){
				$(this).tree('beginEdit', node.target);//开始编辑一个节点
			}});
			
			//在编辑节点之后触发。
			$("#financial-ul").tree({onAfterEdit : function(node){
				var id = node.id;
				var text = node.text;
				$.getJSON('update_financialTypeName',{financialTypeId:id,financialTypeName:text},function(data){
					 if(!$("#financial-ul").tree('getSelected').children){
							$("#financial-tb").datagrid({url : 'query_financial_all_where'});
							$("#financial-tb").datagrid('load' , {financialTypeId : id});//请求参数
							$("#financial-ul").tree('reload');
						}  
				});
			}});
			
			//验证分类名是否唯一
			$.extend($.fn.textbox.defaults.rules,{
				regexFinanCialTypeName :{
					validator :  function(value){
						var json = null;
						$.post({
							//async 异步请求
							async : false,
							//url 请求路劲
							url : 'regex_fianTypeName',
							//data请求参数
							data : {finanTypeName : value},
							//success 请求结果
							success : function(data){
								json = eval("("+data+")");
							}
						});
						return json.error;
					},
					message : '该分类名已存在！'
				}
			});
			
		
</script>
	<div class="easyui-layout" data-options="fit:true,border:false">
			<div data-options="region:'west',collapsible:false"
				style="width: 180px;">
				<ul id="financial-ul" class="easyui-tree" data-options="method:'get',url:'query_financial_type'">
				
				</ul>
			</div>

			<div data-options="region:'center'" style="" >
				<table id="financial-tb" class="easyui-datagrid financial-tb"
					data-options="fit : true,
						pagination:true,
						rownumbers:true,
						pageSize:10,
						url:'query_financial_all',
						method:'get',
						border:false,
						singleSelect : true,
						toolbar:'.financial-select-all',
						pageList:[10,20,30,40]">
					<thead>
						<tr>
							<th data-options="field:'financialId',width:90,align:'left'">收费编号</th>
							<th data-options="field:'financialName',width:110,align:'left'">收费项目名称</th>
							<th data-options="field:'code',width:80,align:'left' , formatter : function(value , row , index){
								if(row.finanTypeVo){
									return row.finanTypeVo.text;
								}
								return value;
							}">分类</th>
							<th data-options="field:'financialType',width:90,align:'left'">收费类型</th>
							<th data-options="field:'financialPrice',width:70,align:'left'">收费单价</th>
							<th data-options="field:'financialExplain',width:150,align:'left'">收费说明</th>
						</tr>
					</thead>
				</table>
				
				<div id="financial-select-all" class="financial-select-all">
					<a id="add-financialTypeName" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" style="width: 90px">新建分类</a>
					<a id="add-inancialistory" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" style="width: 90px">新建项目</a> 
					<a id="editor-financial" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" style="width: 60px">编辑</a>
					<input class="easyui-searchbox"  style="width: 200px" data-options="prompt:'收费项目名称',
						 searcher : function(value , name){
						 $('#financial-ul').tree('reload');
			 			if(value==null){
			 				$('#financial-tb').datagrid('reload','query_financial_all');
			 			}else{
			 				$('#financial-tb').datagrid({url : 'query_financialName_where'});
			 				$('#financial-tb').datagrid('load',{financialName : value});
			 			}
			 		} 
					"/> 
					<a id="financial-showall" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:true" style="width: 90px">显示所有</a>
					<a id="financial-queding" href="#" class="easyui-linkbutton  financial-queding" data-options="iconCls:'icon-ok',plain:true" style="width: 60px">确定</a>
				</div>
			</div>
		</div>
		
	
	<div id="financialName-window-fenlei" class="easyui-window" style="width: 300px;height: 150px"
	 data-options="title:'新建分类',modal:true,minimizable:false,maximizable:false,collapsible:false,closed:true">
		<form action="add_financialTypeName" method="post" id="edit-fenlei">
			<table align="center">
				<tr height="50">
					<td>
						<input id="financial-type-name" class="easyui-textbox" name="financialTypeName" data-options="label:'分类名',width:260,required:true,validType:'regexFinanCialTypeName',labelWidth:60"/>
					</td>
				</tr>
				<tr  height="50">
					<td align="center">
						<a id="add-shoufei-save"   class="easyui-linkbutton" data-options="" style="width: 60px">确定</a>
					</td>
				</tr>
			</table>
		</form>
	</div>
	
	<!-- 新建收费项目 -->
	<div id="inancialistory-win-window-add-manager" class="easyui-window"
		title="新建收费项目" style="width: 540px; height: 400px"	
		data-options="modal:true,minimizable:false,maximizable:false,collapsible:false,closed:true">
		<div class="easyui-layout" data-options="fit:true">
			<div data-options="region:'south',border:false" style="height: 45px; padding: 5px">
				<table width="100%">
					<tr>
						<td  align="right">
							<a id="financial-save-btn" href="#" class="easyui-linkbutton"
								data-options="iconCls:'icon-save',plain:true" style="width: 80px">保存</a> 
							<a id="add-shoufei-guanbi" href="#"
								class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" style="width: 80px">关闭</a>
						</td>
					</tr>
				</table>
			</div>

			<div data-options="region:'center',border:false" style="height: 340px">
				<form action="" method="post" id="addfinancial-ff" style="margin: 8px">
					<table>
						 <tr height="32">
							<td><input name="financialId" class="easyui-textbox" readonly="readonly"  id="finanical-xmbianhao"
								data-options="label:'收费项目编号*',width:240,labelAlign:'right',required : true
							"/>
							</td>
							<td><input name="financialType" class="easyui-textbox" id="finan-type" 
								data-options="label:'收费类型',width:240,labelAlign:'right',required : true,value:'单项',editable:false
								"/>
							</td>
						</tr>
						 <tr  height="32">
							<td><input name="financialName" class="easyui-textbox" id="finan-name"
								data-options="label:'收费项目名称*',width:240,labelAlign:'right',required : true,value:'化验血',
								icons:[
								{
									iconCls:'icon-clear',
									handler:function(e){$(e.data.target).textbox('clear');
									}
								}
							]"></td>
							<td>
								<input id="finan-fenlei" class="easyui-combobox" name="financialTypeId" 
								data-options="label:'分类*',width:240,labelAlign:'right',
												url:'query_fianaical_fenlei',
												method:'get',
												valueField:'id',
												textField:'text',
												editable:false,
												required : true
												">  
							</td>
						</tr>
						<tr  height="32">
							<td><input name="financialPrice" class="easyui-textbox" id="finan-price"
								data-options="label:'单价',width:240,labelAlign:'right',required : true,value:'1',
								icons:[
								{
									iconCls:'icon-clear',
									handler:function(e){$(e.data.target).textbox('clear');
									}
								}
							]">
							</td>
							<td><input name="financialMoney" class="easyui-textbox" id="finan-money"
								data-options="label:'金额',width:240,labelAlign:'right',required : true,value:'400.0',
								icons:[
								{
									iconCls:'icon-clear',
									handler:function(e){$(e.data.target).textbox('clear');
									}
								}
							]"></td>
						</tr>
						
						 <tr  height="32">
							<td><select id="" class="easyui-combobox" name="empId" 
								data-options="label:'创建人',width:240,labelAlign:'right',required : true" >   
								    <option value="${empMessage.empId}">${empMessage.empLoginName}</option>   
								</select> 
							</td>
							<td><input name="financialCreatorDate" class="easyui-datebox" value="new Date()"
								data-options="label:'创建日期',width:240,labelAlign:'right',required : true"></td> 
						</tr>
						<tr  height="32">
							<td colspan="2"><input name="financialZhekoujia" class="easyui-textbox" id="finan-zhekoujia"
								data-options="label:'折扣价',width:240,labelAlign:'right',required : true,value:'360.0',
								icons:[
								{
									iconCls:'icon-clear',
									handler:function(e){$(e.data.target).textbox('clear');
									}
								}
								]">
							</td>
						</tr> 
						<tr  height="45">
							<td colspan="2"><input name="financialExplain" class="easyui-textbox" id="finan-shoufei"
								data-options="label:'收费说明',width:485,height:120,labelAlign:'right',multiline:true,required : true,value:'无',
								icons:[
								{
									iconCls:'icon-clear',
									handler:function(e){$(e.data.target).textbox('clear');
									}
								}
								]">
							</td>
						</tr> 
					</table>
				</form>
			</div>
		</div>
	</div>
</body>
</html>