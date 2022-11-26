package com.jensen.adminservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jensen.dao.ProductDaoImp;
import com.jensen.db.DBConnection;
import com.jensen.entity.Product;

@WebServlet("/deleteProduct")
public class DeleteProduct extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html");
		
		int id = Integer.parseInt(req.getParameter("id"));
		
		try {
			
			ProductDaoImp dao = new ProductDaoImp(DBConnection.getconnection());
			boolean f = dao.deleteProduct(id);
			
			if(f) {
				res.sendRedirect("admin/home.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
