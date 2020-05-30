<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="col-md-10 col-md-offset-1">
	<div class="row">
		<h1>积分兑换记录</h1>
	</div>
	<div class="row" align="right">
			<!-- 搜索框 -->
		<div class="row" align="right">
			<div class="col-md-5" style="padding:0px;">
				<form class="nav-form" action="search" method="get">
					<div class="input-group">
      					<input type="text" class="form-control" placeholder="搜索...">
      					<span class="input-group-btn">
       				 		<button class="btn btn-default" type="submit"><span class="glyphicon glyphicon-search"></span></button>
      					</span>
      					<select name="search-type" class="form-control" style="margin-left:20px;">
							<option value="1">按班级搜索</option>
							<option value="2">按学生姓名搜索</option>
							<option value="2">按专业搜索</option>
							<option value="2">按年级搜索</option>
							<option value="2">按学号搜索</option>
						</select>
    				</div>
				</form>
			</div>
		</div>
	</div>
	<div class="row">
		<table class="table table-striped table-hover">
		<thead>
			<tr><th>积分兑换编号</th><th>兑换规则</th><th>学生姓名</th><th>得分</th><th>消耗积分</th></tr>
		</thead>
		<tbody>
			
		</tbody>
		</table>
		
	</div>
</div>