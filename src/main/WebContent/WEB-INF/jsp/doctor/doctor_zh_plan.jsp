`<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
</head>
<body>

	<style type="text/css">
		.left{
			margin-left: 50px;
		}
		.left li{
			list-style: none;
			float: left;
			width: 100px;
			height:30px;
			margin:1px;
			line-height: 30px;
		}
		#top_div_style , .right{
			width: 98%;
			height:58px;
			border: 1px solid #ddd;
			margin: 10px 0px 0px 11px;
		}
		
		.right{
			height:400px;
			border: 0px;
			clear: both;
		}
		
		.right table{
			border:1px solid #ddd;
			color:#333333;
		    border-width: 1px;
		    border-color: #ddd;
		    border-collapse: collapse;
		}
		.right table tbody tr{
			 height:25px;
			 text-align: center;
		}
		tr li {
			float: left;
			margin: 2px;
		}
		.item{
			text-align:center;
			border:1px solid #499B33;
			width: 70px;
			height:20px;
			line-height:18px;
			list-style: none;
		}
		#ul_top_lajitong{
			border:none;
			border-right:1px solid #ddd;
			height:100% ;
			width : 30px;
			margin-top:0px;
			float: left;
		}
		.lj_style{
			background: #ddd;
		}
		.week_day_is{
			width:100%;
			height: 30px;
		}
		.week_day_is_span{
			margin-top: 12px;
			margin-left:10px;
			float: left;
			font-weight: bold;
		}
		.week_day_is_span2{
			float: right;
			margin-right: 15px;
		}
		
</style>

	<script>
	
	//分页数据，
	var page = 1 , rows = 5  , maxPage = 0;//班次分页
	var pageE = 1 , rowsE = 10 , maxPageE = 0;
	var isCX = true;
	//值班类型
	var zhibanType = "门诊排班";
		$(function(){
			loadBClass();
		});
		//计算本周星期一和星期天
		function weekDay(url , url2 , value){
			$.getJSON(url , {'monday' : value} ,function(data){
				$('#today_week').text(data.object);
				$('#last_week').text(data.value);
				$.getJSON(url2 ,  {'monday' : value== null ? data.object : value} ,function(data){
					for (var i = 0; i < data.length; i++) {
						$('.title').eq(i).html(data[i]);
					}
				});
			});
		}
		function loadBClass(){
			pagesMax();
			//计算本周星期一和星期天
			weekDay("find_monday_sunday" , "find_everyday" , null);
			$.getJSON('select_all_emp2' , {page:pageE , rows:rowsE} , function(data){
				if(isCX){
					isCX = false;
					$(".drop").parent("tr").remove();
					for (var i = 0; i <data.length; i++) {
							var $trTemp = $("<tr style='height:33px'></tr>");
							 //往行里面追加 td单元格
			                $trTemp.append("<td width='80px'>"+data[i].empLoginName+"</td>");
			                $trTemp.append("<td width='80px'>"+data[i].dclass.dclassName+"</td>");
			                $trTemp.append("<td width='120px' class='drop'></td>");
			                $trTemp.append("<td width='120px' class='drop'></td>");
			                $trTemp.append("<td  width='120px' class='drop'></td>");
			                $trTemp.append("<td  width='120px' class='drop'></td>");
			                $trTemp.append("<td  width='120px' class='drop'></td>");
			                $trTemp.append("<td  width='120px' class='drop'></td>");
			                $trTemp.append("<td  width='120px' class='drop'></td>");
			                $trTemp.appendTo(".right table");
						}
					/*  $.getJSON("select_all_paiban" , function(json){
						$("#every_week").html(json[0].tableMess);
						$('.right td li').draggable({
							revert:true,
							proxy:'clone'
						});
					});   */
				}
				$.getJSON("select_all_banci_to_plan" , {page : page , rows : rows} , function(json){
					$(".left").children('li').remove();
					for (var i = 0; i < json.length; i++) {
						if(i == 0&& page > 1){
							$("<li>").html('<').css({
								'font-size':'20px',
								'cursor' : 'pointer',
								'width' : '20px',
								'padding' : '3px',
								'color' : 'green'
							}).attr('class' , 'last').appendTo(".left");
						}
						$("<li>").html(json[i].bclassesName.length > 4 ? json[i].bclassesName.substring(0 , 4) : json[i].bclassesName).
						css({'background' : json[i].bclassesColor ,
							'width' : '65px' , 
							'borderRadius' : '10px',
							'border' : '0px',
							'cursor' : 'pointer',
							'text-align' : 'center'	
							}).attr('title' , json[i].bclassesName)
						.attr("class" , "item")
						.appendTo(".left");
						if(i == json.length-1 && maxPage != page && maxPage != 1){
							$("<li>").html('>').css({
								'font-size':'20px',
								'cursor' : 'pointer',
								'padding' : '3px',
								'margin-left' : '10px',
								'color' : 'green'
							}).attr('class' , 'next').appendTo(".left");
						}
					}	
					nextAndLast();
					move();
				});
				
			});
		}
		//计算分页数据
		function pagesMax(){
			$.get("select_banci_count" ,function(data){
				if(parseInt(data)%rows == 0){
					maxPage = parseInt(data)/rows;
				}else{
					maxPage = Math.floor(parseInt(data)/rows) + 1;
				}
			});
		}
		//next  last;
		function nextAndLast(){
			$(".last").click(function(){
				page = page - 1 ;
				loadBClass();
			});
			$(".next").click(function(){
				page = page + 1 ;
				loadBClass();
			});
		}
		
		//move 
		function move(){
			$('.left .item').draggable({
				revert:true,
				proxy:'clone'
			});
			$('.right td li').draggable({
				revert:true,
				proxy:'clone'
			});
			$('.right td.drop').droppable({
				onDragEnter:function(){
					$(this).addClass('over');
				},
				onDragLeave:function(){
					$(this).removeClass('over');
				},
				onDrop:function(e,source){
					$(this).removeClass('over');
					if ($(source).hasClass('assigned')){
						if($(this).children('li').length<2){
							var c = $(source).addClass('assigned')
							if(c.text() != $(this).children('li').text()){
								$(this).append(c);
							}
						}
					} else {
						var c = $(source).clone().addClass('assigned');
						if($(this).children('li').length<2){
							if(c.text() != $(this).children('li').text()){
								$(this).append(c);
							}
						}
						c.draggable({
							revert:true
						});
					}
				}
			});
			$('#ul_top_lajitong').droppable({
				onDragEnter : function(){
					$(this).addClass('lj_style');
				},
				onDragLeave : function(){
					$(this).removeClass('lj_style');
				},
				onDrop : function(e , source){
					if ($(source).hasClass('assigned')){
						source.remove();
					}
					$(this).removeClass('lj_style');
				}
			});
			
		}
		
		var i = 0;
		//删除界面
		$(function(){
			$("#chongxinpaiBan").linkbutton({onClick : function(){
				$.messager.confirm('确认对话框', '你确定要清除排班记录吗？', function(r){
					if (r){
						$(".right table tr td li").remove();
					}
				});
			}});	
			//下一周
			$("#last-week").linkbutton({onClick : function(){
				weekDay("last_week" , "last_week_tow" , $('#today_week').text());
			}});
			$("#next-week").linkbutton({onClick : function(){
				weekDay("next_week" , "next_week_tow" ,  $('#today_week').text());
			}});
			
			$("#ben_week").linkbutton({onClick : function(){
				weekDay("find_monday_sunday" , "find_everyday" , null);
			}});
			//保存排班
			$("#baocunPaiban").linkbutton({onClick : function(){
				if($(".right td li").length == 0){
					$.messager.alert("提示" , "你还没有排班呢？");
					return ;
				}
				//开始时间、结束时间、排班内容、排班类型
				var startDate = $("#today_week").text();
				var endDate = $("#last_week").text();
				var planMessage = $(".right table").html();
				$.post("insert_paiban_plan" , {beOnDutyPlanStartDate : startDate , beOnDutyPlanEndDate : endDate,
					mess : planMessage
					} , 
					function(data){
						$('#cc_update').combobox('reload');  
						var json = eval('('+data+')');
						if(json.error){
							//成功
							$.messager.alert('提示' , "排班添加成功！");
							$("#cc_update").combobox('clear');
							$("#update_paiban").hide();
							clicks2 = 0;
							$("#updatepaiban").linkbutton({text :"编辑/复制"}); 
							$(".right table tr td li").remove();
						}else{
							//失败
							$.messager.confirm('确认对话框','该周已经排过班！是否修改！', function(r){
								if (r){
									$.post("update_paiban_message" , {planId : json.eMessage , mess : planMessage},
											function(data){
											var json = eval('('+data+')');
												if(json.error){
													//修改
													$.messager.alert('提示' , "排班修改成功！");
													$("#cc_update").combobox('clear');
													$("#update_paiban").hide();
													clicks2 = 0;
													$("#updatepaiban").linkbutton({text :"编辑/复制"}); 
													$(".right table tr td li").remove();
												}else{
													$.messager.alert('提示' , json.eMessage);
												}
									});
								}
							});
						}
					}
				);
			}});
			
			//选择排班类型查询不同的员工
			$("#paiban_select_combobox").combobox({onChange : function(){
				var com = $(this).combobox("getValue");
				zhibanType = com;
				isCX = true;
				loadBClass();
			}});
		});
		
		$(function(){
			 var clicks2 = 0 ;
			//排班复制
			 $("#updatepaiban").linkbutton({onClick : function(){
				$("#updatepaiban").linkbutton({text :"取消"}); 
					if(clicks2 == 0){
						//选择排班
						clicks2 = 1;
						$("#update_paiban").show();
					}else{
						$("#cc_update").combobox('clear');
						$("#update_paiban").hide();
						clicks2 = 0;
						$("#updatepaiban").linkbutton({text :"编辑/复制"}); 
						$(".right table tr td li").remove();
					} 
			
			 }}); 
			
			 $("#cc_update").combobox({onChange : function(newValue , oldValue){
				  $.getJSON("select_all_paiban" , function(json){
					  for (var i = 0; i < json.length; i++) {
						if(newValue == json[i].beOnDutyPlanId){
							$("#every_week").html(json[i].tableMess);
							$('#today_week').text(date(json[i].beOnDutyPlanStartDate));
							$('#last_week').text(date(json[i].beOnDutyPlanEndDate));
						}
					}
					move();
				});   
			}}); 
		});
	</script>
</head>
<body>
		<div id="top_div_style">
			<ul id="ul_top_lajitong">	
				<img alt=""  style="margin:10px 0px 0px -22px;float: left;" width="35px" height="38px" src="<c:url value="/images/tsp/delete-bcsz.png"/>">
			</ul>
			 <ul class="left">
				
			</ul>
	    </div>   
	   <div class="right">
	   			<div class="week_day_is">
	   				<span class="week_day_is_span">
		   				 <a id="today_week">2018-03-19 </a> 至 <a id="last_week">2018-03-25</a> 排班表
	   				</span>
	   				<span class="week_day_is_span2">
	   					<a href="#" id='last-week' class="easyui-linkbutton" data-options="iconCls :'icon-undo',plain:true">上一周</a>
   					<a href="#" id='next-week' class="easyui-linkbutton" data-options="iconCls :'icon-redo',plain:true">下一周</a>
						<a href="#" id='ben_week' class="easyui-linkbutton" data-options="iconCls :'icon-back',plain:true">本周</a>
						<a href="#" id="updatepaiban" class="easyui-linkbutton" data-options="iconCls :'icon-edit',plain:true">编辑/复制</a>
						<span  id="update_paiban" style="display: none">
							<select id="cc_update" class="easyui-combobox" data-options="editable:false ,
							url : 'select_all_paiban2',
							method : 'get',
								valueField:'beOnDutyPlanId',textField:'dateBetween'
							" style="width:146px;">   
							</select>  
						</span>
						<a href="#" id="chongxinpaiBan" class="easyui-linkbutton" data-options="iconCls :'icon-reload',plain:true">重新排班</a>
						<a href="#" id="baocunPaiban" class="easyui-linkbutton" data-options="iconCls :'icon-save',plain:true">保存排班</a>
	   				</span>
	   			</div>
	   			<table id="every_week" border="1px" width="100%"  cellspacing="0px">
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
				</table>
		    	
	    </div>
</body>
</html>