<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
	$(function() {
		parent.$.messager.progress('close');
		$('#form').form({
			url : '${pageContext.request.contextPath}/coursesController/edit',
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
			<input name="id" type="hidden" class="span2" value="${courses.id}" readonly="readonly">
			<table class="table table-hover table-condensed">
				<tr>
					<th>课程名称</th>
					<td><input name="name" type="text" placeholder="请输入课程名称" class="easyui-validatebox span2" data-options="required:true"  value="${courses.name}"></td>
					<th>目前人数</th>
					<td>
					<input name="num" type="text" placeholder="请输入目前人数" class="easyui-validatebox span2" data-options="required:true"  value="${courses.num}">
					</td>
				</tr>
				<tr>
					<th>额满人数</th>
					<td><input name="maxNum" type="text" placeholder="请输入额满人数" class="easyui-validatebox span2" value="${courses.maxNum}"></td>
					<th>座位数</th>
					<td><input name="numSeat" type="text" placeholder="请输入座位数" class="easyui-validatebox span2"  value="${courses.numSeat}"></td>
				</tr>
				<tr>
					<th>毕业人数</th>
					<td><input name="numGraduate" type="text" placeholder="请输入毕业人数" class="easyui-validatebox span2" value="${courses.numGraduate}"></td>
					<th>是否付款</th>
					<td>
					<select class="easyui-combobox" name="isPay" data-options="panelHeight:'auto',editable:false" style="width: 140px;height: 30px">
						<option value="0" <c:if test="${courses.isPay == 0}">selected="selected"</c:if>>是</option>
						<option value="1" <c:if test="${courses.isPay == 1}">selected="selected"</c:if>>否</option>
					</select>
					</td>
				</tr>
				<tr>
					<th>是否提供教程</th>
					<td>
					<select class="easyui-combobox" name="isProvide" data-options="panelHeight:'auto',editable:false" style="width: 140px;height: 30px">
						<option value="0" <c:if test="${courses.isProvide == 0}">selected="selected"</c:if>>是</option>
						<option value="1" <c:if test="${courses.isProvide == 1}">selected="selected"</c:if>>否</option>
					</select>
					</td>
					<th></th>
					<td></td>
				</tr>
				<tr>
					<th>课程亮点</th>
					<td colspan="3"><textarea name="point" rows="" cols="" class="span5">${courses.point}</textarea></td>
				</tr>
			</table>
		</form>
	</div>
</div>