<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>电子处方</title>
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
			if('${e}' == '门诊处方'){
				$('.outregist-zhuyuanId').textbox('disable');
			}else{
				$('.eletronic-regist-id').textbox('disable');
			}
			clear_drug();//清空处方开药
			clear();//清空医疗项目
			//获取处方编号
			$.get("eletronic_number",function(data){
				$(".eletronic_bh").textbox('setValue',data.substring(1,data.length-1));
			});
 			
			$("#electroni-chuli").linkbutton({onClick :function(){
				tijiao();
			}});
			
			$("#charges-dy").linkbutton({onClick :function(){
				$.messager.confirm('确认对话框','要打印电子处方数据吗？',function(r){
					if(r){
						$('#dayinforms-window').window('refresh' , 'href_address?myValue=outpatient/dayinforms');
						$('#dayinforms-window').window('open');
					}
				
				});
			}});
			
			//加载成功之后加载表格数据
			 $('#dayinforms-window').window({onLoad : function(){
				 $('#eletonic-dyid').html($('.eletronic_bh').textbox('getValue'));
					$('#outregist-dyid').html($('.eletronic-regist-id').textbox('getValue'));
					$('#eletonic-dydate').html($('.eletonic-dates').textbox('getValue'));
					$('#zhuyuan-dyid').html($('.outregist-zhuyuanId').textbox('getValue'));
					$('#outregist-name').html($('#eletronic-name').textbox('getValue'));
					$('#dclass-name').html($('#eletronic-keshi').textbox('getValue'));
					$('#outregist-age').html($('#eletronic-age').textbox('getValue'));
					$('#outregist-sex').html($('#eletronic-sex').textbox('getValue'));
					$('#eletronic-doctor').html($('#eletronic-doctors').textbox('getText'));
					
					var financial = $('#drug-list-table').datagrid('getRows');
					var hospital = $('#hospital-table').datagrid('getRows');
					//循环打印收费项目
					for (var i = 0; i < financial.length; i++) {
						var tr = $("<tr align='center' height='15'></tr>");
						tr.append('<td  style="color:#000000">'+financial[i].prescriptionRecodeId+'</td>');
						tr.append('<td  style="color:#000000">'+financial[i].prescriptionRecodeDrugType+'</td>');
						tr.append('<td  bgcolor="#CCFFFF" style="color:#000000">'+financial[i].drugBname+'</td>');
						tr.append('<td  style="color:#000000">'+financial[i].prescriptionRecodeNum+'</td>');
						tr.append('<td  style="color:#000000">'+financial[i].prescriptionRecodePrice+'</td>');
						tr.append('<td bgcolor="#CCFFFF" style="color:#000000">'+financial[i].prescriptionRecodeMoney+'</td>');
						tr.appendTo('#financial-tbody');
					}
					
					//循环打印处方
					 for (var i = 0; i < hospital.length; i++) {
						var tr = $("<tr align='center'  height='15'>");
						tr.append('<td style="color:#000000">'+hospital[i].financialId+'</td>');
						tr.append('<td style="color:#000000">'+hospital[i].financialTypeName+'</td>');
						tr.append('<td bgcolor="#CCFFFF" style="color:#000000">'+hospital[i].financialName+'</td>');
						tr.append('<td style="color:#000000">'+hospital[i].financialNum+'</td>');
						tr.append('<td style="color:#000000">'+hospital[i].financialPrice+'</td>');
						tr.append('<td bgcolor="#CCFFFF" style="color:#000000">'+hospital[i].financialMoney+'</td>');
						tr.appendTo('#financial-tbody');
					}
					
					for (var i = 0; i <21 - (financial.length + hospital.length); i++) {
						var tr = $("<tr align='center' height='15'></tr>");
						for (var j = 0; j < 6; j++) {
							if(j == 2 || j== 5){
								tr.append("<td bgcolor='#CCFFFF'></td>");
							}else{
								tr.append("<td></td>");
							}
						}
						tr.appendTo('#financial-tbody');
					}
					
					$("#financialhejida").html(convertCurrency($('#sum_moeny').textbox('getValue')));
					$("#financialhejixiao").html('￥'+$('#sum_moeny').textbox('getValue'));
					
				}});
			
		});
	
		var rowi = null;
		function loadFinancial(rowi){
			if(rowi == null){
				$.messager.alert("提示","请选择一个项目");
			}
			$("#hospital-project").textbox('setValue',rowi.financialId);
			$("#hospital-projectName").textbox('setValue',rowi.financialName);
			$("#hospital-price").textbox('setValue',rowi.financialPrice);
			$("#hospital-money").textbox('setValue',rowi.financialMoney);
			$("#eletronic-win-window").window('close');
		}
		
		//获取医疗项目的数量
		$("#hospital-num").textbox({onChange : function(newValue , oldValue){
			var price = $("#hospital-price").textbox('getValue');
			if(!isNaN(newValue)){
				$("#hospital-money").textbox('setValue' , price * newValue);
			}
		}});
		
		//添加医疗项目
		function HospitalFinancialCode(){
			var financialId = $("#hospital-project").textbox('getValue');
			var financialName = $("#hospital-projectName").textbox('getValue');
			var financialNum = $("#hospital-num").textbox('getValue');
			var financialPrice = $("#hospital-price").textbox('getValue');
			var financialMoney = $("#hospital-money").textbox('getValue');
			if(financialId == ''||financialName == ''|| financialNum == ''|| financialPrice == ''||financialMoney == ''){
				$.messager.alert("提示","提交信息不能为空");
				return;
			}else if(isNaN(financialNum)){
				$.messager.alert("提示","请输入数量！");
				return;
			}else if($("#eletronic-zhuangtai").combobox('getValue')=='已处理'){
				$.messager.alert("提示","数据不能重复提交！");
				return;
			}
			$.get("add_HospitalPresc",{financialId : $("#hospital-project").textbox('getValue'),
				financialName:$("#hospital-projectName").textbox('getValue'),
				financialNum:$("#hospital-num").textbox('getValue'),
				financialPrice:$("#hospital-price").textbox('getValue'),
				financialMoney:$("#hospital-money").textbox('getValue')},
					function(){
						selectHospital();
					}
				);
		}
		
		//点击加入医疗项目的时候加入
		$("#hospital-financial-jiaru").linkbutton({onClick: function(){
			HospitalFinancialCode();
			sumMoney();
		}});
		
		//点击医疗项目删除的删除
		$("#hospital-financial-shanchu").linkbutton({onClick : function(){
			deleteFindByID();
		}});
		
		function clear(){
			$.get("clear_Hospital",function(){});
		}
		function selectHospital(){
			$("#hospital-table").datagrid('reload','query_Hospital');
			//清空医疗文本框文本框
			setValueNULL();
		}
		
		function setValueNULL(){
			//$('#hospital-num').textbox('setValue','');
			$('#hospital-price').textbox('setValue','');
			$('#hospital-money').textbox('setValue','');
			$('#hospital-project').textbox('setValue','');
			$('#hospital-projectName').textbox('setValue','');
		}
		
		function deleteFindByID(){
			var rows = $("#hospital-table").datagrid('getSelections');
			if(rows.length == 0){
				$.messager.alert("提示","请至少选择一行删除");
				return;
			}else{
				var str = "";
				for (var i = 0; i < rows.length; i++) {
					str += rows[i].id+",";
				}
				$.get("delete_code",{idCode : str},function(){
					selectHospital();
				});
			}
		}
		
		
		function deleteTables(){
			var rows = $("#hospital-table").datagrid('getSelections');
				var str = "";
				for (var i = 0; i < rows.length; i++) {
					str += rows[i].id+",";
				}
				$.get("delete_code",{idCode : str},function(){
					selectHospital();
				});
		}
	
		//点击选择药品确定传到处方开药界面
		$(".inancialistory-win-window").window({onLoad : function(){
			$(".refresh-drug-queding").linkbutton({onClick :function(){
				loadDrug(rowd);
			}});
			
			$(".drug-tables").datagrid({onDblClickRow : function(index , rows){
				loadDrug(rows);
				rowd = rows;
			}});
		}})
		
		var rowd = null;
		function loadDrug(rowd){
			if(rowd == null){
				$.messager.alert("提示","请选择一个项目");
				return;
			}
			
			$("#drug-id").textbox('setValue',rowd.drugId);
			$("#drug-name").textbox('setValue',rowd.drugBname);
			//$("#drug-shuoming").textbox('setValue',rowd.drugId);
			$("#drug-num").textbox('setValue','1');
			//$("#drug-jiliang").textbox('setValue',rowd.drugId);
			$("#drug-price").textbox('setValue',rowd.drugLsprice);
			$("#drug-money").textbox('setValue',rowd.drugLsprice);
			$(".inancialistory-win-window").window('close');
		}
		
		//点击加入的时候加入处方开药
		$("#drug-jiaru-btn").linkbutton({onClick : function(){
			addDrug();
		}});
		//获取处方开药的数量
		$("#drug-num").textbox({onChange : function(newValue , oldValue){
			var price = $("#drug-price").textbox('getValue');
			var jiliang = $("#drug-num").textbox('getValue');
			if(!isNaN(newValue)){
				$("#drug-jiliang").textbox('setValue',jiliang);
				$("#drug-money").textbox('setValue' , price * newValue);
			}
		}});
		

		//修改库存数量
		function kucunNum(kucunNum , drugId){
			$.getJSON('update_kucun_num' , {kucunNum : kucunNum , drugId : drugId} , function(data){
				if(!data.error){
					$.messager.alert("提示",data.eMessage);
				}
			});
		}
		
		//添加处方开药的方式
		function addDrug(){
			var drugNum = $("#drug-num").textbox('getValue');
			if($("#drug-num").textbox('getValue') > rowd.kukun.yaofangKaiyaoShengyuNum){
				$.messager.alert('提示','该药品数量不足！');
				return;
			}else if($("#drug-name").textbox('getValue') == '' || $("#drug-num").textbox('getValue') == ''){
				$.messager.alert('提示','数量不能为空！');
				return;
			}else if(isNaN(drugNum)){
				$.messager.alert('提示','输入正确的数量！');
			}
			$.get("add_drug_all",{prescriptionRecodeId : $("#drug-id").textbox('getValue'),
				drugBname : $("#drug-name").textbox('getValue'),
				prescriptionRecodeExplain: $("#drug-shuoming").textbox('getValue'),
				prescriptionRecodeNum: $("#drug-num").textbox('getValue'),
				prescriptionRecodePrice: $("#drug-price").textbox('getValue'),
				prescriptionRecodeMoney: $("#drug-money").textbox('getValue'),
				prescriptionRecodeNum: $("#drug-num").textbox('getValue')},
				function(){
					kucunNum($("#drug-num").textbox('getValue') , $("#drug-id").textbox('getValue'));
					selectDrug();
				});
			}
		
		//查询处方开药的方法
		function selectDrug(){
			$("#drug-list-table").datagrid('reload','query_drug_all');
			sumMoney();
			setValueNull();
		}
		
		function setValueNull(){
			$("#drug-id").textbox('setValue','');
			$("#drug-name").textbox('setValue','');
			//$("#drug-num").textbox('setValue','');
			$("#drug-price").textbox('setValue','');
			$("#drug-money").textbox('setValue','');
			$("#drug-jiliang").textbox('setValue','');
			$("#drug-shuoming").textbox('setValue','');
		}
		//清除list集合的方法
		function clear_drug(){
			$.get("clear_eletronic",function(){});
		}
		
		//删除处方开药的表格数据
		$("#drug-delete").linkbutton({onClick :function(){
			drugFindById();
		}});
		
		function drugFindById(){
			var row = $("#drug-list-table").datagrid('getSelections');
			if(row.length == 0){
				$.messager.alert("提示","请选择一行数据删除！");
				return;
			}
			var strs = "";
			for (var i = 0; i < row.length; i++) {
				strs += row[i].id + ",";
			}
			$.get("delete_drug",{ids :strs},function(){
				selectDrug();
			});
		}
		
		//点击数据表格修改
		$("#drug-list-table").datagrid({onDblClickRow :function(index,row){
			$("#update-drug-window").window('open');
			$("#drugform").form("load" , row);
			$("#drug-save-btn").linkbutton({onClick : function(){
				if($("#update-eletronicnum").textbox('getValue') > rowd.kukun.yaofangKaiyaoShengyuNum){
					$.messager.alert('提示','输入数量不能大于库存数量！');
					return;
				} 
				$("#drugform").form('submit',{
					url:'update_drug_code',
					onSubmit : function(param){
						param.id = row.id;
						param.num = row.prescriptionRecodeNum - $("#update-eletronicnum").textbox('getValue');
						return $(this).form('validate');
					},
					success :function(){
						//判断输入的数量是否大于库存数量
						 //kucunNum($('#update-eletronicnum').textbox('getValue') , $('#update-eletronicId').textbox('getValue')); 
						selectDrug();//重新查询这个数据页面
						$("#update-drug-window").window('close');//关闭修改页面
					}
				});
			
			}});
		}});
	
		//计算总金额
		function sumMoney(){
			$.getJSON("select_sum_money" , function(data){
				$("#sum_moeny").textbox('setValue' , data);
			});
		}
		function tijiao(){
			$("#eletronic-patient-add-form").form('submit',{
				url:'add_prescription',
				onSubmit : function(param){
					param.eType = '${e}';
					param.hId = $('.outregist-zhuyuanId').textbox('getValue')
					return $(this).form('validate');
				},
				success : function(data){
						var json = eval("("+data+")");
						if(json.error){
						 $.messager.alert('提示','数据处理成功！');
							$("#eletronic-patient-add-form").form("reset");
							$.get("eletronic_number",function(data){
								$(".eletronic_bh").textbox('setValue',data.substring(1,data.length-1));
							});
							clear();
							clear_drug();
							$('#sum_moeny').textbox('setValue','');
							selectHospital();
							selectDrug();
						}
					}
				
			});
		}
		
		$('#electroni-init').linkbutton({onClick : function(){
			$('#eletronic-patient-add-form').form('reset');
			deleteTables();
			setValueNull();
			setValueNULL();
			//获取处方编号
			$.get("eletronic_number",function(data){
				$(".eletronic_bh").textbox('setValue',data.substring(1,data.length-1));
			});
		}});
		
		
	</script>
	
	<div id="" class="easyui-layout" title=""
			data-options="modal:true,minimizable:false,maximizable:false,collapsible:false,resizable:false,fit:true,border:false">
		<div class="easyui-layout" data-options="fit:true,border:false">

			<div id="regist-top-id" data-options="region:'north'" 
				style="height: 45px; padding: 6px ; border-top: none;border-left: none;border-right: none">
				<table width="98%">
					<tr>
						<td>
							<a id="electroni-init" href="#" class="easyui-linkbutton"
								data-options="iconCls:'icon-add',plain:true" style="width: 80px">新建</a>
							<!-- <a id="electroni-open"
								href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload'"
								style="width: 80px">打开</a>  -->
							<!-- <a id="electroni-gd" href="#"
								class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true" style="width: 80px">挂单</a> -->
							<a id="electroni-chuli" href="#" class="easyui-linkbutton"
								data-options="iconCls:'icon-ok',plain:true" style="width: 80px; ">处理</a>
							<a
								id="charges-dy" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-print',plain:true"
								style="width: 80px;">打印</a>
						</td>
					</tr>
					
				</table>
				
			</div>

			<div data-options="region:'center' , border:false,fit:true">
				<form id="eletronic-patient-add-form" action="" method="post">
					<table width="100%"  style="margin-top: 5px"> 
						<tr height="30">
							<td><input name="prescriptionId" class="easyui-textbox eletronic_bh"  readonly="readonly"
								data-options="label:'处方号*',width:240,labelAlign:'right',labelWidth:100"></td>
							<td><select name="prescriptionZt" class="easyui-combobox" id="eletronic-zhuangtai"
								data-options="label:'状态',width:240,labelAlign:'right' , editable : false" readonly="readonly">
								<option>未处理</option>	
								<option>已处理</option>	
							</select></td>
							<td><select name="prescriptionYzzx" class="easyui-combobox"
								data-options="label:'医嘱执行',width:240,labelAlign:'right'">
									<option>Y</option>
									<option>N</option>
								</select>
							</td>
							<td><input name="prescriptionDate" class="easyui-datebox eletonic-dates" value="new Date()" readonly="readonly"
								data-options="label:'处方日期',width:240,labelAlign:'right'"></td>
						</tr>
						<tr height="30">
							<td><input name="outRegistId" class="easyui-textbox eletronic-regist-id"  
								data-options="label:'门诊号',width:280,labelAlign:'right',required:true,labelWidth:100,buttonText:'…',
								onClickButton : function(){
										menzhengh(function(row){
											if(row == null){                                                                                                                                                                                             
												$.messager.alert('操作','请至少选择一行数据!');
												return ;
											}
											$('.eletronic-regist-id').textbox('setValue', row.idField);
											$('#eletronic-keshi').textbox('setValue',row.dclass.dclassName);
											$('#eletronic-chuangjianren').textbox('setValue',row.emp.empLoginName);
											$('#eletronic-sex').textbox('setValue',row.medical.medicalCardSex);
											$('#eletronic-name').textbox('setValue',row.medical.medicalCardName);
											$('#eletronic-age').textbox('setValue',row.medical.medicalCardAge);
											$('#eregistration-window-select').window('close');
										} , '已处理' , 'wo');
									}">
								
							</td>
							<td><input name="" class="easyui-textbox  outregist-zhuyuanId" 
								data-options="label:'住院号',width:280,required:true,labelAlign:'right',valueField:'id',textField:'text',buttonText:'…',
								onClickButton : function(){
									selectZhuyuanJilu(function(row){
											$('.outregist-zhuyuanId').textbox('setValue', row.hospitalRegistrationId);
											$('#eletronic-keshi').textbox('setValue',row.hospitaNotify.outpaitentRegist.dclass.dclassName);
											$('#eletronic-name').textbox('setValue',row.hospitaNotify.outpaitentRegist.medicalCard.medicalCardName);
											$('#eletronic-sex').textbox('setValue',row.hospitaNotify.outpaitentRegist.medicalCard.medicalCardSex);
											$('#eletronic-age').textbox('setValue',row.hospitaNotify.outpaitentRegist.medicalCard.medicalCardAge);
											
									});
								}">
							</td>
							<td>
								<input name="" class="easyui-textbox" id="eletronic-sex" readonly="readonly"
								data-options="label:'性别*',width:240,labelAlign:'right',required:true">
							</td>
							<td><input name="dclassId" class="easyui-textbox" id="eletronic-keshi" readonly="readonly"
								data-options="label:'科室',width:240,required:true,labelAlign:'right'"> 
							</td>
						</tr>
						<tr height="30">
							<td><input  name="" class="easyui-textbox" id="eletronic-name" readonly="readonly"
								data-options="label:'病人姓名*',width:240,labelAlign:'right',labelWidth:100,required:true"></td>
							<td><input name="" class="easyui-textbox" id="eletronic-age" readonly="readonly"
								data-options="label:'年龄*',width:240,labelAlign:'right',required:true"></td>
							<td><select name="prescriptionType" class="easyui-combobox"
								data-options="label:'处方类型',width:240,labelAlign:'right',editable : false" readonly="readonly" >
									<option selected="selected">门诊处方</option>
									<option>住院处方</option>
								</select></td>
							<td><select name="empId" class="easyui-combobox" id="eletronic-doctors" readonly="readonly"
								data-options="label:'经办人',width:240,labelAlign:'right',editable:false">
								<option value="${empMessage.empId}">${empMessage.empLoginName}</option>
								</select>
							</td>
						</tr>
					</table>
					</form>
					<div id="eletronic-presscribing-add-tabs" class="easyui-tabs" data-options="border:false"
						style="margin-top: 5px;height:  380px;border:none;overflow: auto;" >
						<div title="处方开药" style="padding: 5px">
							<table width="100%" id="drug-table-one-appendTo">
								<tr height="35">
									<td colspan="4"><input name="" class="easyui-textbox" id="drug-id"
										data-options="label:'药品*',width:190,labelAlign:'right'">
										<input name="" class="easyui-textbox"  id="drug-name" 
											data-options="width:210,buttonText:'…',
											onClickButton : function(){
												$('#drug-inancialistory-win-window').window({'refresh' : 'href_address?myValue=doctor/drug_chufang'});
												$('#drug-inancialistory-win-window').window('open');
											}">
									
										<input name="" class="easyui-textbox"  id="drug-shuoming"
										data-options="label:'说明',width:365,labelAlign:'right'">
									<a id="drug-jiaru-btn" href="#" class="easyui-linkbutton"
										data-options="iconCls:'icon-add',plain:true" style="width: 80px;margin-left: 140px">加入</a></td>
								</tr>

								<tr height="35">
									<td colspan="8">
										<input name="" class="easyui-textbox"  id="drug-num" value="1"
										data-options="label:'数量*',width:190,labelAlign:'right'">
										<input name="" class="easyui-textbox"  id="drug-price" readonly="readonly"
											data-options="label:'单价',width:190,labelAlign:'right'">
										<input name="" class="easyui-textbox"  id="drug-money"  readonly="readonly"
											data-options="label:'金额',width:190,labelAlign:'right'">
										<a id="drug-delete" href="#" class="easyui-linkbutton"
										data-options="iconCls:'icon-remove',plain:true" style="width: 80px;margin-left: 335px">删除</a>
										</td>
								</tr>
							</table>
						
							<table  class="easyui-datagrid" width="99%" id="drug-list-table"
								data-options="fit : true,fitColumns : true,method:'get',rownumbers:true" >
								<thead>
									<tr>
										<th data-options="field:'prescriptionRecodeDrugType',width:100">类型</th>
										<th data-options="field:'prescriptionRecodeId',width:100">收费项目编号</th>
										<th data-options="field:'drugBname',width:200">收费项目名称</th>
										<th data-options="field:'prescriptionRecodeNum',width:100">数量</th>
										<th data-options="field:'prescriptionRecodePrice',width:100">单价</th>
										<th data-options="field:'prescriptionRecodeMoney',width:100">金额</th>
										<th data-options="field:'prescriptionRecodeZt',width:150">状态</th>
										<th data-options="field:'prescriptionRecodeExplain',width:150">用法用量</th>
									</tr>
								</thead>
								
							</table>
						</div>

						<div title="医疗项目" data-options="closable:false"
							style="padding: 5px; display: none;">
							<table width="100%">
								<tr height="35">
									<td colspan="4"><input name="" class="easyui-textbox" id="hospital-project" readonly="readonly"
										data-options="label:'项目*',width:190,labelAlign:'right'">
										<input name="" class="easyui-textbox"  id="hospital-projectName"
											data-options="width:210,buttonText:'…',
												onClickButton : function(){
												comm(function(row){
														loadFinancial(row);
													});
											}"> </td>
								</tr>

								<tr height="35">
									<td colspan="1">
										<input name="" class="easyui-textbox" id="hospital-num" value="1" 
										data-options="label:'数量*',width:190,labelAlign:'right'">
										<input name="" class="easyui-textbox" id="hospital-price" readonly="readonly"
										data-options="label:'单价',width:190,labelAlign:'right'">
										<input name="" class="easyui-textbox" id="hospital-money" readonly="readonly"
										data-options="label:'金额',width:190,labelAlign:'right'"> 
										
										<a id="hospital-financial-jiaru" href="#" class="easyui-linkbutton"
										data-options="iconCls:'icon-add',plain:true" style="width: 80px;margin-left: 40px">加入</a> 
										
										<a id="hospital-financial-shanchu" href="#" class="easyui-linkbutton"
										data-options="iconCls:'icon-remove',plain:true" style="width: 80px">删除</a>
									</td>
								</tr>
							</table>
							<table class="easyui-datagrid" id="hospital-table"
								data-options="fit : true,fitColumns : true,
											rownumbers:true,
											method:'get'
										">
								<thead>
									<tr>
										<th data-options="field:'financialTypeName',width:150,align:'left'">类型</th>
										<th data-options="field:'financialId',width:100,align:'left'">收费项目编号</th>
										<th data-options="field:'financialName',width:200,align:'left'">收费项目名称</th>
										<th data-options="field:'financialPrice',width:100,align:'left'">单价</th>
										<th data-options="field:'financialNum',width:100,align:'left'">数量</th>
										<th data-options="field:'financialMoney',width:150,align:'left'">金额</th>
										<th data-options="field:'financialzt',width:200,align:'left'">状态</th>
									</tr>
								</thead>
							</table>
						</div>
					</div>
					 <div style="border:1px solid rgb(149,184,231);margin-left:5px;width: 1192px"> 
						<table>
							<tr height="30">
								<td><input id="sum_moeny" name="" class="easyui-textbox" readonly="readonly" data-options="label:'处方金额',width:230,labelAlign:'right',value:'0.00'">  元</td>
							</tr>
						</table>
					</div>
			</div>
		</div>
	</div>

	<div id="drug-inancialistory-win-window" class="easyui-window inancialistory-win-window"
		title="选择药品开药" style="width: 820px; height: 500px"
		data-options="modal:true,minimizable:false,maximizable:false,collapsible:false, resizable:false, closed: true,
			href:'href_address?myValue=doctor/drug_chufang'
		">
	</div>
	
	<div id="update-drug-window" class="easyui-window"
		title="编辑记录" style="width:360px; height:330px;" 
		data-options="modal:true,minimizable:false,maximizable:false,collapsible:false, resizable:false,closed:true">
		<form action="" id="drugform" >
			<table align="center" style="padding: 15px">
				 <tr height="25">
					<td><input name="prescriptionRecodeDrugType" class="easyui-textbox" readonly="readonly"  id=""
						data-options="label:'类型',width:240,labelAlign:'left',labelWidth:100
					"/>
					</td>
				</tr>
				
				<tr height="25">
					<td><input name="prescriptionRecodeId" class="easyui-textbox" id="update-eletronicId"  readonly="readonly"
						data-options="label:'收费项目编号',width:240,labelAlign:'left',labelWidth:100
						"/>
					</td>
				</tr>
				
				 <tr  height="25">
					<td><input name="drugBname" class="easyui-textbox" id="" readonly="readonly"
						data-options="label:'收费项目名称*',width:240,labelAlign:'left',labelWidth:100
						">
					</td>
				</tr>
				
				<tr height="25">
					<td>
						<input id="update-eletronicnum" class="easyui-textbox" name="prescriptionRecodeNum" 
						data-options="label:'数量',width:240,required : true,labelAlign:'left',labelWidth:100">  
					</td>
				</tr>
				<tr  height="25">
					<td><input name="prescriptionRecodePrice" class="easyui-textbox" id="" readonly="readonly"
						data-options="label:'单价',width:240,labelAlign:'left',labelWidth:100">
					</td>
				</tr>
				<tr height="25">
					<td><input name="prescriptionRecodeMoney" class="easyui-textbox" id="" readonly="readonly"
						data-options="label:'金额',width:240,labelAlign:'left',labelWidth:100">
					</td>
				</tr>
				<tr  height="25">
					<td><input id="" class="easyui-textbox" name="prescriptionRecodeZt" readonly="readonly"
						data-options="label:'状态',width:240,labelAlign:'left',labelWidth:100" >   
					</td>
				</tr>
				<tr height="25">
					<td><input name="prescriptionRecodeExplain" class="easyui-textbox"
						data-options="label:'用法用量',width:240,labelAlign:'left',required : true,labelWidth:100">
					</td> 
				</tr>
				
				<tr>
					<td  align="right">
						<a id="drug-save-btn" href="#" class="easyui-linkbutton"
							data-options="iconCls:'icon-save',plain:true" style="width:60px">确定</a> 
					</td>
				</tr>
			</table>
		</form>
	</div>
	
	<div id="dayinforms-window" class="easyui-window" data-options="width: 700,
	          height: 600,
	          maximizable:false,
	          minimizable:false,
	          collapsible:false,
	          resizable:false,
	          title: '浏览表单',
	          closed: true,
	          href: 'href_address?myValue=outpatient/dayinforms',
	          modal: true">
	 </div>
</body>
</html>