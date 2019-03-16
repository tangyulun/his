<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>药品字典</title>
</head>
<body>

	<table class="easyui-datagrid" id="durg_dean_tab"
	        data-options="fitColumns:true,singleSelect:true ,border:false,fit:true , rownumbers : true ,
	         pagination: true,
	             pageSize: 10,
	             singleSelect : true,
	             pageList: [10,20,30, 40],
	             url : 'select_all_drug_dean',
	             method : 'get',
	             striped : true,
	             toolbar : '#yaopin_toolbar'
	        ">   
	    <thead>   
	     	 <tr>   
	            <th colspan="9">药品基本信息</th>   
	            <th colspan="3">药库库存信息</th>   
	            <th colspan="3">药房库存信息</th>   
	        </tr>   
	        <tr>   
	            <th data-options="field:'drugId',width:60">药品编号</th>   
	            <th data-options="field:'drugName',width:110">药品名称</th>   
	            <th data-options="field:'pric12e',width:60 , formatter : function(value , row , index){
	            	return row.drugType.text;
	            }">药品分类</th>   
	            <th data-options="field:'pric213e',width:50, formatter : function(value , row , index){
	            	return row.unit.text;
	            }">单位</th>   
	            <th data-options="field:'drugBzdate',width:60">保质天数</th>   
	            <th data-options="field:'drugGg',width:50">规格</th>   
	            <th data-options="field:'drugPfprice',width:60">批发单价</th>   
	            <th data-options="field:'drugLsprice',width:60">零售单价</th> 
	            <th data-options="field:'drugBz',width:80">备注</th>     
	            <th data-options="field:'p31rice',width:65, formatter : function(value , row , index){
	            	return row.yaokuKucun.yaokuKucunNum;
	            } , 
		            styler: function(value,row,index){
		            
						if (row.yaokuKucun.yaokuKucunNum <= row.yaokuKucun.yaokuKucunBottom){
							return 'color:red;font-weight : bold';
						}
					}
	            
	            ">药库库存</th>   
	            <th data-options="field:'prrice',width:65, formatter : function(value , row , index){
	            	return row.yaokuKucun.yaokuKucunTop;
	            }">药库上限</th>   
	            <th data-options="field:'preqice',width:65, formatter : function(value , row , index){
	            	return row.yaokuKucun.yaokuKucunBottom;
	            }">药库下限</th>   
	            <th data-options="field:'pr321ice',width:65, formatter : function(value , row , index){
	            	return row.yaokuKucun.yaofangKucunNum;
	            } ,
	             styler: function(value,row,index){
					if (row.yaokuKucun.yaofangKucunNum <= row.yaokuKucun.yaofangKucunBottom){
						return 'color:red;font-weight : bold';
					}
				}">药房库存</th>   
	            <th data-options="field:'priqce',width:65, formatter : function(value , row , index){
	            	return row.yaokuKucun.yaofangKucunTop;
	            }
	            ">药房上限</th>   
	            <th data-options="field:'prwerfice',width:65, formatter : function(value , row , index){
	            	return row.yaokuKucun.yaofangKucunBottom;
	            }">药房下限</th>   
	        </tr>   
	    </thead>   
	</table>  
	
			
	<div id="yaopin_toolbar" style="">
		<input id="sousuo_drug_id_name" class="easyui-searchbox" style="width:200px ;height: 22px" 
			data-options="label:'编号/药品名' , labelWidth:75 , 
				searcher : function(value , name){
		    		if(value == null || value == ''){
		    			$('#durg_dean_tab').datagrid('reload' , 'select_all_drug_dean');
		    		}else{
		    			$('#durg_dean_tab').datagrid({url : 'select_all_drug_dean_where'});
					    $('#durg_dean_tab').datagrid('load' , {key : value});
		    		}
		    	}
			"></input> 
		<select id="drug_dean_type" class="easyui-combobox" data-options="
			method:'post',
			valueField:'id',
			textField:'text',
			url:'select_all_drug_type_dean'
		,editable:false, label : '药品分类' , labelWidth:'57' ,height:22" style="width:160px;">   
		</select>
		<select id="yao_ku_ku_cun_dean" class="easyui-combobox" data-options="editable:false, label : '药库库存' , labelWidth:'57' ,height:22" style="width:160px;">   
		    <option value="0">全部</option>   
		    <option value="-1">低于药库下限</option>   
		    <option value="1">高于药库下限</option>   
		</select>
		<select id="yao_fang_ku_cun_dean" class="easyui-combobox" data-options="editable:false, label : '药房库存' , labelWidth:'57' ,height:22" style="width:160px;">   
		    <option value="0">全部</option>   
		    <option value="-1">低于药房下限</option>   
		    <option value="1">高于药房下限</option>   
		</select>
		  <a id="drug_dean_search" href="#" class="easyui-linkbutton"
		  	 data-options="iconCls:'icon-search',plain:true,text:'搜索' ,
		  	 ">
		  </a>
		  <a id="" href="#" class="easyui-linkbutton" 
			  data-options="iconCls:'icon-reload',plain:true,text:'显示所有' , 
			  onClick : function(){
				  	$('#durg_dean_tab').datagrid('reload' , 'select_all_drug_dean');
				  	$('#sousuo_drug_id_name').textbox('setValue' , '');
					$('#drug_dean_type').combobox('setValue' , '全部');
					$('#yao_ku_ku_cun_dean').combobox('setValue' , '全部');
					$('#yao_fang_ku_cun_dean').combobox('setValue' , '全部');
			  }
			  ">
		  </a>
	</div>
	
	<script type="text/javascript">
		$(function(){
			$("#drug_dean_search").linkbutton({onClick : function(){
				var key = $("#sousuo_drug_id_name").textbox("getValue");
				var type = $("#drug_dean_type").combobox("getValue");
				var ku = $("#yao_ku_ku_cun_dean").combobox("getValue");
				var fang = $("#yao_fang_ku_cun_dean").combobox("getValue");
				$("#durg_dean_tab").datagrid({url : 'select_all_drug_dean_grade_where'});
				$("#durg_dean_tab").datagrid("load" , {key : key , type : type , ku : ku , fang : fang});
			}});
		})
	</script>
</body>
</html>