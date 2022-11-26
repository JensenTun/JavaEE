package com.jensen.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jensen.dao.UserDaoImp;
import com.jensen.db.DBConnection;
import com.jensen.entity.User;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html");
		
		String fname = req.getParameter("fname");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String password = req.getParameter("password");
		
		try {
			UserDaoImp dao = new UserDaoImp(DBConnection.getconnection());
			User user = new User();
			user.setName(fname);
			user.setEmail(email);
			user.setPhone(phone);
			user.setPassword(password);
			
			if(!fname.isEmpty() && !email.isEmpty() && !password.isEmpty()) {
				dao.register(user);
				res.sendRedirect("index.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
