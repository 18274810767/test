<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
	$(function() {
		parent.$.messager.progress('close');
		
		$('#form').form({
			url : '${pageContext.request.contextPath}/customerController/add',
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
			<input name="id" type="hidden" class="span2" value="${customer.id}" readonly="readonly">
			<table class="table table-hover table-condensed">
				<tr>
					<th>姓名</th>
					<td><input name="name" type="text" placeholder="请输入姓名" class="easyui-validatebox span2" data-options="required:true" ></td>
					<th>电话</th>
					<td><input name="phone" type="text" placeholder="请输入电话" class="easyui-validatebox span2" ></td>
				</tr>
				<tr>
					<th>QQ</th>
					<td><input name="qq" type="text" placeholder="请输入QQ" class="easyui-validatebox span2" ></td>
					<th>Email</th>
					<td><input name="email" type="text" placeholder="请输入Email" class="easyui-validatebox span2" ></td>
				</tr>
				<tr>
					<th>微信号</th>
					<td><input name="wx" type="text" placeholder="请输入微信号" class="easyui-validatebox span2" ></td>
					<th>生日</th>
					<td><input name="brd" type="text" placeholder="请输入旺旺号" class="easyui-validatebox span2" ></td>
				</tr>
				<tr>
					<th>行业</th>
					<td><input name="hangye" type="text" placeholder="请输入行业" class="easyui-validatebox span2" ></td>
					<th>住址</th>
					<td><input name="adr" type="text" placeholder="请输入住址" class="easyui-validatebox span2" ></td>
				</tr>
				<tr>
					<th>个人或公司</th>
					<td>
					<select class="easyui-combobox" name="type" data-options="panelHeight:'auto',editable:false" style="width: 140px;height: 30px">
							<option value="0">个人</option>
							<option value="1">公司</option>
					</select>
					</td>
					<th>公司地址</th>
					<td><input name="ltdAdr" type="text" placeholder="请输入公司地址" class="easyui-validatebox span2" ></td>
				</tr>
				<tr>
					<th>公司名称</th>
					<td>
					<input name="ltdName" type="text" placeholder="请输入公司名称" class="easyui-validatebox span2" >
					</td>
					<th>公司职务</th>
					<td>
					<input name="ltdZhiwu" type="text" placeholder="请输入公司职务" class="easyui-validatebox span2" >
					</td>
				</tr>
				<tr>
					<th>是否购买</th>
					<td>
					<select class="easyui-combobox" name="IsGoumai" data-options="panelHeight:'auto',editable:false" style="width: 140px;height: 30px">
							<option value="0">是</option>
							<option value="1">否</option>
					</select>
					</td>
					<th>是否热点</th>
					<td>
					<select class="easyui-combobox" name="isTop" data-options="panelHeight:'auto',editable:false" style="width: 140px;height: 30px">
							<option value="0">是</option>
							<option value="1">否</option>
					</select>
					</td>
				</tr>
				<tr>
					<th>热度分类</th>
					<td>
					<select class="easyui-combobox" name="topFenlei" data-options="panelHeight:'auto',editable:false" style="width: 140px;height: 30px">
							<option value="1">类别1</option>
							<option value="2">类别2</option>
					</select>
					</td>
					<th>热度级别</th>
					<td>
					<select class="easyui-combobox" name="topLevel" data-options="panelHeight:'auto',editable:false" style="width: 140px;height: 30px">
							<option value="A1">低热</option>
							<option value="A2">中热</option>
							<option value="A3">高热</option>
					</select>
					</td>
				</tr>
				<tr>
					<th>证件种类</th>
					<td>
					<select class="easyui-combobox" name="LCardType" data-options="panelHeight:'auto',editable:false" style="width: 140px;height: 30px">
							<option value="1">身份证</option>
							<option value="2">户口</option>
					</select>
					</td>
					<th>证件号</th>
					<td>
					<input name="LCardCode" type="text" placeholder="请输入证件号" class="easyui-validatebox span2" >
					</td>
				</tr>
				<tr>
					<th>价值等级</th>
					<td>
					<select class="easyui-combobox" name="CJiazhi" data-options="panelHeight:'auto',editable:false" style="width: 140px;height: 30px">
							<option value="1">有需求</option>
							<option value="2">有消费决策权</option>
							<option value="3">有消费能力</option>
							<option value="4">有意向度</option>
					</select>
					</td>
					<th>客户来源</th>
					<td>
					<select class="easyui-combobox" name=laiyuan data-options="panelHeight:'auto',editable:false" style="width: 140px;height: 30px">
							<option value="1">电话咨询</option>
							<option value="2">talk99咨询</option>
							<option value="3">QQ咨询</option>
							<option value="4">后台留言</option>
							<option value="5">独立开发</option>
							<option value="6">合作伙伴</option>
							<option value="7">转介绍</option>
					</select>
					</td>
				</tr>
				<tr>
					<th>信用等级</th>
					<td>
					<select class="easyui-combobox" name="xleve" data-options="panelHeight:'auto',editable:false" style="width: 140px;height: 30px">
							<option value="1">高</option>
							<option value="2">中</option>
							<option value="3">低</option>
					</select>
					</td>
					<th>关系等级</th>
					<td>
					<select class="easyui-combobox" name="guanxi" data-options="panelHeight:'auto',editable:false" style="width: 140px;height: 30px">
							<option value="1">密切</option>
							<option value="2">友好</option>
							<option value="3">一般</option>
					</select>
					</td>
				</tr>
				<tr>
					<th>客户标签</th>
					<td>
					<select class="easyui-combobox" name="label" data-options="panelHeight:'auto',editable:false" style="width: 140px;height: 30px">
							<option value="1">已电话沟通</option>
							<option value="2">已拜访送票</option>
							<option value="3">已报出价格</option>
							<option value="4">已听体验课</option>
							<option value="5">已成交-定金</option>
							<option value="6">已成交-全款</option>
					</select>
					</td>
					<th>客户余额</th>
					<td>
					<input name="balance" type="text" placeholder="请输入余额" class="easyui-validatebox span2" >
					</td>
				</tr>
				<tr>
					<th>保护类型</th>
					<td>
					<select class="easyui-combobox" name="btype" data-options="panelHeight:'auto',editable:false" style="width: 140px;height: 30px">
							<option value="1">绝对保护</option>
							<option value="2">相对保护</option>
							<option value="3">公池</option>
					</select>
					</td>
					<th>保护开始时间</th>
					<td>
					 <input class="span2" name="createdatetime" placeholder="点击选择时间" onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss'})" readonly="readonly" />
					</td>
				</tr>
			</table>
		</form>
	</div>
</div>