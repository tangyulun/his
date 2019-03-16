<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<link id="ztqh" rel="stylesheet" type="text/css" href="<c:url value="/js/easyui/themes/default/easyui.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/js/easyui/themes/icon.css"/>"> 
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/tsp/table_height.css"/>"> 
	<script type="text/javascript" src="<c:url value="/js/jquery-3.1.0.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/tsp/date.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/easyui/jquery.easyui.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/easyui/easyui-lang-zh_CN.js"/>"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript">
		$("#tree_select_drug_kaiyao").tree({onSelect : function(node){
			var nodes = node.id;
			if(!$("#tree_select_drug_kaiyao").tree('getSelected').children){
				$("#drug-tables").datagrid({url : 'query_drug_typeId'});
				$("#drug-tables").datagrid('load',{drugTypeId : nodes});
			}
		}});
		
	</script>
		<div id="dd" class="easyui-layout" style="width:600px;height:400px;" data-options="fit:true">   
		    <div data-options="region:'west'" style="width:150px;">
		    	<ul style="margin-top:5px" id="tree_select_drug_kaiyao" class="easyui-tree" data-options="method:'get',url:'to_select_drugType_tree'"></ul>
		    </div>   
		    <div data-options="region:'center',border:false" style="">
		    	<table class="easyui-datagrid drug-tables"   id="drug-tables" 
				        data-options="singleSelect:true , rownumbers : true ,  toolbar:'#drug_tools' , fit:true,
				        	toolbar: '#drug_tools',method:'get',url:'query_drug',
				      		pagination:true,
							pageSize:5,
							pageList:[5,10,15]
				        ">   
				    <thead>   
				        <tr>   
				             <th data-options="field:'drugId',width:100">药品编号</th>   
				             <th data-options="field:'drugBname',width:120">药品名称</th>
				             <th data-options="field:'type',width:110,
				             	 formatter(value , row , index){
									if(row.type != null){
										return row.type.text;
									}
									return value;
								}">分类名称</th>    
				             <th data-options="field:'unit',width:90,
				             	 formatter(value , row , index){
									if(row.unit != null){
										return row.unit.text;
									}
									return value;
								}
				             ">单位</th>  
				             <th data-options="field:'drugLsprice',width:110">药品售价</th>   
				             <th data-options="field:'cod4',width:90,
				             	 formatter(value , row , index){
									if(row.kukun != null){
										return row.kukun.yaofangKaiyaoShengyuNum;
									}
									return value;
								},
				             	styler: function(value,row,index){
									if (value < 10){
										return 'background-color:#ffee00;color:red;';
									}
								}
				             ">药房数量</th>   
				        </tr>   
				    </thead>   
				</table>  
				<div id="drug_tools">
					<div style="margin-left: 20px"> 
						<input class="easyui-searchbox" style="width:240px;margin-left: 80px" data-options="label:'药品编号/名称',labelWidth:90,prompt:'药品编号/名称',searcher : function( value , name){
						 			if(value==null){
						 				
						 			}else{
						 				
						 			}
						 		}" />
						<a href="#" class="easyui-linkbutton refresh-all" data-options="plain:true , iconCls : 'icon-reload'">显示所有</a>
						<a href="#" class="easyui-linkbutton refresh-drug-queding" data-options="plain:true , iconCls : 'icon-save'">确定</a>
						
					</div>
				</div>
		    </div>   
		</div> 
</body>
</html>