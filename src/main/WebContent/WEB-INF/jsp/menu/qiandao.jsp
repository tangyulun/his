<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<body>
	<style type="text/css">
		#qian-dao-button-div{
			width: 99%;
			border-radius: 10px;
			height:250px;
			border: 1px solid #ddd;
		}
		#qian-dao-top-div{
			width: 99%;
			height:30px;
		}
		#qian-dao-center-div{
	       border:1px solid #ddd;
			padding : 5px;
			margin:5px;
			border-radius: 10px;
		}
		#span_new_date_span{
			position :absolute;
			margin-top: 6px;
			margin-left:7px;
		}
		
		#span_new_date_span_qiandao{
			float: right;
			margin-right: 5px;
		}
		 #qian_dao_table{
			border:1px solid #ddd;
			color:#333333;
		    border-width: 1px;
		    border-color: #ddd;
		    border-collapse: collapse;
		    border-radius: 10px 15px 20px 30px;
		    overflow:hidden; 
		}
	</style>
	
	<div id="cc" class="easyui-layout" data-options="fit:true">   
			<!-- <div data-options="region:'east'" style="width:32%">
		    	
		    </div>    -->
		    <div data-options="region:'center'" style="width:68%">
				<div id="qian-dao-center-div">
				    	<div id="qian-dao-top-div">
				    		<span id="span_new_date_span">
				    			
				    		</span>
				    		<span id="span_new_date_span_qiandao">
				    			<a id="qian_dao_btn" class="easyui-linkbutton" data-options="plain: true,iconCls : 'icon-edit'">签到</a>
				    		</span>
				    	</div>
				    	<div id="qian-dao-button-div">
				    		<table id="qian_dao_table" border="1" cellpadding="0" cellspacing="0" width="100%">
			    				<tr height="30px" align="center" style="font-weight: bold;">
				    				<td class="xq0">周日</td>
				    				<td class="xq1">周一</td>
				    				<td class="xq2">周二</td>
				    				<td class="xq3">周三</td>
				    				<td class="xq4">周四</td>
				    				<td class="xq5">周五</td>
				    				<td class="xq6">周六</td>
			    				</tr>
				    		</table>
				    	</div>
				 </div>   
			</div>
	</div> 
	
	
	<script type="text/javascript">
		//获取系统日期
		function createDate(){
			var date = new Date();
			var year = date.getFullYear();
			var month = date.getMonth()+1< 10  ?  "0"+parseInt(date.getMonth() + 1)  : date.getMonth()+1 ;
			var day = date.getDate();
			return year + "年" + month + "月" + day + "日";
		}
		
		$(function(){
			loadDays();
			$('#span_new_date_span').text(createDate());
			//签到
			$("#qian_dao_btn").linkbutton({onClick : function(){
				var day = new Date().getDate();
					 $.getJSON('insert_qian_dao' , function(data){
						if(data.error){ 
							for (var i = 0; i < $('#qian_dao_table td').length; i++) {
								if($('#qian_dao_table td')[i].innerHTML == day){
									$('#qian_dao_table td')[i].style.backgroundImage="url(<c:url value='/images/tsp/qiandao_icon.png'/>)";
									$('#qian_dao_table td')[i].style.backgroundRepeat='no-repeat';
									$('#qian_dao_table td')[i].style.backgroundSize='80% 80%';
									$('#qian_dao_table td')[i].style.backgroundPosition='40% 50%';
									$.getJSON("select_all_qian_dao_days" , function(json){
										$("#qian_dao_btn").linkbutton({text : " 本月共签到  <span style='color:red;font-weight:bold;font-size:16px'>"+json.qdDay+"</span> 天"});
										$("#qian_dao_btn").linkbutton({iconCls : "icon-ok"});
									});
								}
							}
						}
					});
			}});
		});
		
		//加载天数
		function loadDays(){
			$.getJSON("select_all_qian_dao_days" , function(json){
				var day = 0;
				for(var i = 0 ; i < 5 ; i ++){
					var $trTemp = $("<tr height='43px' align='center' >");
					 //往行里面追加 td单元格
					 for (var j = 0; j < 7; j++) {
						 if(json.isFlag[day]){
				              $trTemp.append("<td class='sb' style='background-image:url(<c:url value='/images/tsp/qiandao_icon.png'/>);background-repeat:no-repeat;background-size:80% 80%; background-position: 40% 50%'>"+json.qdAllDate[day++]+"</td>");
				              if(day - json.moneyDay == new Date().getDate()){
									$("#qian_dao_btn").linkbutton({text : " 本月共签到  <span style='color:red;font-weight:bold;font-size:16px'>"+json.qdDay+"</span> 天"});
									$("#qian_dao_btn").linkbutton({iconCls : "icon-ok"});
							  }
						 }else{
							  $trTemp.append("<td  class='sb' >"+json.qdAllDate[day++]+"</td>");
						 }
					}
	                $trTemp.appendTo("#qian_dao_table");
				}
				for (var i = 0; i < $('#qian_dao_table td').length; i++) {
					if($('#qian_dao_table td')[i].innerHTML == 'undefined'){
						$('#qian_dao_table td')[i].innerHTML='';
						$('#qian_dao_table td')[i].style.backgroundImage='';
					}
				}
			});
		}
		
	</script>
	
</body>
</html>