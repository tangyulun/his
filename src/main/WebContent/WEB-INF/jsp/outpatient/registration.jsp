<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
<style type="text/css">
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>门诊挂号管理</title>
</head>
<body>
	<script type="text/javascript">
	
		//点击打开按钮打开选择挂号窗口
		$("#regist-open").linkbutton({onClick : function(){
					menzhengh(function(row){
						$("#regists-form").form("load" , row);
						$("#r_number").textbox('setValue', row.idField);
						$("#outpaitentRegistGuahaodate").datebox('setValue',row.outpaitentRegistGuahaodate+"");
						$("#reDclass").combobox('setValue',row.dclass.dclassId);
						$("#kahaoId").textbox('setValue',row.medical.medicalCardCardId);
						$("#kahaoName").textbox('setValue',row.medical.medicalCardName);
						$("#empId").combobox('setValue',row.emp.empLoginName);
						$("#guahaoTime").textbox('setValue',row.outpaitentRegistGuahaoTime.substring(11 , row.outpaitentRegistGuahaoTime.length));
						$("#registration-window-select").window('close'); 
						
						//通过卡号搜索历史门诊数据表格数据
						$('#outpatientRegist-tb').datagrid({url : 'query_history_registall'});
						$('#outpatientRegist-tb').datagrid('load',{medicalCardCardId : $('#kahaoId').textbox('getValue')});
						
						//收费记录的数据表格
						//$("#financial-code-tb").datagrid("reload" , 'query_FinancialHistory');
						//病人资料
						$("#kahaoSex").textbox('setValue',row.medical.medicalCardSex);
						$("#kahaoHunfou").textbox('setValue',row.medical.medicalCardHunyanzk);
						$("#kahaoAge").textbox('setValue',row.medical.medicalCardAge);
						$("#kahaoCard").textbox('setValue',row.medical.medicalCardIdencard);
						$("#kahaoBingZhuang").textbox('setValue',row.medical.medicalCardBingzhuang);
						
						//获取收费记录的表格
						$("#financial-code-tb").datagrid({url : 'query_financial_code_tbs'});
						$("#financial-code-tb").datagrid('load',{outpaitentRegistId : row.idField});
					} , "all");
		}});
		
		function loadTable(row){
			$("#select-bankacode").window('close');
			$("#kahaoId").textbox('setValue',row.medicalCardCardId);
			$("#kahaoName").textbox('setValue',row.medicalCardName);
			$("#kahaoSex").textbox('setValue',row.medicalCardSex);
			$("#kahaoHunfou").textbox('setValue',row.medicalCardHunyanzk);
			$("#kahaoAge").textbox('setValue',row.medicalCardAge);
			$("#kahaoCard").textbox('setValue',row.medicalCardIdencard);
			$("#kahaoBingZhuang").textbox('setValue',row.medicalCardBingzhuang);
			$("#outpatientRegist-tb").datagrid({url : 'query_history_registall'});
			$("#outpatientRegist-tb").datagrid('load',{medicalCardCardId : row.medicalCardCardId});
		}
		
		//验证收费记录的格式
		function regexGS(money , type){
			var shoufeiId = $("#shoufeiId").combobox('getValue');
			var shoufeiName = $("#shoufeiName").textbox('getValue');
			var shouguahaofei = $(money).textbox('getValue');
			if($("#outpatientZhuangtai").combobox("getValue")!='未处理'){
				$.messager.alert("提示","不能重复处理该业务！");
				return ;
			}
			else if(shoufeiId == '' || shoufeiName == '' || shouguahaofei == ''){
				$.messager.alert("提示","提交信息需填写完整！");
				return;
			}else if(isNaN(shouguahaofei)||isNaN(shoufeiId)){
				$.messager.alert("提示","格式错误！");
				return;
			} 
			$.getJSON("queryFinan" , function(data){
				for (var i = 0; i < data.length; i++) {
					if(shoufeiId ==data[i].financialId){
						$.getJSON('addfinancial_code',
								{financialHistoryId : $("#shoufeiId").combobox('getValue'),financialHistoryShoufeixm : $("#shoufeiName").textbox('getValue'),
									financialHistoryShoufeije : type == 1 ? shouguahaofei : '-' + shouguahaofei},
								function(data){
									$("#financial-code-tb").datagrid("reload" , 'query_FinancialHistory');
									$("#shoufeiId").combobox('setValue','');
									$("#shoufeiName").textbox('setValue','');
									$("#shouguahaofei").textbox('setValue','');
									$("#tuiguahaofei").textbox('setValue','');
								}
							);
						break;
					}else if(i == data.length-1){
						$.messager.alert("提示","收费项目编号不存在！请重新选择!");
						break;
					}
				}
			});
		}
		
		//新增挂号和挂号处理的方法
		function insertGuahaoAndChuLi(state){
			if($("#outpatientZhuangtai").combobox("getValue") !='未处理'){
				$.messager.alert("提示","不能重复处理该业务！");
				return;
			}
			//$.messager.alert("提示",state != '已处理' ? "挂号成功！" : "挂号处理成功!");
			$("#regists-form").form('submit',{
				url : 'add_registInfo',
				onSubmit : function(param){
					param.state = state;
					return $(this).form('validate');
				},
				success : function(data){
					var json = eval("("+data+")");
					if(json.error){
						$.messager.alert("提示",state != '已处理' ? "挂号成功！" : "挂号处理成功!");
						if(state == '已处理'){
							$.get("clear_history" , function(){
								$("#financial-code-tb").datagrid('reload');
							});//清空收费记录的list 
							
							$("#regists-form").form('reset');
						 	$("#shoufeiId").combobox('setValue','');
							$("#shoufeiName").textbox('setValue','');
							$("#shouguahaofei").textbox('setValue','');
							$("#tuiguahaofei").textbox('setValue','');
							$("#kahaoAge").textbox('setValue','');
							$("#kahaoCard").textbox('setValue','');
							$("#kahaoBingZhuang").textbox('setValue',''); 
							//门诊号
							$.get("r_number" , function(data){
								$('#r_number').textbox('setValue',data.substring(1,data.length - 1));
							});
							
							$.get('current_Time',function(data){
								$("#guahaoTime").textbox('setValue',data.substring(1,data.length - 1));
							});
							
							//清空历史门诊的数据
							historyRegist();
						}
					}else{
						$.messager.alert("提示",json.eMessage);
					}
				}
			});
		}
		
		//删除历史门诊的数据表格方法
		function historyRegist(){
			var registAll = $("#outpatientRegist-tb").datagrid('getRows');
			for (var i = registAll.length-1; i >= 0; i--) {
				$("#outpatientRegist-tb").datagrid('deleteRow',i);
			}	
		}
		
		//新增挂号记录
		$("#regist-gd").linkbutton({onClick : function(){
			insertGuahaoAndChuLi("未处理");
		}});
		
		//点击挂号处理的时候 状态变成已处理
		$("#regist-ghcl").linkbutton({onClick : function(){
			if($("#financial-code-tb").datagrid("getRows")==0){
				$.messager.alert("提示","请至少选择一项收费项目！");
				return ;
			}
			insertGuahaoAndChuLi("已处理");
		}});
		
		var url = null;//作为增加和修改收费项目的路径
		$(function(){
			$.get("clear_history" , function(){
				$("#financial-code-tb").datagrid('reload');
			});
			//打开办卡页面
			$("#regist-add").linkbutton({onClick : function(){
				$("#insert-bankarecode").window('open');
				//获取卡号
				$.get("medical_card" , function(data){
					$("#medical-card-select").textbox('setValue',data.substring(1,data.length - 1));
				});
			}});
			
			//门诊号
			$.get("r_number" , function(data){
				$('#r_number').textbox('setValue',data.substring(1,data.length - 1));
			});
			
			//增加办卡记录
			 $("#regist-forms-save").linkbutton({onClick : function(){
				$("#medical-ff").form({
					onSubmit: function(param){
	                    return $(this).form('validate');
	                }, 
	                success: function(data){
	                	var json = eval("("+data+")");
	                	if(json.error){
	                		/* $("#reName").textbox('setValue' , '');
	                		$("#reAge").textbox('setValue' , '');
	                		$("#reCard").textbox('setValue' , ''); */
	                		$("#insert-bankarecode").window("close");
	                		$("#medical-ff").form('reset');
	                	}else{
	                		$.messager.alert("提示",json.eMessage);
	                	} 
					}
				}).submit();
			}});
			
			//验证身份证号码
			$.extend($.fn.textbox.defaults.rules,{
				maxlength : {
					validator : function(value,param){
						var reg =/^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$|^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/;
						return reg.test(value);
					},
					message : "请输入正确的身份证号码"
				},
				//验证年龄
				mustnumber : {
					validator : function(value,param){
						return /^[0-9]*$/.test(value); 
					},
					message : "请输入数字"
				},
				//验证中文
				chinese : {
					validator : function(value,param){
						 var reg = /^[\u4e00-\u9fa5]+$/i;  
				         return reg.test(value);  
					},
					message : "请输入中文"
				}
			});
			
			//点击加入收费添加收费记录
			$("#financial-shoufei").linkbutton({onClick : function(){
				regexGS('#shouguahaofei' , 1);
			}});
			
			//点击加入 退费  添加收费记录
			$("#financial-tuifei").linkbutton({onClick : function(){
				regexGS('#tuiguahaofei' , 0);
			}});
			
			$("#financial-delete").linkbutton({onClick : function(){
				var rows = $("#financial-code-tb").datagrid('getSelections');
				if($("#outpatientZhuangtai").combobox("getValue")!='未处理'){
					$.messager.alert("提示","不能重复处理该业务！");
					return;
				}
				else if(rows.length==0){
					$.messager.alert("提示","请至少选择一行删除！")
				}else{
					var str = "";
					for (var i = 0; i < rows.length; i++) {
						str +=rows[i].id + ",";
					}
					
					$.getJSON("deletes_code" , {ids : str} , function(data){
						$("#financial-code-tb").datagrid("reload" , 'query_FinancialHistory');
					})
				}	
			}});
			
			//获取系统当前时间
			$.get('current_Time',function(data){
				$("#guahaoTime").textbox('setValue',data.substring(1,data.length - 1));
			});
			
			//选项卡历史门诊高级查询
			$("#regist-gaojisousuo").linkbutton({onClick : function(){
				var registSearcher = $("#regist-searcher").searchbox('getValue');
				var registType = $("#registType").combobox('getValue');
				var registStartTime = $("#regist-startTime").datebox('getValue');
				var registEndTime = $("#regist-endTime").datebox('getValue');
				
				$("#outpatientRegist-tb").datagrid({url : 'query_regist_time'});
				$("#outpatientRegist-tb").datagrid('reload' , { registSearcher : registSearcher,
					registType : registType,registStartTime :registStartTime,registEndTime: registEndTime});
				$("#outpatientRegist-tb").datagrid('reload');
			}}); 
		
			$("#shoufeiId").combobox({onChange : function(){
				$.getJSON('query_financialName_whereId',{financialId : $("#shoufeiId").combobox('getValue')},function(data){
					$("#shoufeiName").textbox('setValue',data.financialName);
					$("#shouguahaofei").textbox('setValue',data.financialMoney);
				});
			}});
			
			//点击新建初始化页面数据
			$("#regist-init").linkbutton({onClick : function(){
				$("#regists-form").form('reset');
				
				//门诊号
				$.get("r_number" , function(data){
					$('#r_number').textbox('setValue',data.substring(1,data.length - 1));
				});
				
				//获取系统当前时间
				$.get('current_Time',function(data){
					$("#guahaoTime").textbox('setValue',data.substring(1,data.length - 1));
				});
				
				//清空收费记录的文本框的值
				$("#shoufeiCode-form").form('reset');
				$("#hospital-form").form('reset');
				
				//删除收费记录的数据表格
				$.get("clear_history" , function(){
					$("#financial-code-tb").datagrid('reload','query_FinancialHistory');
				});
				
				//删除历史门诊的数据表格
				historyRegist();
				$.messager.alert('提示','数据初始化完毕!');
			}});
			
			//点击收费项目数据表格的某一行，打开另外面板
			$("#shoufeixiangmu-tb").datagrid({onDblClickRow : function(index , row){
				$("#regist-patient-add-tabs").tabs('select','收费记录');
				 $("#shoufeiId").combobox('setValue' , row.financialId);
				$("#shoufeiName").textbox('setValue',row.financialName);
				$("#shouguahaofei").textbox('setValue',row.financialMoney);
			}});
		}); 
		
	</script>
	<div id="cc" class="easyui-layout" data-options="fit:true,border:false">
		<div data-options="region:'north'"
			style="height: 45px; padding: 6px;border-top: none;border-left: none;border-right: none">
			<a id="regist-init" href="#" class="easyui-linkbutton"
				data-options="iconCls:'icon-add',plain:true" style="width: 80px">新建</a>
			 <a id="regist-add" href="#" class="easyui-linkbutton"
				data-options="iconCls:'icon-banka',plain:true" style="width: 80px">办卡</a> 
			<a id="regist-gd" href="#" class="easyui-linkbutton"
				data-options="iconCls:'icon-guahao',plain:true" style="width: 80px">挂号</a>
			<a id="regist-ghcl" href="#" class="easyui-linkbutton"
				data-options="iconCls:'icon-ok',plain:true" style="width: 100px;">挂号处理</a> 
			<a id="regist-open" href="#" class="easyui-linkbutton"
				data-options="iconCls:'icon-reload',plain:true" style="width: 80px;">打开</a> 
			<!-- <a id="regist-dy" href="#" class="easyui-linkbutton"
				data-options="iconCls:'icon-print',plain:true" style="width: 80px">打印</a> -->

		</div>
			
		<div data-options="region:'center', border:false,fit:true" >
			<form action="" id="regists-form" method="post">
				<table width="100%">
					<tr height="30px">
						<td><input name="outpaitentRegistId" id="r_number" class="easyui-textbox" readonly="readonly"
							data-options="label:'门诊号*',width:260,labelAlign:'right'">
						</td>
						<td><select id="outpatientZhuangtai" name="outpaitentRegistZhuangtai" class="easyui-combobox"  readonly="readonly"
							data-options="label:'状态',width:220,labelAlign:'right'">
							<option>未处理</option>
							<option>已处理</option>
							</select>
						</td>
						<td><input name="outpaitentRegistGuahaodate" class="easyui-datebox" readonly="readonly" id="reDate"
							data-options="label:'挂号日期*',width:260,labelAlign:'right'" value="new Date()">
						</td>
					</tr>
					<tr height="30px">
						<td>
							<select name="dclassId" class="easyui-combobox" id="reDclass" 
								data-options="label:'科室',width:220,labelAlign:'right',
													url:'where_select_dclass?deptId=2',
													method:'get',
													valueField:'dclassId',
													textField:'dclassName',
													required : true"> 
									</select>
						</td>
						<td><select name="outpaitentRegistType" class="easyui-combobox" id="reType"
							data-options="label:'挂号类型',width:260,labelAlign:'right'">
								<option>普通</option>
								<option>急诊</option>
							</select>
						</td>
						<td><input name="outpaitentRegistGuahaotime" id="guahaoTime" class="easyui-textbox" readonly="readonly"
							data-options="label:'挂号时间',width:260,labelAlign:'right',editable:false,editable:false">
						</td>
					</tr>
					<tr height="30px">
						<td><input name="medicalCardCardId" class="easyui-textbox" id="kahaoId" readonly="readonly"
								data-options="label:'卡号',width:220,labelAlign:'right',editable:false,required:true">
							<input
								name="medicalCardName" class="easyui-textbox" id="kahaoName"
								 data-options="width:110,editable:false,required:true,buttonText:'…',
									onClickButton : function(){
										$('#select-bankacode').window('open');
										$('#banka-tb').datagrid('reload');
									}
								"> 
						</td>
						<td><select name="empId" class="easyui-combobox" id="reEmp"
							data-options="label:'经办人',width:220,labelAlign:'right',editable:false">
							<option value="${empMessage.empId}">${empMessage.empLoginName}</option>
							</select>
						</td>
					</tr>
				</table>
			</form>
			
			<div  id="regist-patient-add-tabs" class="easyui-tabs" style="height: 415px;margin-top: 10px;" data-options="border:false">
				<div title="收费项目" style="">
					<table class="easyui-datagrid" id="shoufeixiangmu-tb"
						data-options="
							url:'query_financialxm',
							method:'get',
							fit : true,
							singleSelect:true,
							fitColumns:true,
							border:false,
							rownumbers:true,
							pagination:true,
							pageSize:10,
							pageList:[10,20,30]">
						<thead>
							<tr>
								<th data-options="field:'financialId',width:300">收费项目编号</th>
								<th data-options="field:'financialName',width:700">收费项目名称</th>
							</tr>
						</thead>
					</table>
				</div>

				<div title="收费记录" data-options="" style="padding: 5px">
						<form id="shoufeiCode-form">
							<table width="99%">
								<tr >
									<td colspan="1">
										<input id="shoufeiId" name="financialId" class="easyui-combobox"
											data-options="method: 'get' , label:'收费项目*',width:230,labelAlign:'right',url:'queryFinan',valueField:'financialId' , textField : 'financialId'">
										<input id="shoufeiName" name="financialHistoryShoufeixm"
										    class="easyui-textbox" data-options="width:250,buttonText:'…',
												onClickButton : function(){
													comm(function(row){
														if(row == null){
															$.messager.alert('提示','您选择的这行为空！');
															return;
														}
														$('#inancialistory-win-window').window('close');
														$('#shoufeiId').textbox('setValue' , row.financialId);
														$('#shoufeiName').textbox('setValue' , row.financialName);
														$('#shouguahaofei').textbox('setValue' , row.financialMoney);
													});
											}">
										<a id="financial-shoufei"  class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" style="width: 80px;margin-left: 180px">加入收费</a> 
									</td>
								</tr> 
								<tr> 
									<td colspan="1">
										<input  name="financialHistoryShoufeije" class="easyui-textbox" id="shouguahaofei"
											data-options="label:'收挂号费',width:230,labelAlign:'right'">
										<input name="financialHistoryShoufeije" class="easyui-textbox" id="tuiguahaofei"
											data-options="label:'退挂号费',width:230,labelAlign:'right'">
										
										<a id="financial-tuifei"  class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" style="width: 80px;margin-left: 200px">加入退费</a>
										<a id="financial-delete"  class="easyui-linkbutton" data-options="iconCls:'icon-delete',plain:true" style="width: 60px;margin-left:240px">删除</a>
									</td>	
								</tr>
							</table>
						</form>
						<table class="easyui-datagrid" id="financial-code-tb" 
							data-options="fit : true,
								fitColumns : true,
								rownumbers:true,
								method:'get'
								">
							<thead>
								<tr>
									<th data-options="field:'financialHistoryId',width:200,align:'left',checkbox:true"></th>
									<th data-options="field:'financialHistoryShoufeilx',width:200,align:'left'">收费类型</th>
									<th data-options="field:'financialHistoryShoufeixm',width:200,align:'left'">收费项目</th>
									<th data-options="field:'financialHistoryShoufeije',width:100,align:'left'">金额</th>
									<th data-options="field:'financialHistoryShoufeizt',width:100,align:'left'">状态</th>
									<th data-options="field:'financialHistoryShoufeisj',width:200,align:'left'">收费日期</th>
								</tr>
							</thead>
						</table>
				</div>
				
				<div title="病人资料" data-options="" style="padding: 5px; ">
					<form action="" id="hospital-form">
						<table width="100%">
							<tr height="30px">
								<td><input name="medicalCardSex" class="easyui-textbox" id="kahaoSex"  
										data-options="label:'病人性别',width:200,labelAlign:'right',editable:false">
									<input name="" class="easyui-textbox" id="kahaoAge" readonly="readonly"
									data-options="label:'病人年龄',width:200,labelAlign:'right',editable:false">
								</td>
							</tr>
	
							<tr height="30px"> 
								<td><input name="" class="easyui-textbox" id="kahaoHunfou" 
									data-options="label:'婚姻状况',width:200,labelAlign:'right',editable:false">
									<input name="" class="easyui-textbox" id="kahaoCard" readonly="readonly"
									data-options="label:'身份证号',width:260,labelAlign:'right',editable:false">
								</td>
							</tr>
	
							<tr height="30px">
								<td style=""><input name="" class="easyui-textbox" id="kahaoBingZhuang" readonly="readonly"
									data-options="label:'病状  ',width:755,height:170,multiline:true,labelAlign:'right'"></td>
							</tr>
						</table>
					</form>
				</div>

				<div title="历史门诊" data-options="" style="padding: 5px;">
					<table width="100%">
						<tr>
							 <td>
								<input class="easyui-searchbox" id="regist-searcher" style="width:200px;" data-options="label:'门诊号',labelWidth:50,prompt:'门诊号',
								 		 searcher : function(value , name){
								 			if(value=='' || value == null){
								 				$('#outpatientRegist-tb').datagrid({url : 'query_history_registall'});
												$('#outpatientRegist-tb').datagrid('load',{medicalCardCardId : $('#kahaoId').textbox('getValue')});
								 			}else{
								 				$('#outpatientRegist-tb').datagrid({url : 'query_regist_like'});
								 				$('#outpatientRegist-tb').datagrid('load',{outpaitentRegistId : value , medicalCardId : $('#kahaoId').textbox('getValue')});
								 			}
								 		} 
								 	"/>
								 	
								 <select name="outpaitentRegistType" class="easyui-combobox" id="registType"
									data-options="label:'挂号类型',width:180,labelWidth:75,labelAlign:'right'">
										<option>普通</option>
										<option>急诊</option>
								 </select>
								 
								  <input name="" class="easyui-datebox" value="new Date()" id="regist-startTime"
									     data-options="label:'查询区间',width:220,labelAlign:'right'">
								至 <input name="" class="easyui-datebox" value="new Date()" id="regist-endTime" data-options="width:130">
								  <a id="regist-gaojisousuo"
									 href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true"
									 style="width: 60px;">搜索</a>
							</td> 
						</tr>
					</table>
					
					<table id="outpatientRegist-tb" class="easyui-datagrid" data-options="
							method:'get',
							fit : true,
							singleSelect:true,
							fitColumns:true,
							rownumbers:true
							
							">
						<thead>
							<tr>
								<th data-options="field:'treeField',width:200,align:'left'">门诊号</th>
								<th data-options="field:'outpaitentRegistType',width:200,align:'left'">挂号类型</th>
								<th data-options="field:'outpaitentRegistGuahaoTime',width:200,align:'left'">挂号日期</th>
								<th data-options="field:'code',width:200,align:'left' , formatter(value , row , index){
									if(row.dclass != null){
										return row.dclass.dclassName;
									}
									return value;
								}
								">科室</th>
								<th data-options="field:'code1',width:200,align:'left' , formatter(value , row , index){
									if(row.emp != null){
										return row.emp.empLoginName;
									}
									return value;
								}
								">创建人</th>
							</tr>
						</thead>
					</table>
				</div>
			</div>
		</div>
	</div>
	
	<!-- 打开挂号记录 -->
	<div id="registration-window-select" class="easyui-window" data-options="
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
	
	<!-- 新增办卡记录 -->
	<div id="insert-bankarecode" class="easyui-window" data-options="width:600,
		height:350,title:'新增办卡',maximizable:false,
			 iconCls:'icon-zhenliaoka',
	          minimizable:false,
	          collapsible:false,
	          resizable:false,
	          closed: true,
	          draggable:false,
	          modal: true">
		<form action="addMedical" method="post" id="medical-ff" style="margin: 10px">
			<table align="center">
					<tr height="35" align="center">
						<td colspan="4">
							<label style="font-size: 18px;font-weight: bold;">诊疗卡</label>
						</td>
					</tr>
					<tr height="35">
						<td>
							<input class="easyui-textbox"  name="medicalCardCardId" id="medical-card-select" readonly="readonly"  data-options="
								width:240,
								label:'卡号',
								labelWidth:60,
								required:true
								
							">
						</td>
						<td width="50"></td>
						<td>
							<input class="easyui-textbox" name="medicalCardName" id="reName" data-options="
								width:240,
								label:'姓名',
								prompt:'请输入姓名',
								align : 'right',
								value:'谭丽',
								labelWidth:60,
								required:true,
								validType:'chinese',
								icons:[
								{
									iconCls:'icon-clear',
									handler:function(e){$(e.data.target).textbox('clear');
									}
								}
							]
							">
						</td>
					</tr>
					<tr height="35">
						<td>
							<input class="easyui-textbox" name="medicalCardAge" id="reAge" data-options="
								width:240,
								label:'年龄',
								prompt:'请输入年龄',
								labelWidth:60,
								value:'18',
								required:true,
								validType:'mustnumber',
								icons:[
								{
									iconCls:'icon-clear',
									handler:function(e){$(e.data.target).textbox('clear');
									}
								}
							]
							"/>
						</td>
						<td width="50"></td>
						<td>
							<select id="" class="easyui-combobox" name="medicalCardSex" data-options="width:240,
								label:'性别',required:true,labelWidth:60" >   
							    <option>男</option>   
							    <option>女</option>   
							</select> 
						</td>
					</tr>
					<tr height="35">
						<td>
							<select id="" class="easyui-combobox" name="medicalCardHunyanzk" data-options="width:240,
								label:'婚否',required:true,labelWidth:60" >   
							    <option>已婚</option>   
							    <option>未婚</option>   
							</select> 
						</td>
						<td width="50"></td>
						<td>
							<select id="" class="easyui-combobox" name="empId" data-options="width:240,
								label:'操作人',required:true,labelWidth:60" >   
							    <option value="${empMessage.empId}">${empMessage.empLoginName}</option>   
							</select> 
						</td>
					</tr>
					<tr height="35">
						<td>
							<input class="easyui-textbox" name="medicalCardIdencard" id="reCard"  data-options="
								width:240,
								label:'身份证号',
								labelWidth:60,
								prompt:'请输入身份证号',
								required:true,
								value:'430224199611250643',
								validType:'maxlength',
								icons:[
								{
									iconCls:'icon-clear',
									handler:function(e){$(e.data.target).textbox('clear');
									}
								}
							]
							">
						</td>
						<td width="50"></td>
						<td>
							<input class="easyui-datebox" value="new Date()" name="medicalCardDate"  data-options="
								width:240,
								label:'办卡日期',
								labelWidth:60,
								required:true
							">
						</td>
					</tr>
					<tr>
						<td colspan="3" height="50px">
							<input class="easyui-textbox" name="medicalCardBingzhuang"  data-options="
								width:540,
								label:'病状',
								labelWidth:60,
								required:true,
								value:'无',
								multiline:true,
								icons:[
								{
									iconCls:'icon-clear',
									handler:function(e){$(e.data.target).textbox('clear');
									}
								}
							]
							">
						</td>
					</tr>
					<tr align="right" height="40">	
						<td colspan="3">
							<a id="regist-forms-save" class="easyui-linkbutton" data-options="text:'确定',iconCls:'icon-save',plain:true" style="width: 70px"></a>
							<a id="cancel" class="easyui-linkbutton" data-options="text:'取消',iconCls:'icon-cancle',plain:true" onclick="$('#insert-bankarecode').window('close')" style="width: 70px"></a>
						</td>
					</tr>
				</table>
			</form>
	</div>
	<!-- 查询办卡记录 -->
	<div id="select-bankacode" class="easyui-window" data-options="
			 width:800,
	          height: 400,
	          title: '办卡记录',
	          maximizable:false,
	          minimizable:false,
	          collapsible:false,
	          resizable:false,
	          closed: true,
	          modal: true,
	          draggable:false,
	          href:'href_address?myValue=outpatient/regist_medicalcode'
		">
	</div>
	
</body>
</html>

