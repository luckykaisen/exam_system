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
	<script src="/bootstrap-3.3.7-dist/js/bootstrap.js>"></script>
	<script src="/js/paging.js"></script>
	<script src="/js/logout.js"></script>
	<script type="application/javascript">

        /**
         * 根据id删除学科
         * @param id
         */
        function deleteSubject(id) {
            if (confirm("确认删除吗？")) {
                $.ajax({
                    url : "subject/delete",
                    data : {"id" : id},
                    type : "get",
                    success : function(data){
                        alert(data.message);
                        window.location = "toSubject";
                    },
                    error : function(){
                        alert("错误");
                    }
                });
            }
        }

        function search_subject(pageNumber) {
            $.ajax({
                url : "resource/service/subject",
                data : "",
                type : "get",
                success : function(data){
					var html = '';
					$.each(data, function (i, n) {
						html += '<tr><td>'+ n.label +'</td><td><a href=toModifySubject?id='+ n.id +'>修改</a></td></tr>';
                    });

					$("#subject").html(html);
                },
                error : function(){
                    alert("错误");
                }
            });
        }

        $(function () {
			search_subject(1);
        });
        /**
		 * 添加学科
         */
        function add_subject() {
			window.location = "toAddSubject";
        }


	</script>
</head>

<body>

	<jsp:include page="../../include/bar_include.jsp"></jsp:include>
	<jsp:include page="../../include/menu_include.jsp"></jsp:include>
<div id="operation" class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	<h2 class="sub-header">学科管理</h2>
	<div class="table-responsive">
		<button type="button" class="btn btn-success" onclick="add_subject()">添加学科</button><br/><br/>
		<table class="table table-bordered">
			<thead>
			<tr>
				<th>学科名称</th>
				<th>修改</th>
			</tr>
			</thead>
			<tbody id = "subject">

			</tbody>
		</table>
	</div>
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