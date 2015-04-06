<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
	$(function() {
		parent.$.messager.progress('close');
		$('#form').form({
			url : '${pageContext.request.contextPath}/customerController/edit',
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
					<td><input name="name" type="text" placeholder="请输入姓名" class="easyui-validatebox span2" data-options="required:true"  value="${customer.name}"></td>
					<th>电话</th>
					<td><input name="phone" type="text" placeholder="请输入电话" class="easyui-validatebox span2" value="${customer.phone}"></td>
				</tr>
				<tr>
					<th>QQ</th>
					<td><input name="qq" type="text" placeholder="请输入QQ" class="easyui-validatebox span2" value="${customer.qq}"></td>
					<th>Email</th>
					<td><input name="email" type="text" placeholder="请输入Email" class="easyui-validatebox span2" value="${customer.email}"></td>
				</tr>
				<tr>
					<th>微信号</th>
					<td><input name="wx" type="text" placeholder="请输入微信号" class="easyui-validatebox span2"  value="${customer.wx}"></td>
					<th>旺旺号</th>
					<td><input name="ww" type="text" placeholder="请输入旺旺号" class="easyui-validatebox span2"  value="${customer.ww}"></td>
				</tr>
				<tr>
					<th>行业</th>
					<td><input name="hangye" type="text" placeholder="请输入行业" class="easyui-validatebox span2" value="${customer.hangye}"></td>
					<th>住址</th>
					<td><input name="adr" type="text" placeholder="请输入住址" class="easyui-validatebox span2" value="${customer.adr}"></td>
				</tr>
				<tr>
					<th>阶段</th>
					<td><input name="jieduan" type="text" placeholder="请输入阶段" class="easyui-validatebox span2" value="${customer.adr}"></td>
					<th>个人或公司</th>
					<td>
					<select class="easyui-combobox" name="type" data-options="panelHeight:'auto',editable:false" style="width: 140px;height: 30px">
							<option value="0" <c:if test="${customer.type == 0}">selected="selected"</c:if>>个人</option>
							<option value="1" <c:if test="${customer.type == 1}">selected="selected"</c:if>>公司</option>
					</select>
					</td>
				</tr>
				<tr>
					<th>是否购买</th>
					<td>
					<select class="easyui-combobox" name="isGoumai" data-options="panelHeight:'auto',editable:false" style="width: 140px;height: 30px">
							<option value="0" <c:if test="${customer.isGoumai == 0}">selected="selected"</c:if>>是</option>
							<option value="1" <c:if test="${customer.isGoumai == 1}">selected="selected"</c:if>>否</option>
					</select>
					</td>
					<th>是否热点</th>
					<td>
					<select class="easyui-combobox" name="isTop" data-options="panelHeight:'auto',editable:false" style="width: 140px;height: 30px">
							<option value="0" <c:if test="${customer.isTop == 0}">selected="selected"</c:if>>是</option>
							<option value="1" <c:if test="${customer.isTop == 1}">selected="selected"</c:if>>否</option>
					</select>
					</td>
				</tr>
				<tr>
					<th>热度分类</th>
					<td>
					<select class="easyui-combobox" name="topFenlei" data-options="panelHeight:'auto',editable:false" style="width: 140px;height: 30px">
							<option value="1" <c:if test="${customer.topFenlei == 1}">selected="selected"</c:if>>类别1</option>
							<option value="2" <c:if test="${customer.topFenlei == 2}">selected="selected"</c:if>>类别2</option>
					</select>
					</td>
					<th>热度级别</th>
					<td>
					<select class="easyui-combobox" name="topLevel" data-options="panelHeight:'auto',editable:false" style="width: 140px;height: 30px">
							<option value="A1" <c:if test="${customer.topLevel =='A1'}">selected="selected"</c:if>>低热</option>
							<option value="A2" <c:if test="${customer.topLevel =='A2'}">selected="selected"</c:if>>中热</option>
							<option value="A3" <c:if test="${customer.topLevel =='A3'}">selected="selected"</c:if>>高热</option>
					</select>
					</td>
				</tr>
				<tr>
					<th>证件种类</th>
					<td>
					<select class="easyui-combobox" name="LCardType" data-options="panelHeight:'auto',editable:false" style="width: 140px;height: 30px">
							<option value="1" <c:if test="${customer.LCardType ==1}">selected="selected"</c:if>>身份证</option>
							<option value="2" <c:if test="${customer.LCardType ==2}">selected="selected"</c:if>>户口</option>
					</select>
					</td>
					<th>证件号</th>
					<td>
					<input name="LCardCode" type="text" placeholder="请输入证件号" class="easyui-validatebox span2"  value="${customer.LCardCode}">
					</td>
				</tr>
				<tr>
					<th>价值等级</th>
					<td>
					<select class="easyui-combobox" name="CJiazhi" data-options="panelHeight:'auto',editable:false" style="width: 140px;height: 30px">
							<option value="1" <c:if test="${customer.CJiazhi ==1}">selected="selected"</c:if>>有需求</option>
							<option value="2" <c:if test="${customer.CJiazhi ==2}">selected="selected"</c:if>>有消费决策权</option>
							<option value="3" <c:if test="${customer.CJiazhi ==3}">selected="selected"</c:if>>有消费能力</option>
							<option value="4" <c:if test="${customer.CJiazhi ==4}">selected="selected"</c:if>>有意向度</option>
					</select>
					</td>
					<th>客户来源</th>
					<td>
					<select class="easyui-combobox" name=laiyuan data-options="panelHeight:'auto',editable:false" style="width: 140px;height: 30px">
							<option value="1" <c:if test="${customer.laiyuan ==1}">selected="selected"</c:if>>电话咨询</option>
							<option value="2" <c:if test="${customer.laiyuan ==2}">selected="selected"</c:if>>talk99咨询</option>
							<option value="3" <c:if test="${customer.laiyuan ==3}">selected="selected"</c:if>>QQ咨询</option>
							<option value="4" <c:if test="${customer.laiyuan ==4}">selected="selected"</c:if>>后台留言</option>
							<option value="5" <c:if test="${customer.laiyuan ==5}">selected="selected"</c:if>>独立开发</option>
							<option value="6" <c:if test="${customer.laiyuan ==6}">selected="selected"</c:if>>合作伙伴</option>
							<option value="7" <c:if test="${customer.laiyuan ==7}">selected="selected"</c:if>>转介绍</option>
					</select>
					</td>
				</tr>
				<tr>
					<th>信用等级</th>
					<td>
					<select class="easyui-combobox" name="xleve" data-options="panelHeight:'auto',editable:false" style="width: 140px;height: 30px">
							<option value="1" <c:if test="${customer.xleve ==1}">selected="selected"</c:if>>高</option>
							<option value="2" <c:if test="${customer.xleve ==2}">selected="selected"</c:if>>中</option>
							<option value="3" <c:if test="${customer.xleve ==3}">selected="selected"</c:if>>低</option>
					</select>
					</td>
					<th>关系等级</th>
					<td>
					<select class="easyui-combobox" name="guanxi" data-options="panelHeight:'auto',editable:false" style="width: 140px;height: 30px">
							<option value="1" <c:if test="${customer.guanxi ==1}">selected="selected"</c:if>>密切</option>
							<option value="2" <c:if test="${customer.guanxi ==2}">selected="selected"</c:if>>友好</option>
							<option value="3" <c:if test="${customer.guanxi ==3}">selected="selected"</c:if>>一般</option>
					</select>
					</td>
				</tr>
				<tr>
					<th>客户标签</th>
					<td>
					<select class="easyui-combobox" name="label" data-options="panelHeight:'auto',editable:false" style="width: 140px;height: 30px">
							<option value="1" <c:if test="${customer.label ==1}">selected="selected"</c:if>>已电话沟通</option>
							<option value="2" <c:if test="${customer.label ==2}">selected="selected"</c:if>>已拜访送票</option>
							<option value="3" <c:if test="${customer.label ==3}">selected="selected"</c:if>>已报出价格</option>
							<option value="4" <c:if test="${customer.label ==4}">selected="selected"</c:if>>已听体验课</option>
							<option value="5" <c:if test="${customer.label ==5}">selected="selected"</c:if>>已成交-定金</option>
							<option value="6" <c:if test="${customer.label ==6}">selected="selected"</c:if>>已成交-全款</option>
					</select>
					</td>
					<th>客户余额</th>
					<td>
					<input name="balance" type="text" placeholder="请输入余额" class="easyui-validatebox span2" value="${customer.balance}">
					</td>
				</tr>
				<tr>
					<th>保护类型</th>
					<td>
					<select class="easyui-combobox" name="btype" data-options="panelHeight:'auto',editable:false" style="width: 140px;height: 30px">
							<option value="1" <c:if test="${customer.btype==1}">selected="selected"</c:if>>绝对保护</option>
							<option value="2" <c:if test="${customer.btype==2}">selected="selected"</c:if>>相对保护</option>
							<option value="3" <c:if test="${customer.btype==3}">selected="selected"</c:if>>公池</option>
					</select>
					</td>
					<th>保护开始时间</th>
					<td>
					<input class="span2" name="createdatetime" placeholder="点击选择时间" onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss'})" readonly="readonly"  value="${customer.createdatetime}"/>
					</td>
				</tr>
			</table>
		</form>
	</div>
</div>