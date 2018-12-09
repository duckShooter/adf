<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="adf.db.DatabaseConnection"%>
<%@page import="java.sql.Connection"%>
<%@page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@page import="adf.util.SessionControl" %>

<%@include file="includes/header.jsp"%>
<%@include file="includes/navbar.jsp"%>

<!-- page content -->
<div class="right_col" role="main">
   	<div class="">
	    <!-- top tiles -->
	    <div class="page-title">
	        <div class="title_left">
	            <h3>عرض جميع المستخدمين لادارة منظومة الارشيف العام</h3>
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
	    <!-- top tiles -->
	    <div class="row">
	    	<div class="col-md-12 col-sm-12 col-xs-12">
	        	<div class="x_panel">
	                            <div class="x_title">
	                                <h2>جميع المستخدمين لادارة منظومة الارشيف العام</h2>
	                                <ul class="nav navbar-right panel_toolbox">
	                                    <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
	                                    <li><a href="#" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a></li>
	                                    <li><a class="close-link"><i class="fa fa-close"></i></a></li>
	                                </ul>
	                                <div class="clearfix"></div>
	                            </div>
	                            <div class="x_content">
	                                <br>
	                                <p class="text-muted font-13 m-b-30"><a href="add-user" class="btn btn-success">اضافة مستخدم جديد</a></p>
	                                <br>
	                                <table id="datatable-buttons" class="table table-striped table-bordered text-center">
	                                    <thead class="text-center">
	                                    <tr>
	                                        <th class="text-center">م</th>
	                                        <th class="text-center">رتبة</th>
	                                        <th class="text-center">الاسم بالكامل</th>
	                                        <th class="text-center">اسم المستخدم</th>
	                                        <th class="text-center">ادارة</th>
	                                    </tr>
	                                    </thead>
	
	
	                                    <tbody>
	                                    <%
			                        	String adminQueryAll = "select * from Test.admin order by id";
			                        	
			                        	Connection con = DatabaseConnection.getActiveConnection();
			                        	PreparedStatement stmt = con.prepareStatement(adminQueryAll);
			                        	ResultSet resultSet = stmt.executeQuery();
			                        	
			                        	for(int count=1; resultSet.next(); count++) {
			                        		
			                            %>
	                                    <tr>
	                                        <td><%= count %></td>
	                                        <td><%= resultSet.getString(9) %></td>
	                                        <td><%= resultSet.getString(4) %></td>
	                                        <td><%= resultSet.getString(2) %></td>
	                                        <td>
	                                            <a href="delete?action=doDeleteUser&id=<%= resultSet.getInt(1)%>" title="حذف" class="btn btn-danger">حذف</a>
	                                        </td>
	                                    </tr>
	                                    <%
			                        	}
	                                    %>
	                                    </tbody>
	                                </table>
	                            </div>
	                        </div>
	        </div>
	    </div>
	    <!-- /top tiles -->
    </div>
</div>
<!-- /page content -->
</div>
<!-- /page content -->
<%@include file="includes/footer.jsp"%>