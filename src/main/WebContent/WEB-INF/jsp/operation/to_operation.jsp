<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>体检</title>

</head>
<body>

<div id="win" class="easyui-layout" title="检验管理" style="width:800px;height:500px"   
        data-options="iconCls:'icon-save',modal:true,fit:true">  
        
   <div id="regist-top-id" data-options="region:'north'" style="height:45px;padding: 8px">
		        	<a id="operation-init" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" style="width:80px">新建</a>  
					<a id="operation-ghcl" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok',plain:true" style="width:100px;">处理</a>  
					<a id="dayin" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-print',plain:true," style="width:80px;">打印</a>
   </div>   	
	       <!-- 表单 -->
   <div data-options="region:'center'" style="height:450px;">   
	           <form id="insert-tjgd" method="post"style="border:1px solid #66cccc;">
	           		<table width="100%" style="padding: 10px 10px 2px 3px;height:140px;">
	           			<tr>
		           				<!-- 只读不能修改模式的体检号 -->
	 						<td><input id="j_jianyan" name="jianyanMessId" class="easyui-textbox" readonly="readonly" data-options="label:'体检号*',width:240,labelAlign:'right'"></td>
		           						<td>
		           						
		           						
		           						 <select id="zhuangtaia" class="easyui-combobox" name="jianyanMessState"  data-options="label:'状态',width:240,labelAlign:'right'" readonly="readonly">   
	    									<option>未处理</option>   
	    									<option>已处理</option>   
										</select>
		           						
		           			</td>
	           				<td><input id="jianyanriqia" name="jianyanMessDate" value="Date" class="easyui-datebox" data-options="required:true,label:'检验日期',width:240,labelAlign:'right',editable:false">
	           				</td>
	           				<td><input id="text-menzhen" name="outpaitentRegistId" class="easyui-textbox" data-options="label:'门诊号*',width:240,labelAlign:'right',
		           					buttonText : '…',
 									onClickButton : function(){
 									menzhengh(function(row){
 										shuju(row);
 									} , '已结算');
 								}">
	           			
	           				</td>
	           			</tr>
	        			<tr>
	        					
	        				<td>
	        				<input id="Namepatient" name="medicalCardName" class="easyui-textbox" data-options="label:'病人姓名',width:240,labelAlign:'right'">
	        				</td>
	        				<!-- 下拉框 -->
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
							<td>
 								<select id="jianyanra" name="empId"  class="easyui-combobox" data-options="editable:false,label:'检验人',width:240,labelAlign:'right'">
									   <option value="${empMessage.empId}">${empMessage.empLoginName}</option>   
								 
								</select>
							</td>
							<td>
 							<input class="easyui-combobox" id="dclassIds" name="dclassName" data-options="label:'检验室',
			           			width:240,
			           			labelAlign:'right',
			           			valueField:'dclassId',    
		    					textField:'dclassName'   ,
			           			method : 'get',
			           			url : 'where_select_dclass?deptId=2',
			           			required:true,
			           			editable:false">
							</td>
	           			</tr>	
	           			<tr>
	           				 <td><select id="jianyanMessleixing" class="easyui-combobox" name="jianyanMessYangbenType"  data-options="editable:false,label:'样本类型' , width:240 , labelAlign : 'right' , ">
	           				 		<option>血清</option>
 									<option>尿液</option>
 									<option>唾液</option>
	           				 	</select></td> 
	           				
	           			</tr>
	           		</table>	
	           		
	           </form>
					  
								
				
			<table id="table-menzhen" class="easyui-datagrid select-tijian-type" style="width:100%;height: 70%;"   
       		data-options="rownumbers:true,singleSelect:true,
       		fitColumns: true,
       		method : 'get'
			">
   			<thead>   
      		 	<tr>
      		 		<th data-options="field:'xmbianhao',width:10,align:'center'">检验项目编号</th>
      		 		<th data-options="field:'xmname',width:10,align:'center'">检验项目名称</th>
           		 	<th data-options="field:'csfw',width:10,align:'center',editor:'text',
           		 	styler: function(value,row,index){
							return 'color:red;font-weight:bold';
					}">参考范围</th>
           		 	<th data-options="field:'jiegao',width:10,align:'center',editor:'text',
           		 	styler: function(value,row,index){
							return 'color:red;font-weight:bold';
					}
           		 ">检验结果</th>
           		 	<th data-options="field:'yichang',width:10,align:'center',editor:'text',
           		 	styler: function(value,row,index){
							return 'color:red;font-weight:bold';
					}">异常</th>
     	  		</tr>   
  		  	</thead>   
		</table>
	   </div>
	</div>
</div><!-- 结尾div -->
		
		<!-- 打印 -->
		<div id="dayin-window" class="easyui-window" title="打印" style="width:800px;height:450px;" 
		data-options="modal:true,collapsible:false,minimizable:false,maximizable:false,closed:true">
			<div style="float: right;">
				<a id="dayinanniu" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok',plain:true"style="width:80px;">打印</a>
			</div>
			<div style="font-size: 14px;font-weight: bold;padding: 5px">深圳XXX医院</div><hr style="border: 0px ;border: 1px dashed #D9E0EB"/>
			
			<div class="easyui-layout dayin_operation" data-options="fit:true">
				<div data-options="region : 'center' , split : true" style="height:50px">
					<div>
					
						<table border="1" cellpadding="0" cellspacing="0" style="border-collapse: collapse;" width="100%">
							<thead>
								<tr style="text-align: center">
								<td style="font-size: 20px;font-weight: bold;text-align: center;color: #398000;" rowspan="2" colspan="2">检验单</td>
									<td style="height:23px;width:90px">
									体检号：
									</td>
									<td style="height:23px;width:150px" id="tijianhao">
									
									</td>
									<td style="height:23px;width:90px">
									门诊号：
									</td>
									<td style="height:23px;width:150px" id="menzhenhao">
									
									</td>
									<td style="height:23px;width:90px">
									检验室：
									</td>
									<td style="height:23px;width:150px" id="jianyanshi">
									
									</td>
								</tr>
								<tr style="text-align: center">
									<td style="height:23px;width:90px">
									状态：
									</td>
									<td style="height:23px;width:150px" id="zhuangtai">
									
									</td>
									<td style="height:23px;width:90px">
									科室：
									</td>
									<td style="height:23px;width:150px" id="keshi">
									
									</td>
									<td style="height:23px;width:90px">
									样本类型：
									</td>
									<td style="height:23px;width:150px" id="yangbenleixing">
									
									</td>
								</tr>
								<tr style="text-align: center">
									<td style="height:23px;width:90px">
									检验日期：
									</td>
									<td style="height:23px;width:150px" id="jianyanriqi">
									
									</td>
									<td style="height:23px;width:90px">
									病人姓名：
									</td>
									<td style="height:23px;width:150px" id="bingrenxingming">
									
									</td>
									<td style="height:23px;width:90px">
									检验人：
									</td>
									<td style="height:23px;width:150px" id="jianyanren">
									
									</td>
								</tr>
							</thead>
						</table>
						<table border="1" id="dayin-table" cellpadding="0" cellspacing="0" style="border-collapse: collapse;" width="100%">
							<thead>
								<tr style="text-align: center">
									<th>序号</th>
									<th>检验项目编号</th>
									<th>检验项目名称</th>
									<th>检验结果</th>
									<th>参考范围</th>
									<th>异常</th>
								</tr>
								
							</thead>
						</table>
					</div>
				</div>
			</div>
		</div>
		

			<!-- 检验弹框 -->
			 <div id="win-tj" class="easyui-window" title="选择检验规则 " style="width:800px;height:500px" data-options="
			    model : true ,  
			    closed:true,
			    minimizable:false,
			    maximizable:false,
			    collapsible:false,
			    resizable:false,
			     modal:true,
			     href :'href_address?myValue=/operation/operation_window' , method : 'get'
			     "></div>
			     
			<script type="text/javascript">
			function shuju(rows){
				$.getJSON('select_jianyan_menzhen' , {outpaitentRegistId :rows.treeField},function(data){
					/*  $.messager.alert("",JSON.stringify(rows));   */
					if (!data.error) {
						$.messager.alert("提示","该门诊号已处理,不能重复！");
						return;
					}
					$("#insert-tjgd").form('load',rows);
					$("#text-menzhen").textbox('setValue',rows.treeField);
					$("#dclassIds").textbox('setValue' , rows.dclass.dclassName);
					$("#Namepatient").textbox('setValue' , rows.medical.medicalCardName);
					$("#table-menzhen").datagrid("load","select_menzhen_shoufei?outpaitentRegistId="+rows.idField);
				});
			}
			$(function(){
				
				
				//打印机
				$("#dayin").linkbutton({onClick : function(){
					$("#tijianhao").html($("#j_jianyan").textbox("getValue"));
					$("#menzhenhao").html($("#text-menzhen").textbox("getValue"));
					$("#jianyanshi").html($("#jianyanMessDclass").textbox("getValue"));
					$("#zhuangtai").html($("#zhuangtaia").textbox("getValue"));
					$("#keshi").html($("#dclassIds").textbox("getValue"));
					$("#yangbenleixing").html($("#jianyanMessleixing").textbox("getValue"));
					$("#jianyanriqi").html($("#jianyanriqia").textbox("getValue"));
					$("#bingrenxingming").html($("#Namepatient").textbox("getValue"));
					$("#jianyanren").html($("#jianyanra").textbox("getValue"));
					totable();
					$("#dayin-window").window("open");	
				}});
				//打印成图片报表
				$(document).ready(function(){
					$('#dayinanniu').linkbutton({onClick :function(){
						$('.dayin_operation').printArea();
					}});
				});

				
				
				
				
			$.get("qc_form_bd",function(){});
			$("#t-t-t").linkbutton({onClick : function(){
					$("#win-tj").window("open");
				}});
			/*  点击门诊号旁边的链接，进入门诊的弹框页面的点击事件  */
			$("#text-menzhen").linkbutton({onClick : function(){
				alert("...");
				/* var rowb=$("#select_datagrid").datagrid('getRows');	
				alert(rowb.length);
				for(var i=rowb.length -1; i>=0;i--){
						alert(rowb[i].outpaitentRegistZhuangtai);
				 	if(rowb[i].outpaitentRegistZhuangtai != "已结算"){
						$("#select_datagrid").datagrid('deleteRow',i);
					}
				} */
				$("#win-menzhenbk").window("open");
			}});
			
			/* 生成体检号 */
			$.get("j_jianyan",function(data){
				$('#j_jianyan').textbox('setValue',data.substring(1,data.length - 1));
			});
	
			/*添加体检挂单处理*/
			$("#operation-ghcl").linkbutton({onClick : function(){
				if($("#table-menzhen").datagrid('getRows') ==0){
			 		$.messager.alert('提示' , '请至少选择一条数据处理!');
			 		return;
				}
				tijiao("已处理");
				qingkong();
			}});
			
			/*打开检验室窗口页面选中数据，点击确定传出选中数据到页面上上*/
			 $("#win-tj").window({onLoad : function(){
					$("#tijiantianjia-queding").linkbutton({onClick : function(){
						rows = $("#jianyanid").datagrid("getSelected");
						alert(JSON.stringify(rows)); 
						$("#insert-tijian-form").form('load',rows);
						$("#dclassIds").textbox('setValue' , rows.hospitaNotify.outpaitentRegist.dclass.dclassName);
						$("#Namepatient").textbox('setValue' , rows.hospitaNotify.outpaitentRegist.medicalCard.medicalCardName);
						
						$("#win-tj").window("close");
					}});
			}});
	
		 	
			 indexs = -1 ;
		  	//修改
			$("#table-menzhen").datagrid({onDblClickRow:function(index,row){
				//开始编辑状态
				indexs=index;
				$("#table-menzhen").datagrid('beginEdit',index);
			}}); 
			//修改加编辑
			$("#table-menzhen").datagrid({onClickRow:function(index,row){
				if(indexs != -1){
					$("#table-menzhen").datagrid('endEdit',indexs);
					$("#table-menzhen").datagrid('selectRow',indexs);
					var rows=$("#table-menzhen").datagrid('getSelected');
					$.get("update_jianyan_bianji",{id:rows.id , csfw:rows.csfw , jiegao:rows.jiegao , yichang:rows.yichang},function(){
						$("#table-menzhen").datagrid("reload",'select_jianyan_bianji');
						$("#table-menzhen").datagrid({onLoadSuccess: function(){
						var rows=$("#table-menzhen").datagrid("getRows");
	 					
	 				}});
	 			});
	 			indexs = -1;
	 		}
		}});  
			
	});
		/*状态加提交*/
		function tijiao(state){
			$("#insert-tjgd").form("submit" , {
				url : 'insert_jianyan_guadan',
				onSubmit :function(data){
					data.state = state;
					return $(this).form("validate");
				},
				success : function(data){
					var json = eval("("+data+")");
					if(json.error){ 
						$.messager.alert("提示","处理成功");
						$.get("j_jianyan",function(a){
						$('#j_jianyan').textbox('setValue',a.substring(1,a.length - 1));
					
						});
					$("#text-menzhen").textbox('setValue',"");
					$("#text-bingrenname").textbox('setValue',"");
					$("#text-jianyanr").textbox('setValue',"");
					$("#text-songjianyisheng").textbox('setValue',"");
					$("#Namepatient").textbox('setValue',"");
					}
				}
			});
		}
		//清空
	 	function qingkong(){
			var rows = $("#table-menzhen").datagrid('getRows');
			for(var i=rows.length -1; i>=0;i--){
				$("#table-menzhen").datagrid('deleteRow',i);
			}
		} 
		
		//打印
	 	 function totable(){
	 		 var rows = $("#table-menzhen").datagrid("getRows");
	 		for(var i = 0; i< rows.length; i++){
				 var trr = $("<tr style='text-align : center;height : 20px'></tr>");
				 trr.append("<td>"+rows[i].xmbianhao+"</td>");
				 trr.append("<td>"+rows[i].xmname+"</td>");
				 trr.append("<td>"+rows[i].csfw+"</td>");
				 trr.append("<td>"+rows[i].jiegao+"</td>");
				 trr.append("<td>"+rows[i].yichang+"</td>");
				 trr.appendTo("#dayin-table");
			 }
	 	 }
	</script>
		</body>
</html>