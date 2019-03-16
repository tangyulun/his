<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<link rel="stylesheet" type="text/css" href="<c:url value="/js/easyui/themes/default/easyui.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/js/easyui/themes/icon.css"/>"> 
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/tsp/table_height.css"/>"> 
	<script type="text/javascript" src="<c:url value="/js/jquery-3.1.0.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/easyui/jquery.easyui.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/easyui/easyui-lang-zh_CN.js"/>"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
<script type="text/javascript">
	$(function(){
		$.get("h_number",function(data){
			$("#finance-shoufeijiesuan").textbox('setValue',data.substring(1,data.length-1));
		});
	});
		
</script>
	<div id="win" class="easyui-layout" title="供应商结算" style="width:800px;height:500px"   
        data-options="modal:true,minimizable:false,maximizable:false,collapsible:false, fit : true">  
          <div id="fina-top-id" data-options="region:'north'" style="height:45px;padding: 8px">
	        	<a id="fina-init" href="#" class="easyui-linkbutton" data-options="" style="width:80px">新建</a>  
				<a id="fina-add" href="#" class="easyui-linkbutton" data-options="" style="width:80px;">打开</a>  
				<a id="fina-gd" href="#" class="easyui-linkbutton" data-options=""  style="width:80px;">结账核算</a>  
				<a id="fina-ghcl" href="#" class="easyui-linkbutton" data-options="" style="width:100px;">结账处理</a>  
				<a id="fina-open" href="#" class="easyui-linkbutton" data-options="" style="width:80px;">关闭</a>  
	      </div>   
	      <div data-options="region:'center'" style="height:450px;">  
	      	<form action="" style="width: 100%">
	      <table width="95%" style="margin-left:20px">
	      
	           			<tr height="30">
	           				<td width="250px"><input name="" id="finance-shoufeijiesuan" readonly="readonly" class="easyui-textbox" data-options="required:true,label:'收费结算号*' ,labelWidth : 100,width:240,labelAlign:'right'"></td>
	           				 
	           				<td>
	           					<select id="cc" class="easyui-combobox" name="dept" style="width:240px;" data-options="label : '状态' , labelWidth : 100,labelAlign:'right'"" disabled="disabled">   
								    <option value="aa">未结账</option>   
								</select>  
	           				</td>
	           				<td>
	           					<select id="cc" class="easyui-combobox" name="dept" disabled="disabled" style="width:240px;" data-options="label : '结账类型' , labelWidth :100,labelAlign:'right'"">   
								    <option value="aa">住院收费</option>   
								</select>  
	           				</td>
	           				<td><input name="" class="easyui-datebox" data-options="required:true,label:'结账日期',labelWidth :100,width:240,labelAlign:'right'"></td>
	           			</tr>
	           			
	           			<tr height="30">
	           				<td width="300px">
	           					 <input style="margin-left: 15px" name="" class="easyui-textbox" data-options="required:true,label:'住院号'
	           					 ,labelWidth :100,width:240,labelAlign:'right' ">
	           					 <a class="easyui-linkbutton"></a>
		           			</td>
		           			<td>
	           					  <input style="margin-left: 15px" name="" class="easyui-textbox" data-options="required:true,label:'病人姓名'
	           					 ,labelWidth :100,width:240,labelAlign:'right' ">
		           			</td>
		           			<td>
	           					<input name="" class="easyui-textbox" data-options="required:true,label:'发票号码'
	           					 ,labelWidth : 100,width:240,labelAlign:'right'">
	           				</td>
	           				<td><input name="" class="easyui-timespinner" data-options="required:true,label:'结账时间',labelWidth :100,width:240,labelAlign:'right'"></td>
	           			</tr>
	           			<tr height="30">
	           				<td>
	           					<select id="cc" class="easyui-combobox" name="dept" style="width:240px;" data-options="label : '操作员' , labelWidth : 100,labelAlign:'right'"">   
								    <option value="aa">管理员</option>   
								</select> 
	           				</td>
	           				<td>
	           					<select id="cc" class="easyui-combobox" name="dept" style="width:240px;" data-options="label : '结账方式' , labelWidth : 100,labelAlign:'right'"">   
								    <option value="aa">支付宝</option>   
								</select> 
	           				</td>
	           				<td >
	           					 <input style="margin-left: 15px" name="" class="easyui-textbox" data-options="required:true,label:'应付账款'
	           					 ,labelWidth :100,width:240,labelAlign:'right'">
		           			</td>
		           			<td>
	           					 <input style="margin-left: 55px" name="" class="easyui-textbox" data-options="required:true,label:'实付账款'
	           					 ,labelWidth : 100,width:240,labelAlign:'right'">
		           			</td>
	           			</tr>
	           		
	           			<tr height="30">
	           				<td colspan="4">
	           					<input name="" class="easyui-textbox" data-options="required:true,label:'备注'
	           					 ,labelWidth : 100,width:495,labelAlign:'right'">
	           				</td>
	           			</tr>
	           		</table>	
	           		</form>
	           		 <div id="regist-patient-add-tabs"  data-options="fit:true" class="easyui-tabs" style="margin-top: 10px; height : 345px" >  
           			<div title="结账明细" style="padding:5px;display:none;">   
				       <table class="easyui-datagrid" data-options="fit : true">   
						    <thead>   
						        <tr>   
						            <th data-options="field:'code',width:100">*</th>   
						            <th data-options="field:'name',width:100">单据编号</th>   
						            <th data-options="field:'price2',width:100,align:'right'">项目编号</th>   
						            <th data-options="field:'price1',width:100,align:'right'">项目名称</th>  
						             <th data-options="field:'price3',width:100,align:'right'">金额</th>   
						            <th data-options="field:'price4',width:100,align:'right'">备注</th>  
						        </tr>   
						    </thead>   
						</table>  
				    </div>  
           			<div title="应收款项" style="padding:5px;display:none;">   
           			  <table width="100%">
           			  	<tr height="40px">
           			  		<td>
		           				 <select id="cc" class="easyui-combobox" name="dept" style="width:200px;" data-options="label : '结账方式' , labelWidth : 62">   
								    <option value="aa">手续费</option>   
								</select> 
								<a class="easyui-linkbutton" data-options="width:23 , height:23"></a>
           			  		</td>
           			  		
           			  		<td>
           			  			 <input  name="" class="easyui-textbox" data-options="required:true,label:'应付金额'
		           					 ,labelWidth : 62,width:230,labelAlign:'right'">
           			  		</td>
           			  		<td>
	           			  			<a class="easyui-linkbutton" data-options="text:'加入' , width :100"></a>
	           			  			<a class="easyui-linkbutton"  data-options="text:'删除' , width :100"></a>
           			  		</td>
           			  	</tr>

           			  </table>
           			  
				       <table class="easyui-datagrid" data-options="fit : true">   
						    <thead>   
						        <tr>   
						            <th data-options="field:'code',width:100">*</th>   
						            <th data-options="field:'name',width:100">应收款项</th>   
						            <th data-options="field:'price1',width:100,align:'right'">应收金额</th>   
						        </tr>   
						    </thead>   
						</table>  
				    </div>  
	           	</div>
	           	
	      </div>
     </div>
</body>
</html>