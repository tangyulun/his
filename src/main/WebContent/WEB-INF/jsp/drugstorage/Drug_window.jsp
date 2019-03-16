<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<div class="easyui-layout" data-options="fit:true">
	 		<div data-options="region:'north',split:true" style="height:50px;padding:8px">
	 			<a class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" style="width:80px;margin-left:20px" href="#" id="add_yp">新建药品</a>
	 			<a class="easyui-linkbutton" style="width:80px" href="#" data-options="iconCls:'icon-edit',plain:true" id="update_drug_bainji">编辑药品</a>
	 			<a class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" name="drugTypeName" style="width:90px" href="#" id="add_drugType">新增分类</a>
	 			<a>
	 				<input class="easyui-searchbox" style="width:240px"
	 					data-options="
	 						searcher : function(value,name){
		 						if(!value){
		 							$('#drug-table-t').datagrid('reload','to_find_drug_byfenye');
		 							$('drug_tree').tree('reload');
		 							return;
		 						}
		 						$('#drug-table-t').datagrid({url : 'to_mohufind_drug_byName'});
		 						$('#drug-table-t').datagrid('load', {drugName : value});
		 					},label : '药品名称',labelAlign:'right'
	 					">
	 			</a>
	 			<a class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:true" style="width:80px;margin-left:30px" href="#" id="findAllDrug">查询所有</a>
	 			<a class="easyui-linkbutton" data-options="iconCls:'icon-ok',plain:true" style="width:80px;margin-left:10px" href="#" id="drug_queding">确定</a>
	 		</div>
	 		<div data-options="region:'west',split:true" style="width:200px">
	 			<ul id="drug_tree" class="easyui-tree" data-options="method:'get',url:'to_select_drugType_tree'"></ul>
	 		</div>
	 		<div data-options="region:'center',split:true">
	 			<table class="easyui-datagrid"  id="drug-table-t"
	 			data-options="fit:true,rownumbers:true,
	 						singleSelect:true,
		 					fitColumns:true,
		 					url:'to_select_drug_fenye',
		 					method:'get',
			                pagination: true,
			                pageSize: 15,
			                pageList: [15, 30, 45, 60]" style="width:100%">
 					<thead>
 						<tr>
 							<th data-options="field:'drugId',width:70,align:'center'">药品编号</th>
 							<th data-options="field:'drugName',width:100,align:'center'">药品名称</th>
 							<th data-options="field:'drugJx',width:70,align:'center'">剂型</th>
 							<th data-options="field:'unit',width:70,align:'center' , 
 								formatter(value , row ,index){
 									return row.unit == null ? null : row.unit.text;
 								}
 							">单位</th>
 							<th data-options="field:'drugYf',width:100,align:'center'">默认药房</th>
 							<th data-options="field:'drugType',width:70,align:'center' ,
 								formatter(value , row ,index){
 									return row.drugType == null ? null : row.drugType.text;
 								}
 								">分类名称</th>
 						</tr>
 					</thead>
 				</table>
	 		</div>
	 	</div>
	 	
	 	
	 	
	 	<!-- 新建药品 -->
	 <div id="add_yaoping" class="easyui-window" title="新建药品"  style="width:650px;height:500px"
	 	 data-options="modal:true,collapsible:false,minimizable:false,maximizable:false,closed:true"> 
	 	 <div class="easyui-layout" data-options="fit:true">
	 	 	<div data-options="region:'center',split:true">
	 	 		<form action="" method="post" id="add_drug">
	 	 			<table width="100%" style="border-spacing:10px;" id="add_drug_tab">
	 	 				<tr>
	 	 					<td><input class="easyui-textbox" id="drug_Id" name="drugId" readonly="readonly"
	 	 					 data-options="required:true,label:'药品编号',width:240,labelAlign:'right'"></td>
	 	 					 
	 	 					<td><input class="easyui-textbox" name="drugName"
	 	 					 data-options="required:true,label:'药品名称',width:240,labelAlign:'right'"></td>
	 	 				</tr>
	 	 				<tr>
	 	 					<td>
	 	 						<input id="DTypeId" name="DTypeId" class="easyui-combobox" data-options="
	 	 							editable:false,
									label:'分类',
									required:true,
									width:240,
									method:'post',
									labelAlign:'right',
									valueField:'id',
									textField:'text',
									url:'to_select_drugType'">
	 	 					</td>
	 	 					
	 	 					<td><input class="easyui-textbox" name="drugBzdate" 
	 	 					data-options="required:true,label:'保质天数',width:240,labelAlign:'right'"></td>
	 	 				</tr>
	 	 				<tr>
	 	 					<td>
	 	 						<select id="" class="easyui-combobox" name="drugYf" 
	 	 							data-options="required:true,editable:false,label:'默认药房',width:240,labelAlign:'right'" >   
								    <option value="中药房">中药房</option>   
								    <option value="西药房">西药房</option>   
								</select> 
	 	 					</td>
	 	 					<td>
	 	 						<select id="" class="easyui-combobox" name="drugLx"
	 	 						 data-options="editable:false,label:'药品类型',width:240,labelAlign:'right'" >   
								    <option value="口服">口服</option>   
								    <option value="煮汤">煮汤</option>   
								</select> 
	 	 					</td>
	 	 				</tr>
	 	 				<tr>
	 	 					<td><input class="easyui-textbox" name="drugSccj" data-options="required:true,label:'生产厂家',width:240,labelAlign:'right'"></td>
	 	 					<td>
	 	 						<select name="drugShr" class="easyui-combobox"
	 	 						 data-options="editable:false,label:'创建人' , width:240 , labelAlign : 'right' , editable : false">
									<option  value="${empMessage.empLoginName}">${empMessage.empLoginName}</option>
								</select>
	 	 					</td>
	 	 				</tr>
	 	 				<tr>
	 	 					<td><input class="easyui-textbox" id="yaokuKucunTop" name="yaokuKucunTop"
	 	 					 data-options="required:true,label:'药品药库上限',width:240,labelAlign:'right',validType:'drug_num',value:'1000'"></td>
	 	 					 
	 	 					<td><input class="easyui-textbox" id="yaokuKucunBottom" name="yaokuKucunBottom"
	 	 					 data-options="required:true,label:'药品药库下限',width:240,labelAlign:'right',validType:'drug_num',value:'100'"></td>
	 	 				</tr>
	 	 				<tr>
	 	 					<td><input class="easyui-textbox" id="yaofangKucunTop" name="sx"
	 	 					 data-options="required:true,label:'药品药房上限',width:240,labelAlign:'right',validType:'drug_num',value:'1000'"></td>
	 	 					 
	 	 					<td><input class="easyui-textbox" id="yaofangKucunBottom" name="xx"
	 	 					 data-options="required:true,label:'药品药房下限',width:240,labelAlign:'right',validType:'drug_num',value:'100'"></td>
	 	 				</tr>
	 	 				<tr>
	 	 					<td><input class="easyui-textbox" name="drugPfprice"
	 	 					 data-options="required:true,label:'批发单价',width:240,labelAlign:'right',validType:'drug_jiage'"></td>
	 	 					 
	 	 					<td><input class="easyui-textbox" name="drugLsprice"
	 	 					 data-options="required:true,label:'零售单价',width:240,labelAlign:'right',validType:'drug_jiage'"></td>
	 	 				</tr>
	 	 				<tr>
	 	 					<td>
	 	 						<select id="" class="easyui-combobox" name="drugJx"
	 	 						 data-options="editable:false,label:'剂型',width:240,labelAlign:'right'" >   
								    <option value="片剂">片剂</option>   
								    <option value="胶囊">胶囊</option>  
								    <option value="口服液">口服液</option>   
								    <option value="注射剂">注射剂</option> 
								    <option value="丸剂">丸剂</option>   
								    <option value="药剂">药剂</option>
								</select>
	 	 					</td>
	 	 					<td>
	 	 						<input class="easyui-combobox" id="Unita" name="Unita" data-options="
	 	 							editable:false,
	 	 							label:'药品单位',
	 	 							required:true,
	 	 							width:240,
	 	 							method:'post',
	 	 							labelAlign:'right',
	 	 							valueField:'id',
	 	 							textField:'text',
	 	 							url:'to_select_allunitName'">
	 	 						 <a id="ypdw" href="#" class="easyui-linkbutton"data-options="" style="width:30px;height:22px">…</a>
	 	 					</td>
	 	 				</tr>
	 	 				<tr>
	 	 					<td colspan="2">
	 	 						<input class="easyui-textbox" name="drugBz"
	 	 						 data-options="required:true,label:'备注',width:500,labelAlign:'right',multiline:true,height:100">
	 	 					</td>
	 	 				</tr>
	 	 			</table>
	 	 		</form>
	 	 	</div>
	 	 	<div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
				<a id="add_drug_ok" class="easyui-linkbutton" data-options="iconCls:'icon-ok', plain:true">Ok</a>
				<a id="grant-not" class="easyui-linkbutton"
					 data-options="iconCls:'icon-cancel', plain:true,
					 onClick : function(){
					 	$('#add_yaoping').window('close');
					 	$('#add_drug').form('reset');
					 	$.get('to_find_drugId',function(data){
							$('#drug_Id').textbox('setValue',data.substring(1,data.length-1));
						});
					 }">Cancel</a>
			</div>
	 	 </div>
	 </div>
	 
	 
	  <!-- 新增药品 -->
	 <div id="add_drug_a" class="easyui-window" title="新增药品分类"  style="width:300px;height:150px"
	 	 data-options="modal:true,collapsible:false,minimizable:false,maximizable:false,closed:true">
	 	 <div data-options="region:'center',split:true" style="margin-top:20px">
	 	 	<form action="" method="post" id="add_drug_b">
		 		<input name="drugTypeName" id="add_drug_name" class="easyui-textbox" 
		 		data-options="label:'分类名',
		 			width:250,
		 			labelAlign:'right',
		 			required:true,
		 			validType:'regexDrugName'">
	 	 	</form>
	 	 </div>
	 	<div data-options="region:'south',split:true" style="margin-left:80px">
			<a id="add_drug_queding" class="easyui-linkbutton" data-options="iconCls:'icon-ok', plain:true" style="width: 78px; margin-top: 20px;">确定</a>
			<a id="grant-not"  data-options="iconCls:'icon-cancel', plain:true" class="easyui-linkbutton" style="width: 78px; margin-top: 20px;">取消</a>
		</div>
	 </div>
	 
	 <!-- 药品单位管理 -->
	 <div id="find_unit" class="easyui-window" title="药品单位" style="width:400px;height:350px"
	 	data-options="modal : true , collapsible : false ,minimizable : false , maximizable : false , closed : true">
	 	 <div class="easyui-layout" data-options="fit:true">
		 	<div data-options="region:'center',split:true" style="height:300px;">
		 		<div style="margin-top:20px">
		 			<ul id="unit_tree" class="easyui-tree"  data-options="method:'get',url:'to_select_allunit'"></ul>
		 		</div>
		 	</div>
		 	<div data-options="region:'north',split:true" style="height : 50px">
		 		<div style="margin-top:10px;padding-left:20px">
			 		<a class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" id="add_unit_xinjian" style="width:80px">新建</a>
			 		<a class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" id="update_unit_bianji" style="width:80px;">编辑</a>
			 		<a class="easyui-linkbutton" data-options="iconCls:'icon-ok',plain:true" id="nuit_guanli_queding" style="width:80px;">确定</a>
			 		<a class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" id="del_unit_quexiao" style="width:80px;">关闭</a>
		 		</div>
		 	</div>
		</div>
	 </div>
	 
	 <!-- 新增药品单位 -->
	 <div id="add_unit_a" class="easyui-window" title="新增药品单位"  style="width:300px;height:150px"
	 	 data-options="modal:true,collapsible:false,minimizable:false,maximizable:false,closed:true">
	 	 <div data-options="region:'center',split:true" style="margin-top:20px">
	 	 	<form action="" method="post" id="add_unit_b">
		 		<input name="unitsName" id="add_unit_name" class="easyui-textbox" 
		 		data-options="label:'分类名',
		 			width:250,
		 			labelAlign:'right',
		 			required:true,
		 			validType:'regexUnitName'">
	 	 	</form>
	 	 </div>
	 	<div data-options="region:'south',split:true" style="margin-left:80px">
			<a id="add_unit_queding" class="easyui-linkbutton" style="width: 78px; margin-top: 20px;" data-options="iconCls:'icon-ok',plain:true">确定</a>
			<a id="" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true,
				onClick : function(){
					$('#add_unit_a').window('close');
					$('#add_unit_b').form('reset');
				}
			" style="width: 78px; margin-top: 20px;">取消</a>
		</div>
		</div>
		
		
		
		<script type="text/javascript">
			var row=null;
			var url = url;
			
			//自动生成药品id
			$.get("to_find_drugId",function(data){
				$("#drug_Id").textbox('setValue',data.substring(1,data.length-1));
			});
			
			$("#ypdw").linkbutton({onClick : function(){
				$("#find_unit").window('open');
			}});
			
			// 添加药品分类
			$("#add_drugType").linkbutton({onClick : function(){
				$("#add_drug_a").window('open');
			}});
			//点击确定按钮时触发
			$("#add_drug_queding").linkbutton({onClick:function(){
				$("#add_drug_b").form("submit",{//form表单提交
					url : 'to_insert_drugType' ,//路径
					onSubmit : function(data){
						return $(this).form("validate");
					},
					success : function(data){
						 var json = eval("("+data+")");
						if(json.error){
							$("#add_drug_name").textbox('setValue' , '');//成功后将文本框中的值清除
							$("#add_drug_a").window("close");//关闭窗口
							$("#drug_tree").tree('reload');//刷新树
						}else{
							$.messager.alert("提示",json.eMessage);
						} 
					}
				});
			}});
			
			
			//验证药品分类名
			$.extend($.fn.validatebox.defaults.rules,{
				//regexSupplierName 自定义验证名
				regexDrugName : {
					validator : function(value){
						var json =  null;
						$.post({
							//async 异常请求
							async : false,
							//请求路径
							url : 'to_select_drugType_Name',
							//请求参数
							data : {drugTypeName : value},
							//请求结果
							success : function(data){
								json = eval("("+data+")");
							}
						});
						return json.error;
					},
					message : '该药品分类已存在！'
				}
			});
			
			
			//点击取消时关闭窗口
			$("#del_unit_quexiao").linkbutton({onClick : function(){
				$("#Unita").combobox('reload');//刷新下拉列表
				$("#find_unit").window('close');//关闭窗口
			}});
			
			//添加单位
			$("#add_unit_xinjian").linkbutton({onClick : function(){
				$("#add_unit_a").window('open');//打开窗口
				url = "to_insert_unitName";//新增药品单位的路径
			}});
			
			//编辑药品单位
			var unitId=0;
			var unitsName=null;
			$("#unit_tree").tree({onSelect : function(node){
				unitId=node.id;
				unitsName=node.text;
			}});
			
			//修改药品单位
			$("#update_unit_bianji").linkbutton({onClick : function(){
				if(unitId==0){
					$.messager.alert("提示","请先选择一行");
				}else{
					$("#add_unit_name").textbox('setValue',unitsName);
					$("#add_unit_a").window('open');
					url = "to_update_unitName?unitId="+unitId;
				}
			}});

			//选择单位将单位传到药品页面中
			$("#nuit_guanli_queding").linkbutton({onClick : function(){
				if(unitId == 0){
					$.messager.alert("提示","请先选择一行");
				}else{
					$("#Unita").textbox("setValue" , unitsName);
					$("#find_unit").window("close");
				}
			}});
			
			//对药品单位进行新增和修改操作
			$("#add_unit_queding").linkbutton({onClick : function(){
				$("#add_unit_b").form("submit",{
					url : url ,
					onSubmit : function(data){
						return $(this).form("validate");
					},
					success : function(data){
						 var json = eval("("+data+")");
						if(json.error){
							$("#Unita").combobox('reload');
							$("#add_unit_name").textbox('setValue' , '');
							$("#add_unit_a").window("close");
							$("#unit_tree").tree('reload');
						}else{
							$.messager.alert("提示",json.eMessage);
						} 
					}
				});
			}});
			
			//验证药品单位
			$.extend($.fn.validatebox.defaults.rules,{
				//regexSupplierName 自定义验证名
				regexUnitName : {
					validator : function(value){
						var json =  null;
						$.post({
							//async 异常请求
							async : false,
							//请求路径
							url : 'to_find_unitName',
							//请求参数
							data : {unitsName : value},
							//请求结果
							success : function(data){
								json = eval("("+data+")");
							}
						});
						return json.error;
					},
					message : '该药品分类已存在！'
				}
			});
			
			//新增药品
			$("#add_yp").linkbutton({onClick:function(){
				url = "to_insert_drug";
				$('#DTypeId').combobox('reload');
				$("#add_yaoping").window('open');
			}});
			
			$("#update_drug_bainji").linkbutton({onClick : function(){
				var row = $("#drug-table-t").datagrid("getSelected");
				if(row != null){
					url = "to_update_drugall";
					$('#DTypeId').combobox('reload');
					$("#add_yaoping").window('setTitle' , '修改药品');
					$("#add_yaoping").window('open');
					$("#add_drug").form("load",row);
					$("#Unita").combobox('setValue' , row.unit.id);
					$("#DTypeId").combobox('setValue',row.drugType.id);
					$("#yaokuKucunBottom").textbox('setValue',row.yaokuKucun.yaokuKucunBottom);
					$("#yaokuKucunTop").textbox('setValue',row.yaokuKucun.yaokuKucunTop);
					$("#yaofangKucunBottom").textbox("setValue" , row.yaokuKucun.yaofangKucunBottom);
					$("#yaofangKucunTop").textbox("setValue" , row.yaokuKucun.yaofangKucunTop);
				}else{
					$.messager.alert("提示","请先选择一行");
				}
			}});
			
			$("#add_drug_ok").linkbutton({onClick:function(){
				$("#add_drug").form("submit",{
					url : url,
					onSubmit : function(data){
						return $(this).form("validate");
					},
					success : function(data){
						var json = eval("("+data+")");
						if(json.error){ 
							$("#add_yaoping").window("close");
							$("#drug-table-t").datagrid('reload');
							$("#add_drug").form('reset');
							$.get("to_find_drugId",function(data){
								$("#drug_Id").textbox('setValue',data.substring(1,data.length-1));
							});
						}else{
							$.messager.alert("提示",json.eMessage);
						} 
					}
				});
			}});
			
			//根据药品分类查询药品信息
			$("#drug_tree").tree({onSelect : function(node){
				var nodes = node.id;//获取id
				if(!$("#drug_tree").tree('getSelected').children){
					$("#drug-table-t").datagrid({url : 'to_select_drug_byTypeId'});
					$("#drug-table-t").datagrid('load',{DTypeId : nodes})//请求参数
				}
			}});
			
			//点击查询所有按钮显示所有药品信息
			$("#findAllDrug").linkbutton({onClick : function(){
				$("#drug-table-t").datagrid('reload','to_find_drug_byfenye');
				$("#drug_tree").tree('reload');
			}});
			
			//根据药品分类id修改药品分类名
			$("#drug_tree").tree({onDblClick : function(node){
				//双击药品分类时触发，开始编辑一个分类
				$(this).tree('beginEdit',node.target);
			}});
			//在编辑节点后触发
			$("#drug_tree").tree({onAfterEdit : function(node){
				var nodes = node.id//获取id
				var text=node.text;
				$.getJSON('to_update_drugType_byID',{drugTypeId : nodes , drugTypeName : text},function(data){
					$("#drug-table-t").datagrid({url : 'to_select_drug_byTypeId'});
					$("#drug-table-t").datagrid('load',{DTypeId : nodes})//请求参数
					$("#drug_tree").tree('reload');
				})
			}});
			
			//验证是否是数字
			$.extend($.fn.textbox.defaults.rules, { 
				drug_num: { 
		                validator : function(value) { 
		                    var drug_num = /^[0-9]*$/; 
		                    return drug_num.test(value); 
		                }, 
		                message : '请输入数字' 
		            } 
		        });
			//验证是否是数字或小数
			$.extend($.fn.textbox.defaults.rules, { 
				drug_jiage: { 
		                validator : function(value) { 
		                    var drug_jiage = /^[1-9]\d*\,\d*|[1-9]\d*$/; 
		                    return drug_jiage.test(value); 
		                }, 
		                message : '请输入数字或小数' 
		            } 
		        });
			
			$("#yaokuKucunBottom").textbox({onChange : function(newValue , oldValue){
				var topnumyk = $("#yaokuKucunTop").textbox("getValue");
				if(newValue >= topnumyk){
					$("#yaokuKucunBottom").textbox("setValue" , 100);
				}
			}});
			
			$("#yaofangKucunBottom").textbox({onChange : function(newValue , oldValue){
				var topnumyf = $("#yaofangKucunTop").textbox("getValue");
				if(newValue >= topnumyf){
					$("#yaofangKucunBottom").textbox('setValue' , 100);
				}
			}});
		</script>
</body>
</html>