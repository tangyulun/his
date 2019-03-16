<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript" src="<c:url value="/js/jquery.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/easyui/jquery.easyui.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/easyui/easyui-lang-zh_CN.js"/>"></script>
<link rel="stylesheet" type="text/css" href="<c:url value="/js/easyui/themes/default/easyui.css"/>">
<link rel="stylesheet" type="text/css" href="<c:url value="/js/easyui/themes/icon.css"/>">
</head>
<body>
	 <div id="xqdj" class="easyui-layout" title="器械登记"
        data-options="iconCls:'icon-save',modal:true,fit:true">   
        <div data-options="region:'north'" style="height:35px;">
        	<div style="margin: 3px 0px 0px 15px">
	        	<a id="btn" href="#" class="easyui-linkbutton"data-options=""style="width:80px;">新建</a>
				<a id="btn1" href="#" class="easyui-linkbutton"data-options=""style="width:80px;">处理</a>
			 </div>
        </div>
        
         <div data-options="region:'center'" style="padding:5px;height:110px">  
			<table width="100%">
				<tr height="35px">
					<td colspan="2">
						<input name="" class="easyui-textbox" data-options="required:true,label:'器械*',width:240,labelAlign:'right'">
				  		<input name="" class="easyui-textbox" data-options="required:true,width:300">
				  		<a id="qx1" href="#" class="easyui-linkbutton" data-options="" style="width:30px;height:22px">…</a>  
					</td>
					<td>
						
						<select name="" class="easyui-combobox"data-options="required:true,label:'仓库*', width:240,labelAlign:'right'">   
   						 <option value="aa">中药库</option>   
    						<option>西药库</option>   
								</select>  
					</td>
					<td>
						<input name="" class="easyui-textbox" data-options="required:true,
						label:'采购单价*',width:240,labelAlign:'right'"/>
					</td>
				</tr>
				<tr height="35px">
					<td>
						<input name="" class="easyui-datebox" data-options="required:true,label:
						'生产日期*',width:240,labelAlign:'right'">
					</td>
					<td>
						<input name="" class="easyui-datebox" data-options="required:true,
						label:'报废日期*',width:240,labelAlign:'right'">
					</td>
					<td>
						<input name="" class="easyui-datebox" data-options="required:true,
						label:'采购日期*',width:240,labelAlign:'right'">
					</td>
					<td>
						<input name="" class="easyui-textbox" data-options="required:true,
						label:'报废天数*',width:240,labelAlign:'right'">
					</td>
				</tr>
			<tr height="35px">
					<td>
						<input name="" class="easyui-textbox" data-options="required:true,
						label:'批号*',width:240,labelAlign:'right'">
					</td>
					<td>
						<input name="" class="easyui-textbox" data-options="required:true,
						label:'备注',width:270,labelAlign:'right'">
					</td>
					<td >
						<input name="" class="easyui-textbox" data-options="required:true,
						label:'数量*',width:240,labelAlign:'right'">
					</td>
					<td>
						
							<a id="" href="#" class="easyui-linkbutton" data-options="" style="width:80px">加入</a> 
							<a id="" href="#" class="easyui-linkbutton" data-options="" style="width:80px">删除</a>

					</td>
				</tr>
			</table>
		 </div>
		 
		 <div data-options="region:'south'" style="height:370px;">
	    <table class="easyui-datagrid" data-options="fitColumns:true,singleSelect:true,fit:true">  
		     <thead>   
				 <tr>   
					<th data-options="field:'code1',width:6">*</th>   
					<th data-options="field:'name2',width:7.77">器械编号</th> 
					<th data-options="field:'code3',width:7.77">器械名称</th>   
					<th data-options="field:'name4',width:7.77">分仓</th>   
					<th data-options="field:'code5',width:7.77">批号</th>   
					<th data-options="field:'name6',width:7.77">数量</th>  
					<th data-options="field:'code7',width:7.77">单位</th>   
					<th data-options="field:'name8',width:7.77">条形码</th>   
					<th data-options="field:'code10',width:7.77">采购日期</th>  
					<th data-options="field:'code11',width:7.77">生产日期</th>  
					<th data-options="field:'code12',width:7.77">报废日期</th>  
					<th data-options="field:'code13',width:7.77">备注</th>  
				</tr>   
			</thead>   
		</table>  
	   </div>   
	</div>
	
	
	<div id="xzqx1" class="easyui-window" title="选择器械" style="width:800px;height:500px" data-options="model : true , closed:true">
		<div data-options="region:'north'" style="height: 30px; padding: 8px">
					<table width="100%">
						<tr>
						<td>
						<div style="margin-left: 260px">
						<a id="A1" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">+(A)</a> 
						</div></td>
							<td align="right"><input name="" class="easyui-textbox"
								data-options="required:true,width:170"> 
								<a id="" href="#"
								class="easyui-linkbutton" data-options="" style="width: 80px">查询</a>
								<a id="regist-shoufei-add-xm" href="#" class="easyui-linkbutton"
								data-options="" style="width: 80px">高级</a> 
							</td>
							<td align="right"><a id="" href="#" class="easyui-linkbutton"
								data-options="" style="width: 80px">确定</a></td>
						</tr>
					</table>
				</div>

				<div data-options="region:'west',title:'收费项目分类结构',collapsible:false"
					style="width: 180px;height:85%;border: 1px solid #66cccc;float:left;">
					<ul class="easyui-tree" data-options="">
						<li><span>器械分类结构</span>
							<ul>
								<li><span>A.病人专用</span></li>
								<li><span>A.医生专用</span></li>
								<li><span>A.护士专用</span></li>
									
					</ul>
	
				</div>

			<div data-options="region:'right'" style="height: 85%;border: 1px solid #66cccc;">
				<table class="easyui-datagrid"
					data-options="fit : true,border:false,fitColumns:true,striped:true">
					<thead style="margin-top: -20px;">
						<tr>
							<th data-options="field:'code',width:3,align:'left'">*</th>
							<th data-options="field:'name',width:15,align:'left'">存放位置</th>
							<th data-options="field:'price',width:15,align:'left'">功能说明</th>
							<th data-options="field:'price2',width:10,align:'left'">状态</th>
							<th data-options="field:'price3',width:15,align:'left'">维护人</th>
							<th data-options="field:'price4',width:15,align:'left'">分类名称</th>
							<th data-options="field:'price5',width:15,align:'left'">器械名称</th>
							<th data-options="field:'price6',width:15,align:'left'">器械编号</th>
							
						</tr>
					</thead>
				</table>
			</div>
		</div>  
	<div id="qxgl1" class="easyui-window" title="器械管理" style="width:800px;height:500px" data-options="
		collapsible:false,
		minimizable:false,
		maximizable:false,
		modal:true,
		closed: true">
		<div data-options="region:'north'" style="height: 30px; padding: 8px">
					<table width="100%">
						<tr>
							<td >
							<a id="fl1" href="#" class="easyui-linkbutton"data-options="" style="width: 80px">器械分类</a>
							</td>
							<td >
							<input class="easyui-searchbox" style="width:200px;margin-left:-50px" />
							</td>
							<td >
							<a id="xj1" href="#" class="easyui-linkbutton"data-options="" style="width: 80px">新建</a>
							</td>
							<td >
							<a id="" href="#" class="easyui-linkbutton"data-options="" style="width: 80px">编辑</a>
							</td>
							<td >
							<a id="" href="#" class="easyui-linkbutton"data-options="" style="width: 80px">删除</a>
							</td>
						</tr>
					</table>
				</div>
				<div data-options="region:'west',title:'收费项目分类结构',collapsible:false"style="width: 180px;height:85%;border: 1px solid #66cccc;float:left;">
					<ul class="easyui-tree" data-options="">
						<li><span>器械分类结构</span>
							<ul>
								<li><span>A.病人专用</span></li>
								<li><span>B.医生专用</span></li>
								<li><span>C.护士专用</span></li>
					</ul>
				</div>
				<div data-options="region:'right'" style="height: 85%;border: 1px solid #66cccc;">
				<table class="easyui-datagrid"
					data-options="fit : true,border:false,fitColumns:true,striped:true">
					<thead style="margin-top: -20px;">
						<tr>
							<th data-options="field:'code',width:3,align:'left'">*</th>
							<th data-options="field:'name',width:15,align:'left'">存放位置</th>
							<th data-options="field:'price',width:15,align:'left'">功能说明</th>
							<th data-options="field:'price2',width:10,align:'left'">状态</th>
							<th data-options="field:'price3',width:15,align:'left'">维护人</th>
							<th data-options="field:'price4',width:15,align:'left'">分类名称</th>
							<th data-options="field:'price5',width:15,align:'left'">器械名称</th>
							<th data-options="field:'price6',width:15,align:'left'">器械编号</th>
							
						</tr>
					</thead>
				</table>
			</div>
		</div>
		
		<div id="qxfl1" class="easyui-window" title="器械分类设置" style="width:300px;height:150px" data-options="collapsible:false,
		minimizable:false,
		maximizable:false,
		modal:true,
		closed: true">
		<tr>
		<td>
			<div style="padding: 15px 5px 10px 5px;">
			<input name="" class="easyui-textbox" data-options="required:true,label:'器械分类码*',width:230,labelAlign:'right'">
			</div>
			</td>
			</tr>
			<tr>
			<td>
			<a id="" href="#" class="easyui-linkbutton"data-options="" style="width:80px;margin-left: 60px;margin-top: 20px">确定</a>
			</td>
			<td>
			<a id="" href="#" class="easyui-linkbutton"data-options="" style="width: 80px;margin-top: 20px">取消</a>
			</td>
			</tr>
			</div>   
			
	<div id="create1" class="easyui-window" title="创建新器械" data-options="
		collapsible:false,
		minimizable:false,
		maximizable:false,
		modal:true,
		closed: true" 
		style="width:700px;height:430px;padding:5px;">
			<div class="easyui-layout" data-options="fit:true">
				<div data-options="region:'center'" style="padding:10px;">
					<table id="dept-table-add"  width="100%">
						<tr height="50px">
							<td><input class="easyui-textbox" data-options="label:'器械编号' , labelWidth:100 , width:300 , labelAlign : 'right'"/></td>
							<td>
								<select class="easyui-combobox" data-options="label:'状态' , labelWidth:100 , width:300 , labelAlign : 'right'">
									<option value="aa">正常</option>
									<option>损坏</option>   
								</select>
							</td>
						</tr>
						<tr>
							<td>
								<select class="easyui-combobox" data-options="label:'单位' , labelWidth:100 , width:300 , labelAlign : 'right'">
									<option value="aa">克</option>
									<option>克</option>   
									<option>支</option>
									<option>台</option>   
									<option>个</option>   
									<option>包</option>   
									<option>件</option>   
									<option>付</option>   
									<option>张</option>   
									<option>架</option>   
									<option>盒</option>   
									<option>本</option>   
									<option>副</option>   
									<option>毫摩尔</option>   
									<option>微摩尔</option>   
									<option>毫帕斯卡.秒</option>   
									<option>min</option>     
								</select>
							</td>
							<td>
								<input class="easyui-datebox" data-options="label:'采购日期' , labelWidth:100 , width:300 , labelAlign : 'right'"/>
							</td>
						</tr>
						<tr>
						<td>
						<input class="easyui-textbox" data-options="label:'科目码' , labelWidth:100 , width:300 , labelAlign : 'right'"/>
						</td>
							<td>
								<input class="easyui-datebox" data-options="label:'启用日期' , labelWidth:100 , width:300 , labelAlign : 'right'"/>
							</td>
						</tr>
						<tr>
							<td>
							<input name="" class="easyui-textbox" data-options="label:'分类*',width:140,labelAlign:'right'">
							<input name="" class="easyui-textbox" data-options="width:140">
							<a id="" href="#" class="easyui-linkbutton">…</a>  
							</td>
							<td>
								<input class="easyui-datebox" data-options="label:'报废日期' , labelWidth:100 , width:300 , labelAlign : 'right'"/>
							</td>
						</tr>
						<tr>
							<td>
 								<input class="easyui-textbox" data-options="label:'拼音' , labelWidth:100 , width:300 , labelAlign : 'right'"/>
							</td>
							<td>
								<input class="easyui-datebox" data-options="label:'最新外借日期' , labelWidth:100 , width:300 , labelAlign : 'right'"/>
							</td>
						</tr>
						<tr>
							<td>
								<input class="easyui-textbox" data-options="label:'外借次数' , labelWidth:100 , width:300 , labelAlign : 'right'"/>
							</td>
						
							<td>
								<input class="easyui-datebox" data-options="label:'审核日期' , labelWidth:100 , width:300 , labelAlign : 'right'"/>
							</td>
						</tr>
						<tr>
							<td>
								<input class="easyui-textbox" data-options="label:'尺寸' , labelWidth:100 , width:300 , labelAlign : 'right'"/>
							</td>
						
							<td>
								<input class="easyui-textbox" data-options="label:'出厂编号' , labelWidth:100 , width:300 , labelAlign : 'right'"/>
							</td>
						</tr>
						<tr>
							<td>
								<input class="easyui-textbox" data-options="label:'购置价格' , labelWidth:100 , width:300 , labelAlign : 'right'"/>
							</td>
						
							<td>
								<input class="easyui-textbox" data-options="label:'审核人' , labelWidth:100 , width:300 , labelAlign : 'right'"/>
								<a id="" href="#" class="easyui-linkbutton" >…</a>  
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<input class="easyui-textbox" data-options="label:'备注' , labelWidth:100 , width:625 , labelAlign : 'right'"/>
							</td>
						</tr>
					</table>
				</div>
				<div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
					<a id="grant-save" class="easyui-linkbutton" data-options="iconCls:'icon-ok', plain:true">Ok</a>
					<a id="grant-not" class="easyui-linkbutton" data-options="iconCls:'icon-cancel', plain:true">Cancel</a>
				</div>
			</div>
		</div>
		</div>
		
<script type="text/javascript">
		$(function(){
			$("#qx1").linkbutton({onClick : function(){
				$("#xzqx1").window("open");
			}});
		});
		$(function(){
			$("#A1").linkbutton({onClick : function(){
				$("#qxgl1").window("open");
			}});
		});
		$(function(){
			$("#fl1").linkbutton({onClick : function(){
				$("#qxfl1").window("open");
			}});
		});
		$(function(){
			$("#xj1").linkbutton({onClick : function(){
				$("#create1").window("open");
			}});
		});
</script>
</body>
</html>