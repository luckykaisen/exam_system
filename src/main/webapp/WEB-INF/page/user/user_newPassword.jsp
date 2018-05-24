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
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="/js/user/user_newPassword.js"></script>
	<title>学生在线考试系统重置密码</title>
</head>
<body>
	<div class="container">
      <form id="id_form_login" action="#" method="post" class="form-signin">
        <h2 class="form-signin-heading">设置新密码</h2>
        <input type="password" id="phone" name="password1" class="form-control" placeholder="新密码" required>
        <input type="password" id="code" name="password2" class="form-control" placeholder="新密码" required>
        <br>
        <button id="regist_id" class="btn btn-lg btn-primary btn-block" type="submit">确认</button>
      </form>
    </div> 

	
	
	
</body>
</html>