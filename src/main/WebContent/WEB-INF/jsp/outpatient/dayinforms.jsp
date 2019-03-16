<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div style="float: right;">
		<a class="easyui-linkbutton" id="printarea-look"
			style="width: 60px; margin-top: 2px;margin-right: 2px;margin-bottom: 2px"
			data-options="iconCls:'icon-print',plain:true">打印
		</a>
	</div>
	<div class="print-div">
		<div style="font-size: 14px;font-weight: bold;padding: 5px;color: #398000;">深圳XXX医院</div><hr style="border: 0px ;border: 1px dashed #D9E0EB"/>
		<div style="padding-left: 8px;padding-right: 8px;">
			<table id='print-tale-one' border="1" width="100%"  style="border:1px solid #ddd;
			    border-width: 1px;
			    border-color: #C0C0C0;
			    border-collapse: collapse;
			    ">
				<tr height="25">
					<td style="font-size: 22px;font-weight: bold;text-align: center;color: #398000;" rowspan="2" colspan="2">电子处方单</td>
					<td  align="right">处方号：</td>
					<td width="210px" id="eletonic-dyid"></td>
				</tr>
				
				<tr height="25" >
					<td align="right">处方日期：</td>
					<td width="210px" id="eletonic-dydate"></td>
				</tr>
				
				<tr height="25">
					<td width="100">门诊号：</td>
					<td width="210px" id="outregist-dyid"></td>
					<td width="100" align="right">住院号：</td>
					<td width="210px" id="zhuyuan-dyid"> </td>
				</tr>
				
				<tr height="25" >
					<td width="100" >病人姓名：</td>
					<td width="210px" id="outregist-name"> </td>
					<td width="100"  align="right">科室：</td>
					<td width="210px" id="dclass-name"> </td>
					
				</tr>
				
				<tr height="25" ">
					<td width="100">年龄：</td>
					<td width="210px" id="outregist-age"> </td>
					<td width="100"  align="right">性别：</td>
					<td width="210px" id="outregist-sex"> </td>
				</tr>
				
				<tr height="25" style="border-bottom: 1px solid white">
					<td width="100" >处方医生：</td>
					<td width="210" colspan="3" id="eletronic-doctor"></td>
				</tr>
				
			</table>
			<table  border="1" width="100%"  id="tables-financialsj" style="border:1px solid #ddd;
			    border-width: 1px;
			    border-color: black;
			    border-collapse: collapse;">
					<tr height="20" style="font-family: '黑体'" align="center">
						<td>编号</td>
						<td>收费类型</td>
						<td bgcolor="#CCFFFF">收费项目名称</td>
						<td>数量</td>
						<td>单价</td>
						<td bgcolor="#CCFFFF">金额</td>
					</tr>
				<tbody id="financial-tbody"></tbody>
				<tfoot>
					<tr height="20">
						<td align="center" style=''>合计（大）：</td>
						<td id="financialhejida" align="center"  colspan="3"  style="color:#398000;font-weight: bold;"></td>
						<td align="center">（小写）：</td>
						<td id="financialhejixiao" align="center" style="color:#398000;font-weight: bold;"></td>
					</tr>
				</tfoot>
				
			</table>
		</div>
	</div>
	
<script type="text/javascript">
	$(document).ready(function(){
		$('#printarea-look').linkbutton({onClick :function(){
			$('.print-div').printArea();
		}});
	});
</script>
</body>
</html>