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
	<script type="text/javascript">

        function update_paper() {
            var id = $("#id_paper_id").val();
            var name = $("#id_paper_name").val();
            var minute = $("#id_minute").val();

            var sectionIds = [];
            var check = $("[type='checkbox']:checked");

            $.each(check, function (i, n) {
                sectionIds.push($(this).val());
            });

            $.ajax({
                url : "teacher/examination/theme/modify",
                data : JSON.stringify({"id" : id, "themeName" : name, "minute" : minute, "sectionIds" : sectionIds}),
                type : "post",
				contentType : "application/json",
                success : function(data){
                    if (data.message == '成功') {
                        window.location="toPaper";
                    } else {
                        alert(data.message);
                    }
                },
                error : function(){
                    alert("错误");
                }
            });
        }

		function searchPaperDetail(id) {
            $.ajax({
                url : "teacher/examination/theme/detail",
                data : {"id" : id},
                type : "get",
                success : function(data){
                    var detail = data.detail;
                    $("#id_paper_id").val(detail.id);
                    $("#id_paper_name").val(detail.themeName);
                    $("#id_subject").val(detail.subjectName);
                    $("#id_minute").val(detail.minute);

                    var sectionIds = data.detail.sections;
                    $.ajax({
                        url : "teacher/section/search",
                        data : {"subjectId" : detail.subjectId, "pageSize":1000, "pageNumber":1},
                        type : "post",
                        success : function(data){
                            $.each(data.sections, function(i, n) {
								if (jQuery.inArray(n.id, sectionIds) != -1) {
                                    $("#section").append('<div class="checkbox">' +
                                        '<label>'+
                                        '<input type="checkbox" value="'+ n.id +'" checked="checked">'+
                                        n.sectionName +
                                        '</label>'+
                                        '</div>');
								} else {
                                    $("#section").append('<div class="checkbox">' +
                                        '<label>'+
                                        '<input type="checkbox" value="'+ n.id +'">'+
                                        n.sectionName +
                                        '</label>'+
                                        '</div>');
								}

                            });
                        }
                    });

                    $.each(sections, function(i, n){
						$("#section").append('<div class="checkbox">' +
                            '<label>'+
                            '<input type="checkbox" value="'+ n.id +'">'+
                            n.sectionName +
                            '</label>'+
                            '</div>');
					});


                },
                error : function(){
                    alert("错误");
                }
            });
        }

        $(function(){
			searchPaperDetail("${id}");
        });
	</script>
</head>

<body>

	<jsp:include page="../../include/bar_include.jsp"></jsp:include>
	<jsp:include page="../../include/menu_include.jsp"></jsp:include>
<div id="operation" class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	<h2 class="sub-header">试卷</h2>
	<div id="paper" class="table-responsive">
		<input type="hidden" id="id_paper_id">
		<div class="input-group input-group-sm">
			<span class="input-group-addon" >试卷名称</span>
			<input type="text" class="form-control" id="id_paper_name" placeholder="Username" aria-describedby="sizing-addon3">
		</div><br/>
		<div class="input-group input-group-sm">
			<span class="input-group-addon">学科</span>
			<input type="text" class="form-control" id="id_subject" placeholder="Username" aria-describedby="sizing-addon3" readonly="readonly">
		</div><br/>
		<div class="input-group input-group-sm">
			<span class="input-group-addon" >考试时间</span>
			<input type="text" class="form-control" placeholder="Username" id="id_minute" aria-describedby="sizing-addon3">
		</div><br/>
		<div id="section" class="has-success">

		</div>
		<button type="button" class="btn btn-success" onclick="update_paper()">提交</button>
	</div>
</div>
<script src="/js/holder.min.js"></script>
<script src="/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>