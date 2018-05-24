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
	<link href="/css/dashboard.css" rel="stylesheet">
	<script src="/js/jQuery3.3.1.js"></script>
	<script src="/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
	<script src="/js/logout.js"></script>
	<script type="application/javascript">
		var subject_id;
		$(function () {

        });

        /**
		 * 添加学科
         */
		function add_subject() {
			var subjectName = $("#subject_name").val();
			var disciplineCode = $("input[name='discipline']:checked").val();

			if (subjectName == "") {
				alert("请输入学科名称");
				return false;
			} else if (disciplineCode == "") {
                alert("请选择科目");
                return false;
			}

            $.ajax({
                url : "subject/create",
                data : JSON.stringify({"subjectName" : subjectName, "disciplineCode" : disciplineCode}),
                type : "post",
				contentType : "application/json",
                success : function(data){
                    alert(data.message);
                    window.location = "toSubject";
                },
                error : function(){
                    alert("错误");
                }
            });
        }

	</script>
</head>

<body>
	<jsp:include page="../../include/bar_include.jsp"></jsp:include>
	<jsp:include page="../../include/menu_include.jsp"></jsp:include>

<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	<h2 class="sub-header">学科管理修改</h2>
	<form class="form-horizontal">
		<div class="form-group">
			<label class="col-sm-1 control-label">学科名称</label>
			<div class="col-xs-3">
				<input type="text" class="form-control" id="subject_name" placeholder="学科名称">
			</div>
		</div>
		<label class="col-sm-1 control-label">
			<input type="radio" name="discipline" value="ARTS"> 文科
		</label>
		<label class="col-sm-1 control-label">
			<input type="radio" name="discipline" value="SCIENCE"> 理科
		</label>
		<button type="submit" class="btn btn-success" onclick="add_subject()">添加</button>
	</form>
</div>
</div>
<script src="/js/holder.min.js"></script>
<script src="/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>