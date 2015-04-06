<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script type="text/javascript">
	var editor;
	$(function() {

		window.setTimeout(function() {
			editor = KindEditor.create('#zongjie', {
				width : '680px',
				height : '300px',
				items : [ 'source', '|', 'undo', 'redo', '|', 'preview', 'print', 'template', 'code', 'cut', 'copy', 'paste', 'plainpaste', 'wordpaste', '|', 'justifyleft', 'justifycenter', 'justifyright', 'justifyfull', 'insertorderedlist', 'insertunorderedlist', 'indent', 'outdent', 'subscript', 'superscript', 'clearhtml', 'quickformat', 'selectall', '|', 'fullscreen', '/', 'formatblock', 'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline', 'strikethrough', 'lineheight', 'removeformat', '|', 'image', 'flash', 'media', 'insertfile', 'table', 'hr', 'emoticons', 'baidumap', 'pagebreak', 'anchor', 'link', 'unlink' ],
				uploadJson : '${pageContext.request.contextPath}/fileController/upload',
				fileManagerJson : '${pageContext.request.contextPath}/fileController/fileManage',
				allowFileManager : true
			});

			parent.$.messager.progress('close');
		}, 1);

		$('#form').form({
			url : '${pageContext.request.contextPath}/wzongjieController/add',
			onSubmit : function() {
				editor.sync();
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

	function fileManage() {
		editor.loadPlugin('filemanager', function() {
			editor.plugin.filemanagerDialog({
				viewType : 'VIEW',
				dirName : 'image',
				clickFn : function(url, title) {
					//KindEditor('#url').val(url);
					editor.insertHtml($.formatString('<img src="{0}" alt="" />', url));
					editor.hideDialog();
				}
			});
		});
	}
</script>
<div class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'center',border:false" title="" style="overflow: hidden;">
		<form id="form" method="post">
			<table class="table table-hover table-condensed">
				<tr>
					<th>编号</th>
					<td><input name="id" type="text" class="span2" value="${zongjie.id}" readonly="readonly"></td>
				    <th>姓名</th>
					<td><input name="name" type="text" class="span2" placeholder="请输入姓名" data-options="required:true"></td>
				</tr>
				<tr>
					<th>完成工作内容</th>
					<td colspan="3"><textarea name="finished" rows="" cols="" class="span8" placeholder="请输入工作内容" data-options="required:true"></textarea></td>
				</tr>
				<tr>
					<th>拜访客户记录</th>
					<td colspan="3"><textarea name="jilu" rows="" cols="" class="span8" placeholder="请输入工作内容" data-options="required:true"></textarea></td>
				</tr>
				<tr>
					<th>客户互动</th>
					<td colspan="3"><textarea name="hudong" rows="" cols="" class="span8" placeholder="请输入完成的工作" data-options="required:true"></textarea></td>
				</tr>
					
				<tr>
					<th>工作总结</th>
					<td colspan="3"><textarea name="zongjie" id="zongjie" cols="50" rows="5" style="visibility: hidden;"></textarea></td>
				</tr>
			</table>
		</form>
	</div>
</div>