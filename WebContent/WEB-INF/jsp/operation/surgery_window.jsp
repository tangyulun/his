<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>      		  
				<div data-options="region:'north'" style="height: 30px; padding: 8px">
					<table width="100%" id="sugery-shuaxin">
						<tr>
							<td>
									<a id="surgery-addfl" href="#" class="easyui-linkbutton"data-options="iconCls:'icon-add',plain:true">添加手术分类</a>
									<a id="surgery-addxm" href="#" class="easyui-linkbutton"data-options="iconCls:'icon-add',plain:true">添加手术项目</a>
									<a id="surgery-bjxm" href="#" class="easyui-linkbutton"data-options="iconCls:'icon-cut',plain:true">编辑手术项目</a>
							</td>
							<td> 
							<input id="ss" class="easyui-searchbox" style="width:200px ; height: 23px;" 
							data-options="labelWidth : 45, prompt:'名称',
							searcher : function( value , name){
								if(value == null){
									$('#sugery-table-right').datagrid('reload' , 'select_sugery_right');
								  }else{
									$('#sugery-table-right').datagrid({url : 'select_shoushuname_where'});
									$('#sugery-table-right').datagrid('load' , {shoushuName : value});
								}
								}"></input> 
								<a id="JianyanMess-showall" href="#" 
								class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:true"
									style="width: 90px">显示所有</a>
							<a id="bg-qd" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok',plain:true" style="width: 80px">确定</a>
							</td>
						</tr>
					</table>
				</div>
				<!-- 左边的树形文件夹 -->
				<div data-options="region:'west',title:'手术项目分类结构',collapsible:false"
					style="width: 180px;height:89%;border: 1px solid #66cccc;float:left;">
					<ul id="ss-type-ul" class="easyui-tree" data-options="
					method:'get', 
					url : 'select_shoushu_type'">
					</ul>
	
				</div>
			<!-- 右边的表格 -->
			<div data-options="region:'center' , border:false" style="height:89%;border: 1px solid #66cccc;">
				<table id="sugery-table-right" class="easyui-datagrid" 
					data-options="fit : true,
						fitColumns:	true,
						border:false,
						striped:	true,
						method	:	'get',
						url	:  		'select_sugery_right',
						singleSelect	:	true,
						pagination	:	true,
						pageSize	:	5,
						pageList	:	[5,10,15,20],
						rownumbers	:	true" >
					<thead style="margin-top: -20px;">
						<tr>
						
							<th data-options="field:'shoushuId',width:10,align:'center'">手术编号</th>
							<th data-options="field:'shoushuName',width:10,align:'center'">手术名称</th>
							<th data-options="field:'shoushuTypeId',width:20,align:'center',
								formatter(value , row , index){
							
									if(row.shoushuTypeBean != null){
										return row.shoushuTypeBean.text;
								}
								return value;
							}">分类名称</th>
							<th data-options="field:'dclass_id',width:10,align:'center',
							formatter(value , row , index){
								
									if(row.dclass != null){
										return row.dclass.dclassName;
								}
								return value;
							}">科室</th>
							<th data-options="field:'price5',width:10,align:'center',
							formatter(value , row , index){
								
									if(row.emp != null){
										return row.emp.empName;
								}
								return value;
							}">创建人</th>
							<th data-options="field:'shoushuExplain',width:20,align:'center'">备注</th>
						</tr>
					</thead>
				</table>
			</div>
			
			<!-- 添加手术分类 -->
		<div id="win-surgeryfl" class="easyui-window" title="添加手术分类" style="width:300px;height:150px" data-options="
		 model : true ,
		 closed:true,
		 minimizable:false,
		 maximizable:false,
		 collapsible:false,
		 resizable:false,
		 modal:true">
		 	<div>
		 		<tr>
		 			<td>
		 				<form id="insert-sstj-name" method="post">
		 					<div style="padding:25px 5px 15px 5px;">
		 						<input id="shoushuTypeName" name="shoushuTypeName" class="easyui-textbox" data-options="label:'分类名称'
		 						,width:240,required : true, validType : 'sugeryKeshiclassName'
		 						,labelAlign:'center'" style="margin: 10px">
		 					</div>
		 				</form>
		 			</td>
		 		</tr>
		 		<tr>
		 			<td>	
						<a id="tjssfl-qd" class="easyui-linkbutton" data-options="iconCls:'icon-save'" style="width:80px;margin-left: 30px;">确定</a>
					</td>
					<td>
						<a id="tjssfl-qx" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" style="width: 80px;margin-left: 40px;">取消</a>
					</td>
		 	   </tr>
		 	</div>
		 </div>
		<!--  添加手术项目 -->
	<div id="win-tjssxmsb" class="easyui-window"
		title="新建手术项目" style="width: 570px; height: 350px"
		data-options="modal:true,minimizable:false,maximizable:false,collapsible:false,closed:true">
		<div class="easyui-layout" data-options="fit:true">
			<div data-options="region:'south',border:false" style="height: 45px; padding: 5px">
				<table width="100%">
					<tr>
						<td  align="right">
							<a id="tj-ssxm-qd" href="#" class="easyui-linkbutton"
								data-options="iconCls:'icon-save'" style="width: 80px">确定</a> 
							<a id="tj-ssxm-qx" href="#"
								class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" style="width: 80px">关闭</a>
						</td>
					</tr>
				</table>
			</div> 
			<!-- 里面的内容 -->
			<div data-options="region:'center',border:false" style="height: 340px">
				<form method="post" id="insert-ssxmss" style="margin: 8px">
					<table>
						 <tr height="32">
						<!--  生成只读不能改的编号 -->
							<td><input id="tj_sugeryxm" name="shoushuId" class="easyui-textbox" readonly="readonly"
								data-options="label:'手术项目编号*',width:240,labelAlign:'right'
							"/>
							</td>
							<td><input name="shoushuName" class="easyui-textbox" id="finan-name"
								data-options="label:'手术项目名称*',width:240,labelAlign:'right',required : true,value:'',
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
							<td>
								<select id="shoushutype" class="easyui-combobox" name="shoushutype" 
								data-options="label:'手术类型*',width:240,labelAlign:'right',
												valueField:'id',
												textField:'text',
												editable:false
												"> 
											<option>刮骨神功 </option>
											<option>九阴针效 </option>
											<option>无敌汗蒸 </option>
								</select>
							</td>
						</tr>
						<tr  height="32">
							<td>
								<input id="sugery-fenlei" class="easyui-combobox" name="shoushuTypeId" 
								data-options="label:'手术分类*',width:240,labelAlign:'right',
												url:'select_sugery_fenlei',
												method:'get',
												valueField:'id',
												textField:'text',
												editable:false,
												required:true
												">  
							</td>
							<td>
								<input id="finan-fenlei" class="easyui-combobox" name="dclassId" 
								data-options="label:'科室*',width:240,labelAlign:'right',
												url:'where_select_dclass?deptId=2',
												method:'get',
												valueField:'dclassId',
												textField:'dclassName',
												editable:false,
												required:true
												">  
							</td>
						</tr>
						<tr  height="45">
							<td colspan="2"><input name="shoushuExplain" class="easyui-textbox" id="finan-bz"
								data-options="label:'备注',width:485,height:120,labelAlign:'right',multiline:true,required : true,value:'无',
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
			<script type="text/javascript">
				$(function(){
					/* 点击添加分类进入添加分类 */
					$("#surgery-addfl").linkbutton({onClick : function(){
						$("#win-surgeryfl").window("open");
					}});
					$("#surgery-addxm").linkbutton({onClick : function(){
						$("#win-tjssxmsb").window("open");
						$("#sugery-fenlei").combobox('reload');
					}});
					/* 关闭添加分类取消按钮 */
					$("#tjssfl-qx").linkbutton({onClick : function(){
						$("#win-surgeryfl").window("close");
					}});
					/* 添加手术项目取消按钮 */
					$("#tj-ssxm-qx").linkbutton({onClick : function(){
						$("#win-tjssxmsb").window("close");
					}});
					/* 生成添加手术号 */
					$.get("tj_sugeryxm",function(data){
						$('#tj_sugeryxm').textbox('setValue',data.substring(1,data.length - 1));
					});
					/* 添加手术分类 */
					 $("#tjssfl-qd").linkbutton({onClick : function(){
							
 						$("#insert-sstj-name").form("submit" , {
							url : 'add_shoushu_type' ,
							onSubmit : function(data){
								return $(this).form("validate");
							},
							success : function(data){
								var json = eval("("+data+")");
								if(json.error){
									$("#ss-type-ul").tree('reload');
									$("#win-surgeryfl").window('close');
									$("#shoushuTypeName").textbox('setValue',"");
								}else{
									$.messager.alert("提示",json.message);
								}
							}
						});
					}}); 
					 /* 添加手术项目 */
						$("#tj-ssxm-qd").linkbutton({onClick : function(){
							$("#insert-ssxmss").form("submit" , {
								url : 'add_shoushu_tj' ,
								onSubmit : function(data){
									return $(this).form("validate");
								},
								success : function(data){
									var json = eval("("+data+")");
									if(json.error){
										$("#sugery-table-right").datagrid('reload');
										$("#win-tjssxmsb").window('close');
										$("#finan-name").textbox('setValue',"");
										$("#finan-bz").textbox('setValue',"");
										$("#finan-fenlei").textbox('setValue',"");
										$.get("tj_sugeryxm",function(data){
											$('#tj_sugeryxm').textbox('setValue',data.substring(1,data.length - 1));
										}); 
									}else{
										$.messager.alert("提示",json.message);
									}
								}
							});
						}});
						
					 /* 验证手术名 */
						$.extend($.fn.validatebox.defaults.rules 	, 	{
								//自定义验证名
								sugeryKeshiclassName	: {
										validator	:	function(value){
												var json  =  null;
												$.post({
													//async	异步请求
													async :false,
													//url 请求路径
													url	:  'sugery_ssfl_name',
													//data 请求参数
													data : {shoushuTypeName	:	value},
													//success请求结果
													success	:	function(data){
													json =	eval("("+data+")");
												}
											});
										return json.error;
									},
									message	:	'该手术分类已存在!'
								}
							}); 
						
						/* 编辑手术项目 */
						$("#surgery-bjxm").linkbutton({onClick:function(){
							var ss =$("#sugery-table-right").datagrid('getSelected');
							if(ss==null){
								$.messager.alert("提示","你选择的这行为空！");
								return;
							}
							$("#insert-ssxmss").form('load',ss);
							$("#win-tjssxmsb").window({title:"编辑手术项目"});
							$("#win-tjssxmsb").window('open');
							$('#sugery-fenlei').combobox('setValue', ss.finanTypeVo.text);
							url = "update_shoushu?shoushuId="+ ss.tj_sugeryxm;
						}});
						
						/* 点击左边ul，刷新右边数据表格 */
						$("#ss-type-ul").tree({onSelect:function(node){
							var nodes = node.id;//获取id
							  if (!$("#ss-type-ul").tree('getSelected').children){
								$("#sugery-table-right").datagrid({url:"qh_shoushu"});
								$("#sugery-table-right").datagrid('load',{shoushuTypeId	:nodes});
							}
						}});
						
						/* 编辑左边分类ul */
						$("#ss-type-ul").tree({onDblClick : function(node){
							$(this).tree('beginEdit', node.target);//开始编辑一个节点
						}});
						
						//在编辑节点之后触发然后刷新
						$("#ss-type-ul").tree({onAfterEdit : function(node){
							var id = node.id;
							var text = node.text;
							$.getJSON('update_shoushu_ul',{shoushuTypeId:id,shoushuTypeName:text},function(data){
								 if(!$("#ss-type-ul").tree('getSelected').children){
										$("#sugery-table-right").datagrid({url : "qh_shoushu"});
										$("#sugery-table-right").datagrid('load' , {shoushuTypeId : id});//请求参数
										$("#ss-type-ul").tree('reload');
									}  
							});
						}});
						 $("#JianyanMess-showall").linkbutton({onClick:function(){
								$('#sugery-table-right').datagrid('reload','select_sugery_right');
							}}); 
						
			});
			</script>
</body>
</html>