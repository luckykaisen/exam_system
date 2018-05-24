<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isELIgnored="false"  %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>学生在线考试系统</title>
	<link href="/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
	<link href="/css/page.css" rel="stylesheet">
	<link href="/css/dashboard.css" rel="stylesheet">
	<script src="/js/jquery-1.7.2.min.js"></script>
	<script src="/js/paging.js"></script>
	<script src="/js/logout.js"></script>
	<script src="/js/teacher/paper/paper.js"></script>
</head>

<body>

	<jsp:include page="../../include/bar_include.jsp"></jsp:include>
	<jsp:include page="../../include/menu_include.jsp"></jsp:include>
<div id="operation" class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	<h2 class="sub-header">试卷</h2>
	<div class="table-responsive">
		<button class="btn btn-success" onclick="javascript:window.location = 'addPaper';">添加试卷</button>
		<table  class="table table-striped">
			<thead>
			<tr>
				<th>id</th>
				<th>考试名称</th>
				<th>学科</th>
				<th>操作</th>
			</tr>
			</thead>
			<tbody id = "rank">


			</tbody>
		</table>
	</div>
	<div align="center" id="page"  class="page_div"><!-- 这里显示分页 --></div>
</div>
</div>
<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->

<!-- Just to make our placeholder images work. Don't actually copy the next line! -->
<script src="/js/holder.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>