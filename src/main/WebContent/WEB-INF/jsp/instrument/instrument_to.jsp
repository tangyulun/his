<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>器械采购  </title>

<script type="text/javascript" src="<c:url value="/js/jquery.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/easyui/jquery.easyui.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/easyui/easyui-lang-zh_CN.js"/>"></script>
<link rel="stylesheet" type="text/css" href="<c:url value="/js/easyui/themes/default/easyui.css"/>">
<link rel="stylesheet" type="text/css" href="<c:url value="/js/easyui/themes/icon.css"/>">
</head>
<body>
 <div id="qxcg" class="easyui-layout" title="器械采购"
        data-options="iconCls:'icon-save',modal:true,fit:true">   
 <div data-options="region:'north'"  style=height:40px;">
 <div  style="margin:5px 0px 0px 5px;">
		<a id="xinjian_instrument" href="#" class="easyui-linkbutton"data-options=iconCls:'icon-add',plain:true style="width:80px;">新建</a>
		<a id="btn1" href="#" class="easyui-linkbutton"data-options=iconCls:'icon-reload',plain:true style="width:80px;">打开</a>
		<a id="guadan_button" href="#" class="easyui-linkbutton"data-options=iconCls:'icon-ok',plain:true style="width:80px;">挂单</a>
		<a id="caigocl_id" href="#" class="easyui-linkbutton"data-options=iconCls:'icon-ok',plain:true style="width:80px;">采购处理</a>
		<a id="dayin_id" href="#" class="easyui-linkbutton"data-options=iconCls:'icon-print',plain:true style="width:80px;">打印</a>
 </div>
</div>
		<div style="margin-top: 40px;">
			<form id="regist-patient-add-form" action="" method="post">
	           		<table width="100%">
	           			<tr height="35px">
	           	<td><input name="instrumentCaigouId" id="qx_cg" readonly="readonly" class="easyui-textbox" data-options="required:true,label:'采购单号*',width:240,labelAlign:'right'"></td>
	            <td><input name="instrumentCaigouState" id="instrumentZt"readonly="readonly" class="easyui-textbox" data-options="editable:false,required:true,label:'状态*', width:240,labelAlign:'right',value:'未确定'">   
   						 
                              </td>
				<td><input name="instrumentCaigouDhDate" id="instrumentDHdate"value="new Date()"class="easyui-datebox" data-options="editable:false,required:true,label:'订货日期*',width:240,labelAlign:'right'"></td>

				<td><input name="instrumentCaigouGhDate" id="instrumentGHdate"value="new Date()" class="easyui-datebox" data-options="editable:false,required:true,label:'供货日期*',width:240,labelAlign:'right'"></td>
	           			</tr>
	           			<tr height="35px">
	           			<td><input name="instrumentCaigouAddress" id="instrumentJH"class="easyui-textbox" data-options="required:true,label:'交货地点*',width:240,labelAlign:'right'"></td>
	            	<td><input name="instrumentCaigouMoney" id="dinghuojine"class="easyui-textbox" data-options="editable:false,required:true,label:'订货金额*',width:240,labelAlign:'right'"></td>
	          
	           <td><input name="supplierLxr" id="instrument_lxr" class="easyui-textbox instrument_lxr" data-options="required:true,editable:false,label:'联系人*',width:240,labelAlign:'right'"></td>
	           	<td><input name="supplierPhone" id="instrument_shoji"class="easyui-textbox instrument_shoji" data-options="required:true,editable:false,label:'手机*',width:240,labelAlign:'right'"></td>
	           			</tr>
	           			<tr height="35px">
	           					<td colspan="2">
						           	<input name="supplierId" id="qxsupplierId"  class="easyui-textbox qxsupplierId" data-options="required:true,editable:false,label:'供应商*',width:170,labelAlign:'right'">
						           	<input name="supplierName " id="qxsupplierName" class="easyui-textbox qxsupplierName" data-options="required:true,width:190 , editable:false,buttonText : '…' , 
						           	onClickButton : function(){
						           			gyscomm(function(row){
												 otherWindowFzhi(row);
											 });
						           	}
						           	">
								</td>
	           	
	           			</tr>
	           		</table>
	           	</form>	
		</div>
	           
		     <div id="regist-patient-add-tabs" class="easyui-tabs" style="margin-top: 10px; height :400px" >   
		     <div title="采购订单" data-options="closable:false" style="padding:5px;display:none;"> 
			     <form id="instrument_from" method="post" style="margin-top: -5px">  
					<table width="100%"">
							          		<tr height="35px">
							          			<td  colspan="4">
							          				<input name="instrumentId" class="easyui-textbox" data-options="required:true,label:'器械*',width:250,labelAlign:'right'">
							          				<input name="instrumentName" class="easyui-textbox" data-options="required:true,width:240 , buttonText : '…' , onClickButton : function(){
							          					selectqx(function(row){
							          						unitName = row.unit.text;
							          						$('#danjia').textbox('setValue' , row.instrumentPrice);
							          						$('#jine').textbox('setValue' , row.instrumentPrice);
							          						$('#shuliang').textbox('setValue' , 1);
															$('#instrument_from').form('load',row);
														});
							          				}" >
							          			   
							          		    </td>
							          		</tr>
							          		
							          		<tr height="35px">
							          			<td><input name="DANJIA" id="danjia"class="easyui-textbox" data-options="required:true,label:'单价',width:250,labelAlign:'right'"></td>
							          			<td><input name="SHULIANG" id="shuliang" class="easyui-textbox" data-options="required:true,label:'数量',width:250,labelAlign:'right'"></td>
							          			<td><a id="jiaru_id" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" style="width:80px">加入</a> 
							          				<a id="shanchu_id" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" style="width:80px">删除</a>
							          			 </td>
							          			</tr>
							          			<tr>
							          			<td><input name="JINE" id="jine" class="easyui-textbox" data-options="editable : false,required:true,label:'金额',width:250,labelAlign:'right'"></td>
							          			<td><input name="BEIZHU" class="easyui-textbox" data-options="required:true,label:'备注',width:250,labelAlign:'right'"></td>
							          		</tr>
							          </table>
				</form>
						          <table  class="easyui-datagrid" id="qixiecaigbiaoge" data-options="rownumbers:true,fitColumns:true,singleSelect:true,fit:true,method : 'get' , url : 'get_instrument_String'">   
								    <thead>   
								        <tr>   
								            <th data-options="field:'qXCGID',width:15">器械编号</th> 
								            <th data-options="field:'qXCGNAME',width:15">器械名称</th>   
								            <th data-options="field:'sHULIANG',width:10">数量</th>   
								            <th data-options="field:'dANWEI',width:10">单位</th>   
								            <th data-options="field:'dANJIA',width:15">单价</th>  
								            <th data-options="field:'jINE',width:15">金额</th>   
								            <th data-options="field:'bEIZHU',width:15">备注</th>  
								        </tr>   
								    </thead>   
								</table>  
						          
					          </div>
					         </div>

<div id="bjqiexie" class="easyui-window" title="编辑" data-options="
		collapsible:false,
		minimizable:false,
		maximizable:false,
		closed : true,
		modal:true" 
		style="width:300px;height:320px;padding:5px;">
			<div class="easyui-layout" data-options="fit:true">
				<div data-options="region:'center'" style="padding:10px;">
					<form id="instrumentbj-form" method="post">
					<table id="bj-table-add"  width="100%" class="">
						<tr >
							<td>
								<input name="cGid" readonly="readonly"id=""class="easyui-textbox" data-options="label:'器械编号' , editable : false , labelWidth:100 , width:210 , labelAlign : 'right'"/>
							</td>
						</tr>
						<tr >
							<td>
								<input name="qXCGNAME" readonly="readonly"id=""class="easyui-textbox" data-options="label:'器械名称' , editable : false , labelWidth:100 , width:210 , labelAlign : 'right'"/>
							</td>
						</tr>
						<tr >
							<td>
								<input name="sHULIANG"  id="shuuliangg"class="easyui-textbox" data-options="label:'数量' , labelWidth:100 , width:210 , labelAlign : 'right'"/>
							</td>
						</tr>
						<tr >
							<td>
								<input name="dANWEI" readonly="readonly"id=""class="easyui-textbox" data-options="label:'单位' , editable : false , labelWidth:100 , width:210 , labelAlign : 'right'"/>
							</td>
						</tr>
						<tr >
							<td>
								<input name="dANJIA" id="dangjiaa"class="easyui-textbox" data-options="label:'单价'  , labelWidth:100 , width:210 , labelAlign : 'right'"/>
							</td>
						</tr>
						<tr >
							<td>
								<input name="jINE" id="jinejine"readonly="readonly"class="easyui-textbox" data-options="label:'金额' , editable : false , labelWidth:100 , width:210 , labelAlign : 'right'"/>
							</td>
						</tr>
						<tr >
							<td>
								<input name="bEIZHU" id=""class="easyui-textbox" data-options="label:'备注'  , labelWidth:100 , width:210 , labelAlign : 'right'"/>
							</td>
						</tr>

					</table>
					</form>
				</div>
				<div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
					<a id="bj_qd" href="#" class="easyui-linkbutton"data-options=""style="width:80px;">确定</a>
					<a id="bj_qx" href="#" class="easyui-linkbutton"data-options="onClick : function(){
						$('#bjqiexie').window('close');
					}"style="width:80px;">取消</a>
				</div>
			</div>
		</div>
		
		
		<div id="dayin-window_instrument" class="easyui-window" title="打印" style="width:800px;height:450px" 
		 	data-options="modal:true,collapsible:false,minimizable:false,maximizable:false,closed:true">
		 	<div class="easyui-layout instrument_dayin"  data-options="fit:true">
				<div data-options="region : 'center' , split : true" style="height:50px">
						
						<div style="float: right;">
						<a class="easyui-linkbutton" id="caigocl_day"
							style="width: 60px; margin-top: 2px;margin-right: 2px;margin-bottom: 2px"
							data-options="iconCls:'icon-print'">打印
						</a>
					</div>
					<div style="font-size: 14px;font-weight: bold;padding: 5px">深圳XXX医院</div><hr/>
					<div>
						<h2 style="text-align: center;">器械采购单</h2>
					</div>
					<table border="1" cellpadding="0" cellspacing="0" style="border-collapse: collapse;" width="100%">
						<thead>
							<tr style="text-align: center">
								<td style="height:23px;width:90px">
									采购订单号：
								</td>
								<td style="height:23px;width:150px" id="qx_cg_id">
									
								</td>
								<td style="height:23px;width:90px">
									供货日期：
								</td>
								<td style="height:23px;width:150px" id="qx_gh_date">
									
								</td>
								<td style="height:23px;width:90px">
									订货日期：
								</td>
								<td style="height:23px;width:150px" id="qx_dh_date">
									
								</td>
							</tr>
							<tr style="text-align: center">
								<td style="height:23px;width:90px">
									供应商编号：
								</td>
								<td style="height:23px;width:150px" id="qx_gys_id">
									
								</td>
								<td style="height:23px;width:90px">
									联系人：
								</td>
								<td style="height:23px;width:150px" id="qx_lxr">
									
								</td>
								<td style="height:23px;width:90px">
									供应商名称：
								</td>
								<td style="height:23px;width:150px" id="qx_gys_name">
									
								</td>
							</tr>
							<tr style="text-align: center">
								<td align="center" style=''>订货金额（大）：</td>
								<td id="qx_dh_m" align="center" style="color:#398000;font-weight: bold;">
									
								</td>
								<td style="height:23px;width:90px">
									电话：
								</td>
								<td style="height:23px;width:150px" id="qx_dh">
									
								</td>
								<td style="height:23px;width:90px">
									交货地点：
								</td>
								<td style="height:23px;width:150px" id="qx_jddd">
									
								</td>
							</tr>
							
						</thead>
					</table>
					<table border="1" id="dayin-table—instrument" cellpadding="0" cellspacing="0" style="border-collapse: collapse; margin-top: 20" width="100%">
						<thead>
							<tr>
								<th>序号</th>
								<th>器械编号</th>
								<th>器械名称</th>
								<th>单位</th>
								<th>数量</th>
								<th>单价</th>
								<th>金额</th>
								<th>备注</th>
							</tr>
						</thead>
					</table>
				</div>
			</div>
		 	</div>
	
 <script type="text/javascript">
 		var unitName = null;
		$(function(){
			$("#dayin_id").linkbutton({onClick : function(){
				$("#qx_cg_id").html($("#qx_cg").textbox("getValue"));
				$("#qx_gh_date").html($("#instrumentGHdate").textbox("getValue"));
				$("#qx_dh_date").html($("#instrumentDHdate").textbox("getValue"));
				$("#qx_gys_id").html($("#qxsupplierId").textbox("getValue"));
				$("#qx_lxr").html($("#instrument_lxr").textbox("getValue"));
				$("#qx_gys_name").html($("#qxsupplierName").textbox("getValue"));
				$("#qx_dh_m").html(convertCurrency($("#dinghuojine").textbox("getValue")));
				$("#qx_dh").html($("#instrument_shoji").textbox("getValue"));
				$("#qx_jddd").html($("#instrumentJH").textbox("getValue"));
				totable();
				for (var i = 0; i <10; i++) {
					var trs = $("<tr align='center' class='charges-tr' height='20'></tr>");
					for (var j = 0; j < 8; j++) {
						trs.append('<td></td>');
					}
					trs.appendTo('#dayin-table—instrument');
				}
				
				$("#dayin-window_instrument").window("open");
			}});
			
			$(document).ready(function(){
				$('#caigocl_day').linkbutton({onClick :function(){
					$('.instrument_dayin').printArea();
				}});
			});
			
			$.get("clear_instrument" ,function(){});
			
			//点击新建刷新
			$("#xinjian_instrument").linkbutton({onClick : function(){
				$("#regist-patient-add-form").form('reset');
				
				$.get("cgdanhao", function(date){
					$('#qx_cg').textbox('setValue',date.substring(1,date.length-1));
				});
			}})
			
			$("#btn1").linkbutton({onClick : function(){
				selectcgopen(function(row){
					 caigoguandan(row);
				});
			}});
		
		$.get("cgdanhao", function(date){
			$('#qx_cg').textbox('setValue',date.substring(1,date.length-1));
		});
		
		
		//点击采购如入按钮 显示采购器械
		 $("#jiaru_id").linkbutton({onClick : function(){
			 if($("#instrumentZt").textbox('getValue')== '已确定'){
				 $.messager.alert("提示","不能重复处理该订单");
					return;
			 }
				$("#instrument_from").form("submit" , {
					url : 'get_andinstrument_String' ,
					onSubmit : function(param){
						param.DANWEI = unitName;
						return $(this).form("validate");
					},
					success : function(){
						$("#instrument_from").form('reset');
						$("#qixiecaigbiaoge").datagrid("reload","get_andinstrument");
						
						jisMONYE();
						
					}
				});
			}});
		 //添加挂单
		  $("#guadan_button").linkbutton({onClick : function(){
			  guanDaninstrument("未确定");
			}});
		  $("#caigocl_id").linkbutton({onClick : function(){
			  guanDaninstrument("已确定");
			}});
		  
		  //删除
		  $("#shanchu_id").linkbutton({onClick : function(){
				var row = $("#qixiecaigbiaoge").datagrid('getSelections');
				if($("#instrumentZt").textbox('getValue')== '已确定'){
					 $.messager.alert("提示","不能重复处理该订单");
						return;
				 }else if(row.length == 0){
					$.messager.alert("提示","请先选择一行")
				}else{
					var str = "";
					for(var i = 0 ; i < row.length ; i++){
						str += row[i].cGid + ",";
					}
					$.getJSON("delect_instrument", {qx : str} , function(data){
						$("#qixiecaigbiaoge").datagrid("reload" , 'get_andinstrument');
						jisMONYE();
					})
				}
			}});
		//根据修改的价格计算总价格
		  $("#shuliang").textbox({onChange : function(newValue, oldValue){
				var price = $("#danjia").textbox("getValue");
				if(!isNaN(newValue)){
					$("#jine").textbox("setValue" , price * newValue);
				}
			}});
		//根据修改的价格计算总价格
			$("#danjia").textbox({onChange : function(newValue, oldValue){
				var num = $("#shuliang").textbox("getValue");
				if(!isNaN(newValue)){
					$("#jine").textbox("setValue" , num * newValue);
				}
			}});
			//根据修改的修改价格计算总价格
			  $("#shuuliangg").textbox({onChange : function(newValue, oldValue){
					var price = $("#dangjiaa").textbox("getValue");
					if(!isNaN(newValue)){
						$("#jinejine").textbox("setValue" , price * newValue);
					}
				}});
			//根据修改的修改价格计算总价格
				$("#dangjiaa").textbox({onChange : function(newValue, oldValue){
					var num = $("#shuuliangg").textbox("getValue");
					if(!isNaN(newValue)){
						$("#jinejine").textbox("setValue" , num * newValue);
					}
				}});
		//修改面板获取
			$("#qixiecaigbiaoge").datagrid({onDblClickRow : function(index, rows){
				row = rows;
				$("#bjqiexie").window('open');
				$("#instrumentbj-form").form('load' , rows);
			}});
		//修改
			$("#bj_qd").linkbutton({onClick : function(){
				$("#instrumentbj-form").form("submit" , {
					url : 'up_instrument_String' ,
					onSubmit : function(param){
						return $(this).form("validate");
					},
					success : function(){
						$("#bjqiexie").window("close");
						$("#qixiecaigbiaoge").datagrid("reload",'get_andinstrument');
						jisMONYE();
					}
				});
			}});
		
			
		

		}); 
		//点击供应商 传值
		function otherWindowFzhi(row){
			$(".qxsupplierId").textbox('setValue' , row.supplierId);
			$(".qxsupplierName").textbox('setValue' , row.supplierName);
			$(".instrument_lxr").textbox('setValue',row.supplierLxr);
			$(".instrument_shoji").textbox('setValue',row.supplierPhone);
		}
		
		//计算订货金额
		function jisMONYE(){
			$.get("jisuan_instrument",function(data){
				$("#dinghuojine").textbox("setValue",data);
			});
		}
		
		function caigoguandan(row){
			if(row == null) {
				$.messager.alert('提示' , '请先选择一条数据!');
				 return ;
			}
			$("#qx_cg").textbox('setValue',row.instrumentCaigouId);
			$("#instrumentZt").textbox('setValue',row.instrumentCaigouState);
			$("#instrumentDHdate").datebox('setValue',row.instrumentCaigouDhDate);
			$("#instrumentGHdate").datebox('setValue',row.instrumentCaigouGhDate);
			$("#dinghuojine").textbox('setValue',row.instrumentCaigouMoney);
			$("#instrument_lxr").textbox('setValue',row.supplier.suplierLxr);
			$("#instrument_shoji").textbox('setValue',row.supplier.suplierPhone);
			$("#instrumentJH").textbox('setValue',row.instrumentCaigouAddress);
			$("#qxsupplierId").textbox('setValue',row.supplier.suplierId);
			$("#qxsupplierName").textbox('setValue',row.supplier.suplierName);
			$.get("clear_instrument" ,function(){});
			$("#qixiecaigbiaoge").datagrid({url : 'select_instrumentna'});
			$("#qixiecaigbiaoge").datagrid('load', {instrumentCaigouId : row.instrumentCaigouId});
			$("#xq-open").window("close");
		}
		
		//挂单和处理
		function guanDaninstrument(state){
			if($("#instrumentZt").textbox('getValue')== '已确定'){
				 $.messager.alert("提示","不能重复处理该订单");
					return;
			 }
			$("#regist-patient-add-form").form("submit",{
				url : "get_instrument_String",
				onSubmit : function(data){
					data.state=state;
					return $(this).form("validate");
				},
				success : function(data){
					var json = eval("("+data+")");
					if(json.error){ 
						if(state == '已确定'){
							$.messager.alert("操作" , "操作成功!");
							$("#regist-patient-add-form").form('reset');
							//自动生成采购订单号
							$.get("cgdanhao", function(date){
								$('#qx_cg').textbox('setValue',date.substring(1,date.length-1));
							});
							$.get("clear_instrument" ,function(){
								$("#qixiecaigbiaoge").datagrid("reload" , 'get_andinstrument');
							});
						}
					}else{
						$.messager.alert("提示",json.eMessage);
					} 
				}
			});
		}
		function totable(){
			 var rows = $("#qixiecaigbiaoge").datagrid("getRows");
			
			 for(var i = 0; i< rows.length; i++){
				 var trr = $("<tr style='text-align : center;height : 20px'></tr>");
				 trr.append("<td>"+rows[i].cGid+"</td>");
				 trr.append("<td>"+rows[i].qXCGID+"</td>");
				 trr.append("<td>"+rows[i].qXCGNAME+"</td>");
				 trr.append("<td>"+rows[i].sHULIANG+"</td>");
				 trr.append("<td>"+rows[i].dANWEI+"</td>");
				 trr.append("<td>"+rows[i].dANJIA+"</td>");
				 trr.append("<td>"+rows[i].jINE+"</td>");
				 trr.append("<td>"+rows[i].bEIZHU+"</td>");
				 trr.appendTo("#dayin-table—instrument");
			 }
		 }
</script> 
</body>
</html>