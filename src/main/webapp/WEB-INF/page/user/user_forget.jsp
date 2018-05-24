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
	<script type="text/javascript" src="/js/jquery-1.7.2.min.js"></script>
	<link  rel="stylesheet" href="/bootstrap-3.3.7-dist/css/bootstrap.min.css">
	<link rel="stylesheet" href="/css/login.css">
	<script type="text/javascript" src="/rap-3.3.7-dist/js/bootstrap.min.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="/js/user/user_forget.js"></script>
	<title>学生在线考试系统忘记密码</title>
</head>
<body>
	<div class="container">
      <form id="id_form_login" action="user_regist.do" method="post" class="form-signin">
        <h2 class="form-signin-heading">找回密码</h2>
        <input type="text" id="phone" name="phone" class="form-control" placeholder="手机号" required><button id="get_code_id">获取验证码</button>
        <input type="text" id="code" name="code" class="form-control" placeholder="验证码" required>
        <br>
        <button id="regist_id" class="btn btn-lg btn-primary btn-block" type="submit">确认</button>
      </form>
    </div> 

	
	
	
</body>
</html>