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
	<script src="/js/logout.js"></script>
	<script type="application/javascript">

        function add() {
            var divs = $(".form-group[name='itemDiv']");


            var options = [];
            $.each(divs, function(i, n){

                var item = $(this).children("[name=item]");
                var answer = $(this).children("[name='answer']").is(":checked");

                var option = new Object();
                option.name = item.val();
                if (answer) {
                    option.answer = "Y";
                } else {
                    option.answer = "N";
                }
                options.push(option);
            });

            var status = $("#itemStatus option:selected").val();
            var itemName = $("#itemName").val();
            var sectionId = "${sectionId}";

            $.ajax({
                url : "teacher/item/create",
                data : JSON.stringify({"name" : itemName, "status" : status, "sectionId" : sectionId, "options" : options}),
                type : "post",
                contentType : "application/json",
                success : function(data){
                    window.location = "toSection";
                },
                error : function(){
                    alert("错误");
                }
            });
        }

        function select_item(status) {

            if (status.value == 1) {
                $("#addItem").html("");
                $("#addItem").append('<div class="form-group" name="itemDiv">' +
                    '<input type="text" class="form-control" name="item" placeholder="答案" >' +
                    '<input type="checkbox" name="answer" value="0"/>' +
                    '</div><div class="form-group" name="itemDiv">' +
                    '<input type="text" class="form-control" name="item" placeholder="答案" >' +
                    '<input type="checkbox" name="answer" value="1"/>' +
                    '</div><div class="form-group" name="itemDiv">' +
                    '<input type="text" class="form-control" name="item" placeholder="答案" >' +
                    '<input type="checkbox" name="answer" value="2"/>' +
                    '</div><div class="form-group" name="itemDiv">' +
                    '<input type="text" class="form-control" name="item" placeholder="答案" >' +
                    '<input type="checkbox" name="answer" value="3"/>' +
                    '</div><div class="form-group" name="itemDiv">' +
                    '<input type="text" class="form-control" name="item" placeholder="答案" >' +
                    '<input type="checkbox" name="answer" value="4"/>' +
                    '</div><div class="form-group" name="itemDiv">' +
                    '<input type="text" class="form-control" name="item" placeholder="答案" >' +
                    '<input type="checkbox" name="answer" value="5"/>' +
                    '</div>');
            }

            if (status.value == 2){
                $("#addItem").html("");
                $("#addItem").append('<div class="form-group" name="itemDiv">' +
                    '<input type="text" class="form-control" name="item" placeholder="答案" >' +
                    '<input type="radio" name="answer"/>' +
                    '</div><div class="form-group" name="itemDiv">' +
                    '<input type="text" class="form-control" name="item" placeholder="答案" >' +
                    '<input type="radio" name="answer"/>' +
                    '</div><div class="form-group" name="itemDiv">' +
                    '<input type="text" class="form-control" name="item" placeholder="答案" >' +
                    '<input type="radio" name="answer"/>' +
                    '</div><div class="form-group" name="itemDiv">' +
                    '<input type="text" class="form-control" name="item" placeholder="答案" >' +
                    '<input type="radio" name="answer"/>' +
                    '</div>');
            }

            if (status.value == 3){
                $("#addItem").html("");
                $("#addItem").append('<div class="form-group" name="itemDiv">' +
                    '<input type="text" class="form-control" name="item" placeholder="答案" >' +
                    '<input type="radio" name="answer"/>' +
                    '</div>' +
                    '<div class="form-group" name="itemDiv">' +
                    '<input type="text" class="form-control" name="item" placeholder="答案" >' +
                    '<input type="radio" name="answer"/>' +
                    '</div>');
            }
        }

        $(function(){

            // 查询已录试题
            $.ajax({
                url : "resource/service/item/status",
                data : "",
                type : "get",
                success : function(data){
                    $.each(data, function(i, n) {
                        $("#itemStatus").append('<option value='+ n.id +'>'+ n.label +'</option>');
                    });
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

		<div class="form-group">
			<label for="exampleInputAmount">试题录入</label>
			<input type="text" class="form-control" id="itemName" placeholder="试题名称" >
		</div>


		试题类型 : <select id="itemStatus" onchange="select_item(this)"></select>


		<form id="addItem">


		</form>
		<div class="form-group">
			<button class="btn btn-success" onclick="javascript:add();">提交</button>
		</div>
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