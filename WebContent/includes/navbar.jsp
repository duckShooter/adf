<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="adf.models.Admin,
				java.util.HashMap,
				adf.util.SessionControl" %>

<%--
request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8");

//Authorize the user, bad practice and will use filters later :-(
Cookie authCookie = SessionControl.acquireCookie("token", request);
if(authCookie == null)
	response.sendError(HttpServletResponse.SC_FORBIDDEN);
else {
	HttpSession currentSession = 
		((HashMap<String, HttpSession>)request.getServletContext().getAttribute("sessmgr")).get(authCookie.getValue());
		System.out.println("LOG: " + currentSession.getAttribute("admin")); //for test purpose
--%>

<body class="nav-md">
<div class="container body">
    <div class="main_container">
        <div class="col-md-3 left_col hidden-print">
            <div class="left_col scroll-view">
                <div class="navbar nav_title" style="border: 0;">
                    <a href="dashboard" class="site_title">منظومة الارشيف العام<span></span></a>
                </div>

                <div class="clearfix"></div>

                <!-- menu profile quick info -->
                <div class="profile clearfix">
                    <div class="profile_pic">
                        <img src="../vendors/images/user.png" alt="..." class="img-circle profile_img">
                    </div>
                    <div class="profile_info">
                    	<span></span>
<%--               			<span><%= (String)session.getAttribute("user") %></span> --%>
                        <span>Administrator</span>
                        <h2><%=((Admin)session.getAttribute("admin")).getFullname()%></h2>
                    </div>
                </div>
                <!-- /menu profile quick info -->

                <br/>

                <!-- sidebar menu -->
                <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
                    <div class="menu_section">
                        <ul class="nav side-menu">
                            <li><a href="dashboard"><i class="fa fa-home"></i>الصفحة الرئيسية</a></li>
                            <li><a href="departments"><i class="fa fa-list-ul"></i>ادارة الاقسام</a></li>
                            <li><a href="officers"><i class="fa fa-users"></i>ادارة  مستخدمين المنظومة</a></li>
                            <li><a href="folders"><i class="fa fa-book"></i>ادارة الحافظات</a></li>
                            <li><a href="users"><i class="fa fa-users"></i>الادارة</a></li>
                        </ul>
                    </div>
                </div>
                <!-- /sidebar menu -->

                <!-- /menu footer buttons -->
                <div class="sidebar-footer hidden-small">
                    <a data-toggle="tooltip" data-placement="top" title="اعدادات">
                        <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
                    </a>
                    <a data-toggle="tooltip" data-placement="top" title="تكبير" onclick="toggleFullScreen();">
                        <span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
                    </a>
                    <a data-toggle="tooltip" data-placement="top" title="قفل" class="lock_btn">
                        <span class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
                    </a>
                    <a data-toggle="tooltip" data-placement="top" title="خروج" href="login">
                        <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
                    </a>
                </div>
                <!-- /menu footer buttons -->
            </div>
        </div>

        <!-- top navigation -->
        <div class="top_nav hidden-print">
            <div class="nav_menu">
                <nav>
                    <div class="nav toggle">
                        <a id="menu_toggle"><i class="fa fa-bars"></i></a>
                    </div>

                    <ul class="nav navbar-nav navbar-right">
                    
                    	<!-- NOTE: DO ME (Giovanni) -->
						<!-- LOGOUT NOTE: Redirect to a servlet first to destroy current session and remove any cookies then redirect to login.jsp -->
                        <li><a href="login"><i class="fa fa-sign-out pull-right"></i>تسجيل الخروج</a></li>

                    </ul>
                </nav>
            </div>
        </div>
        <!-- /top navigation -->
        <!-- /header content -->
