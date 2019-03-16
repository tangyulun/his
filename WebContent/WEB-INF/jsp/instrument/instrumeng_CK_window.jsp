<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

		<div id="qxfl3" class="easyui-window" title="器械分类设置" style="width:300px;height:150px" data-options="collapsible:false,
		minimizable:false,
		maximizable:false,
		modal:true,
		closed: true">
		
		<tr>
		<td>
			<div style="padding: 15px 5px 10px 5px;">
			<form id="i_fl" method="post">
			<input id="instrumentTypeName" name="instrumentTypeName" class="easyui-textbox" data-options="required:true,label:'器械分类码*',
			required:true,validType:'regexiTypeName',width:230,labelAlign:'right'">
			</form>
			</div>
			
			</td>
			</tr>
			<tr>
			<td>
			<a id="fl_yes" href="#" class="easyui-linkbutton"data-options="iconCls:'icon-ok', plain:true" style="width:80px;margin-left: 60px;margin-top: 20px">确定</a>
			</td>
			<td>
			<a id="fl_qux" href="#" class="easyui-linkbutton"data-options="iconCls:'icon-cancel', plain:true" style="width: 80px;margin-top: 20px">取消</a>
			</td>
			</tr>
			
			</div>   
			
	<div id="create3" class="easyui-window" title="创建新器械" data-options="
		collapsible:false,
		minimizable:false,
		maximizable:false,
		modal:true,
		closed: true" 
		style="width:700px;height:360px;padding:5px;">
			<div class="easyui-layout" data-options="fit:true">
				<div data-options="region:'center'" style="padding:10px;">
					<form id="instrument-form" method="post">
					<table id="dept-table-add"  width="100%">
						<tr height="50px">
							<td>
								<input name="instrumentId" id="instrumentflbh"class="easyui-textbox" data-options="label:'器械编号' , editable : false , labelWidth:100 , width:300 , labelAlign : 'right'"/>
							</td>
							<td>
								<input name="instrumentName" value="111" id="instrumentName"class="easyui-textbox" data-options="required : true,label:'器械名称' , labelWidth:100 , width:300 , labelAlign : 'right'"/>
							</td>
						</tr>
						<tr>
							<td>
								<input class="easyui-combobox" id="unitId" name="unitId" data-options="
	 	 							editable:false,
	 	 							label:'器械单位',
	 	 							labelWidth: 100,
	 	 							width:300,
	 	 							required : true,
	 	 							method:'post',
	 	 							labelAlign:'right',
	 	 							required:true,
	 	 							valueField:'id',
	 	 							editable : false,
	 	 							textField:'text',
	 	 							url:'to_select_allunitName'">
							</td>
							<td>
								<input name="instrumentQiyongDate"value="new Date()" class="easyui-datebox" data-options="label:'启用日期' , labelWidth:100 , width:300 , labelAlign : 'right' , editable : false"/>
							</td>
						</tr>
						<tr>
							<td>
								<input id="instrumentTypeId" name="instrumentTypeId" class="easyui-combobox"data-options="valueField:'id',	required:true, labelWidth:100 , textField:'text',url:'select_instrument_types2' , label:'分类' ,width:300 ,  labelAlign : 'right', method : 'get', " />
							</td>
							<td>
								<input name="instrumentBaofeiDate" value="new Date()" class="easyui-datebox" data-options="label:'报废日期' ,editable : false ,  labelWidth:100 , width:300 , labelAlign : 'right'"/>
							</td>
						</tr>
						<tr>
							<td>
								<input name="instrumentWaijieNum" value="0" class="easyui-textbox" data-options="label:'外借次数' , labelWidth:100 , width:300 , labelAlign : 'right'"/>
							</td>
							<td>
								<input class="easyui-textbox" name="instrumentPrice" value="100" data-options="label:'购置价格' , labelWidth:100 , width:300 , labelAlign : 'right'"/>
							</td>
						</tr>
						<tr>
							<td>
								<input name="instrumentChicun"  value="13.4" class="easyui-textbox" data-options="label:'尺寸' , labelWidth:100 , width:300 , labelAlign : 'right'"/>
							</td>
					
							<td>
								<select class="easyui-combobox" name="empId" data-options="label:'审核人' , labelWidth:100 , width:300 , labelAlign : 'right'">
									<option value="${empMessage.empId}">${empMessage.empName}</option>
								</select>
							</td>
							
						</tr>
						<tr>
								<td>
									<input name="instruemntTop" value="10" class="easyui-textbox" data-options="label:'库存上限'  ,  labelWidth:100 , width:300 , labelAlign : 'right'"/>
								</td>
								<td>
									<input id="instrumentButtom" name="instrumentButtom" value="1" name="instrumentButtom" class="easyui-textbox"data-options=" labelWidth:100 ,  label:'库存下限' ,width:300 ,  labelAlign : 'right', method : 'get' " />
								</td>
							</tr>
						<tr>
							<td colspan="2">
								<input name="instrumentRemark" class="easyui-textbox" data-options="label:'备注' , labelWidth:100 , width:625 , labelAlign : 'right'"/>
							</td>
						</tr>
					</table>
					</form>
				</div>
				<div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
					<a id="instrument-sava" class="easyui-linkbutton" data-options="iconCls:'icon-ok', plain:true">确定</a>
					<a id="quxiao-not" class="easyui-linkbutton" data-options="iconCls:'icon-cancel', plain:true">取消</a>
				</div>
			</div>
		</div>
	
		
		<div id="qixie_layout" class="easyui-layout" data-options="fit:true">   
		    <div data-options="region:'north'" style="height:50px;">
		    <table width="95%" style="margin: 8px 0px 0px 10px">
						<tr>
							<td>
							
								<a id="fl3" href="#" class="easyui-linkbutton"data-options="iconCls:'icon-add',plain:true" style="width: 80px">新建分类</a>
								<a id="xj3" href="#" class="easyui-linkbutton"data-options="iconCls:'icon-add',plain:true" style="width: 80px">新建器械</a>
								<a id="editor-instrument" href="#" class="easyui-linkbutton"data-options="iconCls:'icon-edit',plain:true" style="width: 80px">编辑</a>
												
								<input name="" id="searcherName" class="easyui-searchbox"data-options="width:250,
								searcher : function( value , name){
												if(value == null){
													$('#select_instrument_type').datagrid('reload' , 'select_instruments_types');
												}else{
													$('#select_instrument_type').datagrid({url : 'select_instrument_where'});
													$('#select_instrument_type').datagrid('load' , {instrumentName : value});
												}
											}"/>
								<a id="show_all_qixiess" href="#" class="easyui-linkbutton"data-options="iconCls:'icon-reload',plain:true" style="width: 80px">显示所有</a> 
								<a id="select_qx_name" href="#" class="easyui-linkbutton select_qx_name"data-options="iconCls:'icon-ok',plain:true" style="width: 60px">确定</a>
							</td>
						</tr>
						
					</table>
		    </div>   
		    <div data-options="region:'west'" style="width:150px;">
		    	<ul class="easyui-tree" id="instrument_ul" data-options="url:'select_instrument_types' , method:'get'">
		    	
		    	</ul>  
		    </div>   
		    <div data-options="region:'center'" style="">
		    	<table class="easyui-datagrid select_instrument_type" id="select_instrument_type"
				data-options="fitColumns:true,
							 singleSelect:true,
					         method : 'get' , 
					         url : 'select_instruments_types',
					         pagination: true,
				             pageSize: 5,
				             fit:true,
				             pageList: [5,10,15, 20],
				             rownumbers : true" 	
				             >
				             
					<thead>
						<tr>
							<th data-options="field:'instrumentId',width:10,align:'left'">器械编号</th>
							
							<th data-options="field:'instrumentName',width:15,align:'left'">器械名称</th>
							<th data-options="field:'instrumentTypeId',width:10,align:'left' , formatter(value , row , index){
									if(row.instrumentType != null){
										return row.instrumentType.text;
									}
									return value;
								}
								">分类名称</th>
							<th data-options="field:'units',width:10,align:'left' , 
							formatter(value , row , index){
								return row.unit.text;
							}">单位</th>
							<th data-options="field:'instrumentPrice',width:20,align:'left'">单价</th>
							<th data-options="field:'instrumentRemark',width:20,align:'left'">备注</th>
						</tr>
					</thead>
				</table>
		    </div>   
		</div>  
	
<script type="text/javascript">
		$(function(){
			$("#qx1").linkbutton({onClick : function(){
				$("#xzqx3").window("open");
			}});
			$("#A3").linkbutton({onClick : function(){
				$("#qxgl3").window("open");
			}});
			$("#fl3").linkbutton({onClick : function(){
				$("#qxfl3").window("open");
			}});
			$("#xj3").linkbutton({onClick : function(){
				$("#create3").window("open");
				$.get("ckdanhao", function(date){
					$('#qx_ck').textbox('setText',date.substring(1,date.length-1));
				});
			}});
			$("#cgddh").linkbutton({onClick : function(){
				$("#xzqxcg").window("open");
			}});
			$("#fl_qux").linkbutton({onClick : function(){
				$("#qxfl3").window("close");
			}});
			//新建的随机分类码
			$.get("ckdanhao", function(date){
				$('#qx_ck').textbox('setText',date.substring(1,date.length-1));
			});
			//新建的id随机分类码
			$.get("ckdanhaoid", function(date){
				$('#instrumentflbh').textbox('setText',date.substring(1,date.length-1));
			});
			$("#quxiao-not").linkbutton({onClick : function(){
				$("#create3").window("close");
			}});
			//新建的随机分类码

			$.get("qixiebh_id", function(date){
				$('#instrumentflbh').textbox('setValue',date.substring(1,date.length-1));
			});

			

			//添加分类码
			$("#fl_yes").linkbutton({onClick : function(){
				$("#i_fl").form("submit" , {
					url : 'add_instrument_types' ,
					onSubmit : function(data){
						return $(this).form("validate");
					},
					success : function(data){
						var json = eval("("+data+")");
						if(json.error){

							$("#instrument_ul").tree('reload');


							$("#qxfl3").window('close');
							$("#instrument_ul").tree('reload');
						}else{
							$.messager.alert(json.message);
						}
					}
				});
			}});
			
			//添加器械
			$("#instrument-sava").linkbutton({onClick : function(){
				$("#instrument-form").form("submit" , {
					url : 'add_instrument' ,
					onSubmit : function(data){
						return $(this).form("validate");
					},
					success : function(data){
						var json = eval("("+data+")");
						if(json.error){	
							$("#create3").window('close');
							$("#select_instrument_type").datagrid("reload");
						}else{
							$.messager.alert("提示",json.message);
						}
					}
				});
			}}); 
			
			
			//分类验证
			$.extend($.fn.validatebox.defaults.rules, {
				regexiTypeName : {
					validator : function(value) {
						var json = null;
						$.post({
							async : false,
							url : 'regex_instrument_types',
							data : {
								instrumentTypeName : value
							},
							success : function(data) {
								json = eval("(" + data + ")");
							}
						});
						return json.error;
					},
					message : '已存在'
				}
			});
			//器械名验证
			$.extend($.fn.validatebox.defaults.rules, {
				regexiName : {
					validator : function(value) {
						var json = null;
						$.post({
							async : false,
							url : 'regex_instrument_names',
							data : {
								instrumentName : value
							},
							success : function(data) {
								json = eval("(" + data + ")");
							}
						});
						return json.error;
					},
					message : '已存在'
				}
			});

			//点击ul 刷新右边
			$("#instrument_ul").tree({onSelect : function(node){
				var nodes  = node.id;
				if (!$("#instrument_ul").tree('getSelected').children) {
					$("#select_instrument_type").datagrid({url : 'select_instruments_typess'});
					$("#select_instrument_type").datagrid('load' , {instrumentTypeId : nodes})
				}
				
			}});
			//编辑
			$("#editor-instrument").linkbutton({onClick : function(){
				var row = $("#select_instrument_type").datagrid('getSelected');
				if(row == null){
					$.messager.alert("提示","您选择的这行为空！");
					return;
				}
				$("#create3").window('open');
				$("#instrument-form").form('load',row);
				$('#instrumentTypeId').combobox('setValue', row.instrumentType.id);
				//$('#unitId').combobox('setValue', row.unit[0].id);
				url = "update_instrument";
			}});
	
			//编辑左边，在用户双击一个节点的时候触发
			$("#instrument_ul").tree({onDblClick : function(node){
				$(this).tree('beginEdit', node.target);//开始编辑一个节点
			}});
			
			//在编辑节点之后触发。
			$("#instrument_ul").tree({onAfterEdit : function(node){
				var id = node.id;
				var text = node.text;
				$.getJSON('update_instrumentinstrument',{instrumentTypeId:id, instrumentTypeName:text},function(data){
					 if(!$("#instrument_ul").tree('getSelected').children){
							$("#select_instrument_type").datagrid({url : 'select_instruments_types'});
							$("#select_instrument_type").datagrid('load' , {instrumentTypeId : id});//请求参数
							$("#instrument_ul").tree('reload');
							$("#select_instrument_type").datagrid("reload");
						}  
				});
			}});
			//显示所有
			$("#show_all_qixiess").linkbutton({onClick : function(){
				$("#searcherName").textbox('setValue' , '');
				$('#select_instrument_type').datagrid('reload' , 'select_instruments_types');
			}});
		});
		
		
</script>

</body>
</html>