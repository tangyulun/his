<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="<c:url value="/js/easyui/themes/default/easyui.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/js/easyui/themes/icon.css"/>">
	<script type="text/javascript" src="<c:url value="/js/jquery-3.1.0.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/easyui/jquery.easyui.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/easyui/easyui-lang-zh_CN.js"/>"></script>
<title>药品采购</title>
</head>
<body>
<style>
	tr th{
		width : 25px;
		height : 20px;
		text-align: center;
	}
	
	#table-tr td{
		width : 25px;
		height : 20px;
		text-align: center;
	}
	
	#dayin-table tr td{
		text-align : center;
		height : 20px;
	}
</style>
	<div id="" class="easyui-layout" title="药品采购" data-options="fit:true">
 		<!-- 头部按钮   -->
 		<div data-options="region:'north',split:true" style="height:50px">
 			<a id="new_" href="#" data-options="iconCls:'icon-add',plain:true" class="easyui-linkbutton" style="width:80px;margin-top:10px;margin-left:10px">新建</a>
 			<a id="open" class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:true" style="width:80px;margin-top:10px;">打开</a>
 			<a id="guadan" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok',plain:true" style="width:80px;margin-top:10px;">挂单</a>
 			<a id="chuli" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok',plain:true" style="width:80px;margin-top:10px;">采购处理</a>
 			<a id="dayin" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-print',plain:true" style="width:80px;margin-top:10px;">打印</a>
 		</div>
 		<!-- 中间文本框  -->
 		<div data-options="region:'center',split:true" style="height:180px;">
 			<form id="caigouform" method="post">
 				<table width="100%" id="caigou_dd_ff" style="padding: 10px;border-spacing:10px;">
 					<tr>
 						<td><input class="easyui-textbox" readonly="readonly" name="drugPurchaseId" id="buyid" data-options="label:'采购订单号*',width:240,labelAlign:'right'"></td>
 						<td><input class="easyui-textbox" readonly="readonly" name="drugPurchaseZt" id="drugPurchaseZt" data-options="label:'状态',width:240,labelAlign:'right',value:'未处理'"></td>
 						<td>
 							<select name="empId" id="empId" class="easyui-combobox"
	 	 						 data-options="editable:false,label:'采购员' , width:240 , labelAlign : 'right' , editable : false">
									<option  value="${empMessage.empId}">${empMessage.empLoginName}</option>
							</select>
 						</td>
 						<td><input class="easyui-textbox" id="drugPurchaseJhdz" name="drugPurchaseJhdz" data-options="required:true,label:'交货地点',width:240,labelAlign:'right'"></td>
 					</tr>
 					<tr>
 						<td colspan="2">
 							<input id="gongyingshnag_id" class="easyui-textbox" name="supplierId" readonly="readonly" data-options="required:true,label:'供应商*',width:200,labelAlign:'right'">
 							<input class="easyui-textbox" id="supplierName_name" name="supplierName" data-options="
 							buttonText : '…',
 							editable : false,
 							onClickButton : function(){
 								 gyscomm(function(row){
									 otherWindowDrug(row);
									 selectdrugPurchase(row.supplierId);
								 });
 							},
 							required:true,width:240">
 						</td>
 						<td colspan="1"><input id="dhmoney" class="easyui-textbox" name="drugPurchaseMoney" readonly="readonly" data-options="label:'订货金额',width:240,labelAlign:'right',value : '0.0'"></td>
 						<td colspan="1"><input class="easyui-datebox" id="drugPurchaseGhdate" name="drugPurchaseGhdate" value="new Date()"  data-options="label:'供货日期',width:240,labelAlign:'right',editable : false"></td>
 					</tr>
 					<tr>
 						<td><input class="easyui-datebox" value="new Date()" id="drugPurchaseDhdate" name="drugPurchaseDhdate" data-options="label:'订货日期',width:240,labelAlign:'right',editable : false"></td>
 						<td><input class="easyui-textbox" id="ypcglxr" readonly="readonly" name="supplierLxr" data-options="required:true,label:'联系人',width:240,labelAlign:'right'"></td>
 						<td><input class="easyui-textbox" id="ypcglxdh" readonly="readonly" name="supplierPhone" data-options="required:true,label:'电话',width:240,labelAlign:'right'"></td>
 					</tr>
 				</table>
 			</form>
 		</div>
 		
 		<!-- 最下面的一些查询的东东 -->
 		<div data-options="region:'south',split:true" style="height:320px">
 			<div id="" class="easyui-tabs" style="width:100%"> 
	 			<div title="采购订单" style="height:200px;">
	 				<form action="" method="post" id="caigou_drug">
		 				<table id="caigou_drug_table" style="padding: 10px;border-spacing:5px;margin-left:-30px;width:100%">
		 					<tr>
		 						<td  colspan="2">
		 							<input class="easyui-textbox" id="drugId" name="drugId" readonly="readonly"
		 							 data-options="required:true,label:'药品*',width:200,labelAlign:'right'">
		 							<input name="drugName" class="easyui-textbox" id="drugName"
		 							 data-options="required:true,width:240 ,
		 							editable : false,
		 							buttonText : '…',
									 onClickButton : function(){
		 								selectYaoPingAll(function(row){
		 									durgShuju(row);
		 								});
		 							}
		 							">
		 						</td>
		 						<td colspan="1"><input class="easyui-textbox" id="drug_ph" name="ph" 
		 						data-options="required:true,label:'批号',width:240,labelAlign:'right'"></td>
		 						<td colspan="1"><input class="easyui-textbox" id="drug_bz" name="bz"
		 						 data-options="required:true,label:'备注',width:300,labelAlign:'right'"></td>
		 					</tr>
		 					<tr>
		 						<td><input name="drugPfprice" id="drug_buymoney" class="easyui-textbox"
		 						 data-options="label:'采购单价',width:240,labelAlign:'right',value:'0.00'"></td>
		 						<td><input class="easyui-textbox" name="num" id="drug_buynum" 
		 						data-options="label:'数量*',width:240,labelAlign:'right',value:'1'"></td>
		 						<td><input class="easyui-textbox" name="zprice" id="drug_jier" readonly="readonly"
		 						 data-options="label:'金额 ',width:240,labelAlign:'right',value:'0.00'"></td>
		 					</tr>
		 					<tr>
		 						<td colspan="3"></td>
		 						<td>
		 							<a id="drug_add_jiaru" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" style="width:80px;height:22px;margin-left:85px">加入</a>
		 							<a id="drug_delete_quxiao" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" style="width:80px;height:22px;">删除</a>
		 						</td>
		 					</tr>
		 				</table>
	 				</form>
	 				<table class="easyui-datagrid caigoudd_table" id="caigoudd_table" data-options="rownumbers:true,method:'get' , url : 'select_caigouxd_all',fitColumns: true" style="width:100%;height:165px">
	 					<thead style="margin-left:10px;height:200px">
	 						<tr>
	 							<th data-options="field:'wu',checkbox:true,width:5,align:'center'"></th>
	 							<th data-options="field:'ypid',width:10,align:'center'">药品编号</th>
	 							<th data-options="field:'ypname',width:10,align:'center'">药品名称</th>
	 							<th data-options="field:'num',width:10,align:'center'">数量</th>
	 							<th data-options="field:'dw',width:10,align:'center'">单位</th>
	 							<th data-options="field:'price',width:10,align:'center'">单价</th>
	 							<th data-options="field:'zprice',width:10,align:'center'">金额</th>
	 							<th data-options="field:'ph',width:10,align:'center'">批号</th>
	 							<th data-options="field:'bz',width:10,align:'center'">备注</th>
	 						</tr>
	 					</thead>
	 				</table>
	 			</div>
	 			<div title="采购历史"  style="height:280px" data-options="closable:false"
						style="padding: 5px;">
	 				<table class="easyui-datagrid" id="caigoulishi" data-options="rownumbers:true,singleSelect:true,fitColumns: true,method : 'get'" style="width:100%;height:270px">
	 					<thead>
	 						<tr>
		 						<th data-options="field:'drugPurchaseId',width:13,align:'center'">采购单号</th>
		 						<th data-options="field:'drugPurchaseMoney',width:8,align:'center'">金额</th>
		 						<th data-options="field:'drugPurchaseDhdate',width:10,align:'center' , formatter : date">订货日期</th>
		 						<th data-options="field:'drugPurchaseGhdate',width:10,align:'center' , formatter : date">供货日期</th>
		 						<th data-options="field:'drugPurchaseJhdz',width:10,align:'center'">交货地点</th>
		 						<th data-options="field:'emp',width:10,align:'center',
		 							formatter(value , row ,index){
 										return row.emp == null ? null : row.emp.empLoginName;
 									}
		 						">采购员</th>
		 						<th data-options="field:'supplier',width:10,align:'center',
		 							formatter(value , row ,index){
 										return row.supplier == null ? null : row.supplier.supplierName;
 									}
		 						">供应商</th>
	 						</tr>
	 					</thead>
	 				</table>
	 			</div>
	 		</div>
 		</div>
	 </div> 
		 <div id="bianji_caigou_jilu_win" class="easyui-window" title="编辑" style="width:350px;height:400px" 
		 	data-options="modal:true,collapsible:false,minimizable:false,maximizable:false,closed:true">
		 	<form action="" method="post" id="bianji_jilu_form">
		 		<table id="bianji_jilu_tab" data-options="fit:true,singleSelect:true,fitColumns: true" style="width:100%;border-spacing:10px;">
	 				<tr>
	 					<td><input class="easyui-textbox" name="ypid" id="" readonly="readonly"
	 					 data-options="label : '药品编号' , width : 240 , labelAlign : 'right'"></td>
	 				</tr>
	 				<tr>
	 					<td><input class="easyui-textbox" name="ypname" id="" readonly="readonly"
	 					 data-options="label : '药品名称' , width : 240 , labelAlign : 'right'"></td>
	 				</tr>
	 				<tr>
	 					<td><input class="easyui-textbox" name="dw" id="" readonly="readonly"
	 					 data-options="label : '单位' , width : 240 , labelAlign : 'right'"></td>
	 				</tr>
	 				<tr>
	 					<td><input class="easyui-textbox" name="zprice" id="cg-je" readonly="readonly"
	 					 data-options="label : '金额' , width : 240 , labelAlign : 'right'"></td>
	 				</tr>
	 				<tr>
	 					<td><input class="easyui-textbox" name="num" id="cg-num"
	 					 data-options="label : '数量' , width : 240, labelAlign : 'right'"></td>
	 				</tr>
	 				<tr>
	 					<td><input class="easyui-textbox" name="price" id="cg-dj"
	 					 data-options="label : '单价' , width : 240 , labelAlign : 'right' , 
	 					 validType:'yanzhendajia'"></td>
	 				</tr>
	 				<tr>
	 					<td><input class="easyui-textbox" name="ph" id="" data-options="label : '批号' , width : 240 , labelAlign : 'right'"></td>
	 				</tr>
	 				<tr>
	 					<td><input class="easyui-textbox" name="bz" id="" data-options="label : '备注' , width : 240 , labelAlign : 'right'"></td>
	 				</tr>
		 		</table>
		 	</form>
	 		<div style="margin-left: 100px;margin-top:15px">
					<a class="easyui-linkbutton" name="" id="update_caigou_queding" data-options="iconCls:'icon-ok', plain:true" style="width : 80px; height :25px ">确定</a>
					<a class="easyui-linkbutton" name="" id="" data-options="iconCls:'icon-cancel', plain:true , 
						onClick : function(){
							$('#bianji_caigou_jilu_win').window('close');
						}
					" style="width : 80px; height : 25px">取消</a>
	 		</div>
		 </div>
		 
		 
		<div id="dayin-window" class="easyui-window" title="打印" style="width:800px;height:450px" 
		 	data-options="modal:true,collapsible:false,minimizable:false,maximizable:false,closed:true">
			<div class="easyui-layout dayin-layout" data-options="fit:true">
				<div data-options="region : 'center' , split : true" style="height:50px">
					<div style="float: right;">
						<a class="easyui-linkbutton" id="dayin-linkbutton"
							style="width: 60px; margin-top: 2px;margin-right: 2px;margin-bottom: 2px"
							data-options="iconCls:'icon-print'">打印
						</a>
					</div>
					<div style="font-size: 14px;font-weight: bold;padding: 5px">深圳XXX医院</div><hr/>
					<div>
						<h2 style="text-align: center;">药品采购单</h2>
					</div>
					<table border="1" cellpadding="0" cellspacing="0" style="border-collapse: collapse;" width="100%">
						<thead>
							<tr style="text-align: center">
								<td style="height:23px;width:90px">
									采购订单号：
								</td>
								<td style="height:23px;width:150px" id="caigoudingdana">
									
								</td>
								<td style="height:23px;width:90px">
									状态：
								</td>
								<td style="height:23px;width:150px" id="statea">
									
								</td>
								<td style="height:23px;width:90px">
									采购员：
								</td>
								<td style="height:23px;width:150px" id="buymana">
									
								</td>
							</tr>
							<tr style="text-align: center">
								<td style="height:23px;width:90px">
									供应商编号：
								</td>
								<td style="height:23px;width:150px" id="supplierIda">
									
								</td>
								<td style="height:23px;width:90px">
									供应商名称：
								</td>
								<td style="height:23px;width:150px" id="supplierNamea">
									
								</td>
								<td style="height:23px;width:90px">
									供货日期：
								</td>
								<td style="height:23px;width:150px" id="gonghuodatea">
									
								</td>
							</tr>
							<tr style="text-align: center">
								<td style="height:23px;width:90px">
									联系人：
								</td>
								<td style="height:23px;width:150px" id="phonemana">
									
								</td>
								<td style="height:23px;width:90px">
									电话：
								</td>
								<td style="height:23px;width:150px" id="phonenumbera">
									
								</td>
								<td style="height:23px;width:90px">
									订货日期：
								</td>
								<td style="height:23px;width:150px" id="dinhuodatea">
									
								</td>
							</tr>
							<tr style="text-align: center">
								<td style="height:23px;width:90px">
									交货地点：
								</td>
								<td style="height:23px;width:150px" id="jiaohuoaddressa">
									
								</td>
								<td style="height:23px;width:90px">
									订货金额(小)：
								</td>
								<td style="height:23px;width:150px" id="dinhoumoneyxiao">
									
								</td>
								<td style="height:23px;width:90px">
									订货金额(大)：
								</td>
								<td style="height:23px;width:150px" id="dinhoumoneyda">
									
								</td>
							</tr>
							<tr height="10px"></tr>
						</thead>
					</table>
					<table border="1" id="dayin-table" cellpadding="0" cellspacing="0" style="border-collapse: collapse;margin-top: 20" width="100%">
							<tr>
								<th>序号</th>
								<th>药品编号</th>
								<th>药品名称</th>
								<th>数量</th>
								<th>单位</th>
								<th>单价</th>
								<th>金额</th>
								<th>批号</th>
								<th>备注</th>
							</tr>
							<tbody id="dayin-tbody"></tbody>
					</table>
				</div>
			</div>
		</div>
	 <script>
	 var row = null;
	 var maxnum = null;
	 //填充药瓶数据
	 function durgShuju(rows){
			row = rows;
			$("#caigou_drug").form('load',rows);
			maxnum = rows.yaokuKucun.yaokuKucunTop;
		 	$("#drug_jier").textbox("setValue", rows.drugPfprice);
			$("#drug_buymoney").textbox("setValue", rows.drugPfprice);
	 }
	 
	 
	 function totable(){
		 var rows = $("#caigoudd_table").datagrid("getRows");
		 $('.cleartr').remove();
		 for(var i = 0; i< rows.length; i++){
			 var trr = $("<tr class='cleartr' style='text-align : center;height : 20px'></tr>");
			 trr.append("<td>"+rows[i].id+"</td>");
			 trr.append("<td>"+rows[i].ypid+"</td>");
			 trr.append("<td>"+rows[i].ypname+"</td>");
			 trr.append("<td>"+rows[i].num+"</td>");
			 trr.append("<td>"+rows[i].dw+"</td>");
			 trr.append("<td>"+rows[i].price+"</td>");
			 trr.append("<td>"+rows[i].zprice+"</td>");
			 trr.append("<td>"+rows[i].ph+"</td>");
			 trr.append("<td>"+rows[i].bz+"</td>"); 
			 trr.appendTo("#dayin-table");
		 }
	 }
	 
	 	//打印
		 $(document).ready(function(){
			$('#dayin-linkbutton').linkbutton({onClick :function(){
				$('.dayin-layout').printArea();
			}});
		 });
	 
		$(function(){
			//点击打印按钮打开打印宽口
			$("#dayin").linkbutton({onClick : function(){
				$("#caigoudingdana").html($("#buyid").textbox("getValue"));
				$("#statea").html($("#drugPurchaseZt").textbox("getValue"));
				$("#buymana").html($("#empId").combobox("getText"));
				$("#supplierIda").html($("#gongyingshnag_id").textbox("getValue"));
				$("#supplierNamea").html($("#supplierName_name").textbox("getValue"));
				$("#gonghuodatea").html($("#drugPurchaseGhdate").datebox("getValue"));
				$("#jiaohuoaddressa").html($("#drugPurchaseJhdz").textbox("getValue"));
				$("#dinhoumoneyxiao").html($("#dhmoney").textbox("getValue"));
				//convertCurrency($("#dhmoney").textbox("getValue"))
				$("#dinhoumoneyda").html(convertCurrency($("#dhmoney").textbox("getValue")));
				$("#dinhuodatea").html($("#drugPurchaseDhdate").datebox("getValue"));
				$("#phonemana").html($("#ypcglxr").textbox("getValue"));
				$("#phonenumbera").html($("#ypcglxdh").textbox("getValue"));
				totable();
				
				for (var i = 0; i <6; i++) {
					var trr = $("<tr align='center' class='cleartr' height='20px'></tr>");
					for (var j = 0; j < 9; j++) {
						trr.append('<td></td>');
					}
					trr.appendTo('#dayin-table');
				}
				
				$("#dayin-window").window("open");
			}});
			
			$.get("clear_caigouxq" ,function(){});
			
			//自动生成采购订单号
			$.get("to_purchase",function(data){
				$("#buyid").textbox('setValue',data.substring(1,data.length-1));
			});
			    
			//打开窗口
			$("#open").linkbutton({onClick : function(){
				selectCaigouDingdan(function(row){
					 guadancaigou(row);		
					 selectdrugPurchase(row.supplier.supplierId);
				});
			}});
			
			//点击加入时获取列表中的值传到table中
			$("#drug_add_jiaru").linkbutton({onClick : function(){
				//判断状态是否是未处理，如果不是则进行提示
				if($("#drugPurchaseZt").textbox('getValue') != '未处理'){
					$.messager.alert("提示","不能重复处理该订单");
					return;
				}
				$("#caigou_drug").form("submit",{
					url : "to_insert_caigou_wa",//路径
					onSubmit : function(param){
						param.dw = row.unit.text;//获取单位
						return $(this).form("validate");
					},
					success : function(){
						$("#caigou_drug").form('reset');//刷新表单
						$("#caigoudd_table").datagrid("reload" , "select_caigouxd_all");//刷新表格
						jsMoney();//计算金额
					}
				});
			}});
			
			//根据修改的数量计算总价格
			$("#drug_buynum").textbox({onChange : function(newValue, oldValue){
				var price = $("#drug_buymoney").textbox("getValue");//获取单价
				if(!isNaN(newValue)){//如果修改的值不是中文则进行以下操作
					if(newValue <= 0){//判断是否大于0
						var price1 = $("#drug_buynum").textbox("setValue" , 1);//如果小于等于0则将值变成1
						var price2 = $("#drug_buynum").textbox("getValue");//获取值
						$("#drug_jier").textbox("setValue" , price * price2);//进行计算
					}else{
						if(newValue > maxnum){//如果输入的值大于库存数量
							$("#drug_buynum").textbox("setValue" , maxnum);//则将输入的值变成最大的库存数量
							$("#drug_jier").textbox("setValue" , price * maxnum);//然后进行计算
						}else{
							//否则直接进行计算
							$("#drug_jier").textbox("setValue" , price * newValue);
						}
					}
				}else{
					var price1 = $("#drug_buynum").textbox("setValue" , 1);//如果小于等于0则将值变成1
					var price2 = $("#drug_buynum").textbox("getValue");//获取值
					$("#drug_jier").textbox("setValue" , price * price2);//进行计算
				}
			}});
			
			$("#cg-num").textbox({onChange : function(newValue, oldValue){
				var je = $("#cg-dj").textbox("getValue");
				if(!isNaN(newValue)){
					if(newValue <= 0){
						var je1 = $("#cg-num").textbox("setValue" , 1);
						var je2 = $("#cg-num").textbox("getValue");
						$("#cg-je").textbox("setValue" , je * je2);
					}else{
						if(newValue > maxnum){
							$("#cg-num").textbox("setValue" , maxnum);
							$("#cg-je").textbox("setValue" , je * maxnum);
						}else{
							$("#cg-je").textbox('setValue',je * newValue);
						}
					}
				}else{
					var je1 = $("#cg-num").textbox("setValue" , 1);
					var je2 = $("#cg-num").textbox("getValue");
					$("#cg-je").textbox("setValue" , je * je2);
				}
			}});
			
			//根据修改的价格计算总价格
			$("#drug_buymoney").textbox({onChange : function(newValue, oldValue){
				var num2 = $("#drug_buynum").textbox("getValue");
				if(!isNaN(newValue)){
					$("#drug_jier").textbox("setValue" , num2 * newValue);
				}else{
					var num3=$("#drug_buymoney").textbox("setValue" , 1);
					var jiage1=$("#drug_buymoney").textbox("getValue");
					$("#drug_jier").textbox("setValue" , num2 * jiage1);
				}
			}});
			$("#cg-dj").textbox({onChange : function(newValue, oldValue){
				var sl=$("#cg-num").textbox("getValue");
				if(!isNaN(newValue)){
					$("#cg-je").textbox('setValue',sl * newValue);
				}else{
					var sl1 = $("#cg-dj").textbox("setValue" , 1);
					var sl2 = $("#cg-dj").textbox("getValue");
					$("#cg-je").textbox("setValue" , sl * sl2);
				}
			}});
			//进行挂单处理
			$("#guadan").linkbutton({onClick : function(){
				guanDanAndDeal("未处理");
			}});

			//进行挂单采购处理
			$("#chuli").linkbutton({onClick : function(){
				if($("#caigoudd_table").datagrid('getRows') ==0){
					 $.messager.alert('提示' , '请至少选择一条数据处理!');
					 return ;
				}
				guanDanAndDeal("已处理");
				caigouhistory();
			}});
			//点击某一行表格数据 删除
			$("#drug_delete_quxiao").linkbutton({onClick : function(){
				var row = $("#caigoudd_table").datagrid('getSelections');
				if($("#drugPurchaseZt").textbox('getValue') != '未处理'){
					$.messager.alert("提示","不能重复处理该订单");
					return;
				}else if($("#caigoudd_table").datagrid('getRows') ==0){
					 $.messager.alert('提示' , '请至少选择一条数据处理!');
					 return ;
				}
				if(row.length == 0){
					$.messager.alert("提示","请先选择一行")
				}else{
					var str = "";
					for(var i = 0 ; i < row.length ; i++){
						str += row[i].id + ",";
					}
					$.getJSON("delete_xq_pur", {xq : str} , function(data){
						$("#caigoudd_table").datagrid("reload" , 'select_caigouxd_all');
						jsMoney();
					});
				}
			}});
			
			//双击table数据时进行编辑
			$("#caigoudd_table").datagrid({onDblClickRow : function(index, rows){
				if($("#drugPurchaseZt").textbox('getValue') != '未处理'){
					$.messager.alert("提示","不能重复处理该订单");
					return;
				}
				row = rows;
				$("#bianji_jilu_form").form('load' , rows);
				$("#bianji_caigou_jilu_win").window('open');
			}});
			
			//点击确定时进行编辑
			$("#update_caigou_queding").linkbutton({onClick : function(){
				$("#bianji_jilu_form").form("submit" , {
					url : 'update_caigou_xq',
					onSubmit : function(data){
						data.id=row.id;
						return $(this).form("validate");
					},
					success : function(){
						$("#bianji_caigou_jilu_win").window("close");
						$("#caigoudd_table").datagrid("reload" , 'select_caigouxd_all');
						jsMoney();
					}
				});
			}});
			
			//点击新建时刷新数据
			$("#new_").linkbutton({onClick : function(){
				$("#caigouform").form('reset');
				$.get("to_purchase",function(data){
					$("#buyid").textbox('setValue',data.substring(1,data.length-1));
				});
				$.get("clear_caigouxq" ,function(){
					$("#caigoudd_table").datagrid("reload" , 'select_caigouxd_all');
				});
				caigouhistory();
			}})
		})
		//将选择的供应商值传到采购页面
		function otherWindowDrug(row){
			 if(row == null){
				 $.messager.alert('提示' , '请选择供应商!');
				 return ;
			 }
			$("#gongyingshnag_id").textbox('setValue' , row.supplierId);
			$("#supplierName_name").textbox('setValue' , row.supplierName);
			$("#ypcglxr").textbox('setValue',row.supplierLxr);
			$("#ypcglxdh").textbox('setValue',row.supplierPhone);
			$("#supplier_management").window("close");
		}
		
		//点击打开时选择一条数据并将值传到采购页面
		function guadancaigou(row){
			if(row == null) {
				$.messager.alert('提示' , '请先选择一条数据!');
				 return ;
			}
			$("#buyid").textbox('setValue',row.drugPurchaseId);
			$("#drugPurchaseZt").textbox('setValue',row.drugPurchaseZt);
			$("#empId").textbox('setValue',row.emp.empId);
			$("#drugPurchaseJhdz").textbox('setValue',row.drugPurchaseJhdz);
			$("#gongyingshnag_id").textbox('setValue',row.supplier.supplierId);
			$("#supplierName_name").textbox('setValue',row.supplier.supplierName);
			$("#dhmoney").textbox('setValue',row.drugPurchaseMoney);
			$("#drugPurchaseGhdate").datebox('setValue',row.drugPurchaseGhdate);
			$("#drugPurchaseDhdate").datebox('setValue',row.drugPurchaseDhdate);
			$("#ypcglxr").textbox('setValue',row.supplier.supplierLxr);
			$("#ypcglxdh").textbox('setValue',row.supplier.supplierPhone);
			$.get("clear_caigouxq" ,function(){});
			$("#caigoudd_table").datagrid({url : 'to_find_xiangbiao_xq'});
			$("#caigoudd_table").datagrid('load', {drugPurchaseId : row.drugPurchaseId});
			$("#caigouguadan").window("close");
			
		}
		
		
		//挂单和处理
		function guanDanAndDeal(state){
			
			if($("#drugPurchaseZt").textbox('getValue') != '未处理'){
				$.messager.alert("提示","不能重复处理该订单");
				return;
			}
			$("#caigouform").form("submit",{
				url : "to_insert_guadan",
				onSubmit : function(data){
					data.state=state;
					return $(this).form("validate");
				},
				success : function(data){
					var json = eval("("+data+")");
					if(json.error){ 
						$.messager.alert("提示","操作成功！");
						if(state == '已处理'){
							$("#caigouform").form('reset');
							//自动生成采购订单号
							$.get("to_purchase",function(data){
								$("#buyid").textbox('setValue',data.substring(1,data.length-1));
							});
							$.get("clear_caigouxq" ,function(){
								$("#caigoudd_table").datagrid("reload" , 'select_caigouxd_all');
							});
						}
					}else{
						$.messager.alert("提示",json.eMessage);
					} 
				}
			});
			
			 $.extend($.fn.textbox.defaults.rules,{
				 yanzhendajia : {
					validator : function(value,param){
						return /^[0-9]*$/.test(value); 
					},
					message : "请输入数字"
				}
			}); 
			
		}
		
		//计算总金额
		function jsMoney(){
			$.get("select_z_money" , function(data){
				$("#dhmoney").textbox("setValue" , data);
			});
		}
		
		//根据供应商id查询采购历史
		function selectdrugPurchase(supplierId){
			$("#caigoulishi").datagrid({url : 'to_find_drugPurchase_BySupplierId'});
			$("#caigoulishi").datagrid('load', {supplierId : supplierId})
		}
		
		//刷新采购历史记录
		function caigouhistory(){
			var regist = $("#caigoulishi").datagrid('getRows');
			for (var i = regist.length - 1 ; i >= 0; i--){
				$("#caigoulishi").datagrid('deleteRow',i);
			}
		}
		
		
	</script>
</body>
</html>