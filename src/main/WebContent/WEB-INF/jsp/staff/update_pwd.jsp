<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<div class="easyui-layout" data-options="fit:true">
						<div data-options="region:'center'" style="padding:10px;">
				<form id="ff-password-update" method="post">
					<table width="100%">
						<tr height="40px">
							<td>
								<input name="oldPwd" class="easyui-passwordbox" data-options="label:'原密码' , validType : 'regexPwdTrue' , 
									labelWidth:100 , width:300 , labelAlign : 'right' , required : true"/>
							</td>
						</tr>
						<tr height="40px">
							<td>
								<input name="newPwd" id="newPwd" class="easyui-passwordbox" data-options="label:'新密码' , 
									labelWidth:100 , width:300 , labelAlign : 'right' , required :true"/>
							</td>
						</tr>
						<tr height="40px">
							<td>
								<input name="newPwd2"  id="easyui-passwordbox"  validType="equals['#newPwd']"   class="easyui-passwordbox" data-options="label:'确认密码' , 
									labelWidth:100 , width:300 , labelAlign : 'right' , required : true"/>
							</td>
						</tr>
						
					</table>
				</form>
						</div>
						<div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
							<a id="password-save" class="easyui-linkbutton" data-options="iconCls:'icon-ok', plain:true">确定</a>
							<a id="password-not" class="easyui-linkbutton" data-options="iconCls:'icon-cancel', plain:true">取消</a>
						</div>
				</div>
				
		<script type="text/javascript">
			$(function(){
				//验证密码是否输入正确
				$.extend($.fn.validatebox.defaults.rules , {
					regexPwdTrue : {
						validator : function(value){
							var json = null;
							$.post({
								async : false,
								url : 'regex_pwd_true',
								data : {oldPwd : value},
								success : function(data){
									json = eval('('+data+')');
								}
							});
							return json.error;
						},
						message : '原密码错误！请重新输入！'
					}
				});
				
				$.extend($.fn.validatebox.defaults.rules, {    
				    equals: {    
				        validator: function(value,param){    
				            return value == $(param[0]).val();    
				        },    
				        message: '两次密码输入不一致！'   
				    }    
				});  

				//确定修改
				$("#password-save").linkbutton({onClick : function(){
					$("#ff-password-update").form('submit' , {
						url : 'update_password',
						onSubmit : function(param){
							return $(this).form('validate');
						},		
						success : function(data){
							json = eval('('+data+')');
							if(json.error){
								$.messager.alert('提示' , '修改成功！请重新登录' , 'info' , function(){
									window.location.href="login";
								});
							}else{
								$.messager.alert('提示', json.eMessage);
							}
						}
					});
				}});
				
			});
		</script>
</body>
</html>