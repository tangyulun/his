<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录记录查询</title>
</head>
<body>
	<div id="cc" class="easyui-layout" data-options="fit:true,border:false">   
	    <div data-options="region:'center',border:false" style="background : rgb(240 , 240 ,255)" >
	    	<div id="tt" class="easyui-tabs"  data-options="fit:true,border:false" >   
			    <div title="登录记录" >   
					 <table class="easyui-datagrid" 
				        data-options="fitColumns:true,rownumbers : true ,
				         pagination: true,
					             pageSize: 15,
					             border:false,
					             singleSelect : true,
					             pageList: [15,30,45, 60],
				         method : 'get' ,rownumbers : true, url : 'select_all_login_logger', fit:true  , toolbar : '#logger_tools'">   
					    <thead>   
					        <tr>   
					            <th data-options="field:'bclassesId',width:1 , 
							            formatter(value , row , index){
							            	return row.emp.empLoginName;
							            }
					            ">用户名</th>   
					            <th data-options="field:'loginTimes',width:9">登录时间</th>   
					        </tr>   
					    </thead>   
					</table>  
			    </div>   
			    <div title="每日记录" >
			    	<div style="height: 35px">
			    		<a style="margin: 5px 0px 0px 20px;position: absolute;">
				    		<select  class="easyui-combobox" id="months_day" style="width:200px;"  data-options="editable : false
				    			, label : '月份查询'  , labelWidth : '60'
				    		">   
							   <c:forEach begin="1" end="12" var="e">
							   		<option value="${e}">${e}月份</option>
							   </c:forEach>
							</select>  
			    		</a>
			    	</div>
			    	<div id='canvasDiv2' style="">
						<div class='ichartjs_info2' style="border:0px">
						</div>
				    </div> 
			    </div>   
			    <div title="每月记录">  
				    <div id='canvasDiv'>
						<div class='ichartjs_info'>
						</div>
				    </div>   
			</div>  
	    </div>   
	 </div>
	</div>
	<script type="text/javascript">
			$(function(){
				year_select();
				var date = new Date();
				$("#months_day").combobox('setValue' , date.getMonth() + 1);
				dayTongji($("#months_day").combobox("getValue"));
				$("#months_day").combobox({onChange : function(){
					dayTongji($("#months_day").combobox("getValue"));
				}});
				$("#months_day").combobox('setValue' , date.getMonth() + 1);
			});
	
	
		//年
		function year_select(){
			var str = [];
			$.getJSON("select_login_group_by" ,function(json){
				 for (var i = 1; i <= 12; i++) {
						for (var j = 0; j < json.length; j++) {
							if(i == json[j][0]){
								str.push(json[j][1]);
								break;
							}else if( j == json.length -1){
								str.push(0);
								break;
							}
						} 
						if(json == ""){
							str.push(0);
						}
				}
				 
				 var data = [
			         	{
			         		name : '月登录统计数',
			         		value:str,
			         		color:'#1385c7'
			         	}
			         ];
					var chart = new iChart.ColumnMulti2D({
							render : 'canvasDiv',
							data: data,
							labels:["一月","二月","三月","四月","五月","六月" , "七月","八月","九月","十月","十一月","十二月"],
							title : '2018年用户月登录记录统计',
							width : 1200,
							height : 498,
							background_color : '',
							legend:{
								enable:true,
								background_color : null,
								border : {
									enable : false
								}
							},
							coordinate:{
								background_color : '',
								scale:[{
									 position:'left',	
									 start_scale:0,
									 end_scale:140,
									 scale_space:20
								}],
								width:800,
								height:330
							}
					});
				chart.draw();
			});
		}
			
		//查询每月的次数记录
		function dayTongji(month){
			var strDay = [];
			var strTian = [];
			$.getJSON("select_login_logger_month" , {months : month} , function(json){
				//结果集出来获取最大天数
				$.getJSON("select_tomonth_days" , {month : month , year : '2018'} , function(data){
					for (var i = 0; i < data ; i++) {
						strTian.push(i + 1);
						for (var j = 0; j < json.length; j++) {
							if(i + 1 == json[j][0]){
								strDay.push(json[j][1]);
								break;
							}else if( j == json.length -1){
								strDay.push(0);
								break;
							}
						} 
						if(json == ""){
							strDay.push(0);
						}
					}
					var data = [
			         	{
			         		name : '日登陆统计数',
			         		value:strDay,
			         		color:'#1385a5'
			         	}
			         ];
			var chart = new iChart.ColumnMulti2D({
					render : 'canvasDiv2',
					data: data,
					labels:strTian,
					 title : '2018年 '+month+' 月天登录记录统计图',
					width : 1200,
					height : 463,
					background_color : '',
					legend:{
						enable:true,
						background_color : null,
						border : {
							enable : false
						}
					},
					coordinate:{
						background_color : '',
						scale:[{
							 position:'left',	
							 start_scale:0,
							 end_scale:140,
							 scale_space:20
						}],
						width:800,
						height:330
					}
			});
			chart.draw();
				});
			})
		}
			</script>
</body>
</html>