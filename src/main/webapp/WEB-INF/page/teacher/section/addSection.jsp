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
	<script src="/js/jquery-1.7.2.min.js"></script>
	<link href="/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
	<link href="/css/dashboard.css" rel="stylesheet">
	<script src="/js/logout.js"></script>
	<script src="/js/teacher/section/addSection.js"></script>
</head>

<body>
	<jsp:include page="../../include/bar_include.jsp"></jsp:include>
	<jsp:include page="../../include/menu_include.jsp"></jsp:include>

<div id="operation" class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	<h2 class="sub-header">章节添加</h2>
	<div class="table-responsive">
		<label for="exampleInputAmount">学科</label><br>
		<select id="id_subject" style="width: 100px" >
		</select>
		<form>
			<div class="form-group">
				<div class="col-xs-3">
					<label for="exampleInputAmount">章节名称</label>
					<input type="text" class="form-control" id="sectionName" placeholder="章节名称" >
				</div>
			</div>

			<button class="btn btn-success" onclick="javascript:add();">提交</button>
		</form>
	</div>
	<div style="position: absolute;bottom: -30px;left: 0;height: 20px;width: 100%;" align="center" id="Pagination" class="pagination"><!-- 这里显示分页 --></div>
</div>
</div>
<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->

<!-- Just to make our placeholder images work. Don't actually copy the next line! -->
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
</body>
</html>