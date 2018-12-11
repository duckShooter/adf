<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="adf.db.DatabaseConnection"%>
<%@page import="java.sql.Connection"%>
<%@page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="adf.util.SessionControl" %>

<%@include file="../includes/header.jsp"%>
<%@include file="../includes/navbar.jsp"%>

<!-- page content -->
<div class="right_col" role="main">
    <div class="">
        <div class="page-title">
            <div class="title_left">
                <h3>ادارة المستخدمين / اضافة مستخدم جديد</h3>
            </div>

            <div class="title_right">
                <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
                    <div class="input-group">
                        <input type="text" class="form-control" placeholder="بحث ...">
                        <span class="input-group-btn">
                              <button class="btn btn-default" type="button">اذهب </button>
                          </span>
                    </div>
                </div>
            </div>
        </div>
        <div class="clearfix"></div>

        <div class="row">
            <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                    <div class="x_title">
                        <h2>اضافة مستخدم جديد</h2>
                        <ul class="nav navbar-right panel_toolbox">
                            <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
                            <li><a href="#" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a></li>
                            <li><a class="close-link"><i class="fa fa-close"></i></a></li>
                        </ul>
                        <div class="clearfix"></div>
                    </div>
                    <div class="x_content">

                        <form class="form-horizontal form-label-left" action="add?action=doAddUser" method="post">
						<div class="item form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">درجة / رتبة : <span
                                        class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                   <select id="name" class="form-control col-md-7 col-xs-12" name="rank" required="required" style="padding: 0 15px;">
										<option value="جندى">جندى</option>
										<option value="عريف">عريف</option>
										<option value="رقيب">رقيب</option>
										<option value="رقيب اول">رقيب اول</option>
										<option value="مساعد">مساعد</option>
										<option value="مساعد اول">مساعد اول</option>
										<option value="ملازم">ملازم</option>
										<option value="ملازم اول">ملازم اول</option>
										<option value="نقيب">نقيب</option>
										<option value="رائد">رائد</option>
										<option value="مقدم">مقدم</option>
										<option value="عقيد">عقيد</option>
										<option value="عميد">عميد</option>
										<option value="لواء">لواء</option>
										<option value="فريق">فريق</option>
                                   </select>
                                </div>
                            </div>
                            <div class="item form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">الاسم بالكامل : <span
                                        class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <input id="name" class="form-control col-md-7 col-xs-12"
                                           data-validate-length-range="6" data-validate-words="2" name="fullname"
                                           placeholder="اسم الاسم بالكامل" required="required" type="text">
                                </div>
                            </div>
                            <div class="item form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">اسم المستخدم : <span
                                        class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <input id="name" class="form-control col-md-7 col-xs-12"
                                           data-validate-length-range="6" data-validate-words="2" name="username"
                                           placeholder="اسم المستخدم" required="required" type="text">
                                </div>
                            </div>
                            <div class="item form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">كلمة المرور : <span
                                        class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <input id="name" class="form-control col-md-7 col-xs-12"
                                           data-validate-length-range="6" data-validate-words="2" name="password"
                                           placeholder="كلمة المرور" required="required" type="password">
                                </div>
                            </div>
                            <div class="ln_solid"></div>
                            <div class="form-group">
                                <div class="col-md-6 col-md-offset-3">
                                    <button id="send" type="submit" class="btn btn-success">ارسال</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- /page content -->

<%@include file="../includes/footer.jsp"%>