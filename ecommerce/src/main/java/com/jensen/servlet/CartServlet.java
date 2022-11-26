package com.jensen.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jensen.dao.CartDAOImp;
import com.jensen.dao.ProductDaoImp;
import com.jensen.db.DBConnection;
import com.jensen.entity.Cart;
import com.jensen.entity.Product;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		int pid = Integer.parseInt(req.getParameter("pid"));
		int uid = Integer.parseInt(req.getParameter("uid"));
		
		
		try {
			
			ProductDaoImp dao = new ProductDaoImp(DBConnection.getconnection());
			
			Product product = dao.getProductById(pid);
			
			Cart cart = new Cart();
			cart.setPid(pid);
			cart.setUserId(uid);
			cart.setProductName(product.getName());
			cart.setPrice(Double.parseDouble(product.getPrice()));
			cart.setTotalPrice(Double.parseDouble(product.getPrice()));
			
			
			CartDAOImp dao2 = new CartDAOImp(DBConnection.getconnection());
			
			boolean f = dao2.add(cart);
			
			if(f) {
				res.sendRedirect("index.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
