package com.jensen.adminservlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.jensen.dao.ProductDaoImp;
import com.jensen.db.DBConnection;
import com.jensen.entity.Product;

@MultipartConfig
@WebServlet("/addProduct")
public class AddProduct extends HttpServlet {
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		
		String name = req.getParameter("name");
		String price = req.getParameter("price");
		String desc = req.getParameter("desc");
		Part file = req.getPart("img");
		
		String imgFileName = file.getSubmittedFileName();
		
//		Product product = new Product(name, price, desc, imgFileName);
//		
//		System.out.println(product);
		
		try {
			
			Product product = new Product(name, price, desc, imgFileName);
			ProductDaoImp dao = new ProductDaoImp(DBConnection.getconnection());
			boolean f = dao.addProduct(product);
			
			if(f) {
				String uploadPath = "C:/myfinalapp/myapp/src/main/webapp/image/";
				System.out.println("image file name : " + uploadPath);
				file.write(uploadPath + File.separator + imgFileName);
				
				res.sendRedirect("admin/add_product.jsp");
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
