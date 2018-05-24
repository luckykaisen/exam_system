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
            $.ajax({
                url : "subject/search",
                data : {"id" : "${id}"},
                type : "get",
                success : function(data){
                   	var subject = data.subject;
                    subject_id = subject.id;
                   	$("#id_subject_name").val(subject.name);

                   	if (subject.disciplineTypeCode == "ARTS") {
                        $("#arts").attr("checked", "checked");
					} else {
                        $("#science").attr("checked", "checked");
					}
                },
                error : function(){
                    alert("错误");
                }
            });
        });
		
		function update_subject() {
            var name = $("#id_subject_name").val();
            var disciplineCode = $("input[name='discipline']:checked").val();

            $.ajax({
                url : "subject/modify",
                data : JSON.stringify({"id" : subject_id, "subjectName" : name, "disciplineCode" : disciplineCode}),
                type : "post",
				contentType : "application/json",
                success : function(data){
                    alert("修改成功");
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
	<form>
		<div class="input-group input-group-sm">
			<span class="input-group-addon" >学科名称</span>
			<input type="text" class="form-control" id="id_subject_name" placeholder="Username" aria-describedby="sizing-addon3">
		</div><br><br>
		文科： <input id="arts" type="radio" name="discipline" value="ARTS"><br><br>
		理科： <input id="science" type="radio" name="discipline" value="SCIENCE"><br><br>
		<button type="button" class="btn btn-success" onclick="update_subject()">修改</button>
	</form>
</div>
</div>
<script src="/js/holder.min.js"></script>
<script src="/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>