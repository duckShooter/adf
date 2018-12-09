<%@page language="java" contentType="text/html;charset=UTF-8"
     pageEncoding="UTF-8"%>
<%@page import="java.util.Date" %>
<%@page import="adf.models.Admin,
 	javax.servlet.http.HttpServlet,
	java.util.HashMap, javax.servlet.http.Cookie" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@include file="includes/header.jsp" %>
<%@include file="includes/navbar.jsp" %>

<!-- page content -->
<div class="right_col" role="main">
    <!-- top tiles -->
    <div class="row tile_count">
        <div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
            <span class="count_top"><i class="fa fa-inbox"></i> عدد المكاتبات الواردة</span>
            <div class="count">2500</div>
        </div>
        <div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
            <span class="count_top"><i class="fa fa-inbox"></i> عدد المكاتبات الصادرة</span>
            <div class="count">2500</div>
        </div>
        <div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
            <span class="count_top"><i class="fa fa-inbox"></i> عدد المكاتبات المحفوظة</span>
            <div class="count">2500</div>
        </div>
        <div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
            <span class="count_top"><i class="fa fa-list-ul"></i> عدد الاقسام</span>
            <div class="count">2500</div>
        </div>
        <div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
            <span class="count_top"><i class="fa fa-users"></i> عدد  الضباط</span>
            <div class="count">2500</div>
        </div>
        <div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
            <span class="count_top"><i class="fa fa-book"></i> عدد الحافظات</span>
            <div class="count">2500</div>
        </div>
    </div>
    <!-- /top tiles -->
    <br>
    <!-- content home -->
    <div class="row">
        <div class="x_panel">
            <div class="x_title">
                <h2 style="text-align: center;">اخر 10 عمليات تمت على النظام بواسطة المستخدمين</h2>
                <ul class="nav navbar-right panel_toolbox">
                    <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
                    <li><a href="#" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a></li>
                    <li><a class="close-link"><i class="fa fa-close"></i></a></li>
                </ul>
                <div class="clearfix"></div>
            </div>

            <div class="x_content">
                <div class="col-md-6 col-sm-6 col-xs-12">
                    <div class="x_panel">
                        <div class="x_title">
                            <h2>
                                <small>اخر 10عمليات من المكاتبات الواردة</small>
                            </h2>
                            <ul class="nav navbar-right panel_toolbox">
                                <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
                                <li><a href="#" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a></li>
                                <li><a class="close-link"><i class="fa fa-close"></i></a></li>
                            </ul>
                            <div class="clearfix"></div>
                        </div>
                        <div class="x_content">

                            <table class="table">
                                <thead>
                                <tr>
                                    <th>م</th>
                                    <th>التاريخ</th>
                                    <th>الوحدة</th>
                                    <th>الموضوع</th>
                                    <th>حافظة الارشيف</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <th scope="row">1</th>
                                    <td>21-11-2018</td>
                                    <td>السكرتارية</td>
                                    <td>تمام الرئيس والنائب</td>
                                    <td>تمام الرؤساء</td>
                                </tr>
                                <tr>
                                    <th scope="row">2</th>
                                    <td>21-11-2018</td>
                                    <td>السكرتارية</td>
                                    <td>تمام الرئيس والنائب</td>
                                    <td>تمام الرؤساء</td>
                                </tr>
                                <tr>
                                    <th scope="row">3</th>
                                    <td>21-11-2018</td>
                                    <td>السكرتارية</td>
                                    <td>تمام الرئيس والنائب</td>
                                    <td>تمام الرؤساء</td>
                                </tr>
                                <tr>
                                    <th scope="row">4</th>
                                    <td>21-11-2018</td>
                                    <td>السكرتارية</td>
                                    <td>تمام الرئيس والنائب</td>
                                    <td>تمام الرؤساء</td>
                                </tr>
                                 <tr>
                                    <th scope="row">5</th>
                                    <td>21-11-2018</td>
                                    <td>السكرتارية</td>
                                    <td>تمام الرئيس والنائب</td>
                                    <td>تمام الرؤساء</td>
                                </tr>
                                 <tr>
                                    <th scope="row">6</th>
                                    <td>21-11-2018</td>
                                    <td>السكرتارية</td>
                                    <td>تمام الرئيس والنائب</td>
                                    <td>تمام الرؤساء</td>
                                </tr>
                                 <tr>
                                    <th scope="row">7</th>
                                    <td>21-11-2018</td>
                                    <td>السكرتارية</td>
                                    <td>تمام الرئيس والنائب</td>
                                    <td>تمام الرؤساء</td>
                                </tr>
                                 <tr>
                                    <th scope="row">8</th>
                                    <td>21-11-2018</td>
                                    <td>السكرتارية</td>
                                    <td>تمام الرئيس والنائب</td>
                                    <td>تمام الرؤساء</td>
                                </tr>
                                 <tr>
                                    <th scope="row">9</th>
                                    <td>21-11-2018</td>
                                    <td>السكرتارية</td>
                                    <td>تمام الرئيس والنائب</td>
                                    <td>تمام الرؤساء</td>
                                </tr>
                                 <tr>
                                    <th scope="row">10</th>
                                    <td>21-11-2018</td>
                                    <td>السكرتارية</td>
                                    <td>تمام الرئيس والنائب</td>
                                    <td>تمام الرؤساء</td>
                                </tr>
                                </tbody>
                            </table>

                        </div>
                    </div>
                </div>
                <div class="col-md-6 col-sm-6 col-xs-12">
                    <div class="x_panel">
                        <div class="x_title">
                            <h2>
                                <small>اخر 10عمليات من المكاتبات الصادرة</small>
                            </h2>
                            <ul class="nav navbar-right panel_toolbox">
                                <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
                                <li><a href="#" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a></li>
                                <li><a class="close-link"><i class="fa fa-close"></i></a></li>
                            </ul>
                            <div class="clearfix"></div>
                        </div>
                        <div class="x_content">

                            <table class="table table-striped">
                                <thead>
                                <tr>
                                    <th>م</th>
                                    <th>التاريخ</th>
                                    <th>الوحدة</th>
                                    <th>الموضوع</th>
                                    <th>حافظة الارشيف</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <th scope="row">1</th>
                                    <td>21-11-2018</td>
                                    <td>السكرتارية</td>
                                    <td>تمام الرئيس والنائب</td>
                                    <td>تمام الرؤساء</td>
                                </tr>
                                <tr>
                                    <th scope="row">2</th>
                                    <td>21-11-2018</td>
                                    <td>السكرتارية</td>
                                    <td>تمام الرئيس والنائب</td>
                                    <td>تمام الرؤساء</td>
                                </tr>
                                <tr>
                                    <th scope="row">3</th>
                                    <td>21-11-2018</td>
                                    <td>السكرتارية</td>
                                    <td>تمام الرئيس والنائب</td>
                                    <td>تمام الرؤساء</td>
                                </tr>
                                <tr>
                                    <th scope="row">4</th>
                                    <td>21-11-2018</td>
                                    <td>السكرتارية</td>
                                    <td>تمام الرئيس والنائب</td>
                                    <td>تمام الرؤساء</td>
                                </tr>
                                 <tr>
                                    <th scope="row">5</th>
                                    <td>21-11-2018</td>
                                    <td>السكرتارية</td>
                                    <td>تمام الرئيس والنائب</td>
                                    <td>تمام الرؤساء</td>
                                </tr>
                                 <tr>
                                    <th scope="row">6</th>
                                    <td>21-11-2018</td>
                                    <td>السكرتارية</td>
                                    <td>تمام الرئيس والنائب</td>
                                    <td>تمام الرؤساء</td>
                                </tr>
                                 <tr>
                                    <th scope="row">7</th>
                                    <td>21-11-2018</td>
                                    <td>السكرتارية</td>
                                    <td>تمام الرئيس والنائب</td>
                                    <td>تمام الرؤساء</td>
                                </tr>
                                 <tr>
                                    <th scope="row">8</th>
                                    <td>21-11-2018</td>
                                    <td>السكرتارية</td>
                                    <td>تمام الرئيس والنائب</td>
                                    <td>تمام الرؤساء</td>
                                </tr>
                                 <tr>
                                    <th scope="row">9</th>
                                    <td>21-11-2018</td>
                                    <td>السكرتارية</td>
                                    <td>تمام الرئيس والنائب</td>
                                    <td>تمام الرؤساء</td>
                                </tr>
                                 <tr>
                                    <th scope="row">10</th>
                                    <td>21-11-2018</td>
                                    <td>السكرتارية</td>
                                    <td>تمام الرئيس والنائب</td>
                                    <td>تمام الرؤساء</td>
                                </tr>
                                </tbody>
                            </table>

                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="clearfix"></div>
    </div>
    <!-- content home -->
</div>
<!-- /page content -->

<%@include file="includes/footer.jsp" %>