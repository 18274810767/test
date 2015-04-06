<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
	var editor;
	$(function() {
		window.setTimeout(function() {
			editor = KindEditor.create('#note', {
				width : '670px',
				height : '370px',
				items : [ 'fullscreen', 'preview', 'print' ]
			});
			//editor.readonly();

			parent.$.messager.progress('close');
		}, 1);
	});
</script>
<style>
.s{height:70px;overflow:auto}
</style>
<div class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'center',border:false">
		<table class="table table-hover table-condensed" >
			<tr>
				<th>编号</th>
				<td>${zongjie.id}</td>
				<th>姓名</th>
				<td>${zongjie.name}</td>
			</tr>
			<tr>
				<th>工作内容</th>
				<td colspan="3" class="s">${zongjie.notes}</td>
			</tr>
			<tr>
				<th>已完成工作</th>
				<td colspan="3" class="s">${zongjie.finished}</td>
			</tr>
			<tr>
				<th>工作总结</th>
				<td colspan="3"><textarea name="note" id="note" cols="50" rows="5" style="visibility: hidden;">${zongjie.zongjie}</textarea></td>
			</tr>
		</table>
	</div>
</div>