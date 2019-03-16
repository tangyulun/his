<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		
 
      		  
				<div data-options="" style="height: 30px; padding: 8px">
					<table width="100%">
						<tr>
							<td>
								<a id="tj-fl" href="#" class="easyui-linkbutton"data-options="">添加分类</a>
							</td>
							<td>
								<a id="tj-jyxm" href="#" class="easyui-linkbutton"data-options="">添加项目</a>
							</td>
							<td>
								<a id="tj-compile" href="#" class="easyui-linkbutton"data-options="">编辑项目</a>
							</td>
							
						
							<!-- 搜索名称 -->
							<td>
								
								<input id="" class="easyui-searchbox" style="width:200px ; height: 20px;" 
					data-options=" prompt:'名称'  , 
					searcher : function( value , name){
						if(value == null){
							$('#jianyanid').datagrid('reload' , 'select_jianyan_right');
						}else{
							$('#jianyanid').datagrid({url : 'select_jianyanname_where'});
							$('#jianyanid').datagrid('load' , {jianyanName : value});
						}
					}"></input>
							<a id="tj-Selectall" href="#" class="easyui-linkbutton"data-options="" style="width:80px">显示所有</a>
							<!-- 确定按钮 -->
								<a id="tijiantianjia-queding" href="#" class="easyui-linkbutton"data-options="" style="margin-left: 200px;width:50px">确定</a>
							</td>
					 </tr>
					</table>
				</div>
				
				<!-- 选择检验 规则旁边的子类父类 -->
				<div data-options="region:'west',title:'收费项目分类结构',collapsible:false"
					style="width: 180px;height:89%;border: 1px solid #66cccc;float:left;">
					<ul id="jy-type-ul" class="easyui-tree" data-options="method:'get', url : 'select_jiayan_type' ">
							
					</ul>
				</div>

			<div data-options="region:'right'" style="height: 89%;border: 1px solid #66cccc;">
				<table id="jianyanid" class="easyui-datagrid"
						data-options="fit : true,
						border:		false,
						fitColumns:	true,
						striped:	true,
						method	:	'get',
						url	:  		'select_jianyan_right',
						singleSelect	:	true,
						pagination	:	true,
						pageSize	:	5,
						pageList	:	[5,10,15,20],
						rownumbers	:	true">
					<thead style="margin-top: -20px;">
						<tr>
							<th data-options="field:'jianyanId',width:15,align:'left'">检验项目编号</th>
							<th data-options="field:'jianyanName',width:15,align:'left'">检验项目名称</th>
							<th data-options="field:'jianyanTypeId',width:10,align:'left' , 
							formatter(value , row , index){
								if(row.jianyantype != null){
									return row.jianyantype.text;
								}
								return value;
							}
							">分类名称</th>
							<th data-options="field:'price4',width:10,align:'left'">检验方法</th>
							<th data-options="field:'price5',width:10,align:'left'">检验备注</th>
						</tr>
					</thead>
				</table>
			</div>
		
		
		
		<!-- 添加分类 -->
		<div id="win-tjfl" class="easyui-window" title="添加分类设置" style="width:300px;height:150px" data-options="
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
		 				<form id="insert-tj-name" method="post">
		 					<div style="padding:25px 5px 15px 5px;">
		 						<input id="jianyanTypeName" name="jianyanTypeName" class="easyui-textbox" data-options="label:'分类名称'
		 						,width:240,required : true, validType : 'regexKeshiclassName'
		 						,labelAlign:'center'" style="margin: 10px">
		 					</div>
		 				</form>
		 			</td>
		 		</tr>
		 		<tr>
		 			<td>	
						<a id="tjfl-qd" class="easyui-linkbutton" data-options="" style="width:80px;margin-left: 30px;">确定</a>
					</td>
					<td>
						<a id="tjfl-qx" class="easyui-linkbutton" data-options="" style="width: 80px;margin-left: 40px;">取消</a>
					</td>
		 	   </tr>
		 	</div>
		 </div>
		 
		 <!-- 选择添加检验项目 -->
		 <div id="win-tjjyxm" class="easyui-window" title="添加检验项目" data-options="
			model : true ,
		 	closed:true,
		 	minimizable:false,
			maximizable:false,
			collapsible:false,
		 	resizable:false,
		 	modal:true"
			style="width:450px;height:430px;padding:5px;">
			<div class="easyui-layout" data-options="fit:true">
				<div data-options="region:'center'" style="padding:10px;">
					<form id="insert-tj-jyxm" method="post">
						<table id="dept-table-add"  width="100%">
							<!-- 生成只能读不能改的编号 -->
							<tr height="50px">
								<td><input id="tj_jianyan" name="jianyanId" class="easyui-textbox"   readonly="readonly" data-options="label:'检验项目编号' , labelWidth:100 , width:300 , labelAlign : 'right'"/></td>
							</tr>
							<tr>
								<td>
									<input name="jianyanName" id="tjjyxm-name" class="easyui-textbox" data-options="label:'检验项目名称' , labelWidth:100 , width:300 , labelAlign : 'right'"/>
								</td>
							</tr>
							<tr>
							<td>
	 								<input id="finan-fenlei" class="easyui-combobox" name="jianyanTypeId"  data-options="label:'分类名' , labelWidth:100 , width:300 , labelAlign : 'right' , 
	 												editable : false,
	 												url:'select_jianyan_fenlei',
													method:'get',
													valueField:'id',
													textField:'text',
													editable:false,
													">
								</td>
								
							</tr>
							<tr>
								<td>
	 								<select name="empId" class="easyui-combobox" data-options="label:'创建人' , labelWidth:100 , width:300 , labelAlign : 'right' , editable : false">
										   <option value="${empMessage.empId}">${empMessage.empLoginName}</option>   
									 
									</select>
								</td>
							</tr>
							<tr>
								<td>
									<input name="jianyanCreateDate" value="new Date()" id="tjjyxm-Creationdate" class="easyui-datebox" data-options="label:'创建日期' ,value:'date', labelWidth:100 , width:300 , labelAlign : 'right',editable:false"/>
								</td>
							</tr>
							<tr>
								<td colspan="2">
									<input id="tjjyxm-Remarks" class="easyui-textbox" data-options="label:'备注' , labelWidth:100 , width:300 ,height:120, labelAlign : 'right',multiline:true,
									icons:[
									{
										iconCls:'icon-clear',
										handler:function(e){$(e.data.target).textbox('clear');
										}
									}
									]"/>
								</td>
							</tr>
					</table>
				</form>
				<div>
						<a id="tjjyxm-qd" class="easyui-linkbutton" data-options="" style="width:80px;margin-left: 100px;">确定</a>
						<a id="tjjyxm-qx" class="easyui-linkbutton" data-options="" style="width: 80px;margin-left: 40px;">取消</a>
				</div>
			 </div>
		</div>
	
</div>
<script type="text/javascript">
	$(function(){
		$("#t-t-t").linkbutton({onClick : function(){
			$("#win-tj").window("open");
		}});
		
		$("#tj-fl").linkbutton({onClick : function(){
			$("#win-tjfl").window("open");
			
		}});
		
		$("#tj-jyxm").linkbutton({onClick : function(){
			$("#finan-fenlei").combobox('reload');
			$("#win-tjjyxm").window("open");
		}});
		
		$("#operation-open").linkbutton({onClick : function(){
			$("#select-query-bkjl").window("open");
		}});
		//添加分类取消按钮
		$("#tjfl-qx").linkbutton({onClick :function(){
			$("#win-tjfl").window('close');
		}});
		//添加检验项目取消按钮
		$("#tjjyxm-qx").linkbutton({onClick :function(){
		$("#win-tjjyxm").window('close');
		}})
		
		/* 生成添加体检号 */
		$.get("tj_jianyan",function(data){
			
			$('#tj_jianyan').textbox('setValue',data.substring(1,data.length - 1));
		});
		/* 添加码名 */
		$("#tjfl-qd").linkbutton({onClick : function(){
			$("#insert-tj-name").form("submit" , {
				url : 'add_jianyan_type' ,
				onSubmit : function(data){
					return $(this).form("validate");
				},
				success : function(data){
					var json = eval("("+data+")");
					if(json.error){
						$("#jy-type-ul").tree('reload');
						$("#win-tjfl").window('close');
						
						$("#jianyanTypeName").textbox('setValue',"");
					}else{
						$.messager.alert("提示",json.message);
					}
				}
			});
		}});
		
		/* 添加检验项目 */
		$("#tjjyxm-qd").linkbutton({onClick	:	function(){
			$("#insert-tj-jyxm").form("submit" , {
				url : 'add_jianyan_tj' ,
				onSubmit : function(data){
					return $(this).form("validate");
				},
				success : function(data){
					var json = eval("("+data+")");
					if(json.error){
						$("#jianyanid").datagrid('reload');
						$("#win-tjjyxm").window('close');
						$("#tjjyxm-name").textbox('setValue',"");
						$("#tjjyxm-Remarks").textbox('setValue',"");
						$("#tjjyxm-Creationdate").textbox('setValue',"");
						$.get("tj_jianyan",function(data){
							
							$('#tj_jianyan').textbox('setValue',data.substring(1,data.length - 1));
						});
					}else{
						$.messager.alert("提示",json.message);
					}
				}
			});
		}});
		
		 /* 验证检验名 */
		$.extend($.fn.validatebox.defaults.rules 	, 	{
				//自定义验证名
				regexKeshiclassName	: {
						validator	:	function(value){
								var json  =  null;
								$.post({
									//async	异步请求
									async :false,
									//url 请求路径
									url	:  'regex_keshiclass_name',
									//data 请求参数
									data : {jianyanTypeName	:	value},
									//success请求结果
									success	:	function(data){
										json =	eval("("+data+")");
									}
								});
								return json.error;
						},
						message	:	'该检验分类已存在!'
				}
		}); 
		
		/* 点击左边ul，刷新右边数据表格 */
		$("#jy-type-ul").tree({onSelect:function(node){
			var nodes = node.id;//获取id
			  if (!$("#jy-type-ul").tree('getSelected').children){
				$("#jianyanid").datagrid({url:"qh_jianyan"});
				$("#jianyanid").datagrid('load',{shoushuTypeId	:nodes});
			}
		}});
		
		/* 编辑检验项目 */
		$("#tj-compile").linkbutton({onClick:function(){
			var jy =$("#jianyanid").datagrid('getSelected');
			if(jy==null){
				$.messager.alert("提示","你选择的这行为空！");
				return;
			}
			$("#insert-tj-jyxm").form('load',jy);
			$("#win-tjjyxm").window({title:"编辑检验项目"});
			$("#win-tjjyxm").window('open');
			$('#finan-fenlei').combobox('setValue', jy.finanTypeVo.text);
			url = "update_jianyan?jianyanId="+ jy.tj_jianyan;
		}});
	
		/* 编辑左边分类ul */
		$("#jy-type-ul").tree({onDblClick : function(node){
			$(this).tree('beginEdit', node.target);//开始编辑一个节点
		}});
		
		//在编辑节点之后触发然后刷新
		$("#jy-type-ul").tree({onAfterEdit : function(node){
			var id = node.id;
			var text = node.text;
			$.getJSON('update_jianyan_ul',{jianyanTypeId:id,jianyanTypeName:text},function(data){
				 if(!$("#jy-type-ul").tree('getSelected').children){
						$("#jianyanid").datagrid({url : 'qh_jianyan'});
						$("#jianyanid").datagrid('load' , {jianyanTypeId : id});//请求参数
						$("#jy-type-ul").tree('reload');
					}  
			});
		}});
		
		
	});
	</script>
</body>
</html>