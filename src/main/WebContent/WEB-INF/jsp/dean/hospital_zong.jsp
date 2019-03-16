<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>医院经营总表</title>
</head>
<body>
	<style type="text/css">
		#ul_shanx{
		list-style:none;
			width: 100%;
			margin-left: -20px;
		}
		#ul_shanx li {
			width: 100%;
			margin-top: 12px;
			
		}
		#suls{
			height: 20px;
			margin-top: -1px;
			margin-left: 23%;
			
		}
		#suls li{
			list-style: none;
			float: left;
			margin : 5px;
		}
	
		#suls li span{
			width:10px;
			float:left;
			height:10px;
			margin: 2px 5px 0px 0px;
		}
			#suls li:hover{
			cursor: pointer;
		}
	</style>
	
		<div  class="easyui-layout" data-options='fit:true , border:false' style="border:none;">   
		    <div data-options="region:'center' , border:false" style="width: 35%;">
		    	<div class="easyui-tabs" data-options="fit:true , border:false">   
				    <div title="门诊收费项目">   
				          <table class="easyui-datagrid" id="menzehn_tab"
						        data-options="border:false,url:'',fitColumns:true,singleSelect:true ,fit:true, method:'get' , rownumbers : true , rownumbers : true">   
						    <thead>  
						        <tr>   
						            <th data-options="field:'shoufeiType',width:200">收费类型 </th>   
						            <th data-options="field:'xiangmuId',width:200"> 项目编号</th>   
						            <th data-options="field:'xiangmuName',width:200">项目名称</th>  
						            <th data-options="field:'xiangmuNum',width:100">数量</th>   
						            <th data-options="field:'xiangmuChengBen',width:100">成本</th>   
						            <th data-options="field:'xiamgMuPrice',width:100">单价</th>  
						            <th data-options="field:'xiangmuMoney',width:100">金额</th> 
						             <th data-options="field:'times',width:160">收费时间</th> 
						        </tr>   
						    </thead>   
						</table>  
				    </div>   
				    <div title="住院收费项目">   
				            <table class="easyui-datagrid" id="zhuyuan_sf" 
						        data-options="border:false,url:'',fitColumns:true,singleSelect:true ,fit:true , method:'get' , rownumbers : true">   
						    <thead>   
						        <tr>   
						          <th data-options="field:'shoufeiType',width:200">收费类型 </th>   
						            <th data-options="field:'xiangmuId',width:200"> 项目编号</th>   
						            <th data-options="field:'xiangmuName',width:200">项目名称</th>  
						            <th data-options="field:'xiangmuNum',width:100">数量</th>   
						            <th data-options="field:'xiangmuChengBen',width:100">成本</th>   
						            <th data-options="field:'xiamgMuPrice',width:100">单价</th>  
						            <th data-options="field:'xiangmuMoney',width:100">金额</th>  
						             <th data-options="field:'times',width:160">收费时间</th> 
						        </tr>   
						    </thead>   
						</table>  
				    </div>   
				    <div title="门诊发药" data-options="" >   
				       		<table class="easyui-datagrid" id="menzhenfayao "  
							        data-options="border:false,url:'select_all_menzhen_drug_zong',fitColumns:true,singleSelect:true ,rownumbers : true,fit:true,method :'get'">   
							    <thead>   
							         <tr>   
							         	 <th data-options="field:'shoufeiType',width:200">收费类型 </th>   
							            <th data-options="field:'xiangmuId',width:200"> 项目编号</th>   
							            <th data-options="field:'xiangmuName',width:200">项目名称</th>  
							            <th data-options="field:'xiangmuNum',width:80">数量</th>   
							             <th data-options="field:'xiangmuDanwei',width:80">单位</th> 
							            <th data-options="field:'xiangmuChengBen',width:80">成本</th>   
							            <th data-options="field:'xiamgMuPrice',width:80">单价</th>  
							            <th data-options="field:'xiangmuMoney',width:80">金额</th>  
						     	   </tr>     
							    </thead>   
							</table>  
				    </div>
				     <div title="住院发药" data-options="" id="zhuyuanfayao" style="border:none;">   
			       			<table class="easyui-datagrid"  
						        data-options="border:false,url:'select_all_zhuyuan_drug_zong',fitColumns:true,singleSelect:true ,rownumbers : true ,method:'get' , fit:true">   
						    <thead>   
						         <tr>   
						         	 <th data-options="field:'shoufeiType',width:200">收费类型 </th>   
							            <th data-options="field:'xiangmuId',width:200"> 项目编号</th>   
							            <th data-options="field:'xiangmuName',width:200">项目名称</th>  
							            <th data-options="field:'xiangmuNum',width:80">数量</th>   
							             <th data-options="field:'xiangmuDanwei',width:80">单位</th> 
							            <th data-options="field:'xiangmuChengBen',width:80">成本</th>   
							            <th data-options="field:'xiamgMuPrice',width:80">单价</th>  
							            <th data-options="field:'xiangmuMoney',width:80">金额</th> 
						        </tr>        
						    </thead>   
						</table>  
				    </div>  
				     <div title="总经营报表1" data-options="border:false" style="border:none;">   
				       		<div  class="easyui-layout" data-options="fit:true,border:false">   
							    <div data-options="region:'north',border:false" style="height:50px;">
							    	<table style="margin-top:8px" width="99%">
							    		<tr>
							    			<td>
							    				<input class="easyui-textbox" id="zongMoney" data-options="label:'总金额' , editable:false , labelAlign : 'right'  , labelWidth:'60' , width:200">
							    			</td>
							    			<td>
							    				<input class="easyui-textbox" id="zongChenBen" data-options="label:'总成本' , editable:false ,labelAlign : 'right' ,  labelWidth:'60' , width:200">
							    			</td>
							    			<td>	
							    				<input class="easyui-textbox" id="zongMaoli" data-options="label:' 总毛利 ' , editable:false ,labelAlign : 'right' ,  labelWidth:'60' , width:200">
							    			</td>
							    			<td>
							    				<input class="easyui-textbox" id="zongMaolilv" data-options="label:' 总毛利率' , editable:false ,labelAlign : 'right' ,  labelWidth:'60' , width:200">
							    			</td>
							    		</tr>
							    	</table>
							    </div>   
							    <div data-options="region:'east' , border:false" style="width:45%;border:none">
							    	<div style="border: 1px solid #ddd;width:95px;height:115px
							    	;position: absolute;z-index: 1000;margin-left: 410px;
							    	margin-top: 13px">
							    		<ul id="ul_shanx">
							    			
							    		</ul>
							    	</div>
									<div id='canvasDivS'></div>
							    </div>   
							    <div data-options="region:'center' , border:false" style="width: 55%;">
							   		<div id='canvasDivX'></div>
							    </div>   
						      <div data-options="region:'south' , border:false" style="height:75px;">
						      	<div style="width:50%;height: 25px;">
						      		<ul id="suls" style="">
						      			<li value="-1">
						      				<span style="background: #ddd"></span>全部
						      			</li>
						      			<li value="1"  style="margin-left: 35px"> 
						      				<span style="background: #1f7e92"></span>收费项目
						      			</li>
						      			<li  value="0" style="margin-left: 35px">
						      				<span style="background : #ed23e3"></span>药房项目
						      			</li>
						      		</ul>
						      	</div>
						      </div>   
							</div>  
				    </div>   
				    <div title="总经营报表2" data-options="" style="border:none;">  
				    	  <div id='canvasDivZ'></div>
				    </div>
				</div>  
	    	
		    </div>   
	   </div>   
		<script type="text/javascript">
		var  t1 , t2 , t3 , t4;
		//加载四个表格
		$(function(){
			//门诊收费项目
			$.getJSON('select_all_menzhen_zong' , function(json){
				t1 = appendRows("#menzehn_tab" , json);
			});
			
			//住院收费项目
			$.getJSON('select_all_zhuyuan_zong' , function(json){
				t2 = appendRows("#zhuyuan_sf" , json);
			});
			
			//点击事件
			$("#suls li").click(function(){
				var index = $(this).val();
				if(index != -1){
					$(this).css('color','red').siblings().css('color','');
					$.getJSON("select_zhe_xian_tu_where" ,{index :index} ,  function(data){
						zhexiantu(data);
					});
				}else{
					$("#suls li").css('color','');
					$.getJSON("select_zhe_xian_tu" , function(data){
						zhexiantu(data);
					});
				}
			});
			
			
		});
		
		//计算前
		function  appendRows(id , json){
			for (var i = 0; i < json.length; i++) {
				$(id).datagrid('appendRow' , {
					shoufeiType : json[i].shoufeiType,
					xiangmuId   : json[i].xiangmuId,
					xiangmuName : json[i].xiangmuName,
					xiangmuNum  : json[i].xiangmuNum,
					xiangmuChengBen :  json[i].xiangmuChengBen,
					xiamgMuPrice : json[i].xiamgMuPrice,
					xiangmuMoney : json[i].xiangmuMoney,
					times : json[i].times,
					xiangmuDanwei : json[i].xiangmuDanwei
				});
			}
		}
		$(function(){
				$.getJSON("select_zong_tong_ji_sxt" , function(json){
					//创建li , 添加到ul_shanx
					$("#ul_shanx").children('li').remove();
					for (var i = 0; i < json.length; i++) {
						var $span = $('<span>').css('width' , '10px').css('height' , '10px')
						.css('background' , json[i].color).html(" ").css('float' , 'left').css('marginLeft' , '-15px')
						.css('marginTop' , '2px');
						$("<li>").html(json[i].name).appendTo('#ul_shanx');
						$span.appendTo($('#ul_shanx li').eq(i));
					}
					var data = json;
					var chart = new iChart.Pie3D({
						render : 'canvasDivS',
						data: data,
						title : {
							text : '2018医院经营扇形图',
							height:40,
							fontsize : 20,
							color : '#282828'
						},
						sub_option : {
							mini_label_threshold_angle : 40,//迷你label的阀值,单位:角度
							mini_label:{//迷你label配置项
								fontsize:20,
								color : '#ffffff'
							},
							label : {
								background_color:null,
								sign:false,//设置禁用label的小图标
								padding:'0 4',
								fontsize:11,
								color : '#4572a7'
							},
							listeners:{
								parseText:function(d, t){
									return d.get('value')+"%";//自定义label文本
								}
							} 
						},
						
						animation : true,//开启过渡动画
						animation_duration:800,//800ms完成动画 
						shadow : true,
						shadow_blur : 6,
						shadow_offsetx : 0,
						shadow_offsety : 0,
						align:'right',//右对齐
						offsetx:-100,//设置向x轴负方向偏移位置60px
						offset_angle:-90,//逆时针偏移120度
						width : 520,
						height : 400,
						radius:140
					});
					
					chart.draw();
				});
			});
		</script>
				<script type="text/javascript">
			$(function(){
				$.getJSON("select_zhu_xing_tu_all" , function(json){
					var data = json;
						var chart = new iChart.ColumnMulti3D({
								render : 'canvasDivZ',
								data: data,
								labels:["一月","二月","三月","四月","五月","六月" , "七月","八月","九月","十月","十一月","十二月"],
								title : {
									text : '2018年各月份收入柱形图',
									color : '#3e576f'
								},
								footnote : {
										color : '#909090',
									fontsize : 11
								},
								width : 1200,
								height : 497,
								background_color : '#ffffff',
								legend:{
									enable:true,
									background_color : null,
									align : 'center',
									valign : 'bottom',
									row:1,
									column:'max',
									border : {
										enable : false
									}
								},
								column_width : 8,//柱形宽度
								zScale:8,//z轴深度倍数
								xAngle : 50,
								bottom_scale:1.1,
								label:{
									color:'#4c4f48'
								},
								sub_option:{
									label :false
								},
								tip:{
									enable :true
								},
								text_space : 16,//坐标系下方的label距离坐标系的距离。
								coordinate:{
									background_color : '#d7d7d5',
									grid_color : '#a4a4a2',
									color_factor : 0.24,
									board_deep:10,
									offsety:-10,
									pedestal_height:10,
									left_board:false,//取消左侧面板
									width:950,
									height:330,
									scale:[{
										 position:'left',	
										 start_scale:0,
										 end_scale:1000,
										 scale_space:200,
										 scale_enable : false,
										 label:{
											color:'#4c4f48'
										 }
									}]
								}
						});
						chart.draw();
				});
			});
			
			function  zhexiantu(json){
					var data = json;
					var chart = new iChart.LineBasic2D({
								render : 'canvasDivX',
								data: data,
								title : '2018各月份医院经营折线图',
								width : 640,
								height : 400,
								coordinate:{height:'90%',background_color:'#f6f9fa'},
								sub_option:{
									hollow_inside:false,//设置一个点的亮色在外环的效果
									point_size:16
								},
								labels:["一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"]
							});
					chart.draw();
			}
			
			$(function(){
				$.getJSON("select_zhe_xian_tu" , function(data){
					zhexiantu(data);
				});
			});
					
			</script>
			
			
			
			<script type="text/javascript">
				$.getJSON("select_zhu_xing_tu_all" , function(json){
					var zongMoney = 0.0;
					for (var i = 0; i < json.length; i++) {
						for (var j = 0; j < 12; j++) {
							if(json[i].value[j] != null){
								zongMoney +=json[i].value[j];
							}
						}
					}	
					$("#zongMoney").textbox('setValue' , zongMoney);
					//计算总成本
					$.get("ji_suan_zong_cheng_ben" , function(chengben){
						$("#zongChenBen").textbox('setValue' , chengben);
						//计算总毛利
						$("#zongMaoli").textbox('setValue' , (zongMoney - chengben).toFixed(2));
						$("#zongMaolilv").textbox('setValue' , ((zongMoney - chengben)/zongMoney*100).toFixed(2) + "%");
					});
				});
			</script>
</body>
</html>