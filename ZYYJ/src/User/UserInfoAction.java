package User;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserInfoAction")
public class UserInfoAction extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		String userid = (String)request.getSession().getAttribute("SingleUserInfoId");
		UserInfo user = new UserDB().GetUserbyId(userid);
		request.getSession().setAttribute("user", user);
		PrintWriter out = response.getWriter();
		out.println("<script>window.location='login/admin.jsp;</script>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
