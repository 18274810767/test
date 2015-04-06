<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<title>用户管理</title>
<jsp:include page="../inc.jsp"></jsp:include>
<c:if test="${fn:contains(sessionInfo.resourceList, '/customerController/editPage')}">
	<script type="text/javascript">
		$.canEdit = true;
	</script>
</c:if>
<c:if test="${fn:contains(sessionInfo.resourceList, '/customerController/delete')}">
	<script type="text/javascript">
		$.canDelete = true;
	</script>
</c:if>

<script type="text/javascript">
	var dataGrid;
	$(function() {
		dataGrid = $('#dataGrid').datagrid({
			url : '${pageContext.request.contextPath}/customerController/dataGrid',
			fit : true,
			fitColumns : false,
			border : false,
			pagination : true,
			idField : 'id',
			pageSize : 10,
			pageList : [ 10, 20, 30, 40, 50 ],
			sortName : 'name',
			sortOrder : 'asc',
			checkOnSelect : false,
			selectOnCheck : false,
			nowrap : false,
			frozenColumns : [ [ {
				field : 'id',
				title : '编号',
				width : 150,
				checkbox : true
			}, {
				field : 'name',
				title : '客户姓名',
				width : 80,
				sortable : true
			} ] ],
			columns : [ [ {
				field : 'pstatus',
				title : '保护类型',
				width : 100,
				formatter : function(value, row, index) {
					switch (value) {
					case '1':
						return '绝对保护';
					case '2':
						return '相对保护';
					case '3':
						return '公池';
					}
				}
			},{
				field : 'balance',
				title : '客户余额',
				width : 100
			},{
				field : 'courseNames',
				title : '选择课程',
				width : 100
			},{
				field : 'phone',
				title : '手机号',
				width : 100
			}, {
				field : 'userName',
				title : '客户保护人',
				width : 100
			},{
				field : 'qq',
				title : 'QQ',
				width : 100
			},{
				field : 'email',
				title : 'Email',
				width : 100
			},{
				field : 'wx',
				title : '微信号',
				width : 100
			},{
				field : 'ww',
				title : '旺旺号',
				width : 100
			},{
				field : 'laiyuan',
				title : '来源',
				width : 100,
				formatter : function(value, row, index) {
					switch (value) {
					case '0':
						return '自己的客户';
					case '1':
						return '分享过来的客户';
					case '2':
						return '转移';
					}
				}
			},{
				field : 'hangye',
				title : '所属行业',
				width : 150
			},{
				field : 'jieduan',
				title : '阶段',
				width : 100
			},{
				field : 'type',
				title : '个人或公司',
				width : 100,
				formatter : function(value, row, index) {
					switch (value) {
					case '0':
						return '个人';
					case '1':
						return '公司';
					}
				}
			},{
				field : 'adr',
				title : '住址',
				width : 100
			},{
				field : 'isGoumai',
				title : '是否购买',
				width : 100,
				formatter : function(value, row, index) {
					switch (value) {
					case '0':
						return '是';
					case '1':
						return '否';
					}
				}
			},{
				field : 'isTop',
				title : '是否热点客户',
				width : 150,
				formatter : function(value, row, index) {
					switch (value) {
					case '0':
						return '是';
					case '1':
						return '否';
					}
				}
			},{
				field : 'topFenlei',
				title : '热度分类',
				width : 100,
				formatter : function(value, row, index) {
					switch (value) {
					case '1':
						return '类别1';
					case '2':
						return '类别2';
					}
				}
			},{
				field : 'topLevel',
				title : '热度级别',
				width : 100,
				formatter : function(value, row, index) {
					switch (value) {
					case 'A1':
						return '低热';
					case 'A2':
						return '中热';
					case 'A3':
						return '高热';
					}
				}
			},{
				field : 'lCardType',
				title : '证件种类',
				width : 100,
				formatter : function(value, row, index) {
					switch (value) {
					case '1':
						return '身份证';
					case '2':
						return '户口';
					}
				}
			},{
				field : 'lCardCode',
				title : '证件号',
				width : 100
			},{
				field : 'cJiazhi',
				title : '价值等级',
				width : 100,
				formatter : function(value, row, index) {
					switch (value) {
					case '1':
						return '等级1';
					case '2':
						return '等级2';
					}
				}
			},{
				field : 'laiyuan',
				title : '客户来源',
				width : 100,
				formatter : function(value, row, index) {
					switch (value) {
					case '1':
						return '电话咨询';
					case '2':
						return 'talk99咨询';
					case '3':
						return 'QQ咨询';
					case '4':
						return '后台留言';
					case '5':
						return '独立开发';
					case '6':
						return '合作伙伴';
					case '7':
						return '转介绍';
					}
				}
			},{
				field : 'xleve',
				title : '信用等级',
				width : 100,
				formatter : function(value, row, index) {
					switch (value) {
					case '1':
						return '高';
					case '2':
						return '中';
					case '3':
						return '低';
					}
				}
			},{
				field : 'guanxi',
				title : '关系等级',
				width : 100,
				formatter : function(value, row, index) {
					switch (value) {
					case '1':
						return '密切';
					case '2':
						return '友好';
					case '3':
						return '一般';
					}
				}
			},{
				field : 'createdatetime',
				title : '保护开始时间',
				width : 150,
				sortable : true
			},  {
				field : 'action',
				title : '操作',
				width : 100,
				formatter : function(value, row, index) {
					var str = '';
					if ($.canEdit) {
						str += $.formatString('<img onclick="editFun(\'{0}\');" src="{1}" title="编辑"/>', row.id, '${pageContext.request.contextPath}/style/images/extjs_icons/pencil.png');
					}
					str += '&nbsp;';
					if ($.canDelete) {
						str += $.formatString('<img onclick="deleteFun(\'{0}\');" src="{1}" title="删除"/>', row.id, '${pageContext.request.contextPath}/style/images/extjs_icons/cancel.png');
					}
					str += '&nbsp;';
					str += $.formatString('<img onclick="grantFun(\'{0}\');" src="{1}" title="课程选择"/>', row.id, '${pageContext.request.contextPath}/style/images/extjs_icons/key.png');
					return str;
				}
			} ] ],
			toolbar : '#toolbar',
			onLoadSuccess : function() {
				$('#searchForm table').show();
				parent.$.messager.progress('close');

				$(this).datagrid('tooltip');
			},
			onRowContextMenu : function(e, rowIndex, rowData) {
				e.preventDefault();
				$(this).datagrid('unselectAll').datagrid('uncheckAll');
				$(this).datagrid('selectRow', rowIndex);
				$('#menu').menu('show', {
					left : e.pageX,
					top : e.pageY
				});
			}
		});
	});

	function deleteFun(id) {
		if (id == undefined) {//点击右键菜单才会触发这个
			var rows = dataGrid.datagrid('getSelections');
			id = rows[0].id;
		} else {//点击操作里面的删除图标会触发这个
			dataGrid.datagrid('unselectAll').datagrid('uncheckAll');
		}
		parent.$.messager.confirm('询问', '您是否要删除当前用户？', function(b) {
			if (b) {
					parent.$.messager.progress({
						title : '提示',
						text : '数据处理中，请稍后....'
					});
					$.post('${pageContext.request.contextPath}/customerController/delete', {
						id : id
					}, function(result) {
						if (result.success) {
							parent.$.messager.alert('提示', result.msg, 'info');
							dataGrid.datagrid('reload');
						}
						parent.$.messager.progress('close');
					}, 'JSON');
			}
		});
	}

	function batchDeleteFun() {
		var rows = dataGrid.datagrid('getChecked');
		var ids = [];
		if (rows.length > 0) {
			parent.$.messager.confirm('确认', '您是否要删除当前选中的项目？', function(r) {
				if (r) {
					parent.$.messager.progress({
						title : '提示',
						text : '数据处理中，请稍后....'
					});
					for ( var i = 0; i < rows.length; i++) {
							ids.push(rows[i].id);
					}
					$.getJSON('${pageContext.request.contextPath}/customerController/batchDelete', {
						ids : ids.join(',')
					}, function(result) {
						if (result.success) {
							dataGrid.datagrid('load');
							dataGrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
						}
						parent.$.messager.alert('提示', result.msg, 'info');
						parent.$.messager.progress('close');
					});
				}
			});
		} else {
			parent.$.messager.show({
				title : '提示',
				msg : '请勾选要删除的记录！'
			});
		}
	}

	function editFun(id) {
		if (id == undefined) {
			var rows = dataGrid.datagrid('getSelections');
			id = rows[0].id;
		} else {
			dataGrid.datagrid('unselectAll').datagrid('uncheckAll');
		}
		parent.$.modalDialog({
			title : '编辑客户',
			width : 500,
			height : 650,
			href : '${pageContext.request.contextPath}/customerController/editPage?id=' + id,
			buttons : [ {
				text : '编辑',
				handler : function() {
					parent.$.modalDialog.openner_dataGrid = dataGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
					var f = parent.$.modalDialog.handler.find('#form');
					f.submit();
				}
			} ]
		});
	}

	function addFun() {
		parent.$.modalDialog({
			title : '添加客户',
			width : 500,
			height : 650,
			href : '${pageContext.request.contextPath}/customerController/addPage',
			buttons : [ {
				text : '添加',
				handler : function() {
					parent.$.modalDialog.openner_dataGrid = dataGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
					var f = parent.$.modalDialog.handler.find('#form');
					f.submit();
				}
			} ]
		});
	}

	function grantFun(id) {
		dataGrid.datagrid('unselectAll').datagrid('uncheckAll');
		parent.$.modalDialog({
			title : '课程选择',
			width : 500,
			height : 300,
			href : '${pageContext.request.contextPath}/customerController/choiceCoursePage?ids=' + id,
			buttons : [ {
				text : '选择',
				handler : function() {
					parent.$.modalDialog.openner_dataGrid = dataGrid;//因为授权成功之后，需要刷新这个dataGrid，所以先预定义好
					var f = parent.$.modalDialog.handler.find('#form');
					f.submit();
				}
			} ]
		});
	}

	function searchFun() {
		dataGrid.datagrid('load', $.serializeObject($('#searchForm')));
	}
	function cleanFun() {
		$('#searchForm input').val('');
		dataGrid.datagrid('load', {});
	}
	
	function addFollow(id) {
		if (id == undefined) {
			var rows = dataGrid.datagrid('getSelections');
			id = rows[0].id;
		} else {
			dataGrid.datagrid('unselectAll').datagrid('uncheckAll');
		}
		parent.$.modalDialog({
			title : '添加客户跟踪记录',
			width : 500,
			height : 300,
			href : '${pageContext.request.contextPath}/followController/addPage?customerId='+id,
			buttons : [ {
				text : '添加',
				handler : function() {
					parent.$.modalDialog.openner_dataGrid = dataGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
					var f = parent.$.modalDialog.handler.find('#form');
					f.submit();
				}
			} ]
		});
	}
	
	function addJnr(id) {
		if (id == undefined) {
			var rows = dataGrid.datagrid('getSelections');
			id = rows[0].id;
		} else {
			dataGrid.datagrid('unselectAll').datagrid('uncheckAll');
		}
		parent.$.modalDialog({
			title : '添加纪念日',
			width : 500,
			height : 300,
			href : '${pageContext.request.contextPath}/jiNianRiController/addPage?customerId='+id,
			buttons : [ {
				text : '添加',
				handler : function() {
					parent.$.modalDialog.openner_dataGrid = dataGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
					var f = parent.$.modalDialog.handler.find('#form');
					f.submit();
				}
			} ]
		});
	}
	
	function showFun(id) {
		if (id == undefined) {
			var rows = dataGrid.datagrid('getSelections');
			id = rows[0].id;
		} else {
			dataGrid.datagrid('unselectAll').datagrid('uncheckAll');
		}

		$.easyui.showGridSelector({
	           topMost: true,
	           extToolbar: true,
	           method: "get",
	           url: "${pageContext.request.contextPath}/followController/dataGrid?customerId="+id,
	           idField: "id",
	           textField: "customerName",
	           autoShowPanel: true,
	           multiple: true,
	           remoteSort: false,
	           pagination: true,
	           columns: [[
				   { field: "id", title: "ID", width: 80, sortable: true, hidden: true },
	               { field: "customerName", title: "客户姓名", width: 120, sortable: true, filterable: false },
	               { field: "type", title: "跟踪方式", width: 120, sortable: true, filterable: false,
	   				formatter : function(value, row, index) {
						switch (value) {
						case '0':
							return '电话';
						case '1':
							return '拜访';
						}
					} },
					{ field: "isjihui", title: "是否销售机会", width: 120, sortable: true, filterable: false,
		   				formatter : function(value, row, index) {
							switch (value) {
							case '0':
								return '是';
							case '1':
								return '否';
							}
						} },
	               { field: "remark", title: "备注", width: 140, sortable: true },
	               { field: "createDatetime", title: "日期", width: 120, sortable: true }
	           ]]
	       });

	}	


	function showJnr(id) {
		if (id == undefined) {
			var rows = dataGrid.datagrid('getSelections');
			id = rows[0].id;
		} else {
			dataGrid.datagrid('unselectAll').datagrid('uncheckAll');
		}

		$.easyui.showGridSelector({
	           topMost: true,
	           extToolbar: true,
	           method: "get",
	           url: "${pageContext.request.contextPath}/jiNianRiController/dataGrid?customerId="+id,
	           idField: "id",
	           textField: "customerName",
	           autoShowPanel: true,
	           multiple: true,
	           remoteSort: false,
	           pagination: true,
	           columns: [[
				   { field: "id", title: "ID", width: 80, sortable: true, hidden: true },
	               { field: "brd", title: "生日", width: 120, sortable: true, filterable: false },
	               { field: "type", title: "阳历or阳历", width: 120, sortable: true, filterable: false,
	   				formatter : function(value, row, index) {
						switch (value) {
						case '0':
							return '阳历';
						case '1':
							return '阳历';
						}
					} },
	               { field: "name", title: "关系", width: 140, sortable: true }
	           ]]
	       });

	}	
</script>
</head>
<body>
	<div class="easyui-layout" data-options="fit : true,border : false">
		<div data-options="region:'north',title:'查询条件',border:false" style="height: 210px; overflow: hidden;">
			<form id="searchForm">
				<table class="table table-hover table-condensed" style="display: none;">
					<tr>
						<th>客户姓名</th>
						<td><input name="name" placeholder="可以模糊查询客户姓名" class="span2" /></td>
					</tr>
					<tr>
						<th>客户手机号</th>
						<td><input name="phone" placeholder="可以查询客户手机号" class="span2" /></td>
					</tr>
					<tr>
						<th>创建时间</th>
						<td><input class="span2" name="createdatetimeStart" placeholder="点击选择时间" onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss'})" readonly="readonly" />至<input class="span2" name="createdatetimeEnd" placeholder="点击选择时间" onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss'})" readonly="readonly" /></td>
					</tr>
					<tr>
						<th>最后修改时间</th>
						<td><input class="span2" name="modifydatetimeStart" placeholder="点击选择时间" onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss'})" readonly="readonly" />至<input class="span2" name="modifydatetimeEnd" placeholder="点击选择时间" onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss'})" readonly="readonly" /></td>
					</tr>
				</table>
			</form>
		</div>
		<div data-options="region:'center',border:false">
			<table id="dataGrid"></table>
		</div>
	</div>
	<div id="toolbar" style="display: none;">
		<c:if test="${fn:contains(sessionInfo.resourceList, '/customerController/addPage')}">
			<a onclick="addFun();" href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'pencil_add'">添加</a>
		</c:if>
		<c:if test="${fn:contains(sessionInfo.resourceList, '/customerController/grantPage')}">
			<a onclick="batchGrantFun();" href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'tux'">批量授权</a>
		</c:if>
		<c:if test="${fn:contains(sessionInfo.resourceList, '/customerController/batchDelete')}">
			<a onclick="batchDeleteFun();" href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'delete'">批量删除</a>
		</c:if>
		<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'brick_add',plain:true" onclick="searchFun();">过滤条件</a><a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'brick_delete',plain:true" onclick="cleanFun();">清空条件</a>
	</div>

	<div id="menu" class="easyui-menu" style="width: 120px; display: none;">
		<c:if test="${fn:contains(sessionInfo.resourceList, '/customerController/addPage')}">
			<div onclick="addFun();" data-options="iconCls:'pencil_add'">增加</div>
		</c:if>
		<c:if test="${fn:contains(sessionInfo.resourceList, '/customerController/delete')}">
			<div onclick="deleteFun();" data-options="iconCls:'pencil_delete'">删除</div>
		</c:if>
		<c:if test="${fn:contains(sessionInfo.resourceList, '/customerController/editPage')}">
			<div onclick="editFun();" data-options="iconCls:'pencil'">编辑</div>
		</c:if>
		<div onclick="showFun();" data-options="iconCls:'pencil'">客户跟踪</div>
		<div onclick="addFollow();" data-options="iconCls:'pencil'">添加客户跟踪</div>
		<div onclick="showJnr();" data-options="iconCls:'pencil'">纪念日</div>
		<div onclick="addJnr();" data-options="iconCls:'pencil'">添加纪念日</div>
	</div>
</body>
</html>