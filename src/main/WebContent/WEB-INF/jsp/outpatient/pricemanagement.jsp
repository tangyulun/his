<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>划价管理</title>
</head>
<body >

<script type="text/javascript">
	$(function(){
		$("#pricemana-open").linkbutton({onClick :function(){
			$("#priceselect-window").window('open');
		}});
		
		$.get("pre_number",function(data){
			$("#huajiabianhao").textbox('setValue',data.substring(1,data.length-1));
		});
		

		//点击收费打开门诊收费
		$("#pricemana-shoufei").linkbutton({onClick : function(){
			addTab("门诊收费","outpatient/outpatientcharges");
		}});
		
		//点击划价处理的时候改变状态
		$("#pricemana-hjcl").linkbutton({onClick :function(){
			var hjcl = $('#pricemanagement-all-grid').datagrid('getRows');
				if( hjcl.length == 0){
					 $.messager.alert('提示','请至少选择一项项目进行处理!');
				}
				loadState();
		}});
		
		//新建按钮初始化
		$('#pricemana-init').linkbutton({onClick : function(){
			$('#pricemanagement-forms').form('reset');
			//删除south的数据
			var butrows = $("#pricemanagement-all-grid").datagrid('getRows');
			 for (var i = butrows.length-1; i >= 0; i--){
				$("#pricemanagement-all-grid").datagrid('deleteRow' , i);
			} 
			 deleteAllTabs("#jiayan-pricemanagement-tbs");
			 deleteAllTabs("#zhiliao-pricemanagement-tbs");
			 deleteAllTabs("#shoushu-pricemanagement-tbs");
			 deleteAllTabs("#haocai-pricemanagement-tbs");
			 deleteAllTabs("#pricemana-yiliao-tb");
			 deleteAllTabs("#price-drug-tbs");
			 deleteAllTabs('#pricemanagement-all-grid');
			 
			 $.get("pre_number",function(data){
					$("#huajiabianhao").textbox('setValue',data.substring(1,data.length-1));
				});
			 
			 $.messager.alert('提示','数据初始化完毕!');
		}});
		
		//全部核算按钮
		$('#pricemana-hsselect').linkbutton({onClick : function(){
			var butrows = $("#pricemanagement-all-grid").datagrid('getRows');
			 for (var i = butrows.length-1; i >= 0; i--){
				$("#pricemanagement-all-grid").datagrid('deleteRow' , i);
			} 
			getAllBoxChecked("#jiayan-pricemanagement-tbs");
			getAllBoxChecked("#zhiliao-pricemanagement-tbs");
			getAllBoxChecked("#shoushu-pricemanagement-tbs");
			getAllBoxChecked("#haocai-pricemanagement-tbs");
			getAllBoxChecked("#pricemana-yiliao-tb");
			getAllBoxChecked("#price-drug-tbs");
			
			 getAllMoney();
			 $.messager.alert('提示','全部划价核算完毕!');
		}});
		
		//点击划价核算保存记录
		$("#pricemana-hjhesuan").linkbutton({onClick : function(){
			var butrows = $("#pricemanagement-all-grid").datagrid('getRows');
			 for (var i = butrows.length-1; i >= 0; i--){
				$("#pricemanagement-all-grid").datagrid('deleteRow' , i);
			} 
			 getAllMoney();
			 $.messager.alert('提示','划价核算完毕!');
		}});
	});
	
	var rows = null;
	function loadTextValues(row){
		if(row == null){
			$.messager.alert("提示","选择数据不能为空！");
			return ;
		}
		rows = row;
		$("#pricemanagement-regist").textbox('setValue', row.idField);
		$("#pricemanagement-name").textbox('setValue',row.medical.medicalCardName);
			//药品选项卡
			$("#price-drug-tbs").datagrid({url : 'query_eletronic_perscri'});
			$("#price-drug-tbs").datagrid('load',{outpaitentRegistId : row.idField});
			
			//检验，手术，治疗
		    selectAllTable("#jiayan-pricemanagement-tbs" , "体检费");
		    selectAllTable("#zhiliao-pricemanagement-tbs" , "治疗费");
		    selectAllTable("#shoushu-pricemanagement-tbs" , "手术费");
		    selectAllTable("#haocai-pricemanagement-tbs" , "耗材费");
		    selectAllTable("#pricemana-yiliao-tb" , "其他");

	}
	
	function selectAllTable(id , typeName){
		$(id).datagrid({url : 'query_hospital_typename'});
		$(id).datagrid('load',{outpaitentRegistId : rows.idField , typeName : typeName});
	}
	
	function getAllMoney(){
		getAllCheckbox("#jiayan-pricemanagement-tbs");
		getAllCheckbox("#zhiliao-pricemanagement-tbs");
		getAllCheckbox("#shoushu-pricemanagement-tbs");
		getAllCheckbox("#haocai-pricemanagement-tbs");
	    getAllCheckbox("#pricemana-yiliao-tb");
	    getDrugCheckbox("#price-drug-tbs");
	    
	    jisuanYSMoney();//应收金额
	   	var m1 = sumfinanmoney("#jiayan-pricemanagement-tbs");
	   	var m2 = sumfinanmoney("#zhiliao-pricemanagement-tbs");
	   	var m3 = sumfinanmoney("#shoushu-pricemanagement-tbs");
	   	var m4 = sumfinanmoney("#haocai-pricemanagement-tbs");
	   	var m6 = sumfinanmoney("#pricemana-yiliao-tb");
	  	var m7 = sumdrugmoney("#price-drug-tbs");
	   	var  moneyZ = zx(m1)+zx(m2)+zx(m3)+zx(m4)+zx(m6)+zx(m7);
	   	$("#pricemanagement-zongmoney").textbox('setValue',moneyZ);
	}
	
	function zx(m){
		if(isNaN(m)){
			 m = 0.0;	
		}
		return parseFloat(m);
	}
	
	function getAllCheckbox(id){
		var rows = $(id).datagrid("getSelections");
		for (var i = 0; i < rows.length; i++) {
			 $("#pricemanagement-all-grid").datagrid('appendRow',{
				financialHistoryId : rows[i].financialId,
				financialHistoryShoufeilx : rows[i].financialTypeName,
				financialHistoryShoufeiName: rows[i].financialName,
				financialHistoryShoufeisj : rows[i].time,
				financialHistoryShoufeije : rows[i].financialPrice * rows[i].financialNum,
				financialHistoryShoufeizt :rows[i].financialzt,
				id :rows[i].id
			}); 
		}
	}
	
	function getDrugCheckbox(id){
		var rowis = $(id).datagrid("getSelections");
		 for (var i = 0; i < rowis.length; i++) {
			 $("#pricemanagement-all-grid").datagrid('appendRow',{
				financialHistoryId : rowis[i].prescriptionRecodeId,
				financialHistoryShoufeilx : rowis[i].prescriptionRecodeDrugType,
				financialHistoryShoufeiName :rowis[i].drugBname,
				financialHistoryShoufeisj : rowis[i].time,
				financialHistoryShoufeije : rowis[i].prescriptionRecodeNum * rowis[i].prescriptionRecodePrice,
				financialHistoryShoufeizt : rowis[i].prescriptionRecodeZt,
				id :rowis[i].id
			});
		} 
	}
	
	//计算总金额
	function sumfinanmoney(id){
		var money = 0.0;
		var sumfinanmoney = $(id).datagrid("getRows");
		for (var i = 0; i < sumfinanmoney.length; i++) {
			money += sumfinanmoney[i].financialMoney;
		}
		return money;
	}
	
	function sumdrugmoney(id){
		var money = 0.0;
		var sumdrugmoney = $(id).datagrid("getRows");
		for (var i = 0; i < sumdrugmoney.length; i++) {
			money += sumdrugmoney[i].prescriptionRecodeMoney;
		}
		return money;
	}
	
	//获取选项卡的金额 ，计算应收金额
	function jisuanYSMoney(){
		var money = 0.0;
		var rowm = $("#pricemanagement-all-grid").datagrid("getRows");
		for (var i = 0; i < rowm.length; i++) {
			money += rowm[i].financialHistoryShoufeije;
		}
		$("#pricemanagement-ysmoney").textbox('setValue',money);
	}
	
	function loadState(){
		var isFlag = true;
		var rows = $('#pricemanagement-all-grid').datagrid('getRows');
		for (var i = 0; i < rows.length; i++) {
			$('#pricemanagement-all-grid').datagrid('updateRow',{
				index : i,
				row : {
					financialHistoryShoufeizt : '记'
				}
			});
			$.getJSON('update_pricemanagement_all',{id : rows[i].id , financialHistoryShoufeilx : rows[i].financialHistoryShoufeilx , outpaitentRegistId : $("#pricemanagement-regist").textbox('getValue')},function(data){
				if(isFlag){
					$.messager.alert('提示' , "划价成功!");
					isFlag = false;
					 $('#pricemanagement-forms').form('reset');
					 $('#zongfeiyongjine-forms').form('reset');
					 deleteAllTabs("#jiayan-pricemanagement-tbs");
					 deleteAllTabs("#zhiliao-pricemanagement-tbs");
					 deleteAllTabs("#shoushu-pricemanagement-tbs");
					 deleteAllTabs("#haocai-pricemanagement-tbs");
					 deleteAllTabs("#pricemana-yiliao-tb");
					 deleteAllTabs("#price-drug-tbs");
					 deleteAllTabs('#pricemanagement-all-grid');
					 
					 $.get("pre_number",function(data){
							$("#huajiabianhao").textbox('setValue',data.substring(1,data.length-1));
						});
				}
			});
		}
	}
	
	//删除center的数据
	function deleteAllTabs(id){
		var butrowalls = $(id).datagrid('getRows');
		 for (var i = butrowalls.length-1; i >= 0; i--){
			$(id).datagrid('deleteRow' , i);
		} 
		 $(id).datagrid('uncheckAll');
	}
	
	function getAllBoxChecked(id){
		$(id).datagrid('checkAll');
	}
	
</script>
	<div id="win" class="easyui-layout" title="划价管理"
			data-options="modal:true,minimizable:false,maximizable:false,collapsible:false,resizable:false,fit:true,border:false">
			<div id="regist-top-id" data-options="region:'north'" 
				style="height: 45px; padding: 6px ; border-top: none;border-left: none;border-right: none">
				<table width="98%" >
					<tr>
						<td>
							<a id="pricemana-init" href="#" class="easyui-linkbutton"
								data-options="iconCls:'icon-add',plain:true" style="width: 80px">新建</a> 
							<a id="pricemana-hsselect"
								href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:true"
								style="width: 80px">全部核算</a>
							<a id="pricemana-hjhesuan" href="#"
								class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true" style="width: 80px">划价核算</a>
							<a id="pricemana-shoufei" href="#" class="easyui-linkbutton"
								data-options="iconCls:'icon-shoufei',plain:true" style="width: 80px; ">收费</a>
							<a id="pricemana-hjcl" href="#" class="easyui-linkbutton"
								data-options="iconCls:'icon-ok',plain:true" style="width: 80px; ">划价处理</a> 
							<!-- <a
								id="pricemana-dy" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-print',plain:true"
								style="width: 80px">打印</a> -->
						</td>
					</tr>
				</table>
			</div>

			<div data-options="region:'center',fit:true,border:false">
				<form id="pricemanagement-forms" action="" method="post">
					<table width="100%" style="margin-top: 5px"> 
						<tr height="30">
							<td><input name=""  id="huajiabianhao" class="easyui-textbox" readonly="readonly"
								data-options="label:'划价编号*',width:240,labelAlign:'right'">
							</td>
							<td><select name="" class="easyui-combobox"  readonly="readonly"
									data-options="label:'状态',width:240,labelAlign:'right',editable:false">
									<option>未处理</option>
									<option>已处理</option>
								</select>
							</td>
							<td><select name="empId" class="easyui-combobox"
									data-options="label:'操作人',width:240,labelAlign:'right'">
									<option value="${empMessage.empId}">${empMessage.empLoginName}</option>
								</select>
							</td>
							<td><input name="" class="easyui-datebox" value="new Date()"
								data-options="label:'划价日期*',width:240,labelAlign:'right',editable:false">
							</td>
						</tr>
						<tr  height="30px">
							<td><input name="" class="easyui-textbox" id="pricemanagement-regist" 
									data-options="label:'门诊号*',width:260,required:true,labelAlign:'right',editable:false,buttonText:'…',
									onClickButton : function(){
										menzhengh2(function(row){
											if(row == null){                                                                                                                                                                                             
												$.messager.alert('操作','请至少选择一行数据!');
												return ;
											}
											loadTextValues(row);
										},'已处理');
									}">
								</td>
							<td ><input name="" id="pricemanagement-eletronic" class="easyui-textbox" readonly="readonly"
								data-options="label:'处方号*',width:240,required:true,labelAlign:'right'">
							</td>
							<td><input name="" class="easyui-textbox" id="pricemanagement-name" readonly="readonly"
								data-options="label:'病人姓名',width:240,required:true,labelAlign:'right'">
							</td>
						</tr>
					</table>
				</form>
					<div id="regist-patient-add-tabs" class="easyui-tabs" data-options="border:false"
						style="margin-top: 10px; height: 248px;" >
						<div title="药品" data-options="closable:false"
							style="padding: 5px; display: none;">
							<table class="easyui-datagrid" id="price-drug-tbs"
								data-options="fit : true,fitColumns : true,method:'get',rownumbers:true,striped:true">
								<thead>
									<tr>
										<th data-options="field:'code1',width:100,align:'left',checkbox:true"></th>
										<th data-options="field:'prescriptionRecodeId',width:100,align:'left'">药品编号</th>
										<th data-options="field:'drugBname',width:100,align:'left'">药品名称</th>
										<th data-options="field:'prescriptionRecodeNum',width:100,align:'left'">数量</th>
										<th data-options="field:'prescriptionRecodePrice',width:150,align:'left'">单价</th>
										<th data-options="field:'prescriptionRecodeMoney',width:150,align:'left'">金额</th>
										<th data-options="field:'prescriptionRecodeZt',width:300,align:'left'">状态</th>
									</tr>
								</thead>
							</table>
							
						</div>
						<div title="检验" data-options="closable:false"
							style="padding: 5px; display: none;">
							<table class="easyui-datagrid" id="jiayan-pricemanagement-tbs"
								data-options="fit : true,fitColumns : true,method:'get',rownumbers:true,striped:true">
								<thead>
									<tr>
										<th data-options="field:'code1',width:100,align:'left',checkbox:true"></th>
										<th data-options="field:'financialId',width:150,align:'left'">收费项目编号</th>
										<th data-options="field:'financialName',width:150,align:'left'">收费项目名称</th>
										<th data-options="field:'financialNum',width:100,align:'left'">数量</th>
										<th data-options="field:'financialPrice',width:100,align:'left'">单价</th>
										<th data-options="field:'financialMoney',width:150,align:'left'">金额</th>
										<th data-options="field:'financialzt',width:250,align:'left'">状态</th>
									</tr>
								</thead>
							</table>
						</div>
						
						<div title="治疗" data-options="closable:false"
							style="padding: 5px; display: none;">
							<table class="easyui-datagrid"  id="zhiliao-pricemanagement-tbs"
								data-options="fit : true,fitColumns : true,method:'get',rownumbers:true,striped:true">
								<thead>
									<tr>
										<th data-options="field:'code1',width:100,align:'left',checkbox:true"></th>
										<th data-options="field:'financialId',width:150,align:'left'">收费项目编号</th>
										<th data-options="field:'financialName',width:150,align:'left'">收费项目名称</th>
										<th data-options="field:'financialNum',width:100,align:'left'">数量</th>
										<th data-options="field:'financialPrice',width:100,align:'left'">单价</th>
										<th data-options="field:'financialMoney',width:150,align:'left'">金额</th>
										<th data-options="field:'financialzt',width:250,align:'left'">状态</th>
									</tr>
								</thead>
							</table>
						</div>
						
						<div title="手术" data-options="closable:false"
							style="padding: 5px; display: none;">
							<table class="easyui-datagrid"  id="shoushu-pricemanagement-tbs"
								data-options="fit : true,fitColumns : true,method:'get',rownumbers:true,striped:true">
								<thead>
									<tr>
										<th data-options="field:'code1',width:100,align:'left',checkbox:true"></th>
										<th data-options="field:'financialId',width:150,align:'left'">收费项目编号</th>
										<th data-options="field:'financialName',width:150,align:'left'">收费项目名称</th>
										<th data-options="field:'financialNum',width:100,align:'left'">数量</th>
										<th data-options="field:'financialPrice',width:100,align:'left'">单价</th>
										<th data-options="field:'financialMoney',width:150,align:'left'">金额</th>
										<th data-options="field:'financialzt',width:250,align:'left'">状态</th>
									</tr>
								</thead>
							</table>
						</div>
						
						<div title="耗材" data-options="closable:false"
							style="padding: 5px; display: none;">
							<table class="easyui-datagrid"  id="haocai-pricemanagement-tbs"
								data-options="fit : true,fitColumns : true,method:'get',rownumbers:true,striped:true">
								<thead>
									<tr>
										<th data-options="field:'code1',width:100,align:'left',checkbox:true"></th>
										<th data-options="field:'financialId',width:150,align:'left'">收费项目编号</th>
										<th data-options="field:'financialName',width:150,align:'left'">收费项目名称</th>
										<th data-options="field:'financialNum',width:100,align:'left'">数量</th>
										<th data-options="field:'financialPrice',width:100,align:'left'">单价</th>
										<th data-options="field:'financialMoney',width:150,align:'left'">金额</th>
										<th data-options="field:'financialzt',width:250,align:'left'">状态</th>
									</tr>
								</thead>
							</table>
						</div>
						
						<div title="其他" style="padding: 5px; display: none;">
							<table class="easyui-datagrid" id="pricemana-yiliao-tb"
								data-options="fit : true,fitColumns : true,method:'get',rownumbers:true,striped:true">
								<thead>
									<tr>
										<th data-options="field:'code1',width:100,align:'left',checkbox:true"></th>
										<th data-options="field:'financialId',width:150,align:'left'">收费项目编号</th>
										<th data-options="field:'financialName',width:150,align:'left'">收费项目名称</th>
										<th data-options="field:'financialNum',width:100,align:'left'">数量</th>
										<th data-options="field:'financialPrice',width:100,align:'left'">单价</th>
										<th data-options="field:'financialMoney',width:150,align:'left'">金额</th>
										<th data-options="field:'financialzt',width:250,align:'left'">状态</th>
									</tr>
								</thead>
							</table>
						</div>
						
					</div>
					<form action="" id="zongfeiyongjine-forms">
						<table>
							<tr >
								<td><input class="easyui-textbox" id="pricemanagement-zongmoney" readonly="readonly" data-options="label:'总费用',labelWidth:100,width:280,labelAlign:'right',value:'0.00'"></td>
								<td><input class="easyui-textbox" id="pricemanagement-ysmoney"   readonly="readonly"  data-options="label:'应收金额',labelWidth:100,width:280,labelAlign:'right',value:'0.00'"></td>
							</tr>
						</table>
					</form>
				</div>
				
				<div data-options="region:'south',border:false" style="height: 165px;padding: 5px;">
					
						<table class="easyui-datagrid" id="pricemanagement-all-grid" 
							data-options="
								method:'get',
								fit : true,
								singleSelect:true,
								fitColumns:true,
								rownumbers:true
								">
							<thead>
								<tr>
									<th data-options="field:'id',width:100,align:'left',hidden:true">编号</th>
									<th data-options="field:'financialHistoryShoufeilx',width:100,align:'left'">收费类型</th>
									<th data-options="field:'financialHistoryShoufeiName',width:200,align:'left'">收费项目</th>
									<th data-options="field:'financialHistoryShoufeisj',width:250,align:'left'">收费日期</th>
									<th data-options="field:'financialHistoryShoufeije',width:150,align:'left'">金额</th>
									<th data-options="field:'financialHistoryShoufeizt',width:200,align:'left'">状态</th>
								</tr>
							</thead>
						</table>
					
				</div>
			</div>
			
			<div id="priceselect-window" class="easyui-window" data-options="width:1010,height:500,title:'选择划价',modal:true,minimizable:false,maximizable:false,collapsible:false,resizable:false,closed:true">
				<div id="priceselect-layout" class="easyui-layout" data-options="fit:true">
						
						<div data-options="region:'center' , border:false"
							style="height: 450px;padding: 5px" >
							<table class="easyui-datagrid" data-options="
								fit : true,
								fitColumns:true,
								toolbar:'#delete-queding',
								striped:true,
								pagination:true,
								rownumbers:true,
								pageSize:10,
								pageList:[10,20,30,40]
							">
								<thead>
									<tr>
										<th data-options="field:'code',width:50,align:'left'">*</th>
										<th data-options="field:'name',width:150,align:'left'">划价单编号</th>
										<th data-options="field:'price',width:50,align:'left'">状态</th>
										<th data-options="field:'price1',width:150,align:'left'">门诊号</th>
										<th data-options="field:'price2',width:100,align:'left'">病人姓名</th>
										<th data-options="field:'price4',width:100,align:'left'">总金额</th>
										<th data-options="field:'price5',width:100,align:'left'">应收金额</th>
										<th data-options="field:'price6',width:100,align:'left'">划价日期</th>
										<th data-options="field:'price7',width:100,align:'left'">机台号</th>
										<th data-options="field:'price8',width:100,align:'left'">处方号</th>
									</tr>
								</thead>
							</table>
						</div>
						
						<div id="delete-queding" >
									<input name="" class="easyui-datebox"
										data-options="label:'查询区间',width:350,labelAlign:'right'">
										至 <input name="" class="easyui-datebox"
										data-options="width:260"> 
									<a id=""
										href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'"
										style="width: 80px">查询</a>
										<td align="right">
									<a id=""
										href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove'"
										style="width: 80px">删除</a>
									<a id=""
										href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'"
										style="width: 80px">确定</a>
						</div>
					</div>
				</div>
	
				<div id="pricemangement-window-select" class="easyui-window" data-options="
						 width: 900,
				          height: 500,
				          title: '选择挂号',
				          maximizable:false,
				          minimizable:false,
				          collapsible:false,
				          resizable:false,
				          href: 'href_address?myValue=outpatient/regist_datagridselect',
				          closed: true,
				          modal: true
					">
				</div>
</body>
</html>