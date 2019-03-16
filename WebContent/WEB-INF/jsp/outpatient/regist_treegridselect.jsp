<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>门诊记录查询</title>
</head>
<body >
<% 
	request.getSession().setAttribute("month", Integer.parseInt(new SimpleDateFormat("MM").format(new Date())));
%>
	<div id="" class="easyui-tabs" data-options="border:false,fit:true"  style="border:none;" >
		<div title="门诊记录" >
			<div id="" class="easyui-layout" data-options="fit:true,border:false" >   
			    <div data-options="region:'center',border:false">
			    	<table id="outregist-code-tb" class="easyui-datagrid" style="width:90%;"   
		      			 data-options="
		      			 border:false,
		    				fit : true,
							fitColumns:true,
							pagination:true,
							rownumbers:true,
							pageSize:4,
							singleSelect:true,
							method:'get',
							url:'query_history_registall',
							toolbar:'#regist-tbssss',
							pageList:[4,8,12,16]">   
			   			<thead>
							<tr>
								<th data-options="field:'treeField',width:135,align:'left'">门诊记录号</th>
								<th data-options="field:'eletronicId',width:135,align:'left'">处方记录号</th>
								<th data-options="field:'dclass',width:100,align:'left',
									formatter(value , row , index){
										if(row.dclass != null){
											return row.dclass.dclassName;
										}
										return value;
									}
									">科室</th>
								<th data-options="field:'value2',width:100,align:'left',
									formatter(value , row , index){
										if(row.medical != null){
											return row.medical.medicalCardName;
										}
										return value;
									}">病人姓名</th>
								<th data-options="field:'outpaitentRegistType',width:100,align:'left'">挂号类型</th>
								<th data-options="field:'value3',width:70,align:'left',
									formatter(value , row , index){
										if(row.emp != null){
											return row.emp.empLoginName;
										}
										return value;
									}">创建人</th>
								<th data-options="field:'outpaitentRegistZhuangtai',width:50,align:'left'">状态</th>
								<th data-options="field:'outpaitentRegistGuahaoTime',width:150,align:'left'">挂号日期</th>
							</tr>
						</thead>
					</table>  
				    <div id="regist-tbssss" >
				   		<span style="margin-left: 10px">门诊号   <input id="outregistqk-searchbox" class="easyui-searchbox" style="width:150px;"
				   			data-options="
				   				searcher : function(value , name){
									 			if(value==null){
									 				$('#outregist-code-tb').datagrid('reload','select_outRegist_all');
									 			}else{
									 				$('#outregist-code-tb').datagrid({url : 'query_registdata_like'});
									 				$('#outregist-code-tb').datagrid('load',{outpaitentRegistId : value});
									 			}
									 		} 	
				   			"/></span>
						<span style="margin-left: 10px"><input name="" class="easyui-datebox" value="new Date()" id="outregistqk-startTime"
								data-options="label:'查询区间  ',width:200,labelAlign:'right',labelWidth:60">
						至 <input name="" class="easyui-datebox" value="new Date()" id="outregistqk-endTime" data-options="width:130"></span>
						<span style="margin-left: 20px">状态   <select class="easyui-combobox" data-options="" id="outregistqk-zt-combobox" style="width:100px;" >
										<option value='全部' selected="selected">全部</option>
										<option value='未处理'>未处理</option>
										<option value='已处理'>已处理</option>
										<option value='已划价'>已划价</option>
										<option value='已结算'>已结算</option>
									</select>
						</span>
						<a id="outregistqk-sear-btn"
							href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true"
							style="width: 70px">搜索</a>
						<a id="outregistqk-showall-btn"
							href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-reload',onClick : function(){
								$('#outregist-code-tb').datagrid({url : 'query_history_registall'});
								deleteOutregistCodeXq('#outregistcodexq-tb');}"
							style="width: 90px" >显示所有</a>
					</div> 
			    </div> 
				
				<div data-options="region:'south',border:false,collapsible:false" style="height:300px;">
			    	<table id="outregistcodexq-tb" class="easyui-datagrid" style="width:90%"   
		      			 data-options="
		    				fit : true,
							fitColumns:true,
							rownumbers:true,
							border:false,
							method:'get'
						">   
			   			<thead>
							<tr>
								<th data-options="field:'financialHistoryShoufeilx',width:100,align:'left'">收费类型</th>
								<th data-options="field:'financialHistoryShoufeiName',width:100,align:'left'">收费项目名称</th>
								<th data-options="field:'financialHistoryPrice',width:100,align:'left'">单价</th>
								<th data-options="field:'financialHistoryNum',width:100,align:'left'">数量</th>
								<th data-options="field:'financialHistoryShoufeije',width:100,align:'left'">金额</th>
								<th data-options="field:'financialHistoryShoufeizt',width:100,align:'left'">状态</th>
								<th data-options="field:'prescriptionRecodeExplain',width:200,align:'left'">说明</th>
								<th data-options="field:'financialHistoryShoufeisj',width:200,align:'left'">收费记录时间</th>
							</tr>
						</thead>
					</table>  	
			    </div>  
		    </div>
    	</div> 
    	<div title="门诊挂号统计图" >
    		  <div style="width:100%;margin: 0px auto;height:40px;font-size: 22px;line-height:50px;font-weight: bold;text-align: center;">2018年<span id="month-span"> ${month} </span>月份门诊日统计图</div>
    		  <div id="chartdiv1" style="width:80%; height: 400px;margin-left: 90px"></div>
    		  <div style="float: right;margin :-370px 10px 0px 0px;">
    		  		月份查询：<select style="width: 100px" class="easyui-combobox"  data-options="editable:false" id="menzhenguahaotj-combobox">
    		  					<c:forEach begin="1" end="12" var="m">
    		  						<c:if test="${month == m}">
	    		  						<option value="${m}"  selected="selected">${m}月份</option>
    		  						</c:if>
    		  						<c:if test="${month != m }">
    		  							<option value="${m}" >${m}月份</option>
    		  						</c:if>
    		  					</c:forEach>
    		  				 </select>
    		  </div>
    	</div>
	</div>
	<script type="text/javascript">
		$(function(){
			$('#outregistqk-sear-btn').linkbutton({onClick : function(){
				var outregistqkSearchbox = $('#outregistqk-searchbox').searchbox('getValue');
				var outregistqkStartTime = $('#outregistqk-startTime').datebox('getValue');
				var outregistqkEndTime = $('#outregistqk-endTime').datebox('getValue');
				var outregistqkztCombobox = $('#outregistqk-zt-combobox').combobox('getValue');
				$('#outregist-code-tb').datagrid({url : 'query_outregist_sumcode'});
				$('#outregist-code-tb').datagrid('load',{outregistqkSearchbox : outregistqkSearchbox,
					outregistqkStartTime : outregistqkStartTime,	outregistqkEndTime :outregistqkEndTime,
					outregistqkztCombobox : outregistqkztCombobox});
				}});
			
			$('#outregist-code-tb').datagrid({onClickRow :function(index,rows){
				$('#outregistcodexq-tb').datagrid({url : 'query_outregistcodexq'});
				$('#outregistcodexq-tb').datagrid('load' ,{outRegistId : rows.treeField, eletronicId :rows.eletronicId});
			}});
			
			
		});
			function deleteOutregistCodeXq(id){
				var rowei = $(id).datagrid('getRows');
				for (var i = rowei.length-1; i >= 0; i--) {
					$(id).datagrid('deleteRow' , i);
				}
			}
		
		
	</script>
	<script type="text/javascript">
            var json = null;
			$.get({
				url : 'query_dayCount',
				async : false,
				data : {month : '${month}' < 10 ? '0' + '${month}' : '${month}'},
				success : function(data){
					json = eval('('+data+')');
					commDayCount(json);
				}
			});
			  
			$(function(){
				$('#menzhenguahaotj-combobox').combobox({onChange : function(newValue,oldValue){
					$('#month-span').html(" "+newValue+" ");	
					$.get({
						url : 'query_dayCount',
						async : false,
						data : {month : newValue < 10 ? '0' + newValue : newValue},
						success : function(data){
							json = eval('('+data+')');
							commDayCount(json);
						}
					});
				}});
			}); 
			
	        function commDayCount(json){
	        	 chart1 = AmCharts.makeChart("chartdiv1", {
	                 type: "serial",
	                 theme:"light",
	                 dataProvider:json,
	                 categoryField: "year",
	                 startDuration: 1,
	                 valueAxes: [{
	                     title: "次数"
	                 }],
	                 graphs: [{
	                     type: "column",
	                     title: "柱形数据",
	                     valueField: "income",
	                     lineAlpha: 0,
	                     fillAlphas: 0.8,
	                     balloonText: "[[title]] in [[category]]:<b>[[value]]</b>"
	                 }, {
	                     type: "line",
	                     title: "折线数据",
	                     valueField: "expenses",
	                     lineThickness: 1,
	                     fillAlphas: 0,
	                     bullet: "round",
	                     balloonText: "[[title]] in [[category]]:<b>[[value]]</b>"
	                 }],
	                 legend: {
	                     useGraphSettings: true
	                 }
	
	             });
	        }

        </script>
</body>
</html>