<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="java.util.Date,
	adf.models.Admin"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<%
	Boolean isLoggedIn = (Boolean)session.getAttribute("isLoggedIn");
	if(isLoggedIn != null && isLoggedIn) {
		System.out.println("FROM: Login.jsp -> " + isLoggedIn);
		response.sendRedirect("a/dashboard");
	} else {
		System.out.println("FROM: Login.jsp -> " + isLoggedIn);
		System.out.println("Failed To Redirect - isLoggedIn: " + isLoggedIn);
	}
%>
<html lang="ar-EG">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Cache-Control" Content="no-cache">
<meta http-equiv="Pragma" Content="no-cache">
<meta http-equiv="Expires" Content="0">
<title>منظومة الارشيف العام | تسجيل الدخول</title>
<link href="vendors/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="vendors/bootstrap-rtl/dist/css/bootstrap-rtl.min.css"
	rel="stylesheet">
<link href="vendors/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<link href="vendors/nprogress/nprogress.css" rel="stylesheet">
<link href="vendors/animate.css/animate.min.css"
	rel="stylesheet">
<link href="vendors/css/custom.css" rel="stylesheet">
<link href="vendors/css/plugin.css" rel="stylesheet">
</head>

<body class="login">
	<div>
	<p>
	<%--	out.println("IP Address: " + request.getRemoteAddr());
		out.println("Host: " + request.getRemoteHost());
		out.println("Session ID:" + request.getRequestedSessionId());
		out.println("Request URL" + request.getRequestURL());
		out.println("Port:" + request.getRemotePort());
		out.println("x-forwarded-for: " + request.getHeader("x-forwarded-for")); --%>
	</p>
		<div class="login_wrapper">
			<div class="animate form login_form">
				<section class="login_content">
					<form action="validate" method="post">
						<h1>
							<img src="vendors/images/logo.png" class="img-circle" alt="">
						</h1>
						<h4
							style="margin-top: 15px; margin-bottom: 15px; line-height: 1.6;"
							class="text-center">مرحبا بكم فى منظومة الارشيف العام برجاء تسجيل الدخول لادارة المنظومة</h4>
						<div>
							<input type="text" name="username" class="form-control"
								placeholder="اسم المستخدم" required="required" autofocus="autofocus"
								oninvalid="this.setCustomValidity('من فضلك ادخل اسم المستخدم')"
								oninput="setCustomValidity('')"/>
						</div>
						<div>
							<input type="password" name="password" class="form-control"
								placeholder="كلمة المرور" required="required" />
						</div>
						<c:if test="${param['error'] eq 1}">
							<span style="color: red;">اسم
							المستخدم  أو كلمة المرور غير صحيحة<br><br></span>
						</c:if>
						
						<%--
						
						 	request.setCharacterEncoding("UTF-8");
						 	response.setCharacterEncoding("UTF-8");
							String errorCode = request.getParameter("error");
							if(m!=null) x = Integer.parseInt(m);
							if(x == 0) {
								
						
						<span style="color: red;" error_code="1">اسم
							المستخدم  أو كلمة المرور غير صحيحة<br></span>
						<% } %> --%>
						
						<span style="color: red" error_code="2" hidden>كلمة السر
							غير صحيحة</span>
						<div>
							<input type="submit" value="تسجيل الدخول"
								class="btn btn-success submit">
						</div>

						<div class="clearfix"></div>

						<div class="separator">
							<div class="clearfix"></div>
							<br />
							<div>
								<p>© 2018 - تصميم وتنفيذ فرع نظم المعلومات د جو</p>
							</div>
						</div>
					</form>
				</section>
			</div>
		</div>
	</div>
</body>
</html>