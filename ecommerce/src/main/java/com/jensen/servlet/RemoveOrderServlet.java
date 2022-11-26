package com.jensen.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jensen.dao.CartDAOImp;
import com.jensen.db.DBConnection;

@WebServlet("/removeOrder")
public class RemoveOrderServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html");
		
		int pid = Integer.parseInt(req.getParameter("pid"));
		int uid = Integer.parseInt(req.getParameter("uid"));
		int cid = Integer.parseInt(req.getParameter("cid"));
		
		try {
			
			CartDAOImp dao = new CartDAOImp(DBConnection.getconnection());
			boolean f = dao.deleteProduct(pid, uid, cid);
			
			if(f) {
				res.sendRedirect("order.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
