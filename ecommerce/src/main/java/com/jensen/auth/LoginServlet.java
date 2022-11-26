package com.jensen.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jensen.dao.UserDaoImp;
import com.jensen.db.DBConnection;
import com.jensen.entity.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html");
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		try {
			
			UserDaoImp dao = new UserDaoImp(DBConnection.getconnection());
			HttpSession session = req.getSession();
			User user = null;
			
			if("admin@gmail.com".equals(email) && "admin123".equals(password)) {
				user = new User();
				user.setName("admin");
				session.setAttribute("userobj", user);
				res.sendRedirect("admin/home.jsp");
			}else {
				user = dao.login(email, password);
				if(user != null) {
					session.setAttribute("userobj", user);
					res.sendRedirect("index.jsp");
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
