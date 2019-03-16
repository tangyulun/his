<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>门诊收费</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/js/easyui/themes/default/easyui.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/js/easyui/themes/icon.css"/>">
<script type="text/javascript"
	src="<c:url value="/js/jquery-3.1.0.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/js/easyui/jquery.easyui.min.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/js/easyui/easyui-lang-zh_CN.js"/>"></script>
</head>
<body>
<script type="text/javascript">
	$(function(){
		getChargeId();
		
		$("#eletronic-hao").linkbutton({onClick : function(){
			$("#eletronic-window-select").window('open');	
		}});
		
		$("#charges-open").linkbutton({onClick : function(){
			$("#outpatientcharges-window-select").window('open');
		}});
		
		$('#charges-print').linkbutton({onClick :function(){
			$.messager.confirm('确认对话框','要打印电子处方数据吗？',function(r){
				if(r){
					$('#outcharges-print-window').window('open');
				}
	
				$('#ouregistcharges-dyid').html($('#outpatient_charges').textbox('getValue'));
				$('#ouregistcharges-dydate').html($('#chargeManagementChargedate').textbox('getValue'));
				$('#ouregist-menzhenhao').html($('#pricemangement-regist-id').textbox('getValue'));
				$('#ouregistcharges-ysje').html($('#outpatientcahrges-ysje').textbox('getValue'));
				$('#ouregistcharges-name').html($('#chages-names').textbox('getValue'));
				$('#ouregistcharges-ssje').html($('#outpatientcahrges-ssje').textbox('getValue'));
				$('#ouregistcharges-ytje').html($('#outpatientcahrges-ssje').textbox('getValue')-
						$('#outpatientcahrges-ysje').textbox('getValue'));
				$('#outpatientcahrges-ytje').textbox('setValue' , 
						$('#outpatientcahrges-ssje').textbox('getValue')-
						$('#outpatientcahrges-ysje').textbox('getValue')		
				);
				//获取费用清单表格的数据
				var fytable = $('#outpatient-yicharges-tb').datagrid('getRows');
				$('.charges-tr').remove();
				for (var i = 0; i < fytable.length; i++) {
					if(fytable[i].financialHistoryShoufeizt=='记'){
						var tr = $("<tr align='center' height='15' class='charges-tr'></tr>");
						tr.append('<td>'+fytable[i].financialHistoryId+'</td>');
						tr.append('<td>'+fytable[i].financialHistoryShoufeilx+'</td>');
						tr.append('<td>'+fytable[i].financialHistoryShoufeiName+'</td>');
						tr.append('<td>'+fytable[i].financialHistoryShoufeije+'</td>');
						tr.append('<td>'+fytable[i].financialHistoryShoufeizt+'</td>');
						tr.append('<td>'+fytable[i].financialHistoryShoufeisj+'</td>');
						tr.appendTo('#outcharges-financial-tbody');
						
					}
				}
				
				for (var i = 0; i <15; i++) {
					var trs = $("<tr align='center' class='charges-tr' height='15'></tr>");
					for (var j = 0; j < 6; j++) {
						trs.append('<td></td>');
					}
					trs.appendTo('#outcharges-financial-tbody');
				}
				
				$('#outregistcharges-financialhejida').html(convertCurrency($('#outpatientcahrges-ysje').textbox('getValue')));
				$('#outregistcharges-financialhejixiao').html('￥'+$('#outpatientcahrges-ysje').textbox('getValue'));
			
			});
		}});
		
	});
	
	$(document).ready(function(){
		$('#outcharges-printarea-look').linkbutton({onClick :function(){
			$('.outcharges-print-div').printArea();
		}});
	});
	//获取门诊收费编号
	function getChargeId(){
		$.get("charge_number",function(data){
			$("#outpatient_charges").textbox('setValue',data.substring(1,data.length - 1));
		});
	}
	
	var rows = null;
	function loadChuFang(row){
		if(row == null){
			$.messager.alert("提示","选择数据不能为空！");
			return ;
		}
		rows = row;
		$("#pricemangement-regist-id").textbox('setValue', row.idField);
		$("#chages-names").textbox('setValue',row.medical.medicalCardName);
		//后台查询
		$.getJSON("query_prescrition",{outpaitentRegistId : row.idField},function(data){
			if(data.error){
				$("#chargers-chufang").textbox('setValue' , data.eMessage);
			}
			//未收费表格
			$.getJSON('query_outchargeswei_all',{outpaitentRegistId : row.idField},function(data){
				getFeiYongMenu(data);
			});
			
		});

	}
	
	
	function getFeiYongMenu(data){
		deleteWeiYong("#outpatient-weicharges-tb");
		deleteWeiYong("#outpatient-yicharges-tb");
		for (var i = 0; i < data.length; i++) {
			if(data[i].financialHistoryShoufeizt == '未'){
				loadTableRows('#outpatient-weicharges-tb' , data , i);
			}
			loadTableRows('#outpatient-yicharges-tb' , data , i);
		}
		//计算应收金额，实收金额，应退金额
		$('#outpatientcahrges-ysje').textbox('setValue',sumYingShouJe(data , i));
	}
	
	function loadTableRows(id , data , i ){
		$(id).datagrid('appendRow',{
			financialHistoryId : data[i].financialHistoryId,
			financialHistoryShoufeilx : data[i].financialHistoryShoufeilx,
			financialHistoryShoufeiName : data[i].financialHistoryShoufeiName,
			financialHistoryShoufeije : data[i].financialHistoryShoufeije,
			financialHistoryShoufeisj : data[i].financialHistoryShoufeisj,
			financialHistoryShoufeizt : data[i].financialHistoryShoufeizt
		});
	}
	
	function sumYingShouJe(data ,i){
		var moenys = 0.0;
		for (var i = 0; i < data.length; i++) {
			if(data[i].financialHistoryShoufeizt == '记'){
				moenys += data[i].financialHistoryShoufeije;
			}
		}
		return moenys;
	}
	
	$('#charges-ghcl').linkbutton({onClick : function(){
		var shishouje = $('#outpatientcahrges-ssje').textbox('getValue');
		var yingshou = $('#outpatientcahrges-ysje').textbox('getValue');
		if(shishouje < yingshou){
			$.messager.alert('提示','实收金额不能小于应收金额');
		}else{
			$('#outpatientcahrges-ytje').textbox('setValue', shishouje - yingshou);
			$.messager.alert("提示","<div style='font-weight:bolder;'>应退金额 <a style='color:red;font-size:28px;'>"+  (shishouje - yingshou) +"</a> 元</div>");
			//form表单提交数据
			$('#outregistcharges-forms').form('submit',{
				url : 'add_outpatientcharges',
				onSubmit : function(param){
					return $(this).form('validate');
				},
				success : function(v){
					var json = eval("("+v+")");
					if(json.error){
						var rowjes = $('#outpatient-yicharges-tb').datagrid('getRows');
						for (var i = 0; i < rowjes.length; i++) {
							$.getJSON('update_chargresZt',{id : rowjes[i].financialHistoryId ,typeName : rowjes[i].financialHistoryShoufeilx},function(data){
								if(data.error){
									$("#outregistcharges-forms").form('reset');
									deleteWeiYong("#outpatient-weicharges-tb");
									deleteWeiYong("#outpatient-yicharges-tb");
									getChargeId();
									return;
								}
							});
						}
					}
				}
			});
		}
	}});
	
	function deleteWeiYong(id){
		var rowei = $(id).datagrid('getRows');
		for (var i = rowei.length-1; i >= 0; i--) {
			$(id).datagrid('deleteRow' , i);
		}
	}

	//点击新建按钮的时候初始化
	$('#charges-init').linkbutton({onClick : function(){
		$('#outregistcharges-forms').form('reset');
		deleteWeiYong("#outpatient-weicharges-tb");
		deleteWeiYong("#outpatient-yicharges-tb");
		getChargeId();
	}});
	
</script>
	<div id="outpatientcharges-layout" class="easyui-layout" title="收费管理"
			data-options="modal:true,minimizable:false,maximizable:false,collapsible:false,resizable:false,fit:true,border:false">
			<div id="" data-options="region:'north'" 
				style="height: 45px; padding: 6px ; border-top: none;border-left: none;border-right: none">
				<table width="98%">
					<tr>
						<td>
							<a id="charges-init" href="#" class="easyui-linkbutton"
								data-options="iconCls:'icon-add',plain:true" style="width: 80px;">新建</a> 
							<!-- <a id="charges-gd" href="#"
								class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true" style="width: 80px;">挂单</a> -->
							<a id="charges-ghcl" href="#" class="easyui-linkbutton"
								data-options="iconCls:'icon-ok',plain:true" style="width: 100px; ">收费处理</a>
							<a id="charges-print"
								href="#" class="easyui-linkbutton" data-options="iconCls:'icon-print',plain:true"
								style="width: 80px;">打印</a> 
						</td>
					</tr>
				</table>
			</div>

			<div data-options="region:'center',fit:true,border:false">
				<form id="outregistcharges-forms" action="" method="post">
					<table width="100%" style="margin-top: 5px"> 
						<tr height="30px">
							<td><input name="chargeManagementId" id="outpatient_charges" class="easyui-textbox" readonly="readonly"
								data-options="label:'门诊收费号*',width:240,labelWidth:100,labelAlign:'right'"></td>
							<td><select name="chargeManagementZt" class="easyui-combobox" readonly="readonly"
								data-options="label:'状态',width:240,labelWidth:100,labelAlign:'right'">
									<option>未处理</option>
									<option>已处理</option>
								</select></td>
							<td><input name="chargeManagementChargedate" id="chargeManagementChargedate" class="easyui-datebox" value="new Date()"
								data-options="label:'收费日期',width:240,labelWidth:100,labelAlign:'right'"></td>
						</tr>
						
						<tr  height="30px">
							<td><input name="outpaitentRegistId" class="easyui-textbox" id="pricemangement-regist-id"
								data-options="label:'门诊号',width:280,labelAlign:'right',labelWidth:100,buttonText:'…',required:true,
								onClickButton : function(){
										menzhengh(function(row){
											if(row == null){                                                                                                                                                                                             
												$.messager.alert('操作','请至少选择一行数据!');
												return ;
											}
											loadChuFang(row);
										} , '已划价');
										
									}">
								
							</td>
							<td ><input name="prescriptionId" class="easyui-textbox" id="chargers-chufang"
								data-options="label:'处方号*',width:240,labelWidth:100,labelAlign:'right',required:true">
							</td>
							<td><input name="" class="easyui-textbox" id="chages-names"
								data-options="label:'病人姓名',width:240,labelWidth:100,labelAlign:'right',required:true"></td>
						</tr>
						
						<tr height="30px">
							<td><input name="chargeManagementYsjine" class="easyui-textbox" id="outpatientcahrges-ysje" readonly="readonly"
								data-options="label:'应收金额',width:240,labelWidth:100,labelAlign:'right',value:'0.00',required:true"></td>
							<td><input name="chargeManagementSsjine" class="easyui-textbox" id="outpatientcahrges-ssje"
								data-options="label:'实收金额*',width:240,labelWidth:100,labelAlign:'right',value:'0.00',required:true"></td>
							<td><input name="chargeManagementYtjine" class="easyui-textbox" id="outpatientcahrges-ytje"
								data-options="label:'应退金额',width:240,labelWidth:100,labelAlign:'right',value:'0.00',required:true"></td>
						</tr>
					</table>
				</form>
				<div id="regist-patient-add-tabs" class="easyui-tabs"  style="height:415px;margin-top: 10px" data-options="border:false"
					 >
					<div title="未收费" style="padding: 5px;">
						<table class="easyui-datagrid" id="outpatient-weicharges-tb"
							data-options="fit : true,fitColumns : true,rownumbers:true,method:'get'">
							<thead>
								<tr>
									<th data-options="field:'financialHistoryId',width:100,align:'left'">编号</th>
									<th data-options="field:'financialHistoryShoufeilx',width:150,align:'left'">收费类型</th>
									<th data-options="field:'financialHistoryShoufeiName',width:150,align:'left'">收费项目</th>
									<th data-options="field:'financialHistoryShoufeije',width:150,align:'left'">金额</th>
									<th data-options="field:'financialHistoryShoufeisj',width:100,align:'left'">收费日期</th>
									<th data-options="field:'financialHistoryShoufeizt',width:150,align:'left'">状态</th>
								</tr>
							</thead>
						</table>
					</div>
	
					<div title="费用清单" data-options="closable:false"
						style="padding: 5px;">
						<table class="easyui-datagrid"  id="outpatient-yicharges-tb"
							data-options="fit : true,fitColumns:true,rownumbers:true,method:'get'">
							<thead>
								<tr>
									<th data-options="field:'financialHistoryId',width:100,align:'left'">编号</th>
									<th data-options="field:'financialHistoryShoufeilx',width:150,align:'left'">收费类型</th>
									<th data-options="field:'financialHistoryShoufeiName',width:150,align:'left'">收费项目</th>
									<th data-options="field:'financialHistoryShoufeije',width:150,align:'left'">金额</th>
									<th data-options="field:'financialHistoryShoufeisj',width:100,align:'left'">收费日期</th>
									<th data-options="field:'financialHistoryShoufeizt',width:150,align:'left'">状态</th>
								</tr>
							</thead>
						</table>
					</div>
				</div>
			</div>	
		</div>
		
		<div id="outcharges-print-window" class="easyui-window" data-options="width: 700,
	          height: 600,
	          maximizable:false,
	          minimizable:false,
	          collapsible:false,
	          resizable:false,
	          title: '浏览表单',
	          closed: true,
	          modal: true">
			<div style="float: right;">
				<a class="easyui-linkbutton" id="outcharges-printarea-look"
					style="width: 60px; margin-top: 2px;margin-right: 2px;margin-bottom: 2px"
					data-options="iconCls:'icon-print',plain:true">打印
				</a>
			</div>
			<div class="outcharges-print-div">
				<div style="font-size: 14px;font-weight: bold;padding: 5px;color:#398000;">深圳XXX医院</div><hr style="border: 0px ;border: 1px dashed #D9E0EB"/>
				<div style="padding-left: 8px;padding-right: 8px;">
					<table id='print-tale-one' border="0" cellpadding="3" cellspacing="3"  bgcolor="#D9E0EB"  width="100%">
						<tr height="70" bgcolor="#FFFFFF">
							<td style="font-size: 22px;font-weight: bold;text-align: center;color: #398000;" colspan="4" >门诊收费单</td>
							
						</tr>
						
						<tr height="25" bgcolor="#FFFFFF">
							<td width="100">门诊收费号：</td>
							<td width="210px" id="ouregistcharges-dyid"></td>
							<td width="100">收费日期：</td>
							<td width="210px" id="ouregistcharges-dydate"></td>
						</tr>
						
						<tr height="25" bgcolor="#FFFFFF">
							<td width="100">门诊号：</td>
							<td width="210px" id="ouregist-menzhenhao"></td>
							<td width="100">应收金额：</td>
							<td width="210px" id="ouregistcharges-ysje"> </td>
						</tr>
						
						<tr height="25" bgcolor="#FFFFFF">
							<td width="100" >病人姓名：</td>
							<td width="210px" id="ouregistcharges-name"> </td>
							<td width="100" >实收金额：</td>
							<td width="210px" id="ouregistcharges-ssje"> </td>
							
						</tr>
						
						<tr height="25" style="border-bottom: 1px solid white" bgcolor="#FFFFFF"> 
							<td width="100">应退金额：</td>
							<td width="210px" id="ouregistcharges-ytje" colspan="3"> </td>
						</tr>
						
					</table>
					<table  border="1" width="100%"  id="outcharges-tables-financialsj" style="border:1px solid #95B8E7;
					    border-width: 1px;
					    border-collapse: collapse;">
							<tr height="20" style="font-family: '黑体'" align="center">
								<td>编号</td>
								<td>收费类型</td>
								<td>收费项目名称</td>
								<td>金额</td>
								<td>状态</td>
								<td>收费日期</td>
							</tr>
						<tbody id="outcharges-financial-tbody"></tbody>
						<tfoot>
							<tr height="20">
								<td align="center" style=''>合计（大）：</td>
								<td id="outregistcharges-financialhejida" align="center"  colspan="3"  style="color:#398000;font-weight: bold;"></td>
								<td align="center">（小写）：</td>
								<td id="outregistcharges-financialhejixiao" align="center" style="color:#398000;font-weight: bold;"></td>
							</tr>
						</tfoot>
						
					</table>
				</div>
			</div>
		</div>
</body>
</html>