package com.dbtest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestDbServlet() 
	{
	}

	/**;
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//setuo connection variables

		String user="root";
		String pass="root";

		//get connection to database

		String jdbcUrl="jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
		//String driver="com.mysql.jdbc.Driver";

		//get Connection to database

		try 
		{
			PrintWriter out=response.getWriter();

			out.println("Connecting to database"+jdbcUrl);

			//Class.forName(driver);

			Connection con=DriverManager.getConnection(jdbcUrl, user, pass);

			out.println("connection successfull");
			System.out.println("done");

			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new ServletException(e);
		}
	}



}
