<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
	$(function() {
		parent.$.messager.progress('close');
		
		$('#form').form({
			url : '${pageContext.request.contextPath}/jiNianRiController/add',
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
			<input name="id" type="hidden" class="span2" value="${jnr.id}" readonly="readonly">
			<input name="customerId" type="hidden" class="span2" value="${jnr.customerId}" readonly="readonly">
			
			<table class="table table-hover table-condensed">
				<tr>
					<th>生日</th>
					<td>
						<!-- <input name="brd" type="text" placeholder="请输入生日" class="easyui-validatebox span2" > -->
						<input class="span2" name="brd" placeholder="点击选择时间" onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss'})" readonly="readonly" />
					</td>
					<th>阳历or阳历</th>
					<td>
					<select class="easyui-combobox" name="type" data-options="panelHeight:'auto',editable:false" style="width: 140px;height: 30px">
							<option value="0">阴历</option>
							<option value="1">阳历</option>
					</select>
					</td></tr>
				<tr>
					<th>关系</th>
					<td colspan="3"><textarea name="name" rows="" cols="" class="span5"></textarea></td>
				</tr>
			</table>
		</form>
	</div>
</div>