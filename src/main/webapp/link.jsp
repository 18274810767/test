<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>SyPro</title>
<jsp:include page="inc.jsp"></jsp:include>
</head>
<body class="hero-unit">
	<div >
		<h1>飞扬演说运营系统</h1>
		<div>
			<ul>
				<li>作者：谭楚柱</li>
				<li>前台由EasyUI1.3.3编写，后台是JAVA语言编写，应用框架spring mvc+hibernate4+maven</li>
			</ul>
		</div>
		<p>
			<a class="btn btn-primary btn-large" href="${pageContext.request.contextPath}/index.jsp" target="_blank"> 进入</a>
		</p>
	</div>
	
</body>
</html>