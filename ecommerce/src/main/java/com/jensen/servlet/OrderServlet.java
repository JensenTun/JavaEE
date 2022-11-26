package com.jensen.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jensen.dao.CartDAOImp;
import com.jensen.dao.OrderDaoImp;
import com.jensen.db.DBConnection;
import com.jensen.entity.Cart;
import com.jensen.entity.Order;

@WebServlet("/orderProduct")
public class OrderServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		res.setContentType("text/html");
		
		int id = Integer.parseInt(req.getParameter("id"));
		
		String name = req.getParameter("username");
		String email = req.getParameter("useremail");
		String phnoe = req.getParameter("userphone");
		String address = req.getParameter("useraddress");
		String city = req.getParameter("usercity");
		String state = req.getParameter("usersate");
		
		String fullAddress = address + " , " + city + " , " + state;
		HttpSession session = req.getSession();
		
		
		try {
			
			CartDAOImp dao = new CartDAOImp(DBConnection.getconnection());
			List<Cart> list = dao.getProductByUser(id);
			
			if(list.isEmpty()) {
				res.sendRedirect("");
			}else {
				OrderDaoImp dao2 = new OrderDaoImp(DBConnection.getconnection());
				Order order = null;
				
				ArrayList<Order> orderList = new ArrayList<Order>();
				Random r = new Random();
				
				for(Cart c : list) {
					order = new Order();
					order.setOrderId("ORDER-ORD-00"+r.nextInt(1000));
					order.setUserName(name);
					order.setEmail(email);
					order.setPhnoe(phnoe);
					order.setFulladd(fullAddress);
					order.setProductname(c.getProductName());
					order.setPrice(c.getPrice()+"");
					
					orderList.add(order);
					
					boolean f = dao2.saveOrder(orderList);
					
					if(f) {
						session.setAttribute("succMsg", "your order was success...");
						res.sendRedirect("index.jsp");
					}else {
						session.setAttribute("failedMsg", "your order was failed...");
						res.sendRedirect("index.jsp");
					}
				}
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
