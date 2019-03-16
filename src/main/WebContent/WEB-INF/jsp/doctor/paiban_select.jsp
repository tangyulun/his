<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>排班查询</title>
</head>
<body>
	<style>
		#div_plan_top{
			border:1px solid #ddd;
			width:99%;
			height:35px;
			font-size: 12px;
			margin: 5px 0px 0px 6px;
		}
		#div_plan_center{
			margin-top:15px;
			border:1px solid #ddd;
			width:99%;
			height:auto;
			margin: 5px 0px 0px 6px;
		}
		li{
			list-style: none;
			height: 15px;
		}
		 #table_paiban table{
			border:1px solid #fff;
			color:#333333;
		    border-width: 1px;
		    border-color: #ddd;
		    width:100%;
		    border-collapse: collapse;
		}
		#table_paiban table tr{
			 height:25px;
			 text-align: center;
		}
		tr li {
			float: left;
			margin: 1px;
		}
		#paibantishi{
			margin-left: 440px;
			font-size: 18px;
			font-weight: bold;
			line-height: 30px;
		}
	</style>
	
	<div id="div_plan_top">
	<div style="margin: 5px 0px 0px 15px">
			
			<span style="margin: 5px 0px 0px 10px">选择
			<select id="cc_select" class="easyui-combobox" data-options="editable:false ,
							url : 'select_all_paiban2',
							method : 'get',
								valueField:'beOnDutyPlanId',textField:'dateBetween'
							" style="width:146px;">   
							</select>  
			排班表</span>
	</div>
	 
	</div>
	<div id="div_plan_center">
	 
		<span id="paibantishi">
			<a id="a1">2018-03-19 </a> 至 <a id="a2">2018-03-25</a> <a id="type">门诊排班</a>表
		</span>
		 	  <div id="table_paiban">
						<table id="every_week_select" border="1px" width="100%"  cellspacing="0px">
						<tr>
							<td colspan="2"></td>
							<td class="title">21</td>
							<td class="title">22</td>
							<td class="title">23</td>
							<td class="title">24</td>
							<td class="title">25</td>
							<td class="title">26</td>
							<td class="title">27</td>
						</tr>
						<tr style="color:red">
							<td>姓名</td>
							<td>科室</td>
							<td>星期一</td>
							<td>星期二</td>
							<td>星期三</td>
							<td>星期四</td>
							<td>星期五</td>
							<td>星期六</td>
							<td>星期天</td>
						</tr>
						<c:forEach begin="0" end="2">
							<tr class="trd">
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
						</c:forEach>
				</table>
			</div> 
			
	</div>
	
	
	<script type="text/javascript">
		$(function(){
			 $("#cc_select").combobox({onChange : function(newValue , oldValue){
				selectPlan(newValue);
			}}); 
			 //设置默认排班表
			 $.getJSON("select_today_id" , function(json){
				 if(json.error){
					 selectPlan(json.eMessage);
					 $("#cc_select").combobox('setValue' , json.eMessage);
				 }
			 });
			 
		});
		function selectPlan(id){
			  $.getJSON("select_all_paiban" , function(json){
				  for (var i = 0; i < json.length; i++) {
					if(id == json[i].beOnDutyPlanId){
						$("#every_week_select").html(json[i].tableMess);
						$('#a1').text(date(json[i].beOnDutyPlanStartDate));
						$('#a2').text(date(json[i].beOnDutyPlanEndDate));
						 $("#type").text(type);
						return ;
					}else if(i == json.length - 1){
						appendToTD();
						  $("#type").text(type);
					}
				}
				
			});   
		}
		function appendToTD(){
			$(".drop").parent("tr").remove();
			for (var i = 0; i < 3; i++) {
				$(".trd").eq(i).remove();
				var $trTemp = $("<tr class='trd'></tr>");
			       $trTemp.append("<td></td>");
	                $trTemp.append("<td></td>");
	                $trTemp.append("<td></td>");
	                $trTemp.append("<td></td>");
	                $trTemp.append("<td></td>");
	                $trTemp.append("<td></td>");
	                $trTemp.append("<td></td>");
	                $trTemp.append("<td></td>");
	                $trTemp.append("<td></td>");
	                $trTemp.appendTo("#every_week_select");
			}
		}
	</script>
</body>
</html>