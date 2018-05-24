<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isELIgnored="false"  %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="<%=basePath %>">
	<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
	<link  rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
	<link rel="stylesheet" href="css/login.css">
	<script type="text/javascript" src="rap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script src="/js/user/user_regist.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>学生在线考试系统注册</title>
</head>
<body>
<input type="hidden" name="token" value="${token}"/>
	<div class="container">
      <form id="id_form_login" action="#" method="post" class="form-signin">
        <h2 class="form-signin-heading">注册</h2>
        <input type="text" id="username" name="username" class="form-control" placeholder="姓名" required autofocus>
        <input type="password" id="inputPassword" name="password" class="form-control" placeholder="密码" required>
        <input type="password" id="inputPassword2" class="form-control" placeholder="请重复密码" required>
        <input type="text" id="phone" name="phone" class="form-control" placeholder="手机号" required>
        <input type="text" id="email" name="email" class="form-control" placeholder="邮箱" required>
        <br>
        <button id="regist_id" class="btn btn-lg btn-primary btn-block" type="submit">注册</button>
      </form>
    </div> 

</body>
</html>