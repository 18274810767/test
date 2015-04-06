<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
	$(function() {
		parent.$.messager.progress('close');
		
		$('#organizationId').combotree({
			url : '${pageContext.request.contextPath}/organizationController/tree',
			parentField : 'pid',
			lines : true,
			panelHeight : 'auto',
			multiple : false,
			onLoadSuccess : function() {
				parent.$.messager.progress('close');
			},
			cascadeCheck : false,
			value : $.stringToList('${user.organizationId}')
		});
		
		$('#form').form({
			url : '${pageContext.request.contextPath}/userController/edit',
			onSubmit : function() {
				parent.$.messager.progress({
					title : '提示',
					text : '数据处理中，请稍后....'
				});
				var isValid = $(this).form('validate');
				if (!isValid) {
					parent.$.messager.progress('close');
				}
				return isValid;
			},
			success : function(result) {
				parent.$.messager.progress('close');
				result = $.parseJSON(result);
				if (result.success) {
					parent.$.modalDialog.openner_dataGrid.datagrid('reload');//之所以能在这里调用到parent.$.modalDialog.openner_dataGrid这个对象，是因为user.jsp页面预定义好了
					parent.$.modalDialog.handler.dialog('close');
				} else {
					parent.$.messager.alert('错误', result.msg, 'error');
				}
			}
		});
	});
</script>
<div class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'center',border:false" title="" style="overflow: hidden;">
		<form id="form" method="post">
			<input name="id" type="hidden" class="span2" value="${user.id}" readonly="readonly">
			<table class="table table-hover table-condensed">
				<tr>
					<th>登录名称</th>
					<td><input name="name" type="text" placeholder="请输入登录名称" class="easyui-validatebox span2" data-options="required:true" value="${user.name}"></td>
					<th>姓名</th>
					<td><input name="realname" type="text" placeholder="请输入姓名" class="easyui-validatebox span2" data-options="required:true"  value="${user.realname}"></td>
				</tr>
				<tr>
					<th>薪资标准</th>
					<td>
					<select name="solaryTypeId" class="easyui-combobox" data-options="width:140,height:29,editable:false,panelHeight:'auto'">
							<c:forEach items="${solarytypeList}" var="solaryType">
								<option value="${solaryType.level}"<c:if test="${solaryType.level == user.solaryTypeId}">selected="selected"</c:if>>${solaryType.name}</option>
							</c:forEach>
					</select>
					</td>
					<th>部门</th>
					<td><select id="organizationId" name="organizationId" style="width: 140px; height: 29px;" ></select></td>
				</tr>
				<tr>
					<th>身份证号</th>
					<td><input name="cardNum" type="text" placeholder="请输入身份证号" class="easyui-validatebox span2"  value="${user.cardNum}"></td>
					<th>推荐人</th>
					<td><input name="tuijianren" type="text" placeholder="请输入推荐人" class="easyui-validatebox span2"  value="${user.tuijianren}"></td>
				</tr>
				<tr>
					<th>职务</th>
					<td><input name="zhiwu" type="text" placeholder="请输入职务" class="easyui-validatebox span2" value="${user.zhiwu}"></td>
					<th>公司代码</th>
					<td><input name="gcode" type="text" placeholder="请输入公司代码" class="easyui-validatebox span2" value="${user.gcode}"></td>
				</tr>
				<tr>
					<th>住址</th>
					<td colspan="3"><textarea name="adr" rows="" cols="" class="span5" >${user.adr}</textarea></td>
				</tr>
			</table>
		</form>
	</div>
</div>