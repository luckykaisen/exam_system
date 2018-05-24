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
    <title>学生在线考试系统</title>

    <link href="/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/dashboard.css" rel="stylesheet">
    <script type="text/javascript">
        $(function () {
            $(".active").attr("class", "");

            $("#${correntMenu}").attr("class", "active");
        });
    </script>
</head>
<body>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <c:if test="${user.userStatus.code == 'STUDENT'}">
                    <li id="menu_exam"><a href="exam">开始考试<span class="sr-only">(current)</span></a></li>
                    <li id="menu_score"><a href="toShowScore">查看成绩</a></li>
                </c:if>
                <c:if test="${user.userStatus.code == 'TEACHER'}">
                    <li id="menu_rank"><a href="toRank">排名 <span class="sr-only">(current)</span></a></li>
                    <li id="menu_section"><a href="toSection">章节管理</a></li>
                    <li id="menu_subject"><a href="toSubject">学科管理</a></li>
                    <li id="menu_paper"><a href="toPaper">组卷<span class="sr-only">(current)</span></a></li>
                </c:if>
                <c:if test="${user.userStatus.code == 'ADMIN'}">
                    <li id="menu_score"><a href="toShowScore">查看成绩<span class="sr-only">(current)</span></a></li>
                    <li id="menu_exam"><a href="exam">开始考试</a></li>
                    <li id="menu_rank"><a href="toRank">排名</a></li>
                    <li id="menu_section"><a href="toSection">章节管理</a></li>
                    <li id="menu_subject"><a href="toSubject">学科管理</a></li>
                    <li id="menu_paper"><a href="toPaper">组卷</a><span class="sr-only">(current)</span></li>
                </c:if>
            </ul>
        </div>

    </div>
</div>

</body>
</html>