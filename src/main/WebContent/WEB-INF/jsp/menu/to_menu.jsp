<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title >HIS医疗管理系统</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="h" uri="http://www.51i-star.com/his" %>
	<style type="text/css">
		.ope_style { 
			border : 1px solid #95B8E7;
			margin-left : 16px;
			padding : 1px;
			font-size: 12px;
			background : #E7F0FF;
		} 
		#dept-table-add tr{
			height:30px;
		}
		
		#weather_div{
			width:37%;
			height: 50px;
			margin-left:30%;
			margin-top:3px;
			position: absolute;
		}
		#weather_div #weather_ul{
			list-style: none;
			width:600px;
			margin-top:-25px;
			margin-left:-40px;
			height:50px;
		}
		#weather_div #weather_ul li{
			width:120px;
			height:50px;
			float: left;
			margin: 25px;
		}
		.weather_li p{
			text-align: right;
			float:right;
			width:75%;
		}
		.weather_li .p2{
			margin-top: -5px;
		}
		.weather_li .p3{
			width:40px;
			height: 40px;
			margin-top: 0px;
		}
		.weather_li .div_1{
			width: 50px;
			height: 50px;
		}
		.weather_li .div_2{
			width: 75px;
			height: 18px;
			margin: -40px 0px 0px 55px;
		}
			.weather_li .div_3{
			width: 75px;
			height: 18px;
			margin: 2px 0px 0px 55px;
		}
		
		.a1{
			width: 15px;
			height: 15px;
			border-radius:10px;
			margin-top: 35px;
			text-align:center;
			font-size:10px;
			position: absolute;
			background: #ddd;
		}
		#go_href:hover {
			cursor: pointer;
		}
		#mbm:hover{
			cursor: pointer;
		}

	</style>
	
	
	<link id="ztqh" rel="stylesheet" type="text/css" href="<c:url value="/js/easyui/themes/default/easyui.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/js/easyui/themes/icon.css"/>"> 
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/tsp/style.css"/>"> 
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/tsp/demo.css"/>"> 
		
</head>
	<body class="easyui-layout">  
    <div data-options="region:'north',disabled:true,title:'' , collapsible:false" style="height:63px;
     background-image: url(<c:url value='/images/tsp/tttt.jpg'/>);background-repeat:no-repeat;background-size:100% 1100%;
    ">
		<span id="weather_div">
	    	<span id="city_shenh" style="width:115px;height:20px;position: absolute;
	    	margin-left: -90px;margin-top: 5px;
	    	">
				正在加载中...
	    	</span>
		</span>
		
    	<span id="hisylglxt" style="font-size: 22px;font-weight:bold;margin: 17px 0px 0px 15px;position: absolute;"> HIS医疗管理系统</span>
    	<div style="float: right;margin-right: 15px; margin-top: 3px">
    		<div style="float: right;margin-right: 15px; margin-top: 30px">
	    	 <a  id="mb2" class="easyui-menubutton"     
	       			 data-options="menu:'#mm2'  , duration : 300 ">${empty empMessage.empLoginName ? '请登录' : empMessage.empLoginName}</a>   
				
				<div id="mm2" style="width:150px;">   
					<div id="login_iii">
						个人信息
					</div>
					<div id="my_wode_qian_dao">
						我的签到
					</div>
				    <div id="update-pwd-div">
				   		修改密码
				    </div>   
				    <div id="clear_session" class="login">
				    	注销
				    </div>   
				</div>  
    	</div>
    		<div style="float: right;margin-right: 25px; margin-top: 30px">
    		<a  id="mb" class="easyui-menubutton"     
        data-options="menu:'#mm'">主题设置</a> 
			<div id="mm" style="width:150px;">
				 <div data-options="">
			   		default
			    </div>      
			    <div>
			   		bootstrap
			    </div>   
			    <div>
			    	gray
			    </div>   
			    <div>
			    	material
			    </div>   
			</div>  
    	</div>
    	
    	<div style="float: right;margin-right: 25px; margin-top: 30px">
    		<a  id="mbm" class=""     
        data-options="" title="点击返回当前城市">选择城市</a> 
				<input id="city_message" class="easyui-combobox" style="width: 100px"/>
    	</div>
    	</div>
			
    </div>  
    <div data-options="region:'west',title:'功能列表',disabled:true,collapsible:false" style="width:160px;">
         	
			
           <div id="aa" class="easyui-accordion"
               data-options="
               fit:true, border:false">
              <c:forEach items="${FunctionTypeVo}" var="all">
	               <div class="funType" title="${all.functionTypeName}" data-options="iconCls : '${all.functionTypeIcon}'" style="overflow: auto; padding: 6px;">
	               		<input type="hidden" value="${all.functionTypeName}" class="typeName">
	               		<c:forEach items="${all.functions}" var="list">
			               	<h:g id="${list.functionsId}">
			               		<a class="easyui-linkbutton fun" style="width:99% ; text-align:left"
			               			data-options="text:'${list.functionsName}' , plain:true , iconCls : '' , url : '${list.functionsHref}'">
			               		</a>
			               	</h:g>
	               		</c:forEach>
	               </div>
         	 </c:forEach>
          </div>
    </div>   
    <div data-options="region:'center'">
          <div id="tt" class="easyui-tabs" data-options="
               border:false, fit:true, tools:'#tab-tools'">
               <div title="主界面" data-options="border:false" style=" padding: 5px; display: none; background-image: url(<c:url value='/images/tsp/tttt.jpg'/>);background-repeat:no-repeat;background-size:100% 100%;>">
               			 <div class="fill">
								  <div  class="clock" id="utility-clock">
								    <div class="centre" >
								      <div class="dynamic"></div>
								      <div class="expand round circle-1"></div>
								      <div class="anchor hour">
								        <div class="element thin-hand"></div>
								        <div class="element fat-hand"></div>
								      </div>
								      <div class="anchor minute">
								        <div class="element thin-hand"></div>
								        <div class="element fat-hand minute-hand"></div>
								      </div>
								      <div class="anchor second">
								        <div class="element second-hand"></div>
								      </div>
								      <div class="expand round circle-2"></div>
								      <div class="expand round circle-3"></div>
								    </div>
								  </div>
								 
								</div>
							
 								 <script src="<c:url value="/js/tsp/index.js"/>"></script>
	               	 	<!-- <div style="width: 300px ; float:right; width:303px ;margin-right:10px; height : 99.5%;border:1px solid #ddd;border-radius: 12px">
	               			 
	               		</div> -->
               </div>
          </div>
           <div id="tab-tools" style="border:none; border-bottom:solid 1px rgb(149,184,231);">
               <a href="#" id="close_cur" class="easyui-linkbutton" plain="true" iconCls="icon-remove"></a>
               <a href="#" id="close_all" class="easyui-linkbutton" plain="true" iconCls="icon-clear"></a>
          </div>
     </div>
    
     <div id="update-password-id" class="easyui-window" title="修改账户密码" data-options="
				collapsible:false,
				minimizable:false,
				maximizable:false,
				modal:true,
				method : 'get',
				href:'href_address?myValue=/staff/update_pwd' ,
				closed: true" 
				style="width:400px;height:230px;padding:5px;">
				
		</div> 
		
		    <div id="select_myself_mess" class="easyui-window" title="查询个人信息" data-options="
				collapsible:false,
				minimizable:false,
				maximizable:false,
				modal:true,
				method : 'get',
				closed: true" 
				style="width:500px;height:350px;padding:5px;">
				
		</div> 	
		
		 <div id="select_login_jilu" class="easyui-window" title="我的个人信息" data-options="
				collapsible:false,
				minimizable:false,
				maximizable:false,
				modal:true,
				method : 'get',
				closed: true" 
				style="width:500px;height:350px;">
				<div id="tt_myself_message" class="easyui-tabs" data-options="boder:false , fit:true" style="width:500px;height:350px;">   
				    <div title="我的基本信息" data-options="border:false,method:'get' , href : 'href_address?myValue=/staff/myself_message'" style="display:none;">   
				        
				    </div>   
				    <div title="拥有角色" data-options="" style="display:none;">   
				         <table  class="easyui-datagrid" 
	      					 data-options="border:false,url : 'select_emp_roles?empId=${empMessage.empId}' , fit:true,toolbar:'#roles_tool_roles' , fitColumns:true,singleSelect:false , method : 'get' , border:false , fit : true , rownumbers : true
				      		">   
						    <thead>   
						        <tr>   
						            <th data-options="field:'rolesId',width:2">编号</th>   
						            <th data-options="field:'rolesName',width:5">角色名</th>   
						        </tr>   
						    </thead>   
						</table>     
				    </div>   
				    <div title="功能列表" data-options="" style="display:none;">   
				         <table  class="easyui-datagrid" 
	      					data-options="border:false,url : 'select_emp_functions?empId=${empMessage.empId}' , height:500,fitColumns:true,singleSelect:true , method : 'get' , border:false , fit : true , rownumbers : true
	      				">   
						    <thead>   
						        <tr>   
						        	<th data-options="field:'functionsId',width:2">编号</th>
						            <th data-options="field:'functionsName',width:5">功能名</th>   
						        </tr>   
						    </thead>   
						</table>   
				    </div>   
				    <div title="登录记录" data-options="method: 'get' ,  href:'href_address?myValue=staff/my_login_logger'" style="display:none;">   
				        
				    </div>   
				</div>  
				
		</div> 		
	
	
	<div id="select_qian_dao" class="easyui-window" title="我的签到"  data-options="
				collapsible:false,
				minimizable:false,
				maximizable:false,
				method : 'get',
				closed : true,
				modal:true,
				href : 'href_address?myValue=menu/qiandao'"
				style="width:355px ; height:344px;border-radius: 10px">
	</div>
					
</body>

<script type="text/javascript" src="<c:url value="/js/jquery-3.1.0.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/tsp/com_page.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/tyl/tyl.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/lym/lym.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/lzx/lzx.js"/>"></script>

<script type="text/javascript" src="<c:url value="/js/tsp/highcharts.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/tsp/grid.js"/>"></script>

<script type="text/javascript" src="<c:url value="/js/tsp/date.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/easyui/jquery.easyui.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/easyui/easyui-lang-zh_CN.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/tsp/ichart.1.2.min.js"/>"></script>

<script type="text/javascript" src="<c:url value="/js/tl/amcharts.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/tl/serial.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/tl/light.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/tsp/jquery.printarea.js"/>"></script>

<script type="text/javascript" src="<c:url value="/js/tsp/pinyin.js"/>"></script>

<script language="Javascript"> 
document.onselectstart=new Function("event.returnValue=false"); 
</script> 
<script type="text/javascript">
	$(function(){
		$.getJSON("select_to_day_qian_dao" , function(json){
			  if(json.error){
				$("#select_qian_dao").window('open');
			}  
		});
		for(var i = $(".funType").length-1 ; i>=0 ; i--){
			  if($(".funType").eq(i).children("a").length == 0){
				$("#aa").accordion("remove" ,$(".typeName").eq(i).val());
			  }  
		}
	});
		var addTab = function(title , url){
				//判断是否已经存在
					 if($("#tt").tabs("exists" , title)){
						//打开
						$("#tt").tabs("select" , title);
						var tab = $('#tt').tabs('getSelected');  // 获取选择的面板
						if(title != '门诊处方' && title != '住院处方'){
							tab.panel('refresh', 'href_address?myValue='+url);
						}
					}else{ 
						//不存在
						  $("#tt").tabs("add" ,{
							title : title,
							href : 'href_address?myValue='+url+"&e="+title,
							closable: true
						}); 
					}
				}
		
		$(function(){
			$(".fun").linkbutton({onClick : function(){
				var title = $(this).linkbutton("options").text;
	            var url = $(this).linkbutton("options").url;
				addTab(title , url);
			}});
			
			$("#close_cur").linkbutton({onClick : function(){
				var tab = $("#tt").tabs("getSelected");
				var tabIndex = $("#tt").tabs("getTabIndex",tab);
				if(tabIndex != 0){
					$("#tt").tabs("close" , tabIndex);
				}
			}});
			
			$("#close_all").linkbutton({onClick : function(){
				var tabs = $("#tt").tabs("tabs");
				for (var i = tabs.length-1; i > 0; i--) {
					$("#tt").tabs("close" , i);
				}
			}});
		
			var zhuti = ["<c:url value='/js/easyui/themes/default/easyui.css'/>" , 
				"<c:url value='/js/easyui/themes/bootstrap/easyui.css'/>", 
				"<c:url value='/js/easyui/themes/gray/easyui.css'/>" ,
				"<c:url value='/js/easyui/themes/material/easyui.css'/>"];
			$("#mm div").click(function(){
				$("#ztqh").attr("href" , zhuti[$(this).index()-1]);
			});
			
			
			$("#clear_session").click(function(){
				$.messager.confirm('提示', '您确认要注销账户吗？', function(v){
                    if(v){
                    	window.location.href="login";
                    }
                });
			});
			
			$("#update-pwd-div").click(function(){
				$('#update-password-id').window('open').window('refresh');
			});
			
			
			$("#login_iii").click(function(){
				$("#select_login_jilu").window("open");
			}); 
			$("#my_wode_qian_dao").click(function(){
				$("#select_qian_dao").window('open');
			}); 
		});
</script>
<script type="text/javascript">
	$(function(){
		//先使用city.js导入城市列表
		$('#city_message').combobox({    
		    url:'/HIS/js/tsp/city.json',    
		    method : 'get',
		    valueField:'areaid',    
		    textField:'countyname'   
		});
		$.getJSON('select_zz_weather' , function(data){
			weathers(data);
		});
		$("#city_message").combobox({onChange:function(newValue , oldValue){
			$("#city_shenh").html("正在加载中...");
			$.getJSON('select_zz_weather' , {cityId : newValue} ,  function(data){
				weathers(data);
			});
		}});
		$("#city_message").combobox("select" , "101250301");
		$("#mbm").click(function(){
			$("#city_message").combobox("select" , "101250301");
		});
	});
	

	function weathers(data){
		$("#city_shenh").html("当前城市：<span id='go_href' title='点击查看天气详情'>"+data.cityName+"</sapn>");
		if(data != null){
			var weather = data.weathers;
			$(".weather_ul").remove();
			var $ul = $("<ul id='weather_ul' class='weather_ul'>");
			for (var i = 0; i < weather.length; i++) {
				$ul.append(
				$("<li class='weather_li'>"
					+"<div class='div_1' style='background-image:url("+weather[i].image+");background-repeat:no-repeat;background-size:95% 95%'>"
						+"<a class='a1'>"+weather[i].daysName+"</a>"
					+"</div>"
					+"<div class='div_2'>"+ weather[i].weather +"</div>"
					+"<div class='div_3'>"+ weather[i].tempNightC + "℃  ~ " +weather[i].tempDayC +"℃</div>"
				+"</li>"));
				$ul.appendTo("#weather_div");
			} 
		}else{
			$.messager.alert("提示" , "请求超时！");
		}
		
		$('#go_href').click(function(){
           var tq = ConvertPinyin($(this).text());
            alert(tq);
			window.open("http://tianqi.sogou.com/"+tq);
		});
	}
</script>

</html>