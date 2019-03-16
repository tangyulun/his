<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>手术</title>
</head>
<body>
		<div id="win" class="easyui-layout" title="手术管理" style="width:800px;height:500px"   
        data-options="iconCls:'icon-save',modal:true,fit:true">  
        
   <div id="regist-top-id" data-options="region:'north'" style="height:45px;padding: 8px">
	        	<a id="regist-init" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" style="width:80px;onclick="doReset()"">新建</a>  
				<a id="regist-gdcl" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok',plain:true" style="width:100px;">处理</a>
				<a id="dayin" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-print',plain:true" style="width:80px;">打印</a>
	         </div>   
	       <!-- 表单 -->
   <div data-options="region:'center'" style="height:450px;">   
	           <form id="insert-ssgd" method="post">
 				<table width="100%" style="padding: 10px;border-spacing:10px;border:1px solid #66cccc;">
 					<tr>
 					
 						<!-- 只读不能修改模式的手术号 -->
 						<td><input name="shoushuMess" id="shoushu_bh" class="easyui-textbox" readonly="readonly" data-options="label:'手术号*',width:240,labelAlign:'right'"></td>
 						
 						<td>
	           						 <select id="" class="easyui-combobox" name="shoushuMessState" data-options="label:'状态',width:240,labelAlign:'right'" readonly="readonly">   
    									<option value="未处理">未处理</option>   
    									<option value="已处理">已处理</option>   
    
									</select>
	           				</td>
 						<td>
 						<input class="easyui-datebox" id="shoushuMessDate" value="new Date()" name="shoushuMessDate" data-options="label:'手术日期',width:240,labelAlign:'right',editable:false">
 						</td>
 						<td>
	           			<select class="easyui-combobox" id="shou" name="shoushuMessType" data-options="label:'手术类型',width:240,labelAlign:'right',editable:false">
	           				<option>骨科手术</option>
	           				<option>外科手术</option>
	           				<option>泌尿系手术</option>
	           				<option>胸科手术</option>
	           				<option>心血管手术</option>
	           				<option>脑神经手术</option>
	           				<option>妇产科手术</option>
	           				<option>眼科手术</option>
	           				<option>耳鼻喉科手术</option>
	           			</select>
	           			</td>
 					</tr>
 					<tr>
 						<td colspan="2">
 							<input class="easyui-textbox" id="shoushuId" name="shoushuId" data-options="required:true,label:'手术室*',width:200,labelAlign:'right'">
 							<input name="shoushuName" id="shoushuName" class="easyui-textbox" data-options="required:true,width:240,buttonText:'…',
 							onClickButton : function(){
							 	 $('#wina').window({'refresh' : 'href_address?myValue=operation/operation_window'});
								 $('#wina').window('open');
							}">
				      
 						</td>
 						<td >
 						<input class="easyui-textbox" id="hospitalRegistrationId" name="hospitalRegistrationId" data-options="label:'住院号',width:240,labelAlign:'right',
 						buttonText : '…',
 						onClickButton : function(){
 						selectZhuyuanJilu(function(row){
 							shuju(row);
 							});
 						}">
 						</td>
 					</tr>
 					<tr> 
 						<td><input class="easyui-textbox" id="Name-patient" name="medicalCardName" data-options="label:'病人姓名',width:240,labelAlign:'right',required:true"></td>
 						<td>
	           			<input class="easyui-combobox" id="dclassIds" name="dclassName" data-options="label:'科室',
	           			width:240,
	           			labelAlign:'right',
	           			valueField:'dclassId',    
    					textField:'dclassName'   ,
	           			method : 'get',
	           			url : 'where_select_dclass?deptId=2',
	           			required:true,
	           			editable:false">
	           			</td>
 						<td><select class="easyui-combobox" id="The-surgeon" name="empId" data-options="label:'主刀医生',width:240,labelAlign:'right',required:true,editable:false">
 							  <option value="${empMessage.empId}">${empMessage.empLoginName}</option>   
 						</select></td>
 						<td><input id="jinea" class="easyui-textbox" name="shoushuMessMoney" data-options="label:'金额',value:'0.00',width:240,labelAlign:'right'"></td>
 					</tr>
	           		</table>
	           </form>
	           	 <div data-options="region:'none'" style="height:200px;">
									<!-- 表格 -->
		<table id="table-shoushu" class="easyui-datagrid" style="width:100%;height:180%"   
       		data-options="rownumbers:true,singleSelect:true,
       		fitColumns: true,
       		method : 'get'">   
   			<thead>   
	      		 	<tr>
	      		 		<th data-options="field:'ssid',width:10,align:'center'">手术编号</th>
	      		 		<th data-options="field:'ssName',width:10,align:'center'">手术名称</th>
	           		 	<th data-options="field:'ssleixing',width:10,align:'center'">手术类型</th>   
	           		 	<th data-options="field:'shuliang',width:6,align:'center'">数量</th>
	           		 	<th data-options="field:'danjia',width:6,align:'center'">单价</th>
	           		 	<th data-options="field:'jine',width:6,align:'center'">金额</th>
	           		 	<th data-options="field:'jieguo',width:15,align:'center',
	           		 	editor:'text',
	           		 	styler: function(value,row,index){
							return 'color:red;font-weight:bold';
						}">结果</th>
	     	  		</tr>   
  		  	</thead>   
		</table>
				</div>
	</div>
 </div>
 	<!-- 选择手术室弹出框 -->
 	<div id="wina" class="easyui-window" title="选择手术室" style="width:800px;height:500px" data-options="
   model : true , 
    closed:true,
    minimizable:false,
    maximizable:false,
    collapsible:false,
    resizable:false,
     modal:true,
     href :'href_address?myValue=/operation/surgery_window' , method : 'get'
     "></div>
	<!-- 点击住院号后面的链接按钮弹出住院查询框 -->
 	<div id="win-zhuyuan" class="easyui-window" title="选择住院" style="width:800px;height:500px" data-options="
   model : true , 
    closed:true,
    minimizable:false,
    maximizable:false,
    collapsible:false,
    resizable:false,
     modal:true,
     href :'href_address?myValue=/behospitalized/zhuyuandengji_window' , method : 'get'
     "></div> 		
		<!-- 打印 -->
		<div id="dayin-window" class="easyui-window" title="打印" style="width:800px;height:450px;" 
		data-options="modal:true,collapsible:false,minimizable:false,maximizable:false,closed:true">
			<div style="float: right;">
					<a id="dayinanniu" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok',plain:true",style="width:80px;">打印</a>
			</div>
			<div style="font-size: 14px;font-weight: bold;padding: 5px">深圳XXX医院</div><hr style="border: 0px ;border: 1px dashed #D9E0EB"/>
			<div class="easyui-layout dayin_shoushu" data-options="fit:true">
				<div data-options="region : 'center' , split : true" style="height:50px">
					<div>
						<table border="1" cellpadding="0" cellspacing="0" style="border-collapse: collapse;" width="100%">
							<thead>
								<tr style="text-align: center">
									<td style="font-size: 20px;font-weight: bold;text-align: center;color: #398000;" rowspan="1" colspan="2">手术治疗单</td>
									<td style="height:23px;width:90px">
									住院号：
									</td>
									<td style="height:23px;width:150px" id="zhuyuanhao">
									
									</td>
									<td style="height:23px;width:90px">
									病人姓名：
									</td>
									<td style="height:23px;width:150px" id="bingrenxingming">
									
									</td>
									<td style="height:23px;width:90px">
									科室：
									</td>
									<td style="height:23px;width:150px" id="keshi">
									
									</td>
								</tr>
								<tr style="text-align: center">
									<td style="height:23px;width:90px">
									手术室编号：
									</td>
									<td style="height:23px;width:150px" id="shoushushibianhao">
									
									</td>
									<td style="height:23px;width:90px">
									主刀医生：
									</td>
									<td style="height:23px;width:150px" id="zhudaoyisheng">
									
									</td>
									<td style="height:23px;width:90px">
									总金额：
									</td>
									<td style="height:23px;width:150px" id="zongjine">
									
									</td>
									<td style="height:23px;width:90px">
									手术室名称：
									</td>
									<td style="height:23px;width:150px" id="shoushushimingcheng">
									
									</td>
									
								</tr>
								<tr style="text-align: center">
								<td style="height:23px;width:90px">
									手术类型：
									</td>
									<td style="height:23px;width:150px" id="shoushuleixing">
									
									</td>
								</tr>
							</thead>
						</table>
						<table border="1" id="dayin-table" cellpadding="0" cellspacing="0" style="border-collapse: collapse;" width="100%">
							<thead>
								<tr style="text-align: center">
									<th>序号</th>
									<th>手术编号</th>
									<th>手术类型</th>
									<th>数量</th>
									<th>单价</th>
									<th>金额</th>
									<th>结果</th>
								</tr>
							</thead>
						</table>
					</div>
				</div>
			</div>
		</div>
	<script type="text/javascript">
	
		function shuju(rows){
			$.getJSON('select_panduan_zhuyuan',{hospitalRegistrationId:rows.hospitalRegistrationId},function(data){
				/* $.messager.alert("",JSON.stringify(rows)); */
					if(!data.error){
						$.messager.alert("提示","您已经做过手术!不能再重复!");
						return;
					}
					$("#insert-ssgd").form('load',rows);
					$("#dclassIds").textbox('setValue' , rows.hospitaNotify.outpaitentRegist.dclass.dclassName);
					$("#Name-patient").textbox('setValue' , rows.hospitaNotify.outpaitentRegist.medicalCard.medicalCardName);
					$("#table-shoushu").datagrid("load","select_Shoushu_Zhuyuan?hospitalRegistrationId="+rows.hospitalRegistrationId);
					$("#table-shoushu").datagrid({onLoadSuccess : function(){
						var rows = $("#table-shoushu").datagrid('getRows');
					
						var money = 0.0;
						for (var i = 0; i < rows.length; i++) {
							money +=rows[i].jine;
						}
						$("#jinea").textbox("setValue",money);
						
					}});
			});
		}
	
			$(function(){
				
				//打印机
				$("#dayin").linkbutton({onClick : function(){
					$("#zhuyuanhao").html($("#hospitalRegistrationId").textbox("getValue"));
					$("#bingrenxingming").html($("#Name-patient").textbox("getValue"));
					$("#keshi").html($("#dclassIds").textbox("getValue"));
					$("#shoushushibianhao").html($("#shoushuId").textbox("getValue"));
					$("#zhudaoyisheng").html($("#The-surgeon").textbox("getValue"));
					$("#zongjine").html($("#jinea").textbox("getValue"));
					$("#shoushushimingcheng").html($("#shoushuName").textbox("getValue"));
					$("#shoushuleixing").html($("#shou").textbox("getValue"));
					totable();
					$("#dayin-window").window("open");	
				}});
				//打印成图片报表
				$(document).ready(function(){
					$('#dayinanniu').linkbutton({onClick :function(){
						$('.dayin_shoushu').printArea();
					}});
				});
				
				
				
				$("#t-t-a").linkbutton({onClick : function(){
					$("#wina").window("open");
				}});
				
				/* 点击住院号后面的链接，弹出住院功能框 */
				$("#Hospitalization-call").linkbutton({onClick : function(){
					$("#win-zhuyuan").window("open");
				}});
				
				/* 生成手术号 */
				$.get("shoushu_bh",function(data){
					$('#shoushu_bh').textbox('setValue',data.substring(1,data.length - 1));
				});
				
				 /* 添加手术挂单 */
				$("#regist-gdcl").linkbutton({onClick : function(){
					if($("#table-shoushu").datagrid('getRows') ==0){
						 $.messager.alert('提示' , '请至少选择一条数据处理!');
						 return ;
					}
					tijiaob("已处理");
					qingkong();
				}});
				 
				 /*打开手术室窗口页面选中数据，点击确定传出选中数据到页面上上*/
				 $("#wina").window({onLoad : function(){
						$("#bg-qd").linkbutton({onClick : function(){
							rows = $("#sugery-table-right").datagrid("getSelected");
							/* alert(JSON.stringify(rows));  */
							$("#insert-ssgd").form('load',rows);
							$("#wina").window("close");
					
						}});	
						$("#sugery-table-right").datagrid({onDblClickRow : function(index , rows){
							row=rows;
							rows = $("#sugery-table-right").datagrid("getSelected");
							/* alert(JSON.stringify(rows));  */
							$("#insert-ssgd").form('load',rows);
							$("#wina").window("close");
						}});
						
				}});
				
				 /*打开住院窗口页面选中数据，点击确定传出选中数据到页面上上*/
			/*	 $("#win-zhuyuan").window({onLoad : function(){
						$("#zhuyuandengji-queding").linkbutton({onClick : function(){
						
							rows = $("#zydj-table").datagrid("getSelected");
							  alert(JSON.stringify(rows.treeField));  
							$("#insert-ssgd").form('load',rows);
							 $.messager.alert("",JSON.stringify(rows));
							$("#dclassIds").textbox('setValue' , rows.hospitaNotify.outpaitentRegist.dclass.dclassName);
							
							$("#Name-patient").textbox('setValue' , rows.hospitaNotify.outpaitentRegist.medicalCard.medicalCardName);
							
							$("#table-shoushu").datagrid("load","select_Shoushu_Zhuyuan?hospitalRegistrationId="+rows.hospitalRegistrationId);
							$("#win-zhuyuan").window("close"); 
						}});
				}}); */
				 
				indexs= -1;
				//修改
				$("#table-shoushu").datagrid({onDblClickRow:function(index,row){
					//开始编辑状态
					indexs=index;
					$("#table-shoushu").datagrid('beginEdit',index);
				}}); 
				 
				//修改加编辑
				$("#table-shoushu").datagrid({onClickRow:function(index,row){ 
					if(indexs!= -1){
						$("#table-shoushu").datagrid('endEdit',indexs);
						$("#table-shoushu").datagrid('selectRow',indexs);
						var rows=$("#table-shoushu").datagrid('getSelected');
						$.get("update_select_shoushu",{id:rows.id,jieguo:rows.jieguo},function(){
							$("#table-shoushu").datagrid("reload",'select_shoushu_bianji');
							$("#table-shoushu").datagrid({onLoadSuccess: function(){
							var rows=$("#table-shoushu").datagrid("getRows");
		 					
		 				}});
		 			});
		 			indexs = -1;
		 		}		
				}});  
				
			});
			
			//状态加提交
			function tijiaob(state){
				$("#insert-ssgd").form("submit" , {
					url : 'insert_guadan',
					onSubmit : function(data){
						data.state = state;
						return $(this).form("validate");
					},
					success : function(data){
						var json = eval("("+data+")");
						if(json.error){ 
							$.messager.alert("提示","处理成功");
						$.get("shoushu_bh",function(data){
							$('#shoushu_bh').textbox('setValue',data.substring(1,data.length - 1));
						});
						$("#shoushuId").textbox('setValue',"");
						$("#shoushuName").textbox('setValue',"");
						$("#hospitalRegistrationId").textbox('setValue',"");
						$("#Name-patient").textbox('setValue',"");
						$("#The-surgeon").textbox('setValue',"");
						$("#shou").textbox('setValue',"");
						$("#dclassIds").textbox('setValue',"");
						}
					}
				});
			}
			
			//清空
		 	function qingkong(){
				var rows = $("#table-shoushu").datagrid('getRows');
				for(var i=rows.length -1; i>=0;i--){
					$("#table-shoushu").datagrid('deleteRow',i);
				}
			}
			
		 	//打印
		 	 function totable(){
		 		 var rows = $("#table-shoushu").datagrid("getRows");
		 		for(var i = 0; i< rows.length; i++){
					 var trr = $("<tr style='text-align : center;height : 20px'></tr>");
					 trr.append("<td>"+rows[i].ssid+"</td>");
					 trr.append("<td>"+rows[i].ssName+"</td>");
					 trr.append("<td>"+rows[i].ssleixing+"</td>");
					 trr.append("<td>"+rows[i].shuliang+"</td>");
					 trr.append("<td>"+rows[i].danjia+"</td>");
					 trr.append("<td>"+rows[i].jine+"</td>");
					 trr.append("<td>"+rows[i].jieguo+"</td>");
					 trr.appendTo("#dayin-table");
				 }
		 	 }
	</script>
</body>
</html>