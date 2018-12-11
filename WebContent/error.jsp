<%@page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
	
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ar" dir="rtl">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>404 HTML Template by Colorlib</title>

<!-- Custom stlylesheet -->
<link type="text/css" rel="stylesheet" href="../vendors/css/erstl.css" />
<link type="text/css" rel="stylesheet" href="vendors/css/erstl.css" />

</head>
<c:set var="httpStatusCode" value="<%= response.getStatus() %>"/>

<body>
	<div id="http-error">
		<div class="http-error">
			<div class="http-error-code">
				<!-- Empty <div> will be used as a square container (i.e. sign board) -->
				<div></div>
				<h1>${httpStatusCode}</h1>
			</div>
			
			<c:choose>					
				<c:when test="${httpStatusCode eq 401}">
						<c:set var="errorTitle">غير مسموح بالدخول</c:set>
						<c:set var="errorDescription">عذراّ! لا تمتلك الصلاحيات الكافية للدخول إلى هذه الصفحة</c:set>
				</c:when>
				<c:when test="${httpStatusCode eq 403}">
						<c:set var="errorTitle">غير مصرح بالدخول</c:set>
						<c:set var="errorDescription">تحتاج إلى تسجيل الدخول بحساب ذو صلاحيات كافية أولاً لعرض هذه الصفحه</c:set>
				</c:when>
				<c:when test="${httpStatusCode eq 404}">
					<c:set var="errorTitle">لم يتم العثور على الصفحة</c:set>
					<c:set var="errorDescription">عذراً! الصفحه التى تبحث عنها غير موجوده, الرجاء التأكد من عنوان الصفحة</c:set>
				</c:when>
				<c:otherwise>
						<c:set var="errorTitle">خطأ فى عرض الصفحة</c:set>
						<c:set var="errorDescription">عذراً! حدث خطأ اثناء عرض الصفحة من فضلك حاول مجدداً</c:set>					
				</c:otherwise>
			</c:choose>
			
			<h2>${errorTitle}</h2>
			<p>${errorDescription}</p>
			<a href="../">عــودة</a>
		</div>
	</div>

</body>
<!-- This templates was made by Colorlib (https://colorlib.com) -->

</html>