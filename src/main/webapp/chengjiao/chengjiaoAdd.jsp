<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<script type="text/javascript">
	$(function() {
		parent.$.messager.progress('close');
		
		
		$('#form').form({
			url : '${pageContext.request.contextPath}/chengjiaoController/add',
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
			<table class="table table-hover table-condensed">
				<tr>
					<th>客户姓名</th>
					<td><input name="customerName" type="text" placeholder="请输入客户姓名" class="easyui-validatebox span2" data-options="required:true" value=""></td>
					<th>是否通知 </th>
					<td>
					<input name="id" type="hidden" class="span2" value="${cj.id}" readonly="readonly">
					<select name="isNotice" class="easyui-combobox" data-options="width:140,height:29,editable:false,panelHeight:'auto'">
						<option value="0">是</option>
						<option value="1">否</option>
					</select>
					</td>
				</tr>
				<tr>
					<th>服务内容</th> 
					<td><input name="serviceContent" type="text" placeholder="请输入服务内容 " class="easyui-validatebox span2" data-options="required:true"></td>
					<th>服务方式</th>
					<td><input name="serviceMode" type="text" placeholder="请输入服务方式" class="easyui-validatebox span2" data-options="required:true" ></td>
				</tr>
				<tr>
					<th>反馈</th>
					<td colspan="3"><textarea name="fadeBack" rows="" cols="" class="span5" ></textarea></td>
				</tr>
			</table>
		</form>
	</div>
</div>