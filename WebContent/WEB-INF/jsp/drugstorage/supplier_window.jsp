<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="easyui-layout" data-options="fit:true">
	 		<div data-options="region:'north',split:true" style="height:50px;padding:8px">
	 			<a class="easyui-linkbutton add_gongyingshangfenlei" data-options="iconCls:'icon-add',plain:true" style="width:110px;margin-left:10px" href="#"  id="add_gongyingshangfenlei">供应商分类</a>
	 			<a class="easyui-linkbutton add_gys" data-options="iconCls:'icon-add',plain:true" style="width:110px;" href="#" id="add_gys">新建供应商</a>
	 			<a class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" style="width:110px" href="#" id="update_supplier">编辑供应商</a>
	 			<a style="margin-left:10px">
	 				<input class="easyui-searchbox" style="width:230px;" 
	 					data-options="searcher : function(value,name){
	 						if(!value){
	 							$('#tab').datagrid('reload','to_findAll_supplier');
	 							$('#gong_lei').tree('reload');
	 							return;
	 						}
	 						$('#tab').datagrid({url : 'to_findMohu_Supplier'});
	 						$('#tab').datagrid('load',{supplierName : value});
	 					},label:'供应商名称',labelAlign:'right'"/>
	 			</a>
	 			<a class="easyui-linkbutton"  data-options="iconCls:'icon-reload',plain:true" style="width:80px;margin-left:30px" href="#" id="find_all_supplier">查询所有</a>
	 			<a class="easyui-linkbutton queding_to_one"  data-options="iconCls:'icon-add',plain:true" id="queding_to_one" style="width:80px;margin-left:10px" href="#" id="huoquSupplier">确定</a>
	 		</div>
	 		<div data-options="region:'west',split:true" style="width:200px">
	 			<ul class="easyui-tree" id="gong_lei" data-options="method:'get',url:'to_find_supplierType'"></ul>
	 		</div>
	 		<div data-options="region:'center',split:true">
	 			<table class="easyui-datagrid tab" width="100%" id="tab" border="1"
		 			data-options="fit:true,
		 					rownumbers:true,
	 						singleSelect:true,
		 					fitColumns:true,
		 					url:'to_findAll_supplier',
		 					method:'get',rownumbers:true,
			                pagination: true,
			                pageSize: 15,
			                pageList: [15, 30, 45, 60]">
 					<thead>
 						<tr>
 							<th data-options="field:'supplierId',width:50">编号</th>
 							<th data-options="field:'supplierName',width:120">供应商简称</th>
 							<th data-options="field:'supplierLxr',width:50">联系人</th>
 							<th data-options="field:'supplierPhone',width:75">联系方式</th>
 							<th data-options="field:'supplierShfs',width:55">送货方式</th>
 							<th data-options="field:'supplierFkfs',width:80">付款方式</th>
 							<th data-options="field:'supplierAddress',width:130">送货地址</th>
 						</tr>
 					</thead>
 				</table>
	 		</div>
	 	</div>
	 	
	 <!-- 供应商分类设置 -->
	 <div id="gongyingshangfenlei" class="easyui-window gongyingshangfenlei" title="供应商分类设置"  style="width:400px;height:350px"
	 	 data-options="modal:true,collapsible:false,minimizable:false,maximizable:false,closed:true">
	 	 <div class="easyui-layout" data-options="fit:true">
		 	<div data-options="region:'center',split:true" style="height:300px;">
		 		<div style="margin-top:20px">
		 			<ul class="easyui-tree" name="SName" id="tree-t"  data-options="method:'get',url:'to_find_supplierType'"></ul>
		 		</div>
		 	</div>
		 	<div data-options="region:'north',split:true" style="height : 50px">
		 		<div style="margin-top:10px;padding-left:20px">
			 		<a class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" id="add_gysfl" style="width:80px">新建</a>
			 		<a class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" id="bianji_gysfl" style="width:80px;">编辑</a>
			 		<a class="easyui-linkbutton" data-options="iconCls:'icon-ok',plain:true" style="width:80px;">确定</a>
			 		<a class="easyui-linkbutton" data-options="onClick : function(){
			 			$('#gongyingshangfenlei').window('close');
			 		},iconCls:'icon-cancel',plain:true" style="width:80px;">关闭</a>
		 		</div>
		 	</div>
		</div>
	 </div>
	 
	  <!-- 新建供应商 -->
	 <div id="add_gonyinshang" class="easyui-window add_gonyinshang" title="新建供应商"  style="width:650px;height:530px"
	 	 data-options="modal:true,collapsible:false,minimizable:false,maximizable:false,closed:true">
	 	<div class="easyui-layout" data-options="fit:true">
	 		<div data-options="region:'center',split:true">
	 			<form action="" method="get" id="add_supplier">
	 				<table width="100%" style="border-spacing:10px;">
	 					<tr>
	 						<td><input id="supplierId" class="easyui-textbox" readonly="readonly"
	 						 name="supplierId" data-options="label:'供应商编号',width:240,labelAlign:'right',required:true"></td>
	 	 					<td><input id="supplierName" class="easyui-textbox" name="supplierName"
	 	 					 data-options="required:true,label:'供应商名称',width:240,labelAlign:'right'"></td>
	 					</tr>
	 					<tr>
	 						<td><input id="supplierJc" class="easyui-textbox" name="supplierJc"
	 						 data-options="required:true,label:'供应商简称',width:240,labelAlign:'right'"></td>
	 						 <td>
	 							<select id="supplierIssh" class="easyui-combobox" name="supplierIssh"
	 							 data-options="editable:false,label:'是否送货',width:240,labelAlign:'right'"  style="width:200px;">   
								    <option value="1">是</option>   
								    <option value="0">否</option>   
								</select>  
	 						</td>
	 					</tr>
	 					 <tr>
	 						<td>
	 							<select id="supplierJzfs" class="easyui-combobox" name="supplierJzfs"
	 							 data-options="editable:false,label:'结账方式',width:240,labelAlign:'right'"  style="width:200px;">   
								    <option value="月结">月结</option>   
								    <option value="现结">现结</option>   
								</select>  
	 						</td>
	 						<td>
	 							<select id="supplierShfs" class="easyui-combobox" name="supplierShfs" 
	 							data-options="editable:false,label:'运送方式',width:240,labelAlign:'right'"  style="width:200px;">   
								    <option value="手提">手提</option>   
								    <option value="陆运">陆运</option>   
								    <option value="空运">空运</option>   
								</select>  
	 						</td>
	 					</tr> 
	 					 <tr>
	 						<td>
	 							<select id="supplierGsxz" class="easyui-combobox" name="supplierGsxz" 
	 							data-options="editable:false,label:'公司性质',width:240,labelAlign:'right'"  style="width:200px;">   
								    <option value="国企">国企</option>   
								    <option value="外企">外企</option> 
								    <option value="私企">私企</option>     
								</select>  
	 						</td>
	 						<td>
	 							<select name="supplierBurman" id="supplierBurman" class="easyui-combobox"
		 	 						 data-options="editable:false,label:'采购员' , width:240 , labelAlign : 'right' , editable : false">
										<option  value="${empMessage.empId}">${empMessage.empLoginName}</option>
								</select>
	 						</td>
	 					</tr>
	 					<tr>
	 						<td>
	 							<select id="supplierPd" class="easyui-combobox" name="supplierPd" 
	 							data-options="editable:false,label:'供应商评定',width:240,labelAlign:'right'"  style="width:200px;">   
								    <option  value="好">好</option>   
								    <option value="差">差</option> 
								    <option value="良">良</option>     
								</select>  
	 						</td>
	 						<td>
	 							<select id="supplierFkfs" class="easyui-combobox" name="supplierFkfs" 
	 							data-options="editable:false,label:'付款方式',width:240,labelAlign:'right'"  style="width:200px;">   
								    <option value="现金">现金</option>   
								    <option value="刷卡">刷卡</option>   
								     <option value="微信">微信</option>   
								      <option value="支付宝">支付宝</option>   
								</select>  
	 						</td>
	 					</tr>
	 					<tr>
	 						<td><input id="supplierLxr" class="easyui-textbox" name="supplierLxr"
	 						 data-options="required:true,label:'联系人',width:240,labelAlign:'right'"></td>
	 						<td><input id="supplierPhone" class="easyui-textbox" name="supplierPhone"
	 						 data-options="required:true,label:'联系方式',width:240,labelAlign:'right',validType:'supplier_tel'"></td>
	 					</tr>
	 					<tr>
	 						<td>
								<input id="supplierType" name="TypeId" class="easyui-combobox" data-options="
									editable:false,
									required:true,
									label:'分类',
									width:240,
									method:'post',
									labelAlign:'right',
									valueField:'id',
									textField:'text',
									url:'to_select_supplierType'">
							</td>
							<td><input id="supplierAddress" name="supplierAddress" class="easyui-textbox"
							 data-options="required:true,label:'送货地址',width:240,labelAlign:'right'"></td>
	 					</tr>
	 					 <tr>
	 						<td colspan="2"><input id="supplierBgdz" class="easyui-textbox" name="supplierBgdz"
	 						 data-options="required:true,label:'办公地址',width:500,labelAlign:'right'"></td>
	 					</tr>
	 					<tr>
		 					<td colspan="2">
		 	 						<input id="supplierSm" class="easyui-textbox" name="supplierSm"
		 	 						 data-options="required:true,label:'供应商说明',width:500,labelAlign:'right',multiline:true,height:100">
		 	 				</td>
	 					</tr> 
	 				</table>
	 			</form>
	 		</div>
	 		<div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
				<a id="sup_queding" class="easyui-linkbutton" data-options="iconCls:'icon-ok', plain:true">Ok</a>
				<a id="sup_quxiao" class="easyui-linkbutton" data-options="iconCls:'icon-cancel', plain:true , 
					onClick : function(){
						$('#add_gonyinshang').window('close');
						$('#add_supplier').form('reset');
						$.get('to_find_supplierId',function(data){
							$('#supplierId').textbox('setValue',data.substring(1,data.length-1));
						});
					}
				">Cancel</a>
			</div>
	 	</div>
	 </div>
	 
	 
	 <!-- 新增供应商分类 -->
	 <div id="xinzenggongyingshangfenlei" class="easyui-window" title="新增供应商分类"  style="width:300px;height:150px"
	 	 data-options="modal:true,collapsible:false,minimizable:false,maximizable:false,closed:true">
	 	 <div data-options="region:'center',split:true" style="margin-top:20px">
	 	 	<form action="" method="post" id="add_fenleiname">
		 		<input name="SName" id="add_supplier_name" value="12" class="easyui-textbox" 
		 		data-options="label:'分类名',
		 			width:250,
		 			labelAlign:'right',
		 			required:true,
		 			validType:'regexSupplierName'">
	 	 	</form>
	 	 </div>
	 	<div data-options="region:'south',split:true" style="margin-left:80px">
			<a id="queding" data-options="iconCls:'icon-ok',plain:true" class="easyui-linkbutton" style="width: 78px; margin-top: 20px;">确定</a>
			<a id="grant-not" class="easyui-linkbutton" style="width: 78px; margin-top: 20px;"
				data-options="onClick : function(){
					$('#xinzenggongyingshangfenlei').window('close');
					$('#add_fenleiname').form('reset');
				},iconCls:'icon-cancel',plain:true">取消</a>
		</div>
	 </div>
	 
	 <!-- 编辑供应商分类 -->
	 <div id="bianjigongyingshangfenlei" class="easyui-window" title="编辑供应商分类"  style="width:300px;height:150px"
	 	 data-options="modal:true,collapsible:false,minimizable:false,maximizable:false,closed:true">
	 	 <div data-options="region:'center',split:true" style="margin-top:20px">
	 	 	<form action="" method="post" id="bj_fenleiname">
		 		<input id="to_update_supplierTypeName" name="supplierTypeName" class="easyui-textbox" data-options="label:'分类名',width:250,labelAlign:'right'">
		 	</form>
	 	 </div>
	 	<div data-options="region:'south',split:true" style="margin-left:80px">
			<a id="Ok" data-options="iconCls:'icon-ok',plain:true" class="easyui-linkbutton" style="width: 78px; margin-top: 20px;">确定</a>
			<a id="grant-not" class="easyui-linkbutton" style="width: 78px; margin-top: 20px;"
			data-options="onClick : function(){
					$('#bianjigongyingshangfenlei').window('close');
					$('#bj_fenleiname').form('reset');
			},iconCls:'icon-cancel',plain:true">取消</a>
		 	
		</div>
	 </div>
	 <input type="hidden" value="${ifs}" id="hiddent"/>
	 	<script type="text/javascript">
	 	var row=null;
	 	var url = url;
			 	//自动生成供应商id
				$.get("to_find_supplierId",function(data){
					$("#supplierId").textbox('setValue',data.substring(1,data.length-1));
				});
			 	
				//点击确定获取供应商id和供应商名称
				$("#huoquSupplier").linkbutton({onClick : function(){
					row = $("#tab").datagrid("getSelected");
					if(row != null){
						$("#add_drug").form("load",row);
						$("#supplier_management").window("close");
					}else{
						$.messager.alert("提示","请先选择一行");
					}
				}});
				
				//添加供应商分类
				$("#queding").linkbutton({onClick:function(){
					$("#add_fenleiname").form("submit",{
						url : 'to_add_supplierType' ,
						onSubmit : function(data){
							return $(this).form("validate");
						},
						success : function(data){
							 var json = eval("("+data+")");
							if(json.error){
								$("#add_supplier_name").textbox('setValue' , '');
								$("#xinzenggongyingshangfenlei").window("close");
								$("#gong_lei").tree('reload');
								$("#tree-t").tree('reload');
							}else{
								$.messager.alert("提示",json.eMessage);
							} 
						}
					});
				}});
				
				//验证供应商分类名
				$.extend($.fn.validatebox.defaults.rules,{
					//regexSupplierName 自定义验证名
					regexSupplierName : {
						validator : function(value){
							var json =  null;
							$.post({
								//async 异常请求
								async : false,
								//请求路径
								url : 'to_find_supplierTypeName',
								//请求参数
								data : {SName : value},
								//请求结果
								success : function(data){
									json = eval("("+data+")");
								}
							});
							return json.error;
						},
						message : '该供应商分类已存在！'
					}
				});
				
				//验证手机号
				$.extend($.fn.textbox.defaults.rules, { 
					supplier_tel: { 
			                validator : function(value) { 
			                    var supplier_tel = /^1[3|4|5|6|7|8][0-9]{9}$/; 
			                    return supplier_tel.test(value); 
			                }, 
			                message : '手机号码输入有误' 
			            } 
			        });
				
				
				//编辑供应商分类
				var supplierTypeId =0;
				var supplierTypeName = null;
				//获取供应商分类id和name
				$("#tree-t").tree({onSelect : function(node){
					alert(node.id + "" +node.text);
					supplierTypeId = node.id;
					supplierTypeName = node.text;
				}});
				$("#bianji_gysfl").linkbutton({onClick:function(){
					if(supplierTypeId==0){
						alert("请先选择一个分类！");
					}else{
						//获取分类值到文本框
						$("#to_update_supplierTypeName").textbox('setValue',supplierTypeName);
						//打开宽口
						$("#bianjigongyingshangfenlei").window('open');
					}
				}});
				
				//点击确定是触发
				$("#Ok").linkbutton({onClick:function(){
					$("#bj_fenleiname").form("submit",{
						url : 'to_update_supplierTypeName?supplierTypeId='+supplierTypeId,
						onSubmit : function(data){
							return $(this).form("validate");
						},
						success : function(data){
							var json = eval("("+data+")");
							if(json.error){ 
								$("#to_update_supplierTypeName").textbox('setValue' , '');
								$("#bianjigongyingshangfenlei").window("close");
								$("#gong_lei").tree('reload');
								$("#tree-t").tree('reload');
							}else{
								$.messager.alert("提示",json.eMessage);
							} 
						}
					});
				}});
				
				//根据供应商分类查询供应商信息
				$("#gong_lei").tree({onSelect : function(node){
					var nodes=node.id;//获取id
					if(!$("#gong_lei").tree('getSelected').children){
						$("#tab").datagrid({url : 'to_fenye_findSupplier'});
						$("#tab").datagrid('load',{typeId : nodes})//请求参数
					}
				}});
				
				//点击查询所有显示所有供应商信息
				$("#find_all_supplier").linkbutton({onClick : function(){
					$('#tab').datagrid('load','to_findAll_supplier');
					$('#gong_lei').tree('reload');
				}});

				//添加供应商分类
				$("#queding").linkbutton({onClick:function(){
					$("#add_fenleiname").form("submit",{
						url : 'to_add_supplierType' ,
						onSubmit : function(data){
							return $(this).form("validate");
						},
						success : function(data){
							 var json = eval("("+data+")");
							if(json.error){
								$("#add_supplier_name").textbox('setValue' , '');
								$("#xinzenggongyingshangfenlei").window("close");
								$("#gong_lei").tree('reload');
								$("#tree-t").tree('reload');
							}else{
								$.messager.alert("提示",json.eMessage);
							} 
						}
					});
				}});
				
				//验证供应商分类名
				$.extend($.fn.validatebox.defaults.rules,{
					//regexSupplierName 自定义验证名
					regexSupplierName : {
						validator : function(value){
							var json =  null;
							$.post({
								//async 异常请求
								async : false,
								//请求路径
								url : 'to_find_supplierTypeName',
								//请求参数
								data : {SName : value},
								//请求结果
								success : function(data){
									json = eval("("+data+")");
								}
							});
							return json.error;
						},
						message : '该供应商分类已存在！'
					}
				});
				
				//编辑供应商分类
				var supplierTypeId =0;
				var supplierTypeName = null;
				//获取供应商分类id和name
				$("#tree-t").tree({onSelect : function(node){
					supplierTypeId = node.id;
					supplierTypeName = node.text;
				}});
				$("#bianji_gysfl").linkbutton({onClick:function(){
					if(supplierTypeId==0){
						alert("请先选择一个分类！");
					}else{
						//获取分类值到文本框
						$("#to_update_supplierTypeName").textbox('setValue',supplierTypeName);
						//打开宽口
						$("#bianjigongyingshangfenlei").window('open');
					}
				}});
				
				//点击确定是触发
				$("#Ok").linkbutton({onClick:function(){
					$("#bj_fenleiname").form("submit",{
						url : 'to_update_supplierTypeName?supplierTypeId='+supplierTypeId,
						onSubmit : function(data){
							return $(this).form("validate");
						},
						success : function(data){
							var json = eval("("+data+")");
							if(json.error){ 
								$("#to_update_supplierTypeName").textbox('setValue' , '');
								$("#bianjigongyingshangfenlei").window("close");
								$("#gong_lei").tree('reload');
								$("#tree-t").tree('reload');
							}else{
								$.messager.alert("提示",json.eMessage);
							} 
						}
					});
				}});
				
				//根据供应商分类查询供应商信息
				$("#gong_lei").tree({onSelect : function(node){
					var nodes=node.id;//获取id
					if(!$("#gong_lei").tree('getSelected').children){
						$("#tab").datagrid({url : 'to_fenye_findSupplier'});
						$("#tab").datagrid('load',{typeId : nodes})//请求参数
					}
				}});
				
				
				$(".add_gys").linkbutton({onClick : function(){
					url = "to_insert_supplier";
					$("#supplierType").combobox('reload');
					$("#add_gonyinshang").window("open");
				}});
				
				//根据供应商id修改供应商
				$("#update_supplier").linkbutton({onClick : function(){
					row = $("#tab").datagrid("getSelected");
					if(row != null){
						url = "to_update_SupplierAll";
						$("#add_gonyinshang").window('open');
						$("#add_supplier").form("load",row);
						$("#supplierType").combobox("setValue" , row.supplierTypeVo.id); 
					}else{
						$.messager.alert("提示","请先选择一行");
					}
				}});
				
				$("#sup_queding").linkbutton({onClick : function(){
					$("#add_supplier").form("submit" , {
						url : url,
						onSubmit : function(data){
							return $(this).form("validate");
						},
						success : function(data){
							var json = eval ("("+data+")");
							if(json.error){
								$("#add_gonyinshang").window("close");
								$("#tab").datagrid('reload');
								$("#add_supplier").form("reset");
								$.get("to_find_supplierId",function(data){
									$("#supplierId").textbox('setValue',data.substring(1,data.length-1));
								});
							}else{
								$.messager.alert("提示",json.eMessage);
							}
						}
					});
				}});
				
				$("#queding_to_one").linkbutton({onClick : function(){
					$("#gongyingshnag_id").textbox('setValue',"有没有");
				}});
				
				//点击查询所有显示所有供应商信息
				$("#find_all_supplier").linkbutton({onClick : function(){
					$('#tab').datagrid('load','to_findAll_supplier');
					$('#gong_lei').tree('reload');
				}});
				
				$("#add_gysfl").linkbutton({onClick:function(){
					$("#xinzenggongyingshangfenlei").window('open');
				}});
				$(".add_gongyingshangfenlei").linkbutton({onClick:function(){
					$("#gongyingshangfenlei").window('open');
				}});
	 	</script>
</body>
</html>