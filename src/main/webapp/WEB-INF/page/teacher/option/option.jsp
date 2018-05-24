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
	<script src="/js/jquery-1.7.2.min.js"></script>
	<script src="/js/logout.js"></script>
	<script type="text/javascript">

        // 添加试题
        function addItem(id) {
            window.location="toAddItem?id=" + id;
        }

        // 隐藏试题
        function hideItem(id) {
            $.ajax({
                url : "teacher/item/hide",
                data : {"id" : id},
                type : "get",
                success : function(data){
                    location.reload();
                },
                error : function(){
                    alert("错误");
                }
            });
        }

        $(function(){

            // 查询已录试题
            $.ajax({
                url : "teacher/item/search",
                data : {"pageNumber":1,"pageSize":1000,"sectionId":"${sectionId}"},
                type : "post",
                success : function(data){
                    var html = '';
					$.each(data.items, function(i, n){
					    if (n.delete == 'Y') {
                            html += '<tr><td>题目: '+ n.name +'(已隐藏)</td></tr>';
						} else {
                            html += '<tr><td>题目: '+ n.name +'</td><td><button onclick=hideItem('+n.id+')>隐藏试题</button></td></tr>';
						}

						$.each(n.options, function(i, n) {
						    if (n.answer == 'Y') {
                                html += '<tr><td style="color:green">'+ (i+1)+ ' 、' +n.name+'</td></tr>';
							} else {
                                html += '<tr><td>'+ (i+1)+ ' 、' + n.name +'</td></tr>';
							}
						});
                        html += '<tr><td>--------------------------------------------------------------------------------</td></tr>';
                    });
					$("#option").html(html);

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
	<h2 class="sub-header">试题录入</h2>
	<div class="table-responsive">
		<table  class="table table-striped">
			<thead>
			<tr>
				<th>试题</th>
				<th><button onclick="javascript:addItem(${sectionId})">添加试题</button></th>
			</tr>
			</thead>
			<tbody id = "option">


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