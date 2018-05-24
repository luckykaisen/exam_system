<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isELIgnored="false"  %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<style>
		*{ margin:0; padding:0; list-style:none;}
		body{ font-size:18px; text-align:center;}
		.time{ height:30px; padding:200px;}
	</style>
	<title>学生在线考试系统</title>
	<link href="/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
	<link href="/css/dashboard.css" rel="stylesheet">
	<script src="/js/jquery-1.7.2.min.js"></script>
	<script src="/js/logout.js"></script>
	<script type="text/javascript">

        // 交卷
        function end_paper() {
		    var divs = $("div[name='itemDiv']");



			var options = [];
		    $.each(divs, function(i, n) {

		        var result = new Object();

				// 选项
                var option = [];
				var paperOptionId = $(this).children("[name='paperOptionId']").val();

                var results = $(this).children("[name^='options']:checked");

				$.each(results, function(i, n){
                    option.push($(this).val());
				});

				result.optionId=option;
				result.paperOptionId=paperOptionId;

				options.push(result);
			});



		    var examinationPaperId = $("#examinationPaperId").val();

		    if (examinationPaperId == null) {
				return false;
			} else {
                $.ajax({
                    url : "student/examination/paper/option/create",
                    data : JSON.stringify({"options":options,"examinationPaperId":examinationPaperId}),
                    type : "post",
					contentType : "application/json",
                    success : function(data){

                        alert("交卷成功");
                        window.location = "toMenu";
                    }
                });
			}
		}

        // 随机出题
        function create_item() {
			var themeId = "${themeId}";
			$.ajax({
                url : "student/examination/paper/create",
                data : {"themeId" : themeId},
                type : "get",
                success : function(data){

                    $("#examinationPaperId").val(data.examinationPaperId);

                    var html = '';
                    $.each(data.items, function(i, n) {
                        // 多选题
						if (n.itemStatus == 'MULTIPLE_CHOICE') {
							html += '<div class="form-group" name="itemDiv">' +
								'<input type="hidden" name="itemId" value='+ n.itemId +'>' +
                                i + '、题目： <input type="text" class="form-control" name="itemName" placeholder="题目" readonly="true" value='+ n.itemName +'>' +
                                '<input type="hidden" name="paperOptionId" value='+ n.paperOptionId +'>';


							$.each(n.options, function (a, z) {

                                var tag = '';
                                if (a == 0) {
                                    tag = 'A';
                                } else if (a == 1) {
                                    tag = "B";
                                } else if (a == 2) {
                                    tag = "C";
                                } else if (a == 3) {
                                    tag = "D";
                                } else if (a == 4) {
									tag = "E";
								} else if (a == 5) {
                                    tag = "F";
								}

                                html += tag + '、' + z.name + ' <input type="checkbox" name="options'+ n.itemId +'" value='+ z.id +'>&nbsp;';
							});

							html += '</div>';
						}

						if (n.itemStatus == 'SINGLE_CHOICE' || n.itemStatus == 'TRUE_OR_FALSE') {
							html += '<div class="form-group" name="itemDiv">' +
								'<input type="hidden" name="itemId" value='+ n.itemId +'>' +
                                '题目： <input type="text" class="form-control" name="itemName" placeholder="题目" readonly="true" value='+ n.itemName +'>' +
                                '<input type="hidden" name="paperOptionId" value='+ n.paperOptionId +'>';

							$.each(n.options, function (a, z) {
								var tag = '';
								if (a == 0) {
								    tag = 'A';
								} else if (a == 1) {
								    tag = "B";
								} else if (a == 2) {
								    tag = "C";
								} else if (a == 3) {
								    tag = "D";
								}

                                html += tag + '、' + z.name + ' <input type="radio" name="options'+ n.itemId +'" value='+ z.id +'>&nbsp;';
							});

							html += '</div>';
						}
					});

                    $("#item").html(html);
                },
                error : function(){
                    alert("该试卷已完成");
                    window.location="exam";
                }
            });
		}

        $(function(){

            create_item();

        });



	</script>
</head>

<body>

	<jsp:include page="../include/bar_include.jsp"></jsp:include>
	<jsp:include page="../include/menu_include.jsp"></jsp:include>
		<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<h2 class="sub-header">Section title</h2>

			<div class="time">
				<span id="t_h">00时</span>
				<span id="t_m">00分</span>
				<span id="t_s">00秒</span>
			</div>

			<div class="table-responsive">
				<table class="table table-striped">
					<input type="hidden" id="examinationPaperId">
					<tbody id = "item">


					</tbody>

				</table>
			</div>
			<input type="button" value="交卷" onclick="end_paper()">
			<div align="center" id="page"  class="page_div"><!-- 这里显示分页 --></div>
		</div>
	</div>
</div>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script type="application/javascript">
    var EndTime = new Date();
    var no = new Date();
    EndTime.setMinutes(no.getMinutes()+40);

    function GetRTime(){
        // var = new Date('2014/06/20 00:00:00');

        var NowTime = new Date();
        var t =EndTime.getTime() - NowTime.getTime();
        var h=Math.floor(t/1000/60/60%24);
        var m=Math.floor(t/1000/60%60);
        var s=Math.floor(t/1000%60);

        document.getElementById("t_h").innerHTML = h + "时";
        document.getElementById("t_m").innerHTML = m + "分";
        document.getElementById("t_s").innerHTML = s + "秒";
    }
    setInterval(GetRTime,0);

//function GetRTime(){
//    var EndTime= new Date('2019/06/20 00:00:00');
//    var NowTime = new Date();
//    var t =EndTime.getTime() - NowTime.getTime();
//    var h=Math.floor(t/1000/60/60%24);
//    var m=Math.floor(t/1000/60%60);
//    var s=Math.floor(t/1000%60);
//
//    document.getElementById("t_h").innerHTML = h + "时";
//    document.getElementById("t_m").innerHTML = m + "分";
//    document.getElementById("t_s").innerHTML = s + "秒";
//}
//setInterval(GetRTime,0);

</script>

<!-- Just to make our placeholder images work. Don't actually copy the next line! -->
<script src="/js/holder.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>