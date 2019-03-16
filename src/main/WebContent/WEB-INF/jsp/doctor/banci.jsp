<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>班次管理</title>
</head>
<body>
<div class="easyui-layout" data-options="fit:true">   
    <div data-options="region:'center' , fit : true , border:false" >
    	<table class="easyui-datagrid" id="banci_table"
        data-options="fitColumns:true,rownumbers : true , 
        		 pagination: true,
        		 border:false,
	             pageSize: 5,
	             singleSelect : true,
	             pageList: [5,10,15, 20],method : 'get',
	              toolbar : '#banci_tools' , 
	              url :'select_all_banci',
	              fit:true" >  
	    <thead>   
	        <tr>   
 	            <th data-options="field:'bclassesName',width:5">班次名称</th>   
	            <th  data-options="field:'bc',width:16 ,
		            formatter: clo
	            
	            ">班次颜色</th>   
	            <th data-options="field:'bclassesBetTime',width:16">班次时间</th> 
	            <th data-options="field:'bclassesType',width:12">班次类型</th> 
	        </tr>   
	    </thead>   
	</table>  
	<div id="banci_tools">
		<a href="#" id="insert_banci_button" class="easyui-linkbutton" data-options="plain:true , iconCls : 'icon-add'">添加班次</a>
		<a href="#" id="update_banci_button" class="easyui-linkbutton" data-options="plain:true , iconCls : 'icon-edit'">编辑</a>
		<a href="#" id="delete_banci_button" class="easyui-linkbutton" data-options="plain:true , iconCls : 'icon-remove'">删除</a>
		<input  class="easyui-searchbox" style="width:220px" data-options="label : '班次名称' , labelWidth:60"/> 
		<select class="easyui-combobox" style="width:200px;" data-options="label:'班次类型' ,  labelWidth:60 , editable:false">   
		  	<option>早班</option>
		</select>  
		<a href="#" class="easyui-linkbutton" data-options="plain:true , iconCls : 'icon-search'">搜索</a>
		<a href="#" class="easyui-linkbutton" data-options="plain:true , iconCls : 'icon-reload' ,
			onClick : function(){$('#banci_table').datagrid('load' , 'select_all_banci');}
		">显示所有</a>
	</div>
	
	  <div id="insert_banci" class="easyui-window" title="添加班次" data-options="
				collapsible:false,
				minimizable:false,
				maximizable:false,
				modal:true,
				closed : true
				"
				style="width:400px;height:240px;">
			<form method="post" id="insert_banci_ff"  style="margin-left: 40px ; margin-top: 10px">
				<input class="easyui-textbox" name="bclassesName" data-options="label:'班次名称', labelWidth:60"
					 style="width:300px"> 
					<br/><br/>
				<input  class="easyui-timespinner" name="bclassesBetTime"  style="width:170px;"   
      				  data-options="label:'班次时间', labelWidth:60 , min:'00:00',showSeconds:true" /> 至
     		    <input  class="easyui-timespinner" id="bclassesBetTimeEnd" name="bclassesBetTimeEnd"  style="width:105px;"   
     				  data-options=" min:'00',showSeconds:true" /> 
					<br/><br/>
      			<select name="bclassesType" class="easyui-combobox" style="width:200px;" data-options="label:'班次类型' ,  labelWidth:60 , editable:false">   
				  	<option value="早班">早班</option>
				  	<option value="中班">中班</option>
				  	<option value="晚班">晚班</option>
				  	<option value="其他">其他</option>
				</select>  
      				 <br/><br/>
    			班次颜色 <input  id="ss" name="bclassesColor"  style="width:50px;margin-left: 5px"   type="color"/>  
    			
			</form>
			<div data-options="region:'south',border:false" style="text-align:right;padding:20px 0 0;margin-right:  20px">
				<a id="banci_save" class="easyui-linkbutton" data-options="iconCls:'icon-ok', plain:true">确定</a>
				<a id="banci_not" class="easyui-linkbutton" data-options="iconCls:'icon-cancel', plain:true">取消</a>
			</div>
		</div> 	
    </div>   
</div> 
 	
		<script type="text/javascript">
		var url = null;
			$(function(){
				$("#insert_banci_button").linkbutton({onClick : function(){
					url = 'insert_banci';
					$("#insert_banci_ff").form('reset');
					$("#insert_banci").window('open');
				}});
				$("#banci_not").linkbutton({onClick : function(){
					$("#insert_banci_ff").form('reset');
					$("#insert_banci").window('close');
				}});
				$("#insert_banci").window({onClose : function(){
					$("#insert_banci_ff").form('reset');
				}});
			
				$("#banci_save").linkbutton({onClick : function(){
					$("#insert_banci_ff").form('submit',{
						url : url,
						onSubmit : function(param){
							return $(this).form("validate");
						},
						success : function(data){
							var json = eval('('+data+')');
							if(json.error){
								$("#banci_table").datagrid('reload' , 'select_all_banci');
								$("#insert_banci_ff").form('reset');
								$("#insert_banci").window('close');
							}else{
								$.messager.alert("操作",json.eMessage);
							}
						}
					});
				}});
				$("#update_banci_button").linkbutton({onClick : function(){
					//获取选中的行
					var row = $("#banci_table").datagrid("getSelected");
					if(row == null){
						$.messager.alert('提示',"请至少选择一行进行编辑!");
						return ;
					}
					$("#bclassesBetTimeEnd").timespinner("setValue" , row.bclassesBetTime.substring(11 , row.bclassesBetTime.length));
					$("#insert_banci_ff").form("load" , row);
					url = 'update_banci?bclassesId='+row.bclassesId;
					$("#insert_banci").window('open');
				}});
				
				$("#delete_banci_button").linkbutton(
					{onClick : function(){
						var row = $("#banci_table").datagrid("getSelected");
						if(row == null){
							$.messager.alert('提示',"请至少选择一行进行删除!");
							return ;
						}
						$.getJSON("delete_banci" , {bclassId : row.bclassesId} , function(data){
							if(data.error){
								$("#banci_table").datagrid('reload' , 'select_all_banci');
							}else{
								$.messager.alert('提示',data.eMessage);
							}
						});
					}
				});
			});
			function  clo(value,row,index){
				var color = row.bclassesColor;
				return "<div style='width:60px;padding:6px;border-radius:10px;color:black;"
				+"background:"+color+";'></div>";
			}
		</script>
</body>
</html>