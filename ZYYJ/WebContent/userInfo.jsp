<%@page import="common.MyTools"%>
<%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
<%@ page import="User.*"  %>

<%
	String userid = (String)session.getAttribute("SingleUserInfoId");
	UserInfo user = new UserDB().GetUserbyId(userid);
	String post = "";
	String gender = "";
	if (user.getPost_id() == 1)
	{
		post = "����Ա";
	}
	else if (user.getPost_id() == 2)
	{
		post = "��ʦ";
	}
	
	if (user.getGender() == 1)
	{
		gender = "Ů";
	}
	else if (user.getGender() == 2)
	{
		gender = "��";
	}
%>
<div class="col-md-8 col-md-offset-2">
	<div class="row">
		<h1>�û�����</h1>
		<div class="col-md-2" align="center">
			<img class="img-circle" src="image/user.png" alt="�û�ͷ��" width="100px" height="100px"><br>
			<a href="#" data-toggle="modal" data-target="#upload-modal">�޸�ͷ��</a>
		</div>
		<div class="col-md-10">
			<ul>
			<li>�û�ID: <%=user.getUser_id() %></li>
			<li>��ɫ: <%=post %></li>
			<li>�û�����<%=user.getName() %></li>
			</ul>
		</div>
	</div>
	
	<div class="row" align="right">
		<a href="#" data-toggle="modal" data-target="#changepassword-modal">�޸�����</a>
		<a href="#" data-toggle="modal" data-target="#modify-modal">�޸ĸ�����Ϣ</a>
	</div>
	
	<div class="row">
		<table class="table table-striped table-hover">
		<tbody>
			<tr><td>��ʵ����</td><td><%=user.getRealname() %></td></tr>
			<tr><td>�Ա�</td><td><%=gender %></td></tr>
			<tr><td>�绰</td><td><%=user.getPhone() %></td></tr>
			<tr><td>����</td><td><%=user.getEmail() %></td></tr>
		</tbody>
		</table>
	</div>
</div>


<!-- �������ϴ�ͷ�� -->
<div class="modal fade" id="upload-modal" tabindex="-1" role="dialog">
  	<div class="modal-dialog modal-md" role="document">
    	<div class="modal-content">
      		<div class="modal-header">
      			<h4 class="modal-title">�ϴ�ͷ��</h4>
      		</div>
      		<div class="modal-body">
      			<form class="form-signin" action="/servlet/upload" method="get">
					<input type="file" name="file">
					<button class="btn btn-primary" type="submit">�ϴ�</button>
				</form>
      		</div>
      			
      		<div class="modal-footer" align="center">
      			<a href="#" data-dismiss="modal">ȡ��</a>
      		</div>
    	</div>
  	</div>
</div>


<!-- �������޸� ������Ϣ-->
<div class="modal fade" id="changepassword-modal" tabindex="-1" role="dialog">
  	<div class="modal-dialog modal-md" role="document">
    	<div class="modal-content">
      		<div class="modal-header">
      			<h4 class="modal-title">�޸�����</h4>
      		</div>
      		<div class="modal-body">
      			<form class="form-signin" action="/servlet/changePassword" method="get">
					<input class="form-control" type="password" name="oldPassword" placeholder="ԭ����">
					<input class="form-control" type="password" name="newPassword" placeholder="������">
					<button class="btn btn-primary btn-block" type="submit">�޸�</button>
				</form>
      		</div>
      			
      		<div class="modal-footer" align="center">
      			<a href="#" data-dismiss="modal">ȡ��</a>
      		</div>
    	</div>
  	</div>
  	<style>
  	.form-control{margin-bottom:20px;}
  	</style>
</div>
<!-- �������޸� ������Ϣ-->
<div class="modal fade" id="modify-modal" tabindex="-1" role="dialog">
  	<div class="modal-dialog modal-md" role="document">
    	<div class="modal-content">
      		<div class="modal-header">
      			<h4 class="modal-title">�޸ĸ�����Ϣ</h4>
      		</div>
      		<div class="modal-body">
      			<form class="form-signin" action="<%=request.getContextPath()%>/UserUpdateAction" method="get">
      				<input class="form-control" type="hidden" name="userid" placeholder="�û�ID" value="<%=user.getUser_id() %>">
      				<input class="form-control" type="hidden" name="userpost" placeholder="�û����" value="<%=user.getPost_id() %>">
      				<input class="form-control" type="hidden" name="userpassword" placeholder="����" value="<%=user.getPassword()%>">
					<input class="form-control" type="text" name="uesename" placeholder="�û���" value="<%=user.getName() %>">
					<input class="form-control" type="text" name="realname" placeholder="��ʵ����" value="<%=user.getRealname() %>">
					<input class="form-control" type="text" name="gender" placeholder="�Ա�" value="<%=user.getGender() == 1?"Ů":"��" %>">
					<!-- <input class="form-control" type="text" name="department" placeholder="����">
					<select name="department" class="form-control">
									<option value="1">��ѧ��</option>
									<option value="2">����</option>							
								</select> -->
					<input class="form-control" type="text" name="phone" placeholder="�绰" value="<%=user.getPhone() %>">
					<input class="form-control" type="text" name="email" placeholder="����" value="<%=user.getEmail() %>">
					<input class="form-control" type="" name="status" placeholder="״̬" value="<%=user.getStatus() %>">
					<button class="btn btn-primary btn-block" type="submit">�޸�</button>
				</form>
      		</div>
      			
      		<div class="modal-footer" align="center">
      			<a href="#" data-dismiss="modal">ȡ��</a>
      		</div>
    	</div>
  	</div>
  	<style>
  	.form-control{margin-bottom:20px;}
  	</style>
</div>
