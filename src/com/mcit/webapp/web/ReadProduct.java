package com.mcit.webapp.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mcit.webapp.entity.EProduct;
import com.mcit.webapp.util.HibernateSessionUtil;

/**
 * Servlet implementation class ReadProduct
 */
@WebServlet("/read-product")
public class ReadProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ReadProduct() {}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("index.html").include(request, response);
		
		try {
			// 1. load session factory
			SessionFactory factory = HibernateSessionUtil.buildSessionFactory();
			// 2. create a session
			Session session = factory.openSession();
			// read products
			List<EProduct> products = session.createQuery("from EProduct").list();
		
			//show data as table
			out.print("<h1> Product List :- </h1>");
			out.print("<style> table,td,th {"
					+ "border:2px solid red;"
					+ "padding: 10px; "
					+ "}</style>");
				out.print("<table >");
				out.print("<tr>");
				out.print("<th> Product Id</th>");
				out.print("<th> Product Name</th>");
				out.print("<th> Product Price</th>");
				out.print("<th> CreateAt </th>");
				out.print("<th> Modified </th>");
				out.print("</tr>");
			for(EProduct p: products) {
				out.print("<tr>");
				out.print("<td>"+p.getId()+"</td>");
				out.print("<td>"+p.getName()+"</td>");
				out.print("<td>"+p.getPrice()+"</td>");
				out.print("<td>"+p.getModifiedAt()+"</td>");
				out.print("<td>"+p.getModifiedAt()+"</td>");
				out.print("</tr>");
			}
			out.print("</table>");
			// 3. close session
			session.close();
		} catch (Exception e) {
			out.print("<h3 style='color:red'>Read Products failed ! <h3>" + e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
