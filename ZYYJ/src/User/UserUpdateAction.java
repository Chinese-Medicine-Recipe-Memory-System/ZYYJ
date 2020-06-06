package User;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.MyTools;

/**
 * Servlet implementation class UserUpdateAction
 */
@WebServlet("/UserUpdateAction")
public class UserUpdateAction extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		UserDB userdb = new UserDB();
		UserInfo user = new UserInfo();
		user.setUser_id(request.getParameter("userid"));
		user.setPost_id(MyTools.toint(request.getParameter("userpost")));
		user.setName(request.getParameter("uesename"));
		user.setRealname(request.getParameter("realname"));
		user.setPassword(request.getParameter("userpassword"));
		user.setPhone(request.getParameter("phone"));
		user.setEmail(request.getParameter("email"));
		user.setGender(MyTools.toint(request.getParameter("gender")));
		user.setStatus(MyTools.toint(request.getParameter("gender")));
		
		userdb.updateUser(user);
		request.getSession().setAttribute("SingleUserInfoId",user.getUser_id());
		response.sendRedirect(request.getContextPath()+"/UserInfoAction");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
