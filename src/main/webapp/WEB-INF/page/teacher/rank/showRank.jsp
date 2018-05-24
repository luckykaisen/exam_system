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
	<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
	<meta name="description" content="">
	<meta name="author" content="">
	<title>学生在线考试系统</title>

	<!-- Bootstrap core CSS -->
	<link href="/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">

	<!-- Custom styles for this template -->
	<link href="/css/dashboard.css" rel="stylesheet">
	<script src="/js/jquery-1.7.2.min.js"></script>
	<script src="/js/logout.js"></script>
	<script type="text/javascript">

        function showRank(id) {
            window.location="toExamRank?id=" + id;
        }


        $(function(){

            $.ajax({
                url : "teacher/examination/paper/rank",
                data : {"id":"${id}"},
                type : "get",
                success : function(data){
                    var html = '';
					$.each(data.rank, function(i, n){
						html += '<tr><td>'+ n.userName +'</td><td>'+ n.score +'</td><td>'+ n.rank +'</td></tr>';
					});

					$("#rank").html(html);

					$("#exam_title").text(data.themeName);
                },
                error : function(){
                    alert("错误");
                }
            });
        });
	</script>
</head>

<body>

	<jsp:include page="../../include/bar_include.jsp"></jsp:include>
	<jsp:include page="../../include/menu_include.jsp"></jsp:include>

<div id="operation" class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	<h2 class="sub-header">考试记录</h2>
	<h3 id="exam_title" class="sub-header"></h3>
	<div class="table-responsive">
		<table  class="table table-striped">
			<thead>
			<tr>
				<th>考生姓名</th>
				<th>分数</th>
				<th>排名</th>
			</tr>
			</thead>
			<tbody id = "rank">


			</tbody>
		</table>
	</div>
	<div style="position: absolute;bottom: -30px;left: 0;height: 20px;width: 100%;" align="center" id="Pagination" class="pagination"><!-- 这里显示分页 --></div>
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