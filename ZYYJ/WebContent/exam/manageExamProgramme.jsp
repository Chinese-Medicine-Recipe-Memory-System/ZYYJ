<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@ page import="com.zyyj.bean.ExamProgramme, java.util.List" %>
<%@ page import="com.zyyj.service.exam.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	ApplicationContext ac = new ClassPathXmlApplicationContext("springMVC.xml");
	ExamProgrammeService service = ac.getBean("examProgrammeServiceImpl", ExamProgrammeService.class);
	List<ExamProgramme> list = service.getAllExamProgrammes();
%>
<div class="col-md-10 col-md-offset-1">
	<div class="row">
		<h1>考试等级管理</h1>
	</div>
	
	<!-- 搜索框和添加按钮 -->
	<div class="row" align="right">
		<div class="col-md-5" style="padding:0px;">
			<form class="nav-form" action="search" method="get">
				<div class="input-group">
      				<input type="text" class="form-control" placeholder="搜索...">
      				<span class="input-group-btn">
       				 	<button class="btn btn-default" type="submit"><span class="glyphicon glyphicon-search"></span></button>
      				</span>
    			</div>
			</form>
		</div>
		<div class="col-md-7" align="right">
			<button class="btn btn-info" data-toggle="modal" data-target="#add-modal">添加新考试等级</button>
		</div>
	</div>
	<div class="row">
		<table class="table table-striped table-hover">
		<thead>
			<tr><th>考试等级编号</th><th>考试等级名</th><th>总题目数</th><th>总分</th><th>通过分数</th><th>各种难度题目数</th><th>答题时长（分钟）</th><th>创建日期</th></tr>
		</thead>
		<tbody>
			<%
			for(ExamProgramme e : list){%>
				<tr><td><%=e.getExam_id() %></td><td><%=e.getName() %></td><td><%=e.getTotal_question() %></td><td><%=e.getTotal_score() %></td>
				<td><%=e.getPass_score() %></td><td><%=e.getQuestion_num() %></td><td><%=e.getLimit_time() %></td><td><%=e.getCreatedate() %></td>
				<td><a href="#" data-toggle="modal" data-target="#modify-modal"><span class="glyphicon glyphicon-pencil"> 修改</span></a></td>
				<td><a href="deleteExamProgramme?exam_id=<%=e.getExam_id()%>"><span class="glyphicon glyphicon-trash"> 删除</span></a></td></tr>
			<%}
			%>
		</tbody>
		</table>
	</div>
</div>


<!-- 弹出框，添加 -->
<div class="modal fade" id="add-modal" tabindex="-1" role="dialog">
  	<div class="modal-dialog modal-md" role="document">
    	<div class="modal-content">
      		<div class="modal-header">
      			<h4 class="modal-title">添加新考试等级</h4>
      		</div>
      		<div class="modal-body">
      			<form class="form-signin" action="addExamProgramme" method="post">
					<input class="form-control" type="text" name="name" placeholder="考试方案名">
					<input class="form-control" type="text" name="total_question" placeholder="题目总数">
					<input class="form-control" type="text" name="total_score" placeholder="总分">
					<input class="form-control" type="text" name="pass_score" placeholder="通过分数">
					<input class="form-control" type="text" name="question_num" placeholder="各种难度题目数（;隔开）">
					<input class="form-control" type="text" name="limit_time" placeholder="答题时长（分钟）">
					<button class="btn btn-primary btn-block" type="submit">添加</button>
				</form>
      		</div>
      			
      		<div class="modal-footer" align="center">
      			<a href="#" data-dismiss="modal">取消</a>
      		</div>
    	</div>
  	</div>
  	<style>
  	.form-control{margin-bottom:20px;}
  	</style>
</div>

<!-- 弹出框，修改 -->
<div class="modal fade" id="modify-modal" tabindex="-1" role="dialog">
  	<div class="modal-dialog modal-md" role="document">
    	<div class="modal-content">
      		<div class="modal-header">
      			<h4 class="modal-title">修改考试等级信息</h4>
      		</div>
      		<div class="modal-body">
      			<form class="form-signin" action="updateExamProgramme" method="post">
      				<input class="form-control" type="text" name="exam_id" id="update_id" readonly>
					<input class="form-control" type="text" name="name" placeholder="考试方案名">
					<input class="form-control" type="text" name="total_question" placeholder="题目总数">
					<input class="form-control" type="text" name="total_score" placeholder="总分">
					<input class="form-control" type="text" name="pass_score" placeholder="通过分数">
					<input class="form-control" type="text" name="question_num" placeholder="各种难度题目数（;隔开）">
					<input class="form-control" type="text" name="limit_time" placeholder="答题时长（分钟）">
					<button class="btn btn-primary btn-block" type="submit">修改</button>
				</form>
      		</div>
      			
      		<div class="modal-footer" align="center">
      			<a href="#" data-dismiss="modal">取消</a>
      		</div>
    	</div>
  	</div>
  	<style>
  	.form-control{margin-bottom:20px;}
  	</style>
</div>