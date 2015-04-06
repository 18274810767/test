<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
	$(function() {
		parent.$.messager.progress('close');
		
		$('#form').form({
			url : '${pageContext.request.contextPath}/followController/add',
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
			<input name="id" type="hidden" class="span2" value="${follower.id}" readonly="readonly">
			<input name="customerId" type="hidden" class="span2" value="${follower.customerId}" readonly="readonly">
			
			<table class="table table-hover table-condensed">
				<tr>
					<th>跟踪方式</th>
					<td>
					<select class="easyui-combobox" name="type" data-options="panelHeight:'auto',editable:false" style="width: 140px;height: 30px">
							<option value="0">电话</option>
							<option value="1">拜访</option>
					</select>
					</td>
					<th>是否销售机会</th>
					<td>
					<select class="easyui-combobox" name="isjihui" data-options="panelHeight:'auto',editable:false" style="width: 140px;height: 30px">
							<option value="0">是</option>
							<option value="1">否</option>
					</select>
					</td></tr>
				<tr>
					<th>备注</th>
					<td colspan="3"><textarea name="remark" rows="" cols="" class="span5"></textarea></td>
				</tr>
			</table>
		</form>
	</div>
</div>