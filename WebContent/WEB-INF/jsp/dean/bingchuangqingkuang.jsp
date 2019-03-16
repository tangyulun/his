<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>病床情况</title>
</head>
<body>
   	<table class="easyui-datagrid" id="bingCHuang_table"
     			 data-options="url:'select_all_beds',fitColumns:true,singleSelect:true , rownumbers : true , 
     			  pagination: true,
     			  fit:true,
	            pageSize: 10,
	            border:false,
	            singleSelect : true,
	            pageList: [10,20,30, 40],
	            method : 'get',
	            toolbar : '#bingchuang_td'
     			 ">   
	    <thead>   
	        <tr>   
	            <th data-options="field:'bedId',width:8">病床号</th>   
	            <th data-options="field:'bedName',width:11">床位名</th>   
	            <th data-options="field:'bingchuangWeizhi',width:11">病床位置</th>   
	            <th data-options="field:'bingchaungType',width:11">病床分类</th>   
	            <th data-options="field:'bingRenName',width:10">病人姓名</th>   
	            <th data-options="field:'bongRenSex',width:5">性别</th>    
	            <th data-options="field:'ruYaundate',width:10,formatter : date">入院日期</th>    
	            <th data-options="field:'houseState',width:10 , 
		            	styler: function(value,row,index){
							if (value ==  '已占用'){
								return 'color:red;';
						}
					}
	            	
	            ">病床状态</th> 
	            <th data-options="field:'bedCreateDate',width:10 , formatter : date">创建日期</th>   
	            <th data-options="field:'bedRemark',width:19">备注</th>   
	        </tr>   
	    </thead>   
	</table>  
	
	<div id="bingchuang_td" style="">
	<div style="margin-left: 15px;">
		<input id="sousuo_nameg_and_id" class="easyui-searchbox" style="width:260px ;height: 22px" 
			data-options="label:'编号/病床名/病人姓名' , labelWidth:125 , 
				searcher : function(value , name){
		    		if(value == null || value == ''){
		    			$('#bingCHuang_table').datagrid('reload' , 'select_all_beds');
		    		}else{
		    			$('#bingCHuang_table').datagrid({url : 'select_all_beds_where'});
					    $('#bingCHuang_table').datagrid('load' , {key : value});
		    		}
		    	}
			"></input> 
		<select id="bing_chuang_state" class="easyui-combobox" data-options="editable:false, label : '状态' , labelWidth:'30' ,height:22" style="width:160px;">   
		    <option value="全部">全部</option>   
		    <option value="未占用">未占用</option>   
		    <option value="已占用">已占用</option>   
		</select>
		<select id="bing_chuang_sex" class="easyui-combobox" data-options="editable:false, label : '性别' , labelWidth:'30' ,height:22" style="width:160px;">   
		    <option value="全部">全部</option>   
		    <option value="男">男</option>   
		    <option value="女">女</option>   
		</select>
		  <a id="bing_chuang_search" href="#" class="easyui-linkbutton"
		  	 data-options="iconCls:'icon-search',plain:true,text:'搜索' ,
		  	 ">
		  </a>
		  <a id="" href="#" class="easyui-linkbutton" 
			  data-options="iconCls:'icon-reload',plain:true,text:'显示所有' , 
			  onClick : function(){
				  	$('#bingCHuang_table').datagrid('reload' , 'select_all_beds');
			  		$('#sousuo_nameg_and_id').textbox('setValue' , '');
					$('#bing_chuang_state').combobox('setValue' ,'全部');
					$('#bing_chuang_sex').combobox('setValue' , '全部');
			  }
			  ">
		  </a>
	</div>
	</div>
	
	<script type="text/javascript">
		$(function(){
			$("#bing_chuang_search").linkbutton({onClick : function(){
				var key = $("#sousuo_nameg_and_id").textbox('getValue');
				var state = $("#bing_chuang_state").combobox('getValue');
				var sex = $("#bing_chuang_sex").combobox('getValue');
				$('#bingCHuang_table').datagrid({url : 'select_all_beds_where_grade'});
			    $('#bingCHuang_table').datagrid('load' , {key : key , state : state , sex : sex});
			}});
		});
	</script>
</body>
</html>